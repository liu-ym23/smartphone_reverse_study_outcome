package si2;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lsi2/s;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "Lsi2/s$a;", "actionList", "Lsi2/s$a;", "getActionList", "()Lsi2/s$a;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
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

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.buy, r4.buy) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.favorite, r4.favorite) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.addToCart, r4.addToCart) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.click, r4.click) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.curProductId, r4.curProductId) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            List<String> r0 = this.buy;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<String> r4 = this.favorite;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            List<String> r7 = this.addToCart;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            List<String> r10 = this.click;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.curProductId;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
        L17:
            r11 = 0;
            goto L18
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L10;
        s r4 = (s) r3;
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionList, r4.actionList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.roomId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        a r4 = this.actionList;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
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
