package com.bytedance.ee.drive.render;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k.a f242755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k.b f242756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k.e f242757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k.h f242758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k.f f242759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k.c f242760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k.d f242761g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.g getTitleBar() {
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L6;
        return new k.g(com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.mobile.doubao_drive_comment"), false);
    L6:
        return new k.g(true, true);
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.b a() {
        return this.f242756b;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.d b() {
        return this.f242761g;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.e c() {
        return this.f242757c;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.c d() {
        return this.f242760f;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.a getContainer() {
        return this.f242755a;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.f getText() {
        return this.f242759e;
    }

    @Override // com.bytedance.ee.drive.render.k
    public final k.h getVideo() {
        return this.f242758d;
    }

    public n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f242755a = new k.a(false);
        this.f242756b = new k.b(xo5.a.a(17.0f), r100.getResources().getColor(R.color.ud_N1000), r100.getResources().getColor(R.color.neutral_transparent_2), r100.getResources().getColor(R.color.primary_50));
        boolean r101 = true;
        this.f242757c = new k.e(Boolean.valueOf(!com.bytedance.ee.bear.bizwidget.officesdk.a.a()));
        boolean r102 = com.bytedance.ee.bear.bizwidget.officesdk.a.a();     // Catch: Throwable -> L10
        boolean r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.doubao_drive_media_preview_enable");     // Catch: Throwable -> L10
        if (r102 == false) goto L7;
        if (r103 == false) goto L7;
    L8:
        tt5.a.h("OfficeDriveUIConfig", "resolveVideoControlBarV2Enabled, v2Enabled=" + r101 + ", officeSpaceEnabled=" + r102 + ", mediaPreviewEnabled=" + r103);     // Catch: Throwable -> L10
    L12:
        this.f242758d = new k.h(false, false, r101);
        this.f242759e = new k.f(false);
        this.f242760f = new k.c(com.bytedance.ee.bear.bizwidget.officesdk.a.a(), com.bytedance.ee.bear.bizwidget.officesdk.a.a(), 150);
        this.f242761g = new k.d(false);
        return;
    L7:
        r101 = false;
    L10:
        th = move-exception;
        tt5.a.e("OfficeDriveUIConfig", "resolveVideoControlBarV2Enabled failed, use legacy", th, false);
        r101 = false;
        goto L12
    }
}
