package com.larus.home.impl.main.side_bar.view.adapter.arch;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.home.impl.main.side_bar.view.adapter.x0;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import yb9.d;
import yb9.e;

/* JADX INFO: loaded from: classes29.dex */
public final class ReorderableConcatAdapterHost {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f344944p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f344945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcatAdapter f344946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public yb9.a f344947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> f344948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView.ViewHolder f344949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f344950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f344951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f344952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f344953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RecyclerView.ItemAnimator f344954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ReorderableItemAnimator f344955k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final IdentityHashMap<View, Float> f344956l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DetachAwareItemTouchHelper f344957m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f344958n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ReorderableConcatAdapterHost$childAttachStateChangeListener$1 f344959o;

    public static final class a {
    }

    public final class b extends ItemTouchHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReorderableConcatAdapterHost f344960a;

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final float getMoveThreshold(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "viewHolder");
            return 0.1f;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final boolean isItemViewSwipeEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onMoved(RecyclerView r100, RecyclerView.ViewHolder r101, int r102, RecyclerView.ViewHolder r103, int r104, int r105, int r106) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "viewHolder");
            Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onSwiped(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "viewHolder");
        }

        public b(ReorderableConcatAdapterHost r100) {
            this.f344960a = r100;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "viewHolder");
            super.clearView(r100, r101);
            this.f344960a.b();
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "viewHolder");
            c r102 = ReorderableConcatAdapterHost.a(this.f344960a, r101);
            if (r102 == null) goto L9;
            yb9.a r103 = r102.f344962b;
            if (r103 == null) goto L9;
            boolean r104 = r103.y1(r102.f344963c);
            boolean r105 = true;
            if (r104 != true) goto L9;
        L10:
            if (r105 == false) goto L12;
            int r106 = 3;
        L14:
            return ItemTouchHelper.Callback.makeMovementFlags(r106, 0);
        L12:
            r106 = 0;
        L9:
            r105 = false;
            goto L10
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
            super.onSelectedChanged(r100, r101);
            if (r101 != 2) goto L16;
            if (r100 == null) goto L17;
            c r102 = ReorderableConcatAdapterHost.a(this.f344960a, r100);
            if (r102 != null) goto L9;
            return;
        L9:
            this.f344960a.f344955k.endAnimation(r100);
            ReorderableConcatAdapterHost r103 = this.f344960a;
            r103.f344949e = r100;
            r103.f344950f = r100.itemView.getBackground();
            x0.c(r100.itemView, true);
            ReorderableConcatAdapterHost r104 = this.f344960a;
            r104.f344948d = r102.f344961a;
            r104.f344953i = false;
            r100.setIsRecyclable(false);
            ReorderableConcatAdapterHost r105 = this.f344960a;
            r105.f344945a.setChildDrawingOrderCallback(r105.f344958n);
            ReorderableConcatAdapterHost r106 = this.f344960a;
            yb9.a r107 = r106.f344947c;
            if (r107 == r102.f344962b) goto L14;
            if (r107 == null) goto L13;
            r107.u0();
        L13:
            r106.f344947c = null;
            ReorderableConcatAdapterHost r108 = this.f344960a;
            yb9.a r109 = r102.f344962b;
            r108.f344947c = r109;
            r109.U0();
        L14:
            ReorderableConcatAdapterHost r110 = this.f344960a;
            r110.f344952h = r102.f344962b.t2(r102.f344963c);
            ReorderableConcatAdapterHost r111 = this.f344960a;
            r111.f344951g = r111.c();
            return;
        L17:
            return;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final boolean canDropOver(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "current");
            Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
            c r103 = ReorderableConcatAdapterHost.a(this.f344960a, r102);
            if (r103 != null) goto L6;
            return false;
        L6:
            if (r103.f344961a == this.f344960a.f344948d) goto L8;
            return false;
        L8:
            if (r103.f344962b.y1(r103.f344963c) == true) goto L12;
            if (r103.f344962b.A1(r103.f344963c) == true) goto L12;
            return false;
        L12:
            if (r103.f344963c == this.f344960a.c()) goto L17;
            return true;
        L17:
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final boolean onMove(RecyclerView r110, RecyclerView.ViewHolder r111, RecyclerView.ViewHolder r112) {
            Intrinsics.checkNotNullParameter(r110, "recyclerView");
            Intrinsics.checkNotNullParameter(r111, "viewHolder");
            Intrinsics.checkNotNullParameter(r112, PickerReporterConstants.KEY.TARGET);
            c r100 = ReorderableConcatAdapterHost.a(this.f344960a, r111);
            boolean r101 = false;
            if (r100 != null) goto L5;
            return false;
        L5:
            c r102 = ReorderableConcatAdapterHost.a(this.f344960a, r112);
            if (r102 != null) goto L9;
            return false;
        L9:
            if (r100.f344961a == r102.f344961a) goto L11;
            return false;
        L11:
            int r103 = r100.f344963c;
            if (r103 != r102.f344963c) goto L15;
            return false;
        L15:
            if (r100.f344962b.y1(r103) == true) goto L18;
            return false;
        L18:
            if (r102.f344962b.y1(r102.f344963c) == true) goto L21;
            r100.f344962b.l2(r102.f344963c);
            return false;
        L21:
            int r104 = r112.getAbsoluteAdapterPosition();
            Integer r105 = null;
            if (r104 == (-1)) goto L52;
            int r113 = com.larus.home.impl.main.side_bar.view.adapter.arch.a.f344966d;
            int r114 = (r104 - r102.f344963c) + r100.f344963c;
            Intrinsics.checkNotNullParameter(r110, "recyclerView");
            if (r114 < 0) goto L52;
            if (r104 < 0) goto L52;
            RecyclerView.LayoutManager r106 = r110.getLayoutManager();
            if ((r106 instanceof LinearLayoutManager) == false) goto L30;
            LinearLayoutManager r107 = (LinearLayoutManager) r106;
        L31:
            if (r107 == null) goto L52;
            if (r107.getOrientation() != 1) goto L52;
            IntRange r115 = new IntRange(Math.min(r114, r104), Math.max(r114, r104));
            OrientationHelper r108 = OrientationHelper.createVerticalHelper(r107);
            int r116 = r110.getChildCount();
            int r117 = 0;
        L37:
            if (r117 >= r116) goto L52;
            View r118 = r110.getChildAt(r117);
            int r119 = r110.getChildViewHolder(r118).getAbsoluteAdapterPosition();
            if (r119 == (-1)) goto L51;
            int r120 = r115.getFirst();
            if (r119 > r115.getLast()) goto L44;
            if (r120 > r119) goto L44;
            boolean r109 = true;
        L45:
            if (r109 == true) goto L51;
            if (r107.getReverseLayout() == false) goto L49;
            int r121 = r108.getEndAfterPadding();
            int r122 = r108.getDecoratedEnd(r118);
        L50:
            com.larus.home.impl.main.side_bar.view.adapter.arch.a r123 = new com.larus.home.impl.main.side_bar.view.adapter.arch.a(r107, r119, r121 - r122);
        L53:
            r110.performHapticFeedback(4);
            r110.playSoundEffect(0);
            boolean r124 = r100.f344962b.e2(r100.f344963c, r102.f344963c);
            if (r124 == false) goto L66;
            if (r123 == null) goto L57;
            r123.f344967a.scrollToPositionWithOffset(r123.f344968b, r123.f344969c);
        L57:
            int r125 = this.f344960a.c();
            ReorderableConcatAdapterHost r126 = this.f344960a;
            Integer r127 = Integer.valueOf(r125);
            if (r127.intValue() == (-1)) goto L60;
            r101 = true;
        L60:
            if (r101 == false) goto L62;
            r105 = r127;
        L62:
            if (r105 == null) goto L64;
            int r128 = r105.intValue();
        L65:
            r126.f344951g = r128;
            this.f344960a.e();
            goto L66
        L64:
            r128 = r102.f344963c;
        L66:
            return r124;
        L49:
            r121 = r108.getDecoratedStart(r118);
            r122 = r108.getStartAfterPadding();
        L44:
            r109 = false;
        L51:
            r117 = r117 + 1;
            goto L37
        L30:
            r107 = null;
        L52:
            r123 = null;
            goto L53
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder r110, List<RecyclerView.ViewHolder> r111, int r112, int r113) {
            Intrinsics.checkNotNullParameter(r110, "selected");
            Intrinsics.checkNotNullParameter(r111, "dropTargets");
            int r114 = this.f344960a.c();
            RecyclerView.ViewHolder r100 = null;
            if (r114 != (-1)) goto L5;
            return null;
        L5:
            float r115 = r113 + (r110.itemView.getHeight() / 2.0f);
            Iterator<RecyclerView.ViewHolder> r116 = r111.iterator();
            float r101 = Float.MAX_VALUE;
        L7:
            if (r116.hasNext() == false) goto L26;
            RecyclerView.ViewHolder r102 = r116.next();
            if (canDropOver(this.f344960a.f344945a, r110, r102) == false) goto L7;
            c r103 = ReorderableConcatAdapterHost.a(this.f344960a, r102);
            if (r103 == null) goto L7;
            int r104 = r103.f344963c;
            View r105 = r102.itemView;
            float r106 = r105.getHeight() * 0.1f;
            boolean r107 = true;
            if (r104 > r114) goto L15;
            if (r104 < r114) goto L19;
        L21:
            r107 = false;
        L22:
            if (r107 == false) goto L7;
            float r108 = Math.abs(r115 - (r105.getTop() + (r105.getHeight() / 2.0f)));
            if (r108 >= r101) goto L7;
            r100 = r102;
            r101 = r108;
            goto L7
        L19:
            if (r115 > (r105.getBottom() - r106)) goto L21;
        L15:
            if (r115 < (r105.getTop() + r106)) goto L21;
        L26:
            return r100;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onChildDraw(Canvas r100, RecyclerView r101, RecyclerView.ViewHolder r102, float r103, float r104, int r105, boolean r106) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "recyclerView");
            Intrinsics.checkNotNullParameter(r102, "viewHolder");
            r102.itemView.setTranslationX(r103);
            r102.itemView.setTranslationY(r104);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public final void onChildDrawOver(Canvas r100, RecyclerView r101, RecyclerView.ViewHolder r102, float r103, float r104, int r105, boolean r106) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "recyclerView");
            super.onChildDrawOver(r100, r101, r102, r103, r104, r105, r106);
            ReorderableConcatAdapterHost r107 = this.f344960a;
            if (r107.f344953i == true) goto L5;
            return;
        L5:
            if (r102 != r107.f344949e) goto L22;
            if (r102 == null) goto L21;
            View r108 = r102.itemView;
            if (r108 == null) goto L23;
            float r109 = r108.getLeft() + r103;
            float r110 = r108.getTop() + r104;
            int r111 = r100.save();
            r100.translate(r109, r110);
            r108.draw(r100);     // Catch: Throwable -> L15
            r100.restoreToCount(r111);
            return;
        L15:
            th = move-exception;
            r100.restoreToCount(r111);
            throw th;
        L23:
            return;
        L21:
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> f344961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final yb9.a f344962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f344963c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f344961a, r101.f344961a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f344962b, r101.f344962b) == true) goto L15;
            return false;
        L15:
            if (this.f344963c == r101.f344963c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f344961a.hashCode() * 31) + this.f344962b.hashCode()) * 31) + this.f344963c;
        }

        public final String toString() {
            return "ReorderablePosition(adapter=" + this.f344961a + ", reorderableChild=" + this.f344962b + ", localPosition=" + this.f344963c + ')';
        }

        public c(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100, yb9.a r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "adapter");
            Intrinsics.checkNotNullParameter(r101, "reorderableChild");
            this.f344961a = r100;
            this.f344962b = r101;
            this.f344963c = r102;
        }
    }

    static {
    }

    public final void b() {
        Iterator<Map.Entry<View, Float>> r100 = this.f344956l.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<View, Float> r101 = r100.next();
        View r102 = r101.getKey();
        Float r103 = r101.getValue();
        Intrinsics.checkNotNull(r103);
        r102.setAlpha(r103.floatValue());
        goto L4
    L6:
        this.f344956l.clear();
        RecyclerView.ViewHolder r104 = this.f344949e;
        if (r104 == null) goto L11;
        View r105 = r104.itemView;
        if (r105 == null) goto L11;
        r105.setBackground(this.f344950f);
        r105.setTranslationX(0.0f);
        r105.setTranslationY(0.0f);
    L11:
        RecyclerView.ViewHolder r106 = this.f344949e;
        if (r106 == null) goto L14;
        r106.setIsRecyclable(true);
    L14:
        this.f344949e = null;
        this.f344950f = null;
        this.f344948d = null;
        this.f344951g = -1;
        this.f344952h = null;
        this.f344953i = false;
        this.f344945a.setChildDrawingOrderCallback(null);
        yb9.a r107 = this.f344947c;
        if (r107 == null) goto L17;
        r107.u0();
    L17:
        this.f344947c = null;
    }

    public final int c() {
        String r100 = this.f344952h;
        Integer r101 = null;
        if (r100 == null) goto L7;
        yb9.a r102 = this.f344947c;
        if (r102 == null) goto L7;
        r101 = Integer.valueOf(r102.n0(r100));
    L7:
        if (r101 == null) goto L12;
        if (r101.intValue() == (-1)) goto L12;
        return r101.intValue();
    L12:
        return this.f344951g;
    }

    public final void d() {
        this.f344955k.endAnimations();
        b();
        this.f344957m.attachToRecyclerView(null);
        this.f344945a.removeOnChildAttachStateChangeListener(this.f344959o);
        if (this.f344945a.getItemAnimator() != this.f344955k) goto L6;
        this.f344945a.setItemAnimator(this.f344954j);
        return;
    }

    public final void e() {
        int r100 = c();
        Iterator r101 = CollectionsKt.toList(this.f344956l.keySet()).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        View r102 = (View) r101.next();
        RecyclerView.ViewHolder r103 = this.f344945a.findContainingViewHolder(r102);
        if (r103 == null) goto L11;
        if (r103.getBindingAdapter() != this.f344948d) goto L11;
        if (r103.getBindingAdapterPosition() == r100) goto L4;
    L11:
        Intrinsics.checkNotNull(r102);
        Float r104 = this.f344956l.remove(r102);
        if (r104 == null) goto L4;
        r102.setAlpha(r104.floatValue());
        goto L4
    L14:
        int r105 = this.f344945a.getChildCount();
        int r106 = 0;
    L15:
        if (r106 >= r105) goto L17;
        f(this.f344945a.getChildAt(r106));
        r106 = r106 + 1;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [yb9.b] */
    /* JADX WARN: Type inference failed for: r1v5, types: [yb9.e] */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener, com.larus.home.impl.main.side_bar.view.adapter.arch.ReorderableConcatAdapterHost$childAttachStateChangeListener$1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [yb9.c] */
    /* JADX WARN: Type inference failed for: r4v0, types: [yb9.d] */
    public ReorderableConcatAdapterHost(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f344945a = r100;
        this.f344946b = new ConcatAdapter(new RecyclerView.Adapter[0]);
        this.f344951g = -1;
        this.f344954j = r100.getItemAnimator();
        ReorderableItemAnimator r101 = new ReorderableItemAnimator(new yb9.b(this));
        this.f344955k = r101;
        this.f344956l = new IdentityHashMap();
        DetachAwareItemTouchHelper r102 = new DetachAwareItemTouchHelper(new b(this), new yb9.c(this), new d(this));
        this.f344957m = r102;
        this.f344958n = new e(this);
        ?? r103 = new ReorderableConcatAdapterHost$childAttachStateChangeListener$1(this);
        this.f344959o = r103;
        r100.setItemAnimator(r101);
        r100.addOnChildAttachStateChangeListener(r103);
        r102.attachToRecyclerView(r100);
    }

    public final void f(View r100) {
        RecyclerView.ViewHolder r101 = this.f344949e;
        if (r101 == null) goto L20;
        View r102 = r101.itemView;
        if (r102 == null) goto L24;
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r103 = this.f344948d;
        if (r103 != null) goto L10;
        return;
    L10:
        if (r100 != r102) goto L12;
        return;
    L12:
        if (this.f344956l.containsKey(r100) == true) goto L25;
        RecyclerView.ViewHolder r104 = this.f344945a.getChildViewHolder(r100);
        if (r104.getBindingAdapter() == r103) goto L17;
        return;
    L17:
        if (r104.getBindingAdapterPosition() != c()) goto L23;
        this.f344956l.put(r100, Float.valueOf(r100.getAlpha()));
        r100.setAlpha(0.0f);
        return;
    L23:
        return;
    L25:
        return;
    L24:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final c a(ReorderableConcatAdapterHost r100, RecyclerView.ViewHolder r101) {
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r102 = r100.f344948d;
        yb9.a r103 = r100.f344947c;
        int r104 = r100.c();
        if (r101 != r100.f344949e) goto L8;
        if (r102 == null) goto L8;
        if (r103 == null) goto L8;
        if (r104 == (-1)) goto L8;
        return new c(r102, r103, r104);
    L8:
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r105 = r101.getBindingAdapter();
        c r106 = null;
        if (r105 == 0) goto L22;
        int r107 = r101.getBindingAdapterPosition();
        if (r107 == (-1)) goto L22;
        if ((r105 instanceof yb9.a) == false) goto L17;
        yb9.a r108 = (yb9.a) r105;
    L18:
        if (r108 == null) goto L22;
        r106 = new c(r105, r108, r107);
        goto L22
    L17:
        r108 = null;
    L22:
        return r106;
    }
}
