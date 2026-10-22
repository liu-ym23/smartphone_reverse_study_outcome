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
public final class HideChatTranslatedNameRequest extends Message<HideChatTranslatedNameRequest, Builder> {
    public static final ProtoAdapter<HideChatTranslatedNameRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final ProtoAdapter_HideChatTranslatedNameRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long chat_id;

    public static final class Builder extends Message.Builder<HideChatTranslatedNameRequest, Builder> implements d<HideChatTranslatedNameRequest> {
        public Long chat_id;

        @Override // com.squareup.wire.Message.Builder
        public HideChatTranslatedNameRequest build() {
            return new HideChatTranslatedNameRequest(this.chat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.chat_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HideChatTranslatedNameRequest extends ProtoAdapter<HideChatTranslatedNameRequest> implements c<HideChatTranslatedNameRequest> {
        public ProtoAdapter_HideChatTranslatedNameRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, HideChatTranslatedNameRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HideChatTranslatedNameRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chat_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(HideChatTranslatedNameRequest r100) {
            Long r101 = r100.chat_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HideChatTranslatedNameRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HideChatTranslatedNameRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HideChatTranslatedNameRequest r101) throws IOException {
            Long r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HideChatTranslatedNameRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_HideChatTranslatedNameRequest r100 = new ProtoAdapter_HideChatTranslatedNameRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HideChatTranslatedNameRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HideChatTranslatedNameRequest(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public HideChatTranslatedNameRequest(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chat_id = r100;
    }
}
