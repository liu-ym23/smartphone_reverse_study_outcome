package com.bytedance.lark.pb.im.v1;

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
public final class GetQuasiMergeForwardMessageRequest extends Message<GetQuasiMergeForwardMessageRequest, Builder> {
    public static final ProtoAdapter<GetQuasiMergeForwardMessageRequest> ADAPTER = null;
    public static final String DEFAULT_QUASI_TITLE = "";
    public static final ProtoAdapter_GetQuasiMergeForwardMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> message_ids;
    public final String quasi_title;

    public static final class Builder extends Message.Builder<GetQuasiMergeForwardMessageRequest, Builder> implements d<GetQuasiMergeForwardMessageRequest> {
        public List<String> message_ids;
        public String quasi_title;

        @Override // com.squareup.wire.Message.Builder
        public GetQuasiMergeForwardMessageRequest build() {
            return new GetQuasiMergeForwardMessageRequest(this.message_ids, this.quasi_title, super.buildUnknownFields());
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }

        public Builder quasi_title(String r100) {
            this.quasi_title = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetQuasiMergeForwardMessageRequest extends ProtoAdapter<GetQuasiMergeForwardMessageRequest> implements c<GetQuasiMergeForwardMessageRequest> {
        public ProtoAdapter_GetQuasiMergeForwardMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetQuasiMergeForwardMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetQuasiMergeForwardMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.quasi_title = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.quasi_title = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(GetQuasiMergeForwardMessageRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.message_ids);
            String r103 = r100.quasi_title;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(2, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetQuasiMergeForwardMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetQuasiMergeForwardMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetQuasiMergeForwardMessageRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.message_ids);
            String r103 = r101.quasi_title;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetQuasiMergeForwardMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetQuasiMergeForwardMessageRequest r100 = new ProtoAdapter_GetQuasiMergeForwardMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.quasi_title = this.quasi_title;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetQuasiMergeForwardMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetQuasiMergeForwardMessageRequest(List<String> r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetQuasiMergeForwardMessageRequest(List<String> r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_ids = Internal.immutableCopyOf("message_ids", r100);
        this.quasi_title = r101;
    }
}
