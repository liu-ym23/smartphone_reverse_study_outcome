package com.larus.dora.impl.ota.connector;

import com.bytedance.keva.Keva;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f337480a = null;

    static {
        f337480a = LazyKt.lazy(new i());
    }

    public static Keva b() {
        return (Keva) f337480a.getValue();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        g49.d.d("OtaWifiRecoveryStore", "clear: reason=" + r100 + ", device=" + c(b().getString("sn", "")) + ", fileName=" + b().getString("file_name", ""));
        b().erase("sn");
        b().erase("file_name");
        b().erase("mark_time");
    }

    public static String c(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L7;
        return "";
    L7:
        return CollectionsKt.joinToString$default(ArraysKt.take(MessageDigest.getInstance("SHA-256").digest(("dora_ota_wifi_recovery_v1:" + r100).getBytes(Charsets.UTF_8)), 16), "", null, null, 0, null, new j(), 30, null);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        if (StringsKt.isBlank(r100) == false) goto L6;
        g49.d.e("OtaWifiRecoveryStore", "markUploadStarted: skip because sn is blank, fileName=" + r101);
        return;
    L6:
        b().storeString("sn", r100);
        b().storeString("file_name", r101);
        b().storeLong("mark_time", System.currentTimeMillis());
        g49.d.d("OtaWifiRecoveryStore", "markUploadStarted: device=" + c(r100) + ", fileName=" + r101);
    }
}
