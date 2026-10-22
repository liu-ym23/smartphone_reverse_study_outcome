package com.ss.android.ugc.aweme.search.common.config;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/PhotoSearchImageRemakeConfig;", "", "()V", "enable", "", "getEnable", "()I", "setEnable", "(I)V", "enableEntrance", "", "", "getEnableEntrance", "()Ljava/util/List;", "setEnableEntrance", "(Ljava/util/List;)V", "patterns", "getPatterns", "setPatterns", ThumbGlideUrl.SOURCE_TEMPLATE, "getTemplate", "()Ljava/lang/String;", "setTemplate", "(Ljava/lang/String;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchImageRemakeConfig {

    @SerializedName("enable")
    private int enable;

    @SerializedName("enable_entrance")
    private List<String> enableEntrance;

    @SerializedName("patterns")
    private List<String> patterns;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    private String template;

    public PhotoSearchImageRemakeConfig() {
    }

    public final int getEnable() {
        return this.enable;
    }

    public final List<String> getEnableEntrance() {
        return this.enableEntrance;
    }

    public final List<String> getPatterns() {
        return this.patterns;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final void setEnable(int r100) {
        this.enable = r100;
    }

    public final void setEnableEntrance(List<String> r100) {
        this.enableEntrance = r100;
    }

    public final void setPatterns(List<String> r100) {
        this.patterns = r100;
    }

    public final void setTemplate(String r100) {
        this.template = r100;
    }
}
