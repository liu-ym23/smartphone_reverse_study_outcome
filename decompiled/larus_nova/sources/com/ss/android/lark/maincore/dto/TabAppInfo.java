package com.ss.android.lark.maincore.dto;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public class TabAppInfo {
    private String appType;
    private Extra extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @JSONField(name = "ID")
    private String f431578id;
    private String key;
    private Logo logo;
    private Name name;
    private boolean primaryOnly;
    private boolean unmovable;

    public static class Extra {

        @JSONField(name = "app_id")
        private String appID;

        @JSONField(name = "mobile_url")
        private String url;

        public Extra() {
        }

        public String getAppID() {
            return this.appID;
        }

        public String getUrl() {
            return this.url;
        }

        public void setAppID(String r100) {
            this.appID = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }

        public static boolean isEqual(Extra r100, Extra r101) {
            if (r100 != null) goto L7;
            if (r101 != null) goto L7;
            return true;
        L7:
            if (r100 == null) goto L16;
            if (r101 == null) goto L16;
            if (TextUtils.equals(r100.appID, r101.appID) == true) goto L12;
        L14:
            return false;
        L12:
            if (TextUtils.equals(r100.url, r101.url) == false) goto L14;
            return true;
        L16:
            return false;
        }
    }

    public static class Logo {

        @JSONField(name = "mobile_primary_default_png")
        private String mobilePrimaryDefaultPng;

        @JSONField(name = "mobile_primary_selected_png")
        private String mobilePrimarySelectedPng;

        @JSONField(name = "primary_color_png")
        private String primaryColorPng;

        @JSONField(name = "primary_default")
        private String primaryDefault;

        @JSONField(name = "primary_selected")
        private String primarySelected;

        @JSONField(name = "secretary_bgcolor")
        private String secretaryBgColor;

        @JSONField(name = "secretary_default")
        private String secretaryDefault;

        public Logo() {
        }

        public String getMobilePrimaryDefaultPng() {
            return this.mobilePrimaryDefaultPng;
        }

        public String getMobilePrimarySelectedPng() {
            return this.mobilePrimarySelectedPng;
        }

        public String getPrimaryColorPng() {
            return this.primaryColorPng;
        }

        public String getPrimaryDefault() {
            return this.primaryDefault;
        }

        public String getPrimarySelected() {
            return this.primarySelected;
        }

        public String getSecretaryBgColor() {
            return this.secretaryBgColor;
        }

        public String getSecretaryDefault() {
            return this.secretaryDefault;
        }

        public void setMobilePrimaryDefaultPng(String r100) {
            this.mobilePrimaryDefaultPng = r100;
        }

        public void setMobilePrimarySelectedPng(String r100) {
            this.mobilePrimarySelectedPng = r100;
        }

        public void setPrimaryColorPng(String r100) {
            this.primaryColorPng = r100;
        }

        public void setPrimaryDefault(String r100) {
            this.primaryDefault = r100;
        }

        public void setPrimarySelected(String r100) {
            this.primarySelected = r100;
        }

        public void setSecretaryBgColor(String r100) {
            this.secretaryBgColor = r100;
        }

        public void setSecretaryDefault(String r100) {
            this.secretaryDefault = r100;
        }

        public static boolean isEqual(Logo r100, Logo r101) {
            if (r100 != null) goto L7;
            if (r101 != null) goto L7;
            return true;
        L7:
            if (r100 == null) goto L24;
            if (r101 == null) goto L24;
            if (TextUtils.equals(r100.secretaryDefault, r101.secretaryDefault) == true) goto L12;
        L22:
            return false;
        L12:
            if (TextUtils.equals(r100.primaryDefault, r101.primaryDefault) == false) goto L22;
            if (TextUtils.equals(r100.primarySelected, r101.primarySelected) == false) goto L22;
            if (TextUtils.equals(r100.primaryColorPng, r101.primaryColorPng) == false) goto L22;
            if (TextUtils.equals(r100.mobilePrimaryDefaultPng, r101.mobilePrimaryDefaultPng) == false) goto L22;
            if (TextUtils.equals(r100.mobilePrimarySelectedPng, r101.mobilePrimarySelectedPng) == false) goto L22;
            return true;
        L24:
            return false;
        }
    }

    public static class Name {

        /* JADX INFO: renamed from: cn, reason: collision with root package name */
        @JSONField(name = "zh_cn")
        private String f431579cn;

        /* JADX INFO: renamed from: jp, reason: collision with root package name */
        @JSONField(name = "ja_jp")
        private String f431580jp;

        /* JADX INFO: renamed from: us, reason: collision with root package name */
        @JSONField(name = "en_us")
        private String f431581us;

        public Name() {
        }

        public String getCn() {
            return this.f431579cn;
        }

        public String getJp() {
            return this.f431580jp;
        }

        public String getUs() {
            return this.f431581us;
        }

        public void setCn(String r100) {
            this.f431579cn = r100;
        }

        public void setJp(String r100) {
            this.f431580jp = r100;
        }

        public void setUs(String r100) {
            this.f431581us = r100;
        }

        public static boolean isEqual(Name r100, Name r101) {
            if (r100 != null) goto L7;
            if (r101 != null) goto L7;
            return true;
        L7:
            if (r100 == null) goto L18;
            if (r101 == null) goto L18;
            if (TextUtils.equals(r100.f431581us, r101.f431581us) == true) goto L12;
        L16:
            return false;
        L12:
            if (TextUtils.equals(r100.f431580jp, r101.f431580jp) == false) goto L16;
            if (TextUtils.equals(r100.f431579cn, r101.f431579cn) == false) goto L16;
            return true;
        L18:
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.appType});
    }

    public TabAppInfo() {
    }

    public String getAppType() {
        return this.appType;
    }

    public Extra getExtra() {
        return this.extra;
    }

    public String getId() {
        return this.f431578id;
    }

    public String getKey() {
        return this.key;
    }

    public Logo getLogo() {
        return this.logo;
    }

    public Name getName() {
        return this.name;
    }

    public boolean isPrimaryOnly() {
        return this.primaryOnly;
    }

    public boolean isUnmovable() {
        return this.unmovable;
    }

    public TabAppInfo(String r100) {
        this.key = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        TabAppInfo r101 = (TabAppInfo) r100;
        if (Objects.equals(this.key, r101.key) == true) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.appType, r101.appType) == false) goto L15;
        return true;
    }

    public void setAppType(String r100) {
        this.appType = r100;
    }

    public void setExtra(Extra r100) {
        this.extra = r100;
    }

    public void setId(String r100) {
        this.f431578id = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setLogo(Logo r100) {
        this.logo = r100;
    }

    public void setName(Name r100) {
        this.name = r100;
    }

    public void setPrimaryOnly(boolean r100) {
        this.primaryOnly = r100;
    }

    public void setUnmovable(boolean r100) {
        this.unmovable = r100;
    }

    public static boolean needUpdate(TabAppInfo r100, TabAppInfo r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r100 != null) goto L9;
        return true;
    L9:
        if (Logo.isEqual(r100.logo, r101.logo) == true) goto L11;
    L14:
        return true;
    L11:
        if (Name.isEqual(r100.name, r101.name) == true) goto L14;
        if (Extra.isEqual(r100.extra, r101.extra) == true) goto L14;
        return false;
    }
}
