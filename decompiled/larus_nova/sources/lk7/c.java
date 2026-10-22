package lk7;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Llk7/c;", "", "", "crossoverActionType", "I", "getCrossoverActionType", "()I", "", "hasAction", "Z", "getHasAction", "()Z", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("crossover_action_type")
    private final int crossoverActionType;

    @SerializedName("has_action")
    private final boolean hasAction;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L18:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L17;
        c r101 = (c) r100;
        if (this.crossoverActionType != r101.crossoverActionType) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        if (this.hasAction != r101.hasAction) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L17:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        int r100 = this.crossoverActionType * 31;
        boolean r101 = this.hasAction;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "crossover_action_type: " + this.crossoverActionType + "  has_action: " + this.hasAction;
    }
}
