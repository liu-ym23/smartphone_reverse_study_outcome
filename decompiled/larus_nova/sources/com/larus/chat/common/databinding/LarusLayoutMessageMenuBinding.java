package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutMessageMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutCompat f324016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f324017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f324018c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324016a;
    }

    public LarusLayoutMessageMenuBinding(LinearLayoutCompat r100, FrameLayout r101, FrameLayout r102) {
        this.f324016a = r100;
        this.f324017b = r101;
        this.f324018c = r102;
    }
}
