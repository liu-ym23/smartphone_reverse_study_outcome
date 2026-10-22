package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/OpenSchemaParams;", "", "schema", "", "clickTime", "", "entranceInfo", "currentEcomSceneId", "type", "Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;", "addEcomSceneId", "addSpecialEcomSceneId", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;Ljava/lang/String;Ljava/lang/String;)V", "getAddEcomSceneId", "()Ljava/lang/String;", "getAddSpecialEcomSceneId", "getClickTime", "()J", "getCurrentEcomSceneId", "getEntranceInfo", "getSchema", "getType", "()Lcom/bytedance/android/shopping/mall/homepage/tools/EcomSceneIdUrlType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenSchemaParams {
    private final String addEcomSceneId;
    private final String addSpecialEcomSceneId;
    private final long clickTime;
    private final String currentEcomSceneId;
    private final String entranceInfo;
    private final String schema;
    private final EcomSceneIdUrlType type;

    public static /* synthetic */ OpenSchemaParams copy$default(OpenSchemaParams r9, String r10, long r11, String r13, String r14, EcomSceneIdUrlType r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.schema;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r2 = r9.clickTime;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.entranceInfo;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.currentEcomSceneId;
    L19:
        if ((r18 & 16) == 0) goto L21;
        EcomSceneIdUrlType r6 = r9.type;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.addEcomSceneId;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.addSpecialEcomSceneId;
    L31:
        return r9.copy(r1, r2, r4, r5, r6, r7, r8);
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
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.schema;
    }

    public final long component2() {
        return this.clickTime;
    }

    public final String component3() {
        return this.entranceInfo;
    }

    public final String component4() {
        return this.currentEcomSceneId;
    }

    public final EcomSceneIdUrlType component5() {
        return this.type;
    }

    public final String component6() {
        return this.addEcomSceneId;
    }

    public final String component7() {
        return this.addSpecialEcomSceneId;
    }

    public final OpenSchemaParams copy(String r11, long r12, String r14, String r15, EcomSceneIdUrlType r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "schema");
        Intrinsics.checkNotNullParameter(r16, "type");
        return new OpenSchemaParams(r11, r12, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof OpenSchemaParams) == false) goto L20;
        OpenSchemaParams r7 = (OpenSchemaParams) r6;
        if (Intrinsics.areEqual(this.schema, r7.schema) == true) goto L8;
        return false;
    L8:
        if (this.clickTime == r7.clickTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.entranceInfo, r7.entranceInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentEcomSceneId, r7.currentEcomSceneId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.type, r7.type) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.addEcomSceneId, r7.addEcomSceneId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.addSpecialEcomSceneId, r7.addSpecialEcomSceneId) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.schema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.clickTime;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.entranceInfo;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.currentEcomSceneId;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        EcomSceneIdUrlType r11 = this.type;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.addEcomSceneId;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.addSpecialEcomSceneId;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "OpenSchemaParams(schema=" + this.schema + ", clickTime=" + this.clickTime + ", entranceInfo=" + this.entranceInfo + ", currentEcomSceneId=" + this.currentEcomSceneId + ", type=" + this.type + ", addEcomSceneId=" + this.addEcomSceneId + ", addSpecialEcomSceneId=" + this.addSpecialEcomSceneId + ")";
    }

    public final String getAddEcomSceneId() {
        return this.addEcomSceneId;
    }

    public final String getAddSpecialEcomSceneId() {
        return this.addSpecialEcomSceneId;
    }

    public final long getClickTime() {
        return this.clickTime;
    }

    public final String getCurrentEcomSceneId() {
        return this.currentEcomSceneId;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final EcomSceneIdUrlType getType() {
        return this.type;
    }

    public OpenSchemaParams(String r2, long r3, String r5, String r6, EcomSceneIdUrlType r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r7, "type");
        this.schema = r2;
        this.clickTime = r3;
        this.entranceInfo = r5;
        this.currentEcomSceneId = r6;
        this.type = r7;
        this.addEcomSceneId = r8;
        this.addSpecialEcomSceneId = r9;
    }

    public /* synthetic */ OpenSchemaParams(String r11, long r12, String r14, String r15, EcomSceneIdUrlType r16, String r17, String r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 16) == 0) goto L5;
        EcomSceneIdUrlType r7 = EcomSceneIdUrlType.URL;
    L7:
        if ((r19 & 32) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r19 & 64) == 0) goto L13;
        String r9 = null;
    L14:
        this(r11, r12, r14, r15, r7, r8, r9);
        return;
    L13:
        r9 = r18;
        goto L14
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }
}
