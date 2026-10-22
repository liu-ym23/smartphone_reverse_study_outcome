package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationMeta;", "Ljava/io/Serializable;", "trackMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;", "businessMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;)V", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "getTrackMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationMeta implements Serializable {

    @SerializedName("business_meta")
    private final AnchorV4KolEvaluationBusinessMeta businessMeta;

    @SerializedName("track_meta")
    private final AnchorV4KolEvaluationTrackMeta trackMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4KolEvaluationMeta() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4KolEvaluationMeta copy$default(AnchorV4KolEvaluationMeta r0, AnchorV4KolEvaluationTrackMeta r1, AnchorV4KolEvaluationBusinessMeta r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.trackMeta;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.businessMeta;
    L9:
        return r0.copy(r1, r2);
    }

    public final AnchorV4KolEvaluationTrackMeta component1() {
        return this.trackMeta;
    }

    public final AnchorV4KolEvaluationBusinessMeta component2() {
        return this.businessMeta;
    }

    public final AnchorV4KolEvaluationMeta copy(AnchorV4KolEvaluationTrackMeta r2, AnchorV4KolEvaluationBusinessMeta r3) {
        return new AnchorV4KolEvaluationMeta(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4KolEvaluationMeta) == false) goto L10;
        AnchorV4KolEvaluationMeta r4 = (AnchorV4KolEvaluationMeta) r3;
        if (Intrinsics.areEqual(this.trackMeta, r4.trackMeta) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.businessMeta, r4.businessMeta) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        AnchorV4KolEvaluationTrackMeta r0 = this.trackMeta;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4KolEvaluationBusinessMeta r4 = this.businessMeta;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4KolEvaluationMeta(trackMeta=" + this.trackMeta + ", businessMeta=" + this.businessMeta + ")";
    }

    public final AnchorV4KolEvaluationBusinessMeta getBusinessMeta() {
        return this.businessMeta;
    }

    public final AnchorV4KolEvaluationTrackMeta getTrackMeta() {
        return this.trackMeta;
    }

    public AnchorV4KolEvaluationMeta(AnchorV4KolEvaluationTrackMeta r1, AnchorV4KolEvaluationBusinessMeta r2) {
        this.trackMeta = r1;
        this.businessMeta = r2;
    }

    public /* synthetic */ AnchorV4KolEvaluationMeta(AnchorV4KolEvaluationTrackMeta r2, AnchorV4KolEvaluationBusinessMeta r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
