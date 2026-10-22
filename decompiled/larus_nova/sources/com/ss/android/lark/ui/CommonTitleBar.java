package com.ss.android.lark.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.Contexts;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class CommonTitleBar extends LinearLayout implements View.OnClickListener {
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private static final String TAG = "CommonTitleBar";
    private boolean isCenterAlways;
    private boolean isLeftAlignMode;
    private final List<IActionTitlebar$Action> mActionList;
    private final int mBackIconRes;
    private final int mBackground;
    private LinearLayout mCenterLayout;
    private TextView mCenterText;
    private final Context mContext;
    private View mDividerView;
    private boolean mDividerVisible;
    private int mHeight;
    private boolean mImmersive;
    private int mLeftDrawablePadding;
    private LinearLayout mLeftLayout;
    protected TextView mLeftText;
    private int mLeftTextPadding;
    private int mMinSidePadding;
    private int mOutLeftPadding;
    private int mOutPadding;
    protected LinearLayout mRightLayout;
    private int mScreenWidth;
    protected TextView mSecLeftText;
    private int mStatusBarHeight;
    private TextView mSubTitleText;
    private String mTitle;
    private final int mTitleColor;
    private e mTitleDoubleTapListener;

    public static class ActionList extends LinkedList<IActionTitlebar$Action> {
        public ActionList() {
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonTitleBar f444538a;

        public a(CommonTitleBar r100) {
            this.f444538a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Context r101 = CommonTitleBar.access$000(this.f444538a);
            if ((r101 instanceof Activity) == false) goto L6;
            ((Activity) r101).finish();
            return;
        L6:
            if (r101 == null) goto L11;
            Activity r102 = Contexts.findActivity(r101);
            if (r102 == null) goto L12;
            r102.finish();
            return;
        L12:
            return;
        }
    }

    public class b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonTitleBar f444539a;

        public b(CommonTitleBar r100) {
            this.f444539a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            int r103 = CommonTitleBar.access$100(this.f444539a);
            int r104 = r102.top;
            if (r103 == r104) goto L5;
            CommonTitleBar.access$102(this.f444539a, r104);
            this.f444539a.requestLayout();
        L5:
            return r101;
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonTitleBar f444540a;

        public c(CommonTitleBar r100) {
            this.f444540a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            CommonTitleBar.access$200(this.f444540a);
            return false;
        }
    }

    public class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureDetector f444541a;

        public d(GestureDetector r100) {
            this.f444541a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            this.f444541a.onTouchEvent(r101);
            return true;
        }
    }

    public interface e {
    }

    public TextView getRightText() {
        return getRightText(0);
    }

    public void registerTitleDoubleTapListener(e r100) {
    }

    private void adjustLeftTextPadding() {
        int r100 = this.mOutPadding;
        if (this.mLeftText.getText().toString().length() <= 0) goto L5;
        r100 = this.mLeftTextPadding;
    L5:
        this.mLeftText.setPadding(this.mOutPadding, 0, r100, 0);
    }

    private void adjustSecLeftTextPadding() {
        TextView r100 = this.mSecLeftText;
        int r101 = this.mLeftTextPadding;
        r100.setPadding(r101, 0, r101, 0);
    }

    private void detectTitleTap() {
        if (this.mCenterLayout != null) goto L5;
        return;
    L5:
        Handler r100 = new Handler(Looper.getMainLooper());
        d r101 = new d(new GestureDetector(getContext(), new c(this), r100));
        this.mCenterLayout.setOnTouchListener(r101);
    }

    public int getActionCount() {
        return this.mRightLayout.getChildCount();
    }

    public List<IActionTitlebar$Action> getAllActions() {
        return new ArrayList(this.mActionList);
    }

    public Drawable getLeftDrawable() {
        return this.mLeftText.getCompoundDrawables()[0];
    }

    public void hideRightAndRemoveActions() {
        this.mRightLayout.setVisibility(8);
        this.mActionList.clear();
    }

    public void removeAllActions() {
        this.mRightLayout.removeAllViews();
        this.mActionList.clear();
    }

    public static int getStatusBarHeight() {
        Resources r100 = Resources.getSystem();
        int r101 = r100.getIdentifier("status_bar_height", "dimen", "android");
        if (r101 > 0) goto L7;
        return 0;
    L7:
        return r100.getDimensionPixelSize(r101);
    }

    public LinearLayout getCenterLayout() {
        return this.mCenterLayout;
    }

    public TextView getCenterText() {
        return this.mCenterText;
    }

    public int getLeftDrawablePadding() {
        return this.mLeftDrawablePadding;
    }

    public LinearLayout getLeftLayout() {
        return this.mLeftLayout;
    }

    public TextView getLeftText() {
        return this.mLeftText;
    }

    public LinearLayout getRightLayout() {
        return this.mRightLayout;
    }

    public CommonTitleBar(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ Context access$000(CommonTitleBar r100) {
        return r100.mContext;
    }

    public static /* synthetic */ int access$100(CommonTitleBar r100) {
        return r100.mStatusBarHeight;
    }

    public static /* synthetic */ e access$200(CommonTitleBar r100) {
        r100.getClass();
        return null;
    }

    public static /* synthetic */ LinearLayout access$300(CommonTitleBar r100) {
        return r100.mCenterLayout;
    }

    private int getVisibleWidth(View r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (r100.getVisibility() != 8) goto L6;
        return 0;
    L6:
        return r100.getMeasuredWidth();
    }

    private void init(Context r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r102 = Resources.getSystem();
        this.mOutPadding = (int) ((15 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
        Resources r103 = Resources.getSystem();
        this.mOutLeftPadding = (int) ((9 * WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density) + 0.5f);
        this.mLeftTextPadding = y9c.d.a(8);
        boolean r104 = false;
        this.mLeftDrawablePadding = y9c.d.a(0);
        this.mMinSidePadding = y9c.d.a(8);
        this.mHeight = r100.getResources().getDimensionPixelSize(R.dimen.title_height);
        int r105 = y9c.a.f566996a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.adjust_title_bar_height_in_forseti_new") == false) goto L5;
    L7:
        if (r104 == false) goto L9;
        this.mHeight = r100.getResources().getDimensionPixelSize(R.dimen.new_title_height);
    L9:
        initView(r100);
        return;
    L5:
        if (ForsetiConfig.b() == false) goto L7;
        r104 = true;
        goto L7
    }

    private void initView(Context r100) {
        setOrientation(0);
        this.mLeftText = new TextView(r100);
        this.mSecLeftText = new TextView(r100);
        this.mCenterLayout = new LinearLayout(r100);
        this.mRightLayout = new LinearLayout(r100);
        this.mLeftLayout = new LinearLayout(r100);
        this.mDividerView = new View(r100);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, -1);
        setDefaultTextStyle(this.mLeftText);
        TextView r102 = this.mLeftText;
        int r103 = CommonTitleBarConstants.DEFAULT_LEFT_TEXT_SIZE;
        r102.setTextSize(r103);
        this.mLeftText.setTextColor(getResources().getColorStateList(R.color.black_c2_c3_selector));
        this.mLeftText.setPadding(this.mOutPadding, 0, 0, 0);
        this.mLeftText.setOnClickListener(new a(this));
        setDefaultTextStyle(this.mSecLeftText);
        this.mSecLeftText.setTextSize(r103);
        this.mSecLeftText.setTextColor(getResources().getColorStateList(R.color.black_c2_c3_selector));
        this.mCenterText = new TextView(r100);
        this.mSubTitleText = new TextView(r100);
        this.mCenterLayout.addView(this.mCenterText);
        this.mCenterLayout.addView(this.mSubTitleText);
        this.mCenterLayout.setGravity(17);
        setDefaultTextStyle(this.mCenterText);
        setDefaultTextStyle(this.mSubTitleText);
        this.mCenterText.setTextSize(CommonTitleBarConstants.DEFAULT_MAIN_TEXT_SIZE);
        this.mCenterText.setTextColor(this.mTitleColor);
        this.mCenterText.setGravity(17);
        this.mSubTitleText.setTextSize(CommonTitleBarConstants.DEFAULT_SUB_TEXT_SIZE);
        this.mSubTitleText.setTextColor(r100.getResources().getColor(R.color.text_title));
        this.mSubTitleText.setGravity(17);
        this.mRightLayout.setPadding(0, 0, 0, 0);
        this.mLeftLayout.setPadding(this.mOutPadding, 0, 0, 0);
        this.mLeftLayout.setGravity(16);
        this.mDividerView.setBackgroundColor(r100.getResources().getColor(R.color.line_divider_default));
        addView(this.mLeftText, r101);
        addView(this.mSecLeftText, r101);
        addView(this.mLeftLayout, r101);
        addView(this.mCenterLayout, r101);
        addView(this.mRightLayout, r101);
        addView(this.mDividerView, new LinearLayout.LayoutParams(-1, 1));
        setBackgroundColor(this.mBackground);
        setTitle(this.mTitle);
        setLeftImageResource(this.mBackIconRes);
        setDividerVisible(this.mDividerVisible);
        detectTitleTap();
    }

    private void setDefaultTextStyle(TextView r100) {
        Context r101 = this.mContext;
        if (r101 == null) goto L6;
        r100.setTextColor(r101.getResources().getColor(R.color.text_title));
        r100.setSingleLine();
        r100.setGravity(16);
        r100.setEllipsize(TextUtils.TruncateAt.END);
        return;
    }

    public View addAction(IActionTitlebar$Action r100) {
        return addAction(r100, this.mRightLayout.getChildCount());
    }

    public void addActions(ActionList r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        addAction(r100.get(r102));
        r102 = r102 + 1;
        goto L3
    }

    public TextView getRightText(int r100) {
        View r101 = getRightView(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if ((r101 instanceof TextView) == true) goto L7;
        return null;
    L7:
        return (TextView) r101;
    }

    public View getRightView(int r100) {
        if (r100 >= 0) goto L5;
        return null;
    L5:
        if (r100 >= this.mActionList.size()) goto L13;
        IActionTitlebar$Action r101 = (IActionTitlebar$Action) ListProtector.get(this.mActionList, r100);
        if (r101 != null) goto L10;
        return null;
    L10:
        return getViewByAction(r101);
    L13:
        return null;
    }

    public View getViewByAction(IActionTitlebar$Action r100) {
        return findViewWithTag(r100);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        Object r101 = r100.getTag();
        if ((r101 instanceof IActionTitlebar$Action) == false) goto L6;
        ((IActionTitlebar$Action) r101).performAction(r100);
        return;
    }

    public void removeAction(IActionTitlebar$Action r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = this.mRightLayout.getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        View r103 = this.mRightLayout.getChildAt(r102);
        if (r103 == null) goto L13;
        Object r104 = r103.getTag();
        if ((r104 instanceof IActionTitlebar$Action) == false) goto L13;
        if (r104.equals(r100) == false) goto L13;
        this.mRightLayout.removeView(r103);
        this.mActionList.remove(r104);
    L13:
        r102 = r102 + 1;
        goto L5
    }

    public void removeActionAt(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        this.mRightLayout.removeViewAt(r100);
        ListProtector.remove(this.mActionList, r100);
    }

    public void setCenterClickListener(View.OnClickListener r100) {
        this.mCenterLayout.setOnClickListener(r100);
    }

    public void setCenterViewVisible(int r100) {
        this.mCenterLayout.setVisibility(r100);
    }

    public void setCustomTitleView(View r100) {
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.mCenterLayout.removeAllViews();
        this.mCenterLayout.addView(r100);
    }

    public void setDivider(int r100) {
        this.mDividerView.setBackgroundResource(r100);
    }

    public void setDividerColor(int r100) {
        this.mDividerView.setBackgroundColor(r100);
    }

    public void setDividerHeight(int r100) {
        this.mDividerView.getLayoutParams().height = r100;
    }

    public void setDividerVisible(boolean r100) {
        View r101 = this.mDividerView;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
        setMeasuredDimension(getMeasuredWidth(), this.mHeight);
    }

    public void setImmersive(boolean r100) {
        if (this.mImmersive != r100) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this));
        ViewCompat.requestApplyInsets(this);
    L8:
        this.mImmersive = r100;
        return;
    L7:
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        this.mStatusBarHeight = 0;
        goto L8
    }

    public void setIsCenterAlways(boolean r100) {
        this.isCenterAlways = r100;
        invalidate();
    }

    public void setLeftAlignMode(boolean r100) {
        this.isLeftAlignMode = r100;
    }

    public void setLeftClickListener(View.OnClickListener r100) {
        this.mLeftText.setOnClickListener(r100);
    }

    public void setLeftImageDrawable(Drawable r100) {
        this.mLeftText.setCompoundDrawablesWithIntrinsicBounds(r100, null, null, null);
        adjustLeftTextPadding();
    }

    public void setLeftImageResource(int r100) {
        setLeftImageResource(r100, R.color.icon_n1);
    }

    public void setLeftText(CharSequence r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mLeftText.setCompoundDrawablePadding(this.mLeftDrawablePadding);
        this.mLeftText.setText(r100);
        adjustLeftTextPadding();
    }

    public void setLeftTextBackground(int r100) {
        this.mLeftText.setBackgroundResource(r100);
    }

    public void setLeftTextColor(int r100) {
        this.mLeftText.setTextColor(r100);
    }

    public void setLeftTextOnly(int r100) {
        setLeftText(r100);
        setLeftImageDrawable(null);
    }

    public void setLeftTextSize(float r100) {
        this.mLeftText.setTextSize(r100);
    }

    public void setLeftVisible(boolean r100) {
        TextView r101 = this.mLeftText;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setMainTitleBackground(int r100) {
        this.mCenterText.setBackgroundResource(r100);
    }

    public void setMainTitleColor(int r100) {
        this.mCenterText.setTextColor(r100);
    }

    public void setMainTitleSize(float r100) {
        this.mCenterText.setTextSize(r100);
    }

    public void setMainTitleTextStyle(int r100) {
        TextView r101 = this.mCenterText;
        r101.setTypeface(r101.getTypeface(), r100);
    }

    public void setMainTitleVisible(boolean r100) {
        TextView r101 = this.mCenterText;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setRightImage(Drawable r100) {
        setRightImage(0, r100);
    }

    public void setRightText(String r100) {
        setRightText(0, r100);
    }

    public void setRightVisible(boolean r100) {
        LinearLayout r101 = this.mRightLayout;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setSecLeftClickListener(View.OnClickListener r100) {
        this.mSecLeftText.setOnClickListener(r100);
    }

    public void setSecLeftImageDrawable(Drawable r100) {
        this.mSecLeftText.setCompoundDrawablesWithIntrinsicBounds(r100, null, null, null);
        adjustSecLeftTextPadding();
    }

    public void setSecLeftImageResource(int r100) {
        Drawable r101 = AppCompatResources.getDrawable(getContext(), r100);
        this.mSecLeftText.setCompoundDrawablesWithIntrinsicBounds(r101, null, null, null);
        adjustSecLeftTextPadding();
    }

    public void setSecLeftText(CharSequence r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mSecLeftText.setCompoundDrawablePadding(this.mLeftDrawablePadding);
        this.mSecLeftText.setText(r100);
        adjustSecLeftTextPadding();
    }

    public void setSecLeftTextColor(int r100) {
        this.mSecLeftText.setTextColor(r100);
    }

    public void setSecLeftTextTypeface(int r100) {
        this.mSecLeftText.setTypeface(Typeface.defaultFromStyle(r100));
    }

    public void setSecLeftVisible(boolean r100) {
        TextView r101 = this.mSecLeftText;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setSubTitleBackground(int r100) {
        this.mSubTitleText.setBackgroundResource(r100);
    }

    public void setSubTitleColor(int r100) {
        this.mSubTitleText.setTextColor(r100);
    }

    public void setSubTitleSize(float r100) {
        this.mSubTitleText.setTextSize(r100);
    }

    public void setSubTitleVisible(boolean r100) {
        TextView r101 = this.mSubTitleText;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setTitle(int r100) {
        setTitle(y9c.d.i(getContext(), r100));
    }

    public void setTitleMaxLines(int r100) {
        if (r100 != 1) goto L5;
        this.mCenterText.setSingleLine();
    L5:
        this.mCenterText.setMaxLines(r100);
    }

    public void updateTitleBarWidth(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.mScreenWidth = r100;
        requestLayout();
    }

    public void setLeftText(int r100) {
        this.mLeftText.setCompoundDrawablePadding(this.mLeftDrawablePadding);
        this.mLeftText.setText(r100);
        adjustLeftTextPadding();
    }

    public void setLeftTextColor(ColorStateList r100) {
        this.mLeftText.setTextColor(r100);
    }

    public void setLeftTextOnly(CharSequence r100) {
        setLeftText(r100);
        setLeftImageDrawable(null);
    }

    public void setSecLeftTextColor(ColorStateList r100) {
        this.mSecLeftText.setTextColor(r100);
    }

    public void setTitle(CharSequence r100) {
        setTitle(r100, false);
    }

    public CommonTitleBar(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ int access$102(CommonTitleBar r100, int r101) {
        r100.mStatusBarHeight = r101;
        return r101;
    }

    public View addAction(IActionTitlebar$Action r100, ViewGroup.LayoutParams r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = this.mRightLayout.getChildCount();
        View r103 = com.ss.android.lark.ui.a.a(getContext(), r100);
        r103.setTag(r100);
        r103.setOnClickListener(this);
        ViewGroup.LayoutParams r104 = r101;
        if (r101 != null) goto L8;
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-2, -1);
        r105.gravity = 16;
        r104 = r105;
    L8:
        this.mRightLayout.addView(r103, r102, r104);
        return r103;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r100);
        if (1073741824 != r102) goto L5;
        int r104 = View.MeasureSpec.getSize(r101);
        int r105 = this.mStatusBarHeight;
    L6:
        int r106 = r104 + r105;
        measureChild(this.mLeftText, r100, r101);
        measureChild(this.mSecLeftText, r100, r101);
        measureChild(this.mRightLayout, r100, r101);
        int r107 = getVisibleWidth(this.mRightLayout) + this.mMinSidePadding;
        measureChild(this.mLeftLayout, View.MeasureSpec.makeMeasureSpec(r103 - r107, Integer.MIN_VALUE), r101);
        int r108 = Math.max(getVisibleWidth(this.mLeftText) + getVisibleWidth(this.mSecLeftText), getVisibleWidth(this.mLeftLayout)) + this.mMinSidePadding;
        if (this.isCenterAlways == false) goto L11;
        if (r108 >= r107) goto L10;
        this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec(r103 - (r107 * 2), 1073741824), r101);
    L12:
        measureChild(this.mDividerView, r100, r101);
        setMeasuredDimension(View.MeasureSpec.getSize(r100), r106);
        return;
    L10:
        this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec(r103 - (r108 * 2), 1073741824), r101);
        goto L12
    L11:
        this.mCenterLayout.measure(View.MeasureSpec.makeMeasureSpec((r103 - r108) - r107, Integer.MIN_VALUE), r101);
        goto L12
    L5:
        r101 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
        r104 = this.mHeight;
        r105 = this.mStatusBarHeight;
        goto L6
    }

    public void setLeftImageResource(int r100, TitleBarIconSize r101) {
        setLeftImageResource(r100, R.color.icon_n1, r101);
    }

    public void setRightImage(int r100, Drawable r101) {
        if (r100 >= 0) goto L4;
    L5:
        r100 = 0;
    L7:
        if (this.mActionList.isEmpty() == false) goto L10;
        addAction(new com.ss.android.lark.ui.c(r101));
        return;
    L10:
        IActionTitlebar$Action r102 = (IActionTitlebar$Action) ListProtector.get(this.mActionList, r100);
        if (r102 == null) goto L18;
        View r103 = getViewByAction(r102);
        if (r103 != null) goto L15;
        return;
    L15:
        if ((r103 instanceof ImageView) == false) goto L20;
        ImageView r104 = (ImageView) r103;
        r104.setImageDrawable(r101);
        r104.setImageTintList(getContext().getResources().getColorStateList(R.color.icon_n1));
        return;
    L20:
        return;
    L18:
        return;
    L4:
        if (r100 < this.mActionList.size()) goto L7;
        goto L5
    }

    public void setRightText(int r100, String r101) {
        IActionTitlebar$Action r102 = (IActionTitlebar$Action) ListProtector.get(this.mActionList, r100);
        if (r102 == null) goto L10;
        View r103 = getViewByAction(r102);
        if (r103 != null) goto L7;
        return;
    L7:
        if ((r103 instanceof TextView) == false) goto L12;
        ((TextView) r103).setText(r101);
        return;
    L12:
        return;
    }

    public void setSecLeftImageResource(int r100, int r101) {
        Drawable r102 = UDIconUtils.getIconDrawable(getContext(), r100, UIUtils.getColor(getContext(), r101));
        this.mSecLeftText.setCompoundDrawablesWithIntrinsicBounds(r102, null, null, null);
        adjustSecLeftTextPadding();
    }

    public void setTitle(CharSequence r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == false) goto L6;
        this.mCenterLayout.removeAllViews();
        this.mCenterLayout.addView(this.mCenterText);
        this.mCenterLayout.addView(this.mSubTitleText);
    L6:
        int r102 = r100.toString().indexOf("\n");
        if (r102 <= 0) goto L9;
        setTitle(r100.subSequence(0, r102), r100.subSequence(r102 + 1, r100.length()), 1);
        return;
    L9:
        int r103 = r100.toString().indexOf("\t");
        if (r103 <= 0) goto L12;
        setTitle(r100.subSequence(0, r103), " " + r100.subSequence(r103 + 1, r100.length()), 0);
        return;
    L12:
        this.mCenterText.setText(r100);
        this.mSubTitleText.setVisibility(8);
    }

    public View addAction(IActionTitlebar$Action r100, int r101) {
        return addAction(r100, r101, null);
    }

    public void setLeftImageResource(int r100, int r101) {
        setLeftImageResource(r100, r101, TitleBarIconSize.NORMAL);
    }

    public CommonTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mActionList = new ArrayList();
        this.isCenterAlways = false;
        this.mTitle = "";
        this.mDividerVisible = false;
        this.isLeftAlignMode = false;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.tb_back_icon, R.attr.tb_background, R.attr.tb_divider_visible, R.attr.tb_title, R.attr.tb_title_color});
        this.mTitle = r103.getString(3);
        this.mBackground = r103.getColor(1, r100.getResources().getColor(R.color.bg_body));
        this.mTitleColor = r103.getColor(4, r100.getResources().getColor(R.color.text_title));
        this.mBackIconRes = r103.getResourceId(0, CommonTitleBarConstants.ICON_BACK);
        this.mDividerVisible = r103.getBoolean(2, false);
        r103.recycle();
        this.mContext = r100;
        init(r100);
    }

    private void setTitle(CharSequence r100, CharSequence r101, int r102) {
        this.mCenterText.setText(r100);
        this.mCenterText.setVisibility(0);
        this.mCenterLayout.setOrientation(r102);
        this.mSubTitleText.setVisibility(0);
        this.mSubTitleText.setText(r101);
    }

    public View addAction(IActionTitlebar$Action r100, int r101, ViewGroup.LayoutParams r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ListProtector.add(this.mActionList, r101, r100);
        ViewGroup.LayoutParams r103 = r102;
        if (r102 != null) goto L8;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -1);
        r104.gravity = 16;
        r103 = r104;
    L8:
        View r105 = com.ss.android.lark.ui.a.a(getContext(), r100);
        r105.setTag(r100);
        r105.setOnClickListener(this);
        this.mRightLayout.addView(r105, r101, r103);
        return r105;
    }

    public void setLeftImageResource(int r100, int r101, TitleBarIconSize r102) {
        Drawable r103 = UDIconUtils.getIconDrawable(getContext(), r100, UIUtils.getColor(getContext(), r101));
        float r104 = r102.leftIconSize(getContext()) / TitleBarIconSize.NORMAL.leftIconSize(getContext());
        if (r104 <= 1.0f) goto L5;
        r104 = 1.0f;
    L5:
        ScaleDrawable r105 = new ScaleDrawable(r103, 17, 1.0f, 1.0f);
        r105.setLevel((int) (r104 * 10000.0f));
        this.mLeftText.setCompoundDrawablesWithIntrinsicBounds(r105, null, null, null);
        adjustLeftTextPadding();
    }

    public void setRightText(int r100, String r101, int r102) {
        IActionTitlebar$Action r103 = (IActionTitlebar$Action) ListProtector.get(this.mActionList, r100);
        if (r103 == null) goto L10;
        View r104 = getViewByAction(r103);
        if (r104 != null) goto L7;
        return;
    L7:
        if ((r104 instanceof TextView) == false) goto L12;
        TextView r105 = (TextView) r104;
        r105.setText(r101);
        r105.setTextColor(r102);
        return;
    L12:
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.mScreenWidth == r100) goto L6;
        this.mScreenWidth = r100;
        requestLayout();
        return;
    }

    public void setLeftTextPadding(int r100, int r101, int r102, int r103) {
        this.mLeftText.setPadding(y9c.d.a(r100), y9c.d.a(r101), y9c.d.a(r102), y9c.d.a(r103));
    }

    public void setSecLeftTextPadding(int r100, int r101, int r102, int r103) {
        this.mSecLeftText.setPadding(y9c.d.a(r100), y9c.d.a(r101), y9c.d.a(r102), y9c.d.a(r103));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        LinearLayout r106 = this.mLeftLayout;
        r106.layout(0, this.mStatusBarHeight, r106.getMeasuredWidth(), this.mStatusBarHeight + this.mLeftLayout.getMeasuredHeight());
        LinearLayout r107 = this.mRightLayout;
        int r108 = r105 - r107.getMeasuredWidth();
        int r109 = this.mStatusBarHeight;
        r107.layout(r108, r109, r105, this.mRightLayout.getMeasuredHeight() + r109);
        TextView r110 = this.mLeftText;
        r110.layout(0, this.mStatusBarHeight, r110.getMeasuredWidth(), this.mLeftText.getMeasuredHeight() + this.mStatusBarHeight);
        this.mSecLeftText.layout(this.mLeftText.getMeasuredWidth(), this.mStatusBarHeight, this.mLeftText.getMeasuredWidth() + this.mSecLeftText.getMeasuredWidth(), this.mSecLeftText.getMeasuredHeight() + this.mStatusBarHeight);
        int r111 = Math.max(getVisibleWidth(this.mLeftText) + getVisibleWidth(this.mSecLeftText), getVisibleWidth(this.mLeftLayout)) + this.mMinSidePadding;
        int r112 = getVisibleWidth(this.mRightLayout) + this.mMinSidePadding;
        if (this.isLeftAlignMode == false) goto L6;
        LinearLayout r113 = this.mCenterLayout;
        r113.layout(r111, this.mStatusBarHeight, r113.getMeasuredWidth() + r111, getMeasuredHeight());
        return;
    L6:
        if (this.isCenterAlways == false) goto L11;
        if (r111 <= r112) goto L9;
        this.mCenterLayout.layout(r111, this.mStatusBarHeight, r105 - r111, getMeasuredHeight());
    L10:
        this.mDividerView.layout(0, getMeasuredHeight() - this.mDividerView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
        return;
    L9:
        this.mCenterLayout.layout(r112, this.mStatusBarHeight, r105 - r112, getMeasuredHeight());
        goto L10
    L11:
        int r114 = r105 / 2;
        int r115 = r114 - r111;
        int r116 = r114 - r112;
        int r117 = Math.min(r115, r116) * 2;
        int r118 = this.mCenterLayout.getMeasuredWidth();
        if (r118 > r117) goto L14;
        int r119 = r118 / 2;
        this.mCenterLayout.layout(r114 - r119, this.mStatusBarHeight, r114 + r119, getMeasuredHeight());
        return;
    L14:
        if (r115 <= r116) goto L16;
        this.mCenterLayout.layout((r105 - r118) - r112, this.mStatusBarHeight, r105 - r112, getMeasuredHeight());
        return;
    L16:
        this.mCenterLayout.layout(r111, this.mStatusBarHeight, r118 + r111, getMeasuredHeight());
    }
}
