package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/TextareaEventKey;", "", "", "value", "I", "getValue", "()I", "TextareaFocus", "TextareaBlur", "TextareaConfirm", "TextareaInput", "TextareaSelectionChange", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TextareaEventKey extends Enum<TextareaEventKey> {
    public static final TextareaEventKey TextareaBlur = null;
    public static final TextareaEventKey TextareaConfirm = null;
    public static final TextareaEventKey TextareaFocus = null;
    public static final TextareaEventKey TextareaInput = null;
    public static final TextareaEventKey TextareaSelectionChange = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextareaEventKey[] f404973a = null;
    private final int value;

    public static TextareaEventKey valueOf(String r100) {
        return (TextareaEventKey) r27.a.a(TextareaEventKey.class, r100);
    }

    public static TextareaEventKey[] values() {
        return (TextareaEventKey[]) f404973a.clone();
    }

    static {
        TextareaEventKey r100 = new TextareaEventKey("TextareaFocus", 0, 30003);
        TextareaFocus = r100;
        TextareaEventKey r101 = new TextareaEventKey("TextareaBlur", 1, 30004);
        TextareaBlur = r101;
        TextareaEventKey r102 = new TextareaEventKey("TextareaConfirm", 2, 30019);
        TextareaConfirm = r102;
        TextareaEventKey r103 = new TextareaEventKey("TextareaInput", 3, 30017);
        TextareaInput = r103;
        TextareaEventKey r104 = new TextareaEventKey("TextareaSelectionChange", 4, 30018);
        TextareaSelectionChange = r104;
        f404973a = new TextareaEventKey[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public TextareaEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
