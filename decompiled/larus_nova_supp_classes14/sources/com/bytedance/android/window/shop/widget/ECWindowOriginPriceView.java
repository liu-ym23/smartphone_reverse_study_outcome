package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECWindowOriginPriceView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/graphics/Paint;", "a", "Lkotlin/Lazy;", "getLineDrawerPaint", "()Landroid/graphics/Paint;", "lineDrawerPaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowOriginPriceView extends AppCompatTextView {
    public final Lazy a;

    private final Paint getLineDrawerPaint() {
        return (Paint) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super/*android.widget.TextView*/.onDraw(r8);
        r8.drawLine(0.0f, getHeight() / 2.0f, getWidth(), getHeight() / 2.0f, getLineDrawerPaint());
    }

    public ECWindowOriginPriceView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = LazyKt.lazy(new ECWindowOriginPriceView$lineDrawerPaint$2(this));
    }
}
