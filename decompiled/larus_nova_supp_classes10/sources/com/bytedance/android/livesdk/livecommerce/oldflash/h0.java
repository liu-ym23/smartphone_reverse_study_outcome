package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h0 extends BaseViewHolder {
    public final ECNetImageView c;

    public h0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = r2.findViewById(2131376249);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        if ((r3 instanceof e) == true) goto L5;
        r3 = null;
    L5:
        e r5 = (e) r3;
        if (r5 == null) goto L17;
        String r6 = r5.b;
        if (r6 != null) goto L10;
        return;
    L10:
        if (((RecyclerView.ViewHolder) this).itemView.getTag() != null) goto L15;
        ImagePipeline r7 = Fresco.getImagePipeline();
        if (r7 == null) goto L14;
        r7.clearCaches();
    L14:
        ((RecyclerView.ViewHolder) this).itemView.setTag(r6);
    L15:
        ECLiveImageUtils.i(this.c, r6, 2, 0);
        return;
    }
}
