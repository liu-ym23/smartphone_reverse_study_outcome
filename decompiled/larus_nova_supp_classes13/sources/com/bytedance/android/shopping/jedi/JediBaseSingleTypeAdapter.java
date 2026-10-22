package com.bytedance.android.shopping.jedi;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.arch.ext.list.differ.JediAsyncListDiffer;
import com.bytedance.jedi.arch.ext.list.differ.JediDifferConfig;
import com.bytedance.jedi.arch.ext.list.differ.JediDifferConfigKt;
import com.bytedance.jedi.ext.adapter.JediListUpdateCallback;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import com.bytedance.jedi.ext.adapter.multitype.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/jedi/JediBaseSingleTypeAdapter;", "T", "Lcom/bytedance/android/shopping/jedi/JediBaseRawAdapter;", "Lcom/bytedance/jedi/ext/adapter/JediViewHolder;", "Lcom/bytedance/jedi/arch/IReceiver;", "Lcom/bytedance/jedi/arch/ext/list/DiffableAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class JediBaseSingleTypeAdapter<T> extends JediBaseRawAdapter<JediViewHolder<? extends IReceiver, T>> implements DiffableAdapter<T> {
    public final JediAsyncListDiffer<T> v;

    public JediBaseSingleTypeAdapter() {
        throw null;
    }

    public abstract AbsDeepFeedProductVH C2(ViewGroup r1);

    public final int getBasicItemCount() {
        return getMDiffer().getItemCount() + 0;
    }

    public final List<T> getCurrentList() {
        return DiffableAdapter.DefaultImpls.getCurrentList(this);
    }

    @Override // com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public final int getItemCount() {
        return super.getItemCount();
    }

    public final JediAsyncListDiffer<T> getMDiffer() {
        return this.v;
    }

    public JediBaseSingleTypeAdapter(LifecycleOwner r5) {
        EqualsItemCallback r0 = new EqualsItemCallback();
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r0, "diffCallback");
        JediDifferConfig r1 = JediDifferConfigKt.asDifferConfig$default(r0, null, 1, null);
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r1, "config");
        super(r5);
        this.v = new JediAsyncListDiffer(new JediListUpdateCallback(this, new JediBaseSingleTypeAdapter$mDiffer$1(this)), r1, null);
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void B2(c<JediViewHolder<? extends IReceiver, T>> r3) {
        Intrinsics.checkNotNullParameter(r3, "registry");
        ViewHolderFactoryManager r4 = (ViewHolderFactoryManager) r3;
        r4.g(null, new JediBaseSingleTypeAdapter$registerFactories$1(this));
    }

    public final void submitList(List<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        DiffableAdapter.DefaultImpls.submitList(this, r2);
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final T A2(int r2, boolean r3) {
        return (T) getMDiffer().getItem(r2 + 0, true);
    }

    public final T getItem(int r1, boolean r2) {
        return (T) DiffableAdapter.DefaultImpls.getItem(this, r1, r2);
    }

    public final void submitList(List<? extends T> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        DiffableAdapter.DefaultImpls.submitList(this, r2, r3);
    }
}
