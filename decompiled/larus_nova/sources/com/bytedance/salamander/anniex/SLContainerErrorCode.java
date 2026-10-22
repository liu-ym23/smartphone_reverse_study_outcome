package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/SLContainerErrorCode;", "", "", "value", "I", "getValue", "()I", "Common", "Router", "Schema", "Create", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SLContainerErrorCode extends Enum<SLContainerErrorCode> {
    public static final SLContainerErrorCode Common = null;
    public static final SLContainerErrorCode Create = null;
    public static final SLContainerErrorCode Router = null;
    public static final SLContainerErrorCode Schema = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SLContainerErrorCode[] f267906a = null;
    private final int value;

    public static SLContainerErrorCode valueOf(String r100) {
        return (SLContainerErrorCode) r27.a.a(SLContainerErrorCode.class, r100);
    }

    public static SLContainerErrorCode[] values() {
        return (SLContainerErrorCode[]) f267906a.clone();
    }

    static {
        SLContainerErrorCode r100 = new SLContainerErrorCode("Common", 0, 0);
        Common = r100;
        SLContainerErrorCode r101 = new SLContainerErrorCode("Router", 1, 1);
        Router = r101;
        SLContainerErrorCode r102 = new SLContainerErrorCode("Schema", 2, 2);
        Schema = r102;
        SLContainerErrorCode r103 = new SLContainerErrorCode("Create", 3, 3);
        Create = r103;
        f267906a = new SLContainerErrorCode[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public SLContainerErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
