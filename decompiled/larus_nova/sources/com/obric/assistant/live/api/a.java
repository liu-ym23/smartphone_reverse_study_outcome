package com.obric.assistant.live.api;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.assistant.live.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes33.dex */
    public static final class C4612a {
        public static /* synthetic */ void a(a r100, boolean r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            r101 = false;
        L5:
            r100.n(false, r101);
        }
    }

    boolean a();

    void b();

    boolean c(ObricInteractionScene r100);

    void collapseNotificationPanel();

    void d(Context r100, ObricInteractionScene r101, boolean r102);

    boolean e();

    void f(boolean r100);

    void g(Message r100);

    void h(Context r100, ObricState r101);

    void i();

    void init();

    void j();

    void k();

    void l(boolean r100);

    void m(boolean r100);

    void n(boolean r100, boolean r101);

    void o(Context r100, ObricInteractionScene r101, boolean r102, String r103);

    void p();

    void q(Context r100);

    void r(boolean r100);

    boolean s(ObricInteractionScene r100);
}
