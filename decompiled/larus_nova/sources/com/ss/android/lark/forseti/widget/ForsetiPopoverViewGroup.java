package com.ss.android.lark.forseti.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import cib.f;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.api.bean.ForsetiNodeMode;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.ui.g;
import com.ss.android.lark.forseti.widget.bean.ArrowDirection;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 =2\u00020\u0001:\u0001=B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0014J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020'H\u0002J\b\u00101\u001a\u00020'H\u0002J0\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0015J\u0006\u00108\u001a\u00020\u001fJ\u0016\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0015J\u000e\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00020%R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiPopoverViewGroup;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "shadowSizePadding", "", "popoverPosition", "Lcom/ss/android/lark/forseti/widget/bean/PopoverPosition;", "horizontalSafeMargin", "minWidthFoldInPixels", "popoverWidthInDp", "", "getPopoverWidthInDp", "()F", "popoverHeightInDp", "getPopoverHeightInDp", "isCMode", "", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Lcom/ss/android/lark/forseti/widget/ForsetiPopoverShadowLayout;", "forsetiInnerOptions", "Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "getForsetiInnerOptions", "()Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "setForsetiInnerOptions", "(Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;)V", "value", "Lcom/ss/android/lark/api/bean/ForsetiPageViewType;", "currentViewType", "setCurrentViewType", "(Lcom/ss/android/lark/api/bean/ForsetiPageViewType;)V", "viewTypeChangeListeners", "", "Lcom/ss/android/lark/api/ui/IForsetiPageViewTypeListener;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onViewAdded", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "triggerDisplayModeChanged", "triggerPageViewTypeChanged", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "getCurrentPageViewType", "addPageViewTypeChangeListener", "listener", "isSticky", "removePageViewTypeChangeListener", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiPopoverViewGroup extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f424693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public dib.a f424694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f424695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f424696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ForsetiPopoverShadowLayout f424697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public uua.a f424698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ForsetiPageViewType f424699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<g> f424700h;

    public static final class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiPopoverViewGroup f424701a;

        public a(ForsetiPopoverViewGroup r100) {
            this.f424701a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "insets");
            ForsetiPopoverViewGroup r102 = this.f424701a;
            if (r102.f424696d == false) goto L5;
            r102.setPadding(r102.getPaddingLeft(), 0, r102.getPaddingRight(), 0);
            return new WindowInsetsCompat.Builder(r101).build();
        L5:
            Insets r103 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            this.f424701a.setPadding(0, r103.top, 0, r103.bottom);
            View r104 = this.f424701a.getChildAt(0);
            int r105 = Math.max(0, this.f424701a.getMeasuredHeight() - (MathKt.roundToInt(r104.getY()) + r104.getMeasuredHeight()));
            Log.i("FST_PopoverViewGroup", "this.measuredHeight = " + this.f424701a.getMeasuredHeight() + ", theOnlyChild.y = " + r104.getY() + ", theOnlyChild.measuredHeight = " + r104.getMeasuredHeight());
            return new WindowInsetsCompat.Builder(r101).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r103.left, 0, r103.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(0, 0, 0, r101.getInsets(WindowInsetsCompat.Type.ime()).bottom - r105)).build();
        }
    }

    public static final class b {
    }

    static {
    }

    private final float getPopoverHeightInDp() {
        uua.a r100 = this.f424698f;
        if (r100 == null) goto L15;
        vua.a r101 = r100.f551784c;
        if (r101 == null) goto L15;
        Float r102 = Float.valueOf(r101.f557370d);
        if (r102.floatValue() <= 0.0f) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        return r102.floatValue();
    L9:
        r103 = false;
    L15:
        return 600.0f;
    }

    private final float getPopoverWidthInDp() {
        uua.a r100 = this.f424698f;
        if (r100 == null) goto L15;
        vua.a r101 = r100.f551784c;
        if (r101 == null) goto L15;
        Float r102 = Float.valueOf(r101.f557369c);
        if (r102.floatValue() <= 0.0f) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        return r102.floatValue();
    L9:
        r103 = false;
    L15:
        return 375.0f;
    }

    public final ForsetiPageViewType getCurrentPageViewType() {
        return this.f424699g;
    }

    public final uua.a getForsetiInnerOptions() {
        return this.f424698f;
    }

    public ForsetiPopoverViewGroup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private final void setCurrentViewType(ForsetiPageViewType r100) {
        if (this.f424699g == r100) goto L8;
        this.f424699g = r100;
        Iterator<T> r101 = this.f424700h.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((g) r101.next()).a(r100);
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        int r101 = getChildCount() - 1;
        boolean r102 = false;
    L4:
        if ((-1) >= r101) goto L49;
        View r103 = getChildAt(r101);
        if (r103.getVisibility() != 0) goto L24;
        int r104 = getMeasuredWidth();
        int r105 = r103.getLeft();
        if (r105 < 0) goto L11;
        if (r105 >= r104) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L24;
        if (r103.getMeasuredWidth() <= 0) goto L24;
        int r107 = getMeasuredHeight();
        int r108 = r103.getTop();
        if (r108 < 0) goto L19;
        if (r108 >= r107) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L24;
        if (r103.getMeasuredHeight() <= 0) goto L24;
        boolean r110 = true;
    L25:
        com.ss.android.lark.api.ui.c r111 = null;
        if (r110 == false) goto L39;
        if (r102 == true) goto L39;
        if ((r103 instanceof com.ss.android.lark.api.ui.c) == false) goto L31;
        r111 = (com.ss.android.lark.api.ui.c) r103;
    L31:
        if (r111 != null) goto L33;
    L37:
        r102 = true;
    L47:
        r101 = r101 - 1;
        goto L4
    L33:
        if (this.f424696d == false) goto L35;
        ForsetiNodeMode r112 = ForsetiNodeMode.NORMAL_C;
    L36:
        r111.a(r112);
        goto L37
    L35:
        r112 = ForsetiNodeMode.STACK_R;
    L39:
        if ((r103 instanceof com.ss.android.lark.api.ui.c) == false) goto L41;
        r111 = (com.ss.android.lark.api.ui.c) r103;
    L41:
        if (r111 == null) goto L47;
        if (this.f424696d == false) goto L45;
        ForsetiNodeMode r113 = ForsetiNodeMode.INVISIBLE_C;
    L46:
        r111.a(r113);
        goto L47
    L45:
        r113 = ForsetiNodeMode.INVISIBLE_R;
    L19:
        r109 = false;
    L11:
        r106 = false;
    L24:
        r110 = false;
        goto L25
    L49:
        if (this.f424696d == true) goto L51;
        ForsetiPageViewType r114 = ForsetiPageViewType.POPOVER_R_VIEW;
    L53:
        if (this.f424699g == r114) goto L60;
        setCurrentViewType(r114);
        return;
    L60:
        return;
    L51:
        r114 = ForsetiPageViewType.POPOVER_C_VIEW;
        goto L53
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (getChildCount() > 1) goto L7;
        super.onViewAdded(r100);
        return;
    L7:
        throw new IllegalStateException("Maximum 1 child");
    }

    public final void setForsetiInnerOptions(uua.a r100) {
        this.f424698f = r100;
        boolean r101 = true;
        int r102 = -2;
        if (r100 == null) goto L9;
        vua.a r103 = r100.f551784c;
        if (r103 == null) goto L9;
        if (r103.f557369c != (-2)) goto L9;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        int r105 = -2;
    L14:
        if (r100 == null) goto L20;
        vua.a r106 = r100.f551784c;
        if (r106 == null) goto L20;
        if (r106.f557370d != (-2)) goto L20;
    L21:
        if (r101 == true) goto L24;
        r102 = -1;
    L24:
        this.f424697e.setLayoutParams(new FrameLayout.LayoutParams(r105, r102));
        return;
    L20:
        r101 = false;
        goto L21
    L13:
        r105 = -1;
    L9:
        r104 = false;
        goto L11
    }

    public ForsetiPopoverViewGroup(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f424693a = f.a(r100, 32.0f);
        f.a(r100, 12.0f);
        this.f424695c = f.a(r100, 636.0f);
        ForsetiPopoverShadowLayout r102 = new ForsetiPopoverShadowLayout(r100, null);
        r102.setId(R.id.forseti_popover_shadow_layout);
        r102.setShadowColor(ContextCompat.getColor(r100, R.color.ud_shadow_s5));
        r102.setShadowSize(UDShadowLayout.Size.S5);
        this.f424697e = r102;
        this.f424699g = ForsetiPageViewType.POPOVER_R_VIEW;
        this.f424700h = new ArrayList();
        addView(r102);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getSize(r111);
        if (getChildCount() <= 0) goto L28;
        boolean r102 = false;
        View r103 = getChildAt(0);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.View");
        int r104 = f.a(getContext(), getPopoverWidthInDp() + 64.0f);
        int r105 = f.a(getContext(), getPopoverHeightInDp() + 64.0f);
        if (r100 >= this.f424695c) goto L9;
        r104 = r100;
    L9:
        if (r100 <= r104) goto L11;
        boolean r106 = true;
    L12:
        boolean r107 = !r106;
        if (this.f424696d == r107) goto L15;
        r102 = true;
    L15:
        if (r102 == false) goto L17;
        this.f424696d = r107;
        requestApplyInsets();
    L17:
        if (r106 == true) goto L20;
        r105 = r101;
    L20:
        if (r102 == false) goto L26;
        ForsetiPopoverShadowLayout r108 = this.f424697e;
        if (this.f424696d == false) goto L24;
        UDShadowLayout.Size r109 = UDShadowLayout.Size.NONE;
    L25:
        r108.setShadowSize(r109);
        goto L26
    L24:
        r109 = UDShadowLayout.Size.S5;
    L26:
        measureChildWithMargins(r103, r110, r100 - r104, r111, r101 - r105);
        setMeasuredDimension(r100, r101);
        return;
    L11:
        r106 = false;
        goto L12
    L28:
        setMeasuredDimension(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
        super.onLayout(r110, r210, r211, r212, r213);
        if (this.f424696d == false) goto L5;
        return;
    L5:
        WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this);
        if (r100 == null) goto L8;
        Insets r101 = r100.getInsets(WindowInsetsCompat.Type.systemBars());
    L9:
        if (r101 == null) goto L11;
        int r102 = r101.top;
    L12:
        if (r101 == null) goto L14;
        int r103 = r101.bottom;
    L15:
        Iterator<View> r104 = ViewGroupKt.getChildren(this).iterator();
    L17:
        if (r104.hasNext() == false) goto L92;
        View r105 = r104.next();
        if ((r105 instanceof ForsetiPopoverShadowLayout) == false) goto L21;
        ForsetiPopoverShadowLayout r106 = (ForsetiPopoverShadowLayout) r105;
    L22:
        Log.d("FST_PopoverViewGroup", "measuredWidth: " + r105.getMeasuredWidth() + ", measuredHeight: " + r105.getMeasuredHeight());
        boolean r107 = r105 instanceof ViewGroup;
        if (r107 == false) goto L25;
        ViewGroup r111 = (ViewGroup) r105;
    L27:
        if (r111 == null) goto L33;
        Sequence<View> r112 = ViewGroupKt.getChildren(r111);
        if (r112 == null) goto L33;
        View r113 = (View) SequencesKt.lastOrNull(r112);
        if (r113 == null) goto L33;
        int r114 = r113.getMeasuredWidth();
    L34:
        if (r107 == false) goto L36;
        ViewGroup r108 = (ViewGroup) r105;
    L37:
        if (r108 == null) goto L43;
        Sequence<View> r109 = ViewGroupKt.getChildren(r108);
        if (r109 == null) goto L43;
        View r115 = (View) SequencesKt.lastOrNull(r109);
        if (r115 == null) goto L43;
        int r116 = r115.getMeasuredHeight();
    L44:
        Activity r117 = ContextsKt.findActivity(getContext());
        if (r117 == null) goto L51;
        Window r118 = r117.getWindow();
        if (r118 == null) goto L51;
        View r119 = a(r118);
        if (r119 == null) goto L51;
        int r120 = r119.getWidth();
    L52:
        Activity r121 = ContextsKt.findActivity(getContext());
        if (r121 == null) goto L59;
        Window r122 = r121.getWindow();
        if (r122 == null) goto L59;
        View r123 = a(r122);
        if (r123 == null) goto L59;
        int r124 = r123.getHeight();
    L60:
        Context r125 = getContext();
        uua.a r126 = this.f424698f;
        if (r126 == null) goto L63;
        vua.a r127 = r126.f551784c;
    L64:
        this.f424694b = eib.a.a(r125, r127, r114, r116, r120, r124);
        Log.d("FST_PopoverViewGroup", "popoverPosition: " + this.f424694b);
        dib.a r128 = this.f424694b;
        if (r128 == null) goto L67;
        int r129 = r128.f468867a;
    L68:
        int r130 = this.f424693a;
        int r131 = r129 - r130;
        if (r128 == null) goto L71;
        int r132 = r128.f468868b;
    L72:
        int r133 = Math.max(r132 - r130, r102);
        dib.a r134 = this.f424694b;
        if (r134 == null) goto L76;
        ArrowDirection r135 = r134.f468869c;
        if (r135 == null) goto L76;
    L77:
        float r136 = 0.0f;
        if (r134 == null) goto L80;
        float r137 = r134.f468870d;
    L81:
        int r138 = this.f424693a;
        float r139 = r138 + r137;
        if (r134 == null) goto L84;
        r136 = r134.f468871e;
    L84:
        dib.a r140 = new dib.a(r131, r133, r135, r139, r136 + r138);
        if (r106 == null) goto L87;
        r106.setPopoverPosition(r140);
    L87:
        int r141 = r140.f468867a;
        int r142 = r105.getMeasuredWidth() + r141;
        int r143 = r213 - r103;
        int r144 = Math.min(r140.f468868b + r105.getMeasuredHeight(), r143);
        if ((r140.f468868b + r105.getMeasuredHeight()) <= r143) goto L90;
        int r145 = r143 - r105.getMeasuredHeight();
    L91:
        r105.layout(r141, r145, r142, r144);
        Log.d("FST_PopoverViewGroup", "onLayout=, child: " + r105 + ", newL: " + r141 + ", newT: " + r145 + ", newR: " + r142 + ", newB: " + r144);
        goto L17
    L90:
        r145 = r140.f468868b;
        goto L91
    L80:
        r137 = 0.0f;
    L76:
        r135 = ArrowDirection.NONE;
        goto L77
    L71:
        r132 = 0;
        goto L72
    L67:
        r129 = 0;
        goto L68
    L63:
        r127 = null;
    L59:
        r124 = -1;
    L51:
        r120 = -1;
    L43:
        r116 = -1;
        goto L44
    L36:
        r108 = null;
    L33:
        r114 = -1;
        goto L34
    L25:
        r111 = null;
        goto L27
    L21:
        r106 = null;
        goto L22
    L92:
        return;
    L14:
        r103 = 0;
        goto L15
    L11:
        r102 = 0;
        goto L12
    L8:
        r101 = null;
        goto L9
    }
}
