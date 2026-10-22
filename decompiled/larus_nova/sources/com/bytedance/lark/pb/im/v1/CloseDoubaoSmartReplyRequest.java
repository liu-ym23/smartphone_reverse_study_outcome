package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CloseDoubaoSmartReplyRequest extends Message<CloseDoubaoSmartReplyRequest, Builder> {
    public static final ProtoAdapter<CloseDoubaoSmartReplyRequest> ADAPTER = null;
    public static final Long DEFAULT_REPLY_LARK_MSG_ID = null;
    public static final ProtoAdapter_CloseDoubaoSmartReplyRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long reply_lark_msg_id;

    public static final class Builder extends Message.Builder<CloseDoubaoSmartReplyRequest, Builder> implements d<CloseDoubaoSmartReplyRequest> {
        public Long reply_lark_msg_id;

        @Override // com.squareup.wire.Message.Builder
        public CloseDoubaoSmartReplyRequest build() {
            return new CloseDoubaoSmartReplyRequest(this.reply_lark_msg_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder reply_lark_msg_id(Long r100) {
            this.reply_lark_msg_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CloseDoubaoSmartReplyRequest extends ProtoAdapter<CloseDoubaoSmartReplyRequest> implements c<CloseDoubaoSmartReplyRequest> {
        public ProtoAdapter_CloseDoubaoSmartReplyRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CloseDoubaoSmartReplyRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CloseDoubaoSmartReplyRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.reply_lark_msg_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.reply_lark_msg_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(CloseDoubaoSmartReplyRequest r100) {
            Long r101 = r100.reply_lark_msg_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CloseDoubaoSmartReplyRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CloseDoubaoSmartReplyRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CloseDoubaoSmartReplyRequest r101) throws IOException {
            Long r102 = r101.reply_lark_msg_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CloseDoubaoSmartReplyRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CloseDoubaoSmartReplyRequest r100 = new ProtoAdapter_CloseDoubaoSmartReplyRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_REPLY_LARK_MSG_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.reply_lark_msg_id = this.reply_lark_msg_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CloseDoubaoSmartReplyRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CloseDoubaoSmartReplyRequest(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public CloseDoubaoSmartReplyRequest(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.reply_lark_msg_id = r100;
    }
}
