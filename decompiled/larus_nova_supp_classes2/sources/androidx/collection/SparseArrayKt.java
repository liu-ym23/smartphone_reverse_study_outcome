package androidx.collection;

import androidx.autofill.HintConstants;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\u001a!\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a.\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\r\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u001a.\u0010\u0011\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u0002H\u0002H\u0086\b¢\u0006\u0002\u0010\u0013\u001a7\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001a-\u0010\u0018\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\r\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aT\u0010\u001a\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\f0\u001cH\u0086\bø\u0001\u0000\u001a\u0016\u0010\u001f\u001a\u00020 \"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\"\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"(\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Æ\u0002¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"size", "", "T", "Landroidx/collection/SparseArrayCompat;", "getSize$annotations", "(Landroidx/collection/SparseArrayCompat;)V", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "contains", "", "key", "set", "", "value", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "plus", "other", "getOrDefault", "defaultValue", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroidx/collection/SparseArrayCompat;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "remove", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "forEach", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "keyIterator", "Lkotlin/collections/IntIterator;", "valueIterator", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/collection/SparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C00851<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_valueIterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArrayCompat<T> r0 = this.$this_valueIterator;
            int r1 = this.index;
            this.index = r1 + 1;
            return (T) r0.valueAt(r1);
        }

        public final int getIndex() {
            return this.index;
        }

        public C00851(SparseArrayCompat<T> r1) {
            this.$this_valueIterator = r1;
        }

        public final void setIndex(int r1) {
            this.index = r1;
        }
    }

    public static /* synthetic */ void getSize$annotations(SparseArrayCompat r0) {
    }

    public static final <T> int getSize(SparseArrayCompat<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !r1.isEmpty();
    }

    public static final <T> IntIterator keyIterator(final SparseArrayCompat<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new C00851(r1);
    }

    public static final <T> boolean contains(SparseArrayCompat<T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.containsKey(r2);
    }

    public static final <T> void forEach(SparseArrayCompat<T> r4, Function2<? super Integer, ? super T, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.invoke(Integer.valueOf(r4.keyAt(r1)), r4.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> r3, SparseArrayCompat<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        SparseArrayCompat<T> r0 = new SparseArrayCompat(r3.size() + r4.size());
        r0.putAll(r3);
        r0.putAll(r4);
        return r0;
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> r1, int r2, T r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return (T) r1.get(r2, r3);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> r1, int r2, Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        T r4 = (T) r1.get(r2);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return (T) r3.invoke();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced with member function. Remove extension import!")
    public static final /* synthetic */ boolean remove(SparseArrayCompat r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.remove(r2, r3);
    }

    public static final <T> void set(SparseArrayCompat<T> r1, int r2, T r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.put(r2, r3);
    }
}
