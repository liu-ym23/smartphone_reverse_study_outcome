package com.larus.ugc.perf.impl;

import android.text.TextUtils;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f375100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, g> f375101b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f375102c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f375103d = null;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            FLogger.f375446a.e("BasePerfMonitor", "err! msg=" + r101);
        }
    }

    public c() {
    }

    static {
        f375100a = new c();
        f375101b = new ConcurrentHashMap();
        f375102c = new a(CoroutineExceptionHandler.Key);
        f375103d = LazyKt.lazy(new b());
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "trackerKey");
        String[] r101 = {""};
        Intrinsics.checkNotNullParameter(r100, "trackerKey");
        Intrinsics.checkNotNullParameter(r101, "keyValues");
        if (TextUtils.isEmpty(r100) == true) goto L19;
        f375100a.getClass();
        g r102 = b(r100);
        if (r102 == null) goto L18;
        e(r100);
        if (r102.a() <= 0) goto L20;
        int r103 = 0;
        int r104 = ProgressionUtilKt.getProgressionLastElement(0, -1, 2);
        if (r104 < 0) goto L15;
    L12:
        r102.d(r101[r103], r101[r103 + 1]);
        if (r103 == r104) goto L15;
        r103 = r103 + 2;
    L15:
        JSONObject r105 = r102.c();
        c r106 = f375100a;
        String r107 = r102.f375111a;
        r106.getClass();
        f(r107, r105);
        return;
    L20:
        return;
    L18:
        return;
    }

    public static g b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        return f375101b.get(r100);
    }

    public static void e(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        TypeIntrinsics.asMutableMap(f375101b).remove(r100);
    }

    @JvmStatic
    public static final void c(String r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "keyValues");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        f375100a.getClass();
        g r102 = b(r100);
        if (r102 == null) goto L15;
        int r103 = 0;
        int r104 = ProgressionUtilKt.getProgressionLastElement(0, r101.length - 2, 2);
        if (r104 < 0) goto L12;
    L9:
        r102.d(r101[r103], r101[r103 + 1]);
        if (r103 == r104) goto L12;
        r103 = r103 + 2;
    L12:
        f375100a.getClass();
        d(r100, r102);
        return;
    }

    public static void d(String r100, g r101) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        f375101b.put(r100, r101);
    L7:
        BuildersKt.launch$default((CoroutineScope) f375103d.getValue(), null, null, new BasePerfMonitor$cleanUpExpiredTrackers$1(null), 3, null);
    }

    public static void f(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "dataJson");
        o.f365780a.reportEvent(r100, r101);     // Catch: Exception -> L5
        FLogger.f375446a.i("BasePerfMonitor", r100 + ":\t " + r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("BasePerfMonitor", "reportEvent error", e);
    }

    @JvmStatic
    public static final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "trackerKey");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        String[] r102 = {""};
        Intrinsics.checkNotNullParameter(r100, "trackerKey");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "keyValues");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L16;
        g r103 = new g(r101);
        int r104 = 0;
        int r105 = ProgressionUtilKt.getProgressionLastElement(0, -1, 2);
        if (r105 < 0) goto L12;
    L9:
        r103.d(r102[r104], r102[r104 + 1]);
        if (r104 == r105) goto L12;
        r104 = r104 + 2;
    L12:
        f375100a.getClass();
        d(r100, r103);
        return;
    }
}
