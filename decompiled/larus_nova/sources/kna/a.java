package kna;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f504322a = null;

    static {
        f504322a = new a();
    }

    public a() {
    }

    @Override // kna.c
    public final boolean a() {
        return false;
    }

    @Override // kna.c
    public final String b() {
        return null;
    }

    @Override // kna.c
    public final void c(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }
}
