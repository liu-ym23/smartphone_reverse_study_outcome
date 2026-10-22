package com.larus.video.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000fJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0017H\u0017J\b\u0010)\u001a\u00020\tH\u0016J \u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0018\u00010,R\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u0004\u0018\u000102J,\u00103\u001a\u00020\t2\u0010\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0010\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0002J\u001c\u00106\u001a\u0004\u0018\u0001022\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0002R\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/video/impl/widget/PagerLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastSelectedView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "currentSelectedView", "pagerSnapHelper", "Landroidx/recyclerview/widget/PagerSnapHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isFirstLayout", "pointerCount", "enableScroll", "getEnableScroll", "()Z", "setEnableScroll", "(Z)V", "scrollCallBack", "Lcom/larus/video/impl/widget/PagerLayoutManager$ScrollCallBack;", "getScrollCallBack", "()Lcom/larus/video/impl/widget/PagerLayoutManager$ScrollCallBack;", "setScrollCallBack", "(Lcom/larus/video/impl/widget/PagerLayoutManager$ScrollCallBack;)V", "lastPosition", "onAttachedToWindow", "", "view", "canScrollVertically", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "tryNotifyItemSelectionChanged", "getCurrentViewHolder", "Lcom/larus/video/impl/widget/VideoViewHolder;", "equals", "r1", "r2", "getViewHolder", "viewRef", "ScrollCallBack", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PagerLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f375930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<View> f375931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PagerSnapHelper f375932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f375933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f375934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f375935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f375936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f375937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f375938i;

    public interface a {
        void a(int r100, int r101);

        void b(int r100, int r101);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        if (this.f375936g == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically() == false) goto L7;
        return true;
    }

    public final boolean q() {
        this.f375930a = this.f375931b;
        if (this.f375936g == false) goto L5;
        View r100 = this.f375932c.findSnapView(this);
    L6:
        WeakReference<View> r101 = new WeakReference(r100);
        this.f375931b = r101;
        WeakReference<View> r102 = this.f375930a;
        if (Intrinsics.areEqual(r102, r101) == true) goto L15;
        if (r102 == null) goto L10;
        View r103 = r102.get();
    L12:
        if (Intrinsics.areEqual(r103, r101.get()) == true) goto L15;
        boolean r104 = false;
    L16:
        if (r104 == true) goto L19;
        postOnAnimation(new com.larus.video.impl.widget.a(this));
        return true;
    L19:
        return false;
    L10:
        r103 = null;
    L15:
        r104 = true;
        goto L16
    L5:
        r100 = findViewByPosition(findFirstVisibleItemPosition());
        goto L6
    }

    public PagerLayoutManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f375932c = new PagerSnapHelper();
        this.f375934e = true;
        this.f375936g = true;
        this.f375938i = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        super.onAttachedToWindow(r100);
        this.f375932c.attachToRecyclerView(r100);
        this.f375933d = r100;
        View r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof View) == false) goto L9;
        r101 = (View) r102;
    L9:
        if (r101 == null) goto L12;
        r101.setOnTouchListener(new b(this));
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int r100) {
        if (r100 == 0) goto L4;
    L6:
        if (r100 != 0) goto L20;
        View r101 = this.f375932c.findSnapView(this);
        if (r101 == null) goto L21;
        int r102 = getPosition(r101);
        int r103 = this.f375938i;
        if (r102 <= r103) goto L14;
        a r104 = this.f375937h;
        if (r104 == null) goto L18;
        r104.a(r103, r102);
    L18:
        this.f375938i = r102;
        return;
    L14:
        if (r102 >= r103) goto L18;
        a r105 = this.f375937h;
        if (r105 == null) goto L18;
        r105.b(r103, r102);
        goto L18
    L21:
        return;
    L20:
        return;
    L4:
        if (this.f375935f != 0) goto L6;
        q();
        goto L6
    }

    public final VideoViewHolder p(WeakReference<View> r100) {
        if (r100 == null) goto L14;
        View r101 = r100.get();
        if (r101 == null) goto L15;
        RecyclerView r102 = this.f375933d;
        if (r102 == null) goto L9;
        RecyclerView.ViewHolder r103 = r102.getChildViewHolder(r101);
    L11:
        if ((r103 instanceof VideoViewHolder) == true) goto L13;
        return null;
    L13:
        return (VideoViewHolder) r103;
    L9:
        r103 = null;
        goto L11
    L15:
        return null;
    L14:
        return null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        super.onLayoutChildren(r100, r101);     // Catch: IndexOutOfBoundsException -> L10
        if (this.f375934e == true) goto L5;
        return;
    L5:
        if (q() == true) goto L7;
        boolean r102 = true;
    L8:
        this.f375934e = r102;     // Catch: IndexOutOfBoundsException -> L10
        return;
    L7:
        r102 = false;
    L10:
        e = move-exception;
        FLogger.f375446a.e(PagerLayoutManager.class.getName(), "perform notifyDataSetChanged still crash >>>" + e);
    }

    public PagerLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.f375932c = new PagerSnapHelper();
        this.f375934e = true;
        this.f375936g = true;
        this.f375938i = -1;
    }
}
