package com.ss.android.download.api.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DeepLink {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f408260id;
    private JSONObject json;
    private boolean jumpToDetailPage;
    private String mCloudGameUrl;
    private String mOpenUrl;
    private String mWebTitle;
    private String mWebUrl;
    private String packageName;

    public DeepLink() {
        this.jumpToDetailPage = false;
    }

    public String getCloudGameUrl() {
        return this.mCloudGameUrl;
    }

    public long getId() {
        return this.f408260id;
    }

    public JSONObject getJson() {
        return this.json;
    }

    public String getOpenUrl() {
        return this.mOpenUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getWebTitle() {
        return this.mWebTitle;
    }

    public String getWebUrl() {
        return this.mWebUrl;
    }

    public boolean isJumpToDetailPage() {
        return this.jumpToDetailPage;
    }

    public void setCloudGameUrl(String r100) {
        this.mCloudGameUrl = r100;
    }

    public void setId(long r100) {
        this.f408260id = r100;
    }

    public void setJson(JSONObject r100) {
        this.json = r100;
    }

    public void setJumpToDetailPage(boolean r100) {
        this.jumpToDetailPage = r100;
    }

    public void setOpenUrl(String r100) {
        this.mOpenUrl = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setWebTitle(String r100) {
        this.mWebTitle = r100;
    }

    public void setWebUrl(String r100) {
        this.mWebUrl = r100;
    }

    public DeepLink(String r100, String r101, String r102) {
        this.jumpToDetailPage = false;
        this.mOpenUrl = r100;
        this.mWebUrl = r101;
        this.mWebTitle = r102;
    }
}
