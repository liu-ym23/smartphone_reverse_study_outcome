package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/VideoPlayInfo;", "Ljava/io/Serializable;", "()V", "awemeType", "", "getAwemeType", "()Ljava/lang/Integer;", "setAwemeType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "backupUrl", "", "getBackupUrl", "()Ljava/lang/String;", "setBackupUrl", "(Ljava/lang/String;)V", "duration", "getDuration", "setDuration", "height", "getHeight", "setHeight", "mainUrl", "getMainUrl", "setMainUrl", "urlExpire", "getUrlExpire", "setUrlExpire", "vid", "getVid", "setVid", "width", "getWidth", "setWidth", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPlayInfo implements Serializable {

    @SerializedName("aweme_type")
    private Integer awemeType;

    @SerializedName(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL)
    private String backupUrl;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("height")
    private Integer height;

    @SerializedName("main_url")
    private String mainUrl;

    @SerializedName("url_expire")
    private Integer urlExpire;

    @SerializedName("vid")
    private String vid;

    @SerializedName("width")
    private Integer width;

    public VideoPlayInfo() {
        this.vid = "";
        this.mainUrl = "";
        this.backupUrl = "";
    }

    public final Integer getAwemeType() {
        return this.awemeType;
    }

    public final String getBackupUrl() {
        return this.backupUrl;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final Integer getUrlExpire() {
        return this.urlExpire;
    }

    public final String getVid() {
        return this.vid;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setAwemeType(Integer r100) {
        this.awemeType = r100;
    }

    public final void setBackupUrl(String r100) {
        this.backupUrl = r100;
    }

    public final void setDuration(Integer r100) {
        this.duration = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setMainUrl(String r100) {
        this.mainUrl = r100;
    }

    public final void setUrlExpire(Integer r100) {
        this.urlExpire = r100;
    }

    public final void setVid(String r100) {
        this.vid = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }
}
