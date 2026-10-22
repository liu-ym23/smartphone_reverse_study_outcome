package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SendMessageRequest extends Message<SendMessageRequest, Builder> {
    public static final ProtoAdapter<SendMessageRequest> ADAPTER = null;
    public static final String DEFAULT_CID = "";
    public static final Long DEFAULT_FILE_HANDLE = null;
    public static final String DEFAULT_PREPROCESS_KEY = "";
    public static final Integer DEFAULT_STRICT_SEND_ORDER = null;
    public static final ProtoAdapter_SendMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String cid;
    public final Long file_handle;
    public final String preprocess_key;
    public final Integer strict_send_order;

    public static final class Builder extends Message.Builder<SendMessageRequest, Builder> implements d<SendMessageRequest> {
        public String cid;
        public Long file_handle;
        public String preprocess_key;
        public Integer strict_send_order;

        @Override // com.squareup.wire.Message.Builder
        public SendMessageRequest build() {
            String r100 = this.cid;
            if (r100 == null) goto L7;
            return new SendMessageRequest(this.cid, this.file_handle, this.preprocess_key, this.strict_send_order, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "cid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cid(String r100) {
            this.cid = r100;
            return this;
        }

        public Builder file_handle(Long r100) {
            this.file_handle = r100;
            return this;
        }

        public Builder preprocess_key(String r100) {
            this.preprocess_key = r100;
            return this;
        }

        public Builder strict_send_order(Integer r100) {
            this.strict_send_order = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SendMessageRequest extends ProtoAdapter<SendMessageRequest> implements c<SendMessageRequest> {
        public ProtoAdapter_SendMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.cid = "";
            r101.file_handle = 0L;
            r101.preprocess_key = "";
            r101.strict_send_order = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.cid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.file_handle = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.preprocess_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.strict_send_order = ProtoAdapter.UINT32.decode(r100);
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
        public int encodedSize2(SendMessageRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.cid);
            Long r103 = r100.file_handle;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.preprocess_key;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.strict_send_order;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.UINT32.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SendMessageRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.cid);
            Long r103 = r101.file_handle;
            if (r103 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.preprocess_key;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            Integer r105 = r101.strict_send_order;
            if (r105 == null) goto L11;
            ProtoAdapter.UINT32.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SendMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SendMessageRequest r100 = new ProtoAdapter_SendMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FILE_HANDLE = 0L;
        DEFAULT_STRICT_SEND_ORDER = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cid = this.cid;
        r100.file_handle = this.file_handle;
        r100.preprocess_key = this.preprocess_key;
        r100.strict_send_order = this.strict_send_order;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SendMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SendMessageRequest(String r100, Long r101, String r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SendMessageRequest(String r100, Long r101, String r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.cid = r100;
        this.file_handle = r101;
        this.preprocess_key = r102;
        this.strict_send_order = r103;
    }
}
