package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FeedsbackResponse extends Message<FeedsbackResponse, Builder> {
    public static final ProtoAdapter<FeedsbackResponse> ADAPTER = null;
    public static final Long DEFAULT_CODE = null;
    public static final String DEFAULT_MESSAGE = "";
    private static final long serialVersionUID = 0;
    public final Long mcode;
    public final String mmessage;

    public static final class Builder extends Message.Builder<FeedsbackResponse, Builder> {
        public Long mcode;
        public String mmessage;

        @Override // com.squareup.wire.Message.Builder
        public FeedsbackResponse build() {
            return new FeedsbackResponse(this.mcode, this.mmessage, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder code(Long r100) {
            this.mcode = r100;
            return this;
        }

        public Builder message(String r100) {
            this.mmessage = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedsbackResponse extends ProtoAdapter<FeedsbackResponse> {
        public ProtoAdapter_FeedsbackResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedsbackResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedsbackResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcode = 0L;
            r101.mmessage = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mcode = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mmessage = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FeedsbackResponse r100) {
            Long r101 = r100.mcode;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mmessage;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedsbackResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedsbackResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedsbackResponse r101) throws IOException {
            Long r102 = r101.mcode;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mmessage;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedsbackResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedsbackResponse();
        DEFAULT_CODE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcode = this.mcode;
        r100.mmessage = this.mmessage;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedsbackResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedsbackResponse(Long r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FeedsbackResponse(Long r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mcode = r100;
        this.mmessage = r101;
    }
}
