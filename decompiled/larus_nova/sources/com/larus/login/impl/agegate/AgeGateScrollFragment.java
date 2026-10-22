package com.larus.login.impl.agegate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common_ui.widget.RectangleButton;
import com.larus.common_ui.widget.datepicker.DatePicker;
import com.larus.common_ui.widget.datepicker.NumberPicker;
import com.larus.login.impl.databinding.LarusFragmentAgeGateScrollBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.j5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000b¨\u0006'"}, d2 = {"Lcom/larus/login/impl/agegate/AgeGateScrollFragment;", "Lcom/larus/login/impl/agegate/BaseNeutralAgeGateFragment;", "<init>", "()V", "binding", "Lcom/larus/login/impl/databinding/LarusFragmentAgeGateScrollBinding;", "onlyYearMode", "", "ageVerificationType", "", "getAgeVerificationType", "()Ljava/lang/String;", "ageVerificationType$delegate", "Lkotlin/Lazy;", "pageHierarchy", "getPageHierarchy", "pageHierarchy$delegate", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "mobAgeGatePageShowInternal", "goAgeGateInputPage", "initButton", "initDatePicker", "backWithMode", "computeAge", "", "remindErrorInput", "onBackPressed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgeGateScrollFragment extends BaseNeutralAgeGateFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f357303l = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LarusFragmentAgeGateScrollBinding f357304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f357305i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f357306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f357307k;

    public static final class a {
    }

    static {
    }

    public final void Y90() {
        if (this.f357305i == false) goto L5;
        S90();
        return;
    L5:
        Bundle r100 = getArguments();
        if (r100 != null) goto L8;
        r100 = new Bundle();
    L8:
        Bundle r101 = new Bundle(r100);
        if (this.f357305i == true) goto L13;
        Bundle r102 = getArguments();
        if (r102 == null) goto L13;
        r101.putInt("input_pass_age", r102.getInt("input_pass_age"));
    L13:
        AgeGateInputFragment r103 = new AgeGateInputFragment();
        r103.setArguments(r101);
        FragmentTransaction r104 = getParentFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r104, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.fragment_container) == true) goto L17;
        r104 = r104.replace(R.id.fragment_container, r103);
    L17:
        r104.commitAllowingStateLoss();
    }

    @Override // com.larus.login.impl.agegate.BaseNeutralAgeGateFragment
    public final void onBackPressed() {
        BaseNeutralAgeGateFragment.T90("back", (String) this.f357306j.getValue(), (String) this.f357307k.getValue());
        Y90();
    }

    public AgeGateScrollFragment() {
        this.f357306j = LazyKt.lazy(new x(this));
        this.f357307k = LazyKt.lazy(new y(this));
    }

    @Override // com.larus.login.impl.agegate.BaseNeutralAgeGateFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        boolean r102 = r101.getBoolean("scroll_date_only_year");
    L6:
        this.f357305i = r102;
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larus.login.impl.agegate.BaseNeutralAgeGateFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (this.f357305i == false) goto L5;
        BaseNeutralAgeGateFragment.U90((String) this.f357306j.getValue(), (String) this.f357307k.getValue());
    L6:
        DatePicker r102 = null;
        if (this.f357305i == true) goto L19;
        LarusFragmentAgeGateScrollBinding r103 = this.f357304h;
        if (r103 == null) goto L30;
        TextView r104 = r103.f357530f;
        Context r105 = getContext();
        if (r105 == null) goto L13;
        String r106 = r105.getString(R.string.larus_age_gate_question);
    L14:
        r104.setText(r106);
        TextView r107 = r103.f357529e;
        Context r108 = getContext();
        if (r108 == null) goto L17;
        String r109 = r108.getString(R.string.larus_age_gate_toast);
    L18:
        r107.setText(r109);
        goto L30
    L17:
        r109 = null;
        goto L18
    L13:
        r106 = null;
    L30:
        LarusFragmentAgeGateScrollBinding r110 = this.f357304h;
        if (r110 == null) goto L35;
        ImageView r111 = r110.f357528d;
        if (r111 == null) goto L35;
        r111.setOnClickListener(new z(this));
    L35:
        LarusFragmentAgeGateScrollBinding r112 = this.f357304h;
        if (r112 == null) goto L38;
        RectangleButton r113 = r112.f357527c;
    L40:
        if (this.f357305i == false) goto L43;
        if (r113 == null) goto L43;
        r113.a(false);
    L43:
        if (r113 == null) goto L45;
        e1.d(r113, new a0(this));
    L45:
        LarusFragmentAgeGateScrollBinding r114 = this.f357304h;
        if (r114 == null) goto L49;
        r102 = r114.f357526b;
    L49:
        if (this.f357305i == false) goto L64;
        Calendar r115 = Calendar.getInstance();
        Intrinsics.checkNotNull(r115);
        xj9.b.a(r115, r115.get(1) - 5);
        Calendar r116 = Calendar.getInstance();
        r116.add(1, -1);
        if (r102 == null) goto L53;
        r102.b(r115.getTime(), r116);
    L53:
        if (r102 == null) goto L73;
        int r117 = DatePicker.f328586j;
        NumberPicker r118 = r102.f328587a;
        if (r118 == null) goto L57;
        r118.setVisibility(0);
    L57:
        NumberPicker r119 = r102.f328588b;
        if (r119 == null) goto L60;
        r119.setVisibility(8);
    L60:
        NumberPicker r120 = r102.f328589c;
        if (r120 == null) goto L63;
        r120.setVisibility(8);
    L63:
        r102.requestLayout();
    L73:
        if (r102 == null) goto L76;
        r102.f328594h = new c0(this);
        return;
    L76:
        return;
    L64:
        Bundle r121 = getArguments();
        if (r121 == null) goto L67;
        int r122 = r121.getInt("input_pass_age");
    L68:
        Calendar r123 = Calendar.getInstance();
        Intrinsics.checkNotNull(r123);
        xj9.b.a(r123, r123.get(1) - r122);
        Calendar r124 = Calendar.getInstance();
        r124.add(1, -r122);
        Object r125 = r124.clone();
        Intrinsics.checkNotNull(r125, "null cannot be cast to non-null type java.util.Calendar");
        Calendar r126 = (Calendar) r125;
        r126.add(1, -1);
        r126.add(5, 1);
        if (r102 == null) goto L71;
        r102.b(r123.getTime(), r124);
    L71:
        if (r102 == null) goto L73;
        r102.setLowerBoundDate(r126);
        goto L73
    L67:
        r122 = 5;
        goto L68
    L38:
        r113 = null;
        goto L40
    L19:
        LarusFragmentAgeGateScrollBinding r127 = this.f357304h;
        if (r127 == null) goto L30;
        TextView r128 = r127.f357529e;
        if (r128 == null) goto L30;
        Context r129 = getContext();
        if (r129 == null) goto L28;
        String r130 = j5.a(r129, R.string.app_string_name, R.string.larus_dola_ageGate_year_desc_verify_global);
        if (r130 == null) goto L28;
    L29:
        r128.setText(r130);
    L28:
        r130 = "";
        goto L29
    L5:
        BaseNeutralAgeGateFragment.U90((String) this.f357306j.getValue(), (String) this.f357307k.getValue());
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_fragment_age_gate_scroll, r101, false);
        int r103 = R.id.date_picker;
        DatePicker r104 = (DatePicker) ViewBindings.findChildViewById(r102, R.id.date_picker);
        if (r104 == null) goto L15;
        r103 = R.id.next_btn;
        RectangleButton r105 = (RectangleButton) ViewBindings.findChildViewById(r102, R.id.next_btn);
        if (r105 == null) goto L15;
        r103 = R.id.phone_back_button;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r102, R.id.phone_back_button);
        if (r106 == null) goto L15;
        r103 = R.id.subTitle;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.subTitle);
        if (r107 == null) goto L15;
        r103 = R.id.title_text;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.title_text);
        if (r108 == null) goto L15;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        this.f357304h = new LarusFragmentAgeGateScrollBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
