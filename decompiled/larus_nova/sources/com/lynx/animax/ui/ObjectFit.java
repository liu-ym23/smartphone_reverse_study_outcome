package com.lynx.animax.ui;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum ObjectFit extends Enum<ObjectFit> {
    public static final ObjectFit CENTER = null;
    public static final ObjectFit CONTAIN = null;
    public static final ObjectFit COVER = null;
    public static final ObjectFit FILL = null;
    public static final ObjectFit SCALE_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObjectFit[] f380461a = null;

    static {
        ObjectFit r100 = new ObjectFit("CENTER", 0);
        CENTER = r100;
        ObjectFit r101 = new ObjectFit("COVER", 1);
        COVER = r101;
        ObjectFit r102 = new ObjectFit("CONTAIN", 2);
        CONTAIN = r102;
        ObjectFit r103 = new ObjectFit("FILL", 3);
        FILL = r103;
        ObjectFit r104 = new ObjectFit("SCALE_DOWN", 4);
        SCALE_DOWN = r104;
        f380461a = new ObjectFit[]{r100, r101, r102, r103, r104};
    }

    public static ObjectFit[] values() {
        return (ObjectFit[]) f380461a.clone();
    }

    public static ObjectFit valueOf(String r100) {
        return (ObjectFit) a.a(ObjectFit.class, r100);
    }

    public ObjectFit(String r100, int r101) {
        super(r100, r101);
    }
}
