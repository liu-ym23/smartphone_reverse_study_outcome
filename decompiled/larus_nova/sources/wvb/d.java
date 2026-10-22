package wvb;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f561603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f561604b = 0;

    static {
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b(r100, 100);
    }

    public static void b(Context r100, long r101) {
        Object r102 = r100.getSystemService("vibrator");     // Catch: Exception -> L18
        if ((r102 instanceof Vibrator) == false) goto L6;
        Vibrator r103 = (Vibrator) r102;     // Catch: Exception -> L18
    L7:
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.hasVibrator() == true) goto L14;
        int r104 = bwb.b.f21271a;     // Catch: Exception -> L18
        bwb.b.b(MmUiLogScene.FOUNDATION, "vibrate", "vibrate skipped: device has no vibrator", null, 8);     // Catch: Exception -> L18
        return;
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        r103.vibrate(VibrationEffect.createOneShot(r101, -1));     // Catch: Exception -> L18
        return;
    L16:
        r103.vibrate(r101);     // Catch: Exception -> L18
        return;
    L6:
        r103 = null;
    L18:
        e = move-exception;
        int r105 = bwb.b.f21271a;
        bwb.b.h(MmUiLogScene.FOUNDATION, "vibrate", "vibrate e=" + e, null);
    }
}
