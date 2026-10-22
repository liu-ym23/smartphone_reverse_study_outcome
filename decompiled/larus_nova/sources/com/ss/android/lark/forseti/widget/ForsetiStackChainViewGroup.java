package com.ss.android.lark.forseti.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cib.f;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.ForsetiStackChainBottomSheetBehaviorV2;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.ss.android.lark.api.bean.ForsetiNodeMode;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.ui.g;
import com.ss.android.lark.api.ui.i;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 V2\u00020\u0001:\u0002VWB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0014J$\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0016J\u0006\u0010?\u001a\u00020\u000eJ\u0010\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020BH\u0014J\u000e\u0010C\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010D\u001a\u000205H\u0014J\b\u0010E\u001a\u000205H\u0002J\b\u0010F\u001a\u000205H\u0002J\u000e\u0010G\u001a\u0002052\u0006\u0010/\u001a\u00020\tJ\u000e\u0010H\u001a\u0002052\u0006\u0010I\u001a\u00020\u000eJ\u000e\u0010J\u001a\u0002052\u0006\u0010I\u001a\u00020\u000eJ\u000e\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020\tJ\u0006\u0010M\u001a\u00020\u0017J\u0016\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u000eJ\u000e\u0010Q\u001a\u0002052\u0006\u0010O\u001a\u00020\u001dJ\u000e\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020\u000eJ\u000e\u0010T\u001a\u0002052\u0006\u0010*\u001a\u00020\tJ\b\u0010U\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b$\u0010 R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010 R$\u0010*\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxHeightInPixelsLevel0", "", "minVerticalPadding", "expandThreshold", "", "isCMode", "", "cModeInitialized", "childHeightGreaterThanThreshold", "Ljava/lang/Boolean;", "peekHeightInPx", "isSkipCollapsed", "forsetiStackStyleChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiStackStyleChangeListener;", "value", "Lcom/ss/android/lark/api/bean/ForsetiPageViewType;", "currentViewType", "setCurrentViewType", "(Lcom/ss/android/lark/api/bean/ForsetiPageViewType;)V", "viewTypeChangeListeners", "", "Lcom/ss/android/lark/api/ui/IForsetiPageViewTypeListener;", "nestedScrollOptimizeDisableFG", "getNestedScrollOptimizeDisableFG", "()Z", "nestedScrollOptimizeDisableFG$delegate", "Lkotlin/Lazy;", "multiStackDisableFG", "getMultiStackDisableFG", "multiStackDisableFG$delegate", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Lcom/ss/android/lark/forseti/widget/ForsetiStackShadowLayout;", "isValidPeekHeight", "Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "style", "getStyle", "()Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "setStyle", "(Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;)V", "pendingBottomSheetState", "swipeToDismissDisabled", "swipeToDismissDisabledV2", "chainHelper", "Lcom/ss/android/lark/forseti/widget/StackChainHelper;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "onViewAdded", "isCModeStatus", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setForsetiStackStyleChangeListener", "onDetachedFromWindow", "triggerDisplayModeChanged", "triggerPageViewTypeChanged", "setPendingBottomSheetState", "setSwipeToDismissDisabled", "disabled", "setSwipeToDismissDisabledV2", "setPeekHeightInPx", "height", "getCurrentPageViewType", "addPageViewTypeChangeListener", "listener", "isSticky", "removePageViewTypeChangeListener", "skipCollapsed", "skip", "updateStyle", "getSystemBarsTop", "Companion", "Style", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiStackChainViewGroup extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f424705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f424706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f424707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f424708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f424709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f424710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f424711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f424712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f424713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ForsetiPageViewType f424714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<g> f424715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f424716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f424717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ForsetiStackShadowLayout f424718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Style f424719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f424720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f424721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f424722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e f424723s;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "HALF_STACK", "STACK", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style HALF_STACK = null;
        public static final Style STACK = null;
        public static final Style UNINITIALIZED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f424724a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f424725b = null;

        public static EnumEntries<Style> getEntries() {
            return f424725b;
        }

        static {
            Style r100 = new Style("UNINITIALIZED", 0);
            UNINITIALIZED = r100;
            Style r101 = new Style("HALF_STACK", 1);
            HALF_STACK = r101;
            Style r102 = new Style("STACK", 2);
            STACK = r102;
            Style[] r103 = {r100, r101, r102};
            f424724a = r103;
            f424725b = EnumEntriesKt.enumEntries(r103);
        }

        public static Style[] values() {
            return (Style[]) f424724a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiStackChainViewGroup f424726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f424727b;

        public a(ForsetiStackChainViewGroup r100, Context r101) {
            this.f424726a = r100;
            this.f424727b = r101;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "insets");
            if (this.f424726a.f424708d == false) goto L23;
            Activity r102 = ContextsKt.findActivity(this.f424727b);
            if (this.f424726a.getStyle() != Style.HALF_STACK) goto L7;
        L16:
            Insets r103 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            ForsetiStackChainViewGroup r104 = this.f424726a;
            r104.setPadding(r104.getPaddingLeft(), r103.top, r104.getPaddingRight(), 0);
            if (ForsetiStackChainViewGroup.a(this.f424726a) == true) goto L27;
            WindowInsetsCompat.Builder r105 = new WindowInsetsCompat.Builder(r101).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r103.left, 0, r103.right, r103.bottom));
            if (this.f424726a.findFocus() != null) goto L26;
            r105.setInsets(WindowInsetsCompat.Type.ime(), Insets.NONE);
        L26:
            return r105.build();
        L27:
            return new WindowInsetsCompat.Builder(r101).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r103.left, 0, r103.right, r103.bottom)).build();
        L7:
            if (this.f424726a.getStyle() != Style.STACK) goto L15;
            if (r102 == null) goto L15;
            LKSplitController r106 = LKSplitController.f409739b;
            if (LKSplitController.a.a().e() == false) goto L12;
            boolean r107 = com.ss.android.lark.base.embedded.b.c(r102);
        L13:
            if (r107 == false) goto L15;
        L12:
            r107 = false;
        L15:
            ForsetiStackChainViewGroup r108 = this.f424726a;
            r108.setPadding(r108.getPaddingLeft(), 0, r108.getPaddingRight(), 0);
            return new WindowInsetsCompat.Builder(r101).build();
        L23:
            Insets r109 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            this.f424726a.setPadding(0, r109.top, 0, r109.bottom);
            View r110 = this.f424726a.getChildAt(0);
            int r111 = Math.max(0, this.f424726a.getMeasuredHeight() - (MathKt.roundToInt(r110.getY()) + r110.getMeasuredHeight()));
            Log.i("FST_StackViewGroup", "this.measuredHeight = " + this.f424726a.getMeasuredHeight() + ", theOnlyChild.y = " + r110.getY() + ", theOnlyChild.measuredHeight = " + r110.getMeasuredHeight());
            Insets r112 = r101.getInsets(WindowInsetsCompat.Type.ime());
            WindowInsetsCompat r113 = new WindowInsetsCompat.Builder(r101).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r109.left, 0, r109.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(0, 0, 0, r112.bottom - r111)).build();
            Log.i("FST_StackViewGroup", "onApplyWindowInsetsListener imeInsets = " + r112 + ", childToBottom = " + r111);
            return r113;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiStackChainViewGroup f424728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f424729b;

        public c(ForsetiStackChainViewGroup r100, boolean r101) {
            this.f424728a = r100;
            this.f424729b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            BottomSheetBehavior r109 = BottomSheetBehavior.from(this.f424728a);
            int r110 = 3;
            if (this.f424728a.getStyle() != Style.HALF_STACK) goto L16;
            ForsetiStackChainViewGroup r111 = this.f424728a;
            if (r111.f424708d == false) goto L16;
            if (this.f424729b == false) goto L16;
            r109.setSkipCollapsed(r111.f424712h);
            ForsetiStackChainViewGroup r112 = this.f424728a;
            int r113 = r112.f424720p;
            if (r113 == 0) goto L12;
            r110 = r113;
        L15:
            r109.setState(r110);
        L20:
            this.f424728a.f424720p = 0;
            return;
        L12:
            if (r112.b() == true) goto L15;
            r110 = 4;
        L16:
            r109.setSkipCollapsed(true);
            int r114 = this.f424728a.f424720p;
            if (r114 == 0) goto L19;
            r110 = r114;
        L19:
            r109.setState(r110);
            goto L20
        }
    }

    static {
    }

    private final boolean getMultiStackDisableFG() {
        return ((Boolean) this.f424717m.getValue()).booleanValue();
    }

    private final boolean getNestedScrollOptimizeDisableFG() {
        return ((Boolean) this.f424716l.getValue()).booleanValue();
    }

    public final boolean b() {
        if (this.f424711g <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getSystemBarsTop() {
        WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this);
        if (r100 == null) goto L7;
        Insets r101 = r100.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r101 == null) goto L7;
        return r101.top;
    L7:
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f424713i = null;
    }

    public final ForsetiPageViewType getCurrentPageViewType() {
        return this.f424714j;
    }

    public final Style getStyle() {
        return this.f424719o;
    }

    public ForsetiStackChainViewGroup(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ boolean a(ForsetiStackChainViewGroup r100) {
        return r100.getMultiStackDisableFG();
    }

    private final void setCurrentViewType(ForsetiPageViewType r100) {
        if (this.f424714j == r100) goto L8;
        this.f424714j = r100;
        Iterator<T> r101 = this.f424715k.iterator();
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
        if (this.f424708d == false) goto L35;
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
        if (this.f424708d == false) goto L45;
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
        if (this.f424708d == true) goto L52;
        ForsetiPageViewType r114 = ForsetiPageViewType.MODAL_R_VIEW;
    L56:
        if (this.f424714j == r114) goto L63;
        setCurrentViewType(r114);
        return;
    L63:
        return;
    L52:
        if (this.f424719o != Style.HALF_STACK) goto L54;
        r114 = ForsetiPageViewType.MODAL_C_HALF_VIEW;
        goto L56
    L54:
        r114 = ForsetiPageViewType.MODAL_C_FULL_VIEW;
        goto L56
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

    public final void setForsetiStackStyleChangeListener(i r100) {
        Intrinsics.checkNotNullParameter(r100, "forsetiStackStyleChangeListener");
        this.f424713i = r100;
    }

    public final void setPeekHeightInPx(int r100) {
        if (r100 == this.f424711g) goto L6;
        this.f424711g = r100;
        requestLayout();
        return;
    }

    public final void setPendingBottomSheetState(int r100) {
        this.f424720p = r100;
    }

    public final void setStyle(Style r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f424719o = r100;
        BottomSheetBehavior r101 = BottomSheetBehavior.from(this);
        r101.setHideable(true);
        if (this.f424709e == false) goto L5;
        this.f424709e = false;
        return;
    L5:
        r101.setState(5);
    }

    public final void setSwipeToDismissDisabled(boolean r100) {
        this.f424721q = r100;
    }

    public final void setSwipeToDismissDisabledV2(boolean r100) {
        this.f424722r = r100;
    }

    public ForsetiStackChainViewGroup(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f424705a = f.a(r100, 900.0f);
        this.f424706b = f.a(r100, 8.0f);
        this.f424707c = 0.75f;
        this.f424714j = ForsetiPageViewType.MODAL_R_VIEW;
        this.f424715k = new ArrayList();
        this.f424716l = LazyKt.lazy(ForsetiStackChainViewGroup$nestedScrollOptimizeDisableFG$2.INSTANCE);
        this.f424717m = LazyKt.lazy(ForsetiStackChainViewGroup$multiStackDisableFG$2.INSTANCE);
        ForsetiStackShadowLayout r102 = new ForsetiStackShadowLayout(r100, null);
        r102.setId(R.id.forseti_stack_chain_shadow_layout);
        r102.setShadowColor(ContextCompat.getColor(r100, R.color.ud_shadow_s5));
        r102.setShadowSize(UDShadowLayout.Size.S5);
        this.f424718n = r102;
        this.f424719o = Style.UNINITIALIZED;
        this.f424723s = new e(r100);
        addView(r102);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this, r100));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getSize(r111);
        if (getChildCount() <= 0) goto L130;
        View r102 = getChildAt(0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
        e r103 = this.f424723s;
        r103.getClass();
        if (Math.min(r100, r101) < r103.f424746c) goto L10;
        int r104 = r103.f424745b;
        if (r100 < ((r103.f424744a * 2) + r104)) goto L10;
    L12:
        if (r100 <= r104) goto L14;
        boolean r105 = true;
    L15:
        boolean r106 = !r105;
        if (this.f424709e == true) goto L18;
    L21:
        boolean r112 = true;
    L22:
        if (r112 == false) goto L24;
        this.f424708d = r106;
        this.f424709e = true;
        requestApplyInsets();
    L24:
        if (r105 == false) goto L28;
        int r107 = this.f424705a;
        int r108 = r101 - r107;
        int r109 = this.f424706b * 2;
        if (r108 >= r109) goto L29;
        r107 = r101 - r109;
    L29:
        if (r112 == false) goto L77;
        ForsetiStackShadowLayout r113 = this.f424718n;
        if (this.f424708d == false) goto L33;
        UDShadowLayout.Size r114 = UDShadowLayout.Size.NONE;
    L34:
        r113.setShadowSize(r114);
        if (getMultiStackDisableFG() == false) goto L37;
    L41:
        BottomSheetBehavior r115 = BottomSheetBehavior.from(this);
        Style r116 = this.f424719o;
        Style r117 = Style.STACK;
        if (r116 != r117) goto L44;
        r115.setDraggable(!this.f424708d);
    L46:
        if (getNestedScrollOptimizeDisableFG() == false) goto L55;
        if (this.f424721q == false) goto L51;
        r115.setDraggable(false);
        goto L55
    L51:
        if (this.f424719o != r117) goto L53;
        r115.setDraggable(!this.f424708d);
        goto L55
    L53:
        r115.setDraggable(true);
    L55:
        if (this.f424722r == false) goto L58;
        r115.setDraggable(false);
    L58:
        if ((r115 instanceof ForsetiStackChainBottomSheetBehaviorV2) == false) goto L60;
        ForsetiStackChainBottomSheetBehaviorV2 r118 = (ForsetiStackChainBottomSheetBehaviorV2) r115;
    L61:
        if (r118 == null) goto L63;
        r118.setDisableSheetBehavior(this.f424722r);
    L63:
        ViewGroup.LayoutParams r119 = r102.getLayoutParams();
        if (r119 == null) goto L75;
        FrameLayout.LayoutParams r120 = (FrameLayout.LayoutParams) r119;
        if (this.f424719o == Style.HALF_STACK) goto L68;
    L70:
        int r121 = 17;
    L71:
        r120.gravity = r121;
        r102.setLayoutParams(r120);
        i r122 = this.f424713i;
        if (r122 == null) goto L77;
        r122.a(this.f424708d);
        goto L77
    L68:
        if (this.f424708d == false) goto L70;
        r121 = 80;
        goto L71
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L60:
        r118 = null;
        goto L61
    L44:
        r115.setDraggable(true);
        goto L46
    L37:
        if (this.f424719o != Style.HALF_STACK) goto L41;
        if (this.f424708d == false) goto L41;
        this.f424718n.setIsHalfDisplay(true);
        goto L41
    L33:
        r114 = UDShadowLayout.Size.S5;
    L77:
        if (b() == true) goto L79;
    L83:
        int r123 = View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE);
    L84:
        int r124 = r100 - r104;
        Style r125 = this.f424719o;
        if (r125 != Style.STACK) goto L87;
    L94:
        int r126 = r111;
    L95:
        measureChildWithMargins(r102, r110, r124, r126, r101 - r107);
        setMeasuredDimension(r100, r101);
        if (r102.getMeasuredHeight() > (getMeasuredHeight() * this.f424707c)) goto L98;
    L100:
        boolean r127 = false;
    L101:
        boolean r128 = !Intrinsics.areEqual(this.f424710f, Boolean.valueOf(r127));
        this.f424710f = Boolean.valueOf(r127);
        if (r112 == true) goto L107;
        if (r128 == true) goto L107;
        if (b() == true) goto L107;
        return;
    L107:
        if (isLaidOut() == true) goto L109;
    L128:
        addOnLayoutChangeListener(new c(this, r127));
        return;
    L109:
        if (isLayoutRequested() == true) goto L128;
        BottomSheetBehavior r129 = BottomSheetBehavior.from(this);
        int r130 = 3;
        if (getStyle() == Style.HALF_STACK) goto L113;
    L123:
        r129.setSkipCollapsed(true);
        int r131 = this.f424720p;
        if (r131 == 0) goto L126;
        r130 = r131;
    L126:
        r129.setState(r130);
    L127:
        this.f424720p = 0;
        return;
    L113:
        if (this.f424708d == false) goto L123;
        if (r127 == false) goto L123;
        r129.setSkipCollapsed(this.f424712h);
        int r132 = this.f424720p;
        if (r132 == 0) goto L119;
        r130 = r132;
    L122:
        r129.setState(r130);
        goto L127
    L119:
        if (b() == true) goto L122;
        r130 = 4;
        goto L122
    L98:
        if (getMeasuredHeight() < this.f424723s.f424746c) goto L100;
        r127 = true;
        goto L101
    L87:
        if (r125 == Style.HALF_STACK) goto L89;
    L93:
        r126 = r123;
        goto L95
    L89:
        if (this.f424708d == true) goto L93;
        if (b() == false) goto L93;
    L79:
        if (this.f424719o != Style.HALF_STACK) goto L83;
        if (this.f424708d == false) goto L83;
        r123 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(this.f424711g + getSystemBarsTop(), r101), 1073741824);
        goto L84
    L28:
        r107 = r101;
        goto L29
    L18:
        if (this.f424708d != r106) goto L21;
        r112 = false;
        goto L22
    L14:
        r105 = false;
    L10:
        r104 = r100;
        goto L12
    L130:
        setMeasuredDimension(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
    L6:
        if (r103 != null) goto L8;
        Log.e("FST_StackViewGroup", "params convert to LayoutParams returns null, set center gravity failed.");
    L9:
        super.addView(r100, r101, r103);
        return;
    L8:
        r103.gravity = 17;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
