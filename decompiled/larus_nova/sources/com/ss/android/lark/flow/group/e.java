package com.ss.android.lark.flow.group;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetChatLinkInfoRequest;
import com.bytedance.lark.pb.im.v1.GetChatQRCodeInfoRequest;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.api.service.impl.g0;
import com.ss.android.lark.chat.api.service.impl.h0;
import com.ss.android.lark.dto.chat.ChatLinkInfoResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.c0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends ova.d {
    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        return true;
    }

    public e() {
    }

    @Override // ova.p
    public final boolean a(Context r100, AppLink r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Uri r102 = UriProtector.parse(r101.f408912a);
        final String r103 = UriProtector.getQueryParameter(r102, "link_token");
        if (TextUtils.isEmpty(r103) == false) goto L8;
        Log.e("FlowGroupAppLinkHandler", "handle link or qrcode appLink failed: token from url is invalid!");
        return true;
    L8:
        if (TextUtils.equals(UriProtector.getQueryParameter(r102, "qr_code"), "true") == false) goto L13;
        Log.i("FlowGroupAppLinkHandler", "handle qrcode");
        int r104 = a.f423660a;
        FlowGroupAppLinkHandler$1 r105 = new FlowGroupAppLinkHandler$1(this, r103, r100);
        Intrinsics.checkNotNullParameter(r103, "token");
        Intrinsics.checkNotNullParameter(r105, "callback");
        ChatService.c.f411535a.getClass();
        GetChatQRCodeInfoRequest.Builder r106 = new GetChatQRCodeInfoRequest.Builder();
        if (TextUtils.isEmpty(r103) == true) goto L19;
        r106.token(r103);
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_QRCODE_INFO, r106, r105, new g0());
        return true;
    L19:
        return true;
    L13:
        Log.i("FlowGroupAppLinkHandler", "handle link");
        final Context r107 = r100.getApplicationContext();
        UICallbackExecutor.execute(new c0());
        int r108 = a.f423660a;
        final IGetDataCallback<FlowChatLinkInfoResponse> r109 = new FlowGroupAppLinkHandler$2(this, r103, r107);
        Intrinsics.checkNotNullParameter(r103, "token");
        Intrinsics.checkNotNullParameter(r109, "callback");
        ChatService r110 = ChatService.c.f411535a;
        IGetDataCallback<ChatLinkInfoResponse> r111 = new FlowChatQRCodeDependency$getChatLinkInfo$1(r109, r103);
        r110.getClass();
        GetChatLinkInfoRequest.Builder r112 = new GetChatLinkInfoRequest.Builder();
        r112.token(r103);
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_SHARE_LINK_INFO, r112, r111, new h0());
        return true;
    }
}
