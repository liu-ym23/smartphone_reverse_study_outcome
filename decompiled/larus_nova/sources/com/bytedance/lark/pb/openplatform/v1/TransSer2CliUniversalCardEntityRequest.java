package com.bytedance.lark.pb.openplatform.v1;

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
public final class TransSer2CliUniversalCardEntityRequest extends Message<TransSer2CliUniversalCardEntityRequest, Builder> {
    public static final ProtoAdapter<TransSer2CliUniversalCardEntityRequest> ADAPTER = null;
    public static final String DEFAULT_UNIVERSAL_CARD_ENTITY = "";
    public static final ProtoAdapter_TransSer2CliUniversalCardEntityRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String universal_card_entity;

    public static final class Builder extends Message.Builder<TransSer2CliUniversalCardEntityRequest, Builder> implements d<TransSer2CliUniversalCardEntityRequest> {
        public String universal_card_entity;

        @Override // com.squareup.wire.Message.Builder
        public TransSer2CliUniversalCardEntityRequest build() {
            String r100 = this.universal_card_entity;
            if (r100 == null) goto L7;
            return new TransSer2CliUniversalCardEntityRequest(this.universal_card_entity, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "universal_card_entity"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder universal_card_entity(String r100) {
            this.universal_card_entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TransSer2CliUniversalCardEntityRequest extends ProtoAdapter<TransSer2CliUniversalCardEntityRequest> implements c<TransSer2CliUniversalCardEntityRequest> {
        public ProtoAdapter_TransSer2CliUniversalCardEntityRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, TransSer2CliUniversalCardEntityRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TransSer2CliUniversalCardEntityRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.universal_card_entity = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.universal_card_entity = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(TransSer2CliUniversalCardEntityRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.universal_card_entity) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TransSer2CliUniversalCardEntityRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TransSer2CliUniversalCardEntityRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TransSer2CliUniversalCardEntityRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.universal_card_entity);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransSer2CliUniversalCardEntityRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TransSer2CliUniversalCardEntityRequest r100 = new ProtoAdapter_TransSer2CliUniversalCardEntityRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.universal_card_entity = this.universal_card_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TransSer2CliUniversalCardEntityRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TransSer2CliUniversalCardEntityRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public TransSer2CliUniversalCardEntityRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.universal_card_entity = r100;
    }
}
