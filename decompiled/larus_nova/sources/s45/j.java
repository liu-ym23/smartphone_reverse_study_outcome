package s45;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public final class j extends p {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Provider<com.bytedance.ee.bear.document.template.a> f540570v;

    public final String k(String r100) {
        boolean r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain");     // Catch: Throwable -> L4
    L6:
        if (r101 == false) goto L8;
        String r102 = f9();
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        return r102;
    L12:
        if (TextUtils.isEmpty(r100) == false) goto L15;
        r100 = "";
    L15:
        return r100;
    L8:
        r102 = p.f540583t;
    L4:
        th = move-exception;
        tt5.a.e("OfficeSpaceKitUrlHelper", "isMgMainDomainEnable failed", th, false);
        r101 = false;
        goto L6
    }

    @Override // s45.p, t45.c
    public final String T6(String r100, Integer r101) {
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L26;
        int r102 = r101.intValue();
        if (fx4.a.c(r102) == true) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L26;
        String r104 = k(null);
        if (TextUtils.isEmpty(r104) == false) goto L27;
        return r100;
    L27:
        Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r105.getScheme()) == false) goto L20;
        return r100;
    L20:
        if (TextUtils.isEmpty(r105.getHost()) == true) goto L30;
        return r105.buildUpon().authority(r104).build().toString();
    L30:
        return r100;
    L24:
        th = move-exception;
        tt5.a.e("OfficeSpaceKitUrlHelper", "concatUrlForDoubao failed", th, false);
        goto L26
    L9:
        if (fx4.a.e(r102) == true) goto L11;
        r103 = true;
    L26:
        return r100;
    }

    public final String l(String r100, String r101) {
        if (fx4.a.d(r101) == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        com.bytedance.ee.bear.document.template.a r103 = this.f540570v.get();     // Catch: Throwable -> L16
        if (r103 == null) goto L19;
        String r104 = r103.y0();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r104) == true) goto L19;
        return r104;
    L19:
        if (TextUtils.isEmpty(r100) == false) goto L22;
        r100 = "";
    L22:
        return r100;
    L16:
        th = move-exception;
        tt5.a.e("OfficeSpaceKitUrlHelper", "getTemplateDomain failed", th, false);
        goto L19
    L10:
        return k(r100);
    L5:
        if (fx4.a.e(sbb.e.g(r101)) == true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // s45.p, t45.c
    public final String ua(String r100, String r101, String r102) {
        return J8(r100, r101, r102, null);
    }

    @Inject
    public j(c r100, awa.d r101, f r102, Provider r103) {
        super(r100, r101, r102);
        this.f540570v = r103;
    }

    @Override // s45.p, t45.c
    public final String J8(String r100, String r101, String r102, String r103) {
        String r104 = a9(r100, r101);
        if (r104 != null) goto L5;
    L7:
        Uri.Builder r105 = new Uri.Builder().scheme("https").authority(l(null, r100)).appendEncodedPath(r104);
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r105.appendQueryParameter("from", r102);
    L11:
        if (TextUtils.isEmpty(r103) == true) goto L14;
        r105.appendQueryParameter("ccm_open_type", r103);
    L14:
        return r105.build().toString();
    L5:
        if (r104.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
        r104 = r104.substring(1);
        goto L7
    }

    @Override // s45.p, t45.c
    public final String Te(String r100, String r101, String r102, Map<String, String> r103) {
        String r104 = a9(r101, r102);
        if (r104 != null) goto L5;
    L7:
        Uri.Builder r105 = new Uri.Builder().scheme("https").authority(l(r100, r101)).appendEncodedPath(r104);
        if (hu5.a.e(r103) == true) goto L18;
        Iterator<Map.Entry<String, String>> r106 = r103.entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L18;
        Map.Entry<String, String> r107 = r106.next();
        if (r107 == null) goto L11;
        if (TextUtils.isEmpty(r107.getKey()) == true) goto L11;
        r105.appendQueryParameter(r107.getKey(), r107.getValue());
    L18:
        return r105.build().toString();
    L5:
        if (r104.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
        r104 = r104.substring(1);
        goto L7
    }
}
