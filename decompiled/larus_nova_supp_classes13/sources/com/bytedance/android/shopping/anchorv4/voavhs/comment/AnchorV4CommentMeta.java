package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMeta;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "component2", "trackMeta", "businessMeta", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "getTrackMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentMeta implements Serializable {

    @SerializedName("business_meta")
    private final AnchorV4CommentBusinessMeta businessMeta;

    @SerializedName("track_meta")
    private final d trackMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4CommentMeta() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4CommentMeta copy$default(AnchorV4CommentMeta r0, d r1, AnchorV4CommentBusinessMeta r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.trackMeta;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.businessMeta;
    L9:
        return r0.copy(r1, r2);
    }

    public final d component1() {
        return this.trackMeta;
    }

    public final AnchorV4CommentBusinessMeta component2() {
        return this.businessMeta;
    }

    public final AnchorV4CommentMeta copy(d r2, AnchorV4CommentBusinessMeta r3) {
        return new AnchorV4CommentMeta(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4CommentMeta) == false) goto L10;
        AnchorV4CommentMeta r4 = (AnchorV4CommentMeta) r3;
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
        d r0 = this.trackMeta;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AnchorV4CommentBusinessMeta r4 = this.businessMeta;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4CommentMeta(trackMeta=" + this.trackMeta + ", businessMeta=" + this.businessMeta + ")";
    }

    public final AnchorV4CommentBusinessMeta getBusinessMeta() {
        return this.businessMeta;
    }

    public final d getTrackMeta() {
        return this.trackMeta;
    }

    public AnchorV4CommentMeta(d r1, AnchorV4CommentBusinessMeta r2) {
        this.trackMeta = r1;
        this.businessMeta = r2;
    }

    public /* synthetic */ AnchorV4CommentMeta(d r2, AnchorV4CommentBusinessMeta r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
