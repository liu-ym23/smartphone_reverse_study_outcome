package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/ManualState;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "ON", "OFF", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ManualState extends Enum<ManualState> {
    public static final ManualState DEFAULT = null;
    public static final ManualState OFF = null;
    public static final ManualState ON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManualState[] f267887a = null;
    private final int value;

    public static ManualState valueOf(String r100) {
        return (ManualState) r27.a.a(ManualState.class, r100);
    }

    public static ManualState[] values() {
        return (ManualState[]) f267887a.clone();
    }

    static {
        ManualState r100 = new ManualState("DEFAULT", 0, 0);
        DEFAULT = r100;
        ManualState r101 = new ManualState("ON", 1, 1);
        ON = r101;
        ManualState r102 = new ManualState("OFF", 2, 2);
        OFF = r102;
        f267887a = new ManualState[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public ManualState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
