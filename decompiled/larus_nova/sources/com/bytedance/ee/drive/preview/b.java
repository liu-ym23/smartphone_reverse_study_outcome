package com.bytedance.ee.drive.preview;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.j;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends c0c.b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f242692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f242693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.drive.preview.a f242694d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final Fragment Ae(DrivePreviewOpenRequest r100, List<? extends i> r101, hk5.a r102, com.bytedance.ee.bear.container.f r103) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return this.f242692b.Ae(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final boolean B1() {
        return this.f242692b.B1();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.c Jd() {
        return this.f242692b.Jd();
    }

    @Override // com.bytedance.ee.drive.preview.c
    public final j U4(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f242692b.U4(r100);
    }

    @Override // com.bytedance.ee.drive.preview.d
    @Deprecated(message = "use openPreviewFragment(request: DrivePreviewOpenRequest) instead")
    public final Fragment Z5(String r100, hk5.a r101, com.bytedance.ee.bear.container.f r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return this.f242692b.Z5(r100, r101, r102);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final int c3(String r100) {
        return this.f242692b.c3(r100);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsPreviewView> ca(int r100, z r101) {
        Intrinsics.checkNotNullParameter(r101, "previewFileModel");
        return this.f242692b.ca(r100, r101);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsLoadingView> f4(int r100, z r101) {
        Intrinsics.checkNotNullParameter(r101, "previewFileModel");
        return this.f242692b.f4(r100, r101);
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final DrivePreviewOpenRequest o9(DrivePreviewOpenRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return this.f242692b.o9(r100);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Map<String, String> oc(String r100) {
        return this.f242692b.oc(r100);
    }

    @Override // com.bytedance.ee.drive.preview.f
    public final void onDestroy() {
        this.f242692b.onDestroy();
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final boolean pa() {
        return this.f242692b.pa();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.a u8() {
        return this.f242692b.u8();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.b y7() {
        return this.f242692b.y7();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final o l6() {
        com.bytedance.ee.drive.preview.a r100 = this.f242694d;
        Object r101 = r100.f242682b;
        monitor-enter(r101);
        o r102 = r100.f242683c;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final void k1(o r100) {
        com.bytedance.ee.drive.preview.a r101 = this.f242694d;
        Object r102 = r101.f242682b;
        monitor-enter(r102);
        r101.f242681a.c().k1(r100);     // Catch: Throwable -> L7
        r101.f242683c = r100;     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("DrivePreviewServiceProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f242694d.f242681a.c().onDestroy();
    }

    public b(com.ss.android.lark.passportc.api.j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), f.class), f.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f242692b = (f) r103.b();
        this.f242693c = r101;
        this.f242694d = new com.bytedance.ee.drive.preview.a(r103);
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        tt5.a.h("DrivePreviewServiceProxy", "preparing");
        v r102 = this.f242693c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        f r104 = (f) k.b(r102.c(r103), f.class);
        com.bytedance.ee.drive.preview.a r105 = this.f242694d;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "newInstance");
        Object r106 = r105.f242682b;
        monitor-enter(r106);
        r104.k1(r105.f242683c);     // Catch: Throwable -> L12
        r105.f242681a.e(r104);     // Catch: Throwable -> L12
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r106);
        return;
    L12:
        th = move-exception;
        throw th;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
