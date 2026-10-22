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
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.office.base.share.OfficeSdkSharePanelProvider;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s extends c0c.b implements cj5.c {
    public final /* synthetic */ cj5.c b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<cj5.c> d;

    public static final class a {
    }

    static {
    }

    @Override // cj5.c
    public final void B7(FragmentActivity r2, String r3) {
        this.b.B7(r2, r3);
    }

    @Override // cj5.c
    public final void C8(Context r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, com.bytedance.ee.bear.middleground_permission_export.model.a r23, String r24, boolean r25, boolean r26) {
        this.b.C8(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    @Override // cj5.c
    public final void Ee(th5.b r2) {
        this.b.Ee(r2);
    }

    @Override // cj5.c
    public final void F0(FragmentActivity r8, String r9, int r10, String r11, String r12, String r13) {
        this.b.F0(r8, r9, r10, r11, r12, r13);
    }

    @Override // cj5.c
    public final void G8(Context r2, String r3, int r4, int r5) {
        this.b.G8(r2, r3, r4, r5);
    }

    @Override // cj5.c
    public final void H9(com.bytedance.ee.bear.share.export.i r2, SharePanelState r3, km5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        Intrinsics.checkNotNullParameter(r4, "p2");
        this.b.H9(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void I5(OfficeSdkSharePanelProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.b.I5(r2);
    }

    @Override // cj5.c
    public final View I7(FragmentActivity r12, int r13, String r14, String r15, String r16, FolderVersion r17, boolean r18, boolean r19, Fragment r20) {
        return this.b.I7(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // cj5.c
    public final void O0(FragmentActivity r11, String r12, String r13, String r14, String r15, boolean r16, ArrayList<UserInfo> r17, ArrayList<UserInfo> r18) {
        this.b.O0(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void R5(com.bytedance.ee.bear.share.export.l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.R5(r2);
    }

    @Override // cj5.c
    public final View S7(Context r7, ShareParams r8, boolean r9, boolean r10, boolean r11) {
        return this.b.S7(r7, r8, r9, r10, r11);
    }

    @Override // cj5.c
    public final View T8(Context r2, boolean r3, String r4) {
        return this.b.T8(r2, r3, r4);
    }

    @Override // cj5.c
    public final DialogFragment Xe(FragmentActivity r2, boolean r3, int r4) {
        return this.b.Xe(r2, r3, r4);
    }

    @Override // cj5.c
    public final void ad(FragmentActivity r15, String r16, int r17, String r18, String r19, int r20, String r21, String r22, SecretLevel r23, SecretApprovalDefModel r24, Map<String, Serializable> r25, SecretLevel r26) {
        this.b.ad(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    @Override // cj5.c
    public final void c5(Context r7, String r8, int r9, String r10, Fragment r11) {
        this.b.c5(r7, r8, r9, r10, r11);
    }

    @Override // cj5.c
    public final DialogFragment fa(ShareParams r2) {
        return this.b.fa(r2);
    }

    @Override // cj5.c
    public final View g2(Context r2, ShareParams r3) {
        return this.b.g2(r2, r3);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final com.bytedance.ee.bear.share.export.o getProvider() {
        return this.b.getProvider();
    }

    @Override // cj5.c
    public final void hb(Fragment r11, int r12, qe5.e.c r13, qe5.e.b r14, SecretApprovalInstanceModel r15, SecretApprovalDefModel r16, SecretLevel r17, SecretLevel r18) {
        this.b.hb(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // cj5.c
    public final View i2(FragmentActivity r16, Fragment r17, int r18, String r19, String r20, String r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, ArrayList r28) {
        return this.b.i2(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    @Override // cj5.c
    public final DialogFragment id(ShareParams r2, Bundle r3) {
        return this.b.id(r2, r3);
    }

    @Override // cj5.c
    public final DialogFragment k6(FragmentActivity r12, String r13, int r14, DocMetaInfo r15, String r16, String r17, boolean r18, Fragment r19, boolean r20) {
        return this.b.k6(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // cj5.c
    public final void l5(FragmentActivity r11, int r12, qe5.e.c r13, qe5.e.b r14, SecretApprovalInstanceModel r15, SecretApprovalDefModel r16, SecretLevel r17, SecretLevel r18) {
        this.b.l5(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // cj5.c
    public final void le(Context r14, int r15, String r16, String r17, boolean r18, boolean r19, String r20, DialogInterface.OnClickListener r21, DialogInterface.OnClickListener r22, Integer r23, String r24) {
        this.b.le(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // cj5.c
    public final View n6(Context r2, boolean r3) {
        return this.b.n6(r2, r3);
    }

    @Override // cj5.c
    public final UDDialog nc(Context r2, String r3) {
        return this.b.nc(r2, r3);
    }

    @Override // cj5.c
    public final void o6(FragmentActivity r7, String r8, int r9, String r10, String r11) {
        this.b.o6(r7, r8, r9, r10, r11);
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void ob(com.bytedance.ee.bear.share.export.l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.ob(r2);
    }

    @Override // cj5.c
    public final DialogFragment r3(FragmentActivity r8, String r9, int r10, DocMetaInfo r11, String r12, String r13) {
        return this.b.r3(r8, r9, r10, r11, r12, r13);
    }

    @Override // cj5.c
    public final void rb(Context r2, cj5.c.b r3, HashMap<String, Serializable> r4, Fragment r5) {
        this.b.rb(r2, r3, r4, r5);
    }

    @Override // cj5.c
    public final View s7(Context r2, ShareParams r3) {
        return this.b.s7(r2, r3);
    }

    @Override // cj5.c
    public final void w4(Fragment r14, String r15, int r16, String r17, String r18, int r19, String r20, SecretLevel r21, SecretApprovalDefModel r22, Map r23, SecretLevel r24) {
        this.b.w4(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // cj5.c
    public final void wb(Context r2, TransferApplyInfo r3, Fragment r4, boolean r5) {
        this.b.wb(r2, r3, r4, r5);
    }

    @Override // cj5.c
    public final void xe(FragmentActivity r11, Fragment r12, String r13, String r14, ArrayList r15, ArrayList r16, ArrayList r17, com.bytedance.ee.bear.bitable.lynx.pro.d r18) {
        this.b.xe(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // cj5.c, com.bytedance.ee.bear.share.export.j
    public final DialogFragment E0(ShareParams r2) {
        Intrinsics.checkNotNullParameter(r2, "shareParams");
        return ((cj5.c) this.d.c()).E0(r2);
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("ShareUIServiceProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
    }

    public s(com.ss.android.lark.passportc.api.j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<cj5.c> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), cj5.c.class), cj5.c.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (cj5.c) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        tt5.a.h("ShareUIServiceProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        cj5.c r6 = (cj5.c) e0c.k.b(r4.c(r5), cj5.c.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }

    @Override // cj5.c
    public final DialogFragment N2(ShareParams r2, Bundle r3, com.bytedance.ee.bear.document.share.a.a r4, ShareDocInfo r5) {
        return ((cj5.c) this.d.c()).N2(r2, r3, r4, r5);
    }
}
