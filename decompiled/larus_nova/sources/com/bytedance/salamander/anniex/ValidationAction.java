package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/ValidationAction;", "", "", "value", "I", "getValue", "()I", "Exception", "Discard", "CutOff", "None", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ValidationAction extends Enum<ValidationAction> {
    public static final ValidationAction CutOff = null;
    public static final ValidationAction Discard = null;
    public static final ValidationAction Exception = null;
    public static final ValidationAction None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ValidationAction[] f267927a = null;
    private final int value;

    public static ValidationAction valueOf(String r100) {
        return (ValidationAction) r27.a.a(ValidationAction.class, r100);
    }

    public static ValidationAction[] values() {
        return (ValidationAction[]) f267927a.clone();
    }

    static {
        ValidationAction r100 = new ValidationAction("Exception", 0, 0);
        Exception = r100;
        ValidationAction r101 = new ValidationAction("Discard", 1, 1);
        Discard = r101;
        ValidationAction r102 = new ValidationAction("CutOff", 2, 2);
        CutOff = r102;
        ValidationAction r103 = new ValidationAction("None", 3, 3);
        None = r103;
        f267927a = new ValidationAction[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ValidationAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
