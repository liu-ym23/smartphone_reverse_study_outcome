package com.ss.android.lark.player.widget;

import java.io.Serializable;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum AspectRatio extends Enum<AspectRatio> implements Serializable {
    public static final AspectRatio AspectRatio_16_9 = null;
    public static final AspectRatio AspectRatio_4_3 = null;
    public static final AspectRatio AspectRatio_FILL_PARENT = null;
    public static final AspectRatio AspectRatio_FIT_PARENT = null;
    public static final AspectRatio AspectRatio_MATCH_PARENT = null;
    public static final AspectRatio AspectRatio_ORIGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AspectRatio[] f438727a = null;

    static {
        AspectRatio r100 = new AspectRatio("AspectRatio_16_9", 0);
        AspectRatio_16_9 = r100;
        AspectRatio r101 = new AspectRatio("AspectRatio_4_3", 1);
        AspectRatio_4_3 = r101;
        AspectRatio r102 = new AspectRatio("AspectRatio_MATCH_PARENT", 2);
        AspectRatio_MATCH_PARENT = r102;
        AspectRatio r103 = new AspectRatio("AspectRatio_FILL_PARENT", 3);
        AspectRatio_FILL_PARENT = r103;
        AspectRatio r104 = new AspectRatio("AspectRatio_FIT_PARENT", 4);
        AspectRatio_FIT_PARENT = r104;
        AspectRatio r105 = new AspectRatio("AspectRatio_ORIGIN", 5);
        AspectRatio_ORIGIN = r105;
        f438727a = new AspectRatio[]{r100, r101, r102, r103, r104, r105};
    }

    public static AspectRatio[] values() {
        return (AspectRatio[]) f438727a.clone();
    }

    public static AspectRatio valueOf(String r100) {
        return (AspectRatio) a.a(AspectRatio.class, r100);
    }

    public AspectRatio(String r100, int r101) {
        super(r100, r101);
    }
}
