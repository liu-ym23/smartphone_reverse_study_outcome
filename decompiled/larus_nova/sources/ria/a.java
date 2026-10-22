package ria;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f537920a = 0;

    static {
    }

    @JvmStatic
    public static final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        VibrationEffect r101 = VibrationEffect.createPredefined(1);
        Object r102 = r100.getSystemService("vibrator");
        Vibrator r103 = null;
        if ((r102 instanceof Vibrator) == false) goto L5;
        Vibrator r104 = (Vibrator) r102;
    L6:
        if (r104 != null) goto L8;
        return;
    L8:
        if (r104.hasVibrator() == false) goto L10;
        r103 = r104;
    L10:
        if (r103 == null) goto L14;
        r103.vibrate(r101);
        return;
    L14:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
