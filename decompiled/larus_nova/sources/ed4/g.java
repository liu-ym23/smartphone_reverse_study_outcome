package ed4;

import android.view.View;
import cd4.m;
import cd4.p;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public interface g extends id4.c, p {
    void c(List<? extends m> r100);

    void f(b r100, i r101);

    String getContainerID();

    View getView();

    void h(i r100);

    void onHide();

    void onShow();

    void sendEvent(String r100, Object r101);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
