package e19;

import android.content.Context;
import android.view.View;
import com.larus.common_ui.floatwindow.manager.FloatPriority;
import java.util.List;

/* JADX INFO: loaded from: classes27.dex */
public interface h {
    void a();

    void b();

    int c();

    List<String> d();

    void e(boolean r100);

    boolean f();

    boolean g();

    View getContentView();

    int getHeight();

    FloatPriority getPriority();

    int getWidth();

    f h();

    boolean i();

    void j(b r100);

    String k();

    View l(Context r100);

    boolean n0();

    void onWindowDismiss();

    void onWindowShow();

    void setHeight(int r100);

    void setWidth(int r100);
}
