package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemFoldTextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f358454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f358455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f358456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ShimmerTextView f358457e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358453a;
    }

    public LarusBlockItemFoldTextBinding(LinearLayout r100, AppCompatImageView r101, LinearLayout r102, SimpleDraweeView r103, ShimmerTextView r104) {
        this.f358453a = r100;
        this.f358454b = r101;
        this.f358455c = r102;
        this.f358456d = r103;
        this.f358457e = r104;
    }
}
