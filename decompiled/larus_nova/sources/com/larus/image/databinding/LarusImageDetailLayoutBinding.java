package com.larus.image.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusImageDetailLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f350913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f350914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f350915c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f350913a;
    }

    public static LarusImageDetailLayoutBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_image_detail_layout, r101, false);
        RecyclerView r103 = (RecyclerView) ViewBindings.findChildViewById(r102, R.id.pager);
        if (r103 == null) goto L7;
        FrameLayout r104 = (FrameLayout) r102;
        return new LarusImageDetailLayoutBinding(r104, r103, r104);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.pager)));
    }

    public LarusImageDetailLayoutBinding(FrameLayout r100, RecyclerView r101, FrameLayout r102) {
        this.f350913a = r100;
        this.f350914b = r101;
        this.f350915c = r102;
    }
}
