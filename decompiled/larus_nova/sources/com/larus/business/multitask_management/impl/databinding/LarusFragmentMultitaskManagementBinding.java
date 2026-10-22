package com.larus.business.multitask_management.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFragmentMultitaskManagementBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f320822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f320823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f320824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f320825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f320826e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f320822a;
    }

    public static LarusFragmentMultitaskManagementBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_fragment_multitask_management, r101, false);
        int r103 = R.id.mtm_drag_handle;
        View r104 = ViewBindings.findChildViewById(r102, R.id.mtm_drag_handle);
        if (r104 == null) goto L11;
        ConstraintLayout r105 = (ConstraintLayout) r102;
        r103 = R.id.mtm_sheet_container;
        RecyclerView r106 = (RecyclerView) ViewBindings.findChildViewById(r102, R.id.mtm_sheet_container);
        if (r106 == null) goto L11;
        r103 = R.id.mtm_top_mask;
        View r107 = ViewBindings.findChildViewById(r102, R.id.mtm_top_mask);
        if (r107 == null) goto L11;
        return new LarusFragmentMultitaskManagementBinding(r105, r104, r105, r106, r107);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusFragmentMultitaskManagementBinding(ConstraintLayout r100, View r101, ConstraintLayout r102, RecyclerView r103, View r104) {
        this.f320822a = r100;
        this.f320823b = r101;
        this.f320824c = r102;
        this.f320825d = r103;
        this.f320826e = r104;
    }
}
