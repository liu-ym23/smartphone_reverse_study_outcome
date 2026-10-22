package h85;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.lark.android.encryption.CipherManager;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class d1 implements com.bytedance.ee.bear.h {
    public final com.ss.android.lark.passportc.api.m a;

    public final void b() {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new z()).doOnNext(new a0()).subscribe(new on4.i(), new b0());
    }

    @Inject
    public d1(com.ss.android.lark.passportc.api.m r2) {
        this.a = null;
        this.a = r2;
        tt5.a.h("DriveInterfaceImpl", "init constructor");
    }

    public final void C0(final String r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new t0()).doOnNext(new v0(r3)).subscribe(new on4.i(), new w0());
    }

    public final void G(final ArrayList<String> r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new r()).doOnNext(new s(r3)).subscribe(new on4.i(), new t());
    }

    public final void G0(Bundle r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new l0()).subscribe(new m0(), new n0());
    }

    public final boolean h8(int r1) {
        return i75.i.a(r1);
    }

    public final void j0(final List<LocalSaveEntity> r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new c()).doOnNext(new n(r3)).subscribe(new y(), new j0());
    }

    public final void m0(final ImportFileEntity r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new a1()).doOnNext(new b1(r3)).subscribe(new on4.i(), new d());
    }

    public final void r(rf5.e r3) {
        final pc5.i.b r4 = (pc5.i.b) r3;
        Flowable.just("").subscribeOn(fo5.d.b()).map(new e0()).doOnNext(new f0(r4)).subscribe(new on4.i(), new g0());
    }

    public final boolean z(String r3) {
        return ((g85.b) o75.b.a().getMimeTypeManager()).o(r3, null);
    }

    public final Flowable<Boolean> D(final int r3, final ArrayList<DriveOfflineDoc> r4) {
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new r0()).flatMap(new s0(r3, r4));
    }

    public final Flowable<Long> P5(String r10, String r11) {
        return FileInfoPuller.V1((NetService) org.koin.java.a.a(NetService.class)).pull(new FileInfoV1Puller.Params(r10, null, r11, null, null, null)).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).map(new u0());
    }

    public final void W(final Context r3, final String r4, final boolean r5) {
        Flowable.just("").map(new x0()).doOnNext(new y0(r3, r4, r5)).subscribe(new on4.i(), new z0());
    }

    public final void g4(FragmentActivity r9, SpaceThirdPartyOpenEntity r10, Long r11) {
        if (r9 == null) goto L23;
        if (r11 == null) goto L26;
        s55.e r1 = new s55.e("DOWNLOAD", PermissionOperation.DOWNLOAD, r10.getFileId(), -1L);
        if (s55.a.a.k(r1, r9) == true) goto L10;
        tt5.a.h("DriveInterfaceImpl", "handlePermissionUiAction return false");
        return;
    L10:
        com.bytedance.ee.bear.middleground_permission_export.model.c r2 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.c.class);
        String r4 = r10.getFileId();
        Boolean r5 = Boolean.FALSE;
        boolean r7 = true;
        if (CipherManager.d() != 1) goto L14;
        r7 = false;
    L14:
        r2.m(null, r4, r5, null, Boolean.valueOf(r7));
        ((zk5.a) org.koin.java.a.a(zk5.a.class)).a(sbb.e.l.b, r10.getFileId(), "open_with_other_app");
        int r3 = r10.getBizType();
        monitor-enter(this);
        a95.a r6 = new a95.a(new o85.f(this.a.getSession()));     // Catch: Throwable -> L20
        monitor-exit(this);
        com.bytedance.ee.bear.drive.biz.external.f r8 = com.bytedance.ee.bear.drive.biz.external.f.e(r3, r9, r6);
        r8.o = new c1(r9);
        com.bytedance.ee.bear.drive.biz.external.a.C0122a r12 = new com.bytedance.ee.bear.drive.biz.external.a.C0122a();
        r12.b = r11.longValue();
        r12.a = r10.getFileId();
        r12.c = null;
        r12.d = r10.getMountPoint();
        r12.e = r10.getDownloadFrom();
        r12.f = r10.getBizScene();
        r12.g = r10.getWatermarkScene();
        r8.g(new com.bytedance.ee.bear.drive.biz.external.a(r12), null, "LARK-PSDA-ccm_drive_docx_fileblock_open_external");
        return;
    L20:
        th = move-exception;
        throw th;
    L26:
        return;
    }

    public final Flowable hc(final FragmentActivity r6, final SpaceThirdPartyOpenEntity r7, final Long r8) {
        if (r6 == null) goto L12;
        if (r8 == null) goto L12;
        s55.e r0 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, r7.getFileId(), -1L);
        if (s55.a.a.k(r0, r6) == true) goto L10;
        tt5.a.h("DriveInterfaceImpl", "handlerPermissionUiAction return false");
        return Flowable.just(Boolean.FALSE);
    L10:
        return new DriveSpaceFileAttachmentExecutor((NetService) org.koin.java.a.a(NetService.class)).a(r7.getFileId(), r7.getMountPoint(), r7.getFileName(), null).doOnError(new c0(r6, r7, r8)).map(new d0(r6));
    L12:
        return Flowable.just(Boolean.FALSE);
    }

    public final void j3(final boolean r3, final pw4.d r4, final com.bytedance.ee.bear.h.a r5) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new e()).doOnNext(new f(r3, r4, r5)).subscribe(new on4.i(), new g());
    }

    public final void m(final String r3, final String r4, rf5.e r5) {
        final pc5.i.b r6 = (pc5.i.b) r5;
        Flowable.just("").subscribeOn(fo5.d.b()).map(new h0()).doOnNext(new i0(r3, r4, r6)).subscribe(new on4.i(), new k0());
    }

    public final void D0(final Activity r3, final String r4, final String r5, final String r6) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new o0()).doOnNext(new p0(r3, r4, r5, r6)).subscribe(new on4.i(), new q0());
    }

    public final void J0(final String r3, final String r4, final Bundle r5, final int r6) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new k()).doOnNext(new l(r3, r4, r5, r6)).subscribe(new on4.i(), new m());
    }

    public final void r0(final String r3, final String r4, final Bundle r5, final int r6) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new h()).doOnNext(new i(r3, r4, r5, r6)).subscribe(new on4.i(), new j());
    }

    public final void E(final Activity r1, final String r2, String r3, final Bundle r4, int r5) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new o()).doOnNext(new p(r1, r2, r4)).subscribe(new on4.i(), new q());
    }

    public final void u(final Activity r1, final String r2, String r3, final Bundle r4, int r5) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new v()).doOnNext(new w(r1, r2, r4)).subscribe(new on4.i(), new x());
    }
}
