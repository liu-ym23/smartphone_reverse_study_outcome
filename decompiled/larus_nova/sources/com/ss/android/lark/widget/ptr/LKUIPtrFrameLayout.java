package com.ss.android.lark.widget.ptr;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.ptr.header.MaterialHeader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class LKUIPtrFrameLayout extends ViewGroup {
    public static boolean DEBUG = false;
    private static final boolean DEBUG_LAYOUT = false;
    public static final String FG_DISABLE_PTR_ADAPT_OPPO = "lark.widget.disable_ptr_adapt_oppo";
    private static byte FLAG_AUTO_REFRESH_AT_ONCE = 0;
    private static byte FLAG_AUTO_REFRESH_BUT_LATER = 0;
    private static byte FLAG_ENABLE_NEXT_PTR_AT_ONCE = 0;
    private static byte FLAG_PIN_CONTENT = 0;
    private static int ID = 0;
    private static byte MASK_AUTO_REFRESH = 0;
    public static final byte PTR_STATUS_COMPLETE = 4;
    public static final byte PTR_STATUS_INIT = 1;
    public static final byte PTR_STATUS_LOADING = 3;
    public static final byte PTR_STATUS_PREPARE = 2;
    public static boolean isDisablePtrAdaptOppoOS;
    protected final String LOG_TAG;
    private int mContainerId;
    protected View mContent;
    private boolean mDisableWhenHorizontalMove;
    private int mDurationToBackFooter;
    private int mDurationToBackHeader;
    private int mDurationToCloseFooter;
    private int mDurationToCloseHeader;
    private boolean mEnableScrollContentAfterLoad;
    private boolean mEnableScrollContentAfterRefresh;
    private int mFlag;
    private int mFooterHeight;
    private int mFooterId;
    private float mFooterShowTouchSlop;
    private View mFooterView;
    private boolean mForceBackWhenComplete;
    private boolean mHasSendCancelEvent;
    private int mHeaderHeight;
    private int mHeaderId;
    private View mHeaderView;
    private boolean mKeepHeaderWhenRefresh;
    private MotionEvent mLastMoveEvent;
    private int mLoadingMinTime;
    private long mLoadingStartTime;
    private Mode mMode;
    private int mPagingTouchSlop;
    private Runnable mPerformRefreshCompleteDelay;
    private boolean mPreventForHorizontal;
    private LKUIPtrHandler mPtrHandler;
    private wdc.a mPtrIndicator;
    private com.ss.android.lark.widget.ptr.b mPtrUIHandlerHolder;
    private boolean mPullToRefresh;
    private com.ss.android.lark.widget.ptr.c mRefreshCompleteHook;
    private c mScrollChecker;
    private byte mStatus;
    private float startYPosition;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int r100) {
            super(-1, r100);
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    public static final enum Mode extends Enum<Mode> {
        public static final Mode BOTH = null;
        public static final Mode LOAD_MORE = null;
        public static final Mode NONE = null;
        public static final Mode REFRESH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f448051a = null;

        static {
            Mode r100 = new Mode(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            Mode r101 = new Mode("REFRESH", 1);
            REFRESH = r101;
            Mode r102 = new Mode("LOAD_MORE", 2);
            LOAD_MORE = r102;
            Mode r103 = new Mode("BOTH", 3);
            BOTH = r103;
            f448051a = new Mode[]{r100, r101, r102, r103};
        }

        public static Mode[] values() {
            return (Mode[]) f448051a.clone();
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUIPtrFrameLayout f448052a;

        @Override // java.lang.Runnable
        public final void run() {
            LKUIPtrFrameLayout.access$000(this.f448052a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LKUIPtrFrameLayout r100) {
            this.f448052a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LKUIPtrFrameLayout f448053a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        L3:
            if (LKUIPtrFrameLayout.DEBUG == false) goto L5;
            Log.d(this.f448053a.LOG_TAG, "mRefreshCompleteHook resume.");     // Catch: Throwable -> L7
        L5:
            LKUIPtrFrameLayout.access$200(this.f448053a, true);     // Catch: Throwable -> L7
        }

        public b(LKUIPtrFrameLayout r100) {
            this.f448053a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f448054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Scroller f448055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f448056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f448057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f448058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LKUIPtrFrameLayout f448059f;

        public final void a() {
            if (this.f448055b.computeScrollOffset() == true) goto L5;
        L8:
            boolean r100 = true;
        L9:
            int r101 = this.f448055b.getCurrY();
            int r102 = r101 - this.f448054a;
            if (r102 != 0) goto L12;
        L15:
            boolean r103 = true;
        L16:
            if (r100 == false) goto L19;
            if (r103 == false) goto L19;
            boolean r104 = true;
        L21:
            if (LKUIPtrFrameLayout.DEBUG == false) goto L24;
            if (r102 == 0) goto L24;
            Log.d(this.f448059f.LOG_TAG, String.format("scroll: %s, start: %s, to: %s, currentPos: %s, current :%s, last: %s, delta: %s", new Object[]{Boolean.valueOf(r104), Integer.valueOf(this.f448057d), Integer.valueOf(this.f448058e), Integer.valueOf(LKUIPtrFrameLayout.access$400(this.f448059f).f559318e), Integer.valueOf(r101), Integer.valueOf(this.f448054a), Integer.valueOf(r102)}));
        L24:
            if (r104 == true) goto L31;
            this.f448054a = r101;
            if (LKUIPtrFrameLayout.access$400(this.f448059f).f559323j == false) goto L28;
            LKUIPtrFrameLayout.access$500(this.f448059f, r102);
        L29:
            this.f448059f.post(this);
            return;
        L28:
            LKUIPtrFrameLayout.access$600(this.f448059f, -r102);
            goto L29
        L31:
            if (LKUIPtrFrameLayout.DEBUG == false) goto L33;
            LKUIPtrFrameLayout r105 = this.f448059f;
            Log.d(r105.LOG_TAG, String.format("finish, currentPos:%s", new Object[]{Integer.valueOf(LKUIPtrFrameLayout.access$400(r105).f559318e)}));
        L33:
            this.f448056c = false;
            this.f448054a = 0;
            this.f448059f.removeCallbacks(this);
            this.f448059f.onPtrScrollFinish();
            return;
        L19:
            r104 = false;
            goto L21
        L12:
            if (LKUIPtrFrameLayout.isDisablePtrAdaptOppoOS == true) goto L15;
            r103 = false;
            goto L16
        L5:
            if (this.f448055b.isFinished() == true) goto L8;
            r100 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(LKUIPtrFrameLayout r100) {
            this.f448059f = r100;
            this.f448056c = false;
            this.f448055b = new Scroller(r100.getContext());
        }

        public final void b(int r110, int r111, boolean r112) {
            if (LKUIPtrFrameLayout.access$400(this.f448059f).f559318e != r110) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L8;
            return;
        L8:
            int r101 = LKUIPtrFrameLayout.access$400(this.f448059f).f559318e;
            this.f448057d = r101;
            this.f448058e = r110;
            int r102 = r110 - r101;
            if (LKUIPtrFrameLayout.DEBUG == false) goto L11;
            Log.d(this.f448059f.LOG_TAG, String.format("tryToScrollTo: start: %s, distance:%s, to:%s", new Object[]{Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r110)}));
        L11:
            this.f448059f.removeCallbacks(this);
            this.f448054a = 0;
            if (this.f448055b.isFinished() == true) goto L15;
            this.f448055b.forceFinished(true);
        L15:
            if (LKUIPtrFrameLayout.access$400(this.f448059f).f559323j == false) goto L19;
            if (LKUIPtrFrameLayout.access$700(this.f448059f) == false) goto L19;
        L22:
            boolean r113 = true;
        L24:
            LKUIPtrFrameLayout r103 = this.f448059f;
            View r104 = r103.mContent;
            if (r104 != null) goto L27;
        L33:
            boolean r105 = false;
        L34:
            if (r112 == false) goto L46;
            if (r113 == false) goto L46;
            if (r105 == false) goto L46;
            if (LKUIPtrFrameLayout.access$400(this.f448059f).f559323j == false) goto L40;
            LKUIPtrFrameLayout.access$500(this.f448059f, r102);
        L41:
            LKUIPtrFrameLayout r114 = this.f448059f;
            View r115 = r114.mContent;
            if (LKUIPtrFrameLayout.access$400(r114).f559323j == true) goto L45;
            r102 = -r102;
        L45:
            r115.scrollBy(0, r102);
            return;
        L40:
            LKUIPtrFrameLayout.access$600(this.f448059f, -r102);
        L46:
            if (r111 <= 0) goto L49;
            this.f448055b.startScroll(0, 0, 0, r102, r111);
            this.f448059f.post(this);
            this.f448056c = true;
            return;
        L49:
            if (LKUIPtrFrameLayout.access$400(this.f448059f).f559323j == false) goto L51;
            LKUIPtrFrameLayout.access$500(this.f448059f, r102);
        L52:
            this.f448056c = false;
            return;
        L51:
            LKUIPtrFrameLayout.access$600(this.f448059f, -r102);
            goto L52
        L27:
            if (LKUIPtrFrameLayout.access$400(r103).f559323j == false) goto L29;
            int r106 = 1;
        L31:
            if (r104.canScrollVertically(r106) == false) goto L33;
            r105 = true;
            goto L34
        L29:
            r106 = -1;
        L19:
            if (LKUIPtrFrameLayout.access$400(this.f448059f).f559323j == false) goto L21;
        L23:
            r113 = false;
            goto L24
        L21:
            if (LKUIPtrFrameLayout.access$800(this.f448059f) == false) goto L23;
        L5:
            r100 = false;
            goto L6
        }
    }

    private void onPositionChange(boolean r100, byte r101, wdc.a r102) {
    }

    private void performRefreshComplete() {
        this.mStatus = 4;
        if (this.mScrollChecker.f448056c == true) goto L5;
    L10:
        notifyUIRefreshComplete(false);
        return;
    L5:
        if (isAutoRefresh() == false) goto L10;
        if (DEBUG == false) goto L12;
        Log.d(this.LOG_TAG, String.format("performRefreshComplete do nothing, scrolling: %s, auto refresh: %s", new Object[]{Boolean.valueOf(this.mScrollChecker.f448056c), Integer.valueOf(this.mFlag)}));
        return;
    }

    private void tryScrollBackToTopAbortRefresh() {
        tryScrollBackToTop(false);
    }

    private void tryScrollBackToTopAfterComplete() {
        tryScrollBackToTop(true);
    }

    private void tryScrollBackToTopWhileLoading() {
        tryScrollBackToTop(true);
    }

    public void autoLoadMore() {
        autoRefresh(true, false);
    }

    public void autoRefresh() {
        autoRefresh(true, true);
    }

    public void setInterceptEventWhileWorking(boolean r100) {
    }

    private void clearFlag() {
        this.mFlag &= ~MASK_AUTO_REFRESH;
    }

    private void layoutChildren() {
        wdc.a r100 = this.mPtrIndicator;
        int r101 = 0;
        if (r100.f559323j == false) goto L5;
        int r102 = r100.f559318e;
        int r103 = 0;
    L6:
        int r104 = getPaddingLeft();
        int r105 = getPaddingTop();
        View r106 = this.mHeaderView;
        if (r106 == null) goto L9;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106.getLayoutParams();
        int r108 = r107.leftMargin + r104;
        int r109 = ((r107.topMargin + r105) + r102) - this.mHeaderHeight;
        int r110 = this.mHeaderView.getMeasuredWidth() + r108;
        int r111 = this.mHeaderView.getMeasuredHeight() + r109;
        this.mHeaderView.layout(r108, r109, r110, r111);
    L9:
        View r112 = this.mContent;
        if (r112 == null) goto L23;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112.getLayoutParams();
        if (this.mPtrIndicator.f559323j == false) goto L17;
        int r114 = r113.leftMargin + r104;
        int r115 = r113.topMargin + r105;
        if (isPinContent() == false) goto L16;
        r102 = 0;
    L16:
        int r116 = r115 + r102;
        int r117 = this.mContent.getMeasuredWidth() + r114;
        int r118 = this.mContent.getMeasuredHeight();
    L22:
        int r119 = r118 + r116;
        this.mContent.layout(r114, r116, r117, r119);
    L24:
        View r120 = this.mFooterView;
        if (r120 == null) goto L31;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120.getLayoutParams();
        int r122 = r104 + r121.leftMargin;
        int r123 = (r105 + r121.topMargin) + r119;
        if (isPinContent() == false) goto L29;
        r101 = r103;
    L29:
        int r124 = r123 - r101;
        int r125 = this.mFooterView.getMeasuredWidth() + r122;
        int r126 = this.mFooterView.getMeasuredHeight() + r124;
        this.mFooterView.layout(r122, r124, r125, r126);
        return;
    L31:
        return;
    L17:
        r114 = r104 + r113.leftMargin;
        int r127 = r113.topMargin + r105;
        if (isPinContent() == false) goto L20;
        int r128 = 0;
    L21:
        r116 = r127 - r128;
        r117 = this.mContent.getMeasuredWidth() + r114;
        r118 = this.mContent.getMeasuredHeight();
        goto L22
    L20:
        r128 = r103;
        goto L21
    L23:
        r119 = 0;
        goto L24
    L5:
        r103 = r100.f559318e;
        r102 = 0;
        goto L6
    }

    private boolean performAutoRefreshButLater() {
        if ((this.mFlag & MASK_AUTO_REFRESH) != FLAG_AUTO_REFRESH_BUT_LATER) goto L5;
        return true;
    L5:
        return false;
    }

    private void sendCancelEvent() {
        if (DEBUG == false) goto L5;
        Log.d(this.LOG_TAG, "send cancel event");
    L5:
        MotionEvent r100 = this.mLastMoveEvent;
        if (r100 != null) goto L8;
        return;
    L8:
        dispatchTouchEventSupper(MotionEvent.obtain(r100.getDownTime(), r100.getEventTime() + ((long) ViewConfiguration.getLongPressTimeout()), 3, r100.getX(), r100.getY(), r100.getMetaState()));
    }

    private void sendDownEvent() {
        if (DEBUG == false) goto L5;
        Log.d(this.LOG_TAG, "send down event");
    L5:
        MotionEvent r100 = this.mLastMoveEvent;
        if (r100 == null) goto L9;
        dispatchTouchEventSupper(MotionEvent.obtain(r100.getDownTime(), r100.getEventTime(), 0, r100.getX(), r100.getY(), r100.getMetaState()));
        return;
    }

    private boolean tryToNotifyReset() {
        byte r100 = this.mStatus;
        if (r100 == 4) goto L7;
        if (r100 == 2) goto L7;
    L18:
        return false;
    L7:
        if (this.mPtrIndicator.f559318e != 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L18;
        if (this.mPtrUIHandlerHolder.f() == false) goto L16;
        this.mPtrUIHandlerHolder.b(this);
        if (DEBUG == false) goto L16;
        Log.i(this.LOG_TAG, "LKUIPtrUIHandler: onUIReset");
    L16:
        this.mStatus = 1;
        clearFlag();
        return true;
    L9:
        r101 = false;
        goto L10
    }

    private boolean tryToPerformRefresh() {
        if (this.mStatus == 2) goto L5;
        return false;
    L5:
        wdc.a r100 = this.mPtrIndicator;
        boolean r101 = true;
        if (r100.f559318e <= r100.a()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
    L12:
        wdc.a r103 = this.mPtrIndicator;
        if (r103.f559318e >= r103.f559314a) goto L16;
        r101 = false;
    L16:
        if (r101 == false) goto L18;
    L17:
        this.mStatus = 3;
        performRefresh();
    L18:
        return false;
    L11:
        if (isAutoRefresh() == true) goto L17;
    L8:
        r102 = false;
        goto L9
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1);
    }

    public float getDurationToClose() {
        return this.mDurationToCloseHeader;
    }

    public long getDurationToCloseFooter() {
        return this.mDurationToCloseFooter;
    }

    public long getDurationToCloseHeader() {
        return this.mDurationToCloseHeader;
    }

    public int getOffsetToKeepHeaderWhileLoading() {
        return this.mPtrIndicator.a();
    }

    public int getOffsetToRefresh() {
        return this.mPtrIndicator.f559314a;
    }

    public float getRatioOfHeaderToHeightRefresh() {
        return this.mPtrIndicator.f559324k;
    }

    public float getResistanceFooter() {
        return this.mPtrIndicator.f559326m;
    }

    public float getResistanceHeader() {
        return this.mPtrIndicator.f559325l;
    }

    public boolean isAutoRefresh() {
        if ((this.mFlag & MASK_AUTO_REFRESH) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnabledNextPtrAtOnce() {
        if ((this.mFlag & FLAG_ENABLE_NEXT_PTR_AT_ONCE) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPinContent() {
        if ((this.mFlag & FLAG_PIN_CONTENT) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRefreshing() {
        if (this.mStatus != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public void onPtrScrollAbort() {
        if (this.mPtrIndicator.b() == true) goto L5;
        return;
    L5:
        if (isAutoRefresh() == true) goto L7;
        return;
    L7:
        if (DEBUG == false) goto L9;
        Log.d(this.LOG_TAG, "call onRelease after scroll abort");
    L9:
        onRelease(true);
    }

    public void onPtrScrollFinish() {
        if (this.mPtrIndicator.b() == true) goto L5;
        return;
    L5:
        if (isAutoRefresh() == true) goto L7;
        return;
    L7:
        if (DEBUG == false) goto L9;
        Log.d(this.LOG_TAG, "call onRelease after scroll finish");
    L9:
        onRelease(true);
    }

    public final void refreshComplete() {
        if (DEBUG == false) goto L5;
        Log.i(this.LOG_TAG, "refreshComplete");
    L5:
        com.ss.android.lark.widget.ptr.c r100 = this.mRefreshCompleteHook;
        if (r100 == null) goto L8;
        r100.f448063b = 0;
    L8:
        int r101 = (int) (((long) this.mLoadingMinTime) - (System.currentTimeMillis() - this.mLoadingStartTime));
        if (r101 <= 0) goto L11;
        postDelayed(this.mPerformRefreshCompleteDelay, r101);
        if (DEBUG == false) goto L19;
        Log.d(this.LOG_TAG, String.format("performRefreshComplete after delay: %s", new Object[]{Integer.valueOf(r101)}));
        return;
    L19:
        return;
    L11:
        if (DEBUG == false) goto L13;
        Log.d(this.LOG_TAG, "performRefreshComplete at once");
    L13:
        performRefreshComplete();
    }

    static {
        isDisablePtrAdaptOppoOS = FeatureGatingModule.getFeatureGatingService().isEnable(FG_DISABLE_PTR_ADAPT_OPPO);
        DEBUG = false;
        ID = 1;
        FLAG_AUTO_REFRESH_AT_ONCE = 1;
        FLAG_AUTO_REFRESH_BUT_LATER = 2;
        FLAG_ENABLE_NEXT_PTR_AT_ONCE = 4;
        FLAG_PIN_CONTENT = 8;
        MASK_AUTO_REFRESH = 3;
    }

    private void performRefresh() {
        this.mLoadingStartTime = System.currentTimeMillis();
        if (this.mPtrUIHandlerHolder.f() == false) goto L7;
        this.mPtrUIHandlerHolder.e(this);
        if (DEBUG == false) goto L7;
        Log.i(this.LOG_TAG, "LKUIPtrUIHandler: onUIRefreshBegin");
    L7:
        LKUIPtrHandler r100 = this.mPtrHandler;
        if (r100 != null) goto L10;
        return;
    L10:
        if (this.mPtrIndicator.f559323j == false) goto L13;
        r100.onRefreshBegin(this);
        return;
    L13:
        if ((r100 instanceof LKUIPtrHandler2) == false) goto L18;
        ((LKUIPtrHandler2) r100).onLoadMoreBegin(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r100 = this.mScrollChecker;
        if (r100 == null) goto L7;
        r100.f448056c = false;
        r100.f448054a = 0;
        r100.f448059f.removeCallbacks(r100);
        if (r100.f448055b.isFinished() == true) goto L7;
        r100.f448055b.forceFinished(true);
    L7:
        Runnable r101 = this.mPerformRefreshCompleteDelay;
        if (r101 == null) goto L11;
        removeCallbacks(r101);
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int r100 = getChildCount();
        if (r100 > 3) goto L110;
        if (r100 != 3) goto L58;
        int r101 = this.mHeaderId;
        if (r101 != 0) goto L9;
    L11:
        int r102 = this.mContainerId;
        if (r102 != 0) goto L14;
    L16:
        int r103 = this.mFooterId;
        if (r103 == 0) goto L22;
        if (this.mFooterView != null) goto L22;
        this.mFooterView = findViewById(r103);
    L22:
        if (this.mContent != null) goto L24;
    L27:
        final View r104 = getChildAt(0);
        final View r105 = getChildAt(1);
        final View r110 = getChildAt(2);
        if (this.mContent == null) goto L30;
    L34:
        final int r106 = 3;
        ArrayList<View> r107 = new AnonymousClass2(this, r106, r104, r105, r110);
        View r108 = this.mHeaderView;
        if (r108 == null) goto L37;
        r107.remove(r108);
    L37:
        View r109 = this.mContent;
        if (r109 == null) goto L40;
        r107.remove(r109);
    L40:
        View r111 = this.mFooterView;
        if (r111 == null) goto L44;
        r107.remove(r111);
    L44:
        if (this.mHeaderView != null) goto L49;
        if (r107.size() <= 0) goto L49;
        this.mHeaderView = (View) ListProtector.get(r107, 0);
        ListProtector.remove(r107, 0);
    L49:
        if (this.mContent != null) goto L54;
        if (r107.size() <= 0) goto L54;
        this.mContent = (View) ListProtector.get(r107, 0);
        ListProtector.remove(r107, 0);
    L54:
        if (this.mFooterView == null) goto L56;
    L95:
        KeyEvent.Callback r112 = this.mHeaderView;
        if (r112 != null) goto L98;
    L101:
        KeyEvent.Callback r113 = this.mFooterView;
        if (r113 != null) goto L104;
    L107:
        super.onFinishInflate();
        return;
    L104:
        if ((r113 instanceof com.ss.android.lark.widget.ptr.a) == false) goto L106;
        addPtrUIHandler((com.ss.android.lark.widget.ptr.a) r113);
    L106:
        this.mFooterView.bringToFront();
        goto L107
    L98:
        if ((r112 instanceof com.ss.android.lark.widget.ptr.a) == false) goto L100;
        addPtrUIHandler((com.ss.android.lark.widget.ptr.a) r112);
    L100:
        this.mHeaderView.bringToFront();
        goto L101
    L56:
        if (r107.size() <= 0) goto L95;
        this.mFooterView = (View) ListProtector.get(r107, 0);
        ListProtector.remove(r107, 0);
        goto L95
    L30:
        if (this.mHeaderView != null) goto L34;
        if (this.mFooterView != null) goto L34;
        this.mHeaderView = r104;
        this.mContent = r105;
        this.mFooterView = r110;
        goto L95
    L24:
        if (this.mHeaderView == null) goto L27;
        if (this.mFooterView != null) goto L95;
    L14:
        if (this.mContent != null) goto L16;
        this.mContent = findViewById(r102);
        goto L16
    L9:
        if (this.mHeaderView != null) goto L11;
        this.mHeaderView = findViewById(r101);
        goto L11
    L58:
        if (r100 != 2) goto L92;
        int r114 = this.mHeaderId;
        if (r114 != 0) goto L62;
    L64:
        int r115 = this.mContainerId;
        if (r115 == 0) goto L70;
        if (this.mContent != null) goto L70;
        this.mContent = findViewById(r115);
    L70:
        if (this.mContent != null) goto L72;
    L73:
        View r116 = getChildAt(0);
        View r117 = getChildAt(1);
        if ((r116 instanceof com.ss.android.lark.widget.ptr.a) == false) goto L77;
        this.mHeaderView = r116;
        this.mContent = r117;
        goto L95
    L77:
        if ((r117 instanceof com.ss.android.lark.widget.ptr.a) == false) goto L79;
        this.mHeaderView = r117;
        this.mContent = r116;
        goto L95
    L79:
        View r118 = this.mContent;
        if (r118 == null) goto L82;
    L84:
        View r119 = this.mHeaderView;
        if (r119 != null) goto L89;
        if (r118 != r116) goto L88;
        r116 = r117;
    L88:
        this.mHeaderView = r116;
        goto L95
    L89:
        if (r119 != r116) goto L91;
        r116 = r117;
    L91:
        this.mContent = r116;
        goto L95
    L82:
        if (this.mHeaderView != null) goto L84;
        this.mHeaderView = r116;
        this.mContent = r117;
        goto L95
    L72:
        if (this.mHeaderView != null) goto L95;
    L62:
        if (this.mHeaderView != null) goto L64;
        this.mHeaderView = findViewById(r114);
        goto L64
    L92:
        if (r100 != 1) goto L94;
        this.mContent = getChildAt(0);
        goto L95
    L94:
        TextView r120 = new TextView(getContext());
        r120.setClickable(true);
        r120.setTextColor(-39424);
        r120.setGravity(17);
        r120.setTextSize(20.0f);
        r120.setText("The content view in PtrFrameLayout is empty. Do you forget to specify its id in xml layout file?");
        this.mContent = r120;
        addView(r120);
        goto L95
    L110:
        throw new IllegalStateException("PtrFrameLayout only can host 3 elements");
    }

    public View getContentView() {
        return this.mContent;
    }

    public int getDurationToBackFooter() {
        return this.mDurationToBackFooter;
    }

    public int getDurationToBackHeader() {
        return this.mDurationToBackHeader;
    }

    public int getFooterHeight() {
        return this.mFooterHeight;
    }

    public int getHeaderHeight() {
        return this.mHeaderHeight;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public Mode getMode() {
        return this.mMode;
    }

    public boolean isForceBackWhenComplete() {
        return this.mForceBackWhenComplete;
    }

    public boolean isKeepHeaderWhenRefresh() {
        return this.mKeepHeaderWhenRefresh;
    }

    public boolean isPullToRefresh() {
        return this.mPullToRefresh;
    }

    public LKUIPtrFrameLayout(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ void access$000(LKUIPtrFrameLayout r100) {
        r100.performRefreshComplete();
    }

    public static /* synthetic */ wdc.a access$400(LKUIPtrFrameLayout r100) {
        return r100.mPtrIndicator;
    }

    public static /* synthetic */ boolean access$700(LKUIPtrFrameLayout r100) {
        return r100.mEnableScrollContentAfterRefresh;
    }

    public static /* synthetic */ boolean access$800(LKUIPtrFrameLayout r100) {
        return r100.mEnableScrollContentAfterLoad;
    }

    private Mode getModeFromIndex(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return Mode.BOTH;
    L12:
        return Mode.BOTH;
    L14:
        return Mode.LOAD_MORE;
    L16:
        return Mode.REFRESH;
    L18:
        return Mode.NONE;
    }

    private void moveFooterPos(float r100) {
        this.mPtrIndicator.f559323j = false;
        movePos(-r100);
    }

    private void moveHeaderPos(float r100) {
        this.mPtrIndicator.f559323j = true;
        movePos(r100);
    }

    private void movePos(float r100) {
        boolean r101 = true;
        int r102 = 0;
        if (r100 < 0.0f) goto L5;
    L13:
        int r103 = this.mPtrIndicator.f559318e + ((int) r100);
        if (r103 < 0) goto L17;
        r101 = false;
    L17:
        if (r101 == true) goto L19;
        r102 = r103;
    L22:
        wdc.a r104 = this.mPtrIndicator;
        int r105 = r104.f559318e;
        r104.f559319f = r105;
        r104.f559318e = r102;
        int r106 = r102 - r105;
        if (r104.f559323j == true) goto L26;
        r106 = -r106;
    L26:
        updatePos(r106);
        return;
    L19:
        if (DEBUG == false) goto L22;
        Log.e(this.LOG_TAG, String.format("over top", new Object[0]));
        goto L22
    L5:
        if (this.mPtrIndicator.f559318e != 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L13;
        if (DEBUG == false) goto L28;
        Log.e(this.LOG_TAG, String.format("has reached the top", new Object[0]));
        return;
    L28:
        return;
    L7:
        r107 = false;
        goto L8
    }

    private void notifyUIRefreshComplete(boolean r100) {
        if (this.mPtrIndicator.b() == false) goto L22;
        if (r100 == true) goto L22;
        if (this.mRefreshCompleteHook == null) goto L22;
        if (DEBUG == false) goto L10;
        Log.d(this.LOG_TAG, "notifyUIRefreshComplete mRefreshCompleteHook run.");
    L10:
        com.ss.android.lark.widget.ptr.c r101 = this.mRefreshCompleteHook;
        byte r102 = r101.f448063b;
        if (r102 != 0) goto L13;
        r101.f448063b = 1;
        ((MaterialHeader.b) r101).run();
        return;
    L13:
        if (r102 != 2) goto L30;
        Runnable r103 = r101.f448062a;
        if (r103 == null) goto L18;
        r103.run();
    L18:
        r101.f448063b = 2;
        return;
    L30:
        return;
    L22:
        if (this.mPtrUIHandlerHolder.f() == true) goto L24;
    L27:
        wdc.a r104 = this.mPtrIndicator;
        r104.f559329p = r104.f559318e;
        tryScrollBackToTopAfterComplete();
        tryToNotifyReset();
        return;
    L24:
        if (DEBUG == false) goto L26;
        Log.i(this.LOG_TAG, "LKUIPtrUIHandler: onUIRefreshComplete");
    L26:
        this.mPtrUIHandlerHolder.a(this, this.mPtrIndicator.f559323j);
        goto L27
    }

    private void onRelease(boolean r100) {
        tryToPerformRefresh();
        byte r101 = this.mStatus;
        if (r101 != 3) goto L18;
        if (this.mKeepHeaderWhenRefresh == false) goto L16;
        wdc.a r102 = this.mPtrIndicator;
        if (r102.f559318e <= r102.a()) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L22;
        if (r100 == true) goto L23;
        wdc.a r104 = this.mPtrIndicator;
        if (r104.f559323j == false) goto L15;
        this.mScrollChecker.b(r104.a(), this.mDurationToBackHeader, false);
        return;
    L15:
        this.mScrollChecker.b(r104.a(), this.mDurationToBackFooter, false);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r103 = false;
        goto L10
    L16:
        tryScrollBackToTopWhileLoading();
        return;
    L18:
        if (r101 != 4) goto L20;
        notifyUIRefreshComplete(false);
        return;
    L20:
        tryScrollBackToTopAbortRefresh();
    }

    private void tryScrollBackToTop(boolean r100) {
        wdc.a r101 = this.mPtrIndicator;
        if (r101.f559327n == true) goto L13;
        if (r101.b() == false) goto L13;
        c r102 = this.mScrollChecker;
        if (this.mPtrIndicator.f559323j == false) goto L9;
        int r103 = this.mDurationToCloseHeader;
    L10:
        r102.b(0, r103, r100);
        return;
    L9:
        r103 = this.mDurationToCloseFooter;
    L13:
        if (this.mForceBackWhenComplete == true) goto L15;
        return;
    L15:
        if (this.mPtrIndicator.f559323j == false) goto L17;
        return;
    L17:
        if (this.mStatus != 4) goto L22;
        this.mScrollChecker.b(0, this.mDurationToCloseFooter, r100);
        return;
    }

    private void updatePos(int r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        wdc.a r101 = this.mPtrIndicator;
        boolean r102 = r101.f559327n;
        if (r102 == true) goto L7;
    L14:
        wdc.a r103 = this.mPtrIndicator;
        if (r103.f559319f == 0) goto L17;
    L19:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L23;
    L24:
        wdc.a r105 = this.mPtrIndicator;
        if (r105.f559318e < r105.f559329p) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == true) goto L30;
    L36:
        wdc.a r107 = this.mPtrIndicator;
        if (r107.f559319f != 0) goto L39;
    L44:
        boolean r108 = false;
    L45:
        if (r108 == false) goto L50;
        tryToNotifyReset();
        if (r102 == false) goto L50;
        sendDownEvent();
    L50:
        if (this.mStatus != 2) goto L75;
        if (r102 == false) goto L65;
        if (isAutoRefresh() == true) goto L65;
        if (this.mPullToRefresh == false) goto L65;
        wdc.a r109 = this.mPtrIndicator;
        int r110 = r109.f559319f;
        int r111 = r109.f559314a;
        if (r110 < r111) goto L59;
    L61:
        boolean r112 = false;
    L62:
        if (r112 == false) goto L65;
        tryToPerformRefresh();
        goto L65
    L59:
        if (r109.f559318e < r111) goto L61;
        r112 = true;
    L65:
        if (performAutoRefreshButLater() == false) goto L75;
        wdc.a r113 = this.mPtrIndicator;
        int r114 = r113.f559319f;
        int r115 = r113.f559320g;
        if (r114 < r115) goto L69;
    L71:
        boolean r116 = false;
    L72:
        if (r116 == false) goto L75;
        tryToPerformRefresh();
        goto L75
    L69:
        if (r113.f559318e < r115) goto L71;
        r116 = true;
    L75:
        if (DEBUG == false) goto L78;
        Log.d(this.LOG_TAG, String.format("updatePos: change: %s, current: %s last: %s, top: %s, headerHeight: %s", new Object[]{Integer.valueOf(r100), Integer.valueOf(this.mPtrIndicator.f559318e), Integer.valueOf(this.mPtrIndicator.f559319f), Integer.valueOf(this.mContent.getTop()), Integer.valueOf(this.mHeaderHeight)}));
    L78:
        if (this.mPtrIndicator.f559323j == false) goto L80;
        this.mHeaderView.offsetTopAndBottom(r100);
    L82:
        if (isPinContent() == true) goto L84;
        this.mContent.offsetTopAndBottom(r100);
    L84:
        invalidate();
        if (this.mPtrUIHandlerHolder.f() == false) goto L87;
        this.mPtrUIHandlerHolder.c(this, r102, this.mStatus, this.mPtrIndicator);
    L87:
        onPositionChange(r102, this.mStatus, this.mPtrIndicator);
        return;
    L80:
        this.mFooterView.offsetTopAndBottom(r100);
        goto L82
    L39:
        if (r107.f559318e != 0) goto L41;
        boolean r117 = true;
    L42:
        if (r117 == false) goto L44;
        r108 = true;
        goto L45
    L41:
        r117 = false;
        goto L42
    L30:
        if (this.mStatus != 4) goto L36;
        if (isEnabledNextPtrAtOnce() == false) goto L36;
    L33:
        this.mStatus = 2;
        this.mPtrUIHandlerHolder.d(this);
        if (DEBUG == false) goto L36;
        Log.i(this.LOG_TAG, String.format("LKUIPtrUIHandler: onUIRefreshPrepare, mFlag %s", new Object[]{Integer.valueOf(this.mFlag)}));
        goto L36
    L27:
        r106 = false;
        goto L28
    L23:
        if (this.mStatus == 1) goto L33;
    L17:
        if (r103.b() == false) goto L19;
        r104 = true;
        goto L21
    L7:
        if (this.mHasSendCancelEvent == true) goto L14;
        if (r101.f559318e == r101.f559322i) goto L11;
        boolean r118 = true;
    L12:
        if (r118 == false) goto L14;
        this.mHasSendCancelEvent = true;
        sendCancelEvent();
        goto L14
    L11:
        r118 = false;
        goto L12
    }

    public void addPtrUIHandler(com.ss.android.lark.widget.ptr.a r100) {
        com.ss.android.lark.widget.ptr.b r101 = this.mPtrUIHandlerHolder;
        if (r100 == null) goto L25;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.f448060a != null) goto L10;
        r101.f448060a = r100;
        return;
    L10:
        com.ss.android.lark.widget.ptr.a r102 = r101.f448060a;
        if (r102 == null) goto L14;
        if (r102 != r100) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L27;
        com.ss.android.lark.widget.ptr.b r104 = r101.f448061b;
        if (r104 == null) goto L19;
        r101 = r104;
        goto L10
    L19:
        com.ss.android.lark.widget.ptr.b r105 = new com.ss.android.lark.widget.ptr.b();
        r105.f448060a = r100;
        r101.f448061b = r105;
        return;
    L27:
        return;
    L14:
        r103 = false;
        goto L15
    }

    public void autoLoadMore(boolean r100) {
        autoRefresh(r100, false);
    }

    public void autoRefresh(boolean r100) {
        autoRefresh(r100, true);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r100 instanceof LayoutParams) == false) goto L6;
        return true;
    }

    public void disableWhenHorizontalMove(boolean r100) {
        this.mDisableWhenHorizontalMove = r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r110) {
        if (isEnabled() == false) goto L148;
        if (this.mContent == null) goto L148;
        if (this.mHeaderView == null) goto L148;
        int r100 = r110.getAction();
        boolean r101 = false;
        if (r100 == 0) goto L122;
        if (r100 != 1) goto L13;
    L107:
        wdc.a r102 = this.mPtrIndicator;
        r102.f559327n = false;
        if (r102.b() == false) goto L121;
        if (DEBUG == false) goto L112;
        Log.d(this.LOG_TAG, "call onRelease when user release");
    L112:
        onRelease(false);
        wdc.a r103 = this.mPtrIndicator;
        if (r103.f559318e == r103.f559322i) goto L115;
        r101 = true;
    L115:
        if (r101 == false) goto L119;
        sendCancelEvent();
        return true;
    L119:
        return dispatchTouchEventSupper(r110);
    L121:
        return dispatchTouchEventSupper(r110);
    L13:
        if (r100 == 2) goto L16;
        if (r100 == 3) goto L107;
    L106:
        return dispatchTouchEventSupper(r110);
    L16:
        this.mLastMoveEvent = r110;
        wdc.a r104 = this.mPtrIndicator;
        float r105 = r110.getX();
        float r106 = r110.getY();
        PointF r111 = r104.f559315b;
        float r112 = r105 - r111.x;
        float r113 = (r106 - r111.y) / r104.f559325l;
        r104.f559316c = r112;
        r104.f559317d = r113;
        r111.set(r105, r106);
        wdc.a r107 = this.mPtrIndicator;
        float r108 = r107.f559316c;
        float r109 = r107.f559317d;
        if (this.mDisableWhenHorizontalMove == false) goto L31;
        if (this.mPreventForHorizontal == true) goto L31;
        if (Math.abs(r108) <= this.mPagingTouchSlop) goto L31;
        if (Math.abs(r108) <= Math.abs(r109)) goto L31;
        if (this.mPtrIndicator.f559318e != 0) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L31;
        this.mPreventForHorizontal = true;
        goto L31
    L27:
        r114 = false;
    L31:
        if (this.mPreventForHorizontal == false) goto L35;
        return dispatchTouchEventSupper(r110);
    L35:
        if (r109 <= 0.0f) goto L37;
        boolean r115 = true;
    L38:
        boolean r116 = !r115;
        wdc.a r117 = this.mPtrIndicator;
        if (r117.f559323j == true) goto L41;
    L43:
        boolean r118 = false;
    L45:
        if (this.mFooterView == null) goto L51;
        wdc.a r119 = this.mPtrIndicator;
        if (r119.f559323j == true) goto L51;
        if (r119.b() == false) goto L51;
        boolean r120 = true;
    L52:
        LKUIPtrHandler r121 = this.mPtrHandler;
        if (r121 != null) goto L55;
    L59:
        boolean r122 = false;
    L60:
        LKUIPtrHandler r123 = this.mPtrHandler;
        if (r123 == null) goto L71;
        View r124 = this.mFooterView;
        if (r124 == null) goto L71;
        if ((r123 instanceof LKUIPtrHandler2) == false) goto L71;
        if (((LKUIPtrHandler2) r123).checkCanDoLoadMore(this, this.mContent, r124) == false) goto L71;
        if ((this.mMode.ordinal() & 2) <= 0) goto L71;
        boolean r125 = true;
    L73:
        if (DEBUG == false) goto L75;
        Log.d(this.LOG_TAG, String.format("ACTION_MOVE: offsetY:%s, currentPos: %s, moveUp: %s, canMoveUp: %s, moveDown: %s: canMoveDown: %s canHeaderMoveDown: %s canFooterMoveUp: %s", new Object[]{Float.valueOf(r109), Integer.valueOf(this.mPtrIndicator.f559318e), Boolean.valueOf(r116), Boolean.valueOf(r118), Boolean.valueOf(r115), Boolean.valueOf(r120), Boolean.valueOf(r122), Boolean.valueOf(r125)}));
    L75:
        if (r118 == true) goto L93;
        if (r120 == true) goto L93;
        if (r115 == false) goto L81;
        if (r122 == true) goto L81;
        return dispatchTouchEventSupper(r110);
    L81:
        if (r116 == false) goto L85;
        if (r125 == true) goto L85;
        return dispatchTouchEventSupper(r110);
    L85:
        if (r115 == false) goto L88;
        moveHeaderPos(r109);
        return true;
    L88:
        if (r116 == false) goto L93;
        if (Math.abs(r110.getY() - this.startYPosition) <= UIUtils.dp2px(getContext(), this.mFooterShowTouchSlop)) goto L93;
        moveFooterPos(r109);
        return true;
    L93:
        if (r118 == false) goto L96;
        moveHeaderPos(r109);
        return true;
    L96:
        if (r120 == false) goto L106;
        if (this.mForceBackWhenComplete == true) goto L100;
    L103:
        moveFooterPos(r109);
        return true;
    L100:
        if (this.mStatus != 4) goto L103;
        return dispatchTouchEventSupper(r110);
    L71:
        r125 = false;
        goto L73
    L55:
        if (r121.checkCanDoRefresh(this, this.mContent, this.mHeaderView) == false) goto L59;
        if ((this.mMode.ordinal() & 1) <= 0) goto L59;
        r122 = true;
    L51:
        r120 = false;
        goto L52
    L41:
        if (r117.b() == false) goto L43;
        r118 = true;
        goto L45
    L37:
        r115 = false;
        goto L38
    L122:
        this.mHasSendCancelEvent = false;
        this.startYPosition = r110.getY();
        wdc.a r126 = this.mPtrIndicator;
        float r127 = r110.getX();
        float r128 = r110.getY();
        r126.f559327n = true;
        r126.f559322i = r126.f559318e;
        r126.f559315b.set(r127, r128);
        if (this.mForceBackWhenComplete == true) goto L130;
        c r129 = this.mScrollChecker;
        if (r129.f448056c == true) goto L127;
    L145:
        this.mPreventForHorizontal = false;
        dispatchTouchEventSupper(r110);
        return true;
    L127:
        if (r129.f448055b.isFinished() == true) goto L129;
        r129.f448055b.forceFinished(true);
    L129:
        r129.f448059f.onPtrScrollAbort();
        r129.f448056c = false;
        r129.f448054a = 0;
        r129.f448059f.removeCallbacks(r129);
        goto L145
    L130:
        wdc.a r130 = this.mPtrIndicator;
        if (r130.f559323j == false) goto L133;
    L135:
        boolean r131 = false;
    L136:
        if (r131 == true) goto L138;
    L139:
        c r132 = this.mScrollChecker;
        if (r132.f448056c == false) goto L145;
        if (r132.f448055b.isFinished() == true) goto L144;
        r132.f448055b.forceFinished(true);
    L144:
        r132.f448059f.onPtrScrollAbort();
        r132.f448056c = false;
        r132.f448054a = 0;
        r132.f448059f.removeCallbacks(r132);
        goto L145
    L138:
        if (this.mStatus == 4) goto L145;
    L133:
        if (r130.b() == false) goto L135;
        r131 = true;
    L148:
        return dispatchTouchEventSupper(r110);
    }

    public boolean dispatchTouchEventSupper(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public void removePtrUIHandler(com.ss.android.lark.widget.ptr.a r100) {
        com.ss.android.lark.widget.ptr.b r101 = this.mPtrUIHandlerHolder;
        if (r101 == null) goto L23;
        if (r100 == null) goto L23;
        if (r101.f448060a == null) goto L23;
        com.ss.android.lark.widget.ptr.b r102 = r101;
        com.ss.android.lark.widget.ptr.b r103 = null;
    L9:
        com.ss.android.lark.widget.ptr.a r104 = r101.f448060a;
        if (r104 == null) goto L13;
        if (r104 != r100) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L18;
        if (r103 != null) goto L17;
        r102 = r101.f448061b;
        r101.f448061b = null;
        r101 = r102;
    L19:
        if (r101 != null) goto L9;
        if (r102 != null) goto L22;
        r101 = new com.ss.android.lark.widget.ptr.b();
        goto L23
    L22:
        r101 = r102;
        goto L23
    L17:
        r103.f448061b = r101.f448061b;
        r101.f448061b = null;
        r101 = r103.f448061b;
        goto L19
    L18:
        r103 = r101;
        r101 = r101.f448061b;
    L13:
        r105 = false;
    L23:
        this.mPtrUIHandlerHolder = r101;
    }

    public void setDurationToBack(int r100) {
        setDurationToBackHeader(r100);
        setDurationToBackFooter(r100);
    }

    public void setDurationToBackFooter(int r100) {
        this.mDurationToBackFooter = r100;
    }

    public void setDurationToBackHeader(int r100) {
        this.mDurationToBackHeader = r100;
    }

    public void setDurationToClose(int r100) {
        setDurationToCloseHeader(r100);
        setDurationToCloseFooter(r100);
    }

    public void setDurationToCloseFooter(int r100) {
        this.mDurationToCloseFooter = r100;
    }

    public void setDurationToCloseHeader(int r100) {
        this.mDurationToCloseHeader = r100;
    }

    public void setEnableScrollContentAfterLoad(boolean r100) {
        this.mEnableScrollContentAfterLoad = r100;
    }

    public void setEnableScrollContentAfterRefresh(boolean r100) {
        this.mEnableScrollContentAfterRefresh = r100;
    }

    public void setEnabledNextPtrAtOnce(boolean r100) {
        if (r100 == false) goto L4;
        this.mFlag |= FLAG_ENABLE_NEXT_PTR_AT_ONCE;
        return;
    L4:
        this.mFlag &= ~FLAG_ENABLE_NEXT_PTR_AT_ONCE;
    }

    public void setFooterShowTouchSlop(float r100) {
        this.mFooterShowTouchSlop = r100;
    }

    public void setFooterView(View r100) {
        View r101 = this.mFooterView;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (r101 == r100) goto L8;
        removeView(r101);
    L8:
        if (r100.getLayoutParams() != null) goto L10;
        r100.setLayoutParams(new LayoutParams(-2));
    L10:
        this.mFooterView = r100;
        addView(r100);
    }

    public void setForceBackWhenComplete(boolean r100) {
        this.mForceBackWhenComplete = r100;
    }

    public void setHeaderView(View r100) {
        View r101 = this.mHeaderView;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (r101 == r100) goto L8;
        removeView(r101);
    L8:
        if (r100.getLayoutParams() != null) goto L10;
        r100.setLayoutParams(new LayoutParams(-2));
    L10:
        this.mHeaderView = r100;
        addView(r100);
    }

    public void setKeepHeaderWhenRefresh(boolean r100) {
        this.mKeepHeaderWhenRefresh = r100;
    }

    public void setLoadingMinTime(int r100) {
        this.mLoadingMinTime = r100;
    }

    public void setMode(Mode r100) {
        this.mMode = r100;
    }

    public void setOffsetToKeepHeaderWhileLoading(int r100) {
        this.mPtrIndicator.f559328o = r100;
    }

    public void setOffsetToRefresh(int r100) {
        wdc.a r101 = this.mPtrIndicator;
        r101.f559324k = (r101.f559320g * 1.0f) / r100;
        r101.f559314a = r100;
    }

    public void setPinContent(boolean r100) {
        if (r100 == false) goto L4;
        this.mFlag |= FLAG_PIN_CONTENT;
        return;
    L4:
        this.mFlag &= ~FLAG_PIN_CONTENT;
    }

    public void setPtrHandler(LKUIPtrHandler r100) {
        this.mPtrHandler = r100;
    }

    public void setPtrIndicator(wdc.a r100) {
        wdc.a r101 = this.mPtrIndicator;
        if (r101 == null) goto L6;
        if (r101 == r100) goto L6;
        r100.getClass();
        r100.f559318e = r101.f559318e;
        r100.f559319f = r101.f559319f;
        r100.f559320g = r101.f559320g;
    L6:
        this.mPtrIndicator = r100;
    }

    public void setPullToRefresh(boolean r100) {
        this.mPullToRefresh = r100;
    }

    public void setRatioOfHeaderHeightToRefresh(float r100) {
        wdc.a r101 = this.mPtrIndicator;
        r101.f559324k = r100;
        r101.f559314a = (int) (r101.f559320g * r100);
    }

    public void setRefreshCompleteHook(com.ss.android.lark.widget.ptr.c r100) {
        this.mRefreshCompleteHook = r100;
        r100.f448062a = new b(this);
    }

    public void setResistance(float r100) {
        setResistanceHeader(r100);
        setResistanceFooter(r100);
    }

    public void setResistanceFooter(float r100) {
        this.mPtrIndicator.f559326m = r100;
    }

    public void setResistanceHeader(float r100) {
        this.mPtrIndicator.f559325l = r100;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new LayoutParams(r100);
    }

    public LKUIPtrFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ void access$200(LKUIPtrFrameLayout r100, boolean r101) {
        r100.notifyUIRefreshComplete(r101);
    }

    public static /* synthetic */ void access$500(LKUIPtrFrameLayout r100, float r101) {
        r100.moveHeaderPos(r101);
    }

    public static /* synthetic */ void access$600(LKUIPtrFrameLayout r100, float r101) {
        r100.moveFooterPos(r101);
    }

    public void autoRefresh(boolean r100, boolean r101) {
        if (this.mStatus == 1) goto L5;
        return;
    L5:
        int r102 = this.mFlag;
        if (r100 == false) goto L8;
        byte r103 = FLAG_AUTO_REFRESH_AT_ONCE;
    L9:
        this.mFlag = r102 | r103;
        this.mStatus = 2;
        if (this.mPtrUIHandlerHolder.f() == false) goto L14;
        this.mPtrUIHandlerHolder.d(this);
        if (DEBUG == false) goto L14;
        Log.i(this.LOG_TAG, String.format("LKUIPtrUIHandler: onUIRefreshPrepare, mFlag %s", new Object[]{Integer.valueOf(this.mFlag)}));
    L14:
        wdc.a r104 = this.mPtrIndicator;
        r104.f559323j = r101;
        c r105 = this.mScrollChecker;
        int r106 = r104.f559314a;
        if (r101 == false) goto L17;
        int r107 = this.mDurationToCloseHeader;
    L18:
        r105.b(r106, r107, false);
        if (r100 == false) goto L22;
        this.mStatus = 3;
        performRefresh();
        return;
    L22:
        return;
    L17:
        r107 = this.mDurationToCloseFooter;
        goto L18
    L8:
        r103 = FLAG_AUTO_REFRESH_BUT_LATER;
        goto L9
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r110) {
        super.onMeasure(r100, r110);
        View r101 = this.mHeaderView;
        if (r101 == null) goto L5;
        measureChildWithMargins(r101, r100, 0, r110, 0);
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) this.mHeaderView.getLayoutParams();
        int r103 = (this.mHeaderView.getMeasuredHeight() + r102.topMargin) + r102.bottomMargin;
        this.mHeaderHeight = r103;
        wdc.a r104 = this.mPtrIndicator;
        r104.f559320g = r103;
        r104.f559314a = (int) (r104.f559324k * r103);
    L5:
        View r105 = this.mFooterView;
        if (r105 == null) goto L8;
        measureChildWithMargins(r105, r100, 0, r110, 0);
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) this.mFooterView.getLayoutParams();
        int r107 = (this.mFooterView.getMeasuredHeight() + r106.topMargin) + r106.bottomMargin;
        this.mFooterHeight = r107;
        wdc.a r108 = this.mPtrIndicator;
        r108.f559321h = r107;
        r108.f559314a = (int) (r108.f559324k * r108.f559320g);
    L8:
        View r109 = this.mContent;
        if (r109 == null) goto L14;
        measureContentView(r109, r100, r110);
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) this.mContent.getLayoutParams();
        if (getLayoutParams().height != (-2)) goto L15;
        super.setMeasuredDimension(getMeasuredWidth(), (this.mContent.getMeasuredHeight() + r111.topMargin) + r111.bottomMargin);
        return;
    L15:
        return;
    }

    public LKUIPtrFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mStatus = 1;
        StringBuilder r103 = new StringBuilder("ptr-frame-");
        int r104 = ID + 1;
        ID = r104;
        r103.append(r104);
        this.LOG_TAG = r103.toString();
        this.mHeaderId = 0;
        this.mContainerId = 0;
        this.mFooterId = 0;
        this.mMode = Mode.BOTH;
        this.mDurationToBackHeader = 200;
        this.mDurationToBackFooter = 200;
        this.mDurationToCloseHeader = 1000;
        this.mDurationToCloseFooter = 1000;
        this.mKeepHeaderWhenRefresh = true;
        this.mPullToRefresh = false;
        this.mForceBackWhenComplete = false;
        this.mPtrUIHandlerHolder = new com.ss.android.lark.widget.ptr.b();
        this.mFooterShowTouchSlop = 0.0f;
        this.startYPosition = 0.0f;
        this.mDisableWhenHorizontalMove = false;
        this.mFlag = 0;
        this.mPreventForHorizontal = false;
        this.mEnableScrollContentAfterRefresh = false;
        this.mEnableScrollContentAfterLoad = false;
        this.mLoadingMinTime = 500;
        this.mLoadingStartTime = 0;
        this.mHasSendCancelEvent = false;
        this.mPerformRefreshCompleteDelay = new a(this);
        this.mPtrIndicator = new wdc.a();
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.lkui_ptr_content, R.attr.lkui_ptr_duration_to_back_footer, R.attr.lkui_ptr_duration_to_back_header, R.attr.lkui_ptr_duration_to_back_refresh, R.attr.lkui_ptr_duration_to_close_either, R.attr.lkui_ptr_duration_to_close_footer, R.attr.lkui_ptr_duration_to_close_header, R.attr.lkui_ptr_footer, R.attr.lkui_ptr_header, R.attr.lkui_ptr_keep_header_when_refresh, R.attr.lkui_ptr_mode, R.attr.lkui_ptr_pull_to_fresh, R.attr.lkui_ptr_ratio_of_header_height_to_refresh, R.attr.lkui_ptr_resistance, R.attr.lkui_ptr_resistance_footer, R.attr.lkui_ptr_resistance_header}, 0, 0);
        if (r105 == null) goto L5;
        this.mHeaderId = r105.getResourceId(8, this.mHeaderId);
        this.mContainerId = r105.getResourceId(0, this.mContainerId);
        this.mFooterId = r105.getResourceId(7, this.mFooterId);
        wdc.a r106 = this.mPtrIndicator;
        r106.f559325l = r105.getFloat(13, r106.f559325l);
        wdc.a r107 = this.mPtrIndicator;
        r107.f559326m = r105.getFloat(13, r107.f559326m);
        wdc.a r108 = this.mPtrIndicator;
        r108.f559325l = r105.getFloat(15, r108.f559325l);
        wdc.a r109 = this.mPtrIndicator;
        r109.f559326m = r105.getFloat(14, r109.f559326m);
        this.mDurationToBackHeader = r105.getInt(3, this.mDurationToCloseHeader);
        this.mDurationToBackFooter = r105.getInt(3, this.mDurationToCloseHeader);
        this.mDurationToBackHeader = r105.getInt(2, this.mDurationToCloseHeader);
        this.mDurationToBackFooter = r105.getInt(1, this.mDurationToCloseHeader);
        this.mDurationToCloseHeader = r105.getInt(4, this.mDurationToCloseHeader);
        this.mDurationToCloseFooter = r105.getInt(4, this.mDurationToCloseFooter);
        this.mDurationToCloseHeader = r105.getInt(6, this.mDurationToCloseHeader);
        this.mDurationToCloseFooter = r105.getInt(5, this.mDurationToCloseFooter);
        float r110 = r105.getFloat(12, this.mPtrIndicator.f559324k);
        wdc.a r111 = this.mPtrIndicator;
        r111.f559324k = r110;
        r111.f559314a = (int) (r111.f559320g * r110);
        this.mKeepHeaderWhenRefresh = r105.getBoolean(9, this.mKeepHeaderWhenRefresh);
        this.mPullToRefresh = r105.getBoolean(11, this.mPullToRefresh);
        this.mMode = getModeFromIndex(r105.getInt(10, 4));
        r105.recycle();
    L5:
        this.mScrollChecker = new c(this);
        this.mPagingTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    private void measureContentView(View r100, int r101, int r102) {
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        r100.measure(ViewGroup.getChildMeasureSpec(r101, ((getPaddingLeft() + getPaddingRight()) + r103.leftMargin) + r103.rightMargin, r103.width), ViewGroup.getChildMeasureSpec(r102, (getPaddingTop() + getPaddingBottom()) + r103.topMargin, r103.height));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        layoutChildren();
    }
}
