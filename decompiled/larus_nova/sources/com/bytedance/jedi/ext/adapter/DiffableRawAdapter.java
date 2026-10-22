package com.bytedance.jedi.ext.adapter;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.arch.ext.list.differ.JediAsyncListDiffer;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeRawAdapter;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u000e\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\b\u0012\u0004\u0012\u00028\u00000\u0007B%\b\u0016\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/DiffableRawAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "VH", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManager;", "M", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeRawAdapter;", "Lcom/bytedance/jedi/arch/ext/list/DiffableAdapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "fetcher", "<init>", "(Landroid/support/v7/util/DiffUtil$ItemCallback;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;)V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class DiffableRawAdapter<T, VH extends MultiTypeViewHolder<T>, M extends ViewHolderFactoryManager<VH>> extends MultiTypeRawAdapter<VH, M> implements DiffableAdapter<T> {
    @Override // com.bytedance.jedi.arch.ext.list.DiffableAdapter
    public JediAsyncListDiffer<T> getMDiffer() {
        return null;
    }

    @Override // com.bytedance.jedi.arch.ext.list.DiffableAdapter
    public final List<T> getCurrentList() {
        return DiffableAdapter.DefaultImpls.getCurrentList(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return DiffableAdapter.DefaultImpls.getItemCount(this);
    }

    @Override // com.bytedance.jedi.arch.ext.list.DiffableAdapter
    public final void submitList(List<? extends T> r100) {
        DiffableAdapter.DefaultImpls.submitList(this, r100);
    }

    @Override // com.bytedance.jedi.arch.ext.list.DiffableAdapter
    public final T getItem(int r100, boolean r101) {
        return (T) DiffableAdapter.DefaultImpls.getItem(this, r100, r101);
    }

    @Override // com.bytedance.jedi.arch.ext.list.DiffableAdapter
    public final void submitList(List<? extends T> r100, Function0<Unit> r101) {
        DiffableAdapter.DefaultImpls.submitList(this, r100, r101);
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.MultiTypeRawAdapter
    public final T y2(int r100, boolean r101) {
        return getItem(r100, r101);
    }
}
