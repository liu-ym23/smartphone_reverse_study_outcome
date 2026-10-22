package pfc;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public interface k {

    public interface a {
    }

    void a();

    void b();

    void c(RectF r100, boolean r101);

    void create();

    boolean d();

    void destroy();

    View getEditView();

    RectF getLocation();

    void restart();

    void setImageBitmap(Bitmap r100);

    void setPluginContext(a r100);

    void stop();
}
