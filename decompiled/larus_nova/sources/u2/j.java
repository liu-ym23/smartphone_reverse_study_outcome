package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015Jb\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bytedance/ai/applet/granting/LocalLoginData;", "", "privacyURL", "", "termsOfServiceURL", "privacyContent", "mobileMask", "loginDescription", "requestId", "timeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getPrivacyURL", "()Ljava/lang/String;", "getTermsOfServiceURL", "getPrivacyContent", "getMobileMask", "getLoginDescription", "getRequestId", "getTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/applet/granting/LocalLoginData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    @SerializedName("bizLoginDescription")
    private final String loginDescription;

    @SerializedName("mobileMask")
    private final String mobileMask;

    @SerializedName("bizPrivacyContent")
    private final String privacyContent;

    @SerializedName("privacyURL")
    private final String privacyURL;

    @SerializedName("requestId")
    private final String requestId;

    @SerializedName("termsOfServiceURL")
    private final String termsOfServiceURL;

    @SerializedName("timeout")
    private final Integer timeout;

    public j() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.privacyURL, r101.privacyURL) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.termsOfServiceURL, r101.termsOfServiceURL) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.privacyContent, r101.privacyContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mobileMask, r101.mobileMask) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.loginDescription, r101.loginDescription) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeout, r101.timeout) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.privacyURL;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.termsOfServiceURL;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.privacyContent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mobileMask;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.loginDescription;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.requestId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.timeout;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public final String toString() {
        return "LocalLoginData(privacyURL=" + this.privacyURL + ", termsOfServiceURL=" + this.termsOfServiceURL + ", privacyContent=" + this.privacyContent + ", mobileMask=" + this.mobileMask + ", loginDescription=" + this.loginDescription + ", requestId=" + this.requestId + ", timeout=" + this.timeout + ')';
    }

    public final String b() {
        return this.loginDescription;
    }

    public final String c() {
        return this.mobileMask;
    }

    public final String d() {
        return this.privacyContent;
    }

    public final String e() {
        return this.privacyURL;
    }

    public final String f() {
        return this.termsOfServiceURL;
    }

    public j(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106) {
        this.privacyURL = r100;
        this.termsOfServiceURL = r101;
        this.privacyContent = r102;
        this.mobileMask = r103;
        this.loginDescription = r104;
        this.requestId = r105;
        this.timeout = r106;
    }

    public static j a(j r100, String r101, String r110, String r111, String r112, String r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.privacyURL;
    L5:
        String r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.termsOfServiceURL;
    L8:
        String r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = r100.privacyContent;
    L11:
        String r104 = r111;
        if ((r114 & 8) == 0) goto L14;
        r112 = r100.mobileMask;
    L14:
        String r105 = r112;
        if ((r114 & 16) == 0) goto L17;
        r113 = r100.loginDescription;
    L17:
        String r106 = r113;
        if ((r114 & 32) == 0) goto L20;
        String r107 = r100.requestId;
    L22:
        if ((r114 & 64) == 0) goto L24;
        Integer r108 = r100.timeout;
    L25:
        r100.getClass();
        return new j(r102, r103, r104, r105, r106, r107, r108);
    L24:
        r108 = null;
        goto L25
    L20:
        r107 = null;
        goto L22
    }
}
