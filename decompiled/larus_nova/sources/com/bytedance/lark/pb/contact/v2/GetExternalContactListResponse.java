package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.ContactInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetExternalContactListResponse extends Message<GetExternalContactListResponse, Builder> {
    public static final ProtoAdapter<GetExternalContactListResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final ProtoAdapter_GetExternalContactListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContactInfo> contacts;
    public final Boolean has_more;

    public static final class Builder extends Message.Builder<GetExternalContactListResponse, Builder> implements d<GetExternalContactListResponse> {
        public List<ContactInfo> contacts;
        public Boolean has_more;

        @Override // com.squareup.wire.Message.Builder
        public GetExternalContactListResponse build() {
            Boolean r100 = this.has_more;
            if (r100 == null) goto L7;
            return new GetExternalContactListResponse(this.contacts, this.has_more, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "has_more"});
        }

        public Builder() {
            this.contacts = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder contacts(List<ContactInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.contacts = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetExternalContactListResponse extends ProtoAdapter<GetExternalContactListResponse> implements c<GetExternalContactListResponse> {
        public ProtoAdapter_GetExternalContactListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetExternalContactListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetExternalContactListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.contacts.add(ContactInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetExternalContactListResponse r100) {
            return (ContactInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.contacts) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.has_more)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetExternalContactListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetExternalContactListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetExternalContactListResponse r101) throws IOException {
            ContactInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.contacts);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.has_more);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetExternalContactListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetExternalContactListResponse r100 = new ProtoAdapter_GetExternalContactListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.contacts = Internal.copyOf("contacts", this.contacts);
        r100.has_more = this.has_more;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetExternalContactListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetExternalContactListResponse(List<ContactInfo> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetExternalContactListResponse(List<ContactInfo> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.contacts = Internal.immutableCopyOf("contacts", r100);
        this.has_more = r101;
    }
}
