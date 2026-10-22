package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class MailContactMeta extends Message<MailContactMeta, Builder> {
    public static final ProtoAdapter<MailContactMeta> ADAPTER = null;
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final String memail;
    public final String mid;
    public final ContactType mtype;

    public static final class Builder extends Message.Builder<MailContactMeta, Builder> {
        public String memail;
        public String mid;
        public ContactType mtype;

        @Override // com.squareup.wire.Message.Builder
        public MailContactMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new MailContactMeta(this.mid, this.mtype, this.memail, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder email(String r100) {
            this.memail = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder type(ContactType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final enum ContactType extends Enum<ContactType> implements WireEnum {
        private static final /* synthetic */ ContactType[] $VALUES = null;
        public static final ProtoAdapter<ContactType> ADAPTER = null;
        public static final ContactType CHATTER = null;
        public static final ContactType EXTERNAL_CONTACT = null;
        public static final ContactType GROUP = null;
        public static final ContactType MAIL_GROUP = null;
        public static final ContactType NAME_CARD = null;
        public static final ContactType NONE_TYPE = null;
        public static final ContactType SHARED_MAILBOX = null;
        public static final ContactType UNKNOWN = null;
        private final int value;

        static {
            ContactType r100 = new ContactType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ContactType r101 = new ContactType("CHATTER", 1, 1);
            CHATTER = r101;
            ContactType r102 = new ContactType("GROUP", 2, 2);
            GROUP = r102;
            ContactType r103 = new ContactType("EXTERNAL_CONTACT", 3, 3);
            EXTERNAL_CONTACT = r103;
            ContactType r104 = new ContactType("NAME_CARD", 4, 4);
            NAME_CARD = r104;
            ContactType r105 = new ContactType("SHARED_MAILBOX", 5, 5);
            SHARED_MAILBOX = r105;
            ContactType r110 = new ContactType("MAIL_GROUP", 6, 6);
            MAIL_GROUP = r110;
            ContactType r111 = new ContactType("NONE_TYPE", 7, 7);
            NONE_TYPE = r111;
            $VALUES = new ContactType[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContactType.class);
        }

        public static ContactType[] values() {
            return (ContactType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ContactType fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return NONE_TYPE;
        L8:
            return MAIL_GROUP;
        L10:
            return SHARED_MAILBOX;
        L12:
            return NAME_CARD;
        L14:
            return EXTERNAL_CONTACT;
        L16:
            return GROUP;
        L18:
            return CHATTER;
        L20:
            return UNKNOWN;
        }

        public static ContactType valueOf(String r100) {
            return (ContactType) a.a(ContactType.class, r100);
        }

        private ContactType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_MailContactMeta extends ProtoAdapter<MailContactMeta> {
        public ProtoAdapter_MailContactMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MailContactMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MailContactMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.memail = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtype = ContactType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.memail = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MailContactMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            ContactType r103 = r100.mtype;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ContactType.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.memail;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(3, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MailContactMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MailContactMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MailContactMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            ContactType r103 = r101.mtype;
            if (r103 == null) goto L5;
            ContactType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.memail;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MailContactMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MailContactMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mtype = this.mtype;
        r100.memail = this.memail;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MailContactMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MailContactMeta(String r100, ContactType r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MailContactMeta(String r100, ContactType r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mid = r100;
        this.mtype = r101;
        this.memail = r102;
    }
}
