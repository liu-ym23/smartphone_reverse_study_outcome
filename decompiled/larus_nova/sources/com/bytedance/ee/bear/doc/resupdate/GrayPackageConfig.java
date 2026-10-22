package com.bytedance.ee.bear.doc.resupdate;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "grayscale_package_config")
class GrayPackageConfig implements NonProguard {
    private String branch;
    private String url;
    private String version;

    public String toString() {
        return "GrayPackageConfig{version='" + this.version + "'}";
    }

    public GrayPackageConfig() {
    }

    public String getBranch() {
        return this.branch;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBranch(String r100) {
        this.branch = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }

    public GrayPackageConfig(String r100, String r101, String r102) {
        this.version = r100;
        this.branch = r101;
        this.url = r102;
    }
}
