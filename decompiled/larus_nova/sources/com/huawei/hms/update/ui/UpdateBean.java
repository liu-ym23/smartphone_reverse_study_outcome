package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public class UpdateBean implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f277835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f277836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f277838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList f277841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f277842h;

    private static <T> T a(T r100) {
        return r100;
    }

    public String getClientAppId() {
        return (String) a(this.f277839e);
    }

    public String getClientAppName() {
        return (String) a(this.f277840f);
    }

    public String getClientPackageName() {
        return (String) a(this.f277837c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f277838d))).intValue();
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f277841g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f277835a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f277842h))).booleanValue();
    }

    public UpdateBean() {
        this.f277842h = true;
    }

    public boolean getResolutionInstallHMS() {
        return this.f277836b;
    }

    public void setClientAppId(String r100) {
        this.f277839e = r100;
    }

    public void setClientAppName(String r100) {
        this.f277840f = r100;
    }

    public void setClientPackageName(String r100) {
        this.f277837c = r100;
    }

    public void setClientVersionCode(int r100) {
        this.f277838d = r100;
    }

    public void setHmsOrApkUpgrade(boolean r100) {
        this.f277835a = r100;
    }

    public void setNeedConfirm(boolean r100) {
        this.f277842h = r100;
    }

    public void setResolutionInstallHMS(boolean r100) {
        this.f277836b = r100;
    }

    public void setTypeList(ArrayList r100) {
        this.f277841g = r100;
    }
}
