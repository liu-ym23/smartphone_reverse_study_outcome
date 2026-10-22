package kotlin.ranges;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", SoloKtvContext.SOLO_PAGE_FIRST, "", "last", "step", "", "(CCI)V", "finalElement", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "getStep", "()I", "nextChar", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CharProgressionIterator extends CharIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        int r100 = this.next;
        if (r100 == this.finalElement) goto L5;
        this.next = this.step + r100;
    L11:
        return (char) r100;
    L5:
        if (this.hasNext == false) goto L8;
        this.hasNext = false;
        goto L11
    L8:
        throw new NoSuchElementException();
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    public CharProgressionIterator(char r100, char r101, int r102) {
        this.step = r102;
        this.finalElement = r101;
        boolean r103 = true;
        if (r102 <= 0) goto L8;
        if (Intrinsics.compare(r100, r101) <= 0) goto L11;
    L10:
        r103 = false;
    L11:
        this.hasNext = r103;
        if (r103 == true) goto L15;
        r100 = r101;
    L15:
        this.next = r100;
        return;
    L8:
        if (Intrinsics.compare(r100, r101) < 0) goto L10;
        goto L10
    }
}
