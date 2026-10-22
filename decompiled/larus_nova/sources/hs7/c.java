package hs7;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static c f487054h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f487055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f487056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f487057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f487058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<byte[]> f487059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f487060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, Object> f487061g;

    public static c a() {
        if (f487054h != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f487054h != null) goto L9;
        f487054h = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f487054h;
    }

    public c() {
    }
}
