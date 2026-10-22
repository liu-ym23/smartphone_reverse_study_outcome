package com.bytedance.ee.drive.render;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f242727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f242728b;

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f242729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f242730b;

        public a(o r100, o r101) {
            this.f242729a = r100;
            this.f242730b = r101;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.o
        public final com.bytedance.ee.bear.browser.plugin.n a(PluginHost r100) {
            Intrinsics.checkNotNullParameter(r100, "host");
            return com.bytedance.ee.bear.browser.plugin.n.c(this.f242729a.a(r100), this.f242730b.a(r100));
        }
    }

    @Override // com.bytedance.ee.drive.render.j
    public final o a() {
        return new a(this.f242727a.a(), this.f242728b);
    }

    @Override // com.bytedance.ee.drive.render.j
    public final k b() {
        return this.f242727a.b();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final m d() {
        return this.f242727a.d();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final u75.b c(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        return this.f242727a.c(r100);
    }

    public d(j r100, o r101) {
        this.f242727a = r100;
        this.f242728b = r101;
    }
}
