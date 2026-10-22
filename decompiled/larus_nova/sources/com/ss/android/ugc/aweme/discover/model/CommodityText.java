package com.ss.android.ugc.aweme.discover.model;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R \u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014¨\u0006,"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommodityText;", "Ljava/io/Serializable;", "()V", "background", "Lcom/ss/android/ugc/aweme/discover/model/CommodityButtonInfo;", "getBackground", "()Lcom/ss/android/ugc/aweme/discover/model/CommodityButtonInfo;", "setBackground", "(Lcom/ss/android/ugc/aweme/discover/model/CommodityButtonInfo;)V", "leftContent", "getLeftContent", "setLeftContent", "rightContent", "getRightContent", "setRightContent", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "textType", "getTextType", "setTextType", "title", "getTitle", d.f25925o, "type", "getType", "setType", "uiStyleVersion", "", "getUiStyleVersion", "()Ljava/lang/Integer;", "setUiStyleVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "upTitle", "getUpTitle", "setUpTitle", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityText implements Serializable {
    public static final String BOLD = "bold";
    public static final Companion Companion = null;
    public static final String FEEDBACK_WITH_QUERY = "button_add_query_end";
    public static final String LESS_RESULT = "less_result";
    public static final String LOAD_MORE_BUTTON = "load_more_button";
    public static final String LONG_LINE = "long_line";
    public static final String NORMAL = "normal";
    public static final String NO_RESULT = "no_result";
    public static final String SECTION_TITLE = "section_title";
    public static final String SHORT_LINE = "short_line";
    public static final String TAB = "tab";
    public static final String TEXT_WITH_ICON = "text_with_icon";

    @SerializedName("background")
    private CommodityButtonInfo background;

    @SerializedName("left_content")
    private CommodityButtonInfo leftContent;

    @SerializedName("right_content")
    private CommodityButtonInfo rightContent;

    @SerializedName("schema")
    private String schema;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    @SerializedName(a.KEY_TEXT_TYPE)
    private String textType;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("ui_style_version")
    private Integer uiStyleVersion;

    @SerializedName("up_title")
    private String upTitle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommodityText$Companion;", "", "()V", "BOLD", "", "FEEDBACK_WITH_QUERY", "LESS_RESULT", "LOAD_MORE_BUTTON", "LONG_LINE", EffectConstants.NORMAL, "NO_RESULT", "SECTION_TITLE", "SHORT_LINE", "TAB", "TEXT_WITH_ICON", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public CommodityText() {
    }

    public final CommodityButtonInfo getBackground() {
        return this.background;
    }

    public final CommodityButtonInfo getLeftContent() {
        return this.leftContent;
    }

    public final CommodityButtonInfo getRightContent() {
        return this.rightContent;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTextType() {
        return this.textType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getUiStyleVersion() {
        return this.uiStyleVersion;
    }

    public final String getUpTitle() {
        return this.upTitle;
    }

    public final void setBackground(CommodityButtonInfo r100) {
        this.background = r100;
    }

    public final void setLeftContent(CommodityButtonInfo r100) {
        this.leftContent = r100;
    }

    public final void setRightContent(CommodityButtonInfo r100) {
        this.rightContent = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public final void setTextType(String r100) {
        this.textType = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setUiStyleVersion(Integer r100) {
        this.uiStyleVersion = r100;
    }

    public final void setUpTitle(String r100) {
        this.upTitle = r100;
    }
}
