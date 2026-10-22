package com.bytedance.creativex.mediaimport.view.internal.base;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import com.bytedance.creativex.mediaimport.view.internal.selector.CenterLayoutManager;
import com.bytedance.creativex.mediaimport.view.internal.selector.MaterialSelectionItemMovedCallback;
import com.bytedance.creativex.mediaimport.view.internal.viewholder.SelectionListViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.view.widget.adapter.DataListAdapter;
import com.ss.android.ugc.tools.view.widget.adapter.FooterRecyclerViewAdapter;
import com.ss.android.ugc.tools.view.widget.adapter.HeaderRecyclerViewAdapter;
import com.ss.android.ugc.tools.view.widget.state.CommonUiState;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class BaseMaterialSelectionListView<DATA> extends BaseMediaCoreListView<DATA> implements ti4.j<DATA> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ti4.m<DATA> f203688n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f203689o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final BehaviorSubject<ti4.h0<DATA>> f203690p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final BehaviorSubject<ti4.g0> f203691q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SelectorListHeaderAdapter f203692r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SelectorListFooterAdapter f203693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final k f203694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l f203695u;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMaterialSelectionListView$SelectorListAdapter;", "DATA", "Lcom/ss/android/ugc/tools/view/widget/adapter/DataListAdapter;", "<init>", "(Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMaterialSelectionListView;)V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "bindSelectorViewHolder", "isPartLoad", "", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SelectorListAdapter<DATA> extends DataListAdapter<DATA> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseMaterialSelectionListView<DATA> f203696b;

        public SelectorListAdapter(BaseMaterialSelectionListView r100) {
            this.f203696b = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            y2(r100, r101, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            BaseMaterialSelectionListView<DATA> r102 = this.f203696b;
            return r102.x(r100, r101, r102.f203694t, r102.f203695u);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Intrinsics.checkNotNullParameter(r102, "payloads");
            y2(r100, r101, !r102.isEmpty());
        }

        public final void y2(RecyclerView.ViewHolder r100, int r101, boolean r102) {
            Object r103 = ListProtector.get(this.f203696b.h().f455121a, r101);
            BaseMaterialSelectionListView<DATA> r104 = this.f203696b;
            MaterialSelectedState r105 = r104.y((DATA) r103);
            ti4.m<DATA> r106 = r104.f203688n;
            if (r106 == null) goto L6;
            MaterialSelectedState r107 = r106.getSelectState((DATA) r103);
            if (r107 == null) goto L6;
        L7:
            BaseSelectorViewHolder.a.C2958a r108 = new BaseSelectorViewHolder.a.C2958a(r105, r107, r102);
            this.f203696b.w(r100, r101, r103, r108);
            return;
        L6:
            r107 = MaterialSelectedState.NON_SELECTED;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMaterialSelectionListView$SelectorListFooterAdapter;", "Lcom/ss/android/ugc/tools/view/widget/adapter/FooterRecyclerViewAdapter;", "delegate", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "(Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMaterialSelectionListView;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "onCreateFooterViewHolder", "parent", "Landroid/view/ViewGroup;", "onBindFooterViewHolder", "", "holder", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SelectorListFooterAdapter extends FooterRecyclerViewAdapter {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseMaterialSelectionListView<DATA> f203697d;

        @Override // com.ss.android.ugc.tools.view.widget.adapter.FooterRecyclerViewAdapter
        public final void onBindFooterViewHolder(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Function1<? super RecyclerView.ViewHolder, Boolean> r101 = this.f203697d.f203689o.f203707i;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L7:
            if (r102 == true) goto L10;
            this.f203697d.getClass();
            Intrinsics.checkNotNullParameter(r100, "holder");
            return;
        L10:
            return;
        L5:
            if (r101.invoke(r100).booleanValue() != true) goto L7;
            r102 = true;
            goto L7
        }

        @Override // com.ss.android.ugc.tools.view.widget.adapter.FooterRecyclerViewAdapter
        public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            Function1<? super ViewGroup, ? extends RecyclerView.ViewHolder> r101 = this.f203697d.f203689o.f203706h;
            if (r101 == null) goto L7;
            RecyclerView.ViewHolder r102 = r101.invoke(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            this.f203697d.getClass();
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new DefaultInvisibleViewHolder(r100);
        }

        public SelectorListFooterAdapter(BaseMaterialSelectionListView r100, RecyclerView.Adapter<RecyclerView.ViewHolder> r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
            this.f203697d = r100;
            super(r101, true);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMaterialSelectionListView$SelectorListHeaderAdapter;", "Lcom/ss/android/ugc/tools/view/widget/adapter/HeaderRecyclerViewAdapter;", "delegate", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "(Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMaterialSelectionListView;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "onCreateHeaderViewHolder", "parent", "Landroid/view/ViewGroup;", "onBindHeaderViewHolder", "", "holder", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SelectorListHeaderAdapter extends HeaderRecyclerViewAdapter {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BaseMaterialSelectionListView<DATA> f203698d;

        @Override // com.ss.android.ugc.tools.view.widget.adapter.HeaderRecyclerViewAdapter
        public final void A2(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            Function1<? super RecyclerView.ViewHolder, Boolean> r101 = this.f203698d.f203689o.f203704f;
            boolean r102 = false;
            if (r101 != null) goto L5;
        L7:
            if (r102 == true) goto L10;
            this.f203698d.getClass();
            Intrinsics.checkNotNullParameter(r100, "holder");
            return;
        L10:
            return;
        L5:
            if (r101.invoke(r100).booleanValue() != true) goto L7;
            r102 = true;
            goto L7
        }

        @Override // com.ss.android.ugc.tools.view.widget.adapter.HeaderRecyclerViewAdapter
        public final RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            Function1<? super ViewGroup, ? extends RecyclerView.ViewHolder> r101 = this.f203698d.f203689o.f203703e;
            if (r101 == null) goto L7;
            RecyclerView.ViewHolder r102 = r101.invoke(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            this.f203698d.getClass();
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new DefaultInvisibleViewHolder(r100);
        }

        public SelectorListHeaderAdapter(BaseMaterialSelectionListView r100, DataListAdapter r101) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
            this.f203698d = r100;
            super(r101, true);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.ItemAnimator f203699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f203700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f203701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f203702d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<? super ViewGroup, ? extends RecyclerView.ViewHolder> f203703e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<? super RecyclerView.ViewHolder, Boolean> f203704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f203705g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function1<? super ViewGroup, ? extends RecyclerView.ViewHolder> f203706h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function1<? super RecyclerView.ViewHolder, Boolean> f203707i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f203708j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function2<? super RecyclerView.ViewHolder, ? super Long, ? extends ViewPropertyAnimator> f203709k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function2<? super RecyclerView.ViewHolder, ? super Long, ? extends ViewPropertyAnimator> f203710l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function1<Boolean, Unit> f203711m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<Boolean, Unit> f203712n;

        public a() {
            throw null;
        }

        public a(i r100, j r101) {
            DefaultItemAnimator r102 = new DefaultItemAnimator();
            r102.setAddDuration(250);
            r102.setMoveDuration(250);
            r102.setRemoveDuration(250);
            r102.setChangeDuration(250);
            Intrinsics.checkNotNullParameter(r100, "showHideHeader");
            Intrinsics.checkNotNullParameter(r101, "showHideFooter");
            this.f203699a = r102;
            this.f203700b = true;
            this.f203701c = false;
            this.f203702d = false;
            this.f203703e = null;
            this.f203704f = null;
            this.f203705g = false;
            this.f203706h = null;
            this.f203707i = null;
            this.f203708j = false;
            this.f203709k = null;
            this.f203710l = null;
            this.f203711m = r100;
            this.f203712n = r101;
        }
    }

    public abstract void w(RecyclerView.ViewHolder r100, int r101, Object r102, BaseSelectorViewHolder.a.C2958a r103);

    public abstract SelectionListViewHolder x(ViewGroup r100, int r101, k r102, l r103);

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public final DataListAdapter<DATA> o() {
        return new SelectorListAdapter(this);
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public final LiveData<List<DATA>> s() {
        ti4.m<DATA> r100 = this.f203688n;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSelectedMaterials();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.creativex.mediaimport.view.internal.base.d] */
    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public void k() {
        super.k();
        j().setItemAnimator(this.f203689o.f203699a);
        a r100 = this.f203689o;
        if (r100.f203700b == false) goto L5;
        MaterialSelectionItemMovedCallback r101 = new MaterialSelectionItemMovedCallback(r100.f203708j, r100.f203709k, r100.f203710l);
        Observable<ti4.g0> r102 = r101.f204090b.hide();
        final ?? r103 = new d(this);
        r102.subscribe(new e(r103));
        new ItemTouchHelper((MaterialSelectionItemMovedCallback.MaterialSelectorItemTouchCallback) r101.f204093e.getValue()).attachToRecyclerView(j());
    L5:
        LifecycleOwner r104 = this.f203715b;
        ti4.m<DATA> r105 = this.f203688n;
        if (r105 == null) goto L9;
        r105.getSelectedMaterials().observe(r104, new f(this));
        r105.getSelectionChanged().observe(r104, new g(this));
        return;
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> m() {
        DataListAdapter<DATA> r100 = h();
        if (this.f203689o.f203702d == false) goto L6;
        SelectorListHeaderAdapter r101 = new SelectorListHeaderAdapter(this, r100);
        this.f203692r = r101;
        r100 = (DataListAdapter<DATA>) r101;
    L6:
        if (this.f203689o.f203705g == false) goto L9;
        SelectorListFooterAdapter r102 = new SelectorListFooterAdapter(this, r100);
        this.f203693s = r102;
        return r102;
    L9:
        return r100;
    }

    @Override // ti4.j
    public final boolean c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        ti4.m<DATA> r101 = this.f203688n;
        if (r101 != null) goto L5;
        return false;
    L5:
        List<DATA> r102 = r101.getSelectedMaterials().getValue();
        if (r102 != null) goto L8;
        return false;
    L8:
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        if ((r104 instanceof ki4.r) == true) goto L14;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L10;
    L20:
        if (r104 == null) goto L28;
        r101.cancel((DATA) r104);
        return true;
    L28:
        return false;
    L14:
        if (Intrinsics.areEqual(((ki4.r) r104).getUri(), r100) == false) goto L16;
        r105 = true;
        goto L17
    L19:
        r104 = null;
        goto L20
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public final int f(int r100) {
        if (this.f203689o.f203702d == false) goto L8;
        SelectorListHeaderAdapter r101 = this.f203692r;
        if (r101 != null) goto L7;
        return r100;
    L7:
        return r100 + r101.z2();
    L8:
        return r100;
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public final int l(int r100) {
        if (this.f203689o.f203702d == false) goto L8;
        SelectorListHeaderAdapter r101 = this.f203692r;
        if (r101 == null) goto L8;
        r100 = r100 - r101.z2();
    L8:
        return super.l(r100);
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public View n(ViewGroup r100) {
        return LayoutInflater.from(getContext()).inflate(R.layout.larus_tools_media_import_selection_list_view, r100, true);
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public final RecyclerView.LayoutManager q(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        return new CenterLayoutManager(getContext());
    }

    @Override // com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaCoreListView
    public final com.ss.android.ugc.tools.view.widget.state.a<CommonUiState> t(View r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return aj4.a.f3900a;
    }

    public MaterialSelectedState y(DATA r100) {
        return MaterialSelectedState.NON_SELECTED;
    }

    public void z(boolean r100) {
        ci4.a.a(j(), !r100);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.creativex.mediaimport.view.internal.base.j] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.bytedance.creativex.mediaimport.view.internal.base.i] */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.bytedance.creativex.mediaimport.view.internal.base.k] */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.bytedance.creativex.mediaimport.view.internal.base.l] */
    public BaseMaterialSelectionListView(Context r100, LifecycleOwner r101, ti4.m<DATA> r110, ViewGroup r111, boolean r112, Function1<? super a, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        super(r100, r101, null, r111, r112);
        this.f203688n = r110;
        a r102 = new a(new i(this), new j(this));
        this.f203689o = r102;
        this.f203690p = BehaviorSubject.create();
        this.f203691q = BehaviorSubject.create();
        this.f203694t = new k(this);
        this.f203695u = new l(this);
        if (r113 == null) goto L6;
        r113.invoke(r102);
        return;
    }
}
