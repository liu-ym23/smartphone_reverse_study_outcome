package com.ss.android.lark.time.format.common;

import com.ss.ttm.player.MediaPlayer;
import java.util.GregorianCalendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f441325a = 0;

    static {
    }

    public static int b(GregorianCalendar r100) {
        Intrinsics.checkNotNullParameter(r100, "gregorianCalendar");
        int r101 = r100.get(1);
        int r102 = r100.get(2) + 1;
        int r103 = (r102 - 14) / 12;
        return (((((((r101 + 4800) + r103) * 1461) / 4) + ((((r102 - 2) - (r103 * 12)) * MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME) / 12)) - (((((r101 + 4900) + r103) / 100) * 3) / 4)) + r100.get(5)) - 32075;
    }

    public static int a(GregorianCalendar r100, GregorianCalendar r101) {
        Intrinsics.checkNotNullParameter(r100, "firstGC");
        Intrinsics.checkNotNullParameter(r101, "secondGC");
        return b(r100) - b(r101);
    }

    public static boolean c(GregorianCalendar r100, GregorianCalendar r101) {
        Intrinsics.checkNotNullParameter(r100, "firstGC");
        Intrinsics.checkNotNullParameter(r101, "secondGC");
        if (a(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean d(GregorianCalendar r100, GregorianCalendar r101) {
        Intrinsics.checkNotNullParameter(r100, "firstGC");
        Intrinsics.checkNotNullParameter(r101, "secondGC");
        if (r100.get(1) == r101.get(1)) goto L7;
        return false;
    L7:
        return true;
    }
}
