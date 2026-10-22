package yh6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g<T> implements j97.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f567606a;

    @Override // j97.a
    public Class<T> getType() {
        return this.f567606a;
    }

    public g(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f567606a = r100;
    }
}
