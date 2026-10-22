package com.bytedance.lark.pb.contact.v2;

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
public final class GetContactsDoubaoResponse extends Message<GetContactsDoubaoResponse, Builder> {
    public static final ProtoAdapter<GetContactsDoubaoResponse> ADAPTER = null;
    public static final Integer DEFAULT_TOTAL = null;
    public static final ProtoAdapter_GetContactsDoubaoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContactProfile> contacts;
    public final Integer total;

    public static final class Builder extends Message.Builder<GetContactsDoubaoResponse, Builder> implements d<GetContactsDoubaoResponse> {
        public List<ContactProfile> contacts;
        public Integer total;

        @Override // com.squareup.wire.Message.Builder
        public GetContactsDoubaoResponse build() {
            return new GetContactsDoubaoResponse(this.contacts, this.total, super.buildUnknownFields());
        }

        public Builder() {
            this.contacts = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder contacts(List<ContactProfile> r100) {
            Internal.checkElementsNotNull(r100);
            this.contacts = r100;
            return this;
        }

        public Builder total(Integer r100) {
            this.total = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetContactsDoubaoResponse extends ProtoAdapter<GetContactsDoubaoResponse> implements c<GetContactsDoubaoResponse> {
        public ProtoAdapter_GetContactsDoubaoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactsDoubaoResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactsDoubaoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.total = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 2) goto L8;
            r101.contacts.add(ContactProfile.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 3) goto L9;
            r101.total = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(GetContactsDoubaoResponse r100) {
            int r101 = ContactProfile.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.contacts);
            Integer r102 = r100.total;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetContactsDoubaoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactsDoubaoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactsDoubaoResponse r101) throws IOException {
            ContactProfile.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.contacts);
            Integer r102 = r101.total;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactsDoubaoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetContactsDoubaoResponse r100 = new ProtoAdapter_GetContactsDoubaoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TOTAL = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.contacts = Internal.copyOf("contacts", this.contacts);
        r100.total = this.total;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactsDoubaoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactsDoubaoResponse(List<ContactProfile> r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetContactsDoubaoResponse(List<ContactProfile> r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.contacts = Internal.immutableCopyOf("contacts", r100);
        this.total = r101;
    }
}
