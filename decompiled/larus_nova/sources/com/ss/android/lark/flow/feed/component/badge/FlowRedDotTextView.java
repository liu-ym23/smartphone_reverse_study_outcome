package com.ss.android.lark.flow.feed.component.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u0012H\u0002J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0014R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/flow/feed/component/badge/FlowRedDotTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "badgeSize", "badgeTextSize", "", "glyphBounds", "Landroid/graphics/Rect;", "setRedDotText", "", "displayStr", "", "setBadgeSize", "setBadgeTextSize", "setRedDotBackground", "createOvalDrawable", "Landroid/graphics/drawable/Drawable;", "width", "height", "color", "onDraw", "canvas", "Landroid/graphics/Canvas;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowRedDotTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f423320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f423321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f423322c;

    public FlowRedDotTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f423320a = UIHelper.dp2px(22.0f);
        this.f423321b = 12.0f;
        this.f423322c = new Rect();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Drawable r101 = getBackground();
        if (r101 == null) goto L5;
        r101.draw(r100);
    L5:
        CharSequence r102 = getText();
        if (r102 == null) goto L8;
        String r103 = r102.toString();
    L9:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        if (r103.length() != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        return;
    L17:
        TextPaint r105 = getPaint();
        r105.setColor(getCurrentTextColor());
        r105.getTextBounds(r103, 0, r103.length(), this.f423322c);
        r100.drawText(r103, (getWidth() - r105.measureText(r103)) / 2.0f, ((getHeight() + this.f423322c.height()) / 2.0f) - this.f423322c.bottom, r105);
        return;
    L14:
        r104 = false;
        goto L15
    L8:
        r103 = null;
        goto L9
    }

    public final void setBadgeSize(float r100) {
        this.f423320a = UIHelper.dp2px(r100);
    }

    public final void setBadgeTextSize(float r100) {
        this.f423321b = r100;
    }

    public final void setRedDotText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "displayStr");
        setText(r100);
        setTextColor(ContextCompat.getColor(getContext(), R.color.flow_sidebar_badge_text_color));
        setTextSize(this.f423321b);
        setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        setIncludeFontPadding(false);
        int r101 = this.f423320a;
        int r102 = ContextCompat.getColor(getContext(), R.color.flow_sidebar_badge_color);
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(1);
        r103.setColor(r102);
        r103.setSize(r101, r101);
        setBackground(r103);
    }

    public FlowRedDotTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f423320a = UIHelper.dp2px(22.0f);
        this.f423321b = 12.0f;
        this.f423322c = new Rect();
    }

    public FlowRedDotTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f423320a = UIHelper.dp2px(22.0f);
        this.f423321b = 12.0f;
        this.f423322c = new Rect();
    }
}
