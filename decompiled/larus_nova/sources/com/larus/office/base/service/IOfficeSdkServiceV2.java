package com.larus.office.base.service;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.platform.api.q4;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J&\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u001a\u001a\u00020\u0006H&J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bH&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\bH&J\b\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH&J6\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010\u00142\b\u0010*\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010\bH¦@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u000201H&J&\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\b2\u0014\u00104\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000305H&J\b\u00106\u001a\u00020\bH&J\b\u00107\u001a\u00020\bH&J\b\u00108\u001a\u00020\u0003H\u0016J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\bH&¨\u0006;"}, d2 = {"Lcom/larus/office/base/service/IOfficeSdkServiceV2;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "preloadWebViewIfNeeded", "", "ensureOfficeSdkInitialized", "forceInitDoc", "", "source", "", "forceInitOfficeSdk", "getOfficeSdkInitState", "Lcom/larus/platform/api/OfficeSdkInitState;", "onLarkSocialInitializationChanged", "shouldInitialize", "getCcmService", "Lcom/bytedance/ee/bear/office/export/IOfficeCCMService;", "ensureSharePanelProviderInjected", "awaitDocsSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDocsSdkReady", "awaitMinutesSdk", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/IMmRecordingCapacity;", "getDocsSdk", "isDocsSdkReady", "isFeishuAppLink", "url", "isOfficeSuiteUrl", "openFeishuAppLink", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "openOfficeSuiteUrl", "isFeishuHost", "updateCookieFirst", "startInjectAuthCookie", "stopInjectAuthCookie", "clearAuthCookie", "registerPermissionApply", "token", "type", "messageId", "conversationId", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createOrUpdatePermissionFragment", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "arguments", "Landroid/os/Bundle;", "getWatermarkImage", "originPath", "callback", "Lkotlin/Function1;", "getImageCachePath", "getImageRealCachePath", "registerChameleonDiskUsageHandler", "prewarmMiaoda", "appId", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOfficeSdkServiceV2 extends ISdkLifecycleV2 {

    /* JADX INFO: loaded from: classes29.dex */
    public static final class a {
        public static /* synthetic */ Object a(IOfficeSdkServiceV2 r100, Continuation r101) {
            return r100.o0(15000, r101);
        }

        public static /* synthetic */ void b(IOfficeSdkServiceV2 r100, boolean r101, String r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = "unknown";
        L8:
            r100.s0(r101, r102, false);
        }
    }

    boolean A0(String r100);

    void B0(String r100);

    ik5.a c0();

    boolean d0(String r100);

    void e0();

    boolean f0();

    void g0(Context r100, String r101);

    Object h0(long r100, Continuation<? super hub.a> r101);

    void i0();

    void j0(String r100);

    Object k0(String r100, Long r101, String r102, String r103, Continuation<? super Unit> r104);

    boolean l0(String r100);

    void m0(String r100);

    Object n0(long r100, Continuation<? super Boolean> r101);

    Object o0(long r100, Continuation<? super ik5.a> r101);

    void p0(String r100, uo9.h r101);

    gk5.e q0();

    void r0();

    void s0(boolean r100, String r101, boolean r102);

    Fragment t0(Fragment r100, Bundle r101);

    void u0(String r100);

    void v0(String r100);

    void w0();

    String x0();

    void y0(boolean r100);

    q4 z0();
}
