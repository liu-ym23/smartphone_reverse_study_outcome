package com.larus.canvas.feature.component.logic.trace;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f323505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, com.larus.ugc.perf.impl.g> f323506b = null;

    public h() {
    }

    static {
        f323505a = new h();
        f323506b = new LruCache(5);
    }

    public static com.larus.ugc.perf.impl.g b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        return f323506b.get(r100);
    }

    public static void c(com.larus.ugc.perf.impl.g r100) {
        h r101 = f323505a;
        String r102 = r100.f375111a;
        JSONObject r103 = r100.c();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Intrinsics.checkNotNullParameter(r103, "dataJson");
        o.f365780a.reportEvent(r102, r103);     // Catch: Exception -> L5
        com.larus.platform.service.g.f365738a.monitorEventForSlardar(r102, r103, new JSONObject(), null);     // Catch: Exception -> L5
        FLogger.f375446a.i("CanvasPerfMonitor", r102 + ":\t " + r103);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CanvasPerfMonitor", "reportEvent error", e);
    }

    public static void a(String r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "localId");
        com.larus.ugc.perf.impl.g r104 = b(r100);
        if (r104 != null) goto L5;
        return;
    L5:
        r104.e(TuplesKt.to("duration", Long.valueOf(r104.a())));
        r104.e(TuplesKt.to("success", Integer.valueOf(r101 ? 1 : 0)));
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r104.e(TuplesKt.to("log_id", r103));
        r104.e(TuplesKt.to("scene", "end"));
        if (r102 == null) goto L11;
        r104.e(TuplesKt.to("error_code", r102));
    L11:
        c(r104);
    }
}
