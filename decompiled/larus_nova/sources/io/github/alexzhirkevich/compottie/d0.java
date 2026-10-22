package io.github.alexzhirkevich.compottie;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes41.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f490738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f490739b;

    public d0() {
        this(0);
    }

    public d0(int r100) {
        MutexImpl r101 = kotlinx.coroutines.sync.b.a();
        Intrinsics.checkNotNullParameter(r101, "mutex");
        this.f490738a = r101;
        this.f490739b = 0;
    }
}
