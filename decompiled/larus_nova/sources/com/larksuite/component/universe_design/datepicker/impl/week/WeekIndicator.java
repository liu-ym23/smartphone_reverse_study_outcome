package com.larksuite.component.universe_design.datepicker.impl.week;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.b;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0014J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u000eR\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/week/WeekIndicator;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mWeeks", "", "", "[Ljava/lang/String;", "mShowTexts", "mBlueColor", "", "mBlackColor", "mCurrentWeekDayIndex", "mChangeTextColorBlue", "", "mWeekDateTextPaint", "Landroid/text/TextPaint;", "weekTextSizePx", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateWeekColorAndText", "currentWeekDayIndex", "changeTextColorBlue", "weekStartDay", "Lcom/larksuite/component/universe_design/util/CalendarDate$DayOfWeek;", "updateWeekColor", "setWeekTextSizePx", "textSize", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WeekIndicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f284822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f284823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f284824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f284825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f284827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextPaint f284828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f284829h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284830a = null;

        static {
            int[] r100 = new int[CalendarDate.DayOfWeek.values().length];
            r100[CalendarDate.DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CalendarDate.DayOfWeek.SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f284830a = r100;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = getWidth() / 7;
        int r101 = 0;
    L3:
        if (r101 >= 7) goto L21;
        String r102 = this.f284823b[r101];
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L20;
        if (this.f284827f == true) goto L16;
    L18:
        this.f284828g.setColor(this.f284825d);
    L19:
        int r104 = (int) r100;
        Rect r105 = new Rect(r104 * r101, 0, r104 * (r101 + 1), getHeight());
        Paint.FontMetrics r106 = this.f284828g.getFontMetrics();
        float r107 = r105.centerY();
        float r108 = r106.bottom;
        r110.drawText(r102, r105.centerX(), (r107 + ((r108 - r106.top) / 2)) - r108, this.f284828g);
        goto L20
    L16:
        if (r101 != this.f284826e) goto L18;
        this.f284828g.setColor(this.f284824c);
    L20:
        r101 = r101 + 1;
        goto L3
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
        goto L11
    }

    public final void setWeekTextSizePx(int r100) {
        float r101 = d.a(getContext(), r100);
        this.f284829h = r101;
        this.f284828g.setTextSize(r101);
        requestLayout();
        invalidate();
    }

    public WeekIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TextPaint r102 = new TextPaint();
        this.f284828g = r102;
        float r103 = d.a(getContext(), 12.0f);
        this.f284829h = r103;
        r102.setTextSize(r103);
        r102.setTextAlign(Paint.Align.CENTER);
        r102.setAntiAlias(true);
        Context r104 = getContext();
        int r105 = b.f483538a;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f284822a = r104.getResources().getStringArray(R.array.ud_timePicker_weeks_abbreviation);
        this.f284823b = new String[7];
        this.f284824c = r100.getResources().getColor(R.color.primary_fill_default);
        this.f284825d = r100.getResources().getColor(R.color.text_title);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), r100), (int) this.f284829h);
    }
}
