package com.bytedance.locallife.dito.common.data;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class UrlModel implements Serializable {

    @SerializedName("player_access_key")
    protected String aK;

    @SerializedName("bgimg_url")
    public String bgimgUrl;

    @SerializedName("download_url_list")
    protected List<String> downUrlList;

    @SerializedName("file_cs")
    protected String fileCheckSum;

    @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
    String fileHash;

    @SerializedName("height")
    int height;

    @SerializedName("data_size")
    long size;

    @SerializedName("uri")
    protected String uri;

    @SerializedName("url_key")
    String urlKey;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> urlList;

    @SerializedName("width")
    int width;

    public UrlModel copy() {
        UrlModel r100 = new UrlModel();
        r100.uri = this.uri;
        r100.width = this.width;
        r100.height = this.height;
        r100.urlKey = this.urlKey;
        r100.size = this.size;
        r100.fileHash = this.fileHash;
        r100.aK = this.aK;
        r100.fileCheckSum = this.fileCheckSum;
        if (this.urlList == null) goto L6;
        r100.urlList = new ArrayList(this.urlList);
    L6:
        if (this.downUrlList == null) goto L8;
        r100.downUrlList = new ArrayList(this.downUrlList);
    L8:
        return r100;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.urlKey) == false) goto L5;
        String r100 = this.uri;
    L6:
        int r101 = 0;
        if (r100 == null) goto L9;
        int r102 = r100.hashCode();
    L10:
        int r103 = r102 * 31;
        List<String> r104 = this.urlList;
        if (r104 == null) goto L14;
        r101 = r104.hashCode();
    L14:
        return r103 + r101;
    L9:
        r102 = 0;
        goto L10
    L5:
        r100 = this.urlKey;
        goto L6
    }

    public UrlModel() {
    }

    public List<String> getDownUrlList() {
        return this.downUrlList;
    }

    public String getFileCheckSum() {
        return this.fileCheckSum;
    }

    public String getFileHash() {
        return this.fileHash;
    }

    public int getHeight() {
        return this.height;
    }

    public long getSize() {
        return this.size;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUrlKey() {
        return this.urlKey;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public int getWidth() {
        return this.width;
    }

    public String getaK() {
        return this.aK;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlModel) == true) goto L8;
        return false;
    L8:
        UrlModel r101 = (UrlModel) r100;
        String r102 = this.uri;
        if (r102 == null) goto L14;
        if (r102.equals(r101.uri) == false) goto L15;
    L16:
        String r103 = this.urlKey;
        if (r103 == null) goto L22;
        if (r103.equals(r101.urlKey) == false) goto L23;
    L24:
        List<String> r104 = this.urlList;
        List<String> r105 = r101.urlList;
        if (r104 != null) goto L31;
        if (r105 == null) goto L32;
        return false;
    L32:
        return true;
    L31:
        return r104.equals(r105);
    L23:
        return false;
    L22:
        if (r101.urlKey == null) goto L24;
    L15:
        return false;
    L14:
        if (r101.uri == null) goto L16;
        goto L15
    }

    public void setFileCheckSum(String r100) {
        this.fileCheckSum = r100;
    }

    public void setFileHash(String r100) {
        this.fileHash = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }

    public void setUrlKey(String r100) {
        this.urlKey = r100;
    }

    public void setUrlList(List<String> r100) {
        this.urlList = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public void setaK(String r100) {
        this.aK = r100;
    }
}
