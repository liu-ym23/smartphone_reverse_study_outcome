package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001e\u0010&\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/MarkdownInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "baseUrl", "getBaseUrl", "setBaseUrl", "contentMargin", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Margin;", "getContentMargin", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Margin;", "setContentMargin", "(Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Margin;)V", "textColor", "getTextColor", "setTextColor", "textSize", "", "getTextSize", "()Ljava/lang/Float;", "setTextSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "lineHeight", "getLineHeight", "setLineHeight", "listItemColor", "getListItemColor", "setListItemColor", "linkColor", "getLinkColor", "setLinkColor", "lineSpacing", "getLineSpacing", "setLineSpacing", "listMarginInfo", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/MarkdownListMarginInfo;", "getListMarginInfo", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/MarkdownListMarginInfo;", "setListMarginInfo", "(Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/MarkdownListMarginInfo;)V", "noBlockSpace", "", "getNoBlockSpace", "()Ljava/lang/Boolean;", "setNoBlockSpace", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownInfo implements NonProguard {
    private String baseUrl;
    private String content;
    private Margin contentMargin;
    private Float lineHeight;
    private Float lineSpacing;
    private String linkColor;
    private String listItemColor;
    private MarkdownListMarginInfo listMarginInfo;
    private Boolean noBlockSpace;
    private String textColor;
    private Float textSize;

    public MarkdownInfo() {
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getContent() {
        return this.content;
    }

    public final Margin getContentMargin() {
        return this.contentMargin;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final Float getLineSpacing() {
        return this.lineSpacing;
    }

    public final String getLinkColor() {
        return this.linkColor;
    }

    public final String getListItemColor() {
        return this.listItemColor;
    }

    public final MarkdownListMarginInfo getListMarginInfo() {
        return this.listMarginInfo;
    }

    public final Boolean getNoBlockSpace() {
        return this.noBlockSpace;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Float getTextSize() {
        return this.textSize;
    }

    public final void setBaseUrl(String r100) {
        this.baseUrl = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setContentMargin(Margin r100) {
        this.contentMargin = r100;
    }

    public final void setLineHeight(Float r100) {
        this.lineHeight = r100;
    }

    public final void setLineSpacing(Float r100) {
        this.lineSpacing = r100;
    }

    public final void setLinkColor(String r100) {
        this.linkColor = r100;
    }

    public final void setListItemColor(String r100) {
        this.listItemColor = r100;
    }

    public final void setListMarginInfo(MarkdownListMarginInfo r100) {
        this.listMarginInfo = r100;
    }

    public final void setNoBlockSpace(Boolean r100) {
        this.noBlockSpace = r100;
    }

    public final void setTextColor(String r100) {
        this.textColor = r100;
    }

    public final void setTextSize(Float r100) {
        this.textSize = r100;
    }
}
