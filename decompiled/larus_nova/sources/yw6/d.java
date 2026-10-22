package yw6;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lyw6/d;", "", "", "grouponId", "Ljava/lang/String;", "getGrouponId", "()Ljava/lang/String;", "collectUid", "getCollectUid", "", "toCollect", "Ljava/lang/Boolean;", "getToCollect", "()Ljava/lang/Boolean;", "", "favoriteLifeInfo", "Ljava/util/Map;", "getFavoriteLifeInfo", "()Ljava/util/Map;", "lifeMallSubpage", "getLifeMallSubpage", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("collector_uid")
    private final String collectUid;

    @SerializedName("favorite_life_info")
    private final Map<String, Object> favoriteLifeInfo;

    @SerializedName("groupon_id")
    private final String grouponId;

    @SerializedName("life_mall_sub_page")
    private final String lifeMallSubpage;

    @SerializedName("want")
    private final Boolean toCollect;

    public d() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.grouponId, r101.grouponId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.collectUid, r101.collectUid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.toCollect, r101.toCollect) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.favoriteLifeInfo, r101.favoriteLifeInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lifeMallSubpage, r101.lifeMallSubpage) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.grouponId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.collectUid;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.toCollect;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.favoriteLifeInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.lifeMallSubpage;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CollectPostEntityParams(grouponId=" + this.grouponId + ", collectUid=" + this.collectUid + ", toCollect=" + this.toCollect + ", favoriteLifeInfo=" + this.favoriteLifeInfo + ", lifeMallSubpage=" + this.lifeMallSubpage + ')';
    }

    public d(String r100, String r101, Boolean r102, Map<String, ? extends Object> r103, String r104) {
        this.grouponId = r100;
        this.collectUid = r101;
        this.toCollect = r102;
        this.favoriteLifeInfo = r103;
        this.lifeMallSubpage = r104;
    }
}
