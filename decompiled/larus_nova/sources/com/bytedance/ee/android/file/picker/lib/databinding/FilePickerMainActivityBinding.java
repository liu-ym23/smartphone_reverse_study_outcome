package com.bytedance.ee.android.file.picker.lib.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.android.file.picker.lib.v2.ui.view.PickerMenuView;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes15.dex */
public final class FilePickerMainActivityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f205991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f205992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PickerMenuView f205993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f205994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f205995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f205996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CommonTitleBar f205997g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f205991a;
    }

    public static FilePickerMainActivityBinding a(LayoutInflater r100, ViewGroup r110) {
        View r101 = r100.inflate(R.layout.file_picker_main_activity, r110, false);
        int r111 = R.id.bottom_bar;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.bottom_bar)) == null) goto L19;
        r111 = R.id.btn_send;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r101, R.id.btn_send);
        if (r102 == null) goto L19;
        r111 = R.id.dropdown_menu;
        PickerMenuView r103 = (PickerMenuView) ViewBindings.findChildViewById(r101, R.id.dropdown_menu);
        if (r103 == null) goto L19;
        r111 = R.id.layout_send;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.layout_send);
        if (r104 == null) goto L19;
        r111 = R.id.recycler_view;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.recycler_view);
        if (r105 == null) goto L19;
        r111 = R.id.select_file_count;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.select_file_count);
        if (r106 == null) goto L19;
        r111 = R.id.title_bar;
        CommonTitleBar r107 = (CommonTitleBar) ViewBindings.findChildViewById(r101, R.id.title_bar);
        if (r107 == null) goto L19;
        return new FilePickerMainActivityBinding((ConstraintLayout) r101, r102, r103, r104, r105, r106, r107);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }

    public FilePickerMainActivityBinding(ConstraintLayout r100, TextView r101, PickerMenuView r102, FrameLayout r103, RecyclerView r104, TextView r105, CommonTitleBar r106) {
        this.f205991a = r100;
        this.f205992b = r101;
        this.f205993c = r102;
        this.f205994d = r103;
        this.f205995e = r104;
        this.f205996f = r105;
        this.f205997g = r106;
    }
}
