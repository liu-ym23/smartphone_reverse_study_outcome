package rl;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lrl/c;", "", "Lrl/b;", "header", "Lrl/b;", "getHeader", "()Lrl/b;", "", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "promotions", "Ljava/util/List;", "getPromotions", "()Ljava/util/List;", "", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("header")
    private final b header;

    @SerializedName("promotions")
    private final List<ECPromotion> promotions;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotions, r101.promotions) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        b r100 = this.header;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ECPromotion> r104 = this.promotions;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.eventParams;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RelatedModule(header=" + this.header + ", promotions=" + this.promotions + ", eventParams=" + this.eventParams + ")";
    }

    public c() {
        this.header = null;
        this.promotions = null;
        this.eventParams = null;
    }
}
