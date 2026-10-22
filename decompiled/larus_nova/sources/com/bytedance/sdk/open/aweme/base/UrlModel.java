package com.bytedance.sdk.open.aweme.base;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class UrlModel implements Serializable {

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> urlList;

    public UrlModel() {
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        List<String> r101 = this.urlList;
        List<String> r102 = ((UrlModel) r100).urlList;
        if (r101 != null) goto L18;
        if (r102 == null) goto L19;
        return false;
    L19:
        return true;
    L18:
        return r101.equals(r102);
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public int hashCode() {
        List<String> r100 = this.urlList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public void setUrlList(List<String> r100) {
        this.urlList = r100;
    }
}
