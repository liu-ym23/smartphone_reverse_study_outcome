package com.ss.android.bytedcert.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.bytedcert.callback.H5CallBack;
import com.ss.android.bytedcert.callback.IWebEventCallback;
import com.ss.android.bytedcert.callback.PhotoCallback;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.config.CertConfig;
import com.ss.android.bytedcert.config.ICnNetIdService;
import com.ss.android.bytedcert.config.IDownloadConfig;
import com.ss.android.bytedcert.config.INfcService;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.config.ThemeConfigAdapter;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.flow.cert.BytedCertFlowParams;
import com.ss.android.bytedcert.flow.face.FaceDetectFlow;
import com.ss.android.bytedcert.flow.face.FaceDetectFlowParams;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.IBadgerSdkConfig;
import com.ss.android.cert.manager.ablity.ISecSdkConfig;
import com.ss.android.cert.manager.callback.CertResultCallback;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.SystemInfoTools;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.cert.manager.utils.thread.BCThread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import qsa.n;
import qsa.o;
import qsa.p;

/* JADX INFO: loaded from: classes34.dex */
public class BytedCertManager {
    private static final String BADGER_SDK_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.BadgerSdkAdapter";
    private static final String CN_NET_ID_ADAPTER_CLASS = "com.ss.android.bytedcert.cn.auth.adapter.ByteCertCnNetIdServiceImpl";
    private static final String DOWNLOAD_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.download.DownloadAdapter";
    private static final String GECKO_NETWORK_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.network.GeckoNetImpl";
    private static final String NFC_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.ByteCertNFCServiceImpl";
    public static final String[] OFFLINE_MODEL_PRE = null;
    private static final String SEC_SDK_ADAPTER_CLASS = "com.ss.android.bytedcert.adapter.SecSdkAdapter";
    private boolean hasDownload;
    private IBadgerSdkConfig mBadgerSdkConfig;
    private CertConfig mCertConfig;
    private ICnNetIdService mCnNetIdService;
    private IDownloadConfig mDownloadConfig;
    private final Map<String, ICertFlow> mFlowMap;
    private boolean mGeckoBOE;
    private String mGeckoBusinessVersion;
    private String mGeckoCustomAccessKey;
    private HashMap<String, String> mGeckoMap;
    private INetWork mGeckoNetwork;
    private final Handler mHandler;
    public long mImgTimeDelta;
    public String mImgType;
    private long mLastReportTime;
    private INfcService mNfcService;
    public PhotoCallback.PickCallback mPickCallbackImp;
    private ISecSdkConfig mSecSdkConfig;
    private ThemeConfig mThemeConfig;
    private IWebEventCallback webEventCallback;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FaceDetectFlowParams f407553a;

        @Override // java.lang.Runnable
        public final void run() {
            new FaceDetectFlow().doFaceLive(this.f407553a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(FaceDetectFlowParams r100) {
            this.f407553a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BytedCertFlowParams f407554a;

        @Override // java.lang.Runnable
        public final void run() {
            new BytedCertFlow().startBytedCertFlow(this.f407554a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(BytedCertFlowParams r100) {
            this.f407554a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BytedCertManager f407556b;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (BytedCertManager.access$100(this.f407556b) == null) goto L9;
            BytedCertManager.access$100(this.f407556b).report(this.f407555a);     // Catch: Throwable -> L6
            return;
        }

        public c(BytedCertManager r100, String r101) {
            this.f407556b = r100;
            this.f407555a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f407557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f407558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BytedCertManager f407559c;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (BytedCertManager.access$100(this.f407559c) == null) goto L9;
            BytedCertManager.access$100(this.f407559c).postEventMessage(this.f407557a, this.f407558b);     // Catch: Throwable -> L6
            return;
        }

        public d(BytedCertManager r100, String r101, String r102) {
            this.f407559c = r100;
            this.f407557a = r101;
            this.f407558b = r102;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f407560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BytedCertManager f407561b;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (BytedCertManager.access$200(this.f407561b) == null) goto L9;
            BytedCertManager.access$200(this.f407561b).report(this.f407560a);     // Catch: Throwable -> L6
            return;
        }

        public e(BytedCertManager r100, int r101) {
            this.f407561b = r100;
            this.f407560a = r101;
        }
    }

    public class f implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f407562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ psa.a f407563b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f407564c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SDKCallBack.CommonRequestCallback f407565d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f407566e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f407567f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f407568g;

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r110) {
            if (r110 != null) goto L4;
        L14:
            if (r110 != null) goto L16;
            r110 = new BDResponse(ErrorConstant.Client.ERROR_UNKNOWN);
        L16:
            this.f407565d.onRequestFinish(r110);
            return;
        L4:
            if (r110.success == false) goto L14;
            JSONObject r100 = r110.jsonData;
            if (r100 == null) goto L14;
            String r101 = r100.optString("ticket");
            if (TextUtils.isEmpty(r101) == true) goto L14;
            Map r111 = this.f407562a;
            if (r111 == null) goto L12;
            r111.put("ticket", r101);
        L12:
            this.f407563b.b(this.f407564c, this.f407565d, this.f407566e, this.f407567f, this.f407568g, this.f407562a);
        }

        public f(Map r100, psa.a r101, Context r102, SDKCallBack.CommonRequestCallback r103, String r104, int r105, boolean r106) {
            this.f407562a = r100;
            this.f407563b = r101;
            this.f407564c = r102;
            this.f407565d = r103;
            this.f407566e = r104;
            this.f407567f = r105;
            this.f407568g = r106;
        }
    }

    public class g implements IDownloadConfig.IDOwnloadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKCallBack.DownloadCallback f407569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BytedCertManager f407570b;

        @Override // com.ss.android.bytedcert.config.IDownloadConfig.IDOwnloadCallback
        public final void checkUpdate(boolean r100) {
            SDKCallBack.DownloadCallback r101 = this.f407569a;
            if (r101 == null) goto L6;
            r101.onFinish(new BDResponse(new CertResponse(!r100)));
            return;
        }

        public g(BytedCertManager r100, SDKCallBack.DownloadCallback r101) {
            this.f407570b = r100;
            this.f407569a = r101;
        }

        @Override // com.ss.android.bytedcert.config.IDownloadConfig.IDOwnloadCallback
        public final void updateResult(boolean r100, Throwable r101) {
            BytedCertManager.access$302(this.f407570b, r100);
        }
    }

    public class h implements IDownloadConfig.IDOwnloadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKCallBack.DownloadCallback f407571a;

        @Override // com.ss.android.bytedcert.config.IDownloadConfig.IDOwnloadCallback
        public final void checkUpdate(boolean r100) {
        }

        public h(SDKCallBack.DownloadCallback r100) {
            this.f407571a = r100;
        }

        @Override // com.ss.android.bytedcert.config.IDownloadConfig.IDOwnloadCallback
        public final void updateResult(boolean r100, Throwable r101) {
            SDKCallBack.DownloadCallback r102 = this.f407571a;
            if (r102 == null) goto L6;
            r102.onFinish(new BDResponse(new CertResponse(r100)));
            return;
        }
    }

    public class i implements IDownloadConfig.IDOwnloadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ICertFlow f407572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SDKCallBack.DownloadCallback f407573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BytedCertManager f407574c;

        @Override // com.ss.android.bytedcert.config.IDownloadConfig.IDOwnloadCallback
        public final void checkUpdate(boolean r100) {
        }

        @Override // com.ss.android.bytedcert.config.IDownloadConfig.IDOwnloadCallback
        public final void updateResult(boolean r100, Throwable r101) {
            BytedCertManager.access$400(this.f407574c, this.f407572a, Boolean.valueOf(r100), r101);
            BDResponse r102 = new BDResponse(new CertResponse(r100));
            if (r101 == null) goto L5;
            r102 = new BDResponse(ErrorConstant.Client.ERROR_UPDATE_MODEL_ERROR);
            r102.detailErrorMsg = r101.getMessage();
        L7:
            SDKCallBack.DownloadCallback r103 = this.f407573b;
            if (r103 == null) goto L10;
            r103.onFinish(r102);
        L10:
            BytedCertManager.access$302(this.f407574c, false);
            return;
        L5:
            if (r100 == true) goto L7;
            r102 = new BDResponse(ErrorConstant.Client.ERROR_UPDATE_NO_MATCH_NEW);
            r102.success = true;
            goto L7
        }

        public i(BytedCertManager r100, ICertFlow r101, SDKCallBack.DownloadCallback r102) {
            this.f407574c = r100;
            this.f407572a = r101;
            this.f407573b = r102;
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BytedCertManager f407575a = null;

        static {
            f407575a = new BytedCertManager(null);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public String getVersionCode() {
        return "4.7.7-rc.13";
    }

    private void injectAdapter() {
        Object r100 = INVOKESTATIC_com_ss_android_bytedcert_manager_BytedCertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(DOWNLOAD_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L6
        if ((r100 instanceof IDownloadConfig) == false) goto L41;
        this.mDownloadConfig = (IDownloadConfig) r100;     // Catch: Exception -> L6
    L41:
        Object r101 = INVOKESTATIC_com_ss_android_bytedcert_manager_BytedCertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(SEC_SDK_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L12
        if ((r101 instanceof ISecSdkConfig) == false) goto L49;
        this.mSecSdkConfig = (ISecSdkConfig) r101;     // Catch: Exception -> L12
    L49:
        Object r102 = INVOKESTATIC_com_ss_android_bytedcert_manager_BytedCertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(GECKO_NETWORK_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L18
        if ((r102 instanceof INetWork) == false) goto L43;
        this.mGeckoNetwork = (INetWork) r102;     // Catch: Exception -> L18
    L43:
        Object r103 = INVOKESTATIC_com_ss_android_bytedcert_manager_BytedCertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(NFC_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L24
        if ((r103 instanceof INfcService) == false) goto L39;
        this.mNfcService = (INfcService) r103;     // Catch: Exception -> L24
    L39:
        Object r104 = INVOKESTATIC_com_ss_android_bytedcert_manager_BytedCertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CN_NET_ID_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L30
        if ((r104 instanceof ICnNetIdService) == false) goto L45;
        this.mCnNetIdService = (ICnNetIdService) r104;     // Catch: Exception -> L30
    L45:
        Object r105 = INVOKESTATIC_com_ss_android_bytedcert_manager_BytedCertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(BADGER_SDK_ADAPTER_CLASS).newInstance();     // Catch: Exception -> L36
        if ((r105 instanceof IBadgerSdkConfig) == false) goto L51;
        this.mBadgerSdkConfig = (IBadgerSdkConfig) r105;     // Catch: Exception -> L36
        return;
    L51:
        return;
    L36:
        e = move-exception;
        e.printStackTrace();
        return;
    L30:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
    L18:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L41
    }

    public CertConfig getCertConfig() {
        CertConfig r100 = this.mCertConfig;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CertConfig.CERT_CONFIG;
    }

    public HashMap<String, String> getGeckoMap() {
        HashMap<String, String> r100 = this.mGeckoMap;
        if (r100 != null) goto L5;
    L8:
        HashMap<String, String> r101 = new HashMap();
        r101.put("appId", "26");
        r101.put("appVersion", "1.0.0");
        r101.put(OperationName.OPERATION_OFFLINE_AVAILABLE, "");
        r101.put("reflection", "");
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        return this.mGeckoMap;
    }

    public ThemeConfig getThemeConfig() {
        ThemeConfig r100 = this.mThemeConfig;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ThemeConfig.THEME_CONFIG;
    }

    static {
        OFFLINE_MODEL_PRE = new String[]{"tt_face_v", "tt_faceverify_v", "tt_stillliveness_v"};
        Flipped.invokeHiddenApiRestrictions();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        CertLog.e("BytedCertManager", "invokeHiddenApiRestrictions failed", th);
    }

    private BytedCertManager() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mFlowMap = new HashMap();
        this.mLastReportTime = 0;
        this.mPickCallbackImp = null;
        this.hasDownload = false;
        injectAdapter();
    }

    public void reportBadger() {
        if (BytedCertSdkManager.getInstance().isReportBadgerEnable() == true) goto L5;
        return;
    L5:
        int r100 = BytedCertSdkManager.getInstance().getReportTimeout();
        if (r100 <= 0) goto L15;
        long r101 = BytedCertSdkManager.getInstance().getReportBadgerInterval() * 1000;
        if (r101 <= 0) goto L13;
        long r102 = System.currentTimeMillis();
        if ((r102 - this.mLastReportTime) >= r101) goto L12;
        return;
    L12:
        this.mLastReportTime = r102;
    L13:
        ThreadPlus.submitRunnable(new e(this, r100));
        return;
    }

    public static BytedCertManager getInstance() {
        return j.f407575a;
    }

    public ICnNetIdService getCnNetIdService() {
        return this.mCnNetIdService;
    }

    public IDownloadConfig getDownloadConfig() {
        return this.mDownloadConfig;
    }

    public Map<String, ICertFlow> getFlowMap() {
        return this.mFlowMap;
    }

    public String getGeckoBusinessVersion() {
        return this.mGeckoBusinessVersion;
    }

    public String getGeckoCustomAccessKey() {
        return this.mGeckoCustomAccessKey;
    }

    public INetWork getGeckoNetwork() {
        return this.mGeckoNetwork;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public INfcService getNfcService() {
        return this.mNfcService;
    }

    public IWebEventCallback getWebEventCallback() {
        return this.webEventCallback;
    }

    public boolean isGeckoBOE() {
        return this.mGeckoBOE;
    }

    public /* synthetic */ BytedCertManager(a r100) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_bytedcert_manager_BytedCertManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ ISecSdkConfig access$100(BytedCertManager r100) {
        return r100.mSecSdkConfig;
    }

    public static /* synthetic */ IBadgerSdkConfig access$200(BytedCertManager r100) {
        return r100.mBadgerSdkConfig;
    }

    public BDResponse checkModelAvailable(HashMap<String, String> r100) {
        if (r100.containsKey(OperationName.OPERATION_OFFLINE_AVAILABLE) == false) goto L7;
        BDResponse r101 = checkModelAvailable(OFFLINE_MODEL_PRE, this.mDownloadConfig.getModelPath(OperationName.OPERATION_OFFLINE_AVAILABLE));
        if (r101 == null) goto L9;
        return r101;
    L9:
        return r101;
    L7:
        return null;
    }

    public void config(CertConfig r100) {
        this.mCertConfig = r100;
    }

    public void doFaceLive(FaceDetectFlowParams r100) {
        executeInMainThread(new a(r100));
    }

    public void executeInMainThread(Runnable r100) {
        Handler r101 = this.mHandler;
        if (r101 == null) goto L6;
        r101.post(r100);
        return;
    }

    public ICertFlow getFlow(String r100) {
        return this.mFlowMap.get(r100);
    }

    public String getModulePath(String r100) {
        return this.mDownloadConfig.getModelPath(r100);
    }

    public void reportSecScene(String r100) {
        ThreadPlus.submitRunnable(new c(this, r100));
    }

    public void setDownloadConfig(IDownloadConfig r100) {
        this.mDownloadConfig = r100;
    }

    public void setExecutorService(ExecutorService r100) {
        BCThread.setExecutorService(r100);
    }

    public void setGeckoBOE(boolean r100) {
        this.mGeckoBOE = r100;
    }

    public void setGeckoBusinessVersion(String r100) {
        this.mGeckoBusinessVersion = r100;
    }

    public void setGeckoCustomAccessKey(String r100) {
        this.mGeckoCustomAccessKey = r100;
    }

    public void setGeckoMap(HashMap<String, String> r100) {
        this.mGeckoMap = r100;
    }

    public void setGeckoNetwork(INetWork r100) {
        this.mGeckoNetwork = r100;
    }

    public void setHost(String r100) {
        UrlConstant.setHost(r100);
        xsa.a.a(r100);
    }

    public void setPickPhotoImp(PhotoCallback.PickCallback r100) {
        this.mPickCallbackImp = r100;
    }

    public void setSecSdkConfig(ISecSdkConfig r100) {
        this.mSecSdkConfig = r100;
    }

    public int setTheme(HashMap<String, Integer> r100) {
        setTheme(new ThemeConfigAdapter(r100));
        return 0;
    }

    public void setWebEventCallback(IWebEventCallback r100) {
        this.webEventCallback = r100;
    }

    public void startBytedCert(BytedCertFlowParams r100) {
        executeInMainThread(new b(r100));
    }

    public void stopFlow(String r100) {
        this.mFlowMap.remove(r100);
    }

    public void setTheme(ThemeConfig r100) {
        this.mThemeConfig = r100;
    }

    public static /* synthetic */ boolean access$302(BytedCertManager r100, boolean r101) {
        r100.hasDownload = r101;
        return r101;
    }

    public BDResponse checkModelAvailable(String[] r110, String r111) {
        String r112 = this.mDownloadConfig.getModelPath(r111);
        if (TextUtils.isEmpty(r112) == false) goto L6;
        BDResponse r113 = new BDResponse(ErrorConstant.Client.ERROR_UPDATE_NO_DOWNLOAD);
        r113.errorMsg = "module path is empty";
        return r113;
    L6:
        PolarisFileWrapper r100 = new PolarisFileWrapper(r112);
        String[] r101 = r100.list();
        if (r100.exists() == false) goto L74;
        if (r101 != null) goto L10;
    L12:
        int r102 = r110.length;
        int r103 = 0;
    L13:
        String r104 = null;
        PolarisFileInputStreamWrapper r105 = null;
        r104 = null;
        if (r103 >= r102) goto L73;
        String r106 = rsa.d.h(r112, r110[r103]);
        if (TextUtils.isEmpty(r106) == true) goto L17;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106 + Global.SUFFIX_TXT_FILE);
        StringBuilder r108 = new StringBuilder();
        if (r107.exists() == true) goto L22;
    L52:
        String r109 = r108.toString();
        if (TextUtils.isEmpty(r109) == true) goto L54;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r106);
        if (r114.isFile() == false) goto L69;
        byte[] r115 = new byte[1024];
        MessageDigest r116 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L66
        PolarisFileInputStreamWrapper r117 = new PolarisFileInputStreamWrapper(r114);     // Catch: Exception -> L66
    L61:
        int r118 = r117.read(r115, 0, 1024);     // Catch: Exception -> L66
        if (r118 == (-1)) goto L64;
        r116.update(r115, 0, r118);     // Catch: Exception -> L66
        goto L61
    L64:
        r117.close();     // Catch: Exception -> L66
        r104 = new BigInteger(1, r116.digest()).toString(16);
    L66:
        e = move-exception;
        e.printStackTrace();
    L69:
        if (TextUtils.equals(r104, r109.trim()) == false) goto L70;
        r103 = r103 + 1;
        goto L13
    L70:
        this.mDownloadConfig.clearCache();
        return new BDResponse(ErrorConstant.Client.ERROR_UPDATE_MODEL_MD5);
    L54:
        this.mDownloadConfig.clearCache();
        return new BDResponse(ErrorConstant.Client.ERROR_UPDATE_MODEL_MD5);
    L22:
        if (r107.isDirectory() == true) goto L52;
        PolarisFileInputStreamWrapper r119 = new PolarisFileInputStreamWrapper(r107);     // Catch: Throwable -> L33 IOException -> L35
    L90:
        BufferedReader r120 = new BufferedReader(new InputStreamReader(r119, "UTF-8"));     // Catch: Throwable -> L29 IOException -> L31
    L25:
        String r121 = r120.readLine();     // Catch: Throwable -> L29 IOException -> L31
        if (r121 == null) goto L86;
        r108.append(r121);     // Catch: Throwable -> L29 IOException -> L31
        r108.append("\n");     // Catch: Throwable -> L29 IOException -> L31
    L86:
        r119.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L31:
        e = e;
    L80:
        CertLog.d("TestFile", e.getMessage());     // Catch: Throwable -> L43
        if (r119 == null) goto L52;
    L43:
        th = th;
        r105 = r119;
    L45:
        r119 = r105;
    L46:
        if (r119 != null) goto L82;
    L51:
        throw th;
    L82:
        r119.close();     // Catch: IOException -> L49
    L49:
        e = move-exception;
        e.printStackTrace();
    L29:
        th = th;
    L35:
        e = e;
        r119 = null;
    L33:
        th = th;
        goto L45
    L17:
        this.mDownloadConfig.clearCache();
        return new BDResponse(ErrorConstant.Client.ERROR_UPDATE_NO_MODEL);
    L73:
        return null;
    L10:
        if (r101.length != 0) goto L12;
    L74:
        BDResponse r122 = new BDResponse(ErrorConstant.Client.ERROR_UPDATE_NO_DOWNLOAD);
        r122.errorMsg = "module path =" + r112 + " no contains file";
        if (r101 != null) goto L77;
    L79:
        return r122;
    L77:
        if (r101.length > 0) goto L79;
        this.mDownloadConfig.clearCache();
        goto L79
    }

    public Intent getOCRIntent(Activity r100, String r101) {
        return new n(new o(r101)).b(r100, false);
    }

    public void postEventMessage(String r100, String r101) {
        ThreadPlus.submitRunnable(new d(this, r100, r101));
    }

    private void onPreloadEvent(ICertFlow r100, Boolean r101, Throwable r102) {
        JSONObject r103 = new JSONObject();
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        if (r100 != null) goto L19;
        EventLogUtils.onEvent(EventConstant.Event.CERT_MODEL_PRELOAD, r103);
        return;
    L19:
        r100.onEvent(EventConstant.Event.CERT_MODEL_PRELOAD, r103);
        return;
    L5:
        if (r101.booleanValue() == false) goto L7;
        r103.put("result", "1");     // Catch: Exception -> L14
    L11:
        if (r102 == null) goto L17;
        r103.put("error_msg", CertLog.getStackTraceString(r102));     // Catch: Exception -> L14
        goto L17
    L7:
        if (r102 == null) goto L9;
        String r104 = "0";
    L10:
        r103.put("result", r104);     // Catch: Exception -> L14
        goto L11
    L9:
        r104 = "2";
        goto L10
    }

    public void checkLoadStatus(Context r100, HashMap<String, String> r101, SDKCallBack.DownloadCallback r102) {
        this.hasDownload = false;
        setGeckoMap(r101);
        this.mDownloadConfig.init(r100, r101);
        BDResponse r103 = checkModelAvailable(r101);
        if (r103 == null) goto L7;
        if (r102 == null) goto L9;
        r102.onFinish(r103);
        return;
    L9:
        return;
    L7:
        this.mDownloadConfig.update(r100, new g(this, r102));
    }

    public void doFaceLive(Context r100, HashMap<String, String> r101, SDKCallBack.FaceLiveCallback r102) {
        doFaceLive(new FaceDetectFlowParams.Builder(r100).setCertInfo(r101).setFaceLiveCallback(r102).build());
    }

    public void keepUriPhoto(Context r100, String r101, Uri r102) {
        this.mImgType = "from_album";
        if (r102 == null) goto L7;
        p.c(r101, rsa.d.d(r100, r102));
        return;
    }

    public void setEnv(UrlConstant.EnvType r100, String r101, String r102) {
        UrlConstant.setEnv(r100, r101, r102);
        xsa.a.a(r101);
    }

    public void startVideoRecord(Activity r100, Map<String, String> r101, SDKCallBack.VideoRecordCallback r102) {
        new BytedCertFlow().startVideoRecord(r100, r101, null, null, r102);
    }

    public static /* synthetic */ void access$400(BytedCertManager r100, ICertFlow r101, Boolean r102, Throwable r103) {
        r100.onPreloadEvent(r101, r102, r103);
    }

    public void checkAndDownloadRes(Context r100, HashMap<String, String> r101, String r102, SDKCallBack.DownloadCallback r103) {
        this.hasDownload = false;
        this.mDownloadConfig.init(r100, r101);
        if (checkModelAvailable(r101) == null) goto L5;
        this.mDownloadConfig.update(r100, new h(r103));
        return;
    L5:
        if (r103 == null) goto L7;
        r103.onFinish(new BDResponse(new CertResponse(true)));
    L7:
        preload(r100, r101, r102, null);
    }

    public void doOfflineFaceLive(Context r100, HashMap<String, String> r101, Bitmap r102, SDKCallBack.FaceLiveCallback r103) {
        doFaceLive(new FaceDetectFlowParams.Builder(r100).setCertInfo(r101).setBitmap(r102).setFaceLiveCallback(r103).build());
    }

    public void preload(Context r100, HashMap<String, String> r101, String r102, SDKCallBack.DownloadCallback r103) {
        ICertFlow r104 = getFlow(r102);
        if (r104 != null) goto L5;
        EventLogUtils.onEvent(EventConstant.Event.CERT_MODEL_PRELOAD_START, new JSONObject());
    L6:
        setGeckoMap(r101);
        if (this.hasDownload == false) goto L12;
        if (r103 == null) goto L10;
        r103.onFinish(new BDResponse(new CertResponse(true)));
    L10:
        this.hasDownload = false;
        return;
    L12:
        this.mDownloadConfig.init(r100, r101);
        this.mDownloadConfig.update(r100, new i(this, r104, r103));
        return;
    L5:
        r104.onEvent(EventConstant.Event.CERT_MODEL_PRELOAD_START, null);
        goto L6
    }

    public JSONObject convertOCRData(Context r100, int r101, String r102, int r103, int r104) {
        String r105 = p.b(r102, r103, r104);     // Catch: Exception -> L9
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L9
        r106.put("status_code", r101);     // Catch: Exception -> L9
        r106.put("message", "");     // Catch: Exception -> L9
        if (r100 == null) goto L5;
        r107.put("camera_valid", SystemInfoTools.isCameraValid(r100));     // Catch: Exception -> L9
    L5:
        if (r101 != 0) goto L7;
        r107.put("image_b64", r105);     // Catch: Exception -> L9
        r107.put("stay_inner_time", this.mImgTimeDelta);     // Catch: Exception -> L9
        r107.put("upload_type", this.mImgType);     // Catch: Exception -> L9
    L7:
        r106.put("data", r107);     // Catch: Exception -> L9
        return r106;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void doOCR(Context r110, String r111, int r112, Map<String, String> r113, SDKCallBack.CommonRequestCallback r114) {
        boolean r100 = BytedCertSdkManager.getInstance().isUpgradeV3();
        if (r113 != null) goto L5;
    L9:
        boolean r101 = r100;
        psa.a r115 = new psa.a(null);
        r115.c(new f(r113, r115, r110, r114, r111, r112, r101), "POST", UrlConstant.getSdkInitPath(r101), r113);
        return;
    L5:
        if (r113.containsKey("use_new_api") == false) goto L9;
        String r102 = r113.get("use_new_api");
        if (r102 == null) goto L9;
        r100 = Boolean.parseBoolean(r102);     // Catch: Exception -> L11
        goto L9
    }

    public void startBytedCert(Context r100, Map<String, String> r101, IWebEventCallback r102, CertResultCallback r103, H5CallBack r104) {
        startBytedCert(new BytedCertFlowParams.Builder(r100).setCertInfo(r101).setWebEventCallback(r102).setCertResultCallback(r103).setH5CallBack(r104).build());
    }

    public Intent getOCRIntent(Activity r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, boolean r110) {
        o r108 = new o(r101);
        r108.f534715c = r102;
        r108.f534716d = r103;
        r108.f534717e = r104;
        r108.f534718f = r105;
        r108.f534719g = r106;
        r108.f534720h = r107;
        r108.f534721i = r110;
        return new n(r108).b(r100, true);
    }
}
