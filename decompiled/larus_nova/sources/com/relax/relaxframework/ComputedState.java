package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/ComputedState;", "", "", "value", "I", "getValue", "()I", "Clean", "Dirty", "Checked", "Computing", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ComputedState extends Enum<ComputedState> {
    public static final ComputedState Checked = null;
    public static final ComputedState Clean = null;
    public static final ComputedState Computing = null;
    public static final ComputedState Dirty = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComputedState[] f404695a = null;
    private final int value;

    public static ComputedState valueOf(String r100) {
        return (ComputedState) r27.a.a(ComputedState.class, r100);
    }

    public static ComputedState[] values() {
        return (ComputedState[]) f404695a.clone();
    }

    static {
        ComputedState r100 = new ComputedState("Clean", 0, 0);
        Clean = r100;
        ComputedState r101 = new ComputedState("Dirty", 1, 1);
        Dirty = r101;
        ComputedState r102 = new ComputedState("Checked", 2, 2);
        Checked = r102;
        ComputedState r103 = new ComputedState("Computing", 3, 3);
        Computing = r103;
        f404695a = new ComputedState[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ComputedState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
