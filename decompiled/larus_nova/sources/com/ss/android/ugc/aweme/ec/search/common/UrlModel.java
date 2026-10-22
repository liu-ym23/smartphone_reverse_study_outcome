package com.ss.android.ugc.aweme.ec.search.common;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020(2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\b\u0010)\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR&\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011¨\u0006*"}, d2 = {"Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "Ljava/io/Serializable;", "()V", "fileCheckSum", "", "getFileCheckSum", "()Ljava/lang/String;", "setFileCheckSum", "(Ljava/lang/String;)V", "fileHash", "getFileHash", "setFileHash", "height", "", "getHeight", "()I", "setHeight", "(I)V", "size", "", "getSize", "()J", "setSize", "(J)V", "uri", "getUri", "setUri", "urlKey", "getUrlKey", "setUrlKey", "urlList", "", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "width", "getWidth", "setWidth", "setFileCheckSumValue", "", "toString", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class UrlModel implements Serializable {

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

    public String toString() {
        return "UrlModel {uri='" + this.uri + "', urlList=" + this.urlList + ", urlKey=" + this.urlKey + '}';
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

    public final void setFileCheckSum(String r100) {
        this.fileCheckSum = r100;
    }

    public final void setFileCheckSumValue(String r100) {
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
}
