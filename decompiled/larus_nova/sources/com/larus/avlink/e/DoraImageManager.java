package com.larus.avlink.e;

import com.larus.utils.logger.FLogger;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class DoraImageManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, com.larus.avlink.model.a> f291761a = null;

    static {
        f291761a = Collections.synchronizedMap(new DoraImageManager$imageInfoMap$1());
    }

    public static com.larus.avlink.model.a a(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        return f291761a.get(r100.toString());
    L5:
        return null;
    }

    public static com.larus.avlink.model.a b(String r100) {
        Map<String, com.larus.avlink.model.a> r101 = f291761a;
        monitor-enter(r101);
        Iterator<T> r102 = r101.values().iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(((com.larus.avlink.model.a) r103).H, r100) == false) goto L6;
    L11:
        com.larus.avlink.model.a r104 = (com.larus.avlink.model.a) r103;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return r104;
    L10:
        r103 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public static void c(int r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        Map<String, com.larus.avlink.model.a> r102 = f291761a;
        com.larus.avlink.model.a r103 = r102.get(String.valueOf(r100));
        if (r103 != null) goto L6;
        FLogger.f375446a.e("DoraImageManager", "model is null, imageUUid: " + r100);
        return;
    L6:
        r101.invoke(r103);
        r102.put(String.valueOf(r100), r103);
    }
}
