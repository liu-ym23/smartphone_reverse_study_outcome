package com.bytedance.jedi.ext.adapter.multitype;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.jedi.ext.adapter.decorator.internal.e;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeRawAdapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "VH", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManager;", "M", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/b;", "<init>", "()V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class MultiTypeRawAdapter<VH extends MultiTypeViewHolder<?>, M extends ViewHolderFactoryManager<VH>> extends RecyclerView.Adapter<VH> implements b<VH, M> {
    public abstract Object y2(int r100, boolean r101);

    public abstract void z2(c<VH> r100);

    public MultiTypeRawAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return n().b(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        n().e(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        com.bytedance.jedi.ext.adapter.internal.a r101 = n().f251043d;
        e r102 = r101.f251028b;
        r102.f250986a = null;
        r100.removeOnAttachStateChangeListener(r102);
        r101.f251029c = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        MultiTypeViewHolder r102 = (MultiTypeViewHolder) r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return n().a(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        MultiTypeViewHolder r103 = (MultiTypeViewHolder) r100;
        M r104 = n();
        Object r105 = y2(r101, true);
        r104.getClass();
        if (r105 == null) goto L7;
        r103.U3(r105, r101, r102);
        return;
    }
}
