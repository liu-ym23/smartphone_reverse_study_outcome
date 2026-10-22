package com.ss.android.lark.message;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.gradient.UDGradientDrawableKt;
import com.larksuite.component.universe_design.gradient.UDLinearGradientDrawable;
import com.larksuite.component.universe_design.gradient.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/message/SummarizeGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pressedGradient", "Lcom/larksuite/component/universe_design/gradient/UDGradientDrawable;", "boundsRect", "Landroid/graphics/Rect;", "isTouching", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SummarizeGradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDLinearGradientDrawable f431890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f431891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f431892c;

    public SummarizeGradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SummarizeGradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f431891b.set(0, 0, getWidth(), getHeight());
        if (this.f431892c == false) goto L5;
        UDLinearGradientDrawable r100 = this.f431890a;
        Rect r101 = this.f431891b;
        r100.setBounds(r101);
        int r102 = r110.saveLayer(r101.left, r101.top, r101.right, r101.bottom, null);
        super.onDraw(r110);
        r100.b((PorterDuffXfermode) UDGradientDrawableKt.f285024a.getValue());
        r100.draw(r110);
        r110.restoreToCount(r102);
        r100.b(null);
        return;
    L5:
        super.onDraw(r110);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L6:
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L15:
        if (r101 != null) goto L18;
    L21:
        return super.onTouchEvent(r100);
    L18:
        if (r101.intValue() != 3) goto L21;
    L19:
        this.f431892c = false;
        invalidate();
        goto L21
    L14:
        if (r101.intValue() == 1) goto L19;
    L9:
        if (r101.intValue() != 0) goto L11;
        this.f431892c = true;
        invalidate();
        goto L21
    L4:
        r101 = null;
        goto L6
    }

    public SummarizeGradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = b.f285036a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDLinearGradientDrawable.Orientation r104 = UDLinearGradientDrawable.Orientation.TO_BOTTOM_RIGHT;
        UDLinearGradientDrawable r105 = new UDLinearGradientDrawable(UDColorUtils.getColor(r100, R.color.ai_primary_content_pressed_0), UDColorUtils.getColor(r100, R.color.ai_primary_content_pressed_1), r104);
        r105.mutate();
        this.f431890a = r105;
        this.f431891b = new Rect();
        setTextColor(UDColorUtils.getColor(r100, R.color.text_caption));
    }

    public /* synthetic */ SummarizeGradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
