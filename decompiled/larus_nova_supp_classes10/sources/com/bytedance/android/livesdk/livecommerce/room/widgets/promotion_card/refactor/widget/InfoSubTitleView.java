package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/widget/InfoSubTitleView;", "Landroid/widget/TextView;", "", "show", "", "setShowDeleteLine", "Landroid/graphics/Paint;", "b", "Lkotlin/Lazy;", "getDeleteLinePaint", "()Landroid/graphics/Paint;", "deleteLinePaint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InfoSubTitleView extends TextView {
    public boolean a;
    public final Lazy b;

    public InfoSubTitleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public InfoSubTitleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Paint getDeleteLinePaint() {
        return (Paint) this.b.getValue();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        if (this.a == false) goto L6;
        getDeleteLinePaint().setColor(getCurrentTextColor());
        r9.drawLine(0.0f, getHeight() * 0.625f, getWidth(), getHeight() * 0.625f, getDeleteLinePaint());
        return;
    }

    public final void setShowDeleteLine(boolean r1) {
        this.a = r1;
        invalidate();
    }

    public InfoSubTitleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(InfoSubTitleView$deleteLinePaint$2.INSTANCE);
    }

    public /* synthetic */ InfoSubTitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
