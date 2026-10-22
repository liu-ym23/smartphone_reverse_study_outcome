package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/salamander/anniex/SLEndToEndStage;", "", "", "value", "I", "getValue", "()I", "Begin", "LoadContainerFail", "LoadTemplateStart", "LoadTemplateFail", "LoadTemplateEnd", "LoadEngineFail", "LoadFail", "LoadSuccess", "DataUpdate", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SLEndToEndStage extends Enum<SLEndToEndStage> {
    public static final SLEndToEndStage Begin = null;
    public static final SLEndToEndStage DataUpdate = null;
    public static final SLEndToEndStage LoadContainerFail = null;
    public static final SLEndToEndStage LoadEngineFail = null;
    public static final SLEndToEndStage LoadFail = null;
    public static final SLEndToEndStage LoadSuccess = null;
    public static final SLEndToEndStage LoadTemplateEnd = null;
    public static final SLEndToEndStage LoadTemplateFail = null;
    public static final SLEndToEndStage LoadTemplateStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SLEndToEndStage[] f267909a = null;
    private final int value;

    public static SLEndToEndStage valueOf(String r100) {
        return (SLEndToEndStage) r27.a.a(SLEndToEndStage.class, r100);
    }

    public static SLEndToEndStage[] values() {
        return (SLEndToEndStage[]) f267909a.clone();
    }

    static {
        SLEndToEndStage r100 = new SLEndToEndStage("Begin", 0, 0);
        Begin = r100;
        SLEndToEndStage r101 = new SLEndToEndStage("LoadContainerFail", 1, 1);
        LoadContainerFail = r101;
        SLEndToEndStage r102 = new SLEndToEndStage("LoadTemplateStart", 2, 2);
        LoadTemplateStart = r102;
        SLEndToEndStage r103 = new SLEndToEndStage("LoadTemplateFail", 3, 3);
        LoadTemplateFail = r103;
        SLEndToEndStage r104 = new SLEndToEndStage("LoadTemplateEnd", 4, 4);
        LoadTemplateEnd = r104;
        SLEndToEndStage r105 = new SLEndToEndStage("LoadEngineFail", 5, 5);
        LoadEngineFail = r105;
        SLEndToEndStage r110 = new SLEndToEndStage("LoadFail", 6, 6);
        LoadFail = r110;
        SLEndToEndStage r111 = new SLEndToEndStage("LoadSuccess", 7, 7);
        LoadSuccess = r111;
        SLEndToEndStage r112 = new SLEndToEndStage("DataUpdate", 8, 8);
        DataUpdate = r112;
        f267909a = new SLEndToEndStage[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    public SLEndToEndStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
