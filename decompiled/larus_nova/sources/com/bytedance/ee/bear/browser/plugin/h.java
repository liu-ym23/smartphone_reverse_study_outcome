package com.bytedance.ee.bear.browser.plugin;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements vo5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginHost.a f216623a;

    @Override // vo5.a
    public final UserSession b() {
        return ((com.ss.android.lark.passportc.convention.a) e0c.k.a(this.f216623a.getActivity().getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();
    }

    public h(PluginHost.a r100) {
        this.f216623a = r100;
    }

    @Override // vo5.a
    public final <T> T a(Class<T> r100) {
        UserSession r101 = b();
        return (T) e0c.k.b(((v) e0c.k.a(this.f216623a.getActivity().getApplication(), v.class)).c(r101), r100);
    }
}
