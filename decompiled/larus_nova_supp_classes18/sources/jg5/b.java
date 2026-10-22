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
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.office.base.share.OfficeSdkSharePanelProvider;
import com.ss.android.lark.utils.LarkContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements cj5.c {
    public com.bytedance.ee.bear.share.export.o a;

    public b() {
    }

    @Override // cj5.c
    public final void B7(FragmentActivity r1, String r2) {
    }

    @Override // cj5.c
    public final void C8(Context r1, int r2, String r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, com.bytedance.ee.bear.middleground_permission_export.model.a r9, String r10, boolean r11, boolean r12) {
    }

    @Override // cj5.c
    public final void Ee(th5.b r1) {
    }

    @Override // cj5.c
    public final void F0(FragmentActivity r1, String r2, int r3, String r4, String r5, String r6) {
    }

    @Override // cj5.c
    public final void G8(Context r1, String r2, int r3, int r4) {
    }

    @Override // cj5.c
    public final void H9(com.bytedance.ee.bear.share.export.i r2, SharePanelState r3, km5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "params");
    }

    @Override // cj5.c
    public final void O0(FragmentActivity r1, String r2, String r3, String r4, String r5, boolean r6, ArrayList<UserInfo> r7, ArrayList<UserInfo> r8) {
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void R5(com.bytedance.ee.bear.share.export.l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // cj5.c
    public final void ad(FragmentActivity r1, String r2, int r3, String r4, String r5, int r6, String r7, String r8, SecretLevel r9, SecretApprovalDefModel r10, Map<String, Serializable> r11, SecretLevel r12) {
    }

    @Override // cj5.c
    public final void c5(Context r1, String r2, int r3, String r4, Fragment r5) {
    }

    @Override // cj5.c
    public final void hb(Fragment r1, int r2, qe5.e.c r3, qe5.e.b r4, SecretApprovalInstanceModel r5, SecretApprovalDefModel r6, SecretLevel r7, SecretLevel r8) {
    }

    @Override // cj5.c
    public final void l5(FragmentActivity r1, int r2, qe5.e.c r3, qe5.e.b r4, SecretApprovalInstanceModel r5, SecretApprovalDefModel r6, SecretLevel r7, SecretLevel r8) {
    }

    @Override // cj5.c
    public final void le(Context r1, int r2, String r3, String r4, boolean r5, boolean r6, String r7, DialogInterface.OnClickListener r8, DialogInterface.OnClickListener r9, Integer r10, String r11) {
    }

    @Override // cj5.c
    public final void o6(FragmentActivity r1, String r2, int r3, String r4, String r5) {
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void ob(com.bytedance.ee.bear.share.export.l r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // cj5.c
    public final void rb(Context r1, cj5.c.b r2, HashMap<String, Serializable> r3, Fragment r4) {
    }

    @Override // cj5.c
    public final void w4(Fragment r1, String r2, int r3, String r4, String r5, int r6, String r7, SecretLevel r8, SecretApprovalDefModel r9, Map r10, SecretLevel r11) {
    }

    @Override // cj5.c
    public final void wb(Context r1, TransferApplyInfo r2, Fragment r3, boolean r4) {
    }

    @Override // cj5.c
    public final void xe(FragmentActivity r1, Fragment r2, String r3, String r4, ArrayList r5, ArrayList r6, ArrayList r7, com.bytedance.ee.bear.bitable.lynx.pro.d r8) {
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final com.bytedance.ee.bear.share.export.o getProvider() {
        com.bytedance.ee.bear.share.export.o r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new c();
    }

    @Override // cj5.c, com.bytedance.ee.bear.share.export.j
    public final DialogFragment E0(ShareParams r2) {
        Intrinsics.checkNotNullParameter(r2, "shareParams");
        tt5.a.h("ShareUIService", "stage=open result=unsupported reason=mock");
        return null;
    }

    @Override // com.bytedance.ee.bear.share.export.j
    public final void I5(OfficeSdkSharePanelProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // cj5.c
    public final DialogFragment fa(ShareParams r1) {
        return new DialogFragment();
    }

    @Override // cj5.c
    public final View g2(Context r1, ShareParams r2) {
        return new View(LarkContext.getApplication());
    }

    @Override // cj5.c
    public final DialogFragment id(ShareParams r1, Bundle r2) {
        return new DialogFragment();
    }

    @Override // cj5.c
    public final View n6(Context r1, boolean r2) {
        return new View(LarkContext.getApplication());
    }

    @Override // cj5.c
    public final UDDialog nc(Context r1, String r2) {
        return new LKUIDialog(LarkContext.getApplication());
    }

    @Override // cj5.c
    public final View s7(Context r1, ShareParams r2) {
        return new View(LarkContext.getApplication());
    }

    @Override // cj5.c
    public final View T8(Context r1, boolean r2, String r3) {
        return new View(LarkContext.getApplication());
    }

    @Override // cj5.c
    public final DialogFragment Xe(FragmentActivity r1, boolean r2, int r3) {
        return new DialogFragment();
    }

    @Override // cj5.c
    public final DialogFragment N2(ShareParams r1, Bundle r2, com.bytedance.ee.bear.document.share.a.a r3, ShareDocInfo r4) {
        return new DialogFragment();
    }

    @Override // cj5.c
    public final View S7(Context r1, ShareParams r2, boolean r3, boolean r4, boolean r5) {
        return new View(LarkContext.getApplication());
    }

    @Override // cj5.c
    public final DialogFragment r3(FragmentActivity r1, String r2, int r3, DocMetaInfo r4, String r5, String r6) {
        return new DialogFragment();
    }

    @Override // cj5.c
    public final View I7(FragmentActivity r1, int r2, String r3, String r4, String r5, FolderVersion r6, boolean r7, boolean r8, Fragment r9) {
        return new View(LarkContext.getApplication());
    }

    @Override // cj5.c
    public final DialogFragment k6(FragmentActivity r1, String r2, int r3, DocMetaInfo r4, String r5, String r6, boolean r7, Fragment r8, boolean r9) {
        return new DialogFragment();
    }

    @Override // cj5.c
    public final View i2(FragmentActivity r1, Fragment r2, int r3, String r4, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, ArrayList r13) {
        return new View(LarkContext.getApplication());
    }
}
