package com.bytedance.dux.panel.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.dux.panel.BottomSheetBehavior;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/dux/panel/pad/PadBottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/bytedance/dux/panel/BottomSheetBehavior;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class PadBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public Location M;
    public boolean N;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f205395a = null;

        static {
            int[] r100 = new int[Location.values().length];
            r100[Location.CORNER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Location.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Location.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f205395a = r100;
        }
    }

    @Override // com.bytedance.dux.panel.BottomSheetBehavior
    public final void calculateCollapsedOffset() {
        if (this.N == false) goto L7;
        super.calculateCollapsedOffset();
        return;
    L7:
        if (this.f205252a == false) goto L9;
        int r100 = this.f205273v - this.f205274w;
        int r101 = this.f205275x;
        int r102 = Math.max(r100 - r101, this.f205260i - r101);
    L10:
        this.f205262k = r102;
        if (a.f205395a[this.M.ordinal()] != 3) goto L15;
        this.f205262k /= 2;
        return;
    L15:
        return;
    L9:
        r102 = (this.f205273v - this.f205274w) - this.f205275x;
        goto L10
    }

    public PadBottomSheetBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.M = Location.CENTER;
    }

    @Override // com.bytedance.dux.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (this.N == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r100, r101, r102);
    }

    @Override // com.bytedance.dux.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, V r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (this.N == false) goto L6;
        super.onLayoutChild(r100, r101, r110);
        return true;
    L6:
        r100.onLayoutChild(r101, r110);
        int r102 = r101.getHeight();
        int r103 = r100.getHeight();
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        ViewGroup.LayoutParams r105 = null;
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r104 = null;
    L9:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r104;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.bottomMargin;
    L14:
        if (r102 <= (r103 - r108)) goto L27;
        ViewGroup.LayoutParams r109 = r101.getLayoutParams();
        if (r109 == null) goto L26;
        CoordinatorLayout.LayoutParams r111 = (CoordinatorLayout.LayoutParams) r109;
        int r112 = r100.getHeight();
        ViewGroup.LayoutParams r113 = r101.getLayoutParams();
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r105 = r113;
    L21:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r105;
        if (r114 == null) goto L24;
        r107 = r114.bottomMargin;
    L24:
        ((ViewGroup.MarginLayoutParams) r111).height = r112 - r107;
        r101.setLayoutParams(r111);
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L27:
        super.onLayoutChild(r100, r101, r110);
        return true;
    L12:
        r108 = 0;
        goto L14
    }

    @Override // com.bytedance.dux.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, V r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (this.N == true) goto L5;
        return false;
    L5:
        return super.onTouchEvent(r100, r101, r102);
    }

    @Override // com.bytedance.dux.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, V r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        if (this.N == true) goto L5;
        return false;
    L5:
        return super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
    }
}
