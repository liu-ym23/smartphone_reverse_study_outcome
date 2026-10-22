package com.larus.home.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.RedDotTextView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemSideBarProjectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f344315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f344316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f344317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f344318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f344319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f344320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RedDotTextView f344321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f344322h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344315a;
    }

    public LarusItemSideBarProjectBinding(LinearLayout r100, ImageView r101, ImageView r102, RecyclerView r103, ConstraintLayout r104, View r105, RedDotTextView r106, TextView r107) {
        this.f344315a = r100;
        this.f344316b = r101;
        this.f344317c = r102;
        this.f344318d = r103;
        this.f344319e = r104;
        this.f344320f = r105;
        this.f344321g = r106;
        this.f344322h = r107;
    }
}
