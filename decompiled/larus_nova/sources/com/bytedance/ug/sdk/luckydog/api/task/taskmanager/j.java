package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import android.app.Application;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import il7.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f271710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f271711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f271712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HashMap<String, h> f271713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static i f271714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, e> f271715f = null;

    static {
        m r100 = m.b("luckydog_task_full_path_config");
        f271710a = r100;
        f271715f = new ConcurrentHashMap();
        f271714e = (i) new Gson().fromJson(r100.e("full_path_config", ""), i.class);     // Catch: Throwable -> L5
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "initConfig onCall: taskFullPathConfig: " + f271714e);     // Catch: Throwable -> L5
    L7:
        i r101 = f271714e;
        if (r101 == null) goto L10;
        ArrayList<String> r102 = r101.b();
    L11:
        f271712c = r102;
        f271713d = b();
        i r103 = f271714e;
        if (r103 == null) goto L14;
        int r104 = r103.c();
    L15:
        f271711b = r104;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "init variables: isEnable: " + f271711b + " gidListConfig: " + f271712c + ", hostEventMatchMap: " + f271713d);
        return;
    L14:
        r104 = ConfigStatus.NotReady.getStatus();
        goto L15
    L10:
        r102 = null;
    L5:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("TaskFullPathManager", th.getLocalizedMessage());
        goto L7
    }

    public static HashMap b() {
        HashMap r100 = new HashMap();
        i r101 = f271714e;
        if (r101 == null) goto L5;
        ArrayList<h> r102 = r101.a();
    L6:
        if (r102 == null) goto L10;
        int r103 = r102.size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        r100.put(((h) ListProtector.get(r102, r104)).a(), ListProtector.get(r102, r104));
        r104 = r104 + 1;
    L10:
        return r100;
    L5:
        r102 = null;
        goto L6
    }

    public static boolean a(String r100) {
        if (f271711b == ConfigStatus.ReadyAndOpen.getStatus()) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "开关没有ready 不返回全链路参数");
        return false;
    L6:
        ArrayList<String> r101 = f271712c;
        if (r101 != null) goto L9;
    L12:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "任务不需要关联 不返回全链路参数");
        return false;
    L9:
        if (r101.contains(r100) != true) goto L12;
        return true;
    }

    public static f d(String r100) {
        e r101 = f271715f.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f271705a;
    }

    public static void c(String r100, boolean r101) {
        e r102 = f271715f.get(r100);
        if (r102 == null) goto L8;
        r102.f271705a.f271708b++;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "doNewEventAssociated onCall, globalTaskId：" + r100 + " 新事件加入后index+1, 当前index: " + r102.f271705a.f271708b);
        if (r101 == false) goto L9;
        r102.f271706b = true;
        return;
    L9:
        return;
    }

    public static f e(boolean r100, String r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "前端尝试获取全链路参数, gid: " + r101 + ", isBeginEvent: " + r100);
        if (a(r101) == true) goto L6;
        return null;
    L6:
        f r102 = d(r101);
        if (r100 == false) goto L11;
        if (r102 != null) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "doPathFirstBegin onCall, globalTaskId：" + r101 + " 创建新的全链路参数");
        StringBuilder r103 = new StringBuilder();
        Application r104 = rk7.m.f538347a;
        r103.append(rk7.m.h());
        r103.append("_");
        r103.append(System.currentTimeMillis());
        f271715f.put(r101, new e(new f(r103.toString(), r101)));
        return d(r101);
    L12:
        return r102;
    L11:
        return r102;
    }

    public static void f(String r100, JSONObject r101, String r102) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "任务管理器尝试获取全链路参数, gid: " + r102 + ", event: " + r100);
        if (a(r102) == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r100, "luckydog_task_manager_receive") == false) goto L9;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "该事件不加全链路: ".concat(r100));
        return;
    L9:
        f r103 = d(r102);
        if (r103 != null) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "未获取到全链路参数: " + r100 + ", gid: " + r102);
        return;
    L13:
        r101.put("session_id", r103.f271707a);
        r101.put("index", r103.f271708b);
        if (Intrinsics.areEqual(r100, "luckydog_task_manager_begin_open") == false) goto L17;
        c(r102, true);
        return;
    L17:
        if (Intrinsics.areEqual(r100, "luckydog_task_manager_complete") == false) goto L19;
    L22:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("TaskFullPathManager", "doLastEventAssociated onCall, 最后一个事件上报后删除entry");
        f271715f.remove(r102);
        return;
    L19:
        if (Intrinsics.areEqual(r100, "luckydog_task_manager_failure") == true) goto L22;
        c(r102, false);
    }
}
