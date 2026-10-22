package nx8;

import android.graphics.Bitmap;
import android.view.View;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes26.dex */
public interface m {

    public interface a {
        void a(int r100);
    }

    void a(c r100, boolean r101);

    Bitmap b();

    void c(int r100, boolean r101);

    boolean d();

    void destroy();

    Bitmap e();

    void f(int r100, int r101);

    b g(String r100, int r101, int r102, boolean r103, SceneType r104, String r105, String r106, boolean r107);

    View getView();

    Bitmap h();

    StateFlowImpl i();

    g j(i r100);

    boolean k();

    int l();

    void m(a r100);

    void n(SceneType r100);

    void o(Bitmap r100, String r101, int r102, boolean r103);

    boolean p();

    boolean q();
}
