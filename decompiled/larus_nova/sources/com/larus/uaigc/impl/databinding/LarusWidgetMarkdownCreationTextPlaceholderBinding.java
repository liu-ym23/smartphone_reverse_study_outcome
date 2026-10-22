package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;
import com.larus.uaigc.chat.markdown.placeholder.ShimmerTextPlaceHolderView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusWidgetMarkdownCreationTextPlaceholderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShimmerTextPlaceHolderView f373277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShimmerTextPlaceHolderView f373278b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373277a;
    }

    public LarusWidgetMarkdownCreationTextPlaceholderBinding(ShimmerTextPlaceHolderView r100, ShimmerTextPlaceHolderView r101) {
        this.f373277a = r100;
        this.f373278b = r101;
    }

    public static LarusWidgetMarkdownCreationTextPlaceholderBinding a(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.larus_widget_markdown_creation_text_placeholder, r101, false);
        if (r102 == false) goto L5;
        r101.addView(r103);
    L5:
        if (r103 == null) goto L9;
        ShimmerTextPlaceHolderView r104 = (ShimmerTextPlaceHolderView) r103;
        return new LarusWidgetMarkdownCreationTextPlaceholderBinding(r104, r104);
    L9:
        throw new NullPointerException("rootView");
    }
}
