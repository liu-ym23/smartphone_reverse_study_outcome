package j25;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public Long h;
    public String i;
    public String j;

    public String getType() {
        return null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.d) == false) goto L6;
        return this.e;
    L6:
        return this.d;
    }

    public final boolean b() {
        return TextUtils.isEmpty(this.d);
    }

    public final String toString() {
        return "{token='" + yu5.c.j(this.b) + "', doc_url='" + yu5.c.j(this.c) + "', path='" + yu5.c.j(this.d) + "', uri='" + yu5.c.j(this.e) + "', type='null', local_url='" + yu5.c.j(this.f) + "', net_url='" + yu5.c.j(this.g) + "', upload_key='" + yu5.c.j(this.i) + "', file_modified_time='" + this.h + "'}";
    }

    public q() {
        this.d = "";
        this.e = "";
        this.h = 0L;
    }

    public q(q r3) {
        this.d = "";
        this.e = "";
        this.h = 0L;
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.h = r3.h;
    }
}
