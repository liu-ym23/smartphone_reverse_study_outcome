package u2;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jm\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/ai/applet/granting/GrantingData;", "", "doubaoAppletKey", "", "doubaoAppletName", "doubaoAppletIcon", "doubaoAppletVersion", "doubaoAppletType", "refuseInteractReplay", "", "cardStatus", "grantingList", "", "Lcom/bytedance/ai/applet/granting/GrantingItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getDoubaoAppletKey", "()Ljava/lang/String;", "getDoubaoAppletName", "getDoubaoAppletIcon", "getDoubaoAppletVersion", "getDoubaoAppletType", "getRefuseInteractReplay", "()Z", "getCardStatus", "getGrantingList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("cardStatus")
    private final String cardStatus;

    @SerializedName("doubaoAppletIcon")
    private final String doubaoAppletIcon;

    @SerializedName("doubaoAppletKey")
    private final String doubaoAppletKey;

    @SerializedName("doubaoAppletName")
    private final String doubaoAppletName;

    @SerializedName("doubaoAppletType")
    private final String doubaoAppletType;

    @SerializedName("doubaoAppletVersion")
    private final String doubaoAppletVersion;

    @SerializedName("grantingList")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<f> grantingList;

    @SerializedName("refuseInteractReplay")
    private final boolean refuseInteractReplay;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.doubaoAppletKey, r101.doubaoAppletKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doubaoAppletName, r101.doubaoAppletName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doubaoAppletIcon, r101.doubaoAppletIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.doubaoAppletVersion, r101.doubaoAppletVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.doubaoAppletType, r101.doubaoAppletType) == true) goto L24;
        return false;
    L24:
        if (this.refuseInteractReplay == r101.refuseInteractReplay) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cardStatus, r101.cardStatus) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.grantingList, r101.grantingList) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.doubaoAppletKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.doubaoAppletName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.doubaoAppletIcon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.doubaoAppletVersion;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.doubaoAppletType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.refuseInteractReplay == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        String r118 = this.cardStatus;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        List<f> r121 = this.grantingList;
        if (r121 == null) goto L35;
        r101 = r121.hashCode();
    L35:
        return r120 + r101;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = 1237;
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
        return "GrantingData(doubaoAppletKey=" + this.doubaoAppletKey + ", doubaoAppletName=" + this.doubaoAppletName + ", doubaoAppletIcon=" + this.doubaoAppletIcon + ", doubaoAppletVersion=" + this.doubaoAppletVersion + ", doubaoAppletType=" + this.doubaoAppletType + ", refuseInteractReplay=" + this.refuseInteractReplay + ", cardStatus=" + this.cardStatus + ", grantingList=" + this.grantingList + ')';
    }

    public final String b() {
        return this.cardStatus;
    }

    public final String c() {
        return this.doubaoAppletIcon;
    }

    public final String d() {
        return this.doubaoAppletKey;
    }

    public final String e() {
        return this.doubaoAppletName;
    }

    public final String f() {
        return this.doubaoAppletType;
    }

    public final String g() {
        return this.doubaoAppletVersion;
    }

    public final List<f> h() {
        return this.grantingList;
    }

    public final boolean i() {
        return this.refuseInteractReplay;
    }

    public /* synthetic */ e(String r110, String r111, List r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r113 & 64) == 0) goto L13;
        r100 = "unexpired";
    L13:
        String r103 = r100;
        if ((r113 & 128) == 0) goto L16;
        r112 = CollectionsKt.emptyList();
    L16:
        this(r101, null, null, r102, null, false, r103, r112);
        return;
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public static e a(e r110, String r111, List r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.doubaoAppletKey;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.doubaoAppletName;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = r110.doubaoAppletIcon;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r104 = r110.doubaoAppletVersion;
    L19:
        if ((r113 & 16) == 0) goto L21;
        r100 = r110.doubaoAppletType;
    L21:
        String r105 = r100;
        if ((r113 & 32) == 0) goto L24;
        boolean r106 = r110.refuseInteractReplay;
    L26:
        if ((r113 & 64) == 0) goto L28;
        r111 = r110.cardStatus;
    L28:
        String r107 = r111;
        if ((r113 & 128) == 0) goto L31;
        r112 = r110.grantingList;
    L31:
        r110.getClass();
        return new e(r101, r102, r103, r104, r105, r106, r107, r112);
    L24:
        r106 = false;
        goto L26
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public e(String r100, String r101, String r102, String r103, String r104, boolean r105, String r106, List<f> r107) {
        this.doubaoAppletKey = r100;
        this.doubaoAppletName = r101;
        this.doubaoAppletIcon = r102;
        this.doubaoAppletVersion = r103;
        this.doubaoAppletType = r104;
        this.refuseInteractReplay = r105;
        this.cardStatus = r106;
        this.grantingList = r107;
    }
}
