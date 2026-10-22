package r35;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bitable.preload.k;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class d extends com.bytedance.ee.bear.route.b {
    public final boolean b;
    public final boolean c;

    public d(com.bytedance.ee.bear.route.d... r3) {
        super(r3);
        this.b = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.slides_enabled");
        if (com.ss.android.lark.base.embedded.b.g() == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        this.c = r4;
        tt5.a.h("DocInterceptor", "isDefaultFoldCheckHit: " + r4);
        return;
    L5:
        if (com.ss.android.lark.base.embedded.f.a() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final String e(BearUrl r2, RouteBean r3) {
        if (wo5.c.a("ccm.mobile.android_doc_support_expand_page") == true) goto L5;
        return "/doc/detail/expand/activity";
    L5:
        if (r3 == null) goto L10;
        if (r3.o == false) goto L10;
        return "/doc/detail/expand/activity";
    L10:
        if (this.c == false) goto L12;
        return "/doc/detail/expand/activity";
    L12:
        return "/doc/detail/activity";
    }

    public boolean b(Context r10, final BearUrl r11, RouteBean r12) {
        if (this.b == true) goto L8;
        if (sbb.e.m.getType().equals(r11.a) == false) goto L8;
        return false;
    L8:
        if (((ArrayList) sbb.e.d).contains(r11.a) == true) goto L10;
        return false;
    L10:
        if (g(r10, r11, r12) == true) goto L46;
        tt5.a.h("DocInterceptor", "dispatchUrl()..." + r11.a);
        k r0 = (k) org.koin.java.a.a(k.class);     // Catch: Throwable -> L16
        if (r0.a() == false) goto L19;
        r0.preload(r11.e);     // Catch: Throwable -> L16
    L19:
        if (im5.d.a() == false) goto L21;
        com.bytedance.ee.bear.document.offline.sync.opendoc.k.e(r11);
    L22:
        String r1 = r11.a;
        sbb.e r4 = sbb.e.o;
        if (TextUtils.equals(r1, r4.getType()) == true) goto L25;
    L27:
        if (r12 != null) goto L30;
        r12 = new RouteBean();
    L30:
        if (ForsetiHelper.k() == false) goto L32;
        r12.s = new ArrayList(Arrays.asList(new String[]{r4.getType(), sbb.e.i.getType()})).contains(r11.a);
    L34:
        if (DocsOpenSource.template_preview.name().equals(r11.d.get(DocRedirectToDocxPlugin.FROM)) == true) goto L36;
    L38:
        PostCard r2 = h(r10, r11, r12);
        r2.e();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        if (PostCard.Type.FORSETI.equals(r2.getType()) == false) goto L45;
        tt5.a.e("DocInterceptor", "route by forseti error!", th, !eu5.c.d());
        r12.s = false;
        h(r10, r11, r12).e();
        goto L46
    L45:
        throw th;
    L36:
        if (DowngradeSettingUtil.a("downgradeForsetiTemplatePreview") == true) goto L38;
        r12.s = true;
        goto L38
    L32:
        r12.s = TextUtils.equals("docx", r11.getType());
        goto L34
    L25:
        if (TextUtils.equals(r11.d.remove("routeFromSync"), "true") == false) goto L27;
        r11.e = p.a().Fd(r11.e, r11.getType(), r11.b, r11.d);
        goto L27
    L21:
        d25.d.i();
        Flowable.just(r11).filter(new a()).observeOn(fo5.d.b()).subscribe(new b(r11), new c());
    L16:
        th = move-exception;
        tt5.a.l("DocInterceptor", "preload Bitable data failed", th);
    L46:
        return true;
    }

    public final PostCard h(Context r12, BearUrl r13, RouteBean r14) {
        String r0 = "";
        String r1 = "Docs";
        String r3 = r13.b;     // Catch: Throwable -> L26
        Map<String, String> r4 = r13.d;     // Catch: Throwable -> L23
        if (r4 == null) goto L15;
        String r5 = r4.get("sourceType");     // Catch: Throwable -> L23
        String r6 = r13.d.get("docId");     // Catch: Throwable -> L12
        boolean r7 = "template_preview".equals(r13.d.get(DocRedirectToDocxPlugin.FROM));     // Catch: Throwable -> L10
        r0 = r5;
    L78:
    L21:
        th = th;
    L29:
        tt5.a.h("DocInterceptor", "openDocEditor e " + th);
    L30:
        Bundle r16 = r14.n;
        if (r16 == null) goto L33;
        boolean r17 = r16.getBoolean("force_single_top", false);
    L35:
        if (TextUtils.isEmpty(r14.f) == true) goto L37;
        r1 = r14.f;
    L37:
        r14.q = RouteBean.DestStyle.FULL_SCREEN;
        Bundle r8 = r14.n;
        if (r8 != null) goto L40;
    L42:
        PostCard r2 = d(r13, r14).i("url", r13.e).o("bear_url", r13).i("node_name", r1).i("obj_token", r3).i("source_type", r0);
        FetchClientVarExecutor r9 = com.bytedance.ee.bear.document.offline.sync.opendoc.k.a;
        if (im5.d.a() == true) goto L45;
    L47:
        boolean r10 = false;
    L48:
        r2.l("enable_fetch_before_render", r10);
        if (r7 == true) goto L51;
        if (r17 == true) goto L51;
    L53:
        if (r13.b() == false) goto L55;
        r2.l("force_load_same", true);
    L55:
        boolean r18 = r14.d;
        r2.l("is_from_multi_task", r18);
        r2.j("extra_exit_anim", r14.b);
        if (r18 == false) goto L58;
        r2.m(335544320);
    L60:
        if (TextUtils.isEmpty(r14.f) == true) goto L62;
        r2.i("node_name", r14.f);
        r2.c("remind_binder", r14.e);
    L62:
        int r19 = r14.a;
        if (r19 == (-1)) goto L65;
        r2.g(r19, 0);
    L65:
        int r110 = r14.c;
        if (r110 == (-1)) goto L68;
        r2.k(r110);
    L68:
        Bundle r111 = r14.n;
        if (r111 == null) goto L71;
        r2.h(r111);
    L71:
        return r2;
    L58:
        r2.i("doc_feed_id", r6);
        r2.c("remind_binder", r14.e);
    L51:
        r2.m(536870912);
        goto L53
    L45:
        if (com.bytedance.ee.bear.document.offline.sync.opendoc.k.b(r13) == false) goto L47;
        r10 = true;
        goto L48
    L40:
        if (r8.getBoolean("single_top_in_forseti", false) == false) goto L42;
        r14.r = true;
        goto L42
    L33:
        r17 = false;
        goto L35
    L17:
        if (TextUtils.isEmpty(r13.a) == true) goto L30;
        if (r12 == null) goto L30;
        r1 = ng5.a.b(r12, sbb.e.e(r13.a).b);     // Catch: Throwable -> L21
    L10:
        th = th;
    L14:
        r0 = r5;
    L25:
        String r11 = r0;
        r0 = r3;
    L28:
        r7 = false;
        String r112 = r11;
        r3 = r0;
        r0 = r112;
    L12:
        th = th;
        r6 = "";
        goto L14
    L15:
        r6 = "";
        r7 = false;
    L23:
        th = th;
        r6 = "";
    L26:
        th = th;
        r11 = "";
        r6 = r11;
        goto L28
    }
}
