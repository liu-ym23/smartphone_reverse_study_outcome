package yh6;

import kotlin.jvm.internal.Intrinsics;
import yh6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class f<T extends c> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f567604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j97.a<T> f567605b;

    @Override // yh6.b
    public final String getName() {
        return this.f567604a;
    }

    @Override // yh6.b
    public j97.a<T> getType() {
        return this.f567605b;
    }

    public f(String r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f567604a = r100;
        this.f567605b = r101;
    }
}
