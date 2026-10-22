package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/KeyframeState;", "", "", "value", "I", "getValue", "()I", "Init", "Applied", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum KeyframeState extends Enum<KeyframeState> {
    public static final KeyframeState Applied = null;
    public static final KeyframeState Init = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyframeState[] f404752a = null;
    private final int value;

    public static KeyframeState valueOf(String r100) {
        return (KeyframeState) r27.a.a(KeyframeState.class, r100);
    }

    public static KeyframeState[] values() {
        return (KeyframeState[]) f404752a.clone();
    }

    static {
        KeyframeState r100 = new KeyframeState("Init", 0, 0);
        Init = r100;
        KeyframeState r101 = new KeyframeState("Applied", 1, 1);
        Applied = r101;
        f404752a = new KeyframeState[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public KeyframeState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
