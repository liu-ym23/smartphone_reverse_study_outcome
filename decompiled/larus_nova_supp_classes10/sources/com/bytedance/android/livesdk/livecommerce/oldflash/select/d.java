package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends RecyclerView.ViewHolder {
    public final TextView a;
    public final ImageView b;

    public d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = (TextView) r2.findViewById(2131390185);
        this.b = (ImageView) r2.findViewById(2131376593);
    }
}
