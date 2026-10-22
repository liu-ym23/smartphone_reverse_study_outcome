package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemMarkdownTextWithIconSubBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f358470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShimmerTextView f358471c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358469a;
    }

    public LarusBlockItemMarkdownTextWithIconSubBinding(LinearLayout r100, SimpleDraweeView r101, ShimmerTextView r102) {
        this.f358469a = r100;
        this.f358470b = r101;
        this.f358471c = r102;
    }
}
