package androidx.collection;

import androidx.autofill.HintConstants;
import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003<=>B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u001d\u0010\f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u001e\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0019\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u001c\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\u0002J\u0017\u0010\u001e\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002J\u0006\u0010 \u001a\u00020\u0010J\u0010\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u0004J\u0011\u0010#\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0004H\u0086\bJ%\u0010$\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0015H\u0001¢\u0006\u0002\u0010'J\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010(J\u0016\u0010)\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010(J\u0013\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ/\u0010+\u001a\u00020\u00102!\u0010,\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0-H\u0086\bø\u0001\u0000J\u0019\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u001aJ\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0014\u00100\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ\u001c\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0086\u0002J\u0017\u0010)\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002J\u0015\u00101\u001a\u00028\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0004¢\u0006\u0002\u00102J\u001a\u00103\u001a\u00020\u00102\b\b\u0001\u00104\u001a\u00020\u00042\b\b\u0001\u00105\u001a\u00020\u0004J\u0019\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u001aJ\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cJ\u0014\u00106\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ \u00107\u001a\u00028\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00108J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006?"}, d2 = {"Landroidx/collection/MutableObjectList;", "E", "Landroidx/collection/ObjectList;", "initialCapacity", "", "<init>", "(I)V", "list", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "capacity", "getCapacity", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "(I[Ljava/lang/Object;)Z", "", "throwIndexOutOfBoundsInclusiveException", "Landroidx/collection/ScatterSet;", "([Ljava/lang/Object;)Z", "", "", "Lkotlin/sequences/Sequence;", "plusAssign", "([Ljava/lang/Object;)V", "clear", "trim", "minCapacity", "ensureCapacity", "resizeStorage", "oldContent", "", "(I[Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "minusAssign", "remove", "removeIf", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "removeAll", "removeAt", "(I)Ljava/lang/Object;", "removeRange", "start", "end", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "asList", "asMutableList", "", "MutableObjectListIterator", "ObjectListMutableList", "SubList", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u000e\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/collection/MutableObjectList$MutableObjectListIterator;", "T", "", "list", "", "index", "", "<init>", "(Ljava/util/List;I)V", "prevIndex", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "hasPrevious", "nextIndex", "previous", "previousIndex", "add", "element", "(Ljava/lang/Object;)V", "set", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private final List<T> list;
        private int prevIndex;

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.prevIndex < (this.list.size() - 1)) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.prevIndex < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> r0 = this.list;
            int r1 = this.prevIndex + 1;
            this.prevIndex = r1;
            return (T) ListProtector.get(r0, r1);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> r0 = this.list;
            int r1 = this.prevIndex;
            this.prevIndex = r1 - 1;
            return (T) ListProtector.get(r0, r1);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            ListProtector.remove(this.list, this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator
        public void add(T r3) {
            List<T> r0 = this.list;
            int r1 = this.prevIndex + 1;
            this.prevIndex = r1;
            ListProtector.add(r0, r1, r3);
        }

        @Override // java.util.ListIterator
        public void set(T r3) {
            ListProtector.set(this.list, this.prevIndex, r3);
        }

        public MutableObjectListIterator(List<T> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.list = r2;
            this.prevIndex = r3 - 1;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0096\u0002J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u001e\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Landroidx/collection/MutableObjectList$ObjectListMutableList;", "T", "", "objectList", "Landroidx/collection/MutableObjectList;", "<init>", "(Landroidx/collection/MutableObjectList;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ObjectListMutableList<T> implements List<T>, KMutableList {
        private final MutableObjectList<T> objectList;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r2) {
            Intrinsics.checkNotNullParameter(r2, "array");
            return (T[]) CollectionToArray.toArray(this, r2);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public ObjectListMutableList(MutableObjectList<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "objectList");
            this.objectList = r2;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r2) {
            return this.objectList.add(r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.objectList.addAll(r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r2) {
            return this.objectList.contains(r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.objectList.containsAll(r2);
        }

        @Override // java.util.List
        public T get(int r2) {
            ObjectListKt.access$checkIndex(this, r2);
            return this.objectList.get(r2);
        }

        @Override // java.util.List
        public int indexOf(Object r2) {
            return this.objectList.indexOf(r2);
        }

        @Override // java.util.List
        public int lastIndexOf(Object r2) {
            return this.objectList.lastIndexOf(r2);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r2) {
            return new MutableObjectListIterator(this, r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r2) {
            return this.objectList.remove(r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.objectList.removeAll(r2);
        }

        public T removeAt(int r2) {
            ObjectListKt.access$checkIndex(this, r2);
            return this.objectList.removeAt(r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.objectList.retainAll(r2);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r1) {
            return removeAt(r1);
        }

        @Override // java.util.List
        public void add(int r2, T r3) {
            this.objectList.add(r2, r3);
        }

        @Override // java.util.List
        public boolean addAll(int r2, Collection<? extends T> r3) {
            Intrinsics.checkNotNullParameter(r3, "elements");
            return this.objectList.addAll(r2, r3);
        }

        @Override // java.util.List
        public T set(int r2, T r3) {
            ObjectListKt.access$checkIndex(this, r2);
            return this.objectList.set(r2, r3);
        }

        @Override // java.util.List
        public List<T> subList(int r2, int r3) {
            ObjectListKt.access$checkSubIndex(this, r2, r3);
            return new SubList(this, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aH\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0016\u0010\u001f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"H\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0015\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fJ\u0016\u0010$\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u0015\u0010%\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010&\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J\u001e\u0010'\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006,"}, d2 = {"Landroidx/collection/MutableObjectList$SubList;", "T", "", "list", "start", "", "end", "<init>", "(Ljava/util/List;II)V", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] r2) {
            Intrinsics.checkNotNullParameter(r2, "array");
            return (T[]) CollectionToArray.toArray(this, r2);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int r0 = this.end - 1;
            int r1 = this.start;
            if (r1 > r0) goto L7;
        L4:
            ListProtector.remove(this.list, r0);
            if (r0 == r1) goto L7;
            r0 = r0 - 1;
        L7:
            this.end = this.start;
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            if (this.end != this.start) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T r4) {
            List<T> r0 = this.list;
            int r1 = this.end;
            this.end = r1 + 1;
            ListProtector.add(r0, r1, r4);
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> r3) {
            Intrinsics.checkNotNullParameter(r3, "elements");
            this.list.addAll(this.end, r3);
            this.end += r3.size();
            if (r3.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object r4) {
            int r0 = this.start;
            int r1 = this.end;
        L3:
            if (r0 >= r1) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r0), r4) == true) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            Iterator<T> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            if (contains(r3.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.List
        public T get(int r3) {
            ObjectListKt.access$checkIndex(this, r3);
            return (T) ListProtector.get(this.list, r3 + this.start);
        }

        @Override // java.util.List
        public int indexOf(Object r4) {
            int r0 = this.start;
            int r1 = this.end;
        L3:
            if (r0 >= r1) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r0), r4) == true) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return r0 - this.start;
        L9:
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(Object r4) {
            int r0 = this.end - 1;
            int r1 = this.start;
            if (r1 <= r0) goto L5;
            return -1;
        L5:
            if (Intrinsics.areEqual(ListProtector.get(this.list, r0), r4) == true) goto L7;
            if (r0 == r1) goto L14;
            r0 = r0 - 1;
            goto L5
        L14:
            return -1;
        L7:
            return r0 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int r2) {
            return new MutableObjectListIterator(this, r2);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object r4) {
            int r0 = this.start;
            int r1 = this.end;
        L3:
            if (r0 >= r1) goto L9;
            if (Intrinsics.areEqual(ListProtector.get(this.list, r0), r4) == true) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            ListProtector.remove(this.list, r0);
            this.end--;
            return true;
        L9:
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "elements");
            int r0 = this.end;
            Iterator<T> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            remove(r4.next());
            goto L4
        L7:
            if (r0 == this.end) goto L9;
            return true;
        L9:
            return false;
        }

        public T removeAt(int r3) {
            ObjectListKt.access$checkIndex(this, r3);
            T r4 = (T) ListProtector.remove(this.list, r3 + this.start);
            this.end--;
            return r4;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<?> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            int r0 = this.end;
            int r1 = r0 - 1;
            int r2 = this.start;
            if (r2 > r1) goto L10;
        L5:
            if (r5.contains(ListProtector.get(this.list, r1)) == true) goto L7;
            ListProtector.remove(this.list, r1);
            this.end--;
        L7:
            if (r1 == r2) goto L10;
            r1 = r1 - 1;
        L10:
            if (r0 == this.end) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int r1) {
            return removeAt(r1);
        }

        @Override // java.util.List
        public void add(int r3, T r4) {
            ListProtector.add(this.list, r3 + this.start, r4);
            this.end++;
        }

        @Override // java.util.List
        public boolean addAll(int r3, Collection<? extends T> r4) {
            Intrinsics.checkNotNullParameter(r4, "elements");
            this.list.addAll(r3 + this.start, r4);
            this.end += r4.size();
            if (r4.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.List
        public T set(int r3, T r4) {
            ObjectListKt.access$checkIndex(this, r3);
            return (T) ListProtector.set(this.list, r3 + this.start, r4);
        }

        @Override // java.util.List
        public List<T> subList(int r2, int r3) {
            ObjectListKt.access$checkSubIndex(this, r2, r3);
            return new SubList(this, r2, r3);
        }

        public SubList(List<T> r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "list");
            this.list = r2;
            this.start = r3;
            this.end = r4;
        }
    }

    public MutableObjectList() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> r0 = this.list;
        if (r0 != null) goto L7;
        ObjectListMutableList<E> r1 = new ObjectListMutableList(this);
        this.list = r1;
        return r1;
    L7:
        return r0;
    }

    public final void clear() {
        ArraysKt.fill(this.content, null, 0, this._size);
        this._size = 0;
    }

    public final int getCapacity() {
        return this.content.length;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public MutableObjectList(int r2) {
        super(r2, null);
    }

    private final void throwIndexOutOfBoundsInclusiveException(int r3) {
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index " + r3 + " must be in 0.." + this._size);
    }

    public final boolean add(E r5) {
        int r0 = this._size + 1;
        Object[] r2 = this.content;
        if (r2.length >= r0) goto L5;
        resizeStorage(r0, r2);
    L5:
        Object[] r1 = this.content;
        int r3 = this._size;
        r1[r3] = r5;
        this._size = r3 + 1;
        return true;
    }

    public final boolean addAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void ensureCapacity(int r3) {
        Object[] r0 = this.content;
        if (r0.length >= r3) goto L6;
        resizeStorage(r3, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> r15) {
        Intrinsics.checkNotNullParameter(r15, "elements");
        Object[] r0 = r15.elements;
        long[] r16 = r15.metadata;
        int r1 = r16.length - 2;
        if (r1 < 0) goto L19;
        int r3 = 0;
    L5:
        long r4 = r16[r3];
        if (((((~r4) << 7) & r4) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r6 = 8 - ((~(r3 - r1)) >>> 31);
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L16;
        if ((255 & r4) >= 128) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L15;
        remove(r0[(r3 << 3) + r8]);
    L15:
        r4 = r4 >> 8;
        r8 = r8 + 1;
        goto L8
    L12:
        r9 = false;
        goto L13
    L16:
        if (r6 == 8) goto L17;
        return;
    L17:
        if (r3 == r1) goto L26;
        r3 = r3 + 1;
        goto L5
    L26:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> r15) {
        Intrinsics.checkNotNullParameter(r15, "elements");
        if (r15.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this._size + r15.getSize();
        Object[] r1 = this.content;
        if (r1.length >= r0) goto L8;
        resizeStorage(r0, r1);
    L8:
        Object[] r2 = r15.elements;
        long[] r16 = r15.metadata;
        int r3 = r16.length - 2;
        if (r3 < 0) goto L25;
        int r4 = 0;
    L11:
        long r5 = r16[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r6 = 8 - ((~(r4 - r3)) >>> 31);
        int r8 = 0;
    L14:
        if (r8 >= r6) goto L22;
        if ((255 & r5) >= 128) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        add(r2[(r4 << 3) + r8]);
    L21:
        r5 = r5 >> 8;
        r8 = r8 + 1;
        goto L14
    L18:
        r9 = false;
        goto L19
    L22:
        if (r6 == 8) goto L23;
        return;
    L23:
        if (r4 == r3) goto L32;
        r4 = r4 + 1;
        goto L11
    L32:
        return;
    }

    public final boolean remove(E r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L6;
        removeAt(r2);
        return true;
    L6:
        return false;
    }

    public final boolean removeAll(E[] r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        int r0 = this._size;
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        remove(r6[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        if (r0 == this._size) goto L10;
        return true;
    L10:
        return false;
    }

    public final E removeAt(int r5) {
        boolean r0 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        throwIndexOutOfBoundsExclusiveException$collection(r5);
    L9:
        Object[] r1 = this.content;
        E r2 = (E) r1[r5];
        int r3 = this._size;
        if (r5 == (r3 - 1)) goto L12;
        ArraysKt.copyInto(r1, r1, r5, r5 + 1, r3);
    L12:
        int r6 = this._size - 1;
        this._size = r6;
        r1[r6] = null;
        return r2;
    L5:
        if (r5 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final void removeIf(Function1<? super E, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r8, "predicate");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = 0;
        IntRange r3 = RangesKt.until(0, r0);
        int r4 = r3.getFirst();
        int r5 = r3.getLast();
        if (r4 > r5) goto L9;
    L4:
        r1[r4 - r2] = r1[r4];
        if (((Boolean) r8.invoke(r1[r4])).booleanValue() == false) goto L7;
        r2 = r2 + 1;
    L7:
        if (r4 == r5) goto L9;
        r4 = r4 + 1;
    L9:
        ArraysKt.fill(r1, null, r0 - r2, r0);
        this._size -= r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = r0 - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (r5.contains(r1[r2]) == true) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final void trim(int r3) {
        int r4 = Math.max(r3, this._size);
        Object[] r0 = this.content;
        if (r0.length <= r4) goto L6;
        this.content = Arrays.copyOf(r0, r4);
        return;
    }

    public final boolean addAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(List<? extends E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(ListProtector.get(r4, r1));
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(List<? extends E> r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this._size;
        int r1 = r7.size() + r0;
        Object[] r2 = this.content;
        if (r2.length >= r1) goto L8;
        resizeStorage(r1, r2);
    L8:
        Object[] r3 = this.content;
        int r4 = r7.size();
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L11;
        r3[r5 + r0] = ListProtector.get(r7, r5);
        r5 = r5 + 1;
        goto L9
    L11:
        this._size += r7.size();
    }

    public final boolean removeAll(ObjectList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Iterable<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = r0 - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (CollectionsKt.contains(r5, r1[r2]) == true) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator<? extends E> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }

    public final void plusAssign(E[] r11) {
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        int r1 = this._size + r11.length;
        Object[] r2 = this.content;
        if (r2.length >= r1) goto L11;
        resizeStorage(r1, r2);
    L11:
        ArraysKt.copyInto$default(r11, this.content, this._size, 0, 0, 12, null);
        this._size += r11.length;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean removeAll(ScatterSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Collection<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = r0 - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (r5.contains(r1[r2]) == true) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(List<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        remove(r3.next());
        goto L4
    }

    public final void plusAssign(ObjectList<E> r6) {
        Intrinsics.checkNotNullParameter(r6, "elements");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this._size + r6._size;
        Object[] r1 = this.content;
        if (r1.length >= r0) goto L8;
        resizeStorage(r0, r1);
    L8:
        ArraysKt.copyInto(r6.content, this.content, this._size, 0, r6._size);
        this._size += r6._size;
    }

    public final boolean removeAll(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(Sequence<? extends E> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = r0 - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (SequencesKt.contains(r5, r1[r2]) == true) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        Object[] r0 = r4.content;
        int r5 = r4._size;
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        remove(r0[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public final void plusAssign(Iterable<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator<? extends E> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        add(r3.next());
        goto L4
    }

    public final boolean removeAll(List<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean retainAll(E[] r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        int r0 = this._size;
        Object[] r1 = this.content;
        int r2 = r0 - 1;
    L4:
        if ((-1) >= r2) goto L10;
        if (ArraysKt.indexOf(r5, r1[r2]) >= 0) goto L8;
        removeAt(r2);
    L8:
        r2 = r2 - 1;
        goto L4
    L10:
        if (r0 == this._size) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean addAll(E[] r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        plusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E[] r4) {
        Intrinsics.checkNotNullParameter(r4, "elements");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        remove(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        add(r3.next());
        goto L4
    }

    public final boolean removeAll(Sequence<? extends E> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        int r0 = this._size;
        minusAssign(r2);
        if (r0 == this._size) goto L5;
        return true;
    L5:
        return false;
    }

    public final void minusAssign(E r1) {
        remove(r1);
    }

    public final void plusAssign(E r1) {
        add(r1);
    }

    public final void add(int r5, E r6) {
        boolean r0 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        throwIndexOutOfBoundsInclusiveException(r5);
    L9:
        int r1 = this._size + 1;
        Object[] r2 = this.content;
        if (r2.length >= r1) goto L12;
        resizeStorage(r1, r2);
    L12:
        Object[] r3 = this.content;
        int r4 = this._size;
        if (r5 == r4) goto L15;
        ArraysKt.copyInto(r3, r3, r5 + 1, r5, r4);
    L15:
        r3[r5] = r6;
        this._size++;
        return;
    L5:
        if (r5 > this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final boolean addAll(int r7, Collection<? extends E> r8) {
        Intrinsics.checkNotNullParameter(r8, "elements");
        int r1 = 0;
        if (r7 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        throwIndexOutOfBoundsInclusiveException(r7);
    L11:
        if (r8.isEmpty() == false) goto L13;
        return false;
    L13:
        int r3 = this._size + r8.size();
        Object[] r4 = this.content;
        if (r4.length >= r3) goto L16;
        resizeStorage(r3, r4);
    L16:
        Object[] r5 = this.content;
        if (r7 == this._size) goto L19;
        ArraysKt.copyInto(r5, r5, r8.size() + r7, r7, this._size);
    L19:
        Iterator<T> r6 = r8.iterator();
    L21:
        if (r6.hasNext() == false) goto L26;
        Object r9 = r6.next();
        int r10 = r1 + 1;
        if (r1 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r5[r1 + r7] = r9;
        r1 = r10;
        goto L21
    L26:
        this._size += r8.size();
        return true;
    L5:
        if (r7 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final void removeRange(int r5, int r6) {
        boolean r0 = true;
        if (r5 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L16;
        if (r6 >= 0) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == false) goto L16;
    L17:
        if (r6 >= r5) goto L19;
        RuntimeHelpersKt.throwIllegalArgumentException("Start (" + r5 + ") is more than end (" + r6 + ')');
    L19:
        if (r6 == r5) goto L25;
        int r1 = this._size;
        if (r6 >= r1) goto L23;
        Object[] r3 = this.content;
        ArraysKt.copyInto(r3, r3, r5, r6, r1);
    L23:
        int r4 = this._size;
        int r7 = r4 - (r6 - r5);
        ArraysKt.fill(this.content, null, r7, r4);
        this._size = r7;
        return;
    L25:
        return;
    L12:
        if (r6 > this._size) goto L14;
    L16:
        RuntimeHelpersKt.throwIndexOutOfBoundsException("Start (" + r5 + ") and end (" + r6 + ") must be in 0.." + this._size);
        goto L17
    L5:
        if (r5 > this._size) goto L7;
        r2 = true;
        goto L9
    }

    public final void resizeStorage(int r3, Object[] r4) {
        Intrinsics.checkNotNullParameter(r4, "oldContent");
        int r0 = r4.length;
        this.content = ArraysKt.copyInto(r4, new Object[Math.max(r3, (r0 * 3) / 2)], 0, 0, r0);
    }

    public final E set(int r3, E r4) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        throwIndexOutOfBoundsExclusiveException$collection(r3);
    L9:
        Object[] r1 = this.content;
        E r2 = (E) r1[r3];
        r1[r3] = r4;
        return r2;
    L5:
        if (r3 >= this._size) goto L7;
        r0 = true;
        goto L7
    }

    public final boolean addAll(int r12, E[] r13) {
        Intrinsics.checkNotNullParameter(r13, "elements");
        if (r12 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        throwIndexOutOfBoundsInclusiveException(r12);
    L11:
        if (r13.length != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return false;
    L16:
        int r1 = this._size + r13.length;
        Object[] r4 = this.content;
        if (r4.length >= r1) goto L19;
        resizeStorage(r1, r4);
    L19:
        Object[] r5 = this.content;
        int r6 = this._size;
        if (r12 == r6) goto L22;
        ArraysKt.copyInto(r5, r5, r13.length + r12, r12, r6);
    L22:
        ArraysKt.copyInto$default(r13, r5, r12, 0, 0, 12, null);
        this._size += r13.length;
        return true;
    L13:
        r3 = false;
        goto L14
    L5:
        if (r12 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean addAll(int r6, ObjectList<E> r7) {
        Intrinsics.checkNotNullParameter(r7, "elements");
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        throwIndexOutOfBoundsInclusiveException(r6);
    L11:
        if (r7.isEmpty() == false) goto L13;
        return false;
    L13:
        int r3 = this._size + r7._size;
        Object[] r4 = this.content;
        if (r4.length >= r3) goto L16;
        resizeStorage(r3, r4);
    L16:
        Object[] r5 = this.content;
        int r8 = this._size;
        if (r6 == r8) goto L19;
        ArraysKt.copyInto(r5, r5, r7._size + r6, r6, r8);
    L19:
        ArraysKt.copyInto(r7.content, r5, r6, 0, r7._size);
        this._size += r7._size;
        return true;
    L5:
        if (r6 > this._size) goto L7;
        r2 = true;
        goto L8
    }

    public /* synthetic */ MutableObjectList(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 16;
    L5:
        this(r1);
    }

    public static /* synthetic */ void trim$default(MutableObjectList r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0._size;
    L5:
        r0.trim(r1);
    }
}
