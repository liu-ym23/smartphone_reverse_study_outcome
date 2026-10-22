package com.larus.flowsdk.common.experiment;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/flowsdk/common/experiment/FlowExperimentDefaultScope;", "", "<init>", "(Ljava/lang/String;I)V", "Doubao", "Default", "flow-client-experiment-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowExperimentDefaultScope extends Enum<FlowExperimentDefaultScope> {
    public static final FlowExperimentDefaultScope Default = null;
    public static final FlowExperimentDefaultScope Doubao = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowExperimentDefaultScope[] f343451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343452b = null;

    public static EnumEntries<FlowExperimentDefaultScope> getEntries() {
        return f343452b;
    }

    static {
        FlowExperimentDefaultScope r100 = new FlowExperimentDefaultScope("Doubao", 0);
        Doubao = r100;
        FlowExperimentDefaultScope r101 = new FlowExperimentDefaultScope("Default", 1);
        Default = r101;
        FlowExperimentDefaultScope[] r102 = {r100, r101};
        f343451a = r102;
        f343452b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowExperimentDefaultScope[] values() {
        return (FlowExperimentDefaultScope[]) f343451a.clone();
    }

    public static FlowExperimentDefaultScope valueOf(String r100) {
        return (FlowExperimentDefaultScope) a.a(FlowExperimentDefaultScope.class, r100);
    }

    public FlowExperimentDefaultScope(String r100, int r101) {
        super(r100, r101);
    }
}
