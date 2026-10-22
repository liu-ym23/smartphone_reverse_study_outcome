package com.larus.dora.o.impl.memory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.gson.Gson;
import com.larus.common_ui.refresh.RefreshHeaderLayout;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.dora.o.impl.databinding.DoraOFragmentMemoryEventBinding;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryEventFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOFragmentMemoryEventBinding;", "viewModel", "Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel;", "getViewModel", "()Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/o/impl/memory/OMemoryEventAdapter;", "deletePopover", "Lcom/obric/oui/popover/v2/OPopover;", "detailLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "gson", "Lcom/google/gson/Gson;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupList", "setupRefresh", "observeViewModel", "renderState", "state", "Lcom/larus/dora/o/impl/memory/OMemoryEventViewModel$ListState;", "openDetail", "event", "Lcom/larus/dora/o/impl/memory/OMemoryEvent;", "showDeleteMenu", "anchor", "confirmDelete", "onDestroyView", "autoLogEnterPage", "", "getCurrentPageName", "", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryEventFragment extends TraceFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f338747k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DoraOFragmentMemoryEventBinding f338748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f338749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OMemoryEventAdapter f338750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.obric.oui.popover.v2.c f338751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f338752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Gson f338753j;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_g_event_list";
    }

    public final OMemoryEventViewModel U90() {
        return (OMemoryEventViewModel) this.f338749f.getValue();
    }

    public OMemoryEventFragment() {
        final Function0<Fragment> r100 = new OMemoryEventFragment$special$$inlined$viewModels$default$1(this);
        this.f338749f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OMemoryEventViewModel.class), new OMemoryEventFragment$special$$inlined$viewModels$default$2(r100), new OMemoryEventFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f338753j = new Gson();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        com.obric.oui.popover.v2.c r100 = this.f338751h;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f338751h = null;
        this.f338750g = null;
        this.f338748e = null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f338752i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new v(this));
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.o.impl.memory.s] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.dora.o.impl.memory.t] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        DoraOFragmentMemoryEventBinding r112 = this.f338748e;
        if (r112 == null) goto L6;
        this.f338750g = new OMemoryEventAdapter(new s(this), new t(this));
        U90().setTodayGroupTitle(getString(R.string.larus_dora_g_record_minutes_list_title2_cn));
        U90().setMonthDayGroupTitleProvider(new u(this));
        r112.f338384c.setLayoutManager(new LinearLayoutManager(getContext()));
        r112.f338384c.setAdapter(this.f338750g);
        r112.f338384c.addOnScrollListener(new OMemoryEventFragment$setupList$4(this));
    L6:
        DoraOFragmentMemoryEventBinding r113 = this.f338748e;
        if (r113 == null) goto L13;
        Context r114 = getContext();
        if (r114 == null) goto L13;
        r113.f338386e.setRefreshHeader(new RefreshHeaderLayout(r114));
        r113.f338386e.setOnRefreshListener(new q(this));
        r113.f338387f.setOnClickListener(new r(this));
    L13:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryEventFragment$observeViewModel$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryEventFragment$observeViewModel$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OMemoryEventFragment$observeViewModel$3(this, null), 3, null);
        U90().refresh();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.dora_o_fragment_memory_event, r101, false);
        int r103 = R.id.memory_event_empty;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.memory_event_empty);
        if (r104 == null) goto L15;
        r103 = R.id.memory_event_list;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r102, R.id.memory_event_list);
        if (r105 == null) goto L15;
        r103 = R.id.memory_event_loading;
        ProgressBar r106 = (ProgressBar) ViewBindings.findChildViewById(r102, R.id.memory_event_loading);
        if (r106 == null) goto L15;
        r103 = R.id.memory_event_refresh;
        SuperSwipeRefreshLayout r107 = (SuperSwipeRefreshLayout) ViewBindings.findChildViewById(r102, R.id.memory_event_refresh);
        if (r107 == null) goto L15;
        r103 = R.id.memory_event_retry;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.memory_event_retry);
        if (r108 == null) goto L15;
        OViewPager2FixLayout r109 = (OViewPager2FixLayout) r102;
        this.f338748e = new DoraOFragmentMemoryEventBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
