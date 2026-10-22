package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXLoadStatus;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "LOAD_START", "LOAD_SUCCESS", "LOAD_FAILED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXLoadStatus extends Enum<AnnieXLoadStatus> {
    public static final AnnieXLoadStatus LOAD_FAILED = null;
    public static final AnnieXLoadStatus LOAD_START = null;
    public static final AnnieXLoadStatus LOAD_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXLoadStatus[] f267825a = null;
    private final String value;

    public static AnnieXLoadStatus valueOf(String r100) {
        return (AnnieXLoadStatus) r27.a.a(AnnieXLoadStatus.class, r100);
    }

    public static AnnieXLoadStatus[] values() {
        return (AnnieXLoadStatus[]) f267825a.clone();
    }

    static {
        AnnieXLoadStatus r100 = new AnnieXLoadStatus("LOAD_START", 0, "load_start");
        LOAD_START = r100;
        AnnieXLoadStatus r101 = new AnnieXLoadStatus("LOAD_SUCCESS", 1, "load_success");
        LOAD_SUCCESS = r101;
        AnnieXLoadStatus r102 = new AnnieXLoadStatus("LOAD_FAILED", 2, "load_failed");
        LOAD_FAILED = r102;
        f267825a = new AnnieXLoadStatus[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public AnnieXLoadStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
