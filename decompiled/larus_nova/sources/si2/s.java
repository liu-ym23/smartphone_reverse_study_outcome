package si2;

import com.byted.cast.linkcommon.cybergarage.upnp.ActionList;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lsi2/s;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "Lsi2/s$a;", ActionList.ELEM_NAME, "Lsi2/s$a;", "getActionList", "()Lsi2/s$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("action_list")
    private final a actionList;

    @SerializedName("room_id")
    private final String roomId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lsi2/s$a;", "", "", "", "buy", "Ljava/util/List;", "getBuy", "()Ljava/util/List;", "favorite", "getFavorite", "addToCart", "getAddToCart", "click", "getClick", "curProductId", "Ljava/lang/String;", "getCurProductId", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("add_to_cart")
        private final List<String> addToCart;

        @SerializedName("buy")
        private final List<String> buy;

        @SerializedName("click")
        private final List<String> click;

        @SerializedName("cur_product_id")
        private final String curProductId;

        @SerializedName("favorite")
        private final List<String> favorite;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.buy, r101.buy) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.favorite, r101.favorite) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.addToCart, r101.addToCart) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.click, r101.click) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.curProductId, r101.curProductId) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            List<String> r100 = this.buy;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.favorite;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<String> r107 = this.addToCart;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            List<String> r110 = this.click;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.curProductId;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ActionList(buy=" + this.buy + ", favorite=" + this.favorite + ", addToCart=" + this.addToCart + ", click=" + this.click + ", curProductId=" + this.curProductId + ")";
        }

        public a() {
            this.buy = null;
            this.favorite = null;
            this.addToCart = null;
            this.click = null;
            this.curProductId = null;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L10;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionList, r101.actionList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.actionList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECUserLiveProductAction(roomId=" + this.roomId + ", actionList=" + this.actionList + ")";
    }

    public s() {
        this.roomId = null;
        this.actionList = null;
    }
}
