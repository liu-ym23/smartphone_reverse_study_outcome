package com.larus.share.impl.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusShareLayoutPanelViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f368627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f368628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f368629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f368630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EditText f368631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f368632f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368627a;
    }

    public LarusShareLayoutPanelViewBinding(LinearLayout r100, LinearLayout r101, RecyclerView r102, FrameLayout r103, EditText r104, RecyclerView r105) {
        this.f368627a = r100;
        this.f368628b = r101;
        this.f368629c = r102;
        this.f368630d = r103;
        this.f368631e = r104;
        this.f368632f = r105;
    }
}
