package com.larus.photopicker.v2.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusFragmentBottomPhotoPickerV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f364373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f364374b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f364373a;
    }

    public LarusFragmentBottomPhotoPickerV2Binding(FrameLayout r100, FrameLayout r101) {
        this.f364373a = r100;
        this.f364374b = r101;
    }

    public static LarusFragmentBottomPhotoPickerV2Binding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_fragment_bottom_photo_picker_v2, r101, false);
        if (r102 == null) goto L7;
        FrameLayout r103 = (FrameLayout) r102;
        return new LarusFragmentBottomPhotoPickerV2Binding(r103, r103);
    L7:
        throw new NullPointerException("rootView");
    }
}
