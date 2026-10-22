package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.view.View;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.message.model.od;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ OpusPreviewDialog a;

    public b(OpusPreviewDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        OpusPreviewDialog r4 = this.a;
        if (r4.z == false) goto L5;
        return;
    L5:
        IMvPreviewViewHolder<od> r0 = r4.o;
        if (r0 == null) goto L9;
        r4.Z90(r0, false);
        return;
    }
}
