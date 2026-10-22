package com.bytedance.lark.pb.basic.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatMailSetting extends com.squareup.wire.Message<ChatMailSetting, Builder> {
    public static final ProtoAdapter<ChatMailSetting> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_MAIL_SEND = null;
    public static final SendPermission DEFAULT_SEND_PERMISSION = null;
    private static final long serialVersionUID = 0;
    public final Boolean allow_mail_send;
    public final SendPermission send_permission;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatMailSetting, Builder> {
        public Boolean allow_mail_send;
        public SendPermission send_permission;

        @Override // com.squareup.wire.Message.Builder
        public ChatMailSetting build() {
            return new ChatMailSetting(this.send_permission, this.allow_mail_send, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder allow_mail_send(Boolean r100) {
            this.allow_mail_send = r100;
            return this;
        }

        public Builder send_permission(SendPermission r100) {
            this.send_permission = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatMailSetting extends ProtoAdapter<ChatMailSetting> {
        public ProtoAdapter_ChatMailSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatMailSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatMailSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.send_permission = SendPermission.GROUP_MEMBERS;
            r101.allow_mail_send = Boolean.TRUE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.send_permission = SendPermission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.allow_mail_send = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatMailSetting r100) {
            SendPermission r101 = r100.send_permission;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SendPermission.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.allow_mail_send;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatMailSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatMailSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatMailSetting r101) throws IOException {
            SendPermission r102 = r101.send_permission;
            if (r102 == null) goto L5;
            SendPermission.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.allow_mail_send;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatMailSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SendPermission extends Enum<SendPermission> implements WireEnum {
        private static final /* synthetic */ SendPermission[] $VALUES = null;
        public static final ProtoAdapter<SendPermission> ADAPTER = null;
        public static final SendPermission ALL = null;
        public static final SendPermission GROUP_ADMIN = null;
        public static final SendPermission GROUP_MEMBERS = null;
        public static final SendPermission ORGANIZATION_MEMBERS = null;
        public static final SendPermission UNKNOWN = null;
        private final int value;

        static {
            SendPermission r100 = new SendPermission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            SendPermission r101 = new SendPermission("GROUP_ADMIN", 1, 1);
            GROUP_ADMIN = r101;
            SendPermission r102 = new SendPermission("GROUP_MEMBERS", 2, 2);
            GROUP_MEMBERS = r102;
            SendPermission r103 = new SendPermission("ORGANIZATION_MEMBERS", 3, 3);
            ORGANIZATION_MEMBERS = r103;
            SendPermission r104 = new SendPermission(AccountType.ALL, 4, 4);
            ALL = r104;
            $VALUES = new SendPermission[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(SendPermission.class);
        }

        public static SendPermission[] values() {
            return (SendPermission[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SendPermission fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return ALL;
        L16:
            return ORGANIZATION_MEMBERS;
        L18:
            return GROUP_MEMBERS;
        L20:
            return GROUP_ADMIN;
        L22:
            return UNKNOWN;
        }

        public static SendPermission valueOf(String r100) {
            return (SendPermission) a.a(SendPermission.class, r100);
        }

        private SendPermission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatMailSetting();
        DEFAULT_SEND_PERMISSION = SendPermission.GROUP_MEMBERS;
        DEFAULT_ALLOW_MAIL_SEND = Boolean.TRUE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.send_permission = this.send_permission;
        r100.allow_mail_send = this.allow_mail_send;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatMailSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatMailSetting(SendPermission r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ChatMailSetting(SendPermission r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.send_permission = r100;
        this.allow_mail_send = r101;
    }
}
