package com.ss.android.lark.mention.base.impl.statistics;

import android.os.SystemClock;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z5c.a0;
import z5c.c4;
import z5c.e1;
import z5c.i0;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f431859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f431860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f431861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f431862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f431863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Long> f431864f = null;

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.statistics.a$a, reason: collision with other inner class name */
    public static final class RunnableC5128a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f431865a;

        public RunnableC5128a(int r100) {
            this.f431865a = r100;
        }

        public final void a() {
            int r100 = this.f431865a;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            s5c.a r102 = i0.f570218c.a(String.valueOf(SystemClock.elapsedRealtime() - a.f431863e));     // Catch: Throwable -> L9
            if (com.ss.android.lark.mention.base.a.a() == false) goto L6;
            s5c.a r103 = c4.f570179d;     // Catch: Throwable -> L9
        L7:
            s5c.a r104 = a0.f570149c.a(String.valueOf(r100));     // Catch: Throwable -> L9
            Statistics.sendEvent("im_mention_finish", s5c.d.b.b(r102, r103).plus(r103).plus(r104).toJson());     // Catch: Throwable -> L9
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
            return;
        L6:
            r103 = c4.f570178c;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f431866a;

        public b(long r100) {
            this.f431866a = r100;
        }

        public final void a() {
            long r100 = this.f431866a;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            s5c.a r102 = e1.f570189c.a(String.valueOf(SystemClock.elapsedRealtime() - r100));     // Catch: Throwable -> L9
            if (com.ss.android.lark.mention.base.a.a() == false) goto L6;
            s5c.a r103 = c4.f570179d;     // Catch: Throwable -> L9
        L7:
            Statistics.sendEvent("im_mention_same_chat_open", s5c.d.b.b(r102, r103).toJson());     // Catch: Throwable -> L9
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
            return;
        L6:
            r103 = c4.f570178c;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f431859a = "";
        f431864f = new LinkedHashMap();
    }

    public static Map a() {
        HashMap r100 = new HashMap();
        if (f431862d == false) goto L5;
        int r101 = 2;
    L6:
        r100.put("sync_type", Integer.valueOf(r101));
        r100.put("chat_type", Integer.valueOf(f431861c));
        return r100;
    L5:
        r101 = 1;
        goto L6
    }

    public static void c(String r100) {
        f431863e = SystemClock.elapsedRealtime();
        if (r100 != null) goto L5;
        return;
    L5:
        LinkedHashMap r101 = (LinkedHashMap) f431864f;
        Long r102 = (Long) r101.get(r100);
        if (r102 == null) goto L8;
        long r103 = r102.longValue();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new b(r103));
    L8:
        r101.clear();
    }

    public static void b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.Notification.CHANNEL_ID);
        f431864f.put(r101, Long.valueOf(SystemClock.elapsedRealtime()));
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC5128a(r100));
    }
}
