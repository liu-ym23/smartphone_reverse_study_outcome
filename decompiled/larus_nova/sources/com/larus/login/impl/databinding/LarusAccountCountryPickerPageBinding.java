package com.larus.login.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.login.impl.SideIndexBar;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusAccountCountryPickerPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f357397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f357398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SearchBar f357399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SearchBar f357400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SideIndexBar f357401f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357396a;
    }

    public LarusAccountCountryPickerPageBinding(ConstraintLayout r100, ImageView r101, RecyclerView r102, SearchBar r103, SearchBar r104, SideIndexBar r105) {
        this.f357396a = r100;
        this.f357397b = r101;
        this.f357398c = r102;
        this.f357399d = r103;
        this.f357400e = r104;
        this.f357401f = r105;
    }
}
