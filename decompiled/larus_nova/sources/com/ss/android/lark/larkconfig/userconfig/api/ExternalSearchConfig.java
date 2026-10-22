package com.ss.android.lark.larkconfig.userconfig.api;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class ExternalSearchConfig implements Serializable {
    private String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f431133id;
    private String title;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.f431133id;
    }

    public String getTitle() {
        return this.title;
    }

    public ExternalSearchConfig(String r100, String r101, String r102) {
        this.f431133id = r100;
        this.title = r101;
        this.iconUrl = r102;
    }
}
