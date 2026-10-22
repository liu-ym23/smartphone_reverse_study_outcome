package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/relax/relaxframework/TextareaAttributeKey;", "", "", "value", "I", "getValue", "()I", "ConfirmType", "KeyboardType", "MaxLength", "Readonly", "CaretColor", "ShowSoftInputOnFocus", "InputFilter", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TextareaAttributeKey extends Enum<TextareaAttributeKey> {
    public static final TextareaAttributeKey CaretColor = null;
    public static final TextareaAttributeKey ConfirmType = null;
    public static final TextareaAttributeKey InputFilter = null;
    public static final TextareaAttributeKey KeyboardType = null;
    public static final TextareaAttributeKey MaxLength = null;
    public static final TextareaAttributeKey Readonly = null;
    public static final TextareaAttributeKey ShowSoftInputOnFocus = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextareaAttributeKey[] f404972a = null;
    private final int value;

    public static TextareaAttributeKey valueOf(String r100) {
        return (TextareaAttributeKey) r27.a.a(TextareaAttributeKey.class, r100);
    }

    public static TextareaAttributeKey[] values() {
        return (TextareaAttributeKey[]) f404972a.clone();
    }

    static {
        TextareaAttributeKey r100 = new TextareaAttributeKey("ConfirmType", 0, 20126);
        ConfirmType = r100;
        TextareaAttributeKey r101 = new TextareaAttributeKey("KeyboardType", 1, 20123);
        KeyboardType = r101;
        TextareaAttributeKey r102 = new TextareaAttributeKey("MaxLength", 2, 20132);
        MaxLength = r102;
        TextareaAttributeKey r103 = new TextareaAttributeKey("Readonly", 3, 20154);
        Readonly = r103;
        TextareaAttributeKey r104 = new TextareaAttributeKey("CaretColor", 4, 20137);
        CaretColor = r104;
        TextareaAttributeKey r105 = new TextareaAttributeKey("ShowSoftInputOnFocus", 5, 20121);
        ShowSoftInputOnFocus = r105;
        TextareaAttributeKey r110 = new TextareaAttributeKey("InputFilter", 6, 20280);
        InputFilter = r110;
        f404972a = new TextareaAttributeKey[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getValue() {
        return this.value;
    }

    public TextareaAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
