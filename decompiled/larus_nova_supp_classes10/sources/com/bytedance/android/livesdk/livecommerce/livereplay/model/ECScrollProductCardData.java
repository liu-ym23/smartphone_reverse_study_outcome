package com.bytedance.android.livesdk.livecommerce.livereplay.model;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/model/ECScrollProductCardData;", "Ljava/io/Serializable;", "promotion", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "explainStartTime", "", "explainEndTime", "isGenera", "", "(Lcom/bytedance/android/ec/model/response/ECPromotion;JJZ)V", "getExplainEndTime", "()J", "getExplainStartTime", "()Z", "getPromotion", "()Lcom/bytedance/android/ec/model/response/ECPromotion;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardData implements Serializable {

    @SerializedName("explain_end_time")
    private final long explainEndTime;

    @SerializedName("explain_start_time")
    private final long explainStartTime;

    @SerializedName("is_genera")
    private final boolean isGenera;

    @SerializedName("promotion")
    private final ECPromotion promotion;

    public ECScrollProductCardData() {
        this(null, 0, 0, false, 15, null);
    }

    public static /* synthetic */ ECScrollProductCardData copy$default(ECScrollProductCardData r4, ECPromotion r5, long r6, long r8, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.promotion;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.explainStartTime;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.explainEndTime;
    L11:
        long r2 = r8;
        if ((r11 & 8) == 0) goto L14;
        r10 = r4.isGenera;
    L14:
        ECPromotion r7 = r5;
        return r4.copy(r7, r0, r2, r10);
    }

    public final ECPromotion component1() {
        return this.promotion;
    }

    public final long component2() {
        return this.explainStartTime;
    }

    public final long component3() {
        return this.explainEndTime;
    }

    public final boolean component4() {
        return this.isGenera;
    }

    public final ECScrollProductCardData copy(ECPromotion r9, long r10, long r12, boolean r14) {
        return new ECScrollProductCardData(r9, r10, r12, r14);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ECScrollProductCardData) == false) goto L14;
        ECScrollProductCardData r7 = (ECScrollProductCardData) r6;
        if (Intrinsics.areEqual(this.promotion, r7.promotion) == true) goto L8;
        return false;
    L8:
        if (this.explainStartTime == r7.explainStartTime) goto L10;
        return false;
    L10:
        if (this.explainEndTime == r7.explainEndTime) goto L12;
        return false;
    L12:
        if (this.isGenera == r7.isGenera) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        ECPromotion r0 = this.promotion;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.explainStartTime;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.explainEndTime;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        boolean r6 = this.isGenera;
        ?? r7 = r6;
        if (r6 == false) goto L10;
        r7 = 1;
    L10:
        return r5 + r7;
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "ECScrollProductCardData(promotion=" + this.promotion + ", explainStartTime=" + this.explainStartTime + ", explainEndTime=" + this.explainEndTime + ", isGenera=" + this.isGenera + ")";
    }

    public final long getExplainEndTime() {
        return this.explainEndTime;
    }

    public final long getExplainStartTime() {
        return this.explainStartTime;
    }

    public final ECPromotion getPromotion() {
        return this.promotion;
    }

    public final boolean isGenera() {
        return this.isGenera;
    }

    public ECScrollProductCardData(ECPromotion r1, long r2, long r4, boolean r6) {
        this.promotion = r1;
        this.explainStartTime = r2;
        this.explainEndTime = r4;
        this.isGenera = r6;
    }

    public /* synthetic */ ECScrollProductCardData(ECPromotion r5, long r6, long r8, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = null;
    L5:
        long r0 = 0;
        if ((r11 & 2) == 0) goto L8;
        long r2 = 0;
    L10:
        if ((r11 & 4) != 0) goto L14;
        r0 = r8;
    L14:
        if ((r11 & 8) == 0) goto L16;
        boolean r13 = false;
    L17:
        this(r5, r2, r0, r13);
        return;
    L16:
        r13 = r10;
        goto L17
    L8:
        r2 = r6;
        goto L10
    }
}
