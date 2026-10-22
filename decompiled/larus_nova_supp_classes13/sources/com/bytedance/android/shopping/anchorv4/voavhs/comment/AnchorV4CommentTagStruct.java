package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentTagStruct;", "Ljava/io/Serializable;", "stateId", "", "isImpressionTag", "", "(JZ)V", "()Z", "getStateId", "()J", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentTagStruct implements Serializable {

    @SerializedName("is_impressing_tag")
    private final boolean isImpressionTag;

    @SerializedName("state_id")
    private final long stateId;

    public AnchorV4CommentTagStruct() {
        this(0, false, 3, null);
    }

    public static /* synthetic */ AnchorV4CommentTagStruct copy$default(AnchorV4CommentTagStruct r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.stateId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.isImpressionTag;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.stateId;
    }

    public final boolean component2() {
        return this.isImpressionTag;
    }

    public final AnchorV4CommentTagStruct copy(long r2, boolean r4) {
        return new AnchorV4CommentTagStruct(r2, r4);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof AnchorV4CommentTagStruct) == false) goto L10;
        AnchorV4CommentTagStruct r7 = (AnchorV4CommentTagStruct) r6;
        if (this.stateId == r7.stateId) goto L8;
        return false;
    L8:
        if (this.isImpressionTag == r7.isImpressionTag) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public int hashCode() {
        long r0 = this.stateId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        boolean r2 = this.isImpressionTag;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r1 + r3;
    }

    public String toString() {
        return "AnchorV4CommentTagStruct(stateId=" + this.stateId + ", isImpressionTag=" + this.isImpressionTag + ")";
    }

    public final long getStateId() {
        return this.stateId;
    }

    public final boolean isImpressionTag() {
        return this.isImpressionTag;
    }

    public AnchorV4CommentTagStruct(long r1, boolean r3) {
        this.stateId = r1;
        this.isImpressionTag = r3;
    }

    public /* synthetic */ AnchorV4CommentTagStruct(long r1, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r1, r3);
    }
}
