package com.larus.camera.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.camera.impl.utils.TabPickerAdapter;
import com.larus.nova.R;
import com.larus.utils.m0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001-\u0018\u00002\u00020\u0001:\u0001?B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013J\r\u0010,\u001a\u00020-H\u0002¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\u001a\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\u0013H\u0002J\b\u00105\u001a\u00020\u0016H\u0002J\u0014\u00106\u001a\u00020\u00162\f\u00107\u001a\b\u0012\u0004\u0012\u00020908J\u0006\u0010:\u001a\u00020\u0007J\u001a\u0010;\u001a\u00020\u00162\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160=J\u0016\u0010>\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007R\u001b\u0010\n\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/camera/impl/widget/TabPickerView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedColor", "getSelectedColor", "()I", "selectedColor$delegate", "Lkotlin/Lazy;", "unSelectedColor", "getUnSelectedColor", "unSelectedColor$delegate", "isFirstInitialized", "", "isForceInterceptScroll", "setForceInterceptFling", "", "isForceInterceptFling", "tabContainer", "Landroidx/recyclerview/widget/RecyclerView;", "getTabContainer", "()Landroidx/recyclerview/widget/RecyclerView;", "tabContainer$delegate", "tabItemUpdater", "Lcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;", "getTabItemUpdater", "()Lcom/larus/camera/impl/widget/PickerLayoutManager$ItemUpdater;", "tabItemUpdater$delegate", "layoutManager", "Lcom/larus/camera/impl/widget/PickerLayoutManager;", "adapter", "Lcom/larus/camera/impl/utils/TabPickerAdapter;", "helper", "Landroidx/recyclerview/widget/LinearSnapHelper;", "lastSelectedView", "Landroid/view/View;", "selectedPosition", "scrollHandled", "createFlingListener", "com/larus/camera/impl/widget/TabPickerView$createFlingListener$1", "()Lcom/larus/camera/impl/widget/TabPickerView$createFlingListener$1;", "scrollFromFling", "velocityX", "velocityY", "scrollToItemCenter", "position", "smooth", "setWindowPadding", "setTabList", "list", "", "Lcom/larus/camera/impl/widget/TabPickerView$Tab;", "getTabCount", "setOnTabPickedListener", "listener", "Lkotlin/Function1;", "pickFromFlingGesture", "Tab", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabPickerView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f322886m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f322887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f322888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f322889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f322890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f322891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f322892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PickerLayoutManager f322893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TabPickerAdapter f322894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearSnapHelper f322895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f322896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f322897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f322898l;

    /* JADX INFO: renamed from: com.larus.camera.impl.widget.TabPickerView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<Integer, Unit> {
        public AnonymousClass1(Object r100) {
            super(1, r100, TabPickerView.class, "scrollToItemCenter", "scrollToItemCenter(IZ)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
            invoke(r100.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int r100) {
            TabPickerView r101 = (TabPickerView) this.receiver;
            int r102 = TabPickerView.f322886m;
            r101.f(r100, true);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f322900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f322901b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f322900a, r101.f322900a) == true) goto L12;
            return false;
        L12:
            if (this.f322901b == r101.f322901b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f322900a.hashCode() * 31;
            if (this.f322901b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Tab(name=" + this.f322900a + ", selected=" + this.f322901b + ')';
        }

        public a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f322900a = r100;
            this.f322901b = r101;
        }
    }

    public static final class b implements PickerLayoutManager.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabPickerView f322902a;

        public b(TabPickerView r100) {
            this.f322902a = r100;
        }

        @Override // com.larus.camera.impl.widget.PickerLayoutManager.a
        public final void a(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            TabPickerView r102 = this.f322902a;
            if (r102.f322889c == false) goto L5;
            return;
        L5:
            if (r101 != 0.0f) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L10;
            return;
        L10:
            if ((r100 instanceof TextView) == false) goto L12;
            ((TextView) r100).setTextColor(TabPickerView.d(r102));
            this.f322902a.f322896j = r100;
        L12:
            this.f322902a.f322889c = true;
            return;
        L7:
            r103 = false;
            goto L8
        }
    }

    public TabPickerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TabPickerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void a(TabPickerView r100) {
        setTabList$lambda$6(r100);
    }

    public static /* synthetic */ void c(TabPickerView r100) {
        setTabList$lambda$6$lambda$5(r100);
    }

    private final int getSelectedColor() {
        return ((Number) this.f322887a.getValue()).intValue();
    }

    private final RecyclerView getTabContainer() {
        return (RecyclerView) this.f322891e.getValue();
    }

    private final PickerLayoutManager.a getTabItemUpdater() {
        return (PickerLayoutManager.a) this.f322892f.getValue();
    }

    private final int getUnSelectedColor() {
        return ((Number) this.f322888b.getValue()).intValue();
    }

    public final int getTabCount() {
        return this.f322894h.getItemCount();
    }

    public static final /* synthetic */ int d(TabPickerView r100) {
        return r100.getSelectedColor();
    }

    private static final void setTabList$lambda$6(final TabPickerView r100) {
        r100.f322893g.scrollToPosition(r100.f322897k);
        r100.post(new a0(r100));
    }

    private static final void setTabList$lambda$6$lambda$5(TabPickerView r100) {
        r100.f(r100.f322897k, false);
    }

    public final boolean e(int r100) {
        if (Math.abs(r100) > getTabContainer().getMinFlingVelocity()) goto L5;
        return false;
    L5:
        View r101 = this.f322893g.p();
        if (r101 == null) goto L8;
        int r102 = getTabContainer().getChildAdapterPosition(r101);
    L10:
        if (r100 <= 0) goto L12;
        int r103 = 1;
    L13:
        f(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r102 + r103, this.f322894h.getItemCount() - 1), 0), true);
        return true;
    L12:
        r103 = -1;
        goto L13
    L8:
        r102 = this.f322897k;
        goto L10
    }

    public final void setForceInterceptFling(boolean r100) {
        this.f322890d = r100;
    }

    public final void setOnTabPickedListener(final Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        PickerLayoutManager r101 = this.f322893g;
        Function1<? super View, Unit> r102 = new b0(this, r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.f322875b = r102;
    }

    public final void setTabList(List<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f322894h.submitList(r100);
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (((a) r102).f322901b == false) goto L4;
    L9:
        a r103 = (a) r102;
        if (r103 != null) goto L12;
        return;
    L12:
        this.f322897k = r100.indexOf(r103);
        post(new v(this));
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void f(int r100, boolean r101) {
        View r102 = this.f322893g.findViewByPosition(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        int[] r103 = this.f322895i.calculateDistanceToFinalSnap(this.f322893g, r102);
        if (r103 != null) goto L8;
        return;
    L8:
        if (r101 == false) goto L10;
        Function2 r104 = new TabPickerView$scrollToItemCenter$scroll$1(getTabContainer());
    L11:
        int r105 = r103[0];
        if (r105 == 0) goto L14;
    L15:
        r104.invoke(Integer.valueOf(r105), Integer.valueOf(r103[1]));
        return;
    L14:
        if (r103[1] != 0) goto L15;
        return;
    L10:
        r104 = new TabPickerView$scrollToItemCenter$scroll$2(getTabContainer());
        goto L11
    }

    public TabPickerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f322887a = LazyKt.lazy(new w(r100));
        this.f322888b = LazyKt.lazy(new x(r100));
        this.f322891e = LazyKt.lazy(new y(this));
        this.f322892f = LazyKt.lazy(new z(this));
        PickerLayoutManager r103 = new PickerLayoutManager(r100, getTabItemUpdater());
        this.f322893g = r103;
        TabPickerAdapter r104 = new TabPickerAdapter();
        this.f322894h = r104;
        this.f322895i = new LinearSnapHelper();
        this.f322897k = -1;
        this.f322898l = true;
        FrameLayout.inflate(r100, R.layout.larus_layout_view_tab_picker, this);
        getTabContainer().setLayoutManager(r103);
        getTabContainer().setAdapter(r104);
        int r105 = m0.f375450a;
        int r106 = RangesKt.coerceAtLeast(m0.b(getContext()) / 2, 0);
        getTabContainer().setPadding(r106, 0, r106, 0);
        AnonymousClass1 r107 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r107, "scrollListener");
        r104.f322708a = r107;
        getTabContainer().setOnFlingListener(new TabPickerView$createFlingListener$1(this));
        getTabContainer().addOnScrollListener(new AnonymousClass2(this));
    }

    public static Unit b(TabPickerView r100, Function1 r101, View r102) {
        if (r102 != null) goto L5;
        return Unit.INSTANCE;
    L5:
        if (r100.f322890d == false) goto L7;
        r100.f(r100.f322897k, false);
        return Unit.INSTANCE;
    L7:
        int r103 = r100.getTabContainer().getChildAdapterPosition(r102);
        if (r103 != r100.f322897k) goto L11;
        return Unit.INSTANCE;
    L11:
        if ((r102 instanceof TextView) == false) goto L13;
        ((TextView) r102).setTextColor(r100.getSelectedColor());
    L13:
        View r104 = r100.f322896j;
        boolean r105 = r104 instanceof TextView;
        if (r105 == false) goto L20;
        if (r105 == false) goto L17;
        TextView r106 = (TextView) r104;
    L18:
        if (r106 == null) goto L20;
        r106.setTextColor(r100.getUnSelectedColor());
        goto L20
    L17:
        r106 = null;
    L20:
        r100.f322897k = r103;
        r100.f322896j = r102;
        r101.invoke(Integer.valueOf(r103));
        return Unit.INSTANCE;
    }

    public /* synthetic */ TabPickerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
