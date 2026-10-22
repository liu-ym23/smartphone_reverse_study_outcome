package com.bytedance.awemeopen.bizmodels.profile;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/profile/ShowIdentifyAuthInfo;", "Ljava/io/Serializable;", "text", "", "textColor", "url", "mobInfo", "iconUrl", "accessibilityText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessibilityText", "()Ljava/lang/String;", "getIconUrl", "getMobInfo", "getText", "getTextColor", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShowIdentifyAuthInfo implements Serializable {

    @SerializedName("accessibility_text")
    private final String accessibilityText;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("tracker_params")
    private final String mobInfo;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("action")
    private final String url;

    public ShowIdentifyAuthInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ShowIdentifyAuthInfo copy$default(ShowIdentifyAuthInfo r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.textColor;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.url;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.mobInfo;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.iconUrl;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.accessibilityText;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.textColor;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.mobInfo;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.accessibilityText;
    }

    public final ShowIdentifyAuthInfo copy(String r100, String r110, String r111, String r112, String r113, String r114) {
        return new ShowIdentifyAuthInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShowIdentifyAuthInfo) == true) goto L8;
        return false;
    L8:
        ShowIdentifyAuthInfo r101 = (ShowIdentifyAuthInfo) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mobInfo, r101.mobInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.accessibilityText, r101.accessibilityText) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.url;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mobInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.iconUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.accessibilityText;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "ShowIdentifyAuthInfo(text=" + this.text + ", textColor=" + this.textColor + ", url=" + this.url + ", mobInfo=" + this.mobInfo + ", iconUrl=" + this.iconUrl + ", accessibilityText=" + this.accessibilityText + ')';
    }

    public final String getAccessibilityText() {
        return this.accessibilityText;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getMobInfo() {
        return this.mobInfo;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getUrl() {
        return this.url;
    }

    public ShowIdentifyAuthInfo(String r100, String r101, String r102, String r103, String r104, String r105) {
        this.text = r100;
        this.textColor = r101;
        this.url = r102;
        this.mobInfo = r103;
        this.iconUrl = r104;
        this.accessibilityText = r105;
    }

    public /* synthetic */ ShowIdentifyAuthInfo(String r100, String r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = "";
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = "";
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = "";
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
