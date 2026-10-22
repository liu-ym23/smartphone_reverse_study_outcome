package com.bytedance.awemeopen.apps.framework.framework.recyclerview;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment;", "Model", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/framework/AosBaseFragment;", "Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/LoadMoreRecyclerViewAdapter$b;", "<init>", "()V", "AosRecyclerItemAdapter", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosRecyclerListFragment<Model, VM extends AosRecyclerListViewModel<Model>> extends AosBaseFragment<VM> implements LoadMoreRecyclerViewAdapter.b {
    public static final /* synthetic */ int m = 0;
    public final String g;
    public DmtStatusView h;
    public RecyclerView i;
    public AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> j;
    public boolean k;
    public final Map<Integer, View> l;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u0000*\u000e\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment$AosRecyclerItemAdapter;", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerItemViewHolder;", "VH", "Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/LoadMoreRecyclerViewAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public final class AosRecyclerItemAdapter<VH extends AosRecyclerItemViewHolder<Model>> extends LoadMoreRecyclerViewAdapter {
        public final HashSet<VH> l;
        public final /* synthetic */ AosRecyclerListFragment<Model, VM> m;

        @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
        public final int getBasicItemCount() {
            AosRecyclerListFragment<Model, VM> r0 = this.m;
            int r1 = AosRecyclerListFragment.m;
            Object r2 = r0.W90().getDataList().getValue();
            Intrinsics.checkNotNull(r2);
            return ((List) ((ListState) r2).a).size();
        }

        public AosRecyclerItemAdapter(AosRecyclerListFragment r1) {
            this.m = r1;
            this.l = new HashSet();
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
        public final int getBasicItemViewType(int r3) {
            if (r3 < 0) goto L7;
            AosRecyclerListFragment<Model, VM> r0 = this.m;
            int r1 = AosRecyclerListFragment.m;
            if (r3 >= r0.W90().dataSize()) goto L9;
            AosRecyclerListFragment<Model, VM> r2 = this.m;
            Object r4 = ((AosRecyclerListViewModel) r2.W90()).getDataList().getValue();
            Intrinsics.checkNotNull(r4);
            return r2.fa0(r3, ListProtector.get((List) ((ListState) r4).a, r3));
        L9:
            return 0;
        L7:
            return 0;
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r6) {
            Intrinsics.checkNotNullParameter(r6, "holder");
            super.onViewRecycled(r6);
            if ((r6 instanceof AosRecyclerItemViewHolder) == false) goto L5;
            AosRecyclerItemViewHolder r7 = (AosRecyclerItemViewHolder) r6;
        L6:
            if (r7 == null) goto L20;
            AosRecyclerListFragment<Model, VM> r0 = this.m;
            if (this.l.contains(r7) == true) goto L18;
            JSONObject r1 = AoSettings.a("ao_feature_bugfix");
            if (r1 != null) goto L12;
        L14:
            boolean r2 = false;
        L15:
            if (r2 == false) goto L18;
            AoLogger.g(r0.g, new Object[]{"holderSet not contains holder"});
            return;
        L12:
            if (JSONObjectProtectorUtils.getBoolean(r1, "ao_on_view_recycled_fix") != true) goto L14;
            r2 = true;
        L18:
            r7.W3();
            this.l.remove(r7);
            return;
        L20:
            return;
        L5:
            r7 = null;
            goto L6
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
        public final void onBindBasicViewHolder(RecyclerView.ViewHolder r7, int r8) {
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type VH of com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment.AosRecyclerItemAdapter");
            AosRecyclerItemViewHolder r9 = (AosRecyclerItemViewHolder) r7;
            AosRecyclerListFragment<Model, VM> r0 = this.m;
            int r1 = AosRecyclerListFragment.m;
            Object r2 = r0.W90().getDataList().getValue();
            Intrinsics.checkNotNull(r2);
            Model r3 = (Model) ListProtector.get((List) ((ListState) r2).a, r8);
            if (r9.b == false) goto L9;
            String r4 = r9.getClass().getSimpleName().concat(" already bind!");
            if (AoEnv.h() == true) goto L8;
            AoNpthService r5 = AoExceptionReporter.a;
            AoExceptionReporter.b(ErrorPriority.p1, "AosRecyclerItemViewHolder", null, r4, 20);
            goto L9
        L8:
            throw new RuntimeException(r4);
        L9:
            r9.b = true;
            r9.a = r3;
            r9.U3(r3, r8);
            this.l.add((VH) r9);
        }

        @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.RecyclerViewWithFooterAdapter
        public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            return this.m.ea0(r1);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ListState.State.values().length];
            r0[ListState.State.NEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ListState.State.INITIAL_LOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ListState.State.INITIAL_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ListState.State.INITIAL_FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ListState.State.START_LOAD_MORE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ListState.State.LOAD_MORE_SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ListState.State.LOAD_MORE_FAIL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ListState.State.CLEAR_DATA.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void S90() {
        ((LinkedHashMap) this.l).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final int X90() {
        return 2131558645;
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void ba0(Bundle r1) {
    }

    public abstract AosRecyclerItemViewHolder ea0(ViewGroup r1);

    public abstract int fa0(int r1, Model r2);

    public abstract void ga0();

    public void ia0() {
    }

    public void ja0(List r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public void ka0() {
    }

    public void la0(List r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public AosRecyclerListFragment() {
        this.l = new LinkedHashMap();
        this.g = "AosRecyclerListFragment";
        this.k = true;
    }

    public final AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> ha0() {
        AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> r0 = this.j;
        if (r0 == null) goto L5;
        return r0;
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
        AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> r0 = ha0();
        Iterator r1 = r0.l.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((AosRecyclerItemViewHolder) r1.next()).W3();
        goto L4
    L6:
        r0.l.clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter.b
    public final void a() {
        ha0().showLoadMoreLoading();
        W90().loadMore();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public void initView() {
        DmtStatusView r0 = (DmtStatusView) findViewById(2131387318);
        this.h = r0;
        if (r0 == null) goto L6;
        r0.setClickable(true);
    L6:
        this.i = findViewById(2131372234);
        FragmentActivity r2 = getActivity();
        ga0();
        ga0();
        GridLayoutManager r1 = new GridLayoutManager(r2, 3);
        RecyclerView r3 = this.i;
        if (r3 == null) goto L10;
        r3.setLayoutManager(r1);
    L10:
        RecyclerView r4 = this.i;
        if (r4 == null) goto L13;
        Resources r5 = Resources.getSystem();
        r4.addItemDecoration(new AmeDecoration2(MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())))));
    L13:
        AosRecyclerListFragment<Model, VM>.AosRecyclerItemAdapter<AosRecyclerItemViewHolder<Model>> r6 = new AosRecyclerItemAdapter(this);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.j = r6;
        ha0().A2();
        ha0().j = this;
        RecyclerView r7 = this.i;
        if (r7 == null) goto L18;
        r7.setAdapter(ha0());
        return;
    }
}
