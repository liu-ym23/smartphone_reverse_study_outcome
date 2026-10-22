package com.ss.android.lark.integrator.im.feed_shared.dependency;

import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements peb.b.InterfaceC7189b {
    public b() {
    }

    @Override // peb.b.InterfaceC7189b
    public final void a() {
    }

    @Override // peb.b.InterfaceC7189b
    public final void c() {
    }

    @Override // peb.b.InterfaceC7189b
    public final lpb.a b(com.ss.android.lark.feed.shared.data.appconfig.d r100) {
        opb.e r101 = opb.e.a.f524824a;
        opb.b r102 = r101.f524819d;
        jpb.a r103 = (jpb.a) ((ConcurrentHashMap) r101.b()).get(LarkSettingModuleDependency.CONFIG_KEY);
        r102.getClass();
        String r104 = LarkSettingModuleDependency.CONFIG_KEY.concat("_v1");
        if (r103 != null) goto L5;
    L8:
        String r105 = spb.a.b().getString(r104, "");
    L10:
        return r100.a(r105);
    L5:
        if (r103.f500011a == true) goto L8;
        r105 = spb.a.a().getString(r104, "");
        goto L10
    }
}
