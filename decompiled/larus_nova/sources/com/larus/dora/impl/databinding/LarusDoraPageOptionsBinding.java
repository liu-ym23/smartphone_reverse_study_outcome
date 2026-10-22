package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageOptionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f333148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemGroup f333149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f333150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NovaTitleBarEx f333151d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333148a;
    }

    public static LarusDoraPageOptionsBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_page_options, r101, false);
        int r103 = R.id.dora_options_group;
        ItemGroup r104 = (ItemGroup) ViewBindings.findChildViewById(r102, R.id.dora_options_group);
        if (r104 == null) goto L13;
        r103 = R.id.dora_page_mask;
        View r105 = ViewBindings.findChildViewById(r102, R.id.dora_page_mask);
        if (r105 == null) goto L13;
        r103 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r102, R.id.scroll_view)) == null) goto L13;
        r103 = R.id.title;
        NovaTitleBarEx r106 = (NovaTitleBarEx) ViewBindings.findChildViewById(r102, R.id.title);
        if (r106 == null) goto L13;
        return new LarusDoraPageOptionsBinding((ConstraintLayout) r102, r104, r105, r106);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusDoraPageOptionsBinding(ConstraintLayout r100, ItemGroup r101, View r102, NovaTitleBarEx r103) {
        this.f333148a = r100;
        this.f333149b = r101;
        this.f333150c = r102;
        this.f333151d = r103;
    }
}
