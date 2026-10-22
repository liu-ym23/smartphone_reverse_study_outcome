package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u001b\u001c\u001d\u001e\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$Builder;Lokio/ByteString;)V", "invite_at_chatters", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$InviteAtChatters;", "getInvite_at_chatters", "()Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$InviteAtChatters;", "url", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$Url;", "getUrl", "()Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$Url;", "lark_command", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$LarkCommand;", "getLark_command", "()Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$LarkCommand;", "chatter_tooltip", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip;", "getChatter_tooltip", "()Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip;", "newBuilder", "toString", "", "Builder", "Companion", "InviteAtChatters", "Url", "LarkCommand", "ChatterTooltip", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SystemMessageItemAction extends com.lark.wire.Message<SystemMessageItemAction, a> {
    public static final ProtoAdapter<SystemMessageItemAction> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ChatterTooltip chatter_tooltip;
    private final InviteAtChatters invite_at_chatters;
    private final LarkCommand lark_command;
    private final Url url;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip$Builder;Lokio/ByteString;)V", "chatter_tooltip_type", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip$Type;", "getChatter_tooltip_type", "()Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip$Type;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatterTooltip extends com.lark.wire.Message<ChatterTooltip, a> {
        public static final ProtoAdapter<ChatterTooltip> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Type chatter_tooltip_type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$ChatterTooltip$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SIMPLIFY_SYSTEM_MESSAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type SIMPLIFY_SYSTEM_MESSAGE = null;
            public static final Type UNKNOWN = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return Type.SIMPLIFY_SYSTEM_MESSAGE;
                L9:
                    return Type.UNKNOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Type> getEntries() {
                return b;
            }

            static {
                Type r0 = new Type("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Type r1 = new Type("SIMPLIFY_SYSTEM_MESSAGE", 1, 1);
                SIMPLIFY_SYSTEM_MESSAGE = r1;
                Type[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
            }

            public static Type[] values() {
                return (Type[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return SIMPLIFY_SYSTEM_MESSAGE;
            L9:
                return UNKNOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ChatterTooltip, a> {
            public Type d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatterTooltip(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatterTooltip> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatterTooltip c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L11;
                r0.d = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L13:
                return new ChatterTooltip(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatterTooltip r4) {
                ChatterTooltip r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + Type.ADAPTER.l(1, r5.getChatter_tooltip_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ChatterTooltip r5) {
                ChatterTooltip r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Type.ADAPTER.i(r4, 1, r6.getChatter_tooltip_type());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, ChatterTooltip r4) {
                ChatterTooltip r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                Type.ADAPTER.j(r3, 1, r5.getChatter_tooltip_type());
            }

            public b(FieldEncoding r7, KClass<ChatterTooltip> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.SystemMessageItemAction.ChatterTooltip", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatterTooltip(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatterTooltip.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.chatter_tooltip_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatterTooltip.class).getSimpleName() + '@' + hashCode();
        }

        public final Type getChatter_tooltip_type() {
            return this.chatter_tooltip_type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatterTooltip(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.chatter_tooltip_type = r2.d;
        }

        public /* synthetic */ ChatterTooltip(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$InviteAtChatters;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$InviteAtChatters$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$InviteAtChatters$Builder;Lokio/ByteString;)V", "at_chatter_ids", "", "", "getAt_chatter_ids", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class InviteAtChatters extends com.lark.wire.Message<InviteAtChatters, a> {
        public static final ProtoAdapter<InviteAtChatters> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<Long> at_chatter_ids;

        public static final class a extends com.lark.wire.Message.a<InviteAtChatters, a> {
            public List<Long> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new InviteAtChatters(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<InviteAtChatters> {
            @Override // com.lark.wire.ProtoAdapter
            public final InviteAtChatters c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L9;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                r1.add(ProtoAdapter.k.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "at_chatter_ids");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new InviteAtChatters(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(InviteAtChatters r4) {
                InviteAtChatters r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.k.a().l(1, r5.getAt_chatter_ids());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, InviteAtChatters r5) {
                InviteAtChatters r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.a().i(r4, 1, r6.getAt_chatter_ids());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, InviteAtChatters r4) {
                InviteAtChatters r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.k.a().j(r3, 1, r5.getAt_chatter_ids());
            }

            public b(FieldEncoding r7, KClass<InviteAtChatters> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.SystemMessageItemAction.InviteAtChatters", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ InviteAtChatters(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(InviteAtChatters.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.at_chatter_ids;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(InviteAtChatters.class).getSimpleName() + '@' + hashCode();
        }

        public final List<Long> getAt_chatter_ids() {
            return this.at_chatter_ids;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public InviteAtChatters(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.at_chatter_ids = com.lark.wire.internal.a.c("at_chatter_ids", r2.d);
        }

        public /* synthetic */ InviteAtChatters(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$LarkCommand;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$LarkCommand$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$LarkCommand$Builder;Lokio/ByteString;)V", "payload", "getPayload", "()Lokio/ByteString;", "cmd", "", "getCmd", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LarkCommand extends com.lark.wire.Message<LarkCommand, a> {
        public static final ProtoAdapter<LarkCommand> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer cmd;
        private final ByteString payload;

        public static final class a extends com.lark.wire.Message.a<LarkCommand, a> {
            public ByteString d;
            public Integer e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new LarkCommand(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LarkCommand> {
            @Override // com.lark.wire.ProtoAdapter
            public final LarkCommand c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.p.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.f();
                goto L3
            L8:
                if (r4 != 2) goto L9;
                r1.e = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new LarkCommand(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LarkCommand r5) {
                LarkCommand r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.p.l(1, r6.getPayload())) + ProtoAdapter.h.l(2, r6.getCmd());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LarkCommand r5) {
                LarkCommand r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.p.i(r4, 1, r6.getPayload());
                ProtoAdapter.h.i(r4, 2, r6.getCmd());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, LarkCommand r5) {
                LarkCommand r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 2, r6.getCmd());
                ProtoAdapter.p.j(r4, 1, r6.getPayload());
            }

            public b(FieldEncoding r7, KClass<LarkCommand> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.SystemMessageItemAction.LarkCommand", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LarkCommand(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LarkCommand.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.payload;
            r0.e = this.cmd;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LarkCommand.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getCmd() {
            return this.cmd;
        }

        public final ByteString getPayload() {
            return this.payload;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public LarkCommand(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.payload = r2.d;
            this.cmd = r2.e;
        }

        public /* synthetic */ LarkCommand(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$Url;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$Url$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SystemMessageItemAction$Url$Builder;Lokio/ByteString;)V", "ios", "", "getIos", "()Ljava/lang/String;", "android", "getAndroid", "pc", "getPc", "web", "getWeb", "common", "getCommon", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Url extends com.lark.wire.Message<Url, a> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String android;
        private final String common;
        private final String ios;
        private final String pc;
        private final String web;

        public static final class a extends com.lark.wire.Message.a<Url, a> {
            public String d;
            public String e;
            public String f;
            public String g;
            public String h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Url(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Url> {
            @Override // com.lark.wire.ProtoAdapter
            public final Url c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L14;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L14:
                if (r4 != 5) goto L15;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.h = r7.i();
                goto L3
            L15:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L22:
                return new Url(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((((r0 + r1.l(1, r6.getIos())) + r1.l(2, r6.getAndroid())) + r1.l(3, r6.getPc())) + r1.l(4, r6.getWeb())) + r1.l(5, r6.getCommon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getIos());
                r0.i(r4, 2, r6.getAndroid());
                r0.i(r4, 3, r6.getPc());
                r0.i(r4, 4, r6.getWeb());
                r0.i(r4, 5, r6.getCommon());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 5, r6.getCommon());
                r0.j(r4, 4, r6.getWeb());
                r0.j(r4, 3, r6.getPc());
                r0.j(r4, 2, r6.getAndroid());
                r0.j(r4, 1, r6.getIos());
            }

            public b(FieldEncoding r7, KClass<Url> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.SystemMessageItemAction.Url", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Url(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Url.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.ios;
            r0.e = this.android;
            r0.f = this.pc;
            r0.g = this.web;
            r0.h = this.common;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Url.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAndroid() {
            return this.android;
        }

        public final String getCommon() {
            return this.common;
        }

        public final String getIos() {
            return this.ios;
        }

        public final String getPc() {
            return this.pc;
        }

        public final String getWeb() {
            return this.web;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Url(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.ios = r2.d;
            this.android = r2.e;
            this.pc = r2.f;
            this.web = r2.g;
            this.common = r2.h;
        }

        public /* synthetic */ Url(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<SystemMessageItemAction, a> {
        public InviteAtChatters d;
        public Url e;
        public LarkCommand f;
        public ChatterTooltip g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new SystemMessageItemAction(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<SystemMessageItemAction> {
        @Override // com.lark.wire.ProtoAdapter
        public final SystemMessageItemAction c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            long r1 = r7.c();
        L3:
            int r3 = r7.e();
            DefaultConstructorMarker r5 = null;
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            r0.d = InviteAtChatters.ADAPTER.c(r7);
            r0.e = null;
            r0.f = null;
            r0.g = null;
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = Url.ADAPTER.c(r7);
            r0.d = null;
            r0.f = null;
            r0.g = null;
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = LarkCommand.ADAPTER.c(r7);
            r0.d = null;
            r0.e = null;
            r0.g = null;
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.g = ChatterTooltip.ADAPTER.c(r7);
            r0.d = null;
            r0.e = null;
            r0.f = null;
            goto L3
        L13:
            r7.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L19:
            return new SystemMessageItemAction(r0, r7.d(r1), r5);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(SystemMessageItemAction r5) {
            SystemMessageItemAction r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((r6.unknownFields().size() + InviteAtChatters.ADAPTER.l(1, r6.getInvite_at_chatters())) + Url.ADAPTER.l(2, r6.getUrl())) + LarkCommand.ADAPTER.l(3, r6.getLark_command())) + ChatterTooltip.ADAPTER.l(4, r6.getChatter_tooltip());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, SystemMessageItemAction r5) {
            SystemMessageItemAction r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            InviteAtChatters.ADAPTER.i(r4, 1, r6.getInvite_at_chatters());
            Url.ADAPTER.i(r4, 2, r6.getUrl());
            LarkCommand.ADAPTER.i(r4, 3, r6.getLark_command());
            ChatterTooltip.ADAPTER.i(r4, 4, r6.getChatter_tooltip());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, SystemMessageItemAction r5) {
            SystemMessageItemAction r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ChatterTooltip.ADAPTER.j(r4, 4, r6.getChatter_tooltip());
            LarkCommand.ADAPTER.j(r4, 3, r6.getLark_command());
            Url.ADAPTER.j(r4, 2, r6.getUrl());
            InviteAtChatters.ADAPTER.j(r4, 1, r6.getInvite_at_chatters());
        }

        public b(FieldEncoding r7, KClass<SystemMessageItemAction> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.SystemMessageItemAction", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ SystemMessageItemAction(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SystemMessageItemAction.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.invite_at_chatters;
        r0.e = this.url;
        r0.f = this.lark_command;
        r0.g = this.chatter_tooltip;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SystemMessageItemAction.class).getSimpleName() + '@' + hashCode();
    }

    public final ChatterTooltip getChatter_tooltip() {
        return this.chatter_tooltip;
    }

    public final InviteAtChatters getInvite_at_chatters() {
        return this.invite_at_chatters;
    }

    public final LarkCommand getLark_command() {
        return this.lark_command;
    }

    public final Url getUrl() {
        return this.url;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public SystemMessageItemAction(a r5, ByteString r6) {
        super(ADAPTER, r6);
        InviteAtChatters r7 = r5.d;
        this.invite_at_chatters = r7;
        Url r0 = r5.e;
        this.url = r0;
        LarkCommand r1 = r5.f;
        this.lark_command = r1;
        ChatterTooltip r8 = r5.g;
        this.chatter_tooltip = r8;
        boolean r2 = false;
        if (com.lark.wire.internal.a.b(r7, r0, r1, r8, new Object[0]) > 1) goto L5;
        r2 = true;
    L5:
        if (r2 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("At most one of invite_at_chatters, url, lark_command, chatter_tooltip may be non-null".toString());
    }

    public /* synthetic */ SystemMessageItemAction(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
