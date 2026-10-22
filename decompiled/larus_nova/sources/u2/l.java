package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/bytedance/ai/applet/granting/QSMusicLoginData;", "", "authLink", "", "title", "subTitle", "refuseText", "buttonLogin", "buttonRefuse", "requestId", "timeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAuthLink", "()Ljava/lang/String;", "getTitle", "getSubTitle", "getRefuseText", "getButtonLogin", "getButtonRefuse", "getRequestId", "getTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/applet/granting/QSMusicLoginData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("authLink")
    private final String authLink;

    @SerializedName("buttonLogin")
    private final String buttonLogin;

    @SerializedName("buttonRefuse")
    private final String buttonRefuse;

    @SerializedName("refuseText")
    private final String refuseText;

    @SerializedName("requestId")
    private final String requestId;

    @SerializedName("subTitle")
    private final String subTitle;

    @SerializedName("timeout")
    private final Integer timeout;

    @SerializedName("title")
    private final String title;

    public l() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.authLink, r101.authLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.refuseText, r101.refuseText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonLogin, r101.buttonLogin) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonRefuse, r101.buttonRefuse) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.timeout, r101.timeout) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.authLink;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.subTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.refuseText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.buttonLogin;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.buttonRefuse;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.requestId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.timeout;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "QSMusicLoginData(authLink=" + this.authLink + ", title=" + this.title + ", subTitle=" + this.subTitle + ", refuseText=" + this.refuseText + ", buttonLogin=" + this.buttonLogin + ", buttonRefuse=" + this.buttonRefuse + ", requestId=" + this.requestId + ", timeout=" + this.timeout + ')';
    }

    public final String b() {
        return this.authLink;
    }

    public final String c() {
        return this.buttonLogin;
    }

    public final String d() {
        return this.buttonRefuse;
    }

    public final String e() {
        return this.refuseText;
    }

    public final String f() {
        return this.subTitle;
    }

    public final String g() {
        return this.title;
    }

    public l(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107) {
        this.authLink = r100;
        this.title = r101;
        this.subTitle = r102;
        this.refuseText = r103;
        this.buttonLogin = r104;
        this.buttonRefuse = r105;
        this.requestId = r106;
        this.timeout = r107;
    }

    public static l a(l r110, String r111, String r112, String r113, String r114, String r115, String r116, int r117) {
        if ((r117 & 1) == 0) goto L5;
        String r100 = r110.authLink;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r102 = r110.subTitle;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r103 = r110.refuseText;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r104 = r110.buttonLogin;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r105 = r110.buttonRefuse;
    L27:
        if ((r117 & 64) == 0) goto L29;
        String r118 = r110.requestId;
    L31:
        if ((r117 & 128) == 0) goto L33;
        Integer r119 = r110.timeout;
    L34:
        r110.getClass();
        return new l(r100, r101, r102, r103, r104, r105, r118, r119);
    L33:
        r119 = null;
        goto L34
    L29:
        r118 = null;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
