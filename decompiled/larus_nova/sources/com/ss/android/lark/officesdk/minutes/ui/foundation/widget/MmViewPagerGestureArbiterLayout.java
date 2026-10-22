package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u00039:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010)\u001a\u00020&J\b\u0010*\u001a\u00020&H\u0014J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020&H\u0002J\u001a\u00100\u001a\u00020&2\b\b\u0002\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u0011H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u00132\u0006\u00106\u001a\u00020\u0001H\u0002J\u0010\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "orientationBiasRatio", "", "manualSwitchThreshold", "conflictChild", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$PagingConflictChild;", "conflictChildTag", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "gestureSessionId", "requestSeq", "activePointerId", "downX", "downY", "lastX", "lastY", "gestureOrientation", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$GestureOrientation;", "currentDirection", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$ScrollDirection;", "currentDirectionCanScroll", "", "Ljava/lang/Boolean;", "pendingDirection", "activeChildSnapshot", "manualSwitchConsumed", "bindPagingConflictChild", "", "tag", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "clearPagingConflictChild", "onAttachedToWindow", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "handleTouchEvent", "maybeTriggerManualPageSwitch", "syncViewPagerUserInputEnabled", "active", "reason", "resetGestureState", "from", "findDescendantViewPager2", RootDescription.ROOT_ELEMENT, "actionToString", "action", "PagingConflictChild", "ScrollDirection", "GestureOrientation", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmViewPagerGestureArbiterLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f435726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f435727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f435728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f435729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f435730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager2 f435731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f435732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f435733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f435734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f435735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f435736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f435737l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public GestureOrientation f435738m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ScrollDirection f435739n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f435740o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScrollDirection f435741p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f435742q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f435743r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$GestureOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Unknown", "Horizontal", "Vertical", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GestureOrientation extends Enum<GestureOrientation> {
        public static final GestureOrientation Horizontal = null;
        public static final GestureOrientation Unknown = null;
        public static final GestureOrientation Vertical = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GestureOrientation[] f435744a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f435745b = null;

        public static EnumEntries<GestureOrientation> getEntries() {
            return f435745b;
        }

        static {
            GestureOrientation r100 = new GestureOrientation("Unknown", 0);
            Unknown = r100;
            GestureOrientation r101 = new GestureOrientation("Horizontal", 1);
            Horizontal = r101;
            GestureOrientation r102 = new GestureOrientation("Vertical", 2);
            Vertical = r102;
            GestureOrientation[] r103 = {r100, r101, r102};
            f435744a = r103;
            f435745b = EnumEntriesKt.enumEntries(r103);
        }

        public static GestureOrientation[] values() {
            return (GestureOrientation[]) f435744a.clone();
        }

        public static GestureOrientation valueOf(String r100) {
            return (GestureOrientation) r27.a.a(GestureOrientation.class, r100);
        }

        public GestureOrientation(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmViewPagerGestureArbiterLayout$ScrollDirection;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "Left", "Right", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection Left = null;
        public static final ScrollDirection Right = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollDirection[] f435746a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f435747b = null;
        private final String rawValue;

        public static EnumEntries<ScrollDirection> getEntries() {
            return f435747b;
        }

        static {
            ScrollDirection r100 = new ScrollDirection("Left", 0, "left");
            Left = r100;
            ScrollDirection r101 = new ScrollDirection("Right", 1, "right");
            Right = r101;
            ScrollDirection[] r102 = {r100, r101};
            f435746a = r102;
            f435747b = EnumEntriesKt.enumEntries(r102);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) f435746a.clone();
        }

        public final String getRawValue() {
            return this.rawValue;
        }

        public static ScrollDirection valueOf(String r100) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r100);
        }

        public ScrollDirection(String r100, int r101, String r102) {
            super(r100, r101);
            this.rawValue = r102;
        }
    }

    public interface a {
        void a(ScrollDirection r100, int r101, int r102, Function1<? super Boolean, Unit> r103);

        boolean isActive();
    }

    public MmViewPagerGestureArbiterLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MmViewPagerGestureArbiterLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f435734i = -1;
        this.f435735j = 0.0f;
        this.f435736k = 0.0f;
        this.f435737l = 0.0f;
        this.f435738m = GestureOrientation.Unknown;
        this.f435739n = null;
        this.f435740o = null;
        this.f435741p = null;
        this.f435742q = false;
        this.f435743r = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = getChildCount();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L9;
        View r102 = getChildAt(r101);
        if ((r102 instanceof ViewPager2) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        ViewPager2 r103 = (ViewPager2) r102;
    L10:
        this.f435731f = r103;
        int r104 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onAttachedToWindow", "viewPager2=" + this.f435731f, null, 8);
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r210) {
        Intrinsics.checkNotNullParameter(r210, "ev");
        ViewPager2 r100 = this.f435731f;
        if (r100 != null) goto L11;
        int r101 = getChildCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L10;
        View r103 = getChildAt(r102);
        if ((r103 instanceof ViewPager2) == true) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        r100 = (ViewPager2) r103;
        goto L11
    L10:
        r100 = null;
    L11:
        this.f435731f = r100;
        a r104 = this.f435729d;
        if (r104 != null) goto L14;
    L16:
        boolean r105 = false;
    L17:
        StringBuilder r106 = new StringBuilder("dispatch_");
        int r107 = r210.getActionMasked();
        if (r107 == 0) goto L28;
        if (r107 == 1) goto L27;
        if (r107 == 2) goto L26;
        if (r107 == 3) goto L25;
        if (r107 == 6) goto L24;
        String r108 = "ACTION_" + r107;
    L29:
        r106.append(r108);
        b(r105, r106.toString());
        if (r105 == true) goto L32;
        a();
    L136:
        return super.dispatchTouchEvent(r210);
    L32:
        if (r104 != null) goto L34;
        int r109 = bwb.b.f21271a;
        bwb.b.h(MmUiLogScene.FOUNDATION, "handleTouchEvent", "active child expected but conflictChild is null", null);
        a();
        goto L136
    L34:
        int r110 = r210.getActionMasked();
        if (r110 != 0) goto L37;
        this.f435732g++;
        this.f435733h = 0;
        this.f435734i = r210.getPointerId(0);
        this.f435735j = r210.getX();
        this.f435736k = r210.getY();
        this.f435737l = r210.getX();
        r210.getY();
        this.f435738m = GestureOrientation.Unknown;
        this.f435739n = null;
        this.f435740o = null;
        this.f435741p = null;
        this.f435743r = false;
        this.f435742q = true;
        int r111 = bwb.b.f21271a;
        MmUiLogScene r112 = MmUiLogScene.FOUNDATION;
        StringBuilder r113 = new StringBuilder("gestureSession=");
        r113.append(this.f435732g);
        r113.append(", x=");
        r113.append(r210.getX());
        r113.append(", y=");
        r113.append(r210.getY());
        r113.append(", childTag=");
        r113.append(this.f435730e);
        r113.append(", currentItem=");
        ViewPager2 r114 = this.f435731f;
        if (r114 == null) goto L133;
        Integer r115 = Integer.valueOf(r114.getCurrentItem());
    L134:
        r113.append(r115);
        bwb.b.g(r112, "ACTION_DOWN", r113.toString(), null, 8);
        goto L136
    L133:
        r115 = null;
        goto L134
    L37:
        if (r110 != 1) goto L39;
        int r116 = bwb.b.f21271a;
        MmUiLogScene r117 = MmUiLogScene.FOUNDATION;
        bwb.b.g(r117, "ACTION_UP", "gestureSession=" + this.f435732g, null, 8);
        if (this.f435742q == true) goto L94;
    L129:
        a();
        goto L136
    L94:
        if (this.f435743r == true) goto L129;
        if (this.f435738m != GestureOrientation.Horizontal) goto L129;
        ScrollDirection r118 = this.f435739n;
        if (r118 == null) goto L129;
        Boolean r119 = this.f435740o;
        if (r119 != null) goto L106;
        bwb.b.h(r117, "maybeTriggerManualPageSwitch", "skip, canScroll result pending, direction=" + r118, null);
        goto L129
    L106:
        if (r119.booleanValue() == true) goto L129;
        float r120 = this.f435737l - this.f435735j;
        if (Math.abs(r120) >= this.f435728c) goto L111;
        bwb.b.g(r117, "maybeTriggerManualPageSwitch", "skip, swipe too short, dx=" + r120 + ", threshold=" + this.f435728c + ", direction=" + r118, null, 8);
        goto L129
    L111:
        ViewPager2 r121 = this.f435731f;
        if (r121 != null) goto L114;
        bwb.b.h(r117, "maybeTriggerManualPageSwitch", "skip, viewPager2 is null", null);
        goto L129
    L114:
        RecyclerView.Adapter r122 = r121.getAdapter();
        if (r122 != null) goto L117;
        bwb.b.h(r117, "maybeTriggerManualPageSwitch", "skip, adapter is null", null);
        goto L129
    L117:
        int r123 = r122.getItemCount();
        int r124 = r121.getCurrentItem();
        if (r118 != ScrollDirection.Left) goto L120;
        int r125 = r124 + 1;
    L121:
        if (r125 < 0) goto L124;
        if (r125 >= r123) goto L124;
        boolean r126 = true;
    L126:
        if (r126 == true) goto L128;
        bwb.b.g(r117, "maybeTriggerManualPageSwitch", "skip, target out of bounds, currentItem=" + r124 + ", targetItem=" + r125 + ", pageCount=" + r123 + ", direction=" + r118, null, 8);
        goto L129
    L128:
        this.f435743r = true;
        bwb.b.g(r117, "maybeTriggerManualPageSwitch", "trigger manual page switch, currentItem=" + r124 + ", targetItem=" + r125 + ", direction=" + r118 + ", dx=" + r120, null, 8);
        r121.setCurrentItem(r125, true);
    L124:
        r126 = false;
        goto L126
    L120:
        r125 = r124 - 1;
        goto L121
    L39:
        if (r110 != 2) goto L41;
        int r127 = this.f435734i;
        if (r127 == (-1)) goto L136;
        int r128 = r210.findPointerIndex(r127);
        if (r128 >= 0) goto L55;
        int r129 = bwb.b.f21271a;
        bwb.b.h(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "invalid pointerIndex, activePointerId=" + this.f435734i, null);
        goto L136
    L55:
        float r130 = r210.getX(r128);
        float r131 = r210.getY(r128);
        this.f435737l = r130;
        float r132 = r130 - this.f435735j;
        float r133 = r131 - this.f435736k;
        float r134 = Math.abs(r132);
        float r135 = Math.abs(r133);
        if (this.f435738m != GestureOrientation.Unknown) goto L74;
        float r136 = this.f435726a;
        if (r134 > r136) goto L63;
        if (r135 <= r136) goto L136;
    L63:
        if (r135 > r136) goto L65;
    L67:
        if (r134 <= r136) goto L136;
        if (r134 <= (r135 * this.f435727b)) goto L136;
        this.f435738m = GestureOrientation.Horizontal;
        int r137 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "horizontal gesture locked, gestureSession=" + this.f435732g + ", dx=" + r132 + ", dy=" + r133 + ", ratio=" + this.f435727b, null, 8);
        goto L74
    L65:
        if (r135 <= (this.f435727b * r134)) goto L67;
        this.f435738m = GestureOrientation.Vertical;
        int r138 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "vertical gesture locked, gestureSession=" + this.f435732g + ", dx=" + r132 + ", dy=" + r133 + ", ratio=" + this.f435727b, null, 8);
    L74:
        if (this.f435738m != GestureOrientation.Horizontal) goto L136;
        if (r132 >= 0.0f) goto L79;
        final ScrollDirection r139 = ScrollDirection.Left;
    L81:
        if (r139 == this.f435739n) goto L84;
        int r140 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "direction changed, gestureSession=" + this.f435732g + ", old=" + this.f435739n + ", new=" + r139 + ", x=" + r130 + ", y=" + r131, null, 8);
        this.f435739n = r139;
        this.f435740o = null;
        this.f435741p = null;
    L84:
        if (this.f435740o != null) goto L136;
        if (this.f435741p == r139) goto L136;
        final int r141 = this.f435733h + 1;
        this.f435733h = r141;
        final int r142 = this.f435732g;
        this.f435741p = r139;
        int r143 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_MOVE", "request child canScroll, gestureSession=" + r142 + ", request=" + r141 + ", direction=" + r139 + ", startX=" + ((int) this.f435735j) + ", startY=" + ((int) this.f435736k) + ", currentX=" + ((int) r130) + ", currentY=" + ((int) r131) + ", childTag=" + this.f435730e, null, 8);
        r104.a(r139, (int) this.f435735j, (int) this.f435736k, new MmViewPagerGestureArbiterLayout$handleTouchEvent$1(r142, this, r141, r139));
        goto L136
    L79:
        r139 = ScrollDirection.Right;
        goto L81
    L41:
        if (r110 != 3) goto L43;
        int r144 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_CANCEL", "gestureSession=" + this.f435732g, null, 8);
        a();
        goto L136
    L43:
        if (r110 != 6) goto L136;
        int r145 = r210.getPointerId(r210.getActionIndex());
        if (r145 != this.f435734i) goto L136;
        int r146 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "ACTION_POINTER_UP", "active pointer released, pointerId=" + r145, null, 8);
        this.f435734i = -1;
        goto L136
    L24:
        r108 = "ACTION_POINTER_UP";
        goto L29
    L25:
        r108 = "ACTION_CANCEL";
        goto L29
    L26:
        r108 = "ACTION_MOVE";
        goto L29
    L27:
        r108 = "ACTION_UP";
        goto L29
    L28:
        r108 = "ACTION_DOWN";
        goto L29
    L14:
        if (r104.isActive() != true) goto L16;
        r105 = true;
        goto L17
    }

    public final void b(boolean r100, String r101) {
        ViewPager2 r102 = this.f435731f;
        if (r102 != null) goto L5;
        return;
    L5:
        boolean r103 = !r100;
        if (r102.isUserInputEnabled() != r103) goto L8;
        return;
    L8:
        int r104 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "syncViewPagerUserInputEnabled", "reason=" + r101 + ", enabled=" + r103, null, 8);
        r102.setUserInputEnabled(r103);
    }

    public MmViewPagerGestureArbiterLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f435726a = r103;
        this.f435727b = 1.2f;
        this.f435728c = r103 * 2;
        this.f435730e = "unset";
        this.f435734i = -1;
        this.f435738m = GestureOrientation.Unknown;
    }

    public /* synthetic */ MmViewPagerGestureArbiterLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
