package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u008c\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "Ljava/io/Serializable;", "token", "", "objType", "", "title", "url", "ownerName", "isFolder", "", "extra", "", "fileList", "", "realType", "baseBizType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/util/List;Ljava/lang/Integer;I)V", "getToken", "()Ljava/lang/String;", "getObjType", "()I", "getTitle", "getUrl", "getOwnerName", "()Z", "getExtra", "()Ljava/util/Map;", "getFileList", "()Ljava/util/List;", "getRealType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaseBizType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/util/List;Ljava/lang/Integer;I)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "equals", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceItem implements Serializable {
    private final int baseBizType;
    private final Map<String, String> extra;
    private final List<OfficeSpaceItem> fileList;
    private final boolean isFolder;
    private final int objType;
    private final String ownerName;
    private final Integer realType;
    private final String title;
    private final String token;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceItem copy$default(OfficeSpaceItem r110, String r111, int r112, String r113, String r114, String r115, boolean r116, Map r117, List r118, Integer r210, int r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.token;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = r110.objType;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.title;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.url;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.ownerName;
    L23:
        if ((r212 & 32) == 0) goto L25;
        boolean r105 = r110.isFolder;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Map r106 = r110.extra;
    L31:
        if ((r212 & 128) == 0) goto L33;
        List r107 = r110.fileList;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Integer r119 = r110.realType;
    L39:
        if ((r212 & 512) == 0) goto L41;
        int r108 = r110.baseBizType;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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
        return this.token;
    }

    public final int component10() {
        return this.baseBizType;
    }

    public final int component2() {
        return this.objType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.ownerName;
    }

    public final boolean component6() {
        return this.isFolder;
    }

    public final Map<String, String> component7() {
        return this.extra;
    }

    public final List<OfficeSpaceItem> component8() {
        return this.fileList;
    }

    public final Integer component9() {
        return this.realType;
    }

    public final OfficeSpaceItem copy(String r110, int r111, String r112, String r113, String r114, boolean r115, Map<String, String> r116, List<OfficeSpaceItem> r210, Integer r211, int r212) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r116, "extra");
        Intrinsics.checkNotNullParameter(r210, "fileList");
        return new OfficeSpaceItem(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceItem) == true) goto L8;
        return false;
    L8:
        OfficeSpaceItem r101 = (OfficeSpaceItem) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (this.objType == r101.objType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ownerName, r101.ownerName) == true) goto L24;
        return false;
    L24:
        if (this.isFolder == r101.isFolder) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fileList, r101.fileList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.realType, r101.realType) == true) goto L36;
        return false;
    L36:
        if (this.baseBizType == r101.baseBizType) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.token.hashCode() * 31) + this.objType) * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.url;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.ownerName;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.isFolder == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((((r110 + r111) * 31) + this.extra.hashCode()) * 31) + this.fileList.hashCode()) * 31;
        Integer r113 = this.realType;
        if (r113 == null) goto L23;
        r102 = r113.hashCode();
    L23:
        return ((r112 + r102) * 31) + this.baseBizType;
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeSpaceItem(token=" + this.token + ", objType=" + this.objType + ", title=" + this.title + ", url=" + this.url + ", ownerName=" + this.ownerName + ", isFolder=" + this.isFolder + ", extra=" + this.extra + ", fileList=" + this.fileList + ", realType=" + this.realType + ", baseBizType=" + this.baseBizType + ')';
    }

    public final int getBaseBizType() {
        return this.baseBizType;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final List<OfficeSpaceItem> getFileList() {
        return this.fileList;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final Integer getRealType() {
        return this.realType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    public OfficeSpaceItem(String r100, int r101, String r102, String r103, String r104, boolean r105, Map<String, String> r106, List<OfficeSpaceItem> r107, Integer r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r106, "extra");
        Intrinsics.checkNotNullParameter(r107, "fileList");
        this.token = r100;
        this.objType = r101;
        this.title = r102;
        this.url = r103;
        this.ownerName = r104;
        this.isFolder = r105;
        this.extra = r106;
        this.fileList = r107;
        this.realType = r110;
        this.baseBizType = r111;
    }

    public /* synthetic */ OfficeSpaceItem(String r110, int r111, String r112, String r113, String r114, boolean r210, Map r211, List r212, Integer r213, int r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r215 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r215 & 64) == 0) goto L17;
        Map r115 = MapsKt.emptyMap();
    L19:
        if ((r215 & 128) == 0) goto L21;
        List r116 = CollectionsKt.emptyList();
    L23:
        if ((r215 & 256) == 0) goto L25;
        Integer r117 = null;
    L27:
        if ((r215 & 512) == 0) goto L29;
        int r118 = 0;
    L30:
        this(r110, r111, r112, r100, r101, r102, r115, r116, r117, r118);
        return;
    L29:
        r118 = r214;
        goto L30
    L25:
        r117 = r213;
        goto L27
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
