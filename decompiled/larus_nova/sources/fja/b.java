package fja;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f477518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f477519b = null;

    static {
        int[] r100 = new int[RunMode.values().length];
        f477518a = r100;
        r100[RunMode.PARALLEL.ordinal()] = 1;
        r100[RunMode.SERIAL.ordinal()] = 2;
        int[] r101 = new int[RepeatMode.values().length];
        f477519b = r101;
        r101[RepeatMode.LOOP.ordinal()] = 1;
        r101[RepeatMode.REVERSE.ordinal()] = 2;
        r101[RepeatMode.NORMAL.ordinal()] = 3;
    }
}
