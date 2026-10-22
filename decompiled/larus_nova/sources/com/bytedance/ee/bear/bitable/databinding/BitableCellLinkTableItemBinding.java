package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCellLinkTableItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f210731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f210732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f210733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f210734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f210735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f210736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BitableNativeViewContainer f210737h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210730a;
    }

    public BitableCellLinkTableItemBinding(FrameLayout r100, View r101, AppCompatImageView r102, ConstraintLayout r103, FrameLayout r104, View r105, AppCompatImageView r106, TextView r107, BitableNativeViewContainer r108) {
        this.f210730a = r100;
        this.f210731b = r101;
        this.f210732c = r102;
        this.f210733d = r104;
        this.f210734e = r105;
        this.f210735f = r106;
        this.f210736g = r107;
        this.f210737h = r108;
    }
}
