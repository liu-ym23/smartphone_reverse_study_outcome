package com.ss.android.lark.contact.base.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v2.SetupBlockUserRequest;
import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.bytedance.lark.pb.im.v1.SendChatApplicationRequest;
import com.bytedance.lark.pb.im.v1.SendChatApplicationResponse;
import com.bytedance.lark.pb.im.v1.UpdateChatApplicationMeReadRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.customized.mygroup.repository.OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$acceptFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$applyFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$blockUser$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$deleteFriend$2$1;
import com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$updateChatApplicationMeRead$2$1;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class y implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IChatParser f418946a;

    public y() {
        this.f418946a = ContactBaseModuleDependency.f418857b.getChatParser();
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void i(IGetDataCallback r100) {
        RxScheduledExecutor.justInIO(new v(this, GetMyGroupChatsRequest.Type.JOIN, r100));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void a(String r100, OfficeProfileModel$acceptFriend$2$1 r101) {
        int r102 = d.f418917a;
        d.d(r100, ChatApplication.Status.AGREED, Boolean.TRUE, r101);
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void c(String r100, OfficeProfileModel$deleteFriend$2$1 r101) {
        ImSdkService.d().N7(r100, r101);
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void d(List r100, OfficeProfileModel$updateChatApplicationMeRead$2$1 r101) {
        int r102 = d.f418917a;
        Intrinsics.checkNotNullParameter(r100, "applicationIds");
        UpdateChatApplicationMeReadRequest.Builder r103 = new UpdateChatApplicationMeReadRequest.Builder().read_all_applications(Boolean.FALSE).application_ids(r100);
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_CHAT_APPLICATION_ME_READ, r103, r101, k.f418925a);
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void g(long r100, IGetDataCallback r101) {
        j(r100, GetMyGroupChatsRequest.Type.ADMINISTRATE, new DefaultOfficeContactRepository$4(this, r101));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void h(long r100, IGetDataCallback r101) {
        j(r100, GetMyGroupChatsRequest.Type.JOIN, new DefaultOfficeContactRepository$4(this, r101));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void e(String r100, boolean r101, OfficeProfileModel$blockUser$2$1 r102) {
        SetupBlockUserRequest.Builder r103 = new SetupBlockUserRequest.Builder().block_status(Boolean.valueOf(r101)).block_user_id(r100);
        SdkSender.asynSendRequestNonWrap(Command.SETUP_BLOCK_USER, r103, r102, new u());
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void f(long r100, GetMyGroupChatsRequest.Type r101, OfficeMyJoinGroupRepository$getMyJoinedGroupFromNet$1 r102) {
        j(r100, r101, r102);
    }

    public final void j(long r100, GetMyGroupChatsRequest.Type r101, IGetDataCallback r102) {
        SdkSender.asynSendRequestNonWrap(Command.GET_MY_GROUP_CHATS, new GetMyGroupChatsRequest.Builder().count(50).type(r101).time(Long.valueOf(r100)), r102, new x(this));
    }

    @Override // com.ss.android.lark.contact.base.service.z
    public final void b(String r100, String r101, String r102, ContactSource r103, final OfficeProfileModel$applyFriend$2$1 r104) {
        IGetDataCallback<SendChatApplicationResponse> r105 = new DefaultOfficeContactRepository$1(this, r104);
        SendChatApplicationRequest.Builder r106 = new SendChatApplicationRequest.Builder().token(null);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        r106.extra_message(r101);
    L6:
        if (TextUtils.isEmpty(null) == true) goto L8;
        r106.chat_id(null);
    L8:
        if (r103 == null) goto L10;
        r106.sender = r103.getSender();
        r106.source_name = r103.getSourceName();
        r106.source(com.bytedance.lark.pb.basic.v1.ContactSource.fromValue(r103.getSourceType()));
        r106.sender_id = r103.getSenderId();
        r106.source_id = r103.getSourceId();
        r106.sub_source_type = r103.getSubSourceType();
    L10:
        r106.user_alias = r102;
        r106.user_id = r100;
        StringBuilder r107 = new StringBuilder("send add friend request user tns:false sourceType=");
        if (r103 == null) goto L13;
        int r108 = r103.getSourceType();
    L14:
        r107.append(r108);
        Log.i("DefaultOfficeContactRepository", r107.toString());
        Command r109 = Command.SEND_CHAT_APPLICATION;
        final ProtoAdapter<SendChatApplicationResponse> r110 = SendChatApplicationResponse.ADAPTER;
        Objects.requireNonNull(r110);
        SdkSender.asynSendRequestNonWrap(r109, r106, r105, new t(r110));
        return;
    L13:
        r108 = -1;
        goto L14
    }
}
