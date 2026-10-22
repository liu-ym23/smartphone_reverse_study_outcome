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
public final class GetCustomizedStickersResponse extends Message<GetCustomizedStickersResponse, Builder> {
    public static final ProtoAdapter<GetCustomizedStickersResponse> ADAPTER = null;
    public static final ProtoAdapter_GetCustomizedStickersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Sticker> stickers;

    public static final class Builder extends Message.Builder<GetCustomizedStickersResponse, Builder> implements d<GetCustomizedStickersResponse> {
        public List<Sticker> stickers;

        @Override // com.squareup.wire.Message.Builder
        public GetCustomizedStickersResponse build() {
            return new GetCustomizedStickersResponse(this.stickers, super.buildUnknownFields());
        }

        public Builder() {
            this.stickers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder stickers(List<Sticker> r100) {
            Internal.checkElementsNotNull(r100);
            this.stickers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetCustomizedStickersResponse extends ProtoAdapter<GetCustomizedStickersResponse> implements c<GetCustomizedStickersResponse> {
        public ProtoAdapter_GetCustomizedStickersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetCustomizedStickersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetCustomizedStickersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.stickers.add(Sticker.ADAPTER.decode(r100));
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
        public int encodedSize2(GetCustomizedStickersResponse r100) {
            return Sticker.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.stickers) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetCustomizedStickersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetCustomizedStickersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetCustomizedStickersResponse r101) throws IOException {
            Sticker.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.stickers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetCustomizedStickersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetCustomizedStickersResponse r100 = new ProtoAdapter_GetCustomizedStickersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.stickers = Internal.copyOf("stickers", this.stickers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetCustomizedStickersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetCustomizedStickersResponse(List<Sticker> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetCustomizedStickersResponse(List<Sticker> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.stickers = Internal.immutableCopyOf("stickers", r100);
    }
}
