package com.bytedance.ee.bear.browser.plugin;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements vo5.a {
    public final /* synthetic */ PluginHost.a a;

    public final UserSession b() {
        return ((com.ss.android.lark.passportc.convention.a) e0c.k.a(this.a.getActivity().getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();
    }

    public h(PluginHost.a r1) {
        this.a = r1;
    }

    public final <T> T a(Class<T> r4) {
        UserSession r0 = b();
        return (T) e0c.k.b(((v) e0c.k.a(this.a.getActivity().getApplication(), v.class)).c(r0), r4);
    }
}
