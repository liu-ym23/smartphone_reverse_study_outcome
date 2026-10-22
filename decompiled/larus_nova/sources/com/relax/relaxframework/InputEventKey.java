package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/InputEventKey;", "", "", "value", "I", "getValue", "()I", "InputFocus", "InputBlur", "InputConfirm", "InputInput", "InputSelectionChange", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum InputEventKey extends Enum<InputEventKey> {
    public static final InputEventKey InputBlur = null;
    public static final InputEventKey InputConfirm = null;
    public static final InputEventKey InputFocus = null;
    public static final InputEventKey InputInput = null;
    public static final InputEventKey InputSelectionChange = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputEventKey[] f404744a = null;
    private final int value;

    public static InputEventKey valueOf(String r100) {
        return (InputEventKey) r27.a.a(InputEventKey.class, r100);
    }

    public static InputEventKey[] values() {
        return (InputEventKey[]) f404744a.clone();
    }

    static {
        InputEventKey r100 = new InputEventKey("InputFocus", 0, 30003);
        InputFocus = r100;
        InputEventKey r101 = new InputEventKey("InputBlur", 1, 30004);
        InputBlur = r101;
        InputEventKey r102 = new InputEventKey("InputConfirm", 2, 30019);
        InputConfirm = r102;
        InputEventKey r103 = new InputEventKey("InputInput", 3, 30017);
        InputInput = r103;
        InputEventKey r104 = new InputEventKey("InputSelectionChange", 4, 30018);
        InputSelectionChange = r104;
        f404744a = new InputEventKey[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public InputEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
