package tx8;

import androidx.lifecycle.LifecycleOwner;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;

/* JADX INFO: loaded from: classes26.dex */
public interface d {
    void a(CameraContainer r100);

    void b(BaseCameraViewModel r100, e r101, LifecycleOwner r102);

    void c(CameraContainer r100);

    String getId();

    com.larus.camera.impl.ui.arch.c getPriority();
}
