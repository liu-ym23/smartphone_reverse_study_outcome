package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Contact extends com.squareup.wire.Message<Contact, Builder> {
    public static final ProtoAdapter<Contact> ADAPTER = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_DELETED = null;
    private static final long serialVersionUID = 0;
    public final String chatter_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253461id;
    public final Boolean is_deleted;

    public static final class Builder extends com.squareup.wire.Message.Builder<Contact, Builder> {
        public String chatter_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253462id;
        public Boolean is_deleted;

        @Override // com.squareup.wire.Message.Builder
        public Contact build() {
            return new Contact(this.f253462id, this.chatter_id, this.is_deleted, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chatter_id(String r100) {
            this.chatter_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253462id = r100;
            return this;
        }

        public Builder is_deleted(Boolean r100) {
            this.is_deleted = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Contact extends ProtoAdapter<Contact> {
        public ProtoAdapter_Contact() {
            super(FieldEncoding.LENGTH_DELIMITED, Contact.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Contact decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253462id = "";
            r101.chatter_id = "";
            r101.is_deleted = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253462id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.chatter_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_deleted = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Contact r100) {
            String r101 = r100.f253461id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.chatter_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_deleted;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Contact decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Contact r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Contact r101) throws IOException {
            String r102 = r101.f253461id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.chatter_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_deleted;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Contact r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Contact();
        DEFAULT_IS_DELETED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253462id = this.f253461id;
        r100.chatter_id = this.chatter_id;
        r100.is_deleted = this.is_deleted;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Contact.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Contact(String r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Contact(String r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253461id = r100;
        this.chatter_id = r101;
        this.is_deleted = r102;
    }
}
