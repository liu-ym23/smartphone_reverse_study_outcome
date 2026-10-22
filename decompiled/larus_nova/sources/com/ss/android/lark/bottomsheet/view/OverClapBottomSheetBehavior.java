package com.ss.android.lark.bottomsheet.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 B*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001BB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J%\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J%\u0010&\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J=\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0002\u0010.JE\u0010/\u001a\u00020\u00162\u0006\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010*\u001a\u00020\u00022\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0002\u00104JM\u00105\u001a\u00020\u00162\u0006\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010*\u001a\u00020\u00022\u0006\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0002\u0010:J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020$H\u0002J \u0010>\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0002R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/ss/android/lark/bottomsheet/view/OverClapBottomSheetBehavior;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "nestedScrollChild", "Ljava/lang/ref/WeakReference;", "nestedScrollingChildRefField", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "touchingScrollingChildRefField", "viewDragHelperField", "overLapBarView", "innerIsDraggable", "", "hasChildNeedScroll", "setNestedScrollChild", "", "view", "setOverLapBarView", "setNestedScrollChildInternal", "setTouchScrollingChildValue", "value", "isDraggable", "setDraggable", "draggable", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "event", "Landroid/view/MotionEvent;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onTouchEvent", "onStartNestedScroll", "coordinatorLayout", "directTargetChild", PickerReporterConstants.KEY.TARGET, "nestedScrollAxes", "", "type", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "onNestedPreScroll", "dx", "dy", "consumed", "", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;II[II)V", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;IIIII)V", "viewGroup", "Landroid/view/ViewGroup;", "ev", "isLocationInView", "x", "", "y", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverClapBottomSheetBehavior<T extends View> extends BottomSheetBehavior<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f410744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Field f410745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Field f410746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f410747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f410748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f410749f;

    public static final class a {
    }

    static {
    }

    public final void setDraggable(boolean r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        setDraggable(false);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L13;
        this.f410748e = false;
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public OverClapBottomSheetBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Field r102 = BottomSheetBehavior.class.getDeclaredField("nestedScrollingChildRef");
        r102.setAccessible(true);
        this.f410744a = r102;
        Field r103 = BottomSheetBehavior.class.getDeclaredField("touchingScrollingChild");
        r103.setAccessible(true);
        this.f410745b = r103;
        Field r104 = BottomSheetBehavior.class.getDeclaredField("viewDragHelper");
        r104.setAccessible(true);
        this.f410746c = r104;
        this.f410748e = true;
    }

    public final boolean a(ViewGroup r110, MotionEvent r111) {
        Object r100 = this.f410744a.get(this);
        if ((r100 instanceof WeakReference) == false) goto L5;
        WeakReference r101 = (WeakReference) r100;
    L7:
        if (ViewCompat.isNestedScrollingEnabled(r110) == false) goto L14;
        if (r101 == null) goto L10;
        View r102 = (View) r101.get();
    L12:
        if (Intrinsics.areEqual(r110, r102) == true) goto L14;
        return true;
    L10:
        r102 = null;
    L14:
        int r103 = r110.getChildCount();
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L37;
        View r105 = r110.getChildAt(r104);
        if (r105 == null) goto L36;
        float r106 = r111.getRawX();
        float r112 = r111.getRawY();
        int[] r113 = new int[2];
        r105.getLocationOnScreen(r113);
        int r114 = r113[0];
        if (new RectF(r114, r113[1], r114 + r105.getWidth(), r113[1] + r105.getHeight()).contains(r106, r112) == false) goto L36;
        if ((r105 instanceof ViewGroup) == false) goto L26;
        boolean r107 = a((ViewGroup) r105, r111);
    L34:
        if (r107 == false) goto L36;
        return true;
    L26:
        if (ViewCompat.isNestedScrollingEnabled(r110) == false) goto L33;
        if (r101 == null) goto L29;
        View r115 = (View) r101.get();
    L31:
        if (Intrinsics.areEqual(r105, r115) == true) goto L33;
        r107 = true;
        goto L34
    L29:
        r115 = null;
    L33:
        r107 = false;
    L36:
        r104 = r104 + 1;
        goto L15
    L37:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, T r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (a(r100, r102) == false) goto L6;
        this.f410749f = true;
        return false;
    L6:
        this.f410749f = false;
        if (r101.isShown() == false) goto L37;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        boolean r104 = super.isDraggable();     // Catch: Throwable -> L10
    L12:
        if (r104 == false) goto L37;
        if (r102.getAction() != 0) goto L37;
        if (getState() == 2) goto L37;
        Object r105 = this.f410744a.get(this);
        View r106 = null;
        if ((r105 instanceof WeakReference) == false) goto L20;
        WeakReference r107 = (WeakReference) r105;
    L21:
        if (r107 == null) goto L23;
        r106 = (View) r107.get();
    L23:
        if (r106 == null) goto L37;
        if (r100.isPointInChildBounds(r106, (int) r102.getX(), (int) r102.getY()) == false) goto L37;
        View r108 = this.f410747d;
        if (r108 == null) goto L37;
        if (r100.isPointInChildBounds(r108, (int) r102.getX(), (int) r102.getY()) == false) goto L37;
        if (r100.doViewsOverlap(r106, r108) == false) goto L37;
        this.f410745b.set(this, Boolean.FALSE);
        ViewDragHelper r109 = (ViewDragHelper) this.f410746c.get(this);
        if (r109 != null) goto L35;
        return false;
    L35:
        return r109.shouldInterceptTouchEvent(r102);
    L20:
        r107 = null;
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r104 = false;
    L37:
        if (this.f410748e == true) goto L40;
        return false;
    L40:
        return super.onInterceptTouchEvent(r100, r101, r102);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, T r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (this.f410748e == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100, r101, r102);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, T r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        if (this.f410748e == true) goto L9;
        if (this.f410749f == true) goto L9;
        return false;
    L9:
        return super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedPreScroll(CoordinatorLayout r100, T r101, View r102, int r103, int r104, int[] r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "consumed");
        if (this.f410748e == false) goto L5;
    L7:
        super.onNestedPreScroll(r100, r101, r102, r103, r104, r105, r106);
        return;
    L5:
        if (this.f410749f == true) goto L7;
        r105[0] = 0;
        r105[1] = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout r100, T r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (this.f410748e == false) goto L5;
    L7:
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L5:
        if (this.f410749f == true) goto L7;
    }
}
