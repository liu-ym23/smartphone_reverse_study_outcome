package com.larus.audio;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f289664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f289665b = null;

    public f() {
    }

    static {
        f289664a = new f();
        f289665b = LazyKt.lazy(new e());
    }

    public static Map a() {
        return (Map) f289665b.getValue();
    }

    public static boolean b() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("hasConnection: ");
        r101.append(!a().isEmpty());
        r100.i("AudioConnectionPoolManager", r101.toString());
        return !a().isEmpty();
    }

    @Override // com.larus.audio.q0
    public final String o(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        Iterator r101 = a().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((Map.Entry) r102).getValue(), r100) == false) goto L4;
    L9:
        Map.Entry r103 = (Map.Entry) r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        return (String) r103.getKey();
    L8:
        r102 = null;
        goto L9
    }
}
