package py8;

import android.companion.CompanionDeviceManager;
import android.content.Context;
import android.os.Build;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {
    public static final b a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 26) goto L17;
        CompanionDeviceManager r102 = (CompanionDeviceManager) r100.getSystemService(CompanionDeviceManager.class);
        if (r102 == null) goto L15;
        if (r101 < 33) goto L10;
        return new f(r102);
    L10:
        if (r101 < 31) goto L13;
        return new e(r102);
    L13:
        return new d(r102);
    L15:
        return new g();
    L17:
        return new g();
    }
}
