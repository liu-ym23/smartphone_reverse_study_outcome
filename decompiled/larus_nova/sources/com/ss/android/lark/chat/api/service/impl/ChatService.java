package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.lark.pb.basic.v1.AddChatChatterApply;
import com.bytedance.lark.pb.basic.v1.ChatOptionInfo;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.OpenApp;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.AddChatChattersRequest;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatRequest;
import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyRequest;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionRequest;
import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.bytedance.lark.pb.im.v1.DeleteChatChattersRequest;
import com.bytedance.lark.pb.im.v1.DisableChatSharedRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.GetChatChattersRequest;
import com.bytedance.lark.pb.im.v1.GetMentionChatChattersRequest;
import com.bytedance.lark.pb.im.v1.GetMentionChatChattersResponse;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsRequest;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsResponse;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.TranslateChatNameRequest;
import com.bytedance.lark.pb.media.v1.GetChatResourcesRequest;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.AddChatChatterApply$Ways;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatSetting;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.integrator.im.impl.IIMApiImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.chats.CheckWithdrawPickEntitiesInChatRequest;
import com.ss.android.lark.pb.chats.CheckWithdrawPickEntitiesInChatResponse;
import com.ss.android.lark.pb.chats.PickEntities;
import com.ss.android.lark.pb.chats.PickType;
import com.ss.android.lark.pb.chats.UpdateChatUserAutoMuteSettingResponse;
import com.ss.android.lark.pb.entities.ChatBackgroundEntity;
import com.ss.android.lark.pb.entities.ChatTheme;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class ChatService implements IChatService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okb.h f411531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final okb.a f411532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a2b.a f411533c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.api.service.impl.ChatService$19, reason: invalid class name */
    class AnonymousClass19 implements IGetDataCallback<Map<String, Chat>> {
        final /* synthetic */ ChatService this$0;
        final /* synthetic */ IGetDataCallback val$callback;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            this.val$callback.onError(r100);
        }

        public void onSuccess(Map<String, Chat> r100) {
            Iterator<String> r101 = r100.keySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            if (r100.get(r101.next()).getRole().equals(Chat.Role.MEMBER) == false) goto L4;
            boolean r102 = true;
        L9:
            this.val$callback.onSuccess(Boolean.valueOf(r102));
            return;
        L8:
            r102 = false;
            goto L9
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((Map) r100);
        }

        public AnonymousClass19(ChatService r100, IGetDataCallback r101) {
            this.this$0 = r100;
            this.val$callback = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.api.service.impl.ChatService$6, reason: invalid class name */
    class AnonymousClass6 implements IGetDataCallback<UpdateChatUserAutoMuteSettingResponse> {
        final /* synthetic */ ChatService this$0;
        final /* synthetic */ IGetDataCallback val$callback;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.larksuite.framework.callback.IGetDataCallback
        public void onError(ErrorResult r100) {
            this.val$callback.onError(r100);
        }

        public void onSuccess(UpdateChatUserAutoMuteSettingResponse r100) {
            this.val$callback.onSuccess(Boolean.TRUE);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
            onError(r100);
        }

        @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
        public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
            onSuccess((UpdateChatUserAutoMuteSettingResponse) r100);
        }

        public AnonymousClass6(ChatService r100, IGetDataCallback r101) {
            this.this$0 = r100;
            this.val$callback = r101;
        }
    }

    public class a implements SdkSender.IParser<Chat> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f411534a;

        public a(String r100) {
            this.f411534a = r100;
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Chat parse(byte[] r100) throws IOException {
            Map<String, com.bytedance.lark.pb.basic.v1.Chat> r101 = GetP2PChatsByChatterIdsResponse.ADAPTER.decode(r100).chatter_id2chat;
            if (r101.keySet().contains(this.f411534a) == true) goto L5;
            return null;
        L5:
            return com.ss.android.lark.parser.internal.h.a(r101.get(this.f411534a), null);
        }
    }

    public class b implements SdkSender.IParser<Chat> {
        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final /* bridge */ /* synthetic */ Chat parse(byte[] r100) throws IOException {
            return null;
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatService f411535a = null;

        static {
            f411535a = new ChatService(new i());
        }
    }

    public static List g() {
        ArrayList r100 = new ArrayList();
        if (CollectionUtils.isEmpty(null) == false) goto L5;
        return r100;
    L5:
        throw null;
    }

    @Inject
    public ChatService(a2b.a r100) {
        this.f411531a = ImSdkProxy.e();
        this.f411532b = ImSdkProxy.b();
        this.f411533c = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.ss.android.lark.chat.api.service.impl.t] */
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
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r100) {
        return this.f411533c.b(new GetChatChatterKickRequest.Builder().chat_id(r100), new t());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final boolean checkLoginUserExistedInLocalChat(Chat r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getRole() != Chat.Role.MEMBER) goto L9;
        return true;
    L9:
        return false;
    }

    public final com.ss.android.lark.chat.entity.chat.a f(final String r100) {
        com.ss.android.lark.chat.entity.chat.a r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        List<String> r102 = Collections.singletonList(r100);
        if (CollectionUtils.isEmpty(r102) == true) goto L9;
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r103 = new MGetChatsRequest.Builder().chat_ids(r102);
        r101 = (com.ss.android.lark.chat.entity.chat.a) SdkSender.syncSend(Command.MGET_CHATS, r103, new p(r100));
    L9:
        if (r101 != null) goto L11;
    L13:
        com.ss.android.lark.chat.utils.z0.a();
        com.ss.android.lark.chat.entity.chat.a r104 = (com.ss.android.lark.chat.entity.chat.a) SdkSender.sendRequest(Command.MGET_CHATS, new MGetChatsRequest.Builder().chat_ids(Collections.singletonList(r100)).should_auth(Boolean.TRUE), new n0(r100));
        if (r104 == null) goto L16;
        return r104;
    L16:
        return new com.ss.android.lark.chat.entity.chat.a();
    L11:
        if (r101.f415170a == null) goto L13;
        return r101;
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getChatById(String r100) {
        com.ss.android.lark.chat.utils.z0.a();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        Chat r101 = getLocalChat(r100);
        if (r101 == null) goto L9;
        return r101;
    L9:
        Map<String, Chat> r102 = n(Collections.singletonList(r100));
        if (CollectionUtils.isEmpty(r102) == false) goto L12;
        return r101;
    L12:
        return r102.get(r100);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getLocalChat(String r100) {
        return i(Collections.singletonList(r100)).get(r100);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getP2pChatByChatterId(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        List<String> r101 = Collections.singletonList(r100);
        GetP2PChatsByChatterIdsRequest.Builder r102 = new GetP2PChatsByChatterIdsRequest.Builder().chatter_ids(r101);
        return (Chat) SdkSender.syncSend(Command.GET_P2P_CHATS_BY_CHATTER_IDS, r102, new a(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.ss.android.lark.chat.api.service.impl.a0] */
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
    public final int h(String r100) {
        List<String> r101 = Collections.singletonList(r100);
        HashMap r102 = new HashMap();
        if (CollectionUtils.isEmpty(r101) == true) goto L14;
        Map r103 = new HashMap();
        if (CollectionUtils.isEmpty(r101) == true) goto L9;
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r104 = new MGetChatsRequest.Builder().chat_ids(r101);
        r103 = this.f411533c.a(r104, new a0());
    L9:
        HashMap r105 = new HashMap();
        Iterator r106 = r103.values().iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        Chat r107 = (Chat) r106.next();
        r105.put(r107.getId(), Integer.valueOf(r107.getLastMessagePosition()));
        goto L11
    L13:
        r102 = r105;
    L14:
        Integer r108 = (Integer) r102.get(r100);
        if (r108 != null) goto L18;
        return 0;
    L18:
        return r108.intValue();
    }

    public final Map<String, Chat> i(List<String> r100) {
        HashMap r101 = new HashMap();
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r102 = new MGetChatsRequest.Builder().chat_ids(r100);
        Map<String, Chat> r103 = (Map) SdkSender.syncSend(Command.MGET_CHATS, r102, new y());
        if (r103 == null) goto L8;
        return r103;
    L8:
        return new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.chat.api.service.impl.v] */
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
    public final Map<String, Chat> n(List<String> r100) {
        ArrayList r101 = new ArrayList(r100);
        Map<String, Chat> r102 = i(r101);
        r101.removeAll(r102.keySet());
        if (r101.isEmpty() == false) goto L5;
        return r102;
    L5:
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r103 = new MGetChatsRequest.Builder().chat_ids(r101).should_auth(Boolean.TRUE).strategy(SyncDataStrategy.FORCE_SERVER);
        Map<? extends String, ? extends Chat> r104 = this.f411533c.f(r103, new v());
        if (r104 != null) goto L8;
        r104 = new HashMap();
    L8:
        r102.putAll(r104);
        return r102;
    }

    public static com.ss.android.lark.chat.entity.chat.a j(String r110, MGetChatsResponse r111) {
        Entity r100 = r111.entity;
        l(r100.chats, new HashMap());
        HashMap r101 = new HashMap(com.ss.android.lark.parser.internal.j.b(r100, r110).f415194a);
        Map<String, com.bytedance.lark.pb.basic.v1.Chat> r102 = r100.chats;
        Map<String, OpenApp> r103 = r100.open_apps;
        Map<String, ChatOptionInfo> r104 = r111.chat_option_info;
        Map<Long, ByteString> r105 = r100.chat_themes;
        HashMap r106 = new HashMap();
        Iterator<String> r107 = r102.keySet().iterator();
    L3:
        ChatThemeInfo r108 = null;
        ChatThemeInfo.ThemeType r109 = null;
        r108 = null;
        if (r107.hasNext() == false) goto L8;
        String r112 = r107.next();
        Chat r113 = com.ss.android.lark.parser.internal.h.a(r102.get(r112), null);
        if (r113 == null) goto L3;
        r106.put(r112, r113);
        goto L3
    L8:
        HashMap r114 = new HashMap();
        Iterator<String> r115 = r103.keySet().iterator();
    L10:
        if (r115.hasNext() == false) goto L14;
        String r116 = r115.next();
        OpenApp r117 = r103.get(r116);
        if (r117 == null) goto L10;
        r114.put(r116, com.ss.android.lark.parser.internal.h.c(r117));
        goto L10
    L14:
        Iterator r118 = r101.entrySet().iterator();
    L16:
        if (r118.hasNext() == false) goto L22;
        Chatter r119 = (Chatter) ((Map.Entry) r118.next()).getValue();
        if (r119 == null) goto L16;
        if (r119.getType() != Chatter.ChatterType.BOT) goto L16;
    L23:
        Chat r120 = (Chat) r106.get(r110);
        com.ss.android.lark.chat.entity.chat.ChatOptionInfo r121 = new com.ss.android.lark.chat.entity.chat.ChatOptionInfo();
        if (CollectionUtils.isNotEmpty(r104) == true) goto L26;
    L30:
        if (r120 == null) goto L32;
        r120.setChatOptionInfo(r121);
    L32:
        if (r119 != null) goto L34;
    L39:
        com.ss.android.lark.biz.im.api.OpenApp r122 = new com.ss.android.lark.biz.im.api.OpenApp();
    L40:
        if (r120 == null) goto L77;
        long r123 = r120.getThemeId();
        int r124 = com.ss.android.lark.parser.internal.m.f437631a;
        Intrinsics.checkNotNullParameter(r105, "chatThemes");
        ByteString r125 = r105.get(Long.valueOf(r123));
        if (r125 == null) goto L77;
        ChatTheme r126 = ChatTheme.ADAPTER.decode(r125);
        ChatBackgroundEntity r127 = r126.mbackground_entity;
        if (r127 == null) goto L57;
        com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode.a r128 = com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode.Companion;
        int r129 = r127.mmode.getValue();
        r128.getClass();
        com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode r130 = com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode.a.a(r129);
        ChatBackgroundEntity.ColorInfo r131 = r127.mcolor;
        if (r131 == null) goto L49;
        String r132 = r131.mud_token;
    L50:
        if (r131 == null) goto L52;
        Integer r133 = r131.mlight_color;
    L53:
        if (r131 == null) goto L55;
        Integer r134 = r131.mdark_color;
    L56:
        com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity r135 = new com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity(r130, new com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.ColorInfo(r132, r133, r134), r127.mimage_key, r127.mfsunit);
    L58:
        ChatTheme.Scene r136 = r126.mcomponent_scene;
        if (r136 == null) goto L71;
        ChatThemeInfo.Scene.a r137 = ChatThemeInfo.Scene.Companion;
        int r138 = r136.getValue();
        r137.getClass();
        if (r138 != 0) goto L63;
        ChatThemeInfo.Scene r139 = ChatThemeInfo.Scene.DEFAULT_SCENE;
    L70:
        ChatThemeInfo.Scene r140 = r139;
    L72:
        Long r141 = r126.mid;
        String r142 = r126.mname;
        HashMap r143 = new HashMap();
        r143.putAll(r126.mi18n_name);
        ChatTheme.ThemeType r144 = r126.mtheme_type;
        if (r144 == null) goto L75;
        ChatThemeInfo.ThemeType.a r145 = ChatThemeInfo.ThemeType.Companion;
        Integer r146 = Integer.valueOf(r144.getValue());
        r145.getClass();
        r109 = ChatThemeInfo.ThemeType.a.a(r146);
    L75:
        r108 = new ChatThemeInfo(r141, r135, r140, r142, r143, r109);
        goto L77
    L63:
        if (r138 != 1) goto L65;
        r139 = ChatThemeInfo.Scene.DARK;
        goto L70
    L65:
        if (r138 == 2) goto L67;
        r139 = null;
        goto L70
    L67:
        r139 = ChatThemeInfo.Scene.BRIGHT;
        goto L70
    L71:
        r140 = null;
        goto L72
    L55:
        r134 = null;
        goto L56
    L52:
        r133 = null;
        goto L53
    L49:
        r132 = null;
        goto L50
    L57:
        r135 = null;
    L77:
        return new com.ss.android.lark.chat.entity.chat.a(r120, r122, r119, r108);
    L34:
        if (r114.size() == 0) goto L39;
        r122 = (com.ss.android.lark.biz.im.api.OpenApp) r114.get(r119.getOpenAppId());
        if (r122 != null) goto L40;
        r122 = new com.ss.android.lark.biz.im.api.OpenApp();
        goto L40
    L26:
        if (r104.get(r110) == null) goto L30;
        ChatOptionInfo r147 = r104.get(r110);
        if (r147 == null) goto L30;
        r121.setAnnounceIsUnread(r147.announce.booleanValue());
        r121.setId(r147.f253453id);
        goto L30
    L22:
        r119 = null;
        goto L23
    }

    public static void l(Map<String, com.bytedance.lark.pb.basic.v1.Chat> r100, Map<String, ChatSetting> r101) {
        Iterator<String> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        com.bytedance.lark.pb.basic.v1.Chat r104 = r100.get(r103);
        ChatSetting r105 = new ChatSetting();
        r105.setChatId(r103);
        r105.setUpdateTime(r104.update_time.longValue());
        r105.setRemind(r104.is_remind.booleanValue());
        r105.setInBox(r104.is_in_box.booleanValue());
        ((HashMap) r101).put(r103, r105);
        goto L4
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Ac(final String r100, UIGetDataCallback r101) {
        GetChatChattersRequest.Builder r102 = new GetChatChattersRequest.Builder().chat_id(r100).offset(0);
        r102.is_from_server(Boolean.TRUE);
        r102.filter(null);
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_CHATTERS, r102, r101, new d0(this, r100));
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void U6(String r100, IGetDataCallback<Boolean> r101) {
        DisableChatSharedRequest.Builder r102 = new DisableChatSharedRequest.Builder().message_id(r100);
        SdkSender.asynSendRequestNonWrap(Command.DISABLE_CHAT_SHARED, r102, r101, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    public final void e(String r100, IGetDataCallback r101) {
        this.f411531a.getCurrentUserId();
        SdkSender.asynSendRequestNonWrap(Command.CREATE_CHAT, new CreateChatRequest.Builder().type(com.bytedance.lark.pb.basic.v1.Chat.Type.P2P).chatter_ids(CollectionUtils.asList(new String[]{r100})).is_crypto(Boolean.FALSE).chat_mode(com.bytedance.lark.pb.basic.v1.Chat.ChatMode.DEFAULT), r101, new f0(this), new com.ss.android.lark.sdk.h());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void getP2pChatCreatedByChatterId(final String r100, final IGetDataCallback<Chat> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r101.onError(new ErrorResult("chatterId is empty"));
        return;
    L6:
        RxScheduledExecutor.justInIO(new c0(this, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.r] */
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
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void y3(String r100, ChatNameRenderer$doHideTranslate$1 r101) {
        Long r102 = Long.valueOf(CastLongProtector.parseLong(r100));     // Catch: NumberFormatException -> L5
        HideChatTranslatedNameRequest.Builder r103 = new HideChatTranslatedNameRequest.Builder().chat_id(r102);
        this.f411533c.d(r103, new r(), r101);
        return;
    }

    public static void b(String r100, Iterable r101, IGetDataCallback r102) {
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add((String) r104.next());
        goto L4
    L6:
        AddChatChattersRequest.Builder r105 = new AddChatChattersRequest.Builder().chat_id(r100).chatter_ids(r103).type(AddChatChattersRequest.Type.INVITATION);
        SdkSender.asynSendRequestNonWrap(Command.ADD_CHAT_CHATTERS, r105, r102, new b());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void L9(String r100, String r101, final IIMApiImpl.AnonymousClass1 r102) {
        Chat r103 = getP2pChatByChatterId(r100);
        if (r103 == null) goto L5;
        r102.onSuccess(r103);
        return;
    L5:
        e(r100, new AnonymousClass26(this, r102));
    }

    public final void c(List<String> r100, String r101, IGetDataCallback<Map<String, Boolean>> r102) {
        CheckChattersInChatRequest.Builder r103 = new CheckChattersInChatRequest.Builder().chat_id(r101).chatter_ids(r100);
        SdkSender.asynSendRequestNonWrap(Command.CHECK_CHATTERS_IN_CHAT, r103, r102, new s());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void f2(List<GroupRecallEntity> r100, String r101, final IGetDataCallback<List<GroupRecallEntity>> r110) {
        final HashMap r102 = new HashMap(r100.size());
        Iterator<GroupRecallEntity> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        GroupRecallEntity r104 = r103.next();
        r102.put(r104.f415166b, r104);
        goto L4
    L6:
        CheckWithdrawPickEntitiesInChatRequest.Builder r105 = new CheckWithdrawPickEntitiesInChatRequest.Builder();
        r105.mchat_id = r101;
        int r106 = com.ss.android.lark.parser.internal.v.f437635a;
        Intrinsics.checkNotNullParameter(r100, "sourcePickEntities");
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator<GroupRecallEntity> r108 = r100.iterator();
    L8:
        if (r108.hasNext() == false) goto L33;
        GroupRecallEntity r109 = r108.next();
        Integer r111 = Integer.valueOf(r109.f415165a);
        if (r111 != null) goto L13;
    L15:
        if (r111 != null) goto L18;
    L20:
        if (r111 != null) goto L23;
    L25:
        PickType r112 = PickType.UNKNOWN;
    L26:
        Pair r113 = (Pair) r107.get(r112);
        if (r113 != null) goto L29;
        PickEntities.Builder r114 = new PickEntities.Builder().pick_type(r112);
        Pair r115 = new Pair(new ArrayList(), r114);
        r107.put(r112, r115);
        r113 = r115;
    L29:
        List r116 = (List) r113.first;
        String r117 = r109.f415166b;
        if (r117 != null) goto L32;
        r117 = "";
    L32:
        r116.add(r117);
        goto L8
    L23:
        if (r111.intValue() != 3) goto L25;
        r112 = PickType.DEPT;
        goto L26
    L18:
        if (r111.intValue() != 1) goto L20;
        r112 = PickType.USER;
        goto L26
    L13:
        if (r111.intValue() != 2) goto L15;
        r112 = PickType.CHAT;
        goto L26
    L33:
        ArrayList r118 = new ArrayList(r107.values().size());
        Iterator r119 = r107.values().iterator();
    L35:
        if (r119.hasNext() == false) goto L37;
        Pair r120 = (Pair) r119.next();
        PickEntities.Builder r121 = (PickEntities.Builder) r120.second;
        r121.pick_ids((List) r120.first);
        r118.add(r121.build());
        goto L35
    L37:
        r105.mpick_entities = r118;
        com.ss.android.lark.pb.improto.Command r122 = com.ss.android.lark.pb.improto.Command.CHECK_WITHDRAW_PICK_ENTITIES_IN_CHAT;
        IGetDataCallback<CheckWithdrawPickEntitiesInChatResponse> r123 = new AnonymousClass7(this, r102, r110);
        final ProtoAdapter<CheckWithdrawPickEntitiesInChatResponse> r124 = CheckWithdrawPickEntitiesInChatResponse.ADAPTER;
        Objects.requireNonNull(r124);
        SdkSender.sendPassThroughRequest(r122, r105, r123, new u(r124));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.ss.android.lark.chat.api.service.impl.w] */
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
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t8(String r100, int r101, int r102) {
        CreateChatLastReadPositionRequest.Builder r103 = new CreateChatLastReadPositionRequest.Builder();
        r103.chat_id(r100).position(Integer.valueOf(r101)).offset(Float.valueOf(r102));
        this.f411533c.h(r103, new w());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t9(String r100, String r101, UIGetDataCallback r102) {
        AddChatChattersRequest.Builder r103 = new AddChatChattersRequest.Builder().message_id(r100).join_token(r101).type(AddChatChattersRequest.Type.SHARE);
        SdkSender.asynSendRequestNonWrap(Command.ADD_CHAT_CHATTERS, r103, r102, new j0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.chat.api.service.impl.b0] */
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
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void u2(List<String> r100, List<String> r101, SubscribeChatEventRequest.SubscriptionKey r102) {
        SubscribeChatEventRequest.Builder r103 = new SubscribeChatEventRequest.Builder();
        if (CollectionUtils.isNotEmpty(r100) == false) goto L6;
        r103.subscribe_chat_ids(r100);
    L6:
        if (CollectionUtils.isNotEmpty(r101) == false) goto L8;
        r103.unsubscribe_chat_ids(r101);
    L8:
        if (r102 == null) goto L10;
        r103.subscription_key(r102);
    L10:
        IGetDataCallback<String> r104 = new AnonymousClass31(this);
        this.f411533c.e(r103, new b0(), r104);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse ze(String r100, String r101, ImageHistoryResponse.Direction r102) {
        GetChatResourcesRequest.Builder r103 = new GetChatResourcesRequest.Builder().chat_id(r100).direction(GetChatResourcesRequest.Direction.fromValue(r102.getNumber())).count(10);
        if (CollectionUtils.isEmpty(g()) == true) goto L6;
        r103.resource_types(g());
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r103.message_id(r101);
    L9:
        return (ImageHistoryResponse) SdkSender.syncSend(Command.GET_CHAT_RESOURCES, r103, new l0(r100));
    }

    public static void a(String r100, List r101, List r102, com.ss.android.lark.chat.entity.chatter.a r103) {
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        String r105 = (String) r104.next();
        ChatChatter r106 = r103.b(r100, r105);
        if (r106 != null) goto L7;
        Log.e("ChatService", "has no chatter entity, chatId: " + r100 + "  chatterId: " + r105);
        goto L4
    L7:
        ((ArrayList) r102).add(r106);
        goto L4
    }

    public static ccb.d k(String r100, String r110, GetMentionChatChattersResponse r111, boolean r112) {
        if (r111 == null) goto L39;
        Entity r101 = r111.entity;
        if (r101 == null) goto L39;
        com.ss.android.lark.chat.entity.chatter.a r102 = com.ss.android.lark.parser.internal.j.b(r101, r110);
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        Iterator<String> r107 = r111.wanted_mention_ids.iterator();
    L8:
        if (r107.hasNext() == false) goto L14;
        ChatChatter r108 = r102.b(r110, r107.next());
        if (r108 == null) goto L8;
        r103.add(r108);
        if (r112 == true) goto L8;
        r108.setChatterSensitiveInfo(new ChatterSensitiveInfo());
        goto L8
    L14:
        Iterator<String> r109 = r111.in_chat_chatter_ids.iterator();
    L16:
        if (r109.hasNext() == false) goto L22;
        ChatChatter r113 = r102.b(r110, r109.next());
        if (r113 == null) goto L16;
        r104.add(r113);
        if (r112 == true) goto L16;
        r113.setChatterSensitiveInfo(new ChatterSensitiveInfo());
        goto L16
    L22:
        Iterator<String> r114 = r111.out_chat_chatter_ids.iterator();
    L24:
        if (r114.hasNext() == false) goto L31;
        ChatChatter r115 = r102.b(r110, r114.next());
        if (r115 == null) goto L24;
        r105.add(new ChatChatter(r115));
        if (r112 == true) goto L24;
        r115.setChatterSensitiveInfo(new ChatterSensitiveInfo());
        goto L24
    L31:
        if (vab.a.f553988c == false) goto L37;
        Iterator<GetMentionChatChattersResponse.UserGroupEntity> r116 = r111.user_groups.iterator();
    L34:
        if (r116.hasNext() == false) goto L37;
        GetMentionChatChattersResponse.UserGroupEntity r117 = r116.next();
        r106.add(new UserGroupEntity(r117.group_id.toString(), r117.group_name, r117.group_member_count.toString(), r117.group_member_in_chat_count.toString()));
    L37:
        return new ccb.d(r103, r104, r105, r106, r111.wanted_mention_tags, r111.show_search.booleanValue(), r100);
    L39:
        return new ccb.d();
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Dc(String r100, Iterable r101, Iterable r102, IGetDataCallback r103) {
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add((String) r105.next());
        goto L4
    L6:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        r106.add((PickChatEntity) r107.next());
        goto L8
    L10:
        List<com.bytedance.lark.pb.basic.v1.PickEntities> r108 = com.ss.android.lark.parser.internal.v.a(r106);
        if (CollectionUtils.isEmpty(r104) == false) goto L30;
        Intrinsics.checkNotNullParameter(r106, "sourcePickEntities");
        ArrayList r109 = new ArrayList();
        Iterator r110 = r106.iterator();
    L14:
        if (r110.hasNext() == false) goto L21;
        Object r111 = r110.next();
        if (((PickChatEntity) r111).f415165a != 1) goto L18;
        boolean r112 = true;
    L19:
        if (r112 == false) goto L14;
        r109.add(r111);
        goto L14
    L18:
        r112 = false;
        goto L19
    L21:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r109.iterator();
    L23:
        if (r114.hasNext() == false) goto L28;
        String r115 = ((PickChatEntity) r114.next()).f415166b;
        if (r115 == null) goto L23;
        r113.add(r115);
        goto L23
    L28:
        if (CollectionUtils.isNotEmpty(r113) == false) goto L30;
        r104.addAll(r113);
    L30:
        DeleteChatChattersRequest.Builder r116 = new DeleteChatChattersRequest.Builder().chat_id(r100).chatter_ids(r104).pick_entities(r108).option(new DeleteChatChattersRequest.DeleteChatChatterOption.Builder().withdraw(true).build());
        SdkSender.asynSendRequestNonWrap(Command.DELETE_CHAT_CHATTERS, r116, r103, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ccb.d M2(String r100, String r101, String r102, boolean r110) {
        return o(r100, r101, r102, r110, false);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse Ne(String r100, String r101, ImageHistoryResponse.Direction r102, int r103) {
        GetChatResourcesRequest.Builder r104 = new GetChatResourcesRequest.Builder().chat_id(r100).direction(GetChatResourcesRequest.Direction.fromValue(r102.getNumber())).count(Integer.valueOf(r103));
        if (CollectionUtils.isEmpty(g()) == true) goto L6;
        r104.resource_types(g());
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r104.message_id(r101);
    L9:
        return (ImageHistoryResponse) SdkSender.syncSend(Command.GET_CHAT_RESOURCES, r104, new m0(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.chat.api.service.impl.e0] */
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
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void h3(String r100, String r101, boolean r102, ChatNameRenderer$doTranslate$1 r103) {
        Long r104 = Long.valueOf(CastLongProtector.parseLong(r100));     // Catch: NumberFormatException -> L5
        TranslateChatNameRequest.Builder r105 = new TranslateChatNameRequest.Builder().chat_id(r104).is_manual(Boolean.TRUE).target_language(r101).is_switch_language(Boolean.valueOf(r102));
        this.f411533c.g(r105, new e0(), r103);
        return;
    }

    public final ccb.d o(final String r100, final String r101, final String r102, boolean r103, boolean r104) {
        GetMentionChatChattersRequest.Builder r105 = new GetMentionChatChattersRequest.Builder();
        r105.chat_id(r100).query(r101).is_from_server(Boolean.valueOf(r103)).enableAiKnowledge(Boolean.valueOf(r104));
        return (ccb.d) SdkSender.sendRequest(Command.GET_MENTION_CHAT_CHATTERS, r105, r102, new z(this, r102, r100, r101));
    }

    public final void m(final String r100, final String r101, final String r102, boolean r103, boolean r104, IGetDataCallback<ccb.d> r105) {
        GetMentionChatChattersRequest.Builder r106 = new GetMentionChatChattersRequest.Builder();
        r106.chat_id(r100).query(r101).is_from_server(Boolean.valueOf(r103)).enableAiKnowledge(Boolean.valueOf(r104));
        StringBuilder r107 = new StringBuilder("searchMentionChatChatters has query : ");
        r107.append(!TextUtils.isEmpty(r101));
        Log.i("ChatService", r107.toString());
        SdkSender.asynSendRequestNonWrap(Command.GET_MENTION_CHAT_CHATTERS, r106, r102, r105, new q(this, r102, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.ss.android.lark.chat.api.service.impl.x] */
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
    public final void d(String r100, AddChatChatterApply$Ways r101, List<String> r102, String r103, String r104, String r105, IGetDataCallback<Boolean> r106) {
        CreateAddChatChatterApplyRequest.Builder r107 = new CreateAddChatChatterApplyRequest.Builder().chat_id(r100).way(AddChatChatterApply.Ways.fromValue(r101.getValue())).reason(r103).chatter_ids(r102).inviter_id(r104).join_token(r105);
        if (TextUtils.isEmpty(null) == true) goto L5;
        r107.event_id(null);
    L5:
        this.f411533c.c(r107, new x(), r106);
    }
}
