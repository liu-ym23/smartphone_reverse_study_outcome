package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.lark.pb.basic.v1.SendLarkCommandPayloadResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback;
import com.ss.android.lark.share_group.RecallGroupChatterActivity;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public final class SystemContentUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f416632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w4b.u f416633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BrowserDependency f416634c = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$3, reason: invalid class name */
    class AnonymousClass3 implements IGetDataCallback<SendLarkCommandPayloadResponse> {
        final /* synthetic */ com.ss.android.lark.chat.export.entity.message.content.d val$localAction;

        public static /* synthetic */ void a(ErrorResult r100) {
            lambda$onError$0(r100);
        }

        public void onSuccess(SendLarkCommandPayloadResponse r100) {
        }

        public AnonymousClass3(com.ss.android.lark.chat.export.entity.message.content.d r100) {
            this.val$localAction = r100;
        }

        private static /* synthetic */ void lambda$onError$0(ErrorResult r100) {
            if (r100 != null) goto L4;
        L7:
            String r101 = UIHelper.getString(R.string.Lark_Legacy_ErrorMessageTip);
        L8:
            UDToast.show(UIHelper.getContext(), r101);
            return;
        L4:
            if (StringUtils.isEmpty(r100.getDisplayMsg()) == true) goto L7;
            r101 = r100.getDisplayMsg();
            goto L8
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(final ErrorResult r100) {
            Set<Integer> r101 = SystemContentUtil.f416632a;
            HashSet r102 = (HashSet) r101;
            if (r102.contains(Integer.valueOf(this.val$localAction.f415406c)) == false) goto L6;
            ThreadUtils.runOnUIThread(new j1(r100));
            return;
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((SendLarkCommandPayloadResponse) r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$4, reason: invalid class name */
    class AnonymousClass4 implements IGetDataCallback<Map<String, Boolean>> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$groupId;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            Log.e(r100.toString());
        }

        public void onSuccess(Map<String, Boolean> r100) {
            if (r100 != null) goto L5;
        L19:
            SystemContentUtil.a(this.val$context.getString(R.string.Lark_Group_MembersAreInTheGroup));
            return;
        L5:
            if (r100.size() == 0) goto L19;
            final ArrayList r101 = new ArrayList();
            Iterator<Map.Entry<String, Boolean>> r102 = r100.entrySet().iterator();
        L9:
            if (r102.hasNext() == false) goto L14;
            Map.Entry<String, Boolean> r103 = r102.next();
            if (r103.getValue().booleanValue() == true) goto L9;
            r101.add(r103.getKey());
            goto L9
        L14:
            if (r101.size() != 0) goto L17;
            SystemContentUtil.a(this.val$context.getString(R.string.Lark_Group_MembersAreInTheGroup));
            return;
        L17:
            final Context r104 = this.val$context;
            final String r105 = this.val$groupId;
            Set<Integer> r106 = SystemContentUtil.f416632a;
            ChatService r107 = ChatService.c.f411535a;
            IGetDataCallback<Chat> r108 = new AnonymousClass6(r104, r105, r101);
            r107.getClass();
            ChatService.b(r105, r101, r108);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((Map) r100);
        }

        public AnonymousClass4(Context r100, String r101) {
            this.val$context = r100;
            this.val$groupId = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$5, reason: invalid class name */
    class AnonymousClass5 implements IJoinGroupCallback {
        final /* synthetic */ Context val$context;

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void joinGroupChatSuccess(String r100) {
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onCancelSendApply() {
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onShowSendApplyDialog() {
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void sendApplySuccess() {
            SystemContentUtil.a(this.val$context.getString(R.string.Lark_Legacy_RequestSentApprovalPendingToast));
        }

        public AnonymousClass5(Context r100) {
            this.val$context = r100;
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onError(ErrorResult r100) {
            if (TextUtils.isEmpty(r100.getDisplayMsg()) == true) goto L6;
            SystemContentUtil.b(this.val$context, r100.getDisplayMsg());
            return;
        }

        @Override // com.ss.android.lark.member_manage.export.callback.IJoinGroupCallback
        public void onSendApplyError(ErrorResult r100) {
            if (TextUtils.isEmpty(r100.getDisplayMsg()) == true) goto L6;
            SystemContentUtil.a(r100.getDisplayMsg());
            Log.e(r100.toString());
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.utils.SystemContentUtil$9, reason: invalid class name */
    class AnonymousClass9 extends UIGetDataCallback<List<GroupRecallEntity>> {
        final /* synthetic */ Chat val$chat;
        final /* synthetic */ Context val$context;
        final /* synthetic */ a val$listener;
        final /* synthetic */ List val$memberEntities;

        @Override // com.larksuite.framework.callback.UIGetDataCallback
        public void onErrored(ErrorResult r100) {
            UDToast.show(UIHelper.getContext(), r100.getDisplayMsg(UIHelper.getString(R.string.Lark_Legacy_ErrorMessageTip)));
        }

        /* JADX INFO: renamed from: onSuccessed, reason: avoid collision after fix types in other method */
        public void onSuccessed2(List<GroupRecallEntity> r100) {
            if (r100.isEmpty() == false) goto L6;
            int r101 = SystemContentUtil.c(this.val$memberEntities, this.val$chat.isThread());
            Context r102 = this.val$context;
            h7b.i.b(r102, null, r102.getResources().getString(r101));
            return;
        L6:
            Context r103 = this.val$context;
            Chat r104 = this.val$chat;
            a r105 = this.val$listener;
            Set<Integer> r106 = SystemContentUtil.f416632a;
            if (r100.size() <= 1) goto L9;
            Intent r107 = new Intent(r103, RecallGroupChatterActivity.class);
            r107.putExtra("key_chatId", r104.getId());
            r107.putExtra("key_is_thread", r104.isThread());
            r107.putParcelableArrayListExtra("key_entities", new ArrayList(r100));
            r103.startActivity(r107);
            return;
        L9:
            h7b.i.d(r103, new g1(r105, r104, r100));
        }

        @Override // com.larksuite.framework.callback.UIGetDataCallback
        public /* bridge */ /* synthetic */ void onSuccessed(List<GroupRecallEntity> r100) {
            onSuccessed2(r100);
        }

        public AnonymousClass9(List r100, Chat r101, Context r102, a r103) {
            this.val$memberEntities = r100;
            this.val$chat = r101;
            this.val$context = r102;
            this.val$listener = r103;
        }
    }

    public interface a {
        void B(String r100, List<GroupRecallEntity> r101);
    }

    static {
        SystemMessageType.SystemContent_CHECK_USER_PHONE_NUMBER.getNumber();
        SystemMessageType.USER_CHECK_OTHERS_TELEPHONE.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_NAME.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_AVATAR.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_DESCRIPTION.getNumber();
        SystemMessageType.USER_MODIFY_GROUP_SETTINGS.getNumber();
        SystemMessageType.USER_START_GROUP_AND_INVITE.getNumber();
        SystemMessageType.SYSTEM_WELCOME_USER.getNumber();
        SystemMessageType r100 = SystemMessageType.USER_INVITE_OTHERS_JOIN;
        r100.getNumber();
        SystemMessageType.USER_QUIT_GROUP.getNumber();
        SystemMessageType.USER_REMOVE_OTHERS.getNumber();
        SystemMessageType.DERIVE_FROM_P2P_CHAT.getNumber();
        SystemMessageType r101 = SystemMessageType.USER_JOIN_VIA_SHARE;
        r101.getNumber();
        SystemMessageType.TRANSFER_GROUP_CHAT_OWNER.getNumber();
        SystemMessageType.TRANSFER_GROUP_CHAT_OWNER_AND_QUIT.getNumber();
        SystemMessageType.USER_SYNC_MESSAGE.getNumber();
        SystemMessageType r102 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CRYPTO_CHAT;
        r102.getNumber();
        SystemMessageType.USER_START_CRYPTO_GROUP_AND_INVITE.getNumber();
        SystemMessageType.USER_START_GROUP.getNumber();
        SystemMessageType r103 = SystemMessageType.USER_JOIN_VIA_QR_CODE;
        r103.getNumber();
        SystemMessageType.USER_SHARE_DOC_PERMISSION.getNumber();
        SystemMessageType.USER_CHANGE_DOC_PERMISSION.getNumber();
        SystemMessageType.USER_SHARE_DOC_FOLDER.getNumber();
        SystemMessageType.USER_OPEN_ONLY_ADMIN_POST.getNumber();
        SystemMessageType.USER_SEPECIFY_MEMBERS_POST.getNumber();
        SystemMessageType.USER_OPEN_ANYONE_POST.getNumber();
        SystemMessageType.USER_INVITE_OTHERS_JOIN_MEETING.getNumber();
        SystemMessageType.USER_QUIT_MEETING_CHAT.getNumber();
        SystemMessageType.USER_DISMISSED_MEETING_CHAT.getNumber();
        SystemMessageType.USER_REMOVE_OTHERS_FROM_MEETING.getNumber();
        SystemMessageType.USER_ADD_MEETING_CHAT.getNumber();
        SystemMessageType r104 = SystemMessageType.USER_START_MEETING_GROUP_AND_INVITE;
        r104.getNumber();
        SystemMessageType.INVITE_CHAT_MEMBER_2_OUT_CHAT.getNumber();
        SystemMessageType.CREATE_CHAT_AND_INVITE_FROM_CHAT_MEMBER.getNumber();
        r104.getNumber();
        SystemMessageType.AUTO_TRANSLATE_GUIDANCE.getNumber();
        SystemMessageType.WITHDRAW_ADDED_USER.getNumber();
        SystemMessageType.SAIPAN_REMIND_ONCALL_REPLY.getNumber();
        SystemMessageType.SAIPAN_REMIND_ONCALL_DONE.getNumber();
        SystemMessageType.SAIPAN_REMIND_ONCALL_AUTO_DONE.getNumber();
        SystemMessageType.SAIPAN_ADD_ONCALL.getNumber();
        SystemMessageType.USER_OPEN_ONLY_ADMIN_POST_THREAD.getNumber();
        SystemMessageType.USER_SPECIFY_MEMBERS_POST_THREAD.getNumber();
        SystemMessageType r105 = SystemMessageType.USER_OPEN_ANYONE_POST_THREAD;
        r105.getNumber();
        SystemMessageType.INVITE_AT_CHATTERS.getNumber();
        r105.getNumber();
        SystemMessageType.VC_MEETING_STARTED.getNumber();
        SystemMessageType.VC_MEETING_ENDED_OVER_ONE_HOUR.getNumber();
        SystemMessageType.VC_MEETING_ENDED_LESS_ONE_HOUR.getNumber();
        SystemMessageType.VC_MEETING_ENDED_LESS_ONE_MINUTE.getNumber();
        SystemMessageType.VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR.getNumber();
        SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR.getNumber();
        SystemMessageType.VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_NO_ANSWER.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_REFUSE.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWER_CANCEL.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_BUSY.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_NO_ANSWER.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_REFUSE.getNumber();
        SystemMessageType.VOIP_INTERVIEWER_CANCEL.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_BUSY.getNumber();
        SystemMessageType.CANCEL_EMERGENCY_CALL.getNumber();
        SystemMessageType.HANGUP_EMERGENCY_CALL.getNumber();
        SystemMessageType.START_EMERGENCY_CALL.getNumber();
        SystemMessageType.EMERGENCY_CALL_NOTANSWER.getNumber();
        SystemMessageType.MEETING_TRANSFER_TO_CHAT.getNumber();
        SystemMessageType.MEETING_TRANSFER_TO_CHAT_WITH_DOC_URL.getNumber();
        SystemMessageType.VC_CALL_INTERVIEWEE_NOT_ONLINE.getNumber();
        SystemMessageType.VOIP_INTERVIEWEE_NOT_ONLINE.getNumber();
        SystemMessageType.USER_JOIN_CHAT_AUTO_MUTE.getNumber();
        SystemMessageType r106 = SystemMessageType.INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_LESS_THRESHOLD;
        r106.getNumber();
        SystemMessageType r107 = SystemMessageType.INVITE_CHATTERS_TO_CHAT_NO_PERMISSION_OVER_THRESHOLD;
        r107.getNumber();
        SystemMessageType.USER_CHANGE_TURN_ON_GROUP_MAIL.getNumber();
        SystemMessageType.USER_CHANGE_TURN_OFF_GROUP_MAIL.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_MEMBERS.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_TENANT.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_EVERYONE.getNumber();
        SystemMessageType r108 = SystemMessageType.USER_JOIN_VIA_GROUP_LINK;
        r108.getNumber();
        SystemMessageType r109 = SystemMessageType.USER_INVITE_BOT_JOIN;
        r109.getNumber();
        SystemMessageType.DOC_TEMPLATE_GROUP_SHARE.getNumber();
        SystemMessageType.SHEET_TEMPLATE_GROUP_SHARE.getNumber();
        SystemMessageType.MIND_NOTE_TEMPLATE_GROUP_SHARE.getNumber();
        SystemMessageType r110 = SystemMessageType.BUILD_ONE_WAY_RELATION;
        r110.getNumber();
        SystemMessageType r111 = SystemMessageType.INVITE_FRIENDS_SUCCESS;
        r111.getNumber();
        SystemMessageType.CREATE_P2P_SOURCE.getNumber();
        SystemMessageType.CREATE_CIRCLE_AND_INVITE_OTHERS_FROM_CHAT.getNumber();
        SystemMessageType.MENTIONED_PERSON_NOT_IN_CIRCLE.getNumber();
        SystemMessageType.INVITE_MEMBERS_TO_JOIN_EXTERNAL_CIRCLE.getNumber();
        r106.getNumber();
        r107.getNumber();
        SystemMessageType.JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD.getNumber();
        SystemMessageType.CIRCLE_WELCOME_NEW_MEMBERS.getNumber();
        SystemMessageType.TRANSFER_CIRCLE_OWNER.getNumber();
        SystemMessageType.TRANSFER_CIRCLE_OWNER_AND_LEAVE.getNumber();
        SystemMessageType.CIRCLE_USER_CHANGE_DOC_PERMISSION.getNumber();
        SystemMessageType r112 = SystemMessageType.USER_INVITE_BOT_JOIN_CIRCLE;
        r112.getNumber();
        SystemMessageType r113 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE;
        r113.getNumber();
        SystemMessageType r114 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK;
        r114.getNumber();
        SystemMessageType.CIRCLE_TOO_MANY_MEMBERS_NOTIFICATION_MUTED.getNumber();
        SystemMessageType r115 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE;
        r115.getNumber();
        SystemMessageType r116 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD;
        r116.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_AVATAR.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_DESCRIPTION.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_NAME.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_OWNER.getNumber();
        SystemMessageType.USER_MODIFY_CIRCLE_SETTINGS.getNumber();
        SystemMessageType.USER_SET_ONLY_CIRCLE_OWNER_CAN_POST.getNumber();
        SystemMessageType.USER_SET_ONLY_CIRCLE_OWNER_CAN_CREATE_NEW_TOPICS.getNumber();
        SystemMessageType.USER_LEAVE_CIRCLE.getNumber();
        SystemMessageType r117 = SystemMessageType.USER_REMOVE_CIRCLE_MEMBERS;
        r117.getNumber();
        r117.getNumber();
        SystemMessageType.USER_CREATE_CIRCLE.getNumber();
        SystemMessageType.USER_CREATE_CIRCLE_AND_INVITE.getNumber();
        SystemMessageType.USER_SYNC_MESSAGE_TO_CIRCLE.getNumber();
        SystemMessageType.USER_WITHDRAW_CIRCLE_INVITATION.getNumber();
        SystemMessageType.CIRCLE_ANONYMOUS_ON.getNumber();
        SystemMessageType.CIRCLE_ANONYMOUS_OFF.getNumber();
        SystemMessageType.USER_CLEAR_CIRCLE_ANNOUNCEMENT.getNumber();
        SystemMessageType.USER_REMOVE_CIRCLE_DESCRIPTION.getNumber();
        SystemMessageType.USER_CREATE_FACE_TO_FACE_CHAT.getNumber();
        SystemMessageType.WELCOME_USER_JOIN_FACE_TO_FACE_CHAT.getNumber();
        SystemMessageType.INVITE_CHAT_MEMBER_2_CHAT.getNumber();
        SystemMessageType.WILL_REACH_CHAT_CHATTER_COUNT_LIMIT.getNumber();
        SystemMessageType.ALREADY_REACH_CHAT_CHATTER_COUNT_LIMIT.getNumber();
        SystemMessageType.USER_CREATED_GROUP_AND_INVITED_OTHER_CHATTER_CHAT_DEPARTMENT.getNumber();
        SystemMessageType r118 = SystemMessageType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN;
        r118.getNumber();
        SystemMessageType.CREATE_CHAT_AND_INVITE_FROM_CHAT_DEPARTMENT_MEMBER.getNumber();
        SystemMessageType.USER_OPEN_ONLY_SPECIFY_MEMBERS_POST.getNumber();
        SystemMessageType.USER_OPEN_ONLY_SPECIFY_MEMBERS_POST_THREAD.getNumber();
        SystemMessageType.USER_REMOVE_SPECIFY_MEMBERS_POST.getNumber();
        SystemMessageType.USER_REMOVE_SPECIFY_MEMBERS_POST_THREAD.getNumber();
        SystemMessageType.ADD_MEMBER_TO_ADMIN_LIST.getNumber();
        SystemMessageType.REMOVE_MEMBER_FROM_ADMIN_LIST.getNumber();
        SystemMessageType.USER_OPEN_ONLY_OWNER_AND_ADMIN_POST.getNumber();
        SystemMessageType.USER_OPEN_ONLY_OWNER_AND_ADMIN_POST_THREAD.getNumber();
        SystemMessageType.ADMIN_OPEN_ANYONE_POST.getNumber();
        SystemMessageType.ADMIN_OPEN_ANYONE_POST_THREAD.getNumber();
        SystemMessageType.USER_CHANGE_GROUP_MAIL_PERMISSION_OWNER_OR_ADMIN.getNumber();
        SystemMessageType.GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_ON.getNumber();
        SystemMessageType.GROUP_NEW_MEMBERS_VIEW_CHAT_HISTORY_OFF.getNumber();
        SystemMessageType r119 = SystemMessageType.GROUP_NEW_MEMBERS_CAN_VIEW_HISTORY_MESSAGES;
        r119.getNumber();
        SystemMessageType.CIRCLE_WELCOME_NEW_MEMBERS_NO_HISTORY.getNumber();
        SystemMessageType.JOIN_CIRCLE_VIA_HELP_DESK_MSG_CARD_NO_HISTORY.getNumber();
        SystemMessageType r120 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_NO_HISTORY;
        r120.getNumber();
        SystemMessageType r121 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_INVITATION_CARD_NO_HISTORY;
        r121.getNumber();
        SystemMessageType r122 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_LINK_NO_HISTORY;
        r122.getNumber();
        SystemMessageType r123 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CIRCLE_BY_QR_CODE_NO_HISTORY;
        r123.getNumber();
        SystemMessageType r124 = SystemMessageType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NO_HIStORY;
        r124.getNumber();
        SystemMessageType r210 = SystemMessageType.USER_JOIN_VIA_QR_CODE_NO_HISTORY;
        r210.getNumber();
        SystemMessageType.USER_JOIN_CHAT_WELCOME_MESSAGE.getNumber();
        SystemMessageType.USER_JOIN_CHAT_WELCOME_MESSAGE_NO_HISTORY.getNumber();
        SystemMessageType r211 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE;
        r211.getNumber();
        SystemMessageType r212 = SystemMessageType.USER_INVITE_OTHERS_JOIN_CHAT_MESSAGE_NO_HISTORY;
        r212.getNumber();
        SystemMessageType r213 = SystemMessageType.USER_INVITE_OTHERS_CHATTER_CHAT_DEPARTMENT_JOIN_NEW;
        r213.getNumber();
        SystemMessageType r214 = SystemMessageType.USER_JOIN_VIA_QR_NEW;
        r214.getNumber();
        SystemMessageType r215 = SystemMessageType.USER_JOIN_VIA_SHARE_NEW;
        r215.getNumber();
        SystemMessageType r216 = SystemMessageType.USER_JOIN_VIA_SHARE_NO_HISTORY;
        r216.getNumber();
        SystemMessageType r217 = SystemMessageType.USER_JOIN_CHAT_BY_LINK;
        r217.getNumber();
        SystemMessageType r218 = SystemMessageType.USER_JOIN_CHAT_BY_LINK_NO_HISTORY;
        r218.getNumber();
        SystemMessageType.HELP_DESK_USER_JOIN_CHAT.getNumber();
        SystemMessageType.HELP_DESK_USER_JOIN_CHAT_NO_HISTORY.getNumber();
        SystemMessageType.BITABLE_TEMPLATE_GROUP_SHARE_SYSTEM_MESSAGE.getNumber();
        SystemMessageType.UPGRADE_SUPER_CHAT.getNumber();
        SystemMessageType.CREATE_TEAM_AND_INVITE_MEMBERS.getNumber();
        SystemMessageType.INVITE_MEMBERS_JOIN_TEAM.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_FAIL.getNumber();
        SystemMessageType.KICK_MEMBERS_OUT_TEAM.getNumber();
        SystemMessageType.MEMBER_LEAVE_TEAM.getNumber();
        SystemMessageType.TRANSFER_TEAM_OWNER.getNumber();
        SystemMessageType.MODIFY_TEAM_NAME.getNumber();
        SystemMessageType.ENABLE_TEAM_CREATE_CHAT_PERMISSION.getNumber();
        SystemMessageType.CLOSE_TEAM_CREATE_CHAT_PERMISSION.getNumber();
        SystemMessageType.ENABLE_TEAM_ADD_MEMBERS_PERMISSION.getNumber();
        SystemMessageType.CLOSE_TEAM_ADD_MEMBERS_PERMISSION.getNumber();
        SystemMessageType.DISSOLVE_TEAM_AND_UNBIND_CHAT.getNumber();
        SystemMessageType.CREATE_TEAM_CHAT.getNumber();
        SystemMessageType.BIND_CHAT_INTO_TEAM.getNumber();
        SystemMessageType.UNBIND_CHAT_WITH_TEAM.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_CHAT_SEE_HISTORICAL.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_CHAT_SEE_NEW_MESSAGES.getNumber();
        SystemMessageType.MEMBERS_JOIN_TEAM_CHAT_FAIL.getNumber();
        SystemMessageType.UPDATE_CHAT_TO_TEAM.getNumber();
        SystemMessageType.MEMBERS_LEAVE_AND_TRANSFER.getNumber();
        SystemMessageType.USER_CREATE_TEAM.getNumber();
        SystemMessageType.MODIFY_TEAM_AVATAR.getNumber();
        SystemMessageType.MODIFY_TEAM_DESCRIPTION.getNumber();
        SystemMessageType.DELETE_TEAM_DESCRIPTION.getNumber();
        SystemMessageType.CREATE_URGENT_ONLY_OWNER_AND_ADMIN_ON.getNumber();
        SystemMessageType.CREATE_URGENT_ONLY_OWNER_AND_ADMIN_OFF.getNumber();
        SystemMessageType.CREATE_TEAM_CHAT_V2_MANAGER.getNumber();
        SystemMessageType.BIND_CHAT_INTO_TEAM_MANAGER.getNumber();
        SystemMessageType.AUTO_OPEN_TYPING_TRANSLATE.getNumber();
        SystemMessageType.AUTO_OPEN_TYPING_TRANSLATE_V1.getNumber();
        SystemMessageType.MANUAL_OPEN_TYPING_TRANSLATE.getNumber();
        SystemMessageType.MANUAL_OPEN_TYPING_TRANSLATE_PROMPTS.getNumber();
        SystemMessageType.CRYPTO_MESSAGE_NOTICE_NO_TRANSMIT.getNumber();
        SystemMessageType.CRYPTO_MESSAGE_NOTICE_SEVEN_DAYS.getNumber();
        SystemMessageType.CRYPTO_MESSAGE_NOTICE_BURN_AFTER_READING.getNumber();
        new HashSet(Arrays.asList(new Integer[]{Integer.valueOf(r100.getNumber()), Integer.valueOf(r102.getNumber()), Integer.valueOf(r101.getNumber()), Integer.valueOf(r103.getNumber()), Integer.valueOf(r108.getNumber()), Integer.valueOf(r109.getNumber()), Integer.valueOf(r113.getNumber()), Integer.valueOf(r116.getNumber()), Integer.valueOf(r115.getNumber()), Integer.valueOf(r112.getNumber()), Integer.valueOf(r114.getNumber()), Integer.valueOf(r118.getNumber()), Integer.valueOf(r119.getNumber()), Integer.valueOf(r120.getNumber()), Integer.valueOf(r121.getNumber()), Integer.valueOf(r123.getNumber()), Integer.valueOf(r122.getNumber()), Integer.valueOf(r124.getNumber()), Integer.valueOf(r210.getNumber()), Integer.valueOf(r211.getNumber()), Integer.valueOf(r212.getNumber()), Integer.valueOf(r213.getNumber()), Integer.valueOf(r214.getNumber()), Integer.valueOf(r215.getNumber()), Integer.valueOf(r216.getNumber()), Integer.valueOf(r217.getNumber()), Integer.valueOf(r218.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroup_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndDepartment_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_GroupAndDepartment_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryYes_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_EnterGroup_UserAndGroupAndDepartment_ChatHistoryNo_Inviter.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_UserAndGroup_OwnerInvite.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_UserAndDepartment_OwnerInvite.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_GroupAndDepartment_OwnerInvite.getNumber()), Integer.valueOf(SystemMessageType.Lark_IM_CreateGroup_UserAndGroupAndDepartment_OwnerInvite.getNumber())}));
        Integer[] r125 = {Integer.valueOf(r110.getNumber()), Integer.valueOf(r111.getNumber()), Integer.valueOf(SystemMessageType.SEND_MESSAGE_COLLABORATION_AUTH_FAILED.getNumber()), Integer.valueOf(SystemMessageType.NOT_COLLABORATION_AUTH_SEND_MSG_LIMIT_NOTIFY.getNumber()), Integer.valueOf(SystemMessageType.NOT_COLLABORATION_AUTH_SEND_MSG_REACH_LIMIT.getNumber())};
        SystemMessageType.SystemContent_Lark_IM_BotCustomization.getNumber();
        new HashSet(Arrays.asList(r125));
        f416632a = new AnonymousClass1();
        f416633b = ChatCoreModule.a().getLoginDependency();
        f416634c = ChatCoreModule.a().getBrowserDependency();
        ChatCoreModule.a().getProfileDependency();
    }

    public static void a(String r100) {
        CoreThreadPool.getDefault().getUIExecutor().execute(new h1(r100));
    }

    public static void b(Context r100, String r101) {
        if (TextUtils.isEmpty(null) == true) goto L5;
    L7:
        CoreThreadPool.getDefault().getUIExecutor().execute(new i1(r100, r101));
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
    }

    public static int c(List<? extends PickChatEntity> r100, boolean r101) {
        HashMap r102 = new HashMap(r100.size());
        Iterator<? extends PickChatEntity> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        PickChatEntity r104 = r103.next();
        List r105 = (List) r102.get(Integer.valueOf(r104.f415165a));
        if (r105 != null) goto L8;
        r105 = new ArrayList(r100.size() / 3);
        r102.put(Integer.valueOf(r104.f415165a), r105);
    L8:
        r105.add(r104);
        goto L4
    L10:
        if (r102.size() != 1) goto L39;
        ArrayList r106 = new ArrayList(r102.keySet());
        boolean r107 = false;
        int r108 = ((Integer) ListProtector.get(r106, 0)).intValue();
        if (((List) r102.get(Integer.valueOf(r108))).size() <= 1) goto L14;
        r107 = true;
    L14:
        if (r108 != 1) goto L16;
        if (r107 == false) goto L34;
        if (r101 == false) goto L33;
        return R.string.Lark_Groups_RevokeFailedDialogContentManyMember;
    L33:
        return R.string.Lark_Group_RevokeMoreMemberNotExist;
    L34:
        if (r101 == false) goto L37;
        return R.string.Lark_Groups_RevokeFailedDialogContent;
    L37:
        return R.string.Lark_Group_RevokeOneMemberNotExist;
    L16:
        if (r108 == 2) goto L24;
        if (r108 != 3) goto L39;
        if (r107 == false) goto L22;
        return R.string.Lark_Server_AllDepartmentsMembersNoLongerInTheGroup;
    L22:
        return R.string.Lark_Server_DepartmentMemberNoLongerInTheGroup;
    L24:
        if (r107 == false) goto L27;
        return R.string.Lark_Server_AllGroupsMembersNoLongerInTheGroup;
    L27:
        return R.string.Lark_Server_GroupMemberNoLongerInTheGroup;
    L39:
        return R.string.Lark_Group_RevokeMoreMemberNotExist;
    }
}
