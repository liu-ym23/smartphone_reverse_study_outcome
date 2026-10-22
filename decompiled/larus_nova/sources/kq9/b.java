package kq9;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f505614a = null;

    static {
        f505614a = new LinkedHashMap();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "albumNodeId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        Map<String, Integer> r101 = f505614a;
        monitor-enter(r101);
        Integer r102 = (Integer) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L14
        if (r102 == null) goto L10;
        int r103 = r102.intValue();     // Catch: Throwable -> L14
    L11:
        r101.put(r100, Integer.valueOf(r103 + 1));     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return;
    L10:
        r103 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "albumNodeId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        Map<String, Integer> r101 = f505614a;
        monitor-enter(r101);
        Integer r102 = (Integer) ((LinkedHashMap) r101).get(r100);     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        int r103 = r102.intValue();     // Catch: Throwable -> L17
    L11:
        int r104 = r103 - 1;     // Catch: Throwable -> L17
        if (r104 <= 0) goto L14;
        r101.put(r100, Integer.valueOf(r104));     // Catch: Throwable -> L17
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        monitor-exit(r101);
        return;
    L14:
        r101.remove(r100);     // Catch: Throwable -> L17
        goto L15
    L10:
        r103 = 0;
    L17:
        th = move-exception;
        throw th;
    }

    public static boolean c(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        Map<String, Integer> r103 = f505614a;
        monitor-enter(r103);
        Integer r104 = (Integer) ((LinkedHashMap) r103).get(r100);     // Catch: Throwable -> L23
        if (r104 == null) goto L17;
        int r105 = r104.intValue();     // Catch: Throwable -> L23
    L18:
        if (r105 > 0) goto L21;
        r101 = false;
    L21:
        monitor-exit(r103);
        return r101;
    L17:
        r105 = 0;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }
}
