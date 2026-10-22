package mda;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.larus.utils.logger.FLogger;
import ita.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
    L10:
        e = move-exception;
        FLogger.a.e("CommonTools", "isInteractorProcess error : " + e);
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        return Intrinsics.areEqual(r4.getPackageName() + ":interactor", Application.getProcessName());
    L9:
        return StringsKt.endsWith$default(k.c(r4), ":interactor", false, 2, null);
    }

    public static boolean b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
    L9:
        e = move-exception;
        FLogger.a.e("CommonTools", "isMainProcess error : " + e);
        return true;
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L8;
        return Intrinsics.areEqual(r3.getPackageName(), Application.getProcessName());
    L8:
        return k.i(r3);
    }
}
