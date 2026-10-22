package com.ss.android.lark.integrator.ccm.dependency.di;

import androidx.fragment.app.Fragment;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class e1 implements com.bytedance.ee.bear.lark.dependency.y {
    @Override // com.bytedance.ee.bear.lark.dependency.y
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.y
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.y
    public final void a() {
        tt5.a.h("OfficeOpenPlatformBrowserDependencyImpl", "openUrl...");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.y
    public final void d() {
        tt5.a.h("OfficeOpenPlatformBrowserDependencyImpl", "createWebContainerFragment with url is not supported in office");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.y
    public final Fragment e() {
        tt5.a.h("OfficeOpenPlatformBrowserDependencyImpl", "createBitableHomePageFragment is not supported in office");
        return new Fragment();
    }

    @Inject
    public e1() {
    }
}
