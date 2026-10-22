package com.larus.camera.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutAlbumThumbItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f321499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f321500b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321499a;
    }

    public LarusLayoutAlbumThumbItemBinding(SimpleDraweeView r100, SimpleDraweeView r101) {
        this.f321499a = r100;
        this.f321500b = r101;
    }
}
