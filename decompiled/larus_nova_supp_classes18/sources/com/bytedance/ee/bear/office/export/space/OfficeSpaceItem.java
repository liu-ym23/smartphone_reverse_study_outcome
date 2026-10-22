package com.bytedance.ee.bear.office.export.space;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u008c\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "Ljava/io/Serializable;", ResourceData.KEY_TOKEN, "", "objType", "", "title", ResourceData.KEY_URL, "ownerName", "isFolder", "", "extra", "", "fileList", "", "realType", "baseBizType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/util/List;Ljava/lang/Integer;I)V", "getToken", "()Ljava/lang/String;", "getObjType", "()I", "getTitle", "getUrl", "getOwnerName", "()Z", "getExtra", "()Ljava/util/Map;", "getFileList", "()Ljava/util/List;", "getRealType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaseBizType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/util/List;Ljava/lang/Integer;I)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "equals", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
    public static /* synthetic */ OfficeSpaceItem copy$default(OfficeSpaceItem r11, String r12, int r13, String r14, String r15, String r16, boolean r17, Map r18, List r19, Integer r20, int r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.token;
    L7:
        if ((r22 & 2) == 0) goto L9;
        int r3 = r11.objType;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.title;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.url;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.ownerName;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r7 = r11.isFolder;
    L27:
        if ((r22 & 64) == 0) goto L29;
        Map r8 = r11.extra;
    L31:
        if ((r22 & 128) == 0) goto L33;
        List r9 = r11.fileList;
    L35:
        if ((r22 & 256) == 0) goto L37;
        Integer r10 = r11.realType;
    L39:
        if ((r22 & 512) == 0) goto L41;
        int r1 = r11.baseBizType;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
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

    public final OfficeSpaceItem copy(String r13, int r14, String r15, String r16, String r17, boolean r18, Map<String, String> r19, List<OfficeSpaceItem> r20, Integer r21, int r22) {
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r19, "extra");
        Intrinsics.checkNotNullParameter(r20, "fileList");
        return new OfficeSpaceItem(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceItem) == true) goto L8;
        return false;
    L8:
        OfficeSpaceItem r6 = (OfficeSpaceItem) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (this.objType == r6.objType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ownerName, r6.ownerName) == true) goto L24;
        return false;
    L24:
        if (this.isFolder == r6.isFolder) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fileList, r6.fileList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.realType, r6.realType) == true) goto L36;
        return false;
    L36:
        if (this.baseBizType == r6.baseBizType) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.token.hashCode() * 31) + this.objType) * 31;
        String r1 = this.title;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.url;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.ownerName;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.isFolder == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (((((r10 + r11) * 31) + this.extra.hashCode()) * 31) + this.fileList.hashCode()) * 31;
        Integer r13 = this.realType;
        if (r13 == null) goto L23;
        r2 = r13.hashCode();
    L23:
        return ((r12 + r2) * 31) + this.baseBizType;
    L17:
        r11 = 1237;
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
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

    public OfficeSpaceItem(String r2, int r3, String r4, String r5, String r6, boolean r7, Map<String, String> r8, List<OfficeSpaceItem> r9, Integer r10, int r11) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r9, "fileList");
        this.token = r2;
        this.objType = r3;
        this.title = r4;
        this.url = r5;
        this.ownerName = r6;
        this.isFolder = r7;
        this.extra = r8;
        this.fileList = r9;
        this.realType = r10;
        this.baseBizType = r11;
    }

    public /* synthetic */ OfficeSpaceItem(String r15, int r16, String r17, String r18, String r19, boolean r20, Map r21, List r22, Integer r23, int r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r25 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r25 & 32) == 0) goto L13;
        boolean r9 = false;
    L15:
        if ((r25 & 64) == 0) goto L17;
        Map r10 = MapsKt.emptyMap();
    L19:
        if ((r25 & 128) == 0) goto L21;
        List r11 = CollectionsKt.emptyList();
    L23:
        if ((r25 & 256) == 0) goto L25;
        Integer r12 = null;
    L27:
        if ((r25 & 512) == 0) goto L29;
        int r13 = 0;
    L30:
        this(r15, r16, r17, r7, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r24;
        goto L30
    L25:
        r12 = r23;
        goto L27
    L21:
        r11 = r22;
        goto L23
    L17:
        r10 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }
}
