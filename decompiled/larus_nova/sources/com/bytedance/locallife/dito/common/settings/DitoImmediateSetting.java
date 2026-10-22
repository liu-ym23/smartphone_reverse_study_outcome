package com.bytedance.locallife.dito.common.settings;

import com.bytedance.locallife.dito.data.e;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/dito/common/settings/DitoImmediateSetting;", "", "", "", "Lcom/bytedance/locallife/dito/data/e;", "ditoImmediateRecoveryConfig", "Ljava/util/Map;", "getDitoImmediateRecoveryConfig", "()Ljava/util/Map;", "<init>", "()V", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoImmediateSetting {

    @SerializedName("dito_immediate_recovery_config")
    private final Map<String, e> ditoImmediateRecoveryConfig;

    public DitoImmediateSetting() {
    }

    public final Map<String, e> getDitoImmediateRecoveryConfig() {
        return this.ditoImmediateRecoveryConfig;
    }
}
