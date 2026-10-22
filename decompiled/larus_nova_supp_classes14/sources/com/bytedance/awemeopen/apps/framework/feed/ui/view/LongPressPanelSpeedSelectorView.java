package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/LongPressPanelSpeedSelectorView;", "Landroid/view/View;", "Landroid/graphics/Paint;", "j", "Lkotlin/Lazy;", "getBackgroundPaint", "()Landroid/graphics/Paint;", "backgroundPaint", "k", "getSelectionPaint", "selectionPaint", "l", "getTextPaint", "textPaint", "m", "getSelectedTextPaint", "selectedTextPaint", "", "value", "o", "I", "setSelectedIndex", "(I)V", "selectedIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class LongPressPanelSpeedSelectorView extends View {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;
    public final float g;
    public final int h;
    public final RectF i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final List<String> n;
    public int o;
    public Function1<? super Integer, Unit> p;

    public LongPressPanelSpeedSelectorView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LongPressPanelSpeedSelectorView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Paint getBackgroundPaint() {
        return (Paint) this.j.getValue();
    }

    private final Paint getSelectedTextPaint() {
        return (Paint) this.m.getValue();
    }

    private final Paint getSelectionPaint() {
        return (Paint) this.k.getValue();
    }

    private final Paint getTextPaint() {
        return (Paint) this.l.getValue();
    }

    private final void setSelectedIndex(int r2) {
        if (this.o == r2) goto L8;
        this.o = r2;
        Function1<? super Integer, Unit> r0 = this.p;
        if (r0 == null) goto L9;
        r0.invoke(Integer.valueOf(r2));
        return;
    L9:
        return;
    }

    public final void a(Function1<? super Paint, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.invoke(getTextPaint());
        r2.invoke(getSelectedTextPaint());
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        boolean r0 = false;
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7.getAction() != 0) goto L9;
        return true;
    L9:
        if (r7.getAction() != 1) goto L32;
        float r1 = getMeasuredWidth();
        float r3 = r7.getX();
        if (0.0f <= r3) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L32;
        float r4 = getMeasuredHeight();
        float r5 = r7.getY();
        if (0.0f <= r5) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L32;
        int r8 = (int) ((r7.getX() - this.g) / ((getWidth() - (this.g * 2)) / ((ArrayList) this.n).size()));
        if (r8 >= 0) goto L27;
    L29:
        if (r0 == false) goto L31;
        setSelectedIndex(r8);
        invalidate();
    L31:
        return true;
    L27:
        if (r8 >= ((ArrayList) this.n).size()) goto L29;
        r0 = true;
        goto L29
    L20:
        if (r5 > r4) goto L22;
        r6 = true;
        goto L23
    L13:
        if (r3 > r1) goto L15;
        r2 = true;
    L32:
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        float r0 = this.h + 0.0f;
        float r2 = getWidth();
        float r3 = getHeight() - this.h;
        float r4 = this.e;
        Paint r5 = getBackgroundPaint();
        RectF r6 = this.i;
        r6.left = 0.0f;
        r6.top = r0;
        r6.right = r2;
        r6.bottom = r3;
        r10.drawRoundRect(r6, r4, r4, r5);
        int r1 = ((ArrayList) this.n).size();
        int r7 = this.o;
        int r8 = 0;
        if (r7 < 0) goto L9;
        if (r7 >= r1) goto L9;
        boolean r9 = true;
    L11:
        if (r9 == false) goto L13;
        float r11 = (getWidth() - (this.g * 2)) / ((ArrayList) this.n).size();
        float r12 = this.o * r11;
        float r13 = this.g;
        float r14 = r12 + r13;
        float r15 = r13 + this.h;
        float r16 = (getHeight() - this.g) - this.h;
        float r17 = this.e;
        Paint r18 = getSelectionPaint();
        RectF r19 = this.i;
        r19.left = r14;
        r19.top = r15;
        r19.right = r11 + r14;
        r19.bottom = r16;
        r10.drawRoundRect(r19, r17, r17, r18);
    L13:
        Paint.FontMetrics r20 = getTextPaint().getFontMetrics();
        float r21 = r20.bottom;
        float r22 = 2;
        float r23 = (getHeight() / 2) + (((r21 - r20.top) / r22) - r21);
        Iterator r24 = ((ArrayList) this.n).iterator();
    L15:
        if (r24.hasNext() == false) goto L24;
        Object r25 = r24.next();
        int r26 = r8 + 1;
        if (r8 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        String r27 = (String) r25;
        float r28 = (getWidth() - (this.g * r22)) / ((ArrayList) this.n).size();
        float r29 = ((r8 * r28) + this.g) + (r28 / r22);
        if (r8 != this.o) goto L22;
        Paint r30 = getSelectedTextPaint();
    L23:
        r10.drawText(r27, r29, r23, r30);
        r8 = r26;
        goto L15
    L22:
        r30 = getTextPaint();
        goto L23
    L24:
        return;
    L9:
        r9 = false;
        goto L11
    }

    public LongPressPanelSpeedSelectorView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        new LinkedHashMap();
        super(r3, r4, r5);
        Intrinsics.checkNotNullParameter("#0A161823", "<this>");
        this.a = ColorProtector.parseColor("#0A161823");
        this.b = -1;
        this.c = ContextCompat.getColor(r3, 2131100048);
        this.d = ContextCompat.getColor(r3, 2131100039);
        Resources r6 = Resources.getSystem();
        this.e = TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()));
        float r7 = 12;
        Resources r8 = Resources.getSystem();
        this.f = TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()));
        Resources r0 = Resources.getSystem();
        this.g = TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
        Resources r9 = Resources.getSystem();
        int r10 = MathKt.roundToInt(TypedValue.applyDimension(1, r7, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics())));
        this.h = r10;
        this.i = new RectF();
        setPadding(0, r10, 0, r10);
        this.j = LazyKt.lazy(new LongPressPanelSpeedSelectorView$backgroundPaint$2(this));
        this.k = LazyKt.lazy(new LongPressPanelSpeedSelectorView$selectionPaint$2(this));
        this.l = LazyKt.lazy(new LongPressPanelSpeedSelectorView$textPaint$2(this));
        this.m = LazyKt.lazy(new LongPressPanelSpeedSelectorView$selectedTextPaint$2(this));
        this.n = new ArrayList();
    }

    public final void b(List<String> r2, int r3, Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        List<String> r5 = r2;
        if ((!r5.isEmpty()) == false) goto L7;
        ((ArrayList) this.n).clear();
        ((ArrayList) this.n).addAll(r5);
        setSelectedIndex(r3);
        this.p = r4;
        invalidate();
        return;
    L7:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public /* synthetic */ LongPressPanelSpeedSelectorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
