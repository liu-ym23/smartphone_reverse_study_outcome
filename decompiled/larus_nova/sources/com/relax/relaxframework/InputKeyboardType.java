package com.relax.relaxframework;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/InputKeyboardType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Text", "Number", "Digit", CancelRetainContactInfoFunctions.Password, "Tel", "Email", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum InputKeyboardType extends Enum<InputKeyboardType> {
    public static final InputKeyboardType Digit = null;
    public static final InputKeyboardType Email = null;
    public static final InputKeyboardType Number = null;
    public static final InputKeyboardType Password = null;
    public static final InputKeyboardType Tel = null;
    public static final InputKeyboardType Text = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputKeyboardType[] f404745a = null;
    private final String value;

    public static InputKeyboardType valueOf(String r100) {
        return (InputKeyboardType) r27.a.a(InputKeyboardType.class, r100);
    }

    public static InputKeyboardType[] values() {
        return (InputKeyboardType[]) f404745a.clone();
    }

    static {
        InputKeyboardType r100 = new InputKeyboardType("Text", 0, "text");
        Text = r100;
        InputKeyboardType r101 = new InputKeyboardType("Number", 1, "number");
        Number = r101;
        InputKeyboardType r102 = new InputKeyboardType("Digit", 2, "digit");
        Digit = r102;
        InputKeyboardType r103 = new InputKeyboardType(CancelRetainContactInfoFunctions.Password, 3, "password");
        Password = r103;
        InputKeyboardType r104 = new InputKeyboardType("Tel", 4, "tel");
        Tel = r104;
        InputKeyboardType r105 = new InputKeyboardType("Email", 5, "email");
        Email = r105;
        f404745a = new InputKeyboardType[]{r100, r101, r102, r103, r104, r105};
    }

    public final String getValue() {
        return this.value;
    }

    public InputKeyboardType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
