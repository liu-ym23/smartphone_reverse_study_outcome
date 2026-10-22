package com.chad.library.adapter.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    protected static final int SECTION_HEADER_VIEW = 1092;
    protected int mSectionHeadResId;

    public abstract void convertHead(K r100, T r101);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int r100) {
        if (((SectionEntity) ListProtector.get(this.mData, r100)).isHeader == false) goto L5;
        return 1092;
    L5:
        return 0;
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
        return (K) super.onCreateDefViewHolder(r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        onBindViewHolder((BaseViewHolder) r100, r101);
    }

    public BaseSectionQuickAdapter(int r100, int r101, List<T> r102) {
        super(r100, r102);
        this.mSectionHeadResId = r101;
    }
}
