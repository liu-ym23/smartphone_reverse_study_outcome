package com.larus.avlink.e.mock;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jd\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/larus/avlink/e/mock/CameraImageInfoJson;", "", "imageUUID", "", "side", "dataSize", SubInfo.KEY_FORMAT, "width", "height", "linkType", "dataBase64", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;IIIIILjava/lang/String;)V", "getImageUUID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSide", "getDataSize", "()I", "getFormat", "getWidth", "getHeight", "getLinkType", "getDataBase64", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;IIIIILjava/lang/String;)Lcom/larus/avlink/e/mock/CameraImageInfoJson;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraImageInfoJson {
    public static final int $stable = 0;

    @SerializedName("dataBase64")
    private final String dataBase64;

    @SerializedName("dataSize")
    private final int dataSize;

    @SerializedName(SubInfo.KEY_FORMAT)
    private final int format;

    @SerializedName("height")
    private final int height;

    @SerializedName("imageUUID")
    private final Integer imageUUID;

    @SerializedName("linkType")
    private final int linkType;

    @SerializedName("side")
    private final Integer side;

    @SerializedName("width")
    private final int width;

    public CameraImageInfoJson() {
        this(null, null, 0, 0, 0, 0, 0, null, 255, null);
    }

    public static /* synthetic */ CameraImageInfoJson copy$default(CameraImageInfoJson r100, Integer r110, Integer r111, int r112, int r113, int r114, int r115, int r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = r100.imageUUID;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = r100.side;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.dataSize;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.format;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.width;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.height;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.linkType;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.dataBase64;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final Integer component1() {
        return this.imageUUID;
    }

    public final Integer component2() {
        return this.side;
    }

    public final int component3() {
        return this.dataSize;
    }

    public final int component4() {
        return this.format;
    }

    public final int component5() {
        return this.width;
    }

    public final int component6() {
        return this.height;
    }

    public final int component7() {
        return this.linkType;
    }

    public final String component8() {
        return this.dataBase64;
    }

    public final CameraImageInfoJson copy(Integer r110, Integer r111, int r112, int r113, int r114, int r115, int r116, String r117) {
        return new CameraImageInfoJson(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraImageInfoJson) == true) goto L8;
        return false;
    L8:
        CameraImageInfoJson r101 = (CameraImageInfoJson) r100;
        if (Intrinsics.areEqual(this.imageUUID, r101.imageUUID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.side, r101.side) == true) goto L15;
        return false;
    L15:
        if (this.dataSize == r101.dataSize) goto L18;
        return false;
    L18:
        if (this.format == r101.format) goto L21;
        return false;
    L21:
        if (this.width == r101.width) goto L24;
        return false;
    L24:
        if (this.height == r101.height) goto L27;
        return false;
    L27:
        if (this.linkType == r101.linkType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.dataBase64, r101.dataBase64) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.imageUUID;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.side;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((((r103 + r105) * 31) + this.dataSize) * 31) + this.format) * 31) + this.width) * 31) + this.height) * 31) + this.linkType) * 31;
        String r107 = this.dataBase64;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CameraImageInfoJson(imageUUID=" + this.imageUUID + ", side=" + this.side + ", dataSize=" + this.dataSize + ", format=" + this.format + ", width=" + this.width + ", height=" + this.height + ", linkType=" + this.linkType + ", dataBase64=" + this.dataBase64 + ')';
    }

    public final String getDataBase64() {
        return this.dataBase64;
    }

    public final int getDataSize() {
        return this.dataSize;
    }

    public final int getFormat() {
        return this.format;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Integer getImageUUID() {
        return this.imageUUID;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public final Integer getSide() {
        return this.side;
    }

    public final int getWidth() {
        return this.width;
    }

    public CameraImageInfoJson(Integer r100, Integer r101, int r102, int r103, int r104, int r105, int r106, String r107) {
        this.imageUUID = r100;
        this.side = r101;
        this.dataSize = r102;
        this.format = r103;
        this.width = r104;
        this.height = r105;
        this.linkType = r106;
        this.dataBase64 = r107;
    }

    public /* synthetic */ CameraImageInfoJson(Integer r110, Integer r111, int r112, int r113, int r114, int r115, int r116, String r117, int r118, DefaultConstructorMarker r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r100 = -1;
    L6:
        int r101 = 0;
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r101 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r107 = null;
    L34:
        this(r100, r102, r103, r104, r105, r106, r101, r107);
        return;
    L33:
        r107 = r117;
        goto L34
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
        r100 = r110;
        goto L6
    }
}
