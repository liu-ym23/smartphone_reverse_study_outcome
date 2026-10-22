package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.chad.library.adapter.base.util.ProviderDelegate;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class MultipleItemRvAdapter<T, V extends BaseViewHolder> extends BaseQuickAdapter<T, V> {
    private SparseArray<BaseItemProvider> mItemProviders;
    private MultiTypeDelegate<T> mMultiTypeDelegate;
    protected ProviderDelegate mProviderDelegate;

    public abstract int getViewType(T r100);

    public abstract void registerItemProvider();

    public void finishInitialize() {
        this.mProviderDelegate = new ProviderDelegate();
        setMultiTypeDelegate(new AnonymousClass1(this));
        registerItemProvider();
        this.mItemProviders = this.mProviderDelegate.getItemProviders();
        int r100 = 0;
    L4:
        if (r100 >= this.mItemProviders.size()) goto L6;
        int r101 = this.mItemProviders.keyAt(r100);
        BaseItemProvider r102 = this.mItemProviders.get(r101);
        r102.mData = this.mData;
        getMultiTypeDelegate().registerItemType(r101, r102.layout());
        r100 = r100 + 1;
        goto L4
    }

    public MultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    public MultipleItemRvAdapter(List<T> r100) {
        super(r100);
    }

    public static /* synthetic */ SparseArray access$000(MultipleItemRvAdapter r100) {
        return r100.mItemProviders;
    }

    private void bindClick(final V r100) {
        BaseQuickAdapter.OnItemClickListener r101 = getOnItemClickListener();
        BaseQuickAdapter.OnItemLongClickListener r102 = getOnItemLongClickListener();
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        return;
    L6:
        if (r101 != null) goto L8;
        r100.itemView.setOnClickListener(new AnonymousClass2(this, r100));
    L8:
        if (r102 != null) goto L11;
        r100.itemView.setOnLongClickListener(new AnonymousClass3(this, r100));
        return;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(V r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        bindClick(r100);
        super.bindViewClickListener(r100);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int r100) {
        if (getMultiTypeDelegate() == null) goto L7;
        return getMultiTypeDelegate().getDefItemViewType(this.mData, r100);
    L7:
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    public void setMultiTypeDelegate(MultiTypeDelegate<T> r100) {
        this.mMultiTypeDelegate = r100;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(V r100, T r101) {
        int r102 = r100.getItemViewType();
        BaseItemProvider r103 = this.mItemProviders.get(r102);
        r103.mContext = r100.itemView.getContext();
        r103.convert(r100, r101, r100.getLayoutPosition() - getHeaderLayoutCount());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public V onCreateDefViewHolder(ViewGroup r100, int r101) {
        if (getMultiTypeDelegate() == null) goto L7;
        return createBaseViewHolder(r100, getMultiTypeDelegate().getLayoutId(r101));
    L7:
        throw new IllegalStateException("please use setMultiTypeDelegate first!");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convertPayloads(V r100, T r101, List<Object> r102) {
        int r103 = r100.getItemViewType();
        this.mItemProviders.get(r103).convertPayloads(r100, r101, r100.getLayoutPosition() - getHeaderLayoutCount(), r102);
    }
}
