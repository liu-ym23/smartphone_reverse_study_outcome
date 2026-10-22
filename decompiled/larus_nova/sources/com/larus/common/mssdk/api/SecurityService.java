package com.larus.common.mssdk.api;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.gson.JsonObject;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 R2\u00020\u0001:\u0002RSJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b2\u0006\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0001H&J \u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H&J\b\u0010\"\u001a\u00020\u0013H&J\b\u0010#\u001a\u00020\tH&J\u001e\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(H&J\b\u0010)\u001a\u00020\u0013H&J\u001a\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u0013H&J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tH&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000203H&J\u0010\u00104\u001a\u00020\u00032\u0006\u00102\u001a\u000203H&J\b\u00105\u001a\u00020\u0003H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010.\u001a\u000206H&J\b\u00107\u001a\u00020\u0003H&J\b\u00108\u001a\u00020\u0013H&J\b\u00109\u001a\u00020:H&J\b\u0010;\u001a\u00020\u0013H&J\u0014\u0010<\u001a\u0004\u0018\u00010\t2\b\u0010=\u001a\u0004\u0018\u00010\tH&J\u0012\u0010>\u001a\u00020\u00132\b\u0010=\u001a\u0004\u0018\u00010\tH&J*\u0010?\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010AH&J\b\u0010B\u001a\u00020\u0013H&J\b\u0010C\u001a\u00020\u0003H&J\b\u0010D\u001a\u00020\u0013H&J\u0010\u0010E\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\tH&J\b\u0010F\u001a\u00020\tH&J3\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\t2!\u0010I\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u00030JH&J\u0010\u0010N\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\tH&J\u0010\u0010O\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\tH&¨\u0006T"}, d2 = {"Lcom/larus/common/mssdk/api/SecurityService;", "", "msInit", "", "appContext", "Landroid/content/Context;", "msReport", PerfLog.PARAM_KEY_CONTEXT_ID, "scene", "", "msFrameSign", "", "rawStr", "initBdInstall", "getAdIdWaitTime", "", "createBdInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "interceptApiCallRequest", "", "apiCallInfo", "logApiCallRequestOnline", "mobPermissionRequest", "page", ComplianceResult.JsonKey.PERMISSIONS, "", "initAppOpsConfig", "tryCheckAppOpsByApiID", "apiID", "", "initAOPEnvironment", "initPreinstallSdk", "application", "Landroid/app/Application;", "isPreinstallApp", "getPreinstallChannel", "checkNetPermission", "fm", "Landroidx/fragment/app/FragmentManager;", "doNext", "Lkotlin/Function0;", "isBasicMode", "setBasicMode", "isBasic", "restartApp", "showBasicModeExitDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "targetUrl", "registerBasicModeListener", "basicModeListener", "Lcom/larus/common/mssdk/api/SecurityService$BasicModeListener;", "unRegisterModeListener", "killCurrentProcess", "Landroid/app/Activity;", "reportPreInstallChannel", "enableTimonLocalInit", "getTimonLocalConfig", "Lcom/google/gson/JsonObject;", "enableTTNetEncrypt", "getTTNetEncryptScene", "requestUrl", "shouldAddTTNetEncryptHeader", "tryMobTTNetEncryptResult", "responseHeaders", "", "forceTTNetRetry", "initTTNetAudit", "enableTTNetAuditMock", "shouldAddTTNetAuditMockHeader", "getTTNetAuditMockHeader", "checkAndFixAIGCMetaDataByPathAsync", "filePath", "completeCB", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "checkAndFixAIGCMetaDataByPathSync", "markMetadataCheckScene", "markMetadataDownloadUrl", "url", "Companion", "BasicModeListener", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SecurityService {

    /* JADX INFO: loaded from: classes27.dex */
    public interface a {
        void onChange();
    }

    boolean A();

    void B();

    void C(String r100, String r101, List<Object> r102);

    boolean D();

    void E();

    t74.a F();

    boolean G(String r100);

    void a();

    boolean b(kz5.a r100);

    void c(String r100, Function1<? super Boolean, Unit> r101);

    void d(Application r100);

    void e(Context r100);

    boolean enableTimonLocalInit();

    boolean f(String r100);

    void g(List r100);

    void h();

    String i();

    boolean isBasicMode();

    boolean j();

    void k(FragmentActivity r100);

    JsonObject l();

    void m(Context r100);

    void n(int r100);

    void o();

    void p();

    String q(String r100);

    void r(Context r100);

    void s(kz5.a r100);

    void t(boolean r100, boolean r101);

    boolean u();

    Map<String, String> v(String r100);

    void w(String r100);

    void x(FragmentManager r100, Function0<Unit> r101);

    void y(String r100);

    boolean z(String r100);
}
