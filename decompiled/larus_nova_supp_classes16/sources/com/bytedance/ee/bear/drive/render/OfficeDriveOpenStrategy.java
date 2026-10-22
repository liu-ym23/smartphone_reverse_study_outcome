package com.bytedance.ee.bear.drive.render;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.impl.SpaceFileLoader;
import com.bytedance.ee.drive.render.j;
import com.bytedance.ee.drive.render.k;
import com.bytedance.ee.drive.render.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeDriveOpenStrategy implements j {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    @Override // com.bytedance.ee.drive.render.j
    public final k b() {
        return (k) this.c.getValue();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final m d() {
        return (m) this.b.getValue();
    }

    @Override // com.bytedance.ee.drive.render.j
    public final o a() {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L6;
        return new a(this);
    L6:
        return b.a;
    }

    public OfficeDriveOpenStrategy(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(OfficeDriveOpenStrategy$driveConfigs$2.INSTANCE);
        this.b = LazyKt.lazy(OfficeDriveOpenStrategy$hostAbilityManager$2.INSTANCE);
        this.c = LazyKt.lazy(new OfficeDriveOpenStrategy$uiConfig$2(r2));
    }

    @Override // com.bytedance.ee.drive.render.j
    public final u75.b c(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        int r0 = r3.c.getBizType();
        if (r0 == 1) goto L9;
        if (r0 == 3) goto L11;
        return new SpaceFileLoader(r3);
    L11:
        return new com.bytedance.ee.bear.drive.loader.impl.a(r3);
    L9:
        return new com.bytedance.ee.bear.drive.loader.impl.b(r3);
    }
}
