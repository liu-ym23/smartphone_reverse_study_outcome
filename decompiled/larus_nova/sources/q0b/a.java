package q0b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;

/* JADX INFO: loaded from: classes35.dex */
public interface a {

    /* JADX INFO: renamed from: q0b.a$a, reason: collision with other inner class name */
    public interface InterfaceC7261a {
        void a(ChameleonWebView r100);

        void b(ChameleonWebView r100);
    }

    WebViewPoolConfig a();

    ChameleonWebView b(ChameleonConfig r100, Object r101);

    ChameleonWebView c(Object r100);

    ChameleonWebView d(Object r100);

    void destroyAll();

    ChameleonWebView detachWebView(Object r100);

    void e(ChameleonWebView r100);

    ChameleonWebView getOverMaxUsedWebView(int r100);

    int occupiedSize();

    int poolSize();
}
