package com.bytedance.awemeopen.apps.framework.framework.recyclerview;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel;
import com.bytedance.awemeopen.apps.framework.profile.AmeDecoration2;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment;", ExifInterface.TAG_MODEL, "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/LoadMoreRecyclerViewAdapter$b;", "<init>", "()V", "AosRecyclerItemAdapter", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosRecyclerListFragment<Model, VM extends AosRecyclerListViewModel<Model>> extends AosBaseFragment<VM> implements LoadMoreRecyclerViewAdapter.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f197006m = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f197007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DmtStatusView f197008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView f197009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> f197010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f197011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<Integer, View> f197012l;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u0000*\u000e\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment$AosRecyclerItemAdapter;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerItemViewHolder;", "VH", "Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/LoadMoreRecyclerViewAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class AosRecyclerItemAdapter<VH extends AosRecyclerItemViewHolder<Model>> extends LoadMoreRecyclerViewAdapter {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final HashSet<VH> f197013l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AosRecyclerListFragment<Model, VM> f197014m;

        @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
        public final int getBasicItemCount() {
            AosRecyclerListFragment<Model, VM> r100 = this.f197014m;
            int r101 = AosRecyclerListFragment.f197006m;
            ListState<List<Model>> r102 = r100.W90().getDataList().getValue();
            Intrinsics.checkNotNull(r102);
            return r102.f196927a.size();
        }

        public AosRecyclerItemAdapter(AosRecyclerListFragment r100) {
            this.f197014m = r100;
            this.f197013l = new HashSet();
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
        @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
        public final int getBasicItemViewType(int r100) {
            if (r100 < 0) goto L7;
            AosRecyclerListFragment<Model, VM> r101 = this.f197014m;
            int r102 = AosRecyclerListFragment.f197006m;
            if (r100 >= r101.W90().dataSize()) goto L9;
            AosRecyclerListFragment<Model, VM> r103 = this.f197014m;
            ListState<List<Model>> r104 = ((AosRecyclerListViewModel) r103.W90()).getDataList().getValue();
            Intrinsics.checkNotNull(r104);
            return r103.fa0(r100, ListProtector.get(r104.f196927a, r100));
        L9:
            return 0;
        L7:
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewRecycled(RecyclerView.ViewHolder r100) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            super.onViewRecycled(r100);
            if ((r100 instanceof AosRecyclerItemViewHolder) == false) goto L5;
            AosRecyclerItemViewHolder r101 = (AosRecyclerItemViewHolder) r100;
        L6:
            if (r101 == null) goto L20;
            AosRecyclerListFragment<Model, VM> r102 = this.f197014m;
            if (this.f197013l.contains(r101) == true) goto L18;
            JSONObject r103 = AoSettings.a("ao_feature_bugfix");
            if (r103 != null) goto L12;
        L14:
            boolean r104 = false;
        L15:
            if (r104 == false) goto L18;
            AoLogger.g(r102.f197007g, new Object[]{"holderSet not contains holder"});
            return;
        L12:
            if (JSONObjectProtectorUtils.getBoolean(r103, "ao_on_view_recycled_fix") != true) goto L14;
            r104 = true;
        L18:
            r101.W3();
            this.f197013l.remove(r101);
            return;
        L20:
            return;
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
        public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type VH of com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment.AosRecyclerItemAdapter");
            AosRecyclerItemViewHolder r102 = (AosRecyclerItemViewHolder) r100;
            AosRecyclerListFragment<Model, VM> r103 = this.f197014m;
            int r104 = AosRecyclerListFragment.f197006m;
            ListState<List<Model>> r105 = r103.W90().getDataList().getValue();
            Intrinsics.checkNotNull(r105);
            Model r106 = (Model) ListProtector.get(r105.f196927a, r101);
            if (r102.f197005b == false) goto L9;
            String r107 = r102.getClass().getSimpleName().concat(" already bind!");
            if (AoEnv.h() == true) goto L8;
            AoNpthService r108 = AoExceptionReporter.f198706a;
            AoExceptionReporter.b(ErrorPriority.f198711p1, "AosRecyclerItemViewHolder", null, r107, 20);
            goto L9
        L8:
            throw new RuntimeException(r107);
        L9:
            r102.f197005b = true;
            r102.f197004a = r106;
            r102.U3(r106, r101);
            this.f197013l.add((VH) r102);
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
        public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return this.f197014m.ea0(r100);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f197015a = null;

        static {
            int[] r100 = new int[ListState.State.values().length];
            r100[ListState.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ListState.State.INITIAL_LOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ListState.State.INITIAL_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ListState.State.INITIAL_FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ListState.State.START_LOAD_MORE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ListState.State.LOAD_MORE_SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ListState.State.LOAD_MORE_FAIL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ListState.State.CLEAR_DATA.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f197015a = r100;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void S90() {
        ((LinkedHashMap) this.f197012l).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return R.layout.aos_fragment_base_recycler_view;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void ba0(Bundle r100) {
    }

    public abstract AosRecyclerItemViewHolder ea0(ViewGroup r100);

    public abstract int fa0(int r100, Model r101);

    public abstract void ga0();

    public void ia0() {
    }

    public void ja0(List r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public void ka0() {
    }

    public void la0(List r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public AosRecyclerListFragment() {
        this.f197012l = new LinkedHashMap();
        this.f197007g = "AosRecyclerListFragment";
        this.f197011k = true;
    }

    public final AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> ha0() {
        AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> r100 = this.f197010j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void Y90() {
        W90().getDataList().observe(this, new h04.a(this));
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void Z90() {
        AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> r100 = ha0();
        Iterator r101 = r100.f197013l.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((AosRecyclerItemViewHolder) r101.next()).W3();
        goto L4
    L6:
        r100.f197013l.clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter.b
    public final void a() {
        ha0().showLoadMoreLoading();
        W90().loadMore();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void initView() {
        DmtStatusView r100 = (DmtStatusView) findViewById(R.id.status_view);
        this.f197008h = r100;
        if (r100 == null) goto L6;
        r100.setClickable(true);
    L6:
        this.f197009i = (RecyclerView) findViewById(R.id.feed_content_recycler_view);
        FragmentActivity r101 = getActivity();
        ga0();
        ga0();
        GridLayoutManager r102 = new GridLayoutManager(r101, 3);
        RecyclerView r103 = this.f197009i;
        if (r103 == null) goto L10;
        r103.setLayoutManager(r102);
    L10:
        RecyclerView r104 = this.f197009i;
        if (r104 == null) goto L13;
        Resources r105 = Resources.getSystem();
        r104.addItemDecoration(new AmeDecoration2(MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())))));
    L13:
        AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> r106 = new AosRecyclerItemAdapter(this);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f197010j = r106;
        ha0().A2();
        ha0().f196986j = this;
        RecyclerView r107 = this.f197009i;
        if (r107 == null) goto L18;
        r107.setAdapter(ha0());
        return;
    }
}
