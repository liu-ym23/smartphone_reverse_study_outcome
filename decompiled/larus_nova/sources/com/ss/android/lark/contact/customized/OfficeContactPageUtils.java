package com.ss.android.lark.contact.customized;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.router.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class OfficeContactPageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f418959a = null;

    static {
        f418959a = LazyKt.lazy(OfficeContactPageUtils$contactAggregateSearchUrl$2.INSTANCE);
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = c.f439675a;
        Log.i("Contact_PageUtils", "openAggregateSearchPage handled=" + c.b(r100, (String) f418959a.getValue()));
    }

    public static void b(Context r100, Intent r101) {
        if ((r100 instanceof Activity) == true) goto L5;
        r101.addFlags(268435456);
        Log.i("Contact_PageUtils", "add FLAG_ACTIVITY_NEW_TASK for context=".concat(r100.getClass().getName()));
    L5:
        r100.startActivity(r101);
    }
}
