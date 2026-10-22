package com.bytedance.jedi.ext.adapter;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ext.list.differ.JediAsyncListDiffer;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u000126\u0012\u0004\u0012\u00028\u0000\u0012\u0012\u0012\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00030\u00050\u0002B-\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB)\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\f\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/JediMultiTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/DiffableRawAdapter;", "Lcom/bytedance/jedi/ext/adapter/JediViewHolder;", "Lcom/bytedance/jedi/arch/IReceiver;", "Lcom/bytedance/jedi/ext/adapter/f;", "Landroidx/lifecycle/LifecycleOwner;", "parent", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "fetcher", "<init>", "(Landroid/arch/lifecycle/LifecycleOwner;Landroid/support/v7/util/DiffUtil$ItemCallback;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;)V", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;", "prefetcher", "Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;", "config", "(Landroid/arch/lifecycle/LifecycleOwner;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;)V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class JediMultiTypeAdapter<T> extends DiffableRawAdapter<T, JediViewHolder<? extends IReceiver, T>, f<JediViewHolder<? extends IReceiver, T>>> {
    @Override // com.bytedance.jedi.ext.adapter.DiffableRawAdapter, com.bytedance.jedi.arch.ext.list.DiffableAdapter
    public final JediAsyncListDiffer<T> getMDiffer() {
        return null;
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.b
    public final /* bridge */ /* synthetic */ ViewHolderFactoryManager n() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        JediViewHolder r101 = (JediViewHolder) r100;
        throw null;
    }
}
