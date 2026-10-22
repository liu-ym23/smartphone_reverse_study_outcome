package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class PickerScenarioListFragmentBinding implements ViewBinding {
    public final TextView pickerScenarioEmptyHint;
    public final RecyclerView pickerScenarioList;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PickerScenarioListFragmentBinding bind(View r100) {
        int r101 = R.id.picker_scenario_empty_hint;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.picker_scenario_empty_hint);
        if (r102 == null) goto L9;
        r101 = R.id.picker_scenario_list;
        RecyclerView r103 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.picker_scenario_list);
        if (r103 == null) goto L9;
        return new PickerScenarioListFragmentBinding((FrameLayout) r100, r102, r103);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static PickerScenarioListFragmentBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private PickerScenarioListFragmentBinding(FrameLayout r100, TextView r101, RecyclerView r102) {
        this.rootView = r100;
        this.pickerScenarioEmptyHint = r101;
        this.pickerScenarioList = r102;
    }

    public static PickerScenarioListFragmentBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.picker_scenario_list_fragment, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
