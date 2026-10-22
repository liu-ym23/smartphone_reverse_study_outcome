package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardPhotoHorizontalItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f386202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f386204c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386202a;
    }

    public ObricCardPhotoHorizontalItemBinding(RelativeLayout r100, SimpleDraweeView r101, ImageView r102) {
        this.f386202a = r100;
        this.f386203b = r101;
        this.f386204c = r102;
    }
}
