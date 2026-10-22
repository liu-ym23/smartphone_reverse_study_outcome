package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/InputAttributeKey;", "", "", "value", "I", "getValue", "()I", "ConfirmType", "KeyboardType", "MaxLength", "Readonly", "CaretColor", "ShowSoftInputOnFocus", "InputFilter", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum InputAttributeKey extends Enum<InputAttributeKey> {
    public static final InputAttributeKey CaretColor = null;
    public static final InputAttributeKey ConfirmType = null;
    public static final InputAttributeKey InputFilter = null;
    public static final InputAttributeKey KeyboardType = null;
    public static final InputAttributeKey MaxLength = null;
    public static final InputAttributeKey Readonly = null;
    public static final InputAttributeKey ShowSoftInputOnFocus = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputAttributeKey[] f404742a = null;
    private final int value;

    public static InputAttributeKey valueOf(String r100) {
        return (InputAttributeKey) r27.a.a(InputAttributeKey.class, r100);
    }

    public static InputAttributeKey[] values() {
        return (InputAttributeKey[]) f404742a.clone();
    }

    static {
        InputAttributeKey r100 = new InputAttributeKey("ConfirmType", 0, 20126);
        ConfirmType = r100;
        InputAttributeKey r101 = new InputAttributeKey("KeyboardType", 1, 20123);
        KeyboardType = r101;
        InputAttributeKey r102 = new InputAttributeKey("MaxLength", 2, 20132);
        MaxLength = r102;
        InputAttributeKey r103 = new InputAttributeKey("Readonly", 3, 20154);
        Readonly = r103;
        InputAttributeKey r104 = new InputAttributeKey("CaretColor", 4, 20137);
        CaretColor = r104;
        InputAttributeKey r105 = new InputAttributeKey("ShowSoftInputOnFocus", 5, 20121);
        ShowSoftInputOnFocus = r105;
        InputAttributeKey r110 = new InputAttributeKey("InputFilter", 6, 20280);
        InputFilter = r110;
        f404742a = new InputAttributeKey[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public InputAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
