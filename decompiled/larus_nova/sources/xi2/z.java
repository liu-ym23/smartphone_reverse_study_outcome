package xi2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lxi2/z;", "Lcom/bytedance/android/ec/model/g;", "", "switch", "Ljava/lang/Boolean;", "getSwitch", "()Ljava/lang/Boolean;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z extends com.bytedance.android.ec.model.g {

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final Boolean f1170switch;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f1170switch, ((z) r100).f1170switch) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f1170switch;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ECPromotionLiveStore(switch=" + this.f1170switch + ")";
    }

    public z() {
        this.f1170switch = null;
    }
}
