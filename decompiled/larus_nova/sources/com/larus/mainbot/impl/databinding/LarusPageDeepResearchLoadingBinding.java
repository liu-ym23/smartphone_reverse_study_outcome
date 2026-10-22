package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.layout.widget.ShimmerLoadingVIew;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusPageDeepResearchLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358812a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358812a;
    }

    public LarusPageDeepResearchLoadingBinding(LinearLayout r100) {
        this.f358812a = r100;
    }

    public static LarusPageDeepResearchLoadingBinding a(View r100) {
        LinearLayout r101 = (LinearLayout) r100;
        int r102 = R.id.shimmer_view_1;
        if (((ShimmerLoadingVIew) ViewBindings.findChildViewById(r100, R.id.shimmer_view_1)) == null) goto L11;
        r102 = R.id.shimmer_view_2;
        if (((ShimmerLoadingVIew) ViewBindings.findChildViewById(r100, R.id.shimmer_view_2)) == null) goto L11;
        r102 = R.id.shimmer_view_3;
        if (((ShimmerLoadingVIew) ViewBindings.findChildViewById(r100, R.id.shimmer_view_3)) == null) goto L11;
        return new LarusPageDeepResearchLoadingBinding(r101);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }
}
