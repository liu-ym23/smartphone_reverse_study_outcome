package kotlin.ranges;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", SoloKtvContext.SOLO_PAGE_FIRST, "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "getStep", "()J", "nextLong", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LongProgressionIterator extends LongIterator {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long r100 = this.next;
        if (r100 == this.finalElement) goto L5;
        this.next = this.step + r100;
    L10:
        return r100;
    L5:
        if (this.hasNext == false) goto L8;
        this.hasNext = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }

    public final long getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    public LongProgressionIterator(long r100, long r101, long r110) {
        this.step = r110;
        this.finalElement = r101;
        boolean r102 = true;
        if (r110 <= 0) goto L6;
        if (r100 <= r101) goto L9;
    L8:
        r102 = false;
    L9:
        this.hasNext = r102;
        if (r102 == true) goto L13;
        r100 = r101;
    L13:
        this.next = r100;
        return;
    L6:
        if (r100 < r101) goto L8;
        goto L8
    }
}
