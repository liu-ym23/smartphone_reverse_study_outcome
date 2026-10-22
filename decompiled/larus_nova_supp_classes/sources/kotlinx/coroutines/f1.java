package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class f1 extends LockFreeLinkedListNode implements z0, m0, x0 {
    public JobSupport d;

    @Override // kotlinx.coroutines.x0
    public final j1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.x0
    public final boolean isActive() {
        return true;
    }

    public final JobSupport i() {
        JobSupport r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return getClass().getSimpleName() + '@' + b0.a(this) + "[job@" + b0.a(i()) + ']';
    }

    @Override // kotlinx.coroutines.m0
    public final void dispose() {
        JobSupport r0 = i();
    L3:
        Object r1 = r0.M();
        boolean r3 = false;
        if ((r1 instanceof f1) == false) goto L16;
        if (r1 != this) goto L58;
        AtomicReferenceFieldUpdater r2 = JobSupport.a;
        p0 r5 = g1.g;
    L9:
        if (r2.compareAndSet(r0, r1, r5) == true) goto L10;
        if (r2.get(r0) == r1) goto L9;
    L13:
        if (r3 == false) goto L3;
        return;
    L10:
        r3 = true;
        goto L13
    L58:
        return;
    L16:
        if ((r1 instanceof x0) == true) goto L18;
        return;
    L18:
        if (((x0) r1).getList() == null) goto L55;
    L19:
        Object r4 = e();
        if ((r4 instanceof kotlinx.coroutines.internal.v) == true) goto L21;
        if (r4 == this) goto L23;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r6 = (LockFreeLinkedListNode) r4;
        r6.getClass();
        AtomicReferenceFieldUpdater r7 = LockFreeLinkedListNode.c;
        kotlinx.coroutines.internal.v r8 = (kotlinx.coroutines.internal.v) r7.get(r6);
        if (r8 != null) goto L27;
        r8 = new kotlinx.coroutines.internal.v(r6);
        r7.set(r6, r8);
    L27:
        AtomicReferenceFieldUpdater r9 = LockFreeLinkedListNode.a;
    L29:
        if (r9.compareAndSet(this, r4, r8) == true) goto L30;
        if (r9.get(this) == r4) goto L29;
        boolean r10 = false;
    L34:
        if (r10 == false) goto L19;
        r6.c();
        return;
    L30:
        r10 = true;
        goto L34
    L23:
        LockFreeLinkedListNode r11 = (LockFreeLinkedListNode) r4;
        return;
    L21:
        LockFreeLinkedListNode r12 = ((kotlinx.coroutines.internal.v) r4).a;
        return;
    }

    public f1() {
    }
}
