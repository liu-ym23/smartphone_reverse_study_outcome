package ed4;

import android.view.View;
import cd4.p;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public interface j extends id4.c, p {
    void a(l r100);

    void addWebViewScrollDelegate(f r100);

    String getContainerID();

    View getWebView();

    boolean isPreRender();

    void onHide();

    void onShow();

    void sendEvent(String r100, Object r101);

    void setWindowProps(Map<String, ? extends Object> r100);
}
