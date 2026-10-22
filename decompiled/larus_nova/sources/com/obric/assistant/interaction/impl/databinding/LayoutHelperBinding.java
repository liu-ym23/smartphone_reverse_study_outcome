package com.obric.assistant.interaction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes33.dex */
public final class LayoutHelperBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainer;
    private final FragmentContainerView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public FragmentContainerView getRoot() {
        return this.rootView;
    }

    public static LayoutHelperBinding bind(View r100) {
        if (r100 == null) goto L6;
        FragmentContainerView r101 = (FragmentContainerView) r100;
        return new LayoutHelperBinding(r101, r101);
    L6:
        throw new NullPointerException("rootView");
    }

    public static LayoutHelperBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private LayoutHelperBinding(FragmentContainerView r100, FragmentContainerView r101) {
        this.rootView = r100;
        this.fragmentContainer = r101;
    }

    public static LayoutHelperBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.layout_helper, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
