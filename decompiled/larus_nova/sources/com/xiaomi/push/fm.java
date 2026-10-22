package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class fm extends fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f463556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f463557b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f463558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f463559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f463560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f463561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f463562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f463563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f463564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f463565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f463566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f463567l;

    @Override // com.xiaomi.push.fn
    /* JADX INFO: renamed from: a */
    public String mo9099a() {
        StringBuilder r100 = new StringBuilder("<message");
        if (p() == null) goto L6;
        r100.append(" xmlns=\"");
        r100.append(p());
        r100.append("\"");
    L6:
        if (this.f463559d == null) goto L9;
        r100.append(" xml:lang=\"");
        r100.append(h());
        r100.append("\"");
    L9:
        if (j() == null) goto L12;
        r100.append(" id=\"");
        r100.append(j());
        r100.append("\"");
    L12:
        if (l() == null) goto L15;
        r100.append(" to=\"");
        r100.append(fw.a(l()));
        r100.append("\"");
    L15:
        if (TextUtils.isEmpty(d()) == true) goto L18;
        r100.append(" seq=\"");
        r100.append(d());
        r100.append("\"");
    L18:
        if (TextUtils.isEmpty(e()) == true) goto L21;
        r100.append(" mseq=\"");
        r100.append(e());
        r100.append("\"");
    L21:
        if (TextUtils.isEmpty(f()) == true) goto L24;
        r100.append(" fseq=\"");
        r100.append(f());
        r100.append("\"");
    L24:
        if (TextUtils.isEmpty(g()) == true) goto L27;
        r100.append(" status=\"");
        r100.append(g());
        r100.append("\"");
    L27:
        if (m() == null) goto L30;
        r100.append(" from=\"");
        r100.append(fw.a(m()));
        r100.append("\"");
    L30:
        if (k() == null) goto L33;
        r100.append(" chid=\"");
        r100.append(fw.a(k()));
        r100.append("\"");
    L33:
        if (this.f463556a == false) goto L36;
        r100.append(" transient=\"true\"");
    L36:
        if (TextUtils.isEmpty(this.f463563h) == true) goto L39;
        r100.append(" appid=\"");
        r100.append(c());
        r100.append("\"");
    L39:
        if (TextUtils.isEmpty(this.f463557b) == true) goto L42;
        r100.append(" type=\"");
        r100.append(this.f463557b);
        r100.append("\"");
    L42:
        if (this.f579b == false) goto L44;
        r100.append(" s=\"1\"");
    L44:
        r100.append(">");
        if (this.f463560e == null) goto L48;
        r100.append("<subject>");
        r100.append(fw.a(this.f463560e));
        r100.append("</subject>");
    L48:
        if (this.f463561f == null) goto L54;
        r100.append("<body");
        if (TextUtils.isEmpty(this.f463562g) == true) goto L52;
        r100.append(" encode=\"");
        r100.append(this.f463562g);
        r100.append("\"");
    L52:
        r100.append(">");
        r100.append(fw.a(this.f463561f));
        r100.append("</body>");
    L54:
        if (this.f463558c == null) goto L57;
        r100.append("<thread>");
        r100.append(this.f463558c);
        r100.append("</thread>");
    L57:
        if ("error".equalsIgnoreCase(this.f463557b) == false) goto L61;
        fr r101 = m9100a();
        if (r101 == null) goto L61;
        r100.append(r101.m9103a());
    L61:
        r100.append(o());
        r100.append("</message>");
        return r100.toString();
    }

    @Override // com.xiaomi.push.fn
    public int hashCode() {
        String r100 = this.f463557b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f463561f;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f463558c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f463559d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f463560e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public fm() {
        this.f463557b = null;
        this.f463558c = null;
        this.f463556a = false;
        this.f463564i = "";
        this.f463565j = "";
        this.f463566k = "";
        this.f463567l = "";
        this.f579b = false;
    }

    public String b() {
        return this.f463557b;
    }

    public String c() {
        return this.f463563h;
    }

    public String d() {
        return this.f463564i;
    }

    public String e() {
        return this.f463565j;
    }

    public String f() {
        return this.f463566k;
    }

    public String g() {
        return this.f463567l;
    }

    public String h() {
        return this.f463559d;
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle r100 = super.a();
        if (TextUtils.isEmpty(this.f463557b) == true) goto L5;
        r100.putString("ext_msg_type", this.f463557b);
    L5:
        String r101 = this.f463559d;
        if (r101 == null) goto L8;
        r100.putString("ext_msg_lang", r101);
    L8:
        String r102 = this.f463560e;
        if (r102 == null) goto L11;
        r100.putString("ext_msg_sub", r102);
    L11:
        String r103 = this.f463561f;
        if (r103 == null) goto L15;
        r100.putString("ext_msg_body", r103);
    L15:
        if (TextUtils.isEmpty(this.f463562g) == true) goto L17;
        r100.putString("ext_body_encode", this.f463562g);
    L17:
        String r104 = this.f463558c;
        if (r104 == null) goto L20;
        r100.putString("ext_msg_thread", r104);
    L20:
        String r105 = this.f463563h;
        if (r105 == null) goto L24;
        r100.putString("ext_msg_appid", r105);
    L24:
        if (this.f463556a == false) goto L27;
        r100.putBoolean("ext_msg_trans", true);
    L27:
        if (TextUtils.isEmpty(this.f463564i) == true) goto L30;
        r100.putString("ext_msg_seq", this.f463564i);
    L30:
        if (TextUtils.isEmpty(this.f463565j) == true) goto L33;
        r100.putString("ext_msg_mseq", this.f463565j);
    L33:
        if (TextUtils.isEmpty(this.f463566k) == true) goto L36;
        r100.putString("ext_msg_fseq", this.f463566k);
    L36:
        if (this.f579b == false) goto L39;
        r100.putBoolean("ext_msg_encrypt", true);
    L39:
        if (TextUtils.isEmpty(this.f463567l) == true) goto L41;
        r100.putString("ext_msg_status", this.f463567l);
    L41:
        return r100;
    }

    public fm(Bundle r100) {
        super(r100);
        this.f463557b = null;
        this.f463558c = null;
        this.f463556a = false;
        this.f463564i = "";
        this.f463565j = "";
        this.f463566k = "";
        this.f463567l = "";
        this.f579b = false;
        this.f463557b = r100.getString("ext_msg_type");
        this.f463559d = r100.getString("ext_msg_lang");
        this.f463558c = r100.getString("ext_msg_thread");
        this.f463560e = r100.getString("ext_msg_sub");
        this.f463561f = r100.getString("ext_msg_body");
        this.f463562g = r100.getString("ext_body_encode");
        this.f463563h = r100.getString("ext_msg_appid");
        this.f463556a = r100.getBoolean("ext_msg_trans", false);
        this.f579b = r100.getBoolean("ext_msg_encrypt", false);
        this.f463564i = r100.getString("ext_msg_seq");
        this.f463565j = r100.getString("ext_msg_mseq");
        this.f463566k = r100.getString("ext_msg_fseq");
        this.f463567l = r100.getString("ext_msg_status");
    }

    public void a(String r100) {
        this.f463563h = r100;
    }

    public void b(String r100) {
        this.f463564i = r100;
    }

    public void c(String r100) {
        this.f463565j = r100;
    }

    public void d(String r100) {
        this.f463566k = r100;
    }

    public void e(String r100) {
        this.f463567l = r100;
    }

    @Override // com.xiaomi.push.fn
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L50:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L50;
        fm r101 = (fm) r100;
        if (super.equals(r101) == true) goto L13;
        return false;
    L13:
        String r102 = this.f463561f;
        if (r102 == null) goto L19;
        if (r102.equals(r101.f463561f) == false) goto L20;
    L21:
        String r103 = this.f463559d;
        if (r103 == null) goto L27;
        if (r103.equals(r101.f463559d) == false) goto L28;
    L29:
        String r104 = this.f463560e;
        if (r104 == null) goto L35;
        if (r104.equals(r101.f463560e) == false) goto L36;
    L37:
        String r105 = this.f463558c;
        if (r105 == null) goto L43;
        if (r105.equals(r101.f463558c) == true) goto L46;
    L44:
        return false;
    L46:
        if (this.f463557b == r101.f463557b) goto L51;
        return false;
    L51:
        return true;
    L43:
        if (r101.f463558c == null) goto L46;
    L36:
        return false;
    L35:
        if (r101.f463560e == null) goto L37;
    L28:
        return false;
    L27:
        if (r101.f463559d == null) goto L29;
    L20:
        return false;
    L19:
        if (r101.f463561f == null) goto L21;
        goto L20
    }

    public void f(String r100) {
        this.f463557b = r100;
    }

    public void g(String r100) {
        this.f463560e = r100;
    }

    public void h(String r100) {
        this.f463561f = r100;
    }

    public void i(String r100) {
        this.f463558c = r100;
    }

    public void j(String r100) {
        this.f463559d = r100;
    }

    public void a(boolean r100) {
        this.f463556a = r100;
    }

    public void b(boolean r100) {
        this.f579b = r100;
    }

    public void a(String r100, String r101) {
        this.f463561f = r100;
        this.f463562g = r101;
    }
}
