package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockReplyTextLoadingViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358502c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358500a;
    }

    public LarusBlockReplyTextLoadingViewBinding(View r100, SimpleDraweeView r101, TextView r102) {
        this.f358500a = r100;
        this.f358501b = r101;
        this.f358502c = r102;
    }
}
