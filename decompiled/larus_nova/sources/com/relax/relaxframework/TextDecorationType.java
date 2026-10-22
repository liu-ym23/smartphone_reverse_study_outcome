package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/relax/relaxframework/TextDecorationType;", "", "", "value", "I", "getValue", "()I", "None", "UnderLine", "LineThrough", "Solid", "Double", "Dotted", "Dashed", "Wavy", "Color", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum TextDecorationType extends Enum<TextDecorationType> {
    public static final TextDecorationType Color = null;
    public static final TextDecorationType Dashed = null;
    public static final TextDecorationType Dotted = null;
    public static final TextDecorationType Double = null;
    public static final TextDecorationType LineThrough = null;
    public static final TextDecorationType None = null;
    public static final TextDecorationType Solid = null;
    public static final TextDecorationType UnderLine = null;
    public static final TextDecorationType Wavy = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextDecorationType[] f404966a = null;
    private final int value;

    public static TextDecorationType valueOf(String r100) {
        return (TextDecorationType) r27.a.a(TextDecorationType.class, r100);
    }

    public static TextDecorationType[] values() {
        return (TextDecorationType[]) f404966a.clone();
    }

    static {
        TextDecorationType r100 = new TextDecorationType("None", 0, 0);
        None = r100;
        TextDecorationType r101 = new TextDecorationType("UnderLine", 1, 1);
        UnderLine = r101;
        TextDecorationType r102 = new TextDecorationType("LineThrough", 2, 2);
        LineThrough = r102;
        TextDecorationType r103 = new TextDecorationType("Solid", 3, 4);
        Solid = r103;
        TextDecorationType r104 = new TextDecorationType("Double", 4, 8);
        Double = r104;
        TextDecorationType r110 = new TextDecorationType("Dotted", 5, 16);
        Dotted = r110;
        TextDecorationType r111 = new TextDecorationType("Dashed", 6, 32);
        Dashed = r111;
        TextDecorationType r112 = new TextDecorationType("Wavy", 7, 64);
        Wavy = r112;
        TextDecorationType r113 = new TextDecorationType("Color", 8, 128);
        Color = r113;
        f404966a = new TextDecorationType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
    }

    public final int getValue() {
        return this.value;
    }

    public TextDecorationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
