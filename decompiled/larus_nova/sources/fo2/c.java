package fo2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f478106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f478107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f478108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f478109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f478110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f478111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f478112g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<Long> f478113h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f478114i;

    public final synchronized void b() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f478114i == false) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f478106a == null) goto L11;
        this.f478114i = true;     // Catch: Throwable -> L13
        this.f478107b = 0;     // Catch: Throwable -> L13
        this.f478108c = 0;     // Catch: Throwable -> L13
        this.f478109d = 0;     // Catch: Throwable -> L13
        this.f478110e = 0;     // Catch: Throwable -> L13
        this.f478111f = 0;     // Catch: Throwable -> L13
        this.f478112g = 0;     // Catch: Throwable -> L13
        this.f478113h.clear();     // Catch: Throwable -> L13
        this.f478106a.f478105a.addIfAbsent(this);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final synchronized Map<String, Long> c() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f478114i == true) goto L6;
    L11:
        monitor-exit(this);
        return null;
    L6:
        if (this.f478106a == null) goto L11;
        this.f478114i = false;     // Catch: Throwable -> L14
        this.f478106a.f478105a.remove(this);     // Catch: Throwable -> L14
        Map<String, Long> r100 = a();     // Catch: Throwable -> L14
        this.f478107b = 0;     // Catch: Throwable -> L14
        this.f478108c = 0;     // Catch: Throwable -> L14
        this.f478109d = 0;     // Catch: Throwable -> L14
        this.f478110e = 0;     // Catch: Throwable -> L14
        this.f478111f = 0;     // Catch: Throwable -> L14
        this.f478112g = 0;     // Catch: Throwable -> L14
        this.f478113h.clear();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r100;
    }

    public final Map<String, Long> a() {
        HashMap r100 = new HashMap();
        r100.put("video_render_stall_count", Long.valueOf(this.f478107b));
        r100.put("video_render_stall_duration", Long.valueOf(this.f478108c));
        r100.put("audio_stall_count", Long.valueOf(this.f478109d));
        r100.put("audio_stall_duration", Long.valueOf(this.f478110e));
        r100.put("net_stall_count", Long.valueOf(this.f478111f));
        r100.put("net_stall_duration", Long.valueOf(this.f478112g));
        return r100;
    }

    public c(b r100) {
        this.f478107b = 0;
        this.f478108c = 0;
        this.f478109d = 0;
        this.f478110e = 0;
        this.f478111f = 0;
        this.f478112g = 0;
        this.f478113h = new CopyOnWriteArrayList();
        this.f478114i = false;
        this.f478106a = r100;
    }

    @Override // fo2.a
    public final void onAudioStall(Long r100) {
        this.f478109d++;
        this.f478110e += r100.longValue();
    }

    @Override // fo2.a
    public final void onStreamNetStall(Long r100) {
        this.f478111f++;
        this.f478112g += r100.longValue();
    }

    @Override // fo2.a
    public final void onVideoRenderStall(Long r100) {
        this.f478107b++;
        this.f478108c += r100.longValue();
        this.f478113h.add(r100);
    }
}
