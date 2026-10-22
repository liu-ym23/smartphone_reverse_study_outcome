package com.ss.android.lark.contact.base.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.SendUserInvitationRequest;
import com.bytedance.lark.pb.contact.v1.SendUserInvitationResponse;
import com.bytedance.lark.pb.im.v1.GetChatApplicationsRequest;
import com.bytedance.lark.pb.im.v1.ProcessChatApplicationRequest;
import com.bytedance.lark.pb.im.v2.GetContactTokenRequest;
import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.base.entity.ChatApplicationGetType;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.sdk.SdkSender;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418917a = 0;

    public static final class c implements SdkSender.IParser<Boolean> {
        public c() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Boolean parse(byte[] r100) {
            return Boolean.TRUE;
        }
    }

    static {
    }

    public static void a(IGetDataCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Command r101 = Command.GET_CONTACT_TOKEN_V2;
        GetContactTokenRequest.Builder r102 = new GetContactTokenRequest.Builder().strategy(SyncDataStrategy.LOCAL);
        InvApmUtils.GetDataCallback r103 = new InvApmUtils.GetDataCallback(r100, "ug_invite_external_nondirectional_get_invite_info", null, 4, null);
        final ProtoAdapter<GetContactTokenResponse> r104 = GetContactTokenResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r101, r102, r103, new a(r104));
    }

    public static void b(IGetDataCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Command r101 = Command.GET_CONTACT_TOKEN_V2;
        GetContactTokenRequest.Builder r102 = new GetContactTokenRequest.Builder();
        InvApmUtils.GetDataCallback r103 = new InvApmUtils.GetDataCallback(r100, "ug_invite_external_nondirectional_get_invite_info", null, 4, null);
        final ProtoAdapter<GetContactTokenResponse> r104 = GetContactTokenResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r101, r102, r103, new b(r104));
    }

    public static void e(String r100, boolean r101, UIGetDataCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r102, "callback");
        HashMap r103 = new HashMap();
        if (r101 == false) goto L5;
        String r104 = "phone";
    L6:
        r103.put("type", r104);
        Command r105 = Command.SEND_USER_INVITATION;
        SendUserInvitationRequest.Builder r106 = new SendUserInvitationRequest.Builder().contact_content(r100);
        if (r101 == false) goto L9;
        SendUserInvitationRequest.Type r107 = SendUserInvitationRequest.Type.MOBILE;
    L10:
        SendUserInvitationRequest.Builder r108 = r106.type(r107);
        InvApmUtils.GetDataCallback r109 = new InvApmUtils.GetDataCallback(r102, "ug_invite_external_orientation_invite", r103);
        final ProtoAdapter<SendUserInvitationResponse> r110 = SendUserInvitationResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r105, r108, r109, new i(r110));
        return;
    L9:
        r107 = SendUserInvitationRequest.Type.EMAIL;
        goto L10
    L5:
        r104 = "email";
        goto L6
    }

    public static void c(String r100, boolean r101, boolean r102, final IGetDataCallback r103) {
        ChatApplicationGetType r104 = ChatApplicationGetType.BEFORE;
        ChatApplication.Type r105 = ChatApplication.Type.FRIEND;
        IGetDataCallback<e9b.a> r106 = new ContactBaseService$getFriendRequests$1(r103);
        GetChatApplicationsRequest.Builder r107 = new GetChatApplicationsRequest.Builder().cursor(r100).count(20).type(com.bytedance.lark.pb.basic.v1.ChatApplication.Type.fromValue(r105.getNumber())).get_type(GetChatApplicationsRequest.GetType.fromValue(r104.getNumber()));
        if (r101 == false) goto L5;
        r107.sync_data_strategy(SyncDataStrategy.LOCAL);
    L5:
        if (r102 == false) goto L8;
        r107.ignore_chat_id_when_empty(Boolean.TRUE);
    L8:
        if (TextUtils.isEmpty("") == true) goto L10;
        r107.chat_id("");
    L10:
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_APPLICATIONS, r107, r106, com.ss.android.lark.contact.base.service.c.f418913a);
    }

    public static void d(String r100, ChatApplication.Status r101, Boolean r102, IGetDataCallback r103) {
        ProcessChatApplicationRequest.Builder r104 = new ProcessChatApplicationRequest.Builder().id(r100).status(com.bytedance.lark.pb.basic.v1.ChatApplication.Status.fromValue(r101.getNumber())).auth_sync(r102);
        SdkSender.asynSendRequestNonWrap(Command.PROCESS_CHAT_APPLICATION, r104, r103, new c());
    }
}
