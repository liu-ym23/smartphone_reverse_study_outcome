package com.bytedance.android.shopping.jedi;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.jedi.ext.adapter.decorator.internal.e;
import com.bytedance.jedi.ext.adapter.f;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import com.bytedance.jedi.ext.adapter.multitype.b;
import com.bytedance.jedi.ext.adapter.multitype.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\u0010\b\u0001\u0010\u0004 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/jedi/MultiTypeAdapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "VH", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManager;", "M", "Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/b;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MultiTypeAdapter<VH extends MultiTypeViewHolder<?>, M extends ViewHolderFactoryManager<VH>> extends LoadMoreRecyclerViewAdapter implements b<VH, M> {

    public static final class a {
    }

    static {
    }

    public abstract Object A2(int r1, boolean r2);

    public abstract void B2(c<VH> r1);

    public int getBasicItemViewType(int r1) {
        if (r1 >= 0) goto L4;
        return Integer.MAX_VALUE;
    L4:
        return 0;
    }

    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
    }

    public MultiTypeAdapter() {
    }

    @Override // com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        ((JediBaseRawAdapter) this).u.e(r2);
    }

    public void onDetachedFromRecyclerView(RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r4);
        com.bytedance.jedi.ext.adapter.internal.a r0 = ((ViewHolderFactoryManager) ((JediBaseRawAdapter) this).u).d;
        e r1 = r0.b;
        r1.a = null;
        r4.removeOnAttachStateChangeListener(r1);
        r0.c = null;
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != Integer.MAX_VALUE) goto L5;
        Intrinsics.checkNotNull(null);
        new JediHeaderViewHolder();
        throw null;
    L5:
        return ((JediBaseRawAdapter) this).u.a(r2, r3);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if (getItemViewType(r4) != Integer.MIN_VALUE) goto L6;
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onBindViewHolder(r3, r4, r5);
        return;
    L6:
        if (getItemViewType(r4) == Integer.MAX_VALUE) goto L13;
        f<VH> r0 = ((JediBaseRawAdapter) this).u;
        MultiTypeViewHolder r6 = (MultiTypeViewHolder) r3;
        Object r1 = A2(r4, true);
        int r7 = r4 + 0;
        r0.getClass();
        if (r1 == null) goto L14;
        r6.U3(r1, r7, r5);
        return;
    L14:
        return;
    }
}
