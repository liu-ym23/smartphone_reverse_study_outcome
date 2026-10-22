package lk7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Llk7/a;", "", "", "checkTimestamp", "Ljava/lang/Long;", "getCheckTimestamp", "()Ljava/lang/Long;", "b", "(Ljava/lang/Long;)V", "", "hasAction", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "Llk7/c;", "hasActionByType", "Ljava/util/List;", "getHasActionByType", "()Ljava/util/List;", "Llk7/b;", "actionRecords", "getActionRecords", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("action_records")
    private final List<b> actionRecords;

    @SerializedName("check_timestamp")
    private Long checkTimestamp;

    @SerializedName("has_action")
    private final boolean hasAction;

    @SerializedName("has_action_by_type")
    private final List<c> hasActionByType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L19:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.checkTimestamp, r101.checkTimestamp) == false) goto L18;
        if (this.hasAction != r101.hasAction) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L18;
        if (Intrinsics.areEqual(this.hasActionByType, r101.hasActionByType) == false) goto L18;
        if (Intrinsics.areEqual(this.actionRecords, r101.actionRecords) == false) goto L18;
    L11:
        r102 = false;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        Long r100 = this.checkTimestamp;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.hasAction;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        List<c> r107 = this.hasActionByType;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        List<b> r110 = this.actionRecords;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L26
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L26
        List<c> r102 = this.hasActionByType;     // Catch: Throwable -> L26
        int r103 = 0;
        if (r102 == null) goto L10;
        int r104 = r102.size();     // Catch: Throwable -> L26
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L11;
        r100.append(((c) ListProtector.get(this.hasActionByType, r105)).toString());     // Catch: Throwable -> L26
        if (r105 == (this.hasActionByType.size() - 1)) goto L9;
        r100.append("\t");     // Catch: Throwable -> L26
    L9:
        r105 = r105 + 1;     // Catch: Throwable -> L26
    L11:
        List<b> r106 = this.actionRecords;     // Catch: Throwable -> L26
        if (r106 == null) goto L19;
        int r107 = r106.size();     // Catch: Throwable -> L26
    L14:
        if (r103 >= r107) goto L20;
        r101.append(((b) ListProtector.get(this.actionRecords, r103)).toString());     // Catch: Throwable -> L26
        if (r103 == (this.actionRecords.size() - 1)) goto L18;
        r101.append("<=records分割=>");     // Catch: Throwable -> L26
    L18:
        r103 = r103 + 1;     // Catch: Throwable -> L26
    L20:
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L26
        r108.append("checkTimestamp: ");     // Catch: Throwable -> L26
        Object r109 = this.checkTimestamp;     // Catch: Throwable -> L26
        if (r109 != null) goto L24;
        r109 = "null";
    L24:
        r108.append(r109);     // Catch: Throwable -> L26
        r108.append(" hasAction: ");     // Catch: Throwable -> L26
        r108.append(this.hasAction);     // Catch: Throwable -> L26
        r108.append(" <===分割===> has_action_by_type: ");     // Catch: Throwable -> L26
        r108.append(r100);     // Catch: Throwable -> L26
        r108.append(" <===分割===> action_records: ");     // Catch: Throwable -> L26
        r108.append(r101);     // Catch: Throwable -> L26
        return r108.toString();
    L19:
        r101.append("action_records is null\t");     // Catch: Throwable -> L26
        goto L20
    L10:
        r100.append("has_action_by_type is null");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        return "exception caught: " + th.getLocalizedMessage();
    }

    public final boolean a() {
        return this.hasAction;
    }

    public final void b(Long r100) {
        this.checkTimestamp = r100;
    }
}
