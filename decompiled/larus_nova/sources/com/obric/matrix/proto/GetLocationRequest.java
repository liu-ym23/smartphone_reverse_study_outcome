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
public final class GetLocationRequest extends Message<GetLocationRequest, Builder> {
    public static final ProtoAdapter<GetLocationRequest> ADAPTER = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class Builder extends Message.Builder<GetLocationRequest, Builder> {
        public String packageName;

        @Override // com.squareup.wire.Message.Builder
        public GetLocationRequest build() {
            return new GetLocationRequest(this.packageName, super.buildUnknownFields());
        }

        public Builder() {
            this.packageName = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder packageName(String r100) {
            this.packageName = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLocationRequest extends ProtoAdapter<GetLocationRequest> {
        public ProtoAdapter_GetLocationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLocationRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetLocationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.packageName(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(GetLocationRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.packageName) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetLocationRequest redact2(GetLocationRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLocationRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationRequest redact(GetLocationRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetLocationRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.packageName);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetLocationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetLocationRequest();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.packageName;
        if (r102 == null) goto L7;
        int r103 = r102.hashCode();
    L8:
        int r104 = r101 + r103;
        this.hashCode = r104;
        return r104;
    L7:
        r103 = 0;
        goto L8
    L10:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.packageName = this.packageName;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.packageName == null) goto L5;
        r100.append(", packageName=");
        r100.append(this.packageName);
    L5:
        StringBuilder r101 = r100.replace(0, 2, "GetLocationRequest{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetLocationRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetLocationRequest) == true) goto L8;
        return false;
    L8:
        GetLocationRequest r101 = (GetLocationRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Internal.equals(this.packageName, r101.packageName) == false) goto L13;
        return true;
    }

    public GetLocationRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.packageName = r100;
    }
}
