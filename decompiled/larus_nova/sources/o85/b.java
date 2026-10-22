package o85;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.h;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends c0c.b implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f522376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f522377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<h> f522378d;

    @Override // com.bytedance.ee.bear.h
    public final void C0(String r100) {
        this.f522376b.C0(r100);
    }

    @Override // com.bytedance.ee.bear.h
    public final Flowable<Boolean> D(int r100, ArrayList<DriveOfflineDoc> r101) {
        return this.f522376b.D(r100, r101);
    }

    @Override // com.bytedance.ee.bear.h
    public final void D0(Activity r100, String r101, String r102, String r103) {
        this.f522376b.D0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.h
    public final void E(Activity r100, String r101, String r102, Bundle r110, int r111) {
        this.f522376b.E(r100, r101, FileInfoPuller.CALLER_EXPLORER, r110, 1033);
    }

    @Override // com.bytedance.ee.bear.h
    public final void G(ArrayList<String> r100) {
        this.f522376b.G(r100);
    }

    @Override // com.bytedance.ee.bear.h
    public final void G0(Bundle r100) {
        this.f522376b.G0(null);
    }

    @Override // com.bytedance.ee.bear.h
    public final void J0(String r100, String r101, Bundle r102, int r103) {
        this.f522376b.J0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.h
    public final Flowable<Long> P5(String r100, String r101) {
        return this.f522376b.P5(r100, r101);
    }

    @Override // com.bytedance.ee.bear.h
    public final void W(Context r100, String r101, boolean r102) {
        this.f522376b.W(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.h
    public final void b() {
        this.f522376b.b();
    }

    @Override // com.bytedance.ee.bear.h
    public final void g4(FragmentActivity r100, SpaceThirdPartyOpenEntity r101, Long r102) {
        this.f522376b.g4(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.h
    public final boolean h8(int r100) {
        return this.f522376b.h8(r100);
    }

    @Override // com.bytedance.ee.bear.h
    public final Flowable hc(FragmentActivity r100, SpaceThirdPartyOpenEntity r101, Long r102) {
        return this.f522376b.hc(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.h
    public final void j0(List<LocalSaveEntity> r100) {
        this.f522376b.j0(r100);
    }

    @Override // com.bytedance.ee.bear.h
    public final void j3(boolean r100, pw4.d r101, h.a r102) {
        this.f522376b.j3(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.h
    public final void m(String r100, String r101, rf5.e r102) {
        this.f522376b.m(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.h
    public final void m0(ImportFileEntity r100) {
        this.f522376b.m0(r100);
    }

    @Override // com.bytedance.ee.bear.h
    public final void r(rf5.e r100) {
        this.f522376b.r(r100);
    }

    @Override // com.bytedance.ee.bear.h
    public final void r0(String r100, String r101, Bundle r102, int r103) {
        this.f522376b.r0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.h
    public final void u(Activity r100, String r101, String r102, Bundle r110, int r111) {
        this.f522376b.u(r100, r101, FileInfoPuller.CALLER_EXPLORER, r110, 1033);
    }

    @Override // com.bytedance.ee.bear.h
    public final boolean z(String r100) {
        return this.f522376b.z(r100);
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), h.class), h.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f522376b = r103.b();
        this.f522377c = r101;
        this.f522378d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f522377c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        h r104 = (h) k.b(r102.c(r103), h.class);
        this.f522378d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
