package com.larus.camera.impl.ui.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import com.larus.camera.impl.utils.CameraData;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes26.dex */
public interface q0 extends com.larus.camera.impl.utils.j0 {
    void A(int r100, int r101, int r102, int r103);

    Bundle B();

    boolean B0(Context r100);

    StateFlowImpl E();

    void F(String r100);

    Bitmap G();

    void G0(boolean r100, CameraCaptureViewModel.i r101);

    void H(String r100, Bitmap r101);

    Pair<Bitmap, Boolean> P(Context r100, boolean r101);

    Bitmap Q(Context r100, Bitmap r101);

    void R(boolean r100);

    Bitmap S(Context r100, Uri r101);

    xx8.c W();

    void X(Intent r100, boolean r101, Function1<? super ActivityResult, Unit> r102);

    void b0(CameraCaptureViewModel.j r100);

    void closePage();

    void d(float r100);

    void d0(boolean r100, Integer r101, String r102, boolean r103, b r104, c r105);

    void e(int r100, CameraCaptureViewModel.a r101);

    void f(CameraCaptureViewModel.b r100);

    boolean g();

    boolean g0();

    Fragment getCurrentFragment();

    String getFlashMode();

    int getRenderFps();

    void h(float r100);

    Fragment h0();

    void i();

    void j(String r100);

    String k(Bitmap r100, int r101, pq9.h r102);

    Bitmap l(Context r100, Uri r101);

    void l0(Function1<? super CameraData, CameraData> r100);

    Bitmap p0(String r100);

    void r();

    Bitmap s(String r100);

    void s0();

    void setResult(int r100, Intent r101);

    void switchCamera();

    boolean t();

    boolean u();

    int u0();

    void x0(String r100);

    CameraData y0();

    void z(SurfaceHolder r100, CameraCaptureViewModel.d r101, pq9.b r102, Boolean r103, boolean r104);
}
