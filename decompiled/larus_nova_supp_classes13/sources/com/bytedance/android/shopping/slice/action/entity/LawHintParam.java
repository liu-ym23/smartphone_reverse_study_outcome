package com.bytedance.android.shopping.slice.action.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/LawHintParam;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Long;", "promotionSource", "copy", "(Ljava/lang/Long;)Lcom/bytedance/android/shopping/slice/action/entity/LawHintParam;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Long;", "getPromotionSource", "<init>", "(Ljava/lang/Long;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LawHintParam implements Serializable {
    public static final a Companion = null;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final Long promotionSource;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LawHintParam() {
        Long r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ LawHintParam copy$default(LawHintParam r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.promotionSource;
    L6:
        return r0.copy(r1);
    }

    public final Long component1() {
        return this.promotionSource;
    }

    public final LawHintParam copy(Long r2) {
        return new LawHintParam(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof LawHintParam) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.promotionSource, ((LawHintParam) r2).promotionSource) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Long r0 = this.promotionSource;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "LawHintParam(promotionSource=" + this.promotionSource + ")";
    }

    public final Long getPromotionSource() {
        return this.promotionSource;
    }

    public LawHintParam(Long r1) {
        this.promotionSource = r1;
    }

    public /* synthetic */ LawHintParam(Long r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0L;
    L5:
        this(r1);
    }
}
