package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusImageScrollCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f310936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f310937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageCardNestedScrollableHost f310938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f310939d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310936a;
    }

    public LarusImageScrollCardBinding(LinearLayout r100, RecyclerView r101, ImageCardNestedScrollableHost r102, TextView r103) {
        this.f310936a = r100;
        this.f310937b = r101;
        this.f310938c = r102;
        this.f310939d = r103;
    }
}
