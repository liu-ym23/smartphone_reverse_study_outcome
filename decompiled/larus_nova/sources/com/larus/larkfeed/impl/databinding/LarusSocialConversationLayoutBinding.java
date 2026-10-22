package com.larus.larkfeed.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusSocialConversationLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f355149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f355150b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355149a;
    }

    public LarusSocialConversationLayoutBinding(FrameLayout r100, LinearLayout r101) {
        this.f355149a = r100;
        this.f355150b = r101;
    }
}
