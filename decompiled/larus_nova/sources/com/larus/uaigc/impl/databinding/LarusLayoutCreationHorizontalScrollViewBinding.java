package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusLayoutCreationHorizontalScrollViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageCardNestedScrollableHost f373215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f373216b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373215a;
    }

    public static LarusLayoutCreationHorizontalScrollViewBinding a(LayoutInflater r100) {
        View r101 = r100.inflate(R.layout.larus_layout_creation_horizontal_scroll_view, null, false);
        ImageCardNestedScrollableHost r102 = (ImageCardNestedScrollableHost) r101;
        RecyclerView r103 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.recycler_view);
        if (r103 == null) goto L7;
        return new LarusLayoutCreationHorizontalScrollViewBinding(r102, r103);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.recycler_view)));
    }

    public LarusLayoutCreationHorizontalScrollViewBinding(ImageCardNestedScrollableHost r100, RecyclerView r101) {
        this.f373215a = r100;
        this.f373216b = r101;
    }
}
