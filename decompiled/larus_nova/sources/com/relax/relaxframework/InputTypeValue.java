package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/InputTypeValue;", "", "", "value", "I", "getValue", "()I", "InputTypeText", "InputTypeNumber", "InputTypeDigit", "InputTypePassword", "InputTypeTel", "InputTypeEmail", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum InputTypeValue extends Enum<InputTypeValue> {
    public static final InputTypeValue InputTypeDigit = null;
    public static final InputTypeValue InputTypeEmail = null;
    public static final InputTypeValue InputTypeNumber = null;
    public static final InputTypeValue InputTypePassword = null;
    public static final InputTypeValue InputTypeTel = null;
    public static final InputTypeValue InputTypeText = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputTypeValue[] f404746a = null;
    private final int value;

    public static InputTypeValue valueOf(String r100) {
        return (InputTypeValue) r27.a.a(InputTypeValue.class, r100);
    }

    public static InputTypeValue[] values() {
        return (InputTypeValue[]) f404746a.clone();
    }

    static {
        InputTypeValue r100 = new InputTypeValue("InputTypeText", 0, 40013);
        InputTypeText = r100;
        InputTypeValue r101 = new InputTypeValue("InputTypeNumber", 1, 40014);
        InputTypeNumber = r101;
        InputTypeValue r102 = new InputTypeValue("InputTypeDigit", 2, 40015);
        InputTypeDigit = r102;
        InputTypeValue r103 = new InputTypeValue("InputTypePassword", 3, 40016);
        InputTypePassword = r103;
        InputTypeValue r104 = new InputTypeValue("InputTypeTel", 4, 40017);
        InputTypeTel = r104;
        InputTypeValue r105 = new InputTypeValue("InputTypeEmail", 5, 40018);
        InputTypeEmail = r105;
        f404746a = new InputTypeValue[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public InputTypeValue(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
