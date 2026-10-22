package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyRequest;
import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyResponse;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionRequest;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionResponse;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickResponse;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameRequest;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameResponse;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventResponse;
import com.bytedance.lark.pb.im.v1.TranslateChatNameRequest;
import com.bytedance.lark.pb.im.v1.TranslateChatNameResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class o implements a2b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f411619a;

    @Inject
    public o(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f411619a = r100;
    }

    @Override // a2b.a
    public final Map a(MGetChatsRequest.Builder r110, final a0 r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        return (Map) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f411619a.h(r100).execute(), new ChatRepositoryV2$syncGetChats$1(r111)), null);
    }

    @Override // a2b.a
    public final com.ss.android.lark.chat.entity.chat.b b(GetChatChatterKickRequest.Builder r110, final t r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetChatChatterKickResponse.ADAPTER, Command.GET_CHAT_CHATTER_KICK_INFO, null, null, null, null, 248);
        return (com.ss.android.lark.chat.entity.chat.b) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e((com.bytedance.lark.rustclient.api.s) this.f411619a.h(r100).a().blockingFirst(), new ChatRepositoryV2$getChatterKickInfo$1(r111)), null);
    }

    @Override // a2b.a
    public final Map f(MGetChatsRequest.Builder r110, final v r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        return (Map) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e((com.bytedance.lark.rustclient.api.s) this.f411619a.h(r100).a().blockingFirst(), new ChatRepositoryV2$syncGetChatsFromNet$1(r111)), null);
    }

    @Override // a2b.a
    public final void h(CreateChatLastReadPositionRequest.Builder r110, w r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, CreateChatLastReadPositionResponse.ADAPTER, Command.CREATE_CHAT_LAST_READ_POSITION, null, null, null, null, 248);
        Observable r112 = this.f411619a.h(r100).a().map(new l(r111));
        Intrinsics.checkNotNullParameter(r112, "<this>");
        r112.subscribe(new com.ss.android.lark.im.sdk.utils.c(null), new com.ss.android.lark.im.sdk.utils.d(null));
    }

    @Override // a2b.a
    public final void c(CreateAddChatChatterApplyRequest.Builder r110, x r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, CreateAddChatChatterApplyResponse.ADAPTER, Command.CREATE_ADD_CHAT_CHATTER_APPLY, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.f411619a.h(r100).a().map(new j(r111)), r112);
    }

    @Override // a2b.a
    public final void d(HideChatTranslatedNameRequest.Builder r110, r r111, ChatNameRenderer$doHideTranslate$1 r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, HideChatTranslatedNameResponse.ADAPTER, Command.HIDE_CHAT_TRANSLATED_NAME, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.f411619a.h(r100).a().map(new k(r111)), r112);
    }

    @Override // a2b.a
    public final void e(SubscribeChatEventRequest.Builder r110, b0 r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, SubscribeChatEventResponse.ADAPTER, Command.SUBSCRIBE_CHAT_EVENT, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.f411619a.h(r100).a().map(new m(r111)), r112);
    }

    @Override // a2b.a
    public final void g(TranslateChatNameRequest.Builder r110, e0 r111, ChatNameRenderer$doTranslate$1 r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, TranslateChatNameResponse.ADAPTER, Command.TRANSLATE_CHAT_NAME, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.f411619a.h(r100).a().map(new n(r111)), r112);
    }
}
