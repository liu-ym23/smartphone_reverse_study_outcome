package j25;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f497001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f497002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f497003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f497004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f497005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f497006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f497007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f497008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f497009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f497010j;

    public String getType() {
        return null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f497004d) == false) goto L6;
        return this.f497005e;
    L6:
        return this.f497004d;
    }

    public final boolean b() {
        return TextUtils.isEmpty(this.f497004d);
    }

    public final String toString() {
        return "{token='" + yu5.c.j(this.f497002b) + "', doc_url='" + yu5.c.j(this.f497003c) + "', path='" + yu5.c.j(this.f497004d) + "', uri='" + yu5.c.j(this.f497005e) + "', type='null', local_url='" + yu5.c.j(this.f497006f) + "', net_url='" + yu5.c.j(this.f497007g) + "', upload_key='" + yu5.c.j(this.f497009i) + "', file_modified_time='" + this.f497008h + "'}";
    }

    public q() {
        this.f497004d = "";
        this.f497005e = "";
        this.f497008h = 0L;
    }

    public q(q r100) {
        this.f497004d = "";
        this.f497005e = "";
        this.f497008h = 0L;
        this.f497001a = r100.f497001a;
        this.f497002b = r100.f497002b;
        this.f497003c = r100.f497003c;
        this.f497004d = r100.f497004d;
        this.f497005e = r100.f497005e;
        this.f497006f = r100.f497006f;
        this.f497008h = r100.f497008h;
    }
}
