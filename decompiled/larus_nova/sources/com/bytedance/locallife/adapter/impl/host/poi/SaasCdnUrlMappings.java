package com.bytedance.locallife.adapter.impl.host.poi;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/adapter/impl/host/poi/SaasCdnUrlMappings;", "Ljava/util/ArrayList;", "Lcom/bytedance/locallife/adapter/impl/host/poi/d;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SaasCdnUrlMappings extends ArrayList<d> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public SaasCdnUrlMappings() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof d) == true) goto L7;
        return false;
    L7:
        return contains((d) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof d) == true) goto L7;
        return -1;
    L7:
        return indexOf((d) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof d) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((d) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof d) == true) goto L7;
        return false;
    L7:
        return remove((d) r100);
    }

    public /* bridge */ d removeAt(int r100) {
        return remove(r100);
    }

    public /* bridge */ boolean contains(d r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(d r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(d r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ d remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(d r100) {
        return super.remove(r100);
    }
}
