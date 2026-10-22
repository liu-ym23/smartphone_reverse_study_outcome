package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.ad.applinksdk.model.BizLineType;
import com.ss.android.download.api.config.AbsDownloadStatusChangeListener;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.download.api.runtime.IAdDownloadActionProvider;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.download.api.settings.TTDownloadSettingsAdapter;
import com.ss.android.download.api.settings.TTDownloadSettingsModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadad.api.download.AppPkgInfo;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.compliance.AdComplianceChecker;
import com.ss.android.downloadlib.addownload.compliance.AdLpComplianceManager;
import com.ss.android.downloadlib.addownload.dialog.IDeleteBtnListener;
import com.ss.android.downloadlib.addownload.interceptor.AppDownloadInterceptor;
import com.ss.android.downloadlib.addownload.interceptor.AppInstallInterceptor;
import com.ss.android.downloadlib.addownload.interceptor.AppMarketInterceptor;
import com.ss.android.downloadlib.addownload.interceptor.AppQuickInterceptor;
import com.ss.android.downloadlib.addownload.interceptor.DownloadChainInfo;
import com.ss.android.downloadlib.addownload.interceptor.TTDownloadInterceptorChain;
import com.ss.android.downloadlib.addownload.model.DownloadInstallInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.addownload.model.PackageManagerChecker;
import com.ss.android.downloadlib.addownload.model.SharedPrefsManager;
import com.ss.android.downloadlib.addownload.pause.CancelPauseInterceptorManager;
import com.ss.android.downloadlib.addownload.pause.PauseInterceptorManager;
import com.ss.android.downloadlib.applink.AdAppLinkManager;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.downloader.NotificationPusher;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.AsyncTaskUtils;
import com.ss.android.downloadlib.utils.Chain;
import com.ss.android.downloadlib.utils.DirUtils;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.downloadlib.utils.WeakHandler;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class CommonDownloadHandler implements DownloadHandler, WeakHandler.IHandler {
    private static final int EMPTY_LISTENER_TOKEN = Integer.MIN_VALUE;
    private static final String TAG = null;
    private CleanSpaceHelper mCleanHelper;
    private WeakReference<Context> mContextRef;
    private DownloadModel mCurrentDownloadModel;
    long mCurrentId;
    private SoftReference<IDownloadButtonClickListener> mDownloadButtonClickListener;
    private DownloadController mDownloadController;
    private DownloadEventConfig mDownloadEventConfig;
    DownloadInfo mDownloadInfo;
    private final WeakHandler mDownloadInfoChangeHandler;
    private final IDownloadListener mDownloadListener;
    private String mHandlerTaskKey;
    DownloadHelper mHelper;
    private QueryDownloadInfoTaskWithNewDownloader mInfoTaskWithNewDownloader;
    private boolean mIsBind;
    boolean mIsNormalScene;
    private SoftReference<OnItemClickListener> mItemClickListener;
    private long mLastWorkTime;
    private final Map<Integer, Object> mStatusChangeListenerMap;
    private DownloadShortInfo mTempDownloadShortInfo;

    public class BindDownloadInfo {
        private DownloadInfo mDownloadInfo;
        private DownloadInstallInfo mDownloadInstallInfo;
        final /* synthetic */ CommonDownloadHandler this$0;

        public DownloadInfo getDownloadInfo() {
            return this.mDownloadInfo;
        }

        public DownloadInstallInfo getDownloadInstallInfo() {
            return this.mDownloadInstallInfo;
        }

        public BindDownloadInfo(CommonDownloadHandler r100, DownloadInfo r101, DownloadInstallInfo r102) {
            this.this$0 = r100;
            this.mDownloadInfo = r101;
            this.mDownloadInstallInfo = r102;
        }
    }

    public interface DownloadInvoker {
        void invoke();
    }

    public interface IFetchApkSizeListener {
        void onFetchEnd(long r100);
    }

    public class QueryDownloadInfoTaskWithNewDownloader extends PthreadAsyncTask<String, Void, BindDownloadInfo> {
        final /* synthetic */ CommonDownloadHandler this$0;

        private QueryDownloadInfoTaskWithNewDownloader(CommonDownloadHandler r100) {
            this.this$0 = r100;
        }

        public BindDownloadInfo doInBackground(String... r100) {
            String r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r100.length < 1) goto L10;
            if (TextUtils.isEmpty(r100[0]) == false) goto L10;
            return null;
        L10:
            if (r100.length >= 3) goto L12;
        L14:
            String r102 = "";
        L15:
            String r103 = r100[0];
            if (TextUtils.isEmpty(CommonDownloadHandler.access$100(this.this$0).getFilePath()) == false) goto L18;
            DownloadInfo r104 = null;
        L24:
            NativeDownloadModel r105 = ModelManager.getInstance().getNativeDownloadModel(CommonDownloadHandler.access$100(this.this$0).getId());
            if (r105 == null) goto L27;
            r101 = r105.getFilePath();
        L27:
            if (r104 != null) goto L47;
            String r106 = DownloadTaskKeyManager.getInstance().getTaskKeyByUrl(r103);
            if (TextUtils.isEmpty(r106) == true) goto L41;
            if (TextUtils.isEmpty(r101) == true) goto L33;
            DownloadInfo r107 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r103, r101);
        L34:
            if (r107 == null) goto L36;
            r104 = r107;
            goto L47
        L36:
            if (TextUtils.isEmpty(r101) == true) goto L38;
            r104 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r106, r101);
            goto L47
        L38:
            r104 = AppDownloader.getInstance().getAppDownloadInfo(GlobalInfo.getContext(), r106);
            goto L47
        L33:
            r107 = AppDownloader.getInstance().getAppDownloadInfo(GlobalInfo.getContext(), r103);
            goto L34
        L41:
            if (TextUtils.isEmpty(r102) == false) goto L43;
            r104 = AppDownloader.getInstance().getAppDownloadInfo(GlobalInfo.getContext(), r103);
            goto L47
        L43:
            if (TextUtils.isEmpty(r101) == true) goto L45;
            r104 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r102, r101);
            goto L47
        L45:
            r104 = AppDownloader.getInstance().getAppDownloadInfo(GlobalInfo.getContext(), r102);
        L47:
            if (r105 == null) goto L55;
            if (r105.isManualPaused() == true) goto L55;
            if (r104 == null) goto L55;
            if (r104.getStatus() != (-2)) goto L55;
            TTDownloaderLogger.INSTANCE.innerLogD(CommonDownloadHandler.access$000(), "doInBackground", "---开始检测非主观暂停行为，包名为：" + CommonDownloadHandler.access$100(this.this$0).getPackageName() + " ，当前时间为：" + System.currentTimeMillis());
            DownloadRetainHelper.getInstance().delayNotifyResumeDownload(CommonDownloadHandler.access$100(this.this$0), r104, false);
        L55:
            return new BindDownloadInfo(this.this$0, r104, ToolUtils.getInstalledAppInfo(CommonDownloadHandler.access$100(this.this$0).getPackageName(), CommonDownloadHandler.access$100(this.this$0).getVersionCode(), CommonDownloadHandler.access$100(this.this$0).getVersionName()));
        L18:
            if (CommonDownloadHandler.access$100(this.this$0) != null) goto L20;
        L22:
            r104 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r103, CommonDownloadHandler.access$100(this.this$0).getFilePath());
            goto L24
        L20:
            if (TextUtils.isEmpty(r102) == true) goto L22;
            r104 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(Downloader.getInstance(GlobalInfo.getContext()).getDownloadId(r102, CommonDownloadHandler.access$100(this.this$0).getFilePath()));
            goto L24
        L12:
            if (TextUtils.isEmpty(r100[2]) == true) goto L14;
            r102 = r100[2];
            goto L15
        }

        public void onPostExecute(BindDownloadInfo r100) {
            super.onPostExecute(r100);
            if (isCancelled() == false) goto L5;
            return;
        L5:
            if (CommonDownloadHandler.access$100(this.this$0) != null) goto L8;
            return;
        L8:
            if (r100 != null) goto L53;
            DownloadInstallInfo r101 = null;
            DownloadInfo r102 = null;
        L13:
            if (r101 == null) goto L16;
            PackageManagerChecker.getInstance().checkVersionCode(CommonDownloadHandler.access$100(this.this$0).getVersionCode(), r101.getVersionCode(), ModelManager.getInstance().getNativeModelByInfo(r102));     // Catch: Exception -> L10
        L16:
            if (r101 != null) goto L18;
        L20:
            boolean r103 = false;
        L21:
            if (r102 != null) goto L23;
        L34:
            if (r102 == null) goto L39;
            if (Downloader.getInstance(GlobalInfo.getContext()).isDownloadSuccessAndFileNotExist(r102) == false) goto L39;
            DownloadNotificationManager.getInstance().cancelNotification(r102.getId());     // Catch: Exception -> L10
            this.this$0.mDownloadInfo = null;     // Catch: Exception -> L10
        L39:
            if (this.this$0.mDownloadInfo == null) goto L42;
            Downloader.getInstance(GlobalInfo.getContext()).removeTaskMainListener(this.this$0.mDownloadInfo.getId());     // Catch: Exception -> L10
            Downloader.getInstance(this.this$0.getContext()).setMainThreadListener(this.this$0.mDownloadInfo.getId(), CommonDownloadHandler.access$1100(this.this$0), false);     // Catch: Exception -> L10
        L42:
            if (r103 == false) goto L44;
            TTDownloaderLogger.INSTANCE.innerLogD(CommonDownloadHandler.access$000(), "QueryDownloadInfoTaskWithNewDownloader", "异步查询下载model，显示立即打开");     // Catch: Exception -> L10
            CommonDownloadHandler r104 = this.this$0;     // Catch: Exception -> L10
            r104.mDownloadInfo = new DownloadInfo.Builder(CommonDownloadHandler.access$100(r104).getDownloadUrl()).build();     // Catch: Exception -> L10
            this.this$0.mDownloadInfo.setStatus(-3);     // Catch: Exception -> L10
            CommonDownloadHandler r105 = this.this$0;     // Catch: Exception -> L10
            r105.mHelper.refreshUIFromDownloadInfo(r105.mDownloadInfo, CommonDownloadHandler.access$400(r105), DownloadHelper.getDownloadListeners(DownloadStatusChangeListener.class, CommonDownloadHandler.access$300(this.this$0)), r103);     // Catch: Exception -> L10
        L49:
            CommonDownloadHandler r106 = this.this$0;     // Catch: Exception -> L10
            r106.mHelper.sendEventIfRecommend(r106.mDownloadInfo);     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            e.printStackTrace();
            return;
        L44:
            Iterator r107 = DownloadHelper.getDownloadListeners(DownloadStatusChangeListener.class, CommonDownloadHandler.access$300(this.this$0)).iterator();     // Catch: Exception -> L10
        L46:
            if (r107.hasNext() == false) goto L48;
            DownloadStatusChangeListener r108 = (DownloadStatusChangeListener) r107.next();     // Catch: Exception -> L10
            TTDownloaderLogger.INSTANCE.innerLogD(CommonDownloadHandler.access$000(), "QueryDownloadInfoTaskWithNewDownloader", "异步查询下载model，应用未安装，下载器空闲");     // Catch: Exception -> L10
            r108.onIdle();     // Catch: Exception -> L10
            goto L46
        L48:
            this.this$0.mDownloadInfo = null;     // Catch: Exception -> L10
            goto L49
        L23:
            if (r102.getId() == 0) goto L34;
            if (r103 == false) goto L26;
        L27:
            Downloader.getInstance(GlobalInfo.getContext()).removeTaskMainListener(r102.getId());     // Catch: Exception -> L10
            DownloadInfo r109 = this.this$0.mDownloadInfo;     // Catch: Exception -> L10
            if (r109 != null) goto L30;
        L32:
            this.this$0.mDownloadInfo = r102;     // Catch: Exception -> L10
            Downloader.getInstance(GlobalInfo.getContext()).setMainThreadListener(this.this$0.mDownloadInfo.getId(), CommonDownloadHandler.access$1100(this.this$0), false);     // Catch: Exception -> L10
        L33:
            CommonDownloadHandler r110 = this.this$0;     // Catch: Exception -> L10
            r110.mHelper.refreshUIFromDownloadInfo(r110.mDownloadInfo, CommonDownloadHandler.access$400(r110), DownloadHelper.getDownloadListeners(DownloadStatusChangeListener.class, CommonDownloadHandler.access$300(this.this$0)), r103);     // Catch: Exception -> L10
            goto L49
        L30:
            if (r109.getStatus() != (-4)) goto L32;
            this.this$0.mDownloadInfo = null;     // Catch: Exception -> L10
            goto L33
        L26:
            if (Downloader.getInstance(GlobalInfo.getContext()).isDownloadSuccessAndFileNotExist(r102) == true) goto L34;
        L18:
            if (r101.isInstall() == false) goto L20;
            r103 = true;
            goto L21
        L53:
            r102 = r100.getDownloadInfo();     // Catch: Exception -> L10
            r101 = r100.getDownloadInstallInfo();     // Catch: Exception -> L10
            goto L13
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r100) {
            return doInBackground((String[]) r100);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Object r100) {
            onPostExecute((BindDownloadInfo) r100);
        }

        public /* synthetic */ QueryDownloadInfoTaskWithNewDownloader(CommonDownloadHandler r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static /* synthetic */ void a(CommonDownloadHandler r100, int r101, boolean r102, NativeDownloadModel r103, int r104, NativeDownloadModel r105) {
        r100.lambda$performButtonClickWithNewDownloader$2(r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ void b(CommonDownloadHandler r100) {
        r100.lambda$performButtonClickWithNewDownloader$1();
    }

    public static /* synthetic */ void c(CommonDownloadHandler r100, int r101, boolean r102, int r103) {
        r100.lambda$beginExecuteDownload$0(r101, r102, r103);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public boolean isSupportSilentDownload() {
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public void onBind() {
        this.mIsBind = true;
        ModelManager.getInstance().addDownloadEventConfig(this.mCurrentId, getDownloadEventConfig());
        ModelManager.getInstance().addDownloadController(this.mCurrentId, getDownloadController());
        this.mHelper.setAdId(this.mCurrentId);
        resumeDownload();
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.ENABLE_EMPTY_LISTENER, 1) == 1) goto L7;
        return;
    L7:
        if (this.mStatusChangeListenerMap.get(Integer.MIN_VALUE) != null) goto L12;
        addStatusChangeListener(Integer.MIN_VALUE, new AbsDownloadStatusChangeListener());
        return;
    }

    static {
        TAG = "CommonDownloadHandler";
    }

    private boolean downloadButtonClickCallback() {
        SoftReference<IDownloadButtonClickListener> r100 = this.mDownloadButtonClickListener;
        if (r100 != null) goto L5;
    L8:
        TTDownloaderMonitor.inst().monitorPathError("mDownloadButtonClickListener has recycled");
        return false;
    L5:
        if (r100.get() == null) goto L8;
        this.mDownloadButtonClickListener.get().handleComplianceDialog(true);
        this.mDownloadButtonClickListener = null;
        return true;
    }

    private DownloadController getDownloadController() {
        if (this.mDownloadController != null) goto L6;
        this.mDownloadController = new AdDownloadController.Builder().setDefaultControllerSign(true).build();
    L6:
        return this.mDownloadController;
    }

    private DownloadEventConfig getDownloadEventConfig() {
        DownloadEventConfig r100 = this.mDownloadEventConfig;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new AdDownloadEventConfig.Builder().setDefaultEventConfigSign(true).build();
    }

    private DownloadShortInfo getTempDownloadShortInfo() {
        if (this.mTempDownloadShortInfo != null) goto L6;
        this.mTempDownloadShortInfo = new DownloadShortInfo();
    L6:
        return this.mTempDownloadShortInfo;
    }

    private void handleClickIdService() {
        if ((this.mCurrentDownloadModel instanceof AdDownloadModel) == true) goto L5;
        return;
    L5:
        if ((this.mDownloadController instanceof AdDownloadController) == true) goto L7;
        return;
    L7:
        if (GlobalInfo.getContext() == null) goto L12;
        DownloadClickIdManager.getInstance().insertByContentProvider((AdDownloadModel) this.mCurrentDownloadModel, (AdDownloadController) this.mDownloadController, new AnonymousClass2(this), this.mHelper.nativeDownloadModel);
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "handleDownload", "尝试发送包含clickId的粘性广播");
        DownloadClickIdManager.getInstance().sendStickyBroadcast((AdDownloadModel) this.mCurrentDownloadModel);
        return;
    }

    private /* synthetic */ void lambda$performButtonClickWithNewDownloader$1() {
        JSONObject r100 = new JSONObject();
        ToolUtils.safePut(r100, EventConstants.ExtraJson.EXTRA_CANCEL_SOURCE, "local");
        cancelDownload(true, r100);
    }

    public Context getContext() {
        WeakReference<Context> r100 = this.mContextRef;
        if (r100 == null) goto L9;
        if (r100.get() == null) goto L9;
        return this.mContextRef.get();
    L9:
        return GlobalInfo.getContext();
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public long getDownloadAdId() {
        DownloadModel r100 = this.mCurrentDownloadModel;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getId();
    }

    public Map<Integer, Object> getStatusChangeListenerMap() {
        return new ConcurrentHashMap(this.mStatusChangeListenerMap);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public boolean isDownloadStarted() {
        DownloadInfo r100 = this.mDownloadInfo;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getStatus() == 0) goto L7;
        return true;
    }

    public boolean needBeginDownload() {
        DownloadInfo r100 = this.mDownloadInfo;
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.getStatus() != (-3)) goto L11;
        if (this.mDownloadInfo.getCurBytes() > 0) goto L11;
        return true;
    L11:
        if (this.mDownloadInfo.getStatus() != 0) goto L13;
    L22:
        return true;
    L13:
        if (this.mDownloadInfo.getStatus() == (-4)) goto L22;
        if (DownloadUtils.isDownloadSuccessAndFileNotExist(this.mDownloadInfo.getStatus(), this.mDownloadInfo.getSavePath(), this.mDownloadInfo.getName()) == false) goto L25;
        return true;
    L25:
        return false;
    L18:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public void notifyInstallFinish() {
        this.mDownloadInfoChangeHandler.post(new AnonymousClass3(this));
    }

    public void openLandingPage() {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "openLandingPage", "进入跳转落地页的逻辑");
        SoftReference<OnItemClickListener> r100 = this.mItemClickListener;
        if (r100 != null) goto L5;
    L7:
        IAdDownloadActionProvider r101 = (IAdDownloadActionProvider) DownloadAdRuntimeProvider.getInnerService(IAdDownloadActionProvider.class);
        if (r101 == null) goto L10;
        r101.onItemClick(getContext(), this.mCurrentDownloadModel, getDownloadController(), getDownloadEventConfig());
    L10:
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (r102 != null) goto L13;
    L15:
        AdEventHandler.getInstance().sendOpenWebEvent(EventConstants.UnityLabel.OPEN_WEB, this.mCurrentId);
        return;
    L13:
        if (TextUtils.isEmpty(r102.getWebUrl()) == false) goto L15;
        DownloadInsideHelper.processWhenWebUrlNull();
        goto L15
    L5:
        if (r100.get() == null) goto L7;
        this.mItemClickListener.get().onItemClick(this.mCurrentDownloadModel, getDownloadEventConfig(), getDownloadController());
        this.mItemClickListener = null;
        goto L10
    }

    public void resetDownloadStatus() {
        if (this.mStatusChangeListenerMap.size() != 0) goto L5;
        return;
    L5:
        Iterator r100 = DownloadHelper.getDownloadListeners(DownloadStatusChangeListener.class, this.mStatusChangeListenerMap).iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((DownloadStatusChangeListener) r100.next()).onIdle();
        goto L7
    L9:
        DownloadInfo r101 = this.mDownloadInfo;
        if (r101 == null) goto L14;
        r101.setStatus(-4);
        return;
    }

    public void resumeDownload() {
        QueryDownloadInfoTaskWithNewDownloader r100 = this.mInfoTaskWithNewDownloader;
        if (r100 != null) goto L5;
    L7:
        this.mInfoTaskWithNewDownloader = new QueryDownloadInfoTaskWithNewDownloader(this, null);
        if (TextUtils.isEmpty(this.mHandlerTaskKey) == true) goto L10;
        AsyncTaskUtils.executeAsyncTask(this.mInfoTaskWithNewDownloader, new String[]{this.mCurrentDownloadModel.getDownloadUrl(), this.mCurrentDownloadModel.getPackageName(), this.mHandlerTaskKey});
        return;
    L10:
        AsyncTaskUtils.executeAsyncTask(this.mInfoTaskWithNewDownloader, new String[]{this.mCurrentDownloadModel.getDownloadUrl(), this.mCurrentDownloadModel.getPackageName()});
        return;
    L5:
        if (r100.getStatus() == AsyncTask.Status.FINISHED) goto L7;
        this.mInfoTaskWithNewDownloader.cancel(true);
        goto L7
    }

    public CommonDownloadHandler() {
        WeakHandler r100 = new WeakHandler(Looper.getMainLooper(), this);
        this.mDownloadInfoChangeHandler = r100;
        this.mStatusChangeListenerMap = new ConcurrentHashMap();
        this.mDownloadListener = new DownloadHelper.AppDownloadListener(r100);
        this.mCurrentId = -1;
        this.mCurrentDownloadModel = null;
        this.mDownloadEventConfig = null;
        this.mDownloadController = null;
        this.mHelper = new DownloadHelper();
        this.mCleanHelper = new CleanSpaceHelper(r100);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public void resetHandlerInfo() {
        ModelManager.getInstance().removeMemoryCaches(this.mCurrentId);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public String getDownloadTaskKey() {
        return this.mHandlerTaskKey;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public long getLastWorkTime() {
        return this.mLastWorkTime;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public boolean isBind() {
        return this.mIsBind;
    }

    public static /* synthetic */ DownloadModel access$100(CommonDownloadHandler r100) {
        return r100.mCurrentDownloadModel;
    }

    public static /* synthetic */ IDownloadListener access$1100(CommonDownloadHandler r100) {
        return r100.mDownloadListener;
    }

    public static /* synthetic */ Map access$300(CommonDownloadHandler r100) {
        return r100.mStatusChangeListenerMap;
    }

    public static /* synthetic */ DownloadShortInfo access$400(CommonDownloadHandler r100) {
        return r100.getTempDownloadShortInfo();
    }

    public static /* synthetic */ CleanSpaceHelper access$500(CommonDownloadHandler r100) {
        return r100.mCleanHelper;
    }

    private void beginDownloadWithNewDownloader(boolean r110) {
        Iterator r100 = DownloadHelper.getDownloadListeners(DownloadStatusChangeListener.class, this.mStatusChangeListenerMap).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((DownloadStatusChangeListener) r100.next()).onDownloadStart(this.mCurrentDownloadModel, getDownloadController());
        goto L4
    L6:
        int r101 = this.mHelper.startDownloadWithNewDownloader(GlobalInfo.getContext(), this.mDownloadListener);
        TTDownloaderLogger r102 = TTDownloaderLogger.INSTANCE;
        String r103 = TAG;
        r102.innerLogD(r103, "beginDownloadWithNewDownloader", "beginDownloadWithNewDownloader id:" + r101);
        if (r101 == 0) goto L30;
        NativeDownloadModel r104 = ModelManager.getInstance().getNativeModelByInfoId(r101);
        if (r104 != null) goto L11;
    L13:
        if (r110 == false) goto L32;
        if (r104 != null) goto L16;
    L18:
        if (r104 == null) goto L27;
        if (r104.getIsOrderDownload() != 1) goto L27;
        if (DownloadSettingUtils.getSetting(r104).optInt(DownloadSettingKeys.KEY_ORDER_DOWNLOAD_MESSAGE_RETAIN_OPT, 0) != 1) goto L27;
        if (DownloadSettingUtils.checkPackageNameEnableOrderMessage(r104) == false) goto L27;
        OrderDownloaderRetainHelper.getInstance().showOrderDownloadUnInstalledMessage(r104, r101);
    L27:
        if (this.mDownloadInfo == null) goto L29;
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_CLICK_START_WITH_DOWNLOAD_INFO, new JSONObject(), r104);
    L29:
        this.mHelper.sendClickStartEventAfterReceivedProgress();
        goto L32
    L16:
        if (r104.getDownloadStartDate() != 0) goto L18;
        r104.getModel().setDownloadStartDate(System.currentTimeMillis());
    L32:
        if (DownloadInsideHelper.shouldResponseItemClick(isDownloadStarted(), this.mHelper.nativeDownloadModel) == false) goto L36;
        r102.innerLogD(r103, "beginDownloadWithNewDownloader", "beginDownloadWithNewDownloader onItemClick id:" + r101);
        openLandingPage();
        return;
    L36:
        return;
    L11:
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r104) == false) goto L13;
        DownloadTaskQueueManagementManager.getInstance().handleDownloadStart(r104);
        goto L13
    L30:
        DownloadInfo r111 = new DownloadInfo.Builder(this.mCurrentDownloadModel.getDownloadUrl()).build();
        r111.setStatus(-1);
        sendUiChangeMessage(r111);
        AdEventHandler.getInstance().sendDownloadFailedEvent(this.mCurrentId, new BaseException(2, "start download failed, id=0"));
        TTDownloaderMonitor.inst().monitorPathError("beginDownloadWithNewDownloader");
        goto L32
    }

    private void beginDownloadWithSubThread(final boolean r100) {
        Iterator r101 = DownloadHelper.getDownloadListeners(DownloadStatusChangeListener.class, this.mStatusChangeListenerMap).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((DownloadStatusChangeListener) r101.next()).onDownloadStart(this.mCurrentDownloadModel, getDownloadController());
        goto L4
    L6:
        Chain.createOnIo(new AnonymousClass9(this), null).nextOnMain(new AnonymousClass8(this, r100)).start();
    }

    private void beginExecuteDownload(final int r110) {
        AdAppLinkManager.getInstance().handleLink(this.mHelper.nativeDownloadModel, r110, 1, this.mIsNormalScene, this, this.mCurrentDownloadModel, this.mDownloadInfo, getContext(), this.mHelper.downloadExtraInfo, new a(this, r110));
    }

    private void beginExecuteDownloadNew(int r110) {
        this.mHelper.nativeDownloadModel.setEnableDownloadProcessChainOpt(true);
        new TTDownloadInterceptorChain(new DownloadChainInfo(this.mHelper.nativeDownloadModel, r110, 1, this.mIsNormalScene, this, this.mCurrentDownloadModel, this.mDownloadInfo, getContext(), this.mHelper.downloadExtraInfo)).add(new AppInstallInterceptor()).add(new AppMarketInterceptor()).add(new AppQuickInterceptor()).add(new AppDownloadInterceptor()).proceed(0);
    }

    private void doClearContentProvider(final NativeDownloadModel r100) {
        DownloadClickIdManager.getInstance().clearExpiredContentProvider(new AnonymousClass1(this, r100));
    }

    private void download(final boolean r110) {
        this.mCleanHelper.setDownloadModelInfo(this.mCurrentDownloadModel, getDownloadEventConfig(), getDownloadController());
        this.mCleanHelper.handleSpaceBeforeDownload(0, 0, 0, new AnonymousClass7(this, r110));
    }

    private void performItemClickWithNewDownloader(boolean r100) {
        TTDownloaderLogger r101 = TTDownloaderLogger.INSTANCE;
        String r102 = TAG;
        r101.innerLogD(r102, "performItemClickWithNewDownloader", "performItemClickWithNewDownloader");
        if (this.mHelper.shouldStartInstallView(this.mDownloadInfo) == true) goto L5;
        if (r100 == false) goto L12;
        AdEventHandler.getInstance().sendClickEvent(this.mCurrentId, 1);
    L12:
        r101.innerLogD(r102, "performItemClickWithNewDownloader", "performItemClickWithNewDownloader onItemClick");
        openLandingPage();
        return;
    L5:
        if (r100 == true) goto L7;
    L9:
        r101.innerLogD(r102, "performItemClickWithNewDownloader", "performItemClickWithNewDownloader ButtonClick");
        performButtonClickWithNewDownloader(false, true);
        return;
    L7:
        if (DownloadSettingUtils.getSetting(this.mCurrentDownloadModel).optInt(DownloadSettingKeys.BugFix.FIX_INSTALL_SEND_EXTRA_CLICK_EVENT, 0) != 0) goto L9;
        AdEventHandler.getInstance().sendClickEvent(this.mCurrentId, 1);
        goto L9
    }

    private void sendUiChangeMessage(DownloadInfo r100) {
        Message r101 = Message.obtain();
        r101.what = 3;
        r101.obj = r100;
        this.mDownloadInfoChangeHandler.sendMessage(r101);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public boolean deleteModel(String r110) {
    L10:
        e = move-exception;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "deleteModel", "执行删除model方法出现crash，msg=" + e.getMessage());
        TTDownloaderMonitor.inst().monitorException(false, true, e, "删除下载数据model错误");
    L12:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "deleteModel", "执行删除model方法失败");
        return false;
    L4:
        if (this.mDownloadInfo == null) goto L6;
        NativeDownloadModel r111 = ModelManager.getInstance().getNativeModelByInfo(this.mDownloadInfo);     // Catch: Exception -> L10
    L7:
        if (r111 == null) goto L12;
        ModelManager.getInstance().removeNativeModel(r111);     // Catch: Exception -> L10
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "deleteModel", "执行删除model方法成功，cid = " + r111.getId());     // Catch: Exception -> L10
        return true;
    L6:
        r111 = ModelManager.getInstance().getNativeModelByUrl(r110);     // Catch: Exception -> L10
        goto L7
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public void handleDownload(int r100) {
        TTDownloaderLogger r101 = TTDownloaderLogger.INSTANCE;
        String r102 = TAG;
        r101.innerLogD(r102, "handleDownload", "进入下载SDK的处理逻辑");
        if (r100 != 1) goto L5;
    L7:
        this.mHelper.setAdId(this.mCurrentId);
        handleClickIdService();
        if (DownloadSettingUtils.checkEnableDownloadChainOpt() == false) goto L10;
        r101.innerLogD(r102, "handleDownload", "命中下载调用流程链式调用优化策略");
        beginExecuteDownloadNew(r100);
        return;
    L10:
        r101.innerLogD(r102, "handleDownload", "未开启链式调用开关，走原有逻辑");
        beginExecuteDownload(r100);
        return;
    L5:
        if (r100 == 2) goto L7;
        TTDownloaderMonitor.inst().monitorDataError("error actionType");
        goto L7
    }

    public void handleDownloadNoIntercept(int r100) {
        if (this.mHelper.handleOrderDownload(r100, this.mIsNormalScene, this) == false) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "handleDownloadNoIntercept", "handleDownload id:" + this.mCurrentId + ",tryPerformItemClick");
        tryPerformItemClick(true);
        return;
    L8:
        if (r100 != 2) goto L10;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "handleDownloadNoIntercept", "handleDownload id:" + this.mCurrentId + ",tryPerformButtonClick");
        if (DownloadSettingUtils.getSetting(this.mCurrentDownloadModel).optInt(DownloadSettingKeys.BugFix.FIX_LP_SEND_EXTRA_CLICK_EVENT, 0) != 1) goto L16;
        tryPerformButtonClick(this.mIsNormalScene, true);
        return;
    L16:
        tryPerformButtonClick(true, true);
        return;
    L10:
        if (r100 != 3) goto L22;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "handleDownloadNoIntercept", "点击行为来自个性化下载入口的合规弹窗,后续不能再执行是否展示合规弹窗的判断逻辑");
        tryPerformButtonClick(true, false);
        return;
    }

    @Override // com.ss.android.downloadlib.utils.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mIsBind == true) goto L7;
        return;
    L7:
        if (r100.what != 3) goto L13;
        this.mDownloadInfo = (DownloadInfo) r100.obj;
        this.mHelper.handleUiChangeMessage(r100, getTempDownloadShortInfo(), this.mStatusChangeListenerMap);
        return;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public boolean onUnbind(int r100) {
        if (r100 != 0) goto L4;
        this.mStatusChangeListenerMap.clear();
    L6:
        if (this.mStatusChangeListenerMap.isEmpty() == false) goto L18;
        this.mIsBind = false;
        this.mLastWorkTime = System.currentTimeMillis();
        if (this.mDownloadInfo == null) goto L10;
        Downloader.getInstance(GlobalInfo.getContext()).removeTaskMainListener(this.mDownloadInfo.getId());
    L10:
        QueryDownloadInfoTaskWithNewDownloader r101 = this.mInfoTaskWithNewDownloader;
        if (r101 != null) goto L13;
    L15:
        this.mHelper.resetData(this.mDownloadInfo);
        this.mDownloadInfoChangeHandler.removeCallbacksAndMessages(null);
        this.mTempDownloadShortInfo = null;
        this.mDownloadInfo = null;
        return true;
    L13:
        if (r101.getStatus() == AsyncTask.Status.FINISHED) goto L15;
        this.mInfoTaskWithNewDownloader.cancel(true);
        goto L15
    L18:
        if (this.mStatusChangeListenerMap.size() == 1) goto L20;
    L22:
        return false;
    L20:
        if (this.mStatusChangeListenerMap.containsKey(Integer.MIN_VALUE) == false) goto L22;
        this.mHelper.sendClickStartWhenUnbind(this.mDownloadInfo);
        goto L22
    L4:
        this.mStatusChangeListenerMap.remove(Integer.valueOf(r100));
        goto L6
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public CommonDownloadHandler setContext(Context r100) {
        if (r100 == null) goto L4;
        this.mContextRef = new WeakReference(r100);
    L4:
        GlobalInfo.makeSureContext(r100);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public DownloadHandler setDownloadButtonClickListener(IDownloadButtonClickListener r100) {
        if (r100 != null) goto L4;
        this.mDownloadButtonClickListener = null;
    L5:
        return this;
    L4:
        this.mDownloadButtonClickListener = new SoftReference(r100);
        goto L5
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public CommonDownloadHandler setDownloadController(DownloadController r100) {
        if ((r100 instanceof AdDownloadController) == false) goto L5;
        ((AdDownloadController) r100).setDefaultControllerSign(false);
    L5:
        this.mDownloadController = r100;
        if (DownloadSettingUtils.getSetting(this.mCurrentDownloadModel).optInt(DownloadSettingKeys.KEY_FORCE_AUTO_OPEN) != 1) goto L8;
        getDownloadController().setLinkMode(1);
    L8:
        JSONObject r101 = this.mCurrentDownloadModel.getExtra();
        if (r101 != null) goto L11;
    L13:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "setDownloadController", "当前的mDownloadController为:" + ToolUtils.generateTLoggerReport(null, this.mDownloadController, null));
        ModelManager.getInstance().addDownloadController(this.mCurrentId, getDownloadController());
        return this;
    L11:
        if (r101.optInt("subprocess") <= 0) goto L13;
        getDownloadController().setEnableNewActivity(false);
        goto L13
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public CommonDownloadHandler setDownloadEventConfig(DownloadEventConfig r100) {
        boolean r101 = false;
        if ((r100 instanceof AdDownloadEventConfig) == false) goto L5;
        ((AdDownloadEventConfig) r100).setDefaultEventConfigSign(false);
    L5:
        this.mDownloadEventConfig = r100;
        if (getDownloadEventConfig().getDownloadScene() != 0) goto L8;
        r101 = true;
    L8:
        this.mIsNormalScene = r101;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "setDownloadEventConfig", "mDownloadEventConfig为:" + ToolUtils.generateTLoggerReport(null, null, this.mDownloadEventConfig));
        ModelManager.getInstance().addDownloadEventConfig(this.mCurrentId, getDownloadEventConfig());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public void setDownloadExtra(JSONObject r100) {
        if (r100 == null) goto L11;
        DownloadModel r101 = this.mCurrentDownloadModel;
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof AdDownloadModel) == false) goto L13;
        ((AdDownloadModel) r101).setExtra(r100);
        ModelManager.getInstance().addDownloadModel(this.mCurrentDownloadModel, 1);
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (r102 == null) goto L14;
        r102.getModel().setExtra(r100);
        ModelManager.getInstance().putNativeModel(r102);
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public DownloadHandler setDownloadTaskKey(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.mHandlerTaskKey = r100;
    L5:
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public DownloadHandler setModelId(long r100) {
        if (r100 == 0) goto L7;
        DownloadModel r101 = ModelManager.getInstance().getDownloadModel(r100);
        if (r101 == null) goto L8;
        this.mCurrentDownloadModel = r101;
        this.mCurrentId = r100;
        this.mHelper.setAdId(r100);
    L8:
        return this;
    L7:
        TTDownloaderMonitor.inst().monitorDataError(false, false, "setModelId");
        goto L8
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public DownloadHandler setOnItemClickListener(OnItemClickListener r100) {
        if (r100 != null) goto L4;
        this.mItemClickListener = null;
    L5:
        return this;
    L4:
        this.mItemClickListener = new SoftReference(r100);
        goto L5
    }

    public void tryPerformItemClick(boolean r100) {
        performItemClickWithNewDownloader(r100);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public /* bridge */ /* synthetic */ DownloadHandler setContext(Context r100) {
        return setContext(r100);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public /* bridge */ /* synthetic */ DownloadHandler setDownloadController(DownloadController r100) {
        return setDownloadController(r100);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public /* bridge */ /* synthetic */ DownloadHandler setDownloadEventConfig(DownloadEventConfig r100) {
        return setDownloadEventConfig(r100);
    }

    public static /* synthetic */ void access$1000(CommonDownloadHandler r100, DownloadInfo r101) {
        r100.sendUiChangeMessage(r101);
    }

    public static /* synthetic */ void access$200(CommonDownloadHandler r100, NativeDownloadModel r101) {
        r100.doClearContentProvider(r101);
    }

    public static /* synthetic */ void access$700(CommonDownloadHandler r100, boolean r101) {
        r100.download(r101);
    }

    public static /* synthetic */ void access$800(CommonDownloadHandler r100, boolean r101) {
        r100.beginDownloadWithSubThread(r101);
    }

    public static /* synthetic */ void access$900(CommonDownloadHandler r100, boolean r101) {
        r100.beginDownloadWithNewDownloader(r101);
    }

    private void handleStatusClick(int r100, int r101) {
        if (r101 != (-3)) goto L5;
    L7:
        DownloadInfo r102 = this.mDownloadInfo;
        if (r102 != null) goto L10;
    L14:
        AppDownloader.getInstance().handleStatusClick(GlobalInfo.getContext(), r100, r101);
        return;
    L10:
        if (DownloadFileUtils.isMediaUri(r102.getSavePath()) == false) goto L14;
        if (DownloadFileUtils.checkUriInsert(this.mDownloadInfo.getSavePath()) == true) goto L14;
        innerStartDownload(false, false);
        return;
    L5:
        if (DownloadProcessDispatcher.getInstance().canResume(r100) == true) goto L7;
        innerStartDownload(false, false);
    }

    private void showComplianceDialogInFeed(boolean r100, int r101) {
        JSONObject r102 = this.mDownloadEventConfig.getAppPkgInfo();
        if (r102 == null) goto L12;
        AppPkgInfo r103 = AppPkgInfo.getAppPkgInfoObject(r102);
        if (AppPkgInfo.checkAppPkgInfoComplete(r103) == true) goto L10;
        if (r100 == false) goto L8;
        AdEventHandler.getInstance().sendClickEvent(this.mCurrentId, 2);
    L8:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "performButtonClickWithNewDownloader", "六要素展示不全，走兜底落地页逻辑");
        openLandingPage();
        return;
    L10:
        r103.setIconUrl(this.mCurrentDownloadModel.getAppIcon());
        AdLpComplianceManager.getInstance().showAppInfoDialogInFeed(AppPkgInfo.generateAppPkgInfoJson(r103), this.mCurrentDownloadModel, this.mDownloadInfo, r101);
        return;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public CommonDownloadHandler addStatusChangeListener(int r100, DownloadStatusChangeListener r101) {
        if (r101 == null) goto L4;
        this.mStatusChangeListenerMap.put(Integer.valueOf(r100), new SoftReference(r101));
    L4:
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public void cancelDownload(boolean r100, JSONObject r101) {
        if (this.mDownloadInfo == null) goto L6;
        DownloadInsideHelper.handleCancelDownload(ModelManager.getInstance().getNativeModelByInfo(this.mDownloadInfo), this.mDownloadInfo, r100, r101, this.mCurrentDownloadModel);
        return;
    }

    public void innerStartDownload(boolean r100, final boolean r101) {
        TTDownloaderLogger r102 = TTDownloaderLogger.INSTANCE;
        String r103 = TAG;
        r102.innerLogD(r103, "innerStartDownload", "处理开始下载的逻辑");
        if (r100 == false) goto L6;
        AdEventHandler.getInstance().sendClickEvent(this.mCurrentId, 2);
    L6:
        if (ToolUtils.checkWritePermission() == true) goto L19;
        if (getDownloadController().enableNewActivity() == true) goto L19;
        String r104 = DownloadDirUtils.getDefaultExtPrivatePath();
        DownloadSettingUtils.getAdSettingJson();
        TTDownloadSettingsModel r105 = TTDownloadSettingsAdapter.INSTANCE.get();
        if (this.mCurrentDownloadModel.isAd() == false) goto L17;
        if (r105 == null) goto L17;
        if (r105.getEnableBusinessDownloadFile() != 1) goto L17;
        String r106 = DirUtils.getBusinessPrivatePath();
        if (TextUtils.isEmpty(r106) == true) goto L17;
        r104 = r106;
    L17:
        this.mCurrentDownloadModel.setFilePath(r104);
    L19:
        if (DownloadSettingUtils.getSavePathType(this.mCurrentDownloadModel) != 0) goto L21;
        r102.innerLogD(r103, "innerStartDownload", "performButtonClickWithNewDownloader not start");
        this.mHelper.checkConditionBeforeDownload(new AnonymousClass6(this, r101));
        return;
    L21:
        download(r101);
    }

    public void performButtonClickWithNewDownloader(final boolean r110, boolean r111) {
        TTDownloaderLogger r100 = TTDownloaderLogger.INSTANCE;
        String r101 = TAG;
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "开始处理点击按钮的操作");
        boolean r102 = needBeginDownload();
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "判断是否需要在特殊场景展示合规弹窗");
        int r103 = AdComplianceChecker.INSTANCE.needShowComplianceDialogInFeed(r102, this.mIsNormalScene, this.mCurrentDownloadModel, this.mDownloadController, this.mDownloadEventConfig, this.mDownloadInfo, r111);
        if (r103 <= 0) goto L7;
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "需要展示合规弹窗,拦截原有的点击操作");
        showComplianceDialogInFeed(r110, r103);
        return;
    L7:
        if (needBeginDownload() == false) goto L33;
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "需要执行开始下载的操作");
        NativeDownloadModel r112 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (this.mHelper.shouldOpenWeb(this.mIsNormalScene) == false) goto L15;
        if (r110 == false) goto L12;
        AdEventHandler.getInstance().sendClickEvent(this.mCurrentId, 2);
    L12:
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "需要跳转兜底落地页");
        openLandingPage();
        return;
    L15:
        if (this.mIsNormalScene == false) goto L28;
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "外卡场景，第一次下载");
        if (this.mCurrentDownloadModel.isAd() == true) goto L19;
    L27:
        innerStartDownload(r110, true);
        return;
    L19:
        if (this.mDownloadButtonClickListener == null) goto L27;
        if (downloadButtonClickCallback() == true) goto L23;
        return;
    L23:
        if (r112.getController() != null) goto L25;
        return;
    L25:
        if (r112.getController().isAutoDownloadOnCardShow() == false) goto L96;
        innerStartDownload(r110, true);
        return;
    L96:
        return;
    L28:
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "落地页场景，第一次下载");
        if (AdLpComplianceManager.getInstance().shouldRequestComplianceInfo(getContext(), r112.getModel(), r112.getController(), r112.getComplianceItem()) == false) goto L32;
        AdLpComplianceManager.getInstance().requestComplianceData(r112, getContext());
        return;
    L32:
        innerStartDownload(r110, true);
        return;
    L33:
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "非第一次开始下载");
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "performButtonClickWithNewDownloader continue download, status:" + this.mDownloadInfo.getStatus());
        DownloadInfo r104 = this.mDownloadInfo;
        if (r104 == null) goto L48;
        DownloadModel r105 = this.mCurrentDownloadModel;
        if (r105 == null) goto L40;
        r104.setOnlyWifi(r105.isNeedWifi());
        BizLineType r106 = this.mCurrentDownloadModel.getBizLineType();
        if (r106 == null) goto L40;
        this.mDownloadInfo.setInstallBizType(r106.toString());
    L40:
        DownloadController r107 = this.mDownloadController;
        if (r107 == null) goto L48;
        String r108 = r107.getBizParamsJson();
        if (TextUtils.isEmpty(r108) == true) goto L45;
        this.mDownloadInfo.setInstallBizParamsJson(r108);
    L45:
        String r109 = this.mDownloadController.getCertId();
        if (TextUtils.isEmpty(r109) == true) goto L48;
        this.mDownloadInfo.setInstallCertId(r109);
    L48:
        final int r113 = this.mDownloadInfo.getStatus();
        final int r114 = this.mDownloadInfo.getId();
        final NativeDownloadModel r115 = ModelManager.getInstance().getNativeModelByInfo(this.mDownloadInfo);
        if (r113 != (-2)) goto L51;
    L89:
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "当前状态为下载暂停/失败");
        this.mHelper.sendEventWithNewDownloader(this.mDownloadInfo, r110);
        if (r115 == null) goto L92;
        r115.setClickDownloadTime(System.currentTimeMillis());
        r115.setClickDownloadSize(this.mDownloadInfo.getCurBytes());
    L92:
        this.mDownloadInfo.setDownloadFromReserveWifi(false);
        this.mCleanHelper.setDownloadModelInfo(this.mCurrentDownloadModel, getDownloadEventConfig(), getDownloadController());
        this.mCleanHelper.handleSpaceBeforeDownload(r114, this.mDownloadInfo.getCurBytes(), this.mDownloadInfo.getTotalBytes(), new AnonymousClass4(this, r114, r113));
        return;
    L51:
        if (r113 == (-1)) goto L89;
        if (ReverseWifiHelper.willPause(r113) == false) goto L88;
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "当前状态为下载暂停");
        if (this.mCurrentDownloadModel.enablePause() == true) goto L59;
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_DOWNLOAD_NOT_ENABLE_PAUSE, new JSONObject(), r115);
        return;
    L59:
        this.mCleanHelper.setDownloadActionCanceled(true);
        if (r115 == null) goto L100;
        NotificationPusher.getInstance().delayNotifyContinueDownload(ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId));
        if ((this.mCurrentDownloadModel instanceof AdDownloadModel) == false) goto L65;
        r115.getModel().setIsDownloadManagement(((AdDownloadModel) this.mCurrentDownloadModel).isFromDownloadManagement());
    L65:
        if (DownloadSetting.obtain(r115.getDownloadId()).optInt(DownloadSettingKeys.FIX_TASK_AFFINITY_CHANGE_ERROR, 0) != 1) goto L67;
        boolean r116 = ToolUtils.whetherTopActivitySingleTask();
    L69:
        if (DownloadSettingUtils.checkJumpManagementOpen(r115) == false) goto L87;
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "命中了新的下载暂停挽留弹窗逻辑");
        CancelPauseInterceptorManager.getInstance().setPauseOptimiseCount(DownloadSettingUtils.getPauseOptimiseCount(r115));
        DownloadEventConfig r117 = this.mDownloadEventConfig;
        if (r117 != null) goto L73;
    L76:
        if (r111 == true) goto L78;
    L77:
        r115.setIsDisableShowDialog(true);
    L78:
        IAdSDKSettingsProvider r118 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (DownloadSettingUtils.getSetting(r115).optInt(DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_BUTTON_DO_DELETE, 0) == 1) goto L85;
        if (r118 != null) goto L82;
    L84:
        IDeleteBtnListener r119 = null;
    L86:
        CancelPauseInterceptorManager.getInstance().handlePauseWithCancel(r115, r113, new c(this, r114, r110, r115, r113), r119, r116, getContext());
        return;
    L82:
        if (r118.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_BUTTON_DO_DELETE, 0) != 1) goto L84;
    L85:
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "点击取消按钮直接删除下载任务,不需要跳转应用管理中心页面");
        r119 = new b(this);
        goto L86
    L73:
        if (TextUtils.isEmpty(r117.getRefer()) == true) goto L76;
        if (TextUtils.equals(this.mDownloadEventConfig.getRefer(), "download_center") == true) goto L77;
    L87:
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "命中了旧的下载暂停挽留弹窗逻辑");
        PauseInterceptorManager.getInstance().handlePause(r115, r113, new AnonymousClass5(this, r114, r110, r115, r113), r116, getContext());
        return;
    L67:
        r116 = false;
        goto L69
    L100:
        return;
    L88:
        r100.innerLogD(r101, "performButtonClickWithNewDownloader", "当前为其他的下载状态");
        this.mHelper.sendEventWithNewDownloader(this.mDownloadInfo, r110);
        handleStatusClick(r114, r113);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public CommonDownloadHandler setDownloadModel(DownloadModel r100, int r101) {
        if (r100 != null) goto L4;
    L55:
        return this;
    L4:
        if (r100.isAd() == false) goto L11;
        if (r100.getId() > 0) goto L8;
    L9:
        TTDownloaderMonitor.inst().monitorDataError("setDownloadModel ad error");
        goto L11
    L8:
        if (TextUtils.isEmpty(r100.getLogExtra()) == true) goto L9;
    L11:
        if (r100.getId() != 0) goto L19;
        if ((r100 instanceof AdDownloadModel) == false) goto L19;
        TTDownloaderMonitor.inst().monitorDataError(false, false, "setDownloadModel id=0");
        if (r100.getDownloadUrl() == null) goto L17;
        ((AdDownloadModel) r100).setId(r100.getDownloadUrl().hashCode());
        goto L19
    L17:
        ((AdDownloadModel) r100).setId(0);
    L19:
        if ((r100 instanceof AdDownloadModel) == true) goto L21;
    L25:
        ModelManager.getInstance().addDownloadModel(r100, r101);
        this.mCurrentId = r100.getId();
        this.mCurrentDownloadModel = r100;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "setDownloadModel", "当前的mCurrentDownloadModel为:" + ToolUtils.generateTLoggerReport(this.mCurrentDownloadModel, null, null));
        if (r100.getCallScene() != 9) goto L28;
    L33:
        ((AdDownloadModel) r100).setIsDownloadManagement(true);
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (r102 == null) goto L36;
        r102.getModel().setIsDownloadManagement(true);
    L36:
        AdDownloadModel r103 = (AdDownloadModel) r100;
        if (r103.getTaskKeyObject() == null) goto L42;
        NativeDownloadModel r104 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (r104 == null) goto L42;
        r104.getModel().setTaskKeyObject(r103.getTaskKeyObject());
    L42:
        if (DownloadInsideHelper.isRecommendAd(r100) == false) goto L49;
        r103.setExtraValue(3);
        NativeDownloadModel r105 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (r105 == null) goto L49;
        if (r105.getExtValue() == 3) goto L49;
        r105.getModel().setExtraValue(3);
        SharedPrefsManager.getInstance().saveNativeDownloadModel(r105);
    L49:
        if (DownloadInsideHelper.isGame(r100) == false) goto L55;
        NativeDownloadModel r106 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (r106 == null) goto L55;
        if (r100.getExtra() == null) goto L55;
        r106.getModel().setExtra(r100.getExtra());
        SharedPrefsManager.getInstance().saveNativeDownloadModel(r106);
        goto L55
    L28:
        if (r100.getCallScene() == 10) goto L33;
        ((AdDownloadModel) r100).setIsDownloadManagement(false);
        NativeDownloadModel r107 = ModelManager.getInstance().getNativeDownloadModel(this.mCurrentId);
        if (r107 == null) goto L36;
        r107.getModel().setIsDownloadManagement(false);
        goto L36
    L21:
        if (TextUtils.isEmpty(r100.getPackageName()) == false) goto L25;
        String r108 = DownloadInsideHelper.getPackageNameFromComplianceData(r100);
        if (TextUtils.isEmpty(r108) == true) goto L25;
        ((AdDownloadModel) r100).setPackageName(r108);
        goto L25
    }

    public void tryPerformButtonClick(boolean r100, boolean r101) {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryPerformButtonClick", "处理按钮区域点击事件");
        if (DownloadSettingUtils.getSetting(this.mCurrentDownloadModel).optInt(com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys.NOTIFICATION_OPT_2) == 1) goto L5;
    L7:
        performButtonClickWithNewDownloader(r100, r101);
        return;
    L5:
        if (this.mDownloadInfo == null) goto L7;
        DownloadNotificationManager.getInstance().cancelNotification(this.mDownloadInfo.getId());
        goto L7
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public /* bridge */ /* synthetic */ DownloadHandler addStatusChangeListener(int r100, DownloadStatusChangeListener r101) {
        return addStatusChangeListener(r100, r101);
    }

    @Override // com.ss.android.downloadlib.addownload.DownloadHandler
    public /* bridge */ /* synthetic */ DownloadHandler setDownloadModel(DownloadModel r100, int r101) {
        return setDownloadModel(r100, r101);
    }

    public static /* synthetic */ void access$600(CommonDownloadHandler r100, int r101, int r102) {
        r100.handleStatusClick(r101, r102);
    }

    private /* synthetic */ void lambda$beginExecuteDownload$0(int r100, boolean r101, int r102) {
        ToolUtils.safePut(this.mHelper.downloadExtraInfo, AdBaseConstants.DownloadExtraInfoKey.EXTRA_APPLINK_INTERCEPT_RESULT_CODE, Integer.valueOf(r102));
        if (r101 == false) goto L6;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "handleDownload", "下载请求已成功处理, 对该点击事件进行拦截");
        return;
    L6:
        if (r102 != 4) goto L12;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "handleDownload", "调起失败, 但是该场景不继续执行点击逻辑");
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_APPLINK_FINAL_FAILED, new JSONObject(this.mHelper.downloadExtraInfo.toString()), this.mHelper.nativeDownloadModel);     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "发送调起失败用户侧埋点时json解析失败");
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_APPLINK_FINAL_FAILED, new JSONObject(), this.mHelper.nativeDownloadModel);
        return;
    L12:
        handleDownloadNoIntercept(r100);
    }

    private /* synthetic */ void lambda$performButtonClickWithNewDownloader$2(int r100, boolean r101, NativeDownloadModel r102, int r103, NativeDownloadModel r110) {
        r110.setIsManualPaused(true);
        if (this.mDownloadInfo != null) goto L5;
        this.mDownloadInfo = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r100);
    L5:
        this.mHelper.sendEventWithNewDownloader(this.mDownloadInfo, r101);
        if (this.mDownloadInfo != null) goto L8;
    L13:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "performButtonClickWithNewDownloader", "---开始检测主观暂停行为，包名为: " + this.mCurrentDownloadModel.getPackageName() + " ，当前时间为：" + System.currentTimeMillis());
        DownloadRetainHelper.getInstance().delayNotifyResumeDownload(this.mCurrentDownloadModel, this.mDownloadInfo, true);
        r110.setDownloadPauseTimeStamp(System.currentTimeMillis());
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r102) == true) goto L16;
    L24:
        handleStatusClick(r100, r103);
        return;
    L16:
        if (r102.isFromGameUnionLive() == false) goto L24;
        if (r102.getActionManually() == 1) goto L24;
        r102.setIsActionManually(DownloadInsideHelper.isActionManuallyInGameUnion(this.mCurrentDownloadModel.getExtra()));
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r102) == false) goto L24;
        if (r102.getActionManually() == 0) goto L24;
        DownloadTaskQueueManagementManager.getInstance().handleDownloadPause(r102);
        goto L24
    L8:
        if (DownloadUtils.isWifi(GlobalInfo.getContext()) == false) goto L13;
        if (this.mDownloadInfo.isPauseReserveOnWifi() == false) goto L13;
        this.mDownloadInfo.stopPauseReserveOnWifi();
        AdEventHandler.getInstance().sendUnityEvent(EventConstants.UnityLabel.CANCEL_PAUSE_RESERVE_WIFI_CANCEL_ON_WIFI, r102);
    }
}
