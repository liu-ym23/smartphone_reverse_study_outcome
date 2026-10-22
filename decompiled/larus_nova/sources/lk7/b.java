package lk7;

import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Llk7/b;", "", "", "crossoverActionType", "I", "getCrossoverActionType", "()I", "", "Llk7/d;", "recordsDetail", "Ljava/util/List;", "getRecordsDetail", "()Ljava/util/List;", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("crossover_action_type")
    private final int crossoverActionType;

    @SerializedName("action_records")
    private final List<d> recordsDetail;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L15:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.crossoverActionType != r101.crossoverActionType) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        if (Intrinsics.areEqual(this.recordsDetail, r101.recordsDetail) == false) goto L14;
    L9:
        r102 = false;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.crossoverActionType * 31;
        List<d> r101 = this.recordsDetail;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L7
        r100.append("{");     // Catch: Throwable -> L7
        int r101 = this.recordsDetail.size();     // Catch: Throwable -> L7
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        r100.append("【 ");     // Catch: Throwable -> L7
        r100.append(((d) ListProtector.get(this.recordsDetail, r102)).toString());     // Catch: Throwable -> L7
        r100.append(" 】,");     // Catch: Throwable -> L7
        r102 = r102 + 1;     // Catch: Throwable -> L7
        goto L3
    L5:
        r100.append(i.f25855d);     // Catch: Throwable -> L7
        return "crossover_action_type: " + this.crossoverActionType + "  action_records: " + r100;
    L7:
        th = move-exception;
        return "exception caught: " + th.getLocalizedMessage();
    }
}
