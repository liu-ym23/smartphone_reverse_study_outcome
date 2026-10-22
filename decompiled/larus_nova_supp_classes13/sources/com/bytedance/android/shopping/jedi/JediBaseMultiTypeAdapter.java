package com.bytedance.android.shopping.jedi;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.arch.ext.list.differ.JediAsyncListDiffer;
import com.bytedance.jedi.arch.ext.list.differ.JediDifferConfig;
import com.bytedance.jedi.arch.ext.list.differ.JediDifferConfigKt;
import com.bytedance.jedi.ext.adapter.JediListUpdateCallback;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0002\b\u00030\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/jedi/JediBaseMultiTypeAdapter;", "T", "Lcom/bytedance/android/shopping/jedi/JediBaseRawAdapter;", "Lcom/bytedance/jedi/ext/adapter/JediViewHolder;", "Lcom/bytedance/jedi/arch/IReceiver;", "Lcom/bytedance/jedi/arch/ext/list/DiffableAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class JediBaseMultiTypeAdapter<T> extends JediBaseRawAdapter<JediViewHolder<? extends IReceiver, ?>> implements DiffableAdapter<T> {
    public final JediAsyncListDiffer<T> v;

    public JediBaseMultiTypeAdapter() {
        throw null;
    }

    public int getBasicItemCount() {
        return getMDiffer().getItemCount() + 0;
    }

    public List<T> getCurrentList() {
        return DiffableAdapter.DefaultImpls.getCurrentList(this);
    }

    @Override // com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public int getItemCount() {
        return super.getItemCount();
    }

    public final JediAsyncListDiffer<T> getMDiffer() {
        return this.v;
    }

    public void submitList(List<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        DiffableAdapter.DefaultImpls.submitList(this, r2);
    }

    public JediBaseMultiTypeAdapter(LifecycleOwner r4, DiffUtil.ItemCallback r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "diffCallback");
        JediDifferConfig r6 = JediDifferConfigKt.asDifferConfig$default(r5, null, 1, null);
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r6, "config");
        super(r4);
        this.v = new JediAsyncListDiffer(new JediListUpdateCallback(this, new JediBaseMultiTypeAdapter$mDiffer$1(this)), r6, null);
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public T A2(int r2, boolean r3) {
        return (T) getMDiffer().getItem(r2 + 0, true);
    }

    public T getItem(int r1, boolean r2) {
        return (T) DiffableAdapter.DefaultImpls.getItem(this, r1, r2);
    }

    public void submitList(List<? extends T> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        DiffableAdapter.DefaultImpls.submitList(this, r2, r3);
    }
}
