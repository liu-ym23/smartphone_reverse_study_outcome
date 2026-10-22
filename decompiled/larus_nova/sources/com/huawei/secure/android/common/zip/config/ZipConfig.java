package com.huawei.secure.android.common.zip.config;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.dora.impl.ota.g2.j0;

/* JADX INFO: loaded from: classes23.dex */
public class ZipConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f278263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f278264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f278265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f278266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f278267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f278268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f278269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f278270h;

    public String[] getBlackListSuffix() {
        return this.f278268f;
    }

    public int getFileNumThreshold() {
        return this.f278264b;
    }

    public String getTargetDir() {
        return this.f278266d;
    }

    public long getTopSizeThreshold() {
        return this.f278263a;
    }

    public String[] getWhiteListSuffix() {
        return this.f278267e;
    }

    public String getZipFile() {
        return this.f278265c;
    }

    public boolean isGbkZipFile() {
        return this.f278270h;
    }

    public boolean isLoadDisk() {
        return this.f278269g;
    }

    public void setBlackListSuffix(String[] r100) {
        this.f278268f = r100;
    }

    public void setFileNumThreshold(int r100) {
        this.f278264b = r100;
    }

    public void setGbkZipFile(boolean r100) {
        this.f278270h = r100;
    }

    public void setLoadDisk(boolean r100) {
        this.f278269g = r100;
    }

    public void setTargetDir(String r100) {
        this.f278266d = r100;
    }

    public void setTopSizeThreshold(long r100) {
        this.f278263a = r100;
    }

    public void setWhiteListSuffix(String[] r100) {
        this.f278267e = r100;
    }

    public void setZipFile(String r100) {
        this.f278265c = r100;
    }

    public ZipConfig(String r110, String r210) {
        this.f278263a = j0.G2_OTA_SPACE_CHECK_BYTES;
        this.f278264b = 6000;
        this.f278268f = new String[]{"jsp", "php", "php2", "php3", "php4", "php5", "phps", "pht", "phtm", "phtml", "py", "pl", "elf", "lua", "sh", GXTemplateKey.GAIAX_JS};
        this.f278269g = true;
        this.f278270h = false;
        this.f278265c = r110;
        this.f278266d = r210;
    }
}
