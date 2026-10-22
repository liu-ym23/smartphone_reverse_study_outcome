package com.bytedance.timon_monitor_impl.pipeline;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@ComponentDeps(required = {kz5.c.class})
public final class ValidateSystem implements TimonSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270758a = 0;

    public static final class a {
        public static String a(ActivityManager.RunningAppProcessInfo r110) {
            if (r110 != null) goto L6;
            return "";
        L6:
            return "processName:" + r110.processName + ",pkgList:" + ArraysKt.joinToString$default(r110.pkgList, "｜", null, null, 0, null, null, 62, null) + ",importance:" + r110.importance + ",importanceReasonCode:" + r110.importanceReasonCode + ",pid:" + r110.pid + ",uid:" + r110.uid + ",lru:" + r110.lru + ",lastTrimLevel:" + r110.lastTrimLevel;
        }
    }

    static {
    }

    public ValidateSystem() {
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final String name() {
        return "ValidateSystem";
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean preInvoke(dh7.c r100) {
        return true;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public final boolean postInvoke(dh7.c r210) {
        Map<Integer, String> r100 = com.bytedance.timon_monitor_impl.fuse.b.f270754a;
        boolean r101 = ScenesDetector.f270865a;
        if (ScenesDetector.f270866b != null) goto L5;
        boolean r102 = false;
    L7:
        if (r102 == false) goto L103;
        ReentrantReadWriteLock.ReadLock r103 = r210.f468622b.readLock();
        r103.lock();
        Object r104 = ((LinkedHashMap) r210.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L100
        if (r104 == null) goto L99;
        kz5.a r105 = (kz5.a) r104;     // Catch: Throwable -> L100
        r103.unlock();
        final int r106 = r105.f506748a;
        if (r106 != 101303) goto L103;
        JsonObject r107 = com.bytedance.timonbase.config.a.a("timon_config");
        String r108 = null;
        if (r107 == null) goto L18;
        JsonObject r109 = r107.getAsJsonObject("runningprocessreport");
    L19:
        if (r109 == null) goto L23;
        JsonElement r110 = r109.get("enable");
        if (r110 == null) goto L23;
        boolean r111 = r110.getAsBoolean();
    L24:
        if (r111 == false) goto L103;
        String r112 = com.bytedance.timonbase.utils.a.f270909a;
        Boolean r113 = Boolean.TRUE;
        Application r114 = TMEnv.f270769c;
        ActivityManager.RunningAppProcessInfo r115 = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(r115);
        r115.processName = com.bytedance.timonbase.utils.a.b();
        String[] r116 = new String[1];
        if (r114 == null) goto L30;
        String r117 = r114.getPackageName();
        if (r117 == null) goto L30;
    L31:
        r116[0] = r117;
        r115.pkgList = r116;
        if (TMEnv.f270767a == false) goto L34;
        int r118 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.a("ProcessUtils", "构造当前进程RunningAppProcessInfo：processName:" + r115.processName + ",pid:" + r115.pid + ",uid:" + r115.uid + ",importance:" + r115.importance + ",importanceReasonCode:" + r115.importanceReasonCode + ",lastTrimLevel:" + r115.lastTrimLevel + ",pkgList:" + ArraysKt.joinToString$default(r115.pkgList, "｜", null, null, 0, null, null, 62, null) + ",lru:" + r115.lru);
    L34:
        List r119 = (List) TuplesKt.to(r113, CollectionsKt.listOf(r115)).component2();
        int r120 = Process.myPid();
        Iterator r121 = r119.iterator();
    L36:
        if (r121.hasNext() == false) goto L43;
        Object r122 = r121.next();
        if (((ActivityManager.RunningAppProcessInfo) r122).pid != r120) goto L40;
        boolean r123 = true;
    L41:
        if (r123 == false) goto L36;
    L44:
        final ActivityManager.RunningAppProcessInfo r124 = (ActivityManager.RunningAppProcessInfo) r122;
        ReentrantReadWriteLock.ReadLock r125 = r210.f468622b.readLock();
        r125.lock();
        Object r126 = ((LinkedHashMap) r210.f468621a).get(Reflection.getOrCreateKotlinClass(kz5.a.class));     // Catch: Throwable -> L95
        if (r126 == null) goto L94;
        kz5.a r127 = (kz5.a) r126;     // Catch: Throwable -> L95
        r125.unlock();
        Object r128 = r127.f506751d;
        if (r128 == null) goto L92;
        List<ActivityManager.RunningAppProcessInfo> r129 = ((ActivityManager) r128).getRunningAppProcesses();
        if (r129 == null) goto L103;
        Iterator<T> r130 = r129.iterator();
    L54:
        if (r130.hasNext() == false) goto L61;
        Object r131 = r130.next();
        if (((ActivityManager.RunningAppProcessInfo) r131).pid != r120) goto L58;
        boolean r132 = true;
    L59:
        if (r132 == false) goto L54;
    L62:
        final ActivityManager.RunningAppProcessInfo r133 = (ActivityManager.RunningAppProcessInfo) r131;
        if (r133 == null) goto L103;
        if (r124 == null) goto L67;
        r108 = r124.processName;
    L67:
        if ((!Intrinsics.areEqual(r108, r133.processName)) == true) goto L84;
        if (r124 == null) goto L73;
        String[] r134 = r124.pkgList;
        if (r134 == null) goto L73;
        if ((!Arrays.equals(r134, r133.pkgList)) == true) goto L84;
    L73:
        if (r124 == null) goto L84;
        if (r124.importance != r133.importance) goto L84;
        if (r124.importanceReasonCode != r133.importanceReasonCode) goto L84;
        if (r124.uid != r133.uid) goto L84;
        if (r124.lru != r133.lru) goto L84;
        if (r124.lastTrimLevel == r133.lastTrimLevel) goto L103;
    L84:
        CopyOnWriteArrayList<Function0<Unit>> r135 = com.bytedance.timonbase.cache.a.f270801a;
        Function0<Unit> r136 = new ValidateSystem$postInvoke$$inlined$let$lambda$1(r133, r124, r106);
        if (TMEnv.f270768b == false) goto L87;
        r136.invoke();
    L90:
        com.bytedance.timonbase.b.c("ProcessUtil", "runningappprocesses出现替换错误");
        goto L103
    L87:
        CopyOnWriteArrayList<Function0<Unit>> r137 = com.bytedance.timonbase.cache.a.f270801a;
        if (r137.size() >= 100) goto L90;
        r137.add(r136);
        goto L90
    L58:
        r132 = false;
        goto L59
    L61:
        r131 = null;
        goto L62
    L92:
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    L94:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.pipeline.ApiCallInfo");     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        r125.unlock();
        throw th;
    L40:
        r123 = false;
        goto L41
    L43:
        r122 = null;
    L30:
        r117 = "";
    L23:
        r111 = false;
        goto L24
    L18:
        r109 = null;
        goto L19
    L99:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.helios.api.pipeline.ApiCallInfo");     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        r103.unlock();
        throw th;
    L103:
        return true;
    L5:
        r102 = ScenesDetector.e();
        goto L7
    }
}
