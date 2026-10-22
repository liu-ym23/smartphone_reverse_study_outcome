package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/PhotoSearchShowToastConfig;", "", "()V", "delayTime", "", "getDelayTime", "()Ljava/lang/Long;", "setDelayTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "showToastEntrance", "", "getShowToastEntrance", "()Ljava/lang/String;", "setShowToastEntrance", "(Ljava/lang/String;)V", "text", "getText", "setText", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchShowToastConfig {

    @SerializedName("delay_time")
    private Long delayTime;

    @SerializedName("show_toast_entrance")
    private String showToastEntrance;

    @SerializedName("text")
    private String text;

    public PhotoSearchShowToastConfig() {
    }

    public final Long getDelayTime() {
        return this.delayTime;
    }

    public final String getShowToastEntrance() {
        return this.showToastEntrance;
    }

    public final String getText() {
        return this.text;
    }

    public final void setDelayTime(Long r100) {
        this.delayTime = r100;
    }

    public final void setShowToastEntrance(String r100) {
        this.showToastEntrance = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
