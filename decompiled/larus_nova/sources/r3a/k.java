package r3a;

import android.app.Activity;
import android.view.TextureView;
import androidx.fragment.app.Fragment;
import com.larus.voicecall.impl.component.vlm.camera.core.CameraOpenScene;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.vesdk.VEDisplaySettings;

/* JADX INFO: loaded from: classes32.dex */
public interface k {
    void a();

    void b(boolean r100);

    boolean c(boolean r100);

    boolean d(String r100);

    void e(int r100, int r101, VEDisplaySettings.VEDisplayFitMode r102);

    void f(float r100, float r101);

    m g();

    Activity getActivity();

    Fragment getFragment();

    void h();

    void i();

    boolean isCameraTorchSupported();

    p3a.c j();

    boolean k();

    void l(VEFrame r100);

    void m(TextureView r100);

    boolean n();

    void o();

    boolean p(String r100, CameraOpenScene r101);

    boolean q();

    boolean r(boolean r100, String r101);

    void s();

    void t(s3a.a r100);

    void u(float r100);
}
