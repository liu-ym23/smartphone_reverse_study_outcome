package ob2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements ek6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f522596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f522597b;

    @Override // ek6.b
    public final void a() {
    }

    public final String toString() {
        return "LiveImageResource[" + CollectionsKt.joinToString$default(this.f522596a, null, null, null, 3, null, null, 55, null) + ']';
    }

    public c(List<String> r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        this.f522596a = r100;
        this.f522597b = r101;
    }
}
