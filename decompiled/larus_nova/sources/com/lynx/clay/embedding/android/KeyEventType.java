package com.lynx.clay.embedding.android;

/* JADX INFO: loaded from: classes32.dex */
public final enum KeyEventType extends Enum<KeyEventType> {
    public static final KeyEventType COMMIT_COMPOSING_TEXT = null;
    public static final KeyEventType COMMIT_TEXT = null;
    public static final KeyEventType DOWN = null;
    public static final KeyEventType REPEAT = null;
    public static final KeyEventType UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyEventType[] f380587a = null;

    static {
        KeyEventType r100 = new KeyEventType("DOWN", 0);
        DOWN = r100;
        KeyEventType r101 = new KeyEventType("UP", 1);
        UP = r101;
        KeyEventType r102 = new KeyEventType("REPEAT", 2);
        REPEAT = r102;
        KeyEventType r103 = new KeyEventType("COMMIT_TEXT", 3);
        COMMIT_TEXT = r103;
        KeyEventType r104 = new KeyEventType("COMMIT_COMPOSING_TEXT", 4);
        COMMIT_COMPOSING_TEXT = r104;
        f380587a = new KeyEventType[]{r100, r101, r102, r103, r104};
    }

    public static KeyEventType[] values() {
        return (KeyEventType[]) f380587a.clone();
    }

    public static KeyEventType valueOf(String r100) {
        return (KeyEventType) r27.a.a(KeyEventType.class, r100);
    }

    public KeyEventType(String r100, int r101) {
        super(r100, r101);
    }
}
