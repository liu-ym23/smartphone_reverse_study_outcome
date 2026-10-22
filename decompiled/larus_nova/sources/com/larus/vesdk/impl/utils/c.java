package com.larus.vesdk.impl.utils;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESize;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f375616c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pq9.a f375617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VEBachQRCodeParam f375618b;

    public static final class a {
    }

    static {
    }

    public c(VERecorder r100, CameraCaptureViewModel.d r101, VESize r102) {
        this.f375617a = r101;
        this.f375618b = new VEBachQRCodeParam.Builder().setCodeType(1023).setScanMode(VEBachQRCodeParam.VE_SCAN_MODE.CAMERA).build();
    }
}
