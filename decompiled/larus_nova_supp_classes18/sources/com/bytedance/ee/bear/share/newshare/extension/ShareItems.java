package com.bytedance.ee.bear.share.newshare.extension;

import com.bytedance.ee.bear.share.newshare.z;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/share/newshare/extension/ShareItems;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/newshare/ShareItem;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "features-share-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareItems extends ArrayList<z> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public ShareItems() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof z) == true) goto L7;
        return false;
    L7:
        return contains((z) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof z) == true) goto L7;
        return -1;
    L7:
        return indexOf((z) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof z) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((z) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r2) {
        if ((r2 instanceof z) == true) goto L7;
        return false;
    L7:
        return remove((z) r2);
    }

    public /* bridge */ z removeAt(int r1) {
        return remove(r1);
    }

    public /* bridge */ boolean contains(z r1) {
        return super.contains(r1);
    }

    public /* bridge */ int indexOf(z r1) {
        return super.indexOf(r1);
    }

    public /* bridge */ int lastIndexOf(z r1) {
        return super.lastIndexOf(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ z remove(int r1) {
        return removeAt(r1);
    }

    public /* bridge */ boolean remove(z r1) {
        return super.remove(r1);
    }
}
