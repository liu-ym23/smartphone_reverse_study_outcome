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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends c0c.b implements h {
    public final /* synthetic */ h b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<h> d;

    public final void C0(String r2) {
        this.b.C0(r2);
    }

    public final Flowable<Boolean> D(int r2, ArrayList<DriveOfflineDoc> r3) {
        return this.b.D(r2, r3);
    }

    public final void D0(Activity r2, String r3, String r4, String r5) {
        this.b.D0(r2, r3, r4, r5);
    }

    public final void E(Activity r7, String r8, String r9, Bundle r10, int r11) {
        this.b.E(r7, r8, FileInfoPuller.CALLER_EXPLORER, r10, 1033);
    }

    public final void G(ArrayList<String> r2) {
        this.b.G(r2);
    }

    public final void G0(Bundle r2) {
        this.b.G0(null);
    }

    public final void J0(String r2, String r3, Bundle r4, int r5) {
        this.b.J0(r2, r3, r4, r5);
    }

    public final Flowable<Long> P5(String r2, String r3) {
        return this.b.P5(r2, r3);
    }

    public final void W(Context r2, String r3, boolean r4) {
        this.b.W(r2, r3, r4);
    }

    public final void b() {
        this.b.b();
    }

    public final void g4(FragmentActivity r2, SpaceThirdPartyOpenEntity r3, Long r4) {
        this.b.g4(r2, r3, r4);
    }

    public final boolean h8(int r2) {
        return this.b.h8(r2);
    }

    public final Flowable hc(FragmentActivity r2, SpaceThirdPartyOpenEntity r3, Long r4) {
        return this.b.hc(r2, r3, r4);
    }

    public final void j0(List<LocalSaveEntity> r2) {
        this.b.j0(r2);
    }

    public final void j3(boolean r2, pw4.d r3, h.a r4) {
        this.b.j3(r2, r3, r4);
    }

    public final void m(String r2, String r3, rf5.e r4) {
        this.b.m(r2, r3, r4);
    }

    public final void m0(ImportFileEntity r2) {
        this.b.m0(r2);
    }

    public final void r(rf5.e r2) {
        this.b.r(r2);
    }

    public final void r0(String r2, String r3, Bundle r4, int r5) {
        this.b.r0(r2, r3, r4, r5);
    }

    public final void u(Activity r7, String r8, String r9, Bundle r10, int r11) {
        this.b.u(r7, r8, FileInfoPuller.CALLER_EXPLORER, r10, 1033);
    }

    public final boolean z(String r2) {
        return this.b.z(r2);
    }

    public b(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), h.class), h.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (h) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r1, g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        h r5 = (h) k.b(r3.c(r4), h.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
