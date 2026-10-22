package com.bytedance.salamander.anniex;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/salamander/anniex/BreakPoint;", "", "", "value", "I", "getValue", "()I", "Type320", "Type375", "Type480", "Type600", "Type704", "Type800", "Type960", "Type1024", "Type1366", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum BreakPoint extends Enum<BreakPoint> {
    public static final BreakPoint Type1024 = null;
    public static final BreakPoint Type1366 = null;
    public static final BreakPoint Type320 = null;
    public static final BreakPoint Type375 = null;
    public static final BreakPoint Type480 = null;
    public static final BreakPoint Type600 = null;
    public static final BreakPoint Type704 = null;
    public static final BreakPoint Type800 = null;
    public static final BreakPoint Type960 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BreakPoint[] f267870a = null;
    private final int value;

    public static BreakPoint valueOf(String r100) {
        return (BreakPoint) r27.a.a(BreakPoint.class, r100);
    }

    public static BreakPoint[] values() {
        return (BreakPoint[]) f267870a.clone();
    }

    static {
        BreakPoint r100 = new BreakPoint("Type320", 0, 320);
        Type320 = r100;
        BreakPoint r101 = new BreakPoint("Type375", 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
        Type375 = r101;
        BreakPoint r102 = new BreakPoint("Type480", 2, 480);
        Type480 = r102;
        BreakPoint r103 = new BreakPoint("Type600", 3, 600);
        Type600 = r103;
        BreakPoint r104 = new BreakPoint("Type704", 4, 704);
        Type704 = r104;
        BreakPoint r105 = new BreakPoint("Type800", 5, 800);
        Type800 = r105;
        BreakPoint r110 = new BreakPoint("Type960", 6, 960);
        Type960 = r110;
        BreakPoint r111 = new BreakPoint("Type1024", 7, 1024);
        Type1024 = r111;
        BreakPoint r112 = new BreakPoint("Type1366", 8, 1366);
        Type1366 = r112;
        f267870a = new BreakPoint[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    public BreakPoint(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
