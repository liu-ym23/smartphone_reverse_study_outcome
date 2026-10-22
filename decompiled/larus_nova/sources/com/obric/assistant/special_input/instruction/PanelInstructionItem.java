package com.obric.assistant.special_input.instruction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JU\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "", "id", "", "displayText", "sendText", "type", "Lcom/obric/assistant/special_input/instruction/PanelInstructionType;", "reason", "sourceData", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/special_input/instruction/PanelInstructionType;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getDisplayText", "getSendText", "getType", "()Lcom/obric/assistant/special_input/instruction/PanelInstructionType;", "getReason", "getSourceData", "getCreateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelInstructionItem {
    private final long createTime;
    private final String displayText;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f392730id;
    private final String reason;
    private final String sendText;
    private final String sourceData;
    private final PanelInstructionType type;

    public static /* synthetic */ PanelInstructionItem copy$default(PanelInstructionItem r100, String r110, String r111, String r112, PanelInstructionType r113, String r114, String r115, long r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.f392730id;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.displayText;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.sendText;
    L15:
        if ((r117 & 8) == 0) goto L17;
        PanelInstructionType r104 = r100.type;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.reason;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.sourceData;
    L27:
        if ((r117 & 64) == 0) goto L29;
        long r107 = r100.createTime;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
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

    public final String component1() {
        return this.f392730id;
    }

    public final String component2() {
        return this.displayText;
    }

    public final String component3() {
        return this.sendText;
    }

    public final PanelInstructionType component4() {
        return this.type;
    }

    public final String component5() {
        return this.reason;
    }

    public final String component6() {
        return this.sourceData;
    }

    public final long component7() {
        return this.createTime;
    }

    public final PanelInstructionItem copy(String r110, String r111, String r112, PanelInstructionType r113, String r114, String r115, long r116) {
        Intrinsics.checkNotNullParameter(r111, "displayText");
        Intrinsics.checkNotNullParameter(r112, "sendText");
        Intrinsics.checkNotNullParameter(r113, "type");
        return new PanelInstructionItem(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PanelInstructionItem) == true) goto L8;
        return false;
    L8:
        PanelInstructionItem r101 = (PanelInstructionItem) r100;
        if (Intrinsics.areEqual(this.f392730id, r101.f392730id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sendText, r101.sendText) == true) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourceData, r101.sourceData) == true) goto L27;
        return false;
    L27:
        if (this.createTime == r101.createTime) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.f392730id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.displayText.hashCode()) * 31) + this.sendText.hashCode()) * 31) + this.type.hashCode()) * 31;
        String r104 = this.reason;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sourceData;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        long r109 = this.createTime;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PanelInstructionItem(id=" + this.f392730id + ", displayText=" + this.displayText + ", sendText=" + this.sendText + ", type=" + this.type + ", reason=" + this.reason + ", sourceData=" + this.sourceData + ", createTime=" + this.createTime + ')';
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final String getId() {
        return this.f392730id;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSendText() {
        return this.sendText;
    }

    public final String getSourceData() {
        return this.sourceData;
    }

    public final PanelInstructionType getType() {
        return this.type;
    }

    public PanelInstructionItem(String r100, String r101, String r102, PanelInstructionType r103, String r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r101, "displayText");
        Intrinsics.checkNotNullParameter(r102, "sendText");
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f392730id = r100;
        this.displayText = r101;
        this.sendText = r102;
        this.type = r103;
        this.reason = r104;
        this.sourceData = r105;
        this.createTime = r106;
    }

    public /* synthetic */ PanelInstructionItem(String r110, String r111, String r112, PanelInstructionType r113, String r114, String r115, long r116, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r210 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r210 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r210 & 64) == 0) goto L17;
        long r103 = 0;
    L18:
        this(r100, r111, r112, r113, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
