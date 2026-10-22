package com.ss.android.lark.passport.flow.core.router;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", "Ljava/io/Serializable;", "nextStep", "", "stepInfo", "Lcom/alibaba/fastjson/JSONObject;", "logId", "<init>", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;)V", "getNextStep", "()Ljava/lang/String;", "getStepInfo", "()Lcom/alibaba/fastjson/JSONObject;", "getLogId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowStep implements Serializable {
    private final String logId;
    private final String nextStep;
    private final JSONObject stepInfo;

    public static /* synthetic */ FlowStep copy$default(FlowStep r100, String r101, JSONObject r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.nextStep;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.stepInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.logId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.nextStep;
    }

    public final JSONObject component2() {
        return this.stepInfo;
    }

    public final String component3() {
        return this.logId;
    }

    public final FlowStep copy(@JSONField(name = "next_step") String r100, @JSONField(name = "step_info") JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "nextStep");
        Intrinsics.checkNotNullParameter(r101, "stepInfo");
        return new FlowStep(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowStep) == true) goto L8;
        return false;
    L8:
        FlowStep r101 = (FlowStep) r100;
        if (Intrinsics.areEqual(this.nextStep, r101.nextStep) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.stepInfo, r101.stepInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.nextStep.hashCode() * 31) + this.stepInfo.hashCode()) * 31;
        String r101 = this.logId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "FlowStep(nextStep=" + this.nextStep + ", stepInfo=" + this.stepInfo + ", logId=" + this.logId + ')';
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getNextStep() {
        return this.nextStep;
    }

    public final JSONObject getStepInfo() {
        return this.stepInfo;
    }

    public FlowStep(@JSONField(name = "next_step") String r100, @JSONField(name = "step_info") JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "nextStep");
        Intrinsics.checkNotNullParameter(r101, "stepInfo");
        this.nextStep = r100;
        this.stepInfo = r101;
        this.logId = r102;
    }

    public /* synthetic */ FlowStep(String r100, JSONObject r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
