package vfa;

import com.larus.applog.api.IApplog;
import com.larus.im.f;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements f.a {
    public b() {
    }

    @Override // com.larus.im.f.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        c.f554605a.set(r100);
        IApplog.f287053a.b("obric_frontier_require", com.larus.utils.f.c(new Pair[]{TuplesKt.to("action", "connect"), TuplesKt.to("reason", r100)}));
    }

    @Override // com.larus.im.f.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        AtomicReference<String> r101 = c.f554605a;
        c.f554605a.set(r100);
        IApplog.f287053a.b("obric_frontier_require", com.larus.utils.f.c(new Pair[]{TuplesKt.to("action", "disconnect"), TuplesKt.to("reason", r100)}));
    }
}
