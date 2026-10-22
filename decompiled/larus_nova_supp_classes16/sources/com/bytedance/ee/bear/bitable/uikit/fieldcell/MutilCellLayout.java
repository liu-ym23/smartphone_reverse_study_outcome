package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001<B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010*\u001a\u00020'2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0015\u0010+\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0007H\u0002J0\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020;H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/MutilCellLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "cellLabelStyleProvider", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/MutilCellLayout$IMutilAddLabelStyleProvider;", "itemSpaceSize", "labelHorizontalPadding", "labelHeight", "isFixMeasureWidth", "", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "labelText", "", "labelTextStartX", "idealChildCount", "Ljava/lang/Integer;", "setFixMeasureWidth", "", "setItemSpace", "size", "setLabelSize", "height", "horizontalPadding", "getDp", "dp", "", "getLabelTextSp", "setMutilCellLabelStyleProvider", "getLabelTextWidth", "setIdealChildCount", "(Ljava/lang/Integer;)V", "getHiddenBaseChildCount", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "checkLayoutPosition", "right", "onLayout", "changed", "l", "t", "r", "b", "draw", "canvas", "Landroid/graphics/Canvas;", "IMutilAddLabelStyleProvider", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MutilCellLayout extends LinearLayout {
    public a a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public final Lazy f;
    public String g;
    public int h;
    public Integer i;

    public interface a {
        Drawable a();

        boolean b();

        int getTextColor();

        float getTextSize();
    }

    private final int getHiddenBaseChildCount() {
        Integer r0 = this.i;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        int r2 = r1 - getChildCount();
        if (r2 > 0) goto L9;
        return 0;
    L9:
        return r2;
    L5:
        r1 = 0;
        goto L6
    }

    private final float getLabelTextSp() {
        int r0 = com.larksuite.framework.utils.autoscale.a.a;
        Resources r1 = Resources.getSystem();
        a r2 = this.a;
        if (r2 == null) goto L5;
        float r3 = r2.getTextSize();
    L7:
        return TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
    L5:
        r3 = 14.0f;
        goto L7
    }

    private final Paint getPaint() {
        return (Paint) this.f.getValue();
    }

    public MutilCellLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final float a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return 0.0f;
    L6:
        getPaint().setTextSize(getLabelTextSp());
        Paint r0 = getPaint();
        a r1 = this.a;
        if (r1 == null) goto L9;
        boolean r2 = r1.b();
    L10:
        r0.setFakeBoldText(r2);
        return getPaint().measureText(r3) + (this.c * 2);
    L9:
        r2 = false;
        goto L10
    }

    @Override // android.view.View
    public final void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.draw(r9);
        String r0 = this.g;
        if (r0 == null) goto L15;
        a r1 = this.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (getChildCount() <= 1) goto L9;
    L10:
        getPaint().setTextSize(getLabelTextSp());
        getPaint().setColor(r1.getTextColor());
        getPaint().setFakeBoldText(r1.b());
        Rect r2 = new Rect();
        getPaint().getTextBounds(r0, 0, r0.length(), r2);
        Drawable r3 = r1.a();
        if (r3 == null) goto L13;
        int r4 = this.d;
        int r5 = (getMeasuredHeight() - r4) / 2;
        int r6 = this.h;
        r3.setBounds(r6, r5, (r2.width() + r6) + (this.c * 2), r4 + r5);
        r3.draw(r9);
    L13:
        r9.drawText(r0, this.h + this.c, getMeasuredHeight() - ((getMeasuredHeight() - r2.height()) / 2), getPaint());
        return;
    L9:
        if (getHiddenBaseChildCount() > 0) goto L10;
        return;
    }

    public final void setFixMeasureWidth(boolean r1) {
        this.e = r1;
    }

    public final void setIdealChildCount(Integer r1) {
        this.i = r1;
    }

    public final void setItemSpace(int r1) {
        this.b = r1;
    }

    public final void setMutilCellLabelStyleProvider(a r2) {
        Intrinsics.checkNotNullParameter(r2, "cellLabelStyleProvider");
        this.a = r2;
    }

    public MutilCellLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r20, int r21) {
        int r7 = getHiddenBaseChildCount();
        if (this.a != null) goto L5;
    L60:
        super.onMeasure(r20, r21);
        return;
    L5:
        if (getChildCount() < 1) goto L60;
        if (getChildCount() != 1) goto L10;
        if (r7 == 0) goto L60;
    L10:
        int r11 = 0;
        if (this.e == false) goto L39;
        this.g = null;
        int r12 = (View.MeasureSpec.getSize(r20) - getPaddingLeft()) - getPaddingRight();
        ArrayList r13 = new ArrayList();
        int r14 = getChildCount();
        int r0 = 0;
        int r16 = 0;
    L13:
        if (r16 >= r14) goto L18;
        View r17 = getChildAt(r16);
        int r18 = Math.max(r0, r17.getMeasuredHeight());
        measureChildWithMargins(r17, r20, 0, r21, 0);
        r13.add(Integer.valueOf(r17.getMeasuredWidth()));
        if ((CollectionsKt.sumOfInt(r13) + (this.b * r16)) > r12) goto L16;
        r16 = r16 + 1;
        r0 = r18;
        goto L13
    L16:
        boolean r1 = true;
    L19:
        if (r1 == true) goto L21;
    L37:
        setMeasuredDimension(r11 + (CollectionsKt.sumOfInt(r13) + (this.b * (r13.size() - 1))), (r18 + getPaddingTop()) + getPaddingBottom());
        return;
    L21:
        if (r13.size() <= 0) goto L32;
        int r2 = r13.size() - 1;
        int r3 = CollectionsKt.sumOfInt(r13) + (this.b * r2);
        int r4 = ((getChildCount() - r2) - 1) + r7;
        if (r4 != 0) goto L25;
        int r19 = 0;
    L27:
        if ((r3 + r19) <= r12) goto L28;
        if (r2 == 0) goto L30;
        ((Number) ListProtector.remove(r13, r2)).intValue();
        goto L21
    L30:
        this.g = "+" + r4;
        View r8 = getChildAt(r2);
        measureChildWithMargins(r8, r20, r19, r21, 0);
        ListProtector.set(r13, 0, Integer.valueOf(r8.getMeasuredWidth()));
    L33:
        int r5 = r13.size();
        int r9 = getChildCount();
        int r10 = r5;
    L34:
        if (r10 >= r9) goto L36;
        measureChildWithMargins(getChildAt(r10), View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r10 = r10 + 1;
        goto L34
    L36:
        r11 = r19;
        goto L37
    L28:
        this.g = "+" + r4;
        goto L33
    L25:
        r19 = ((int) a("+" + r4)) + this.b;
        goto L27
    L32:
        r19 = 0;
        goto L33
    L18:
        r18 = r0;
        r1 = false;
        goto L19
    L39:
        this.g = null;
        int r110 = (View.MeasureSpec.getSize(r20) - getPaddingLeft()) - getPaddingRight();
        int r111 = getChildCount();
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L40:
        if (r112 >= r111) goto L58;
        View r115 = getChildAt(r112);
        measureChildWithMargins(r115, r20, 0, r21, 0);
        r113 = Math.max(r113, r115.getMeasuredHeight());
        int r6 = ((getChildCount() - r112) - 1) + r7;
        if (r6 != 0) goto L44;
        int r116 = 0;
    L45:
        int r22 = r115.getMeasuredWidth();
        if (r112 != 0) goto L48;
        int r23 = 0;
    L49:
        int r24 = r114 + (r22 + r23);
        if ((r24 + r116) > r110) goto L51;
        r112 = r112 + 1;
        r114 = r24;
        goto L40
    L51:
        if (r112 != 0) goto L53;
        measureChildWithMargins(r115, r20, r116, r21, 0);
        this.g = "+" + r6;
        int r26 = r115.getMeasuredWidth() + r116;
    L54:
        r114 = r114 + r26;
        int r117 = r112 + 1;
        int r27 = getChildCount();
    L55:
        if (r117 >= r27) goto L58;
        measureChildWithMargins(getChildAt(r117), View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r117 = r117 + 1;
        goto L55
    L53:
        this.g = "+" + (r6 + 1);
        measureChildWithMargins(r115, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0, View.MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
        r26 = ((int) a(this.g)) + this.b;
        goto L54
    L48:
        r23 = this.b;
        goto L49
    L44:
        r116 = ((int) a("+" + r6)) + this.b;
    L58:
        setMeasuredDimension(r114, (r113 + getPaddingTop()) + getPaddingBottom());
    }

    public MutilCellLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = com.bytedance.ee.util.ui.n.c(6.0f);
        this.c = com.bytedance.ee.util.ui.n.c(6.0f);
        this.d = com.bytedance.ee.util.ui.n.c(24.0f);
        this.f = LazyKt.lazy(MutilCellLayout$paint$2.INSTANCE);
        setWillNotDraw(false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        if (this.a != null) goto L5;
    L28:
        super.onLayout(r8, r9, r10, r11, r12);
        return;
    L5:
        if (getChildCount() < 1) goto L28;
        if (getChildCount() == 1) goto L9;
    L11:
        int r13 = getPaddingLeft();
        int r14 = getChildCount();
        int r16 = 0;
    L12:
        if (r16 >= r14) goto L26;
        View r17 = getChildAt(r16);
        if (r17.getMeasuredWidth() <= 0) goto L24;
        int r0 = (getMeasuredHeight() - r17.getMeasuredHeight()) / 2;
        int r2 = r17.getMeasuredWidth() + r13;
        int r3 = r17.getMeasuredHeight() + r0;
        if (TextUtils.isEmpty(this.g) == false) goto L18;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        r17.layout(r13, r0, r2, r3);
        r13 = r2 + this.b;
    L25:
        r16 = r16 + 1;
        goto L12
    L23:
        r17.layout(0, 0, 0, 0);
        goto L25
    L18:
        if (r2 <= (((getMeasuredWidth() - a(this.g)) - getPaddingRight()) - this.b)) goto L20;
        r4 = false;
        goto L21
    L24:
        r17.layout(0, 0, 0, 0);
        goto L25
    L26:
        this.h = r13;
        return;
    L9:
        if (getHiddenBaseChildCount() != 0) goto L11;
        goto L11
    }
}
