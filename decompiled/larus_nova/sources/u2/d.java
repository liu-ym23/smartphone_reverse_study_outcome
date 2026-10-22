package u2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/ai/applet/granting/FirstPartyLoginData;", "", "authLink", "", "bizLoginDescription", "awemeLoginDescription", "awemeLoginCommonPrivacyURL", "requestId", "timeout", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAuthLink", "()Ljava/lang/String;", "getBizLoginDescription", "getAwemeLoginDescription", "getAwemeLoginCommonPrivacyURL", "getRequestId", "getTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/ai/applet/granting/FirstPartyLoginData;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("authLink")
    private final String authLink;

    @SerializedName("awemeLoginCommonPrivacyURL")
    private final String awemeLoginCommonPrivacyURL;

    @SerializedName("awemeLoginDescription")
    private final String awemeLoginDescription;

    @SerializedName("bizLoginDescription")
    private final String bizLoginDescription;

    @SerializedName("requestId")
    private final String requestId;

    @SerializedName("timeout")
    private final Integer timeout;

    public d() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.authLink, r101.authLink) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizLoginDescription, r101.bizLoginDescription) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.awemeLoginDescription, r101.awemeLoginDescription) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.awemeLoginCommonPrivacyURL, r101.awemeLoginCommonPrivacyURL) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.timeout, r101.timeout) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.authLink;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.bizLoginDescription;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.awemeLoginDescription;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.awemeLoginCommonPrivacyURL;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.requestId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.timeout;
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

    public final String toString() {
        return "FirstPartyLoginData(authLink=" + this.authLink + ", bizLoginDescription=" + this.bizLoginDescription + ", awemeLoginDescription=" + this.awemeLoginDescription + ", awemeLoginCommonPrivacyURL=" + this.awemeLoginCommonPrivacyURL + ", requestId=" + this.requestId + ", timeout=" + this.timeout + ')';
    }

    public final String b() {
        return this.authLink;
    }

    public final String c() {
        return this.awemeLoginCommonPrivacyURL;
    }

    public final String d() {
        return this.awemeLoginDescription;
    }

    public final String e() {
        return this.bizLoginDescription;
    }

    public final Integer f() {
        return this.timeout;
    }

    public d(String r100, String r101, String r102, String r103, String r104, Integer r105) {
        this.authLink = r100;
        this.bizLoginDescription = r101;
        this.awemeLoginDescription = r102;
        this.awemeLoginCommonPrivacyURL = r103;
        this.requestId = r104;
        this.timeout = r105;
    }

    public static d a(d r100, String r101, String r102, String r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.authLink;
    L5:
        String r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.bizLoginDescription;
    L8:
        String r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.awemeLoginDescription;
    L11:
        String r105 = r110;
        if ((r112 & 8) == 0) goto L14;
        r111 = r100.awemeLoginCommonPrivacyURL;
    L14:
        String r106 = r111;
        if ((r112 & 16) == 0) goto L17;
        String r107 = r100.requestId;
    L19:
        if ((r112 & 32) == 0) goto L21;
        Integer r108 = r100.timeout;
    L22:
        r100.getClass();
        return new d(r103, r104, r105, r106, r107, r108);
    L21:
        r108 = null;
        goto L22
    L17:
        r107 = null;
        goto L19
    }
}
