package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/ShadowOption;", "", "", "value", "I", "getValue", "()I", "None", "Inset", "Initial", "Inherit", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ShadowOption extends Enum<ShadowOption> {
    public static final ShadowOption Inherit = null;
    public static final ShadowOption Initial = null;
    public static final ShadowOption Inset = null;
    public static final ShadowOption None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShadowOption[] f404956a = null;
    private final int value;

    public static ShadowOption valueOf(String r100) {
        return (ShadowOption) r27.a.a(ShadowOption.class, r100);
    }

    public static ShadowOption[] values() {
        return (ShadowOption[]) f404956a.clone();
    }

    static {
        ShadowOption r100 = new ShadowOption("None", 0, 0);
        None = r100;
        ShadowOption r101 = new ShadowOption("Inset", 1, 1);
        Inset = r101;
        ShadowOption r102 = new ShadowOption("Initial", 2, 2);
        Initial = r102;
        ShadowOption r103 = new ShadowOption("Inherit", 3, 3);
        Inherit = r103;
        f404956a = new ShadowOption[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ShadowOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
