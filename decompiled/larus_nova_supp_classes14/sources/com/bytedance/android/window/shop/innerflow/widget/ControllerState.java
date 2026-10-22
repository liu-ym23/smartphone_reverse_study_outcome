package com.bytedance.android.window.shop.innerflow.widget;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;", "", "ENABLED", "DISABLED", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ControllerState extends Enum<ControllerState> {
    public static final ControllerState DISABLED = null;
    public static final ControllerState ENABLED = null;
    public static final /* synthetic */ ControllerState[] a = null;

    static {
        ControllerState r1 = new ControllerState("ENABLED", 0);
        ENABLED = r1;
        ControllerState r2 = new ControllerState("DISABLED", 1);
        DISABLED = r2;
        a = new ControllerState[]{r1, r2};
    }

    public static ControllerState valueOf(String r1) {
        return (ControllerState) a.a(ControllerState.class, r1);
    }

    public static ControllerState[] values() {
        return (ControllerState[]) a.clone();
    }

    public ControllerState(String r1, int r2) {
        super(r1, r2);
    }
}
