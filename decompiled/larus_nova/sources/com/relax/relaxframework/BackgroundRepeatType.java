package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/relax/relaxframework/BackgroundRepeatType;", "", "", "value", "I", "getValue", "()I", "Repeat", "NoRepeat", "RepeatX", "RepeatY", "Round", "Space", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum BackgroundRepeatType extends Enum<BackgroundRepeatType> {
    public static final BackgroundRepeatType NoRepeat = null;
    public static final BackgroundRepeatType Repeat = null;
    public static final BackgroundRepeatType RepeatX = null;
    public static final BackgroundRepeatType RepeatY = null;
    public static final BackgroundRepeatType Round = null;
    public static final BackgroundRepeatType Space = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundRepeatType[] f404684a = null;
    private final int value;

    public static BackgroundRepeatType valueOf(String r100) {
        return (BackgroundRepeatType) r27.a.a(BackgroundRepeatType.class, r100);
    }

    public static BackgroundRepeatType[] values() {
        return (BackgroundRepeatType[]) f404684a.clone();
    }

    static {
        BackgroundRepeatType r100 = new BackgroundRepeatType("Repeat", 0, 0);
        Repeat = r100;
        BackgroundRepeatType r101 = new BackgroundRepeatType("NoRepeat", 1, 1);
        NoRepeat = r101;
        BackgroundRepeatType r102 = new BackgroundRepeatType("RepeatX", 2, 2);
        RepeatX = r102;
        BackgroundRepeatType r103 = new BackgroundRepeatType("RepeatY", 3, 3);
        RepeatY = r103;
        BackgroundRepeatType r104 = new BackgroundRepeatType("Round", 4, 4);
        Round = r104;
        BackgroundRepeatType r105 = new BackgroundRepeatType("Space", 5, 5);
        Space = r105;
        f404684a = new BackgroundRepeatType[]{r100, r101, r102, r103, r104, r105};
    }

    public final int getValue() {
        return this.value;
    }

    public BackgroundRepeatType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
