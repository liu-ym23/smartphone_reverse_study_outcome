package un5;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.contract.i0;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class l extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f550814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f550815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f550816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f550817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f550818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap<String, String> f550819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f550820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f550821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f550822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f550823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f550824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f550825n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f550826o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f550827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f550828q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f550829r;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    public final boolean g1() {
        return false;
    }

    public final String a() {
        String r100 = this.f550817f;
        String r101 = ((i0) org.koin.java.a.a(i0.class)).a();
        if (r101 != null) goto L6;
        r101 = Locale.getDefault().getLanguage();
    L6:
        if (ou5.a.e() == false) goto L31;
        HashMap<String, String> r102 = this.f550819h;
        if (idb.f.a().isEnable("ccm.bytedance_english_name_fallback") == true) goto L10;
        String r103 = this.f550817f;
    L15:
        if (TextUtils.equals(r101, Locale.CHINA.getLanguage()) == false) goto L20;
        if (TextUtils.isEmpty(this.f550817f) == true) goto L27;
        r103 = this.f550817f;
    L27:
        String r104 = ou5.a.c(r101, r102, r103);
        if (TextUtils.isEmpty(r104) == true) goto L54;
        r100 = r104;
    L54:
        tt5.a.b("UserSpan", "displayName:" + r100);
        if (TextUtils.isEmpty(r100) == false) goto L59;
        return this.f550820i;
    L59:
        return "@" + r100;
    L20:
        if (TextUtils.equals(r101, Locale.US.getLanguage()) == false) goto L27;
        if (TextUtils.isEmpty(this.f550818g) == true) goto L25;
        r103 = this.f550818g;
        goto L27
    L25:
        if (TextUtils.isEmpty(this.f550817f) == true) goto L27;
        r103 = this.f550817f;
        goto L27
    L10:
        if (TextUtils.isEmpty(this.f550818g) == true) goto L12;
        r103 = this.f550818g;
        goto L15
    L12:
        r103 = this.f550817f;
        goto L15
    L31:
        if (TextUtils.equals(Locale.ENGLISH.getLanguage(), r101) == false) goto L41;
        HashMap<String, String> r105 = this.f550819h;
        if (r105 == null) goto L38;
        if (TextUtils.isEmpty(ou5.c.b(r105)) == true) goto L38;
        r100 = ou5.c.b(this.f550819h);
    L38:
        if (TextUtils.isEmpty(this.f550818g) == true) goto L54;
        r100 = this.f550818g;
        goto L54
    L41:
        if (TextUtils.equals(Locale.JAPANESE.getLanguage(), r101) == false) goto L48;
        HashMap<String, String> r106 = this.f550819h;
        if (r106 == null) goto L54;
        if (TextUtils.isEmpty(ou5.c.d(r106)) == true) goto L54;
        r100 = ou5.c.d(this.f550819h);
        goto L54
    L48:
        if (TextUtils.equals(Locale.CHINESE.getLanguage(), r101) == false) goto L54;
        HashMap<String, String> r107 = this.f550819h;
        if (r107 == null) goto L54;
        if (TextUtils.isEmpty(ou5.c.a(r107)) == true) goto L54;
        r100 = ou5.c.a(this.f550819h);
        goto L54
    }

    public final int b() {
        int r100 = this.f550814c.getResources().getColor(R.color.text_link_normal);
        int r101 = this.f550773b;
        if (r101 == (-1)) goto L6;
        return r101;
    L6:
        if (this.f550821j == true) goto L8;
        return r100;
    L8:
        return this.f550814c.getResources().getColor(R.color.text_caption);
    }

    @Override // un5.a, android.text.style.ClickableSpan
    public final void onClick(View r100) {
        super.onClick(r100);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(b());
    }

    public l(Context r110, String r111, String r112, String r113, boolean r114, String r115) {
        this(r110, r111, r112, r113, false, null, r114, r115, null);
    }

    public l(Context r110, String r111, String r112, String r113, boolean r114, String r115, boolean r210, String r211, a.InterfaceC7903a r212) {
        this(r110, null, r111, null, r112, r113, null, r114, r115, r210, r211, r212);
    }

    public l(Context r100, String r101, String r102, String r103, String r104, String r105, HashMap<String, String> r106, boolean r107, String r110, boolean r111, String r112, a.InterfaceC7903a r113) {
        this.f550828q = 0;
        this.f550829r = null;
        this.f550814c = r100;
        this.f550820i = r101;
        this.f550815d = r102;
        this.f550816e = r103;
        this.f550817f = r104;
        this.f550818g = r105;
        this.f550819h = r106;
        this.f550823l = r107;
        this.f550825n = r110;
        this.f550826o = r111;
        this.f550829r = r112;
        this.f550772a = r113;
    }
}
