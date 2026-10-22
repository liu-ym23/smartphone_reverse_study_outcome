package pq9;

import android.view.SurfaceHolder;
import com.larus.avatar.impl.scan.component.ScanCameraComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.platform.model.camera.ve.Ratio;

/* JADX INFO: loaded from: classes31.dex */
public interface j {
    void a();

    void b(f r100);

    boolean c();

    void d(float r100);

    void e(int r100, CameraCaptureViewModel.a r101);

    void f(CameraCaptureViewModel.b r100);

    boolean g();

    String getFlashMode();

    void h(float r100);

    void i();

    void j(String r100);

    void k(boolean r100, g r101, boolean r102);

    boolean l(String r100);

    void m(Ratio r100);

    void n(ScanCameraComponent.b r100);

    void o();

    void p();

    void q(SurfaceHolder r100, int r101, CameraCaptureViewModel.d r102, b r103, Boolean r104, boolean r105);

    void r(int r100, int r101, int r102);

    void s(String r100, String r101);

    void switchCamera();

    int t();

    void u();
}
