package com.larus.bot.impl.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Ljava/io/Serializable;", "iconUri", "", "iconUrl", "previewUrl", "downloadUrl", EventConstant.Key.RETAIN_PROMPT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUri", "()Ljava/lang/String;", "setIconUri", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getPreviewUrl", "setPreviewUrl", "getDownloadUrl", "setDownloadUrl", "getPrompt", "setPrompt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAvatarIconData implements Serializable {

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("icon_uri")
    private String iconUri;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private String prompt;

    public BotAvatarIconData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BotAvatarIconData copy$default(BotAvatarIconData r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.iconUri;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.iconUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.previewUrl;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.downloadUrl;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.prompt;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.iconUri;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.previewUrl;
    }

    public final String component4() {
        return this.downloadUrl;
    }

    public final String component5() {
        return this.prompt;
    }

    public final BotAvatarIconData copy(String r100, String r101, String r110, String r111, String r112) {
        return new BotAvatarIconData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotAvatarIconData) == true) goto L8;
        return false;
    L8:
        BotAvatarIconData r101 = (BotAvatarIconData) r100;
        if (Intrinsics.areEqual(this.iconUri, r101.iconUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewUrl, r101.previewUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.downloadUrl, r101.downloadUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.iconUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.iconUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.previewUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.downloadUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.prompt;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "BotAvatarIconData(iconUri=" + this.iconUri + ", iconUrl=" + this.iconUrl + ", previewUrl=" + this.previewUrl + ", downloadUrl=" + this.downloadUrl + ", prompt=" + this.prompt + ')';
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final void setDownloadUrl(String r100) {
        this.downloadUrl = r100;
    }

    public final void setIconUri(String r100) {
        this.iconUri = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setPreviewUrl(String r100) {
        this.previewUrl = r100;
    }

    public final void setPrompt(String r100) {
        this.prompt = r100;
    }

    public BotAvatarIconData(String r100, String r101, String r102, String r103, String r104) {
        this.iconUri = r100;
        this.iconUrl = r101;
        this.previewUrl = r102;
        this.downloadUrl = r103;
        this.prompt = r104;
    }

    public /* synthetic */ BotAvatarIconData(String r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r108 = "";
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = null;
    L21:
        String r109 = r104;
        this(r111, r107, r108, r106, r109);
        return;
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
