package com.larus.office.plugins.inputv2.component.feishu;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/office/plugins/inputv2/component/feishu/FeishuFlowAIShowResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "NOT_READY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeishuFlowAIShowResult extends Enum<FeishuFlowAIShowResult> {
    public static final FeishuFlowAIShowResult NOT_READY = null;
    public static final FeishuFlowAIShowResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeishuFlowAIShowResult[] f362739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f362740b = null;

    public static EnumEntries<FeishuFlowAIShowResult> getEntries() {
        return f362740b;
    }

    static {
        FeishuFlowAIShowResult r100 = new FeishuFlowAIShowResult("SUCCESS", 0);
        SUCCESS = r100;
        FeishuFlowAIShowResult r101 = new FeishuFlowAIShowResult("NOT_READY", 1);
        NOT_READY = r101;
        FeishuFlowAIShowResult[] r102 = {r100, r101};
        f362739a = r102;
        f362740b = EnumEntriesKt.enumEntries(r102);
    }

    public static FeishuFlowAIShowResult[] values() {
        return (FeishuFlowAIShowResult[]) f362739a.clone();
    }

    public static FeishuFlowAIShowResult valueOf(String r100) {
        return (FeishuFlowAIShowResult) a.a(FeishuFlowAIShowResult.class, r100);
    }

    public FeishuFlowAIShowResult(String r100, int r101) {
        super(r100, r101);
    }
}
