package com.larus.common_ui.floatwindow.manager;

import com.larus.utils.logger.FLogger;
import e19.h;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/common_ui/floatwindow/manager/FloatPriorityQueue;", "Ljava/util/PriorityQueue;", "Lcom/larus/common_ui/floatwindow/manager/IFloatRequest;", "initialCapacity", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "<init>", "(ILjava/util/Comparator;)V", "add", "", "element", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatPriorityQueue extends PriorityQueue<h> {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.PriorityQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public boolean add(h r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Iterator r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        h r102 = (h) r101.next();
        if (Intrinsics.areEqual(r100.getPriority(), r102.getPriority()) == false) goto L4;
        FLogger.f375446a.i("FloatPriorityQueue", "remove element due to same level");
        super.remove(r102);
        r102.a();
    L9:
        return super.add(r100);
    }

    @Override // java.util.PriorityQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L9;
        return false;
    L9:
        return contains((h) r100);
    L4:
        r101 = r100 instanceof h;
        goto L5
    }

    @Override // java.util.PriorityQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean remove(Object r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L9;
        return false;
    L9:
        return remove((h) r100);
    L4:
        r101 = r100 instanceof h;
        goto L5
    }

    @Override // java.util.PriorityQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        return add((h) r100);
    }

    public /* bridge */ boolean contains(h r100) {
        return super.contains(r100);
    }

    public /* bridge */ boolean remove(h r100) {
        return super.remove(r100);
    }

    public FloatPriorityQueue(int r100, Comparator<h> r101) {
        Intrinsics.checkNotNullParameter(r101, "comparator");
        super(r100, r101);
    }
}
