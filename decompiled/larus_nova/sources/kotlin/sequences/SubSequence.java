package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/sequences/SubSequence;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", OfficeSDKRequestTag.KEY_NEW_USER, "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int endIndex;
    private final Sequence<T> sequence;
    private final int startIndex;

    /* JADX INFO: renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "drop", "", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int position;
        final /* synthetic */ SubSequence<T> this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        private final void drop() {
        L3:
            if (this.position >= SubSequence.access$getStartIndex$p(this.this$0)) goto L7;
            if (this.iterator.hasNext() == false) goto L10;
            this.iterator.next();
            this.position++;
            goto L3
        L10:
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            drop();
            if (this.position < SubSequence.access$getEndIndex$p(this.this$0)) goto L5;
        L7:
            return false;
        L5:
            if (this.iterator.hasNext() == false) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            drop();
            if (this.position >= SubSequence.access$getEndIndex$p(this.this$0)) goto L7;
            this.position++;
            return this.iterator.next();
        L7:
            throw new NoSuchElementException();
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final int getPosition() {
            return this.position;
        }

        public AnonymousClass1(SubSequence<T> r100) {
            this.this$0 = r100;
            this.iterator = SubSequence.access$getSequence$p(r100).iterator();
        }

        public final void setPosition(int r100) {
            this.position = r100;
        }
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    public static final /* synthetic */ int access$getEndIndex$p(SubSequence r100) {
        return r100.endIndex;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(SubSequence r100) {
        return r100.sequence;
    }

    public static final /* synthetic */ int access$getStartIndex$p(SubSequence r100) {
        return r100.startIndex;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int r100) {
        if (r100 < getCount()) goto L6;
        return SequencesKt.emptySequence();
    L6:
        return new SubSequence(this.sequence, this.startIndex + r100, this.endIndex);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int r100) {
        if (r100 >= getCount()) goto L7;
        Sequence<T> r101 = this.sequence;
        int r102 = this.startIndex;
        return new SubSequence(r101, r102, r100 + r102);
    L7:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubSequence(Sequence<? extends T> r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "sequence");
        this.sequence = r100;
        this.startIndex = r101;
        this.endIndex = r102;
        boolean r103 = true;
        if (r101 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L21;
        if (r102 < 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L19;
        if (r102 >= r101) goto L14;
        r103 = false;
    L14:
        if (r103 == false) goto L17;
        return;
    L17:
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + r102 + " < " + r101).toString());
    L19:
        throw new IllegalArgumentException(("endIndex should be non-negative, but is " + r102).toString());
    L9:
        r105 = false;
        goto L10
    L21:
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + r101).toString());
    L5:
        r104 = false;
        goto L6
    }
}
