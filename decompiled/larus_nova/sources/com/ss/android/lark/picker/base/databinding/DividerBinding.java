package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class DividerBinding implements ViewBinding {
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    private DividerBinding(LinearLayout r100) {
        this.rootView = r100;
    }

    public static DividerBinding bind(View r100) {
        if (r100 == null) goto L6;
        return new DividerBinding((LinearLayout) r100);
    L6:
        throw new NullPointerException("rootView");
    }

    public static DividerBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static DividerBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.divider, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }
}
