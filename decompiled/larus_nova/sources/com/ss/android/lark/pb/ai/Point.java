package com.ss.android.lark.pb.ai;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Point extends Message<Point, Builder> {
    public static final ProtoAdapter<Point> ADAPTER = null;
    public static final Double DEFAULT_X = null;
    public static final Double DEFAULT_Y = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: mx, reason: collision with root package name */
    public final Double f438532mx;

    /* JADX INFO: renamed from: my, reason: collision with root package name */
    public final Double f438533my;

    public static final class Builder extends Message.Builder<Point, Builder> {

        /* JADX INFO: renamed from: mx, reason: collision with root package name */
        public Double f438534mx;

        /* JADX INFO: renamed from: my, reason: collision with root package name */
        public Double f438535my;

        @Override // com.squareup.wire.Message.Builder
        public Point build() {
            Double r100 = this.f438534mx;
            if (r100 == null) goto L9;
            if (this.f438535my == null) goto L9;
            return new Point(this.f438534mx, this.f438535my, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mx", this.f438535my, "my"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder x(Double r100) {
            this.f438534mx = r100;
            return this;
        }

        public Builder y(Double r100) {
            this.f438535my = r100;
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
            Double r102 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.f438534mx = r102;
            r101.f438535my = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r101.f438534mx = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L9;
            r101.f438535my = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Point r100) {
            ProtoAdapter<Double> r101 = ProtoAdapter.DOUBLE;
            return (r101.encodedSizeWithTag(1, r100.f438532mx) + r101.encodedSizeWithTag(2, r100.f438533my)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Point decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Point r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Point r101) throws IOException {
            ProtoAdapter<Double> r102 = ProtoAdapter.DOUBLE;
            r102.encodeWithTag(r100, 1, r101.f438532mx);
            r102.encodeWithTag(r100, 2, r101.f438533my);
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
        DEFAULT_X = r100;
        DEFAULT_Y = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f438534mx = this.f438532mx;
        r100.f438535my = this.f438533my;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Point.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Point(Double r100, Double r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Point(Double r100, Double r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f438532mx = r100;
        this.f438533my = r101;
    }
}
