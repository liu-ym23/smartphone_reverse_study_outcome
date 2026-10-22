package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ChatMailSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ChatMailSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ChatMailSetting$Builder;Lokio/ByteString;)V", "send_permission", "Lcom/lark/kmp/pb/basic/v1/ChatMailSetting$SendPermission;", "getSend_permission", "()Lcom/lark/kmp/pb/basic/v1/ChatMailSetting$SendPermission;", "allow_mail_send", "", "getAllow_mail_send", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "SendPermission", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatMailSetting extends com.lark.wire.Message<ChatMailSetting, a> {
    public static final ProtoAdapter<ChatMailSetting> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_ALLOW_MAIL_SEND = true;
    public static final SendPermission DEFAULT_SEND_PERMISSION = null;
    private static final long serialVersionUID = 0;
    private final Boolean allow_mail_send;
    private final SendPermission send_permission;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ChatMailSetting$SendPermission;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "GROUP_ADMIN", "GROUP_MEMBERS", "ORGANIZATION_MEMBERS", "ALL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SendPermission extends Enum<SendPermission> implements o0 {
        public static final ProtoAdapter<SendPermission> ADAPTER = null;
        public static final SendPermission ALL = null;
        public static final b Companion = null;
        public static final SendPermission GROUP_ADMIN = null;
        public static final SendPermission GROUP_MEMBERS = null;
        public static final SendPermission ORGANIZATION_MEMBERS = null;
        public static final SendPermission UNKNOWN = null;
        public static final /* synthetic */ SendPermission[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SendPermission> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SendPermission.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<SendPermission> r1, Syntax r2, SendPermission r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static SendPermission a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return SendPermission.ALL;
            L20:
                return SendPermission.ORGANIZATION_MEMBERS;
            L21:
                return SendPermission.GROUP_MEMBERS;
            L22:
                return SendPermission.GROUP_ADMIN;
            L17:
                return SendPermission.UNKNOWN;
            }
        }

        @JvmStatic
        public static final SendPermission fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<SendPermission> getEntries() {
            return b;
        }

        static {
            SendPermission r0 = new SendPermission("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            SendPermission r1 = new SendPermission("GROUP_ADMIN", 1, 1);
            GROUP_ADMIN = r1;
            SendPermission r3 = new SendPermission("GROUP_MEMBERS", 2, 2);
            GROUP_MEMBERS = r3;
            SendPermission r5 = new SendPermission("ORGANIZATION_MEMBERS", 3, 3);
            ORGANIZATION_MEMBERS = r5;
            SendPermission r7 = new SendPermission("ALL", 4, 4);
            ALL = r7;
            SendPermission[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SendPermission.class), Syntax.PROTO_2, r0);
        }

        public static SendPermission[] values() {
            return (SendPermission[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static SendPermission valueOf(String r1) {
            return (SendPermission) r27.a.a(SendPermission.class, r1);
        }

        public SendPermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ChatMailSetting, a> {
        public SendPermission d;
        public Boolean e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ChatMailSetting(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ChatMailSetting> {
        @Override // com.lark.wire.ProtoAdapter
        public final ChatMailSetting c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L8;
            r0.d = SendPermission.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L9:
            r9.j(r3);
            goto L3
        L16:
            return new ChatMailSetting(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ChatMailSetting r5) {
            ChatMailSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + SendPermission.ADAPTER.l(1, r6.getSend_permission())) + ProtoAdapter.g.l(2, r6.getAllow_mail_send());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ChatMailSetting r5) {
            ChatMailSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            SendPermission.ADAPTER.i(r4, 1, r6.getSend_permission());
            ProtoAdapter.g.i(r4, 2, r6.getAllow_mail_send());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ChatMailSetting r5) {
            ChatMailSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 2, r6.getAllow_mail_send());
            SendPermission.ADAPTER.j(r4, 1, r6.getSend_permission());
        }

        public b(FieldEncoding r7, KClass<ChatMailSetting> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ChatMailSetting", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ChatMailSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_SEND_PERMISSION = SendPermission.GROUP_MEMBERS;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatMailSetting.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.send_permission;
        r0.e = this.allow_mail_send;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ChatMailSetting.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getAllow_mail_send() {
        return this.allow_mail_send;
    }

    public final SendPermission getSend_permission() {
        return this.send_permission;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ChatMailSetting(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.send_permission = r2.d;
        this.allow_mail_send = r2.e;
    }

    public /* synthetic */ ChatMailSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
