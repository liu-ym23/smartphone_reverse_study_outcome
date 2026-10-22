package v19;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Context[] f552451a = null;

    static {
        f552451a = new Context[2];
    }

    public static final int a(int r100, Context r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return ContextCompat.getColor(r101, b(r100, r101, r102));
    }

    public static final int b(int r100, Context r101, int r102) {
        if (r101 != null) goto L18;
        AppHost.Companion r103 = AppHost.f326268a;
        Activity r104 = r103.a().getCurrentActivity();
        if (r104 == null) goto L6;
        r101 = r104;
        goto L18
    L6:
        boolean r105 = com.larus.platform.service.z2.f365865a.enableSwDpOffline();
        Context[] r106 = f552451a;
        monitor-enter(r106);
        Context r107 = r106[r105 ? 1 : 0];     // Catch: Throwable -> L15
        if (r107 == null) goto L12;
        monitor-exit(r106);
        r101 = r107;
        goto L18
    L12:
        r101 = f.d(r103.getApplication());     // Catch: Throwable -> L15
        r106[r105 ? 1 : 0] = r101;     // Catch: Throwable -> L15
        monitor-exit(r106);
    L15:
        th = move-exception;
        throw th;
    L18:
        TypedValue r108 = new TypedValue();
        Resources.Theme r109 = r101.getTheme();     // Catch: Exception -> L26
        if (r109 == null) goto L22;
        r109.resolveAttribute(r100, r108, true);     // Catch: Exception -> L26
    L22:
        int r110 = r108.resourceId;     // Catch: Exception -> L26
        if (r110 != 0) goto L25;
        return r102;
    L25:
        return r110;
    L26:
        return r102;
    }

    public static final int c(int r100, Context r101, int r102) {
        if (r101 != null) goto L4;
        r101 = AppHost.f326268a.a().getCurrentActivity();
    L4:
        TypedValue r103 = new TypedValue();
        boolean r104 = false;
        if (r101 != null) goto L15;
    L11:
        if (r104 == false) goto L17;
        return r103.data;
    L18:
        return r102;
    L17:
        return r102;
    L15:
        Resources.Theme r105 = r101.getTheme();     // Catch: Exception -> L14
        if (r105 == null) goto L11;
        if (r105.resolveAttribute(r100, r103, true) != true) goto L11;
        r104 = true;
        goto L11
    }
}
