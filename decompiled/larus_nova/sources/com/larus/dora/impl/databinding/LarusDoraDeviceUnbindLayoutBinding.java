package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceUnbindLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f332459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f332460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f332461c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332459a;
    }

    public LarusDoraDeviceUnbindLayoutBinding(LinearLayout r100, LinearLayout r101, AppCompatTextView r102) {
        this.f332459a = r100;
        this.f332460b = r101;
        this.f332461c = r102;
    }
}
