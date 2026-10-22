package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/ECMallRecyclerView;", "Lcom/bytedance/android/ec/hybrid/list/view/ECHybridRecyclerView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallRecyclerView extends ECHybridRecyclerView {
    public final ArrayList<View> U;
    public final ArrayList<BaseViewHolder> V;

    public final List<BaseViewHolder> J() {
        return this.V;
    }

    public ECMallRecyclerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.U = new ArrayList();
        this.V = new ArrayList();
    }

    public final void onChildAttachedToWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "child");
        this.U.add(r3);
        RecyclerView.ViewHolder r0 = getChildViewHolder(r3);
        if ((r0 instanceof BaseViewHolder) == true) goto L5;
        r0 = null;
    L5:
        BaseViewHolder r1 = (BaseViewHolder) r0;
        if (r1 == null) goto L8;
        this.V.add(r1);
    L8:
        super/*androidx.recyclerview.widget.RecyclerView*/.onChildAttachedToWindow(r3);
    }

    public final void onChildDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "child");
        this.U.remove(r3);
        RecyclerView.ViewHolder r0 = getChildViewHolder(r3);
        if ((r0 instanceof BaseViewHolder) == true) goto L5;
        r0 = null;
    L5:
        BaseViewHolder r1 = (BaseViewHolder) r0;
        if (r1 == null) goto L8;
        this.V.remove(r1);
    L8:
        super/*androidx.recyclerview.widget.RecyclerView*/.onChildDetachedFromWindow(r3);
    }

    public final void Q(int r6, int r7) {
        int r0 = ((Number) L(getLayoutManager()).component2()).intValue();
        Iterator<BaseViewHolder> r1 = this.V.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        BaseViewHolder r2 = r1.next();
        if (r2.C3() == false) goto L4;
        r2.g1(r6, r7, r2.V3());
        goto L4
    L9:
        if (f0(r0) == true) goto L11;
        return;
    L11:
        if (M(r0) == null) goto L24;
        com.bytedance.android.ec.hybrid.list.ability.a r8 = getAbilityManager();
        if (r8 == null) goto L25;
        com.bytedance.android.ec.hybrid.list.ability.k0 r9 = (com.bytedance.android.ec.hybrid.list.ability.k0) r8.getAbility(com.bytedance.android.ec.hybrid.list.ability.k0.class);
        if (r9 == null) goto L26;
        r9.a();
        return;
    L26:
        return;
    L25:
        return;
    }
}
