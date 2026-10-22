package com.ss.android.lark.im.sdk.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.ContactSource;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.ChatChatterKickInfo;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatRequest;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatResponse;
import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.bytedance.lark.pb.im.v1.CreateChatResponse;
import com.bytedance.lark.pb.im.v1.CreateP2PChatSource;
import com.bytedance.lark.pb.im.v1.CreateP2PChatsRequest;
import com.bytedance.lark.pb.im.v1.CreateP2PChatsResponse;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickResponse;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsRequest;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsResponse;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.z0;
import com.ss.android.lark.im.sdk.utils.ExtensionsKt$toErrorIfNull$1;
import com.ss.android.lark.integrator.im.impl.ChatApiImpl$selectMessagesFromChat$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class f implements ImSdkChatService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f426094b;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f426095a;

        public b(f r100) {
            this.f426095a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
            Intrinsics.checkNotNullParameter(r101, "r");
            final f r102 = this.f426095a;
            return com.bytedance.lark.rustclient.api.t.e(r101, new ImSdkChatServiceImplV2$asyncGetChats$1$1(r102));
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f426096a = null;

        static {
            f426096a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
            Intrinsics.checkNotNullParameter(r101, "r");
            return com.bytedance.lark.rustclient.api.t.e(r101, ImSdkChatServiceImplV2$checkChattersInChat$1$1.INSTANCE);
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f426097a;

        public d(f r100) {
            this.f426097a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
            Intrinsics.checkNotNullParameter(r101, "r");
            final f r102 = this.f426097a;
            return com.bytedance.lark.rustclient.api.t.e(r101, new ImSdkChatServiceImplV2$createP2pChat$1$1(r102));
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T, R> f426098a = null;

        static {
            f426098a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
            Intrinsics.checkNotNullParameter(r101, "r");
            return com.bytedance.lark.rustclient.api.t.e(r101, ImSdkChatServiceImplV2$createP2pChats$1$1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.service.f$f, reason: collision with other inner class name */
    public static final class C5037f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f426099a;

        public C5037f(f r100) {
            this.f426099a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            f r102 = this.f426099a;
            MGetChatsResponse r103 = (MGetChatsResponse) r101.f253935c;
            r102.getClass();
            return f.c(r103);
        }
    }

    static {
    }

    public static Map c(MGetChatsResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Entity r101 = r100.entity;
        return com.ss.android.lark.parser.internal.h.d(r101.chats, r100.chat_option_info, r101.mail_setting);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat B2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        return (Chat) ((Map) ((com.bytedance.lark.rustclient.api.x) com.bytedance.lark.rustclient.api.t.b(a(CollectionsKt.listOf(r100), SyncDataStrategy.FORCE_SERVER)).blockingFirst()).f253935c).get(r100);
    L5:
        th = move-exception;
        Log.e("ImSdkChatServiceImplV2", "getServerChat failed， error:" + th.getMessage());
        return null;
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r110) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        GetChatChatterKickRequest.Builder r100 = new GetChatChatterKickRequest.Builder().chat_id(r110);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r111 = new com.bytedance.lark.rustclient.api.d(r100, GetChatChatterKickResponse.ADAPTER, Command.GET_CHAT_CHATTER_KICK_INFO, null, null, null, null, 248);
        GetChatChatterKickResponse r112 = (GetChatChatterKickResponse) com.bytedance.lark.rustclient.api.t.c(this.f426094b.h(r111).execute(), null);
        if (r112 == null) goto L8;
        ChatChatterKickInfo r113 = r112.chat_chatter_kick_info;
        if (r113 != null) goto L7;
        return null;
    L7:
        return new com.ss.android.lark.chat.entity.chat.b(r113.chat_id, r113.reason);
    L8:
        return null;
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat getLocalChat(String r110) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        List<String> r100 = CollectionsKt.listOf(r110);
        Intrinsics.checkNotNullParameter(r100, "chatIds");
        SyncDataStrategy r101 = SyncDataStrategy.TRY_LOCAL;
        z0.a();
        List<String> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        Map r104 = MapsKt.emptyMap();
    L16:
        return (Chat) r104.get(r110);
    L11:
        MGetChatsRequest.Builder r105 = new MGetChatsRequest.Builder().chat_ids(r100).strategy(r101);
        Intrinsics.checkNotNull(r105);
        com.bytedance.lark.rustclient.api.d r106 = new com.bytedance.lark.rustclient.api.d(r105, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        MGetChatsResponse r107 = (MGetChatsResponse) com.bytedance.lark.rustclient.api.t.c(this.f426094b.h(r106).execute(), null);
        if (r107 == null) goto L14;
        r104 = c(r107);
        goto L16
    L14:
        r104 = MapsKt.emptyMap();
        goto L16
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final String getOtherP2PChatterId(Chat r100) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        if (r100.getType() == Chat.Type.P2P) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r100.getP2pChatterId()) == false) goto L9;
        String r101 = r100.getKey();
        List<String> r102 = new Regex(":").split(r101, 0);
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        if (((String) r105).length() <= 0) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L12;
        r103.add(r105);
        goto L12
    L16:
        r106 = false;
        goto L17
    L19:
        String[] r107 = (String[]) r103.toArray(new String[0]);
        Iterator r108 = CollectionsKt.listOf(Arrays.copyOf(r107, r107.length)).iterator();
    L21:
        if (r108.hasNext() == false) goto L26;
        String r109 = (String) r108.next();
        if (Intrinsics.areEqual(r109, this.f426093a) == true) goto L21;
        return r109;
    L26:
        return r107[0];
    L9:
        return r100.getP2pChatterId();
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.a nd(String r100) {
        com.ss.android.lark.chat.entity.chat.a r101 = b(r100, true);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return b(r100, false);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat we(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        List<String> r101 = CollectionsKt.listOf(r100);
        Intrinsics.checkNotNullParameter(r101, "chatIds");
        Map r102 = (Map) ((com.bytedance.lark.rustclient.api.x) com.bytedance.lark.rustclient.api.t.b(a(r101, SyncDataStrategy.TRY_LOCAL)).blockingFirst()).f253935c;     // Catch: Throwable -> L5
    L8:
        return (Chat) r102.get(r100);
    L5:
        th = move-exception;
        Log.e("ImSdkChatServiceImplV2", "getChats failed， error:" + th.getMessage());
        r102 = MapsKt.emptyMap();
        goto L8
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat xc(String r110) {
        Intrinsics.checkNotNullParameter(r110, "chatterId");
        GetP2PChatsByChatterIdsRequest.Builder r100 = new GetP2PChatsByChatterIdsRequest.Builder().chatter_ids(CollectionsKt.listOf(r110));
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r101 = new com.bytedance.lark.rustclient.api.d(r100, GetP2PChatsByChatterIdsResponse.ADAPTER, Command.GET_P2P_CHATS_BY_CHATTER_IDS, null, null, null, null, 248);
        GetP2PChatsByChatterIdsResponse r102 = (GetP2PChatsByChatterIdsResponse) com.bytedance.lark.rustclient.api.t.c(this.f426094b.h(r101).execute(), null);
        if (r102 == null) goto L8;
        Map<String, com.bytedance.lark.pb.basic.v1.Chat> r103 = r102.chatter_id2chat;
        if (r103.keySet().contains(r110) == true) goto L7;
        return null;
    L7:
        return com.ss.android.lark.parser.internal.h.a(r103.get(r110), null);
    L8:
        return null;
    }

    @Inject
    public f(String r100, com.bytedance.lark.rustclient.api.l r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userClient");
        this.f426093a = r100;
        this.f426094b = r101;
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void C2(List<String> r110, IGetDataCallback<Map<String, Chat>> r111) {
        Intrinsics.checkNotNullParameter(r110, "chatterIds");
        Intrinsics.checkNotNullParameter(r111, "callback");
        CreateP2PChatsRequest.Builder r100 = new CreateP2PChatsRequest.Builder().chatter_ids(r110);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(r100, CreateP2PChatsResponse.ADAPTER, Command.CREATE_P2P_CHATS, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.f426094b.h(r112).a().map(e.f426098a), r111);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat P6(String r110, ImSdkChatService.Source r111) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        Intrinsics.checkNotNullParameter(r111, "source");
        MGetChatsRequest.Builder r100 = new MGetChatsRequest.Builder().chat_ids(CollectionsKt.mutableListOf(new String[]{r110})).strategy(SyncDataStrategy.FORCE_SERVER).should_auth(Boolean.TRUE).source(MGetChatsRequest.Source.fromValue(r111.getValue()));     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L5
        return (Chat) ((Map) com.bytedance.lark.rustclient.api.t.b(this.f426094b.h(new com.bytedance.lark.rustclient.api.d(r100, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248)).a()).map(new C5037f(this)).blockingFirst()).get(r110);
    L5:
        th = move-exception;
        Log.e("ImSdkChatServiceImplV2", "getServerChat failed， error:" + th.getMessage());
        return null;
    }

    public final Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Map<String, Chat>>> a(List<String> r110, SyncDataStrategy r111) {
        MGetChatsRequest.Builder r100 = new MGetChatsRequest.Builder().chat_ids(r110).strategy(r111).should_auth(Boolean.TRUE);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(r100, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        return this.f426094b.h(r112).a().map(new b(this));
    }

    public final com.ss.android.lark.chat.entity.chat.a b(String r110, boolean r111) {
        z0.a();
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
        return null;
    L12:
        MGetChatsRequest.Builder r101 = new MGetChatsRequest.Builder().chat_ids(CollectionsKt.listOf(r110));
        if (r111 == false) goto L15;
        SyncDataStrategy r112 = SyncDataStrategy.TRY_LOCAL;
    L16:
        MGetChatsRequest.Builder r102 = r101.strategy(r112);
        Intrinsics.checkNotNull(r102);
        com.bytedance.lark.rustclient.api.d r113 = new com.bytedance.lark.rustclient.api.d(r102, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        MGetChatsResponse r114 = (MGetChatsResponse) com.bytedance.lark.rustclient.api.t.c(this.f426094b.h(r113).execute(), null);
        if (r114 != null) goto L19;
        return null;
    L19:
        return ChatService.j(r110, r114);
    L15:
        r112 = SyncDataStrategy.FORCE_SERVER;
        goto L16
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L10
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void uc(List r100, ChatApiImpl$selectMessagesFromChat$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatIds");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.ss.android.lark.im.sdk.utils.e.b(a(r100, SyncDataStrategy.TRY_LOCAL).map(g.f426100a), r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void X5(String r110, ImSdkChatService.a r111, final IGetDataCallback<Chat> r112) {
        Intrinsics.checkNotNullParameter(r110, "chatterId");
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (r111 == null) goto L5;
        boolean r100 = r111.f426004a;
    L6:
        if (r111 == null) goto L8;
        ProfileSource r113 = r111.f426005b;
    L9:
        CreateChatRequest.Builder r101 = new CreateChatRequest.Builder().type(com.bytedance.lark.pb.basic.v1.Chat.Type.P2P).chatter_ids(CollectionUtils.asList(new String[]{r110, this.f426093a})).is_crypto(Boolean.valueOf(r100)).chat_mode(com.bytedance.lark.pb.basic.v1.Chat.ChatMode.DEFAULT);
        if (r113 == null) goto L12;
        r101.create_p2p_chat_source(new CreateP2PChatSource.Builder().source_type(ContactSource.fromValue(r113.f409891a)).sender_id_v2(r113.f409892b).source_id(r113.f409893c).source_name(r113.f409894d).build());
    L12:
        Intrinsics.checkNotNull(r101);
        Observable r114 = this.f426094b.h(new com.bytedance.lark.rustclient.api.d(r101, CreateChatResponse.ADAPTER, Command.CREATE_CHAT, null, null, null, null, 248)).a().map(new d(this));
        Intrinsics.checkNotNullParameter(r112, "<this>");
        com.ss.android.lark.im.sdk.utils.e.b(r114, new ExtensionsKt$toErrorIfNull$1(r112));
        return;
    L8:
        r113 = null;
        goto L9
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void Y6(List<String> r110, String r111, IGetDataCallback<Map<String, Boolean>> r112) {
        Intrinsics.checkNotNullParameter(r110, "chatterIds");
        Intrinsics.checkNotNullParameter(r111, "chatId");
        Intrinsics.checkNotNullParameter(r112, "callback");
        CheckChattersInChatRequest.Builder r100 = new CheckChattersInChatRequest.Builder().chat_id(r111).chatter_ids(r110);
        Intrinsics.checkNotNull(r100);
        com.bytedance.lark.rustclient.api.d r113 = new com.bytedance.lark.rustclient.api.d(r100, CheckChattersInChatResponse.ADAPTER, Command.CHECK_CHATTERS_IN_CHAT, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.f426094b.h(r113).a().map(c.f426096a), r112);
    }
}
