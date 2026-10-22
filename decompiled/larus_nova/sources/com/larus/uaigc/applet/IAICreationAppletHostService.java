package com.larus.uaigc.applet;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.platform.api.creation.UserCreation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ny8.e;
import ny9.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 >2\u00020\u0001:\u0001>J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u000eH&J\"\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0005H&J\"\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0005H&J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H&J\u0012\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020!H&J\"\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010#H&J\u0012\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H&J\b\u0010&\u001a\u00020\u0003H&J.\u0010'\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)H&J8\u0010,\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000300H&J$\u00101\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000300H&J\b\u00102\u001a\u00020\u0005H&J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020!H&J\u001a\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010)H&J \u00107\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00108\u001a\u00020)2\u0006\u0010+\u001a\u00020)H&J\u0012\u00109\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010;H&J\u0012\u0010<\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010\u0014H&¨\u0006?"}, d2 = {"Lcom/larus/uaigc/applet/IAICreationAppletHostService;", "", "prewarmCreatePageApplet", "", "shouldOpenFromBottomTab", "", "openCreatePage", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "allowNativeFallback", "createCreatePageIntent", "Landroid/content/Intent;", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "openCanvasPage", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "createCanvasPageIntent", "openDetailPage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WsConstants.KEY_PAYLOAD, "Landroid/os/Bundle;", "asRoot", "openImageRemovePage", "openProfilePage", "openNativeMineProfilePage", "notifyPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "shouldRouteResultToChatAfterApplet", "getNativeRouteContextBelowApplet", "currentContext", "navigateBack", "delta", "", "onRouteFailure", "Lkotlin/Function0;", "closeApplet", "clearAICreationHomeMemory", "clearAICreationHomeMemoryForNextOpen", "openHomeFromDoubaoAppsSchemaIfNeeded", "appId", "", "pageUrl", "routeMode", "routeNativeBelowApplet", "closeDelayMs", "", "routeAction", "Lkotlin/Function1;", "routeNativeBelowAppletAndMoveToBack", "finishNativeHostBelowApplet", "setEmptyResultAndFinishCamera", "resultCode", "completeCameraCreationMessageSent", "conversationId", "openPreparedAppletUrl", "url", "isAICreationAppletActivity", "activity", "Landroid/app/Activity;", "isFromAICreationApplet", "args", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAICreationAppletHostService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f370273a = null;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000bH\u0096\u0001J!\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000b2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!H\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0019\u0010&\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007H\u0096\u0001J!\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0007H\u0096\u0001J/\u0010-\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u00162\u0006\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\r2\b\u00100\u001a\u0004\u0018\u00010\rH\u0096\u0001J!\u00101\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0007H\u0096\u0001J\u0011\u00102\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0016H\u0096\u0001J!\u00103\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00162\u0006\u00104\u001a\u00020\r2\u0006\u00100\u001a\u00020\rH\u0096\u0001J\u0019\u00105\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u001dH\u0096\u0001J\t\u00106\u001a\u00020\u0005H\u0096\u0001J5\u00107\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050;H\u0096\u0001J%\u0010<\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00162\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050;H\u0096\u0001J\u0011\u0010=\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010>\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010?\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020'H\u0096\u0001¨\u0006@"}, d2 = {"Lcom/larus/uaigc/applet/IAICreationAppletHostService$Companion;", "Lcom/larus/uaigc/applet/IAICreationAppletHostService;", "<init>", "()V", "clearAICreationHomeMemoryForNextOpen", "", "closeApplet", "", "clearAICreationHomeMemory", "completeCameraCreationMessageSent", "resultCode", "", "conversationId", "", "createCanvasPageIntent", "Landroid/content/Intent;", "config", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "createCreatePageIntent", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "finishNativeHostBelowApplet", "getNativeRouteContextBelowApplet", "Landroid/content/Context;", "currentContext", "isAICreationAppletActivity", "activity", "Landroid/app/Activity;", "isFromAICreationApplet", "args", "Landroid/os/Bundle;", "navigateBack", "delta", "onRouteFailure", "Lkotlin/Function0;", "notifyPublishSuccess", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "openCanvasPage", "openCreatePage", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "allowNativeFallback", "openDetailPage", PerfLog.PARAM_KEY_CONTEXT_ID, WsConstants.KEY_PAYLOAD, "asRoot", "openHomeFromDoubaoAppsSchemaIfNeeded", "appId", "pageUrl", "routeMode", "openImageRemovePage", "openNativeMineProfilePage", "openPreparedAppletUrl", "url", "openProfilePage", "prewarmCreatePageApplet", "routeNativeBelowApplet", "closeDelayMs", "", "routeAction", "Lkotlin/Function1;", "routeNativeBelowAppletAndMoveToBack", "setEmptyResultAndFinishCamera", "shouldOpenFromBottomTab", "shouldRouteResultToChatAfterApplet", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAICreationAppletHostService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f370274c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAICreationAppletHostService f370275b;

        static {
            f370274c = new Companion();
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            return this.f370275b.a(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean b(String r100) {
            return this.f370275b.b(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final void c() {
            this.f370275b.c();
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final void d() {
            this.f370275b.d();
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean e(c r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            return this.f370275b.e(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean f(c r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            return this.f370275b.f(r100, r101);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final void g(UserCreation r100) {
            Intrinsics.checkNotNullParameter(r100, "userCreation");
            this.f370275b.g(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean h(int r100) {
            return this.f370275b.h(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean i(boolean r100) {
            return this.f370275b.i(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean j() {
            return this.f370275b.j();
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean k(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f370275b.k(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean l(Context r100, Function1<? super Context, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "routeAction");
            return this.f370275b.l(r100, r101);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean m(Context r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
            return this.f370275b.m(r100, r101);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean n(int r100, Function0<Unit> r101) {
            return this.f370275b.n(r100, r101);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean o(Context r100, Bundle r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
            return this.f370275b.o(r100, r101, r102);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean p(Context r100, boolean r101, long r110, Function1<? super Context, Unit> r111) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "routeAction");
            return this.f370275b.p(r100, r101, r110, r111);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean q() {
            return this.f370275b.q();
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean r(Context r100, Bundle r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
            return this.f370275b.r(r100, r101, r102);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean s(FragmentActivity r100) {
            return this.f370275b.s(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean t(Bundle r100) {
            return this.f370275b.t(r100);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final boolean u(Context r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "appId");
            return this.f370275b.u(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletHostService
        public final Context v(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "currentContext");
            return this.f370275b.v(r100);
        }

        private Companion() {
            IAICreationAppletHostService r100 = (IAICreationAppletHostService) ServiceManager.get().getService(IAICreationAppletHostService.class);
            if (r100 != null) goto L5;
            r100 = new IAICreationAppletHostServiceNoop();
        L5:
            this.f370275b = r100;
        }
    }

    static {
        f370273a = Companion.f370274c;
    }

    boolean a(e r100);

    boolean b(String r100);

    void c();

    void d();

    boolean e(c r100);

    boolean f(c r100, boolean r101);

    void g(UserCreation r100);

    boolean h(int r100);

    boolean i(boolean r100);

    boolean j();

    boolean k(Context r100);

    boolean l(Context r100, Function1<? super Context, Unit> r101);

    boolean m(Context r100, Bundle r101);

    boolean n(int r100, Function0<Unit> r101);

    boolean o(Context r100, Bundle r101, boolean r102);

    boolean p(Context r100, boolean r101, long r102, Function1<? super Context, Unit> r103);

    boolean q();

    boolean r(Context r100, Bundle r101, boolean r102);

    boolean s(FragmentActivity r100);

    boolean t(Bundle r100);

    boolean u(Context r100, String r101, String r102, String r103);

    Context v(Context r100);
}
