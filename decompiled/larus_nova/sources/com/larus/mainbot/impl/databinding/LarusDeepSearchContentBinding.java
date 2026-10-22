package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.widget.AtMostHeightLinearLayout;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusDeepSearchContentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f358565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f358566b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358565a;
    }

    public LarusDeepSearchContentBinding(LinearLayout r100, AtMostHeightLinearLayout r101, View r102) {
        this.f358565a = r100;
        this.f358566b = r102;
    }
}
