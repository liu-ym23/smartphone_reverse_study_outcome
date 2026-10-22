package com.larus.home.api.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.util.EventsUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.home.impl.MainActivity;
import com.larus.voice_setting.voice.base.MainTabFragmentAction;
import com.volcengine.zeus.provider.ContentProviderManager;
import gb9.b;
import hb9.a;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\nH\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\nH\u0016J\u0017\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0002\u00100J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0016J\u0014\u00103\u001a\u0004\u0018\u00010$2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0018\u00106\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0016J\b\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u00020$H\u0016J\b\u00109\u001a\u00020$H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010$2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010>\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010@2\u0006\u0010D\u001a\u00020BH\u0016J\b\u0010E\u001a\u00020,H\u0016J\b\u0010F\u001a\u00020,H\u0016J\b\u0010G\u001a\u00020,H\u0016J\b\u0010H\u001a\u00020\nH\u0016J\u0010\u0010I\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010J\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020,H\u0016J\u0010\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0016H\u0016J\b\u0010N\u001a\u00020,H\u0016J\b\u0010O\u001a\u00020$H\u0016J\u001f\u0010P\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010T\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020,H\u0016J\u0012\u0010W\u001a\u00020,2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u001a\u0010Z\u001a\u00020\n2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020\\H\u0016J\u001c\u0010]\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0018\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020$2\u0006\u0010b\u001a\u00020cH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006d"}, d2 = {"Lcom/larus/home/api/main/HomeService;", "Lcom/larus/home/api/main/IHomeApi;", "<init>", "()V", "iHomeApi", "getIHomeApi", "()Lcom/larus/home/api/main/IHomeApi;", "iHomeApi$delegate", "Lkotlin/Lazy;", "setMainTabViewGenerator", XmlPullParser.NO_NAMESPACE, "preloadMainTabView", "initAppStartTime", "initAppRealInitTime", "getAppRealInitTime", XmlPullParser.NO_NAMESPACE, "()Ljava/lang/Long;", "recordAppAttachEnd", "recordAppOnCreate", "startMillis", "reportAppFeedShow", "data", "Lorg/json/JSONObject;", "asyncReportPrivacyPoliceShow", "duration", "tryReportPrivacyDialogShow", "applicationAttachBeforeSuper", "context", "Landroid/content/Context;", "applicationAttachAfterSuper", "applicationCreateBeforeSuper", "application", "Landroid/app/Application;", "applicationCreateAfterSuper", "initSystemLoadLibraryHook", "versionName", XmlPullParser.NO_NAMESPACE, "checkMiddleTabLottieAndDownloadIfNecessary", "initUpdateClientStateManager", "registerUpdateRedDotManagerListener", "initPadController", "initPreloadMessages", "setDecorViewLancetEnable", "enable", XmlPullParser.NO_NAMESPACE, "initBottomTabConfig", "getCurrentAppIconId", XmlPullParser.NO_NAMESPACE, "(Landroid/content/Context;)Ljava/lang/Integer;", "getAvailableIcons", XmlPullParser.NO_NAMESPACE, "getAppIconClickEventId", "appIconsType", "Lcom/larus/home/api/main/AppIconsType;", "changeAppIcon", "setIsFromLogin", "getChatActivityClassName", "getObricChatActivityClassName", "findEnabledActivity", "getBottomTabConfigManager", "Lcom/larus/home/api/main/model/IBottomTabConfigManager;", "reportAppPrivacyPoliceDismissToLoginShow", "tryUpdateLauncherActivity", "getChatFragment", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "topActivity", "Landroid/app/Activity;", "getSelectedChatFragment", "activity", "enableSideBar", "isSideBarVisible", "isFlowNativeBotChatVisible", "clearPreloadMessage", "savePrivacyWindowShow", "savePrivacyWindowClick", "accept", "recordPrivacyPoliceShow", "jsonParams", "isPad", "getPrivacyWebViewActivityClassName", "enableLauncherIcon", "currentSelectAppIconId", "(Landroid/content/Context;Ljava/lang/Integer;)V", "disableLauncherIcon", "recoverLauncherIcon", "setHotLaunchEnabled", "enabled", "hasAddPageMineTabFragment", "fragment", "Landroidx/fragment/app/Fragment;", "mainTabOnAction", "action", "Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "redirectNeedLoginStrictModeRouter", ContentProviderManager.PROVIDER_URI, "Landroid/net/Uri;", "openPhoneNumberPanel", "phoneNumber", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class HomeService implements IHomeApi {
    public static final HomeService a = null;
    public static final Lazy b = null;

    private HomeService() {
    }

    static {
        a = new HomeService();
        b = LazyKt.lazy(new b());
    }

    public static IHomeApi b() {
        return (IHomeApi) b.getValue();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void B() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.B();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void D() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.D();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void E() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.E();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String F() {
        IHomeApi r0 = b();
        if (r0 == null) goto L5;
        String r1 = r0.F();
    L6:
        if (r1 != null) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void G() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.G();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Long J() {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.J();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void K() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.K();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void N() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.N();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String P() {
        IHomeApi r0 = b();
        if (r0 == null) goto L5;
        String r1 = r0.P();
    L6:
        if (r1 != null) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void S() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.S();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void T() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.T();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void U() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.U();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void X() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.X();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final a d0() {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d0();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void e0() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.e0();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void g0() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.g0();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean isPad() {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPad();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean m() {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.m();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean n() {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.n();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final boolean o() {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.o();
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String r() {
        IHomeApi r0 = b();
        if (r0 == null) goto L5;
        String r1 = r0.r();
    L6:
        if (r1 != null) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Map<Integer, Integer> s() {
        IHomeApi r0 = b();
        if (r0 == null) goto L5;
        Map<Integer, Integer> r1 = r0.s();
    L6:
        Intrinsics.checkNotNull(r1);
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void u() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.u();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void y() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.y();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void z() {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.z();
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String A(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.A(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void C(boolean r2) {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.C(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final Integer H(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.H(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void I(long r2) {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.I(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void L(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.L(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void M(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.M(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Q(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.Q(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void R(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("15.2.0.1", "versionName");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.R(r3);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void V(boolean r2) {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.V(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final xe8.a a(Activity r2) {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void a0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.a0(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void c0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.c0(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void f0(MainActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.f0(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void p(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.p(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final String q(AppIconsType r2) {
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void t(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.t(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final xe8.a v(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        IHomeApi r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.v(r2);
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void x(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonParams");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.x(r2);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void O(Fragment r2, MainTabFragmentAction r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.O(r2, r3);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void W(Context r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.W(r2, r3);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Y(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.Y(r2, r3);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void Z(Context r2, Uri r3) {
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.Z(r2, r3);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void b0(String r2, FragmentManager r3) {
        Intrinsics.checkNotNullParameter(r2, "phoneNumber");
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.b0(r2, r3);
        return;
    }

    @Override // com.larus.home.api.main.IHomeApi
    public final void w(Context r2, AppIconsType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appIconsType");
        IHomeApi r0 = b();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }
}
