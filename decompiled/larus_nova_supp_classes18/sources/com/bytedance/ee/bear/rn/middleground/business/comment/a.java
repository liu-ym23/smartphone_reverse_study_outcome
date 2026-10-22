package com.bytedance.ee.bear.rn.middleground.business.comment;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.drive.biz.comment.a1;
import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.drive.biz.comment.f1;
import com.bytedance.ee.bear.drive.biz.comment.m;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentMentionAuthorize$Request;
import com.bytedance.ee.bear.middleground.comment.export.q;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import idb.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements vl5.a {
    public final /* synthetic */ CommentSDK a;
    public final /* synthetic */ q b;

    public a(CommentSDK r1, f1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // vl5.a
    public final void a(vl5.c r9, JSONObject r10) {
        if (r9.a != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("comment", r10.getString("business")) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r10.getJSONObject(WikiFolderPushPlugin.DATA).getString(WikiFolderPushPlugin.OPT), "addAuthorizePermissionIfNeeded") == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r10.getJSONObject(WikiFolderPushPlugin.DATA).getJSONObject("identifier").getString(ResourceData.KEY_TOKEN), this.a.a) == false) goto L53;
        f1 r0 = this.b;
        String r11 = JSON.toJSONString(r10, true);
        f1 r1 = r0;
        if (r1.a.a == false) goto L14;
        tt5.a.b("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver, data: " + r11);
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L48;
    L25:
        CommentMentionAuthorize$Request r12 = null;
    L26:
        if (r12 == null) goto L58;
        List<String> r13 = r12.getUserIds();
        if (r13 != null) goto L31;
        tt5.a.k("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver, no request userId.");
        m.a(r12.getCallbackId(), 0, "Success", null, null);
        return;
    L31:
        u55.b r5 = (u55.b) r1.a.G.livePerm().getValue();
        if (r5 == null) goto L34;
        IDocUserPermission r6 = r5.b.a;
    L35:
        if (r6 != null) goto L37;
    L43:
        boolean r7 = f.a().isCurrentEnable("ccm.mobile.comment_batch_askowner");
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver, no permission to manage collaborator, requestUserIds: " + r13 + ", isBatchAskOwnerEnable: " + r7);
        if (r7 == false) goto L46;
        m.a(r12.getCallbackId(), 0, "Success", null, null);
        a1.d(r1.a, r13);
        return;
    L46:
        m.a(r12.getCallbackId(), 0, "Success", null, r13);
        return;
    L37:
        if (r6.canManageCollaborator() == false) goto L43;
        if (r1.a.c != null) goto L42;
        tt5.a.k("DriveCommentWrapper", "setupAuthorizeListener - AuthorizeObserver, mComment is null");
        m.a(r12.getCallbackId(), 0, "Success", null, null);
        return;
    L42:
        tt5.a.h("DriveCommentWrapper", "setupAuthorizeListener - onReceive, requestUserIds: " + r13);
        r1.a.c.m(r13, new e1(r1, r13, r12));
        return;
    L34:
        r6 = null;
        goto L35
    L58:
        return;
    L48:
        org.json.JSONObject r14 = new org.json.JSONObject(r11).optJSONObject(WikiFolderPushPlugin.DATA);
        if (r14 == null) goto L25;
        String r15 = r14.optString("body");
        if (TextUtils.isEmpty(r15) == true) goto L25;
        r12 = (CommentMentionAuthorize$Request) JSON.parseObject(r15, CommentMentionAuthorize$Request.class);
        goto L26
    }
}
