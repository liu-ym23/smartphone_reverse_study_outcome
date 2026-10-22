package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0012\u0012\u0004\u0012\u0002H\u00010\u0003j\b\u0012\u0004\u0012\u0002H\u0001`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ChatterCellValue;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatterCellValue<T extends IChatterEntity> extends ArrayList<T> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public ChatterCellValue() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof IChatterEntity) == true) goto L7;
        return false;
    L7:
        return contains((IChatterEntity) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof IChatterEntity) == true) goto L7;
        return -1;
    L7:
        return indexOf((IChatterEntity) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof IChatterEntity) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((IChatterEntity) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof IChatterEntity) == true) goto L7;
        return false;
    L7:
        return remove((IChatterEntity) r100);
    }

    public /* bridge */ IChatterEntity removeAt(int r100) {
        return (IChatterEntity) super.remove(r100);
    }

    public /* bridge */ boolean contains(IChatterEntity r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(IChatterEntity r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(IChatterEntity r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int r100) {
        return (T) removeAt(r100);
    }

    public /* bridge */ boolean remove(IChatterEntity r100) {
        return super.remove(r100);
    }
}
