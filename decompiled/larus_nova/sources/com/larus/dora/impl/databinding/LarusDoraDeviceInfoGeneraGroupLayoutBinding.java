package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceInfoGeneraGroupLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f332388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f332389b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332388a;
    }

    public LarusDoraDeviceInfoGeneraGroupLayoutBinding(LinearLayout r100, LinearLayout r101) {
        this.f332388a = r100;
        this.f332389b = r101;
    }

    public static LarusDoraDeviceInfoGeneraGroupLayoutBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_device_info_genera_group_layout, r101, false);
        if (r102 == null) goto L7;
        LinearLayout r103 = (LinearLayout) r102;
        return new LarusDoraDeviceInfoGeneraGroupLayoutBinding(r103, r103);
    L7:
        throw new NullPointerException("rootView");
    }
}
