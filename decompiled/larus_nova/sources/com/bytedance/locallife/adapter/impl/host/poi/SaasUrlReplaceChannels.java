package com.bytedance.locallife.adapter.impl.host.poi;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/adapter/impl/host/poi/SaasUrlReplaceChannels;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "()V", "locallife-adapter-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SaasUrlReplaceChannels extends ArrayList<String> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public SaasUrlReplaceChannels() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return contains((String) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return -1;
    L7:
        return indexOf((String) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((String) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return remove((String) r100);
    }

    public /* bridge */ String removeAt(int r100) {
        return remove(r100);
    }

    public /* bridge */ boolean contains(String r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(String r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(String r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ String remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(String r100) {
        return super.remove(r100);
    }
}
