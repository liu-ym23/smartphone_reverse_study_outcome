package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class LockFreeLinkedListNode {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");
        b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");
        c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    }

    public final LockFreeLinkedListNode c() {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) b.get(this);
        LockFreeLinkedListNode r1 = r0;
    L3:
        LockFreeLinkedListNode r3 = null;
    L4:
        AtomicReferenceFieldUpdater r4 = a;
        Object r5 = r4.get(r1);
        boolean r6 = true;
        if (r5 == this) goto L6;
        if (h() == true) goto L20;
        if (r5 == null) goto L22;
        if ((r5 instanceof u) == true) goto L25;
        if ((r5 instanceof v) == true) goto L28;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r3 = r1;
        r1 = (LockFreeLinkedListNode) r5;
        goto L4
    L28:
        if (r3 != null) goto L29;
        r1 = (LockFreeLinkedListNode) b.get(r1);
        goto L4
    L29:
        LockFreeLinkedListNode r7 = ((v) r5).a;
    L31:
        if (r4.compareAndSet(r3, r1, r7) == true) goto L36;
        if (r4.get(r3) == r1) goto L31;
        r6 = false;
    L36:
        if (r6 == false) goto L2;
        r1 = r3;
        goto L3
    L25:
        ((u) r5).a(r1);
        goto L2
    L22:
        return r1;
    L20:
        return null;
    L6:
        if (r0 == r1) goto L7;
        AtomicReferenceFieldUpdater r8 = b;
    L10:
        if (r8.compareAndSet(this, r0, r1) == true) goto L15;
        if (r8.get(this) == r0) goto L10;
        r6 = false;
    L15:
        if (r6 == false) goto L2;
        return r1;
    L7:
        return r1;
    }

    public final Object e() {
        AtomicReferenceFieldUpdater r0 = a;
    L3:
        Object r1 = r0.get(this);
        if ((r1 instanceof u) == false) goto L5;
        ((u) r1).a(this);
        goto L3
    L5:
        return r1;
    }

    public String toString() {
        return new toString.1(this) + '@' + kotlinx.coroutines.b0.a(this);
    }

    public LockFreeLinkedListNode() {
        this._next$volatile = this;
        this._prev$volatile = this;
    }

    public final LockFreeLinkedListNode f() {
        Object r0 = e();
        if ((r0 instanceof v) == false) goto L5;
        v r1 = (v) r0;
    L6:
        if (r1 == null) goto L9;
        LockFreeLinkedListNode r2 = r1.a;
        if (r2 == null) goto L9;
        return r2;
    L9:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) r0;
    L5:
        r1 = null;
        goto L6
    }

    public final LockFreeLinkedListNode g() {
        LockFreeLinkedListNode r0 = c();
        if (r0 != null) goto L9;
        Object r1 = b.get(this);
    L5:
        r0 = (LockFreeLinkedListNode) r1;
        if (r0.h() == false) goto L9;
        r1 = b.get(r0);
    L9:
        return r0;
    }

    public boolean h() {
        return e() instanceof v;
    }

    public final void d(LockFreeLinkedListNode r5) {
        AtomicReferenceFieldUpdater r0 = b;
    L3:
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0.get(r5);
        if (e() != r5) goto L5;
        AtomicReferenceFieldUpdater r2 = b;
    L8:
        if (r2.compareAndSet(r5, r1, this) == true) goto L9;
        if (r2.get(r5) == r1) goto L8;
        boolean r3 = false;
    L13:
        if (r3 == false) goto L3;
        if (h() == false) goto L26;
        r5.c();
        return;
    L26:
        return;
    L9:
        r3 = true;
        goto L13
    }
}
