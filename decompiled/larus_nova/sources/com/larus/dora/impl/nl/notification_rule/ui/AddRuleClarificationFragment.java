package com.larus.dora.impl.nl.notification_rule.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common_ui.widget.MaxHeightRecyclerView;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleClarificationBinding;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/AddRuleClarificationFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleClarificationBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleClarificationBinding;", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "userInput", "", "clarifiedDesc", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "observeViewModel", "initUI", "onDestroyView", "Companion", "PreviewViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddRuleClarificationFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f336289h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDoraFragmentAddRuleClarificationBinding f336290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CustomBroadcastRulesViewModel f336291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f336292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f336293g;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/AddRuleClarificationFragment$PreviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "name", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreviewViewHolder extends RecyclerView.ViewHolder {
        public PreviewViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    public AddRuleClarificationFragment() {
        this.f336292f = "";
        this.f336293g = CollectionsKt.emptyList();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f336290d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        String r102 = r101.getString("user_input");
        if (r102 == null) goto L6;
    L7:
        this.f336292f = r102;
        Bundle r103 = getArguments();
        if (r103 == null) goto L12;
        List<String> r104 = r103.getStringArrayList("clarified_desc");
        if (r104 == null) goto L12;
    L13:
        this.f336293g = r104;
        return;
    L12:
        r104 = CollectionsKt.emptyList();
    L6:
        r102 = "";
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        FragmentActivity r112 = getActivity();
        if (r112 != null) goto L5;
        return;
    L5:
        this.f336291e = (CustomBroadcastRulesViewModel) new ViewModelProvider(r112).get(CustomBroadcastRulesViewModel.class);
        LarusDoraFragmentAddRuleClarificationBinding r113 = this.f336290d;
        if (r113 == null) goto L11;
        TextView r114 = r113.f332547e;
        if (r114 == null) goto L11;
        r114.setText(this.f336292f);
    L11:
        if (getContext() == null) goto L17;
        LarusDoraFragmentAddRuleClarificationBinding r115 = this.f336290d;
        if (r115 == null) goto L17;
        TextView r116 = r115.f332546d;
        if (r116 == null) goto L17;
        r116.setText(getString(R.string.larus_dora_broadcast_half_dialog_confirm_rule_generated_count_cn, new Object[]{String.valueOf(this.f336293g.size())}));
    L17:
        LarusDoraFragmentAddRuleClarificationBinding r117 = this.f336290d;
        if (r117 == null) goto L22;
        MaxHeightRecyclerView r118 = r117.f332548f;
        if (r118 == null) goto L22;
        r118.setLayoutManager(new LinearLayoutManager(r118.getContext()));
        int r100 = r118.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        int r101 = ((r100 * 2) + r118.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8))) + ((int) (((double) r118.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_sp_15, null, R.dimen.larus_sp_15))) * 1.5d));
        r118.setMaxHeight(r101 * 3);
        r118.setMinimumHeight(r101);
        r118.setAdapter(new AddRuleClarificationFragment$initUI$2$1(this));
    L22:
        LarusDoraFragmentAddRuleClarificationBinding r119 = this.f336290d;
        if (r119 == null) goto L27;
        DoraTextView r120 = r119.f332549g;
        if (r120 == null) goto L27;
        e1.d(r120, new com.larus.dora.impl.nl.notification_rule.ui.a(this));
    L27:
        LarusDoraFragmentAddRuleClarificationBinding r121 = this.f336290d;
        if (r121 == null) goto L32;
        LinearLayoutCompat r122 = r121.f332544b;
        if (r122 == null) goto L32;
        e1.d(r122, new b(this));
    L32:
        Lifecycle.State r123 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r123, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r123, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r123, null, this), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_dora_fragment_add_rule_clarification, r110, false);
        int r112 = R.id.btn_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r101, R.id.btn_container)) == null) goto L27;
        r112 = R.id.confirm_add_btn;
        if (((DoraTextView) ViewBindings.findChildViewById(r101, R.id.confirm_add_btn)) == null) goto L27;
        r112 = R.id.confirm_add_btn_ll;
        LinearLayoutCompat r102 = (LinearLayoutCompat) ViewBindings.findChildViewById(r101, R.id.confirm_add_btn_ll);
        if (r102 == null) goto L27;
        r112 = R.id.confirm_add_btn_pb;
        ProgressBar r103 = (ProgressBar) ViewBindings.findChildViewById(r101, R.id.confirm_add_btn_pb);
        if (r103 == null) goto L27;
        r112 = R.id.generated_count_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.generated_count_text);
        if (r104 == null) goto L27;
        r112 = R.id.original_desc_label;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.original_desc_label)) == null) goto L27;
        r112 = R.id.original_desc_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.original_desc_text);
        if (r105 == null) goto L27;
        r112 = R.id.preview_recycler_view;
        MaxHeightRecyclerView r106 = (MaxHeightRecyclerView) ViewBindings.findChildViewById(r101, R.id.preview_recycler_view);
        if (r106 == null) goto L27;
        r112 = R.id.re_describe_btn;
        DoraTextView r107 = (DoraTextView) ViewBindings.findChildViewById(r101, R.id.re_describe_btn);
        if (r107 == null) goto L27;
        r112 = R.id.sub_title;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.sub_title)) == null) goto L27;
        r112 = R.id.title;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.title)) == null) goto L27;
        ConstraintLayout r108 = (ConstraintLayout) r101;
        this.f336290d = new LarusDoraFragmentAddRuleClarificationBinding(r108, r102, r103, r104, r105, r106, r107);
        return r108;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
