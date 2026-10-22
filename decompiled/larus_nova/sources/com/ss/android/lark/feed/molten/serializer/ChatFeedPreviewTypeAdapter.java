package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ChatFeedPreviewTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/shared/data/preview/ChatFeedPreview;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;", "chatTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "chatModeAdapter", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "lastMessageTypeAdapter", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "tagListAdapter", "", "Lcom/bytedance/lark/pb/basic/v1/Tag;", "statusListAdapter", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "chatRoleAdapter", "Lcom/ss/android/lark/chat/entity/chat/Chat$Role;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFeedPreviewTypeAdapter extends JsonTreeTypeAdapter<ChatFeedPreview> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f421068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<Chat.Type> f421069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TypeAdapter<Chat.ChatMode> f421070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TypeAdapter<Message.Type> f421071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TypeAdapter<List<Tag>> f421072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TypeAdapter<List<Chatter.ChatterCustomStatus>> f421073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TypeAdapter<Chat.Role> f421074g;

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ ChatFeedPreview a(JsonObject r100) {
        return c(r100);
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ JsonObject b(ChatFeedPreview r100) {
        return d(r100);
    }

    public final ChatFeedPreview c(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        ChatFeedPreview r101 = new ChatFeedPreview();
        this.f421068a.a(r100, r101);
        Boolean r102 = a.c(r100, "isBotChat");
        int r103 = 0;
        if (r102 == null) goto L5;
        boolean r104 = r102.booleanValue();
    L6:
        r101.setBotChat(r104);
        Boolean r105 = a.c(r100, "isBotMute");
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        r101.setBotMute(r106);
        Boolean r107 = a.c(r100, "isBlocked");
        if (r107 == null) goto L13;
        boolean r108 = r107.booleanValue();
    L14:
        r101.setBlocked(r108);
        Boolean r109 = a.c(r100, "isMeeting");
        if (r109 == null) goto L17;
        boolean r110 = r109.booleanValue();
    L18:
        r101.setMeeting(r110);
        Boolean r111 = a.c(r100, "isSecret");
        if (r111 == null) goto L21;
        boolean r112 = r111.booleanValue();
    L22:
        r101.setSecret(r112);
        Boolean r113 = a.c(r100, "isShowBotTag");
        if (r113 == null) goto L25;
        boolean r114 = r113.booleanValue();
    L26:
        r101.setShowBotTag(r114);
        Boolean r115 = a.c(r100, "isShowAgentTag");
        if (r115 == null) goto L29;
        boolean r116 = r115.booleanValue();
    L30:
        r101.setShowAgentTag(r116);
        Boolean r117 = a.c(r100, "isCrossWithKa");
        if (r117 == null) goto L33;
        boolean r118 = r117.booleanValue();
    L34:
        r101.setCrossWithKa(r118);
        Chat.Type r119 = (Chat.Type) a.k(r100, "chatType", this.f421069b);
        if (r119 == null) goto L37;
        r101.setChatType(r119);
    L37:
        Chat.ChatMode r120 = (Chat.ChatMode) a.k(r100, "chatMode", this.f421070c);
        if (r120 == null) goto L40;
        r101.setChatMode(r120);
    L40:
        Message.Type r121 = (Message.Type) a.k(r100, "lastMessageType", this.f421071d);
        if (r121 == null) goto L43;
        r101.setLastMessageType(r121);
    L43:
        Boolean r122 = a.c(r100, "isDepartment");
        if (r122 == null) goto L46;
        boolean r123 = r122.booleanValue();
    L47:
        r101.setDepartment(r123);
        Boolean r124 = a.c(r100, "isTenantChat");
        if (r124 == null) goto L50;
        boolean r125 = r124.booleanValue();
    L51:
        r101.setTenantChat(r125);
        Boolean r126 = a.c(r100, "isSuper");
        if (r126 == null) goto L54;
        boolean r127 = r126.booleanValue();
    L55:
        r101.setSuper(r127);
        Boolean r128 = a.c(r100, "isPublic");
        if (r128 == null) goto L58;
        boolean r129 = r128.booleanValue();
    L59:
        r101.setPublic(r129);
        Boolean r130 = a.c(r100, "isOfficialOncall");
        if (r130 == null) goto L62;
        boolean r131 = r130.booleanValue();
    L63:
        r101.setOfficialOncall(r131);
        Boolean r132 = a.c(r100, "isOfflineOncall");
        if (r132 == null) goto L66;
        boolean r133 = r132.booleanValue();
    L67:
        r101.setOfflineOncall(r133);
        r101.setOnCallId(a.l(r100, "onCallId"));
        Long r134 = a.f(r100, "zenModeEndTime");
        if (r134 == null) goto L70;
        long r135 = r134.longValue();
    L71:
        r101.setZenModeEndTime(r135);
        r101.setMiniAvatarKey(a.l(r100, "miniAvatarKey"));
        r101.setP2pChatterId(a.l(r100, "p2pChatterId"));
        Boolean r136 = a.c(r100, "isMyThreadUpdated");
        if (r136 == null) goto L74;
        boolean r137 = r136.booleanValue();
    L75:
        r101.setMyThreadUpdated(r137);
        List<Tag> r138 = a.b(r100, PromotionProductPrivilegesStruct.TAGS, this.f421072e);
        if (r138 != null) goto L78;
        r138 = CollectionsKt.emptyList();
    L78:
        r101.setTags(r138);
        Integer r139 = a.e(r100, "chatterApplyCount");
        if (r139 == null) goto L81;
        int r140 = r139.intValue();
    L82:
        r101.setChatterApplyCount(r140);
        Boolean r141 = a.c(r100, "isSpecialFocus");
        if (r141 == null) goto L85;
        boolean r142 = r141.booleanValue();
    L86:
        r101.setSpecialFocus(r142);
        r101.setStatus(a.b(r100, "status", this.f421073f));
        Chat.Role r143 = (Chat.Role) a.k(r100, "chatRole", this.f421074g);
        if (r143 == null) goto L89;
        r101.setChatRole(r143);
    L89:
        r101.setOrderAvatarKey(a.l(r100, "orderAvatarKey"));
        Boolean r144 = a.c(r100, "showSwitch");
        if (r144 == null) goto L92;
        boolean r145 = r144.booleanValue();
    L93:
        r101.setShowSwitch(r145);
        Integer r146 = a.e(r100, "userCount");
        if (r146 == null) goto L96;
        int r147 = r146.intValue();
    L97:
        r101.setUserCount(r147);
        Boolean r148 = a.c(r100, "isUserCountVisible");
        if (r148 == null) goto L100;
        boolean r149 = r148.booleanValue();
    L101:
        r101.setUserCountVisible(r149);
        Boolean r150 = a.c(r100, "isFrozen");
        if (r150 == null) goto L104;
        boolean r151 = r150.booleanValue();
    L105:
        r101.setFrozen(r151);
        Integer r152 = a.e(r100, "chatReadable");
        if (r152 == null) goto L108;
        r103 = r152.intValue();
    L108:
        r101.setChatReadable(r103);
        return r101;
    L104:
        r151 = false;
        goto L105
    L100:
        r149 = true;
        goto L101
    L96:
        r147 = 0;
        goto L97
    L92:
        r145 = false;
        goto L93
    L85:
        r142 = false;
        goto L86
    L81:
        r140 = 0;
        goto L82
    L74:
        r137 = false;
        goto L75
    L70:
        r135 = 0;
        goto L71
    L66:
        r133 = false;
        goto L67
    L62:
        r131 = false;
        goto L63
    L58:
        r129 = false;
        goto L59
    L54:
        r127 = false;
        goto L55
    L50:
        r125 = false;
        goto L51
    L46:
        r123 = false;
        goto L47
    L33:
        r118 = false;
        goto L34
    L29:
        r116 = false;
        goto L30
    L25:
        r114 = false;
        goto L26
    L21:
        r112 = false;
        goto L22
    L17:
        r110 = false;
        goto L18
    L13:
        r108 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    public final JsonObject d(ChatFeedPreview r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        JsonObject r101 = new JsonObject();
        e.b(r101, r100);
        this.f421068a.b(r101, r100);
        a.g(r101, "isBotChat", Boolean.valueOf(r100.isBotChat()));
        a.g(r101, "isBotMute", Boolean.valueOf(r100.isBotMute()));
        a.g(r101, "isBlocked", Boolean.valueOf(r100.isBlocked()));
        a.g(r101, "isMeeting", Boolean.valueOf(r100.isMeeting()));
        a.g(r101, "isSecret", Boolean.valueOf(r100.isSecret()));
        a.g(r101, "isShowBotTag", Boolean.valueOf(r100.isShowBotTag()));
        a.g(r101, "isShowAgentTag", Boolean.valueOf(r100.isShowAgentTag()));
        a.g(r101, "isCrossWithKa", Boolean.valueOf(r100.isCrossWithKa()));
        a.i(r101, "chatType", r100.getChatType(), this.f421069b);
        a.i(r101, "chatMode", r100.getChatMode(), this.f421070c);
        a.i(r101, "lastMessageType", r100.getLastMessageType(), this.f421071d);
        a.g(r101, "isDepartment", Boolean.valueOf(r100.isDepartment()));
        a.g(r101, "isTenantChat", Boolean.valueOf(r100.isTenantChat()));
        a.g(r101, "isSuper", Boolean.valueOf(r100.isSuper()));
        a.g(r101, "isPublic", Boolean.valueOf(r100.isPublic()));
        a.g(r101, "isOfficialOncall", Boolean.valueOf(r100.isOfficialOncall()));
        a.g(r101, "isOfflineOncall", Boolean.valueOf(r100.isOfflineOncall()));
        a.j(r101, "onCallId", r100.getOnCallId());
        a.h(r101, "zenModeEndTime", Long.valueOf(r100.getZenModeEndTime()));
        a.j(r101, "miniAvatarKey", r100.getMiniAvatarKey());
        a.j(r101, "p2pChatterId", r100.getP2pChatterId());
        a.g(r101, "isMyThreadUpdated", Boolean.valueOf(r100.isMyThreadUpdated()));
        a.a(r101, PromotionProductPrivilegesStruct.TAGS, r100.getTags(), this.f421072e);
        a.h(r101, "chatterApplyCount", Integer.valueOf(r100.getChatterApplyCount()));
        a.g(r101, "isSpecialFocus", Boolean.valueOf(r100.isSpecialFocus()));
        a.a(r101, "status", r100.getStatus(), this.f421073f);
        a.i(r101, "chatRole", r100.getChatRole(), this.f421074g);
        a.j(r101, "orderAvatarKey", r100.getOrderAvatarKey());
        a.g(r101, "showSwitch", Boolean.valueOf(r100.getShowSwitch()));
        a.h(r101, "userCount", Integer.valueOf(r100.getUserCount()));
        a.g(r101, "isUserCountVisible", Boolean.valueOf(r100.isUserCountVisible()));
        a.g(r101, "isFrozen", Boolean.valueOf(r100.isFrozen()));
        a.h(r101, "chatReadable", Integer.valueOf(r100.getChatReadable()));
        return r101;
    }

    public ChatFeedPreviewTypeAdapter(c r100, TypeAdapter r101, TypeAdapter r102, TypeAdapter r103, ListTypeAdapter r104, ListTypeAdapter r105, TypeAdapter r106) {
        Intrinsics.checkNotNullParameter(r100, "fieldCodec");
        Intrinsics.checkNotNullParameter(r101, "chatTypeAdapter");
        Intrinsics.checkNotNullParameter(r102, "chatModeAdapter");
        Intrinsics.checkNotNullParameter(r103, "lastMessageTypeAdapter");
        Intrinsics.checkNotNullParameter(r104, "tagListAdapter");
        Intrinsics.checkNotNullParameter(r105, "statusListAdapter");
        Intrinsics.checkNotNullParameter(r106, "chatRoleAdapter");
        this.f421068a = r100;
        this.f421069b = r101;
        this.f421070c = r102;
        this.f421071d = r103;
        this.f421072e = r104;
        this.f421073f = r105;
        this.f421074g = r106;
    }
}
