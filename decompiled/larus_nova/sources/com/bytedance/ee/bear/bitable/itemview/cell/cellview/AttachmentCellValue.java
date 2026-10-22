package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentCellValue extends ArrayList<AttachmentEntity> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public AttachmentCellValue() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof AttachmentEntity) == true) goto L7;
        return false;
    L7:
        return contains((AttachmentEntity) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof AttachmentEntity) == true) goto L7;
        return -1;
    L7:
        return indexOf((AttachmentEntity) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof AttachmentEntity) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((AttachmentEntity) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof AttachmentEntity) == true) goto L7;
        return false;
    L7:
        return remove((AttachmentEntity) r100);
    }

    public /* bridge */ AttachmentEntity removeAt(int r100) {
        return remove(r100);
    }

    public /* bridge */ boolean contains(AttachmentEntity r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(AttachmentEntity r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(AttachmentEntity r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ AttachmentEntity remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(AttachmentEntity r100) {
        return super.remove(r100);
    }
}
