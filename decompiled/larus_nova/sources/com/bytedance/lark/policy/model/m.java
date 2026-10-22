package com.bytedance.lark.policy.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0010HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0093\u0001\u0010-\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010!R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00062"}, d2 = {"Lcom/bytedance/lark/policy/model/Pointcut;", "", "appliedPolicyTypes", "", "", "contextDerivation", "", "fallbackStrategy", "", LocationMonitorConst.IDENTIFIER, "interceptPercentage", PromotionProductPrivilegesStruct.TAGS, "timeoutMS", "type", "", "isReserved", "", "fallbackActions", "<init>", "(Ljava/util/List;Ljava/util/Map;ILjava/lang/String;ILjava/util/Map;IJZLjava/util/List;)V", "getAppliedPolicyTypes", "()Ljava/util/List;", "getContextDerivation", "()Ljava/util/Map;", "getFallbackStrategy", "()I", "getIdentifier", "()Ljava/lang/String;", "getInterceptPercentage", "getTags", "getTimeoutMS", "getType", "()J", "()Z", "getFallbackActions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m {

    @SerializedName("appliedPolicyTypes")
    private final List<String> appliedPolicyTypes;

    @SerializedName("contextDerivation")
    private final Map<String, String> contextDerivation;

    @SerializedName("fallbackActions")
    private final List<String> fallbackActions;

    @SerializedName("fallbackStrategy")
    private final int fallbackStrategy;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private final String identifier;

    @SerializedName("interceptPercentage")
    private final int interceptPercentage;

    @SerializedName("isReserved")
    private final boolean isReserved;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final Map<String, String> tags;

    @SerializedName("timeoutMS")
    private final int timeoutMS;

    @SerializedName("type")
    private final long type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.appliedPolicyTypes, r101.appliedPolicyTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contextDerivation, r101.contextDerivation) == true) goto L15;
        return false;
    L15:
        if (this.fallbackStrategy == r101.fallbackStrategy) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L21;
        return false;
    L21:
        if (this.interceptPercentage == r101.interceptPercentage) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L27;
        return false;
    L27:
        if (this.timeoutMS == r101.timeoutMS) goto L30;
        return false;
    L30:
        if (this.type == r101.type) goto L33;
        return false;
    L33:
        if (this.isReserved == r101.isReserved) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.fallbackActions, r101.fallbackActions) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.appliedPolicyTypes.hashCode() * 31) + this.contextDerivation.hashCode()) * 31) + this.fallbackStrategy) * 31) + this.identifier.hashCode()) * 31) + this.interceptPercentage) * 31) + this.tags.hashCode()) * 31) + this.timeoutMS) * 31;
        long r101 = this.type;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.isReserved == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        List<String> r105 = this.fallbackActions;
        if (r105 != null) goto L9;
        int r106 = 0;
    L11:
        return r104 + r106;
    L9:
        r106 = r105.hashCode();
        goto L11
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "Pointcut(appliedPolicyTypes=" + this.appliedPolicyTypes + ", contextDerivation=" + this.contextDerivation + ", fallbackStrategy=" + this.fallbackStrategy + ", identifier=" + this.identifier + ", interceptPercentage=" + this.interceptPercentage + ", tags=" + this.tags + ", timeoutMS=" + this.timeoutMS + ", type=" + this.type + ", isReserved=" + this.isReserved + ", fallbackActions=" + this.fallbackActions + ')';
    }

    public final List<String> a() {
        return this.appliedPolicyTypes;
    }

    public final Map<String, String> b() {
        return this.contextDerivation;
    }

    public final List<String> c() {
        return this.fallbackActions;
    }

    public final int d() {
        return this.fallbackStrategy;
    }

    public final Map<String, String> e() {
        return this.tags;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final long getType() {
        return this.type;
    }
}
