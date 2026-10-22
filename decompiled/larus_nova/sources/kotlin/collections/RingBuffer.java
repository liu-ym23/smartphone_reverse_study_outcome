package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0082\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lkotlin/collections/RingBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", "add", "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", OfficeSDKRequestTag.KEY_NEW_USER, "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    public final boolean isFull() {
        if (size() != this.capacity) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public RingBuffer(int r100) {
        this(new Object[r100], 0);
    }

    public static final /* synthetic */ Object[] access$getBuffer$p(RingBuffer r100) {
        return r100.buffer;
    }

    public static final /* synthetic */ int access$getCapacity$p(RingBuffer r100) {
        return r100.capacity;
    }

    public static final /* synthetic */ int access$getStartIndex$p(RingBuffer r100) {
        return r100.startIndex;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T r100) {
        if (isFull() == true) goto L7;
        this.buffer[(this.startIndex + size()) % access$getCapacity$p(this)] = r100;
        this.size = size() + 1;
        return;
    L7:
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int r100) {
        int r101 = this.capacity;
        int r102 = RangesKt.coerceAtMost((r101 + (r101 >> 1)) + 1, r100);
        if (this.startIndex != 0) goto L5;
        Object[] r103 = Arrays.copyOf(this.buffer, r102);
    L7:
        return new RingBuffer(r103, size());
    L5:
        r103 = toArray(new Object[r102]);
        goto L7
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int r100) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r100, size());
        return (T) this.buffer[(this.startIndex + r100) % access$getCapacity$p(this)];
    }

    public final void removeFirst(int r100) {
        boolean r101 = true;
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L22;
        if (r100 <= size()) goto L11;
        r101 = false;
    L11:
        if (r101 == false) goto L20;
        if (r100 <= 0) goto L23;
        int r103 = this.startIndex;
        int r104 = (r103 + r100) % access$getCapacity$p(this);
        if (r103 <= r104) goto L16;
        ArraysKt.fill(this.buffer, null, r103, this.capacity);
        ArraysKt.fill(this.buffer, null, 0, r104);
    L17:
        this.startIndex = r104;
        this.size = size() - r100;
        return;
    L16:
        ArraysKt.fill(this.buffer, null, r103, r104);
        goto L17
    L23:
        return;
    L20:
        throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + r100 + ", size = " + size()).toString());
    L22:
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + r100).toString());
    L5:
        r102 = false;
        goto L6
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        int r101 = r100.length;
        Object[] r102 = r100;
        if (r101 >= size()) goto L5;
        r102 = (T[]) Arrays.copyOf(r100, size());
    L5:
        int r103 = size();
        int r104 = this.startIndex;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r106 >= r103) goto L10;
        if (r104 >= this.capacity) goto L10;
        r102[r106] = this.buffer[r104];
        r106 = r106 + 1;
        r104 = r104 + 1;
    L10:
        if (r106 >= r103) goto L13;
        r102[r106] = this.buffer[r105];
        r106 = r106 + 1;
        r105 = r105 + 1;
        goto L10
    L13:
        return (T[]) CollectionsKt.terminateCollectionToArray(r103, r102);
    }

    public RingBuffer(Object[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        this.buffer = r100;
        boolean r102 = true;
        if (r101 < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L17;
        if (r101 <= r100.length) goto L11;
        r102 = false;
    L11:
        if (r102 == false) goto L15;
        this.capacity = r100.length;
        this.size = r101;
        return;
    L15:
        throw new IllegalArgumentException(("ring buffer filled size: " + r101 + " cannot be larger than the buffer size: " + r100.length).toString());
    L17:
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + r101).toString());
    L5:
        r103 = false;
        goto L6
    }

    private final int forward(int r100, int r101) {
        return (r100 + r101) % access$getCapacity$p(this);
    }
}
