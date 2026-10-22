package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ContactInfo extends com.squareup.wire.Message<ContactInfo, Builder> {
    public static final ProtoAdapter<ContactInfo> ADAPTER = null;
    public static final ContactOperation DEFAULT_OP = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    public final ContactOperation f253463op;
    public final UserInfo user_info;

    public static final class Builder extends com.squareup.wire.Message.Builder<ContactInfo, Builder> {

        /* JADX INFO: renamed from: op, reason: collision with root package name */
        public ContactOperation f253464op;
        public UserInfo user_info;

        @Override // com.squareup.wire.Message.Builder
        public ContactInfo build() {
            UserInfo r100 = this.user_info;
            if (r100 == null) goto L7;
            return new ContactInfo(this.user_info, this.f253464op, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_info"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder op(ContactOperation r100) {
            this.f253464op = r100;
            return this;
        }

        public Builder user_info(UserInfo r100) {
            this.user_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContactInfo extends ProtoAdapter<ContactInfo> {
        public ProtoAdapter_ContactInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ContactInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContactInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253464op = ContactOperation.OPERATION_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user_info = UserInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.f253464op = ContactOperation.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(ContactInfo r100) {
            int r101 = UserInfo.ADAPTER.encodedSizeWithTag(1, r100.user_info);
            ContactOperation r102 = r100.f253463op;
            if (r102 == null) goto L5;
            int r103 = ContactOperation.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContactInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContactInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContactInfo r101) throws IOException {
            UserInfo.ADAPTER.encodeWithTag(r100, 1, r101.user_info);
            ContactOperation r102 = r101.f253463op;
            if (r102 == null) goto L5;
            ContactOperation.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContactInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContactInfo();
        DEFAULT_OP = ContactOperation.OPERATION_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_info = this.user_info;
        r100.f253464op = this.f253463op;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContactInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContactInfo(UserInfo r100, ContactOperation r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ContactInfo(UserInfo r100, ContactOperation r101, ByteString r102) {
        super(ADAPTER, r102);
        this.user_info = r100;
        this.f253463op = r101;
    }
}
