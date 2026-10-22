package com.obric.oui.titlebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0004o\u001a $B\u001d\b\u0007\u0012\u0006\u0010j\u001a\u00020i\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k¢\u0006\u0004\bm\u0010nJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\f\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u000f\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\u0010\u0010\u001eR$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010.\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R$\u00105\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010I\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010@\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR$\u0010M\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u00100\u001a\u0004\bK\u00102\"\u0004\bL\u00104R\"\u0010T\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010[\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010_\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010O\u001a\u0004\b]\u0010Q\"\u0004\b^\u0010SR\u001a\u0010b\u001a\u00020\u00038\u0006X\u0086D¢\u0006\f\n\u0004\b`\u0010O\u001a\u0004\ba\u0010QR$\u0010c\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010h¨\u0006p"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "", "getSnapRange", "getScrollRange", "", "expanded", "", "setExpanded", "Lcom/obric/oui/titlebar/OUnitedTitleBar$b;", "onHeaderFlingUnConsumedListener", "setOnHeaderFlingUnConsumedListener", "Landroid/view/View;", "view", "setLeftAction", "setRightAction", "getDownNestedScrollRange", "getUpNestedPreScrollRange", "getTopInset", "getPendingAction", "getTotalScrollRange", "getDownNestedPreScrollRange", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "Landroid/view/ViewGroup;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/ViewGroup;", "getLeftAction", "()Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "leftAction", "b", "getRightAction", "rightAction", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "d", "getMTvSubTitle", "setMTvSubTitle", "mTvSubTitle", "e", "Landroid/view/View;", "getBottomAction", "()Landroid/view/View;", "setBottomAction", "(Landroid/view/View;)V", "bottomAction", "", "f", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "titleText", "Landroid/graphics/drawable/Drawable;", ce.f26391f, "Landroid/graphics/drawable/Drawable;", "getLeftActionSrc", "()Landroid/graphics/drawable/Drawable;", "setLeftActionSrc", "(Landroid/graphics/drawable/Drawable;)V", "leftActionSrc", "h", "getRightActionSrc", "setRightActionSrc", "rightActionSrc", RXScreenCaptureService.KEY_INDEX, "getDivider", "setDivider", ItemStyle.ITEM_STYLE_DIVIDER, ce.f26395j, "I", "getMCollapsePosition", "()I", "setMCollapsePosition", "(I)V", "mCollapsePosition", "m", "Z", "getInDebug", "()Z", "setInDebug", "(Z)V", "inDebug", OfficeSDKRequestTag.KEY_NEW_USER, "getTextInitPos", "setTextInitPos", "textInitPos", "o", "getINVALID_SCROLL_RANGE", "INVALID_SCROLL_RANGE", "mOnHeaderFlingUnConsumedListener", "Lcom/obric/oui/titlebar/OUnitedTitleBar$b;", "getMOnHeaderFlingUnConsumedListener", "()Lcom/obric/oui/titlebar/OUnitedTitleBar$b;", "setMOnHeaderFlingUnConsumedListener", "(Lcom/obric/oui/titlebar/OUnitedTitleBar$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Behavior", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.AttachedBehavior {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f403463q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f403464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f403465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f403466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f403467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f403468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f403469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f403470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f403471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f403472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f403473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f403474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<c> f403475l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f403476m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f403477n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f403478o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WindowInsetsCompat f403479p;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001d\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Behavior;", "Lcom/obric/oui/titlebar/behavior/HeaderBehavior;", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "<init>", "()V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ValueAnimator f403480j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f403481k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public WeakReference<View> f403482l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f403483m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f403484n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f403485o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f403486p;

        public Behavior() {
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final boolean canDragView(View r100) {
            OUnitedTitleBar r101 = (OUnitedTitleBar) r100;
            WeakReference<View> r102 = this.f403482l;
            if (r102 == null) goto L14;
            Intrinsics.checkNotNull(r102);
            View r103 = r102.get();
            if (r103 != null) goto L7;
        L13:
            return false;
        L7:
            if (r103.isShown() == false) goto L13;
            if (ViewCompat.canScrollVertically(r103, -1) == true) goto L13;
            int r104 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r101);
            if (r104 <= (-OUnitedTitleBar.a(r101))) goto L13;
        L14:
            return true;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getMaxDragOffset(View r100) {
            OUnitedTitleBar r101 = (OUnitedTitleBar) r100;
            Intrinsics.checkNotNullParameter(r101, "view");
            return -OUnitedTitleBar.a(r101);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int getScrollRangeForDragFling(View r100) {
            OUnitedTitleBar r101 = (OUnitedTitleBar) r100;
            Intrinsics.checkNotNullParameter(r101, "view");
            return OUnitedTitleBar.a(r101);
        }

        public Behavior(Context r100, AttributeSet r101) {
            super(r100, r101);
        }

        public final void a(final CoordinatorLayout r110, final OUnitedTitleBar r111) {
            int r100 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r111);
            int r101 = -OUnitedTitleBar.b(r111);
            if (r100 <= r101) goto L24;
            if (r100 < 0) goto L6;
            return;
        L6:
            if (r100 < ((r101 + 0) / 2)) goto L9;
            r101 = 0;
        L9:
            int r102 = Math.abs(getTopBottomOffsetForScrollingSibling() - r101);
            float r103 = Math.abs(0.0f);
            if (r103 <= 0.0f) goto L12;
            int r104 = Math.round(1000 * (r102 / r103));
        L13:
            int r105 = getTopAndBottomOffset();
            if (r105 != r101) goto L18;
            ValueAnimator r106 = this.f403480j;
            if (r106 == null) goto L18;
            Intrinsics.checkNotNull(r106);
            r106.cancel();
        L18:
            ValueAnimator r107 = this.f403480j;
            if (r107 != null) goto L21;
            ValueAnimator r108 = new ValueAnimator();
            this.f403480j = r108;
            Intrinsics.checkNotNull(r108);
            r108.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r109 = this.f403480j;
            Intrinsics.checkNotNull(r109);
            r109.addUpdateListener(new m(this, r110, r111));
        L22:
            ValueAnimator r112 = this.f403480j;
            Intrinsics.checkNotNull(r112);
            r112.setDuration(r104);
            ValueAnimator r113 = this.f403480j;
            Intrinsics.checkNotNull(r113);
            r113.setIntValues(new int[]{r105, r101});
            ValueAnimator r114 = this.f403480j;
            Intrinsics.checkNotNull(r114);
            r114.start();
            return;
        L21:
            Intrinsics.checkNotNull(r107);
            r107.cancel();
            goto L22
        L12:
            Intrinsics.checkNotNull(r111);
            r104 = (int) (((r102 / r111.getHeight()) + 1) * 150);
            goto L13
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final void onFlingFinished(CoordinatorLayout r100, View r101) {
            this.f403484n = false;
            a(r100, (OUnitedTitleBar) r101);
        }

        @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onLayoutChild(CoordinatorLayout r100, View r101, int r102) {
            OUnitedTitleBar r103 = (OUnitedTitleBar) r101;
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            super.onLayoutChild(r100, r103, r102);
            int r104 = r103.f403474k;
            if (r104 != 0) goto L5;
        L10:
            r103.c(getTopAndBottomOffset());
            return true;
        L5:
            if ((r104 & 1) == 0) goto L8;
            setHeaderTopBottomOffset(r100, r103, -OUnitedTitleBar.a(r103));
            goto L10
        L8:
            if ((r104 & 16) == 0) goto L10;
            setHeaderTopBottomOffset(r100, r103, 0);
            goto L10
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102) {
            OUnitedTitleBar r103 = (OUnitedTitleBar) r101;
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            if (this.f403483m == true) goto L5;
            a(r100, r103);
        L5:
            this.f403481k = false;
            this.f403482l = new WeakReference(r102);
        }

        public final boolean b(CoordinatorLayout r100, OUnitedTitleBar r110, int r111, float r112) {
            Intrinsics.checkNotNullParameter(r110, "layout");
            if (r112 >= 0.0f) goto L5;
            this.f403484n = true;
            this.f403485o = r111;
            this.f403486p = 0;
            int r101 = Integer.MIN_VALUE;
            int r102 = Integer.MAX_VALUE;
        L7:
            return super.fling(r100, r110, r101, r102, r112);
        L5:
            r101 = r111;
            r102 = 0;
            goto L7
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final /* bridge */ /* synthetic */ boolean fling(CoordinatorLayout r100, View r101, int r102, int r103, float r104) {
            return b(r100, (OUnitedTitleBar) r101, r102, r104);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onNestedPreFling(CoordinatorLayout r100, View r101, View r102, float r103, float r104) {
            OUnitedTitleBar r105 = (OUnitedTitleBar) r101;
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r105, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            if (r104 > 0.0f) goto L5;
        L7:
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.a(r105))) goto L7;
            b(r100, r105, -OUnitedTitleBar.a(r105), -r104);
            this.f403483m = true;
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104) {
            OUnitedTitleBar r105 = (OUnitedTitleBar) r101;
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r105, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, "directTargetChild");
            Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
            if ((r104 & 2) > 0) goto L5;
        L9:
            boolean r106 = false;
        L10:
            if (r106 == false) goto L14;
            ValueAnimator r107 = this.f403480j;
            if (r107 == null) goto L14;
            Intrinsics.checkNotNull(r107);
            r107.cancel();
        L14:
            this.f403482l = null;
            this.f403483m = false;
            this.f403484n = false;
            OverScroller r108 = this.f403504d;
            if (r108 == null) goto L17;
            r108.abortAnimation();
        L17:
            return r106;
        L5:
            if (OUnitedTitleBar.a(r105) <= 0) goto L9;
            if ((r100.getHeight() - r102.getHeight()) > r105.getHeight()) goto L9;
            r106 = true;
            goto L10
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public final int setHeaderTopBottomOffset(CoordinatorLayout r100, View r101, int r102, int r110, int r111) {
            OUnitedTitleBar r103 = (OUnitedTitleBar) r101;
            getTopAndBottomOffset();
            if (this.f403484n == false) goto L5;
            r110 = Math.max(this.f403485o, r110);
            r111 = Math.min(this.f403486p, r111);
        L5:
            int r104 = super.setHeaderTopBottomOffset(r100, r103, r102, r110, r111);
            if (r103 == null) goto L10;
            r103.c(getTopAndBottomOffset());
        L10:
            if (this.f403484n == false) goto L15;
            if (r103 == null) goto L15;
            r103.getMOnHeaderFlingUnConsumedListener();
        L15:
            return r104 + 0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean onNestedFling(CoordinatorLayout r100, View r101, View r102, float r103, float r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter((OUnitedTitleBar) r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            this.f403483m = true;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedPreScroll(CoordinatorLayout r100, View r101, View r102, int r110, int r111, int[] r112) {
            OUnitedTitleBar r103 = (OUnitedTitleBar) r101;
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r112, "consumed");
            if (r111 > 0) goto L5;
            return;
        L5:
            if (this.f403481k == true) goto L9;
            r112[1] = scroll(r100, r103, r111, -OUnitedTitleBar.a(r103), 0);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r110, int r111, int r112, int r113) {
            OUnitedTitleBar r103 = (OUnitedTitleBar) r101;
            Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            if (r113 >= 0) goto L5;
            scroll(r100, r103, r113, -OUnitedTitleBar.a(r103), 0);
            boolean r104 = true;
        L6:
            this.f403481k = r104;
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        void a(int r100);
    }

    static {
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final b getMOnHeaderFlingUnConsumedListener() {
        return null;
    }

    public final void setMOnHeaderFlingUnConsumedListener(b r100) {
    }

    public final void setOnHeaderFlingUnConsumedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "onHeaderFlingUnConsumedListener");
    }

    private final int getScrollRange() {
        return pla.d.n(this, 184);
    }

    private final int getSnapRange() {
        return pla.d.n(this, 56);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }

    public final int getTopInset() {
        WindowInsetsCompat r100 = this.f403479p;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100.getSystemWindowInsetTop();
    L5:
        return 0;
    }

    public final int getTotalScrollRange() {
        return pla.d.n(this, 184);
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final View getBottomAction() {
        return this.f403468e;
    }

    public final View getDivider() {
        return this.f403472i;
    }

    public final int getINVALID_SCROLL_RANGE() {
        return this.f403478o;
    }

    public final boolean getInDebug() {
        return this.f403476m;
    }

    public final ViewGroup getLeftAction() {
        return this.f403464a;
    }

    public final Drawable getLeftActionSrc() {
        return this.f403470g;
    }

    public final int getMCollapsePosition() {
        return this.f403473j;
    }

    public final TextView getMTvSubTitle() {
        return this.f403467d;
    }

    public final TextView getMTvTitle() {
        return this.f403466c;
    }

    public final int getPendingAction() {
        return this.f403474k;
    }

    public final ViewGroup getRightAction() {
        return this.f403465b;
    }

    public final Drawable getRightActionSrc() {
        return this.f403471h;
    }

    public final int getTextInitPos() {
        return this.f403477n;
    }

    public final String getTitleText() {
        return this.f403469f;
    }

    public OUnitedTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final /* synthetic */ int a(OUnitedTitleBar r100) {
        return r100.getScrollRange();
    }

    public static final /* synthetic */ int b(OUnitedTitleBar r100) {
        return r100.getSnapRange();
    }

    public final void c(int r100) {
        List<c> r101 = this.f403475l;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        Iterator r102 = ((ArrayList) r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((c) r102.next()).a(r100);
        goto L6
    L10:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new BaseBehavior.LayoutParams(getContext(), r100);
    }

    public final void setBottomAction(View r100) {
        this.f403468e = r100;
    }

    public final void setDivider(View r100) {
        this.f403472i = r100;
    }

    public final void setExpanded(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 16;
    L5:
        this.f403474k = r101;
        requestLayout();
        return;
    L4:
        r101 = 1;
        goto L5
    }

    public final void setInDebug(boolean r100) {
        this.f403476m = r100;
    }

    public final void setLeftAction(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup r101 = this.f403464a;
        if (r101 == null) goto L6;
        r101.removeAllViews();
    L6:
        ViewGroup r102 = this.f403464a;
        if (r102 == null) goto L11;
        r102.addView(r100);
        return;
    }

    public final void setLeftActionSrc(Drawable r100) {
        this.f403470g = r100;
    }

    public final void setMCollapsePosition(int r100) {
        this.f403473j = r100;
    }

    public final void setMTvSubTitle(TextView r100) {
        this.f403467d = r100;
    }

    public final void setMTvTitle(TextView r100) {
        this.f403466c = r100;
    }

    public final void setRightAction(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup r101 = this.f403465b;
        if (r101 == null) goto L6;
        r101.removeAllViews();
    L6:
        ViewGroup r102 = this.f403465b;
        if (r102 == null) goto L11;
        r102.addView(r100);
        return;
    }

    public final void setRightActionSrc(Drawable r100) {
        this.f403471h = r100;
    }

    public final void setTextInitPos(int r100) {
        this.f403477n = r100;
    }

    public final void setTitleText(String r100) {
        this.f403469f = r100;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new BaseBehavior.LayoutParams(getContext(), r100);
    }

    public final void setLeftAction(ViewGroup r100) {
        this.f403464a = r100;
    }

    public final void setRightAction(ViewGroup r100) {
        this.f403465b = r100;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new BaseBehavior.LayoutParams(r100);
    }

    public OUnitedTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_left_action_src, R.attr.oui_right_action_src, R.attr.oui_title_collapse_position, R.attr.oui_united_title});
        this.f403469f = r102.getString(3);
        this.f403473j = r102.getInt(2, 0);
        this.f403470g = r102.getDrawable(0);
        this.f403471h = r102.getDrawable(1);
        r102.recycle();
        FrameLayout.inflate(r100, R.layout.o_united_titlebar, this);
        this.f403464a = (ViewGroup) findViewById(R.id.fl_left_container);
        this.f403465b = (ViewGroup) findViewById(R.id.fl_right_container);
        this.f403466c = (TextView) findViewById(R.id.tv_title_container);
        this.f403467d = (TextView) findViewById(R.id.tv_subtitle_container);
        this.f403468e = findViewById(R.id.fl_bottom_container);
        this.f403472i = findViewById(R.id.divider);
        TextView r103 = this.f403466c;
        if (r103 == null) goto L6;
        r103.setText(this.f403469f);
    L6:
        ViewCompat.setOnApplyWindowInsetsListener(this, new l(this));
        if (this.f403470g == null) goto L10;
        OIconButton r104 = new OIconButton(getContext(), null, 0, 0, 28);
        r104.setImageDrawable(getLeftActionSrc());
        setLeftAction(r104);
    L10:
        if (this.f403471h == null) goto L12;
        OIconButton r105 = new OIconButton(getContext(), null, 0, 0, 28);
        r105.setImageDrawable(getRightActionSrc());
        setRightAction(r105);
    L12:
        setBackgroundColor(getResources().getColor(R.color.Transparent));
        if (this.f403476m == false) goto L26;
        ViewGroup r106 = this.f403464a;
        if (r106 == null) goto L18;
        r106.setBackgroundColor(getResources().getColor(R.color.oui_blue_2));
    L18:
        ViewGroup r107 = this.f403465b;
        if (r107 == null) goto L22;
        r107.setBackgroundColor(getResources().getColor(R.color.oui_blue_2));
    L22:
        setBackgroundColor(getResources().getColor(R.color.oui_red_2));
        TextView r108 = this.f403466c;
        if (r108 == null) goto L26;
        r108.setBackgroundColor(getResources().getColor(R.color.oui_yellow_1));
    L26:
        n r109 = new n(this);
        if (this.f403475l != null) goto L29;
        this.f403475l = new ArrayList();
    L29:
        List<c> r110 = this.f403475l;
        Intrinsics.checkNotNull(r110);
        if (((ArrayList) r110).contains(r109) == true) goto L32;
        List<c> r111 = this.f403475l;
        Intrinsics.checkNotNull(r111);
        ((ArrayList) r111).add(r109);
    L32:
        this.f403478o = -1;
    }
}
