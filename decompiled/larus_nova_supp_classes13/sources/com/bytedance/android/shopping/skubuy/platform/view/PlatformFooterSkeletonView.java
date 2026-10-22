package com.bytedance.android.shopping.skubuy.platform.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformFooterSkeletonView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformFooterSkeletonView extends View {
    public final int a;
    public final Paint b;
    public final float c;
    public final float d;

    public PlatformFooterSkeletonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PlatformFooterSkeletonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        r10.drawColor(this.a);
        float r0 = getWidth() / this.c;
        r10.save();
        r10.scale(r0, r0);
        float r7 = this.d;
        r10.drawRoundRect(16.0f, 8.0f, 359.0f, 52.0f, r7, r7, this.b);
        r10.restore();
    }

    public PlatformFooterSkeletonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ColorProtector.parseColor("#FFFFFF");
        Paint r5 = new Paint(1);
        r5.setColor(ColorProtector.parseColor("#F8F8F8"));
        r5.setStyle(Paint.Style.FILL);
        Unit r6 = Unit.INSTANCE;
        this.b = r5;
        this.c = 375.0f;
        this.d = 44.0f;
    }

    public /* synthetic */ PlatformFooterSkeletonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
