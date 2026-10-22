package com.bytedance.locallife.dito.plugin;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/dito/plugin/DitoComponentStage;", "", "", "stageStr", "Ljava/lang/String;", "getStageStr", "()Ljava/lang/String;", "UNKNOWN", "PARSE", "BIND_DATA", "WILL_SHOW", "COMPLETE_SHOW", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum DitoComponentStage extends Enum<DitoComponentStage> {
    public static final DitoComponentStage BIND_DATA = null;
    public static final DitoComponentStage COMPLETE_SHOW = null;
    public static final DitoComponentStage PARSE = null;
    public static final DitoComponentStage UNKNOWN = null;
    public static final DitoComponentStage WILL_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DitoComponentStage[] f258575a = null;
    private final String stageStr;

    public static DitoComponentStage valueOf(String r100) {
        return (DitoComponentStage) r27.a.a(DitoComponentStage.class, r100);
    }

    public static DitoComponentStage[] values() {
        return (DitoComponentStage[]) f258575a.clone();
    }

    static {
        DitoComponentStage r100 = new DitoComponentStage("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        DitoComponentStage r101 = new DitoComponentStage("PARSE", 1, "parse");
        PARSE = r101;
        DitoComponentStage r102 = new DitoComponentStage("BIND_DATA", 2, "bindData");
        BIND_DATA = r102;
        DitoComponentStage r103 = new DitoComponentStage("WILL_SHOW", 3, "willShow");
        WILL_SHOW = r103;
        DitoComponentStage r104 = new DitoComponentStage("COMPLETE_SHOW", 4, "completeShow");
        COMPLETE_SHOW = r104;
        f258575a = new DitoComponentStage[]{r100, r101, r102, r103, r104};
    }

    public final String getStageStr() {
        return this.stageStr;
    }

    public DitoComponentStage(String r100, int r101, String r102) {
        super(r100, r101);
        this.stageStr = r102;
    }
}
