package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.uaigc.creation.gallery.providers.CreationBottomView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusGalleryCreationBottomBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f373155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CreationBottomView f373156b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373155a;
    }

    public LarusGalleryCreationBottomBinding(FrameLayout r100, CreationBottomView r101) {
        this.f373155a = r100;
        this.f373156b = r101;
    }
}
