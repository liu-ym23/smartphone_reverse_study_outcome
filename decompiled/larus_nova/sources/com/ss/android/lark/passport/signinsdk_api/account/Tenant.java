package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes37.dex */
public class Tenant implements Serializable, Parcelable {
    public static final Parcelable.Creator<Tenant> CREATOR = null;
    public static final int FROM_SOURCE_DOUBAO = 12;

    @JSONField(name = "from_source")
    public int fromSource;

    @JSONField(name = "i18n_names")
    public I18Name i18Name;

    @JSONField(name = "icon_url")
    public String iconUrl;

    @JSONField(name = "is_certificated")
    public boolean isCertificated;
    public String name;

    @JSONField(name = "tenant_full_domain")
    public String suiteFullDomain;

    @JSONField(name = "tenant_tag")
    public int tag;

    @JSONField(name = "tenant_biz_type")
    public int tenantBizType;

    @JSONField(name = "tenant_brand")
    private String tenantBrand;

    @JSONField(name = "tenant_domain")
    public String tenantDomain;

    @JSONField(name = MapBundleKey.MapObjKey.OBJ_GEO)
    private String tenantGeo;

    @JSONField(alternateNames = {"id"}, name = "tenant_id")
    public String tenantId;

    public class a implements Parcelable.Creator<Tenant> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Tenant createFromParcel(Parcel r100) {
            return new Tenant(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final Tenant[] newArray(int r100) {
            return new Tenant[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public Tenant() {
        this.tag = 0;
    }

    public String getTenantBrand() {
        return this.tenantBrand;
    }

    public String getTenantGeo() {
        return this.tenantGeo;
    }

    public Tenant(Parcel r100) {
        boolean r101 = false;
        this.tag = 0;
        this.tenantId = r100.readString();
        this.name = r100.readString();
        this.iconUrl = r100.readString();
        this.tag = r100.readInt();
        this.tenantDomain = r100.readString();
        this.suiteFullDomain = r100.readString();
        this.tenantBrand = r100.readString();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.isCertificated = r101;
        this.tenantGeo = r100.readString();
    }

    public String localizedName(Locale r100) {
        if (r100 == null) goto L4;
        String r101 = this.name;
        if (this.i18Name != null) goto L8;
        return r101;
    L8:
        if (r100.getLanguage().equals(Locale.CHINESE.getLanguage()) == false) goto L13;
        if (TextUtils.isEmpty(this.i18Name.zhCn) == false) goto L23;
        return r101;
    L23:
        return this.i18Name.zhCn;
    L13:
        if (r100.getLanguage().equals(Locale.JAPANESE.getLanguage()) == false) goto L18;
        if (TextUtils.isEmpty(this.i18Name.jaJp) == true) goto L18;
        return this.i18Name.jaJp;
    L18:
        if (TextUtils.isEmpty(this.i18Name.enUs) == false) goto L20;
        return r101;
    L20:
        return this.i18Name.enUs;
    L4:
        return this.name;
    }

    public void setTenantBrand(String r100) {
        this.tenantBrand = r100;
    }

    public void setTenantGeo(String r100) {
        this.tenantGeo = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.tenantId);
        r100.writeString(this.name);
        r100.writeString(this.iconUrl);
        r100.writeInt(this.tag);
        r100.writeString(this.tenantDomain);
        r100.writeString(this.suiteFullDomain);
        r100.writeString(this.tenantBrand);
        r100.writeByte(this.isCertificated ? 1 : 0);
        r100.writeString(this.tenantGeo);
    }
}
