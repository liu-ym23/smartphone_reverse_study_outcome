package com.bytedance.android.shopping.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/dto/PromotionVisitor;", "Ljava/io/Serializable;", "avatars", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "count", "", "(Ljava/util/List;J)V", "getAvatars", "()Ljava/util/List;", "setAvatars", "(Ljava/util/List;)V", "getCount", "()J", "setCount", "(J)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionVisitor implements Serializable {

    @SerializedName("avatar")
    private List<? extends ECUrlModel> avatars;

    @SerializedName("count")
    private long count;

    public PromotionVisitor() {
        this(null, 0, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionVisitor copy$default(PromotionVisitor r0, List r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.avatars;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.count;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<ECUrlModel> component1() {
        return this.avatars;
    }

    public final long component2() {
        return this.count;
    }

    public final PromotionVisitor copy(List<? extends ECUrlModel> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "avatars");
        return new PromotionVisitor(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof PromotionVisitor) == false) goto L10;
        PromotionVisitor r6 = (PromotionVisitor) r5;
        if (Intrinsics.areEqual(this.avatars, r6.avatars) == true) goto L8;
        return false;
    L8:
        if (this.count == r6.count) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<? extends ECUrlModel> r0 = this.avatars;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.count;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionVisitor(avatars=" + this.avatars + ", count=" + this.count + ")";
    }

    public final List<ECUrlModel> getAvatars() {
        return this.avatars;
    }

    public final long getCount() {
        return this.count;
    }

    public final void setAvatars(List<? extends ECUrlModel> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.avatars = r2;
    }

    public final void setCount(long r1) {
        this.count = r1;
    }

    public PromotionVisitor(List<? extends ECUrlModel> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "avatars");
        this.avatars = r2;
        this.count = r3;
    }

    public /* synthetic */ PromotionVisitor(List r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
