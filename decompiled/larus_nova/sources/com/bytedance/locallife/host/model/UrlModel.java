package com.bytedance.locallife.host.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0002J\b\u00104\u001a\u0004\u0018\u00010\u0004J\b\u00105\u001a\u00020\u0019H\u0016J\u0010\u00106\u001a\u0002072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR(\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r8\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR&\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001e\u0010-\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001d¨\u00068"}, d2 = {"Lcom/bytedance/locallife/host/model/UrlModel;", "Ljava/io/Serializable;", "()V", "aK", "", "getAK", "()Ljava/lang/String;", "setAK", "(Ljava/lang/String;)V", "bgimgUrl", "getBgimgUrl", "setBgimgUrl", "downUrlList", "", "getDownUrlList", "()Ljava/util/List;", "setDownUrlList", "(Ljava/util/List;)V", "fileCheckSum", "getFileCheckSum", "setFileCheckSum", "fileHash", "getFileHash", "setFileHash", "height", "", "getHeight", "()I", "setHeight", "(I)V", "size", "", "getSize", "()J", "setSize", "(J)V", "uri", "getUri", "setUri", "urlKey", "getUrlKey", "setUrlKey", "urlList", "getUrlList", "setUrlList", "width", "getWidth", "setWidth", "equals", "", "other", "", "getaK", "hashCode", "setaK", "", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class UrlModel implements Serializable {

    @SerializedName("player_access_key")
    private String aK;

    @SerializedName("bgimg_url")
    private String bgimgUrl;

    @SerializedName("download_url_list")
    private List<String> downUrlList;

    @SerializedName("file_cs")
    private String fileCheckSum;

    @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
    private String fileHash;

    @SerializedName("height")
    private int height;

    @SerializedName("data_size")
    private long size;

    @SerializedName("uri")
    private String uri;

    @SerializedName("url_key")
    private String urlKey;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> urlList;

    @SerializedName("width")
    private int width;

    public UrlModel() {
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
        if (r104 == null) goto L15;
        if (r104 == null) goto L15;
        r101 = r104.hashCode();
    L15:
        return r103 + r101;
    L9:
        r102 = 0;
        goto L10
    L5:
        r100 = this.urlKey;
        goto L6
    }

    public final String getAK() {
        return this.aK;
    }

    public final String getBgimgUrl() {
        return this.bgimgUrl;
    }

    public final List<String> getDownUrlList() {
        return this.downUrlList;
    }

    public final String getFileCheckSum() {
        return this.fileCheckSum;
    }

    public final String getFileHash() {
        return this.fileHash;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrlKey() {
        return this.urlKey;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final int getWidth() {
        return this.width;
    }

    public final String getaK() {
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
        if (Intrinsics.areEqual(r102, r101.uri) == false) goto L15;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == false) goto L19;
        return false;
    L19:
        String r104 = this.urlKey;
        if (r104 == null) goto L25;
        if (Intrinsics.areEqual(r104, r101.urlKey) == false) goto L26;
    L27:
        boolean r105 = false;
    L28:
        if (r105 == false) goto L30;
        return false;
    L30:
        List<String> r106 = this.urlList;
        List<String> r107 = r101.urlList;
        if (r106 != null) goto L37;
        if (r107 == null) goto L38;
        return false;
    L38:
        return true;
    L37:
        return Intrinsics.areEqual(r106, r107);
    L26:
        r105 = true;
        goto L28
    L25:
        if (r101.urlKey == null) goto L27;
    L15:
        r103 = true;
        goto L17
    L14:
        if (r101.uri == null) goto L16;
        goto L15
    }

    public final void setAK(String r100) {
        this.aK = r100;
    }

    public final void setBgimgUrl(String r100) {
        this.bgimgUrl = r100;
    }

    public final void setDownUrlList(List<String> r100) {
        this.downUrlList = r100;
    }

    public final void setFileCheckSum(String r100) {
        this.fileCheckSum = r100;
    }

    public final void setFileHash(String r100) {
        this.fileHash = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setSize(long r100) {
        this.size = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrlKey(String r100) {
        this.urlKey = r100;
    }

    public final void setUrlList(List<String> r100) {
        this.urlList = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public final void setaK(String r100) {
        this.aK = r100;
    }
}
