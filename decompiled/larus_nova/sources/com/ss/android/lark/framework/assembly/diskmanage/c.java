package com.ss.android.lark.framework.assembly.diskmanage;

import android.text.TextUtils;
import com.ss.android.lark.diskmanage.smalldisk.settings.DiskStrategyConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o0;
import e0c.k;
import ebb.g;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f425632a = null;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f425633a = null;

        static {
            f425633a = new c();
        }
    }

    public c() {
    }

    static {
        f425632a = new AtomicBoolean(false);
    }

    public static void a() {
        if (f425632a.get() == false) goto L6;
        return;
    L6:
        if (o0.a(LarkContext.getApplication()) == false) goto L18;
        Iterator<T> r100 = ((d) k.a(LarkContext.getApplication(), d.class)).a().iterator();
    L9:
        if (r100.hasNext() == false) goto L18;
        g r101 = (g) r100.next();
        int r102 = ebb.b.f471973c;
        ebb.b r103 = ebb.b.C5764b.f471976a;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r101, "task");     // Catch: Throwable -> L15
        r103.f471974a.put(r101.getBiz(), r101);     // Catch: Throwable -> L15
        monitor-exit(r103);
    L15:
        th = move-exception;
        throw th;
    L18:
        f425632a.set(true);
    }

    public static cbb.d b() {
        eac.a r100 = eac.a.a();
        String r101 = r100.getString("key_disk_manage_setting", "");
        Log.i("DiskManageProvider", "startRemoteClean, settingJson: " + r101);
        cbb.d r102 = new cbb.d(0);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        JSONObject r103 = new JSONObject(r101);     // Catch: Exception -> L8
        JSONObject r104 = r103.optJSONObject("global");     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L8
        cbb.c r105 = r102.f23126a;     // Catch: Exception -> L8
        r105.f23120a = r104.optLong("clean_interval");     // Catch: Exception -> L8
        r105.f23121b = r104.optLong("idle_delay");     // Catch: Exception -> L8
        r105.f23122c = r104.optLong("sdk_task_cost_limit");     // Catch: Exception -> L8
        r105.f23123d = r104.optLong("task_cost_limit");     // Catch: Exception -> L8
        r105.f23124e = r104.optLong("cache_time_limit");     // Catch: Exception -> L8
        r105.f23125f = r104.optLong("auto_clean_max_times");     // Catch: Exception -> L8
        String r106 = r103.optString("cache_config");     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r106, "<set-?>");     // Catch: Exception -> L8
        r102.f23127b = r106;     // Catch: Exception -> L8
        DiskStrategyConfig.parse(r106);     // Catch: Exception -> L8
        if (r100.getBoolean("small_disk_on", false) == false) goto L14;
        float r107 = r100.getFloat("disk_timeout_factor", 1.0f);     // Catch: Exception -> L8
        r105.f23120a = (long) (r105.f23120a * r107);     // Catch: Exception -> L8
        r105.f23124e = (long) (r105.f23124e * r107);     // Catch: Exception -> L8
        return r102;
    L14:
        return r102;
    L8:
        e = move-exception;
        cbb.d r108 = new cbb.d(0);
        Log.e("DiskManageProvider", "parse remote config failed: " + e);
        return r108;
    L13:
        return r102;
    }
}
