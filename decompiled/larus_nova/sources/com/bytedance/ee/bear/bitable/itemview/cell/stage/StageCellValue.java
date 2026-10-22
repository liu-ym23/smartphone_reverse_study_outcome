package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import com.bytedance.ee.bear.bitable.common.model.field.RichOptionItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageCellValue;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageItem;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "getStageItemList", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class StageCellValue extends ArrayList<StageItem> {
    public final List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> getStageItemList() {
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(this, 10));
        Iterator<StageItem> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        StageItem r102 = r101.next();
        RichOptionItem r103 = new RichOptionItem();
        r103.setType(r102.getType());
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r104 = new com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a("", r102.getText(), 0, r102.getCapsuleColor(), r102.getTextColor());
        r104.f207146f = r102.getBorderColor();
        r100.add(new com.bytedance.ee.bear.bitable.card.model.stmodel.field.d(r103, r104));
        goto L4
    L6:
        return r100;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public StageCellValue() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof StageItem) == true) goto L7;
        return false;
    L7:
        return contains((StageItem) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof StageItem) == true) goto L7;
        return -1;
    L7:
        return indexOf((StageItem) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof StageItem) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((StageItem) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof StageItem) == true) goto L7;
        return false;
    L7:
        return remove((StageItem) r100);
    }

    public /* bridge */ StageItem removeAt(int r100) {
        return (StageItem) super.remove(r100);
    }

    public /* bridge */ boolean contains(StageItem r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(StageItem r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(StageItem r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ StageItem remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(StageItem r100) {
        return super.remove(r100);
    }
}
