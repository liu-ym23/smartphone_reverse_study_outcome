package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
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
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001b\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\u001d\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u0018\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\u001c\u0010\u0019\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u001a\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\"\u0010\u001b\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0015H\u0016J\u001c\u0010\u001c\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/collection/MutableEntries;", "K", "V", "", "", "parent", "Landroidx/collection/MutableScatterMap;", "<init>", "(Landroidx/collection/MutableScatterMap;)V", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "clear", "", "containsAll", "elements", "", "contains", "element", "addAll", "add", "retainAll", "removeAll", "remove", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MutableEntries<K, V> implements Set<Map.Entry<K, V>>, KMutableSet {
    private final MutableScatterMap<K, V> parent;

    /* JADX INFO: renamed from: androidx.collection.MutableEntries$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R,\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"androidx/collection/MutableEntries$iterator$1", "", "", "iterator", "", "getIterator", "()Ljava/util/Iterator;", "setIterator", "(Ljava/util/Iterator;)V", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "remove", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        private int current;
        private Iterator<? extends Map.Entry<K, V>> iterator;
        final /* synthetic */ MutableEntries<K, V> this$0;

        /* JADX INFO: renamed from: androidx.collection.MutableEntries$iterator$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.collection.MutableEntries$iterator$1$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1542}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
        public static final class C00051 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map.Entry<K, V>>, Continuation<? super Unit>, Object> {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            long J$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            final /* synthetic */ MutableEntries<K, V> this$0;
            final /* synthetic */ AnonymousClass1 this$1;

            public C00051(MutableEntries<K, V> r1, AnonymousClass1 r2, Continuation<? super C00051> r3) {
                this.this$0 = r1;
                this.this$1 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                C00051 r0 = new C00051(this.this$0, this.this$1, r5);
                r0.L$0 = r4;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((SequenceScope) r1, (Continuation) r2);
            }

            public final Object invoke(SequenceScope<? super Map.Entry<K, V>> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0065 -> B:14:0x007f). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ca -> B:24:0x00ce). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00d5 -> B:26:0x00d6). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ea -> B:31:0x00eb). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r26) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                int r3 = 8;
                if (r2 == 0) goto L8;
                if (r2 != 1) goto L7;
                int r4 = this.I$3;
                int r6 = this.I$2;
                long r7 = this.J$0;
                int r9 = this.I$1;
                int r10 = this.I$0;
                long[] r11 = (long[]) this.L$3;
                MutableEntries<K, V> r12 = (MutableEntries) this.L$2;
                AnonymousClass1 r13 = (AnonymousClass1) this.L$1;
                SequenceScope r14 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(r26);
                C00051 r5 = this;
                int r0 = 1;
            L24:
                SequenceScope r15 = r14;
                AnonymousClass1 r16 = r13;
                MutableEntries<K, V> r17 = r12;
                C00051 r18 = r5;
                r3 = 8;
            L26:
                r7 = r7 >> r3;
                r4 = r4 + r0;
            L14:
                if (r4 >= r6) goto L28;
                if ((r7 & 255) >= 128) goto L18;
                boolean r19 = true;
            L19:
                if (r19 == false) goto L25;
                r16.setCurrent((r9 << 3) + r4);
                MutableMapEntry r8 = new MutableMapEntry(MutableEntries.access$getParent$p(r17).keys, MutableEntries.access$getParent$p(r17).values, r16.getCurrent());
                r18.L$0 = r15;
                r18.L$1 = r16;
                r18.L$2 = r17;
                r18.L$3 = r11;
                r18.I$0 = r10;
                r18.I$1 = r9;
                r18.J$0 = r7;
                r18.I$2 = r6;
                r18.I$3 = r4;
                r0 = 1;
                r18.label = 1;
                if (r15.yield(r8, r18) != r1) goto L23;
                return r1;
            L23:
                r5 = r18;
                r12 = r17;
                r13 = r16;
                r14 = r15;
                goto L24
            L25:
                r0 = 1;
                goto L26
            L18:
                r19 = false;
                goto L19
            L28:
                if (r6 != r3) goto L34;
                long[] r20 = r11;
                C00051 r110 = r18;
                MutableEntries<K, V> r21 = r17;
                AnonymousClass1 r22 = r16;
                SequenceScope r23 = r15;
                int r24 = r10;
                int r111 = r9;
                int r25 = r24;
            L31:
                if (r111 == r25) goto L34;
                r111 = r111 + 1;
            L11:
                long r112 = r20[r111];
                if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L31;
                r15 = r23;
                r4 = 0;
                C00051 r27 = r110;
                r11 = r20;
                r6 = 8 - ((~(r111 - r25)) >>> 31);
                r16 = r22;
                r17 = r21;
                r18 = r27;
                r7 = r112;
                int r28 = r111;
                r10 = r25;
                r9 = r28;
            L34:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r26);
                r23 = (SequenceScope) this.L$0;
                MutableScatterMap r29 = MutableEntries.access$getParent$p(this.this$0);
                r22 = this.this$1;
                r21 = this.this$0;
                r20 = r29.metadata;
                r25 = r20.length - 2;
                if (r25 < 0) goto L34;
                r110 = this;
                r111 = 0;
                goto L11
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current == (-1)) goto L6;
            MutableEntries.access$getParent$p(this.this$0).removeValueAt(this.current);
            this.current = -1;
            return;
        }

        public final int getCurrent() {
            return this.current;
        }

        public final Iterator<Map.Entry<K, V>> getIterator() {
            return this.iterator;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public AnonymousClass1(MutableEntries<K, V> r3) {
            this.this$0 = r3;
            this.current = -1;
            this.iterator = SequencesKt.iterator(new C00051(r3, this, null));
        }

        public final void setCurrent(int r1) {
            this.current = r1;
        }

        public final void setIterator(Iterator<? extends Map.Entry<K, V>> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.iterator = r2;
        }
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

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.parent.clear();
    }

    public int getSize() {
        return this.parent._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public MutableEntries(MutableScatterMap<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        this.parent = r2;
    }

    public static final /* synthetic */ MutableScatterMap access$getParent$p(MutableEntries r0) {
        return r0.parent;
    }

    public boolean add(Map.Entry<K, V> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        throw new UnsupportedOperationException();
    }

    public boolean contains(Map.Entry<K, V> r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        return Intrinsics.areEqual(this.parent.get(r3.getKey()), r3.getValue());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Collection<?> r6 = r5;
        if (r6.isEmpty() == true) goto L15;
        Iterator<T> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) r7.next();
        if (Intrinsics.areEqual(this.parent.get((K) r0.getKey()), r0.getValue()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    public boolean remove(Map.Entry<K, V> r20) {
        Intrinsics.checkNotNullParameter(r20, "element");
        MutableScatterMap<K, V> r1 = this.parent;
        K r3 = r20.getKey();
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = r5 * ScatterMapKt.MurmurHashC1;
        int r7 = r6 ^ (r6 << 16);
        int r8 = r7 & 127;
        int r9 = r1._capacity;
        int r10 = (r7 >>> 7) & r9;
        int r11 = 0;
    L7:
        long[] r12 = r1.metadata;
        int r13 = r10 >> 3;
        int r14 = (r10 & 7) << 3;
        long r15 = ((r12[r13 + 1] << (64 - r14)) & ((-r14) >> 63)) | (r12[r13] >>> r14);
        long r16 = (((long) r8) * ScatterMapKt.BitmaskLsb) ^ r15;
        long r17 = ((~r16) & (r16 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r17 == 0) goto L11;
        boolean r18 = true;
    L12:
        if (r18 == false) goto L18;
        int r19 = ((Long.numberOfTrailingZeros(r17) >> 3) + r10) & r9;
        if (Intrinsics.areEqual(r1.keys[r19], r3) == true) goto L20;
        r17 = r17 & (r17 - 1);
    L20:
        if (r19 >= 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.parent.values[r19], r20.getValue()) == false) goto L31;
        this.parent.removeValueAt(r19);
        return true;
    L31:
        return false;
    L18:
        if (((r15 & ((~r15) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r11 = r11 + 8;
        r10 = (r10 + r11) & r9;
        goto L7
    L19:
        r19 = -1;
        goto L20
    L11:
        r18 = false;
        goto L12
    L5:
        r5 = 0;
        goto L6
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> r19) {
        Intrinsics.checkNotNullParameter(r19, "elements");
        long[] r1 = this.parent.metadata;
        int r3 = r1.length - 2;
        if (r3 < 0) goto L27;
        int r5 = 0;
        boolean r6 = false;
    L5:
        long r7 = r1[r5];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L24;
        int r9 = 8 - ((~(r5 - r3)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L23;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L22;
        int r13 = (r5 << 3) + r11;
        Iterator<?> r14 = r19.iterator();
    L16:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (Intrinsics.areEqual(r15.getKey(), this.parent.keys[r13]) == false) goto L16;
        if (Intrinsics.areEqual(r15.getValue(), this.parent.values[r13]) == false) goto L16;
        this.parent.removeValueAt(r13);
        r6 = true;
    L22:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L23:
        if (r9 == 8) goto L24;
        return r6;
    L24:
        if (r5 == r3) goto L26;
        r5 = r5 + 1;
        goto L5
    L26:
        boolean r4 = r6;
    L29:
        return r4;
    L27:
        r4 = false;
        goto L29
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> r19) {
        Intrinsics.checkNotNullParameter(r19, "elements");
        long[] r1 = this.parent.metadata;
        int r3 = r1.length - 2;
        if (r3 < 0) goto L30;
        int r5 = 0;
        boolean r6 = false;
    L5:
        long r7 = r1[r5];
        if (((((~r7) << 7) & r7) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L27;
        int r9 = 8 - ((~(r5 - r3)) >>> 31);
        int r11 = 0;
    L8:
        if (r11 >= r9) goto L26;
        if ((255 & r7) >= 128) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L25;
        int r13 = (r5 << 3) + r11;
        Iterator<?> r14 = r19.iterator();
    L16:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (Intrinsics.areEqual(r15.getKey(), this.parent.keys[r13]) == false) goto L16;
        if (Intrinsics.areEqual(r15.getValue(), this.parent.values[r13]) == false) goto L16;
        boolean r4 = true;
    L23:
        if (r4 == true) goto L25;
        this.parent.removeValueAt(r13);
        r6 = true;
        goto L25
    L22:
        r4 = false;
    L25:
        r7 = r7 >> 8;
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = false;
        goto L13
    L26:
        if (r9 == 8) goto L27;
        return r6;
    L27:
        if (r5 == r3) goto L29;
        r5 = r5 + 1;
        goto L5
    L29:
        boolean r8 = r6;
    L32:
        return r8;
    L30:
        r8 = false;
        goto L32
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return add((Map.Entry) r1);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object r2) {
        if (TypeIntrinsics.isMutableMapEntry(r2) == true) goto L7;
        return false;
    L7:
        return contains((Map.Entry) r2);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object r2) {
        if (TypeIntrinsics.isMutableMapEntry(r2) == true) goto L7;
        return false;
    L7:
        return remove((Map.Entry) r2);
    }
}
