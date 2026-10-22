package com.bytedance.caijing.sdk.infra.base.api.env;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayToastAdapter;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface;
import com.bytedance.caijing.sdk.infra.base.api.router.CJHostRouterService;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sd4.a;
import sd4.b;
import sd4.c;
import sd4.d;
import sd4.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\u0006H&J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0016J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u000eH\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u001c\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\u0004H\u0016J\u0010\u00101\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0004H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\u00102\u0006\u0010+\u001a\u000204H\u0016J\b\u00106\u001a\u00020\u0010H\u0016J\n\u00108\u001a\u0004\u0018\u000107H\u0016J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u000209H\u0016J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010:\u001a\u000209H\u0016J\u0012\u0010>\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010=H\u0016J\n\u0010@\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010C\u001a\f\u0012\u0006\b\u0001\u0012\u00020B\u0018\u00010AH\u0016J\n\u0010E\u001a\u0004\u0018\u00010DH\u0016J\b\u0010F\u001a\u00020\u0004H\u0016J\b\u0010G\u001a\u00020\u0004H\u0016J\u001c\u0010J\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020B0Hj\n\u0012\u0006\b\u0001\u0012\u00020B`IH\u0016J\n\u0010L\u001a\u0004\u0018\u00010KH\u0016J\b\u0010N\u001a\u00020MH\u0016J\b\u0010O\u001a\u00020MH\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\u0017\u0010R\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010QH\u0016¢\u0006\u0004\bR\u0010SJ\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u00020\u0004H\u0016J\b\u0010V\u001a\u00020\u0004H\u0016J\b\u0010W\u001a\u00020\u0004H\u0016J\b\u0010X\u001a\u00020\u0004H\u0016J\u0010\u0010Y\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&J\b\u0010Z\u001a\u00020\fH\u0016J\n\u0010[\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010\\\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0016\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010]H\u0016¨\u0006_"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/app/Application;", "getHostApplication", "", "hostIsDebug", "", "getHostAid", "getHostChannel", "isLocalTestChannel", "isGreyChannel", "isDarkMode", "", "getNetworkQuality", "", "getDeviceScore", "", "performenceInit", "getDeviceId", "getHostUserId", "getHostVersionName", "getHostVersionCode", "getHostUpdateVersionCode", "getHostAppName", "getPluginVersion", "isLivePluginAvailable", "getPackageName", "stopApmStartUpMonitor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lsd4/d;", "callback", "goLarkSSOAuth", "key", "value", "storeStringInHostRepo", "defaultValue", "getStringFromHostRepo", "getIID", "getFontScale", "isElderMode", "schema", "Landroid/app/Activity;", "activity", "openSchemaRouter", "url", "isApi", "networkParamsLoadToUrl", "isSign", "setWXIndependentSign", "Lsd4/b;", "getEnvController", "Landroidx/fragment/app/FragmentActivity;", "setAttachWindowSpecialEffectController", "onSDKInvoke", "Lcom/bytedance/caijing/sdk/infra/base/api/env/INetEnv;", "getNetEnvHelper", "Lsd4/e;", "listener", "addAppBackGroundListener", "removeAppBackGroundListener", "Lsd4/c;", "tryShowUpdateDialog", "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayToastAdapter;", "hostToastAdapter", "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayLoadingAdapter;", "", "hostLoadingAdapter", "Landroid/view/View;", "getHostLoadingView", "isBasicMode", "isFollowSystemTheme", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTTNetInterceptors", "Lsd4/a;", "getDidCheckControl", "", "getColdBootBeginUptimeMS", "getColdBootBeginMs", "isColdBoot", "", "getActivityStack", "()[Landroid/app/Activity;", "getHostSettingsConfig", "isSupportSettingsUpdateOpt", "isStdUIDebugMode", "isVerifyDebuggable", "isVerifyDefaultMode", "isMainProcess", "getBootType", "getTopActivity", "isWifiProxy", "Landroid/util/Pair;", "getHostSettingsTag", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJHostService extends ICJService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void addAppBackGroundListener(CJHostService r100, e r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }

        public static Activity[] getActivityStack(CJHostService r100) {
            return null;
        }

        public static int getBootType(CJHostService r100) {
            return -1;
        }

        public static long getColdBootBeginMs(CJHostService r100) {
            return 0;
        }

        public static long getColdBootBeginUptimeMS(CJHostService r100) {
            return 0;
        }

        public static float getDeviceScore(CJHostService r100) {
            return -1.0f;
        }

        public static a getDidCheckControl(CJHostService r100) {
            return null;
        }

        public static b getEnvController(CJHostService r100) {
            return null;
        }

        public static float getFontScale(CJHostService r100) {
            return 1.0f;
        }

        public static View getHostLoadingView(CJHostService r100) {
            return null;
        }

        public static String getHostSettingsConfig(CJHostService r100) {
            return "";
        }

        public static Pair<String, String> getHostSettingsTag(CJHostService r100) {
            return null;
        }

        public static String getIID(CJHostService r100) {
            return "";
        }

        public static INetEnv getNetEnvHelper(CJHostService r100) {
            return null;
        }

        public static int getNetworkQuality(CJHostService r100) {
            return -1;
        }

        public static String getPackageName(CJHostService r100) {
            return "com.ss.android.ugc.aweme.cjpay";
        }

        public static int getPluginVersion(CJHostService r100) {
            return 0;
        }

        public static String getStringFromHostRepo(CJHostService r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "defaultValue");
            return "";
        }

        public static Activity getTopActivity(CJHostService r100) {
            return null;
        }

        public static void goLarkSSOAuth(CJHostService r100, Context r101, d r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "callback");
        }

        public static TTCJPayLoadingAdapter<? extends Object> hostLoadingAdapter(CJHostService r100) {
            return null;
        }

        public static TTCJPayToastAdapter hostToastAdapter(CJHostService r100) {
            return null;
        }

        public static boolean isBasicMode(CJHostService r100) {
            return false;
        }

        public static boolean isColdBoot(CJHostService r100) {
            return false;
        }

        public static boolean isDarkMode(CJHostService r100) {
            return false;
        }

        public static boolean isElderMode(CJHostService r100) {
            return false;
        }

        public static boolean isFollowSystemTheme(CJHostService r100) {
            return false;
        }

        public static boolean isGreyChannel(CJHostService r100) {
            return false;
        }

        public static boolean isLivePluginAvailable(CJHostService r100) {
            return false;
        }

        public static boolean isStdUIDebugMode(CJHostService r100) {
            return false;
        }

        public static boolean isSupportSettingsUpdateOpt(CJHostService r100) {
            return false;
        }

        public static boolean isVerifyDebuggable(CJHostService r100) {
            return false;
        }

        public static boolean isVerifyDefaultMode(CJHostService r100) {
            return false;
        }

        public static boolean isWifiProxy(CJHostService r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return false;
        }

        public static String networkParamsLoadToUrl(CJHostService r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r101, "url");
            return r101;
        }

        public static void onSDKInvoke(CJHostService r100) {
        }

        public static void performenceInit(CJHostService r100) {
        }

        public static void removeAppBackGroundListener(CJHostService r100, e r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }

        public static void setAttachWindowSpecialEffectController(CJHostService r100, FragmentActivity r101) {
            Intrinsics.checkNotNullParameter(r101, "activity");
        }

        public static void setWXIndependentSign(CJHostService r100, boolean r101) {
        }

        public static void stopApmStartUpMonitor(CJHostService r100) {
        }

        public static void storeStringInHostRepo(CJHostService r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "value");
        }

        public static void tryShowUpdateDialog(CJHostService r100, c r101) {
        }

        public static ArrayList<? extends Object> getTTNetInterceptors(CJHostService r100) {
            return new ArrayList();
        }

        public static boolean isLocalTestChannel(CJHostService r100) {
            return StringsKt.equals("local_test", r100.getHostChannel(), true);
        }

        public static boolean openSchemaRouter(CJHostService r100, String r101, Activity r102) {
            Intrinsics.checkNotNullParameter(r101, "schema");
            ve4.a.f554342a.getClass();
            CJHostRouterService r103 = (CJHostRouterService) ve4.a.a(CJHostRouterService.class);
            if (r103 == null) goto L9;
            TTCJPayOpenSchemeWithContextInterface r104 = r103.getOpenSchemeWithContextInterface();
            if (r104 == null) goto L10;
            r104.openScheme(r102, r101);
            return false;
        L10:
            return false;
        L9:
            return false;
        }

        public static /* synthetic */ String networkParamsLoadToUrl$default(CJHostService r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = true;
        L7:
            return r100.networkParamsLoadToUrl(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: networkParamsLoadToUrl");
        }

        public static /* synthetic */ boolean openSchemaRouter$default(CJHostService r100, String r101, Activity r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.openSchemaRouter(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSchemaRouter");
        }
    }

    void addAppBackGroundListener(e r100);

    Activity[] getActivityStack();

    int getBootType();

    long getColdBootBeginMs();

    long getColdBootBeginUptimeMS();

    String getDeviceId();

    float getDeviceScore();

    a getDidCheckControl();

    b getEnvController();

    float getFontScale();

    String getHostAid();

    String getHostAppName();

    Application getHostApplication();

    String getHostChannel();

    View getHostLoadingView();

    String getHostSettingsConfig();

    Pair<String, String> getHostSettingsTag();

    int getHostUpdateVersionCode();

    String getHostUserId();

    int getHostVersionCode();

    String getHostVersionName();

    String getIID();

    INetEnv getNetEnvHelper();

    int getNetworkQuality();

    String getPackageName();

    int getPluginVersion();

    String getStringFromHostRepo(String r100, String r101);

    ArrayList<? extends Object> getTTNetInterceptors();

    Activity getTopActivity();

    void goLarkSSOAuth(Context r100, d r101);

    boolean hostIsDebug();

    TTCJPayLoadingAdapter<? extends Object> hostLoadingAdapter();

    TTCJPayToastAdapter hostToastAdapter();

    boolean isBasicMode();

    boolean isColdBoot();

    boolean isDarkMode();

    boolean isElderMode();

    boolean isFollowSystemTheme();

    boolean isGreyChannel();

    boolean isLivePluginAvailable();

    boolean isLocalTestChannel();

    boolean isMainProcess(Context r100);

    boolean isStdUIDebugMode();

    boolean isSupportSettingsUpdateOpt();

    boolean isVerifyDebuggable();

    boolean isVerifyDefaultMode();

    boolean isWifiProxy(Context r100);

    String networkParamsLoadToUrl(String r100, boolean r101);

    void onSDKInvoke();

    boolean openSchemaRouter(String r100, Activity r101);

    void performenceInit();

    void removeAppBackGroundListener(e r100);

    void setAttachWindowSpecialEffectController(FragmentActivity r100);

    void setWXIndependentSign(boolean r100);

    void stopApmStartUpMonitor();

    void storeStringInHostRepo(String r100, String r101);

    void tryShowUpdateDialog(c r100);
}
