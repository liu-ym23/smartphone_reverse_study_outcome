package w50;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.v;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile h f558301n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f558302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f558303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f558304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f558305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f558306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f558307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f558308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f558309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f558310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashSet<Pair<String, String>> f558311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashSet<String> f558312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f558313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LiveTracingMonitor.EventModule f558314m;

    public static h a() {
        if (f558301n != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f558301n != null) goto L9;
        f558301n = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f558301n;
    }

    public h() {
        this.f558302a = new AtomicBoolean(false);
        this.f558303b = new HashSet();
        this.f558304c = new HashSet();
        this.f558305d = 0;
        this.f558306e = 0;
        this.f558307f = 0;
        this.f558308g = 0;
        this.f558309h = 0;
        this.f558310i = 0;
        this.f558311j = new HashSet();
        this.f558312k = new HashSet();
        this.f558313l = 0;
        this.f558314m = LiveTracingMonitor.EventModule.TEXT_MESSAGE;
    }

    public final void c(@Nullable String r100, @Nullable String r101) {
        if (v.a() == false) goto L6;
        return;
    L6:
        if (this.f558302a.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        this.f558305d++;
    L15:
        if (TextUtils.isEmpty(r100) == false) goto L17;
        this.f558307f++;
    L20:
        this.f558302a.set(false);
        return;
    L17:
        this.f558308g++;
        if (this.f558303b.size() >= 30) goto L20;
        this.f558303b.add(r100);
        goto L20
    L11:
        this.f558306e++;
        if (this.f558304c.size() >= 30) goto L15;
        this.f558304c.add(r101);
        goto L15
    }

    public final void b(@Nullable String r100, @Nullable String r101, @Nullable String r102) {
        if (v.a() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return;
    L11:
        if (this.f558302a.compareAndSet(false, true) == true) goto L14;
        return;
    L14:
        if (this.f558311j.size() >= 30) goto L20;
        this.f558311j.add(new Pair(r100, r101));
        if (TextUtils.isEmpty(r102) == false) goto L18;
    L21:
        this.f558302a.set(false);
        return;
    L18:
        if (this.f558312k.size() >= 30) goto L21;
        this.f558312k.add(r102);
        goto L21
    L20:
        this.f558313l++;
        goto L21
    }
}
