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
public final class Point extends Message<Point, Builder> {
    public static final ProtoAdapter<Point> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double longitude;

    public static final class Builder extends Message.Builder<Point, Builder> {
        public Double latitude;
        public Double longitude;

        @Override // com.squareup.wire.Message.Builder
        public Point build() {
            return new Point(this.longitude, this.latitude, super.buildUnknownFields());
        }

        public Builder() {
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
    }

    public static final class ProtoAdapter_Point extends ProtoAdapter<Point> {
        public ProtoAdapter_Point() {
            super(FieldEncoding.LENGTH_DELIMITED, Point.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Point decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.longitude(ProtoAdapter.DOUBLE.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.latitude(ProtoAdapter.DOUBLE.decode(r100));
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
        public int encodedSize2(Point r100) {
            ProtoAdapter<Double> r101 = ProtoAdapter.DOUBLE;
            return (r101.encodedSizeWithTag(1, r100.longitude) + r101.encodedSizeWithTag(2, r100.latitude)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Point redact2(Point r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Point decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Point r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Point redact(Point r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Point r101) throws IOException {
            ProtoAdapter<Double> r102 = ProtoAdapter.DOUBLE;
            r102.encodeWithTag(r100, 1, r101.longitude);
            r102.encodeWithTag(r100, 2, r101.latitude);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Point r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Point();
        Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT_LONGITUDE = r100;
        DEFAULT_LATITUDE = r100;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = unknownFields().hashCode() * 37;
        Double r102 = this.longitude;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Double r106 = this.latitude;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        int r107 = r105 + r103;
        this.hashCode = r107;
        return r107;
    L7:
        r104 = 0;
        goto L8
    L13:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.longitude = this.longitude;
        r100.latitude = this.latitude;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r100.append(", longitude=");
        r100.append(this.longitude);
    L6:
        if (this.latitude == null) goto L8;
        r100.append(", latitude=");
        r100.append(this.latitude);
    L8:
        StringBuilder r101 = r100.replace(0, 2, "Point{");
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
        if ((r100 instanceof Point) == true) goto L8;
        return false;
    L8:
        Point r101 = (Point) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.longitude, r101.longitude) == false) goto L15;
        if (Internal.equals(this.latitude, r101.latitude) == false) goto L15;
        return true;
    }

    public Point(Double r100, Double r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Point(Double r100, Double r101, ByteString r102) {
        super(ADAPTER, r102);
        this.longitude = r100;
        this.latitude = r101;
    }
}
