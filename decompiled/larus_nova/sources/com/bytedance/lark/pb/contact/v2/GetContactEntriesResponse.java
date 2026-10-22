package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetContactEntriesResponse extends Message<GetContactEntriesResponse, Builder> {
    public static final ProtoAdapter<GetContactEntriesResponse> ADAPTER = null;
    public static final ProtoAdapter_GetContactEntriesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContactEntry> entries;

    public static final class Builder extends Message.Builder<GetContactEntriesResponse, Builder> implements d<GetContactEntriesResponse> {
        public List<ContactEntry> entries;

        @Override // com.squareup.wire.Message.Builder
        public GetContactEntriesResponse build() {
            return new GetContactEntriesResponse(this.entries, super.buildUnknownFields());
        }

        public Builder() {
            this.entries = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder entries(List<ContactEntry> r100) {
            Internal.checkElementsNotNull(r100);
            this.entries = r100;
            return this;
        }
    }

    public static final class ContactEntry extends Message<ContactEntry, Builder> {
        public static final ProtoAdapter<ContactEntry> ADAPTER = null;
        public static final Boolean DEFAULT_IS_VISIBLE = null;
        public static final Type DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final Boolean is_visible;
        public final Type type;

        public static final class Builder extends Message.Builder<ContactEntry, Builder> {
            public Boolean is_visible;
            public Type type;

            @Override // com.squareup.wire.Message.Builder
            public ContactEntry build() {
                return new ContactEntry(this.type, this.is_visible, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder is_visible(Boolean r100) {
                this.is_visible = r100;
                return this;
            }

            public Builder type(Type r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ContactEntry extends ProtoAdapter<ContactEntry> {
            public ProtoAdapter_ContactEntry() {
                super(FieldEncoding.LENGTH_DELIMITED, ContactEntry.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ContactEntry decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = Type.Unknown;
                r101.is_visible = Boolean.TRUE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.is_visible = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(ContactEntry r100) {
                Type r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.is_visible;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ContactEntry decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ContactEntry r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ContactEntry r101) throws IOException {
                Type r102 = r101.type;
                if (r102 == null) goto L5;
                Type.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.is_visible;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContactEntry r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContactEntry();
            DEFAULT_TYPE = Type.Unknown;
            DEFAULT_IS_VISIBLE = Boolean.TRUE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.is_visible = this.is_visible;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ContactEntry.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ContactEntry(Type r100, Boolean r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public ContactEntry(Type r100, Boolean r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.is_visible = r101;
        }
    }

    public static final class ProtoAdapter_GetContactEntriesResponse extends ProtoAdapter<GetContactEntriesResponse> implements c<GetContactEntriesResponse> {
        public ProtoAdapter_GetContactEntriesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactEntriesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactEntriesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.entries.add(ContactEntry.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetContactEntriesResponse r100) {
            return ContactEntry.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.entries) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetContactEntriesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactEntriesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactEntriesResponse r101) throws IOException {
            ContactEntry.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.entries);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactEntriesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CONTACT_USER_GROUP = null;
        public static final Type ChatGroups = null;
        public static final Type EduContacts = null;
        public static final Type Email = null;
        public static final Type ExternalContacts = null;
        public static final Type HelpDesks = null;
        public static final Type MyAI = null;
        public static final Type NewContacts = null;
        public static final Type Organization = null;
        public static final Type RelatedOrganizations = null;
        public static final Type SpecialFocus = null;
        public static final Type USER_GROUP = null;
        public static final Type Unknown = null;
        private final int value;

        static {
            Type r100 = new Type("Unknown", 0, 0);
            Unknown = r100;
            Type r101 = new Type("Organization", 1, 1);
            Organization = r101;
            Type r102 = new Type("ExternalContacts", 2, 2);
            ExternalContacts = r102;
            Type r103 = new Type("NewContacts", 3, 3);
            NewContacts = r103;
            Type r104 = new Type("ChatGroups", 4, 4);
            ChatGroups = r104;
            Type r105 = new Type("HelpDesks", 5, 5);
            HelpDesks = r105;
            Type r110 = new Type("EduContacts", 6, 6);
            EduContacts = r110;
            Type r111 = new Type("RelatedOrganizations", 7, 7);
            RelatedOrganizations = r111;
            Type r112 = new Type("SpecialFocus", 8, 8);
            SpecialFocus = r112;
            Type r113 = new Type("USER_GROUP", 9, 9);
            USER_GROUP = r113;
            Type r114 = new Type("MyAI", 10, 10);
            MyAI = r114;
            Type r115 = new Type("Email", 11, 11);
            Email = r115;
            Type r106 = new Type("CONTACT_USER_GROUP", 12, 12);
            CONTACT_USER_GROUP = r106;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
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
            switch(r100) {
                case 0: goto L30;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L14;
                case 9: goto L12;
                case 10: goto L10;
                case 11: goto L8;
                case 12: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return CONTACT_USER_GROUP;
        L8:
            return Email;
        L10:
            return MyAI;
        L12:
            return USER_GROUP;
        L14:
            return SpecialFocus;
        L16:
            return RelatedOrganizations;
        L18:
            return EduContacts;
        L20:
            return HelpDesks;
        L22:
            return ChatGroups;
        L24:
            return NewContacts;
        L26:
            return ExternalContacts;
        L28:
            return Organization;
        L30:
            return Unknown;
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
        ProtoAdapter_GetContactEntriesResponse r100 = new ProtoAdapter_GetContactEntriesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.entries = Internal.copyOf("entries", this.entries);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactEntriesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactEntriesResponse(List<ContactEntry> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetContactEntriesResponse(List<ContactEntry> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.entries = Internal.immutableCopyOf("entries", r100);
    }
}
