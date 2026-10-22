package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "Ljava/io/Serializable;", "folderToken", "", "folderTitle", "depth", "", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;", "traceId", "payload", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;Ljava/lang/String;Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;)V", "getFolderToken", "()Ljava/lang/String;", "getFolderTitle", "getDepth", "()I", "getSource", "()Lcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;", "getTraceId", "getPayload", "()Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFolderPageRequest implements Serializable {
    private final int depth;
    private final String folderTitle;
    private final String folderToken;
    private final OfficeFolderPagePayload payload;
    private final OfficeFolderSource source;
    private final String traceId;

    public static /* synthetic */ OfficeFolderPageRequest copy$default(OfficeFolderPageRequest r4, String r5, String r6, int r7, OfficeFolderSource r8, String r9, OfficeFolderPagePayload r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.folderToken;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.folderTitle;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.depth;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.source;
    L14:
        OfficeFolderSource r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.traceId;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.payload;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.folderToken;
    }

    public final String component2() {
        return this.folderTitle;
    }

    public final int component3() {
        return this.depth;
    }

    public final OfficeFolderSource component4() {
        return this.source;
    }

    public final String component5() {
        return this.traceId;
    }

    public final OfficeFolderPagePayload component6() {
        return this.payload;
    }

    public final OfficeFolderPageRequest copy(String r9, String r10, int r11, OfficeFolderSource r12, String r13, OfficeFolderPagePayload r14) {
        Intrinsics.checkNotNullParameter(r9, "folderToken");
        Intrinsics.checkNotNullParameter(r10, "folderTitle");
        Intrinsics.checkNotNullParameter(r14, "payload");
        return new OfficeFolderPageRequest(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeFolderPageRequest) == true) goto L8;
        return false;
    L8:
        OfficeFolderPageRequest r6 = (OfficeFolderPageRequest) r5;
        if (Intrinsics.areEqual(this.folderToken, r6.folderToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.folderTitle, r6.folderTitle) == true) goto L15;
        return false;
    L15:
        if (this.depth == r6.depth) goto L18;
        return false;
    L18:
        if (this.source == r6.source) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.payload, r6.payload) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.folderToken.hashCode() * 31) + this.folderTitle.hashCode()) * 31) + this.depth) * 31;
        OfficeFolderSource r1 = this.source;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.traceId;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.payload.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeFolderPageRequest(folderToken=" + this.folderToken + ", folderTitle=" + this.folderTitle + ", depth=" + this.depth + ", source=" + this.source + ", traceId=" + this.traceId + ", payload=" + this.payload + ')';
    }

    public final int getDepth() {
        return this.depth;
    }

    public final String getFolderTitle() {
        return this.folderTitle;
    }

    public final String getFolderToken() {
        return this.folderToken;
    }

    public final OfficeFolderPagePayload getPayload() {
        return this.payload;
    }

    public final OfficeFolderSource getSource() {
        return this.source;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public OfficeFolderPageRequest(String r2, String r3, int r4, OfficeFolderSource r5, String r6, OfficeFolderPagePayload r7) {
        Intrinsics.checkNotNullParameter(r2, "folderToken");
        Intrinsics.checkNotNullParameter(r3, "folderTitle");
        Intrinsics.checkNotNullParameter(r7, "payload");
        this.folderToken = r2;
        this.folderTitle = r3;
        this.depth = r4;
        this.source = r5;
        this.traceId = r6;
        this.payload = r7;
    }
}
