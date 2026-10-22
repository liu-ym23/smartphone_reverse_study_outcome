package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageDeviceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusDoraDeviceDisconnectedLayoutBinding f332889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusDoraDeviceInfoLayoutBinding f332890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusDoraDeviceScanLayoutBinding f332891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraNovaTitleBarEx f332892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f332893f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332888a;
    }

    public LarusDoraPageDeviceBinding(ConstraintLayout r100, LarusDoraDeviceDisconnectedLayoutBinding r101, LarusDoraDeviceInfoLayoutBinding r102, LarusDoraDeviceScanLayoutBinding r103, DoraNovaTitleBarEx r104, View r105) {
        this.f332888a = r100;
        this.f332889b = r101;
        this.f332890c = r102;
        this.f332891d = r103;
        this.f332892e = r104;
        this.f332893f = r105;
    }
}
