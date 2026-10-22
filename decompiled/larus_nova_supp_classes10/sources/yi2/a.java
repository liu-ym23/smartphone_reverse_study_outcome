package yi2;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lyi2/a;", "Lcom/bytedance/android/ec/model/g;", "", "Lyi2/b;", "smallWindowLabels", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "refreshCycle", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends g {

    @SerializedName("refresh_cycle")
    private final Long refreshCycle;

    @SerializedName("small_window_labels")
    private final List<b> smallWindowLabels;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.smallWindowLabels, r4.smallWindowLabels) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.refreshCycle, r4.refreshCycle) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<b> r0 = this.smallWindowLabels;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.refreshCycle;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveSmallWindowResponse(smallWindowLabels=" + this.smallWindowLabels + ", refreshCycle=" + this.refreshCycle + ")";
    }

    public a() {
        this.smallWindowLabels = null;
        this.refreshCycle = null;
    }

    public final Long a() {
        return this.refreshCycle;
    }

    public final List<b> b() {
        return this.smallWindowLabels;
    }
}
