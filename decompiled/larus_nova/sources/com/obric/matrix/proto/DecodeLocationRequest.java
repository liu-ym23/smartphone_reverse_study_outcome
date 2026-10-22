package com.obric.matrix.proto;

import androidx.camera.video.AudioStats;
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
public final class DecodeLocationRequest extends Message<DecodeLocationRequest, Builder> {
    public static final ProtoAdapter<DecodeLocationRequest> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    public final Double latitude;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double longitude;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class Builder extends Message.Builder<DecodeLocationRequest, Builder> {
        public Double latitude;
        public Double longitude;
        public String packageName;

        @Override // com.squareup.wire.Message.Builder
        public DecodeLocationRequest build() {
            return new DecodeLocationRequest(this.packageName, this.longitude, this.latitude, super.buildUnknownFields());
        }

        public Builder() {
            this.packageName = "";
            Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            this.longitude = r100;
            this.latitude = r100;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder latitude(Double r100) {
            this.latitude = r100;
            return this;
        }

        public Builder longitude(Double r100) {
            this.longitude = r100;
            return this;
        }

        public Builder packageName(String r100) {
            this.packageName = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DecodeLocationRequest extends ProtoAdapter<DecodeLocationRequest> {
        public ProtoAdapter_DecodeLocationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DecodeLocationRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DecodeLocationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.packageName(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.longitude(ProtoAdapter.DOUBLE.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.latitude(ProtoAdapter.DOUBLE.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DecodeLocationRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.packageName);
            ProtoAdapter<Double> r102 = ProtoAdapter.DOUBLE;
            return ((r101 + r102.encodedSizeWithTag(2, r100.longitude)) + r102.encodedSizeWithTag(3, r100.latitude)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public DecodeLocationRequest redact2(DecodeLocationRequest r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DecodeLocationRequest r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest redact(DecodeLocationRequest r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DecodeLocationRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.packageName);
            ProtoAdapter<Double> r102 = ProtoAdapter.DOUBLE;
            r102.encodeWithTag(r100, 2, r101.longitude);
            r102.encodeWithTag(r100, 3, r101.latitude);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DecodeLocationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DecodeLocationRequest();
        Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT_LONGITUDE = r100;
        DEFAULT_LATITUDE = r100;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.packageName;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Double r106 = this.longitude;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Double r109 = this.latitude;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = r108 + r103;
        this.hashCode = r110;
        return r110;
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L17:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.packageName = this.packageName;
        r100.longitude = this.longitude;
        r100.latitude = this.latitude;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.packageName == null) goto L6;
        r100.append(", packageName=");
        r100.append(this.packageName);
    L6:
        if (this.longitude == null) goto L9;
        r100.append(", longitude=");
        r100.append(this.longitude);
    L9:
        if (this.latitude == null) goto L11;
        r100.append(", latitude=");
        r100.append(this.latitude);
    L11:
        StringBuilder r101 = r100.replace(0, 2, "DecodeLocationRequest{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof DecodeLocationRequest) == true) goto L8;
        return false;
    L8:
        DecodeLocationRequest r101 = (DecodeLocationRequest) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (Internal.equals(this.packageName, r101.packageName) == false) goto L17;
        if (Internal.equals(this.longitude, r101.longitude) == false) goto L17;
        if (Internal.equals(this.latitude, r101.latitude) == false) goto L17;
        return true;
    }

    public DecodeLocationRequest(String r100, Double r101, Double r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DecodeLocationRequest(String r100, Double r101, Double r102, ByteString r103) {
        super(ADAPTER, r103);
        this.packageName = r100;
        this.longitude = r101;
        this.latitude = r102;
    }
}
