package ob2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements ek6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f522600a;

    @Override // ek6.b
    public final void a() {
    }

    public final String toString() {
        return "LiveNinePatchResource[" + CollectionsKt.joinToString$default(this.f522600a, null, null, null, 3, null, null, 55, null) + ']';
    }

    public f(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "urls");
        this.f522600a = r100;
    }
}
