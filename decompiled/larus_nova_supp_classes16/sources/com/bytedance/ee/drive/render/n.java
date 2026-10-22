package com.bytedance.ee.drive.render;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements k {
    public final k.a a;
    public final k.b b;
    public final k.e c;
    public final k.h d;
    public final k.f e;
    public final k.c f;
    public final k.d g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.g getTitleBar() {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L6;
        return new k.g(com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.mobile.doubao_drive_comment"), false);
    L6:
        return new k.g(true, true);
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.b a() {
        return this.b;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.d b() {
        return this.g;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.e c() {
        return this.c;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.c d() {
        return this.f;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.a getContainer() {
        return this.a;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.f getText() {
        return this.e;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.h getVideo() {
        return this.d;
    }

    public n(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this.a = new k.a(false);
        this.b = new k.b(xo5.a.a(17.0f), r8.getResources().getColor(2131108713), r8.getResources().getColor(2131103686), r8.getResources().getColor(2131105539));
        boolean r2 = true;
        this.c = new k.e(Boolean.valueOf(!com.bytedance.ee.bear.bizwidget.officesdk.a.a()));
        boolean r4 = com.bytedance.ee.bear.bizwidget.officesdk.a.a();     // Catch: Throwable -> L10
        boolean r5 = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.doubao_drive_media_preview_enable");     // Catch: Throwable -> L10
        if (r4 == false) goto L7;
        if (r5 == false) goto L7;
    L8:
        tt5.a.h("OfficeDriveUIConfig", "resolveVideoControlBarV2Enabled, v2Enabled=" + r2 + ", officeSpaceEnabled=" + r4 + ", mediaPreviewEnabled=" + r5);     // Catch: Throwable -> L10
    L12:
        this.d = new k.h(false, false, r2);
        this.e = new k.f(false);
        this.f = new k.c(com.bytedance.ee.bear.bizwidget.officesdk.a.a(), com.bytedance.ee.bear.bizwidget.officesdk.a.a(), 150);
        this.g = new k.d(false);
        return;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        tt5.a.e("OfficeDriveUIConfig", "resolveVideoControlBarV2Enabled failed, use legacy", th, false);
        r2 = false;
        goto L12
    }
}
