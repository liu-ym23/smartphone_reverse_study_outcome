package com.bytedance.ee.bear.office.export.space;

import com.bytedance.common.wschannel.WsConstants;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "Ljava/io/Serializable;", "folderToken", "", "folderTitle", ToygerFaceAlgorithmConfig.DEPTH, "", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;", "traceId", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;Ljava/lang/String;Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;)V", "getFolderToken", "()Ljava/lang/String;", "getFolderTitle", "getDepth", "()I", "getSource", "()Lcom/bytedance/ee/bear/office/export/space/OfficeFolderSource;", "getTraceId", "getPayload", "()Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPagePayload;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFolderPageRequest implements Serializable {
    private final int depth;
    private final String folderTitle;
    private final String folderToken;
    private final OfficeFolderPagePayload payload;
    private final OfficeFolderSource source;
    private final String traceId;

    public static /* synthetic */ OfficeFolderPageRequest copy$default(OfficeFolderPageRequest r100, String r101, String r102, int r103, OfficeFolderSource r104, String r105, OfficeFolderPagePayload r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.folderToken;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.folderTitle;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.depth;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.source;
    L14:
        OfficeFolderSource r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.traceId;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.payload;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
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

    public final OfficeFolderPageRequest copy(String r100, String r110, int r111, OfficeFolderSource r112, String r113, OfficeFolderPagePayload r114) {
        Intrinsics.checkNotNullParameter(r100, "folderToken");
        Intrinsics.checkNotNullParameter(r110, "folderTitle");
        Intrinsics.checkNotNullParameter(r114, WsConstants.KEY_PAYLOAD);
        return new OfficeFolderPageRequest(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeFolderPageRequest) == true) goto L8;
        return false;
    L8:
        OfficeFolderPageRequest r101 = (OfficeFolderPageRequest) r100;
        if (Intrinsics.areEqual(this.folderToken, r101.folderToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.folderTitle, r101.folderTitle) == true) goto L15;
        return false;
    L15:
        if (this.depth == r101.depth) goto L18;
        return false;
    L18:
        if (this.source == r101.source) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.folderToken.hashCode() * 31) + this.folderTitle.hashCode()) * 31) + this.depth) * 31;
        OfficeFolderSource r101 = this.source;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.traceId;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.payload.hashCode();
    L5:
        r103 = r101.hashCode();
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

    public OfficeFolderPageRequest(String r100, String r101, int r102, OfficeFolderSource r103, String r104, OfficeFolderPagePayload r105) {
        Intrinsics.checkNotNullParameter(r100, "folderToken");
        Intrinsics.checkNotNullParameter(r101, "folderTitle");
        Intrinsics.checkNotNullParameter(r105, WsConstants.KEY_PAYLOAD);
        this.folderToken = r100;
        this.folderTitle = r101;
        this.depth = r102;
        this.source = r103;
        this.traceId = r104;
        this.payload = r105;
    }
}
