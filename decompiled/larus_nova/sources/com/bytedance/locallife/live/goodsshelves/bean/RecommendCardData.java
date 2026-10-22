package com.bytedance.locallife.live.goodsshelves.bean;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/RecommendCardData;", "Ljava/io/Serializable;", "card_list", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/LiveGoodsShelvesCard;", "total", "", "city_name", "", "explain_title", "closest", "(Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCard_list", "()Ljava/util/List;", "getCity_name", "()Ljava/lang/String;", "getClosest", "getExplain_title", "getTotal", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RecommendCardData implements Serializable {
    private final List<LiveGoodsShelvesCard> card_list;
    private final String city_name;
    private final String closest;
    private final String explain_title;
    private final long total;

    public RecommendCardData() {
        this(null, 0, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendCardData copy$default(RecommendCardData r100, List r101, long r102, String r103, String r104, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.card_list;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.total;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.city_name;
    L11:
        String r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.explain_title;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.closest;
    L17:
        List r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final List<LiveGoodsShelvesCard> component1() {
        return this.card_list;
    }

    public final long component2() {
        return this.total;
    }

    public final String component3() {
        return this.city_name;
    }

    public final String component4() {
        return this.explain_title;
    }

    public final String component5() {
        return this.closest;
    }

    public final RecommendCardData copy(List<LiveGoodsShelvesCard> r100, long r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "city_name");
        Intrinsics.checkNotNullParameter(r112, "explain_title");
        Intrinsics.checkNotNullParameter(r113, "closest");
        return new RecommendCardData(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendCardData) == true) goto L8;
        return false;
    L8:
        RecommendCardData r101 = (RecommendCardData) r100;
        if (Intrinsics.areEqual(this.card_list, r101.card_list) == true) goto L12;
        return false;
    L12:
        if (this.total == r101.total) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.city_name, r101.city_name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.explain_title, r101.explain_title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.closest, r101.closest) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        List<LiveGoodsShelvesCard> r100 = this.card_list;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.total;
        return (((((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.city_name.hashCode()) * 31) + this.explain_title.hashCode()) * 31) + this.closest.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RecommendCardData(card_list=" + this.card_list + ", total=" + this.total + ", city_name=" + this.city_name + ", explain_title=" + this.explain_title + ", closest=" + this.closest + ')';
    }

    public final List<LiveGoodsShelvesCard> getCard_list() {
        return this.card_list;
    }

    public final String getCity_name() {
        return this.city_name;
    }

    public final String getClosest() {
        return this.closest;
    }

    public final String getExplain_title() {
        return this.explain_title;
    }

    public final long getTotal() {
        return this.total;
    }

    public RecommendCardData(List<LiveGoodsShelvesCard> r100, long r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "city_name");
        Intrinsics.checkNotNullParameter(r103, "explain_title");
        Intrinsics.checkNotNullParameter(r104, "closest");
        this.card_list = r100;
        this.total = r101;
        this.city_name = r102;
        this.explain_title = r103;
        this.closest = r104;
    }

    public /* synthetic */ RecommendCardData(List r100, long r101, String r102, String r103, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        long r104 = r101;
        if ((r111 & 4) == 0) goto L11;
        String r113 = "";
    L13:
        if ((r111 & 8) == 0) goto L15;
        String r105 = "";
    L17:
        if ((r111 & 16) == 0) goto L19;
        String r106 = "";
    L20:
        this(r100, r104, r113, r105, r106);
        return;
    L19:
        r106 = r110;
        goto L20
    L15:
        r105 = r103;
        goto L17
    L11:
        r113 = r102;
        goto L13
    }
}
