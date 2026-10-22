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
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import xe8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0003H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\u0017\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0017\u001a\u00020\u0018H&¢\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/H&J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+01H&J\u0014\u00102\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010/H&J\n\u00103\u001a\u0004\u0018\u000104H&J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u00106\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0012\u00107\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0016\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;H&J\u0012\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010=\u001a\u00020;H\u0017J\b\u0010>\u001a\u00020'H&J\b\u0010?\u001a\u00020'H&J\b\u0010@\u001a\u00020'H&J\b\u0010A\u001a\u00020\u0003H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010C\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010D\u001a\u00020'H&J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0012H&J\b\u0010G\u001a\u00020'H&J\b\u0010H\u001a\u00020\u0005H&J\u001f\u0010I\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010J\u001a\u0004\u0018\u00010+H&¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0012\u0010M\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020'H&J\u0012\u0010P\u001a\u00020'2\b\u0010Q\u001a\u0004\u0018\u00010RH&J\u001a\u0010S\u001a\u00020\u00032\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010T\u001a\u00020UH&J\u001c\u0010V\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010W\u001a\u0004\u0018\u00010XH&J\u0018\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\\H&¨\u0006]"}, d2 = {"Lcom/larus/home/api/main/IHomeApi;", XmlPullParser.NO_NAMESPACE, "setMainTabViewGenerator", XmlPullParser.NO_NAMESPACE, "getChatActivityClassName", XmlPullParser.NO_NAMESPACE, "getObricChatActivityClassName", "preloadMainTabView", "initAppStartTime", "initAppRealInitTime", "getAppRealInitTime", XmlPullParser.NO_NAMESPACE, "()Ljava/lang/Long;", "recordAppAttachEnd", "recordAppOnCreate", "startMillis", "reportAppFeedShow", "data", "Lorg/json/JSONObject;", "asyncReportPrivacyPoliceShow", "duration", "tryReportPrivacyDialogShow", "applicationAttachBeforeSuper", "context", "Landroid/content/Context;", "applicationAttachAfterSuper", "applicationCreateBeforeSuper", "application", "Landroid/app/Application;", "applicationCreateAfterSuper", "initSystemLoadLibraryHook", "versionName", "checkMiddleTabLottieAndDownloadIfNecessary", "initUpdateClientStateManager", "registerUpdateRedDotManagerListener", "initPadController", "initPreloadMessages", "setDecorViewLancetEnable", "enable", XmlPullParser.NO_NAMESPACE, "initBottomTabConfig", "setIsFromLogin", "getCurrentAppIconId", XmlPullParser.NO_NAMESPACE, "(Landroid/content/Context;)Ljava/lang/Integer;", "changeAppIcon", "appIconsType", "Lcom/larus/home/api/main/AppIconsType;", "getAvailableIcons", XmlPullParser.NO_NAMESPACE, "getAppIconClickEventId", "getBottomTabConfigManager", "Lcom/larus/home/api/main/model/IBottomTabConfigManager;", "reportAppPrivacyPoliceDismissToLoginShow", "tryUpdateLauncherActivity", "findEnabledActivity", "getChatFragment", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "topActivity", "Landroid/app/Activity;", "getSelectedChatFragment", "activity", "enableSideBar", "isSideBarVisible", "isFlowNativeBotChatVisible", "clearPreloadMessage", "savePrivacyWindowShow", "savePrivacyWindowClick", "accept", "recordPrivacyPoliceShow", "jsonParams", "isPad", "getPrivacyWebViewActivityClassName", "enableLauncherIcon", "currentSelectAppIconId", "(Landroid/content/Context;Ljava/lang/Integer;)V", "disableLauncherIcon", "recoverLauncherIcon", "setHotLaunchEnabled", "enabled", "hasAddPageMineTabFragment", "fragment", "Landroidx/fragment/app/Fragment;", "mainTabOnAction", "action", "Lcom/larus/voice_setting/voice/base/MainTabFragmentAction;", "redirectNeedLoginStrictModeRouter", ContentProviderManager.PROVIDER_URI, "Landroid/net/Uri;", "openPhoneNumberPanel", "phoneNumber", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IHomeApi {
    String A(Context r1);

    void B();

    void C(boolean r1);

    void D();

    void E();

    String F();

    void G();

    Integer H(Context r1);

    void I(long r1);

    Long J();

    void K();

    void L(JSONObject r1);

    void M(Application r1);

    void N();

    void O(Fragment r1, MainTabFragmentAction r2);

    String P();

    void Q(Context r1);

    void R(Context r1);

    void S();

    void T();

    void U();

    void V(boolean r1);

    void W(Context r1, Integer r2);

    void X();

    void Y(Context r1, boolean r2);

    void Z(Context r1, Uri r2);

    a a(Activity r1);

    void a0(Context r1);

    void b0(String r1, FragmentManager r2);

    void c0(Context r1);

    hb9.a d0();

    void e0();

    void f0(MainActivity r1);

    void g0();

    boolean isPad();

    boolean m();

    boolean n();

    boolean o();

    void p(JSONObject r1);

    String q(AppIconsType r1);

    String r();

    Map<Integer, Integer> s();

    void t(Context r1);

    void u();

    a v(Activity r1);

    void w(Context r1, AppIconsType r2);

    void x(JSONObject r1);

    void y();

    void z();
}
