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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends c0c.b implements w {
    public final /* synthetic */ w b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<w> d;

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void C0(String r2) {
        this.b.C0(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final Flowable<Boolean> D(int r2, ArrayList<DriveOfflineDoc> r3) {
        return this.b.D(r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void D0(Activity r2, String r3, String r4, String r5) {
        this.b.D0(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void E(Activity r7, String r8, String r9, Bundle r10, int r11) {
        this.b.E(r7, r8, r9, r10, r11);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void G(ArrayList<String> r2) {
        this.b.G(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void G0(Bundle r2) {
        this.b.G0(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void J0(String r2, String r3, Bundle r4, int r5) {
        this.b.J0(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void R0(d0 r2) {
        this.b.R0(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void W(Context r2, String r3, boolean r4) {
        this.b.W(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void b() {
        this.b.b();
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void i9(String r2, ArrayList<PreviewAction> r3) {
        this.b.i9(r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void kb(boolean r2, pw4.d r3, u r4) {
        this.b.kb(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final IPlayer l8(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return this.b.l8(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void m(String r2, String r3, rf5.e r4) {
        this.b.m(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void m0(ImportFileEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.b.m0(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final Flowable<Boolean> n7() {
        return this.b.n7();
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void onLoginStatusChangedEvent(int r2) {
        this.b.onLoginStatusChangedEvent(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void r(rf5.e r2) {
        this.b.r(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void r0(String r2, String r3, Bundle r4, int r5) {
        this.b.r0(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void u(Activity r7, String r8, String r9, Bundle r10, int r11) {
        this.b.u(r7, r8, r9, r10, r11);
    }

    public d(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<w> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), w.class), w.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (w) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r1, g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        w r5 = (w) k.b(r3.c(r4), w.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
