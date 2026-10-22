package com.ss.android.lark.watermark.mysterious;

import android.content.Context;
import c7c.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f445315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f445316b;

    /* JADX INFO: renamed from: com.ss.android.lark.watermark.mysterious.a$a, reason: collision with other inner class name */
    public static final class C5388a {
    }

    static {
    }

    public final String a(String r110) {
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        if (StringsKt.indexOf$default(r110, "{{.timestamp}}", 0, false, 6, null) < 0) goto L8;
        Context r100 = this.f445315a;
        Date r101 = new Date();
        c7c.a r111 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r111.f22684h = !this.f445316b.invoke().booleanValue();
        Unit r102 = Unit.INSTANCE;
        return StringsKt.replace$default(r110, "{{.timestamp}}", b.c(r100, r101, r111), false, 4, null);
    L8:
        return r110;
    }

    public a(Context r100, Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "is24Hours");
        this.f445315a = r100;
        this.f445316b = r101;
    }
}
