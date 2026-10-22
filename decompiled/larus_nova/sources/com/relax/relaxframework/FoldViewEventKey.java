package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/relax/relaxframework/FoldViewEventKey;", "", "", "value", "I", "getValue", "()I", "FoldViewOffset", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FoldViewEventKey extends Enum<FoldViewEventKey> {
    public static final FoldViewEventKey FoldViewOffset = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FoldViewEventKey[] f404726a = null;
    private final int value;

    public static FoldViewEventKey valueOf(String r100) {
        return (FoldViewEventKey) r27.a.a(FoldViewEventKey.class, r100);
    }

    public static FoldViewEventKey[] values() {
        return (FoldViewEventKey[]) f404726a.clone();
    }

    static {
        FoldViewEventKey r100 = new FoldViewEventKey();
        FoldViewOffset = r100;
        f404726a = new FoldViewEventKey[]{r100};
    }

    public FoldViewEventKey() {
        super("FoldViewOffset", 0);
        this.value = 30122;
    }

    public final int getValue() {
        return this.value;
    }
}
