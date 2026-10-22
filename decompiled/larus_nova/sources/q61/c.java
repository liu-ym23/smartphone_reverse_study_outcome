package q61;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cz.c f531761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f531762b;

    @Override // q61.b
    public final Map<String, String> getLogParams() {
        return this.f531762b;
    }

    @Override // q61.b
    public final cz.c getScene() {
        return this.f531761a;
    }

    public c(b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f531761a = r100.f531760c;
        this.f531762b = r100.f531759b;
    }
}
