package com.relax.relaxframework;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/SetGestureStateType;", "", "", "value", "I", "getValue", "()I", "Active", CheckStatus.FAIL, "End", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum SetGestureStateType extends Enum<SetGestureStateType> {
    public static final SetGestureStateType Active = null;
    public static final SetGestureStateType End = null;
    public static final SetGestureStateType Fail = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SetGestureStateType[] f404955a = null;
    private final int value;

    public static SetGestureStateType valueOf(String r100) {
        return (SetGestureStateType) r27.a.a(SetGestureStateType.class, r100);
    }

    public static SetGestureStateType[] values() {
        return (SetGestureStateType[]) f404955a.clone();
    }

    static {
        SetGestureStateType r100 = new SetGestureStateType("Active", 0, 1);
        Active = r100;
        SetGestureStateType r101 = new SetGestureStateType(CheckStatus.FAIL, 1, 2);
        Fail = r101;
        SetGestureStateType r102 = new SetGestureStateType("End", 2, 3);
        End = r102;
        f404955a = new SetGestureStateType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public SetGestureStateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
