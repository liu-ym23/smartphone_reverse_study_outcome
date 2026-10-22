package com.huawei.secure.android.common.encrypt.rootkey;

/* JADX INFO: loaded from: classes23.dex */
public class RootKeyConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f278019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f278020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f278021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f278022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f278023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f278024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f278025g;

    public int getExportLen() {
        return this.f278024f;
    }

    public String getFirst() {
        return this.f278019a;
    }

    public int getIteration() {
        return this.f278023e;
    }

    public byte[] getSalt() {
        return this.f278022d;
    }

    public String getSecond() {
        return this.f278020b;
    }

    public String getThird() {
        return this.f278021c;
    }

    public boolean isSha256() {
        return this.f278025g;
    }

    public void setExportLen(int r100) {
        this.f278024f = r100;
    }

    public void setFirst(String r100) {
        this.f278019a = r100;
    }

    public void setIteration(int r100) {
        this.f278023e = r100;
    }

    public void setSalt(byte[] r100) {
        this.f278022d = r100;
    }

    public void setSecond(String r100) {
        this.f278020b = r100;
    }

    public void setSha256(boolean r100) {
        this.f278025g = r100;
    }

    public void setThird(String r100) {
        this.f278021c = r100;
    }

    public RootKeyConfig(String r100, String r101, String r102, byte[] r103, int r104, int r105, boolean r106) {
        this.f278019a = r100;
        this.f278020b = r101;
        this.f278021c = r102;
        this.f278022d = r103;
        this.f278023e = r104;
        this.f278024f = r105;
        this.f278025g = r106;
    }
}
