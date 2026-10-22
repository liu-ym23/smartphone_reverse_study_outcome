package com.larus.home.api.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.autofill.HintConstants;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.home.impl.MainActivity;
import com.larus.voice_setting.voice.base.MainTabFragmentAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import gb9.b;
import hb9.a;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\nH\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\nH\u0016J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0002\u00100J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0016J\u0014\u00103\u001a\u0004\u0018\u00010$2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0018\u00106\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0016J\b\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u00020$H\u0016J\b\u00109\u001a\u00020$H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010>\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010@2\u0006\u0010D\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020,H\u0016J\b\u0010F\u001a\u00020,H\u0016J\b\u0010G\u001a\u00020,H\u0016J\b\u0010H\u001a\u00020\nH\u0016J\u0010\u0010I\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010J\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020,H\u0016J\u0010\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0016H\u0016J\b\u0010N\u001a\u00020,H\u0016J\b\u0010O\u001a\u00020$H\u0016J\u001f\u0010P\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010T\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020,H\u0016J\u0012\u0010W\u001a\u00020,2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u001a\u0010Z\u001a\u00020\n2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020\\H\u0016J\u001c\u0010]\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0018\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020$2\u0006\u0010b\u001a\u00020cH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006d"}, d2 = {"Lcom/larus/home/api/main/HomeService;", "Lcom/larus/home/api/main/IHomeApi;", "<init>", "()V", "iHomeApi", "getIHomeApi", "()Lcom/larus/home/api/main/IHomeApi;", "iHomeApi$delegate", "Lkotlin/Lazy;", "setMainTabViewGenerator", "", "preloadMainTabView", "initAppStartTime", "initAppRealInitTime", "getAppRealInitTime", "", "()Ljava/lang/Long;", "recordAppAttachEnd", "recordAppOnCreate", "startMillis", "reportAppFeedShow", "data", "Lorg/json/JSONObject;", "asyncReportPrivacyPoliceShow", "duration", "tryReportPrivacyDialogShow", "applicationAttachBeforeSuper", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "applicationAttachAfterSuper", "applicationCreateBeforeSuper", "application", "Landroid/app/Application;", "applicationCreateAfterSuper", "initSystemLoadLibraryHook", "versionName", "", "checkMiddleTabLottieAndDownloadIfNecessary", "initUpdateClientStateManager", "registerUpdateRedDotManagerListener", "initPadController", "initPreloadMessages", "setDecorViewLancetEnable", "enable", "", "initBottomTabConfig", "getCurrentAppIconId", "", "(Landroid/content/Context;)Ljava/lang/Integer;", "getAvailableIcons", "", "getAppIconClickEventId", "appIconsType", "Lcom/larus/home/api/main/AppIconsType;", "changeAppIcon", "setIsFromLogin", "getChatActivityClassName", "getObricChatActivityClassName", "findEnabledActivity", "getBottomTabConfigManager", "Lcom/larus/home/api/main/model/IBottomTabConfigManager;", "reportAppPrivacyPoliceDismissToLoginShow", "tryUpdateLauncherActivity", "getChatFragment", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "topActivity", "Landroid/app/Activity;", "getSelectedChatFragment", "activity", "enableSideBar", "isSideBarVisible", "isFlowNativeBotChatVisible", "clearPreloadMessage", "savePrivacyWindowShow", "savePrivacyWindowClick", "accept", "recordPrivacyPoliceShow", "jsonParams", "isPad", "getPrivacyWebViewActivityClassName", "enableLauncherIcon", "currentSelectAppIconId", "(Landroid/content/Context;Ljava/lang/Integer;)V", "disableLauncherIcon", "recoverLauncherIcon", "setHotLaunchEnabled", "enabled", "hasAddPageMineTabFragment", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "mainTabOnAction", "action", "Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "redirectNeedLoginStrictModeRouter", "uri", "Landroid/net/Uri;", "openPhoneNumberPanel", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeService implements IHomeApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HomeService f344094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f344095b = null;

    private HomeService() {
    }

    static {
        f344094a = new HomeService();
        f344095b = LazyKt.lazy(new b());
    }

    public static IHomeApi b() {
        return (IHomeApi) f344095b.getValue();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void B() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.B();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void D() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.D();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void E() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.E();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String F() {
        IHomeApi r100 = b();
        if (r100 == null) goto L5;
        String r101 = r100.F();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void G() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.G();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Long J() {
        IHomeApi r100 = b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.J();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void K() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.K();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void N() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.N();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String P() {
        IHomeApi r100 = b();
        if (r100 == null) goto L5;
        String r101 = r100.P();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void S() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.S();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void T() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.T();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void U() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.U();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void X() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.X();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final a d0() {
        IHomeApi r100 = b();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d0();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void e0() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.e0();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void g0() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.g0();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean isPad() {
        IHomeApi r100 = b();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPad();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean m() {
        IHomeApi r100 = b();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.m();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean n() {
        IHomeApi r100 = b();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.n();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean o() {
        IHomeApi r100 = b();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.o();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String r() {
        IHomeApi r100 = b();
        if (r100 == null) goto L5;
        String r101 = r100.r();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Map<Integer, Integer> s() {
        IHomeApi r100 = b();
        if (r100 == null) goto L5;
        Map<Integer, Integer> r101 = r100.s();
    L6:
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void u() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.u();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void y() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.y();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void z() {
        IHomeApi r100 = b();
        if (r100 == null) goto L6;
        r100.z();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String A(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r101 = b();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.A(r100);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void C(boolean r100) {
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.C(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Integer H(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r101 = b();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.H(r100);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void I(long r100) {
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.I(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void L(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.L(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void M(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.M(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.Q(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void R(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("15.2.0.1", "versionName");
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.R(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void V(boolean r100) {
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.V(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final xe8.a a(Activity r100) {
        IHomeApi r101 = b();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void a0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.a0(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void c0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.c0(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void f0(MainActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.f0(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void p(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.p(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String q(AppIconsType r100) {
        IHomeApi r101 = b();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.q(r100);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void t(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.t(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final xe8.a v(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        IHomeApi r101 = b();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.v(r100);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void x(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonParams");
        IHomeApi r101 = b();
        if (r101 == null) goto L6;
        r101.x(r100);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void O(Fragment r100, MainTabFragmentAction r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        IHomeApi r102 = b();
        if (r102 == null) goto L6;
        r102.O(r100, r101);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void W(Context r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r102 = b();
        if (r102 == null) goto L6;
        r102.W(r100, r101);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Y(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IHomeApi r102 = b();
        if (r102 == null) goto L6;
        r102.Y(r100, r101);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Z(Context r100, Uri r101) {
        IHomeApi r102 = b();
        if (r102 == null) goto L6;
        r102.Z(r100, r101);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void b0(String r100, FragmentManager r101) {
        Intrinsics.checkNotNullParameter(r100, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        IHomeApi r102 = b();
        if (r102 == null) goto L6;
        r102.b0(r100, r101);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void w(Context r100, AppIconsType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appIconsType");
        IHomeApi r102 = b();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }
}
