package com.bytedance.ee.bear.reminder.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ql5.f0;

/* JADX INFO: loaded from: classes18.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f236471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f236472b;

        public a() {
        }
    }

    static {
        sParamUpdateListeners = new ArrayList();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        sParamUpdateListeners.add(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sParamUpdateListeners.remove(this);
    }

    @Override // rl5.a
    public void onExpireTimeUpdate() {
        invalidate();
    }

    @Override // rl5.a
    public void onSelectColorResUpdate() {
        invalidate();
    }

    public ReminderMonthView(Context r100) {
        super(r100);
        this.mRadius = n.d(16);
        Rect r101 = new Rect();
        this.mCurMonthTextPaint.getTextBounds("22", 0, 2, r101);
        this.mTextHeight = r101.height();
    }

    private static void notifyListeners(boolean r100) {
        if (r100 == false) goto L7;
        Iterator<rl5.a> r101 = sParamUpdateListeners.iterator();
    L5:
        if (r101.hasNext() == false) goto L11;
        r101.next().onExpireTimeUpdate();
        goto L5
    L11:
        return;
    L7:
        Iterator<rl5.a> r102 = sParamUpdateListeners.iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        r102.next().onSelectColorResUpdate();
        goto L9
    }

    public static void updateExpireTime(int r100, int r101) {
        if (sExpireTime != null) goto L5;
        sExpireTime = new a();
    L5:
        a r102 = sExpireTime;
        r102.f236471a = r100;
        r102.f236472b = r101;
        notifyListeners(true);
    }

    public static void updateSelectDayColorResources(int r100, int r101, int r102) {
        sSelectBeforeDayColorRes = r100;
        sSelectAfterDayColorRes = r102;
        sSelectCurrentDayColorRes = r101;
        notifyListeners(false);
    }

    @Override // com.haibin.calendarview.s
    public void onDrawScheme(Canvas r100, Calendar r101, int r102, int r103) {
        r100.drawCircle(r102 + (this.mItemWidth / 2), (this.mTextBaseLine - (this.mTextHeight / 2.0f)) + r103, this.mRadius, this.mSchemePaint);
    }

    @Override // com.haibin.calendarview.s
    public boolean onDrawSelected(Canvas r100, Calendar r101, int r102, int r103, boolean r110) {
        long r104 = r101.getTimeInMillis();
        a r111 = sExpireTime;
        if (r111 == null) goto L5;
        r104 = f0.b(r101, r111.f236471a, r111.f236472b, 0);
    L5:
        long r105 = r104 - System.currentTimeMillis();
        if (r105 >= 0) goto L9;
        int r106 = sSelectBeforeDayColorRes;
    L12:
        this.mSelectedPaint.setColor(getResources().getColor(r106));
        r100.drawCircle(r102 + (this.mItemWidth / 2), (this.mTextBaseLine - (this.mTextHeight / 2.0f)) + r103, this.mRadius, this.mSelectedPaint);
        return false;
    L9:
        if (r105 >= 604800000) goto L11;
        r106 = sSelectCurrentDayColorRes;
        goto L12
    L11:
        r106 = sSelectAfterDayColorRes;
        goto L12
    }

    @Override // com.haibin.calendarview.s
    public void onDrawText(Canvas r100, Calendar r101, int r102, int r103, boolean r104, boolean r105) {
        float r106 = this.mTextBaseLine + r103;
        int r107 = r102 + (this.mItemWidth / 2);
        String r108 = String.valueOf(r101.getDay());
        float r109 = r107;
        if (r105 == true) goto L10;
        if (r104 == true) goto L10;
        if (r101.isCurrentMonth() == false) goto L9;
        Paint r110 = this.mCurMonthTextPaint;
    L11:
        r100.drawText(r108, r109, r106, r110);
        return;
    L9:
        r110 = this.mOtherMonthTextPaint;
    L10:
        r110 = this.mSelectTextPaint;
        goto L11
    }
}
