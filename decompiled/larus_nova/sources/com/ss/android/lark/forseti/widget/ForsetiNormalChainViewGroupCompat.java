package com.ss.android.lark.forseti.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cib.f;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.lark.api.bean.config.ForsetiMarginType;
import com.ss.android.lark.api.ui.NavigationMode;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainHelper;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forsetiutils.WindowInsetsJitterFixListener;
import com.ss.android.lark.insets.AndroidQInsetsDispatchCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'J\b\u0010)\u001a\u00020\u001fH\u0014J2\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020,H\u0002R\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainViewGroupCompat;", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "systemBottomBarHeight", "setSystemBottomBarHeight", "(I)V", "systemStatusBarHeight", "setSystemStatusBarHeight", "systemBarLeft", "setSystemBarLeft", "systemBarRight", "setSystemBarRight", "isEmbedded", "", "()Z", "mainTabMarginTop", "", "getMainTabMarginTop", "()F", "mainTabMarginBottom", "getMainTabMarginBottom", "()I", "setForsetiDraggingHelper", "", "forsetiColumnsDraggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "setForsetiChainHelper", "forsetiChainHelper", "Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "setForsetiChainConfig", "forsetiChainConfig", "Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "refreshForsetiChainConfig", "layoutFrameLayout", "measureChildWithMargins", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "consumeWindowInsetsForFirstNode", "firstChild", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiNormalChainViewGroupCompat extends ForsetiNormalChainViewGroup {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f424680v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f424681w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f424682x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f424683y;

    public static final class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiNormalChainViewGroupCompat f424684a;

        public a(ForsetiNormalChainViewGroupCompat r100) {
            this.f424684a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "insets");
            Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            ForsetiNormalChainViewGroupCompat.f(this.f424684a, r102.bottom);
            ForsetiNormalChainViewGroupCompat.g(this.f424684a, r102.top);
            int r103 = fib.a.f477428a;
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.window_insets_disabled") == true) goto L5;
            ForsetiNormalChainViewGroupCompat.d(this.f424684a, r102.left);
            ForsetiNormalChainViewGroupCompat.e(this.f424684a, r102.right);
        L5:
            return r101;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f424685a = null;

        static {
            int[] r100 = new int[ForsetiMarginType.values().length];
            r100[ForsetiMarginType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ForsetiMarginType.NONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ForsetiMarginType.CUSTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f424685a = r100;
        }
    }

    static {
    }

    public ForsetiNormalChainViewGroupCompat(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ForsetiNormalChainViewGroupCompat(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup
    public final void a() {
        StringBuilder r100 = new StringBuilder("layoutFrameLayout isEmbedded:");
        LKSplitController r101 = LKSplitController.f409739b;
        r100.append(LKSplitController.a.a().d(ContextsKt.requireActivity(getContext())));
        Log.d("FST_ChainViewGroupCompat", r100.toString());
        if (LKSplitController.a.a().d(ContextsKt.requireActivity(getContext())) == false) goto L23;
        int r102 = getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L28;
        View r104 = getChildAt(r103);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        ViewGroup.MarginLayoutParams r106 = null;
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r105;
    L10:
        if (r107 == null) goto L12;
        int r108 = r107.leftMargin;
    L13:
        ViewGroup.LayoutParams r109 = r104.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r106 = (ViewGroup.MarginLayoutParams) r109;
    L16:
        if (r106 == null) goto L18;
        int r110 = r106.topMargin;
    L19:
        if (r103 != 0) goto L21;
        r104.layout(r108, r110, r104.getMeasuredWidth() + r108, r104.getMeasuredHeight() + r110);
    L22:
        r103 = r103 + 1;
        goto L5
    L21:
        r104.layout(getMeasuredWidth(), r110, getMeasuredWidth() + r104.getMeasuredWidth(), r104.getMeasuredHeight() + r110);
        goto L22
    L18:
        r110 = 0;
        goto L19
    L12:
        r108 = 0;
        goto L13
    L9:
        r107 = null;
        goto L10
    L28:
        return;
    L23:
        super.a();
    }

    private final int getMainTabMarginBottom() {
        return f.a(getContext(), 66.0f) + this.f424680v;
    }

    private final float getMainTabMarginTop() {
        return a08.b.a(f.a(getContext(), 60.0f), getContext()) + this.f424681w;
    }

    private final void setSystemBarLeft(int r100) {
        if (this.f424682x == r100) goto L6;
        this.f424682x = r100;
        requestLayout();
        return;
    }

    private final void setSystemBarRight(int r100) {
        if (this.f424683y == r100) goto L6;
        this.f424683y = r100;
        requestLayout();
        return;
    }

    private final void setSystemBottomBarHeight(int r100) {
        if (this.f424680v == r100) goto L6;
        this.f424680v = r100;
        requestLayout();
        return;
    }

    private final void setSystemStatusBarHeight(int r100) {
        if (this.f424681w == r100) goto L6;
        this.f424681w = r100;
        requestLayout();
        return;
    }

    public final void setForsetiChainConfig(com.ss.android.lark.api.bean.config.a r100) {
        Intrinsics.checkNotNullParameter(r100, "forsetiChainConfig");
        setChainConfig(r100);
    }

    public final void setForsetiChainHelper(ForsetiChainHelper r100) {
        Intrinsics.checkNotNullParameter(r100, "forsetiChainHelper");
        setChainHelper(r100);
    }

    public final void setForsetiDraggingHelper(ForsetiColumnsDraggingHelper r100) {
        Intrinsics.checkNotNullParameter(r100, "forsetiColumnsDraggingHelper");
        setDraggingHelper(r100);
    }

    public static final /* synthetic */ void d(ForsetiNormalChainViewGroupCompat r100, int r101) {
        r100.setSystemBarLeft(r101);
    }

    public static final /* synthetic */ void e(ForsetiNormalChainViewGroupCompat r100, int r101) {
        r100.setSystemBarRight(r101);
    }

    public static final /* synthetic */ void f(ForsetiNormalChainViewGroupCompat r100, int r101) {
        r100.setSystemBottomBarHeight(r101);
    }

    public static final /* synthetic */ void g(ForsetiNormalChainViewGroupCompat r100, int r101) {
        r100.setSystemStatusBarHeight(r101);
    }

    public ForsetiNormalChainViewGroupCompat(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a r103 = new a(this);
        int r104 = AndroidQInsetsDispatchCompat.f427705a;
        Intrinsics.checkNotNullParameter(this, "viewGroup");
        Intrinsics.checkNotNullParameter(r103, PlayerResolution.SDKKEY.ORIGIN);
        OnApplyWindowInsetsListener r105 = r103;
        if (Build.VERSION.SDK_INT > 29) goto L6;
        r105 = new com.ss.android.lark.insets.a(r103, this);
    L6:
        ViewCompat.setOnApplyWindowInsetsListener(this, new WindowInsetsJitterFixListener(r105));
    }

    public /* synthetic */ ForsetiNormalChainViewGroupCompat(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r100, int r110, int r111, int r112, int r113) {
        if (r100 != null) goto L4;
    L60:
        super.measureChildWithMargins(r100, r110, r111, r112, r113);
        return;
    L4:
        if (indexOfChild(r100) != 0) goto L60;
        int r101 = (int) getMainTabMarginTop();
        if (getLastNavMode() == NavigationMode.BOTTOM_MODE) goto L8;
        int r102 = this.f424680v;
    L9:
        com.ss.android.lark.api.bean.config.a r103 = getChainConfig();
        ViewGroup.MarginLayoutParams r104 = null;
        if (r103 == null) goto L14;
        com.ss.android.lark.api.bean.config.c r105 = r103.f408667a;
        if (r105 == null) goto L14;
        ForsetiMarginType r106 = r105.getType();
    L15:
        int r107 = -1;
        if (r106 != null) goto L18;
        int r108 = -1;
    L20:
        if (r108 == 2) goto L31;
        if (r108 != 3) goto L32;
        com.ss.android.lark.api.bean.config.a r109 = getChainConfig();
        if (r109 == null) goto L30;
        com.ss.android.lark.api.bean.config.c r114 = r109.f408667a;
        if (r114 == null) goto L30;
        Integer r115 = r114.f408681b;
        if (r115 == null) goto L30;
        r101 = r115.intValue();
    L30:
        r101 = 0;
    L32:
        com.ss.android.lark.api.bean.config.a r116 = getChainConfig();
        if (r116 == null) goto L37;
        com.ss.android.lark.api.bean.config.c r117 = r116.f408668b;
        if (r117 == null) goto L37;
        ForsetiMarginType r118 = r117.getType();
    L38:
        if (r118 == null) goto L41;
        r107 = c.f424685a[r118.ordinal()];
    L41:
        if (r107 == 2) goto L52;
        if (r107 != 3) goto L53;
        com.ss.android.lark.api.bean.config.a r119 = getChainConfig();
        if (r119 == null) goto L51;
        com.ss.android.lark.api.bean.config.c r120 = r119.f408668b;
        if (r120 == null) goto L51;
        Integer r121 = r120.f408681b;
        if (r121 == null) goto L51;
        r102 = r121.intValue();
    L51:
        r102 = 0;
    L53:
        ViewGroup.LayoutParams r122 = r100.getLayoutParams();
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == false) goto L56;
        r104 = (ViewGroup.MarginLayoutParams) r122;
    L56:
        if (r104 == null) goto L60;
        r104.topMargin = r101;
        r104.bottomMargin = r102;
        int r123 = fib.a.f477428a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.window_insets_disabled") == true) goto L60;
        r104.leftMargin = this.f424682x;
        r104.rightMargin = this.f424683y;
        goto L60
    L52:
        r102 = this.f424680v;
    L37:
        r118 = null;
        goto L38
    L31:
        r101 = this.f424681w;
        goto L32
    L18:
        r108 = c.f424685a[r106.ordinal()];
    L14:
        r106 = null;
        goto L15
    L8:
        r102 = getMainTabMarginBottom();
        goto L9
    }
}
