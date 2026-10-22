package com.larus.bmhome.bot.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/bot/bean/ImageUploadResult;", "", "uploadUrl", "", "uploadUri", "referenceBgImgStyle", "referenceBgImgPrompt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUploadUrl", "()Ljava/lang/String;", "setUploadUrl", "(Ljava/lang/String;)V", "getUploadUri", "setUploadUri", "getReferenceBgImgStyle", "getReferenceBgImgPrompt", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadResult {

    @SerializedName("reference_bg_img_prompt")
    private final String referenceBgImgPrompt;

    @SerializedName("reference_bg_img_style")
    private final String referenceBgImgStyle;

    @SerializedName("upload_uri")
    private String uploadUri;

    @SerializedName("upload_url")
    private String uploadUrl;

    public ImageUploadResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ImageUploadResult copy$default(ImageUploadResult r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.uploadUrl;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.uploadUri;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.referenceBgImgStyle;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.referenceBgImgPrompt;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.uploadUrl;
    }

    public final String component2() {
        return this.uploadUri;
    }

    public final String component3() {
        return this.referenceBgImgStyle;
    }

    public final String component4() {
        return this.referenceBgImgPrompt;
    }

    public final ImageUploadResult copy(String r100, String r101, String r102, String r103) {
        return new ImageUploadResult(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageUploadResult) == true) goto L8;
        return false;
    L8:
        ImageUploadResult r101 = (ImageUploadResult) r100;
        if (Intrinsics.areEqual(this.uploadUrl, r101.uploadUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadUri, r101.uploadUri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.referenceBgImgStyle, r101.referenceBgImgStyle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.referenceBgImgPrompt, r101.referenceBgImgPrompt) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.uploadUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uploadUri;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.referenceBgImgStyle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.referenceBgImgPrompt;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageUploadResult(uploadUrl=" + this.uploadUrl + ", uploadUri=" + this.uploadUri + ", referenceBgImgStyle=" + this.referenceBgImgStyle + ", referenceBgImgPrompt=" + this.referenceBgImgPrompt + ')';
    }

    public final String getReferenceBgImgPrompt() {
        return this.referenceBgImgPrompt;
    }

    public final String getReferenceBgImgStyle() {
        return this.referenceBgImgStyle;
    }

    public final String getUploadUri() {
        return this.uploadUri;
    }

    public final String getUploadUrl() {
        return this.uploadUrl;
    }

    public final void setUploadUri(String r100) {
        this.uploadUri = r100;
    }

    public final void setUploadUrl(String r100) {
        this.uploadUrl = r100;
    }

    public ImageUploadResult(String r100, String r101, String r102, String r103) {
        this.uploadUrl = r100;
        this.uploadUri = r101;
        this.referenceBgImgStyle = r102;
        this.referenceBgImgPrompt = r103;
    }

    public /* synthetic */ ImageUploadResult(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
