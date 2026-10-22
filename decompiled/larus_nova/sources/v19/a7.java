package v19;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes27.dex */
public final class a7 {
    static {
    }

    public static void a(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        if (Build.VERSION.SDK_INT < 35) goto L21;
        StringBuilder r102 = new StringBuilder("<");
        if (r100 == null) goto L7;
        String r103 = r100.getClass().getSimpleName();
    L8:
        r102.append(r103);
        r102.append('-');
        r102.append(r101);
        r102.append(Typography.greater);
        String r104 = r102.toString();
        long r105 = System.currentTimeMillis();     // Catch: Exception -> L16
        if (r100 == null) goto L14;
        Resources.Theme r106 = r100.getTheme();     // Catch: Exception -> L16
        if (r106 == null) goto L14;
        r106.applyStyle(R.style.larus_compat_target_35, true);     // Catch: Exception -> L16
    L14:
        long r107 = System.currentTimeMillis() - r105;     // Catch: Exception -> L16
        FLogger.f375446a.d("Target35Compat", r104 + ", applyStyle success, duration:" + r107 + "ms");     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        FLogger.f375446a.e("Target35Compat", r104 + ", applyStyle error:" + e.getMessage());
        return;
    L7:
        r103 = null;
        goto L8
    }
}
