package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/model/BusinessSwitchState;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "MULTI_CHORUS", "NOT_SING", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BusinessSwitchState extends Enum<BusinessSwitchState> {
    public static final BusinessSwitchState MULTI_CHORUS = null;
    public static final BusinessSwitchState NOT_SING = null;
    public static final BusinessSwitchState UNKNOWN = null;
    public static final /* synthetic */ BusinessSwitchState[] a = null;
    private final int value;

    static {
        BusinessSwitchState r1 = new BusinessSwitchState("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        BusinessSwitchState r2 = new BusinessSwitchState("MULTI_CHORUS", 1, 1);
        MULTI_CHORUS = r2;
        BusinessSwitchState r3 = new BusinessSwitchState("NOT_SING", 2, 2);
        NOT_SING = r3;
        a = new BusinessSwitchState[]{r1, r2, r3};
    }

    public static BusinessSwitchState valueOf(String r1) {
        return (BusinessSwitchState) a.a(BusinessSwitchState.class, r1);
    }

    public static BusinessSwitchState[] values() {
        return (BusinessSwitchState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public BusinessSwitchState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
