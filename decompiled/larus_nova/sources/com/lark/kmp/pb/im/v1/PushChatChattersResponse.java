package com.lark.kmp.pb.im.v1;

import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.o0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003 !\"B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/lark/kmp/pb/im/v1/PushChatChattersResponse;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/im/v1/PushChatChattersResponse$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/im/v1/PushChatChattersResponse$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/im/v1/PushChatChattersResponse$Type;", "getType", "()Lcom/lark/kmp/pb/im/v1/PushChatChattersResponse$Type;", "chat", "Lcom/lark/kmp/pb/basic/v1/Chat;", "getChat", "()Lcom/lark/kmp/pb/basic/v1/Chat;", "ordered_weight", "", "", "", "getOrdered_weight", "()Ljava/util/Map;", "operator_id", "getOperator_id", "()Ljava/lang/String;", "entity", "Lcom/lark/kmp/pb/basic/v1/Entity;", "getEntity", "()Lcom/lark/kmp/pb/basic/v1/Entity;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushChatChattersResponse extends Message<PushChatChattersResponse, a> {
    public static final ProtoAdapter<PushChatChattersResponse> ADAPTER = null;
    public static final b Companion = null;
    public static final c<PushChatChattersResponse> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Chat chat;
    private final Entity entity;
    private final String operator_id;
    private final Map<String, Long> ordered_weight;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/im/v1/PushChatChattersResponse$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ADD_CHATTER", "DELETE_CHATTER", "DELETE_ME", "UPDATE_CHATTER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type ADD_CHATTER = null;
        public static final b Companion = null;
        public static final Type DELETE_CHATTER = null;
        public static final Type DELETE_ME = null;
        public static final Type UPDATE_CHATTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f282321a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f282322b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r100) {
                Type.Companion.getClass();
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L19;
                if (r100 == 3) goto L18;
                if (r100 == 4) goto L17;
                return null;
            L17:
                return Type.UPDATE_CHATTER;
            L18:
                return Type.DELETE_ME;
            L19:
                return Type.DELETE_CHATTER;
            L15:
                return Type.ADD_CHATTER;
            }

            public a(KClass<Type> r100, Syntax r101) {
                super(r100, r101, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f282322b;
        }

        static {
            Type r100 = new Type("ADD_CHATTER", 0, 1);
            ADD_CHATTER = r100;
            Type r101 = new Type("DELETE_CHATTER", 1, 2);
            DELETE_CHATTER = r101;
            Type r102 = new Type("DELETE_ME", 2, 3);
            DELETE_ME = r102;
            Type r103 = new Type("UPDATE_CHATTER", 3, 4);
            UPDATE_CHATTER = r103;
            Type[] r104 = {r100, r101, r102, r103};
            f282321a = r104;
            f282322b = EnumEntriesKt.enumEntries(r104);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
        }

        public static Type[] values() {
            return (Type[]) f282321a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r100) {
            Companion.getClass();
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L19;
            if (r100 == 3) goto L18;
            if (r100 == 4) goto L17;
            return null;
        L17:
            return UPDATE_CHATTER;
        L18:
            return DELETE_ME;
        L19:
            return DELETE_CHATTER;
        L15:
            return ADD_CHATTER;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a extends Message.a<PushChatChattersResponse, a> implements we6.d<PushChatChattersResponse> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Type f282323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Chat f282324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, Long> f282325f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f282326g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Entity f282327h;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new PushChatChattersResponse(this, c(), null);
        }

        public a() {
            this.f282325f = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ PushChatChattersResponse(a r100, ByteString r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        Companion = new b();
        PushChatChattersResponse$Companion$ADAPTER$1 r100 = new PushChatChattersResponse$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PushChatChattersResponse.class), Syntax.PROTO_2);
        ADAPTER = r100;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.im.v1.PushChatChattersResponse>");
        RAW_TYPE_ADAPTER = r100;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r100 = new a();
        r100.f282323d = this.type;
        r100.f282324e = this.chat;
        r100.f282325f = this.ordered_weight;
        r100.f282326g = this.operator_id;
        r100.f282327h = this.entity;
        r100.a(unknownFields());
        return r100;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PushChatChattersResponse.class).getSimpleName() + '@' + hashCode();
    }

    public final Chat getChat() {
        return this.chat;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final String getOperator_id() {
        return this.operator_id;
    }

    public final Map<String, Long> getOrdered_weight() {
        return this.ordered_weight;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public PushChatChattersResponse(a r100, ByteString r101) {
        super(ADAPTER, r101);
        Type r102 = r100.f282323d;
        Intrinsics.checkNotNull(r102);
        this.type = r102;
        Chat r103 = r100.f282324e;
        Intrinsics.checkNotNull(r103);
        this.chat = r103;
        this.ordered_weight = com.lark.wire.internal.a.d("ordered_weight", r100.f282325f);
        this.operator_id = r100.f282326g;
        this.entity = r100.f282327h;
    }

    public /* synthetic */ PushChatChattersResponse(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = ByteString.EMPTY;
    L5:
        this(r100, r101);
    }
}
