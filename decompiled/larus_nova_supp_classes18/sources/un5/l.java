package un5;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.contract.i0;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class l extends a {
    public final Context c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public HashMap<String, String> h;
    public final String i;
    public boolean j;
    public boolean k;
    public final boolean l;
    public boolean m;
    public final String n;
    public final boolean o;
    public String p;
    public int q;
    public final String r;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    public final boolean g1() {
        return false;
    }

    public final String a() {
        String r0 = this.f;
        String r1 = ((i0) org.koin.java.a.a(i0.class)).a();
        if (r1 != null) goto L6;
        r1 = Locale.getDefault().getLanguage();
    L6:
        if (ou5.a.e() == false) goto L31;
        HashMap<String, String> r2 = this.h;
        if (idb.f.a().isEnable("ccm.bytedance_english_name_fallback") == true) goto L10;
        String r3 = this.f;
    L15:
        if (TextUtils.equals(r1, Locale.CHINA.getLanguage()) == false) goto L20;
        if (TextUtils.isEmpty(this.f) == true) goto L27;
        r3 = this.f;
    L27:
        String r4 = ou5.a.c(r1, r2, r3);
        if (TextUtils.isEmpty(r4) == true) goto L54;
        r0 = r4;
    L54:
        tt5.a.b("UserSpan", "displayName:" + r0);
        if (TextUtils.isEmpty(r0) == false) goto L59;
        return this.i;
    L59:
        return "@" + r0;
    L20:
        if (TextUtils.equals(r1, Locale.US.getLanguage()) == false) goto L27;
        if (TextUtils.isEmpty(this.g) == true) goto L25;
        r3 = this.g;
        goto L27
    L25:
        if (TextUtils.isEmpty(this.f) == true) goto L27;
        r3 = this.f;
        goto L27
    L10:
        if (TextUtils.isEmpty(this.g) == true) goto L12;
        r3 = this.g;
        goto L15
    L12:
        r3 = this.f;
        goto L15
    L31:
        if (TextUtils.equals(Locale.ENGLISH.getLanguage(), r1) == false) goto L41;
        HashMap<String, String> r5 = this.h;
        if (r5 == null) goto L38;
        if (TextUtils.isEmpty(ou5.c.b(r5)) == true) goto L38;
        r0 = ou5.c.b(this.h);
    L38:
        if (TextUtils.isEmpty(this.g) == true) goto L54;
        r0 = this.g;
        goto L54
    L41:
        if (TextUtils.equals(Locale.JAPANESE.getLanguage(), r1) == false) goto L48;
        HashMap<String, String> r6 = this.h;
        if (r6 == null) goto L54;
        if (TextUtils.isEmpty(ou5.c.d(r6)) == true) goto L54;
        r0 = ou5.c.d(this.h);
        goto L54
    L48:
        if (TextUtils.equals(Locale.CHINESE.getLanguage(), r1) == false) goto L54;
        HashMap<String, String> r7 = this.h;
        if (r7 == null) goto L54;
        if (TextUtils.isEmpty(ou5.c.a(r7)) == true) goto L54;
        r0 = ou5.c.a(this.h);
        goto L54
    }

    public final int b() {
        int r0 = this.c.getResources().getColor(2131106616);
        int r1 = this.b;
        if (r1 == (-1)) goto L6;
        return r1;
    L6:
        if (this.j == true) goto L8;
        return r0;
    L8:
        return this.c.getResources().getColor(2131106607);
    }

    @Override // un5.a, android.text.style.ClickableSpan
    public final void onClick(View r1) {
        super.onClick(r1);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r2) {
        super.updateDrawState(r2);
        r2.setUnderlineText(false);
        r2.setColor(b());
    }

    public l(Context r11, String r12, String r13, String r14, boolean r15, String r16) {
        this(r11, r12, r13, r14, false, null, r15, r16, null);
    }

    public l(Context r14, String r15, String r16, String r17, boolean r18, String r19, boolean r20, String r21, a.InterfaceC0318a r22) {
        this(r14, null, r15, null, r16, r17, null, r18, r19, r20, r21, r22);
    }

    public l(Context r2, String r3, String r4, String r5, String r6, String r7, HashMap<String, String> r8, boolean r9, String r10, boolean r11, String r12, a.InterfaceC0318a r13) {
        this.q = 0;
        this.r = null;
        this.c = r2;
        this.i = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.l = r9;
        this.n = r10;
        this.o = r11;
        this.r = r12;
        this.a = r13;
    }
}
