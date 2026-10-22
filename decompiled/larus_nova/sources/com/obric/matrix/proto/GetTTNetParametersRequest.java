package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class GetTTNetParametersRequest extends Message<GetTTNetParametersRequest, Builder> {
    public static final ProtoAdapter<GetTTNetParametersRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GetTTNetParametersRequest, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public GetTTNetParametersRequest build() {
            return new GetTTNetParametersRequest(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ProtoAdapter_GetTTNetParametersRequest extends ProtoAdapter<GetTTNetParametersRequest> {
        public ProtoAdapter_GetTTNetParametersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTTNetParametersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTTNetParametersRequest r100) {
            return r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetTTNetParametersRequest redact2(GetTTNetParametersRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTTNetParametersRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersRequest redact(GetTTNetParametersRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTTNetParametersRequest r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTTNetParametersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetTTNetParametersRequest();
    }

    public GetTTNetParametersRequest() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder().replace(0, 2, "GetTTNetParametersRequest{");
        r100.append('}');
        return r100.toString();
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTTNetParametersRequest(ByteString r100) {
        super(ADAPTER, r100);
    }

    public boolean equals(Object r100) {
        return r100 instanceof GetTTNetParametersRequest;
    }
}
