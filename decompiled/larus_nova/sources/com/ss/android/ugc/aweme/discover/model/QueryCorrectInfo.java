package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class QueryCorrectInfo implements Serializable {
    public static final int CORRECT_LEVEL_STRONG = 2;
    public static final int CORRECT_LEVEL_WEAK = 1;
    static final long serialVersionUID = 1;

    @SerializedName("background_color")
    String backgroundColor;

    @SerializedName("corrected_query")
    String correctedKeyword;

    @SerializedName("correct_level")
    int correctedLevel;

    @SerializedName("dark_text_color")
    String darkTextColor;

    @SerializedName("margin_bottom")
    public int marginBottom;

    @SerializedName("margin_top")
    public int marginTop;

    @SerializedName("origin_query")
    String originQuery;
    private String requestId;
    private String searchId;

    @SerializedName("should_show_divider_line")
    boolean shouldShowDividerLine;

    @SerializedName("text_color")
    String textColor;

    @SerializedName("text_size")
    public int textSize;
    public boolean useOriginQuery;

    public QueryCorrectInfo copy() {
        QueryCorrectInfo r100 = new QueryCorrectInfo();
        r100.requestId = this.requestId;
        r100.searchId = this.searchId;
        r100.correctedKeyword = this.correctedKeyword;
        r100.correctedLevel = this.correctedLevel;
        r100.originQuery = this.originQuery;
        return r100;
    }

    public QueryCorrectInfo() {
        this.shouldShowDividerLine = true;
        this.textSize = 14;
        this.marginTop = 16;
        this.marginBottom = 16;
        this.useOriginQuery = false;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    @AllowImpl
    public String getCorrectedKeyword() {
        return this.correctedKeyword;
    }

    @AllowImpl
    public int getCorrectedLevel() {
        return this.correctedLevel;
    }

    public String getDarkTextColor() {
        return this.darkTextColor;
    }

    public String getOriginQuery() {
        return this.originQuery;
    }

    @AllowImpl
    public String getRequestId() {
        return this.requestId;
    }

    @AllowImpl
    public String getSearchId() {
        return this.searchId;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public boolean isShouldShowDividerLine() {
        return this.shouldShowDividerLine;
    }

    public void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    @AllowImpl
    public void setCorrectedKeyword(String r100) {
        this.correctedKeyword = r100;
    }

    @AllowImpl
    public void setCorrectedLevel(int r100) {
        this.correctedLevel = r100;
    }

    public void setDarkTextColor(String r100) {
        this.darkTextColor = r100;
    }

    public void setOriginQuery(String r100) {
        this.originQuery = r100;
    }

    @AllowImpl
    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    @AllowImpl
    public void setSearchId(String r100) {
        this.searchId = r100;
    }

    public void setShouldShowDividerLine(boolean r100) {
        this.shouldShowDividerLine = r100;
    }

    public void setTextColor(String r100) {
        this.textColor = r100;
    }
}
