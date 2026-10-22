package com.bytedance.ee.bear.more.protocol3.extension;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/more/protocol3/extension/MoreItems;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/more/protocol3/MoreItem;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreItems extends ArrayList<com.bytedance.ee.bear.more.protocol3.b> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public MoreItems() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof com.bytedance.ee.bear.more.protocol3.b) == true) goto L7;
        return false;
    L7:
        return contains((com.bytedance.ee.bear.more.protocol3.b) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof com.bytedance.ee.bear.more.protocol3.b) == true) goto L7;
        return -1;
    L7:
        return indexOf((com.bytedance.ee.bear.more.protocol3.b) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof com.bytedance.ee.bear.more.protocol3.b) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((com.bytedance.ee.bear.more.protocol3.b) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof com.bytedance.ee.bear.more.protocol3.b) == true) goto L7;
        return false;
    L7:
        return remove((com.bytedance.ee.bear.more.protocol3.b) r100);
    }

    public /* bridge */ com.bytedance.ee.bear.more.protocol3.b removeAt(int r100) {
        return remove(r100);
    }

    public /* bridge */ boolean contains(com.bytedance.ee.bear.more.protocol3.b r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(com.bytedance.ee.bear.more.protocol3.b r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(com.bytedance.ee.bear.more.protocol3.b r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ com.bytedance.ee.bear.more.protocol3.b remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(com.bytedance.ee.bear.more.protocol3.b r100) {
        return super.remove(r100);
    }
}
