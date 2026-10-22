package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewContainer;
import com.bytedance.ee.bear.bitable.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mt4.c;
import mt4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u00042\u00020\u0005:\u0002PQB3\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u00109\u001a\u00020:2\u0006\u00103\u001a\u000204J0\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000bH\u0016J\u0015\u0010B\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010CJ \u0010D\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u000bH&J5\u0010H\u001a\u00020:2\u0016\u0010I\u001a\u00120JR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010K\u001a\u00028\u00012\u0006\u0010<\u001a\u00020\u000bH&¢\u0006\u0002\u0010LJ\u0017\u0010M\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\u000bH&R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\u00120\u0015R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00028\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00060-R\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView;", "V", "Landroid/view/View;", "D", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/IRowScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "fixedCelFixedWidth", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/lang/Integer;)V", "getFixedCelFixedWidth", "()Ljava/lang/Integer;", "setFixedCelFixedWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "adapter", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowAdapter;", "setAdapter", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowAdapter;)V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "fixCol", "getFixCol", "()Landroid/view/View;", "setFixCol", "(Landroid/view/View;)V", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewContext", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewContainer$GridViewContext;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewContainer;", "getViewContext", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewContainer$GridViewContext;", "setViewContext", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridViewContainer$GridViewContext;)V", "rowScrollManager", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;", "getRowScrollManager", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;", "setRowScrollManager", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;)V", "bindScrollManager", "", "onScroll", "position", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/Position;", "scrollX", "dx", "fixedWidth", "minFixedWidth", "createFixedColView", "(Landroid/content/Context;)Landroid/view/View;", "createCellView", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindCellView", "holder", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowViewHolder;", "data", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowViewHolder;Ljava/lang/Object;I)V", "getItemViewType", "(Ljava/lang/Object;)I", "getRowHeight", "RowAdapter", "RowViewHolder", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseRowView<V extends View, D> extends FrameLayout implements mt4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f213621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseRowView<V, D>.RowAdapter f213622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayoutManager f213623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V f213624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f213625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GridViewContainer.e f213626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f213627g;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u0018\u0012\u0014\u0012\u00120\u0002R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0012\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ(\u0010\u0013\u001a\u00120\u0002R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J(\u0010\u0017\u001a\u00020\r2\u0016\u0010\u0018\u001a\u00120\u0002R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowViewHolder;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView;", "<init>", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView;)V", "data", "", "loadingSize", "", "clickListener", "Lkotlin/Function2;", "", "", "getClickListener", "()Lkotlin/jvm/functions/Function2;", "setClickListener", "(Lkotlin/jvm/functions/Function2;)V", "setData", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RowAdapter extends RecyclerView.Adapter<BaseRowView<V, D>.RowViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<? extends D> f213628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f213629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function2<? super Integer, ? super Boolean, Unit> f213630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseRowView<V, D> f213631d;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            if ((!this.f213628a.isEmpty()) == false) goto L6;
            return this.f213628a.size();
        L6:
            return this.f213629b;
        }

        public RowAdapter(BaseRowView r100) {
            this.f213631d = r100;
            this.f213628a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return this.f213631d.e((D) m.j(this.f213628a, r100, null));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            BaseRowView<V, D>.RowViewHolder r102 = (RowViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            Object r103 = m.j(this.f213628a, r101, null);
            int r104 = 0;
            if (r103 == null) goto L12;
            View r105 = r102.itemView;
            if (r101 == 0) goto L7;
        L9:
            r105.setVisibility(r104);
            ViewGroup.LayoutParams r106 = r102.itemView.getLayoutParams();
            r106.width = this.f213631d.getRowScrollManager().f515638b.a(r101);
            this.f213631d.f(r102, (D) r103, r101);
            if (this.f213630c == null) goto L17;
            r102.itemView.setOnClickListener(new a(this, r101));
            r102.itemView.setOnLongClickListener(new b(this, r101));
            return;
        L17:
            return;
        L7:
            if (this.f213631d.getFixedCelFixedWidth() != null) goto L9;
            r104 = 8;
            goto L9
        L12:
            View r107 = r102.itemView;
            if (r101 != 0) goto L15;
            r104 = 8;
        L15:
            r107.setVisibility(r104);
            ViewGroup.LayoutParams r108 = r102.itemView.getLayoutParams();
            r108.width = this.f213631d.getRowScrollManager().f515638b.a(r101);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            BaseRowView<V, D> r102 = this.f213631d;
            return new RowViewHolder(r102.c(r102.getContext(), r100, r101));
        }

        public final void y2(List<? extends D> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f213628a = r100;
            this.f213629b = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView;Landroid/view/View;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RowViewHolder extends RecyclerView.ViewHolder {
        public RowViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public BaseRowView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 0, 14);
    }

    public BaseRowView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public BaseRowView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // mt4.b
    public final /* synthetic */ void a(int r100) {
    }

    public abstract View c(Context r100, ViewGroup r101, int r102);

    public abstract V d(Context r100);

    public abstract int e(D r100);

    public abstract void f(BaseRowView<V, D>.RowViewHolder r100, D r101, int r102);

    public abstract int getRowHeight();

    public final d getRowScrollManager() {
        d r100 = this.f213627g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rowScrollManager");
        return null;
    }

    public final GridViewContainer.e getViewContext() {
        GridViewContainer.e r100 = this.f213626f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewContext");
        return null;
    }

    public final BaseRowView<V, D>.RowAdapter getAdapter() {
        return this.f213622b;
    }

    public final V getFixCol() {
        return this.f213624d;
    }

    public final Integer getFixedCelFixedWidth() {
        return this.f213621a;
    }

    public final LinearLayoutManager getLayoutManager() {
        return this.f213623c;
    }

    public final RecyclerView getRecyclerView() {
        return this.f213625e;
    }

    public final void setAdapter(BaseRowView<V, D>.RowAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213622b = r100;
    }

    public final void setFixCol(V r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213624d = r100;
    }

    public final void setFixedCelFixedWidth(Integer r100) {
        this.f213621a = r100;
    }

    public final void setLayoutManager(LinearLayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213623c = r100;
    }

    public final void setRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213625e = r100;
    }

    public final void setRowScrollManager(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213627g = r100;
    }

    public final void setViewContext(GridViewContainer.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213626f = r100;
    }

    public BaseRowView(Context r100, AttributeSet r101, int r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213621a = r103;
        NoScrollRecyclerView r104 = new NoScrollRecyclerView(r100, null);
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, getRowHeight()));
        LinearLayoutManager r105 = new LinearLayoutManager(r100);
        r105.setOrientation(0);
        this.f213623c = r105;
        r104.setLayoutManager(r105);
        BaseRowView<V, D>.RowAdapter r106 = new RowAdapter(this);
        this.f213622b = r106;
        r104.setAdapter(r106);
        this.f213625e = r104;
        addView(r104);
        V r107 = (V) d(r100);
        Integer r108 = this.f213621a;
        if (r108 == null) goto L5;
        int r109 = r108.intValue();
    L6:
        r107.setLayoutParams(new FrameLayout.LayoutParams(r109, getRowHeight()));
        this.f213624d = r107;
        addView(r107);
        RecyclerView r110 = this.f213625e;
        Integer r111 = this.f213621a;
        if (r111 == null) goto L9;
        int r112 = r111.intValue();
    L10:
        m.s(r110, r112, false);
        return;
    L9:
        r112 = 0;
        goto L10
    L5:
        r109 = -2;
        goto L6
    }

    public /* synthetic */ BaseRowView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102, null);
    }

    public void b(c r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f213623c.scrollToPositionWithOffset(r100.f515635a, r100.f515636b);
        V r105 = this.f213624d;
        if ((r105 instanceof mt4.a) == false) goto L5;
        mt4.a r106 = (mt4.a) r105;
    L6:
        if (r106 == null) goto L9;
        r106.a(r103, r104);
        return;
    L9:
        return;
    L5:
        r106 = null;
        goto L6
    }
}
