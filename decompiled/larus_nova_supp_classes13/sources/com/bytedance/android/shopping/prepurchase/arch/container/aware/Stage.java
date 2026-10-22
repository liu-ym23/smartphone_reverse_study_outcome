package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/aware/Stage;", "", "", "value", "I", "getValue", "()I", "PAGE_CREATE", "QUERY", "RENDER", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Stage extends Enum<Stage> {
    public static final Stage PAGE_CREATE = null;
    public static final Stage QUERY = null;
    public static final Stage RENDER = null;
    public static final /* synthetic */ Stage[] a = null;
    private final int value;

    static {
        Stage r2 = new Stage("PAGE_CREATE", 0, 1);
        PAGE_CREATE = r2;
        Stage r3 = new Stage("QUERY", 1, 2);
        QUERY = r3;
        Stage r4 = new Stage("RENDER", 2, 3);
        RENDER = r4;
        a = new Stage[]{r2, r3, r4};
    }

    public static Stage valueOf(String r1) {
        return (Stage) r27.a.a(Stage.class, r1);
    }

    public static Stage[] values() {
        return (Stage[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public Stage(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
