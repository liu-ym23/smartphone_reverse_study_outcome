package o85;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drive.services.d0;
import com.bytedance.ee.bear.drive.services.w;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import h85.u;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends c0c.b implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f522380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f522381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<w> f522382d;

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void C0(String r100) {
        this.f522380b.C0(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final Flowable<Boolean> D(int r100, ArrayList<DriveOfflineDoc> r101) {
        return this.f522380b.D(r100, r101);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void D0(Activity r100, String r101, String r102, String r103) {
        this.f522380b.D0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void E(Activity r100, String r101, String r102, Bundle r110, int r111) {
        this.f522380b.E(r100, r101, r102, r110, r111);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void G(ArrayList<String> r100) {
        this.f522380b.G(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void G0(Bundle r100) {
        this.f522380b.G0(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void J0(String r100, String r101, Bundle r102, int r103) {
        this.f522380b.J0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void R0(d0 r100) {
        this.f522380b.R0(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void W(Context r100, String r101, boolean r102) {
        this.f522380b.W(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void b() {
        this.f522380b.b();
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void i9(String r100, ArrayList<PreviewAction> r101) {
        this.f522380b.i9(r100, r101);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void kb(boolean r100, pw4.d r101, u r102) {
        this.f522380b.kb(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final IPlayer l8(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return this.f522380b.l8(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void m(String r100, String r101, rf5.e r102) {
        this.f522380b.m(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void m0(ImportFileEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f522380b.m0(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final Flowable<Boolean> n7() {
        return this.f522380b.n7();
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void onLoginStatusChangedEvent(int r100) {
        this.f522380b.onLoginStatusChangedEvent(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void r(rf5.e r100) {
        this.f522380b.r(r100);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void r0(String r100, String r101, Bundle r102, int r103) {
        this.f522380b.r0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void u(Activity r100, String r101, String r102, Bundle r110, int r111) {
        this.f522380b.u(r100, r101, r102, r110, r111);
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<w> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), w.class), w.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f522380b = r103.b();
        this.f522381c = r101;
        this.f522382d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f522381c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        w r104 = (w) k.b(r102.c(r103), w.class);
        this.f522382d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
