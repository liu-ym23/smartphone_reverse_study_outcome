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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformBodySkeletonView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformBodySkeletonView extends View {
    public final int a;
    public final Paint b;
    public final Paint c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public PlatformBodySkeletonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PlatformBodySkeletonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        r9.drawColor(this.a);
        float r0 = getWidth() / this.d;
        r9.save();
        r9.scale(r0, r0);
        float r6 = this.e;
        r9.drawRoundRect(0.0f, 0.0f, 375.0f, 154.0f, r6, r6, this.c);
        float r7 = this.f;
        r9.drawRoundRect(16.0f, 16.0f, 358.0f, 40.0f, r7, r7, this.b);
        float r8 = this.f;
        r9.drawRoundRect(16.0f, 64.0f, 90.0f, 138.0f, r8, r8, this.b);
        float r10 = this.i;
        r9.drawRoundRect(102.0f, 64.0f, 238.0f, 88.0f, r10, r10, this.b);
        float r11 = this.i;
        r9.drawRoundRect(102.0f, 100.0f, 238.0f, 124.0f, r11, r11, this.b);
        float r12 = this.h;
        r9.drawRoundRect(0.0f, 162.0f, 375.0f, 654.0f, r12, r12, this.c);
        float r13 = this.g;
        r9.drawRoundRect(16.0f, 178.0f, 90.0f, 198.0f, r13, r13, this.b);
        float r14 = this.i;
        r9.drawRoundRect(16.0f, 210.0f, 122.0f, 359.0f, r14, r14, this.b);
        float r15 = this.i;
        r9.drawRoundRect(134.0f, 210.0f, 240.0f, 359.0f, r15, r15, this.b);
        float r16 = this.i;
        r9.drawRoundRect(252.0f, 210.0f, 358.0f, 359.0f, r16, r16, this.b);
        float r17 = this.g;
        r9.drawRoundRect(16.0f, 383.0f, 90.0f, 403.0f, r17, r17, this.b);
        float r18 = this.g;
        r9.drawRoundRect(16.0f, 407.0f, 240.0f, 441.0f, r18, r18, this.b);
        r9.restore();
    }

    public PlatformBodySkeletonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ColorProtector.parseColor("#F5F6F9");
        Paint r5 = new Paint(1);
        r5.setColor(ColorProtector.parseColor("#F8F8F8"));
        r5.setStyle(Paint.Style.FILL);
        Unit r6 = Unit.INSTANCE;
        this.b = r5;
        Paint r7 = new Paint(1);
        r7.setColor(ColorProtector.parseColor("#FFFFFF"));
        r7.setStyle(Paint.Style.FILL);
        this.c = r7;
        this.d = 375.0f;
        this.e = 16.0f;
        this.f = 8.0f;
        this.g = 4.0f;
        this.h = 12.0f;
        this.i = 6.0f;
    }

    public /* synthetic */ PlatformBodySkeletonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
