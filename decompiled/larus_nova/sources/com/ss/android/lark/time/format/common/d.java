package com.ss.android.lark.time.format.common;

import android.text.TextUtils;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f441324a = 0;

    static {
    }

    public static c7c.a a(c7c.a r110) {
        if (r110 == null) goto L4;
        return r110;
    L4:
        return new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
    }

    public static TimeZone b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        TimeZone r101 = TimeZone.getDefault();
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        TimeZone r102 = TimeZone.getTimeZone(r100);
        Intrinsics.checkNotNull(r102);
        return r102;
    }
}
