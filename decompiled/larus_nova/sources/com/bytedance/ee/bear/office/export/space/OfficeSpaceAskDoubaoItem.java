package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010'\u001a\u00020\u0005HÆ\u0003J|\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoItem;", "Ljava/io/Serializable;", "token", "", "objType", "", "title", "url", "fileExt", "isFolder", "", "extra", "Ljava/util/LinkedHashMap;", "realType", "baseBizType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/LinkedHashMap;Ljava/lang/Integer;I)V", "getToken", "()Ljava/lang/String;", "getObjType", "()I", "getTitle", "getUrl", "getFileExt", "()Z", "getExtra", "()Ljava/util/LinkedHashMap;", "getRealType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaseBizType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/LinkedHashMap;Ljava/lang/Integer;I)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoItem;", "equals", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceAskDoubaoItem implements Serializable {
    private final int baseBizType;
    private final LinkedHashMap<String, String> extra;
    private final String fileExt;
    private final boolean isFolder;
    private final int objType;
    private final Integer realType;
    private final String title;
    private final String token;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceAskDoubaoItem copy$default(OfficeSpaceAskDoubaoItem r110, String r111, int r112, String r113, String r114, String r115, boolean r116, LinkedHashMap r117, Integer r118, int r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.token;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.objType;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.title;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.url;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.fileExt;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.isFolder;
    L27:
        if ((r210 & 64) == 0) goto L29;
        LinkedHashMap r106 = r110.extra;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.realType;
    L35:
        if ((r210 & 256) == 0) goto L37;
        int r108 = r110.baseBizType;
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
        return this.token;
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
        return this.fileExt;
    }

    public final boolean component6() {
        return this.isFolder;
    }

    public final LinkedHashMap<String, String> component7() {
        return this.extra;
    }

    public final Integer component8() {
        return this.realType;
    }

    public final int component9() {
        return this.baseBizType;
    }

    public final OfficeSpaceAskDoubaoItem copy(String r110, int r111, String r112, String r113, String r114, boolean r115, LinkedHashMap<String, String> r116, Integer r117, int r210) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r116, "extra");
        return new OfficeSpaceAskDoubaoItem(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceAskDoubaoItem) == true) goto L8;
        return false;
    L8:
        OfficeSpaceAskDoubaoItem r101 = (OfficeSpaceAskDoubaoItem) r100;
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
        if (Intrinsics.areEqual(this.fileExt, r101.fileExt) == true) goto L24;
        return false;
    L24:
        if (this.isFolder == r101.isFolder) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.realType, r101.realType) == true) goto L33;
        return false;
    L33:
        if (this.baseBizType == r101.baseBizType) goto L35;
        return false;
    L35:
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
        String r108 = this.fileExt;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.isFolder == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (((r110 + r111) * 31) + this.extra.hashCode()) * 31;
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
        return "OfficeSpaceAskDoubaoItem(token=" + this.token + ", objType=" + this.objType + ", title=" + this.title + ", url=" + this.url + ", fileExt=" + this.fileExt + ", isFolder=" + this.isFolder + ", extra=" + this.extra + ", realType=" + this.realType + ", baseBizType=" + this.baseBizType + ')';
    }

    public final int getBaseBizType() {
        return this.baseBizType;
    }

    public final LinkedHashMap<String, String> getExtra() {
        return this.extra;
    }

    public final String getFileExt() {
        return this.fileExt;
    }

    public final int getObjType() {
        return this.objType;
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

    public OfficeSpaceAskDoubaoItem(String r100, int r101, String r102, String r103, String r104, boolean r105, LinkedHashMap<String, String> r106, Integer r107, int r110) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r106, "extra");
        this.token = r100;
        this.objType = r101;
        this.title = r102;
        this.url = r103;
        this.fileExt = r104;
        this.isFolder = r105;
        this.extra = r106;
        this.realType = r107;
        this.baseBizType = r110;
    }

    public /* synthetic */ OfficeSpaceAskDoubaoItem(String r110, int r111, String r112, String r113, String r114, boolean r115, LinkedHashMap r210, Integer r211, int r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r213 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r213 & 64) == 0) goto L17;
        LinkedHashMap r116 = new LinkedHashMap();
    L19:
        if ((r213 & 128) == 0) goto L21;
        Integer r117 = null;
    L23:
        if ((r213 & 256) == 0) goto L25;
        int r118 = 0;
    L26:
        this(r110, r111, r112, r100, r101, r102, r116, r117, r118);
        return;
    L25:
        r118 = r212;
        goto L26
    L21:
        r117 = r211;
        goto L23
    L17:
        r116 = r210;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
