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
public final class Circle extends Message<Circle, Builder> {
    public static final ProtoAdapter<Circle> ADAPTER = null;
    public static final Double DEFAULT_RADIUS = null;
    private static final long serialVersionUID = 0;

    @SerializedName("center")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    public final Point center;

    @SerializedName("radius")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double radius;

    public static final class Builder extends Message.Builder<Circle, Builder> {
        public Point center;
        public Double radius;

        @Override // com.squareup.wire.Message.Builder
        public Circle build() {
            return new Circle(this.center, this.radius, super.buildUnknownFields());
        }

        public Builder() {
            this.radius = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder center(Point r100) {
            this.center = r100;
            return this;
        }

        public Builder radius(Double r100) {
            this.radius = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Circle extends ProtoAdapter<Circle> {
        public ProtoAdapter_Circle() {
            super(FieldEncoding.LENGTH_DELIMITED, Circle.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Circle decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.center(Point.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.radius(ProtoAdapter.DOUBLE.decode(r100));
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
        public int encodedSize2(Circle r100) {
            return (Point.ADAPTER.encodedSizeWithTag(1, r100.center) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r100.radius)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Circle redact2(Circle r100) {
            Builder r101 = r100.newBuilder();
            Point r102 = r101.center;
            if (r102 == null) goto L5;
            r101.center = Point.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Circle decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Circle r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Circle redact(Circle r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Circle r101) throws IOException {
            Point.ADAPTER.encodeWithTag(r100, 1, r101.center);
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 2, r101.radius);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Circle r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Circle();
        DEFAULT_RADIUS = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = unknownFields().hashCode() * 37;
        Point r102 = this.center;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Double r106 = this.radius;
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
        r100.center = this.center;
        r100.radius = this.radius;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.center == null) goto L6;
        r100.append(", center=");
        r100.append(this.center);
    L6:
        if (this.radius == null) goto L8;
        r100.append(", radius=");
        r100.append(this.radius);
    L8:
        StringBuilder r101 = r100.replace(0, 2, "Circle{");
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
        if ((r100 instanceof Circle) == true) goto L8;
        return false;
    L8:
        Circle r101 = (Circle) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.center, r101.center) == false) goto L15;
        if (Internal.equals(this.radius, r101.radius) == false) goto L15;
        return true;
    }

    public Circle(Point r100, Double r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Circle(Point r100, Double r101, ByteString r102) {
        super(ADAPTER, r102);
        this.center = r100;
        this.radius = r101;
    }
}
