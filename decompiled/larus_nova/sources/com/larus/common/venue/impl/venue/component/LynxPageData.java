package com.larus.common.venue.impl.venue.component;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003Jk\u0010!\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006'"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/LynxPageData;", "", "pocketPageData", "", "", "inputTopToBottomHeight", "", "clickActionBarTimeMs", "", "schemaHandleTimeMs", "traceInfo", "sourceSchema", "stage", "<init>", "(Ljava/util/Map;IJJLjava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getPocketPageData", "()Ljava/util/Map;", "getInputTopToBottomHeight", "()I", "getClickActionBarTimeMs", "()J", "getSchemaHandleTimeMs", "getTraceInfo", "getSourceSchema", "()Ljava/lang/String;", "getStage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxPageData {
    private final long clickActionBarTimeMs;
    private final int inputTopToBottomHeight;
    private final Map<String, Object> pocketPageData;
    private final long schemaHandleTimeMs;
    private final String sourceSchema;
    private final String stage;
    private final Map<String, Object> traceInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxPageData copy$default(LynxPageData r110, Map r111, int r112, long r113, long r114, Map r115, String r116, String r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Map r100 = r110.pocketPageData;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.inputTopToBottomHeight;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.clickActionBarTimeMs;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.schemaHandleTimeMs;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Map r104 = r110.traceInfo;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.sourceSchema;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.stage;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
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

    public final Map<String, Object> component1() {
        return this.pocketPageData;
    }

    public final int component2() {
        return this.inputTopToBottomHeight;
    }

    public final long component3() {
        return this.clickActionBarTimeMs;
    }

    public final long component4() {
        return this.schemaHandleTimeMs;
    }

    public final Map<String, Object> component5() {
        return this.traceInfo;
    }

    public final String component6() {
        return this.sourceSchema;
    }

    public final String component7() {
        return this.stage;
    }

    public final LynxPageData copy(Map<String, ? extends Object> r110, int r111, long r112, long r113, Map<String, ? extends Object> r114, String r115, String r210) {
        Intrinsics.checkNotNullParameter(r110, "pocketPageData");
        Intrinsics.checkNotNullParameter(r114, "traceInfo");
        Intrinsics.checkNotNullParameter(r115, "sourceSchema");
        Intrinsics.checkNotNullParameter(r210, "stage");
        return new LynxPageData(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LynxPageData) == true) goto L8;
        return false;
    L8:
        LynxPageData r101 = (LynxPageData) r100;
        if (Intrinsics.areEqual(this.pocketPageData, r101.pocketPageData) == true) goto L12;
        return false;
    L12:
        if (this.inputTopToBottomHeight == r101.inputTopToBottomHeight) goto L15;
        return false;
    L15:
        if (this.clickActionBarTimeMs == r101.clickActionBarTimeMs) goto L18;
        return false;
    L18:
        if (this.schemaHandleTimeMs == r101.schemaHandleTimeMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceInfo, r101.traceInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourceSchema, r101.sourceSchema) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.stage, r101.stage) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.pocketPageData.hashCode() * 31) + this.inputTopToBottomHeight) * 31;
        long r101 = this.clickActionBarTimeMs;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.schemaHandleTimeMs;
        return ((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.traceInfo.hashCode()) * 31) + this.sourceSchema.hashCode()) * 31) + this.stage.hashCode();
    }

    public String toString() {
        return "LynxPageData(pocketPageData=" + this.pocketPageData + ", inputTopToBottomHeight=" + this.inputTopToBottomHeight + ", clickActionBarTimeMs=" + this.clickActionBarTimeMs + ", schemaHandleTimeMs=" + this.schemaHandleTimeMs + ", traceInfo=" + this.traceInfo + ", sourceSchema=" + this.sourceSchema + ", stage=" + this.stage + ')';
    }

    public final long getClickActionBarTimeMs() {
        return this.clickActionBarTimeMs;
    }

    public final int getInputTopToBottomHeight() {
        return this.inputTopToBottomHeight;
    }

    public final Map<String, Object> getPocketPageData() {
        return this.pocketPageData;
    }

    public final long getSchemaHandleTimeMs() {
        return this.schemaHandleTimeMs;
    }

    public final String getSourceSchema() {
        return this.sourceSchema;
    }

    public final String getStage() {
        return this.stage;
    }

    public final Map<String, Object> getTraceInfo() {
        return this.traceInfo;
    }

    public LynxPageData(Map<String, ? extends Object> r100, int r101, long r102, long r103, Map<String, ? extends Object> r104, String r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, "pocketPageData");
        Intrinsics.checkNotNullParameter(r104, "traceInfo");
        Intrinsics.checkNotNullParameter(r105, "sourceSchema");
        Intrinsics.checkNotNullParameter(r110, "stage");
        this.pocketPageData = r100;
        this.inputTopToBottomHeight = r101;
        this.clickActionBarTimeMs = r102;
        this.schemaHandleTimeMs = r103;
        this.traceInfo = r104;
        this.sourceSchema = r105;
        this.stage = r110;
    }

    public /* synthetic */ LynxPageData(Map r110, int r111, long r112, long r113, Map r114, String r115, String r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        Map r100 = MapsKt.emptyMap();
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r211 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r103 = 0;
    L19:
        if ((r211 & 16) == 0) goto L21;
        Map r104 = MapsKt.emptyMap();
    L22:
        this(r100, r101, r102, r103, r104, r115, r210);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
