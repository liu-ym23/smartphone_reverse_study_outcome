package oe6;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jw\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006+"}, d2 = {"Lcom/bytedance/lark/policy/model/calculate/PolicyCalculateInfo;", "", "tenantID", "", "enablePolicies", "", "Lcom/bytedance/lark/policy/model/calculate/PolicyInfo;", "contextParam", "evaluateTime", CronetDataStorageAccess.LOGID, "policyType", "effect", SlcCommonAction.KEY_ACTIONS, "advice", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getTenantID", "()Ljava/lang/String;", "getEnablePolicies", "()Ljava/util/List;", "getContextParam", "getEvaluateTime", "getLogid", "getPolicyType", "getEffect", "getActions", "getAdvice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<String> actions;

    @SerializedName("advice")
    private final String advice;

    @SerializedName("contextParam")
    private final String contextParam;

    @SerializedName("effect")
    private final String effect;

    @SerializedName("enablePolicies")
    private final List<e> enablePolicies;

    @SerializedName("evaluateTime")
    private final String evaluateTime;

    @SerializedName(CronetDataStorageAccess.LOGID)
    private final String logid;

    @SerializedName("policyType")
    private final String policyType;

    @SerializedName("tenantID")
    private final String tenantID;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.tenantID, r101.tenantID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enablePolicies, r101.enablePolicies) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.contextParam, r101.contextParam) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.evaluateTime, r101.evaluateTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.logid, r101.logid) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.policyType, r101.policyType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.effect, r101.effect) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.advice, r101.advice) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.tenantID;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<e> r104 = this.enablePolicies;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.contextParam;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((((((r106 + r108) * 31) + this.evaluateTime.hashCode()) * 31) + this.logid.hashCode()) * 31) + this.policyType.hashCode()) * 31) + this.effect.hashCode()) * 31;
        List<String> r110 = this.actions;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.advice.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PolicyCalculateInfo(tenantID=" + this.tenantID + ", enablePolicies=" + this.enablePolicies + ", contextParam=" + this.contextParam + ", evaluateTime=" + this.evaluateTime + ", logid=" + this.logid + ", policyType=" + this.policyType + ", effect=" + this.effect + ", actions=" + this.actions + ", advice=" + this.advice + ')';
    }

    public static c a(c r110, String r111, String r112) {
        List<e> r100 = r110.enablePolicies;
        String r101 = r110.contextParam;
        String r102 = r110.evaluateTime;
        String r103 = r110.logid;
        String r104 = r110.effect;
        List<String> r105 = r110.actions;
        String r106 = r110.advice;
        Intrinsics.checkNotNullParameter(r102, "evaluateTime");
        Intrinsics.checkNotNullParameter(r103, CronetDataStorageAccess.LOGID);
        Intrinsics.checkNotNullParameter(r112, "policyType");
        Intrinsics.checkNotNullParameter(r104, "effect");
        Intrinsics.checkNotNullParameter(r106, "advice");
        return new c(r111, r100, r101, r102, r103, r112, r104, r105, r106);
    }

    public c(String r100, List<e> r101, String r102, String r103, String r104, String r105, String r106, List<String> r107, String r110) {
        Intrinsics.checkNotNullParameter(r103, "evaluateTime");
        Intrinsics.checkNotNullParameter(r104, CronetDataStorageAccess.LOGID);
        Intrinsics.checkNotNullParameter(r105, "policyType");
        Intrinsics.checkNotNullParameter(r106, "effect");
        Intrinsics.checkNotNullParameter(r110, "advice");
        this.tenantID = r100;
        this.enablePolicies = r101;
        this.contextParam = r102;
        this.evaluateTime = r103;
        this.logid = r104;
        this.policyType = r105;
        this.effect = r106;
        this.actions = r107;
        this.advice = r110;
    }
}
