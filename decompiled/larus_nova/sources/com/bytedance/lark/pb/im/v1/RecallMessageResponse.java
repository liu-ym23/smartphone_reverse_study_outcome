package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Content;
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
public final class RecallMessageResponse extends Message<RecallMessageResponse, Builder> {
    public static final ProtoAdapter<RecallMessageResponse> ADAPTER = null;
    public static final String DEFAULT_MESSAGE = "";
    public static final ProtoAdapter_RecallMessageResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Content content;
    public final String message;

    public static final class Builder extends Message.Builder<RecallMessageResponse, Builder> implements d<RecallMessageResponse> {
        public Content content;
        public String message;

        @Override // com.squareup.wire.Message.Builder
        public RecallMessageResponse build() {
            String r100 = this.message;
            if (r100 == null) goto L7;
            return new RecallMessageResponse(this.message, this.content, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "message"});
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

        public Builder message(String r100) {
            this.message = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecallMessageResponse extends ProtoAdapter<RecallMessageResponse> implements c<RecallMessageResponse> {
        public ProtoAdapter_RecallMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, RecallMessageResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecallMessageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.content = Content.ADAPTER.decode(r100);
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
        public int encodedSize2(RecallMessageResponse r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.message);
            Content r102 = r100.content;
            if (r102 == null) goto L5;
            int r103 = Content.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecallMessageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecallMessageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecallMessageResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.message);
            Content r102 = r101.content;
            if (r102 == null) goto L5;
            Content.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecallMessageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_RecallMessageResponse r100 = new ProtoAdapter_RecallMessageResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message = this.message;
        r100.content = this.content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecallMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecallMessageResponse(String r100, Content r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public RecallMessageResponse(String r100, Content r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message = r100;
        this.content = r101;
    }
}
