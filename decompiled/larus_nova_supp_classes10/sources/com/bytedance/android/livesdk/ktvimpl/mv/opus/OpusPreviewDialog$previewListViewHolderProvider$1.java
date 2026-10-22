package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.view.viewholder.OpusPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import com.bytedance.android.livesdk.message.model.od;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class OpusPreviewDialog$previewListViewHolderProvider$1 implements j<od> {
    public final /* synthetic */ OpusPreviewDialog a;

    public OpusPreviewDialog$previewListViewHolderProvider$1(OpusPreviewDialog r1) {
        this.a = r1;
    }

    public final IMvPreviewViewHolder<od> a(final FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        OpusPreviewViewHolder r0 = new OpusPreviewViewHolder(r3, new OpusPreviewDialog$previewListViewHolderProvider$1$provideMvPreviewViewHolder$1(this, r3));
        this.a.s.add(r0);
        return r0;
    }
}
