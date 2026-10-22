package com.larus.bmhome.chat.component.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import ce8.i;
import ce8.j;
import ce8.k;
import ce8.l;
import ce8.m;
import ce8.n;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0014J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J0\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\u001c\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000103H\u0002J \u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\u0018\u00108\u001a\u00020#2\u0006\u00105\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/component/util/PaneAwareFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paneProvider", "Lkotlin/Function0;", "Landroid/view/View;", "getPaneProvider", "()Lkotlin/jvm/functions/Function0;", "setPaneProvider", "(Lkotlin/jvm/functions/Function0;)V", "windowProvider", "Landroid/view/Window;", "getWindowProvider", "setWindowProvider", "maskProvider", "getMaskProvider", "setMaskProvider", "observedPane", "pendingRetryLayout", "", "pendingInitialInsetsAdjust", "initialInsetsPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "initialInsetsViewTreeObserver", "Landroid/view/ViewTreeObserver;", "paneLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "onAttachedToWindow", "", "onDetachedFromWindow", "installInitialInsetsGuard", "removeInitialInsetsPreDrawListener", "applyInitialInsetsAdjust", "ensurePaneObserver", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "resolvePaneGeometry", "Lkotlin/Triple;", "syncWindow", "paneLeft", "paneBottomToRoot", "paneWidth", "syncMask", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaneAwareFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f301864j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<? extends View> f301865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends Window> f301866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<? extends View> f301867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f301868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f301869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f301870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f301871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewTreeObserver f301872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f301873i;

    public PaneAwareFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PaneAwareFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b() {
        Function0<? extends View> r100 = this.f301865a;
        View r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.invoke();
    L6:
        if (r102 != null) goto L8;
    L10:
        r101 = r102;
    L11:
        View r103 = this.f301868d;
        if (r101 != r103) goto L14;
        return;
    L14:
        if (r103 == null) goto L16;
        r103.removeOnLayoutChangeListener(this.f301873i);
    L16:
        this.f301868d = r101;
        if (r101 == null) goto L20;
        r101.addOnLayoutChangeListener(this.f301873i);
        return;
    L20:
        return;
    L8:
        if (r102.isAttachedToWindow() == true) goto L10;
    L5:
        r102 = null;
        goto L6
    }

    public final void c() {
        n r100 = this.f301871g;
        if (r100 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r101 = this.f301872h;
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.isAlive() != true) goto L10;
    L11:
        if (r102 == false) goto L13;
        r101.removeOnPreDrawListener(r100);
    L13:
        this.f301871g = null;
        this.f301872h = null;
        return;
    L10:
        r102 = false;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        View r100 = this.f301868d;
        if (r100 == null) goto L5;
        r100.removeOnLayoutChangeListener(this.f301873i);
    L5:
        this.f301868d = null;
        this.f301870f = false;
        c();
        super.onDetachedFromWindow();
    }

    public final void a() {
        if (isAttachedToWindow() == true) goto L6;
        return;
    L6:
        if (this.f301870f == true) goto L8;
        return;
    L8:
        this.f301870f = false;
        WeakHashMap<View, Boolean> r100 = PaneAwareBottomSheetController.f301858d;
        View r101 = this;
    L9:
        View r102 = null;
        if (r101 == null) goto L18;
        if (r101.getId() == R.id.design_bottom_sheet) goto L19;
        Object r103 = r101.getParent();
        if ((r103 instanceof View) == true) goto L16;
        r101 = null;
        goto L9
    L16:
        r101 = (View) r103;
    L19:
        if (r101 == null) goto L33;
        PaneAwareBottomSheetController.a.b(r101);
        Object r104 = r101.getParent();
        if ((r104 instanceof View) == false) goto L24;
        View r105 = (View) r104;
    L25:
        if (r105 == null) goto L33;
        PaneAwareBottomSheetController.a.b(r105);
        Object r106 = r105.getParent();
        if ((r106 instanceof View) == false) goto L30;
        r102 = (View) r106;
    L30:
        if (r102 == null) goto L33;
        PaneAwareBottomSheetController.a.b(r102);
        goto L33
    L24:
        r105 = null;
    L33:
        requestLayout();
        return;
    L18:
        r101 = null;
        goto L19
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        WeakHashMap<View, Boolean> r100 = PaneAwareBottomSheetController.f301858d;
        View r101 = this;
    L3:
        View r102 = null;
        if (r101 == null) goto L12;
        if (r101.getId() == R.id.design_bottom_sheet) goto L13;
        Object r103 = r101.getParent();
        if ((r103 instanceof View) == true) goto L10;
        r101 = null;
        goto L3
    L10:
        r101 = (View) r103;
    L13:
        if (r101 == null) goto L35;
        PaneAwareBottomSheetController.a.b(r101);
        WeakHashMap<View, Boolean> r104 = PaneAwareBottomSheetController.f301858d;
        Boolean r105 = r104.get(r101);
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r106) == true) goto L18;
        r104.put(r101, r106);
        ViewCompat.setOnApplyWindowInsetsListener(r101, new i());
    L18:
        Object r107 = r101.getParent();
        if ((r107 instanceof View) == false) goto L21;
        View r108 = (View) r107;
    L22:
        if (r108 == null) goto L35;
        PaneAwareBottomSheetController.a.b(r108);
        if (Intrinsics.areEqual(r104.get(r108), r106) == true) goto L27;
        r104.put(r108, r106);
        ViewCompat.setOnApplyWindowInsetsListener(r108, new i());
    L27:
        Object r109 = r108.getParent();
        if ((r109 instanceof View) == false) goto L30;
        r102 = (View) r109;
    L30:
        if (r102 == null) goto L35;
        PaneAwareBottomSheetController.a.b(r102);
        if (Intrinsics.areEqual(r104.get(r102), r106) == true) goto L35;
        r104.put(r102, r106);
        ViewCompat.setOnApplyWindowInsetsListener(r102, new i());
        goto L35
    L21:
        r108 = null;
    L35:
        ViewCompat.requestApplyInsets(this);
        if (this.f301870f == true) goto L47;
        this.f301870f = true;
        n r110 = new n(this);
        ViewTreeObserver r111 = getViewTreeObserver();
        this.f301872h = r111;
        r111.addOnPreDrawListener(r110);
        this.f301871g = r110;
        post(new j(this));
        return;
    L47:
        return;
    L12:
        r101 = null;
        goto L13
    }

    public final Function0<View> getMaskProvider() {
        return this.f301867c;
    }

    public final Function0<View> getPaneProvider() {
        return this.f301865a;
    }

    public final Function0<Window> getWindowProvider() {
        return this.f301866b;
    }

    public final void setMaskProvider(Function0<? extends View> r100) {
        this.f301867c = r100;
    }

    public final void setPaneProvider(Function0<? extends View> r100) {
        this.f301865a = r100;
    }

    public final void setWindowProvider(Function0<? extends Window> r100) {
        this.f301866b = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        b();
        Function0<? extends View> r102 = this.f301865a;
        if (r102 == null) goto L7;
        View r103 = r102.invoke();
        if (r103 == null) goto L7;
        int r104 = r103.getWidth();
    L8:
        if (r104 <= 0) goto L10;
        r100 = View.MeasureSpec.makeMeasureSpec(r104, 1073741824);
    L10:
        super.onMeasure(r100, r101);
        return;
    L7:
        r104 = 0;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [ce8.m] */
    public PaneAwareFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setFitsSystemWindows(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new l());
        this.f301873i = new m(this);
    }

    public /* synthetic */ PaneAwareFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        super.onLayout(r110, r111, r112, r113, r114);
        b();
        Function0<? extends View> r115 = this.f301865a;
        FrameLayout.LayoutParams r116 = null;
        boolean r117 = false;
        if (r115 == null) goto L28;
        View r118 = r115.invoke();
        if (r118 == null) goto L28;
        int r119 = r118.getWidth();
        int r100 = r118.getHeight();
        if (r119 <= 0) goto L24;
        if (r100 <= 0) goto L24;
        View r101 = r118.getRootView();
        if (r101 == null) goto L28;
        if (r101.getHeight() <= 0) goto L28;
        if (r101.getWidth() <= 0) goto L28;
        WeakHashMap<View, Boolean> r102 = PaneAwareBottomSheetController.f301858d;
        Pair r120 = PaneAwareBottomSheetController.a.c(r118, r101);
        if (r120 == null) goto L28;
        int r103 = ((Number) r120.component1()).intValue();
        int r121 = ((Number) r120.component2()).intValue();
        Triple r104 = new Triple(Integer.valueOf(RangesKt.coerceAtLeast(r103, 0)), Integer.valueOf(RangesKt.coerceAtLeast(r101.getHeight() - (r121 + r100), 0)), Integer.valueOf(r119));
    L29:
        if (r104 != null) goto L31;
        return;
    L31:
        int r122 = ((Number) r104.component1()).intValue();
        int r123 = ((Number) r104.component2()).intValue();
        int r105 = ((Number) r104.component3()).intValue();
        Function0<? extends Window> r106 = this.f301866b;
        if (r106 == null) goto L51;
        Window r107 = r106.invoke();
        if (r107 == null) goto L51;
        WindowManager.LayoutParams r108 = r107.getAttributes();
        if (r108.width == r105) goto L39;
    L48:
        boolean r109 = true;
    L49:
        if (r109 == false) goto L51;
        StringBuilder r124 = new StringBuilder();
        r124.append(r108.width);
        r124.append(',');
        r124.append(r108.height);
        r124.append(',');
        r124.append(r108.x);
        r124.append(',');
        r124.append(r108.y);
        r124.append(',');
        r124.append(r108.gravity);
        String r125 = r124.toString();
        r108.width = r105;
        r108.height = -2;
        r108.gravity = 8388691;
        r108.x = r122;
        r108.y = r123;
        r107.setAttributes(r108);
        FLogger.f375446a.d("PaneAwareBSC", "syncWindow: " + r125 + " -> " + r105 + ",-2," + r122 + ',' + r123 + ",8388691");
        goto L51
    L39:
        if (r108.height != (-2)) goto L48;
        if (r108.x != r122) goto L48;
        if (r108.y != r123) goto L48;
        if (r108.gravity != 8388691) goto L48;
        r109 = false;
    L51:
        Function0<? extends View> r126 = this.f301867c;
        if (r126 == null) goto L71;
        View r127 = r126.invoke();
        if (r127 == null) goto L73;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if ((r128 instanceof FrameLayout.LayoutParams) == false) goto L59;
        r116 = (FrameLayout.LayoutParams) r128;
    L59:
        if (r116 != null) goto L62;
        return;
    L62:
        if (r116.width == r105) goto L64;
    L67:
        r117 = true;
    L68:
        if (r117 == false) goto L72;
        StringBuilder r129 = new StringBuilder();
        r129.append(r116.width);
        r129.append(',');
        r129.append(r116.height);
        r129.append(',');
        r129.append(r116.leftMargin);
        String r130 = r129.toString();
        r116.width = r105;
        r116.height = -1;
        r116.leftMargin = r122;
        r116.gravity = 8388659;
        r127.setLayoutParams(r116);
        FLogger.f375446a.d("PaneAwareBSC", "syncMask: (w,h,left) " + r130 + " -> " + r105 + ",MATCH_PARENT," + r122);
        return;
    L72:
        return;
    L64:
        if (r116.leftMargin != r122) goto L67;
        if (r116.height == (-1)) goto L68;
    L73:
        return;
    L71:
        return;
    L24:
        if (r118.isLaidOut() == true) goto L28;
        if (this.f301869e == true) goto L28;
        this.f301869e = true;
        r118.post(new k(this));
    L28:
        r104 = null;
        goto L29
    }
}
