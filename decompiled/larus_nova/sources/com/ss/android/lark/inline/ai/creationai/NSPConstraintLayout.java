package com.ss.android.lark.inline.ai.creationai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J(\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\bH\u0016J@\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020%H\u0016J8\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J0\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/NSPConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/core/view/NestedScrollingParent3;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nspHandler", "Lcom/ss/android/lark/inline/ai/creationai/NSPConstraintLayout$NSPHandler;", "nspHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "setNSPHandler", "", "onNestedPreFling", "", PickerReporterConstants.KEY.TARGET, "Landroid/view/View;", "velocityX", "", "velocityY", "onNestedFling", "consumed", "onStartNestedScroll", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "axes", "type", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "onNestedPreScroll", "dx", "dy", "NSPHandler", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NSPConstraintLayout extends ConstraintLayout implements NestedScrollingParent3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f427037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollingParentHelper f427038b;

    public interface a {
        boolean a(View r100, float r101);

        void b(View r100, int r101, int r102, int[] r103);

        void c(View r100, int r101, int[] r102, int r103);

        void onStartNestedScroll(View r100, View r101, int r102);

        void onStopNestedScroll(View r100, int r101);
    }

    public NSPConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NSPConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
    }

    public final void setNSPHandler(a r100) {
        this.f427037a = r100;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        a r102 = this.f427037a;
        if (r102 == null) goto L5;
        r102.onStopNestedScroll(r100, r101);
    L5:
        this.f427038b.onStopNestedScroll(r100, r101);
    }

    public NSPConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f427038b = new NestedScrollingParentHelper(this);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        a r103 = this.f427037a;
        if (r103 == null) goto L6;
        return r103.a(r100, r102);
    L6:
        return super.onNestedPreFling(r100, r101, r102);
    }

    public /* synthetic */ NSPConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return super.onNestedFling(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f427038b.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        a r104 = this.f427037a;
        if (r104 == null) goto L5;
        r104.onStartNestedScroll(r100, r101, r103);
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        a r105 = this.f427037a;
        if (r105 == null) goto L6;
        r105.c(r100, r102, r103, r104);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
        a r107 = this.f427037a;
        if (r107 == null) goto L6;
        r107.b(r100, r104, r105, r106);
        return;
    }
}
