package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/InputActionType;", "", "", "value", "I", "getValue", "()I", "InputActionSend", "InputActionSearch", "InputActionGo", "InputActionDone", "InputActionNext", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum InputActionType extends Enum<InputActionType> {
    public static final InputActionType InputActionDone = null;
    public static final InputActionType InputActionGo = null;
    public static final InputActionType InputActionNext = null;
    public static final InputActionType InputActionSearch = null;
    public static final InputActionType InputActionSend = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputActionType[] f404741a = null;
    private final int value;

    public static InputActionType valueOf(String r100) {
        return (InputActionType) r27.a.a(InputActionType.class, r100);
    }

    public static InputActionType[] values() {
        return (InputActionType[]) f404741a.clone();
    }

    static {
        InputActionType r100 = new InputActionType("InputActionSend", 0, 40019);
        InputActionSend = r100;
        InputActionType r101 = new InputActionType("InputActionSearch", 1, 40020);
        InputActionSearch = r101;
        InputActionType r102 = new InputActionType("InputActionGo", 2, 40021);
        InputActionGo = r102;
        InputActionType r103 = new InputActionType("InputActionDone", 3, 40022);
        InputActionDone = r103;
        InputActionType r104 = new InputActionType("InputActionNext", 4, 40023);
        InputActionNext = r104;
        f404741a = new InputActionType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public InputActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
