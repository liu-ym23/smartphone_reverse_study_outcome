package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0016\u0010\u001c\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0016\u0010 \u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ScoreTags;", "Ljava/io/Serializable;", "()V", "color", "", "getColor", "()Ljava/lang/String;", "darkUrl", "getDarkUrl", "extra", "", "", "getExtra", "()Ljava/util/Map;", "extraText", "getExtraText", "extraUrlList", "", "getExtraUrlList", "()Ljava/util/List;", "height", "", "getHeight", "()I", "icon", "getIcon", "text", "getText", "type", "getType", "urlList", "getUrlList", "width", "getWidth", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScoreTags implements Serializable {
    public static final String BACKGROUND_ICON_URL = "background_icon_url";
    public static final String BACKGROUND_ICON_URL_DARK = "background_icon_url_dark";
    public static final Companion Companion = null;
    public static final String SCORE_ICON_URL = "score_icon_url";
    public static final String SCORE_ICON_URL_DARK = "score_icon_url_dark";
    public static final String SCORE_TYPE_DOUZUAN = "douzuan";
    public static final String SCORE_TYPE_STAR = "star";
    public static final String STARS_IMAGE = "stars_image";
    public static final String STAR_EMPTY_URL = "full_no_color_star_url";
    public static final String STAR_FULL_URL = "full_color_star_url";
    public static final String STAR_HALF_URL = "half_color_star_url";
    public static final String STAR_HEIGHT = "height";
    public static final String STAR_NEW_STYLE = "star_new_style";
    public static final int STAR_NEW_STYLE_YES = 1;
    public static final String STAR_URL_LIST = "url_list";
    public static final String STAR_WIDTH = "width";
    public static final int TYPE_ICON = 1;
    public static final int TYPE_REPUTATION_SCORE = 5;
    public static final int TYPE_SCORE = 2;
    public static final int TYPE_STAR = 4;
    public static final int TYPE_STAR_SCORE = 6;
    public static final int TYPE_TEXT = 3;

    @SerializedName("color")
    private final String color;

    @SerializedName("dark_url")
    private final String darkUrl;

    @SerializedName("extra")
    private final Map<String, Object> extra;

    @SerializedName("extra_text")
    private final String extraText;

    @SerializedName("extra_url_list")
    private final List<String> extraUrlList;

    @SerializedName("height")
    private final int height;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final int type;

    @SerializedName(STAR_URL_LIST)
    private final List<String> urlList;

    @SerializedName("width")
    private final int width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ScoreTags$Companion;", "", "()V", "BACKGROUND_ICON_URL", "", "BACKGROUND_ICON_URL_DARK", "SCORE_ICON_URL", "SCORE_ICON_URL_DARK", "SCORE_TYPE_DOUZUAN", "SCORE_TYPE_STAR", "STARS_IMAGE", "STAR_EMPTY_URL", "STAR_FULL_URL", "STAR_HALF_URL", "STAR_HEIGHT", "STAR_NEW_STYLE", "STAR_NEW_STYLE_YES", "", "STAR_URL_LIST", "STAR_WIDTH", "TYPE_ICON", "TYPE_REPUTATION_SCORE", "TYPE_SCORE", "TYPE_STAR", "TYPE_STAR_SCORE", "TYPE_TEXT", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public ScoreTags() {
    }

    public final String getColor() {
        return this.color;
    }

    public final String getDarkUrl() {
        return this.darkUrl;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getExtraText() {
        return this.extraText;
    }

    public final List<String> getExtraUrlList() {
        return this.extraUrlList;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final int getWidth() {
        return this.width;
    }
}
