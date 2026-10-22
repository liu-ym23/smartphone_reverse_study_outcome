package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseView extends View implements View.OnClickListener, View.OnLongClickListener {
    static final int TEXT_SIZE = 14;
    boolean isClick;
    protected Paint mCurDayLunarTextPaint;
    protected Paint mCurDayTextPaint;
    protected Paint mCurMonthLunarTextPaint;
    protected Paint mCurMonthTextPaint;
    int mCurrentItem;
    l mDelegate;
    protected int mItemHeight;
    protected int mItemWidth;
    List<Calendar> mItems;
    protected Paint mOtherMonthLunarTextPaint;
    protected Paint mOtherMonthTextPaint;
    CalendarLayout mParentLayout;
    protected Paint mSchemeLunarTextPaint;
    protected Paint mSchemePaint;
    protected Paint mSchemeTextPaint;
    protected Paint mSelectTextPaint;
    protected Paint mSelectedLunarTextPaint;
    protected Paint mSelectedPaint;
    protected float mTextBaseLine;
    float mX;
    float mY;

    public void initPaint() {
    }

    public abstract void onDestroy();

    public void onPreviewHook() {
    }

    public abstract void updateCurrentDate();

    public final void addSchemesFromMap() {
        Map<String, Calendar> r100 = this.mDelegate.f276175j0;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() == 0) goto L25;
        Iterator<Calendar> r101 = this.mItems.iterator();
    L9:
        if (r101.hasNext() == false) goto L26;
        Calendar r102 = r101.next();
        if (this.mDelegate.f276175j0.containsKey(r102.toString()) == true) goto L12;
        r102.setScheme("");
        r102.setSchemeColor(0);
        r102.setSchemes(null);
        goto L9
    L12:
        Calendar r103 = this.mDelegate.f276175j0.get(r102.toString());
        if (TextUtils.isEmpty(r103.getScheme()) == false) goto L15;
        String r104 = this.mDelegate.S;
    L16:
        r102.setScheme(r104);
        r102.setSchemeColor(r103.getSchemeColor());
        r102.setSchemes(r103.getSchemes());
        goto L9
    L15:
        r104 = r103.getScheme();
        goto L16
    L26:
        return;
    }

    public final void removeSchemes() {
        Iterator<Calendar> r100 = this.mItems.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Calendar r101 = r100.next();
        r101.setScheme("");
        r101.setSchemeColor(0);
        r101.setSchemes(null);
        goto L4
    }

    final void update() {
        Map<String, Calendar> r100 = this.mDelegate.f276175j0;
        if (r100 != null) goto L5;
    L9:
        removeSchemes();
        invalidate();
        return;
    L5:
        if (r100.size() == 0) goto L9;
        addSchemesFromMap();
        invalidate();
    }

    public void updateItemHeight() {
        this.mItemHeight = this.mDelegate.f276159b0;
        Paint.FontMetrics r100 = this.mCurMonthTextPaint.getFontMetrics();
        this.mTextBaseLine = ((this.mItemHeight / 2) - r100.descent) + ((r100.bottom - r100.top) / 2.0f);
    }

    public BaseView(Context r100) {
        this(r100, null);
    }

    private void initPaint(Context r100) {
        this.mCurMonthTextPaint.setAntiAlias(true);
        this.mCurMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurMonthTextPaint.setColor(-15658735);
        this.mCurMonthTextPaint.setFakeBoldText(true);
        this.mCurMonthTextPaint.setTextSize(f.a(r100, 14.0f));
        this.mOtherMonthTextPaint.setAntiAlias(true);
        this.mOtherMonthTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthTextPaint.setColor(-1973791);
        this.mOtherMonthTextPaint.setFakeBoldText(true);
        this.mOtherMonthTextPaint.setTextSize(f.a(r100, 14.0f));
        this.mCurMonthLunarTextPaint.setAntiAlias(true);
        this.mCurMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectedLunarTextPaint.setAntiAlias(true);
        this.mSelectedLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mOtherMonthLunarTextPaint.setAntiAlias(true);
        this.mOtherMonthLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeLunarTextPaint.setAntiAlias(true);
        this.mSchemeLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setAntiAlias(true);
        this.mSchemeTextPaint.setStyle(Paint.Style.FILL);
        this.mSchemeTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSchemeTextPaint.setColor(-1223853);
        this.mSchemeTextPaint.setFakeBoldText(true);
        this.mSchemeTextPaint.setTextSize(f.a(r100, 14.0f));
        this.mSelectTextPaint.setAntiAlias(true);
        this.mSelectTextPaint.setStyle(Paint.Style.FILL);
        this.mSelectTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mSelectTextPaint.setColor(-1223853);
        this.mSelectTextPaint.setFakeBoldText(true);
        this.mSelectTextPaint.setTextSize(f.a(r100, 14.0f));
        this.mSchemePaint.setAntiAlias(true);
        this.mSchemePaint.setStyle(Paint.Style.FILL);
        this.mSchemePaint.setStrokeWidth(2.0f);
        this.mSchemePaint.setColor(-1052689);
        this.mCurDayTextPaint.setAntiAlias(true);
        this.mCurDayTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayTextPaint.setColor(-65536);
        this.mCurDayTextPaint.setFakeBoldText(true);
        this.mCurDayTextPaint.setTextSize(f.a(r100, 14.0f));
        this.mCurDayLunarTextPaint.setAntiAlias(true);
        this.mCurDayLunarTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mCurDayLunarTextPaint.setColor(-65536);
        this.mCurDayLunarTextPaint.setFakeBoldText(true);
        this.mCurDayLunarTextPaint.setTextSize(f.a(r100, 14.0f));
        this.mSelectedPaint.setAntiAlias(true);
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setStrokeWidth(2.0f);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public final boolean isInRange(Calendar r100) {
        l r101 = this.mDelegate;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (f.o(r100, r101) == false) goto L7;
        return true;
    }

    public boolean isSelected(Calendar r100) {
        List<Calendar> r101 = this.mItems;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.indexOf(r100) != this.mCurrentItem) goto L7;
        return true;
    }

    public final boolean onCalendarIntercept(Calendar r100) {
        this.mDelegate.getClass();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (r100.getPointerCount() <= 1) goto L5;
        return false;
    L5:
        int r102 = r100.getAction();
        if (r102 == 0) goto L18;
        if (r102 != 1) goto L9;
        this.mX = r100.getX();
        this.mY = r100.getY();
    L20:
        return super.onTouchEvent(r100);
    L9:
        if (r102 != 2) goto L20;
        if (this.isClick == false) goto L20;
        if (Math.abs(r100.getY() - this.mY) > 50.0f) goto L16;
        r101 = true;
    L16:
        this.isClick = r101;
        goto L20
    L18:
        this.mX = r100.getX();
        this.mY = r100.getY();
        this.isClick = true;
        goto L20
    }

    public void setup(l r100) {
        this.mDelegate = r100;
        this.mCurDayTextPaint.setColor(r100.f276162d);
        this.mCurDayLunarTextPaint.setColor(r100.f276164e);
        this.mCurMonthTextPaint.setColor(r100.f276174j);
        this.mOtherMonthTextPaint.setColor(r100.f276172i);
        this.mCurMonthLunarTextPaint.setColor(r100.f276180m);
        this.mSelectedLunarTextPaint.setColor(r100.f276178l);
        this.mSelectTextPaint.setColor(r100.f276176k);
        this.mOtherMonthLunarTextPaint.setColor(r100.f276182n);
        this.mSchemeLunarTextPaint.setColor(r100.f276170h);
        this.mSchemePaint.setColor(r100.I);
        this.mSchemeTextPaint.setColor(r100.f276168g);
        this.mCurMonthTextPaint.setTextSize(r100.Z);
        this.mOtherMonthTextPaint.setTextSize(r100.Z);
        this.mCurDayTextPaint.setTextSize(r100.Z);
        this.mSchemeTextPaint.setTextSize(r100.Z);
        this.mSelectTextPaint.setTextSize(r100.Z);
        this.mCurMonthLunarTextPaint.setTextSize(r100.f276157a0);
        this.mSelectedLunarTextPaint.setTextSize(r100.f276157a0);
        this.mCurDayLunarTextPaint.setTextSize(r100.f276157a0);
        this.mOtherMonthLunarTextPaint.setTextSize(r100.f276157a0);
        this.mSchemeLunarTextPaint.setTextSize(r100.f276157a0);
        this.mSelectedPaint.setStyle(Paint.Style.FILL);
        this.mSelectedPaint.setColor(r100.f276155J);
        updateItemHeight();
        initPaint();
    }

    public BaseView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mCurMonthTextPaint = new Paint();
        this.mOtherMonthTextPaint = new Paint();
        this.mCurMonthLunarTextPaint = new Paint();
        this.mSelectedLunarTextPaint = new Paint();
        this.mOtherMonthLunarTextPaint = new Paint();
        this.mSchemeLunarTextPaint = new Paint();
        this.mSchemePaint = new Paint();
        this.mSelectedPaint = new Paint();
        this.mSchemeTextPaint = new Paint();
        this.mSelectTextPaint = new Paint();
        this.mCurDayTextPaint = new Paint();
        this.mCurDayLunarTextPaint = new Paint();
        this.isClick = true;
        this.mCurrentItem = -1;
        initPaint(r100);
    }
}
