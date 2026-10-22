package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFlowMessageCardStickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f310887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageViewWithLastMotion f310888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f310889c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310887a;
    }

    public LarusFlowMessageCardStickerBinding(LinearLayout r100, ImageViewWithLastMotion r101, FrameLayout r102) {
        this.f310887a = r100;
        this.f310888b = r101;
        this.f310889c = r102;
    }
}
