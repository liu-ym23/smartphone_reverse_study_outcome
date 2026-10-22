package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCreateMenuItemBtnLayoutV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f326627b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326626a;
    }

    public LarusCreateMenuItemBtnLayoutV2Binding(View r100, TextView r101) {
        this.f326626a = r100;
        this.f326627b = r101;
    }

    public static LarusCreateMenuItemBtnLayoutV2Binding a(LayoutInflater r100, ViewGroup r101) {
        r100.inflate(R.layout.larus_create_menu_item_btn_layout_v2, r101);
        TextView r102 = (TextView) ViewBindings.findChildViewById(r101, R.id.btn_menu_item);
        if (r102 == null) goto L7;
        return new LarusCreateMenuItemBtnLayoutV2Binding(r101, r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.btn_menu_item)));
    }
}
