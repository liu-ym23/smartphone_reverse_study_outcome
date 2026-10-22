package com.bytedance.helios.sdk.region;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import uz5.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/helios/sdk/region/FixSizeLinkedList;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/ConcurrentLinkedQueue;", "element", "", "offer", "(Ljava/lang/Object;)Z", "", "capacity", "I", "Luz5/a;", "fixSizeLinkedListListener", "Luz5/a;", "", "initialCollection", "<init>", "(ILuz5/a;Ljava/util/Collection;)V", "sdk_release"}, k = 1, mv = {1, 4, 0})
public final class FixSizeLinkedList<T> extends ConcurrentLinkedQueue<T> {
    private final int capacity;
    private final a<T> fixSizeLinkedListListener;

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public synchronized boolean offer(T r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (size() < this.capacity) goto L9;
        a<T> r101 = this.fixSizeLinkedListListener;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        r101.a();     // Catch: Throwable -> L16
    L9:
        if ((size() + 1) <= this.capacity) goto L11;
        poll();     // Catch: Throwable -> L16
    L11:
        boolean r102 = super.offer(r100);     // Catch: Throwable -> L16
        a<T> r103 = this.fixSizeLinkedListListener;     // Catch: Throwable -> L16
        if (r103 == null) goto L14;
        r103.b(r100, r102);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return r102;
    }

    public FixSizeLinkedList(int r100, a<T> r101, Collection<? extends T> r102) {
        super(r102);
        this.capacity = r100;
        this.fixSizeLinkedListListener = r101;
    }

    public /* synthetic */ FixSizeLinkedList(int r100, a r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        this(r100, r101, r102);
    }
}
