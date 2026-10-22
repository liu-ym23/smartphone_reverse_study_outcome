package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageDeviceSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f332898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f332899c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332897a;
    }

    public LarusDoraPageDeviceSettingsBinding(ConstraintLayout r100, RecyclerView r101, NovaTitleBarEx r102) {
        this.f332897a = r100;
        this.f332898b = r101;
        this.f332899c = r102;
    }
}
