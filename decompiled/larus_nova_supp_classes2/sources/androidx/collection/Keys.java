package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/collection/Keys;", "K", "V", "", "parent", "Landroidx/collection/ScatterMap;", "<init>", "(Landroidx/collection/ScatterMap;)V", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "containsAll", "elements", "", "contains", "element", "(Ljava/lang/Object;)Z", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Keys<K, V> implements Set<K>, KMappedMarker {
    private final ScatterMap<K, V> parent;

    /* JADX INFO: renamed from: androidx.collection.Keys$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "K", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.collection.Keys$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {1435}, m = "invokeSuspend", n = {"$this$iterator", "k$iv", "m$iv$iv", "lastIndex$iv$iv", "i$iv$iv", "slot$iv$iv", "bitCount$iv$iv", "j$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super K>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Keys<K, V> this$0;

        public AnonymousClass1(Keys<K, V> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((SequenceScope) r1, (Continuation) r2);
        }

        public final Object invoke(SequenceScope<? super K> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005c -> B:28:0x00b2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005e -> B:14:0x0070). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009e -> B:24:0x00a3). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r23) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            int r3 = this.I$3;
            int r6 = this.I$2;
            long r7 = this.J$0;
            int r9 = this.I$1;
            int r10 = this.I$0;
            long[] r11 = (long[]) this.L$2;
            Object[] r12 = (Object[]) this.L$1;
            SequenceScope r13 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r23);
            SequenceScope r14 = r13;
            Object[] r15 = r12;
            AnonymousClass1 r16 = this;
        L24:
            AnonymousClass1 r20 = r16;
            long[] r17 = r11;
            AnonymousClass1 r18 = r20;
        L25:
            r7 = r7 >> 8;
            r3 = r3 + 1;
        L14:
            if (r3 < r6) goto L16;
            if (r6 != 8) goto L31;
            int r8 = r10;
            AnonymousClass1 r19 = r18;
            long[] r21 = r17;
            Object[] r22 = r15;
            SequenceScope r4 = r14;
        L28:
            if (r9 == r8) goto L31;
            r9 = r9 + 1;
        L11:
            long r110 = r21[r9];
            if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
            r14 = r4;
            r3 = 0;
            r17 = r21;
            r18 = r19;
            r6 = 8 - ((~(r9 - r8)) >>> 31);
            r15 = r22;
            r10 = r8;
            r7 = r110;
        L31:
            return Unit.INSTANCE;
        L16:
            if ((255 & r7) >= 128) goto L32;
            if (1 == 0) goto L25;
            Object r111 = r15[(r9 << 3) + r3];
            r18.L$0 = r14;
            r18.L$1 = r15;
            r18.L$2 = r17;
            r18.I$0 = r10;
            r18.I$1 = r9;
            r18.J$0 = r7;
            r18.I$2 = r6;
            r18.I$3 = r3;
            r18.label = 1;
            if (r14.yield(r111, r18) != r1) goto L23;
            return r1;
        L23:
            long[] r24 = r17;
            r16 = r18;
            r11 = r24;
            goto L24
        L32:
            if (0 == 0) goto L25;
            goto L25
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            r4 = (SequenceScope) this.L$0;
            ScatterMap r25 = Keys.access$getParent$p(this.this$0);
            r22 = r25.keys;
            r21 = r25.metadata;
            r8 = r21.length - 2;
            if (r8 < 0) goto L31;
            r19 = this;
            r9 = 0;
            goto L11
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(K r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends K> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (T[]) CollectionToArray.toArray(this, r2);
    }

    public int getSize() {
        return this.parent._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<K> iterator() {
        return SequencesKt.iterator(new AnonymousClass1(this, null));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public Keys(ScatterMap<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        this.parent = r2;
    }

    public static final /* synthetic */ ScatterMap access$getParent$p(Keys r0) {
        return r0.parent;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object r2) {
        return this.parent.containsKey(r2);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Collection<?> r5 = r4;
        if (r5.isEmpty() == true) goto L15;
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Object r0 = r6.next();
        if (this.parent.containsKey((K) r0) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }
}
