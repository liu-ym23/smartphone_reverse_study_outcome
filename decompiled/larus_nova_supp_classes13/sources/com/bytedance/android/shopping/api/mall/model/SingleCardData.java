package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "", "lynxData", "", "lynxSchema", "extra", "skipCache", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getExtra", "()Ljava/lang/String;", "getLynxData", "getLynxSchema", "getSkipCache", "()Z", "setSkipCache", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleCardData {

    @SerializedName("extra")
    private final String extra;

    @SerializedName("lynx_data")
    private final String lynxData;

    @SerializedName("lynx_schema")
    private final String lynxSchema;
    private transient boolean skipCache;

    public SingleCardData() {
        this(null, null, null, false, 15, null);
    }

    public static /* synthetic */ SingleCardData copy$default(SingleCardData r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.lynxData;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.lynxSchema;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.extra;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.skipCache;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.lynxData;
    }

    public final String component2() {
        return this.lynxSchema;
    }

    public final String component3() {
        return this.extra;
    }

    public final boolean component4() {
        return this.skipCache;
    }

    public final SingleCardData copy(String r2, String r3, String r4, boolean r5) {
        return new SingleCardData(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SingleCardData) == false) goto L14;
        SingleCardData r4 = (SingleCardData) r3;
        if (Intrinsics.areEqual(this.lynxData, r4.lynxData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxSchema, r4.lynxSchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L12;
        return false;
    L12:
        if (this.skipCache == r4.skipCache) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.lynxData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.lynxSchema;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.extra;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.skipCache;
        ?? r10 = r9;
        if (r9 == false) goto L17;
        r10 = 1;
    L17:
        return r8 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SingleCardData(lynxData=" + this.lynxData + ", lynxSchema=" + this.lynxSchema + ", extra=" + this.extra + ", skipCache=" + this.skipCache + ")";
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getLynxData() {
        return this.lynxData;
    }

    public final String getLynxSchema() {
        return this.lynxSchema;
    }

    public final boolean getSkipCache() {
        return this.skipCache;
    }

    public final void setSkipCache(boolean r1) {
        this.skipCache = r1;
    }

    public SingleCardData(String r1, String r2, String r3, boolean r4) {
        this.lynxData = r1;
        this.lynxSchema = r2;
        this.extra = r3;
        this.skipCache = r4;
    }

    public /* synthetic */ SingleCardData(String r2, String r3, String r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
