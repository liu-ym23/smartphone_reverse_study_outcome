package com.bytedance.lark.pb.im.v2;

import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetContactsDoubaoWithDeniedReasonResponse extends Message<GetContactsDoubaoWithDeniedReasonResponse, Builder> {
    public static final ProtoAdapter<GetContactsDoubaoWithDeniedReasonResponse> ADAPTER = null;
    public static final Integer DEFAULT_TOTAL = null;
    public static final ProtoAdapter_GetContactsDoubaoWithDeniedReasonResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContactProfile> contacts;
    public final Map<Long, DeniedReason> id2denied_reason;
    public final List<Long> in_chat_chatter_ids;
    public final Integer total;

    public static final class Builder extends Message.Builder<GetContactsDoubaoWithDeniedReasonResponse, Builder> implements d<GetContactsDoubaoWithDeniedReasonResponse> {
        public List<ContactProfile> contacts;
        public Map<Long, DeniedReason> id2denied_reason;
        public List<Long> in_chat_chatter_ids;
        public Integer total;

        @Override // com.squareup.wire.Message.Builder
        public GetContactsDoubaoWithDeniedReasonResponse build() {
            return new GetContactsDoubaoWithDeniedReasonResponse(this.contacts, this.total, this.id2denied_reason, this.in_chat_chatter_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.contacts = Internal.newMutableList();
            this.id2denied_reason = Internal.newMutableMap();
            this.in_chat_chatter_ids = Internal.newMutableList();
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

        public Builder id2denied_reason(Map<Long, DeniedReason> r100) {
            Internal.checkElementsNotNull(r100);
            this.id2denied_reason = r100;
            return this;
        }

        public Builder in_chat_chatter_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.in_chat_chatter_ids = r100;
            return this;
        }

        public Builder total(Integer r100) {
            this.total = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetContactsDoubaoWithDeniedReasonResponse extends ProtoAdapter<GetContactsDoubaoWithDeniedReasonResponse> implements c<GetContactsDoubaoWithDeniedReasonResponse> {
        private final ProtoAdapter<Map<Long, DeniedReason>> id2denied_reason;

        public ProtoAdapter_GetContactsDoubaoWithDeniedReasonResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactsDoubaoWithDeniedReasonResponse.class);
            this.id2denied_reason = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, DeniedReason.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactsDoubaoWithDeniedReasonResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.total = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.contacts.add(ContactProfile.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.total = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.id2denied_reason.putAll(this.id2denied_reason.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.in_chat_chatter_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetContactsDoubaoWithDeniedReasonResponse r100) {
            int r101 = ContactProfile.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.contacts);
            Integer r102 = r100.total;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L7:
            return (((r101 + r103) + this.id2denied_reason.encodedSizeWithTag(3, r100.id2denied_reason)) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(4, r100.in_chat_chatter_ids)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetContactsDoubaoWithDeniedReasonResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactsDoubaoWithDeniedReasonResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactsDoubaoWithDeniedReasonResponse r101) throws IOException {
            ContactProfile.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.contacts);
            Integer r102 = r101.total;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            this.id2denied_reason.encodeWithTag(r100, 3, r101.id2denied_reason);
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 4, r101.in_chat_chatter_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactsDoubaoWithDeniedReasonResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetContactsDoubaoWithDeniedReasonResponse r100 = new ProtoAdapter_GetContactsDoubaoWithDeniedReasonResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TOTAL = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.contacts = Internal.copyOf("contacts", this.contacts);
        r100.total = this.total;
        r100.id2denied_reason = Internal.copyOf("id2denied_reason", this.id2denied_reason);
        r100.in_chat_chatter_ids = Internal.copyOf("in_chat_chatter_ids", this.in_chat_chatter_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactsDoubaoWithDeniedReasonResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactsDoubaoWithDeniedReasonResponse(List<ContactProfile> r100, Integer r101, Map<Long, DeniedReason> r102, List<Long> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetContactsDoubaoWithDeniedReasonResponse(List<ContactProfile> r100, Integer r101, Map<Long, DeniedReason> r102, List<Long> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.contacts = Internal.immutableCopyOf("contacts", r100);
        this.total = r101;
        this.id2denied_reason = Internal.immutableCopyOf("id2denied_reason", r102);
        this.in_chat_chatter_ids = Internal.immutableCopyOf("in_chat_chatter_ids", r103);
    }
}
