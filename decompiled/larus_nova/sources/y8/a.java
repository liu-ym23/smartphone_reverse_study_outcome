package y8;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.util.n;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f566652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Pair<Long, Object>> f566653b = null;

    public a() {
    }

    public final synchronized Object b() {
        monitor-enter(this);
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        Map<String, Pair<Long, Object>> r101 = f566653b;     // Catch: Throwable -> L13
        if (r101.containsKey(MobConstants.NETWORK_TIME) == false) goto L10;
        Object r102 = ((LinkedHashMap) r101).get(MobConstants.NETWORK_TIME);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L13
        if ((r100 - ((Number) ((Pair) r102).getFirst()).longValue()) >= 5000) goto L10;
        Object r103 = ((LinkedHashMap) r101).get(MobConstants.NETWORK_TIME);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L13
        Object r104 = ((Pair) r103).getSecond();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r104;
    L10:
        int r105 = ((c) Annie.getService$default(c.class, null, 2, null)).getEffectiveConnectionType();     // Catch: Throwable -> L13
        r101.put(MobConstants.NETWORK_TIME, new Pair(Long.valueOf(r100), Integer.valueOf(r105)));     // Catch: Throwable -> L13
        Integer r106 = Integer.valueOf(r105);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r106;
    L13:
        th = move-exception;
        throw th;
    }

    static {
        f566652a = new a();
        f566653b = new LinkedHashMap();
    }

    public static float c() {
        float r100 = ((c) Annie.getService$default(c.class, null, 2, null)).getScreenFps();
        if (r100 >= 0) goto L6;
        return 60.0f;
    L6:
        return r100;
    }

    public final synchronized float a(Context r100) {
        monitor-enter(this);
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L20
        Map<String, Pair<Long, Object>> r102 = f566653b;     // Catch: Throwable -> L20
        if (r102.containsKey(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE) == false) goto L10;
        Object r103 = ((LinkedHashMap) r102).get(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE);     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L20
        if ((r101 - ((Number) ((Pair) r103).getFirst()).longValue()) >= 5000) goto L10;
        Object r104 = ((LinkedHashMap) r102).get(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE);     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L20
        Object r105 = ((Pair) r104).getSecond();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L20
        float r106 = ((Float) r105).floatValue();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r106;
    L10:
        int r107 = n.f40069c;     // Catch: Throwable -> L20
        if (r100 == null) goto L16;
        Intent r108 = n.a(r100, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L20
        if (r108 == null) goto L16;
        float r109 = r108.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, -10) / 10.0f;     // Catch: Throwable -> L20
    L17:
        r102.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, new Pair(Long.valueOf(r101), Float.valueOf(r109)));     // Catch: Throwable -> L20
        monitor-exit(this);
        return r109;
    L16:
        r109 = -1.0f;
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized double d(Context r100) {
        monitor-enter(this);
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        Map<String, Pair<Long, Object>> r102 = f566653b;     // Catch: Throwable -> L22
        if (r102.containsKey("memory_info") == false) goto L10;
        Object r103 = ((LinkedHashMap) r102).get("memory_info");     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L22
        if ((r101 - ((Number) ((Pair) r103).getFirst()).longValue()) >= 5000) goto L10;
        Object r104 = ((LinkedHashMap) r102).get("memory_info");     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L22
        Object r105 = ((Pair) r104).getSecond();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Double");     // Catch: Throwable -> L22
        double r106 = ((Double) r105).doubleValue();     // Catch: Throwable -> L22
        monitor-exit(this);
        return r106;
    L10:
        int r107 = n.f40069c;     // Catch: Throwable -> L22
        if (r100 == null) goto L15;
        Object r108 = r100.getSystemService("activity");     // Catch: Throwable -> L22
        if ((r108 instanceof ActivityManager) == false) goto L15;
        ActivityManager.MemoryInfo r109 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L22
        ((ActivityManager) r108).getMemoryInfo(r109);     // Catch: Throwable -> L22
        double r110 = (r109.availMem / 1024.0d) / 1024.0d;     // Catch: Throwable -> L22
    L17:
        if (r110 >= 0) goto L19;
        r110 = 1201.0d;
    L19:
        r102.put("memory_info", new Pair(Long.valueOf(r101), Double.valueOf(r110)));     // Catch: Throwable -> L22
        monitor-exit(this);
        return r110;
    L15:
        r110 = -1.0d;
    L22:
        th = move-exception;
        throw th;
    }
}
