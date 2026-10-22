package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 I2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0007HIJKLMNB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010F\u001a\u00020\u0002H\u0016J\b\u0010G\u001a\u00020\u0012H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010$\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020'0\u001a¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u001d\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020*0\u001a¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001d\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u001a¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0013\u00102\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0014R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u00108\u001a\u0004\u0018\u000109¢\u0006\n\n\u0002\u0010;\u001a\u0004\b8\u0010:R\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020=0\u001a¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001cR\u0015\u0010?\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010#\u001a\u0004\b@\u0010\"R\u0013\u0010A\u001a\u0004\u0018\u00010B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0015\u0010E\u001a\u0004\u0018\u000109¢\u0006\n\n\u0002\u0010;\u001a\u0004\bE\u0010:¨\u0006O"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MergeForwardContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$Builder;Lokio/ByteString;)V", "messages", "", "Lcom/lark/kmp/pb/basic/v1/Message;", "getMessages", "()Ljava/util/List;", "chat_type", "Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "getChat_type", "()Lcom/lark/kmp/pb/basic/v1/Chat$Type;", "group_chat_name", "", "getGroup_chat_name", "()Ljava/lang/String;", "p2p_creator_name", "getP2p_creator_name", "p2p_partner_name", "getP2p_partner_name", "creator_i18n_names", "", "getCreator_i18n_names", "()Ljava/util/Map;", "partner_i18n_names", "getPartner_i18n_names", "p2p_creator_id", "", "getP2p_creator_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "p2p_partner_id", "getP2p_partner_id", "chatters", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$ChatterInfo;", "getChatters", "reaction_snapshots", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageReaction;", "getReaction_snapshots", "thread", "Lcom/lark/kmp/pb/basic/v1/Thread;", "getThread", "()Lcom/lark/kmp/pb/basic/v1/Thread;", "i18n_thread_title", "getI18n_thread_title", "quasi_title", "getQuasi_title", "put_info", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$OptionPutInfo;", "getPut_info", "()Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$OptionPutInfo;", "is_transmit", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "message_threads", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageThread;", "getMessage_threads", "origin_chat_id", "getOrigin_chat_id", "origin_chat", "Lcom/lark/kmp/pb/basic/v1/Chat;", "getOrigin_chat", "()Lcom/lark/kmp/pb/basic/v1/Chat;", "is_copy_from_doubao", "newBuilder", "toString", "Builder", "Companion", "ChatterInfo", "Reaction", "MessageReaction", "OptionPutInfo", "MessageThread", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MergeForwardContent extends com.lark.wire.Message<MergeForwardContent, a> {
    public static final ProtoAdapter<MergeForwardContent> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Chat.Type chat_type;
    private final Map<String, ChatterInfo> chatters;
    private final Map<String, String> creator_i18n_names;
    private final String group_chat_name;
    private final Map<String, String> i18n_thread_title;
    private final Boolean is_copy_from_doubao;
    private final Boolean is_transmit;
    private final Map<Long, MessageThread> message_threads;
    private final List<Message> messages;
    private final Chat origin_chat;
    private final Long origin_chat_id;
    private final Long p2p_creator_id;
    private final String p2p_creator_name;
    private final Long p2p_partner_id;
    private final String p2p_partner_name;
    private final Map<String, String> partner_i18n_names;
    private final OptionPutInfo put_info;
    private final String quasi_title;
    private final Map<String, MessageReaction> reaction_snapshots;
    private final Thread thread;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001c\u0010\u001eR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$ChatterInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$ChatterInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$ChatterInfo$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "avatar", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getAvatar$annotations", "()V", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "type", "Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "avatar_key", "getAvatar_key", "avatar_path", "getAvatar_path", "is_anonymous", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "i18n_name", "", "getI18n_name", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatterInfo extends com.lark.wire.Message<ChatterInfo, a> {
        public static final ProtoAdapter<ChatterInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final ImageSet avatar;
        private final String avatar_key;
        private final String avatar_path;
        private final Map<String, String> i18n_name;
        private final String id;
        private final Boolean is_anonymous;
        private final String name;
        private final Chatter.Type type;

        public static final class a extends com.lark.wire.Message.a<ChatterInfo, a> {
            public String d;
            public String e;
            public ImageSet f;
            public Chatter.Type g;
            public String h;
            public String i;
            public Boolean j;
            public Map<String, String> k;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatterInfo(this, c(), null);
            }

            public a() {
                this.k = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ ChatterInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        @Deprecated(message = "avatar is deprecated")
        public static /* synthetic */ void getAvatar$annotations() {
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(ChatterInfo.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new MergeForwardContent$ChatterInfo$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.id;
            r0.e = this.name;
            r0.f = this.avatar;
            r0.g = this.type;
            r0.h = this.avatar_key;
            r0.i = this.avatar_path;
            r0.j = this.is_anonymous;
            r0.k = this.i18n_name;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatterInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final ImageSet getAvatar() {
            return this.avatar;
        }

        public final String getAvatar_key() {
            return this.avatar_key;
        }

        public final String getAvatar_path() {
            return this.avatar_path;
        }

        public final Map<String, String> getI18n_name() {
            return this.i18n_name;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final Chatter.Type getType() {
            return this.type;
        }

        public final Boolean is_anonymous() {
            return this.is_anonymous;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatterInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.id = r2.d;
            this.name = r2.e;
            this.avatar = r2.f;
            this.type = r2.g;
            this.avatar_key = r2.h;
            this.avatar_path = r2.i;
            this.is_anonymous = r2.j;
            this.i18n_name = com.lark.wire.internal.a.d("i18n_name", r2.k);
        }

        public /* synthetic */ ChatterInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageReaction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageReaction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageReaction$Builder;Lokio/ByteString;)V", "message_id", "", "getMessage_id", "()Ljava/lang/String;", "reactions", "", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$Reaction;", "getReactions", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MessageReaction extends com.lark.wire.Message<MessageReaction, a> {
        public static final ProtoAdapter<MessageReaction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String message_id;
        private final List<Reaction> reactions;

        public static final class a extends com.lark.wire.Message.a<MessageReaction, a> {
            public String d;
            public List<Reaction> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MessageReaction(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<MessageReaction> {
            @Override // com.lark.wire.ProtoAdapter
            public final MessageReaction c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L12;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.d = r8.i();
                goto L3
            L8:
                if (r5 != 2) goto L9;
                r2.add(Reaction.ADAPTER.c(r8));
                goto L3
            L9:
                r8.j(r5);
                goto L3
            L12:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "reactions");
                com.lark.wire.internal.a.a(r2);
                r1.e = r2;
                return new MessageReaction(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(MessageReaction r5) {
                MessageReaction r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getMessage_id())) + Reaction.ADAPTER.a().l(2, r6.getReactions());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, MessageReaction r5) {
                MessageReaction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getMessage_id());
                Reaction.ADAPTER.a().i(r4, 2, r6.getReactions());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, MessageReaction r5) {
                MessageReaction r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                Reaction.ADAPTER.a().j(r4, 2, r6.getReactions());
                ProtoAdapter.q.j(r4, 1, r6.getMessage_id());
            }

            public b(FieldEncoding r7, KClass<MessageReaction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MergeForwardContent.MessageReaction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ MessageReaction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageReaction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.message_id;
            r0.e = this.reactions;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(MessageReaction.class).getSimpleName() + '@' + hashCode();
        }

        public final String getMessage_id() {
            return this.message_id;
        }

        public final List<Reaction> getReactions() {
            return this.reactions;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public MessageReaction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.message_id = r2.d;
            this.reactions = com.lark.wire.internal.a.c("reactions", r2.e);
        }

        public /* synthetic */ MessageReaction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageThread;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageThread$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageThread$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "reply_count", "", "getReply_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "top_repliers", "", "getTop_repliers", "()Ljava/util/List;", "latest_reply_time", "getLatest_reply_time", "messages", "Lcom/lark/kmp/pb/basic/v1/Message;", "getMessages", "reaction_snapshots", "", "", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$MessageReaction;", "getReaction_snapshots", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class MessageThread extends com.lark.wire.Message<MessageThread, a> {
        public static final ProtoAdapter<MessageThread> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Long id;
        private final Long latest_reply_time;
        private final List<Message> messages;
        private final Map<String, MessageReaction> reaction_snapshots;
        private final Integer reply_count;
        private final List<Long> top_repliers;

        public static final class a extends com.lark.wire.Message.a<MessageThread, a> {
            public Long d;
            public Integer e;
            public List<Long> f;
            public Long g;
            public List<Message> h;
            public Map<String, MessageReaction> i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new MessageThread(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
                this.h = CollectionsKt.emptyList();
                this.i = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ MessageThread(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(MessageThread.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new MergeForwardContent$MessageThread$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.id;
            r0.e = this.reply_count;
            r0.f = this.top_repliers;
            r0.g = this.latest_reply_time;
            r0.h = this.messages;
            r0.i = this.reaction_snapshots;
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

        public final List<Message> getMessages() {
            return this.messages;
        }

        public final Map<String, MessageReaction> getReaction_snapshots() {
            return this.reaction_snapshots;
        }

        public final Integer getReply_count() {
            return this.reply_count;
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
            this.messages = com.lark.wire.internal.a.c("messages", r2.h);
            this.reaction_snapshots = com.lark.wire.internal.a.d("reaction_snapshots", r2.i);
        }

        public /* synthetic */ MessageThread(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$OptionPutInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$OptionPutInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$OptionPutInfo$Builder;Lokio/ByteString;)V", "merge_type", "Lcom/lark/kmp/pb/basic/v1/MergeFowardMessageType;", "getMerge_type", "()Lcom/lark/kmp/pb/basic/v1/MergeFowardMessageType;", "thread_id", "", "getThread_id", "()Ljava/lang/String;", "limited", "", "getLimited", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "need_copy_reaction", "getNeed_copy_reaction", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class OptionPutInfo extends com.lark.wire.Message<OptionPutInfo, a> {
        public static final ProtoAdapter<OptionPutInfo> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_LIMITED = false;
        private static final long serialVersionUID = 0;
        private final Boolean limited;
        private final MergeFowardMessageType merge_type;
        private final Boolean need_copy_reaction;
        private final String thread_id;

        public static final class a extends com.lark.wire.Message.a<OptionPutInfo, a> {
            public MergeFowardMessageType d;
            public String e;
            public Boolean f;
            public Boolean g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new OptionPutInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<OptionPutInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final OptionPutInfo c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                r1.d = MergeFowardMessageType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = (Boolean) ProtoAdapter.g.c(r10);
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
                return new OptionPutInfo(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(OptionPutInfo r5) {
                OptionPutInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = (r6.unknownFields().size() + MergeFowardMessageType.ADAPTER.l(1, r6.getMerge_type())) + ProtoAdapter.q.l(2, r6.getThread_id());
                l r1 = ProtoAdapter.g;
                return (r0 + r1.l(3, r6.getLimited())) + r1.l(4, r6.getNeed_copy_reaction());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, OptionPutInfo r5) {
                OptionPutInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                MergeFowardMessageType.ADAPTER.i(r4, 1, r6.getMerge_type());
                ProtoAdapter.q.i(r4, 2, r6.getThread_id());
                l r0 = ProtoAdapter.g;
                r0.i(r4, 3, r6.getLimited());
                r0.i(r4, 4, r6.getNeed_copy_reaction());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, OptionPutInfo r5) {
                OptionPutInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 4, r6.getNeed_copy_reaction());
                r0.j(r4, 3, r6.getLimited());
                ProtoAdapter.q.j(r4, 2, r6.getThread_id());
                MergeFowardMessageType.ADAPTER.j(r4, 1, r6.getMerge_type());
            }

            public b(FieldEncoding r7, KClass<OptionPutInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MergeForwardContent.OptionPutInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ OptionPutInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OptionPutInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.merge_type;
            r0.e = this.thread_id;
            r0.f = this.limited;
            r0.g = this.need_copy_reaction;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(OptionPutInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean getLimited() {
            return this.limited;
        }

        public final MergeFowardMessageType getMerge_type() {
            return this.merge_type;
        }

        public final Boolean getNeed_copy_reaction() {
            return this.need_copy_reaction;
        }

        public final String getThread_id() {
            return this.thread_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public OptionPutInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.merge_type = r2.d;
            this.thread_id = r2.e;
            this.limited = r2.f;
            this.need_copy_reaction = r2.g;
        }

        public /* synthetic */ OptionPutInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$Reaction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$Reaction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MergeForwardContent$Reaction$Builder;Lokio/ByteString;)V", "type", "", "getType", "()Ljava/lang/String;", "count", "", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "chatter_ids", "", "getChatter_ids", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Reaction extends com.lark.wire.Message<Reaction, a> {
        public static final ProtoAdapter<Reaction> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> chatter_ids;
        private final Integer count;
        private final String type;

        public static final class a extends com.lark.wire.Message.a<Reaction, a> {
            public String d;
            public Integer e;
            public List<String> f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Reaction(this, c(), null);
            }

            public a() {
                this.f = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<Reaction> {
            @Override // com.lark.wire.ProtoAdapter
            public final Reaction c(g0 r8) {
                Intrinsics.checkNotNullParameter(r8, "reader");
                a r1 = new a();
                ArrayList r2 = new ArrayList();
                long r3 = r8.c();
            L3:
                int r5 = r8.e();
                if (r5 == (-1)) goto L15;
                if (r5 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r1.d = r8.i();
                goto L3
            L8:
                if (r5 != 2) goto L10;
                r1.e = (Integer) ProtoAdapter.h.c(r8);
                goto L3
            L10:
                if (r5 != 3) goto L11;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r8, "reader");
                r2.add(r8.i());
                goto L3
            L11:
                r8.j(r5);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L15:
                ByteString r9 = r8.d(r3);
                Intrinsics.checkNotNullParameter(r2, "chatter_ids");
                com.lark.wire.internal.a.a(r2);
                r1.f = r2;
                return new Reaction(r1, r9, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Reaction r6) {
                Reaction r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(1, r7.getType())) + ProtoAdapter.h.l(2, r7.getCount())) + r1.a().l(3, r7.getChatter_ids());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, Reaction r6) {
                Reaction r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getType());
                ProtoAdapter.h.i(r5, 2, r7.getCount());
                r0.a().i(r5, 3, r7.getChatter_ids());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, Reaction r6) {
                Reaction r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.a().j(r5, 3, r7.getChatter_ids());
                ProtoAdapter.h.j(r5, 2, r7.getCount());
                r0.j(r5, 1, r7.getType());
            }

            public b(FieldEncoding r7, KClass<Reaction> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MergeForwardContent.Reaction", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Reaction(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Reaction.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.count;
            r0.f = this.chatter_ids;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Reaction.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getChatter_ids() {
            return this.chatter_ids;
        }

        public final Integer getCount() {
            return this.count;
        }

        public final String getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Reaction(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.count = r2.e;
            this.chatter_ids = com.lark.wire.internal.a.c("chatter_ids", r2.f);
        }

        public /* synthetic */ Reaction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<MergeForwardContent, a> {
        public List<Message> d;
        public Chat.Type e;
        public String f;
        public String g;
        public String h;
        public Map<String, String> i;
        public Map<String, String> j;
        public Long k;
        public Long l;
        public Map<String, ChatterInfo> m;
        public Map<String, MessageReaction> n;
        public Thread o;
        public Map<String, String> p;
        public String q;
        public OptionPutInfo r;
        public Boolean s;
        public Map<Long, MessageThread> t;
        public Long u;
        public Chat v;
        public Boolean w;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MergeForwardContent(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
            this.i = MapsKt.emptyMap();
            this.j = MapsKt.emptyMap();
            this.m = MapsKt.emptyMap();
            this.n = MapsKt.emptyMap();
            this.p = MapsKt.emptyMap();
            this.t = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ MergeForwardContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(MergeForwardContent.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new MergeForwardContent$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.messages;
        r0.e = this.chat_type;
        r0.f = this.group_chat_name;
        r0.g = this.p2p_creator_name;
        r0.h = this.p2p_partner_name;
        r0.i = this.creator_i18n_names;
        r0.j = this.partner_i18n_names;
        r0.k = this.p2p_creator_id;
        r0.l = this.p2p_partner_id;
        r0.m = this.chatters;
        r0.n = this.reaction_snapshots;
        r0.o = this.thread;
        r0.p = this.i18n_thread_title;
        r0.q = this.quasi_title;
        r0.r = this.put_info;
        r0.s = this.is_transmit;
        r0.t = this.message_threads;
        r0.u = this.origin_chat_id;
        r0.v = this.origin_chat;
        r0.w = this.is_copy_from_doubao;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MergeForwardContent.class).getSimpleName() + '@' + hashCode();
    }

    public final Chat.Type getChat_type() {
        return this.chat_type;
    }

    public final Map<String, ChatterInfo> getChatters() {
        return this.chatters;
    }

    public final Map<String, String> getCreator_i18n_names() {
        return this.creator_i18n_names;
    }

    public final String getGroup_chat_name() {
        return this.group_chat_name;
    }

    public final Map<String, String> getI18n_thread_title() {
        return this.i18n_thread_title;
    }

    public final Map<Long, MessageThread> getMessage_threads() {
        return this.message_threads;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final Chat getOrigin_chat() {
        return this.origin_chat;
    }

    public final Long getOrigin_chat_id() {
        return this.origin_chat_id;
    }

    public final Long getP2p_creator_id() {
        return this.p2p_creator_id;
    }

    public final String getP2p_creator_name() {
        return this.p2p_creator_name;
    }

    public final Long getP2p_partner_id() {
        return this.p2p_partner_id;
    }

    public final String getP2p_partner_name() {
        return this.p2p_partner_name;
    }

    public final Map<String, String> getPartner_i18n_names() {
        return this.partner_i18n_names;
    }

    public final OptionPutInfo getPut_info() {
        return this.put_info;
    }

    public final String getQuasi_title() {
        return this.quasi_title;
    }

    public final Map<String, MessageReaction> getReaction_snapshots() {
        return this.reaction_snapshots;
    }

    public final Thread getThread() {
        return this.thread;
    }

    public final Boolean is_copy_from_doubao() {
        return this.is_copy_from_doubao;
    }

    public final Boolean is_transmit() {
        return this.is_transmit;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MergeForwardContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.messages = com.lark.wire.internal.a.c("messages", r2.d);
        this.chat_type = r2.e;
        this.group_chat_name = r2.f;
        this.p2p_creator_name = r2.g;
        this.p2p_partner_name = r2.h;
        this.creator_i18n_names = com.lark.wire.internal.a.d("creator_i18n_names", r2.i);
        this.partner_i18n_names = com.lark.wire.internal.a.d("partner_i18n_names", r2.j);
        this.p2p_creator_id = r2.k;
        this.p2p_partner_id = r2.l;
        this.chatters = com.lark.wire.internal.a.d("chatters", r2.m);
        this.reaction_snapshots = com.lark.wire.internal.a.d("reaction_snapshots", r2.n);
        this.thread = r2.o;
        this.i18n_thread_title = com.lark.wire.internal.a.d("i18n_thread_title", r2.p);
        this.quasi_title = r2.q;
        this.put_info = r2.r;
        this.is_transmit = r2.s;
        this.message_threads = com.lark.wire.internal.a.d("message_threads", r2.t);
        this.origin_chat_id = r2.u;
        this.origin_chat = r2.v;
        this.is_copy_from_doubao = r2.w;
    }

    public /* synthetic */ MergeForwardContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
