package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseSectionMultiItemQuickAdapter<T extends SectionMultiEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    protected static final int SECTION_HEADER_VIEW = 1092;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;
    protected int mSectionHeadResId;

    public abstract void convertHead(K r100, T r101);

    private int getLayoutId(int r100) {
        return this.layouts.get(r100, -404);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int r100) {
        SectionMultiEntity r101 = (SectionMultiEntity) ListProtector.get(this.mData, r100);
        if (r101 != null) goto L5;
        return -255;
    L5:
        if (r101.isHeader == false) goto L8;
        return 1092;
    L8:
        return r101.getItemType();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int r100) {
        if (super.isFixedViewType(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 1092) goto L8;
        return false;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void remove(int r100) {
        List<T> r101 = this.mData;
        if (r101 == null) goto L13;
        if (r100 >= 0) goto L6;
        return;
    L6:
        if (r100 >= r101.size()) goto L15;
        MultiItemEntity r102 = (SectionMultiEntity) ListProtector.get(this.mData, r100);
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
        if (r101 < 0) goto L6;
        ((IExpandable) ListProtector.get(this.mData, r101)).getSubItems().remove(r100);
        return;
    }

    public void setDefaultViewTypeLayout(int r100) {
        addItemType(-255, r100);
    }

    public BaseSectionMultiItemQuickAdapter(int r100, List<T> r101) {
        super(r101);
        this.mSectionHeadResId = r100;
    }

    public void addItemType(int r100, int r101) {
        if (this.layouts != null) goto L5;
        this.layouts = new SparseIntArray();
    L5:
        this.layouts.put(r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(K r100, int r101) {
        if (r100.getItemViewType() == 1092) goto L5;
        super.onBindViewHolder(r100, r101);
        return;
    L5:
        setFullSpan(r100);
        convertHead(r100, getItem(r101 - getHeaderLayoutCount()));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup r100, int r101) {
        if (r101 != 1092) goto L7;
        return createBaseViewHolder(getItemView(this.mSectionHeadResId, r100));
    L7:
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        onBindViewHolder((BaseViewHolder) r100, r101);
    }
}
