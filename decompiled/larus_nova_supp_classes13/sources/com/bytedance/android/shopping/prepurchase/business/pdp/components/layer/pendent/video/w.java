package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w extends FrameLayout {
    public final ImageView a;

    public w(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        ImageView r0 = new ImageView(r2);
        this.a = r0;
        Unit r3 = Unit.INSTANCE;
        addView(r0);
    }

    public final void setImageResource(int r2) {
        this.a.setImageResource(r2);
    }
}
