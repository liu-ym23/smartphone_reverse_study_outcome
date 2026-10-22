package com.larus.bmhome.chat.model.repo;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jz\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\f2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/Tile;", "", "id", "", "name", "category", "Lcom/larus/bmhome/chat/model/repo/Category;", "type", "", "iconUrl", "iconUrlDark", "noticeEnabledValue", "", "noticePermissionValue", "supplierValue", "Lcom/larus/bmhome/chat/model/repo/SupplierDetail;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/repo/Category;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/repo/SupplierDetail;)V", "getId", "()Ljava/lang/String;", "getName", "getCategory", "()Lcom/larus/bmhome/chat/model/repo/Category;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconUrl", "getIconUrlDark", "getNoticeEnabledValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNoticePermissionValue", "getSupplierValue", "()Lcom/larus/bmhome/chat/model/repo/SupplierDetail;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/model/repo/Category;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/model/repo/SupplierDetail;)Lcom/larus/bmhome/chat/model/repo/Tile;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Tile {

    @SerializedName("category")
    private final Category category;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("icon_url_dark")
    private final String iconUrlDark;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f307756id;

    @SerializedName("name")
    private final String name;

    @SerializedName("notice_enabled_value")
    private final Boolean noticeEnabledValue;

    @SerializedName("notice_permission_value")
    private final Boolean noticePermissionValue;

    @SerializedName("supplier_value")
    private final SupplierDetail supplierValue;

    @SerializedName("type")
    private final Integer type;

    public Tile() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ Tile copy$default(Tile r110, String r111, String r112, Category r113, Integer r114, String r115, String r116, Boolean r117, Boolean r118, SupplierDetail r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.f307756id;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Category r102 = r110.category;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.type;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.iconUrl;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.iconUrlDark;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Boolean r106 = r110.noticeEnabledValue;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r107 = r110.noticePermissionValue;
    L35:
        if ((r210 & 256) == 0) goto L37;
        SupplierDetail r108 = r110.supplierValue;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
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

    public final String component1() {
        return this.f307756id;
    }

    public final String component2() {
        return this.name;
    }

    public final Category component3() {
        return this.category;
    }

    public final Integer component4() {
        return this.type;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.iconUrlDark;
    }

    public final Boolean component7() {
        return this.noticeEnabledValue;
    }

    public final Boolean component8() {
        return this.noticePermissionValue;
    }

    public final SupplierDetail component9() {
        return this.supplierValue;
    }

    public final Tile copy(String r110, String r111, Category r112, Integer r113, String r114, String r115, Boolean r116, Boolean r117, SupplierDetail r210) {
        return new Tile(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Tile) == true) goto L8;
        return false;
    L8:
        Tile r101 = (Tile) r100;
        if (Intrinsics.areEqual(this.f307756id, r101.f307756id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.category, r101.category) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconUrlDark, r101.iconUrlDark) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.noticeEnabledValue, r101.noticeEnabledValue) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.noticePermissionValue, r101.noticePermissionValue) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.supplierValue, r101.supplierValue) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r100 = this.f307756id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Category r107 = this.category;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.type;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.iconUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.iconUrlDark;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.noticeEnabledValue;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.noticePermissionValue;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        SupplierDetail r125 = this.supplierValue;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
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

    public String toString() {
        return "Tile(id=" + this.f307756id + ", name=" + this.name + ", category=" + this.category + ", type=" + this.type + ", iconUrl=" + this.iconUrl + ", iconUrlDark=" + this.iconUrlDark + ", noticeEnabledValue=" + this.noticeEnabledValue + ", noticePermissionValue=" + this.noticePermissionValue + ", supplierValue=" + this.supplierValue + ')';
    }

    public final Category getCategory() {
        return this.category;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIconUrlDark() {
        return this.iconUrlDark;
    }

    public final String getId() {
        return this.f307756id;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getNoticeEnabledValue() {
        return this.noticeEnabledValue;
    }

    public final Boolean getNoticePermissionValue() {
        return this.noticePermissionValue;
    }

    public final SupplierDetail getSupplierValue() {
        return this.supplierValue;
    }

    public final Integer getType() {
        return this.type;
    }

    public Tile(String r100, String r101, Category r102, Integer r103, String r104, String r105, Boolean r106, Boolean r107, SupplierDetail r108) {
        this.f307756id = r100;
        this.name = r101;
        this.category = r102;
        this.type = r103;
        this.iconUrl = r104;
        this.iconUrlDark = r105;
        this.noticeEnabledValue = r106;
        this.noticePermissionValue = r107;
        this.supplierValue = r108;
    }

    public /* synthetic */ Tile(String r110, String r111, Category r112, Integer r113, String r114, String r115, Boolean r116, Boolean r117, SupplierDetail r118, int r210, DefaultConstructorMarker r211) {
        SupplierDetail r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Category r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Boolean r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
