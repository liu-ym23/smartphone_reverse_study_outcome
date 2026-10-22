package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePreviewNativeViewLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f211011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f211012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f211013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f211014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableNativeViewContainer f211015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f211016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f211017g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211011a;
    }

    public BitablePreviewNativeViewLayoutBinding(LinearLayout r100, View r101, AppCompatImageView r102, FrameLayout r103, BitableNativeViewContainer r104, LinearLayout r105, TextView r106) {
        this.f211011a = r100;
        this.f211012b = r101;
        this.f211013c = r102;
        this.f211014d = r103;
        this.f211015e = r104;
        this.f211016f = r105;
        this.f211017g = r106;
    }
}
