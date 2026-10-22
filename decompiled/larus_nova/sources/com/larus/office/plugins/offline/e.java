package com.larus.office.plugins.offline;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f363101a = 0;

    static {
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        FLogger.f375446a.i("OfflineDocReport", "OfficeOfflineDocCreate, " + r100);
    }

    public static String c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        if (r100 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r100.length() + ",hash=" + r100.hashCode();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (r101 != null) goto L5;
        FLogger.f375446a.e("OfflineDocReport", "OfficeOfflineDocCreate, " + r100);
        return;
    L5:
        FLogger.f375446a.e("OfflineDocReport", "OfficeOfflineDocCreate, " + r100, r101);
    }
}
