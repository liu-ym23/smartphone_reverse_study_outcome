package vy2;

import org.json.JSONObject;
import py2.k;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends ny2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f557586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f557587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ny2.b f557588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final py2.a f557589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py2.b f557590e;

    @Override // ny2.g
    public final JSONObject b() {
        return null;
    }

    @Override // ny2.g
    public final JSONObject g() {
        return null;
    }

    @Override // ny2.g
    public final String getContainerType() {
        return this.f557587b.f531014c;
    }

    @Override // ny2.g
    public final String getEventType() {
        ny2.b r100 = this.f557588c;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.f521188a;
    }

    @Override // ny2.g
    public final ny2.f a() {
        return this.f557587b;
    }

    @Override // ny2.g
    public final py2.a c() {
        return this.f557589d;
    }

    @Override // ny2.g
    public final ny2.f d() {
        return this.f557590e;
    }

    @Override // ny2.g
    public final ny2.b f() {
        return this.f557588c;
    }

    @Override // ny2.g
    public final String getBiz() {
        return this.f557586a;
    }

    public e(k r100, ny2.b r101, py2.a r102, py2.b r103) {
        this.f557587b = r100;
        this.f557588c = r101;
        this.f557589d = r102;
        this.f557590e = r103;
    }
}
