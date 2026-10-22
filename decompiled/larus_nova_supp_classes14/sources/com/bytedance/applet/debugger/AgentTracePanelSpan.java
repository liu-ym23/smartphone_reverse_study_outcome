package com.bytedance.applet.debugger;

import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003Jd\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bytedance/applet/debugger/AgentTracePanelSpan;", "", "id", "", "type", "name", "source", "startedAtMs", "", "durationMs", "input", "Lcom/google/gson/JsonElement;", "output", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getSource", "getStartedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDurationMs", "getInput", "()Lcom/google/gson/JsonElement;", "getOutput", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)Lcom/bytedance/applet/debugger/AgentTracePanelSpan;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentTracePanelSpan {
    private final Long durationMs;
    private final String id;
    private final JsonElement input;
    private final String name;
    private final JsonElement output;
    private final String source;
    private final Long startedAtMs;
    private final String type;

    public static /* synthetic */ AgentTracePanelSpan copy$default(AgentTracePanelSpan r9, String r10, String r11, String r12, String r13, Long r14, Long r15, JsonElement r16, JsonElement r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.type;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.name;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.source;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Long r6 = r9.startedAtMs;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Long r7 = r9.durationMs;
    L27:
        if ((r18 & 64) == 0) goto L29;
        JsonElement r8 = r9.input;
    L31:
        if ((r18 & 128) == 0) goto L33;
        JsonElement r1 = r9.output;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.source;
    }

    public final Long component5() {
        return this.startedAtMs;
    }

    public final Long component6() {
        return this.durationMs;
    }

    public final JsonElement component7() {
        return this.input;
    }

    public final JsonElement component8() {
        return this.output;
    }

    public final AgentTracePanelSpan copy(String r11, String r12, String r13, String r14, Long r15, Long r16, JsonElement r17, JsonElement r18) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r14, "source");
        Intrinsics.checkNotNullParameter(r17, "input");
        Intrinsics.checkNotNullParameter(r18, "output");
        return new AgentTracePanelSpan(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AgentTracePanelSpan) == true) goto L8;
        return false;
    L8:
        AgentTracePanelSpan r6 = (AgentTracePanelSpan) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.startedAtMs, r6.startedAtMs) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.durationMs, r6.durationMs) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.input, r6.input) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.output, r6.output) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String r1 = this.name;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.source.hashCode()) * 31;
        Long r5 = this.startedAtMs;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.durationMs;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((r7 + r2) * 31) + this.input.hashCode()) * 31) + this.output.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AgentTracePanelSpan(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", source=" + this.source + ", startedAtMs=" + this.startedAtMs + ", durationMs=" + this.durationMs + ", input=" + this.input + ", output=" + this.output + ')';
    }

    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final String getId() {
        return this.id;
    }

    public final JsonElement getInput() {
        return this.input;
    }

    public final String getName() {
        return this.name;
    }

    public final JsonElement getOutput() {
        return this.output;
    }

    public final String getSource() {
        return this.source;
    }

    public final Long getStartedAtMs() {
        return this.startedAtMs;
    }

    public final String getType() {
        return this.type;
    }

    public AgentTracePanelSpan(String r2, String r3, String r4, String r5, Long r6, Long r7, JsonElement r8, JsonElement r9) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r8, "input");
        Intrinsics.checkNotNullParameter(r9, "output");
        this.id = r2;
        this.type = r3;
        this.name = r4;
        this.source = r5;
        this.startedAtMs = r6;
        this.durationMs = r7;
        this.input = r8;
        this.output = r9;
    }
}
