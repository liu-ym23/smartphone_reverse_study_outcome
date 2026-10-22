package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/SLEndToEndErrorCode;", "", "", "value", "I", "getValue", "()I", "LoadContainerFail", "LoadEngineFail", "LoadTemplateFail", "EngineRenderFail", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SLEndToEndErrorCode extends Enum<SLEndToEndErrorCode> {
    public static final SLEndToEndErrorCode EngineRenderFail = null;
    public static final SLEndToEndErrorCode LoadContainerFail = null;
    public static final SLEndToEndErrorCode LoadEngineFail = null;
    public static final SLEndToEndErrorCode LoadTemplateFail = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SLEndToEndErrorCode[] f267908a = null;
    private final int value;

    public static SLEndToEndErrorCode valueOf(String r100) {
        return (SLEndToEndErrorCode) r27.a.a(SLEndToEndErrorCode.class, r100);
    }

    public static SLEndToEndErrorCode[] values() {
        return (SLEndToEndErrorCode[]) f267908a.clone();
    }

    static {
        SLEndToEndErrorCode r100 = new SLEndToEndErrorCode("LoadContainerFail", 0, 0);
        LoadContainerFail = r100;
        SLEndToEndErrorCode r101 = new SLEndToEndErrorCode("LoadEngineFail", 1, 1);
        LoadEngineFail = r101;
        SLEndToEndErrorCode r102 = new SLEndToEndErrorCode("LoadTemplateFail", 2, 2);
        LoadTemplateFail = r102;
        SLEndToEndErrorCode r103 = new SLEndToEndErrorCode("EngineRenderFail", 3, 3);
        EngineRenderFail = r103;
        f267908a = new SLEndToEndErrorCode[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public SLEndToEndErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
