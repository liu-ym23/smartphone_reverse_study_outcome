package com.bytedance.lark.policy.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lark/policy/model/TenantIndexFactorValue;", "", "<init>", "()V", "tenantID", "", "getTenantID", "()Ljava/lang/String;", "advice", "getAdvice", "indexFactorValues", "", "getIndexFactorValues", "()Ljava/util/List;", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class x {

    @SerializedName("advice")
    private final String advice;

    @SerializedName("indexFactorValues")
    private final List<String> indexFactorValues;

    @SerializedName("tenantID")
    private final String tenantID;

    public x() {
        this.tenantID = "";
        this.advice = "";
        this.indexFactorValues = CollectionsKt.emptyList();
    }

    public final List<String> a() {
        return this.indexFactorValues;
    }

    public final String b() {
        return this.tenantID;
    }
}
