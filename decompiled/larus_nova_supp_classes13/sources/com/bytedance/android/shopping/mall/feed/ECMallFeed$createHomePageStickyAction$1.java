package com.bytedance.android.shopping.mall.feed;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$createHomePageStickyAction$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$createHomePageStickyAction$1(ECMallFeed r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m994invoke() {
        ECHybridListEngine r0 = this.this$0.J;
        if (r0 == null) goto L9;
        BaseViewHolder r1 = r0.g("favorite_section", 0);
        if (r1 == null) goto L9;
        View r2 = ((RecyclerView.ViewHolder) r1).itemView;
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.getTop());
    L10:
        Integer r4 = this.this$0.D1;
        if (r4 != null) goto L14;
        return false;
    L14:
        if (r4.intValue() == 0) goto L16;
        return false;
    L16:
        if (this.this$0.S0 == false) goto L23;
        if (r3 != null) goto L19;
        return false;
    L19:
        if (r3.intValue() <= 0) goto L25;
        return true;
    L25:
        return false;
    L23:
        return false;
    L9:
        r3 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m994invoke());
    }
}
