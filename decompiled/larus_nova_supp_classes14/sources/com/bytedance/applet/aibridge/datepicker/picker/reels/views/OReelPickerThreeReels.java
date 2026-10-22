package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kv3.b;
import kv3.c;
import kv3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002,-B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0018\u001a\u00020\u0019*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0014J0\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wv1", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "getWv1", "()Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "wv1$delegate", "Lkotlin/Lazy;", "wv2", "getWv2", "wv2$delegate", "wv3", "getWv3", "wv3$delegate", "reelsCount", "configure", "", "reel", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker$Reel;", "colIndex", "maxColIndex", "asView", "Landroid/view/View;", "getReelView", "col", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", ScrollPosition.POSITION_LEFT, ScrollPosition.POSITION_TOP, ScrollPosition.POSITION_RIGHT, ScrollPosition.POSITION_BOTTOM, "Builder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OReelPickerThreeReels extends ConstraintLayout {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public OReelPickerThreeReels(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OReelPickerThreeReels(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final WheelView getWv1() {
        return (WheelView) this.a.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.b.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.c.getValue();
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OReelPickerThreeReels(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new b(this));
        this.b = LazyKt.lazy(new c(this));
        this.c = LazyKt.lazy(new d(this));
        LayoutInflater.from(r2).inflate(2131561811, this);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
