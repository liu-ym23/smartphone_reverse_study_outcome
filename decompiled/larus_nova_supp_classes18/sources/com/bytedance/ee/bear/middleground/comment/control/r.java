package com.bytedance.ee.bear.middleground.comment.control;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAreaMark;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.PermMember;
import com.bytedance.ee.bear.middleground.comment.export.bean.PermMemberBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.export.bean.VisibilityBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements a0 {
    public final tb5.m a;

    public static final class a {
    }

    public static final class b {
        public final JSONObject a;

        public final String b() {
            return this.a.toString();
        }

        public b() {
            this.a = new JSONObject();
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "action");
            this.a.put("action", r3);
        }

        public final void c(List r13) {
            JSONArray r0 = new JSONArray();
            if (r13 == null) goto L5;
            int r2 = r13.size();
        L6:
            if (r2 <= 0) goto L18;
            Intrinsics.checkNotNull(r13);
            Iterator r14 = r13.iterator();
        L9:
            if (r14.hasNext() == false) goto L18;
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r3 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r14.next();
            JSONObject r4 = new JSONObject();
            r4.put("uuid", r3.getUuid());
            r4.put("src", r3.getSrc());
            r4.put(ResourceData.KEY_TOKEN, r3.getToken());
            JSONArray r5 = new JSONArray();
            Iterator<T> r6 = r3.getAreaMark().iterator();
        L12:
            if (r6.hasNext() == false) goto L17;
            CommentAreaMark r7 = (CommentAreaMark) r6.next();
            JSONObject r8 = new JSONObject();
            JSONArray r9 = new JSONArray();
            float[] r10 = r7.getAreaData();
            int r11 = r10.length;
            int r12 = 0;
        L14:
            if (r12 >= r11) goto L16;
            r9.put(Float.valueOf(r10[r12]));
            r12 = r12 + 1;
            goto L14
        L16:
            r8.put("area_data", r9);
            r8.put("create_timestamp", r7.getCreateTimeStamp());
            r8.put("area_uuid", r7.getAreaUUID());
            r8.put("user_id", r7.getUserId());
            r8.put("user_name", r7.getUserName());
            r5.put(r8);
            goto L12
        L17:
            r4.put("areaMark", r5);
            r0.put(r4);
        L18:
            this.a.put("imageList", r0);
            return;
        L5:
            r2 = 0;
            goto L6
        }

        public final void d(SmartReplyDataForInsert r4) {
            if (r4 == null) goto L5;
            JSONObject r0 = new JSONObject();
            r0.put("text", r4.getText());
            r0.put("comment_id", r4.getCommentId());
            r0.put("reply_id", r4.getReplyId());
            r0.put("ai_reply_id", r4.getAiReplyId());
            this.a.put("smartReplyData", r0);
            return;
        }

        public final void e(VisibilityBean r11) {
            Intrinsics.checkNotNullParameter(r11, "visibility");
            JSONObject r1 = new JSONObject();
            r1.put(ResourceData.KEY_TYPE, r11.getType());
            JSONArray r2 = new JSONArray();
            PermMemberBean r3 = r11.getPermissionMembers();
            if (r3 == null) goto L10;
            ArrayList<PermMember> r4 = r3.getBefore();
            if (r4 == null) goto L10;
            Iterator<T> r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            PermMember r7 = (PermMember) r5.next();
            JSONObject r8 = new JSONObject();
            r8.put("ownerId", r7.getOwnerId());
            r8.put("ownerType", r7.getOwnerType());
            r8.put("permission", r7.getPermission());
            r2.put(r8);
        L10:
            JSONArray r6 = new JSONArray();
            PermMemberBean r12 = r11.getPermissionMembers();
            if (r12 == null) goto L18;
            ArrayList<PermMember> r13 = r12.getAfter();
            if (r13 == null) goto L18;
            Iterator<T> r14 = r13.iterator();
        L16:
            if (r14.hasNext() == false) goto L18;
            PermMember r9 = (PermMember) r14.next();
            JSONObject r10 = new JSONObject();
            r10.put("ownerId", r9.getOwnerId());
            r10.put("ownerType", r9.getOwnerType());
            r10.put("permission", r9.getPermission());
            r6.put(r10);
        L18:
            JSONObject r15 = new JSONObject();
            r15.put("before", r2);
            r15.put("after", r6);
            r1.put("permissionMembers", r15);
            this.a.put("visibility", r1);
        }
    }

    static {
    }

    public r(tb5.m r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        tt5.a.h("Comment#CommentWebSdkImpl", "applyRevision()... commentId = " + r5);
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter("applyRevision", "action");
        r1.put("action", "applyRevision");
        Intrinsics.checkNotNullParameter(r5, "commentId");
        r1.put("commentId", r5);
        r1.put("commentType", 2);
        this.a.onCallBack(r1.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        tt5.a.h("Comment#CommentWebSdkImpl", "rejectRevision()... commentId = " + r5);
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter("rejectRevision", "action");
        r1.put("action", "rejectRevision");
        Intrinsics.checkNotNullParameter(r5, "commentId");
        r1.put("commentId", r5);
        r1.put("commentType", 2);
        this.a.onCallBack(r1.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void b(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        Intrinsics.checkNotNullParameter(r7, "userName");
        tt5.a.h("Comment#CommentWebSdkImpl", "clickMentionUser()...");
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter("clickMentionUser", "action");
        r2.put("action", "clickMentionUser");
        Intrinsics.checkNotNullParameter("userId", "key");
        if (r6 == null) goto L5;
        r2.put("userId", r6);
    L5:
        Intrinsics.checkNotNullParameter("userName", "key");
        if (r7 == null) goto L8;
        r2.put("userName", r7);
    L8:
        String r8 = r2.toString();
        this.a.onCallBack(r8);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void c(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r7, "replyId");
        tt5.a.h("Comment#CommentWebSdkImpl", "showSmartReply()... replyId = " + r7 + ", commentId = " + r6);
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter("showSmartReply", "action");
        r2.put("action", "showSmartReply");
        Intrinsics.checkNotNullParameter(r6, "commentId");
        r2.put("commentId", r6);
        Intrinsics.checkNotNullParameter(r7, "replyId");
        r2.put("replyId", r7);
        this.a.onCallBack(r2.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void g(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "replyId");
        tt5.a.h("Comment#CommentWebSdkImpl", "getReactionDetail()... replyId = " + r5);
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter("getReactionDetail", "action");
        r1.put("action", "getReactionDetail");
        Intrinsics.checkNotNullParameter(r5, "replyId");
        r1.put("replyId", r5);
        r1.put("commentType", r6);
        this.a.onCallBack(r1.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void h(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r7, "replyId");
        tt5.a.h("Comment#CommentWebSdkImpl", "closeSmartReply()... replyId = " + r7 + ", commentId = " + r6);
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter("closeSmartReply", "action");
        r2.put("action", "closeSmartReply");
        Intrinsics.checkNotNullParameter(r6, "commentId");
        r2.put("commentId", r6);
        Intrinsics.checkNotNullParameter(r7, "replyId");
        r2.put("replyId", r7);
        this.a.onCallBack(r2.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void i(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r7, "replyId");
        tt5.a.h("Comment#CommentWebSdkImpl", "showCreationAI()... replyId = " + r7 + ", commentId = " + r6);
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter("showCreationAI", "action");
        r2.put("action", "showCreationAI");
        Intrinsics.checkNotNullParameter(r6, "commentId");
        r2.put("commentId", r6);
        Intrinsics.checkNotNullParameter(r7, "replyId");
        r2.put("replyId", r7);
        this.a.onCallBack(r2.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void r(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        tt5.a.h("Comment#CommentWebSdkImpl", "resolveComment()... commentId = " + r5);
        JSONObject r1 = new JSONObject();
        Intrinsics.checkNotNullParameter("resolveComment", "action");
        r1.put("action", "resolveComment");
        Intrinsics.checkNotNullParameter(r5, "commentId");
        r1.put("commentId", r5);
        r1.put("commentType", r6);
        this.a.onCallBack(r1.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void a(String r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "commentId");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        tt5.a.h("Comment#CommentWebSdkImpl", "translate()... commentId = " + r7 + ", replyId = " + r9);
        TranslateLanguageSetting r2 = (TranslateLanguageSetting) LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "translate", true).getJSONObject("config", TranslateLanguageSetting.class);
        JSONObject r4 = new JSONObject();
        Intrinsics.checkNotNullParameter("translate", "action");
        r4.put("action", "translate");
        if (r2 == null) goto L6;
        String r3 = r2.getTargetLanguageKey();
        if (r3 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r3, "targetLanguage");
        r4.put("targetLanguage", r3);
        Intrinsics.checkNotNullParameter(r7, "commentId");
        r4.put("commentId", r7);
        r4.put("commentType", r8);
        Intrinsics.checkNotNullParameter(r9, "replyId");
        r4.put("replyId", r9);
        this.a.onCallBack(r4.toString());
        return;
    L6:
        r3 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void m(String r5, VisibilityBean r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "visibility");
        Intrinsics.checkNotNullParameter(r7, "forwardId");
        tt5.a.h("Comment#CommentWebSdkImpl", "addForwardComment()... visibility = " + r6.getType() + ", forwardId = " + r7 + ' ');
        b r1 = new b();
        r1.a("addForwardComment");
        if (r5 == null) goto L5;
        r1.a.put("content", r5);
    L5:
        Intrinsics.checkNotNullParameter(r7, "forwardId");
        r1.a.put("forwardId", r7);
        r1.e(r6);
        this.a.onCallBack(r1.b());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void o(String r6, String r7, SmartReplyDataForInsert r8) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        StringBuilder r1 = new StringBuilder("clearInputText()... commentId = ");
        r1.append(r6);
        r1.append(", replyUUID = ");
        r1.append(r7);
        r1.append(", smartReplyData: ");
        if (r8 != null) goto L5;
        String r2 = "is null";
    L6:
        r1.append(r2);
        tt5.a.h("Comment#CommentWebSdkImpl", du5.b.k(r1.toString()));
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter("clearInputText", "action");
        r3.put("action", "clearInputText");
        Intrinsics.checkNotNullParameter(r6, "commentId");
        r3.put("commentId", r6);
        if (r7 != null) goto L16;
    L12:
        if (r8 == null) goto L14;
        JSONObject r9 = new JSONObject();
        r9.put("text", r8.getText());
        r9.put("comment_id", r8.getCommentId());
        r9.put("reply_id", r8.getReplyId());
        r9.put("ai_reply_id", r8.getAiReplyId());
        r3.put("smartReplyData", r9);
    L14:
        String r10 = r3.toString();
        this.a.onCallBack(r10);
        return;
    L16:
        r3.put("reply_uuid", r7);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        tt5.a.j("Comment#CommentWebSdkImpl", th);
        goto L12
    L5:
        r2 = "is not null";
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void p(String r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r8, "replyId");
        tt5.a.h("Comment#CommentWebSdkImpl", "retryOperation()... commentId = " + r6 + ", replyId = " + r8);
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter("retryOperation", "action");
        r2.put("action", "retryOperation");
        Intrinsics.checkNotNullParameter(r6, "commentId");
        r2.put("commentId", r6);
        r2.put("commentType", r7);
        Intrinsics.checkNotNullParameter(r8, "replyId");
        r2.put("replyId", r8);
        this.a.onCallBack(r2.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void s(String r6, int r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r8, "replyId");
        tt5.a.h("Comment#CommentWebSdkImpl", "deleteReply()... commentId = " + r6 + ", replyId = " + r8);
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter("deleteReply", "action");
        r2.put("action", "deleteReply");
        Intrinsics.checkNotNullParameter(r6, "commentId");
        r2.put("commentId", r6);
        r2.put("commentType", r7);
        Intrinsics.checkNotNullParameter(r8, "replyId");
        r2.put("replyId", r8);
        this.a.onCallBack(r2.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void A(String r7, int r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "commentId");
        Intrinsics.checkNotNullParameter(r9, "referKey");
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        tt5.a.h("Comment#CommentWebSdkImpl", "removeContentReaction()... commentId = " + r7 + ", reactionKey = " + r10);
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter("removeContentReaction", "action");
        r3.put("action", "removeContentReaction");
        Intrinsics.checkNotNullParameter(r7, "commentId");
        r3.put("commentId", r7);
        r3.put("commentType", r8);
        Intrinsics.checkNotNullParameter(r9, "referKey");
        r3.put("referKey", r9);
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        r3.put("reactionKey", r10);
        this.a.onCallBack(r3.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void j(String r7, int r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "commentId");
        Intrinsics.checkNotNullParameter(r9, "referKey");
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        tt5.a.h("Comment#CommentWebSdkImpl", "addContentReaction()... commentId = " + r7 + ", reactionKey = " + r10);
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter("addContentReaction", "action");
        r3.put("action", "addContentReaction");
        Intrinsics.checkNotNullParameter(r7, "commentId");
        r3.put("commentId", r7);
        r3.put("commentType", r8);
        Intrinsics.checkNotNullParameter(r9, "referKey");
        r3.put("referKey", r9);
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        r3.put("reactionKey", r10);
        this.a.onCallBack(r3.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void k(String r5, String r6, int r7, int r8, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        Intrinsics.checkNotNullParameter(r6, "replyId");
        Intrinsics.checkNotNullParameter(r9, "imageList");
        tt5.a.h("Comment#CommentWebSdkImpl", "insertReplyFromAreaMark()... commentId = " + r5 + ", replyId = " + r6 + ", commentType = " + r7 + ", isWhole = " + r8 + ", imageList = " + r9);
        b r2 = new b();
        r2.a("intertReplyFromAreaMark");
        Intrinsics.checkNotNullParameter(r5, "commentId");
        r2.a.put("commentId", r5);
        Intrinsics.checkNotNullParameter(r6, "replyId");
        r2.a.put("replyId", r6);
        r2.a.put("commentType", r7);
        Integer r10 = Integer.valueOf(r8);
        Intrinsics.checkNotNullParameter("isWhole", "key");
        if (r10 == null) goto L5;
        r2.a.put("isWhole", r10.intValue());
    L5:
        r2.c(r9);
        this.a.onCallBack(r2.b());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void l(String r7, String r8, int r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r7, "commentId");
        Intrinsics.checkNotNullParameter(r8, "replyId");
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        tt5.a.h("Comment#CommentWebSdkImpl", "removeReaction()... commentId = " + r7 + ", replyId = " + r8 + ", reactionKey = " + r10 + ", actionId = " + r11);
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter("removeReaction", "action");
        r3.put("action", "removeReaction");
        Intrinsics.checkNotNullParameter(r7, "commentId");
        r3.put("commentId", r7);
        Intrinsics.checkNotNullParameter(r8, "replyId");
        r3.put("replyId", r8);
        r3.put("commentType", r9);
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        r3.put("reactionKey", r10);
        Intrinsics.checkNotNullParameter("actionId", "key");
        if (r11 == null) goto L5;
        r3.put("actionId", r11);
    L5:
        this.a.onCallBack(r3.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void u(String r7, String r8, int r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r7, "commentId");
        Intrinsics.checkNotNullParameter(r8, "replyId");
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        tt5.a.h("Comment#CommentWebSdkImpl", "addReaction()... commentId = " + r7 + ", replyId = " + r8 + ", reactionKey = " + r10 + ", actionId = " + r11);
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter("addReaction", "action");
        r3.put("action", "addReaction");
        Intrinsics.checkNotNullParameter(r7, "commentId");
        r3.put("commentId", r7);
        Intrinsics.checkNotNullParameter(r8, "replyId");
        r3.put("replyId", r8);
        r3.put("commentType", r9);
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        r3.put("reactionKey", r10);
        Intrinsics.checkNotNullParameter("actionId", "key");
        if (r11 == null) goto L5;
        r3.put("actionId", r11);
    L5:
        this.a.onCallBack(r3.toString());
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void n(String r4, int r5, VisibilityBean r6, String r7, boolean r8, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r6, "visibility");
        StringBuilder r0 = new StringBuilder("addComment()... visibility = ");
        r0.append(r6.getType());
        r0.append(" , content length = ");
        int r1 = 0;
        if (r4 == null) goto L5;
        int r2 = r4.length();
    L6:
        r0.append(r2);
        r0.append(", imgId = ");
        r0.append(r7);
        r0.append(", isWhole = ");
        r0.append(r8);
        r0.append(", imageList size = ");
        if (r9 == null) goto L9;
        r1 = r9.size();
    L9:
        r0.append(r1);
        r0.append(", shouldAuthorize = ");
        r0.append(r10);
        tt5.a.h("Comment#CommentWebSdkImpl", r0.toString());
        b r3 = new b();
        r3.a("addComment");
        if (r4 == null) goto L12;
        r3.a.put("content", r4);
    L12:
        r3.e(r6);
        if (r7 == null) goto L15;
        r3.a.put("imgId", r7);
    L15:
        r3.a.put("commentType", r5);
        r3.a.put("isWhole", r8);
        r3.c(r9);
        Intrinsics.checkNotNullParameter("shouldAuthorize", "key");
        r3.a.put("shouldAuthorize", r10);
        String r11 = r3.b();
        this.a.onCallBack(r11);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void q(String r6, String r7, String r8, int r9, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r7, "replyId");
        StringBuilder r2 = new StringBuilder("updateReply()... commentId = ");
        r2.append(r6);
        r2.append(", replyId = ");
        r2.append(r7);
        r2.append(", content length = ");
        int r3 = 0;
        if (r8 == null) goto L5;
        int r4 = r8.length();
    L6:
        r2.append(r4);
        r2.append(", imageList size = ");
        if (r10 == null) goto L9;
        r3 = r10.size();
    L9:
        r2.append(r3);
        r2.append(", shouldAuthorize = ");
        r2.append(r11);
        r2.append(", hasAreaAdded = ");
        r2.append(r12);
        tt5.a.h("Comment#CommentWebSdkImpl", r2.toString());
        b r5 = new b();
        r5.a("updateReply");
        Intrinsics.checkNotNullParameter(r6, "commentId");
        r5.a.put("commentId", r6);
        Intrinsics.checkNotNullParameter(r7, "replyId");
        r5.a.put("replyId", r7);
        r5.a.put("commentType", r9);
        if (r8 == null) goto L12;
        r5.a.put("content", r8);
    L12:
        r5.c(r10);
        Intrinsics.checkNotNullParameter("shouldAuthorize", "key");
        r5.a.put("shouldAuthorize", r11);
        Intrinsics.checkNotNullParameter("hasAreaAdded", "key");
        r5.a.put("hasAreaAdded", r12);
        String r13 = r5.b();
        this.a.onCallBack(r13);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.a0
    public final void e(String r5, String r6, int r7, String r8, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9, String r10, boolean r11, SmartReplyDataForInsert r12) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        StringBuilder r1 = new StringBuilder("addReply()... commentId = ");
        r1.append(r5);
        r1.append(", content length = ");
        int r2 = 0;
        if (r6 == null) goto L5;
        int r3 = r6.length();
    L6:
        r1.append(r3);
        r1.append(", imgId = ");
        r1.append(r8);
        r1.append(", imageList size = ");
        if (r9 == null) goto L9;
        r2 = r9.size();
    L9:
        r1.append(r2);
        r1.append(", shouldAuthorize = ");
        r1.append(r11);
        r1.append(", smartReplyDataForInsert: ");
        if (r12 != null) goto L12;
        String r4 = "is null";
    L13:
        r1.append(r4);
        tt5.a.h("Comment#CommentWebSdkImpl", r1.toString());
        b r13 = new b();
        r13.a("addReply");
        Intrinsics.checkNotNullParameter(r5, "commentId");
        r13.a.put("commentId", r5);
        if (r6 == null) goto L16;
        r13.a.put("content", r6);
    L16:
        if (r8 == null) goto L18;
        r13.a.put("imgId", r8);
    L18:
        r13.a.put("commentType", r7);
        if (r10 != null) goto L26;
    L24:
        r13.c(r9);
        Intrinsics.checkNotNullParameter("shouldAuthorize", "key");
        r13.a.put("shouldAuthorize", r11);
        r13.d(r12);
        String r14 = r13.b();
        this.a.onCallBack(r14);
        return;
    L26:
        r13.a.put("reply_uuid", r10);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        tt5.a.j("Comment#CommentWebSdkImpl", th);
        goto L24
    L12:
        r4 = "is not null";
        goto L13
    L5:
        r3 = 0;
        goto L6
    }
}
