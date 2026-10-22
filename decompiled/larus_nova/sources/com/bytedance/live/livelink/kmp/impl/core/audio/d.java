package com.bytedance.live.livelink.kmp.impl.core.audio;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f255365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f255366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final li6.c f255367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ei6.a f255368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f255369e;

    public static final class a {
    }

    public static final class b extends Handler {
        public b(Looper r100) {
            Intrinsics.checkNotNullParameter(r100, "looper");
            super(r100);
        }
    }

    static {
    }

    public final String a() {
        li6.c r100 = this.f255367c;
        if (r100 == null) goto L7;
        li6.b r101 = r100.f509384c;
        if (r101 == null) goto L7;
        String r102 = r101.f509375b;
    L9:
        return String.valueOf(r102);
    L7:
        r102 = null;
        goto L9
    }

    public d(ei6.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("RtcPhoneStateListener", "logTag");
        this.f255368d = r100;
        this.f255369e = "RtcPhoneStateListener";
        this.f255366b = new AtomicInteger(0);
        li6.a r102 = r100.e();
        if (r102 == null) goto L5;
        li6.c r103 = (li6.c) r102.a("TYPE_LIVE_RTC_EXT_INFO", Reflection.getOrCreateKotlinClass(li6.c.class));
    L6:
        this.f255367c = r103;
        this.f255365a = r101.getApplicationContext();
        return;
    L5:
        r103 = null;
        goto L6
    }
}
