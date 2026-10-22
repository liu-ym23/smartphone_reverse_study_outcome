package mda;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import ita.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f513431a = 0;

    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    L10:
        e = move-exception;
        FLogger.f375446a.e("CommonTools", "isInteractorProcess error : " + e);
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        return Intrinsics.areEqual(r100.getPackageName() + ":interactor", Application.getProcessName());
    L9:
        return StringsKt.endsWith$default(k.c(r100), ":interactor", false, 2, null);
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    L9:
        e = move-exception;
        FLogger.f375446a.e("CommonTools", "isMainProcess error : " + e);
        return true;
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        return Intrinsics.areEqual(r100.getPackageName(), Application.getProcessName());
    L8:
        return k.i(r100);
    }
}
