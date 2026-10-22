package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ChatTeamInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ChatTeamInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ChatTeamInfo$Builder;Lokio/ByteString;)V", "team_id", "", "getTeam_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "team_chat_type", "Lcom/lark/kmp/pb/basic/v1/TeamChatType;", "getTeam_chat_type", "()Lcom/lark/kmp/pb/basic/v1/TeamChatType;", "bind_time", "getBind_time", "order_weight", "getOrder_weight", "discoverable", "", "getDiscoverable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatTeamInfo extends com.lark.wire.Message<ChatTeamInfo, a> {
    public static final ProtoAdapter<ChatTeamInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long bind_time;
    private final Boolean discoverable;
    private final Long order_weight;
    private final TeamChatType team_chat_type;
    private final Long team_id;

    public static final class a extends com.lark.wire.Message.a<ChatTeamInfo, a> {
        public Long d;
        public TeamChatType e;
        public Long f;
        public Long g;
        public Boolean h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ChatTeamInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ChatTeamInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final ChatTeamInfo c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L25;
            if (r3 != 1) goto L8;
            r0.d = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = TeamChatType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.g = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.h = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L15:
            r9.j(r3);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L25:
            return new ChatTeamInfo(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ChatTeamInfo r6) {
            ChatTeamInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            t r1 = ProtoAdapter.k;
            return ((((r0 + r1.l(1, r7.getTeam_id())) + TeamChatType.ADAPTER.l(2, r7.getTeam_chat_type())) + r1.l(3, r7.getBind_time())) + r1.l(4, r7.getOrder_weight())) + ProtoAdapter.g.l(5, r7.getDiscoverable());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, ChatTeamInfo r6) {
            ChatTeamInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r5, 1, r7.getTeam_id());
            TeamChatType.ADAPTER.i(r5, 2, r7.getTeam_chat_type());
            r0.i(r5, 3, r7.getBind_time());
            r0.i(r5, 4, r7.getOrder_weight());
            ProtoAdapter.g.i(r5, 5, r7.getDiscoverable());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, ChatTeamInfo r6) {
            ChatTeamInfo r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.g.j(r5, 5, r7.getDiscoverable());
            t r0 = ProtoAdapter.k;
            r0.j(r5, 4, r7.getOrder_weight());
            r0.j(r5, 3, r7.getBind_time());
            TeamChatType.ADAPTER.j(r5, 2, r7.getTeam_chat_type());
            r0.j(r5, 1, r7.getTeam_id());
        }

        public b(FieldEncoding r7, KClass<ChatTeamInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ChatTeamInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ChatTeamInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatTeamInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.team_id;
        r0.e = this.team_chat_type;
        r0.f = this.bind_time;
        r0.g = this.order_weight;
        r0.h = this.discoverable;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ChatTeamInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getBind_time() {
        return this.bind_time;
    }

    public final Boolean getDiscoverable() {
        return this.discoverable;
    }

    public final Long getOrder_weight() {
        return this.order_weight;
    }

    public final TeamChatType getTeam_chat_type() {
        return this.team_chat_type;
    }

    public final Long getTeam_id() {
        return this.team_id;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ChatTeamInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.team_id = r2.d;
        this.team_chat_type = r2.e;
        this.bind_time = r2.f;
        this.order_weight = r2.g;
        this.discoverable = r2.h;
    }

    public /* synthetic */ ChatTeamInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
