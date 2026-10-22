package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/PhaseType;", "", "", "value", "I", "getValue", "()I", "None", "CapturingPhase", "AtTarget", "BubblingPhase", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PhaseType extends Enum<PhaseType> {
    public static final PhaseType AtTarget = null;
    public static final PhaseType BubblingPhase = null;
    public static final PhaseType CapturingPhase = null;
    public static final PhaseType None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhaseType[] f404842a = null;
    private final int value;

    public static PhaseType valueOf(String r100) {
        return (PhaseType) r27.a.a(PhaseType.class, r100);
    }

    public static PhaseType[] values() {
        return (PhaseType[]) f404842a.clone();
    }

    static {
        PhaseType r100 = new PhaseType("None", 0, 0);
        None = r100;
        PhaseType r101 = new PhaseType("CapturingPhase", 1, 1);
        CapturingPhase = r101;
        PhaseType r102 = new PhaseType("AtTarget", 2, 2);
        AtTarget = r102;
        PhaseType r103 = new PhaseType("BubblingPhase", 3, 3);
        BubblingPhase = r103;
        f404842a = new PhaseType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public PhaseType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
