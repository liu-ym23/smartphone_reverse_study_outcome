package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.lark.pb.basic.v1.CloudDraftContent;
import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import com.bytedance.lark.pb.basic.v1.ScheduleMessageItem;
import com.bytedance.lark.pb.im.v1.CreateDraftRequest;
import com.bytedance.lark.pb.im.v1.CreateOrDeleteChatLastDraftIdRequest;
import com.bytedance.lark.pb.im.v1.DeleteDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchChatInputDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchMessageReplyDraftRequest;
import com.bytedance.lark.pb.im.v1.GetDraftsRequest;
import com.bytedance.lark.pb.im.v1.PutChatOrThreadDraftsUpdateRequest;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.ReplyActionUtils;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.dto.draft.ScheduleDraftInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class r implements m6b.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l6b.a f416560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExecutorService f416561b;

    public interface a {
        Boolean a();
    }

    @Override // m6b.g
    public final Executor getExecutor() {
        ExecutorService r100 = this.f416561b;
        if (r100 != null) goto L5;
    L8:
        this.f416561b = CoreThreadPool.getDefault().newSerialIODensityThreadPool("DraftService");
    L10:
        return this.f416561b;
    L5:
        if (r100.isShutdown() == true) goto L8;
        if (this.f416561b.isTerminated() == false) goto L10;
        goto L8
    }

    @Inject
    public r(l6b.a r100) {
        this.f416560a = r100;
    }

    @Override // m6b.g
    public final Draft Ea(String r100) {
        return b(r100, 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.service.impl.q] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // m6b.g
    public final Draft Na(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FetchMessageReplyDraftRequest.Builder r101 = new FetchMessageReplyDraftRequest.Builder();
        r101.message_id(r100);
        return this.f416560a.a(r101, new q());
    }

    @Override // m6b.g
    public final Draft Pc(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return se(Collections.singletonList(r100)).get(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.ss.android.lark.chat.service.impl.l] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final String a(Draft r100) {
        switch(r100.type) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        com.bytedance.lark.pb.basic.v1.Draft.Type r101 = com.bytedance.lark.pb.basic.v1.Draft.Type.TEXT;
    L11:
        boolean r102 = true;
        com.bytedance.lark.pb.basic.v1.Draft.Builder r103 = new com.bytedance.lark.pb.basic.v1.Draft.Builder().content(JSON.toJSONString(r100, new SerializerFeature[]{SerializerFeature.WriteClassName})).type(r101);
        RichText r104 = r100.postRichText;
        if (r104 == null) goto L14;
        com.bytedance.lark.pb.basic.v1.RichText r105 = com.ss.android.lark.parser.internal.g0.d(r104);
    L15:
        r103.cloud_draft_content(new CloudDraftContent(r100.title, r105));
        if (TextUtils.isEmpty(r100.messageId) == true) goto L19;
        r103.message_id(r100.messageId);
    L19:
        if (TextUtils.isEmpty(r100.chatId) == true) goto L22;
        r103.chat_id(r100.chatId);
    L22:
        if (TextUtils.isEmpty(r100.reEditMessageId) == true) goto L25;
        r103.edit_message_id(r100.reEditMessageId);
    L25:
        if (TextUtils.isEmpty(r100.threadId) == true) goto L28;
        r103.thread_id(r100.threadId);
    L28:
        if (r100.scheduleDraftInfo == null) goto L37;
        com.bytedance.lark.pb.basic.v1.Draft.ScheduleInfo.Builder r106 = new com.bytedance.lark.pb.basic.v1.Draft.ScheduleInfo.Builder();
        r106.schedule_time(Long.valueOf(r100.scheduleDraftInfo.getScheduleSendTime()));
        if (TextUtils.isEmpty(r100.scheduleDraftInfo.getScheduleMessageId()) == true) goto L36;
        ScheduleMessageItem.Builder r107 = new ScheduleMessageItem.Builder();
        r107.item_id(r100.scheduleDraftInfo.getScheduleMessageId());
        if (r100.scheduleDraftInfo.isPreScheduleMessage() == false) goto L34;
        ScheduleMessageItem.ItemType r108 = ScheduleMessageItem.ItemType.QUASI_SCHEDULE_MESSAGE;
    L35:
        r107.item_type(r108);
        r106.item(r107.build());
        goto L36
    L34:
        r108 = ScheduleMessageItem.ItemType.SCHEDULE_MESSAGE;
    L36:
        r103.schedule_info(r106.build());
    L37:
        PartialReplyInfo r109 = r100.partialReplyInfo;
        if (r109 == null) goto L40;
        r103.partial_reply_info(ReplyActionUtils.e(r109));
    L40:
        DraftAttachmentSnapshot r110 = r100.attachmentSnapshot;
        if (r110 != null) goto L43;
    L45:
        r102 = false;
    L46:
        if (r102 == false) goto L49;
        r103.attachment_snapshot(r100.attachmentSnapshot);
    L49:
        return this.f416560a.d(new CreateDraftRequest.Builder().draft(r103.build()), new l(), new m());
    L43:
        if (CollectionUtils.isNotEmpty(r110.attachments) == false) goto L45;
    L14:
        r105 = null;
        goto L15
    L5:
        r101 = com.bytedance.lark.pb.basic.v1.Draft.Type.SCHEDULE_MESSAGE;
        goto L11
    L6:
        r101 = com.bytedance.lark.pb.basic.v1.Draft.Type.EDIT_MESSAGE;
        goto L11
    L7:
        r101 = com.bytedance.lark.pb.basic.v1.Draft.Type.MSG_THREAD;
        goto L11
    L8:
        r101 = com.bytedance.lark.pb.basic.v1.Draft.Type.INDIVIDUAL_TOPIC;
        goto L11
    L9:
        r101 = com.bytedance.lark.pb.basic.v1.Draft.Type.POST;
        goto L11
    L10:
        r101 = com.bytedance.lark.pb.basic.v1.Draft.Type.TEXT;
        goto L11
    }

    @Override // m6b.g
    public final void a8(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        DeleteDraftRequest.Builder r101 = new DeleteDraftRequest.Builder().draft_id(r100);
        this.f416560a.b(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.chat.service.impl.n] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // m6b.g
    public final Draft b6(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FetchChatInputDraftRequest.Builder r101 = new FetchChatInputDraftRequest.Builder();
        r101.chat_id(r100).thread_id(null);
        return this.f416560a.e(r101, new n());
    }

    @Override // m6b.g
    public final Draft b8(String r100) {
        return b(r100, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.chat.service.impl.k] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // m6b.g
    public final Map<String, Draft> se(final List<String> r100) {
        if (CollectionUtils.isEmpty(r100) == true) goto L5;
        GetDraftsRequest.Builder r101 = new GetDraftsRequest.Builder();
        r101.draft_ids(r100);
        Map<String, Draft> r102 = this.f416560a.g(r101, new k(r100));
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new HashMap();
    L5:
        return new HashMap();
    }

    @Override // m6b.g
    public final void M8(String r100, int r101) {
        List r102 = Collections.singletonList(r100);
        HashMap r103 = new HashMap();
        if (CollectionUtils.isEmpty(r102) == true) goto L23;
        com.ss.android.lark.chat.utils.z0.a();
        Map<String, List<Draft>> r104 = this.f416560a.f(new p());
        if (CollectionUtils.isNotEmpty(r104) == false) goto L23;
        Iterator r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L23;
        List<Draft> r106 = r104.get((String) r105.next());
        if (r106 == null) goto L9;
        Iterator<Draft> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L9;
        Draft r108 = r107.next();
        if (r108 == null) goto L15;
        if (r108.type != r101) goto L15;
        String r109 = r108.chatId;
        if (r109 == null) goto L15;
        r103.put(r109, r108);
    L23:
        Draft r110 = (Draft) r103.get(r100);
        if (r110 != null) goto L26;
        return;
    L26:
        a8(r110.f420576id);
    }

    @Override // m6b.g
    public final void Mb(String r100, String r101) {
        CreateOrDeleteChatLastDraftIdRequest.Builder r102 = new CreateOrDeleteChatLastDraftIdRequest.Builder();
        r102.chat_id(r100).draft_id(r101);
        this.f416560a.h(r102);
    }

    public final Draft b(String r100, int r101) {
        com.ss.android.lark.chat.utils.z0.a();
        Map<String, List<Draft>> r102 = this.f416560a.f(new o());
        if (CollectionUtils.isNotEmpty(r102) == false) goto L15;
        Iterator<List<Draft>> r103 = r102.values().iterator();
    L6:
        if (r103.hasNext() == false) goto L24;
        Iterator<Draft> r104 = r103.next().iterator();
    L9:
        if (r104.hasNext() == false) goto L6;
        Draft r105 = r104.next();
        if (r105.type != r101) goto L9;
        if (TextUtils.equals(r105.messageId, r100) == false) goto L9;
        return r105;
    L24:
        return null;
    L15:
        return null;
    }

    @Override // m6b.g
    public final String x8(Chat r110, Draft r111, boolean r112) {
        String r100 = "";
        boolean r101 = false;
        if (r110 != null) goto L5;
    L44:
        Log.i("DraftService", "saveAllDraftImpl: called");
        if (r110 != null) goto L48;
        Log.e("DraftService", "saveAllDraftImpl: chat is null , method return");
    L95:
        return r100;
    L48:
        if (r111.type != 6) goto L50;
        boolean r102 = true;
    L51:
        if (r102 == false) goto L53;
    L55:
        boolean r103 = false;
    L56:
        if (r102 == false) goto L58;
    L62:
        boolean r104 = false;
    L63:
        DraftAttachmentSnapshot r105 = r111.attachmentSnapshot;
        if (r105 != null) goto L66;
    L68:
        boolean r106 = false;
    L70:
        if (TextUtils.isEmpty(r111.title) == true) goto L72;
    L75:
        if (r104 == false) goto L81;
        Log.i("DraftService", "isChatGeneralDraft: true");
        if (r101 == false) goto L79;
        Log.i("DraftService", "draft is empty, remove chat post draft");
        a8(r110.getPostDraftId());
    L93:
        if (r112 == false) goto L95;
        Mb(r110.getId(), r100);
        goto L95
    L79:
        Draft r107 = new Draft();
        r107.title = r111.title;
        r107.postRichText = r111.postRichText;
        r107.queryStatusInfo = r111.queryStatusInfo;
        r107.attachmentSnapshot = r111.attachmentSnapshot;
        Log.i("DraftService", "addPostDraft");
        r107.chatId = r110.getId();
        r107.type = 1;
        String r113 = a(r107);
    L80:
        r100 = r113;
        goto L93
    L81:
        if (r103 == false) goto L88;
        if (r101 == false) goto L87;
        Log.i("DraftService", "remove message reply draft: " + r111.messageId);
        Draft r114 = b(r111.messageId, 3);
        if (r114 == null) goto L93;
        a8(r114.f420576id);
        goto L93
    L87:
        Log.i("DraftService", "save message reply draft: " + r111.messageId);
        Draft r108 = new Draft();
        r108.messageId = r111.messageId;
        r108.title = r111.title;
        r108.postRichText = r111.postRichText;
        r108.partialReplyInfo = r111.partialReplyInfo;
        r108.queryStatusInfo = r111.queryStatusInfo;
        r108.attachmentSnapshot = r111.attachmentSnapshot;
        String r115 = r111.messageId;
        r108.type = 3;
        r108.messageId = r115;
        r113 = a(r108);
        goto L80
    L88:
        if (r102 == false) goto L93;
        if (TextUtils.isEmpty(r111.reEditMessageId) == false) goto L92;
        Log.i("DraftService", "remove reEdit message draft, chat id is : " + r111.chatId);
        a8(r110.getReEditDraftId());
        goto L93
    L92:
        Draft r109 = new Draft();
        r109.reEditMessageId = r111.reEditMessageId;
        r109.title = r111.title;
        r109.messageId = r111.messageId;
        r109.postRichText = r111.postRichText;
        r109.chatId = r110.getId();
        r109.type = 6;
        r109.queryStatusInfo = r111.queryStatusInfo;
        r109.attachmentSnapshot = r111.attachmentSnapshot;
        r113 = a(r109);
        goto L80
    L72:
        if (com.ss.android.lark.widget.richtext.i.l(r111.postRichText) == false) goto L75;
        if (r106 == true) goto L75;
        r101 = true;
        goto L75
    L66:
        if (CollectionUtils.isNotEmpty(r105.attachments) == false) goto L68;
        r106 = true;
        goto L70
    L58:
        if (TextUtils.isEmpty(r111.reEditMessageId) == false) goto L62;
        if (TextUtils.isEmpty(r111.messageId) == false) goto L62;
        r104 = true;
        goto L63
    L53:
        if (TextUtils.isEmpty(r111.messageId) == true) goto L55;
        r103 = true;
        goto L56
    L50:
        r102 = false;
        goto L51
    L5:
        if (r110.isSecret() == false) goto L44;
        String r116 = r111.messageId;
        String r117 = r110.getId();
        RichText r118 = r111.contentRichText;
        String r119 = r111.title;
        RichText r120 = r111.postRichText;
        if (TextUtils.isEmpty(r116) == false) goto L22;
        if (TextUtils.isEmpty(r117) == true) goto L22;
        if (com.ss.android.lark.widget.richtext.i.l(r118) == false) goto L13;
        Log.i("DraftService", "removeChatTextDraft:" + r110.getTextDraftId());
        a8(r110.getTextDraftId());
    L15:
        if (TextUtils.isEmpty(r119) == true) goto L17;
    L19:
        Draft r121 = new Draft();
        r121.title = r119;
        r121.postRichText = r120;
        r121.chatId = r117;
        r121.type = 1;
        a(r121);
    L20:
        Mb(r117, "");
    L43:
        return "";
    L17:
        if (com.ss.android.lark.widget.richtext.i.l(r120) == false) goto L19;
        Log.i("DraftService", "removeChatPostDraft:" + r110.getPostDraftId());
        a8(r110.getPostDraftId());
        goto L20
    L13:
        Draft r122 = new Draft();
        r122.contentRichText = r118;
        r122.chatId = r117;
        r122.type = 0;
        a(r122);
    L22:
        if (TextUtils.isEmpty(r116) == true) goto L43;
        if (com.ss.android.lark.widget.richtext.i.l(r118) == false) goto L31;
        Draft r123 = b(r116, 0);
        if (r123 == null) goto L29;
        a8(r123.f420576id);
    L29:
        if (r112 == false) goto L35;
        Mb(r117, "");
    L35:
        if (TextUtils.isEmpty(r119) == true) goto L37;
    L42:
        Draft r124 = new Draft();
        r124.postRichText = r120;
        r124.type = 3;
        r124.messageId = r116;
        a(r124);
        goto L43
    L37:
        if (com.ss.android.lark.widget.richtext.i.l(r120) == false) goto L42;
        Draft r125 = b(r116, 3);
        if (r125 == null) goto L43;
        a8(r125.f420576id);
        goto L43
    L31:
        Draft r126 = new Draft();
        r126.contentRichText = r118;
        r126.messageId = r116;
        String r127 = a(r126);
        if (r112 == false) goto L35;
        Mb(r117, r127);
        goto L35
    }

    @Override // m6b.g
    public final void o5(b2.a r100, String r101, String r102, a r103) {
        if (r100.f416452a != null) goto L6;
        return;
    L6:
        if (r103.a().booleanValue() == true) goto L8;
        return;
    L8:
        PutChatOrThreadDraftsUpdateRequest.Builder r104 = new PutChatOrThreadDraftsUpdateRequest.Builder();
        r104.chat_id(r100.f416452a).thread_id(null).chat_input_draft_id(r100.f416453b).chat_type(r101).chat_type_detail(r102);
        this.f416560a.c(r104);
    }

    @Override // m6b.g
    public final void tc(String r100, Draft r101, boolean r102, String r110) {
        Log.i("DraftService", "save schedule send draft, chat id = " + r100 + ", type = " + r101.type);
        if (r101.type == 7) goto L5;
        return;
    L5:
        ScheduleDraftInfo r103 = r101.scheduleDraftInfo;
        if (r103 != null) goto L8;
    L11:
        Log.i("DraftService", "remove schedule send draft, chat id is " + r100 + ", remove draft id = " + r110);
        a8(r110);
        String r104 = "";
    L12:
        Log.i("DraftService", "save schedule draft success, chat id = " + r100 + ", draft id = " + r104);
        Mb(r100, r104);
        return;
    L8:
        if (r103.getScheduleSendTime() == 0) goto L11;
        Draft r105 = new Draft();
        r105.title = r101.title;
        r105.messageId = r101.messageId;
        r105.threadId = r101.threadId;
        r105.chatId = r100;
        r105.postRichText = r101.postRichText;
        r105.type = 7;
        r105.scheduleDraftInfo = r101.scheduleDraftInfo;
        r105.partialReplyInfo = r101.partialReplyInfo;
        r105.attachmentSnapshot = r101.attachmentSnapshot;
        r104 = a(r105);
        goto L12
    }
}
