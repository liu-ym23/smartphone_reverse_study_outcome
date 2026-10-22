package com.ss.android.lark.message.service.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class CardActionUrl implements Serializable {
    private static final long serialVersionUID = 2530852242548850205L;
    private String android_url;
    private String url;

    public CardActionUrl() {
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.android_url;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String getAndroid_url() {
        return this.android_url;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        CardActionUrl r101 = (CardActionUrl) r100;
        String r102 = this.url;
        if (r102 == null) goto L16;
        if (r102.equals(r101.url) == false) goto L17;
    L18:
        String r103 = this.android_url;
        String r104 = r101.android_url;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        return false;
    L16:
        if (r101.url == null) goto L18;
        goto L17
    }

    public void setAndroid_url(String r100) {
        this.android_url = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
