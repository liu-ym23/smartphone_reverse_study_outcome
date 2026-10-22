package t3;

import android.content.Context;
import android.os.PowerManager;
import android.provider.Settings;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f544277b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f544278a;

    public static final class a {
        public a() {
        }

        public static e a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Object r101 = r100.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
            if ((r101 instanceof PowerManager) == false) goto L5;
            PowerManager r102 = (PowerManager) r101;
        L6:
            boolean r103 = true;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
            if (Settings.System.getInt(r100.getContentResolver(), "POWER_SAVE_MODE_OPEN", 0) != 1) goto L10;
            boolean r105 = true;
        L11:
            Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L13
        L15:
            Boolean r107 = Boolean.FALSE;
            if (Result.m9455isFailureimpl(r106) == false) goto L18;
            r106 = r107;
        L18:
            boolean r108 = ((Boolean) r106).booleanValue();
            if (r102 != null) goto L21;
        L23:
            boolean r109 = false;
        L24:
            if (r109 == true) goto L29;
            if (r108 == true) goto L29;
            r103 = false;
        L29:
            return new e(r103);
        L21:
            if (r102.isPowerSaveMode() != true) goto L23;
            r109 = true;
            goto L24
        L10:
            r105 = false;
        L13:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        L5:
            r102 = null;
            goto L6
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f544278a == ((e) r100).f544278a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f544278a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "BatteryInfoChangeSnapshot(isLowPowerModeEnabled=" + this.f544278a + ')';
    }

    static {
        f544277b = new a();
    }

    public e(boolean r100) {
        this.f544278a = r100;
    }
}
