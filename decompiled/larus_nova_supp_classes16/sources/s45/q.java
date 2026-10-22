package s45;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q extends sbb.a {
    public final f c;

    public q(f r1) {
        super(r1);
        this.c = r1;
    }

    public final BearUrl d(String r11) {
        BearUrl r0 = new BearUrl(r11);
        boolean r2 = true;
        int r3 = 0;
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        tt5.a.h("UrlParser", "parse()...url is null or is js function");
        return r0;
    L13:
        r0.a = sbb.e.e.getType();
        Uri r4 = UriProtector.parse(r11);
        if (r4.isHierarchical() == false) goto L50;
        Set r5 = UriProtector.getQueryParameterNames(r4);
        if (r5 == null) goto L50;
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L50;
        String r7 = (String) r6.next();
        String r8 = UriProtector.getQueryParameter(r4, r7);
        r0.d.put(r7, r8);
        if (TextUtils.equals(r7, "sourceType") == true) goto L22;
        if (TextUtils.equals(r7, "docId") == true) goto L25;
        if (TextUtils.equals(r7, "open_type") == true) goto L28;
        if (TextUtils.equals(r7, DocRedirectToDocxPlugin.FROM) == true) goto L31;
        if (TextUtils.equals(r7, "subFrom") == true) goto L34;
        if (TextUtils.equals(r7, "edition_id") == true) goto L37;
        if (TextUtils.equals(r7, "invite") == true) goto L40;
        if (TextUtils.equals(r7, "scene_id") == true) goto L43;
        if (TextUtils.equals(r7, "table") == true) goto L46;
        if (TextUtils.equals(r7, "doc_app_id") == false) goto L19;
        r0.r = r8;
        goto L19
    L46:
        r0.s = r8;
        goto L19
    L43:
        r0.q = r8;
        goto L19
    L40:
        r0.o = r8;
        goto L19
    L37:
        r0.n = r8;
        goto L19
    L34:
        r0.i = r8;
        goto L19
    L31:
        r0.h = r8;
        goto L19
    L28:
        r0.c = r8;
        goto L19
    L25:
        r0.g = r8;
        goto L19
    L22:
        r0.f = r8;
    L50:
        r0.p = r4.getFragment();
        String r9 = r4.getPath();
        r0.l = r9;
        a.C0288a r10 = a.e(r9);
        if (r10 == null) goto L55;
        r0.a = r10.getType();
        r0.b = r10.b;
        return r0;
    L55:
        if (TextUtils.isEmpty(r9) == false) goto L57;
    L62:
        boolean r12 = true;
    L64:
        if (r12 == false) goto L68;
        r0.a = "recent";
        tt5.a.h("UrlParser", "parseUrl()...type = " + r0.getType());
        return r0;
    L68:
        if (TextUtils.isEmpty(r11) == false) goto L71;
    L75:
        boolean r13 = false;
    L76:
        if (r13 == false) goto L144;
        if (r9 == null) goto L144;
        if (r9.startsWith("/page") == false) goto L83;
        r0.a = sbb.e.t.getType();
        r0.b = r4.getLastPathSegment();
        return r0;
    L83:
        if (r9.startsWith("/app") == false) goto L144;
        sbb.c.a.getClass();
        if ((!idb.f.a().isEnable("ccm.workspace.miaoda_app_url_infer_disable")) == true) goto L87;
        r0.a = sbb.e.u.getType();
    L87:
        return r0;
    L144:
        boolean r14 = this.c.w.matcher(r9).matches();     // Catch: Exception -> L90
    L92:
        if (r14 == false) goto L111;
        Matcher r16 = ((sbb.b) this.c).b.matcher(r9);
    L104:
        e = move-exception;
        tt5.a.f("UrlParser", e, false);
    L106:
        tt5.a.h("UrlParser", "parseUrl()...type = " + r0.getType());
        if (TextUtils.isEmpty(r0.b) == true) goto L109;
        tt5.a.h("UrlParser", "parse()...subPath = " + r9.replace(r0.b, ""));
    L109:
        return r0;
    L95:
        if (r16.find() == false) goto L106;
        if (r16.end() <= r16.start()) goto L106;
        String r17 = r9.substring(r16.start() + 1, r16.end());     // Catch: Exception -> L104
        Matcher r18 = ((sbb.b) this.c).a.matcher(r9);     // Catch: Exception -> L104
        if (r18.find() == false) goto L106;
        if (r18.end() <= r18.start()) goto L106;
        r0.a = c(r9, r18);     // Catch: Exception -> L104
        r0.b = r17;     // Catch: Exception -> L104
        goto L106
    L111:
        if (r9.endsWith("/") == true) goto L113;
        r9 = r9.concat("/");
    L113:
        String r19 = (String) ((HashMap) this.c.s).get(r9);
        if (TextUtils.isEmpty(r19) == false) goto L116;
        r2 = false;
    L117:
        if (r2 == false) goto L120;
        return r0;
    L120:
        if (r9.startsWith("/wiki/space") == false) goto L126;
        String r110 = r4.getLastPathSegment();
        if (TextUtils.isEmpty(r110) == true) goto L126;
        r0.a = "wiki_space_home";
        r0.k = r110;
        return r0;
    L126:
        if (r9.startsWith("/wiki/trash") == false) goto L131;
        String r111 = r4.getLastPathSegment();
        if (TextUtils.isEmpty(r111) == true) goto L131;
        r0.a = "wiki_trash";
        r0.k = r111;
        return r0;
    L131:
        String[] r112 = sbb.f.e;
        int r20 = r112.length;
    L132:
        if (r3 >= r20) goto L139;
        if (r9.startsWith(r112[r3]) == true) goto L135;
        r3 = r3 + 1;
        goto L132
    L135:
        r0.a = "pay_operation";
        return r0;
    L139:
        if (r9.startsWith("/drive/listing") == false) goto L142;
        r0.a = "owner_list";
        return r0;
    L142:
        r0.a = sbb.e.e.getType();
        tt5.a.h("UrlParser", "parseUrl()...type = unknown");
        return r0;
    L116:
        r0.a = r19;
        tt5.a.h("UrlParser", "parse()...tab = " + r19);
    L90:
        e = move-exception;
        tt5.a.f("UrlParser", e, false);
        r14 = false;
        goto L92
    L71:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("apaas.miaoda.migrate_to_ccm") == false) goto L75;
        sbb.c.a.getClass();
        if (sbb.c.b(r11) == false) goto L75;
        r13 = true;
        goto L76
    L57:
        if (TextUtils.equals(r9, "/space") == true) goto L62;
        if (TextUtils.equals(r9, "/") == true) goto L62;
        r12 = false;
        goto L64
    L5:
        if (r11.startsWith("javascript:") == true) goto L8;
        r1 = false;
        goto L10
    }

    private String c(String r4, Matcher r5) {
        String r6 = r4.substring(r5.start() + 1, r5.end() - 1);
        sbb.e r7 = sbb.e.e;
        String r0 = r7.getType();
        if (TextUtils.isEmpty(r6) == false) goto L5;
        tt5.a.h("UrlParser", "getProductTypeName()....originType is empty");
        return r0;
    L5:
        String r1 = (String) ((HashMap) ((sbb.b) this.c).c).get(r6);
        if (TextUtils.isEmpty(r1) == false) goto L10;
        tt5.a.h("UrlParser", "getProductTypeName()...originType = " + r6);
        return r7.getType();
    L10:
        return r1;
    }
}
