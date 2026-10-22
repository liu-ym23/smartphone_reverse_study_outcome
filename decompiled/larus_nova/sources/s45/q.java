package s45;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.trace.CopyContentTypeString;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes16.dex */
public final class q extends sbb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f540604c;

    public q(f r100) {
        super(r100);
        this.f540604c = r100;
    }

    public final BearUrl d(String r110) {
        BearUrl r100 = new BearUrl(r110);
        boolean r101 = true;
        int r102 = 0;
        if (TextUtils.isEmpty(r110) == false) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        tt5.a.h("UrlParser", "parse()...url is null or is js function");
        return r100;
    L13:
        r100.f222560a = sbb.e.f541294e.getType();
        Uri r104 = UriProtector.parse(r110);
        if (r104.isHierarchical() == false) goto L50;
        Set<String> r105 = UriProtector.getQueryParameterNames(r104);
        if (r105 == null) goto L50;
        Iterator<String> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L50;
        String r107 = r106.next();
        String r108 = UriProtector.getQueryParameter(r104, r107);
        r100.f222563d.put(r107, r108);
        if (TextUtils.equals(r107, "sourceType") == true) goto L22;
        if (TextUtils.equals(r107, "docId") == true) goto L25;
        if (TextUtils.equals(r107, "open_type") == true) goto L28;
        if (TextUtils.equals(r107, "from") == true) goto L31;
        if (TextUtils.equals(r107, "subFrom") == true) goto L34;
        if (TextUtils.equals(r107, "edition_id") == true) goto L37;
        if (TextUtils.equals(r107, "invite") == true) goto L40;
        if (TextUtils.equals(r107, "scene_id") == true) goto L43;
        if (TextUtils.equals(r107, CopyContentTypeString.TABLE) == true) goto L46;
        if (TextUtils.equals(r107, "doc_app_id") == false) goto L19;
        r100.f222577r = r108;
        goto L19
    L46:
        r100.f222578s = r108;
        goto L19
    L43:
        r100.f222576q = r108;
        goto L19
    L40:
        r100.f222574o = r108;
        goto L19
    L37:
        r100.f222573n = r108;
        goto L19
    L34:
        r100.f222568i = r108;
        goto L19
    L31:
        r100.f222567h = r108;
        goto L19
    L28:
        r100.f222562c = r108;
        goto L19
    L25:
        r100.f222566g = r108;
        goto L19
    L22:
        r100.f222565f = r108;
    L50:
        r100.f222575p = r104.getFragment();
        String r109 = r104.getPath();
        r100.f222571l = r109;
        a.C7566a r111 = a.e(r109);
        if (r111 == null) goto L55;
        r100.f222560a = r111.getType();
        r100.f222561b = r111.f540547b;
        return r100;
    L55:
        if (TextUtils.isEmpty(r109) == false) goto L57;
    L62:
        boolean r112 = true;
    L64:
        if (r112 == false) goto L68;
        r100.f222560a = "recent";
        tt5.a.h("UrlParser", "parseUrl()...type = " + r100.getType());
        return r100;
    L68:
        if (TextUtils.isEmpty(r110) == false) goto L71;
    L75:
        boolean r113 = false;
    L76:
        if (r113 == false) goto L144;
        if (r109 == null) goto L144;
        if (r109.startsWith("/page") == false) goto L83;
        r100.f222560a = sbb.e.f541309t.getType();
        r100.f222561b = r104.getLastPathSegment();
        return r100;
    L83:
        if (r109.startsWith("/app") == false) goto L144;
        sbb.c.f541290a.getClass();
        if ((!idb.f.a().isEnable("ccm.workspace.miaoda_app_url_infer_disable")) == true) goto L87;
        r100.f222560a = sbb.e.f541310u.getType();
    L87:
        return r100;
    L144:
        boolean r114 = this.f540604c.f540564w.matcher(r109).matches();     // Catch: Exception -> L90
    L92:
        if (r114 == false) goto L111;
        Matcher r115 = this.f540604c.f541281b.matcher(r109);
    L104:
        e = move-exception;
        tt5.a.f("UrlParser", e, false);
    L106:
        tt5.a.h("UrlParser", "parseUrl()...type = " + r100.getType());
        if (TextUtils.isEmpty(r100.f222561b) == true) goto L109;
        tt5.a.h("UrlParser", "parse()...subPath = " + r109.replace(r100.f222561b, ""));
    L109:
        return r100;
    L95:
        if (r115.find() == false) goto L106;
        if (r115.end() <= r115.start()) goto L106;
        String r116 = r109.substring(r115.start() + 1, r115.end());     // Catch: Exception -> L104
        Matcher r117 = this.f540604c.f541280a.matcher(r109);     // Catch: Exception -> L104
        if (r117.find() == false) goto L106;
        if (r117.end() <= r117.start()) goto L106;
        r100.f222560a = c(r109, r117);     // Catch: Exception -> L104
        r100.f222561b = r116;     // Catch: Exception -> L104
        goto L106
    L111:
        if (r109.endsWith(HTTP.URL_DEFAULT) == true) goto L113;
        r109 = r109.concat(HTTP.URL_DEFAULT);
    L113:
        String r118 = (String) ((HashMap) this.f540604c.f540560s).get(r109);
        if (TextUtils.isEmpty(r118) == false) goto L116;
        r101 = false;
    L117:
        if (r101 == false) goto L120;
        return r100;
    L120:
        if (r109.startsWith("/wiki/space") == false) goto L126;
        String r119 = r104.getLastPathSegment();
        if (TextUtils.isEmpty(r119) == true) goto L126;
        r100.f222560a = "wiki_space_home";
        r100.f222570k = r119;
        return r100;
    L126:
        if (r109.startsWith("/wiki/trash") == false) goto L131;
        String r120 = r104.getLastPathSegment();
        if (TextUtils.isEmpty(r120) == true) goto L131;
        r100.f222560a = "wiki_trash";
        r100.f222570k = r120;
        return r100;
    L131:
        String[] r121 = sbb.f.f541323e;
        int r122 = r121.length;
    L132:
        if (r102 >= r122) goto L139;
        if (r109.startsWith(r121[r102]) == true) goto L135;
        r102 = r102 + 1;
        goto L132
    L135:
        r100.f222560a = "pay_operation";
        return r100;
    L139:
        if (r109.startsWith("/drive/listing") == false) goto L142;
        r100.f222560a = "owner_list";
        return r100;
    L142:
        r100.f222560a = sbb.e.f541294e.getType();
        tt5.a.h("UrlParser", "parseUrl()...type = unknown");
        return r100;
    L116:
        r100.f222560a = r118;
        tt5.a.h("UrlParser", "parse()...tab = " + r118);
    L90:
        e = move-exception;
        tt5.a.f("UrlParser", e, false);
        r114 = false;
        goto L92
    L71:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("apaas.miaoda.migrate_to_ccm") == false) goto L75;
        sbb.c.f541290a.getClass();
        if (sbb.c.b(r110) == false) goto L75;
        r113 = true;
        goto L76
    L57:
        if (TextUtils.equals(r109, "/space") == true) goto L62;
        if (TextUtils.equals(r109, HTTP.URL_DEFAULT) == true) goto L62;
        r112 = false;
        goto L64
    L5:
        if (r110.startsWith("javascript:") == true) goto L8;
        r103 = false;
        goto L10
    }

    private String c(String r100, Matcher r101) {
        String r102 = r100.substring(r101.start() + 1, r101.end() - 1);
        sbb.e r103 = sbb.e.f541294e;
        String r104 = r103.getType();
        if (TextUtils.isEmpty(r102) == false) goto L5;
        tt5.a.h("UrlParser", "getProductTypeName()....originType is empty");
        return r104;
    L5:
        String r105 = (String) ((HashMap) this.f540604c.f541282c).get(r102);
        if (TextUtils.isEmpty(r105) == false) goto L10;
        tt5.a.h("UrlParser", "getProductTypeName()...originType = " + r102);
        return r103.getType();
    L10:
        return r105;
    }
}
