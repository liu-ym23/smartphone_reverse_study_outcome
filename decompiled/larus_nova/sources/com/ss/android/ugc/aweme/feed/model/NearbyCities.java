package com.ss.android.ugc.aweme.feed.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class NearbyCities implements Parcelable {
    public static final Parcelable.Creator<NearbyCities> CREATOR = null;
    public static String DATA_SOURCE_HOMEPAGE = "homepage";
    private List<CityBean> all;
    private CityBean current;
    private List<CityBean> history;
    private List<CityBean> hot;

    @SerializedName("log_pb")
    com.bytedance.locallife.model.groupon.LogPbBean logPb;
    private List<CityBean> old;
    private List<CityBean> quickAccessList;

    @SerializedName("search_page_url")
    String searchPageUrl;

    public static class CityBean implements Comparable<CityBean>, Parcelable {
        public static final Parcelable.Creator<CityBean> CREATOR = null;

        @SerializedName("ad_code")
        public String adCode;

        @SerializedName("asci_name")
        public String asciName;
        private String belongCity;
        private String belongCityCode;
        private String belongCountry;
        private String belongProvince;
        private String belongProvinceCode;

        @SerializedName("center")
        public List<Float> center;

        @SerializedName("city_name")
        public String cityName;

        @SerializedName("cn_pinyin")
        public String cnPinyin;
        private String code;

        @SerializedName("code_local")
        public String codeLocal;

        @SerializedName(DistrictSearchQuery.KEYWORDS_COUNTRY)
        public String country;

        @SerializedName("country_code")
        public String countryCode;

        @SerializedName("current_position_name")
        public String currentPositionName;

        @SerializedName("data_source")
        public String dataSource;

        @SerializedName("district_code")
        public String districtCode;

        @SerializedName("district_type")
        public String districtType;

        @SerializedName("districts")
        public List<CityBean> districts;

        /* JADX INFO: renamed from: en, reason: collision with root package name */
        private String f450815en;

        @SerializedName("feed_first_poi_info")
        public FeedFirstPoiInfo feedFirstPoiInfo;

        @SerializedName("geoname_id")
        public String geonameId;

        @SerializedName("groupon_address_code")
        public String grouponAddressCode;

        @SerializedName("groupon_address_name")
        public String grouponAddressName;

        @SerializedName("groupon_address_type")
        public String grouponAddressType;

        @SerializedName("groupon_city_name")
        public String grouponCityName;

        @SerializedName("is_aoi_selected")
        public boolean isAoiSelected;
        public boolean isL3;
        public String l2Name;

        @SerializedName("l2_re_code")
        public String l2ReCode;

        @SerializedName("l2_re_code_list")
        public List<String> l2ReCodeList;

        @SerializedName("level")
        public String level;

        @SerializedName("location_address_info")
        public LocationAddressInfo locationAddressInfo;
        private String name;

        @SerializedName("name_en")
        public String nameEn;

        @SerializedName("nearby_label_name")
        public String nearbyLabelName;

        @SerializedName("nearby_tab_name")
        public String nearbyTabName;
        public String requestTriggerType;

        @SerializedName("roam_city_code")
        public String roamCityCode;

        @SerializedName("show_name")
        public String showName;

        @SerializedName("show_type")
        public int showType;

        @SerializedName("sub_region")
        public List<CityBean> subRegion;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public CityBean() {
            this.isL3 = false;
            this.l2Name = "";
            this.requestTriggerType = null;
        }

        public FeedFirstPoiInfo feedFirstPoiInfo() {
            return this.feedFirstPoiInfo;
        }

        public String getAdCode() {
            return this.adCode;
        }

        public String getBelongCity() {
            return this.belongCity;
        }

        public String getBelongCityCode() {
            return this.belongCityCode;
        }

        public String getBelongCountry() {
            return this.belongCountry;
        }

        public String getBelongProvince() {
            return this.belongProvince;
        }

        public String getBelongProvinceCode() {
            return this.belongProvinceCode;
        }

        public String getCityName() {
            return this.cityName;
        }

        public String getCnPinyin() {
            return this.cnPinyin;
        }

        public String getCode() {
            return this.code;
        }

        public String getDistrictCode() {
            return this.districtCode;
        }

        public String getDistrictType() {
            return this.districtType;
        }

        public String getEn() {
            return this.f450815en;
        }

        public LocationAddressInfo getLocationAddressInfo() {
            return this.locationAddressInfo;
        }

        public String getName() {
            return this.name;
        }

        public CityBean(Parcel r100) {
            this.isL3 = false;
            this.l2Name = "";
            this.requestTriggerType = null;
            this.name = r100.readString();
            this.code = r100.readString();
            this.f450815en = r100.readString();
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(CityBean r100) {
            boolean r101 = this.isL3;
            if (r101 == false) goto L8;
            if (r100.isL3 == true) goto L8;
            return 1;
        L8:
            if (r101 == true) goto L13;
            if (r100.isL3 == false) goto L13;
            return -1;
        L13:
            if (TextUtils.isEmpty(this.cnPinyin) == false) goto L16;
            return -1;
        L16:
            if (TextUtils.isEmpty(r100.getCnPinyin()) == false) goto L19;
            return 1;
        L19:
            return this.cnPinyin.compareTo(r100.getCnPinyin());
        }

        public void setBelongCity(String r100) {
            this.belongCity = r100;
        }

        public void setBelongCityCode(String r100) {
            this.belongCityCode = r100;
        }

        public void setBelongCountry(String r100) {
            this.belongCountry = r100;
        }

        public void setBelongProvince(String r100) {
            this.belongProvince = r100;
        }

        public void setBelongProvinceCode(String r100) {
            this.belongProvinceCode = r100;
        }

        public void setCityName(String r100) {
            this.cityName = r100;
        }

        public void setCnPinyin(String r100) {
            this.cnPinyin = r100;
        }

        public void setCode(String r100) {
            this.code = r100;
        }

        public void setEn(String r100) {
            this.f450815en = r100;
        }

        public void setLocationAddressInfo(LocationAddressInfo r100) {
            this.locationAddressInfo = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(CityBean r100) {
            return compareTo2(r100);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.name);
            r100.writeString(this.code);
            r100.writeString(this.f450815en);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public NearbyCities() {
    }

    public List<CityBean> getAll() {
        return this.all;
    }

    public CityBean getCurrent() {
        return this.current;
    }

    public List<CityBean> getHistory() {
        return this.history;
    }

    public List<CityBean> getHot() {
        return this.hot;
    }

    public com.bytedance.locallife.model.groupon.LogPbBean getLogPb() {
        return this.logPb;
    }

    public List<CityBean> getOld() {
        return this.old;
    }

    public List<CityBean> getQuickAccessList() {
        return this.quickAccessList;
    }

    public String getSearchPageUrl() {
        return this.searchPageUrl;
    }

    public NearbyCities(Parcel r100) {
        this.current = (CityBean) r100.readParcelable(CityBean.class.getClassLoader());
        Parcelable.Creator<CityBean> r101 = CityBean.CREATOR;
        this.all = r100.createTypedArrayList(r101);
        this.hot = r100.createTypedArrayList(r101);
        this.old = r100.createTypedArrayList(r101);
    }

    public void setAll(List<CityBean> r100) {
        this.all = r100;
    }

    public void setCurrent(CityBean r100) {
        this.current = r100;
    }

    public void setHot(List<CityBean> r100) {
        this.hot = r100;
    }

    public void setLogPb(com.bytedance.locallife.model.groupon.LogPbBean r100) {
        this.logPb = r100;
    }

    public void setOld(List<CityBean> r100) {
        this.old = r100;
    }

    public void setQuickAccessList(List<CityBean> r100) {
        this.quickAccessList = r100;
    }

    public void setSearchPageUrl(String r100) {
        this.searchPageUrl = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.current, r101);
        r100.writeTypedList(this.all);
        r100.writeTypedList(this.hot);
        r100.writeTypedList(this.old);
    }
}
