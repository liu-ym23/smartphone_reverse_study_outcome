package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.service.z2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 >2\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0011J\b\u0010#\u001a\u00020\u001eH\u0002J \u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J$\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020,2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002J \u00104\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0016H\u0007J\u000e\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020\u001eJ\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u001eH\u0014J\b\u0010=\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/common_ui/view/BottomOverlayViewAdapterPad;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialTouchRawX", "", "initialTouchRawY", "initHeight", "downEvent", "Landroid/view/MotionEvent;", "isScrolling", "", "_isSwipeDown", "boundMenu", "boundSheet", "boundCoordinator", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coverSheetTouchArea", "preferSheetTapTarget", "heightOverride", "Ljava/lang/Integer;", "boundLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "initViewInfo", "", "isSwipeDown", "setCoverSheetTouchAreaEnabled", "enabled", "setPreferSheetTapTargetEnabled", "updateCoverBounds", "updateCoverRect", "menuRect", "Landroid/graphics/Rect;", "sheetRect", "coverRect", "initMenuOnlyTouchListener", TplType.MENU, "attachParent", "Landroid/view/ViewGroup;", "sourceRoot", "createMenuOnlyLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "left", "top", "initBottomSheetAndMenuTouchListener", DocumentType.SHEET_NAME, "coordinator", "updateHeight", "newHeight", "resetHeight", "addBoundLayoutChangeListeners", "clearBoundViews", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomOverlayViewAdapterPad extends View {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f328138m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f328139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f328140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MotionEvent f328141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f328142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f328143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f328144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f328145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CoordinatorLayout f328146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f328147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f328148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f328149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f328150l;

    public static final class a {
    }

    static {
    }

    public BottomOverlayViewAdapterPad(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BottomOverlayViewAdapterPad(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        View r100 = this.f328144f;
        if (r100 == null) goto L5;
        r100.removeOnLayoutChangeListener(this.f328150l);
    L5:
        View r101 = this.f328145g;
        if (r101 == null) goto L8;
        r101.removeOnLayoutChangeListener(this.f328150l);
    L8:
        CoordinatorLayout r102 = this.f328146h;
        if (r102 == null) goto L11;
        r102.removeOnLayoutChangeListener(this.f328150l);
    L11:
        this.f328144f = null;
        this.f328145g = null;
        this.f328146h = null;
    }

    public final void d() {
        View r100 = this.f328144f;
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = this.f328145g;
        if (r101 != null) goto L8;
        return;
    L8:
        Rect r102 = new Rect();
        Rect r103 = new Rect();
        Rect r104 = new Rect();
        r100.getGlobalVisibleRect(r102);
        r101.getGlobalVisibleRect(r103);
        e(r102, r103, r104);
        Rect r105 = new Rect();
        Object r106 = getParent();
        if ((r106 instanceof View) == false) goto L11;
        View r107 = (View) r106;
    L13:
        if (r107 == null) goto L17;
        boolean r108 = true;
        if (r107.getGlobalVisibleRect(r105) != true) goto L17;
    L18:
        int r109 = r104.left;
        if (r108 == false) goto L21;
        r109 = r109 - r105.left;
    L21:
        if (r108 == false) goto L23;
        int r110 = r104.top - r105.top;
    L24:
        int r111 = RangesKt.coerceAtLeast(r104.width(), 0);
        int r112 = RangesKt.coerceAtLeast(r104.height(), 0);
        ViewGroup.LayoutParams r113 = getLayoutParams();
        if (r113 != null) goto L27;
        r113 = new ViewGroup.LayoutParams(r111, r112);
    L27:
        r113.width = r111;
        Integer r114 = this.f328149k;
        if (r114 == null) goto L30;
        r112 = r114.intValue();
    L30:
        r113.height = r112;
        setLayoutParams(r113);
        setX(r109);
        setY(r110);
        requestLayout();
        return;
    L23:
        r110 = r104.top;
    L17:
        r108 = false;
        goto L18
    L11:
        r107 = null;
        goto L13
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new d(this));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener(null);
        MotionEvent r100 = this.f328141c;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f328141c = null;
        a();
        this.f328149k = null;
    }

    public final void setCoverSheetTouchAreaEnabled(boolean r100) {
        if (this.f328147i != r100) goto L5;
        return;
    L5:
        this.f328147i = r100;
        d();
    }

    public final void setPreferSheetTapTargetEnabled(boolean r100) {
        this.f328148j = r100;
    }

    public static final void b(View r100, MotionEvent r101) {
        Rect r102 = new Rect();
        r100.getGlobalVisibleRect(r102);
        MotionEvent r103 = MotionEvent.obtain(r101);
        r103.setLocation(r101.getRawX() - r102.left, r101.getRawY() - r102.top);
        r100.dispatchTouchEvent(r103);
        r103.recycle();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.common_ui.view.c] */
    public BottomOverlayViewAdapterPad(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328147i = true;
        this.f328148j = z2.f365865a.preferBottomOverlaySheetTapTarget();
        this.f328150l = new c(this);
    }

    public final void e(Rect r100, Rect r101, Rect r102) {
        r102.set(r100);
        if (this.f328147i == false) goto L7;
        r102.union(r101);
        return;
    L7:
        if (Rect.intersects(r102, r101) == true) goto L9;
        return;
    L9:
        int r103 = r101.top;
        int r104 = r102.top;
        if (r103 > r104) goto L12;
        r102.top = RangesKt.coerceAtMost(r101.bottom, r102.bottom);
        return;
    L12:
        int r105 = r101.bottom;
        int r106 = r102.bottom;
        if (r105 < r106) goto L15;
        r102.bottom = RangesKt.coerceAtLeast(r103, r104);
        return;
    L15:
        r102.top = RangesKt.coerceAtMost(r105, r106);
    }

    public /* synthetic */ BottomOverlayViewAdapterPad(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void c(BottomOverlayViewAdapterPad r100, Rect r101, Rect r102, CoordinatorLayout r103, View r104, Rect r105, View r106, Rect r107, MotionEvent r108) {
        r104.getGlobalVisibleRect(r105);
        r106.getGlobalVisibleRect(r101);
        r103.getGlobalVisibleRect(r102);
        r100.e(r105, r101, r107);
        float r109 = r108.getRawY() - r100.f328140b;
        int r110 = r101.centerX() - r102.left;
        int r111 = r101.centerY() - r102.top;
        MotionEvent r112 = MotionEvent.obtain(r108);
        r112.setLocation(r110, r111 + r109);
        r103.dispatchTouchEvent(r112);
        r112.recycle();
    }
}
