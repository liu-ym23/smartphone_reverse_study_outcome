package com.obric.assistant.ipc;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f389985a = null;

    static {
        f389985a = LazyKt.lazy(new c0());
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return "";
    L5:
        String r101 = ((Keva) f389985a.getValue()).getString(c(r100), "");
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public static String c(String r100) {
        return "register_data_id_" + r100;
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "reason");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        ((Keva) f389985a.getValue()).erase(c(r100));
        FLogger.f375446a.i("WakeupTruthUploadRegisterDataStore", "clear register_data_id uid=" + StringsKt.padStart(StringsKt.takeLast(r100, 4), RangesKt.coerceAtMost(r100.length(), 4), '*') + " reason=" + r101);
    }
}
