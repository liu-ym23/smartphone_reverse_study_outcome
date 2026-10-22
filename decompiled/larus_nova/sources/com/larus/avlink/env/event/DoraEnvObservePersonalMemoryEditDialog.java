package com.larus.avlink.env.event;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.impl.databinding.LarusDialogPersonalMemoryEditBinding;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDialogPersonalMemoryEditBinding;", "maxCharCount", "", "viewModel", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryViewModel;", "getViewModel", "()Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "clientReqId", "", "isSaveSuccess", "", "editEntryId", "", "Ljava/lang/Long;", "initialContent", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupDialogBehavior", "setupViews", "updateSaveButtonState", "s", "Landroid/text/Editable;", "updateCounter", "length", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraEnvObservePersonalMemoryEditDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f292212k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogPersonalMemoryEditBinding f292213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f292214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f292215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f292216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f292217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f292218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f292219j;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f292220a;

        public b(r r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f292220a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f292220a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f292220a.invoke(r100);
        }
    }

    static {
    }

    public final DoraEnvObservePersonalMemoryViewModel T90() {
        return (DoraEnvObservePersonalMemoryViewModel) this.f292215f.getValue();
    }

    public DoraEnvObservePersonalMemoryEditDialog() {
        this.f292214e = 100;
        this.f292215f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObservePersonalMemoryViewModel.class), new DoraEnvObservePersonalMemoryEditDialog$special$$inlined$activityViewModels$default$1(this), new DoraEnvObservePersonalMemoryEditDialog$special$$inlined$activityViewModels$default$2(this));
        this.f292216g = UUID.randomUUID().toString();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f292213d = null;
    }

    public final void S90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        if (this.f292217h == false) goto L5;
        return;
    L5:
        if (this.f292218i != null) goto L20;
        LarusDialogPersonalMemoryEditBinding r101 = this.f292213d;
        if (r101 == null) goto L16;
        EditText r102 = r101.f293189b;
        if (r102 == null) goto L16;
        Editable r103 = r102.getText();
        if (r103 == null) goto L16;
        String r104 = r103.toString();
        if (r104 == null) goto L16;
        String r105 = StringsKt.trim(r104).toString();
        if (r105 == null) goto L16;
    L17:
        String r106 = o98.d.f522486a;
        Intrinsics.checkNotNullParameter(r105, "text");
        o98.d.f522486a = r105;
        return;
    L16:
        r105 = "";
        goto L17
    }

    public final void U90(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        LarusDialogPersonalMemoryEditBinding r102 = this.f292213d;
        if (r102 == null) goto L11;
        TextView r103 = r102.f293191d;
        if (r103 == null) goto L11;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        r104.append('/');
        r104.append(this.f292214e);
        r103.setText(r104.toString());
    L11:
        if (r100 < this.f292214e) goto L17;
        LarusDialogPersonalMemoryEditBinding r105 = this.f292213d;
        if (r105 == null) goto L23;
        TextView r106 = r105.f293191d;
        if (r106 == null) goto L24;
        r106.setTextColor(ContextCompat.getColor(r101, v19.c.b(R.color.larus_conditional_danger_50, r101, R.color.larus_conditional_danger_50)));
        return;
    L24:
        return;
    L23:
        return;
    L17:
        LarusDialogPersonalMemoryEditBinding r107 = this.f292213d;
        if (r107 == null) goto L26;
        TextView r108 = r107.f293191d;
        if (r108 == null) goto L27;
        r108.setTextColor(ContextCompat.getColor(r101, v19.c.b(R.color.larus_neutral_50, r101, R.color.larus_neutral_50)));
        return;
    L27:
        return;
    }

    public final void V90(Editable r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (r100 == null) goto L12;
        String r103 = r100.toString();
        if (r103 == null) goto L12;
        if ((!StringsKt.isBlank(r103)) != true) goto L12;
        r102 = true;
    L12:
        if (r102 == false) goto L18;
        LarusDialogPersonalMemoryEditBinding r104 = this.f292213d;
        if (r104 == null) goto L24;
        TextView r105 = r104.f293192e;
        if (r105 == null) goto L25;
        r105.setTextColor(ContextCompat.getColor(r101, v19.c.b(R.color.larus_primary_50, r101, R.color.larus_primary_50)));
        return;
    L25:
        return;
    L24:
        return;
    L18:
        LarusDialogPersonalMemoryEditBinding r106 = this.f292213d;
        if (r106 == null) goto L27;
        TextView r107 = r106.f293192e;
        if (r107 == null) goto L28;
        r107.setTextColor(ContextCompat.getColor(r101, v19.c.b(R.color.larus_primary_50_05_alpha, r101, R.color.larus_primary_50_05_alpha)));
        return;
    L28:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 != null) goto L5;
    L7:
        Long r103 = null;
    L8:
        this.f292218i = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L11;
        r102 = r104.getString("arg_content");
    L11:
        this.f292219j = r102;
        return;
    L5:
        if (r101.containsKey("arg_entry_id") == false) goto L7;
        r103 = Long.valueOf(r101.getLong("arg_entry_id"));
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        S90(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.avlink.env.event.r] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Object r102 = r100.getParent();
        Editable r103 = null;
        if ((r102 instanceof View) == false) goto L5;
        View r104 = (View) r102;
    L6:
        int r105 = 0;
        if (r104 == null) goto L9;
        r104.setBackgroundColor(0);
    L9:
        Dialog r106 = getDialog();
        if (r106 == null) goto L12;
        r106.setOnShowListener(new s(this));
    L12:
        LarusDialogPersonalMemoryEditBinding r107 = this.f292213d;
        if (r107 == null) goto L17;
        TextView r108 = r107.f293190c;
        if (r108 == null) goto L17;
        int r109 = com.larus.utils.j0.f375426a;
        r108.setText(com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_cancel_cn));
    L17:
        LarusDialogPersonalMemoryEditBinding r110 = this.f292213d;
        if (r110 == null) goto L22;
        TextView r111 = r110.f293192e;
        if (r111 == null) goto L22;
        int r112 = com.larus.utils.j0.f375426a;
        r111.setText(com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_save_cn));
    L22:
        LarusDialogPersonalMemoryEditBinding r113 = this.f292213d;
        if (r113 == null) goto L27;
        EditText r114 = r113.f293189b;
        if (r114 == null) goto L27;
        int r115 = com.larus.utils.j0.f375426a;
        r114.setHint(com.larus.utils.j0.d(R.string.larus_dora_environmental_data_personal_add_guide_cn));
    L27:
        LarusDialogPersonalMemoryEditBinding r116 = this.f292213d;
        if (r116 == null) goto L32;
        TextView r117 = r116.f293190c;
        if (r117 == null) goto L32;
        r117.setOnClickListener(new p(this));
    L32:
        LarusDialogPersonalMemoryEditBinding r118 = this.f292213d;
        if (r118 == null) goto L37;
        TextView r119 = r118.f293192e;
        if (r119 == null) goto L37;
        r119.setOnClickListener(new q(this));
    L37:
        T90().getSaveSuccess().observe(getViewLifecycleOwner(), new b(new r(this)));
        String r120 = o98.d.f522486a;
        if (r120.length() <= 0) goto L40;
        boolean r121 = true;
    L41:
        if (r121 == true) goto L43;
    L54:
        String r122 = this.f292219j;
        if (r122 == null) goto L70;
        LarusDialogPersonalMemoryEditBinding r123 = this.f292213d;
        if (r123 == null) goto L61;
        EditText r124 = r123.f293189b;
        if (r124 == null) goto L61;
        r124.setText(r122);
    L61:
        LarusDialogPersonalMemoryEditBinding r125 = this.f292213d;
        if (r125 == null) goto L70;
        EditText r126 = r125.f293189b;
        if (r126 == null) goto L70;
        String r127 = this.f292219j;
        if (r127 == null) goto L68;
        int r128 = r127.length();
    L69:
        r126.setSelection(r128);
        goto L70
    L68:
        r128 = 0;
    L70:
        LarusDialogPersonalMemoryEditBinding r129 = this.f292213d;
        if (r129 == null) goto L77;
        EditText r130 = r129.f293189b;
        if (r130 == null) goto L77;
        Editable r131 = r130.getText();
        if (r131 == null) goto L77;
        r105 = r131.length();
    L77:
        U90(r105);
        LarusDialogPersonalMemoryEditBinding r132 = this.f292213d;
        if (r132 == null) goto L82;
        EditText r133 = r132.f293189b;
        if (r133 == null) goto L82;
        r103 = r133.getText();
    L82:
        V90(r103);
        LarusDialogPersonalMemoryEditBinding r134 = this.f292213d;
        if (r134 == null) goto L88;
        EditText r135 = r134.f293189b;
        if (r135 == null) goto L89;
        r135.addTextChangedListener(new u(this));
        return;
    L89:
        return;
    L88:
        return;
    L43:
        if (this.f292218i != null) goto L54;
        LarusDialogPersonalMemoryEditBinding r136 = this.f292213d;
        if (r136 == null) goto L49;
        EditText r137 = r136.f293189b;
        if (r137 == null) goto L49;
        r137.setText(r120);
    L49:
        LarusDialogPersonalMemoryEditBinding r138 = this.f292213d;
        if (r138 == null) goto L70;
        EditText r139 = r138.f293189b;
        if (r139 == null) goto L70;
        r139.setSelection(r120.length());
        goto L70
    L40:
        r121 = false;
        goto L41
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dialog_personal_memory_edit, r101, false);
        int r104 = R.id.et_input;
        EditText r105 = (EditText) ViewBindings.findChildViewById(r103, R.id.et_input);
        if (r105 == null) goto L15;
        r104 = R.id.tv_cancel;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.tv_cancel);
        if (r106 == null) goto L15;
        r104 = R.id.tv_counter;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r103, R.id.tv_counter);
        if (r107 == null) goto L15;
        r104 = R.id.tv_save;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r103, R.id.tv_save);
        if (r108 == null) goto L15;
        r104 = R.id.tv_title;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.tv_title)) == null) goto L15;
        ConstraintLayout r109 = (ConstraintLayout) r103;
        this.f292213d = new LarusDialogPersonalMemoryEditBinding(r109, r105, r106, r107, r108);
        return r109;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
