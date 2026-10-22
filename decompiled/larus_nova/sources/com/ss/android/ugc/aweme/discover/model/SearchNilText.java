package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.ies.modulize.rule.AllowImpl;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class SearchNilText implements Serializable {
    private String content;
    private String link;
    private String url;

    public SearchNilText() {
    }

    @AllowImpl
    public String getContent() {
        return this.content;
    }

    @AllowImpl
    public String getLink() {
        return this.link;
    }

    @AllowImpl
    public String getUrl() {
        return this.url;
    }

    @AllowImpl
    public void setContent(String r100) {
        this.content = r100;
    }

    @AllowImpl
    public void setLink(String r100) {
        this.link = r100;
    }

    @AllowImpl
    public void setUrl(String r100) {
        this.url = r100;
    }

    public SearchNilText(String r100, String r101, String r102) {
        this.content = r100;
        this.link = r101;
        this.url = r102;
    }
}
