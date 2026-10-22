package com.ss.android.lark.location.dto;

import com.amap.api.services.district.DistrictSearchQuery;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR.\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010!j\n\u0012\u0004\u0012\u00020\"\u0018\u0001`#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010(\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010!j\n\u0012\u0004\u0012\u00020)\u0018\u0001`#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/ss/android/lark/location/dto/AddressComponent;", "", "Ljava/io/Serializable;", "<init>", "()V", DistrictSearchQuery.KEYWORDS_COUNTRY, "", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "province", "getProvince", "setProvince", "city", "getCity", "setCity", DistrictSearchQuery.KEYWORDS_DISTRICT, "getDistrict", "setDistrict", "township", "getTownship", "setTownship", "neighborhood", "getNeighborhood", "setNeighborhood", LocationConstants$NameType.BUILDING, "getBuilding", "setBuilding", "address", "getAddress", "setAddress", "aoiItems", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/location/dto/AoiItemInfo;", "Lkotlin/collections/ArrayList;", "getAoiItems", "()Ljava/util/ArrayList;", "setAoiItems", "(Ljava/util/ArrayList;)V", "poiItems", "Lcom/ss/android/lark/location/dto/PoiItemInfo;", "getPoiItems", "setPoiItems", "larkStreetNumber", "Lcom/ss/android/lark/location/dto/StreetNumberInfo;", "getLarkStreetNumber", "()Lcom/ss/android/lark/location/dto/StreetNumberInfo;", "setLarkStreetNumber", "(Lcom/ss/android/lark/location/dto/StreetNumberInfo;)V", "Builder", "location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddressComponent implements Cloneable, Serializable {
    private String address;
    private ArrayList<AoiItemInfo> aoiItems;
    private String building;
    private String city;
    private String country;
    private String district;
    private StreetNumberInfo larkStreetNumber;
    private String neighborhood;
    private ArrayList<PoiItemInfo> poiItems;
    private String province;
    private String township;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f431166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f431167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f431168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f431169d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f431170e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f431171f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f431172g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f431173h;

        public final AddressComponent a() {
            AddressComponent r100 = new AddressComponent();
            r100.setCountry(this.f431166a);
            r100.setProvince(this.f431167b);
            r100.setCity(this.f431168c);
            r100.setDistrict(this.f431169d);
            r100.setTownship(this.f431170e);
            r100.setNeighborhood(this.f431171f);
            r100.setBuilding(this.f431172g);
            r100.setAddress(this.f431173h);
            r100.setAoiItems(null);
            r100.setPoiItems(null);
            r100.setLarkStreetNumber(null);
            return r100;
        }

        public a() {
            this.f431166a = "";
            this.f431167b = "";
            this.f431168c = "";
            this.f431169d = "";
            this.f431170e = "";
            this.f431171f = "";
            this.f431172g = "";
            this.f431173h = "";
        }
    }

    public AddressComponent() {
        this.country = "";
        this.province = "";
        this.city = "";
        this.district = "";
        this.township = "";
        this.neighborhood = "";
        this.building = "";
        this.address = "";
    }

    public Object clone() {
        return super.clone();
    }

    public final String getAddress() {
        return this.address;
    }

    public final ArrayList<AoiItemInfo> getAoiItems() {
        return this.aoiItems;
    }

    public final String getBuilding() {
        return this.building;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final StreetNumberInfo getLarkStreetNumber() {
        return this.larkStreetNumber;
    }

    public final String getNeighborhood() {
        return this.neighborhood;
    }

    public final ArrayList<PoiItemInfo> getPoiItems() {
        return this.poiItems;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getTownship() {
        return this.township;
    }

    public final void setAddress(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.address = r100;
    }

    public final void setAoiItems(ArrayList<AoiItemInfo> r100) {
        this.aoiItems = r100;
    }

    public final void setBuilding(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.building = r100;
    }

    public final void setCity(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.city = r100;
    }

    public final void setCountry(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.country = r100;
    }

    public final void setDistrict(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.district = r100;
    }

    public final void setLarkStreetNumber(StreetNumberInfo r100) {
        this.larkStreetNumber = r100;
    }

    public final void setNeighborhood(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.neighborhood = r100;
    }

    public final void setPoiItems(ArrayList<PoiItemInfo> r100) {
        this.poiItems = r100;
    }

    public final void setProvince(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.province = r100;
    }

    public final void setTownship(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.township = r100;
    }
}
