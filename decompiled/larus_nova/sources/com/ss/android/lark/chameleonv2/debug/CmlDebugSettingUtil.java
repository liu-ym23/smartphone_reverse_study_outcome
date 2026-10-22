package com.ss.android.lark.chameleonv2.debug;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class CmlDebugSettingUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f411374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f411375b = null;

    static {
        f411374a = new com.ss.android.lark.storage.a("chameleon");
        f411375b = LazyKt.lazy(CmlDebugSettingUtil$kvRepo$2.INSTANCE);
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        String r102 = ((KVRepo) f411375b.getValue()).getString(r100, r101);
        if (r102 != null) goto L6;
        return "";
    L6:
        return r102;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ((KVRepo) f411375b.getValue()).putString(r100, r101);
    }
}
