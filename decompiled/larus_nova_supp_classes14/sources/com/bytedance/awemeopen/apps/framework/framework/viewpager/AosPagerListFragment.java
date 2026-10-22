package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleColorBallAnimationView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.FeedSwipeRefreshLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.LoadMoreFrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.mix.MixAwemeFeedFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\u00020\u0006:\u0003\t\n\u000bB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListFragment;", "Model", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DoubleBallSwipeRefreshLayout$g;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/g;", "<init>", "()V", "AosFeedItemAdapter", "a", "PullDownType", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosPagerListFragment<Model, VM extends AosPagerListViewModel<Model>> extends AosBaseFragment<VM> implements DoubleBallSwipeRefreshLayout.g, com.bytedance.awemeopen.apps.framework.base.view.refresh.g {
    public static final /* synthetic */ int v = 0;
    public boolean g;
    public DmtStatusView h;
    public FeedSwipeRefreshLayout i;
    public LoadMoreFrameLayout j;
    public VerticalViewPager k;
    public FrameLayout l;
    public DoubleColorBallAnimationView m;
    public AosPagerListFragment<Model, VM>.AosFeedItemAdapter n;
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.o o;
    public f54.a p;
    public PullDownType q;
    public long r;
    public long s;
    public long t;
    public final Map<Integer, View> u;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListFragment$AosFeedItemAdapter;", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/MultiTypePagerAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class AosFeedItemAdapter extends MultiTypePagerAdapter {
        public final HashMap<Model, g<Model>> b;
        public final /* synthetic */ AosPagerListFragment<Model, VM> c;

        public final int getCount() {
            AosPagerListFragment<Model, VM> r0 = this.c;
            int r1 = AosPagerListFragment.v;
            Object r2 = r0.W90().getDataList().getValue();
            Intrinsics.checkNotNull(r2);
            return ((List) ((ListState) r2).a).size();
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final List<Integer> h() {
            this.c.getClass();
            return new ArrayList();
        }

        public AosFeedItemAdapter(AosPagerListFragment r1) {
            this.c = r1;
            r1.getContext();
            this.b = new HashMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final int f(int r3) {
            AosPagerListFragment<Model, VM> r0 = this.c;
            int r1 = AosPagerListFragment.v;
            Object r2 = ((AosPagerListViewModel) r0.W90()).getDataList().getValue();
            Intrinsics.checkNotNull(r2);
            return r0.ia0(r3, ListProtector.get((List) ((ListState) r2).a, r3));
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final int g(View r2) {
            if (r2 == null) goto L4;
            Object r3 = r2.getTag(2131372247);
        L6:
            if ((r3 instanceof Integer) == true) goto L10;
            return 1;
        L10:
            return ((Number) r3).intValue();
        L4:
            r3 = null;
            goto L6
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final int getItemPosition(Object r5) {
            Intrinsics.checkNotNullParameter(r5, "any");
            g<Model> r6 = k(r5);
            if (r6 == null) goto L13;
            int r0 = getCount();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L19;
            AosPagerListFragment<Model, VM> r2 = this.c;
            int r3 = AosPagerListFragment.v;
            Object r4 = r2.W90().getDataList().getValue();
            Intrinsics.checkNotNull(r4);
            Object r7 = ListProtector.get((List) ((ListState) r4).a, r1);
            if (r7 == null) goto L12;
            if (this.c.ha0((Model) r7, r6) == false) goto L12;
            return r1;
        L12:
            r1 = r1 + 1;
            goto L5
        L19:
            return -2;
        L13:
            return -2;
        }

        public final g<Model> k(Object r3) {
            if ((r3 instanceof View) == false) goto L5;
            View r4 = (View) r3;
        L6:
            if (r4 == null) goto L8;
            Object r5 = r4.getTag(2131372246);
        L10:
            if ((r5 instanceof g) == true) goto L12;
            return null;
        L12:
            return (g) r5;
        L8:
            r5 = null;
            goto L10
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final void j(View r2, int r3) {
            g<Model> r4 = k(r2);
            HashMap<Model, g<Model>> r5 = this.b;
            if (r4 == null) goto L5;
            Model r0 = r4.b;
        L6:
            TypeIntrinsics.asMutableMap(r5).remove(r0);
            if (r4 == null) goto L10;
            r4.k();
            return;
        L10:
            return;
        L5:
            r0 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v2, types: [com.bytedance.awemeopen.apps.framework.framework.viewpager.g, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.MultiTypePagerAdapter
        public final View i(int r5, View r6, ViewGroup r7) {
            AosPagerListFragment<Model, VM> r0 = this.c;
            int r1 = AosPagerListFragment.v;
            Object r2 = r0.W90().getDataList().getValue();
            Intrinsics.checkNotNull(r2);
            Object r3 = ListProtector.get((List) ((ListState) r2).a, r5);
            int r4 = f(r5);
            List<Integer> r8 = h();
            ArrayList r9 = (ArrayList) r8;
            if (r9.contains(Integer.valueOf(r4)) == true) goto L7;
            if (r6 == null) goto L7;
            g<Model> r10 = k(r6);
            Intrinsics.checkNotNull(r10);
            View r11 = r6;
            ?? r12 = r10;
        L8:
            this.b.put((Model) r3, (g<Model>) r12);
            r12.c(r3, r5);
            return r11;
        L7:
            AosPagerListFragment<Model, VM> r13 = this.c;
            Intrinsics.checkNotNull(r7);
            g<Model> r14 = r13.ga0(r7, r4);
            View r15 = r14.a;
            r15.setTag(2131372247, Integer.valueOf(r4));
            r15.setTag(2131372246, r14);
            r11 = r15;
            r12 = r14;
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosPagerListFragment$PullDownType;", "", "NONE", "REFRESH", "LOAD_FORWARD", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum PullDownType extends Enum<PullDownType> {
        public static final PullDownType LOAD_FORWARD = null;
        public static final PullDownType NONE = null;
        public static final PullDownType REFRESH = null;
        public static final /* synthetic */ PullDownType[] a = null;

        public static PullDownType valueOf(String r1) {
            return (PullDownType) r27.a.a(PullDownType.class, r1);
        }

        public static PullDownType[] values() {
            return (PullDownType[]) a.clone();
        }

        static {
            PullDownType r0 = new PullDownType("NONE", 0);
            NONE = r0;
            PullDownType r1 = new PullDownType("REFRESH", 1);
            REFRESH = r1;
            PullDownType r3 = new PullDownType("LOAD_FORWARD", 2);
            LOAD_FORWARD = r3;
            a = new PullDownType[]{r0, r1, r3};
        }

        public PullDownType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ListState.State.values().length];
            r0[ListState.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L66:
            r0[ListState.State.REQUEST_LAUNCH_CONFIG_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L78:
            r0[ListState.State.REQUEST_LAUNCH_CONFIG_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L50:
            r0[ListState.State.INITIAL_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L52:
            r0[ListState.State.REFRESH_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L62:
            r0[ListState.State.INITIAL_FAIL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L72:
            r0[ListState.State.REFRESH_FAIL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L58:
            r0[ListState.State.START_LOAD_MORE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L68:
            r0[ListState.State.LOAD_MORE_SUCCESS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L70:
            r0[ListState.State.LOAD_MORE_FAIL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
        L46:
            r0[ListState.State.START_LOAD_FORWARD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L36
        L64:
            r0[ListState.State.LOAD_FORWARD_SUCCESS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L37
        L76:
            r0[ListState.State.LOAD_FORWARD_FAIL.ordinal()] = 13;     // Catch: NoSuchFieldError -> L38
        L44:
            r0[ListState.State.DISLIKE_CURRENT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L39
        L54:
            r0[ListState.State.DISCARD_AFTER_CURRENT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L40
        L20:
            a = r0;
            int[] r1 = new int[PullDownType.values().length];
            r1[PullDownType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L48:
            r1[PullDownType.LOAD_FORWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L56:
            r1[PullDownType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L24:
            b = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void S90() {
        ((LinkedHashMap) this.u).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void ba0(Bundle r1) {
    }

    public abstract g<Model> ga0(ViewGroup r1, int r2);

    public abstract boolean ha0(Model r1, g<Model> r2);

    public abstract int ia0(int r1, Model r2);

    public void ja0(int r1, Model r2) {
    }

    public void ka0(int r1, Model r2) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.g
    public final void onLoadMore() {
        AoLogger.g("AosPagerListFragment", new Object[]{"onStartLoadMore"});
        this.t = SystemClock.elapsedRealtime();
        W90().startLoadMore(false);
    }

    public int ra0() {
        return 0;
    }

    public void sa0() {
    }

    public void ta0(List<Model> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public void ua0() {
    }

    public void va0(List<Model> r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public void wa0(boolean r1) {
    }

    public void xa0(List<Model> r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public AosPagerListFragment() {
        this.u = new LinkedHashMap();
        this.q = PullDownType.REFRESH;
    }

    private final void qa0() {
        FrameLayout r0 = this.l;
        DoubleColorBallAnimationView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r0 = null;
    L5:
        x54.b.a(r0);
        DoubleColorBallAnimationView r2 = this.m;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
        r2 = null;
    L9:
        if (r2.k == false) goto L16;
        DoubleColorBallAnimationView r3 = this.m;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L14:
        r1.d();
        return;
    L13:
        r1 = r3;
        goto L14
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final boolean ca0() {
        int r0 = w04.a.a;
        return w04.a.b(getActivity());
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void initView() {
        f54.a r0 = AosExtConfig.b.J0();
        this.p = r0;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        DmtStatusView r1 = (DmtStatusView) findViewById(2131387318);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.h = r1;
        DmtStatusView.a r2 = DmtStatusView.a.a(getContext());
        AosDefaultNetErrorView r3 = U90(oa0());
        r3.findViewById(2131384465).setOnClickListener(new h(this));
        r2.d(r3);
        AosNoMoreFeedErrorView r4 = new AosNoMoreFeedErrorView(oa0().getContext());
        r2.e = r4;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        oa0().setBuilder(r2);
        oa0().c();
        r3.b();
        this.l = (FrameLayout) findViewById(2131375296);
        this.m = (DoubleColorBallAnimationView) findViewById(2131375295);
        VerticalViewPager r5 = (VerticalViewPager) findViewById(2131372236);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.k = r5;
        pa0().setOffscreenPageLimit(1);
        pa0().c(new AosPagerListFragment$initViewPager$1(this));
        AosPagerListFragment<Model, VM>.AosFeedItemAdapter r6 = new AosFeedItemAdapter(this);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.n = r6;
        pa0().setAdapter(la0());
        FrameLayout r7 = (FrameLayout) findViewById(2131372774);
        this.o = new com.bytedance.awemeopen.apps.framework.base.view.refresh.o((DoubleColorBallAnimationView) findViewById(2131379017), (DmtTextView) findViewById(2131391217), r7);
        FeedSwipeRefreshLayout r8 = (FeedSwipeRefreshLayout) findViewById(2131372235);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.i = r8;
        na0().setViewPager(pa0());
        na0().setOnRefreshListener(this);
        PullDownType r9 = ma0();
        this.q = r9;
        int r10 = b.b[r9.ordinal()];
        if (r10 != 1) goto L8;
        na0().setOnSwipeChangeListener(new n(this));
        na0().setEnabled(true);
    L15:
        LoadMoreFrameLayout r11 = (LoadMoreFrameLayout) findViewById(2131372233);
        this.j = r11;
        LoadMoreFrameLayout r12 = null;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
        r11 = null;
    L18:
        VerticalViewPager r13 = pa0();
        FeedSwipeRefreshLayout r14 = na0();
        r11.b = r13;
        r11.c = r14;
        LoadMoreFrameLayout r15 = this.j;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
        r15 = null;
    L21:
        r15.setLabel(AosPagerListViewModel.API_TYPE_FEED);
        LoadMoreFrameLayout r16 = this.j;
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
        r16 = null;
    L24:
        r16.setLoadMoreListener(this);
        LoadMoreFrameLayout r17 = this.j;
        if (r17 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
    L28:
        r12.setOnLoadMoreUiListener(new m(this));
        return;
    L27:
        r12 = r17;
        goto L28
    L8:
        if (r10 != 2) goto L10;
        na0().setEnabled(true);
        goto L15
    L10:
        if (r10 != 3) goto L15;
        na0().setEnabled(false);
        goto L15
    }

    public final AosPagerListFragment<Model, VM>.AosFeedItemAdapter la0() {
        AosPagerListFragment<Model, VM>.AosFeedItemAdapter r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final FeedSwipeRefreshLayout na0() {
        FeedSwipeRefreshLayout r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    }

    public final DmtStatusView oa0() {
        DmtStatusView r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleBallSwipeRefreshLayout.g
    public final void onRefresh() {
        int r0 = b.b[this.q.ordinal()];
        if (r0 != 1) goto L5;
        AoLogger.g("AosPagerListFragment", new Object[]{"onStartRefresh"});
        this.r = SystemClock.elapsedRealtime();
        W90().startRefresh();
        return;
    L5:
        if (r0 != 2) goto L11;
        AoLogger.g("AosPagerListFragment", new Object[]{"onStartLoadForward"});
        this.s = SystemClock.elapsedRealtime();
        W90().loadForward();
        return;
    }

    public final VerticalViewPager pa0() {
        VerticalViewPager r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void Y90() {
        W90().getDataList().observe(this, new i(this));
        W90().getSelectedIndex().observe(getViewLifecycleOwner(), new j(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void Z90() {
        AosPagerListFragment<Model, VM>.AosFeedItemAdapter r0 = la0();
        Iterator<T> r1 = r0.b.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((g) r1.next()).k();
        goto L4
    L6:
        r0.b.clear();
    }

    public PullDownType ma0() {
        return PullDownType.REFRESH;
    }

    private final void ya0(boolean r5) {
        na0().setRefreshing(false);
        if (r5 == false) goto L13;
        qa0();
        ListState r2 = (ListState) W90().getDataList().getValue();
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        DmtStatusView r4 = oa0();
        r4.setVisibility(0);
        r4.setStatus(3);
        goto L13
    L12:
        oa0().d();
        goto L13
    L7:
        if (r2.j != 12100) goto L9;
        r3 = true;
    L13:
        AoLogger.g("AosPagerListFragment", new Object[]{"onRefreshFail"});
        Aa0(r5, false);
        wa0(r5);
    }

    public final void Ba0(int r3) {
        if (pa0().getCurrentItem() == r3) goto L6;
        pa0().y(r3, false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void ea0(AosPagerListFragment r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        if (r6.ra0() <= 0) goto L7;
        if (r7 == false) goto L6;
        r6.Ba0(r6.ra0());
    L8:
        r6.qa0();
        return;
    L6:
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r6.W90(), 0, true, false, 4, null);
        goto L8
    L7:
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r6.W90(), 0, true, false, 4, null);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void fa0(final AosPagerListFragment r17, ListState r18) {
        Intrinsics.checkNotNullParameter(r17, "this$0");
        boolean r6 = false;
        boolean r7 = true;
        DoubleColorBallAnimationView r9 = null;
        LoadMoreFrameLayout r10 = null;
        LoadMoreFrameLayout r11 = null;
        LoadMoreFrameLayout r12 = null;
        LoadMoreFrameLayout r13 = null;
        LoadMoreFrameLayout r14 = null;
        switch(b.a[r18.c.ordinal()]) {
            case 1: goto L141;
            case 2: goto L140;
            case 3: goto L139;
            case 4: goto L86;
            case 5: goto L86;
            case 6: goto L85;
            case 7: goto L84;
            case 8: goto L83;
            case 9: goto L45;
            case 10: goto L37;
            case 11: goto L36;
            case 12: goto L16;
            case 13: goto L12;
            case 14: goto L8;
            case 15: goto L5;
            default: goto L164;
        };
    L5:
        ((AosPagerListViewModel) r17.W90()).removeDataAfterIndex();
        PagerAdapter r0 = r17.pa0().getAdapter();
        if (r0 == null) goto L150;
        r0.notifyDataSetChanged();
        return;
    L150:
        return;
    L8:
        PagerAdapter r1 = r17.pa0().getAdapter();
        if (r1 == null) goto L11;
        r1.notifyDataSetChanged();
    L11:
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r17.W90(), r17.pa0().getCurrentItem(), true, false, 4, null);
        return;
    L12:
        r17.na0().setRefreshing(false);
        AoLogger.g("AosPagerListFragment", new Object[]{"onLoadForwardFail"});
        if (r17.s <= 0) goto L15;
        r17.za0(false, SystemClock.elapsedRealtime() - r17.s, "loadForward");
        r17.s = 0;
    L15:
        r17.sa0();
        return;
    L16:
        r17.na0().setRefreshing(false);
        ListState r2 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r2 != null) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == true) goto L24;
        r17.na0().setEnabled(false);
    L24:
        ((AosPagerListViewModel) r17.W90()).tempData2ListForLoadForward();
        PagerAdapter r4 = r17.pa0().getAdapter();
        if (r4 == null) goto L27;
        r4.notifyDataSetChanged();
    L27:
        AoLogger.g("AosPagerListFragment", new Object[]{"onLoadForwardSuccess"});
        if (r17.s <= 0) goto L30;
        r17.za0(true, SystemClock.elapsedRealtime() - r17.s, "loadForward");
        r17.s = 0;
    L30:
        Object r5 = ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        Intrinsics.checkNotNull(r5);
        List<Model> r8 = (List) ((ListState) r5).a;
        ListState r15 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r15 != null) goto L33;
    L35:
        r17.ta0(r8, r6);
        return;
    L33:
        if (r15.h != true) goto L35;
        r6 = true;
        goto L35
    L19:
        if (r2.h != true) goto L21;
        r3 = true;
        goto L22
    L36:
        ((AosPagerListViewModel) r17.W90()).loadForwardData(((AosPagerListViewModel) r17.W90()).getLoadForwardCallback());
        return;
    L37:
        LoadMoreFrameLayout r16 = r17.j;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
    L41:
        r10.f();
        AoLogger.g("AosPagerListFragment", new Object[]{"onLoadMoreFail"});
        if (r17.t <= 0) goto L44;
        r17.za0(false, SystemClock.elapsedRealtime() - r17.t, "loadMore");
        r17.t = 0;
    L44:
        r17.ua0();
        r17.g = false;
        return;
    L40:
        r10 = r16;
        goto L41
    L45:
        ListState r19 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r19 != null) goto L48;
    L50:
        boolean r20 = false;
    L51:
        if (r20 == false) goto L57;
        LoadMoreFrameLayout r21 = r17.j;
        if (r21 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
    L56:
        r11.f();
    L63:
        if (((AosPagerListViewModel) r17.W90()).dataSize() <= 0) goto L65;
    L67:
        boolean r22 = false;
    L68:
        ((AosPagerListViewModel) r17.W90()).tempData2ListForLoadMore();
        PagerAdapter r23 = r17.pa0().getAdapter();
        if (r23 == null) goto L71;
        r23.notifyDataSetChanged();
    L71:
        if (r22 == false) goto L73;
        AosPagerListViewModel.updateCurrentIndex$default((AosPagerListViewModel) r17.W90(), 0, true, false, 4, null);
    L73:
        AoLogger.g("AosPagerListFragment", new Object[]{"onLoadMoreSuccess"});
        if (r17.t <= 0) goto L76;
        r17.za0(true, SystemClock.elapsedRealtime() - r17.t, "loadMore");
        r17.t = 0;
    L76:
        Object r24 = ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        Intrinsics.checkNotNull(r24);
        List<Model> r25 = (List) ((ListState) r24).a;
        ListState r26 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r26 != null) goto L79;
    L81:
        r7 = false;
    L82:
        r17.va0(r25, r7, r17.g);
        r17.g = false;
        return;
    L79:
        if (r26.g != true) goto L81;
    L65:
        if (((AosPagerListViewModel) r17.W90()).getCurrentIndex() != 0) goto L67;
        r22 = true;
        goto L68
    L55:
        r11 = r21;
        goto L56
    L57:
        LoadMoreFrameLayout r27 = r17.j;
        if (r27 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
    L61:
        r12.g();
        goto L63
    L60:
        r12 = r27;
        goto L61
    L48:
        if (r19.g != true) goto L50;
        r20 = true;
        goto L51
    L83:
        r17.g = false;
        return;
    L84:
        r17.ya0(false);
        return;
    L85:
        r17.ya0(true);
        return;
    L86:
        r17.na0().setRefreshing(false);
        r17.oa0().c();
        ((AosPagerListViewModel) r17.W90()).tempData2ListForRefresh();
        PagerAdapter r28 = r17.pa0().getAdapter();
        if (r28 == null) goto L90;
        r28.notifyDataSetChanged();
    L90:
        if (((AosPagerListViewModel) r17.W90()).getCurrentState() != ListState.State.INITIAL_SUCCESS) goto L92;
        final boolean r29 = true;
    L93:
        Object r30 = ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        Intrinsics.checkNotNull(r30);
        if (((ListState) r30).c != ListState.State.REFRESH_SUCCESS) goto L96;
        boolean r31 = !(r17 instanceof MixAwemeFeedFragment);
    L97:
        if (r31 == false) goto L99;
        r17.pa0().post(new l(r17, r29));
    L101:
        if (r17.q != PullDownType.LOAD_FORWARD) goto L110;
        ListState r32 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r32 != null) goto L105;
    L107:
        boolean r33 = false;
    L108:
        if (r33 == true) goto L110;
        r17.na0().setEnabled(false);
        goto L110
    L105:
        if (r32.h != true) goto L107;
        r33 = true;
    L110:
        ListState r34 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r34 != null) goto L113;
    L115:
        boolean r35 = false;
    L116:
        if (r35 == false) goto L122;
        LoadMoreFrameLayout r36 = r17.j;
        if (r36 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
    L121:
        r13.f();
    L127:
        AoLogger.g("AosPagerListFragment", new Object[]{"onRefreshSuccess"});
        r17.Aa0(r29, true);
        Object r37 = ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        Intrinsics.checkNotNull(r37);
        List<Model> r38 = (List) ((ListState) r37).a;
        ListState r39 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r39 != null) goto L130;
    L132:
        boolean r40 = false;
    L133:
        ListState r41 = (ListState) ((AosPagerListViewModel) r17.W90()).getDataList().getValue();
        if (r41 != null) goto L136;
    L138:
        r17.xa0(r38, r40, r6);
        return;
    L136:
        if (r41.g != true) goto L138;
        r6 = true;
        goto L138
    L130:
        if (r39.h != true) goto L132;
        r40 = true;
        goto L133
    L120:
        r13 = r36;
        goto L121
    L122:
        LoadMoreFrameLayout r42 = r17.j;
        if (r42 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreLayout");
    L126:
        r14.g();
        goto L127
    L125:
        r14 = r42;
        goto L126
    L113:
        if (r34.g != true) goto L115;
        r35 = true;
        goto L116
    L99:
        r17.qa0();
        goto L101
    L96:
        r31 = true;
        goto L97
    L92:
        r29 = false;
        goto L93
    L139:
        r17.ya0(true);
        return;
    L140:
        r17.getClass();
        return;
    L141:
        r17.oa0().c();
        FrameLayout r43 = r17.l;
        if (r43 != null) goto L144;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingFl");
        r43 = null;
    L144:
        x54.b.d(r43);
        DoubleColorBallAnimationView r44 = r17.m;
        if (r44 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("initLoadingDoubleBall");
    L148:
        r9.c();
        r17.pa0().post(new k(r17));
        return;
    L147:
        r9 = r44;
        goto L148
    }

    public final void Aa0(boolean r7, boolean r8) {
        if (r7 == false) goto L5;
        return;
    L5:
        if (this.r <= 0) goto L8;
        za0(r8, SystemClock.elapsedRealtime() - this.r, "pullRefresh");
        this.r = 0;
        return;
    }

    public final void za0(boolean r9, long r10, String r12) {
        AoLogger.g("AosPagerListFragment", new Object[]{"reportManualLoadingResult isSuccess:" + r9 + " duration:" + r10 + " loadingType:" + r12});
        AosEventReporter r1 = AosEventReporter.a;
        int r4 = !r9 ? 1 : 0;
        String r5 = W90().sceneId();
        r1.getClass();
        AosEventReporter.x(r10, r4, r5, r12, "");
    }
}
