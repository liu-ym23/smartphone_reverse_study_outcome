package com.ss.android.ugc.aweme.discover.model.commodity.aladdin;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/Display;", "Ljava/io/Serializable;", "()V", "arrowText", "", "getArrowText", "()Ljava/lang/String;", "setArrowText", "(Ljava/lang/String;)V", "bannerImage", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getBannerImage", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setBannerImage", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "capsuleStyle", "Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/CapsuleStyle;", "getCapsuleStyle", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/CapsuleStyle;", "setCapsuleStyle", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/CapsuleStyle;)V", "linkDesc", "getLinkDesc", "setLinkDesc", "linkIcon", "getLinkIcon", "setLinkIcon", "linkSchema", "getLinkSchema", "setLinkSchema", "linkSubDesc", "getLinkSubDesc", "setLinkSubDesc", "schemaType", "", "getSchemaType", "()I", "setSchemaType", "(I)V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Display implements Serializable {
    public static final Companion Companion = null;
    public static final int SCHEMA_TYPE_H5 = 2;
    public static final int SCHEMA_TYPE_MINI_APP = 1;
    public static final int SCHEMA_TYPE_NATIVE = 0;

    @SerializedName("arrow_text")
    private String arrowText;

    @SerializedName("banner")
    private UrlModel bannerImage;

    @SerializedName("button_style")
    private CapsuleStyle capsuleStyle;

    @SerializedName("link_desc")
    private String linkDesc;

    @SerializedName("link_icon")
    private UrlModel linkIcon;

    @SerializedName("link_schema")
    private String linkSchema;

    @SerializedName("link_sub_desc")
    private String linkSubDesc;

    @SerializedName("schema_type")
    private int schemaType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/Display$Companion;", "", "()V", "SCHEMA_TYPE_H5", "", "SCHEMA_TYPE_MINI_APP", "SCHEMA_TYPE_NATIVE", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public Display() {
    }

    public final String getArrowText() {
        return this.arrowText;
    }

    public final UrlModel getBannerImage() {
        return this.bannerImage;
    }

    public final CapsuleStyle getCapsuleStyle() {
        return this.capsuleStyle;
    }

    public final String getLinkDesc() {
        return this.linkDesc;
    }

    public final UrlModel getLinkIcon() {
        return this.linkIcon;
    }

    public final String getLinkSchema() {
        return this.linkSchema;
    }

    public final String getLinkSubDesc() {
        return this.linkSubDesc;
    }

    public final int getSchemaType() {
        return this.schemaType;
    }

    public final void setArrowText(String r100) {
        this.arrowText = r100;
    }

    public final void setBannerImage(UrlModel r100) {
        this.bannerImage = r100;
    }

    public final void setCapsuleStyle(CapsuleStyle r100) {
        this.capsuleStyle = r100;
    }

    public final void setLinkDesc(String r100) {
        this.linkDesc = r100;
    }

    public final void setLinkIcon(UrlModel r100) {
        this.linkIcon = r100;
    }

    public final void setLinkSchema(String r100) {
        this.linkSchema = r100;
    }

    public final void setLinkSubDesc(String r100) {
        this.linkSubDesc = r100;
    }

    public final void setSchemaType(int r100) {
        this.schemaType = r100;
    }
}
