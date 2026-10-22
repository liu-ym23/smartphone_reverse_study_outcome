package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.bear.bitable.uikit.fieldcell.CapsuleModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/SelectCellValue;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/CapsuleModel;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "getOptionList", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectCellValue extends ArrayList<CapsuleModel> {
    public final List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> getOptionList() {
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(this, 10));
        Iterator<CapsuleModel> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        CapsuleModel r102 = r101.next();
        r100.add(new com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a("", r102.getText(), 0, r102.getCapsuleColor(), r102.getTextColor(), r102.getBorderColor()));
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

    public SelectCellValue() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof CapsuleModel) == true) goto L7;
        return false;
    L7:
        return contains((CapsuleModel) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof CapsuleModel) == true) goto L7;
        return -1;
    L7:
        return indexOf((CapsuleModel) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof CapsuleModel) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((CapsuleModel) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof CapsuleModel) == true) goto L7;
        return false;
    L7:
        return remove((CapsuleModel) r100);
    }

    public /* bridge */ CapsuleModel removeAt(int r100) {
        return remove(r100);
    }

    public /* bridge */ boolean contains(CapsuleModel r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(CapsuleModel r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(CapsuleModel r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ CapsuleModel remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(CapsuleModel r100) {
        return super.remove(r100);
    }
}
