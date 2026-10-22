package dm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f469204a = 0;

    static {
    }

    public static String a(StackTraceElement r100) {
        String r101 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r102 = new StringBuilder();
        String r103 = r100.getClassName();
        if (r103 == null) goto L9;
        r101 = r103.substring(StringsKt.lastIndexOf$default(r103, ".", 0, false, 6, null) + 1);
    L9:
        r102.append(r101);
        r102.append(".");
        r102.append(r100.getMethodName());
        r102.append("  (");
        r102.append(r100.getFileName());
        r102.append(":");
        r102.append(r100.getLineNumber());
        r102.append(")");
        return r102.toString();
    }

    public static void b(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        em.a.f473045b.a(6, "LogUtils", "getStackOffset failed since " + r100.getMessage());
        em.b.f473046a.a(6, "LogUtils", "getStackOffset failed since " + r100.getMessage());
    }
}
