package com.larus.platform.model.downgrade;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/model/downgrade/MockRequestDowngradeConfig;", "", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "", "", "Lcom/larus/platform/model/downgrade/MockDowngradeStrategyConfig;", "<init>", "(Ljava/util/Map;)V", "getConfigs", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MockRequestDowngradeConfig {

    @SerializedName(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY)
    private final Map<String, MockDowngradeStrategyConfig> configs;

    /* JADX WARN: Multi-variable type inference failed */
    public MockRequestDowngradeConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MockRequestDowngradeConfig copy$default(MockRequestDowngradeConfig r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.configs;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, MockDowngradeStrategyConfig> component1() {
        return this.configs;
    }

    public final MockRequestDowngradeConfig copy(Map<String, MockDowngradeStrategyConfig> r100) {
        return new MockRequestDowngradeConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MockRequestDowngradeConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.configs, ((MockRequestDowngradeConfig) r100).configs) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Map<String, MockDowngradeStrategyConfig> r100 = this.configs;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "MockRequestDowngradeConfig(configs=" + this.configs + ')';
    }

    public final Map<String, MockDowngradeStrategyConfig> getConfigs() {
        return this.configs;
    }

    public MockRequestDowngradeConfig(Map<String, MockDowngradeStrategyConfig> r100) {
        this.configs = r100;
    }

    public /* synthetic */ MockRequestDowngradeConfig(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
