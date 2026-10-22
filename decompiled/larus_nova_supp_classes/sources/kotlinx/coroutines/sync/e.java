package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e extends y<e> {
    public final /* synthetic */ AtomicReferenceArray e;

    public final String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }

    @Override // kotlinx.coroutines.internal.y
    public final int g() {
        return d.f;
    }

    @Override // kotlinx.coroutines.internal.y
    public final void h(int r2, CoroutineContext r3) {
        b0 r4 = d.e;
        this.e.set(r2, r4);
        i();
    }

    public e(long r1, e r3, int r4) {
        super(r1, r3, r4);
        this.e = new AtomicReferenceArray(d.f);
    }
}
