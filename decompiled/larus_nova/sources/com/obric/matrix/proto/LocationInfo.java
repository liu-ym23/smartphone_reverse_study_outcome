package com.obric.matrix.proto;

import androidx.camera.video.AudioStats;
import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
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
public final class LocationInfo extends Message<LocationInfo, Builder> {
    public static final ProtoAdapter<LocationInfo> ADAPTER = null;
    public static final String DEFAULT_ADDRESSLINE = "";
    public static final String DEFAULT_ADMINISTRATIVEAREA = "";
    public static final String DEFAULT_CITY = "";
    public static final String DEFAULT_CITYCODE = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_COUNTRYCODE = "";
    public static final String DEFAULT_DISTRICT = "";
    public static final String DEFAULT_DISTRICTCODE = "";
    public static final Double DEFAULT_LATITUDE = null;
    public static final String DEFAULT_LOCALITY = "";
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_STREET = "";
    public static final String DEFAULT_SUBADMINISTRATIVEAREA = "";
    public static final String DEFAULT_SUBLOCALITY = "";
    public static final String DEFAULT_TOWN = "";
    private static final long serialVersionUID = 0;

    @SerializedName("addressLine")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String addressLine;

    @SerializedName("administrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String administrativeArea;

    @SerializedName("city")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String city;

    @SerializedName("cityCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String cityCode;

    @SerializedName(DistrictSearchQuery.KEYWORDS_COUNTRY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String country;

    @SerializedName(CommonConstant.KEY_COUNTRY_CODE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String countryCode;

    @SerializedName(DistrictSearchQuery.KEYWORDS_DISTRICT)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String district;

    @SerializedName("districtCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final String districtCode;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName("locality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String locality;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double longitude;

    @SerializedName("street")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String street;

    @SerializedName("subAdministrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String subAdministrativeArea;

    @SerializedName("subLocality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String subLocality;

    @SerializedName("town")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String town;

    public static final class Builder extends Message.Builder<LocationInfo, Builder> {
        public String addressLine;
        public String administrativeArea;
        public String city;
        public String cityCode;
        public String country;
        public String countryCode;
        public String district;
        public String districtCode;
        public Double latitude;
        public String locality;
        public Double longitude;
        public String street;
        public String subAdministrativeArea;
        public String subLocality;
        public String town;

        @Override // com.squareup.wire.Message.Builder
        public LocationInfo build() {
            return new LocationInfo(this.longitude, this.latitude, this.country, this.countryCode, this.administrativeArea, this.city, this.district, this.town, this.street, this.subAdministrativeArea, this.locality, this.subLocality, this.addressLine, this.cityCode, this.districtCode, super.buildUnknownFields());
        }

        public Builder() {
            Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            this.longitude = r100;
            this.latitude = r100;
            this.country = "";
            this.countryCode = "";
            this.administrativeArea = "";
            this.city = "";
            this.district = "";
            this.town = "";
            this.street = "";
            this.subAdministrativeArea = "";
            this.locality = "";
            this.subLocality = "";
            this.addressLine = "";
            this.cityCode = "";
            this.districtCode = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder addressLine(String r100) {
            this.addressLine = r100;
            return this;
        }

        public Builder administrativeArea(String r100) {
            this.administrativeArea = r100;
            return this;
        }

        public Builder city(String r100) {
            this.city = r100;
            return this;
        }

        public Builder cityCode(String r100) {
            this.cityCode = r100;
            return this;
        }

        public Builder country(String r100) {
            this.country = r100;
            return this;
        }

        public Builder countryCode(String r100) {
            this.countryCode = r100;
            return this;
        }

        public Builder district(String r100) {
            this.district = r100;
            return this;
        }

        public Builder districtCode(String r100) {
            this.districtCode = r100;
            return this;
        }

        public Builder latitude(Double r100) {
            this.latitude = r100;
            return this;
        }

        public Builder locality(String r100) {
            this.locality = r100;
            return this;
        }

        public Builder longitude(Double r100) {
            this.longitude = r100;
            return this;
        }

        public Builder street(String r100) {
            this.street = r100;
            return this;
        }

        public Builder subAdministrativeArea(String r100) {
            this.subAdministrativeArea = r100;
            return this;
        }

        public Builder subLocality(String r100) {
            this.subLocality = r100;
            return this;
        }

        public Builder town(String r100) {
            this.town = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LocationInfo extends ProtoAdapter<LocationInfo> {
        public ProtoAdapter_LocationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LocationInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LocationInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L22;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L7:
            r101.districtCode(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.cityCode(ProtoAdapter.STRING.decode(r100));
            goto L3
        L9:
            r101.addressLine(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.subLocality(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.locality(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            r101.subAdministrativeArea(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.street(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            r101.town(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            r101.district(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.city(ProtoAdapter.STRING.decode(r100));
            goto L3
        L17:
            r101.administrativeArea(ProtoAdapter.STRING.decode(r100));
            goto L3
        L18:
            r101.countryCode(ProtoAdapter.STRING.decode(r100));
            goto L3
        L19:
            r101.country(ProtoAdapter.STRING.decode(r100));
            goto L3
        L20:
            r101.latitude(ProtoAdapter.DOUBLE.decode(r100));
            goto L3
        L21:
            r101.longitude(ProtoAdapter.DOUBLE.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L22:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LocationInfo r100) {
            ProtoAdapter<Double> r101 = ProtoAdapter.DOUBLE;
            int r102 = r101.encodedSizeWithTag(1, r100.longitude) + r101.encodedSizeWithTag(2, r100.latitude);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            return (((((((((((((r102 + r103.encodedSizeWithTag(3, r100.country)) + r103.encodedSizeWithTag(4, r100.countryCode)) + r103.encodedSizeWithTag(5, r100.administrativeArea)) + r103.encodedSizeWithTag(6, r100.city)) + r103.encodedSizeWithTag(7, r100.district)) + r103.encodedSizeWithTag(8, r100.town)) + r103.encodedSizeWithTag(9, r100.street)) + r103.encodedSizeWithTag(10, r100.subAdministrativeArea)) + r103.encodedSizeWithTag(11, r100.locality)) + r103.encodedSizeWithTag(12, r100.subLocality)) + r103.encodedSizeWithTag(13, r100.addressLine)) + r103.encodedSizeWithTag(14, r100.cityCode)) + r103.encodedSizeWithTag(15, r100.districtCode)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public LocationInfo redact2(LocationInfo r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LocationInfo r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo redact(LocationInfo r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LocationInfo r101) throws IOException {
            ProtoAdapter<Double> r102 = ProtoAdapter.DOUBLE;
            r102.encodeWithTag(r100, 1, r101.longitude);
            r102.encodeWithTag(r100, 2, r101.latitude);
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 3, r101.country);
            r103.encodeWithTag(r100, 4, r101.countryCode);
            r103.encodeWithTag(r100, 5, r101.administrativeArea);
            r103.encodeWithTag(r100, 6, r101.city);
            r103.encodeWithTag(r100, 7, r101.district);
            r103.encodeWithTag(r100, 8, r101.town);
            r103.encodeWithTag(r100, 9, r101.street);
            r103.encodeWithTag(r100, 10, r101.subAdministrativeArea);
            r103.encodeWithTag(r100, 11, r101.locality);
            r103.encodeWithTag(r100, 12, r101.subLocality);
            r103.encodeWithTag(r100, 13, r101.addressLine);
            r103.encodeWithTag(r100, 14, r101.cityCode);
            r103.encodeWithTag(r100, 15, r101.districtCode);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LocationInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LocationInfo();
        Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT_LONGITUDE = r100;
        DEFAULT_LATITUDE = r100;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L65;
        int r101 = unknownFields().hashCode() * 37;
        Double r102 = this.longitude;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Double r106 = this.latitude;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.country;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        String r112 = this.countryCode;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        String r115 = this.administrativeArea;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        String r118 = this.city;
        if (r118 == null) goto L27;
        int r119 = r118.hashCode();
    L28:
        int r120 = (r117 + r119) * 37;
        String r121 = this.district;
        if (r121 == null) goto L31;
        int r122 = r121.hashCode();
    L32:
        int r123 = (r120 + r122) * 37;
        String r124 = this.town;
        if (r124 == null) goto L35;
        int r125 = r124.hashCode();
    L36:
        int r126 = (r123 + r125) * 37;
        String r127 = this.street;
        if (r127 == null) goto L39;
        int r128 = r127.hashCode();
    L40:
        int r129 = (r126 + r128) * 37;
        String r130 = this.subAdministrativeArea;
        if (r130 == null) goto L43;
        int r131 = r130.hashCode();
    L44:
        int r132 = (r129 + r131) * 37;
        String r133 = this.locality;
        if (r133 == null) goto L47;
        int r134 = r133.hashCode();
    L48:
        int r135 = (r132 + r134) * 37;
        String r136 = this.subLocality;
        if (r136 == null) goto L51;
        int r137 = r136.hashCode();
    L52:
        int r138 = (r135 + r137) * 37;
        String r139 = this.addressLine;
        if (r139 == null) goto L55;
        int r140 = r139.hashCode();
    L56:
        int r141 = (r138 + r140) * 37;
        String r142 = this.cityCode;
        if (r142 == null) goto L59;
        int r143 = r142.hashCode();
    L60:
        int r144 = (r141 + r143) * 37;
        String r145 = this.districtCode;
        if (r145 == null) goto L63;
        r103 = r145.hashCode();
    L63:
        int r146 = r144 + r103;
        this.hashCode = r146;
        return r146;
    L59:
        r143 = 0;
        goto L60
    L55:
        r140 = 0;
        goto L56
    L51:
        r137 = 0;
        goto L52
    L47:
        r134 = 0;
        goto L48
    L43:
        r131 = 0;
        goto L44
    L39:
        r128 = 0;
        goto L40
    L35:
        r125 = 0;
        goto L36
    L31:
        r122 = 0;
        goto L32
    L27:
        r119 = 0;
        goto L28
    L23:
        r116 = 0;
        goto L24
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L65:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.longitude = this.longitude;
        r100.latitude = this.latitude;
        r100.country = this.country;
        r100.countryCode = this.countryCode;
        r100.administrativeArea = this.administrativeArea;
        r100.city = this.city;
        r100.district = this.district;
        r100.town = this.town;
        r100.street = this.street;
        r100.subAdministrativeArea = this.subAdministrativeArea;
        r100.locality = this.locality;
        r100.subLocality = this.subLocality;
        r100.addressLine = this.addressLine;
        r100.cityCode = this.cityCode;
        r100.districtCode = this.districtCode;
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
        if (this.latitude == null) goto L9;
        r100.append(", latitude=");
        r100.append(this.latitude);
    L9:
        if (this.country == null) goto L12;
        r100.append(", country=");
        r100.append(this.country);
    L12:
        if (this.countryCode == null) goto L15;
        r100.append(", countryCode=");
        r100.append(this.countryCode);
    L15:
        if (this.administrativeArea == null) goto L18;
        r100.append(", administrativeArea=");
        r100.append(this.administrativeArea);
    L18:
        if (this.city == null) goto L21;
        r100.append(", city=");
        r100.append(this.city);
    L21:
        if (this.district == null) goto L24;
        r100.append(", district=");
        r100.append(this.district);
    L24:
        if (this.town == null) goto L27;
        r100.append(", town=");
        r100.append(this.town);
    L27:
        if (this.street == null) goto L30;
        r100.append(", street=");
        r100.append(this.street);
    L30:
        if (this.subAdministrativeArea == null) goto L33;
        r100.append(", subAdministrativeArea=");
        r100.append(this.subAdministrativeArea);
    L33:
        if (this.locality == null) goto L36;
        r100.append(", locality=");
        r100.append(this.locality);
    L36:
        if (this.subLocality == null) goto L39;
        r100.append(", subLocality=");
        r100.append(this.subLocality);
    L39:
        if (this.addressLine == null) goto L42;
        r100.append(", addressLine=");
        r100.append(this.addressLine);
    L42:
        if (this.cityCode == null) goto L45;
        r100.append(", cityCode=");
        r100.append(this.cityCode);
    L45:
        if (this.districtCode == null) goto L47;
        r100.append(", districtCode=");
        r100.append(this.districtCode);
    L47:
        StringBuilder r101 = r100.replace(0, 2, "LocationInfo{");
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
        if ((r100 instanceof LocationInfo) == true) goto L8;
        return false;
    L8:
        LocationInfo r101 = (LocationInfo) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L41:
        return false;
    L11:
        if (Internal.equals(this.longitude, r101.longitude) == false) goto L41;
        if (Internal.equals(this.latitude, r101.latitude) == false) goto L41;
        if (Internal.equals(this.country, r101.country) == false) goto L41;
        if (Internal.equals(this.countryCode, r101.countryCode) == false) goto L41;
        if (Internal.equals(this.administrativeArea, r101.administrativeArea) == false) goto L41;
        if (Internal.equals(this.city, r101.city) == false) goto L41;
        if (Internal.equals(this.district, r101.district) == false) goto L41;
        if (Internal.equals(this.town, r101.town) == false) goto L41;
        if (Internal.equals(this.street, r101.street) == false) goto L41;
        if (Internal.equals(this.subAdministrativeArea, r101.subAdministrativeArea) == false) goto L41;
        if (Internal.equals(this.locality, r101.locality) == false) goto L41;
        if (Internal.equals(this.subLocality, r101.subLocality) == false) goto L41;
        if (Internal.equals(this.addressLine, r101.addressLine) == false) goto L41;
        if (Internal.equals(this.cityCode, r101.cityCode) == false) goto L41;
        if (Internal.equals(this.districtCode, r101.districtCode) == false) goto L41;
        return true;
    }

    public LocationInfo(Double r110, Double r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public LocationInfo(Double r110, Double r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, ByteString r311) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, "", "", r311);
    }

    public LocationInfo(Double r110, Double r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310) {
        this(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, ByteString.EMPTY);
    }

    public LocationInfo(Double r110, Double r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, ByteString.EMPTY);
    }

    public LocationInfo(Double r110, Double r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, ByteString r312) {
        this(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, "", r312);
    }

    public LocationInfo(Double r100, Double r101, String r102, String r103, String r104, String r105, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, ByteString r119) {
        super(ADAPTER, r119);
        this.longitude = r100;
        this.latitude = r101;
        this.country = r102;
        this.countryCode = r103;
        this.administrativeArea = r104;
        this.city = r105;
        this.district = r110;
        this.town = r111;
        this.street = r112;
        this.subAdministrativeArea = r113;
        this.locality = r114;
        this.subLocality = r115;
        this.addressLine = r116;
        this.cityCode = r117;
        this.districtCode = r118;
    }
}
