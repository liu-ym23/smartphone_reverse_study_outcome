package s45;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class j extends p {
    public final Provider<com.bytedance.ee.bear.document.template.a> v;

    public final String k(String r5) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ark_domain");     // Catch: Throwable -> L4
    L6:
        if (r0 == false) goto L8;
        String r1 = f9();
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L12;
        return r1;
    L12:
        if (TextUtils.isEmpty(r5) == false) goto L15;
        r5 = "";
    L15:
        return r5;
    L8:
        r1 = p.t;
    L4:
        th = move-exception;
        tt5.a.e("OfficeSpaceKitUrlHelper", "isMgMainDomainEnable failed", th, false);
        r0 = false;
        goto L6
    }

    @Override // s45.p, t45.c
    public final String T6(String r4, Integer r5) {
        if (r5 != null) goto L5;
        return r4;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L26;
        int r6 = r5.intValue();
        if (fx4.a.c(r6) == true) goto L9;
    L11:
        boolean r7 = false;
    L12:
        if (r7 == false) goto L26;
        String r8 = k(null);
        if (TextUtils.isEmpty(r8) == false) goto L27;
        return r4;
    L27:
        Uri r0 = UriProtector.parse(r4);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r0.getScheme()) == false) goto L20;
        return r4;
    L20:
        if (TextUtils.isEmpty(r0.getHost()) == true) goto L30;
        return r0.buildUpon().authority(r8).build().toString();
    L30:
        return r4;
    L24:
        th = move-exception;
        tt5.a.e("OfficeSpaceKitUrlHelper", "concatUrlForDoubao failed", th, false);
        goto L26
    L9:
        if (fx4.a.e(r6) == true) goto L11;
        r7 = true;
    L26:
        return r4;
    }

    public final String l(String r4, String r5) {
        if (fx4.a.d(r5) == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
        com.bytedance.ee.bear.document.template.a r7 = (com.bytedance.ee.bear.document.template.a) this.v.get();     // Catch: Throwable -> L16
        if (r7 == null) goto L19;
        String r8 = r7.y0();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r8) == true) goto L19;
        return r8;
    L19:
        if (TextUtils.isEmpty(r4) == false) goto L22;
        r4 = "";
    L22:
        return r4;
    L16:
        th = move-exception;
        tt5.a.e("OfficeSpaceKitUrlHelper", "getTemplateDomain failed", th, false);
        goto L19
    L10:
        return k(r4);
    L5:
        if (fx4.a.e(sbb.e.g(r5)) == true) goto L7;
        r6 = true;
        goto L8
    }

    @Override // s45.p, t45.c
    public final String ua(String r2, String r3, String r4) {
        return J8(r2, r3, r4, null);
    }

    @Inject
    public j(c r1, awa.d r2, f r3, Provider r4) {
        super(r1, r2, r3);
        this.v = r4;
    }

    @Override // s45.p, t45.c
    public final String J8(String r3, String r4, String r5, String r6) {
        String r7 = a9(r3, r4);
        if (r7 != null) goto L5;
    L7:
        Uri.Builder r8 = new Uri.Builder().scheme("https").authority(l(null, r3)).appendEncodedPath(r7);
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r8.appendQueryParameter(DocRedirectToDocxPlugin.FROM, r5);
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L14;
        r8.appendQueryParameter("ccm_open_type", r6);
    L14:
        return r8.build().toString();
    L5:
        if (r7.startsWith("/") == false) goto L7;
        r7 = r7.substring(1);
        goto L7
    }

    @Override // s45.p, t45.c
    public final String Te(String r3, String r4, String r5, Map<String, String> r6) {
        String r7 = a9(r4, r5);
        if (r7 != null) goto L5;
    L7:
        Uri.Builder r8 = new Uri.Builder().scheme("https").authority(l(r3, r4)).appendEncodedPath(r7);
        if (hu5.a.e(r6) == true) goto L18;
        Iterator<Map.Entry<String, String>> r9 = r6.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L18;
        Map.Entry<String, String> r10 = r9.next();
        if (r10 == null) goto L11;
        if (TextUtils.isEmpty(r10.getKey()) == true) goto L11;
        r8.appendQueryParameter(r10.getKey(), r10.getValue());
    L18:
        return r8.build().toString();
    L5:
        if (r7.startsWith("/") == false) goto L7;
        r7 = r7.substring(1);
        goto L7
    }
}
