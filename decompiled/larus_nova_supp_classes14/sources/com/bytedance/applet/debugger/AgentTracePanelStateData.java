package com.bytedance.applet.debugger;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applet/debugger/AgentTracePanelStateData;", "Lcom/bytedance/applet/debugger/AgentTracePanelPayload;", "schemaVersion", "", "messageId", "", "sectionId", "traceId", "status", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSchemaVersion", "()I", "getMessageId", "()Ljava/lang/String;", "getSectionId", "getTraceId", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentTracePanelStateData {
    private final String messageId;
    private final int schemaVersion;
    private final String sectionId;
    private final String status;
    private final String traceId;

    public static /* synthetic */ AgentTracePanelStateData copy$default(AgentTracePanelStateData r3, int r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.schemaVersion;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.messageId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.sectionId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.traceId;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.status;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.schemaVersion;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.sectionId;
    }

    public final String component4() {
        return this.traceId;
    }

    public final String component5() {
        return this.status;
    }

    public final AgentTracePanelStateData copy(int r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "messageId");
        Intrinsics.checkNotNullParameter(r10, "sectionId");
        Intrinsics.checkNotNullParameter(r11, "traceId");
        Intrinsics.checkNotNullParameter(r12, "status");
        return new AgentTracePanelStateData(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AgentTracePanelStateData) == true) goto L8;
        return false;
    L8:
        AgentTracePanelStateData r6 = (AgentTracePanelStateData) r5;
        if (this.schemaVersion == r6.schemaVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sectionId, r6.sectionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.schemaVersion * 31) + this.messageId.hashCode()) * 31) + this.sectionId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "AgentTracePanelStateData(schemaVersion=" + this.schemaVersion + ", messageId=" + this.messageId + ", sectionId=" + this.sectionId + ", traceId=" + this.traceId + ", status=" + this.status + ')';
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public AgentTracePanelStateData(int r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "sectionId");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r6, "status");
        this.schemaVersion = r2;
        this.messageId = r3;
        this.sectionId = r4;
        this.traceId = r5;
        this.status = r6;
    }

    public /* synthetic */ AgentTracePanelStateData(int r7, String r8, String r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        int r1 = 1;
    L6:
        this(r1, r8, r9, r10, r11);
        return;
    L5:
        r1 = r7;
        goto L6
    }
}
