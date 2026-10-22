package com.larus.bmhome.share.network;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "", "shareId", "", "shareUrl", "qrCodeUrl", "sharePermissionType", "", "larkMetaIdentity", "Lcom/larus/bmhome/share/network/LarkMetaIdentity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/share/network/LarkMetaIdentity;)V", "getShareId", "()Ljava/lang/String;", "getShareUrl", "getQrCodeUrl", "getSharePermissionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLarkMetaIdentity", "()Lcom/larus/bmhome/share/network/LarkMetaIdentity;", "isCcmSharePanelAvailable", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/share/network/LarkMetaIdentity;)Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveMessageShareInfo {

    @SerializedName("lark_meta_identity")
    private final LarkMetaIdentity larkMetaIdentity;

    @SerializedName("qr_code_url")
    private final String qrCodeUrl;

    @SerializedName(BdpAppEventConstant.SHARE_ID)
    private final String shareId;

    @SerializedName("share_permission_type")
    private final Integer sharePermissionType;

    @SerializedName("share_url")
    private final String shareUrl;

    public SaveMessageShareInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SaveMessageShareInfo copy$default(SaveMessageShareInfo r100, String r101, String r102, String r103, Integer r104, LarkMetaIdentity r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.shareId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.shareUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.qrCodeUrl;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.sharePermissionType;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.larkMetaIdentity;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.shareId;
    }

    public final String component2() {
        return this.shareUrl;
    }

    public final String component3() {
        return this.qrCodeUrl;
    }

    public final Integer component4() {
        return this.sharePermissionType;
    }

    public final LarkMetaIdentity component5() {
        return this.larkMetaIdentity;
    }

    public final SaveMessageShareInfo copy(String r100, String r101, String r110, Integer r111, LarkMetaIdentity r112) {
        return new SaveMessageShareInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SaveMessageShareInfo) == true) goto L8;
        return false;
    L8:
        SaveMessageShareInfo r101 = (SaveMessageShareInfo) r100;
        if (Intrinsics.areEqual(this.shareId, r101.shareId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shareUrl, r101.shareUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.qrCodeUrl, r101.qrCodeUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sharePermissionType, r101.sharePermissionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.larkMetaIdentity, r101.larkMetaIdentity) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.shareId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.shareUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.qrCodeUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.sharePermissionType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        LarkMetaIdentity r113 = this.larkMetaIdentity;
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
        return "SaveMessageShareInfo(shareId=" + this.shareId + ", shareUrl=" + this.shareUrl + ", qrCodeUrl=" + this.qrCodeUrl + ", sharePermissionType=" + this.sharePermissionType + ", larkMetaIdentity=" + this.larkMetaIdentity + ')';
    }

    public final boolean isCcmSharePanelAvailable() {
        Integer r100 = this.sharePermissionType;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.intValue() != 2) goto L24;
        String r101 = this.shareUrl;
        if (r101 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == true) goto L25;
        LarkMetaIdentity r103 = this.larkMetaIdentity;
        if (r103 != null) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r103.isValid() != true) goto L20;
        r104 = true;
        goto L21
    L25:
        return false;
    L10:
        if (StringsKt.isBlank(r101) == true) goto L13;
        r102 = false;
        goto L14
    L24:
        return false;
    }

    public final LarkMetaIdentity getLarkMetaIdentity() {
        return this.larkMetaIdentity;
    }

    public final String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public final String getShareId() {
        return this.shareId;
    }

    public final Integer getSharePermissionType() {
        return this.sharePermissionType;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public SaveMessageShareInfo(String r100, String r101, String r102, Integer r103, LarkMetaIdentity r104) {
        this.shareId = r100;
        this.shareUrl = r101;
        this.qrCodeUrl = r102;
        this.sharePermissionType = r103;
        this.larkMetaIdentity = r104;
    }

    public /* synthetic */ SaveMessageShareInfo(String r100, String r101, String r102, Integer r103, LarkMetaIdentity r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        Integer r108 = null;
    L19:
        if ((r105 & 16) == 0) goto L21;
        LarkMetaIdentity r109 = null;
    L22:
        this(r111, r107, r106, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
