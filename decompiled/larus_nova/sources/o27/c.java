package o27;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f521785e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f521786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f521787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f521788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f521789d;

    public static c a() {
        if (f521785e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f521785e != null) goto L9;
        f521785e = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f521785e;
    }

    public c() {
        this.f521786a = 0;
        this.f521787b = true;
        this.f521788c = new ArrayList();
        this.f521789d = false;
    }
}
