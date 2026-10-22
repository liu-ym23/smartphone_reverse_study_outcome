package jg5;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.TransferApplyInfo;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.office.base.share.OfficeSdkSharePanelProvider;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s extends c0c.b implements cj5.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cj5.c f499030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f499031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<cj5.c> f499032d;

    public static final class a {
    }

    static {
    }

    @Override // cj5.c
    public final void B7(FragmentActivity r100, String r101) {
        this.f499030b.B7(r100, r101);
    }

    @Override // cj5.c
    public final void C8(Context r110, int r111, String r112, boolean r113, boolean r114, boolean r210, boolean r211, boolean r212, com.bytedance.ee.bear.middleground_permission_export.model.a r213, String r214, boolean r215, boolean r216) {
        this.f499030b.C8(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // cj5.c
    public final void Ee(th5.b r100) {
        this.f499030b.Ee(r100);
    }

    @Override // cj5.c
    public final void F0(FragmentActivity r100, String r101, int r110, String r111, String r112, String r113) {
        this.f499030b.F0(r100, r101, r110, r111, r112, r113);
    }

    @Override // cj5.c
    public final void G8(Context r100, String r101, int r102, int r103) {
        this.f499030b.G8(r100, r101, r102, r103);
    }

    @Override // cj5.c
    public final void H9(com.bytedance.ee.bear.share.export.i r100, SharePanelState r101, km5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        Intrinsics.checkNotNullParameter(r102, "p2");
        this.f499030b.H9(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void I5(OfficeSdkSharePanelProvider r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f499030b.I5(r100);
    }

    @Override // cj5.c
    public final View I7(FragmentActivity r110, int r111, String r112, String r113, String r114, FolderVersion r115, boolean r116, boolean r117, Fragment r210) {
        return this.f499030b.I7(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // cj5.c
    public final void O0(FragmentActivity r110, String r111, String r112, String r113, String r114, boolean r115, ArrayList<UserInfo> r116, ArrayList<UserInfo> r117) {
        this.f499030b.O0(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void R5(com.bytedance.ee.bear.share.export.l r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f499030b.R5(r100);
    }

    @Override // cj5.c
    public final View S7(Context r100, ShareParams r101, boolean r102, boolean r110, boolean r111) {
        return this.f499030b.S7(r100, r101, r102, r110, r111);
    }

    @Override // cj5.c
    public final View T8(Context r100, boolean r101, String r102) {
        return this.f499030b.T8(r100, r101, r102);
    }

    @Override // cj5.c
    public final DialogFragment Xe(FragmentActivity r100, boolean r101, int r102) {
        return this.f499030b.Xe(r100, r101, r102);
    }

    @Override // cj5.c
    public final void ad(FragmentActivity r110, String r111, int r112, String r113, String r114, int r210, String r211, String r212, SecretLevel r213, SecretApprovalDefModel r214, Map<String, Serializable> r215, SecretLevel r216) {
        this.f499030b.ad(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    @Override // cj5.c
    public final void c5(Context r100, String r101, int r102, String r110, Fragment r111) {
        this.f499030b.c5(r100, r101, r102, r110, r111);
    }

    @Override // cj5.c
    public final DialogFragment fa(ShareParams r100) {
        return this.f499030b.fa(r100);
    }

    @Override // cj5.c
    public final View g2(Context r100, ShareParams r101) {
        return this.f499030b.g2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final com.bytedance.ee.bear.share.export.o getProvider() {
        return this.f499030b.getProvider();
    }

    @Override // cj5.c
    public final void hb(Fragment r110, int r111, qe5.e.c r112, qe5.e.b r113, SecretApprovalInstanceModel r114, SecretApprovalDefModel r115, SecretLevel r116, SecretLevel r117) {
        this.f499030b.hb(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // cj5.c
    public final View i2(FragmentActivity r110, Fragment r111, int r112, String r113, String r210, String r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, ArrayList r218) {
        return this.f499030b.i2(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    @Override // cj5.c
    public final DialogFragment id(ShareParams r100, Bundle r101) {
        return this.f499030b.id(r100, r101);
    }

    @Override // cj5.c
    public final DialogFragment k6(FragmentActivity r110, String r111, int r112, DocMetaInfo r113, String r114, String r115, boolean r116, Fragment r117, boolean r210) {
        return this.f499030b.k6(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // cj5.c
    public final void l5(FragmentActivity r110, int r111, qe5.e.c r112, qe5.e.b r113, SecretApprovalInstanceModel r114, SecretApprovalDefModel r115, SecretLevel r116, SecretLevel r117) {
        this.f499030b.l5(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // cj5.c
    public final void le(Context r110, int r111, String r112, String r113, boolean r114, boolean r115, String r210, DialogInterface.OnClickListener r211, DialogInterface.OnClickListener r212, Integer r213, String r214) {
        this.f499030b.le(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    @Override // cj5.c
    public final View n6(Context r100, boolean r101) {
        return this.f499030b.n6(r100, r101);
    }

    @Override // cj5.c
    public final UDDialog nc(Context r100, String r101) {
        return this.f499030b.nc(r100, r101);
    }

    @Override // cj5.c
    public final void o6(FragmentActivity r100, String r101, int r102, String r110, String r111) {
        this.f499030b.o6(r100, r101, r102, r110, r111);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void ob(com.bytedance.ee.bear.share.export.l r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f499030b.ob(r100);
    }

    @Override // cj5.c
    public final DialogFragment r3(FragmentActivity r100, String r101, int r110, DocMetaInfo r111, String r112, String r113) {
        return this.f499030b.r3(r100, r101, r110, r111, r112, r113);
    }

    @Override // cj5.c
    public final void rb(Context r100, cj5.c.b r101, HashMap<String, Serializable> r102, Fragment r103) {
        this.f499030b.rb(r100, r101, r102, r103);
    }

    @Override // cj5.c
    public final View s7(Context r100, ShareParams r101) {
        return this.f499030b.s7(r100, r101);
    }

    @Override // cj5.c
    public final void w4(Fragment r110, String r111, int r112, String r113, String r114, int r115, String r210, SecretLevel r211, SecretApprovalDefModel r212, Map r213, SecretLevel r214) {
        this.f499030b.w4(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    @Override // cj5.c
    public final void wb(Context r100, TransferApplyInfo r101, Fragment r102, boolean r103) {
        this.f499030b.wb(r100, r101, r102, r103);
    }

    @Override // cj5.c
    public final void xe(FragmentActivity r110, Fragment r111, String r112, String r113, ArrayList r114, ArrayList r115, ArrayList r116, com.bytedance.ee.bear.bitable.lynx.pro.d r117) {
        this.f499030b.xe(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // cj5.c, com.bytedance.ee.bear.share.export.j
    public final DialogFragment E0(ShareParams r100) {
        Intrinsics.checkNotNullParameter(r100, "shareParams");
        return this.f499032d.c().E0(r100);
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("ShareUIServiceProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
    }

    public s(com.ss.android.lark.passportc.api.j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<cj5.c> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), cj5.c.class), cj5.c.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f499030b = r103.b();
        this.f499031c = r101;
        this.f499032d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        tt5.a.h("ShareUIServiceProxy", "preparing");
        v r102 = this.f499031c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        cj5.c r104 = (cj5.c) e0c.k.b(r102.c(r103), cj5.c.class);
        this.f499032d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }

    @Override // cj5.c
    public final DialogFragment N2(ShareParams r100, Bundle r101, com.bytedance.ee.bear.document.share.a.C3158a r102, ShareDocInfo r103) {
        return this.f499032d.c().N2(r100, r101, r102, r103);
    }
}
