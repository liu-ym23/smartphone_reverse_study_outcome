package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class GetTTNetParametersResponse extends Message<GetTTNetParametersResponse, Builder> {
    public static final ProtoAdapter<GetTTNetParametersResponse> ADAPTER = null;
    public static final String DEFAULT_PARAMETERS = "";
    private static final long serialVersionUID = 0;

    @SerializedName("parameters")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String parameters;

    public static final class Builder extends Message.Builder<GetTTNetParametersResponse, Builder> {
        public String parameters;

        @Override // com.squareup.wire.Message.Builder
        public GetTTNetParametersResponse build() {
            String r100 = this.parameters;
            if (r100 == null) goto L7;
            return new GetTTNetParametersResponse(this.parameters, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "parameters"});
        }

        public Builder() {
            this.parameters = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder parameters(String r100) {
            this.parameters = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTTNetParametersResponse extends ProtoAdapter<GetTTNetParametersResponse> {
        public ProtoAdapter_GetTTNetParametersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTTNetParametersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.parameters(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetTTNetParametersResponse r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.parameters) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetTTNetParametersResponse redact2(GetTTNetParametersResponse r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTTNetParametersResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTTNetParametersResponse redact(GetTTNetParametersResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTTNetParametersResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.parameters);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTTNetParametersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetTTNetParametersResponse();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.parameters.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.parameters = this.parameters;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", parameters=");
        r100.append(this.parameters);
        StringBuilder r101 = r100.replace(0, 2, "GetTTNetParametersResponse{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTTNetParametersResponse(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetTTNetParametersResponse) == true) goto L8;
        return false;
    L8:
        GetTTNetParametersResponse r101 = (GetTTNetParametersResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.parameters.equals(r101.parameters) == false) goto L13;
        return true;
    }

    public GetTTNetParametersResponse(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.parameters = r100;
    }
}
