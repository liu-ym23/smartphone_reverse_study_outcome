package kotlin.ranges;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0013\u0010\f\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u00020\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b!¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", SoloKtvContext.SOLO_PAGE_FIRST, "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public /* synthetic */ UIntProgressionIterator(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: next-pVg5ArA, reason: not valid java name */
    public int m10679nextpVg5ArA() {
        int r100 = this.next;
        if (r100 == this.finalElement) goto L5;
        this.next = UInt.m9544constructorimpl(this.step + r100);
    L10:
        return r100;
    L5:
        if (this.hasNext == false) goto L8;
        this.hasNext = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m9538boximpl(m10679nextpVg5ArA());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    private UIntProgressionIterator(int r100, int r101, int r102) {
        this.finalElement = r101;
        boolean r103 = true;
        int r104 = Integer.compare(r100 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r101);
        if (r102 <= 0) goto L6;
        if (r104 <= 0) goto L9;
    L8:
        r103 = false;
    L9:
        this.hasNext = r103;
        this.step = UInt.m9544constructorimpl(r102);
        if (this.hasNext == true) goto L13;
        r100 = r101;
    L13:
        this.next = r100;
        return;
    L6:
        if (r104 < 0) goto L8;
        goto L8
    }
}
