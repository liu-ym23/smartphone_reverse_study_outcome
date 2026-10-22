package com.larus.bmhome.music.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusMusicCoverViewHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f312754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieAdapterView f312755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f312756c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f312754a;
    }

    public LarusMusicCoverViewHolderBinding(ConstraintLayout r100, LottieAdapterView r101, SimpleDraweeView r102) {
        this.f312754a = r100;
        this.f312755b = r101;
        this.f312756c = r102;
    }
}
