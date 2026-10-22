package com.larus.av_call.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusRealtimeBottomMoreBtnBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f290561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f290562b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f290561a;
    }

    public LarusRealtimeBottomMoreBtnBinding(FrameLayout r100, SimpleDraweeView r101) {
        this.f290561a = r100;
        this.f290562b = r101;
    }
}
