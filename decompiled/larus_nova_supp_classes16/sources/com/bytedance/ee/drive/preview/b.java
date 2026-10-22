package com.bytedance.ee.drive.preview;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.j;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends c0c.b implements f {
    public final /* synthetic */ f b;
    public final v c;
    public final com.bytedance.ee.drive.preview.a d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final Fragment Ae(DrivePreviewOpenRequest r2, List<? extends i> r3, hk5.a r4, com.bytedance.ee.bear.container.f r5) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return this.b.Ae(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final boolean B1() {
        return this.b.B1();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.c Jd() {
        return this.b.Jd();
    }

    @Override // com.bytedance.ee.drive.preview.c
    public final j U4(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.b.U4(r2);
    }

    @Override // com.bytedance.ee.drive.preview.d
    @Deprecated(message = "use openPreviewFragment(request: DrivePreviewOpenRequest) instead")
    public final Fragment Z5(String r2, hk5.a r3, com.bytedance.ee.bear.container.f r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return this.b.Z5(r2, r3, r4);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final int c3(String r2) {
        return this.b.c3(r2);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsPreviewView> ca(int r2, z r3) {
        Intrinsics.checkNotNullParameter(r3, "previewFileModel");
        return this.b.ca(r2, r3);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Class<? extends AbsLoadingView> f4(int r2, z r3) {
        Intrinsics.checkNotNullParameter(r3, "previewFileModel");
        return this.b.f4(r2, r3);
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final DrivePreviewOpenRequest o9(DrivePreviewOpenRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return this.b.o9(r2);
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final Map<String, String> oc(String r2) {
        return this.b.oc(r2);
    }

    @Override // com.bytedance.ee.drive.preview.f
    public final void onDestroy() {
        this.b.onDestroy();
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final boolean pa() {
        return this.b.pa();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.a u8() {
        return this.b.u8();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.b y7() {
        return this.b.y7();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final o l6() {
        com.bytedance.ee.drive.preview.a r0 = this.d;
        Object r1 = r0.b;
        monitor-enter(r1);
        o r2 = r0.c;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final void k1(o r4) {
        com.bytedance.ee.drive.preview.a r0 = this.d;
        Object r1 = r0.b;
        monitor-enter(r1);
        ((f) r0.a.c()).k1(r4);     // Catch: Throwable -> L7
        r0.c = r4;     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("DrivePreviewServiceProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
        ((f) this.d.a.c()).onDestroy();
    }

    public b(com.ss.android.lark.passportc.api.j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), f.class), f.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (f) r0.b();
        this.c = r5;
        this.d = new com.bytedance.ee.drive.preview.a(r0);
    }

    public final void qf(f0c.g r3, f0c.g r4) {
        tt5.a.h("DrivePreviewServiceProxy", "preparing");
        v r5 = this.c;
        if (r4 == null) goto L6;
        UserSession r6 = r4.b;
        if (r6 == null) goto L6;
    L7:
        f r7 = (f) k.b(r5.c(r6), f.class);
        com.bytedance.ee.drive.preview.a r8 = this.d;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r7, "newInstance");
        Object r0 = r8.b;
        monitor-enter(r0);
        r7.k1(r8.c);     // Catch: Throwable -> L12
        r8.a.e(r7);     // Catch: Throwable -> L12
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    L6:
        r6 = ContainerConstsKt.a();
        goto L7
    }
}
