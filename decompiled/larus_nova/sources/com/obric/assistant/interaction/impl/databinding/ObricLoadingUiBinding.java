package com.obric.assistant.interaction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.obric.oui.status.OPageStatus;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricLoadingUiBinding implements ViewBinding {
    public final OPageStatus loadingStatus;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ObricLoadingUiBinding bind(View r100) {
        OPageStatus r101 = (OPageStatus) ViewBindings.findChildViewById(r100, R.id.loading_status);
        if (r101 == null) goto L7;
        return new ObricLoadingUiBinding((FrameLayout) r100, r101);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.loading_status)));
    }

    public static ObricLoadingUiBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    private ObricLoadingUiBinding(FrameLayout r100, OPageStatus r101) {
        this.rootView = r100;
        this.loadingStatus = r101;
    }

    public static ObricLoadingUiBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.obric_loading_ui, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
