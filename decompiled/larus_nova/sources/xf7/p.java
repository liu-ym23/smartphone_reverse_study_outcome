package xf7;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements yf7.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f563491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f563492b;

    @Override // yf7.j
    public final void remove() {
        d r100 = this.f563492b;
        long r101 = this.f563491a.longValue();
        Map<Long, o> r102 = r100.f563450b;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.remove(Long.valueOf(r101));
    }

    public p(Long r100, d r101) {
        this.f563491a = r100;
        this.f563492b = r101;
    }
}
