package vd7;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.ttnet.TTNetInit;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getAppInfo")
public final class d extends vd7.a {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f554210a = null;

        static {
            int[] r100 = new int[NetworkUtils.NetworkType.values().length];
            r100[NetworkUtils.NetworkType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[NetworkUtils.NetworkType.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[NetworkUtils.NetworkType.MOBILE_3G_H.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[NetworkUtils.NetworkType.MOBILE_3G_HP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[NetworkUtils.NetworkType.WIFI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[NetworkUtils.NetworkType.WIFI_24GHZ.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[NetworkUtils.NetworkType.WIFI_5GHZ.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f554210a = r100;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public d() {
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final vd7.a.b b(Activity r100, Context r110) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.getResources().getConfiguration().orientation != 2) goto L6;
        boolean r101 = true;
    L7:
        int r102 = e(r110.getResources().getDimensionPixelSize(r110.getResources().getIdentifier("status_bar_height", "dimen", "android")), r110);
        Rect r103 = new Rect();
        a(r100.getWindow()).getWindowVisibleDisplayFrame(r103);
        int r104 = e(a(r100.getWindow()).getHeight(), r100);
        int r105 = e(r103.top, r110);
        int r106 = e(r103.bottom, r110);
        if (r104 != 0) goto L11;
        if (r105 != 0) goto L11;
        r106 = r106 + r102;
    L11:
        int r107 = Math.max(c(r100, r110) - r106, 0);
        if (r101 == false) goto L14;
        vd7.a.b r111 = (vd7.a.b) ne7.e.c(Reflection.getOrCreateKotlinClass(vd7.a.b.class));
        r111.setMarginLeft(Integer.valueOf(r102));
        r111.setMarginRight(Integer.valueOf(r107));
        r111.setMarginTop(0);
        r111.setMarginBottom(0);
        return r111;
    L14:
        vd7.a.b r112 = (vd7.a.b) ne7.e.c(Reflection.getOrCreateKotlinClass(vd7.a.b.class));
        r112.setMarginTop(Integer.valueOf(r102));
        r112.setMarginBottom(Integer.valueOf(r107));
        r112.setMarginRight(0);
        r112.setMarginLeft(0);
        return r112;
    L6:
        r101 = false;
        goto L7
    }

    public final int c(Context r100, Context r101) {
        if (r100 != null) goto L5;
        r100 = r101;
    L5:
        if (r100.getResources().getConfiguration().orientation != 2) goto L7;
        boolean r102 = true;
    L8:
        int r103 = e(c.b(r100), r100);
        int r104 = e(c.a(r100), r100);
        if (r102 == false) goto L12;
        return Math.min(r103, r104);
    L12:
        return Math.max(r103, r104);
    L7:
        r102 = false;
        goto L8
    }

    public final int e(double r100, Context r101) {
        Resources r102 = r101.getResources();
        return (int) ((r100 / ((double) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density)) + ((double) 0.5f));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((vd7.a.c) r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        XBaseRuntime r113 = XBaseRuntime.f270095a;
        r113.getClass();
        Unit r100 = null;
        if (XBaseRuntime.f270100f == null) goto L59;
        XBaseModel r101 = ne7.e.c(Reflection.getOrCreateKotlinClass(vd7.a.d.class));
        vd7.a.d r102 = (vd7.a.d) r101;
        r113.getClass();
        IHostContextDepend r114 = XBaseRuntime.f270100f;
        boolean r103 = false;
        String r104 = "";
        if (r114 == null) goto L46;
        Context r105 = r114.getApplicationContext();
        r102.setAppID(String.valueOf(r114.getAppId()));
        r102.setAppName(r114.getAppName());
        r102.setAppVersion(r114.getVersionName());
        r102.setChannel(r114.getChannel());
        r102.setLanguage(r114.getLanguage());
        r102.setTeenMode(Boolean.valueOf(r114.isTeenMode()));
        r102.setBaseMode(Boolean.valueOf(r114.isBaseMode()));
        r102.setAppTheme(r114.getSkinName());
        r102.setOsVersion(Build.VERSION.RELEASE);
        r102.setDevicePlatform("android");
        r102.setDeviceID(r114.getDeviceId());
        r102.setDeviceModel(Build.MODEL);
        r102.setNetType(NetworkUtils.getNetworkTypeFast(r105).name());
        NetworkUtils.NetworkType r106 = NetworkUtils.getNetworkTypeFast(r105);
        if (r106 != null) goto L9;
        int r107 = -1;
    L10:
        switch(r107) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            default: goto L11;
        };
    L11:
        String r108 = "unknown";
    L19:
        r102.setNetworkType(r108);
        r102.setNetworkQuality(Integer.valueOf(TTNetInit.getEffectiveConnectionType()));
        if (r105.getResources().getConfiguration().orientation != 1) goto L22;
        String r109 = "portrait";
    L23:
        r102.setScreenOrientation(r109);
        r102.setUpdateVersionCode(r114.getUpdateVersion());
        r102.setStatusBarHeight(Integer.valueOf(e(r105.getResources().getDimensionPixelSize(r105.getResources().getIdentifier("status_bar_height", "dimen", "android")), r105)));
        String r115 = r114.getCurrentTelcomCarrier();
        if (r115 != null) goto L26;
        r115 = "";
    L26:
        r102.setCarrier(r115);
        Activity r116 = r110.getOwnerActivity();     // Catch: Exception -> L45
        if (r116 != null) goto L30;
        Context r117 = r105;
    L32:
        if (r117.getResources().getConfiguration().orientation != 2) goto L34;
        boolean r118 = true;
    L35:
        int r119 = e(c.b(r117), r117);     // Catch: Exception -> L45
        int r120 = e(c.a(r117), r117);     // Catch: Exception -> L45
        if (r118 == false) goto L38;
        int r121 = Math.max(r119, r120);     // Catch: Exception -> L45
    L39:
        r102.setScreenWidth(Integer.valueOf(r121));     // Catch: Exception -> L45
        r102.setScreenHeight(Integer.valueOf(c(r116, r105)));     // Catch: Exception -> L45
        if ((r116 instanceof Activity) == true) goto L43;
        r116 = null;
    L43:
        r102.setSafeArea(b(r116, r105));     // Catch: Exception -> L45
        goto L46
    L38:
        r121 = Math.min(r119, r120);     // Catch: Exception -> L45
        goto L39
    L34:
        r118 = false;
        goto L35
    L30:
        r117 = r116;
        goto L32
    L22:
        r109 = "landscape";
        goto L23
    L12:
        r108 = "wifi";
        goto L19
    L13:
        r108 = CJPayBasicUtils.NETWORK_MOBILE;
        goto L19
    L14:
        r108 = CJPayBasicUtils.NETWORK_4G;
        goto L19
    L15:
        r108 = CJPayBasicUtils.NETWORK_3G;
        goto L19
    L16:
        r108 = CJPayBasicUtils.NETWORK_2G;
        goto L19
    L17:
        r108 = "mobile";
        goto L19
    L18:
        r108 = "none";
        goto L19
    L9:
        r107 = a.f554210a[r106.ordinal()];
    L46:
        XBaseRuntime.f270095a.getClass();
        IHostLogDepend r122 = XBaseRuntime.f270096b;
        if (r122 == null) goto L51;
        HashMap r123 = new HashMap();
        r122.putCommonParams(r123, true);
        if (r123.containsKey(WsConstants.KEY_INSTALL_ID) == false) goto L51;
        r102.setInstallID((String) r123.get(WsConstants.KEY_INSTALL_ID));
    L51:
        String r124 = r102.getInstallID();
        if (r124 == null) goto L55;
        r104 = r124;
    L55:
        r102.setInstallID(r104);
        if (Build.SUPPORTED_64_BIT_ABIS.length != 0) goto L58;
        r103 = true;
    L58:
        r102.set32Bit(Boolean.valueOf(r103));
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r101, null, 2, null);
        r100 = Unit.INSTANCE;
    L59:
        if (r100 != null) goto L64;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "hostContextDepend depend is null", null, 4, null);
        return;
    }
}
