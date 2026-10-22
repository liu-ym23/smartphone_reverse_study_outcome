package com.bytedance.ee.bear.tts;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@AppConfig(key = TtsConfig.CONFIG_NAME)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0003\u0013\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0006H\u0016R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "supportedLanguages", "", "", "getSupportedLanguages", "()Ljava/util/List;", "setSupportedLanguages", "(Ljava/util/List;)V", "covers", "Lcom/bytedance/ee/bear/tts/TtsConfig$TtsCoversConfig;", "getCovers$annotations", "getCovers", "()Lcom/bytedance/ee/bear/tts/TtsConfig$TtsCoversConfig;", "setCovers", "(Lcom/bytedance/ee/bear/tts/TtsConfig$TtsCoversConfig;)V", "toString", "Companion", "TtsCoversConfig", "TtsCoverInfo", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsConfig implements NonProguard {
    public static final String CONFIG_NAME = "ccm_listen_to_doc_config";
    public static final a Companion = null;

    @SerializedName("covers")
    @JSONField(name = "covers")
    private TtsCoversConfig covers;

    @SerializedName("supported_languages")
    @JSONField(name = "supported_languages")
    private List<String> supportedLanguages;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsConfig$TtsCoverInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "largeCoverUrl", "", "getLargeCoverUrl", "()Ljava/lang/String;", "setLargeCoverUrl", "(Ljava/lang/String;)V", "smallCoverUrl", "getSmallCoverUrl", "setSmallCoverUrl", "titleColorKey", "getTitleColorKey", "setTitleColorKey", "toString", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TtsCoverInfo implements NonProguard {

        @SerializedName("large_cover_url")
        @JSONField(name = "large_cover_url")
        private String largeCoverUrl;

        @SerializedName("small_cover_url")
        @JSONField(name = "small_cover_url")
        private String smallCoverUrl;

        @SerializedName("title_color_key")
        @JSONField(name = "title_color_key")
        private String titleColorKey;

        public TtsCoverInfo() {
        }

        public String toString() {
            return "TtsCoverInfo@" + hashCode() + "{largeCoverUrl: " + this.largeCoverUrl + ", smallCoverUrl: " + this.smallCoverUrl + ", titleColorKey: " + this.titleColorKey + '}';
        }

        public final String getLargeCoverUrl() {
            return this.largeCoverUrl;
        }

        public final String getSmallCoverUrl() {
            return this.smallCoverUrl;
        }

        public final String getTitleColorKey() {
            return this.titleColorKey;
        }

        public final void setLargeCoverUrl(String r1) {
            this.largeCoverUrl = r1;
        }

        public final void setSmallCoverUrl(String r1) {
            this.smallCoverUrl = r1;
        }

        public final void setTitleColorKey(String r1) {
            this.titleColorKey = r1;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0006H\u0016R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/tts/TtsConfig$TtsCoversConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "coverIdList", "", "", "getCoverIdList", "()Ljava/util/List;", "setCoverIdList", "(Ljava/util/List;)V", "coverInfoMap", "", "Lcom/bytedance/ee/bear/tts/TtsConfig$TtsCoverInfo;", "getCoverInfoMap", "()Ljava/util/Map;", "setCoverInfoMap", "(Ljava/util/Map;)V", "toString", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JSONType(typeName = "covers")
    public static final class TtsCoversConfig implements NonProguard {

        @SerializedName("cover_id")
        @JSONField(name = "cover_id")
        private List<String> coverIdList;

        @SerializedName("cover_info")
        @JSONField(name = "cover_info")
        private Map<String, TtsCoverInfo> coverInfoMap;

        public TtsCoversConfig() {
        }

        public String toString() {
            return "TtsCoversConfig@" + hashCode() + "{coverIdList: " + this.coverIdList + ", coverInfoMap: " + this.coverInfoMap + '}';
        }

        public final List<String> getCoverIdList() {
            return this.coverIdList;
        }

        public final Map<String, TtsCoverInfo> getCoverInfoMap() {
            return this.coverInfoMap;
        }

        public final void setCoverIdList(List<String> r1) {
            this.coverIdList = r1;
        }

        public final void setCoverInfoMap(Map<String, TtsCoverInfo> r1) {
            this.coverInfoMap = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TtsConfig() {
    }

    @Deprecated(message = "Settings 平台已经移除了该字段")
    public static /* synthetic */ void getCovers$annotations() {
    }

    public String toString() {
        return "TtsConfig{supportedLanguages: " + this.supportedLanguages + ", covers: " + this.covers + '}';
    }

    public final TtsCoversConfig getCovers() {
        return this.covers;
    }

    public final List<String> getSupportedLanguages() {
        return this.supportedLanguages;
    }

    public final void setCovers(TtsCoversConfig r1) {
        this.covers = r1;
    }

    public final void setSupportedLanguages(List<String> r1) {
        this.supportedLanguages = r1;
    }
}
