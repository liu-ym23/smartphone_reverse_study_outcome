package oi9;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostLogDepend;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XBridgeMethod.Access f523471b;

    /* JADX INFO: renamed from: oi9.a$a, reason: collision with other inner class name */
    public static final class C7059a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f523472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f523473b;

        public final void a() {
            Intrinsics.checkNotNullParameter("hostContextDepend depend is null", "msg");
            XCoreBridgeMethod.onFailure$default(this.f523472a, this.f523473b, 0, "hostContextDepend depend is null", null, 8, null);
        }

        public C7059a(a r100, XBridgeMethod.Callback r101) {
            this.f523472a = r100;
            this.f523473b = r101;
        }

        public final void b(c r100, String r110) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r110, "msg");
            int r101 = c.f523475w;
            Intrinsics.checkNotNullParameter(r100, "data");
            if (r100.f523476a != null) goto L6;
        L120:
            LinkedHashMap r102 = null;
        L121:
            if (r102 != null) goto L124;
            XCoreBridgeMethod.onFailure$default(this.f523472a, this.f523473b, -5, null, null, 12, null);
            return;
        L124:
            this.f523472a.onSuccess(this.f523473b, r102, r110);
            return;
        L6:
            if (r100.f523477b == null) goto L120;
            if (r100.f523478c == null) goto L120;
            if (r100.f523479d == null) goto L120;
            if (r100.f523480e == null) goto L120;
            Boolean r103 = r100.f523482g;
            if (r103 == null) goto L120;
            r103.booleanValue();
            if (r100.f523484i == null) goto L120;
            if (r100.f523486k == null) goto L120;
            if (r100.f523487l == null) goto L120;
            if (r100.f523489n == null) goto L120;
            if (r100.f523490o == null) goto L120;
            if (r100.f523491p == null) goto L120;
            if (r100.f523492q == null) goto L120;
            Boolean r104 = r100.f523493r;
            if (r104 == null) goto L120;
            r104.booleanValue();
            r102 = new LinkedHashMap();
            String r105 = r100.f523476a;
            if (r105 == null) goto L45;
            r102.put(com.heytap.mcssdk.constant.b.f276371u, r105);
        L45:
            String r106 = r100.f523477b;
            if (r106 == null) goto L48;
            r102.put("installID", r106);
        L48:
            String r107 = r100.f523478c;
            if (r107 == null) goto L51;
            r102.put("appName", r107);
        L51:
            String r108 = r100.f523479d;
            if (r108 == null) goto L54;
            r102.put("appVersion", r108);
        L54:
            String r109 = r100.f523494s;
            if (r109 == null) goto L57;
            r102.put("updateVersionCode", r109);
        L57:
            Integer r111 = r100.f523495t;
            if (r111 == null) goto L60;
            r102.put("screenWidth", Integer.valueOf(r111.intValue()));
        L60:
            Integer r112 = r100.f523496u;
            if (r112 == null) goto L63;
            r102.put("screenHeight", Integer.valueOf(r112.intValue()));
        L63:
            String r113 = r100.f523480e;
            if (r113 == null) goto L66;
            r102.put("channel", r113);
        L66:
            String r114 = r100.f523481f;
            if (r114 == null) goto L69;
            r102.put("language", r114);
        L69:
            Boolean r115 = r100.f523482g;
            if (r115 == null) goto L72;
            r102.put("isTeenMode", Boolean.valueOf(r115.booleanValue()));
        L72:
            String r116 = r100.f523484i;
            if (r116 == null) goto L75;
            r102.put("osVersion", r116);
        L75:
            Integer r117 = r100.f523485j;
            if (r117 == null) goto L78;
            r102.put("statusBarHeight", Integer.valueOf(r117.intValue()));
        L78:
            String r118 = r100.f523486k;
            if (r118 == null) goto L81;
            r102.put("devicePlatform", r118);
        L81:
            String r119 = r100.f523487l;
            if (r119 == null) goto L84;
            r102.put("deviceModel", r119);
        L84:
            String r120 = r100.f523489n;
            if (r120 == null) goto L87;
            r102.put(OnekeyLoginConstants.NET_TYPE, r120);
        L87:
            String r121 = r100.f523490o;
            if (r121 == null) goto L90;
            r102.put("networkType", r121);
        L90:
            String r122 = r100.f523491p;
            if (r122 == null) goto L93;
            r102.put("screenOrientation", r122);
        L93:
            String r123 = r100.f523492q;
            if (r123 == null) goto L96;
            r102.put(Constants.OperatorKey.KEY_CARRIER, r123);
        L96:
            String r124 = r100.f523483h;
            if (r124 == null) goto L99;
            r102.put("appTheme", r124);
        L99:
            Boolean r125 = r100.f523493r;
            if (r125 == null) goto L102;
            r102.put("is32Bit", Boolean.valueOf(r125.booleanValue()));
        L102:
            String r126 = r100.f523488m;
            if (r126 == null) goto L105;
            r102.put("deviceID", r126);
        L105:
            c.b r127 = r100.f523497v;
            if (r127 == null) goto L121;
            LinkedHashMap r128 = new LinkedHashMap();
            Integer r129 = r127.f523499b;
            if (r129 == null) goto L110;
            r128.put("marginBottom", Integer.valueOf(r129.intValue()));
        L110:
            Integer r130 = r127.f523498a;
            if (r130 == null) goto L113;
            r128.put("marginTop", Integer.valueOf(r130.intValue()));
        L113:
            Integer r131 = r127.f523501d;
            if (r131 == null) goto L116;
            r128.put("marginRight", Integer.valueOf(r131.intValue()));
        L116:
            Integer r132 = r127.f523500c;
            if (r132 == null) goto L119;
            r128.put("marginLeft", Integer.valueOf(r132.intValue()));
        L119:
            Unit r133 = Unit.INSTANCE;
            r102.put("safeArea", r128);
            goto L121
        }
    }

    public a() {
        this.f523470a = "x.getAppInfo";
        this.f523471b = XBridgeMethod.Access.PROTECT;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f523471b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f523470a;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<com.bytedance.ies.xbridge.model.params.b> provideParamModel() {
        return com.bytedance.ies.xbridge.model.params.b.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<c> provideResultModel() {
        return c.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        int r100 = com.bytedance.ies.xbridge.model.params.b.f249508a;
        Intrinsics.checkNotNullParameter(r110, "params");
        com.bytedance.ies.xbridge.model.params.b r101 = new com.bytedance.ies.xbridge.model.params.b();
        C7059a r102 = new C7059a(this, r111);
        b r103 = (b) this;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        r56.c r104 = (r56.c) r103.provideContext(r56.c.class);
        if (r104 == null) goto L6;
        IHostContextDepend r105 = r104.f536314b;
        if (r105 == null) goto L6;
    L11:
        if (r105 == null) goto L97;
        c r106 = new c();
        r56.c r107 = (r56.c) r103.provideContext(r56.c.class);
        if (r107 == null) goto L16;
        IHostContextDepend r108 = r107.f536314b;
        if (r108 == null) goto L16;
    L21:
        if (r108 == null) goto L73;
        Context r113 = r108.getApplicationContext();
        r106.f523476a = String.valueOf(r108.getAppId());
        r106.f523478c = r108.getAppName();
        r106.f523479d = r108.getVersionName();
        r106.f523480e = r108.getChannel();
        r106.f523481f = r108.getLanguage();
        r106.f523482g = Boolean.valueOf(r108.isTeenMode());
        r106.f523483h = r108.getSkinName();
        r106.f523484i = Build.VERSION.RELEASE;
        r106.f523486k = "android";
        r106.f523488m = r108.getDeviceId();
        r106.f523487l = Build.MODEL;
        r106.f523489n = NetworkUtils.getNetworkTypeFast(r113).name();
        NetworkUtils.NetworkType r114 = NetworkUtils.getNetworkTypeFast(r113);
        if (r114 != null) goto L25;
        int r115 = -1;
    L26:
        switch(r115) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L28;
            case 11: goto L28;
            default: goto L27;
        };
    L27:
        String r116 = "unknown";
    L35:
        r106.f523490o = r116;
        if (r113.getResources().getConfiguration().orientation != 1) goto L38;
        String r117 = "portrait";
    L39:
        r106.f523491p = r117;
        r106.f523494s = r108.getUpdateVersion();
        String r118 = "";
        r106.f523485j = Integer.valueOf(r103.g(r113.getResources().getDimensionPixelSize(r113.getResources().getIdentifier("status_bar_height", "dimen", "android")), r113));
        String r109 = r108.getCurrentTelcomCarrier();
        if (r109 != null) goto L42;
        r109 = r118;
    L42:
        r106.f523492q = r109;
        Context r119 = (Context) r103.provideContext(Context.class);
        if (r119 != null) goto L45;
        Context r120 = r113;
    L47:
        if (r120.getResources().getConfiguration().orientation != 2) goto L49;
        boolean r121 = true;
    L50:
        int r122 = r103.g(vd7.c.b(r120), r120);
        int r123 = r103.g(vd7.c.a(r120), r120);
        if (r121 == false) goto L53;
        int r124 = Math.max(r122, r123);
    L54:
        r106.f523495t = Integer.valueOf(r124);
        r106.f523496u = Integer.valueOf(r103.f(r119, r113));
        Object r125 = r103.provideContext(Context.class);
        if ((r125 instanceof Activity) == false) goto L57;
        Activity r126 = (Activity) r125;
    L58:
        if (r126 != null) goto L60;
        c.b r127 = null;
    L72:
        r106.f523497v = r127;
    L74:
        r56.c r128 = (r56.c) r103.provideContext(r56.c.class);
        if (r128 == null) goto L80;
        IHostLogDepend r129 = r128.f536313a;
        if (r129 == null) goto L80;
        IHostLogDepend r130 = r129;
    L84:
        if (r130 == null) goto L88;
        HashMap r131 = new HashMap();
        boolean r132 = true;
        r130.putCommonParams(r131, true);
        if (r131.containsKey(WsConstants.KEY_INSTALL_ID) == false) goto L89;
        r106.f523477b = (String) r131.get(WsConstants.KEY_INSTALL_ID);
    L89:
        String r133 = r106.f523477b;
        if (r133 != null) goto L92;
        r133 = r118;
    L92:
        r106.f523477b = r133;
        if (Build.SUPPORTED_64_BIT_ABIS.length == 0) goto L96;
        r132 = false;
    L96:
        r106.f523493r = Boolean.valueOf(r132);
        r102.b(r106, r118);
        return;
    L88:
        r132 = true;
    L80:
        r56.c r134 = r56.c.f536312g;
        if (r134 == null) goto L83;
        r130 = r134.f536313a;
        goto L84
    L83:
        r130 = null;
        goto L84
    L60:
        if (r126.getResources().getConfiguration().orientation != 2) goto L62;
        boolean r135 = true;
    L63:
        int r136 = r103.g(r113.getResources().getDimensionPixelSize(r113.getResources().getIdentifier("status_bar_height", "dimen", "android")), r113);
        Rect r137 = new Rect();
        b.e(r126.getWindow()).getWindowVisibleDisplayFrame(r137);
        int r138 = r103.g(b.e(r126.getWindow()).getHeight(), r126);
        int r139 = r103.g(r137.top, r113);
        int r140 = r103.g(r137.bottom, r113);
        if (r138 != 0) goto L67;
        if (r139 != 0) goto L67;
        r140 = r140 + r136;
    L67:
        int r141 = Math.max(r103.f(r126, r113) - r140, 0);
        if (r135 == false) goto L70;
        r127 = new c.b();
        r127.f523500c = Integer.valueOf(r136);
        r127.f523501d = Integer.valueOf(r141);
        r127.f523498a = 0;
        r127.f523499b = 0;
        goto L72
    L70:
        r127 = new c.b();
        r127.f523498a = Integer.valueOf(r136);
        r127.f523499b = Integer.valueOf(r141);
        r127.f523501d = 0;
        r127.f523500c = 0;
        goto L72
    L62:
        r135 = false;
        goto L63
    L57:
        r126 = null;
        goto L58
    L53:
        r124 = Math.min(r122, r123);
        goto L54
    L49:
        r121 = false;
        goto L50
    L45:
        r120 = r119;
        goto L47
    L38:
        r117 = "landscape";
        goto L39
    L28:
        r116 = "wifi";
        goto L35
    L29:
        r116 = CJPayBasicUtils.NETWORK_MOBILE;
        goto L35
    L30:
        r116 = CJPayBasicUtils.NETWORK_4G;
        goto L35
    L31:
        r116 = CJPayBasicUtils.NETWORK_3G;
        goto L35
    L32:
        r116 = CJPayBasicUtils.NETWORK_2G;
        goto L35
    L33:
        r116 = "mobile";
        goto L35
    L34:
        r116 = "none";
        goto L35
    L25:
        r115 = b.a.f523474a[r114.ordinal()];
        goto L26
    L73:
        r118 = "";
    L16:
        r56.c r142 = r56.c.f536312g;
        if (r142 == null) goto L19;
        r108 = r142.f536314b;
        goto L21
    L19:
        r108 = null;
        goto L21
    L97:
        r102.a();
        return;
    L6:
        r56.c r143 = r56.c.f536312g;
        if (r143 == null) goto L9;
        r105 = r143.f536314b;
        goto L11
    L9:
        r105 = null;
        goto L11
    }
}
