package com.bytedance.helios.api.consumer;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/helios/api/consumer/OperateHistory;", "", OnekeyLoginConstants.CU_KEY_OPERATOR, "", PickerReporterConstants.KEY.TARGET, "pairs", "", "Lcom/bytedance/helios/api/consumer/OperatePairs;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getOperator", "()Ljava/lang/String;", "setOperator", "(Ljava/lang/String;)V", "getPairs", "()Ljava/util/List;", "setPairs", "(Ljava/util/List;)V", "getTarget", "setTarget", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 1, 16})
public final class OperateHistory {
    private String operator;
    private List<OperatePairs> pairs;
    private String target;

    public OperateHistory() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OperateHistory copy$default(OperateHistory r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.operator;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.target;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.pairs;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.operator;
    }

    public final String component2() {
        return this.target;
    }

    public final List<OperatePairs> component3() {
        return this.pairs;
    }

    public final OperateHistory copy(String r100, String r101, List<OperatePairs> r102) {
        return new OperateHistory(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OperateHistory) == false) goto L12;
        OperateHistory r101 = (OperateHistory) r100;
        if (Intrinsics.areEqual(this.operator, r101.operator) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pairs, r101.pairs) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.operator;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.target;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<OperatePairs> r107 = this.pairs;
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

    public String toString() {
        return "OperateHistory(operator=" + this.operator + ", target=" + this.target + ", pairs=" + this.pairs + ")";
    }

    public final String getOperator() {
        return this.operator;
    }

    public final List<OperatePairs> getPairs() {
        return this.pairs;
    }

    public final String getTarget() {
        return this.target;
    }

    public final void setOperator(String r100) {
        this.operator = r100;
    }

    public final void setPairs(List<OperatePairs> r100) {
        this.pairs = r100;
    }

    public final void setTarget(String r100) {
        this.target = r100;
    }

    public OperateHistory(String r100, String r101, List<OperatePairs> r102) {
        this.operator = r100;
        this.target = r101;
        this.pairs = r102;
    }

    public /* synthetic */ OperateHistory(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
