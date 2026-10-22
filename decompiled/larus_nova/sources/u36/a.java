package u36;

import android.net.Uri;
import android.os.Bundle;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.bullet.forest.q;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.e;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import w26.g;
import y36.p;
import y36.s;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f548600d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f548602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f548603c;

    /* JADX INFO: renamed from: u36.a$a, reason: collision with other inner class name */
    public static final class C7829a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f548604a = null;

        static {
            int[] r100 = new int[KitType.values().length];
            r100[KitType.WEB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[KitType.LYNX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f548604a = r100;
        }
    }

    static {
        f548600d = SetsKt.setOf(new String[]{"packages", "__x_session_id", "web_domain_party", "enable_third_party_web_ui"});
    }

    @Override // t36.e
    public final String getName() {
        return this.f548603c;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f548601a = r100;
        this.f548602b = new q();
        this.f548603c = "Bullet";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.e
    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r210) {
        Intrinsics.checkNotNullParameter(r210, "schemaData");
        String r100 = (String) new p(r210, "container_bgcolor", null).f565862b;
        if (r100 == null) goto L5;
        r210.a("container_bg_color", new p(r100), false);
    L5:
        String r101 = (String) new p(r210, "bg_color", null).f565862b;
        if (r101 == null) goto L8;
        r210.a("container_bg_color", new p(r101), false);
    L8:
        Boolean r102 = (Boolean) new y36.a(r210, "hide_loading", null).f565862b;
        if (r102 == null) goto L11;
        r210.a("show_loading", new y36.a(Boolean.valueOf(!r102.booleanValue())), false);
    L11:
        String r103 = (String) new p(r210, "secLinkScene", null).f565862b;
        if (r103 == null) goto L15;
        r210.a("sec_link_scene", new p(r103), false);
    L15:
        if (Intrinsics.areEqual(r210.f248127d, "bullet") == false) goto L20;
        if (Intrinsics.areEqual(r210.getHost(), "bullet") == false) goto L20;
        return true;
    L20:
        if (Intrinsics.areEqual(r210.f248127d, "http") == false) goto L22;
    L23:
        Intrinsics.checkNotNullParameter("webview", "path");
        r210.f248128e = "webview";
        r210.a("url", new s(r210.f248126c), true);
    L24:
        this.f548602b.b(r210);
        Map<String, String> r104 = r210.f248139p;
        String r110 = "";
        if (r104.containsKey(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY) == false) goto L27;
        KitType r105 = KitType.LYNX;
    L59:
        UGLogger.f270252a.c("BulletInterceptor", "host: " + r210.getHost() + " kitType: " + r105);
        Map<String, Map<Class<?>, Object>> r111 = x26.a.f562251a;
        g r112 = (g) x26.a.a(g.class);
        if (r112 == null) goto L66;
        w26.e r113 = (w26.e) r112.n0(w26.e.class);
        if (r113 == null) goto L66;
        Boolean r114 = r113.r0();
        if (r114 == null) goto L66;
        boolean r115 = r114.booleanValue();
    L67:
        Boolean r116 = Boolean.FALSE;
        Boolean r117 = (Boolean) new y36.a(r210, "clear_url_params", r116).f565862b;
        int r106 = b.f548604a[r105.ordinal()];
        char r118 = '?';
        char r107 = Typography.amp;
        if (r106 == 1) goto L116;
        if (r106 == 2) goto L71;
        return false;
    L71:
        r210.l();
        Intrinsics.checkNotNullParameter("bullet", "path");
        r210.f248128e = "bullet";
        if (Intrinsics.areEqual(r117, r116) == true) goto L74;
        if (r115 == false) goto L74;
    L180:
        return true;
    L74:
        LinkedHashMap r108 = (LinkedHashMap) r104;
        String r109 = (String) r108.get("url");
        String r119 = (String) r108.get("res_url");
        if (r119 != null) goto L77;
        r119 = (String) r108.get("surl");
    L77:
        if (r119 != null) goto L81;
        if (r109 != null) goto L82;
        r109 = null;
    L82:
        ConcurrentHashMap<String, ResourceLoaderService> r120 = i.f246824a;
        a26.a r121 = i.b(this.f548601a, 2).i(r109);
        String r122 = "channel";
        if (r121 == null) goto L86;
        String r123 = r121.a();
        if (r123 == null) goto L86;
    L87:
        String r124 = "bundle";
        if (r121 == null) goto L91;
        String r125 = r121.b();
        if (r125 == null) goto L91;
    L92:
        Bundle r126 = r210.f248125b;
        if (r126 == null) goto L98;
        if (r123 == null) goto L96;
        r126.putString("__x_param_channel", r123);
    L96:
        if (r125 == null) goto L98;
        r126.putString("__x_param_bundle", r125);
    L98:
        StringBuilder r127 = new StringBuilder("lynxview://");
        if (r123 == null) goto L102;
        r122 = r123;
    L102:
        r127.append(r122);
        r127.append('/');
        if (r125 == null) goto L106;
        r124 = r125;
    L106:
        r127.append(r124);
        r127.append('?');
        Iterator r128 = r108.entrySet().iterator();
        boolean r129 = true;
    L108:
        if (r128.hasNext() == false) goto L115;
        Map.Entry r130 = (Map.Entry) r128.next();
        if (f548600d.contains(r130.getKey()) == true) goto L108;
        if (r129 == false) goto L113;
        r129 = false;
    L114:
        r127.append(Uri.encode((String) r130.getKey()));
        r127.append(com.alipay.sdk.m.n.a.f25612h);
        r127.append(Uri.encode((String) r130.getValue()));
        goto L108
    L113:
        r127.append(Typography.amp);
        goto L114
    L115:
        r210.a("url", new p(r127.toString()), true);
    L91:
        r125 = (String) r108.get("bundle");
    L86:
        r123 = (String) r108.get("channel");
        goto L87
    L81:
        r109 = r119;
        goto L82
    L116:
        r210.l();
        Intrinsics.checkNotNullParameter("bullet", "path");
        r210.f248128e = "bullet";
        LinkedHashMap r131 = (LinkedHashMap) r104;
        String r132 = (String) r131.get("url");
        if (r132 == null) goto L124;
        Map<String, com.bytedance.ies.bullet.web.pia.c.a> r133 = com.bytedance.ies.bullet.web.pia.c.f248301a;
        if (com.bytedance.ies.bullet.web.pia.c.d(r132, this.f548601a, null) == false) goto L124;
        T r134 = new y36.a(r210, "disable_pia", null).f565862b;
        Boolean r135 = Boolean.TRUE;
        if (Intrinsics.areEqual(r134, r135) == true) goto L124;
        r210.a("__x_param_pia", new y36.a(r135), false);
    L124:
        if (Intrinsics.areEqual(r117, r116) == true) goto L126;
        if (r115 == true) goto L180;
    L126:
        String r136 = (String) r131.get("url");
        if (r136 == null) goto L180;
        int r137 = StringsKt.indexOf$default(r136, '?', 0, false, 6, null);
        if (r137 != (-1)) goto L131;
        String r138 = r136;
    L132:
        if (r137 != (-1)) goto L134;
        int r139 = -1;
    L135:
        if (r139 == (-1)) goto L138;
        r110 = r136.substring(r139, r136.length());
    L138:
        StringBuilder r140 = new StringBuilder(r138);
        Iterator r141 = r131.entrySet().iterator();
        boolean r142 = true;
    L140:
        if (r141.hasNext() == false) goto L179;
        Map.Entry r143 = (Map.Entry) r141.next();
        if (Intrinsics.areEqual(r143.getKey(), "url") == true) goto L178;
        if (f548600d.contains(r143.getKey()) == true) goto L178;
        if (r142 == false) goto L147;
        r140.append(r118);
        r142 = false;
    L149:
        if (Intrinsics.areEqual(this.f548601a, "webcast") == false) goto L176;
        if (Intrinsics.areEqual(r143.getKey(), "token") == false) goto L176;
        Map<String, Map<Class<?>, Object>> r144 = x26.a.f562251a;
        g r145 = (g) x26.a.a(g.class);
        if (r145 == null) goto L159;
        w26.e r146 = (w26.e) r145.n0(w26.e.class);
        if (r146 == null) goto L159;
        List<String> r147 = r146.o();
        if (r147 == null) goto L159;
    L160:
        List<String> r148 = r147;
        if ((r148 instanceof Collection) == true) goto L163;
    L165:
        Iterator<T> r149 = r148.iterator();
    L167:
        if (r149.hasNext() == false) goto L172;
        if (StringsKt.contains$default(r138, (String) r149.next(), false, 2, null) == false) goto L167;
        boolean r150 = true;
    L173:
        if (r150 == false) goto L176;
        r140.append(Uri.encode((String) r143.getKey()));
        r140.append(com.alipay.sdk.m.n.a.f25612h);
        r140.append((String) r143.getValue());
    L172:
        r150 = false;
        goto L173
    L163:
        if (r148.isEmpty() == false) goto L165;
    L159:
        r147 = CollectionsKt.emptyList();
    L176:
        r140.append(Uri.encode((String) r143.getKey()));
        r140.append(com.alipay.sdk.m.n.a.f25612h);
        r140.append(Uri.encode((String) r143.getValue()));
        goto L178
    L147:
        r140.append(r107);
    L178:
        r107 = Typography.amp;
        r118 = '?';
        goto L140
    L179:
        r140.append(r110);
        r210.a("url", new p(r140.toString()), true);
        goto L180
    L134:
        r139 = StringsKt.indexOf$default(r136, '#', r137 + 1, false, 4, null);
        goto L135
    L131:
        r138 = r136.substring(0, r137);
    L66:
        r115 = true;
        goto L67
    L27:
        String r151 = r210.getHost();
        if (r151 != null) goto L31;
        r151 = "";
    L31:
        switch(r151.hashCode()) {
            case -1932693274: goto L56;
            case -1772600516: goto L52;
            case -1001735703: goto L49;
            case 862922167: goto L46;
            case 981209732: goto L43;
            case 1224424441: goto L40;
            case 1630240178: goto L37;
            case 2015851285: goto L34;
            default: goto L58;
        };
    L58:
        r105 = KitType.UNKNOWN;
        goto L59
    L34:
        if (r151.equals("webview_page") == false) goto L58;
    L57:
        r105 = KitType.WEB;
        goto L59
    L37:
        if (r151.equals("lynxview_page") == false) goto L58;
    L54:
        r105 = KitType.LYNX;
        goto L59
    L40:
        if (r151.equals("webview") == true) goto L57;
    L43:
        if (r151.equals("lynx_popup") == true) goto L54;
    L46:
        if (r151.equals("lynx_page") == true) goto L54;
    L49:
        if (r151.equals("lynxview_popup") == true) goto L54;
    L52:
        if (r151.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == true) goto L54;
    L56:
        if (r151.equals(AppConstants.HOST_WEBVIEW_DIALOG) == false) goto L58;
    L22:
        if (Intrinsics.areEqual(r210.f248127d, "https") == false) goto L24;
        goto L23
    }
}
