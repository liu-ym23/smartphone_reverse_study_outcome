package com.bytedance.locallife.pdp.headimage.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.lighten.loader.SmartImageView;
import com.larus.nova.R;
import df6.u;
import gx6.a;
import jx6.i;
import jx6.p;
import jx6.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/view/viewholder/PicItemViewHolder;", "Lcom/bytedance/locallife/pdp/headimage/view/viewholder/BaseItemViewHolder;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PicItemViewHolder extends BaseItemViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SmartImageView f261521a;

    public PicItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f261521a = (SmartImageView) r100.findViewById(R.id.image_view);
    }

    @Override // com.bytedance.locallife.pdp.headimage.view.viewholder.BaseItemViewHolder
    public final void T3(p r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "itemInfo");
        Intrinsics.checkNotNullParameter(r101, "contextData");
        int r102 = a.a(r100, r101);
        SmartImageView r103 = this.f261521a;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        r104.height = r102;
        r103.setLayoutParams(r104);
        q r105 = r100.b().a();
        if (r105 == null) goto L5;
        String r106 = r105.b();
    L6:
        u r107 = df6.q.d(r106);
        r107.f468295u = this.f261521a;
        r107.c();
        return;
    L5:
        r106 = null;
        goto L6
    }
}
