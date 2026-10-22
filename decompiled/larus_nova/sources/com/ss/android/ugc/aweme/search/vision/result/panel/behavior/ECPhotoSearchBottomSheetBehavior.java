package com.ss.android.ugc.aweme.search.vision.result.panel.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.ECSearchViewPagerUtils;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoSearchEventTracker;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoSearchInteractEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class ECPhotoSearchBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public final boolean A;
    public final ViewDragHelper.Callback B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f453687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f453688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f453689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f453690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f453691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f453692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f453693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f453694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f453695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f453696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f453697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewDragHelper f453698l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f453699m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f453700n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f453701o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f453702p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public WeakReference<V> f453703q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WeakReference<View> f453704r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<BottomSheetCallback> f453705s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public VelocityTracker f453706t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f453707u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f453708v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f453709w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f453710x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f453711y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f453712z;

    public static abstract class BottomSheetCallback {
        public BottomSheetCallback() {
        }

        public abstract void a(View r100, float r101);

        public abstract void b(View r100, int r101);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f453717a;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.f453717a = r100.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f453717a);
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.f453717a = r101;
        }
    }

    public class SettleRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f453718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f453719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ECPhotoSearchBottomSheetBehavior f453720c;

        public final void a() {
            ViewDragHelper r100 = this.f453720c.f453698l;
            if (r100 != null) goto L5;
        L25:
            this.f453720c.setStateInternal(this.f453719b);
            return;
        L5:
            if (r100.continueSettling(true) == false) goto L25;
            ViewCompat.postOnAnimation(this.f453718a, this);
            if (this.f453719b != 4) goto L27;
            int r101 = this.f453718a.getTop();
            ECPhotoSearchBottomSheetBehavior r102 = this.f453720c;
            if (r101 == r102.f453693g) goto L11;
            return;
        L11:
            if (r102.f453695i == true) goto L29;
            PhotoSearchInteractEvent r103 = PhotoSearchInteractEvent.I;
            long r104 = System.currentTimeMillis();
            r103.getClass();
            PhotoSearchInteractEvent.f453615o = r104;
            PhotoSearchEventTracker.f453600a.getClass();
            ITradeSearchHostService r105 = TradeSearch.c(TradeSearch.f453393a);
            if (r105 == null) goto L17;
            ITradeSearchHostAbility r106 = r105.getITradeSearchHostAbility();
            if (r106 == null) goto L17;
            r106.getNetworkStateManager();
        L17:
            PhotoSearchInteractEvent.f453603c = null;
            long r107 = PhotoSearchInteractEvent.f453615o;
            long r108 = PhotoSearchInteractEvent.f453604d;
            PhotoSearchInteractEvent.f453616p = (int) (r107 - r108);
            long r109 = PhotoSearchInteractEvent.f453605e;
            PhotoSearchInteractEvent.f453617q = (int) (r109 - r108);
            long r110 = PhotoSearchInteractEvent.f453611k;
            PhotoSearchInteractEvent.f453618r = (int) (r110 - r109);
            PhotoSearchInteractEvent.f453619s = (int) (r107 - r110);
            long r111 = PhotoSearchInteractEvent.f453606f;
            PhotoSearchInteractEvent.f453620t = (int) (r111 - r109);
            if (PhotoSearchInteractEvent.f453601a == false) goto L20;
            long r112 = PhotoSearchInteractEvent.f453609i;
            PhotoSearchInteractEvent.f453621u = (int) (r112 - r111);
            long r113 = PhotoSearchInteractEvent.f453608h;
            PhotoSearchInteractEvent.f453622v = (int) (r113 - r111);
            PhotoSearchInteractEvent.f453623w = (int) (r112 - r113);
            PhotoSearchInteractEvent.f453624x = (int) (PhotoSearchInteractEvent.f453610j - r112);
            PhotoSearchInteractEvent.f453625y = (int) (r110 - r113);
        L21:
            long r114 = PhotoSearchInteractEvent.f453612l;
            PhotoSearchInteractEvent.f453626z = (int) (r114 - r110);
            long r115 = PhotoSearchInteractEvent.f453613m;
            PhotoSearchInteractEvent.A = (int) (r115 - r114);
            long r116 = PhotoSearchInteractEvent.f453614n;
            PhotoSearchInteractEvent.B = (int) (r116 - r115);
            PhotoSearchInteractEvent.C = (int) (r107 - r116);
            JSONObject r117 = new JSONObject();
            r117.put("itemCount", PhotoSearchInteractEvent.f453602b);
            r117.put("network_type", PhotoSearchInteractEvent.f453603c);
            r117.put("photo_search_duration", PhotoSearchInteractEvent.f453616p);
            r117.put("prepare_photo_duration", PhotoSearchInteractEvent.f453617q);
            r117.put(a.KEY_LOADING_DURATION, PhotoSearchInteractEvent.f453618r);
            r117.put("search_anim_duration", PhotoSearchInteractEvent.f453619s);
            r117.put("build_request_cost", PhotoSearchInteractEvent.f453620t);
            r117.put("network_finish_cost", PhotoSearchInteractEvent.f453621u);
            r117.put("data_parse_cost", PhotoSearchInteractEvent.f453624x);
            r117.put("loading_end_cost", PhotoSearchInteractEvent.f453625y);
            r117.put("loading_crop_gap_cost", PhotoSearchInteractEvent.f453626z);
            r117.put("crop_window_cost", PhotoSearchInteractEvent.A);
            r117.put("crop_result_gap_cost", PhotoSearchInteractEvent.B);
            r117.put("result_show_cost", PhotoSearchInteractEvent.C);
            r117.put("enter_from", PhotoSearchInteractEvent.D);
            r117.put("search_source", PhotoSearchInteractEvent.E);
            r117.put("search_type", PhotoSearchInteractEvent.F);
            r117.put("search_channel", PhotoSearchInteractEvent.G);
            r117.put("search_type_detail", PhotoSearchInteractEvent.H);
            if (PhotoSearchInteractEvent.f453601a == false) goto L24;
            r117.put("get_chunk1_cost", PhotoSearchInteractEvent.f453622v);
            r117.put("chunk1_chunk2_gap_cost", PhotoSearchInteractEvent.f453623w);
        L24:
            Unit r118 = Unit.INSTANCE;
            AppLogNewUtils.onEventV3("photo_search_interact_monitor", r117);
            this.f453720c.f453695i = true;
            return;
        L20:
            long r119 = PhotoSearchInteractEvent.f453607g;
            PhotoSearchInteractEvent.f453621u = (int) (r119 - r111);
            long r120 = PhotoSearchInteractEvent.f453610j;
            PhotoSearchInteractEvent.f453624x = (int) (r120 - r119);
            PhotoSearchInteractEvent.f453625y = (int) (r110 - r120);
            goto L21
        L29:
            return;
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

        public SettleRunnable(ECPhotoSearchBottomSheetBehavior r100, View r101, int r102) {
            this.f453720c = r100;
            this.f453718a = r101;
            this.f453719b = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public boolean d(View r100) {
        return true;
    }

    public final int b() {
        int r100 = this.f453710x;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return this.f453702p;
    }

    public ECPhotoSearchBottomSheetBehavior() {
        this.f453695i = true;
        this.f453696j = true;
        this.f453697k = 4;
        this.f453705s = new ArrayList();
        this.f453710x = -1;
        this.f453711y = -1;
        this.f453712z = false;
        this.A = true;
        this.B = new AnonymousClass2(this);
    }

    public final void dispatchOnSlide(int r100) {
        V r101 = this.f453703q.get();
        if (r101 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.f453705s).isEmpty() == true) goto L17;
        int r102 = 0;
        if (r100 <= this.f453693g) goto L12;
    L9:
        if (r102 >= ((ArrayList) this.f453705s).size()) goto L18;
        ((BottomSheetCallback) ListProtector.get(this.f453705s, r102)).a(r101, (this.f453693g - r100) / (b() - this.f453693g));
        r102 = r102 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r102 >= ((ArrayList) this.f453705s).size()) goto L19;
        BottomSheetCallback r103 = (BottomSheetCallback) ListProtector.get(this.f453705s, r102);
        int r104 = this.f453693g;
        r103.a(r101, (r104 - r100) / (r104 - this.f453692f));
        r102 = r102 + 1;
        goto L12
    L19:
        return;
    }

    public final View findScrollingChild(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r100) == false) goto L8;
        return r100;
    L8:
        int r101 = 0;
        if ((r100 instanceof ViewPager) == false) goto L27;
        ViewPager r102 = (ViewPager) r100;
        Field r103 = ECSearchViewPagerUtils.f453411a;
        int r104 = r102.getCurrentItem();
    L12:
        if (r101 >= r102.getChildCount()) goto L22;
        View r105 = r102.getChildAt(r101);
        ViewPager.LayoutParams r106 = (ViewPager.LayoutParams) r105.getLayoutParams();
        int r107 = ((Integer) ECSearchViewPagerUtils.f453411a.get(r106)).intValue();     // Catch: IllegalAccessException -> L19
        if (r106.isDecor == true) goto L18;
        if (r104 != r107) goto L18;
    L23:
        View r108 = findScrollingChild(r105);
        if (r108 == null) goto L36;
        return r108;
    L36:
        return null;
    L18:
        r101 = r101 + 1;
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    L22:
        r105 = null;
        goto L23
    L27:
        if ((r100 instanceof ViewGroup) == false) goto L36;
        ViewGroup r109 = (ViewGroup) r100;
        if (r109.getVisibility() != 0) goto L36;
        int r110 = r109.getChildCount();
    L31:
        if (r101 >= r110) goto L36;
        View r111 = findScrollingChild(r109.getChildAt(r101));
        if (r111 != null) goto L34;
        r101 = r101 + 1;
        goto L31
    L34:
        return r111;
    }

    public final void setPeekHeight(int r100) {
        boolean r101 = true;
        if (r100 != (-1)) goto L8;
        if (this.f453690d == true) goto L12;
        this.f453690d = true;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        if (this.f453697k != 4) goto L24;
        WeakReference<V> r102 = this.f453703q;
        if (r102 == null) goto L25;
        V r103 = r102.get();
        if (r103 == null) goto L26;
        r103.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r101 = false;
        goto L14
    L8:
        if (this.f453690d == false) goto L10;
    L13:
        this.f453690d = false;
        this.f453688b = Math.max(0, r100);
        this.f453693g = this.f453702p - r100;
        goto L14
    L10:
        if (this.f453688b == r100) goto L12;
        goto L12
    }

    public final void setState(final int r100) {
        if (r100 != this.f453697k) goto L5;
        return;
    L5:
        WeakReference<V> r101 = this.f453703q;
        if (r101 == null) goto L8;
        final V r102 = r101.get();
        if (r102 != null) goto L22;
        return;
    L22:
        ViewParent r103 = r102.getParent();
        if (r103 != null) goto L25;
    L29:
        startSettlingAnimation(r102, r100);
        return;
    L25:
        if (r103.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L29;
        final PhotoSearchBottomSheetBehavior r104 = (PhotoSearchBottomSheetBehavior) this;
        r102.post(new AnonymousClass1(r104, r102, r100));
        return;
    L8:
        if (r100 != 4) goto L10;
    L17:
        this.f453697k = r100;
        return;
    L10:
        if (r100 == 3) goto L17;
        if (this.f453694h == false) goto L16;
        if (r100 == 5) goto L17;
    L16:
        if (r100 == 6) goto L17;
    }

    public void setStateInternal(int r100) {
        if (this.f453697k != r100) goto L5;
        return;
    L5:
        this.f453697k = r100;
        V r101 = this.f453703q.get();
        if (r101 != null) goto L8;
        return;
    L8:
        if (((ArrayList) this.f453705s).isEmpty() == true) goto L15;
        int r102 = 0;
    L11:
        if (r102 >= ((ArrayList) this.f453705s).size()) goto L16;
        ((BottomSheetCallback) ListProtector.get(this.f453705s, r102)).b(r101, r100);
        r102 = r102 + 1;
        goto L11
    L16:
        return;
    }

    public ECPhotoSearchBottomSheetBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f453695i = true;
        this.f453696j = true;
        this.f453697k = 4;
        this.f453705s = new ArrayList();
        this.f453710x = -1;
        this.f453711y = -1;
        this.f453712z = false;
        this.A = true;
        this.B = new AnonymousClass2(this);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.behavior_fitToContents, R.attr.behavior_hideable, R.attr.behavior_peekHeight, R.attr.behavior_skipCollapsed});
        TypedValue r103 = r102.peekValue(2);
        if (r103 == null) goto L7;
        int r104 = r103.data;
        if (r104 != (-1)) goto L7;
        setPeekHeight(r104);
    L8:
        r102.recycle();
        this.f453687a = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        return;
    L7:
        setPeekHeight(r102.getDimensionPixelSize(2, -1));
        goto L8
    }

    public ViewDragHelper a(CoordinatorLayout r100, ViewDragHelper.Callback r101) {
        return ViewDragHelper.create(r100, r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout r100, V r101) {
        return new SavedState(super.onSaveInstanceState(r100, r101), this.f453697k);
    }

    public boolean shouldHide(View r100, float r101) {
        if (this.f453696j == false) goto L6;
        return true;
    L6:
        if (r100.getTop() >= this.f453693g) goto L9;
        return false;
    L9:
        if ((Math.abs((r100.getTop() + (r101 * 0.1f)) - this.f453693g) / this.f453688b) > 0.5f) goto L13;
        return false;
    L13:
        return true;
    }

    public final void startSettlingAnimation(View r100, int r101) {
        if (r101 != 4) goto L6;
        int r102 = this.f453693g;
    L15:
        PhotoSearchInteractEvent r103 = PhotoSearchInteractEvent.I;
        long r104 = System.currentTimeMillis();
        r103.getClass();
        PhotoSearchInteractEvent.f453614n = r104;
        ViewDragHelper r105 = this.f453698l;
        if (r105 != null) goto L18;
    L20:
        setStateInternal(r101);
        return;
    L18:
        if (r105.smoothSlideViewTo(r100, r100.getLeft(), r102) == false) goto L20;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new SettleRunnable(this, r100, r101));
        return;
    L6:
        if (r101 != 3) goto L9;
        r102 = this.f453692f;
        goto L15
    L9:
        if (this.f453694h == false) goto L23;
        if (r101 != 5) goto L13;
    L14:
        r102 = b();
        goto L15
    L13:
        if (r101 == 6) goto L14;
    L23:
        throw new IllegalArgumentException("Illegal state argument: " + r101);
    }

    public void c(View r100, float r101, float r102) {
        int r103 = 3;
        if (r102 >= 0.0f) goto L6;
        int r104 = this.f453692f;
    L18:
        ViewDragHelper r105 = this.f453698l;
        if (r105 != null) goto L21;
    L23:
        setStateInternal(r103);
        return;
    L21:
        if (r105.settleCapturedViewAt(r100.getLeft(), r104) == false) goto L23;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r100, new SettleRunnable(this, r100, r103));
        return;
    L6:
        if (this.f453694h == false) goto L11;
        if (shouldHide(r100, r102) == false) goto L11;
        r104 = b();
        r103 = 5;
    L11:
        if (r102 != 0.0f) goto L16;
        int r106 = r100.getTop();
        if (Math.abs(r106 - this.f453692f) >= Math.abs(r106 - this.f453693g)) goto L15;
        r104 = this.f453692f;
        goto L18
    L15:
        int r107 = this.f453693g;
    L17:
        r104 = r107;
        r103 = 4;
        goto L18
    L16:
        r107 = this.f453693g;
        goto L17
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r110, MotionEvent r111) {
        if (r110.isShown() == true) goto L6;
        this.f453699m = true;
        return false;
    L6:
        int r101 = r111.getActionMasked();
        View r102 = null;
        if (r101 != 0) goto L12;
        this.f453707u = -1;
        VelocityTracker r103 = this.f453706t;
        if (r103 == null) goto L12;
        r103.recycle();
        this.f453706t = null;
    L12:
        if (this.f453706t != null) goto L14;
        this.f453706t = VelocityTracker.obtain();
    L14:
        this.f453706t.addMovement(r111);
        if (r101 == 0) goto L24;
        if (r101 != 1) goto L18;
    L20:
        this.f453709w = false;
        this.f453707u = -1;
        if (this.f453699m == false) goto L40;
        this.f453699m = false;
        return false;
    L40:
        if (this.f453699m == true) goto L46;
        ViewDragHelper r112 = this.f453698l;
        if (r112 == null) goto L46;
        if (r112.shouldInterceptTouchEvent(r111) == false) goto L46;
        return true;
    L46:
        WeakReference<View> r113 = this.f453704r;
        if (r113 == null) goto L50;
        r102 = r113.get();
    L50:
        if (r101 != 2) goto L64;
        if (r102 != null) goto L53;
        return false;
    L53:
        if (this.f453699m == false) goto L55;
        return false;
    L55:
        if (this.f453697k != 1) goto L57;
        return false;
    L57:
        if (r100.isPointInChildBounds(r102, (int) r111.getX(), (int) r111.getY()) == false) goto L59;
        return false;
    L59:
        if (this.f453698l != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.f453708v - r111.getY()) <= this.f453698l.getTouchSlop()) goto L70;
        return true;
    L70:
        return false;
    L64:
        return false;
    L18:
        if (r101 == 3) goto L20;
    L24:
        int r104 = (int) r111.getX();
        this.f453708v = (int) r111.getY();
        WeakReference<View> r105 = this.f453704r;
        if (r105 == null) goto L27;
        View r106 = r105.get();
    L28:
        if (r106 == null) goto L33;
        if (r100.isPointInChildBounds(r106, r104, this.f453708v) == false) goto L33;
        this.f453707u = r111.getPointerId(r111.getActionIndex());
        this.f453709w = true;
    L33:
        if (this.f453707u == (-1)) goto L35;
    L37:
        boolean r114 = false;
    L38:
        this.f453699m = r114;
        goto L40
    L35:
        if (r100.isPointInChildBounds(r110, r104, this.f453708v) == true) goto L37;
        r114 = true;
        goto L38
    L27:
        r106 = null;
        goto L28
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r100, V r101, int r102) {
        if (ViewCompat.getFitsSystemWindows(r100) == true) goto L5;
    L7:
        int r103 = r101.getTop();
        r100.onLayoutChild(r101, r102);
        this.f453702p = r100.getHeight();
        if (this.f453690d == true) goto L10;
        int r104 = this.f453688b;
    L14:
        int r105 = this.f453711y;
        if (r105 > 0) goto L18;
        r105 = Math.max(0, this.f453702p - r101.getHeight());
    L18:
        this.f453692f = r105;
        int r106 = this.f453711y;
        if (r106 > 0) goto L22;
        r106 = Math.max(this.f453702p - r104, r105);
    L22:
        this.f453693g = r106;
        int r107 = this.f453697k;
        if (r107 != 3) goto L26;
        ViewCompat.offsetTopAndBottom(r101, this.f453692f);
    L44:
        if (this.f453698l != null) goto L46;
        this.f453698l = a(r100, this.B);
    L46:
        this.f453703q = new WeakReference(r101);
        this.f453704r = new WeakReference(findScrollingChild(r101));
        return true;
    L26:
        if (this.f453694h == false) goto L37;
        if (r107 == 5) goto L32;
        if (r107 != 6) goto L37;
    L32:
        if (this.f453712z == false) goto L34;
        int r108 = b();
    L35:
        ViewCompat.offsetTopAndBottom(r101, r108);
        goto L44
    L34:
        r108 = this.f453702p;
    L37:
        if (r107 != 4) goto L39;
        ViewCompat.offsetTopAndBottom(r101, r106);
        goto L44
    L39:
        if (r107 != 1) goto L41;
    L42:
        ViewCompat.offsetTopAndBottom(r101, r103 - r101.getTop());
        goto L44
    L41:
        if (r107 != 2) goto L44;
    L10:
        if (this.f453691e != 0) goto L12;
        this.f453691e = r100.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L12:
        r104 = Math.max(this.f453691e, this.f453702p - ((r100.getWidth() * 9) / 16));
        this.f453689c = r104;
        goto L14
    L5:
        if (ViewCompat.getFitsSystemWindows(r101) == true) goto L7;
        ViewCompat.setFitsSystemWindows(r101, true);
        goto L7
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout r100, V r101, Parcelable r102) {
        SavedState r103 = (SavedState) r102;
        super.onRestoreInstanceState(r100, r101, r103.getSuperState());
        if (this.A == true) goto L5;
        return;
    L5:
        int r104 = r103.f453717a;
        if (r104 != 1) goto L8;
    L11:
        this.f453697k = 4;
        return;
    L8:
        if (r104 == 2) goto L11;
        this.f453697k = r104;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onStopNestedScroll(CoordinatorLayout r100, V r101, View r102) {
        int r103 = 3;
        if (r101.getTop() != this.f453692f) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r104 = this.f453704r;
        if (r104 != null) goto L9;
        return;
    L9:
        if (r102 == r104.get()) goto L11;
        return;
    L11:
        if (this.f453701o == true) goto L14;
        return;
    L14:
        if (this.f453700n <= 0) goto L19;
        if (d(r101) == false) goto L19;
        int r105 = this.f453692f;
    L34:
        ViewDragHelper r106 = this.f453698l;
        if (r106 != null) goto L37;
    L39:
        setStateInternal(r103);
    L40:
        this.f453701o = false;
        return;
    L37:
        if (r106.smoothSlideViewTo(r101, r101.getLeft(), r105) == false) goto L39;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r101, new SettleRunnable(this, r101, r103));
    L19:
        if (this.f453694h == false) goto L27;
        if (this.f453706t != null) goto L23;
        this.f453706t = VelocityTracker.obtain();
    L23:
        this.f453706t.computeCurrentVelocity(1000, this.f453687a);
        if (shouldHide(r101, this.f453706t.getYVelocity(this.f453707u)) == false) goto L27;
        r105 = b();
        r103 = 5;
    L27:
        if (this.f453700n != 0) goto L32;
        int r107 = r101.getTop();
        if (Math.abs(r107 - this.f453692f) >= Math.abs(r107 - this.f453693g)) goto L31;
        r105 = this.f453692f;
        goto L34
    L31:
        r105 = this.f453693g;
    L33:
        r103 = 4;
        goto L34
    L32:
        r105 = this.f453693g;
        goto L33
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        boolean r103 = false;
        if (r101.isShown() == true) goto L5;
        return false;
    L5:
        int r104 = r102.getActionMasked();
        if (this.f453697k != 1) goto L10;
        if (r104 != 0) goto L10;
        return true;
    L10:
        if (r102.getAction() != 2) goto L12;
    L13:
        int r105 = r102.findPointerIndex(this.f453698l.getActivePointerId());
        ViewDragHelper r106 = this.f453698l;
        if (r106 != null) goto L16;
    L19:
        r103 = true;
    L20:
        ViewDragHelper r107 = this.f453698l;
        if (r107 == null) goto L24;
        if (r103 == false) goto L24;
        r107.processTouchEvent(r102);
    L24:
        if (r104 != 0) goto L29;
        this.f453707u = -1;
        VelocityTracker r108 = this.f453706t;
        if (r108 == null) goto L29;
        r108.recycle();
        this.f453706t = null;
    L29:
        if (this.f453706t != null) goto L31;
        this.f453706t = VelocityTracker.obtain();
    L31:
        this.f453706t.addMovement(r102);
        if (r104 != 2) goto L39;
        if (this.f453699m == true) goto L39;
        if (Math.abs(this.f453708v - r102.getY()) <= this.f453698l.getTouchSlop()) goto L39;
        this.f453698l.captureChildView(r101, r102.getPointerId(r102.getActionIndex()));
    L39:
        return !this.f453699m;
    L16:
        if (r106.getViewDragState() != 1) goto L19;
        if (r105 >= 0) goto L19;
    L12:
        if (r102.getAction() != 6) goto L19;
        goto L13
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onNestedPreFling(CoordinatorLayout r100, V r101, View r102, float r103, float r104) {
        if (r102 == this.f453704r.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.f453697k == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r100, r101, r102, r103, r104) == false) goto L9;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104) {
        this.f453700n = 0;
        this.f453701o = false;
        if ((r104 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, V r101, View r102, int r103, int r104, int[] r105) {
        if (r102 == this.f453704r.get()) goto L5;
        return;
    L5:
        int r106 = r101.getTop();
        int r107 = r106 - r104;
        if (r104 <= 0) goto L11;
        int r108 = this.f453692f;
        if (r107 >= r108) goto L10;
        int r109 = r106 - r108;
        r105[1] = r109;
        ViewCompat.offsetTopAndBottom(r101, -r109);
        setStateInternal(3);
    L21:
        dispatchOnSlide(r101.getTop());
        this.f453700n = r104;
        this.f453701o = true;
        return;
    L10:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L21
    L11:
        if (r104 >= 0) goto L21;
        if (r102.canScrollVertically(-1) == true) goto L21;
        int r110 = this.f453693g;
        if (r107 > r110) goto L17;
    L20:
        r105[1] = r104;
        ViewCompat.offsetTopAndBottom(r101, -r104);
        setStateInternal(1);
        goto L21
    L17:
        if (this.f453694h == true) goto L20;
        int r111 = r106 - r110;
        r105[1] = r111;
        ViewCompat.offsetTopAndBottom(r101, -r111);
        setStateInternal(4);
        goto L21
    }
}
