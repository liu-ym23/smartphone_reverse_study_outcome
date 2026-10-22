package com.bytedance.ee.bear.drive.biz.comment;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteData;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static InviteResult d(Throwable r2) {
        if ((r2 instanceof NetService.ServerErrorException) == true) goto L5;
        return null;
    L5:
        String r3 = ((NetService.ServerErrorException) r2).getJson();
        if (TextUtils.isEmpty(r3) == false) goto L17;
        return null;
    L17:
        InviteResult r4 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.h.a(r3);     // Catch: Exception -> L10
    L11:
        if (r4 != null) goto L13;
    L16:
        return null;
    L13:
        if (r4.getData() == null) goto L16;
        return r4;
    L10:
        r4 = null;
        goto L11
    }

    public static void a(FragmentActivity r5, List r6, AskOwnerModel.SendResult r7) {
        Toast.cancel();
        AskOwnerModel.ResultData r8 = r7.data;
        if (r8 != null) goto L8;
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResult, resultData is null, requestUserIds: " + r6);
        if (r5 == null) goto L33;
        Toast.showSuccessText(r5, 2131888116);
        return;
    L33:
        return;
    L8:
        HashMap r2 = r8.getFailMembers();
        if (CollectionUtils.isEmpty(r2) == false) goto L14;
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResult, failMembers is null, requestUserIds: " + r6);
        if (r5 == null) goto L34;
        Toast.showSuccessText(r5, 2131888116);
        return;
    L34:
        return;
    L14:
        List r3 = (List) r2.get(String.valueOf(ImportResult.STATUS_SHEET_IMPORT_EXCEED_IMAGE_LIMIT));
        if (CollectionUtils.isNotEmpty(r3) == false) goto L19;
        if (r5 == null) goto L19;
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResult, CAC blocked, requestUserIds: " + r6 + ", cacMembers: " + r3);
        Toast.showFailureText(r5, 2131889841);
        return;
    L19:
        List r4 = (List) r2.get(String.valueOf(ImportResult.STATUS_SHEET_CELL_CONTENT_TOO_LONG));
        if (CollectionUtils.isNotEmpty(r4) == false) goto L25;
        if (r5 == null) goto L25;
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResult, DLP blocked, requestUserIds: " + r6 + ", dlpMembers: " + r4);
        Toast.showFailureText(r5, 2131888962);
        return;
    L25:
        if (r8.getFailCount() > 0) goto L29;
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResult, all success, requestUserIds: " + r6);
        if (r5 == null) goto L35;
        Toast.showSuccessText(r5, 2131888116);
        return;
    L35:
        return;
    L29:
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResult, failed, requestUserIds: " + r6);
        if (r5 == null) goto L37;
        Toast.showFailureText(r5, 2131888113);
        return;
    }

    public static void b(FragmentActivity r5, List r6, AskOwnerModel.SendResult r7) {
        AskOwnerModel.ResultData r8 = r7.data;
        if (r8 != null) goto L6;
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResultIfAllFailed, resultData is null, requestUserIds: " + r6);
        return;
    L6:
        HashSet r1 = new HashSet();
        if (CollectionUtils.isNotEmpty(r8.getBlockMembers()) == false) goto L18;
        Iterator r2 = r8.getBlockMembers().values().iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        List r3 = (List) r2.next();
        if (r3 == null) goto L10;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L10;
        r1.add(((AskOwnerModel.BlockMember) r4.next()).getId());
    L18:
        if (CollectionUtils.isNotEmpty(r8.getFailMembers()) == false) goto L29;
        Iterator r9 = r8.getFailMembers().values().iterator();
    L21:
        if (r9.hasNext() == false) goto L29;
        List r10 = (List) r9.next();
        if (r10 == null) goto L21;
        Iterator r11 = r10.iterator();
    L26:
        if (r11.hasNext() == false) goto L21;
        r1.add(((AskOwnerModel.FailMember) r11.next()).getId());
    L29:
        if (r1.size() != r6.size()) goto L33;
        if (r5 == null) goto L45;
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResultIfAllFailed, all failed or blocked, requestUserIds=" + r6 + " | failAndBlockUserIds=" + r1);
        Toast.showFailureText(r5, 2131888113);
        return;
    L45:
        return;
    L33:
        tt5.a.h("DriveCommentRnHelper", "handleAskOwnerResultIfAllFailed: no toast, requestUserIds=" + r6.size() + " | failAndBlockUserIds=" + r1);
    }

    public static void c(FragmentActivity r7, List r8, InviteResult r9, String r10) {
        InviteData r11 = r9.getData();
        if (r11 != null) goto L6;
        tt5.a.h("DriveCommentRnHelper", "handleInviteCollaboratorResult, inviteResultData is null");
        m.a(r10, 0, "Success", r8, null);
        return;
    L6:
        ArrayList r4 = r11.conditionControlUsers;
        if (CollectionUtils.isNotEmpty(r4) == false) goto L20;
        ArrayList r12 = new ArrayList();
        ArrayList r0 = new ArrayList(r8);
        Iterator r13 = r4.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        NotNotifyUserEntity r1 = (NotNotifyUserEntity) r13.next();
        r0.remove(r1.getId());
        r12.add(r1.getId());
        goto L10
    L12:
        tt5.a.h("DriveCommentRnHelper", "handleInviteCollaboratorResult, cacBlockedUsers: " + r12 + ", cacNotBlockedUsers: " + r0);
        m.a(r10, -1, "CAC", r0, r12);
        if (CollectionUtils.isEmpty(r0) == false) goto L15;
        int r14 = 2131889842;
    L16:
        Toast.cancelLoading();
        if (r7 == null) goto L44;
        Toast.showFailureText(r7, r14);
        return;
    L44:
        return;
    L15:
        r14 = 2131889841;
        goto L16
    L20:
        ArrayList r5 = r11.dlpControlUsers;
        if (CollectionUtils.isNotEmpty(r5) == false) goto L35;
        ArrayList r16 = new ArrayList();
        ArrayList r2 = new ArrayList(r8);
        Iterator r17 = r5.iterator();
    L24:
        if (r17.hasNext() == false) goto L26;
        NotNotifyUserEntity r3 = (NotNotifyUserEntity) r17.next();
        r2.remove(r3.getId());
        r16.add(r3.getId());
        goto L24
    L26:
        tt5.a.h("DriveCommentRnHelper", "handleInviteCollaboratorResult, dlpBlockedUsers: " + r16 + ", dlpNotBlockedUsers: " + r2);
        m.a(r10, -1, "DLP", r2, r16);
        if (CollectionUtils.isEmpty(r2) == false) goto L29;
        int r18 = 2131888960;
    L30:
        Toast.cancelLoading();
        if (r7 == null) goto L45;
        Toast.showFailureText(r7, r18);
        return;
    L45:
        return;
    L29:
        r18 = 2131888962;
        goto L30
    L35:
        if (r11.getFailCount() > 0) goto L37;
        tt5.a.h("DriveCommentRnHelper", "handleInviteCollaboratorResult, all success.");
        m.a(r10, 0, "Success", r8, null);
        return;
    L37:
        tt5.a.h("DriveCommentRnHelper", "handleInviteCollaboratorResult, all failed.");
        if (r7 == null) goto L40;
        Toast.showFailureText(r7, 2131888198);
    L40:
        m.a(r10, -1, "AllFailed", null, r8);
    }
}
