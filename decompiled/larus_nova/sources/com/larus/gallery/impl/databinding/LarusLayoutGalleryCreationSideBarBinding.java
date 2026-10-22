package com.larus.gallery.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutGalleryCreationSideBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f343987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CreationSidebarView f343988b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343987a;
    }

    public LarusLayoutGalleryCreationSideBarBinding(FrameLayout r100, CreationSidebarView r101) {
        this.f343987a = r100;
        this.f343988b = r101;
    }

    public static LarusLayoutGalleryCreationSideBarBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_layout_gallery_creation_side_bar, r101, false);
        CreationSidebarView r103 = (CreationSidebarView) ViewBindings.findChildViewById(r102, R.id.creation_sidebar_view);
        if (r103 == null) goto L7;
        return new LarusLayoutGalleryCreationSideBarBinding((FrameLayout) r102, r103);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.creation_sidebar_view)));
    }
}
