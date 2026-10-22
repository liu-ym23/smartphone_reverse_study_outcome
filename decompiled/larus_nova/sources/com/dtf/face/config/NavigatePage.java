package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class NavigatePage {
    public static final String DEFAULT_URL = "https://render.alipay.com/p/f/fd-j8l9yjja/index.html";

    @JSONField(name = "enable")
    private boolean enable;

    @JSONField(name = "needRareCharUi")
    private boolean needRareCharUi;

    @JSONField(name = "url")
    private String url;

    public NavigatePage() {
        this.enable = false;
        this.url = DEFAULT_URL;
        this.needRareCharUi = false;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isNeedRareCharUi() {
        return this.needRareCharUi;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setNeedRareCharUi(boolean r100) {
        this.needRareCharUi = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
