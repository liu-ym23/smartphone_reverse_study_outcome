package com.obric.matrix.proto;

import com.amap.api.fence.GeoFence;
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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class Fence extends Message<Fence, Builder> {
    public static final ProtoAdapter<Fence> ADAPTER = null;
    public static final String DEFAULT_FENCEID = "";
    public static final Integer DEFAULT_SHAPE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("circular")
    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    public final Circle circular;

    @SerializedName(GeoFence.BUNDLE_KEY_FENCEID)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String fenceid;

    @SerializedName("multi_polygon")
    @WireField(adapter = "com.obric.matrix.proto.MultiPolygon#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<MultiPolygon> multi_polygon;

    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<Polygon> polygons;

    @SerializedName("properties")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> properties;

    @SerializedName("shape")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer shape;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<Point> vertices;

    public static final class Builder extends Message.Builder<Fence, Builder> {
        public Circle circular;
        public String fenceid;
        public List<MultiPolygon> multi_polygon;
        public List<Polygon> polygons;
        public Map<String, String> properties;
        public Integer shape;
        public List<Point> vertices;

        @Override // com.squareup.wire.Message.Builder
        public Fence build() {
            return new Fence(this.fenceid, this.shape, this.circular, this.vertices, this.properties, this.polygons, this.multi_polygon, super.buildUnknownFields());
        }

        public Builder() {
            this.fenceid = "";
            this.shape = 0;
            this.vertices = Internal.newMutableList();
            this.properties = Internal.newMutableMap();
            this.polygons = Internal.newMutableList();
            this.multi_polygon = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder circular(Circle r100) {
            this.circular = r100;
            return this;
        }

        public Builder fenceid(String r100) {
            this.fenceid = r100;
            return this;
        }

        public Builder multi_polygon(List<MultiPolygon> r100) {
            Internal.checkElementsNotNull(r100);
            this.multi_polygon = r100;
            return this;
        }

        public Builder polygons(List<Polygon> r100) {
            Internal.checkElementsNotNull(r100);
            this.polygons = r100;
            return this;
        }

        public Builder properties(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.properties = r100;
            return this;
        }

        public Builder shape(Integer r100) {
            this.shape = r100;
            return this;
        }

        public Builder vertices(List<Point> r100) {
            Internal.checkElementsNotNull(r100);
            this.vertices = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Fence extends ProtoAdapter<Fence> {
        private final ProtoAdapter<Map<String, String>> properties;

        public ProtoAdapter_Fence() {
            super(FieldEncoding.LENGTH_DELIMITED, Fence.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.properties = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Fence decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.multi_polygon.add(MultiPolygon.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.polygons.add(Polygon.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.properties.putAll(this.properties.decode(r100));
            goto L3
        L10:
            r101.vertices.add(Point.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.circular(Circle.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.shape(ProtoAdapter.INT32.decode(r100));
            goto L3
        L13:
            r101.fenceid(ProtoAdapter.STRING.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Fence r100) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.fenceid) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.shape)) + Circle.ADAPTER.encodedSizeWithTag(3, r100.circular)) + Point.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.vertices)) + this.properties.encodedSizeWithTag(5, r100.properties)) + Polygon.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.polygons)) + MultiPolygon.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.multi_polygon)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Fence redact2(Fence r100) {
            Builder r101 = r100.newBuilder();
            Circle r102 = r101.circular;
            if (r102 == null) goto L5;
            r101.circular = Circle.ADAPTER.redact(r102);
        L5:
            Internal.redactElements(r101.vertices, Point.ADAPTER);
            Internal.redactElements(r101.polygons, Polygon.ADAPTER);
            Internal.redactElements(r101.multi_polygon, MultiPolygon.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Fence r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence redact(Fence r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Fence r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.fenceid);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.shape);
            Circle.ADAPTER.encodeWithTag(r100, 3, r101.circular);
            Point.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.vertices);
            this.properties.encodeWithTag(r100, 5, r101.properties);
            Polygon.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.polygons);
            MultiPolygon.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.multi_polygon);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Fence r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Fence();
        DEFAULT_SHAPE = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L17;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.fenceid;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.shape;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Circle r109 = this.circular;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        int r110 = ((((((((r108 + r103) * 37) + this.vertices.hashCode()) * 37) + this.properties.hashCode()) * 37) + this.polygons.hashCode()) * 37) + this.multi_polygon.hashCode();
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
        r100.fenceid = this.fenceid;
        r100.shape = this.shape;
        r100.circular = this.circular;
        r100.vertices = Internal.copyOf("vertices", this.vertices);
        r100.properties = Internal.copyOf("properties", this.properties);
        r100.polygons = Internal.copyOf("polygons", this.polygons);
        r100.multi_polygon = Internal.copyOf("multi_polygon", this.multi_polygon);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.fenceid == null) goto L6;
        r100.append(", fenceid=");
        r100.append(this.fenceid);
    L6:
        if (this.shape == null) goto L9;
        r100.append(", shape=");
        r100.append(this.shape);
    L9:
        if (this.circular == null) goto L11;
        r100.append(", circular=");
        r100.append(this.circular);
    L11:
        List<Point> r101 = this.vertices;
        if (r101 != null) goto L14;
    L16:
        Map<String, String> r102 = this.properties;
        if (r102 != null) goto L19;
    L21:
        List<Polygon> r103 = this.polygons;
        if (r103 != null) goto L24;
    L26:
        List<MultiPolygon> r104 = this.multi_polygon;
        if (r104 != null) goto L29;
    L31:
        StringBuilder r105 = r100.replace(0, 2, "Fence{");
        r105.append('}');
        return r105.toString();
    L29:
        if (r104.isEmpty() == true) goto L31;
        r100.append(", multi_polygon=");
        r100.append(this.multi_polygon);
        goto L31
    L24:
        if (r103.isEmpty() == true) goto L26;
        r100.append(", polygons=");
        r100.append(this.polygons);
        goto L26
    L19:
        if (r102.isEmpty() == true) goto L21;
        r100.append(", properties=");
        r100.append(this.properties);
        goto L21
    L14:
        if (r101.isEmpty() == true) goto L16;
        r100.append(", vertices=");
        r100.append(this.vertices);
        goto L16
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Fence) == true) goto L8;
        return false;
    L8:
        Fence r101 = (Fence) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L25:
        return false;
    L11:
        if (Internal.equals(this.fenceid, r101.fenceid) == false) goto L25;
        if (Internal.equals(this.shape, r101.shape) == false) goto L25;
        if (Internal.equals(this.circular, r101.circular) == false) goto L25;
        if (this.vertices.equals(r101.vertices) == false) goto L25;
        if (this.properties.equals(r101.properties) == false) goto L25;
        if (this.polygons.equals(r101.polygons) == false) goto L25;
        if (this.multi_polygon.equals(r101.multi_polygon) == false) goto L25;
        return true;
    }

    public Fence(String r110, Integer r111, Circle r112, List<Point> r113, Map<String, String> r114, List<Polygon> r115, List<MultiPolygon> r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public Fence(String r100, Integer r101, Circle r102, List<Point> r103, Map<String, String> r104, List<Polygon> r105, List<MultiPolygon> r106, ByteString r107) {
        super(ADAPTER, r107);
        this.fenceid = r100;
        this.shape = r101;
        this.circular = r102;
        this.vertices = Internal.immutableCopyOf("vertices", r103);
        this.properties = Internal.immutableCopyOf("properties", r104);
        this.polygons = Internal.immutableCopyOf("polygons", r105);
        this.multi_polygon = Internal.immutableCopyOf("multi_polygon", r106);
    }
}
