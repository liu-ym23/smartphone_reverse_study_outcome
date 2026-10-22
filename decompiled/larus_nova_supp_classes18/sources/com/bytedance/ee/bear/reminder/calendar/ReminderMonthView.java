package com.bytedance.ee.bear.reminder.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.haibin.calendarview.BaseView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ql5.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReminderMonthView extends s implements rl5.a, NonProguard {
    private static final long SEVEN_DAY = 604800000;
    private static a sExpireTime = null;
    private static List<rl5.a> sParamUpdateListeners = null;
    private static int sSelectAfterDayColorRes = 2131105628;
    private static int sSelectBeforeDayColorRes = 2131105629;
    private static int sSelectCurrentDayColorRes = 2131105630;
    private int mRadius;
    private float mTextHeight;

    public static class a {
        public int a;
        public int b;

        public a() {
        }
    }

    static {
        sParamUpdateListeners = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.view.View*/.onAttachedToWindow();
        sParamUpdateListeners.add(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.view.View*/.onDetachedFromWindow();
        sParamUpdateListeners.remove(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rl5.a
    public void onExpireTimeUpdate() {
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rl5.a
    public void onSelectColorResUpdate() {
        invalidate();
    }

    public ReminderMonthView(Context r5) {
        super(r5);
        this.mRadius = n.d(16);
        Rect r6 = new Rect();
        ((BaseView) this).mCurMonthTextPaint.getTextBounds("22", 0, 2, r6);
        this.mTextHeight = r6.height();
    }

    private static void notifyListeners(boolean r1) {
        if (r1 == false) goto L7;
        Iterator<rl5.a> r2 = sParamUpdateListeners.iterator();
    L5:
        if (r2.hasNext() == false) goto L11;
        r2.next().onExpireTimeUpdate();
        goto L5
    L11:
        return;
    L7:
        Iterator<rl5.a> r3 = sParamUpdateListeners.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        r3.next().onSelectColorResUpdate();
        goto L9
    }

    public static void updateExpireTime(int r1, int r2) {
        if (sExpireTime != null) goto L5;
        sExpireTime = new a();
    L5:
        a r0 = sExpireTime;
        r0.a = r1;
        r0.b = r2;
        notifyListeners(true);
    }

    public static void updateSelectDayColorResources(int r0, int r1, int r2) {
        sSelectBeforeDayColorRes = r0;
        sSelectAfterDayColorRes = r2;
        sSelectCurrentDayColorRes = r1;
        notifyListeners(false);
    }

    public void onDrawScheme(Canvas r3, Calendar r4, int r5, int r6) {
        r3.drawCircle(r5 + (((BaseView) this).mItemWidth / 2), (((BaseView) this).mTextBaseLine - (this.mTextHeight / 2.0f)) + r6, this.mRadius, ((BaseView) this).mSchemePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onDrawSelected(Canvas r6, Calendar r7, int r8, int r9, boolean r10) {
        long r0 = r7.getTimeInMillis();
        a r11 = sExpireTime;
        if (r11 == null) goto L5;
        r0 = f0.b(r7, r11.a, r11.b, 0);
    L5:
        long r1 = r0 - System.currentTimeMillis();
        if (r1 >= 0) goto L9;
        int r12 = sSelectBeforeDayColorRes;
    L12:
        ((BaseView) this).mSelectedPaint.setColor(getResources().getColor(r12));
        r6.drawCircle(r8 + (((BaseView) this).mItemWidth / 2), (((BaseView) this).mTextBaseLine - (this.mTextHeight / 2.0f)) + r9, this.mRadius, ((BaseView) this).mSelectedPaint);
        return false;
    L9:
        if (r1 >= SEVEN_DAY) goto L11;
        r12 = sSelectCurrentDayColorRes;
        goto L12
    L11:
        r12 = sSelectAfterDayColorRes;
        goto L12
    }

    public void onDrawText(Canvas r2, Calendar r3, int r4, int r5, boolean r6, boolean r7) {
        float r0 = ((BaseView) this).mTextBaseLine + r5;
        int r8 = r4 + (((BaseView) this).mItemWidth / 2);
        String r9 = String.valueOf(r3.getDay());
        float r10 = r8;
        if (r7 == true) goto L10;
        if (r6 == true) goto L10;
        if (r3.isCurrentMonth() == false) goto L9;
        Paint r11 = ((BaseView) this).mCurMonthTextPaint;
    L11:
        r2.drawText(r9, r10, r0, r11);
        return;
    L9:
        r11 = ((BaseView) this).mOtherMonthTextPaint;
    L10:
        r11 = ((BaseView) this).mSelectTextPaint;
        goto L11
    }
}
