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
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import xe8.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0003H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\u0017\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0017\u001a\u00020\u0018H&¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/H&J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+01H&J\u0014\u00102\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010/H&J\n\u00103\u001a\u0004\u0018\u000104H&J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u00106\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0012\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0016\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;H&J\u0012\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010=\u001a\u00020;H\u0017J\b\u0010>\u001a\u00020'H&J\b\u0010?\u001a\u00020'H&J\b\u0010@\u001a\u00020'H&J\b\u0010A\u001a\u00020\u0003H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010C\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010D\u001a\u00020'H&J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0012H&J\b\u0010G\u001a\u00020'H&J\b\u0010H\u001a\u00020\u0005H&J\u001f\u0010I\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010J\u001a\u0004\u0018\u00010+H&¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0012\u0010M\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020'H&J\u0012\u0010P\u001a\u00020'2\b\u0010Q\u001a\u0004\u0018\u00010RH&J\u001a\u0010S\u001a\u00020\u00032\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010T\u001a\u00020UH&J\u001c\u0010V\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010W\u001a\u0004\u0018\u00010XH&J\u0018\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\\H&¨\u0006]"}, d2 = {"Lcom/larus/home/api/main/IHomeApi;", "", "setMainTabViewGenerator", "", "getChatActivityClassName", "", "getObricChatActivityClassName", "preloadMainTabView", "initAppStartTime", "initAppRealInitTime", "getAppRealInitTime", "", "()Ljava/lang/Long;", "recordAppAttachEnd", "recordAppOnCreate", "startMillis", "reportAppFeedShow", "data", "Lorg/json/JSONObject;", "asyncReportPrivacyPoliceShow", "duration", "tryReportPrivacyDialogShow", "applicationAttachBeforeSuper", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "applicationAttachAfterSuper", "applicationCreateBeforeSuper", "application", "Landroid/app/Application;", "applicationCreateAfterSuper", "initSystemLoadLibraryHook", "versionName", "checkMiddleTabLottieAndDownloadIfNecessary", "initUpdateClientStateManager", "registerUpdateRedDotManagerListener", "initPadController", "initPreloadMessages", "setDecorViewLancetEnable", "enable", "", "initBottomTabConfig", "setIsFromLogin", "getCurrentAppIconId", "", "(Landroid/content/Context;)Ljava/lang/Integer;", "changeAppIcon", "appIconsType", "Lcom/larus/home/api/main/AppIconsType;", "getAvailableIcons", "", "getAppIconClickEventId", "getBottomTabConfigManager", "Lcom/larus/home/api/main/model/IBottomTabConfigManager;", "reportAppPrivacyPoliceDismissToLoginShow", "tryUpdateLauncherActivity", "findEnabledActivity", "getChatFragment", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "topActivity", "Landroid/app/Activity;", "getSelectedChatFragment", "activity", "enableSideBar", "isSideBarVisible", "isFlowNativeBotChatVisible", "clearPreloadMessage", "savePrivacyWindowShow", "savePrivacyWindowClick", "accept", "recordPrivacyPoliceShow", "jsonParams", "isPad", "getPrivacyWebViewActivityClassName", "enableLauncherIcon", "currentSelectAppIconId", "(Landroid/content/Context;Ljava/lang/Integer;)V", "disableLauncherIcon", "recoverLauncherIcon", "setHotLaunchEnabled", "enabled", "hasAddPageMineTabFragment", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "mainTabOnAction", "action", "Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "redirectNeedLoginStrictModeRouter", "uri", "Landroid/net/Uri;", "openPhoneNumberPanel", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHomeApi {
    String A(Context r100);

    void B();

    void C(boolean r100);

    void D();

    void E();

    String F();

    void G();

    Integer H(Context r100);

    void I(long r100);

    Long J();

    void K();

    void L(JSONObject r100);

    void M(Application r100);

    void N();

    void O(Fragment r100, MainTabFragmentAction r101);

    String P();

    void Q(Context r100);

    void R(Context r100);

    void S();

    void T();

    void U();

    void V(boolean r100);

    void W(Context r100, Integer r101);

    void X();

    void Y(Context r100, boolean r101);

    void Z(Context r100, Uri r101);

    a a(Activity r100);

    void a0(Context r100);

    void b0(String r100, FragmentManager r101);

    void c0(Context r100);

    hb9.a d0();

    void e0();

    void f0(MainActivity r100);

    void g0();

    boolean isPad();

    boolean m();

    boolean n();

    boolean o();

    void p(JSONObject r100);

    String q(AppIconsType r100);

    String r();

    Map<Integer, Integer> s();

    void t(Context r100);

    void u();

    a v(Activity r100);

    void w(Context r100, AppIconsType r101);

    void x(JSONObject r100);

    void y();

    void z();
}
