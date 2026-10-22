package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarLocation extends Message<CalendarLocation, Builder> {
    public static final ProtoAdapter<CalendarLocation> ADAPTER = null;
    public static final String DEFAULT_ADDRESS = "";
    public static final Float DEFAULT_LATITUDE = null;
    public static final String DEFAULT_LOCATION = "";
    public static final Float DEFAULT_LONGITUDE = null;
    private static final long serialVersionUID = 0;
    public final String address;
    public final Float latitude;
    public final String location;
    public final Float longitude;

    public static final class Builder extends Message.Builder<CalendarLocation, Builder> {
        public String address;
        public Float latitude;
        public String location;
        public Float longitude;

        @Override // com.squareup.wire.Message.Builder
        public CalendarLocation build() {
            return new CalendarLocation(this.location, this.address, this.latitude, this.longitude, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder address(String r100) {
            this.address = r100;
            return this;
        }

        public Builder latitude(Float r100) {
            this.latitude = r100;
            return this;
        }

        public Builder location(String r100) {
            this.location = r100;
            return this;
        }

        public Builder longitude(Float r100) {
            this.longitude = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CalendarLocation extends ProtoAdapter<CalendarLocation> {
        public ProtoAdapter_CalendarLocation() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarLocation.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarLocation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.location = "";
            r101.address = "";
            Float r102 = Float.valueOf(360.0f);
            r101.latitude = r102;
            r101.longitude = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.location = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.address = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.latitude = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.longitude = ProtoAdapter.FLOAT.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CalendarLocation r100) {
            String r101 = r100.location;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.address;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Float r107 = r100.latitude;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Float r110 = r100.longitude;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarLocation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarLocation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarLocation r101) throws IOException {
            String r102 = r101.location;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.address;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Float r104 = r101.latitude;
            if (r104 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 3, r104);
        L11:
            Float r105 = r101.longitude;
            if (r105 == null) goto L14;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarLocation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarLocation();
        Float r100 = Float.valueOf(360.0f);
        DEFAULT_LATITUDE = r100;
        DEFAULT_LONGITUDE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.location = this.location;
        r100.address = this.address;
        r100.latitude = this.latitude;
        r100.longitude = this.longitude;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarLocation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarLocation(String r100, String r101, Float r102, Float r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public CalendarLocation(String r100, String r101, Float r102, Float r103, ByteString r104) {
        super(ADAPTER, r104);
        this.location = r100;
        this.address = r101;
        this.latitude = r102;
        this.longitude = r103;
    }
}
