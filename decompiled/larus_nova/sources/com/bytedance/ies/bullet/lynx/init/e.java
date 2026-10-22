package com.bytedance.ies.bullet.lynx.init;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.w0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f247345a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, LynxGroup> f247346b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f247347c = null;

    public e() {
    }

    static {
        f247345a = new Object();
        f247346b = new LinkedHashMap();
        f247347c = new LinkedHashMap();
    }

    public static void a(String r100) {
        Map<String, Integer> r101 = f247347c;
        Integer r102 = (Integer) ((LinkedHashMap) r101).get(r100);
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        r101.put(r100, Integer.valueOf(r103 + 1));
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public static void e(String r100) {
        Object r101 = f247345a;
        monitor-enter(r101);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r100.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        monitor-exit(r101);
        return;
    L12:
        Map<String, Integer> r103 = f247347c;     // Catch: Throwable -> L26
        Integer r104 = (Integer) ((LinkedHashMap) r103).get(r100);     // Catch: Throwable -> L26
        if (r104 == null) goto L24;
        int r105 = r104.intValue();     // Catch: Throwable -> L26
        if (r105 != 1) goto L23;
        LynxGroup r106 = f247346b.remove(r100);     // Catch: Throwable -> L26
        if ((r106 instanceof w0) == false) goto L19;
        w0 r107 = (w0) r106;     // Catch: Throwable -> L26
    L20:
        if (r107 == null) goto L22;
        r107.destroy();     // Catch: Throwable -> L26
    L22:
        r103.remove(r100);     // Catch: Throwable -> L26
        goto L24
    L19:
        r107 = null;
        goto L20
    L23:
        r103.put(r100, Integer.valueOf(r105 - 1));     // Catch: Throwable -> L26
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        monitor-exit(r101);
        return;
    L8:
        r102 = false;
        goto L9
    }

    public static /* synthetic */ LynxGroup d(String r100, String[] r101, boolean r102, boolean r103, boolean r110) {
        return c(r100, r101, r102, r103, r110, false);
    }

    public static LynxGroup b(String r100, boolean r101, boolean r110, String[] r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        boolean r102 = true;
        if (r101 == true) goto L5;
        if (r110 == true) goto L16;
        if (r113 == true) goto L16;
        r102 = false;
    L16:
        return LynxGroup.Create(r100, r111, false, r102, r112);
    L5:
        if (r110 == true) goto L9;
        if (r113 == true) goto L9;
        boolean r103 = false;
    L17:
        return LynxGroup.Create(r100, r100, r111, false, r103, r112);
    L9:
        r103 = true;
        goto L17
    }

    public static LynxGroup c(String r110, String[] r111, boolean r112, boolean r113, boolean r114, boolean r115) {
        Intrinsics.checkNotNullParameter(r110, "groupName");
        Object r100 = f247345a;
        monitor-enter(r100);
        a(r110);     // Catch: Throwable -> L19
        Map<String, LynxGroup> r101 = f247346b;     // Catch: Throwable -> L19
        LynxGroup r102 = (LynxGroup) ((LinkedHashMap) r101).get(r110);     // Catch: Throwable -> L19
        if (r102 != null) goto L17;
        if (r115 == true) goto L9;
        r102 = LynxGroup.Create(r110, r111, false, r112, r113, r114);     // Catch: Throwable -> L19
    L16:
        r101.put(r110, r102);     // Catch: Throwable -> L19
        goto L17
    L9:
        if (r112 == true) goto L13;
        if (r114 == true) goto L13;
        boolean r103 = false;
    L14:
        r102 = new w0(r110, r110, r111, r103, r113, null);     // Catch: Throwable -> L19
    L13:
        r103 = true;
    L17:
        monitor-exit(r100);
        return r102;
    L19:
        th = move-exception;
        throw th;
    }
}
