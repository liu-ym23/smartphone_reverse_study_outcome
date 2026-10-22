package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.openplatform.v1.AppInfoItem;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006/01234B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 0\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020+0\u0012¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0015¨\u00065"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageLink;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageLink$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageLink$Builder;Lokio/ByteString;)V", "token", "", "getToken", "()Ljava/lang/String;", "entity_ids", "", "", "getEntity_ids", "()Ljava/util/List;", "entities", "", "Lcom/lark/kmp/pb/basic/v1/MessageLink$Entity;", "getEntities", "()Ljava/util/Map;", "chatters", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "getChatters", "chats", "Lcom/lark/kmp/pb/basic/v1/Chat;", "getChats", "preview_entities", "Lcom/lark/kmp/pb/basic/v1/PreviewEntityPair;", "getPreview_entities", "preview_templates", "Lcom/lark/kmp/pb/basic/v1/URLPreviewTemplate;", "getPreview_templates", "meta_info", "Lcom/lark/kmp/pb/basic/v1/MessageLink$MetaInfo;", "getMeta_info", "()Lcom/lark/kmp/pb/basic/v1/MessageLink$MetaInfo;", "chat_info", "Lcom/lark/kmp/pb/basic/v1/MessageLink$ChatInfo;", "getChat_info", "()Lcom/lark/kmp/pb/basic/v1/MessageLink$ChatInfo;", "app_info_items", "Lcom/lark/kmp/pb/openplatform/v1/AppInfoItem;", "getApp_info_items", "newBuilder", "toString", "Builder", "Companion", "Entity", "MetaInfo", "MessageThread", "ChatInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MessageLink extends com.lark.wire.Message<MessageLink, a> {
    public static final ProtoAdapter<MessageLink> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<Long, AppInfoItem> app_info_items;
    private final ChatInfo chat_info;
    private final Map<String, Chat> chats;
    private final Map<String, Chatter> chatters;
    private final Map<Long, Entity> entities;
    private final List<Long> entity_ids;
    private final MetaInfo meta_info;
    private final Map<String, PreviewEntityPair> preview_entities;
    private final Map<String, URLPreviewTemplate> preview_templates;
    private final String token;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageLink$ChatInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageLink$ChatInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageLink$ChatInfo$Builder;Lokio/ByteString;)V", "name", "", "getName", "()Ljava/lang/String;", "is_auth", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "type", "Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "is_p2p_bot", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatInfo extends com.lark.wire.Message<ChatInfo, a> {
        public static final ProtoAdapter<ChatInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Boolean is_auth;
        private final Boolean is_p2p_bot;
        private final String name;
        private final Chat.Type type;

        public static final class a extends com.lark.wire.Message.a<ChatInfo, a> {
            public String d;
            public Boolean e;
            public Chat.Type f;
            public Boolean g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatInfo c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = Chat.Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L13:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L22:
                return new ChatInfo(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatInfo r6) {
                ChatInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size() + ProtoAdapter.q.l(1, r7.getName());
                l r1 = ProtoAdapter.g;
                return ((r0 + r1.l(2, r7.is_auth())) + Chat.Type.ADAPTER.l(3, r7.getType())) + r1.l(4, r7.is_p2p_bot());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ChatInfo r6) {
                ChatInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                ProtoAdapter.q.i(r5, 1, r7.getName());
                l r0 = ProtoAdapter.g;
                r0.i(r5, 2, r7.is_auth());
                Chat.Type.ADAPTER.i(r5, 3, r7.getType());
                r0.i(r5, 4, r7.is_p2p_bot());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ChatInfo r6) {
                ChatInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r5, 4, r7.is_p2p_bot());
                Chat.Type.ADAPTER.j(r5, 3, r7.getType());
                r0.j(r5, 2, r7.is_auth());
                ProtoAdapter.q.j(r5, 1, r7.getName());
            }

            public b(FieldEncoding r7, KClass<ChatInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MessageLink.ChatInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.name;
            r0.e = this.is_auth;
            r0.f = this.type;
            r0.g = this.is_p2p_bot;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getName() {
            return this.name;
        }

        public final Chat.Type getType() {
            return this.type;
        }

        public final Boolean is_auth() {
            return this.is_auth;
        }

        public final Boolean is_p2p_bot() {
            return this.is_p2p_bot;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.name = r2.d;
            this.is_auth = r2.e;
            this.type = r2.f;
            this.is_p2p_bot = r2.g;
        }

        public /* synthetic */ ChatInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageLink$Entity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageLink$Entity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageLink$Entity$Builder;Lokio/ByteString;)V", "message", "Lcom/lark/kmp/pb/basic/v1/Message;", "getMessage", "()Lcom/lark/kmp/pb/basic/v1/Message;", "thread", "Lcom/lark/kmp/pb/basic/v1/Thread;", "getThread", "()Lcom/lark/kmp/pb/basic/v1/Thread;", "message_thread", "Lcom/lark/kmp/pb/basic/v1/MessageLink$MessageThread;", "getMessage_thread", "()Lcom/lark/kmp/pb/basic/v1/MessageLink$MessageThread;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Entity extends com.lark.wire.Message<Entity, a> {
        public static final ProtoAdapter<Entity> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Message message;
        private final MessageThread message_thread;
        private final Thread thread;

        public static final class a extends com.lark.wire.Message.a<Entity, a> {
            public Message d;
            public Thread e;
            public MessageThread f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Entity(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Entity> {
            @Override // com.lark.wire.ProtoAdapter
            public final Entity c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = Message.ADAPTER.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = Thread.ADAPTER.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = MessageThread.ADAPTER.c(r6);
                goto L3
            L11:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L16:
                return new Entity(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Entity r5) {
                Entity r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + Message.ADAPTER.l(1, r6.getMessage())) + Thread.ADAPTER.l(2, r6.getThread())) + MessageThread.ADAPTER.l(3, r6.getMessage_thread());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Entity r5) {
                Entity r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Message.ADAPTER.i(r4, 1, r6.getMessage());
                Thread.ADAPTER.i(r4, 2, r6.getThread());
                MessageThread.ADAPTER.i(r4, 3, r6.getMessage_thread());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Entity r5) {
                Entity r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                MessageThread.ADAPTER.j(r4, 3, r6.getMessage_thread());
                Thread.ADAPTER.j(r4, 2, r6.getThread());
                Message.ADAPTER.j(r4, 1, r6.getMessage());
            }

            public b(FieldEncoding r7, KClass<Entity> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MessageLink.Entity", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Entity(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Entity.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.message;
            r0.e = this.thread;
            r0.f = this.message_thread;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Entity.class).getSimpleName() + '@' + hashCode();
        }

        public final Message getMessage() {
            return this.message;
        }

        public final MessageThread getMessage_thread() {
            return this.message_thread;
        }

        public final Thread getThread() {
            return this.thread;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Entity(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.message = r2.d;
            this.thread = r2.e;
            this.message_thread = r2.f;
        }

        public /* synthetic */ Entity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageLink$MessageThread;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageLink$MessageThread$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageLink$MessageThread$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "reply_count", "", "getReply_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "top_repliers", "", "getTop_repliers", "()Ljava/util/List;", "latest_reply_time", "getLatest_reply_time", "reply_entity_ids", "getReply_entity_ids", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MessageThread extends com.lark.wire.Message<MessageThread, a> {
        public static final ProtoAdapter<MessageThread> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long id;
        private final Long latest_reply_time;
        private final Integer reply_count;
        private final List<Long> reply_entity_ids;
        private final List<Long> top_repliers;

        public static final class a extends com.lark.wire.Message.a<MessageThread, a> {
            public Long d;
            public Integer e;
            public List<Long> f;
            public Long g;
            public List<Long> h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MessageThread(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
                this.h = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<MessageThread> {
            @Override // com.lark.wire.ProtoAdapter
            public final MessageThread c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L21;
                if (r5 != 1) goto L8;
                r0.d = (Long) ProtoAdapter.k.c(r8);
                goto L3
            L8:
                if (r5 != 2) goto L10;
                r0.e = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L10:
                if (r5 != 3) goto L12;
                r1.add(ProtoAdapter.k.c(r8));
                goto L3
            L12:
                if (r5 != 4) goto L14;
                r0.g = (Long) ProtoAdapter.k.c(r8);
                goto L3
            L14:
                if (r5 != 5) goto L15;
                r2.add(ProtoAdapter.k.c(r8));
                goto L3
            L15:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L21:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r1, "top_repliers");
                com.lark.wire.internal.a.a(r1);
                r0.f = r1;
                Intrinsics.checkNotNullParameter(r2, "reply_entity_ids");
                com.lark.wire.internal.a.a(r2);
                r0.h = r2;
                return new MessageThread(r0, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MessageThread r6) {
                MessageThread r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                t r1 = ProtoAdapter.k;
                return ((((r0 + r1.l(1, r7.getId())) + ProtoAdapter.h.l(2, r7.getReply_count())) + r1.a().l(3, r7.getTop_repliers())) + r1.l(4, r7.getLatest_reply_time())) + r1.a().l(5, r7.getReply_entity_ids());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, MessageThread r6) {
                MessageThread r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r5, 1, r7.getId());
                ProtoAdapter.h.i(r5, 2, r7.getReply_count());
                r0.a().i(r5, 3, r7.getTop_repliers());
                r0.i(r5, 4, r7.getLatest_reply_time());
                r0.a().i(r5, 5, r7.getReply_entity_ids());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, MessageThread r6) {
                MessageThread r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                t r0 = ProtoAdapter.k;
                r0.a().j(r5, 5, r7.getReply_entity_ids());
                r0.j(r5, 4, r7.getLatest_reply_time());
                r0.a().j(r5, 3, r7.getTop_repliers());
                ProtoAdapter.h.j(r5, 2, r7.getReply_count());
                r0.j(r5, 1, r7.getId());
            }

            public b(FieldEncoding r7, KClass<MessageThread> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MessageLink.MessageThread", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MessageThread(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageThread.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.id;
            r0.e = this.reply_count;
            r0.f = this.top_repliers;
            r0.g = this.latest_reply_time;
            r0.h = this.reply_entity_ids;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MessageThread.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getId() {
            return this.id;
        }

        public final Long getLatest_reply_time() {
            return this.latest_reply_time;
        }

        public final Integer getReply_count() {
            return this.reply_count;
        }

        public final List<Long> getReply_entity_ids() {
            return this.reply_entity_ids;
        }

        public final List<Long> getTop_repliers() {
            return this.top_repliers;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MessageThread(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.id = r2.d;
            this.reply_count = r2.e;
            this.top_repliers = com.lark.wire.internal.a.c("top_repliers", r2.f);
            this.latest_reply_time = r2.g;
            this.reply_entity_ids = com.lark.wire.internal.a.c("reply_entity_ids", r2.h);
        }

        public /* synthetic */ MessageThread(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageLink$MetaInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageLink$MetaInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageLink$MetaInfo$Builder;Lokio/ByteString;)V", "operator_id", "", "getOperator_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "from_chat_id", "getFrom_chat_id", "operator_time_ns", "getOperator_time_ns", "jump_pos", "", "getJump_pos", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MetaInfo extends com.lark.wire.Message<MetaInfo, a> {
        public static final ProtoAdapter<MetaInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long from_chat_id;
        private final Integer jump_pos;
        private final Long operator_id;
        private final Long operator_time_ns;

        public static final class a extends com.lark.wire.Message.a<MetaInfo, a> {
            public Long d;
            public Long e;
            public Long f;
            public Integer g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MetaInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<MetaInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final MetaInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.f = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.g = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L13:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L19:
                return new MetaInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MetaInfo r5) {
                MetaInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                t r1 = ProtoAdapter.k;
                return (((r0 + r1.l(1, r6.getOperator_id())) + r1.l(2, r6.getFrom_chat_id())) + r1.l(3, r6.getOperator_time_ns())) + ProtoAdapter.h.l(4, r6.getJump_pos());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, MetaInfo r5) {
                MetaInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r4, 1, r6.getOperator_id());
                r0.i(r4, 2, r6.getFrom_chat_id());
                r0.i(r4, 3, r6.getOperator_time_ns());
                ProtoAdapter.h.i(r4, 4, r6.getJump_pos());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, MetaInfo r5) {
                MetaInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 4, r6.getJump_pos());
                t r0 = ProtoAdapter.k;
                r0.j(r4, 3, r6.getOperator_time_ns());
                r0.j(r4, 2, r6.getFrom_chat_id());
                r0.j(r4, 1, r6.getOperator_id());
            }

            public b(FieldEncoding r7, KClass<MetaInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MessageLink.MetaInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MetaInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MetaInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.operator_id;
            r0.e = this.from_chat_id;
            r0.f = this.operator_time_ns;
            r0.g = this.jump_pos;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MetaInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getFrom_chat_id() {
            return this.from_chat_id;
        }

        public final Integer getJump_pos() {
            return this.jump_pos;
        }

        public final Long getOperator_id() {
            return this.operator_id;
        }

        public final Long getOperator_time_ns() {
            return this.operator_time_ns;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MetaInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.operator_id = r2.d;
            this.from_chat_id = r2.e;
            this.operator_time_ns = r2.f;
            this.jump_pos = r2.g;
        }

        public /* synthetic */ MetaInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<MessageLink, a> {
        public String d;
        public List<Long> e;
        public Map<Long, Entity> f;
        public Map<String, Chatter> g;
        public Map<String, Chat> h;
        public Map<String, PreviewEntityPair> i;
        public Map<String, URLPreviewTemplate> j;
        public MetaInfo k;
        public ChatInfo l;
        public Map<Long, AppInfoItem> m;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MessageLink(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
            this.f = MapsKt.emptyMap();
            this.g = MapsKt.emptyMap();
            this.h = MapsKt.emptyMap();
            this.i = MapsKt.emptyMap();
            this.j = MapsKt.emptyMap();
            this.m = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ MessageLink(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(MessageLink.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new MessageLink$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.token;
        r0.e = this.entity_ids;
        r0.f = this.entities;
        r0.g = this.chatters;
        r0.h = this.chats;
        r0.i = this.preview_entities;
        r0.j = this.preview_templates;
        r0.k = this.meta_info;
        r0.l = this.chat_info;
        r0.m = this.app_info_items;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MessageLink.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<Long, AppInfoItem> getApp_info_items() {
        return this.app_info_items;
    }

    public final ChatInfo getChat_info() {
        return this.chat_info;
    }

    public final Map<String, Chat> getChats() {
        return this.chats;
    }

    public final Map<String, Chatter> getChatters() {
        return this.chatters;
    }

    public final Map<Long, Entity> getEntities() {
        return this.entities;
    }

    public final List<Long> getEntity_ids() {
        return this.entity_ids;
    }

    public final MetaInfo getMeta_info() {
        return this.meta_info;
    }

    public final Map<String, PreviewEntityPair> getPreview_entities() {
        return this.preview_entities;
    }

    public final Map<String, URLPreviewTemplate> getPreview_templates() {
        return this.preview_templates;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MessageLink(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.token = r2.d;
        this.entity_ids = com.lark.wire.internal.a.c("entity_ids", r2.e);
        this.entities = com.lark.wire.internal.a.d("entities", r2.f);
        this.chatters = com.lark.wire.internal.a.d("chatters", r2.g);
        this.chats = com.lark.wire.internal.a.d("chats", r2.h);
        this.preview_entities = com.lark.wire.internal.a.d("preview_entities", r2.i);
        this.preview_templates = com.lark.wire.internal.a.d("preview_templates", r2.j);
        this.meta_info = r2.k;
        this.chat_info = r2.l;
        this.app_info_items = com.lark.wire.internal.a.d("app_info_items", r2.m);
    }

    public /* synthetic */ MessageLink(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
