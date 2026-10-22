package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/DotCountDownView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dotCount", "", "dotRadius", "", "dotSpace", "paint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "updateDotCount", "count", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DotCountDownView extends View {
    private int dotCount;
    private float dotRadius;
    private float dotSpace;
    private final Paint paint;

    @Override // android.view.View
    public void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        int r0 = this.dotCount;
        if (r0 >= 1) goto L5;
        return;
    L5:
        int r1 = r0 - 1;
    L6:
        if (r1 < 0) goto L10;
        if (r6 == null) goto L9;
        r6.drawCircle(this.dotRadius + (r1 * this.dotSpace), r6.getHeight() / 2, this.dotRadius, this.paint);
    L9:
        r1 = r1 - 1;
        goto L6
    }

    public final void updateDotCount(int r1) {
        this.dotCount = r1;
        invalidate();
    }

    public DotCountDownView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.dotCount = 3;
        this.dotSpace = UtilityKotlinExtentionsKt.h(10);
        this.dotRadius = UtilityKotlinExtentionsKt.h(2);
        Paint r3 = new Paint(1);
        r3.setStyle(Paint.Style.FILL);
        r3.setColor(ColorProtector.parseColor("#ffffff"));
        Unit r4 = Unit.INSTANCE;
        this.paint = r3;
    }
}
