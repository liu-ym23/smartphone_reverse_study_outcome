package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.utils.x1;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u0017\u0010&\u001a\u00020\u00102\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/AddRuleInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleInputBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraFragmentAddRuleInputBinding;", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", com.heytap.mcssdk.constant.b.f276366p, "Lcom/larus/dora/api/entity/NotificationRule;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "observeViewModel", "initUI", "updateCharCount", "length", "", "updateBtnState", "text", "", "saveEditedRule", "newName", "resetErrorState", "showErrorState", "errorResId", "(Ljava/lang/Integer;)V", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddRuleInputFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f336295h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDoraFragmentAddRuleInputBinding f336296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CustomBroadcastRulesViewModel f336297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x1 f336298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NotificationRule f336299g;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        x1 r100 = this.f336298f;
        if (r100 == null) goto L5;
        r100.a(true);
    L5:
        this.f336296d = null;
    }

    public AddRuleInputFragment() {
    }

    public final void S90(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        LarusDoraFragmentAddRuleInputBinding r102 = this.f336296d;
        if (r102 == null) goto L11;
        LinearLayoutCompat r103 = r102.f332555f;
        if (r103 == null) goto L11;
        r103.setEnabled(!r101);
    L11:
        LarusDoraFragmentAddRuleInputBinding r104 = this.f336296d;
        if (r104 == null) goto L20;
        LinearLayoutCompat r105 = r104.f332555f;
        if (r105 == null) goto L21;
        if (r101 == false) goto L17;
        float r106 = 0.3f;
    L18:
        r105.setAlpha(r106);
        return;
    L17:
        r106 = 1.0f;
        goto L18
    L21:
        return;
    L20:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void T90(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        LarusDoraFragmentAddRuleInputBinding r102 = this.f336296d;
        if (r102 == null) goto L11;
        TextView r103 = r102.f332552c;
        if (r103 == null) goto L11;
        r103.setText(r100 + "/100");
    L11:
        if (r100 < 100) goto L17;
        SpannableString r104 = new SpannableString(r100 + "/100");
        r104.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r101, R.color.larus_danger_50)), 0, String.valueOf(r100).length(), 33);
        LarusDoraFragmentAddRuleInputBinding r105 = this.f336296d;
        if (r105 == null) goto L23;
        TextView r106 = r105.f332552c;
        if (r106 == null) goto L24;
        r106.setText(r104);
        return;
    L24:
        return;
    L23:
        return;
    L17:
        LarusDoraFragmentAddRuleInputBinding r107 = this.f336296d;
        if (r107 == null) goto L26;
        TextView r108 = r107.f332552c;
        if (r108 == null) goto L27;
        r108.setTextColor(ContextCompat.getColor(r101, v19.c.b(R.attr.larus_neutral_30, r101, R.color.larus_neutral_30)));
        return;
    L27:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        NotificationRule r102 = null;
        if (r101 == null) goto L5;
        Serializable r103 = r101.getSerializable("arg_rule");
    L7:
        if ((r103 instanceof NotificationRule) == false) goto L9;
        r102 = (NotificationRule) r103;
    L9:
        this.f336299g = r102;
        return;
    L5:
        r103 = null;
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
        this.f336297e = (CustomBroadcastRulesViewModel) new ViewModelProvider(r112).get(CustomBroadcastRulesViewModel.class);
        LarusDoraFragmentAddRuleInputBinding r113 = this.f336296d;
        if (r113 == null) goto L10;
        AppCompatEditText r114 = r113.f332558i;
        if (r114 == null) goto L10;
        this.f336298f = new x1(r114);
    L10:
        int r115 = 0;
        if (this.f336299g == null) goto L13;
        final boolean r116 = true;
    L14:
        String r100 = "";
        if (r116 == false) goto L67;
        if (getContext() == null) goto L28;
        LarusDoraFragmentAddRuleInputBinding r101 = this.f336296d;
        if (r101 == null) goto L23;
        TextView r102 = r101.f332560k;
        if (r102 == null) goto L23;
        r102.setText(getString(R.string.larus_dora_broadcast_title_edit_custom_rule_cn));
    L23:
        LarusDoraFragmentAddRuleInputBinding r103 = this.f336296d;
        if (r103 == null) goto L28;
        DoraTextView r104 = r103.f332554e;
        if (r104 == null) goto L28;
        r104.setText(getString(R.string.larus_dora_broadcast_finish_cn));
    L28:
        LarusDoraFragmentAddRuleInputBinding r105 = this.f336296d;
        if (r105 == null) goto L33;
        TextView r106 = r105.f332559j;
        if (r106 == null) goto L33;
        r106.setVisibility(8);
    L33:
        LarusDoraFragmentAddRuleInputBinding r107 = this.f336296d;
        if (r107 == null) goto L43;
        AppCompatEditText r108 = r107.f332558i;
        if (r108 == null) goto L43;
        NotificationRule r109 = this.f336299g;
        if (r109 == null) goto L41;
        String r117 = r109.getRuleDesc();
        if (r117 == null) goto L41;
    L42:
        r108.setText(r117);
    L41:
        r117 = "";
    L43:
        LarusDoraFragmentAddRuleInputBinding r118 = this.f336296d;
        if (r118 == null) goto L54;
        AppCompatEditText r119 = r118.f332558i;
        if (r119 == null) goto L54;
        NotificationRule r120 = this.f336299g;
        if (r120 == null) goto L52;
        String r121 = r120.getRuleDesc();
        if (r121 == null) goto L52;
        int r122 = r121.length();
    L53:
        r119.setSelection(r122);
    L52:
        r122 = 0;
    L54:
        NotificationRule r123 = this.f336299g;
        if (r123 == null) goto L59;
        String r124 = r123.getRuleDesc();
        if (r124 == null) goto L59;
        r115 = r124.length();
    L59:
        T90(r115);
        NotificationRule r125 = this.f336299g;
        if (r125 == null) goto L65;
        String r126 = r125.getRuleDesc();
        if (r126 == null) goto L65;
        r100 = r126;
    L65:
        S90(r100);
    L84:
        LarusDoraFragmentAddRuleInputBinding r127 = this.f336296d;
        if (r127 == null) goto L89;
        AppCompatEditText r128 = r127.f332558i;
        if (r128 == null) goto L89;
        r128.addTextChangedListener(new h(this));
    L89:
        LarusDoraFragmentAddRuleInputBinding r129 = this.f336296d;
        if (r129 == null) goto L94;
        DoraTextView r130 = r129.f332551b;
        if (r130 == null) goto L94;
        e1.d(r130, new f(this));
    L94:
        LarusDoraFragmentAddRuleInputBinding r131 = this.f336296d;
        if (r131 == null) goto L99;
        LinearLayoutCompat r132 = r131.f332555f;
        if (r132 == null) goto L99;
        e1.d(r132, new g(this, r116));
    L99:
        Lifecycle.State r133 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r133, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r133, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r133, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r133, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AddRuleInputFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r133, null, this), 3, null);
        return;
    L67:
        if (getContext() == null) goto L78;
        LarusDoraFragmentAddRuleInputBinding r134 = this.f336296d;
        if (r134 == null) goto L73;
        TextView r135 = r134.f332560k;
        if (r135 == null) goto L73;
        r135.setText(getString(R.string.larus_dora_broadcast_btn_add_custom_rule_cn));
    L73:
        LarusDoraFragmentAddRuleInputBinding r136 = this.f336296d;
        if (r136 == null) goto L78;
        DoraTextView r137 = r136.f332554e;
        if (r137 == null) goto L78;
        r137.setText(getString(R.string.larus_dora_broadcast_half_dialog_add_custom_rule_btn_generate_cn));
    L78:
        LarusDoraFragmentAddRuleInputBinding r138 = this.f336296d;
        if (r138 == null) goto L83;
        TextView r139 = r138.f332559j;
        if (r139 == null) goto L83;
        r139.setVisibility(0);
    L83:
        S90("");
        goto L84
    L13:
        r116 = false;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dora_fragment_add_rule_input, r111, false);
        int r114 = R.id.btn_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.btn_container)) == null) goto L29;
        r114 = R.id.cancel_btn;
        DoraTextView r100 = (DoraTextView) ViewBindings.findChildViewById(r113, R.id.cancel_btn);
        if (r100 == null) goto L29;
        r114 = R.id.char_count;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.char_count);
        if (r101 == null) goto L29;
        r114 = R.id.error_tips;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r113, R.id.error_tips);
        if (r102 == null) goto L29;
        r114 = R.id.generate_btn;
        DoraTextView r103 = (DoraTextView) ViewBindings.findChildViewById(r113, R.id.generate_btn);
        if (r103 == null) goto L29;
        r114 = R.id.generate_btn_ll;
        LinearLayoutCompat r104 = (LinearLayoutCompat) ViewBindings.findChildViewById(r113, R.id.generate_btn_ll);
        if (r104 == null) goto L29;
        r114 = R.id.generate_btn_pb;
        ProgressBar r105 = (ProgressBar) ViewBindings.findChildViewById(r113, R.id.generate_btn_pb);
        if (r105 == null) goto L29;
        r114 = R.id.input_container;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.input_container);
        if (r106 == null) goto L29;
        r114 = R.id.input_outer_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.input_outer_container)) == null) goto L29;
        r114 = R.id.rule_input;
        AppCompatEditText r107 = (AppCompatEditText) ViewBindings.findChildViewById(r113, R.id.rule_input);
        if (r107 == null) goto L29;
        r114 = R.id.sub_title;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r113, R.id.sub_title);
        if (r115 == null) goto L29;
        r114 = R.id.title;
        TextView r116 = (TextView) ViewBindings.findChildViewById(r113, R.id.title);
        if (r116 == null) goto L29;
        ConstraintLayout r117 = (ConstraintLayout) r113;
        this.f336296d = new LarusDoraFragmentAddRuleInputBinding(r117, r100, r101, r102, r103, r104, r105, r106, r107, r115, r116);
        return r117;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
