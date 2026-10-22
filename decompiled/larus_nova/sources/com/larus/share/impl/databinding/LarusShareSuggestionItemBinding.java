package com.larus.share.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusShareSuggestionItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f368633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f368634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f368635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f368636d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368633a;
    }

    public LarusShareSuggestionItemBinding(ConstraintLayout r100, TextView r101, SimpleDraweeView r102, FrameLayout r103) {
        this.f368633a = r100;
        this.f368634b = r101;
        this.f368635c = r102;
        this.f368636d = r103;
    }
}
