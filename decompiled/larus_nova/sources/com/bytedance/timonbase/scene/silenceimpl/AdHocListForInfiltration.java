package com.bytedance.timonbase.scene.silenceimpl;

import android.view.View;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B!\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/timonbase/scene/silenceimpl/AdHocListForInfiltration;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", PlayerResolution.SDKKEY.ORIGIN, "(Ljava/util/ArrayList;)V", "add", "", "element", "timonbase_release"}, k = 1, mv = {1, 1, 16})
public final class AdHocListForInfiltration extends ArrayList<View> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public AdHocListForInfiltration(ArrayList<View> r100) {
        if (r100 != null) goto L5;
        r100 = new ArrayList();
    L5:
        super(r100);
    }

    public boolean add(View r100) {
        a.f270895e.getClass();
        a.b(r100);
        return super.add(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof View) == true) goto L5;
        return false;
    L5:
        return contains((View) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof View) == true) goto L5;
        return -1;
    L5:
        return indexOf((View) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof View) == true) goto L5;
        return -1;
    L5:
        return lastIndexOf((View) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof View) == true) goto L5;
        return false;
    L5:
        return remove((View) r100);
    }

    public /* bridge */ View removeAt(int r100) {
        return remove(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r100) {
        return add((View) r100);
    }

    public /* bridge */ boolean contains(View r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(View r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(View r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ View remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(View r100) {
        return super.remove(r100);
    }
}
