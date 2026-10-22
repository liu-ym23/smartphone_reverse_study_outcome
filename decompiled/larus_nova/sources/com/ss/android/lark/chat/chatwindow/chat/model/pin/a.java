package com.ss.android.lark.chat.chatwindow.chat.model.pin;

import com.bytedance.lark.pb.im.v1.GetChatPinInfoRequest;
import com.bytedance.lark.pb.im.v1.GetChatPinInfoResponse;
import com.bytedance.lark.pb.im.v1.PushChatPinInfo;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: classes35.dex */
public interface a {
    @SdkCall(4184)
    RucketJob<GetChatPinInfoResponse> getChatPinExtras(GetChatPinInfoRequest r100);

    @SdkPush(4185)
    RucketJob<PushChatPinInfo> pushChatPinExtras();
}
