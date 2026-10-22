package com.bytedance.ee.bear.drive.config.strategy;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.impl.SpaceFileLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class LarkDriveOpenStrategy implements com.bytedance.ee.drive.render.j {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    @Override // com.bytedance.ee.drive.render.j
    public final o a() {
        return (o75.d) this.a.getValue();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final com.bytedance.ee.drive.render.k b() {
        return (com.bytedance.ee.drive.render.k) this.c.getValue();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final com.bytedance.ee.drive.render.m d() {
        return (com.bytedance.ee.drive.render.m) this.b.getValue();
    }

    public LarkDriveOpenStrategy(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(LarkDriveOpenStrategy$driveConfigs$2.INSTANCE);
        this.b = LazyKt.lazy(LarkDriveOpenStrategy$hostAbilityManager$2.INSTANCE);
        this.c = LazyKt.lazy(new LarkDriveOpenStrategy$uiConfig$2(r2));
    }

    @Override // com.bytedance.ee.drive.render.j
    public final u75.b c(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginHost");
        ((o75.d) this.a.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r4, "host");
        int r0 = r4.c.getBizType();
        tt5.a.h("DriveComponent", "getFileLoader() bizType=" + r0);
        if (r0 == 1) goto L9;
        if (r0 == 3) goto L11;
        return new SpaceFileLoader(r4);
    L11:
        return new com.bytedance.ee.bear.drive.loader.impl.a(r4);
    L9:
        return new com.bytedance.ee.bear.drive.loader.impl.b(r4);
    }
}
