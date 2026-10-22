package v19;

import android.app.Activity;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f552477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f552478b = null;

    public h() {
    }

    static {
        f552478b = LazyKt.lazy(new g());
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L7;
        AppHost.Companion r101 = AppHost.f326268a;
        Activity r102 = r101.a().getCurrentActivity();
        if (r102 != null) goto L6;
        r100 = r101.getApplication();
        goto L7
    L6:
        r100 = r102;
    L7:
        Boolean r103 = c(r100);
        if (r103 == null) goto L11;
        return r103.booleanValue();
    L11:
        return f552477a;
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r101 = c(r100);
        if (r101 == null) goto L17;
        return r101.booleanValue();
    L17:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L19;
        return true;
    L19:
        return false;
    L12:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Throwable r104 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r104 == null) goto L16;
        FLogger.f375446a.i("DarkModeUtil", "isNightMode fail " + r104);
    L16:
        return false;
    }

    public static Boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.larus.platform.exp.h.f365384a == false) goto L5;
        boolean r101 = ((Boolean) f552478b.getValue()).booleanValue();
    L7:
        if (r101 == true) goto L9;
        return null;
    L9:
        int r102 = c.c(R.attr.larus_theme_tag, r100, 0);
        if (r102 == 1) goto L16;
        if (r102 == 2) goto L17;
        return null;
    L17:
        return Boolean.TRUE;
    L16:
        return Boolean.FALSE;
    L5:
        r101 = com.larus.platform.service.z2.f365865a.supportLarusThemeTag();
        goto L7
    }
}
