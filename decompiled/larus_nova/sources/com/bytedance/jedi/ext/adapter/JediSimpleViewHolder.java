package com.bytedance.jedi.ext.adapter;

import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.jedi.arch.ViewModelFactoryOwner;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "ITEM", "Lcom/bytedance/jedi/ext/adapter/JediViewHolder;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class JediSimpleViewHolder<ITEM> extends JediViewHolder<JediSimpleViewHolder<ITEM>, ITEM> implements ViewModelFactoryOwner<ViewModelProvider.Factory> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Factory f250956k;

    public abstract void a4(ITEM r100);

    @Override // com.bytedance.jedi.arch.ViewModelFactoryOwner
    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.f250956k;
    }

    public JediSimpleViewHolder(View r100) {
        super(r100);
        this.f250956k = d.f250965a;
    }

    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder
    public final void Y3(List<Object> r100) {
        b4(getItem(), this.f251038c, r100);
    }

    public void b4(ITEM r100, int r101, List<Object> r102) {
        a4(r100);
    }
}
