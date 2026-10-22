package com.bytedance.android.shopping.mall.homepage.card.video;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.ui.IHybridVideoBoxView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import com.bytedance.android.shopping.mall.homepage.card.live.o;
import com.bytedance.android.shopping.mall.homepage.tools.c0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class NativeVideoBigCard$cardClickListener$1 implements View.OnClickListener {
    public final /* synthetic */ NativeVideoBigCard a;
    public final /* synthetic */ View b;

    public NativeVideoBigCard$cardClickListener$1(NativeVideoBigCard r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Map<String, Object> r7 = c0.a;
        ECHybridListItemVO r8 = ((BaseViewHolder) this.a).c;
        if (r8 == null) goto L8;
        ECNAMallCardExtra r9 = r8.c();
        if (r9 == null) goto L8;
        Map r10 = r9.getSchemaMap();
        if (r10 == null) goto L8;
    L9:
        String r11 = c0.a(r10, false, ToolsKt.g(this.a), new NativeVideoBigCard$cardClickListener$1$schema$1(this));
        IHybridVideoBoxView r0 = this.a.t;
        if (r0 == null) goto L12;
        MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r11)});
        int r12 = IHybridVideoBoxView.a;
        r0.b();
    L13:
        NativeVideoBigCard r13 = this.a;
        o.a(r13, null, r13.v, 5);
        return;
    L12:
        k.b.d(this.b.getContext(), r11, null);
    L8:
        r10 = MapsKt.emptyMap();
        goto L9
    }
}
