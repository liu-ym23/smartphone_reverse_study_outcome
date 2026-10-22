package com.bytedance.ee.drive.render;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements j {
    public final /* synthetic */ j a;
    public final /* synthetic */ o b;

    public static final class a implements o {
        public final /* synthetic */ o a;
        public final /* synthetic */ o b;

        public a(o r1, o r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.browser.plugin.o
        public final com.bytedance.ee.bear.browser.plugin.n a(PluginHost r3) {
            Intrinsics.checkNotNullParameter(r3, "host");
            return com.bytedance.ee.bear.browser.plugin.n.c(this.a.a(r3), this.b.a(r3));
        }
    }

    @Override // com.bytedance.ee.drive.render.j
    public final o a() {
        return new a(this.a.a(), this.b);
    }

    @Override // com.bytedance.ee.drive.render.j
    public final k b() {
        return this.a.b();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final m d() {
        return this.a.d();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final u75.b c(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return this.a.c(r2);
    }

    public d(j r1, o r2) {
        this.a = r1;
        this.b = r2;
    }
}
