package com.larus.home.impl.main.side_bar.feed.arch;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f344637a = 0;

    static {
    }

    public static String d(String r100) {
        if (r100 != null) goto L4;
    L13:
        return "unknown";
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L13;
        String r102 = Integer.toHexString(r100.hashCode());
        if (r102 == null) goto L13;
        return r102;
    L6:
        r101 = false;
        goto L7
    }

    public static String e(Object r100) {
        if (r100 != null) goto L6;
        return "unknown";
    L6:
        return r100.getClass().getSimpleName() + '@' + Integer.toHexString(r100.hashCode());
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "detail");
        FLogger.f375446a.e("FlowFeedArch", r100 + ' ' + r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "detail");
        FLogger.f375446a.i("FlowFeedArch", r100 + ' ' + r101);
    }

    public static void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "detail");
        Intrinsics.checkNotNullParameter(r102, "error");
        FLogger.f375446a.e("FlowFeedArch", r100 + ' ' + r101, r102);
    }
}
