package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003JG\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "", "bcmEmId", "", "bcmEm", "emData", "extra", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;)V", "getBcmEm", "()Ljava/lang/String;", "getBcmEmId", "getEmData", "()Ljava/lang/Object;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getBcmMap", "", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Bcm {

    @SerializedName("bcm_em")
    private final String bcmEm;

    @SerializedName("bcm_em_id")
    private final String bcmEmId;

    @SerializedName("em_data")
    private final Object emData;

    @SerializedName("extra")
    private final Map<String, Object> extra;

    public Bcm() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Bcm copy$default(Bcm r0, String r1, String r2, Object r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.bcmEmId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.bcmEm;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.emData;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extra;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.bcmEmId;
    }

    public final String component2() {
        return this.bcmEm;
    }

    public final Object component3() {
        return this.emData;
    }

    public final Map<String, Object> component4() {
        return this.extra;
    }

    public final Bcm copy(String r2, String r3, Object r4, Map<String, ? extends Object> r5) {
        return new Bcm(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Bcm) == false) goto L14;
        Bcm r4 = (Bcm) r3;
        if (Intrinsics.areEqual(this.bcmEmId, r4.bcmEmId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bcmEm, r4.bcmEm) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.emData, r4.emData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.bcmEmId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.bcmEm;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Object r7 = this.emData;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, Object> r10 = this.extra;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "Bcm(bcmEmId=" + this.bcmEmId + ", bcmEm=" + this.bcmEm + ", emData=" + this.emData + ", extra=" + this.extra + ")";
    }

    public final Map<String, Object> getBcmMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = this.bcmEmId;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        r0.put("bcm_em_id", this.bcmEmId);
    L11:
        String r4 = this.bcmEm;
        if (r4 != null) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == true) goto L18;
        r0.put("bcm_em", this.bcmEm);
    L18:
        Object r5 = this.emData;
        if (r5 == null) goto L21;
        r0.put("em_data", r5);
    L21:
        Map<String, Object> r6 = this.extra;
        if (r6 == null) goto L24;
        r0.put("extra", r6);
    L24:
        return r0;
    L14:
        if (r4.length() != 0) goto L16;
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final String getBcmEm() {
        return this.bcmEm;
    }

    public final String getBcmEmId() {
        return this.bcmEmId;
    }

    public final Object getEmData() {
        return this.emData;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public Bcm(String r1, String r2, Object r3, Map<String, ? extends Object> r4) {
        this.bcmEmId = r1;
        this.bcmEm = r2;
        this.emData = r3;
        this.extra = r4;
    }

    public /* synthetic */ Bcm(String r2, String r3, Object r4, Map r5, int r6, DefaultConstructorMarker r7) {
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
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
