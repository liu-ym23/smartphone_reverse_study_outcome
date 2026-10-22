package com.ss.android.lark.featuregating;

import android.content.Context;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.storage.kv.flash.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import jdb.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f420726d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f420727e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.flash.c f420728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f420729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f420730c;

    public static final class a {
        @JvmStatic
        public final b a() {
            LarkAppContext.Companion.getClass();
            return b(LarkAppContext.access$getInstance$cp().getContext());
        }

        public a() {
        }

        @JvmStatic
        public final synchronized b b(Context r100) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L9
            b r101 = b.f420727e;     // Catch: Throwable -> L9
            if (r101 != null) goto L6;
            r101 = new b(r100);     // Catch: Throwable -> L9
        L6:
            b.f420727e = r101;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r101;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.featuregating.b$b, reason: collision with other inner class name */
    public static final class C4959b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f420731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f420732b;

        @Override // com.ss.android.lark.featuregating.b.c
        public final boolean isEnable(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f420732b.B0(this.f420731a, r100);
        }

        public C4959b(String r100, e r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "service");
            this.f420731a = r100;
            this.f420732b = r101;
        }
    }

    public interface c {
        boolean isEnable(String r100);
    }

    static {
        f420726d = new a();
    }

    public b(Context r100) {
        d r101 = com.ss.android.lark.storage.kv.flash.c.f441037b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.lark.storage.kv.flash.c.a r102 = new com.ss.android.lark.storage.kv.flash.c.a(r100);
        String r103 = r102.f441040b;
        Intrinsics.checkNotNullParameter(r103, "space");
        Intrinsics.checkNotNullParameter("flash_fg", "domain");
        r102.f441041c = r103;
        r102.f441042d = "flash_fg";
        com.ss.android.lark.featuregating.a r104 = new com.ss.android.lark.featuregating.a();
        Intrinsics.checkNotNullParameter(r104, "source");
        com.ss.android.lark.storage.kv.flash.a r105 = r102.f441043e;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "source");
        String[] r106 = r104.a();
        int r107 = r106.length;
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L9;
        String r109 = r106[r108];
        if (r105.f441036a.put(r109, r104) != null) goto L8;
        r108 = r108 + 1;
        goto L3
    L8:
        throw new IllegalStateException("multi source contains duplicate keys, key:" + r109);
    L9:
        this.f420728a = r102.a();
        this.f420729b = new ConcurrentHashMap(10);
        this.f420730c = new ConcurrentHashMap(10);
    }

    @JvmStatic
    public static final synchronized b b(Context r100) {
        monitor-enter(b.class);
        b r101 = f420726d.b(r100);     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fgKey");
        ConcurrentHashMap<String, Boolean> r101 = this.f420730c;
        Boolean r102 = r101.get(r100);
        if (r102 != null) goto L9;
        r102 = Boolean.valueOf(this.f420728a.a(r100, false));
        Boolean r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        return r102.booleanValue();
    }
}
