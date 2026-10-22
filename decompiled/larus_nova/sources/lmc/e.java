package lmc;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Long, d> f509950a;

    public e() {
        this.f509950a = new LinkedHashMap();
    }

    public final d a(long r100) {
        return this.f509950a.get(Long.valueOf(r100));
    }
}
