package f6b;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import t3b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements e<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f475725a;

    public a() {
        this.f475725a = new AtomicInteger(0);
    }

    @Override // t3b.e
    public final String a(u3b.a r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, "task");
        return r101.a() + '_' + this.f475725a.get();
    }

    @Override // t3b.e
    public final String b(u3b.a r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, "task");
        return r101.a() + '_' + this.f475725a.incrementAndGet();
    }
}
