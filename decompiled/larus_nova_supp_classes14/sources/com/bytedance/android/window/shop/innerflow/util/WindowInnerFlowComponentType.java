package com.bytedance.android.window.shop.innerflow.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/util/WindowInnerFlowComponentType;", "", "", "type", "I", "getType", "()I", "UNKNOWN", "FOLLOWTOAST", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowInnerFlowComponentType extends Enum<WindowInnerFlowComponentType> {
    public static final WindowInnerFlowComponentType FOLLOWTOAST = null;
    public static final WindowInnerFlowComponentType UNKNOWN = null;
    public static final /* synthetic */ WindowInnerFlowComponentType[] a = null;
    private final int type;

    static {
        WindowInnerFlowComponentType r1 = new WindowInnerFlowComponentType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        WindowInnerFlowComponentType r2 = new WindowInnerFlowComponentType("FOLLOWTOAST", 1, 1);
        FOLLOWTOAST = r2;
        a = new WindowInnerFlowComponentType[]{r1, r2};
    }

    public static WindowInnerFlowComponentType valueOf(String r1) {
        return (WindowInnerFlowComponentType) r27.a.a(WindowInnerFlowComponentType.class, r1);
    }

    public static WindowInnerFlowComponentType[] values() {
        return (WindowInnerFlowComponentType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public WindowInnerFlowComponentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
