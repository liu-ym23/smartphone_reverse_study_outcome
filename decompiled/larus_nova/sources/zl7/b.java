package zl7;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f572790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f572791b;

    static {
    }

    public static boolean a(Context r100) {
        if (f572790a == false) goto L21;
        return f572791b;
    L21:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        f572791b = !Process.is64Bit();     // Catch: Throwable -> L20
        goto L18
    L10:
        if (r100 == null) goto L16;
        ClassLoader r101 = r100.getClassLoader();     // Catch: Throwable -> L20
        boolean r102 = false;
        Object r103 = r101.getClass().getDeclaredMethod("findLibrary", new Class[]{StringCompanionObject.INSTANCE.getClass()}).invoke(r101, new Object[]{"art"});     // Catch: Throwable -> L20
        if ((r103 instanceof String) == false) goto L16;
        if (StringsKt.contains$default((CharSequence) r103, "lib64", false, 2, null) == false) goto L16;
    L17:
        f572791b = r102;     // Catch: Throwable -> L20
    L16:
        r102 = true;
    L18:
        f572790a = true;
        return f572791b;
    }
}
