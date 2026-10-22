package com.bytedance.lark.pb.contact.v1;

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
public final class UpdateChatterResponse extends Message<UpdateChatterResponse, Builder> {
    public static final ProtoAdapter<UpdateChatterResponse> ADAPTER = null;
    public static final String DEFAULT_MESSAGE = "";
    public static final ProtoAdapter_UpdateChatterResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String message;

    public static final class Builder extends Message.Builder<UpdateChatterResponse, Builder> implements d<UpdateChatterResponse> {
        public String message;

        @Override // com.squareup.wire.Message.Builder
        public UpdateChatterResponse build() {
            return new UpdateChatterResponse(this.message, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message(String r100) {
            this.message = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateChatterResponse extends ProtoAdapter<UpdateChatterResponse> implements c<UpdateChatterResponse> {
        public ProtoAdapter_UpdateChatterResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatterResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateChatterResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.message = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UpdateChatterResponse r100) {
            String r101 = r100.message;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateChatterResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateChatterResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateChatterResponse r101) throws IOException {
            String r102 = r101.message;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateChatterResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateChatterResponse r100 = new ProtoAdapter_UpdateChatterResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message = this.message;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateChatterResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateChatterResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateChatterResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.message = r100;
    }
}
