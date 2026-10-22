package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes42.dex */
public final class f1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow<T> f504849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f504850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferOverflow f504851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineContext f504852d;

    /* JADX WARN: Multi-variable type inference failed */
    public f1(Flow<? extends T> r100, int r101, BufferOverflow r102, CoroutineContext r103) {
        this.f504849a = r100;
        this.f504850b = r101;
        this.f504851c = r102;
        this.f504852d = r103;
    }
}
