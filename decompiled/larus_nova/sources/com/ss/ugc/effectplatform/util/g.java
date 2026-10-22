package com.ss.ugc.effectplatform.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458036a = 0;

    public g() {
    }

    static {
    }

    public static /* synthetic */ HashMap b(EffectConfig r100, int r101) {
        boolean r102 = true;
        if ((r101 & 2) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r101 & 4) != 0) goto L11;
        r102 = false;
    L11:
        return a(r100, r103, r102);
    L5:
        r103 = false;
        goto L7
    }

    public static HashMap a(EffectConfig r110, boolean r111, boolean r210) {
        HashMap r100 = new HashMap();
        int r101 = r.f458047a;
        if (r.b(r110.f457152a) == true) goto L9;
        String r102 = r110.f457152a;
        if (r102 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r100.put("access_key", r102);
    L9:
        if (r.b(r110.f457158d) == true) goto L15;
        String r103 = r110.f457158d;
        if (r103 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        r100.put("device_id", r103);
    L15:
        if (r.b(r110.f457161g) == true) goto L21;
        String r104 = r110.f457161g;
        if (r104 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r100.put("device_type", r104);
    L21:
        if (r.b(r110.f457162h) == true) goto L27;
        String r105 = r110.f457162h;
        if (r105 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        r100.put("os_version", r105);
    L27:
        if (r.b(r110.f457160f) == true) goto L33;
        String r106 = r110.f457160f;
        if (r106 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        r100.put("device_platform", r106);
    L33:
        if (r.b(r110.f457166l) == true) goto L39;
        String r107 = r110.f457166l;
        if (r107 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        r100.put(EffectConfiguration.KEY_REGION, r107);
    L39:
        if (r.b(r110.f457154b) == true) goto L45;
        String r108 = r110.f457154b;
        if (r108 != null) goto L43;
        Intrinsics.throwNpe();
    L43:
        r100.put("sdk_version", r108);
    L45:
        if (r.b(r110.f457156c) == true) goto L51;
        String r109 = r110.f457156c;
        if (r109 != null) goto L49;
        Intrinsics.throwNpe();
    L49:
        r100.put("app_version", r109);
    L51:
        if (r.b(r110.f457159e) == true) goto L57;
        String r112 = r110.f457159e;
        if (r112 != null) goto L55;
        Intrinsics.throwNpe();
    L55:
        r100.put("channel", r112);
    L57:
        if (r.b(r110.f457167m) == true) goto L63;
        String r113 = r110.f457167m;
        if (r113 != null) goto L61;
        Intrinsics.throwNpe();
    L61:
        r100.put("aid", r113);
    L63:
        if (r.b(r110.f457168n) == true) goto L68;
        String r114 = r110.f457168n;
        if (r114 != null) goto L67;
        Intrinsics.throwNpe();
    L67:
        r100.put(EffectConfiguration.KEY_APP_LANGUAGE, r114);
    L68:
        int r115 = bytekn.foundation.utils.a.f21806a;
        HashMap<String, String> r116 = r110.f457169o;
        if (r116 != null) goto L71;
    L74:
        boolean r117 = true;
    L75:
        if (r117 == true) goto L91;
        if (r111 == false) goto L78;
        HashMap<String, String> r118 = r110.f457169o;
    L90:
        r100.putAll(r118);
        goto L91
    L78:
        HashMap<String, String> r119 = r110.f457169o;
        LinkedHashMap r120 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r121 = r119.entrySet().iterator();
    L80:
        if (r121.hasNext() == false) goto L89;
        Map.Entry<String, String> r122 = r121.next();
        String r123 = r122.getKey();
        if ((!Intrinsics.areEqual(r123, EffectConfiguration.KEY_LX)) == true) goto L84;
    L86:
        boolean r124 = false;
    L87:
        if (r124 == false) goto L80;
        r120.put(r122.getKey(), r122.getValue());
        goto L80
    L84:
        if ((!Intrinsics.areEqual(r123, EffectConfiguration.KEY_LY)) == false) goto L86;
        r124 = true;
        goto L87
    L89:
        r118 = r120;
    L91:
        int r125 = r.f458047a;
        if (r.b(r110.B) == true) goto L97;
        String r126 = r110.B;
        if (r126 != null) goto L96;
        Intrinsics.throwNpe();
    L96:
        r100.put(EffectConfiguration.KEY_GPU_INFO, r126);
    L97:
        Integer r127 = r110.O;
        if (r127 != null) goto L100;
    L102:
        new c();
        Object r128 = r110.G;
        HashMap r129 = new HashMap();
        r129.put("platform", 1);
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L105
        Object r131 = Result.m9449constructorimpl(Float.valueOf(CastFloatProtector.parseFloat(((GPUUtils.a) GPUUtils.f458014d.getValue()).f458016b)));     // Catch: Throwable -> L105
    L108:
        if (Result.m9455isFailureimpl(r131) == false) goto L110;
        r131 = null;
    L110:
        Float r132 = (Float) r131;
        if (r132 == null) goto L113;
        r129.put("gl_version", Float.valueOf(r132.floatValue()));
    L113:
        Lazy r133 = GPUUtils.f458014d;
        r129.put("gl_vendor", ((GPUUtils.a) r133.getValue()).f458017c);
        r129.put("gl_renderer", ((GPUUtils.a) r133.getValue()).f458015a);
        if (r210 == false) goto L116;
        r129.put("gl_extension", ((GPUUtils.a) r133.getValue()).f458022h);
    L116:
        if (r128 != null) goto L118;
    L168:
        Object r134 = ((ConcurrentHashMap) d.f458025a).get("cache_key_cpu_model");
        if (r134 == null) goto L172;
        String r135 = (String) r134;
    L201:
        r129.put("cpu_vendor", r135);
        r129.put("os_version", Build.VERSION.RELEASE);
        String r136 = new JSONObject(r129).toString();
        if (r136 == null) goto L204;
        r100.put("device_info", r136);
    L204:
        r100.put(EffectConfiguration.KEY_PLATFORM_AB_PARAM, String.valueOf(r110.f457173s));
        String r137 = EffectPlatformAES.f458008a;
        if (r137 == null) goto L207;
        r100.put(EffectConfiguration.KEY_PLATFORM_SDK_VERSION, r137);
    L207:
        return r100;
    L172:
        monitor-enter(d.class);
    L212:
        th = move-exception;
        throw th;
    L195:
        e = e;
        BufferedReader r138 = null;
    L221:
        e.printStackTrace();     // Catch: Throwable -> L208
    L198:
        d.a(r138);     // Catch: Throwable -> L212
        r135 = Build.HARDWARE;     // Catch: Throwable -> L212
        monitor-exit(d.class);
    L200:
        ((ConcurrentHashMap) d.f458025a).put("cache_key_cpu_model", r135);
    L208:
        th = th;
    L209:
        BufferedReader r139 = r138;
    L210:
        d.a(r139);     // Catch: Throwable -> L212
        throw th;     // Catch: Throwable -> L212
    L193:
        th = th;
        r138 = null;
        goto L209
    L175:
        if (new PolarisFileWrapper("/proc/cpuinfo").exists() == false) goto L192;
        r139 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L193 Exception -> L195
    L227:
        String r140 = r139.readLine();     // Catch: Throwable -> L188 Exception -> L190
        if (r140 == null) goto L187;
        if (r140.contains(":") == false) goto L227;
        String[] r141 = r140.split(":");     // Catch: Throwable -> L188 Exception -> L190
        if (r141[0].contains("Hardware") == false) goto L227;
        r135 = r141[1];     // Catch: Throwable -> L188 Exception -> L190
        d.a(r139);     // Catch: Throwable -> L212
        monitor-exit(d.class);
        goto L200
    L187:
        r138 = r139;
    L190:
        e = e;
        r138 = r139;
    L188:
        th = th;
        goto L210
    L192:
        r138 = null;
        goto L198
    L118:
        if ((r128 instanceof Context) == false) goto L168;
        Context r142 = (Context) r128;
        Object r143 = ((ConcurrentHashMap) d.f458025a).get("cache_key_memory_info");
        if (r143 == null) goto L122;
        d.a r144 = (d.a) r143;
    L165:
        long r145 = r144.f458026a;
        if (r145 <= 0) goto L168;
        r129.put("memory_total_size", Long.valueOf(r145));
        goto L168
    L122:
        d.a r146 = new d.a();
        ActivityManager.MemoryInfo r147 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L127
        ActivityManager r148 = (ActivityManager) r142.getSystemService("activity");     // Catch: Exception -> L127
        if (r148 == null) goto L128;
        r148.getMemoryInfo(r147);     // Catch: Exception -> L127
        long r149 = r147.totalMem;     // Catch: Exception -> L127
    L130:
        if (r149 == (-1)) goto L231;
    L144:
        r146.f458026a = r149;
        ActivityManager.MemoryInfo r150 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L149
        ActivityManager r151 = (ActivityManager) r142.getSystemService("activity");     // Catch: Exception -> L149
        if (r151 == null) goto L150;
        r151.getMemoryInfo(r150);     // Catch: Exception -> L149
        long r152 = r150.availMem;     // Catch: Exception -> L149
    L152:
        if (r152 == (-1)) goto L236;
    L164:
        ((ConcurrentHashMap) d.f458025a).put("cache_key_memory_info", r146);
        r144 = r146;
        goto L165
    L236:
        PolarisFileInputStreamWrapper r153 = new PolarisFileInputStreamWrapper("/proc/meminfo");     // Catch: Throwable -> L158 Exception -> L162
        d.c("MemAvailable", r153);     // Catch: Throwable -> L156 Exception -> L216
    L156:
        th = th;
        PolarisFileInputStreamWrapper r154 = r153;
    L160:
        d.a(r154);
        throw th;
    L163:
        d.a(r153);
        goto L164
    L162:
        r153 = null;
    L158:
        th = th;
        r154 = null;
    L150:
        r152 = -1;
        goto L152
    L231:
    L138:
        th = th;
        PolarisFileInputStreamWrapper r155 = null;
    L140:
        d.a(r155);
        throw th;
    L132:
        if (new PolarisFileWrapper("/proc/meminfo").exists() == false) goto L142;
        PolarisFileInputStreamWrapper r156 = new PolarisFileInputStreamWrapper("/proc/meminfo");     // Catch: Throwable -> L138 Exception -> L217
        r149 = ((long) d.c("MemTotal", r156)) * 1024;
        goto L143
    L136:
        th = th;
        r155 = r156;
    L143:
        d.a(r156);
        goto L144
    L142:
        r156 = null;
    L128:
        r149 = -1;
    L105:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L108
    L100:
        if (r127.intValue() <= 0) goto L102;
        r100.put(EffectConfiguration.KEY_FILTER_TYPE, String.valueOf(r110.O));
        goto L102
    L71:
        if (r116.isEmpty() == true) goto L74;
        r117 = false;
        goto L75
    }
}
