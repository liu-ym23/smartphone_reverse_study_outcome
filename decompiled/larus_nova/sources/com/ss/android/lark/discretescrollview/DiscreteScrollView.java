package com.ss.android.lark.discretescrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.discretescrollview.transform.DiscreteScrollItemTransformer;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class DiscreteScrollView extends RecyclerView {
    private static final int DEFAULT_ORIENTATION = 0;
    private static final String LOG_TAG = "DiscreteScrollView";
    public static final int NO_POSITION = -1;
    private boolean isOverScrollEnabled;
    private DiscreteScrollLayoutManager layoutManager;
    private Runnable notifyItemChangedRunnable;
    private List<OnItemChangedListener> onItemChangedListeners;
    private List<c> scrollStateChangeListeners;

    public interface OnItemChangedListener<T extends RecyclerView.ViewHolder> {
        void onCurrentItemChanged(T r100, int r101);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiscreteScrollView f420440a;

        @Override // java.lang.Runnable
        public final void run() {
            DiscreteScrollView.access$000(this.f420440a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(DiscreteScrollView r100) {
            this.f420440a = r100;
        }
    }

    public interface b<T extends RecyclerView.ViewHolder> {
    }

    public interface c<T extends RecyclerView.ViewHolder> {
        void a();

        void b();

        void c();
    }

    public class d implements DiscreteScrollLayoutManager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiscreteScrollView f420441a;

        public d(DiscreteScrollView r100) {
            this.f420441a = r100;
        }
    }

    static {
        DEFAULT_ORIENTATION = DSVOrientation.HORIZONTAL.ordinal();
    }

    private void notifyCurrentItemChanged() {
        removeCallbacks(this.notifyItemChangedRunnable);
        if (this.onItemChangedListeners.isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = this.layoutManager.f420423k;
        RecyclerView.ViewHolder r101 = getViewHolder(r100);
        if (r101 != null) goto L8;
        post(this.notifyItemChangedRunnable);
        return;
    L8:
        notifyCurrentItemChanged(r101, r100);
    }

    public int getCurrentItem() {
        return this.layoutManager.f420423k;
    }

    public DiscreteScrollView(Context r100) {
        super(r100);
        this.notifyItemChangedRunnable = new a(this);
        init(null);
    }

    public static /* synthetic */ void access$000(DiscreteScrollView r100) {
        r100.notifyCurrentItemChanged();
    }

    public static /* synthetic */ boolean access$200(DiscreteScrollView r100) {
        return r100.isOverScrollEnabled;
    }

    public static /* synthetic */ Runnable access$300(DiscreteScrollView r100) {
        return r100.notifyItemChangedRunnable;
    }

    public static /* synthetic */ List access$400(DiscreteScrollView r100) {
        return r100.scrollStateChangeListeners;
    }

    public static /* synthetic */ DiscreteScrollLayoutManager access$500(DiscreteScrollView r100) {
        return r100.layoutManager;
    }

    public static /* synthetic */ List access$700(DiscreteScrollView r100) {
        return r100.onItemChangedListeners;
    }

    private void init(AttributeSet r100) {
        this.scrollStateChangeListeners = new ArrayList();
        this.onItemChangedListeners = new ArrayList();
        int r101 = DEFAULT_ORIENTATION;
        boolean r102 = true;
        if (r100 == null) goto L6;
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.dsv_orientation});
        r101 = r103.getInt(0, r101);
        r103.recycle();
    L6:
        if (getOverScrollMode() != 2) goto L9;
        r102 = false;
    L9:
        this.isOverScrollEnabled = r102;
        DiscreteScrollLayoutManager r104 = new DiscreteScrollLayoutManager(getContext(), new d(this), DSVOrientation.values()[r101]);
        this.layoutManager = r104;
        setLayoutManager(r104);
    }

    public void addOnItemChangedListener(OnItemChangedListener<?> r100) {
        this.onItemChangedListeners.add(r100);
    }

    public void addScrollListener(b<?> r100) {
        addScrollStateChangeListener(new bbb.a());
    }

    public void addScrollStateChangeListener(c<?> r100) {
        this.scrollStateChangeListeners.add(r100);
    }

    public RecyclerView.ViewHolder getViewHolder(int r100) {
        View r101 = this.layoutManager.findViewByPosition(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return getChildViewHolder(r101);
    }

    public void removeItemChangedListener(OnItemChangedListener<?> r100) {
        this.onItemChangedListeners.remove(r100);
    }

    public void removeScrollListener(b<?> r100) {
        removeScrollStateChangeListener(new bbb.a());
    }

    public void removeScrollStateChangeListener(c<?> r100) {
        this.scrollStateChangeListeners.remove(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int r100) {
        int r101 = this.layoutManager.f420423k;
        super.scrollToPosition(r100);
        if (r101 == r100) goto L6;
        notifyCurrentItemChanged();
        return;
    }

    public void setClampTransformProgressAfter(int r100) {
        if (r100 > 1) goto L5;
        Log.e(LOG_TAG, "must be >= 1");
    L5:
        DiscreteScrollLayoutManager r101 = this.layoutManager;
        r101.f420431s = r100;
        r101.p();
    }

    public void setItemTransformer(DiscreteScrollItemTransformer r100) {
        this.layoutManager.A = r100;
    }

    public void setItemTransitionTimeMillis(int r100) {
        this.layoutManager.f420429q = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager r100) {
        if ((r100 instanceof DiscreteScrollLayoutManager) == false) goto L5;
        super.setLayoutManager(r100);
        return;
    L5:
        Log.e(LOG_TAG, "layout manager of wrong type");
    }

    public void setOffscreenItems(int r100) {
        DiscreteScrollLayoutManager r101 = this.layoutManager;
        r101.f420430r = r100;
        r101.f420418f = r101.f420419g * r100;
        r101.B.f420444a.requestLayout();
    }

    public void setOrientation(DSVOrientation r100) {
        DiscreteScrollLayoutManager r101 = this.layoutManager;
        r101.getClass();
        r101.f420426n = r100.createHelper();
        r101.B.f420444a.removeAllViews();
        r101.B.f420444a.requestLayout();
    }

    public void setOverScrollEnabled(boolean r100) {
        this.isOverScrollEnabled = r100;
        setOverScrollMode(2);
    }

    public void setScrollConfig(DSVScrollConfig r100) {
        this.layoutManager.f420437y = r100;
    }

    public void setSlideOnFling(boolean r100) {
        this.layoutManager.f420434v = r100;
    }

    public void setSlideOnFlingThreshold(int r100) {
        this.layoutManager.f420433u = r100;
    }

    public DiscreteScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.notifyItemChangedRunnable = new a(this);
        init(r101);
    }

    private void notifyCurrentItemChanged(RecyclerView.ViewHolder r100, int r101) {
        Iterator<OnItemChangedListener> r102 = this.onItemChangedListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onCurrentItemChanged(r100, r101);
        goto L4
    }

    private void notifyScrollEnd(RecyclerView.ViewHolder r100, int r101) {
        Iterator<c> r102 = this.scrollStateChangeListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().c();
        goto L4
    }

    private void notifyScrollStart(RecyclerView.ViewHolder r100, int r101) {
        Iterator<c> r102 = this.scrollStateChangeListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a();
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int r100, int r101) {
        DiscreteScrollLayoutManager r102 = this.layoutManager;
        boolean r103 = false;
        if (r102.f420437y.isScrollBlocked(Direction.fromDelta(r102.f420426n.h(r100, r101))) == false) goto L5;
        return false;
    L5:
        boolean r104 = super.fling(r100, r101);
        if (r104 == false) goto L36;
        DiscreteScrollLayoutManager r105 = this.layoutManager;
        int r106 = r105.f420426n.h(r100, r101);
        if (r105.f420434v == false) goto L10;
        int r107 = Math.abs(r106 / r105.f420433u);
    L11:
        int r108 = r105.f420423k + Direction.fromDelta(r106).applyTo(r107);
        int r109 = r105.B.b();
        int r110 = r105.f420423k;
        if (r110 == 0) goto L15;
        if (r108 >= 0) goto L15;
        r108 = 0;
    L20:
        if ((r106 * r105.f420421i) < 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L31;
        if (r108 >= 0) goto L26;
    L28:
        boolean r112 = false;
    L29:
        if (r112 == false) goto L31;
        r103 = true;
        goto L31
    L26:
        if (r108 >= r105.B.b()) goto L28;
        r112 = true;
    L31:
        if (r103 == false) goto L33;
        r105.v(r108);
    L39:
        return r104;
    L33:
        int r113 = -r105.f420421i;
        r105.f420422j = r113;
        if (r113 == 0) goto L39;
        r105.u();
        goto L39
    L22:
        r111 = false;
    L15:
        int r114 = r109 - 1;
        if (r110 == r114) goto L20;
        if (r108 < r109) goto L20;
        r108 = r114;
        goto L20
    L10:
        r107 = 1;
        goto L11
    L36:
        DiscreteScrollLayoutManager r115 = this.layoutManager;
        int r116 = -r115.f420421i;
        r115.f420422j = r116;
        if (r116 == 0) goto L39;
        r115.u();
        goto L39
    }

    public DiscreteScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.notifyItemChangedRunnable = new a(this);
        init(r101);
    }

    public static /* synthetic */ void access$600(DiscreteScrollView r100, RecyclerView.ViewHolder r101, int r102) {
        r100.notifyScrollStart(r101, r102);
    }

    public static /* synthetic */ void access$800(DiscreteScrollView r100, RecyclerView.ViewHolder r101, int r102) {
        r100.notifyScrollEnd(r101, r102);
    }

    public static /* synthetic */ void access$900(DiscreteScrollView r100, RecyclerView.ViewHolder r101, int r102) {
        r100.notifyCurrentItemChanged(r101, r102);
    }

    private void notifyScroll(float r100, int r101, int r102, RecyclerView.ViewHolder r103, RecyclerView.ViewHolder r104) {
        Iterator<c> r105 = this.scrollStateChangeListeners.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r105.next().b();
        goto L4
    }

    public static /* synthetic */ void access$1000(DiscreteScrollView r100, float r101, int r102, int r103, RecyclerView.ViewHolder r104, RecyclerView.ViewHolder r105) {
        r100.notifyScroll(r101, r102, r103, r104, r105);
    }
}
