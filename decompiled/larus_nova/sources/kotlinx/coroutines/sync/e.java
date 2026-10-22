package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: classes.dex */
public final class e extends y<e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f505146e;

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f504984c + ", hashCode=" + hashCode() + ']';
    }

    @Override // kotlinx.coroutines.internal.y
    public final int g() {
        return d.f505145f;
    }

    @Override // kotlinx.coroutines.internal.y
    public final void h(int r100, CoroutineContext r101) {
        b0 r102 = d.f505144e;
        this.f505146e.set(r100, r102);
        i();
    }

    public e(long r100, e r101, int r102) {
        super(r100, r101, r102);
        this.f505146e = new AtomicReferenceArray(d.f505145f);
    }
}
