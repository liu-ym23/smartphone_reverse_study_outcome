package com.larus.photopicker.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.photopicker.impl.ui.widget.ChatBottomAlbumFrameLayout;
import com.larus.photopicker.impl.ui.widget.TransparentView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusFragmentBottomPhotoPickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f363993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f363994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f363995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f363996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TransparentView f363997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChatBottomAlbumFrameLayout f363998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f363999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f364000h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f363993a;
    }

    public LarusFragmentBottomPhotoPickerBinding(ConstraintLayout r100, LinearLayout r101, TextView r102, TextView r103, TransparentView r104, ChatBottomAlbumFrameLayout r105, ImageView r106, ConstraintLayout r107) {
        this.f363993a = r100;
        this.f363994b = r101;
        this.f363995c = r102;
        this.f363996d = r103;
        this.f363997e = r104;
        this.f363998f = r105;
        this.f363999g = r106;
        this.f364000h = r107;
    }
}
