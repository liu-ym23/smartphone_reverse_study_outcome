package x6a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;

/* JADX INFO: loaded from: classes32.dex */
public interface e {
    void applyRendererClipBounds(boolean r100, Rect r101);

    void applyRendererOpacity(float r100);

    void applyRendererTransform(float[] r100);

    PointF convertPointInRendererHostToScreen(PointF r100);

    i createRenderer(PlatformRendererContext r100, int r101);

    i getRenderer();

    int getRendererHostHeight();

    int getRendererHostScrollX();

    int getRendererHostScrollY();

    int getRendererHostWidth();

    View getView();

    void invalidateForRenderer();

    boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102);

    void requestLayoutForRenderer();

    void setClipChildrenForRenderer(boolean r100);

    void setRenderer(i r100);

    void setWillNotDrawForRenderer(boolean r100);
}
