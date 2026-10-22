package du9;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/settings/provider/chat/ChatNavNewStyleSettings;", "", "officialWebsiteName", "", "overseaOfficialWebsiteName", "overseaOfficialWebsiteUrl", "officialWebsiteUrl", "officialWebsiteDisplayBotTypes", "Ljava/util/ArrayList;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getOfficialWebsiteName", "()Ljava/lang/String;", "getOverseaOfficialWebsiteName", "getOverseaOfficialWebsiteUrl", "getOfficialWebsiteUrl", "getOfficialWebsiteDisplayBotTypes", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u {

    @SerializedName("official_website_display_bot_types")
    private final ArrayList<Integer> officialWebsiteDisplayBotTypes;

    @SerializedName("official_website_name")
    private final String officialWebsiteName;

    @SerializedName("official_website_url")
    private final String officialWebsiteUrl;

    @SerializedName("oversea_official_website_name")
    private final String overseaOfficialWebsiteName;

    @SerializedName("oversea_official_website_url")
    private final String overseaOfficialWebsiteUrl;

    public u() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.officialWebsiteName, r101.officialWebsiteName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.overseaOfficialWebsiteName, r101.overseaOfficialWebsiteName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.overseaOfficialWebsiteUrl, r101.overseaOfficialWebsiteUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.officialWebsiteUrl, r101.officialWebsiteUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.officialWebsiteDisplayBotTypes, r101.officialWebsiteDisplayBotTypes) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.officialWebsiteName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.overseaOfficialWebsiteName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.overseaOfficialWebsiteUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.officialWebsiteUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ArrayList<Integer> r113 = this.officialWebsiteDisplayBotTypes;
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

    public final String toString() {
        return "ChatNavNewStyleSettings(officialWebsiteName=" + this.officialWebsiteName + ", overseaOfficialWebsiteName=" + this.overseaOfficialWebsiteName + ", overseaOfficialWebsiteUrl=" + this.overseaOfficialWebsiteUrl + ", officialWebsiteUrl=" + this.officialWebsiteUrl + ", officialWebsiteDisplayBotTypes=" + this.officialWebsiteDisplayBotTypes + ')';
    }

    public final ArrayList<Integer> a() {
        return this.officialWebsiteDisplayBotTypes;
    }

    public final String b() {
        return this.officialWebsiteName;
    }

    public final String c() {
        return this.officialWebsiteUrl;
    }

    public final String d() {
        return this.overseaOfficialWebsiteName;
    }

    public final String e() {
        return this.overseaOfficialWebsiteUrl;
    }

    public u(ArrayList r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        String r102 = "doubao.com";
    L6:
        String r103 = "";
        if ((r101 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r101 & 4) == 0) goto L13;
        String r105 = "";
    L15:
        if ((r101 & 8) != 0) goto L19;
        r103 = null;
    L19:
        if ((r101 & 16) == 0) goto L21;
        r100 = null;
    L21:
        this.officialWebsiteName = r102;
        this.overseaOfficialWebsiteName = r104;
        this.overseaOfficialWebsiteUrl = r105;
        this.officialWebsiteUrl = r103;
        this.officialWebsiteDisplayBotTypes = r100;
        return;
    L13:
        r105 = null;
        goto L15
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
