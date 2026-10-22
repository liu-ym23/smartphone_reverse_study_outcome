package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.CardAction;
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
public final class PutActionResponse extends Message<PutActionResponse, Builder> {
    public static final ProtoAdapter<PutActionResponse> ADAPTER = null;
    public static final CardAction.Method DEFAULT_METHOD = null;
    public static final ProtoAdapter_PutActionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CardAction.Method method;
    public final CardAction.Url open_url;

    public static final class Builder extends Message.Builder<PutActionResponse, Builder> implements d<PutActionResponse> {
        public CardAction.Method method;
        public CardAction.Url open_url;

        @Override // com.squareup.wire.Message.Builder
        public PutActionResponse build() {
            return new PutActionResponse(this.method, this.open_url, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder method(CardAction.Method r100) {
            this.method = r100;
            return this;
        }

        public Builder open_url(CardAction.Url r100) {
            this.open_url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutActionResponse extends ProtoAdapter<PutActionResponse> implements c<PutActionResponse> {
        public ProtoAdapter_PutActionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutActionResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutActionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.method = CardAction.Method.GET;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.method = CardAction.Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.open_url = CardAction.Url.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PutActionResponse r100) {
            CardAction.Method r101 = r100.method;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CardAction.Method.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            CardAction.Url r104 = r100.open_url;
            if (r104 == null) goto L10;
            r102 = CardAction.Url.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutActionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutActionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutActionResponse r101) throws IOException {
            CardAction.Method r102 = r101.method;
            if (r102 == null) goto L5;
            CardAction.Method.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            CardAction.Url r103 = r101.open_url;
            if (r103 == null) goto L8;
            CardAction.Url.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutActionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutActionResponse r100 = new ProtoAdapter_PutActionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_METHOD = CardAction.Method.GET;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.method = this.method;
        r100.open_url = this.open_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutActionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutActionResponse(CardAction.Method r100, CardAction.Url r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutActionResponse(CardAction.Method r100, CardAction.Url r101, ByteString r102) {
        super(ADAPTER, r102);
        this.method = r100;
        this.open_url = r101;
    }
}
