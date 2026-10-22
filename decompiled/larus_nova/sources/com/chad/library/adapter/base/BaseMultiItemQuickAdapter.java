package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;

    public BaseMultiItemQuickAdapter(List<T> r100) {
        super(r100);
    }

    private int getLayoutId(int r100) {
        return this.layouts.get(r100, -404);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int r100) {
        MultiItemEntity r101 = (MultiItemEntity) ListProtector.get(this.mData, r100);
        if (r101 != null) goto L5;
        return -255;
    L5:
        return r101.getItemType();
    }

    public int getParentPositionInAll(int r100) {
        List<T> r101 = getData();
        T r102 = getItem(r100);
        if (isExpandable(r102) == false) goto L12;
        IExpandable r103 = (IExpandable) r102;
        int r104 = r100 - 1;
    L5:
        if (r104 < 0) goto L18;
        MultiItemEntity r105 = (MultiItemEntity) ListProtector.get(r101, r104);
        if (isExpandable(r105) == false) goto L11;
        if (r103.getLevel() <= ((IExpandable) r105).getLevel()) goto L11;
        return r104;
    L11:
        r104 = r104 - 1;
        goto L5
    L18:
        return -1;
    L12:
        int r106 = r100 - 1;
    L13:
        if (r106 < 0) goto L26;
        if (isExpandable((MultiItemEntity) ListProtector.get(r101, r106)) == true) goto L16;
        r106 = r106 - 1;
        goto L13
    L16:
        return r106;
    L26:
        return -1;
    }

    public boolean isExpandable(MultiItemEntity r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r100 instanceof IExpandable) == false) goto L6;
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void remove(int r100) {
        List<T> r101 = this.mData;
        if (r101 == null) goto L13;
        if (r100 >= 0) goto L6;
        return;
    L6:
        if (r100 >= r101.size()) goto L15;
        MultiItemEntity r102 = (MultiItemEntity) ListProtector.get(this.mData, r100);
        if ((r102 instanceof IExpandable) == false) goto L11;
        removeAllChild((IExpandable) r102, r100);
    L11:
        removeDataFromParent(r102);
        super.remove(r100);
        return;
    L15:
        return;
    }

    public void removeDataFromParent(T r100) {
        int r101 = getParentPosition(r100);
        if (r101 < 0) goto L8;
        IExpandable r102 = (IExpandable) ListProtector.get(this.mData, r101);
        if (r102 == r100) goto L9;
        r102.getSubItems().remove(r100);
        return;
    L9:
        return;
    }

    public void setDefaultViewTypeLayout(int r100) {
        addItemType(-255, r100);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ boolean isExpandable(Object r100) {
        return isExpandable((MultiItemEntity) r100);
    }

    public void addItemType(int r100, int r101) {
        if (this.layouts != null) goto L5;
        this.layouts = new SparseIntArray();
    L5:
        this.layouts.put(r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup r100, int r101) {
        return createBaseViewHolder(r100, getLayoutId(r101));
    }

    public void removeAllChild(IExpandable r100, int r101) {
        if (r100.isExpanded() == false) goto L12;
        List r102 = r100.getSubItems();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.size() == 0) goto L15;
        int r103 = r102.size();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L16;
        remove(r101 + 1);
        r104 = r104 + 1;
        goto L10
    L16:
        return;
    L15:
        return;
    }
}
