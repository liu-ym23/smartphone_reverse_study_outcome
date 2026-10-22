package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusExpertCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f310877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f310878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f310879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f310880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtMostHeightRecyclerView f310881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f310882f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310877a;
    }

    public LarusExpertCardBinding(LinearLayout r100, AppCompatImageView r101, LinearLayout r102, FrameLayout r103, AtMostHeightRecyclerView r104, TextView r105) {
        this.f310877a = r100;
        this.f310878b = r101;
        this.f310879c = r102;
        this.f310880d = r103;
        this.f310881e = r104;
        this.f310882f = r105;
    }
}
