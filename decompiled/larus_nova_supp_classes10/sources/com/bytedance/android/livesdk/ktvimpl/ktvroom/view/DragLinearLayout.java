package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b \u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/DragLinearLayout;", "Landroid/widget/LinearLayout;", "", "percent", "", "setPosPercent", "", "draggable", "setDraggable", "b", "F", "getDifferenceY", "()F", "setDifferenceY", "(F)V", "differenceY", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "getRegionConfirmListener", "()Lkotlin/jvm/functions/Function1;", "setRegionConfirmListener", "(Lkotlin/jvm/functions/Function1;)V", "regionConfirmListener", "", "d", "I", "getBottomEdget", "()I", "setBottomEdget", "(I)V", "bottomEdget", "getTransLationSpace", "transLationSpace", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DragLinearLayout extends LinearLayout {
    public float a;
    public float b;
    public Function1<? super Float, Unit> c;
    public int d;
    public boolean e;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ DragLinearLayout a;

        public a(DragLinearLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r5, MotionEvent r6) {
            DragLinearLayout r0 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r5, "v");
            if (r6 == null) goto L39;
            r0.onTouchEvent(r6);
            int r2 = r6.getAction();
            if (r2 == 0) goto L28;
            if (r2 != 1) goto L9;
        L25:
            Function1<? super Float, Unit> r7 = r0.c;
            if (r7 == null) goto L39;
            r7.invoke(Float.valueOf(r0.getTranslationY() / r0.getTransLationSpace()));
            goto L39
        L9:
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L25;
        L14:
            if (r0.e == false) goto L39;
            r0.b = r6.getRawY() - r0.a;
            r0.a = r6.getRawY();
            float r8 = (r0.getY() + r0.getHeight()) + r0.b;
            int r9 = r0.d;
            if (r8 <= r9) goto L19;
            if (r9 <= 0) goto L19;
            r0.setY(r9 - r0.getHeight());
        L19:
            float r10 = 0;
            if (r0.getTranslationY() <= r10) goto L22;
        L24:
            r0.setTranslationY(r0.getTranslationY() + r0.b);
            goto L39
        L22:
            if (r0.b >= r10) goto L24;
            r0.setTranslationY(0.0f);
            goto L39
        L28:
            r0.getY();
            r5.getParent().requestDisallowInterceptTouchEvent(true);
            ViewParent r11 = r5.getParent();
        L29:
            boolean r3 = r11 instanceof cs1.a;
            if (r3 == true) goto L36;
            if (r11 == null) goto L33;
            ViewParent r4 = r11.getParent();
        L34:
            if (r4 == null) goto L36;
            r11 = r11.getParent();
            goto L29
        L33:
            r4 = null;
        L36:
            if (r3 == false) goto L38;
            ((cs1.a) r11).setDisallowInterceptOnce(true);
        L38:
            r0.a = r6.getRawY();
        L39:
            return true;
        }
    }

    public final void a() {
        UtilityKotlinExtentionsKt.s(0, false, true, new DragLinearLayout$checkLayoutPosition$1(this), 3);
    }

    public final int getTransLationSpace() {
        Integer r0 = Integer.valueOf((this.d - getTop()) - getHeight());
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return r0.intValue();
    L5:
        r1 = false;
        goto L6
    }

    public final int getBottomEdget() {
        return this.d;
    }

    public final float getDifferenceY() {
        return this.b;
    }

    public final Function1<Float, Unit> getRegionConfirmListener() {
        return this.c;
    }

    public final void setBottomEdget(int r1) {
        this.d = r1;
    }

    public final void setDifferenceY(float r1) {
        this.b = r1;
    }

    public final void setDraggable(boolean r1) {
        this.e = r1;
    }

    public final void setPosPercent(float r6) {
        double r0 = r6;
        if (r0 >= 0.0d) goto L5;
        return;
    L5:
        if (r0 > 1.0d) goto L9;
        setTranslationY(getTransLationSpace() * r6);
        return;
    }

    public final void setRegionConfirmListener(Function1<? super Float, Unit> r1) {
        this.c = r1;
    }

    public DragLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        setOnTouchListener(new a(this));
    }
}
