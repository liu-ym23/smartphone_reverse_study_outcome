package com.ss.android.lark.quicklaunchbar.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import androidx.window.layout.WindowMetricsCalculator;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.quicklaunchbar.databinding.QuickLaunchBarBinding;
import com.ss.android.lark.quicklaunchbar.databinding.QuickLaunchBarIconItemBinding;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 X2\u00020\u0001:\u0002XYB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u0016\u0010$\u001a\u00020\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0017J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\fH\u0017J \u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0016\u0010+\u001a\u00020\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0017J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\fH\u0017J \u0010,\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000fH\u0007J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000fH\u0007J\u0010\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0011H\u0017J\u0010\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0011H\u0017J\u0010\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0018H\u0007J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0007J\u0018\u00108\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u0007H\u0007J\u0006\u0010;\u001a\u00020\u0007J \u0010<\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\fH\u0002J \u0010@\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000fH\u0002J\u0018\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020F2\u0006\u0010)\u001a\u00020\fH\u0002J\"\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J(\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020\u001fH\u0002J\b\u0010P\u001a\u00020\u001fH\u0002J\b\u0010Q\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020\u001fH\u0002J\b\u0010S\u001a\u00020\u001fH\u0002J\b\u0010T\u001a\u00020\u001fH\u0002J\u0012\u0010U\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010WH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/ss/android/lark/quicklaunchbar/widget/QuickLaunchBar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rightItems", "", "Lcom/ss/android/lark/quicklaunchbar/model/QuickLaunchBarItem;", "leftItems", "isItemNameVisible", "", "leftItemClickListener", "Lcom/ss/android/lark/quicklaunchbar/widget/QuickLaunchBar$OnItemClickListener;", "rightItemClickListener", "viewBinding", "Lcom/ss/android/lark/quicklaunchbar/databinding/QuickLaunchBarBinding;", "isSkeletonVisible", "isLaunchBarShow", "scrollContentView", "Landroid/view/View;", "pageScrollY", "pageScrollJob", "Lkotlinx/coroutines/Job;", "cacheScrollY", "cacheOldScrollY", "onSizeChanged", "", "w", "h", "oldw", "oldh", "setLeftItems", "items", "", "updateLeftItem", "position", MapController.ITEM_LAYER_TAG, "needCheckOverWidth", "setRightItems", "updateRightItem", "setSkeletonVisible", "visible", "setItemNameVisible", "setOnLeftItemClickListener", "listener", "setOnRightItemClickListener", "setScrollContentView", "view", "onPageScrollChange", "scrollY", "oldScrollY", "handlePageScrollDelay", "onPageScrolled", "dy", "getQuickLaunchBarHeight", "buildItemView", "isLeft", "index", "buildIconItemView", "buildButtonItemView", "buttonAttrs", "Lcom/ss/android/lark/quicklaunchbar/model/QuickLaunchBarItem$ButtonAttrs;", "isJustMeasure", "bindItemIcon", "ivIcon", "Landroid/widget/ImageView;", "bindBadge", "dotView", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "textView", IAllianceService.CONTENT_TYPE_BADGE, "Lcom/ss/android/lark/quicklaunchbar/model/QuickLaunchBarItem$Badge;", "bindItemClick", "itemView", "updateItemMargin", "checkOverWidth", "getItemTotalMargin", "updateItemNameVisibility", "hideLaunchBar", "showLaunchBar", "getContainerWidth", "activityContext", "Landroid/app/Activity;", "Companion", "OnItemClickListener", "quick-launch-bar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class QuickLaunchBar extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f439134g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j2c.a> f439135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j2c.a> f439136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f439137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final QuickLaunchBarBinding f439138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f439139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f439140f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickLaunchBar f439141a;

        public b(QuickLaunchBar r100) {
            this.f439141a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            QuickLaunchBar r100 = this.f439141a;     // Catch: Throwable -> L4
            int r101 = QuickLaunchBar.f439134g;     // Catch: Throwable -> L4
            r100.f();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickLaunchBar f439142a;

        public c(QuickLaunchBar r100) {
            this.f439142a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ViewGroup.LayoutParams r101 = this.f439142a.f439138d.f439127a.getLayoutParams();
            if (r101 == null) goto L5;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.height = ((Integer) r102).intValue();
        L5:
            this.f439142a.requestLayout();
        }
    }

    static {
    }

    public QuickLaunchBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public QuickLaunchBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getItemTotalMargin() {
        List r100 = CollectionsKt.plus(this.f439136b, this.f439135a);
        if (r100.size() == this.f439138d.f439128b.getChildCount()) goto L5;
        return 0;
    L5:
        UIHelper.dp2px(16.0f);
        Iterator r101 = r100.iterator();
        if (r101.hasNext() == true) goto L8;
        return 0;
    L8:
        j2c.a r102 = (j2c.a) r101.next();
        j2c.a r103 = (j2c.a) CollectionsKt.getOrNull(r100, -1);
        r102.getClass();
        throw null;
    }

    public final void f() {
        List r100 = CollectionsKt.plus(this.f439136b, this.f439135a);
        if (r100.size() == this.f439138d.f439128b.getChildCount()) goto L5;
        return;
    L5:
        List r101 = r100;
        boolean r102 = r101 instanceof Collection;
        if (r102 == true) goto L8;
    L10:
        Iterator r103 = r101.iterator();
        if (r103.hasNext() == false) goto L13;
        ((j2c.a) r103.next()).getClass();
        throw null;
    L13:
        if (0 > 0) goto L16;
        Log.i("QuickLaunchBar", "checkOverWidth, button item count is 0, ignore");
        return;
    L16:
        if (r102 == true) goto L18;
    L20:
        Iterator r104 = r101.iterator();
        if (r104.hasNext() == false) goto L23;
        ((j2c.a) r104.next()).getClass();
        throw null;
    L23:
        if (0 > 0) goto L27;
        Log.i("QuickLaunchBar", "checkOverWidth, icon item count is 0, ignore");
        return;
    L27:
        if (getWidth() <= 0) goto L29;
        int r105 = getWidth();
        Log.i("QuickLaunchBar", "checkOverWidth, parentWidth use view width: " + r105);
    L41:
        if (r105 > 0) goto L43;
        return;
    L43:
        Iterator r106 = r101.iterator();
    L45:
        if (r106.hasNext() == false) goto L51;
        Object r107 = null;
        ((j2c.a) r106.next()).getClass();
        if ((r107 instanceof j2c.a.e.C6389a) == false) goto L45;
        j2c.a.e.C6389a r108 = (j2c.a.e.C6389a) null;
        throw null;
    L51:
        Log.i("QuickLaunchBar", "checkOverWidth, button items total width is 0, ignore");
        return;
    L29:
        Activity r109 = ContextsKt.findActivity(getContext());
        if (Build.VERSION.SDK_INT < 29) goto L35;
        if (r109 == null) goto L35;
        int r110 = WindowMetricsCalculator.Companion.getOrCreate().computeCurrentWindowMetrics(r109).getBounds().width();
        if (r110 <= 0) goto L35;
    L36:
        StringBuilder r111 = new StringBuilder("checkOverWidth, parentWidth use window width: ");
        r111.append(r110);
        r111.append(" con:");
        if (r109 != null) goto L39;
        boolean r112 = true;
    L40:
        r111.append(r112);
        Log.i("QuickLaunchBar", r111.toString());
        r105 = r110;
        goto L41
    L39:
        r112 = false;
    L35:
        Object r113 = getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics r114 = new DisplayMetrics();
        ((WindowManager) r113).getDefaultDisplay().getMetrics(r114);
        r110 = r114.widthPixels;
        goto L36
    L18:
        if (r101.isEmpty() == false) goto L20;
    L8:
        if (r101.isEmpty() == false) goto L10;
        goto L10
    }

    public final void g() {
        if (this.f439139e == true) goto L6;
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{0, getQuickLaunchBarHeight()});
        r100.addUpdateListener(new c(this));
        r100.setDuration(300);
        r100.start();
        this.f439139e = true;
        return;
    }

    public final int getQuickLaunchBarHeight() {
        if (this.f439137c == false) goto L6;
        return getResources().getDimensionPixelSize(R.dimen.quick_launch_bar_height_with_name);
    L6:
        return getResources().getDimensionPixelSize(R.dimen.quick_launch_bar_height);
    }

    public final void h() {
        List r100 = CollectionsKt.plus(this.f439136b, this.f439135a);
        if (r100.size() == this.f439138d.f439128b.getChildCount()) goto L5;
        return;
    L5:
        int r101 = UIHelper.dp2px(16.0f);
        LinearLayout r102 = this.f439138d.f439128b;
        int r103 = r102.getChildCount();
        int r104 = 0;
        int r105 = -1;
    L6:
        if (r104 >= r103) goto L28;
        View r106 = r102.getChildAt(r104);
        j2c.a r107 = (j2c.a) ListProtector.get(r100, r104);
        j2c.a r108 = (j2c.a) CollectionsKt.getOrNull(r100, r105);
        ViewGroup.LayoutParams r109 = r106.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
    L11:
        if (r110 == null) goto L13;
        r110.leftMargin = 0;
    L13:
        if (r110 == null) goto L16;
        r110.rightMargin = 0;
    L16:
        if (r107.b() == false) goto L26;
        if (r110 == null) goto L20;
        r110.leftMargin = r101;
    L20:
        if (r104 != (this.f439138d.f439128b.getChildCount() - 1)) goto L25;
        if (r107.b() == false) goto L25;
        if (r110 == null) goto L25;
        r110.rightMargin = r101;
    L25:
        r105 = r104;
        r104 = r104 + 1;
        goto L6
    L26:
        r107.getClass();
        throw null;
    L10:
        r110 = null;
        goto L11
    L28:
        requestLayout();
    }

    public final View d(j2c.a r100) {
        int r101 = 0;
        QuickLaunchBarIconItemBinding r102 = QuickLaunchBarIconItemBinding.a(LayoutInflater.from(getContext()).inflate(R.layout.quick_launch_bar_icon_item, this.f439138d.f439128b, false));
        b(r102.f439132d, r100);
        UDBadgeView r103 = r102.f439130b;
        UDBadgeView r104 = r102.f439131c;
        r100.getClass();
        a(r103, r104, null);
        TextView r105 = r102.f439133e;
        r100.getClass();
        r105.setText(null);
        TextView r106 = r102.f439133e;
        if (this.f439137c == true) goto L6;
        r101 = 8;
    L6:
        r106.setVisibility(r101);
        return r102.f439129a;
    }

    public static void b(ImageView r100, j2c.a r101) {
        int r102 = r101.a().f497061a;
        Integer r103 = r101.a().f497062b;
        r101.a().getClass();
        r101.a().getClass();
        r100.setImageResource(r102);
        if (r103 == null) goto L6;
        r100.setImageTintList(ColorStateList.valueOf(r103.intValue()));
        return;
    }

    public QuickLaunchBar(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        ArrayList r111 = new ArrayList();
        this.f439135a = r111;
        ArrayList r102 = new ArrayList();
        this.f439136b = r102;
        this.f439139e = true;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.quick_launch_bar, this, false);
        addView(r103);
        int r104 = R.id.itemContainer;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.itemContainer);
        if (r105 == null) goto L16;
        r104 = R.id.skeletonContainer;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.skeletonContainer);
        if (r106 == null) goto L16;
        FrameLayout r107 = (FrameLayout) r103;
        this.f439138d = new QuickLaunchBarBinding(r107, r105, r106);
        TypedArray r108 = r100.obtainStyledAttributes(r101, new int[]{R.attr.itemNameVisible});
        this.f439137c = r108.getBoolean(0, false);
        r108.recycle();
        r107.getLayoutParams().height = getQuickLaunchBarHeight();
        r105.getLayoutParams().height = getQuickLaunchBarHeight();
        r106.getLayoutParams().height = getQuickLaunchBarHeight();
        List r109 = CollectionsKt.plus(r102, r111);
        int r112 = r105.getChildCount();
        int r113 = 0;
    L7:
        if (r113 >= r112) goto L13;
        r105.getChildAt(r113);
        j2c.a r114 = (j2c.a) CollectionsKt.getOrNull(r109, r113);
        if (r114 != null) goto L11;
        r113 = r113 + 1;
        goto L7
    L11:
        r114.getClass();
        throw null;
    L13:
        requestLayout();
        return;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public static void a(UDBadgeView r100, UDBadgeView r101, j2c.a.AbstractC6385a r102) {
        if ((r102 instanceof j2c.a.AbstractC6385a.C6386a) == false) goto L6;
        r100.setVisibility(0);
        r101.setVisibility(8);
        return;
    L6:
        if ((r102 instanceof j2c.a.AbstractC6385a.b) == false) goto L8;
        r100.setVisibility(8);
        r101.setVisibility(0);
        ((j2c.a.AbstractC6385a.b) r102).getClass();
        r101.setText(null);
        r101.a();
        return;
    L8:
        r100.setVisibility(8);
        r101.setVisibility(8);
    }

    public final View c(j2c.a r100, j2c.a.c r110, boolean r111) {
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.quick_launch_bar_button_item, this.f439138d.f439128b, false);
        int r102 = R.id.badgeDotView;
        UDBadgeView r103 = (UDBadgeView) ViewBindings.findChildViewById(r101, R.id.badgeDotView);
        if (r103 == null) goto L25;
        r102 = R.id.badgeTextView;
        UDBadgeView r104 = (UDBadgeView) ViewBindings.findChildViewById(r101, R.id.badgeTextView);
        if (r104 == null) goto L25;
        r102 = R.id.flNameContainer;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.flNameContainer);
        if (r105 == null) goto L25;
        r102 = R.id.ivIcon;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r101, R.id.ivIcon);
        if (r106 == null) goto L25;
        r102 = R.id.tvName;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.tvName);
        if (r107 == null) goto L25;
        LinearLayout r108 = (LinearLayout) r101;
        if (r111 == true) goto L18;
        Drawable r112 = r108.getBackground();
        if ((r112 instanceof GradientDrawable) == false) goto L17;
        GradientDrawable r113 = (GradientDrawable) r112;
        r113.mutate();
        r113.setColor(r110.f497055c);
        r113.setStroke(r110.f497054b, r110.f497053a);
    L17:
        b(r106, r100);
    L18:
        Function1<ViewGroup, View> r114 = r110.f497056d;
        if (r114 == null) goto L21;
        View r115 = r114.invoke(r108);
        r105.removeAllViews();
        r105.addView(r115);
    L22:
        r100.getClass();
        a(r103, r104, null);
        return r108;
    L21:
        r100.getClass();
        r107.setText(null);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public final View e(j2c.a r100, boolean r101, int r102) {
        Object r103 = null;
        r100.getClass();
        if ((r103 instanceof j2c.a.e.b) == false) goto L6;
        View r104 = d(r100);
    L10:
        r104.setOnClickListener(new com.ss.android.lark.quicklaunchbar.widget.a(r101, this, r100, r102));
        r104.setOnLongClickListener(new com.ss.android.lark.quicklaunchbar.widget.b(r101, this, r100, r102));
        return r104;
    L6:
        if ((r103 instanceof j2c.a.e.C6389a) == false) goto L15;
        Log.i("QuickLaunchBar", "buildItemView, isLeft: " + r101 + ", index: " + r102 + ", button show as icon: " + r100.f497051a);
        if (r100.f497051a == false) goto L12;
        r104 = d(r100);
        goto L10
    L12:
        r100.getClass();
        j2c.a.e.C6389a r105 = (j2c.a.e.C6389a) null;
        throw null;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ QuickLaunchBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        Log.i("QuickLaunchBar", "onWidthChanged, w: " + r100 + ", oldw: " + r102);
        post(new b(this));
        return;
    }
}
