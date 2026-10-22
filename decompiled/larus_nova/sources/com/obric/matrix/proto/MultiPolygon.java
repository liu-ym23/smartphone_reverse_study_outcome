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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class MultiPolygon extends Message<MultiPolygon, Builder> {
    public static final ProtoAdapter<MultiPolygon> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Polygon> polygons;

    public static final class Builder extends Message.Builder<MultiPolygon, Builder> {
        public List<Polygon> polygons;

        @Override // com.squareup.wire.Message.Builder
        public MultiPolygon build() {
            return new MultiPolygon(this.polygons, super.buildUnknownFields());
        }

        public Builder() {
            this.polygons = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder polygons(List<Polygon> r100) {
            Internal.checkElementsNotNull(r100);
            this.polygons = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MultiPolygon extends ProtoAdapter<MultiPolygon> {
        public ProtoAdapter_MultiPolygon() {
            super(FieldEncoding.LENGTH_DELIMITED, MultiPolygon.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MultiPolygon decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.polygons.add(Polygon.ADAPTER.decode(r100));
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
        public int encodedSize2(MultiPolygon r100) {
            return Polygon.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.polygons) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public MultiPolygon redact2(MultiPolygon r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.polygons, Polygon.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MultiPolygon decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MultiPolygon r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MultiPolygon redact(MultiPolygon r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MultiPolygon r101) throws IOException {
            Polygon.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.polygons);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MultiPolygon r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MultiPolygon();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.polygons.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.polygons = Internal.copyOf("polygons", this.polygons);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<Polygon> r101 = this.polygons;
        if (r101 != null) goto L5;
    L7:
        StringBuilder r102 = r100.replace(0, 2, "MultiPolygon{");
        r102.append('}');
        return r102.toString();
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.append(", polygons=");
        r100.append(this.polygons);
        goto L7
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MultiPolygon(List<Polygon> r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof MultiPolygon) == true) goto L8;
        return false;
    L8:
        MultiPolygon r101 = (MultiPolygon) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.polygons.equals(r101.polygons) == false) goto L13;
        return true;
    }

    public MultiPolygon(List<Polygon> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.polygons = Internal.immutableCopyOf("polygons", r100);
    }
}
