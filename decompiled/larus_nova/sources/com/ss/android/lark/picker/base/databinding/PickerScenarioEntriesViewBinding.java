package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class PickerScenarioEntriesViewBinding implements ViewBinding {
    public final LinearLayout pickerScenarioEntryPermissionGroup;
    public final LinearLayout pickerScenarioEntryPersonnelType;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PickerScenarioEntriesViewBinding bind(View r100) {
        int r101 = R.id.picker_scenario_entry_permission_group;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.picker_scenario_entry_permission_group);
        if (r102 == null) goto L9;
        r101 = R.id.picker_scenario_entry_personnel_type;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.picker_scenario_entry_personnel_type);
        if (r103 == null) goto L9;
        return new PickerScenarioEntriesViewBinding((LinearLayout) r100, r102, r103);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static PickerScenarioEntriesViewBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private PickerScenarioEntriesViewBinding(LinearLayout r100, LinearLayout r101, LinearLayout r102) {
        this.rootView = r100;
        this.pickerScenarioEntryPermissionGroup = r101;
        this.pickerScenarioEntryPersonnelType = r102;
    }

    public static PickerScenarioEntriesViewBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.picker_scenario_entries_view, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
