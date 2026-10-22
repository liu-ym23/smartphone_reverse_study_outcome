package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends FrameLayout {
    public SimpleDraweeView a;

    public final SimpleDraweeView getSkuImgView() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        LayoutInflater.from(r2).inflate(2131560378, this);
        this.a = findViewById(2131386852);
    }

    public final void setSkuImgView(SimpleDraweeView r1) {
        this.a = r1;
    }
}
