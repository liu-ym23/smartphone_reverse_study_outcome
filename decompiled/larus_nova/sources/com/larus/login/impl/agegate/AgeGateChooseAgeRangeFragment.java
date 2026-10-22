package com.larus.login.impl.agegate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.login.impl.databinding.LarusFragmentAgeGateChooseAgeRangeBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/login/impl/agegate/AgeGateChooseAgeRangeFragment;", "Lcom/larus/login/impl/agegate/BaseAgeGateClickChooseFragment;", "<init>", "()V", "binding", "Lcom/larus/login/impl/databinding/LarusFragmentAgeGateChooseAgeRangeBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgeGateChooseAgeRangeFragment extends BaseAgeGateClickChooseFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f357270f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentAgeGateChooseAgeRangeBinding f357271e;

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f357271e = null;
    }

    public AgeGateChooseAgeRangeFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusFragmentAgeGateChooseAgeRangeBinding r102 = this.f357271e;
        if (r102 == null) goto L7;
        TextView r103 = r102.f357500b;
        if (r103 == null) goto L7;
        r103.setText(AgeRange.RANGE_2_12.getShowText());
    L7:
        LarusFragmentAgeGateChooseAgeRangeBinding r104 = this.f357271e;
        if (r104 == null) goto L12;
        TextView r105 = r104.f357500b;
        if (r105 == null) goto L12;
        r105.setOnClickListener(new b(this));
    L12:
        LarusFragmentAgeGateChooseAgeRangeBinding r106 = this.f357271e;
        if (r106 == null) goto L17;
        TextView r107 = r106.f357501c;
        if (r107 == null) goto L17;
        r107.setText(AgeRange.RANGE_13_17.getShowText());
    L17:
        LarusFragmentAgeGateChooseAgeRangeBinding r108 = this.f357271e;
        if (r108 == null) goto L22;
        TextView r109 = r108.f357501c;
        if (r109 == null) goto L22;
        r109.setOnClickListener(new c(this));
    L22:
        LarusFragmentAgeGateChooseAgeRangeBinding r110 = this.f357271e;
        if (r110 == null) goto L27;
        TextView r111 = r110.f357502d;
        if (r111 == null) goto L27;
        r111.setText(AgeRange.RANGE_18_24.getShowText());
    L27:
        LarusFragmentAgeGateChooseAgeRangeBinding r112 = this.f357271e;
        if (r112 == null) goto L32;
        TextView r113 = r112.f357502d;
        if (r113 == null) goto L32;
        r113.setOnClickListener(new d(this));
    L32:
        LarusFragmentAgeGateChooseAgeRangeBinding r114 = this.f357271e;
        if (r114 == null) goto L37;
        TextView r115 = r114.f357503e;
        if (r115 == null) goto L37;
        r115.setText(AgeRange.RANGE_25_40.getShowText());
    L37:
        LarusFragmentAgeGateChooseAgeRangeBinding r116 = this.f357271e;
        if (r116 == null) goto L42;
        TextView r117 = r116.f357503e;
        if (r117 == null) goto L42;
        r117.setOnClickListener(new e(this));
    L42:
        LarusFragmentAgeGateChooseAgeRangeBinding r118 = this.f357271e;
        if (r118 == null) goto L47;
        TextView r119 = r118.f357504f;
        if (r119 == null) goto L47;
        r119.setText(AgeRange.RANGE_41_60.getShowText());
    L47:
        LarusFragmentAgeGateChooseAgeRangeBinding r120 = this.f357271e;
        if (r120 == null) goto L52;
        TextView r121 = r120.f357504f;
        if (r121 == null) goto L52;
        r121.setOnClickListener(new f(this));
    L52:
        LarusFragmentAgeGateChooseAgeRangeBinding r122 = this.f357271e;
        if (r122 == null) goto L57;
        TextView r123 = r122.f357505g;
        if (r123 == null) goto L57;
        r123.setText(AgeRange.RANGE_61_100.getShowText());
    L57:
        LarusFragmentAgeGateChooseAgeRangeBinding r124 = this.f357271e;
        if (r124 == null) goto L63;
        TextView r125 = r124.f357505g;
        if (r125 == null) goto L64;
        r125.setOnClickListener(new g(this));
        return;
    L64:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_fragment_age_gate_choose_age_range, r110, false);
        int r112 = R.id.range1;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r101, R.id.range1);
        if (r102 == null) goto L17;
        r112 = R.id.range2;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.range2);
        if (r103 == null) goto L17;
        r112 = R.id.range3;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.range3);
        if (r104 == null) goto L17;
        r112 = R.id.range4;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r101, R.id.range4);
        if (r105 == null) goto L17;
        r112 = R.id.range5;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.range5);
        if (r106 == null) goto L17;
        r112 = R.id.range6;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.range6);
        if (r107 == null) goto L17;
        ScrollView r108 = (ScrollView) r101;
        this.f357271e = new LarusFragmentAgeGateChooseAgeRangeBinding(r108, r102, r103, r104, r105, r106, r107);
        return r108;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
