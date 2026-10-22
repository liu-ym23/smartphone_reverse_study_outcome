package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class LockFreeLinkedListNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504925a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504926b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504927c = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX INFO: loaded from: classes5.dex */
    public static abstract class a extends b<LockFreeLinkedListNode> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LockFreeLinkedListNode f504928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LockFreeLinkedListNode f504929c;

        public a(LockFreeLinkedListNode r100) {
            this.f504928b = r100;
        }

        @Override // kotlinx.coroutines.internal.b
        public final void b(LockFreeLinkedListNode r100, Object r101) {
            LockFreeLinkedListNode r102 = r100;
            boolean r103 = false;
            if (r101 != null) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L8;
            LockFreeLinkedListNode r105 = this.f504928b;
        L9:
            if (r105 == null) goto L23;
            AtomicReferenceFieldUpdater r106 = LockFreeLinkedListNode.f504925a;
        L12:
            if (r106.compareAndSet(r102, this, r105) == true) goto L13;
            if (r106.get(r102) == this) goto L12;
        L16:
            if (r103 == false) goto L24;
            if (r104 == false) goto L25;
            LockFreeLinkedListNode r107 = this.f504928b;
            LockFreeLinkedListNode r108 = this.f504929c;
            Intrinsics.checkNotNull(r108);
            r107.d(r108);
            return;
        L25:
            return;
        L24:
            return;
        L13:
            r103 = true;
            goto L16
        L23:
            return;
        L8:
            r105 = this.f504929c;
            goto L9
        L5:
            r104 = false;
            goto L6
        }
    }

    static {
        f504925a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");
        f504926b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");
        f504927c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    }

    public final LockFreeLinkedListNode c() {
    L2:
        LockFreeLinkedListNode r100 = (LockFreeLinkedListNode) f504926b.get(this);
        LockFreeLinkedListNode r101 = r100;
    L3:
        LockFreeLinkedListNode r102 = null;
    L4:
        AtomicReferenceFieldUpdater r103 = f504925a;
        Object r104 = r103.get(r101);
        boolean r105 = true;
        if (r104 == this) goto L6;
        if (h() == true) goto L20;
        if (r104 == null) goto L22;
        if ((r104 instanceof u) == true) goto L25;
        if ((r104 instanceof v) == true) goto L28;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r102 = r101;
        r101 = (LockFreeLinkedListNode) r104;
        goto L4
    L28:
        if (r102 != null) goto L29;
        r101 = (LockFreeLinkedListNode) f504926b.get(r101);
        goto L4
    L29:
        LockFreeLinkedListNode r106 = ((v) r104).f504981a;
    L31:
        if (r103.compareAndSet(r102, r101, r106) == true) goto L36;
        if (r103.get(r102) == r101) goto L31;
        r105 = false;
    L36:
        if (r105 == false) goto L2;
        r101 = r102;
        goto L3
    L25:
        ((u) r104).a(r101);
        goto L2
    L22:
        return r101;
    L20:
        return null;
    L6:
        if (r100 == r101) goto L7;
        AtomicReferenceFieldUpdater r107 = f504926b;
    L10:
        if (r107.compareAndSet(this, r100, r101) == true) goto L15;
        if (r107.get(this) == r100) goto L10;
        r105 = false;
    L15:
        if (r105 == false) goto L2;
        return r101;
    L7:
        return r101;
    }

    public final Object e() {
        AtomicReferenceFieldUpdater r100 = f504925a;
    L3:
        Object r101 = r100.get(this);
        if ((r101 instanceof u) == false) goto L5;
        ((u) r101).a(this);
        goto L3
    L5:
        return r101;
    }

    public String toString() {
        return new AnonymousClass1(this) + '@' + kotlinx.coroutines.b0.a(this);
    }

    public LockFreeLinkedListNode() {
        this._next$volatile = this;
        this._prev$volatile = this;
    }

    public final LockFreeLinkedListNode f() {
        Object r100 = e();
        if ((r100 instanceof v) == false) goto L5;
        v r101 = (v) r100;
    L6:
        if (r101 == null) goto L9;
        LockFreeLinkedListNode r102 = r101.f504981a;
        if (r102 == null) goto L9;
        return r102;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) r100;
    L5:
        r101 = null;
        goto L6
    }

    public final LockFreeLinkedListNode g() {
        LockFreeLinkedListNode r100 = c();
        if (r100 != null) goto L9;
        Object r101 = f504926b.get(this);
    L5:
        r100 = (LockFreeLinkedListNode) r101;
        if (r100.h() == false) goto L9;
        r101 = f504926b.get(r100);
    L9:
        return r100;
    }

    public boolean h() {
        return e() instanceof v;
    }

    public final void d(LockFreeLinkedListNode r100) {
        AtomicReferenceFieldUpdater r101 = f504926b;
    L3:
        LockFreeLinkedListNode r102 = (LockFreeLinkedListNode) r101.get(r100);
        if (e() != r100) goto L5;
        AtomicReferenceFieldUpdater r103 = f504926b;
    L8:
        if (r103.compareAndSet(r100, r102, this) == true) goto L9;
        if (r103.get(r100) == r102) goto L8;
        boolean r104 = false;
    L13:
        if (r104 == false) goto L3;
        if (h() == false) goto L26;
        r100.c();
        return;
    L26:
        return;
    L9:
        r104 = true;
        goto L13
    }
}
