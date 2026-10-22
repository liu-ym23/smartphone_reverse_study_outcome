package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutOnboardResponse extends Message<PutOnboardResponse, Builder> {
    public static final ProtoAdapter<PutOnboardResponse> ADAPTER = null;
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mai_chat_mode_id;

    public static final class Builder extends Message.Builder<PutOnboardResponse, Builder> {
        public Long mai_chat_mode_id;

        @Override // com.squareup.wire.Message.Builder
        public PutOnboardResponse build() {
            return new PutOnboardResponse(this.mai_chat_mode_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_chat_mode_id(Long r100) {
            this.mai_chat_mode_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutOnboardResponse extends ProtoAdapter<PutOnboardResponse> {
        public ProtoAdapter_PutOnboardResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutOnboardResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutOnboardResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mai_chat_mode_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mai_chat_mode_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(PutOnboardResponse r100) {
            Long r101 = r100.mai_chat_mode_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutOnboardResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutOnboardResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutOnboardResponse r101) throws IOException {
            Long r102 = r101.mai_chat_mode_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutOnboardResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutOnboardResponse();
        DEFAULT_AI_CHAT_MODE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mai_chat_mode_id = this.mai_chat_mode_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutOnboardResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutOnboardResponse(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutOnboardResponse(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mai_chat_mode_id = r100;
    }
}
