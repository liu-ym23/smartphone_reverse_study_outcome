package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.BooleanIterator;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/jvm/internal/ArrayBooleanIterator;", "Lkotlin/collections/BooleanIterator;", "array", "", "([Z)V", "index", "", "hasNext", "", "nextBoolean", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ArrayBooleanIterator extends BooleanIterator {
    private final boolean[] array;
    private int index;

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.array.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.BooleanIterator
    public boolean nextBoolean() {
        boolean[] r100 = this.array;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r101 = this.index;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.index = r101 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r100[r101];
    L4:
        e = move-exception;
        this.index--;
        throw new NoSuchElementException(e.getMessage());
    }

    public ArrayBooleanIterator(boolean[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        this.array = r100;
    }
}
