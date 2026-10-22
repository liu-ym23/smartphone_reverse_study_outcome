package com.larus.camera.impl.widget;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001!B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J(\u0010\u001a\u001a\u00020\r2\u001e\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r0\u001cH\u0002J\u001c\u0010\u001e\u001a\u00020\r2\u0014\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bJ\b\u0010 \u001a\u0004\u0018\u00010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/camera/impl/widget/PickerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "reverseLayout", "", "itemUpdater", "Lcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;", "<init>", "(Landroid/content/Context;ZLcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;)V", "itemSelectedListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "", "dx", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "scaleDownView", "getSelectedPosition", "normalizeOffsetAndLoopChild", "callback", "Lkotlin/Function3;", "", "setOnItemSelectedListener", "listener", "getSelectedItem", "ItemUpdater", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f322874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super View, Unit> f322875b;

    public interface a {
        void a(View r100, float r101);
    }

    public final View p() {
        final Ref.IntRef r100 = new Ref.IntRef();
        final Ref.FloatRef r101 = new Ref.FloatRef();
        r101.element = 1.0f;
        q(new s(r101, r100));
        return getChildAt(r100.element);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int r100) {
        super.onScrollStateChanged(r100);
        if (r100 != 0) goto L6;
        this.f322875b.invoke(p());
        return;
    }

    public final void q(Function3<? super View, ? super Integer, ? super Float, Unit> r100) {
        float r101 = getWidth() / 2.0f;
        int r102 = 0;
        if (r101 != 0.0f) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        int r104 = getChildCount();
    L9:
        if (r102 >= r104) goto L15;
        View r105 = getChildAt(r102);
        if (r105 == null) goto L14;
        r100.invoke(r105, Integer.valueOf(r102), Float.valueOf(Math.abs(((getDecoratedLeft(r105) + getDecoratedRight(r105)) / 2.0f) - r101) / r101));
    L14:
        r102 = r102 + 1;
        goto L9
    L15:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public PickerLayoutManager(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "itemUpdater");
        super(r100, 0, false);
        this.f322874a = r101;
        this.f322875b = new t();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        Intrinsics.checkNotNullParameter(r100, "recycler");
        Intrinsics.checkNotNullParameter(r101, "state");
        super.onLayoutChildren(r100, r101);
        q(new r(this));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r101, "recycler");
        Intrinsics.checkNotNullParameter(r102, "state");
        int r103 = super.scrollHorizontallyBy(r100, r101, r102);
        q(new r(this));
        return r103;
    }
}
