package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemHeadTextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f358458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358459b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358458a;
    }

    public LarusBlockItemHeadTextBinding(TextView r100, TextView r101) {
        this.f358458a = r100;
        this.f358459b = r101;
    }
}
