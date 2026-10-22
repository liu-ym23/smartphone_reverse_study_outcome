package n2a;

import android.webkit.CookieManager;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.settings.value.e10;
import com.larus.settings.value.ge;
import com.larus.settings.value.q4;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.sdk.r;
import com.obric.assistant.common.spi.IObricEnvService;
import com.obric.assistant.spi.launch.ObricLazyInitSettingsServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.DataLoaderListener;
import com.ss.ttvideoengine.LibraryLoaderProxy;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.download.Downloader;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qt9.l4;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f516801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f516802b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f516803c;

    public static final class a implements DataLoaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f516804a = null;

        static {
            f516804a = new a();
        }

        public a() {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final String apiStringForFetchVideoModel(Map<String, String> r100, String r101, Resolution r102) {
            return "";
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final String authStringForFetchVideoModel(String r100, Resolution r101) {
            return "";
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final String getCheckSumInfo(String r100) {
            return "";
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final boolean loadLibrary(String r100) {
            return false;
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress r100) {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final /* synthetic */ void onMultiNetworkSwitch(String r100, String r101) {
            DataLoaderListener.CC.$default$onMultiNetworkSwitch(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void onNotify(int r100, long r101, long r102, String r103) {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void onNotifyCDNLog(DataLoaderCDNLog r100) {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void onNotifyCDNLog(JSONObject r100) {
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final /* synthetic */ void onStartComplete() {
            DataLoaderListener.CC.$default$onStartComplete(this);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final HashMap<String, String> getCustomHttpHeaders(String r100) {
            String r101 = CookieManager.getInstance().getCookie(r100);
            Pair[] r102 = new Pair[2];
            r102[0] = new Pair("Cookie", r101);
            String r103 = AccountService.f365697a.getXTTToken();
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            r102[1] = new Pair(LoginVerifyService.X_TT_TOKEN, r103);
            return MapsKt.hashMapOf(r102);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo r100) {
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("onTaskProgress type is ");
            if (r100 == null) goto L5;
            int r103 = r100.mTaskType;
        L6:
            r102.append(r103);
            r101.d("dataLoader", r102.toString());
            return;
        L5:
            r103 = -1;
            goto L6
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void dataLoaderError(String r100, int r101, Error r102) {
            FLogger.f375446a.e("dataLoader", "dataLoaderError: videoId = " + r100 + " , errorType = " + r101 + " error = " + r102);
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void onLogInfo(int r100, String r101, JSONObject r102) {
            FLogger.f375446a.d("dataLoader", "onLogInfo:what = " + r100 + " logType = " + r101 + " log = " + r102);
            if (r101 == null) goto L7;
            if (r102 == null) goto L8;
            IApplog.f287053a.onMiscEvent(r101, r102);
            return;
        L8:
            return;
        }

        @Override // com.ss.ttvideoengine.DataLoaderListener
        public final void onLogInfoToMonitor(int r100, String r101, JSONObject r102) {
            if (r101 == null) goto L6;
            if (r102 == null) goto L7;
            IApplog.f287053a.onMiscEvent(r101, r102);
            return;
        L7:
            return;
        }
    }

    public static final class b implements LibraryLoaderProxy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f516805a = null;

        static {
            f516805a = new b();
        }

        public b() {
        }

        @JvmStatic
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            com.bytedance.librarian.a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }

        @Override // com.ss.ttvideoengine.LibraryLoaderProxy
        public final boolean loadLibrary(String r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L21;
            return false;
        L21:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
            a(r100);     // Catch: Throwable -> L13
            Object r103 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L13
        L15:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L20;
            FLogger.f375446a.e("InitTTVideoEngineTask", "load mdl library failed, name=" + r100, r104);
            r103 = Boolean.FALSE;
        L20:
            return ((Boolean) r103).booleanValue();
        L13:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    public c() {
    }

    static {
        f516801a = new c();
        f516802b = new Object();
    }

    public static void a() {
        if (ObricLazyInitSettingsServiceDelegate.f392888a.b() == true) goto L7;
        b();
        return;
    L7:
        if (f516803c == false) goto L9;
        return;
    L9:
        Object r100 = f516802b;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (f516803c == false) goto L15;
        monitor-exit(r100);
        return;
    L15:
        f516801a.getClass();     // Catch: Throwable -> L18
        b();     // Catch: Throwable -> L18
        f516803c = true;     // Catch: Throwable -> L18
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r100);
    }

    public static void b() {
        StringBuilder r100 = new StringBuilder();
        AppHost.Companion r101 = AppHost.f326268a;
        r100.append(r101.getApplication().getCacheDir().getAbsolutePath());
        r100.append("/videoCache");
        TTVideoEngine.setStringValue(0, r100.toString());
        TTVideoEngine.setStringValue(111, r101.getApplication().getCacheDir().getAbsolutePath() + "/videoDownload");
        HashMap r102 = new HashMap();
        r102.put("appid", Integer.valueOf(r101.getAppId()));
        r102.put("appname", r101.getAppName());
        r102.put("appchannel", r101.getBuildChannel());
        r102.put("appversion", r101.getVersionName());
        r102.put("deviceid", o.f365780a.getDeviceId());
        TTVideoEngine.setAppInfo(r101.getApplication(), r102);
        TTVideoEngine.setIntValue(1, AVMDLDataLoaderConfigure.DEFAULT_MAX_CACHE_SIZE);
        TTVideoEngine.setDataLoaderListener(a.f516804a);
        TTVideoEngine.setIntValue(105, 0);
        TTVideoEngine.setIntValue(103, 0);
        TTVideoEngine.setIntValue(104, 0);
        DataLoaderHelper.getDataLoader().setBackUpIP("v3-tt.ixigua.com", "8.8.8.8,8.8.8.8");
        TTVideoEngine.setIntValue(106, 0);
        TTVideoEngine.setIntValue(1117, 1);
        TTVideoEngine.setIntValue(1501, 1);
        TTVideoEngine.setStringValue(108, "dns.google.com");
        TTVideoEngine.setStringValue(107, "34.102.215.99");
        TTVideoEngine.setTTDNSServerHost("34.102.215.99");
        TTVideoEngine.enableNewMDLFetcher(true);
        e10 r103 = e10.f368561a;
        int r104 = l0.f375430a;
        boolean r105 = ((Boolean) l0.a(Boolean.FALSE, new ge())).booleanValue();
        TTVideoEngine.setIntValue(1154, r105 ? 1 : 0);
        if (r105 == false) goto L5;
        TTVideoEngine.setIntValue(DataLoaderHelper.DATALOADER_KEY_INT_ENABLE_LIBMANAGER, 1);
        DataLoaderHelper.getDataLoader().setLoadProxy(b.f516805a);
    L5:
        FLogger.f375446a.i("InitTTVideoEngineTask", "configMdlVersion enableMdl2=" + r105);
        e10 r106 = e10.f368561a;
        if (Intrinsics.areEqual(((l4) l0.a(new l4(0), new q4())).a(), Boolean.TRUE) == false) goto L11;
        TTVideoEngine.setIntValue(472, 1);
        IObricEnvService r107 = (IObricEnvService) ServiceManager.get().getService(IObricEnvService.class);
        if (r107 == null) goto L10;
        r107.a(new n2a.a());
    L10:
        TTVideoEngineLog.setListener(new n2a.b());
    L11:
        VideoEventManager.instance.setListener(d.f516806a);
        TTVideoEngine.startDataLoader(r101.getApplication());     // Catch: Throwable -> L22
    L23:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L15
        Downloader.getInstance().setMaxDownloadOperationCount(1);     // Catch: Throwable -> L15
        Downloader.getInstance().setLimitFreeDiskSize(1073741824);     // Catch: Throwable -> L15
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L20;
        FLogger.f375446a.e("InitTTVideoEngineTask", "Downloader config failed", r110);
    L20:
        TTNetWorkListener.getInstance().setIntValue(1, 100);
        TTNetWorkListener.getInstance().setIntValue(2, 5000);
        TTVideoEngine.setReportLogByEngine(true, AppHost.f326268a.getApplication());
        TTVideoEngine.addEngineStateListener(r.f375924a);
        FLogger.f375446a.i("BackgroundLazyInit", "TTVideoEngine init completed");
        return;
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
