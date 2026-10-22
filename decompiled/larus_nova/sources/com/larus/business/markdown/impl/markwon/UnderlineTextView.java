package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.noties.markwon.core.spans.CustomLinkSpan;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "", "weight", "", "setBottomLineWeight", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getLineColor", "()I", "setLineColor", "(I)V", "lineColor", "", "b", "Z", "getDrawLine", "()Z", "setDrawLine", "(Z)V", "drawLine", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public class UnderlineTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f320588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f320589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f320590c;

    public UnderlineTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UnderlineTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public boolean getDrawLine() {
        return this.f320589b;
    }

    public int getLineColor() {
        return this.f320588a;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        Layout r100 = getLayout();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = 0;
        if (getDrawLine() == false) goto L10;
        this.f320590c.setColor(getLineColor());
        Paint.FontMetricsInt r102 = getPaint().getFontMetricsInt();
        int r103 = Math.abs((r102.bottom - r102.ascent) - getLineHeight());
        int r104 = r102.bottom;
        int r105 = r102.descent;
        int r110 = (r103 - (r104 - r105)) + (Math.abs(r105) / 2);
        int r111 = getLineCount();
    L8:
        if (r101 >= r111) goto L80;
        float r106 = getPaddingLeft() + r100.getLineLeft(r101);
        float r107 = r100.getLineRight(r101) + getPaddingLeft();
        float r108 = (r100.getLineBottom(r101) + getPaddingTop()) - r110;
        r210.drawLine(r106, r108, r107, r108, this.f320590c);
        r101 = r101 + 1;
        goto L8
    L80:
        return;
    L10:
        CharSequence r109 = getText();
        if ((r109 instanceof Spanned) == false) goto L13;
        Spanned r112 = (Spanned) r109;
    L14:
        if (r112 == null) goto L70;
        this.f320590c.setColor(getLineColor());
        Object[] r113 = r112.getSpans(0, r112.length(), CustomLinkSpan.class);
        ArrayList r114 = new ArrayList();
        int r115 = r113.length;
        int r116 = 0;
    L16:
        if (r116 >= r115) goto L21;
        Object r117 = r113[r116];
        if (((CustomLinkSpan) r117).f492294h == false) goto L20;
        r114.add(r117);
    L20:
        r116 = r116 + 1;
        goto L16
    L21:
        Paint.FontMetricsInt r118 = getPaint().getFontMetricsInt();
        int r119 = Math.abs((r118.bottom - r118.ascent) - getLineHeight());
        int r120 = r118.bottom;
        int r121 = r118.descent;
        int r122 = (r119 - (r120 - r121)) + (Math.abs(r121) / 2);
        int r123 = r114.size();
        int r124 = 0;
    L22:
        if (r124 >= r123) goto L81;
        CustomLinkSpan r125 = (CustomLinkSpan) ListProtector.get(r114, r124);
        int r126 = r112.getSpanStart(r125);
        int r127 = r112.getSpanEnd(r125);
        int r128 = r100.getLineForOffset(r126);
        int r129 = r100.getLineForOffset(r127);
        float r130 = r100.getPrimaryHorizontal(r126);
        float r131 = r100.getPrimaryHorizontal(r127);
        int r132 = getLineCount();
        int r133 = 0;
    L24:
        if (r133 >= r132) goto L69;
        if (r133 < r128) goto L67;
        if (r133 > r129) goto L67;
        Object[] r134 = r112.getSpans(r100.getLineStart(r133), r100.getLineEnd(r133), wsc.f.class);
        if (r134.length != 0) goto L31;
        boolean r135 = true;
    L32:
        if (r135 == false) goto L34;
        int r211 = r132;
        int r136 = r124;
        Integer r137 = null;
    L54:
        Integer r138 = r137;
        if (r138 == null) goto L57;
        int r139 = r138.intValue();
    L58:
        float r140 = RangesKt.coerceAtLeast((r139 - (r118.descent - r118.ascent)) / 2, 0);
        float r141 = getPaddingLeft();
        if (r133 != r128) goto L61;
        float r142 = r130;
    L62:
        float r143 = r141 + r142;
        float r144 = getPaddingLeft();
        if (r133 != r129) goto L65;
        float r145 = r131;
    L66:
        float r146 = r144 + r145;
        float r147 = ((getPaddingTop() + r122) + r100.getLineBaseline(r133)) + r140;
        int r148 = r136;
        r210.drawLine(r143, r147, r146, r147, this.f320590c);
    L68:
        r133 = r133 + 1;
        r124 = r148;
        r132 = r211;
        r129 = r129;
        r128 = r128;
        goto L24
    L65:
        r145 = r100.getLineMax(r133);
        goto L66
    L61:
        r142 = r100.getPrimaryHorizontal(r100.getLineStart(r133));
        goto L62
    L57:
        r139 = 0;
        goto L58
    L34:
        wsc.f r149 = (wsc.f) r134[0];
        Drawable r150 = r149.f561138b.f561120e;
        if (r150 == null) goto L39;
        Rect r151 = r150.getBounds();
        if (r151 == null) goto L39;
        int r152 = r151.height();
    L40:
        r137 = Integer.valueOf(r152);
        int r153 = ArraysKt.getLastIndex(r134);
        r211 = r132;
        int r154 = 1;
        if (1 > r153) goto L53;
    L42:
        Object[] r212 = r134;
        wsc.f r155 = (wsc.f) r134[r154];
        r136 = r124;
        Drawable r156 = r155.f561138b.f561120e;
        if (r156 == null) goto L47;
        Rect r157 = r156.getBounds();
        if (r157 == null) goto L47;
        int r158 = r157.height();
    L48:
        Integer r159 = Integer.valueOf(r158);
        if (r137.compareTo(r159) >= 0) goto L51;
        r137 = r159;
    L51:
        if (r154 == r153) goto L54;
        r154 = r154 + 1;
        r124 = r136;
        r134 = r212;
    L47:
        r158 = r155.f561138b.getBounds().height();
        goto L48
    L53:
        r136 = r124;
    L39:
        r152 = r149.f561138b.getBounds().height();
        goto L40
    L31:
        r135 = false;
    L67:
        r211 = r132;
        r148 = r124;
        goto L68
    L69:
        r124 = r124 + 1;
        goto L22
    L81:
        return;
    L70:
        return;
    L13:
        r112 = null;
        goto L14
    }

    public void setBottomLineWeight(float r100) {
        this.f320590c.setStrokeWidth(r100);
    }

    public void setDrawLine(boolean r100) {
        this.f320589b = r100;
    }

    public void setLineColor(int r100) {
        this.f320588a = r100;
    }

    public UnderlineTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f320588a = ContextCompat.getColor(getContext(), R.color.primary_transparent_4);
        this.f320590c = new Paint();
    }

    public /* synthetic */ UnderlineTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
