package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Draft;
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
public final class FetchMessageReplyDraftResponse extends Message<FetchMessageReplyDraftResponse, Builder> {
    public static final ProtoAdapter<FetchMessageReplyDraftResponse> ADAPTER = null;
    public static final ProtoAdapter_FetchMessageReplyDraftResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Draft draft;

    public static final class Builder extends Message.Builder<FetchMessageReplyDraftResponse, Builder> implements d<FetchMessageReplyDraftResponse> {
        public Draft draft;

        @Override // com.squareup.wire.Message.Builder
        public FetchMessageReplyDraftResponse build() {
            return new FetchMessageReplyDraftResponse(this.draft, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder draft(Draft r100) {
            this.draft = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchMessageReplyDraftResponse extends ProtoAdapter<FetchMessageReplyDraftResponse> implements c<FetchMessageReplyDraftResponse> {
        public ProtoAdapter_FetchMessageReplyDraftResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchMessageReplyDraftResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FetchMessageReplyDraftResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.draft = Draft.ADAPTER.decode(r100);
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
        public int encodedSize2(FetchMessageReplyDraftResponse r100) {
            Draft r101 = r100.draft;
            if (r101 == null) goto L5;
            int r102 = Draft.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FetchMessageReplyDraftResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FetchMessageReplyDraftResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FetchMessageReplyDraftResponse r101) throws IOException {
            Draft r102 = r101.draft;
            if (r102 == null) goto L5;
            Draft.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FetchMessageReplyDraftResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_FetchMessageReplyDraftResponse r100 = new ProtoAdapter_FetchMessageReplyDraftResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.draft = this.draft;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FetchMessageReplyDraftResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FetchMessageReplyDraftResponse(Draft r100) {
        this(r100, ByteString.EMPTY);
    }

    public FetchMessageReplyDraftResponse(Draft r100, ByteString r101) {
        super(ADAPTER, r101);
        this.draft = r100;
    }
}
