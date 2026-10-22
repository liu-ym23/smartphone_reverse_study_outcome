package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/ModifierValue_LinearLayoutGravity;", "", "", "value", "I", "getValue", "()I", "None", "Top", "Bottom", "Left", "Right", "CenterVertical", "CenterHorizontal", "FillVertical", "FillHorizontal", "Center", "Stretch", "Start", "End", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ModifierValue_LinearLayoutGravity extends Enum<ModifierValue_LinearLayoutGravity> {
    public static final ModifierValue_LinearLayoutGravity Bottom = null;
    public static final ModifierValue_LinearLayoutGravity Center = null;
    public static final ModifierValue_LinearLayoutGravity CenterHorizontal = null;
    public static final ModifierValue_LinearLayoutGravity CenterVertical = null;
    public static final ModifierValue_LinearLayoutGravity End = null;
    public static final ModifierValue_LinearLayoutGravity FillHorizontal = null;
    public static final ModifierValue_LinearLayoutGravity FillVertical = null;
    public static final ModifierValue_LinearLayoutGravity Left = null;
    public static final ModifierValue_LinearLayoutGravity None = null;
    public static final ModifierValue_LinearLayoutGravity Right = null;
    public static final ModifierValue_LinearLayoutGravity Start = null;
    public static final ModifierValue_LinearLayoutGravity Stretch = null;
    public static final ModifierValue_LinearLayoutGravity Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModifierValue_LinearLayoutGravity[] f404816a = null;
    private final int value;

    public static ModifierValue_LinearLayoutGravity valueOf(String r100) {
        return (ModifierValue_LinearLayoutGravity) r27.a.a(ModifierValue_LinearLayoutGravity.class, r100);
    }

    public static ModifierValue_LinearLayoutGravity[] values() {
        return (ModifierValue_LinearLayoutGravity[]) f404816a.clone();
    }

    static {
        ModifierValue_LinearLayoutGravity r100 = new ModifierValue_LinearLayoutGravity("None", 0, 0);
        None = r100;
        ModifierValue_LinearLayoutGravity r101 = new ModifierValue_LinearLayoutGravity("Top", 1, 1);
        Top = r101;
        ModifierValue_LinearLayoutGravity r102 = new ModifierValue_LinearLayoutGravity("Bottom", 2, 2);
        Bottom = r102;
        ModifierValue_LinearLayoutGravity r103 = new ModifierValue_LinearLayoutGravity("Left", 3, 3);
        Left = r103;
        ModifierValue_LinearLayoutGravity r104 = new ModifierValue_LinearLayoutGravity("Right", 4, 4);
        Right = r104;
        ModifierValue_LinearLayoutGravity r105 = new ModifierValue_LinearLayoutGravity("CenterVertical", 5, 5);
        CenterVertical = r105;
        ModifierValue_LinearLayoutGravity r110 = new ModifierValue_LinearLayoutGravity("CenterHorizontal", 6, 6);
        CenterHorizontal = r110;
        ModifierValue_LinearLayoutGravity r111 = new ModifierValue_LinearLayoutGravity("FillVertical", 7, 7);
        FillVertical = r111;
        ModifierValue_LinearLayoutGravity r112 = new ModifierValue_LinearLayoutGravity("FillHorizontal", 8, 8);
        FillHorizontal = r112;
        ModifierValue_LinearLayoutGravity r113 = new ModifierValue_LinearLayoutGravity("Center", 9, 9);
        Center = r113;
        ModifierValue_LinearLayoutGravity r114 = new ModifierValue_LinearLayoutGravity("Stretch", 10, 10);
        Stretch = r114;
        ModifierValue_LinearLayoutGravity r115 = new ModifierValue_LinearLayoutGravity("Start", 11, 11);
        Start = r115;
        ModifierValue_LinearLayoutGravity r106 = new ModifierValue_LinearLayoutGravity("End", 12, 12);
        End = r106;
        f404816a = new ModifierValue_LinearLayoutGravity[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
    }

    public final int getValue() {
        return this.value;
    }

    public ModifierValue_LinearLayoutGravity(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
