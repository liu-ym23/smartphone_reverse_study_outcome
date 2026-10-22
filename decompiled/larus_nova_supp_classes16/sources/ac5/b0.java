package ac5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReport;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0 extends com.bytedance.ee.bear.route.a {
    public final String e(BearUrl r1, RouteBean r2) {
        return "/list/template4/activity";
    }

    public b0() {
    }

    public final boolean b(final Context r43, BearUrl r44, RouteBean r46) {
        String r2 = "";
        boolean r3 = TextUtils.equals("template_center", r44.a);
        if (r3 == false) goto L113;
        tt5.a.h("TempCenterRouteInterceptor", "dispatchUrl()..." + r44.a);
        final HashMap r4 = new HashMap();
        if (r46 == null) goto L11;
        Map r6 = r46.k;
        if (r6 == null) goto L11;
        if (r6.size() <= 0) goto L11;
        r4.putAll(r46.k);
    L11:
        Map<String, String> r1 = r44.d;
        if (r1 != null) goto L14;
    L16:
        int r8 = -1;
        String r9 = null;
    L105:
        e = e;
        long r10 = -1;
        String r7 = null;
        String r12 = null;
    L107:
        int r13 = r8;
        boolean r14 = false;
    L108:
        String r11 = r7;
        long r16 = r10;
        long r18 = r16;
        String r47 = r2;
        String r5 = r47;
        final String r17 = r5;
    L109:
        boolean r19 = false;
    L110:
        tt5.a.f("TempCenterRouteInterceptor", e, r19);
        String r0 = r47;
        long r30 = r16;
        String r20 = r11;
        String r21 = r9;
        long r28 = r10;
        String r27 = r12;
        int r33 = r13;
        boolean r34 = r14;
        String r36 = r17;
        String r32 = r2;
        long r26 = r18;
    L111:
        Flowable r110 = Flowable.just("/list/template4/activity");
        final String r22 = r5;
        final String r111 = r0;
        final String r112 = r21;
        final long r113 = r26;
        final String r114 = r20;
        final String r115 = r27;
        final long r116 = r28;
        final long r117 = r30;
        final String r23 = r32;
        final int r24 = r33;
        final boolean r29 = r34;
        final String r210 = r36;
        Consumer r118 = new q(this, r43, r22, r111, r112, r113, r114, r115, r116, r117, r23, r24, r29, r210, r4);
        final String r119 = r27;
        r110.subscribe(r118, new s(this, r43, r22, r111, r112, r113, r114, r119, r116, r117, r23, r24, r29, r210, r4));
        return r3;
    L18:
        if (r4.size() <= 1) goto L103;
        String r120 = (String) r4.get(DocRedirectToDocxPlugin.FROM);     // Catch: Exception -> L105
        r12 = (String) r4.get("openType");     // Catch: Exception -> L101
        r13 = yu5.c.f((String) r4.get("objType"), -1);     // Catch: Exception -> L99
        r14 = TextUtils.equals((CharSequence) r4.get("fixedFilter"), Boolean.TRUE.toString());     // Catch: Exception -> L97
        final String r31 = (String) r4.get("id");     // Catch: Exception -> L95
        if (r31 != null) goto L26;
        r31 = (String) r4.get("topicId");     // Catch: Exception -> L95
    L26:
        r17 = (String) r4.get("templateSource");     // Catch: Exception -> L95
        if (r17 != null) goto L29;
        r17 = (String) r4.get("enterSource");     // Catch: Exception -> L95
    L29:
        if (r17 != null) goto L126;
        r17 = "link";
    L126:
        String r37 = (String) r4.get(JSEventListener.ACTION);     // Catch: Exception -> L92
        if ("create".equals(r37) == false) goto L39;
        int r38 = yu5.c.f((String) r4.get("type"), 0);     // Catch: Exception -> L92
        String r39 = (String) r4.get("clickFrom");     // Catch: Exception -> L92
        String r40 = (String) r4.get("templateID");     // Catch: Exception -> L92
        if (TextUtils.isEmpty(r40) == true) goto L37;
        f("", r38, r39, true, r40);     // Catch: Exception -> L92
        goto L113
    L37:
        f((String) r4.get("token"), r38, r39, false, "");     // Catch: Exception -> L92
        goto L113
    L39:
        if ("preview".equals(r37) == false) goto L44;
        final String r41 = (String) r4.get("templateType");     // Catch: Exception -> L92
        if (String.valueOf(2).equals(r41) == false) goto L43;
        ((wn5.a) org.koin.java.a.a(wn5.a.class)).j(r31).map(new x()).subscribe(new y(r31, r41), new z());     // Catch: Exception -> L92
        goto L113
    L43:
        ((wn5.a) org.koin.java.a.a(wn5.a.class)).l(r31, null, -1).subscribe(new v(r31, r17), new w());     // Catch: Exception -> L92
        goto L113
    L44:
        String r42 = (String) r4.get("openTemplateCenter");     // Catch: Exception -> L92
        String r48 = (String) r4.get("templateCategory");     // Catch: Exception -> L90
        if (r48 != null) goto L48;
        r48 = (String) r4.get("categoryId");     // Catch: Exception -> L90
    L48:
        String r49 = (String) r4.get("fromAppLink");     // Catch: Exception -> L90
        if (r48 == null) goto L55;
        String r121 = "";
        long r50 = -1;
        r18 = yu5.c.g(r48, -1);     // Catch: Exception -> L53
    L56:
        if (r31 != null) goto L118;
        long r51 = -1;
    L124:
        String r52 = (String) r4.get("sceneId");     // Catch: Exception -> L85
        if (r52 == null) goto L70;
        String r53 = r120;
        long r122 = -1;
        long r54 = yu5.c.g(r52, -1);     // Catch: Exception -> L68
    L129:
    L83:
        e = e;
    L88:
        String r123 = r121;
    L89:
        r47 = r121;
        r2 = r49;
        r11 = r53;
        long r310 = r54;
        r9 = r42;
        r16 = r310;
        r5 = r123;
        r10 = r51;
        goto L109
    L72:
        if (TextUtils.isEmpty(r53) == true) goto L74;
        r123 = "chat";
    L77:
        if (TextUtils.equals(r17, "bitable_ws_landing_banner") == false) goto L80;
        r13 = sbb.e.i.b;     // Catch: Exception -> L81
        r14 = true;
    L81:
        e = e;
    L80:
        String r56 = r53;
        String r57 = r12;
        boolean r311 = r14;
        String r124 = r42;
        long r58 = r18;
        long r312 = r51;
        r2 = r49;
        r8 = r13;
        boolean r59 = r311;
        long r125 = r312;
    L104:
        r34 = r59;
        r32 = r2;
        r27 = r57;
        r26 = r58;
        r33 = r8;
        r30 = r54;
        r5 = r123;
        r28 = r125;
        r21 = r124;
        r36 = r17;
        r20 = r56;
        r0 = r121;
        goto L111
    L74:
        r123 = (String) r4.get("MODULE");     // Catch: Exception -> L83
        r121 = (String) r4.get("ROOT_TOKEN");     // Catch: Exception -> L81
    L68:
        e = e;
    L87:
        r54 = r122;
        goto L88
    L70:
        r53 = r120;
        r54 = -1;
    L85:
        e = e;
        r53 = r120;
        r122 = -1;
        goto L87
    L118:
        r51 = yu5.c.g(r31, r50);     // Catch: Exception -> L59
    L59:
        e = e;
        r50 = r18;
    L61:
        r18 = r50;
        r9 = r42;
        r47 = r121;
        r5 = r47;
        r19 = false;
        r16 = -1;
        r2 = r49;
        r11 = r120;
        r10 = -1;
    L53:
        e = e;
        goto L61
    L55:
        r121 = "";
        r50 = -1;
        r18 = -1;
    L90:
        e = e;
        r10 = -1;
        r9 = r42;
    L94:
        r11 = r120;
        r16 = r10;
        r18 = r16;
        r47 = r2;
        r5 = r47;
    L92:
        e = e;
        r10 = -1;
    L95:
        e = e;
        r2 = "";
        r7 = r120;
        r10 = -1;
    L97:
        e = e;
        r7 = r120;
        r10 = -1;
        r8 = r13;
    L99:
        e = e;
        r7 = r120;
        r10 = -1;
    L101:
        e = e;
        r7 = r120;
        r10 = -1;
        r12 = null;
        goto L107
    L103:
        r121 = "";
        r56 = null;
        r57 = null;
        r124 = null;
        r58 = -1;
        r125 = -1;
        r17 = "";
        r59 = false;
        r54 = -1;
        r123 = r17;
        goto L104
    L14:
        if (r1.size() <= 0) goto L16;
        r4.putAll(r44.d);
    L113:
        return r3;
    }

    public static void f(final String r1, final int r2, String r3, boolean r4, String r5) {
        String r0 = TemplateReport.a;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        TemplateReport.a = r3;
        new g0().b(new com.bytedance.ee.bear.list.create.l(r1, r2, r4, r5)).subscribe(new t(), new u(r1, r2));
    }

    public static void g(Context r4, String r5, String r6, String r7, String r8, Long r9, String r10, String r11, long r12, long r14, String r16, int r17, boolean r18, String r19, Map r20) {
        PostCard r0 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2(r5);
        if (r20 == null) goto L5;
        r0.n("extra_data_map", (Serializable) r20);
    L5:
        r0.i("MODULE", r6).i("ROOT_TOKEN", r7).i("openTemplateCenter", r8).f("templateCategory", r9.longValue()).i(DocRedirectToDocxPlugin.FROM, r10).i("openType", r11).f("topicId", r12).f("sceneId", r14).i("fromAppLink", r16).i("enterSource", r19).j("objType", r17).l("fixedFilter", r18).k(1).d(r4).e();
    }
}
