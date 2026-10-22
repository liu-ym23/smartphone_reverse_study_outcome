package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/TakeSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", OfficeSDKRequestTag.KEY_NEW_USER, "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TakeSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.TakeSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"kotlin/sequences/TakeSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int left;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.left > 0) goto L5;
        L7:
            return false;
        L5:
            if (this.iterator.hasNext() == false) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            int r100 = this.left;
            if (r100 == 0) goto L7;
            this.left = r100 - 1;
            return this.iterator.next();
        L7:
            throw new NoSuchElementException();
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final int getLeft() {
            return this.left;
        }

        public AnonymousClass1(TakeSequence<T> r100) {
            this.left = TakeSequence.access$getCount$p(r100);
            this.iterator = TakeSequence.access$getSequence$p(r100).iterator();
        }

        public final void setLeft(int r100) {
            this.left = r100;
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    public static final /* synthetic */ int access$getCount$p(TakeSequence r100) {
        return r100.count;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(TakeSequence r100) {
        return r100.sequence;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int r100) {
        int r101 = this.count;
        if (r100 < r101) goto L6;
        return SequencesKt.emptySequence();
    L6:
        return new SubSequence(this.sequence, r100, r101);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int r100) {
        if (r100 < this.count) goto L6;
        return this;
    L6:
        return new TakeSequence(this.sequence, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TakeSequence(Sequence<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "sequence");
        this.sequence = r100;
        this.count = r101;
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("count must be non-negative, but was " + r101 + '.').toString());
    L5:
        r102 = false;
        goto L6
    }
}
