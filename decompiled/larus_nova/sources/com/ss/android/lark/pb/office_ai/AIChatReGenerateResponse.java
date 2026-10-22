package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AIChatReGenerateResponse extends Message<AIChatReGenerateResponse, Builder> {
    public static final ProtoAdapter<AIChatReGenerateResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> mmessage_ids;

    public static final class Builder extends Message.Builder<AIChatReGenerateResponse, Builder> {
        public List<Long> mmessage_ids;

        @Override // com.squareup.wire.Message.Builder
        public AIChatReGenerateResponse build() {
            return new AIChatReGenerateResponse(this.mmessage_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessage_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmessage_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AIChatReGenerateResponse extends ProtoAdapter<AIChatReGenerateResponse> {
        public ProtoAdapter_AIChatReGenerateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AIChatReGenerateResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIChatReGenerateResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mmessage_ids.add(ProtoAdapter.INT64.decode(r100));
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
        public int encodedSize2(AIChatReGenerateResponse r100) {
            return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.mmessage_ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AIChatReGenerateResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIChatReGenerateResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIChatReGenerateResponse r101) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.mmessage_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIChatReGenerateResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIChatReGenerateResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIChatReGenerateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIChatReGenerateResponse(List<Long> r100) {
        this(r100, ByteString.EMPTY);
    }

    public AIChatReGenerateResponse(List<Long> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r100);
    }
}
