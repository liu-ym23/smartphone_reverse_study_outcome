package com.ss.android.lark.storage.monitor;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f441102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.ss.android.lark.storage.monitor.a f441103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Executor f441104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f441105d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f441106a = 0;

        static {
        }

        public a() {
        }

        public static void c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "message");
            Log.i("UniStoreMonitor_".concat(r100), r101);
        }

        public static void a(String r100, String r101, Throwable r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "message");
            if (r102 == null) goto L5;
            Log.e("UniStoreMonitor_" + r100, r101, r102, r103);
            return;
        L5:
            Log.e("UniStoreMonitor_" + r100, r101);
        }

        public static /* synthetic */ void b(String r100, String r101, Throwable r102, int r103) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            a(r100, r101, r102, false);
        }
    }

    static {
        f441102a = new b();
    }

    public b() {
    }

    public static void a(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "kvRepo");
        com.ss.android.lark.storage.kv.statistics.a r101 = com.ss.android.lark.storage.kv.statistics.a.f441083a;
        Intrinsics.checkNotNullParameter(r100, "kvRepo");
        String r102 = com.ss.android.lark.storage.kv.statistics.a.d(com.ss.android.lark.storage.kv.statistics.a.c(r100));
        int r103 = com.ss.android.lark.storage.kv.statistics.a.C5310a.f441084c;
        Intrinsics.checkNotNullParameter(r102, "repoName");
        com.ss.android.lark.storage.kv.statistics.a.g(new com.ss.android.lark.storage.kv.statistics.a.C5310a("cipher_error", r102, null));
    }
}
