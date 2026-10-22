package com.relax.relaxreact;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxreact/SetGestureStateType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Active", CheckStatus.FAIL, "End", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum SetGestureStateType extends Enum<SetGestureStateType> {
    public static final SetGestureStateType Active = null;
    public static final SetGestureStateType End = null;
    public static final SetGestureStateType Fail = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SetGestureStateType[] f405435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f405436b = null;
    private final int value;

    public static EnumEntries<SetGestureStateType> getEntries() {
        return f405436b;
    }

    public static SetGestureStateType valueOf(String r100) {
        return (SetGestureStateType) r27.a.a(SetGestureStateType.class, r100);
    }

    public static SetGestureStateType[] values() {
        return (SetGestureStateType[]) f405435a.clone();
    }

    static {
        SetGestureStateType r100 = new SetGestureStateType("Active", 0, 1);
        Active = r100;
        SetGestureStateType r101 = new SetGestureStateType(CheckStatus.FAIL, 1, 2);
        Fail = r101;
        SetGestureStateType r102 = new SetGestureStateType("End", 2, 3);
        End = r102;
        SetGestureStateType[] r103 = {r100, r101, r102};
        f405435a = r103;
        f405436b = EnumEntriesKt.enumEntries(r103);
    }

    public final int getValue() {
        return this.value;
    }

    public SetGestureStateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
