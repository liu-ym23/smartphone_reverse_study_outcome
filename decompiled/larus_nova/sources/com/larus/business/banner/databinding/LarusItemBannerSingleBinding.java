package com.larus.business.banner.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemBannerSingleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f319937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f319938b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f319937a;
    }

    public LarusItemBannerSingleBinding(RelativeLayout r100, SimpleDraweeView r101) {
        this.f319937a = r100;
        this.f319938b = r101;
    }
}
