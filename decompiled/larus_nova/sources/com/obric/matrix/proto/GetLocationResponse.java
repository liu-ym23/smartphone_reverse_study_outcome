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
public final class GetLocationResponse extends Message<GetLocationResponse, Builder> {
    public static final ProtoAdapter<GetLocationResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("locationInfo")
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    public final LocationInfo locationInfo;

    public static final class Builder extends Message.Builder<GetLocationResponse, Builder> {
        public LocationInfo locationInfo;

        @Override // com.squareup.wire.Message.Builder
        public GetLocationResponse build() {
            return new GetLocationResponse(this.locationInfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder locationInfo(LocationInfo r100) {
            this.locationInfo = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLocationResponse extends ProtoAdapter<GetLocationResponse> {
        public ProtoAdapter_GetLocationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLocationResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetLocationResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.locationInfo(LocationInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(GetLocationResponse r100) {
            return LocationInfo.ADAPTER.encodedSizeWithTag(1, r100.locationInfo) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetLocationResponse redact2(GetLocationResponse r100) {
            Builder r101 = r100.newBuilder();
            LocationInfo r102 = r101.locationInfo;
            if (r102 == null) goto L5;
            r101.locationInfo = LocationInfo.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLocationResponse r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLocationResponse redact(GetLocationResponse r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetLocationResponse r101) throws IOException {
            LocationInfo.ADAPTER.encodeWithTag(r100, 1, r101.locationInfo);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetLocationResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetLocationResponse();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L10;
        int r101 = unknownFields().hashCode() * 37;
        LocationInfo r102 = this.locationInfo;
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
        r100.locationInfo = this.locationInfo;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.locationInfo == null) goto L5;
        r100.append(", locationInfo=");
        r100.append(this.locationInfo);
    L5:
        StringBuilder r101 = r100.replace(0, 2, "GetLocationResponse{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetLocationResponse(LocationInfo r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetLocationResponse) == true) goto L8;
        return false;
    L8:
        GetLocationResponse r101 = (GetLocationResponse) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Internal.equals(this.locationInfo, r101.locationInfo) == false) goto L13;
        return true;
    }

    public GetLocationResponse(LocationInfo r100, ByteString r101) {
        super(ADAPTER, r101);
        this.locationInfo = r100;
    }
}
