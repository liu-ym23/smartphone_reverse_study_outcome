package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f271369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f271370b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.bytedance.ug.sdk.luckycat.impl.popup.a f271371c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f271372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f271373b;

        public a(String r100, e r101) {
            this.f271372a = r100;
            this.f271373b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CopyOnWriteArrayList<String> r100 = v.f271369a;     // Catch: Throwable -> L4
            com.bytedance.ug.sdk.luckycat.impl.popup.a r101 = (com.bytedance.ug.sdk.luckycat.impl.popup.a) GsonProtectorUtils.fromJson(new Gson(), this.f271372a, com.bytedance.ug.sdk.luckycat.impl.popup.a.class);     // Catch: Throwable -> L4
            v.f271371c = r101;     // Catch: Throwable -> L4
            this.f271373b.a(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public v() {
    }

    static {
        f271369a = new CopyOnWriteArrayList();
        f271370b = new Handler(Looper.getMainLooper());
    }

    public static final void a(com.bytedance.ug.sdk.luckycat.impl.popup.f r110) {
        LuckyCatSettingsManger r100 = LuckyCatSettingsManger.b.f271283a;
        r100.getClass();
        Object r101 = r100.c(new String[]{"common", "enable_feed_forest_child_thread"});
        boolean r102 = true;
        if ((r101 instanceof Boolean) == false) goto L5;
        boolean r103 = ((Boolean) r101).booleanValue();
    L6:
        StringBuilder r104 = new StringBuilder("tryPreload luckyPreloadConfig.mainUrl: ");
        Long r105 = null;
        if (r110 == null) goto L11;
        com.bytedance.ug.sdk.luckycat.impl.popup.g r106 = r110.d();
        if (r106 == null) goto L11;
        String r107 = r106.b();
    L12:
        r104.append(r107);
        r104.append(", startTime = ");
        if (r110 == null) goto L15;
        Long r108 = r110.e();
    L16:
        r104.append(r108);
        r104.append(", endTime = ");
        if (r110 == null) goto L19;
        r105 = r110.c();
    L19:
        r104.append(r105);
        r104.append(", forceAsync = ");
        r104.append(r103);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", r104.toString());
        if (r110 == null) goto L30;
        Long r109 = r110.e();
        if (r109 == null) goto L30;
        long r111 = r109.longValue();
        Long r112 = r110.c();
        if (r112 == null) goto L30;
        long r113 = r112.longValue();
        if (r111 <= 0) goto L30;
        if (r113 <= 0) goto L30;
    L32:
        if (r102 == false) goto L49;
        long r114 = System.currentTimeMillis();
        if (r110 == null) goto L57;
        Long r115 = r110.e();
        if (r115 == null) goto L58;
        long r116 = r115.longValue();
        Long r117 = r110.c();
        if (r117 == null) goto L59;
        long r118 = r117.longValue();
        if (r116 <= r118) goto L42;
        return;
    L42:
        if (r116 <= r114) goto L45;
        return;
    L45:
        if (r118 < r114) goto L61;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", "tryPreload ForestLoader.preload");
        r110.a();
        com.bytedance.forest.model.n r119 = r110.f271421a;
        if (r119 == null) goto L62;
        com.bytedance.ies.bullet.forest.f<String, com.bytedance.forest.model.o> r120 = ForestLoader.f246728a;
        ForestLoader.l(ForestLoader.d(), r119, "PreloadSource", r103, 24);
        return;
    L62:
        return;
    L61:
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L49:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", "tryPreload ForestLoader.preload");
        if (r110 == null) goto L52;
        r110.a();
    L52:
        if (r110 == null) goto L64;
        com.bytedance.forest.model.n r121 = r110.f271421a;
        if (r121 == null) goto L65;
        com.bytedance.ies.bullet.forest.f<String, com.bytedance.forest.model.o> r122 = ForestLoader.f246728a;
        ForestLoader.l(ForestLoader.d(), r121, "PreloadSource", r103, 24);
        return;
    L65:
        return;
    L64:
        return;
    L30:
        r102 = false;
        goto L32
    L15:
        r108 = null;
    L11:
        r107 = null;
        goto L12
    L5:
        r103 = true;
        goto L6
    }

    public static void b(e r100) {
        LuckyCatSettingsManger r101 = LuckyCatSettingsManger.b.f271283a;     // Catch: Exception -> L11
        r101.getClass();     // Catch: Exception -> L11
        Object r102 = r101.c(new String[]{"container_config", "fmp_optimize_config"});     // Catch: Exception -> L11
        if ((r102 instanceof JSONObject) == false) goto L5;
        JSONObject r103 = (JSONObject) r102;     // Catch: Exception -> L11
    L6:
        String r104 = r103.toString();     // Catch: Exception -> L11
        com.bytedance.ug.sdk.luckycat.impl.popup.a r105 = f271371c;     // Catch: Exception -> L11
        if (r105 != null) goto L9;
        rj7.c.a(new a(r104, r100));     // Catch: Exception -> L11
        return;
    L9:
        r100.a(r105);     // Catch: Exception -> L11
        return;
    L5:
        r103 = new JSONObject();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyForestPreloadManager", "getPreloadData fail:" + e.getMessage());
    }

    public static void c(Function0 r100) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f271370b.post(new w(r100));
    }
}
