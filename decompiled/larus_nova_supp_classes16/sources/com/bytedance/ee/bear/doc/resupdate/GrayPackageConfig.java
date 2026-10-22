package com.bytedance.ee.bear.doc.resupdate;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setBranch(String r1) {
        this.branch = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }

    public GrayPackageConfig(String r1, String r2, String r3) {
        this.version = r1;
        this.branch = r2;
        this.url = r3;
    }
}
