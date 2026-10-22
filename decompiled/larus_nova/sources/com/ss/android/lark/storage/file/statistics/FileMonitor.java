package com.ss.android.lark.storage.file.statistics;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.storage.monitor.SessionTracker;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class FileMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileMonitor f441005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SessionTracker<a> f441006b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FilePathTracker f441007c = null;

    public static final class a extends SessionTracker.Session {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f441008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f441009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f441010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f441011e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f441012f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f441013g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f441014h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f441015i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f441016j;

        @Override // com.ss.android.lark.storage.monitor.SessionTracker.Session
        public final void a() {
        }

        public a(String r100) {
            long r101 = SystemClock.elapsedRealtime();
            Intrinsics.checkNotNullParameter(r100, "currentEvent");
            this.f441008b = r100;
            this.f441009c = r101;
            this.f441010d = -1;
            this.f441011e = -1;
            this.f441012f = -1;
            this.f441013g = -1;
            this.f441014h = -1;
            this.f441015i = -1;
            this.f441016j = -1;
        }
    }

    public FileMonitor() {
    }

    static {
        f441005a = new FileMonitor();
        f441006b = new SessionTracker();
        FilePathTracker r100 = new FilePathTracker();
        r100.f441020b = 3;
        Intrinsics.checkNotNullParameter(FileMonitor$pathTracker$1$1.INSTANCE, "accept");
        f441007c = r100;
    }

    public static String c(String r100) {
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();
        Context r101 = com.ss.android.lark.storage.monitor.b.f441105d;
        if (r101 == null) goto L9;
        String r102 = new PolarisFileWrapper(r100).getParent();
        if (r102 != null) goto L8;
        return r100;
    L8:
        return f441007c.a(r101, r102);
    L9:
        int r103 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        com.ss.android.lark.storage.monitor.b.a.c("FileMonitor", "extractDir error, context is empty");
        return r100;
    }

    public static String d(Function0 r100) {
        String r101 = null;
        a r102 = (a) r100.invoke();     // Catch: Exception -> L5
        r101 = r102.f441008b;     // Catch: Exception -> L5
        return f441006b.b(r102);
    L5:
        e = move-exception;
        if (r101 != null) goto L9;
        String r103 = "unknown";
    L10:
        new com.ss.android.lark.storage.kv.statistics.d("startSession-".concat(r103)).a();
        int r104 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        com.ss.android.lark.storage.monitor.b.a.a("FileMonitor", "start session failed, " + r101, e, true);
        return "";
    L9:
        r103 = r101;
        goto L10
    }

    public static void a(String r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "trackKey");
        Intrinsics.checkNotNullParameter(r101, "fileApi");
        Intrinsics.checkNotNullParameter(r102, "path");
        b(r100, "infra_unistore_file_access_dev", new FileMonitor$endAccess$1(r102, r101));
    }

    public static void b(String r100, String r101, final Function1 r102) {
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L13;
        return;
    L13:
        int r104 = com.ss.android.lark.storage.monitor.b.a.f441106a;     // Catch: Exception -> L10
        String r105 = "end session: " + r101 + ", time: " + SystemClock.elapsedRealtime();     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter("FileMonitor", "tag");     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r105, "message");     // Catch: Exception -> L10
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();     // Catch: Exception -> L10
        f441006b.a(r100, new FileMonitor$endSessionAndSendEvent$1(r102));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        new com.ss.android.lark.storage.kv.statistics.d("endSession-".concat(r101)).a();
        int r106 = com.ss.android.lark.storage.monitor.b.a.f441106a;
        com.ss.android.lark.storage.monitor.b.a.a("FileMonitor", "end session failed, event: ".concat(r101), e, true);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
