package com.bytedance.android.shopping.anchorv4.voavhs;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.shopping.prepurchase.arch.exposure.ExposureEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.ecom.arch.slice.adapter.c {
    public final /* synthetic */ AnchorV4Adapter a;

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public a(AnchorV4Adapter r1) {
        this.a = r1;
    }

    public final void a(RecyclerView.ViewHolder r2, com.bytedance.android.ecom.arch.slice.adapter.b r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if ((r3 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L5;
        return;
    L5:
        if ((r2 instanceof SlcBaseViewHolder) == false) goto L19;
        AnchorV4Adapter r5 = this.a;
        SlcBaseViewHolder r6 = (SlcBaseViewHolder) r2;
        int r0 = AnchorV4Adapter.Z;
        r5.getClass();
        String r7 = ((com.bytedance.android.ecom.arch.slice.g) r3).getSliceId();
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        if (r7.length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L20;
        ExposureEngine r8 = r5.Y.getExposureEngine();
        if (r8 == null) goto L21;
        ExposureEngine.a(r8, ((RecyclerView.ViewHolder) r6).itemView, r7);
        return;
    L21:
        return;
    L20:
        return;
    L12:
        r1 = false;
        goto L13
    }
}
