package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class EmailMember extends com.squareup.wire.Message<EmailMember, Builder> {
    public static final ProtoAdapter<EmailMember> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_INVITER_ID = "";
    public static final Long DEFAULT_JOIN_TIME = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253487id;
    public final String inviter_id;
    public final Long join_time;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<EmailMember, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253488id;
        public String inviter_id;
        public Long join_time;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public EmailMember build() {
            String r100 = this.f253488id;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new EmailMember(this.f253488id, this.type, this.inviter_id, this.join_time, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.type, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253488id = r100;
            return this;
        }

        public Builder inviter_id(String r100) {
            this.inviter_id = r100;
            return this;
        }

        public Builder join_time(Long r100) {
            this.join_time = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EmailMember extends ProtoAdapter<EmailMember> {
        public ProtoAdapter_EmailMember() {
            super(FieldEncoding.LENGTH_DELIMITED, EmailMember.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EmailMember decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253488id = "";
            r101.type = Type.CHATTER;
            r101.inviter_id = "";
            r101.join_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.f253488id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.inviter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.join_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EmailMember r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253487id) + Type.ADAPTER.encodedSizeWithTag(2, r100.type);
            String r103 = r100.inviter_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.join_time;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.INT64.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EmailMember decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EmailMember r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EmailMember r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253487id);
            Type.ADAPTER.encodeWithTag(r100, 2, r101.type);
            String r103 = r101.inviter_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            Long r104 = r101.join_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmailMember r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CHAT = null;
        public static final Type CHATTER = null;
        private final int value;

        static {
            Type r100 = new Type("CHATTER", 0, 1);
            CHATTER = r100;
            Type r101 = new Type("CHAT", 1, 2);
            CHAT = r101;
            $VALUES = new Type[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return CHAT;
        L11:
            return CHATTER;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmailMember();
        DEFAULT_TYPE = Type.CHATTER;
        DEFAULT_JOIN_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253488id = this.f253487id;
        r100.type = this.type;
        r100.inviter_id = this.inviter_id;
        r100.join_time = this.join_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EmailMember.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EmailMember(String r100, Type r101, String r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public EmailMember(String r100, Type r101, String r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.f253487id = r100;
        this.type = r101;
        this.inviter_id = r102;
        this.join_time = r103;
    }
}
