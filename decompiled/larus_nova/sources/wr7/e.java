package wr7;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f560831a;

    public e(List<h> r100) {
        zr7.a.c(r100, "ExecutionTime list cannot be null or empty");
        this.f560831a = Collections.unmodifiableList(r100);
    }

    @Override // wr7.h
    public final Optional<ZonedDateTime> a(final ZonedDateTime r100) {
        return (Optional) this.f560831a.parallelStream().map(new a(r100)).filter(new b()).sorted(new c()).findFirst().orElseGet(new d());
    }
}
