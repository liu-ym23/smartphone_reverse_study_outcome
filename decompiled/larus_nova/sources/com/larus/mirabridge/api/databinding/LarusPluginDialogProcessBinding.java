package com.larus.mirabridge.api.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusPluginDialogProcessBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f359319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f359320b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f359319a;
    }

    public LarusPluginDialogProcessBinding(LinearLayout r100, TextView r101) {
        this.f359319a = r100;
        this.f359320b = r101;
    }
}
