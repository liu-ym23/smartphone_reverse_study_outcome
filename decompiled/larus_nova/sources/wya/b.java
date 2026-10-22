package wya;

import android.view.View;
import wya.c;

/* JADX INFO: loaded from: classes34.dex */
public interface b<T extends c> {
    void a(com.ss.android.lark.chat.chatwindow.biz.component.banner.c r100);

    void b(boolean r100);

    void c(View r100, T r101);

    void d(T r100);

    void destroy();

    int e();

    View getBanner();

    int getLayoutId();

    void getListener();

    int getPriority();

    int getType();

    boolean isEnabled();

    boolean isShown();
}
