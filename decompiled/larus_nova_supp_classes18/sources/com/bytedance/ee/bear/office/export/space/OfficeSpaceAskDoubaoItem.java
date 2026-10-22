package com.bytedance.ee.bear.office.export.space;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010'\u001a\u00020\u0005HÆ\u0003J|\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoItem;", "Ljava/io/Serializable;", ResourceData.KEY_TOKEN, "", "objType", "", "title", ResourceData.KEY_URL, "fileExt", "isFolder", "", "extra", "Ljava/util/LinkedHashMap;", "realType", "baseBizType", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/LinkedHashMap;Ljava/lang/Integer;I)V", "getToken", "()Ljava/lang/String;", "getObjType", "()I", "getTitle", "getUrl", "getFileExt", "()Z", "getExtra", "()Ljava/util/LinkedHashMap;", "getRealType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaseBizType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/LinkedHashMap;Ljava/lang/Integer;I)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceAskDoubaoItem;", "equals", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
    public static /* synthetic */ OfficeSpaceAskDoubaoItem copy$default(OfficeSpaceAskDoubaoItem r10, String r11, int r12, String r13, String r14, String r15, boolean r16, LinkedHashMap r17, Integer r18, int r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.token;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.objType;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.title;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.url;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.fileExt;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r7 = r10.isFolder;
    L27:
        if ((r20 & 64) == 0) goto L29;
        LinkedHashMap r8 = r10.extra;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Integer r9 = r10.realType;
    L35:
        if ((r20 & 256) == 0) goto L37;
        int r1 = r10.baseBizType;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final OfficeSpaceAskDoubaoItem copy(String r12, int r13, String r14, String r15, String r16, boolean r17, LinkedHashMap<String, String> r18, Integer r19, int r20) {
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "extra");
        return new OfficeSpaceAskDoubaoItem(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceAskDoubaoItem) == true) goto L8;
        return false;
    L8:
        OfficeSpaceAskDoubaoItem r6 = (OfficeSpaceAskDoubaoItem) r5;
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
        if (Intrinsics.areEqual(this.fileExt, r6.fileExt) == true) goto L24;
        return false;
    L24:
        if (this.isFolder == r6.isFolder) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.realType, r6.realType) == true) goto L33;
        return false;
    L33:
        if (this.baseBizType == r6.baseBizType) goto L35;
        return false;
    L35:
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
        String r8 = this.fileExt;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.isFolder == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (((r10 + r11) * 31) + this.extra.hashCode()) * 31;
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

    public OfficeSpaceAskDoubaoItem(String r2, int r3, String r4, String r5, String r6, boolean r7, LinkedHashMap<String, String> r8, Integer r9, int r10) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "extra");
        this.token = r2;
        this.objType = r3;
        this.title = r4;
        this.url = r5;
        this.fileExt = r6;
        this.isFolder = r7;
        this.extra = r8;
        this.realType = r9;
        this.baseBizType = r10;
    }

    public /* synthetic */ OfficeSpaceAskDoubaoItem(String r14, int r15, String r16, String r17, String r18, boolean r19, LinkedHashMap r20, Integer r21, int r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r23 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r23 & 32) == 0) goto L13;
        boolean r9 = false;
    L15:
        if ((r23 & 64) == 0) goto L17;
        LinkedHashMap r10 = new LinkedHashMap();
    L19:
        if ((r23 & 128) == 0) goto L21;
        Integer r11 = null;
    L23:
        if ((r23 & 256) == 0) goto L25;
        int r12 = 0;
    L26:
        this(r14, r15, r16, r7, r8, r9, r10, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r7 = r17;
        goto L7
    }
}
