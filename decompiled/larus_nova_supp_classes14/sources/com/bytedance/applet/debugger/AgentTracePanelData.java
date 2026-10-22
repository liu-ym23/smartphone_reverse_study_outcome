package com.bytedance.applet.debugger;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Ji\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006/"}, d2 = {"Lcom/bytedance/applet/debugger/AgentTracePanelData;", "Lcom/bytedance/applet/debugger/AgentTracePanelPayload;", "schemaVersion", "", "messageId", "", "sectionId", "traceId", "status", "durationMs", "", "input", "spans", "", "Lcom/bytedance/applet/debugger/AgentTracePanelSpan;", "output", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getSchemaVersion", "()I", "getMessageId", "()Ljava/lang/String;", "getSectionId", "getTraceId", "getStatus", "getDurationMs", "()J", "getInput", "getSpans", "()Ljava/util/List;", "getOutput", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentTracePanelData {
    private final long durationMs;
    private final String input;
    private final String messageId;
    private final String output;
    private final int schemaVersion;
    private final String sectionId;
    private final List<AgentTracePanelSpan> spans;
    private final String status;
    private final String traceId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AgentTracePanelData copy$default(AgentTracePanelData r11, int r12, String r13, String r14, String r15, String r16, long r17, String r19, List r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        int r2 = r11.schemaVersion;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.messageId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.sectionId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.traceId;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.status;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r7 = r11.durationMs;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r9 = r11.input;
    L31:
        if ((r22 & 128) == 0) goto L33;
        List r10 = r11.spans;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r1 = r11.output;
    L39:
        return r11.copy(r2, r3, r4, r5, r6, r7, r9, r10, r1);
    L37:
        r1 = r21;
        goto L39
    L33:
        r10 = r20;
        goto L35
    L29:
        r9 = r19;
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

    public final long component6() {
        return this.durationMs;
    }

    public final String component7() {
        return this.input;
    }

    public final List<AgentTracePanelSpan> component8() {
        return this.spans;
    }

    public final String component9() {
        return this.output;
    }

    public final AgentTracePanelData copy(int r13, String r14, String r15, String r16, String r17, long r18, String r20, List<AgentTracePanelSpan> r21, String r22) {
        Intrinsics.checkNotNullParameter(r14, "messageId");
        Intrinsics.checkNotNullParameter(r15, "sectionId");
        Intrinsics.checkNotNullParameter(r16, "traceId");
        Intrinsics.checkNotNullParameter(r17, "status");
        Intrinsics.checkNotNullParameter(r20, "input");
        Intrinsics.checkNotNullParameter(r21, "spans");
        Intrinsics.checkNotNullParameter(r22, "output");
        return new AgentTracePanelData(r13, r14, r15, r16, r17, r18, r20, r21, r22);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AgentTracePanelData) == true) goto L8;
        return false;
    L8:
        AgentTracePanelData r9 = (AgentTracePanelData) r8;
        if (this.schemaVersion == r9.schemaVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r9.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sectionId, r9.sectionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.traceId, r9.traceId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.status, r9.status) == true) goto L24;
        return false;
    L24:
        if (this.durationMs == r9.durationMs) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.input, r9.input) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.spans, r9.spans) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.output, r9.output) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.schemaVersion * 31) + this.messageId.hashCode()) * 31) + this.sectionId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.status.hashCode()) * 31;
        long r1 = this.durationMs;
        return ((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.input.hashCode()) * 31) + this.spans.hashCode()) * 31) + this.output.hashCode();
    }

    public String toString() {
        return "AgentTracePanelData(schemaVersion=" + this.schemaVersion + ", messageId=" + this.messageId + ", sectionId=" + this.sectionId + ", traceId=" + this.traceId + ", status=" + this.status + ", durationMs=" + this.durationMs + ", input=" + this.input + ", spans=" + this.spans + ", output=" + this.output + ')';
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getInput() {
        return this.input;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getOutput() {
        return this.output;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final List<AgentTracePanelSpan> getSpans() {
        return this.spans;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public AgentTracePanelData(int r2, String r3, String r4, String r5, String r6, long r7, String r9, List<AgentTracePanelSpan> r10, String r11) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "sectionId");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r6, "status");
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r10, "spans");
        Intrinsics.checkNotNullParameter(r11, "output");
        this.schemaVersion = r2;
        this.messageId = r3;
        this.sectionId = r4;
        this.traceId = r5;
        this.status = r6;
        this.durationMs = r7;
        this.input = r9;
        this.spans = r10;
        this.output = r11;
    }

    public /* synthetic */ AgentTracePanelData(int r13, String r14, String r15, String r16, String r17, long r18, String r20, List r21, String r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 1) == 0) goto L5;
        int r2 = 1;
    L7:
        if ((r23 & 16) == 0) goto L9;
        String r6 = "completed";
    L10:
        this(r2, r14, r15, r16, r6, r18, r20, r21, r22);
        return;
    L9:
        r6 = r17;
        goto L10
    L5:
        r2 = r13;
        goto L7
    }
}
