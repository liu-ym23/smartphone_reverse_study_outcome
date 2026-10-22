package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes.dex */
public abstract class f1 extends LockFreeLinkedListNode implements z0, m0, x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JobSupport f504740d;

    @Override // kotlinx.coroutines.x0
    public final j1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.x0
    public final boolean isActive() {
        return true;
    }

    public final JobSupport i() {
        JobSupport r100 = this.f504740d;
        if (r100 == null) goto L5;
        return r100;
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
        JobSupport r100 = i();
    L3:
        Object r101 = r100.M();
        boolean r102 = false;
        if ((r101 instanceof f1) == false) goto L16;
        if (r101 != this) goto L58;
        AtomicReferenceFieldUpdater r103 = JobSupport.f504599a;
        p0 r104 = g1.f504918g;
    L9:
        if (r103.compareAndSet(r100, r101, r104) == true) goto L10;
        if (r103.get(r100) == r101) goto L9;
    L13:
        if (r102 == false) goto L3;
        return;
    L10:
        r102 = true;
        goto L13
    L58:
        return;
    L16:
        if ((r101 instanceof x0) == true) goto L18;
        return;
    L18:
        if (((x0) r101).getList() == null) goto L55;
    L19:
        Object r105 = e();
        if ((r105 instanceof kotlinx.coroutines.internal.v) == true) goto L21;
        if (r105 == this) goto L23;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r106 = (LockFreeLinkedListNode) r105;
        r106.getClass();
        AtomicReferenceFieldUpdater r107 = LockFreeLinkedListNode.f504927c;
        kotlinx.coroutines.internal.v r108 = (kotlinx.coroutines.internal.v) r107.get(r106);
        if (r108 != null) goto L27;
        r108 = new kotlinx.coroutines.internal.v(r106);
        r107.set(r106, r108);
    L27:
        AtomicReferenceFieldUpdater r109 = LockFreeLinkedListNode.f504925a;
    L29:
        if (r109.compareAndSet(this, r105, r108) == true) goto L30;
        if (r109.get(this) == r105) goto L29;
        boolean r110 = false;
    L34:
        if (r110 == false) goto L19;
        r106.c();
        return;
    L30:
        r110 = true;
        goto L34
    L23:
        LockFreeLinkedListNode r111 = (LockFreeLinkedListNode) r105;
        return;
    L21:
        LockFreeLinkedListNode r112 = ((kotlinx.coroutines.internal.v) r105).f504981a;
        return;
    }

    public f1() {
    }
}
