package hba;

import android.view.SurfaceControl;
import com.obric.assistant.activation.presentation.runtime.surface.ObricRootSurfaceEvent;

/* JADX INFO: loaded from: classes4.dex */
public interface f {
    void onRootSurfaceAvailable(SurfaceControl r100, ObricRootSurfaceEvent r101, SurfaceControl.Transaction r102);

    void onRootSurfaceDestroyed();

    void onRootSurfaceUnavailable(String r100);
}
