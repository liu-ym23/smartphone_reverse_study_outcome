package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Content;
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
public final class RecallGroupMessageResponse extends Message<RecallGroupMessageResponse, Builder> {
    public static final ProtoAdapter<RecallGroupMessageResponse> ADAPTER = null;
    public static final ProtoAdapter_RecallGroupMessageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Content content;

    public static final class Builder extends Message.Builder<RecallGroupMessageResponse, Builder> implements d<RecallGroupMessageResponse> {
        public Content content;

        @Override // com.squareup.wire.Message.Builder
        public RecallGroupMessageResponse build() {
            return new RecallGroupMessageResponse(this.content, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(Content r100) {
            this.content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecallGroupMessageResponse extends ProtoAdapter<RecallGroupMessageResponse> implements c<RecallGroupMessageResponse> {
        public ProtoAdapter_RecallGroupMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, RecallGroupMessageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecallGroupMessageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.content = Content.ADAPTER.decode(r100);
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
        public int encodedSize2(RecallGroupMessageResponse r100) {
            Content r101 = r100.content;
            if (r101 == null) goto L5;
            int r102 = Content.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecallGroupMessageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecallGroupMessageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecallGroupMessageResponse r101) throws IOException {
            Content r102 = r101.content;
            if (r102 == null) goto L5;
            Content.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecallGroupMessageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_RecallGroupMessageResponse r100 = new ProtoAdapter_RecallGroupMessageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.content = this.content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecallGroupMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecallGroupMessageResponse(Content r100) {
        this(r100, ByteString.EMPTY);
    }

    public RecallGroupMessageResponse(Content r100, ByteString r101) {
        super(ADAPTER, r101);
        this.content = r100;
    }
}
