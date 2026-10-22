package com.bytedance.lark.policy.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes20.dex */
@AppConfig(key = "lark_policy_engine_config")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR&\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR0\u0010,\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR$\u00105\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R*\u00108\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00170-8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\u001e\u0010;\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\t¨\u0006>"}, d2 = {"Lcom/bytedance/lark/policy/utils/PolicyEngineSettingConfig;", "", "<init>", "()V", "enablePolicyEngine", "", "getEnablePolicyEngine", "()Z", "setEnablePolicyEngine", "(Z)V", "enableEngineLocalValidate", "getEnableEngineLocalValidate", "setEnableEngineLocalValidate", "policyEngineFetchPolicyInterval", "", "getPolicyEngineFetchPolicyInterval", "()J", "setPolicyEngineFetchPolicyInterval", "(J)V", "nonEnterpriseFetchThrottle", "getNonEnterpriseFetchThrottle", "setNonEnterpriseFetchThrottle", "policyEngineLocalValidateCountLimit", "", "getPolicyEngineLocalValidateCountLimit", "()I", "setPolicyEngineLocalValidateCountLimit", "(I)V", "policyEnginePointCutRetryDelay", "getPolicyEnginePointCutRetryDelay", "setPolicyEnginePointCutRetryDelay", "useRustExpressionEngine", "getUseRustExpressionEngine", "setUseRustExpressionEngine", "disableLocalDecisionPointcutList", "", "", "getDisableLocalDecisionPointcutList", "()Ljava/util/List;", "setDisableLocalDecisionPointcutList", "(Ljava/util/List;)V", "policyEngineFetchPolicyMaxNum", "getPolicyEngineFetchPolicyMaxNum", "setPolicyEngineFetchPolicyMaxNum", "policyEngineUnsupportedFactorMap", "", "getPolicyEngineUnsupportedFactorMap", "()Ljava/util/Map;", "setPolicyEngineUnsupportedFactorMap", "(Ljava/util/Map;)V", "enableIPFenceCalculate", "getEnableIPFenceCalculate", "setEnableIPFenceCalculate", "enableIndexFactorPolicyType", "getEnableIndexFactorPolicyType", "setEnableIndexFactorPolicyType", "policyEngineFastPassConfig", "getPolicyEngineFastPassConfig", "setPolicyEngineFastPassConfig", "userSessionJudgeOpt", "getUserSessionJudgeOpt", "setUserSessionJudgeOpt", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PolicyEngineSettingConfig {

    @SerializedName("disable_local_decision_pointcut_list")
    private List<String> disableLocalDecisionPointcutList;

    @SerializedName("policy_engine_enable_local_validate")
    private boolean enableEngineLocalValidate;

    @SerializedName("policy_engine_enable_ip_fence_calculate")
    private boolean enableIPFenceCalculate;

    @SerializedName("enable_index_factor_policy_type")
    private List<String> enableIndexFactorPolicyType;

    @SerializedName("enable_policy_engine")
    private boolean enablePolicyEngine;

    @SerializedName("non_enterprise_fetch_throttle")
    private boolean nonEnterpriseFetchThrottle;

    @SerializedName("policy_engine_fast_pass_config")
    private Map<String, Integer> policyEngineFastPassConfig;

    @SerializedName("policy_engine_fetch_policy_interval")
    private long policyEngineFetchPolicyInterval;

    @SerializedName("policy_engine_fetch_policy_num")
    private int policyEngineFetchPolicyMaxNum;

    @SerializedName("policy_engine_local_validate_count_limit")
    private int policyEngineLocalValidateCountLimit;

    @SerializedName("policy_engine_pointcut_retry_delay")
    private long policyEnginePointCutRetryDelay;

    @SerializedName("policy_engine_unsupported_factor_map")
    private Map<String, ? extends List<String>> policyEngineUnsupportedFactorMap;

    @SerializedName("use_rust_expression_engine")
    private boolean useRustExpressionEngine;

    @SerializedName("user_session_judge_opt")
    private boolean userSessionJudgeOpt;

    public PolicyEngineSettingConfig() {
        this.enablePolicyEngine = true;
        this.enableEngineLocalValidate = true;
        this.policyEngineFetchPolicyInterval = 300;
        this.nonEnterpriseFetchThrottle = true;
        this.policyEngineLocalValidateCountLimit = 20;
        this.policyEnginePointCutRetryDelay = 5;
        this.useRustExpressionEngine = true;
        this.disableLocalDecisionPointcutList = CollectionsKt.emptyList();
        this.policyEngineFetchPolicyMaxNum = 20;
        this.policyEngineUnsupportedFactorMap = MapsKt.emptyMap();
        this.enableIndexFactorPolicyType = CollectionsKt.emptyList();
        this.policyEngineFastPassConfig = MapsKt.emptyMap();
        this.userSessionJudgeOpt = true;
    }

    public final List<String> a() {
        return this.disableLocalDecisionPointcutList;
    }

    public final boolean b() {
        return this.enableEngineLocalValidate;
    }

    public final boolean c() {
        return this.enableIPFenceCalculate;
    }

    public final List<String> d() {
        return this.enableIndexFactorPolicyType;
    }

    public final boolean e() {
        return this.enablePolicyEngine;
    }

    public final boolean f() {
        return this.nonEnterpriseFetchThrottle;
    }

    public final Map<String, Integer> g() {
        return this.policyEngineFastPassConfig;
    }

    public final long h() {
        return this.policyEngineFetchPolicyInterval;
    }

    public final int i() {
        return this.policyEngineFetchPolicyMaxNum;
    }

    public final int j() {
        return this.policyEngineLocalValidateCountLimit;
    }

    public final long k() {
        return this.policyEnginePointCutRetryDelay;
    }

    public final Map<String, List<String>> l() {
        return this.policyEngineUnsupportedFactorMap;
    }

    public final boolean m() {
        return this.useRustExpressionEngine;
    }

    public final boolean n() {
        return this.userSessionJudgeOpt;
    }
}
