package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.content.Context;
import android.os.Environment;
import bolts.Task;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270152a = 0;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f270153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f270154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f270155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f270156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f270157e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f270158f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f270159g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f270160h;

        public a(String r100, Context r101, String r102, String r103, String r104, String r105, long r106, long r107) {
            this.f270153a = r100;
            this.f270154b = r101;
            this.f270155c = r102;
            this.f270156d = r103;
            this.f270157e = r104;
            this.f270158f = r105;
            this.f270159g = r106;
            this.f270160h = r107;
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b4 -> B:19:0x00b5). Please report as a decompilation issue!!! */
        @Override // java.util.concurrent.Callable
        public final Unit call() {
            int r100 = f.f270152a;
            String r101 = this.f270153a;
            String r102 = this.f270154b.getPackageName();
            PolarisFileWrapper r103 = new PolarisFileWrapper(Environment.getDataDirectory() + "/data/" + r102 + "/shared_prefs/" + (r101 + "_xbridge_storage.xml"));     // Catch: Exception -> L16
            if (r103.exists() == true) goto L6;
        L8:
            PolarisFileWrapper r104 = new PolarisFileWrapper(Environment.getDataDirectory() + "/data/" + r102 + "/files/keva/repo/" + (r101 + "_xbridge_storage"));     // Catch: Exception -> L16
            if (r104.exists() == true) goto L11;
        L18:
            long r105 = 0;
        L19:
            if (r105 >= 0) goto L22;
            ExecutorService r106 = BulletLogger.f247763a;
            BulletLogger.k("UserDomainLocalStorageMonitor-report.Wrong Happen.Calcute Size: " + r105, null, null, 6);
            return Unit.INSTANCE;
        L22:
            c1 r107 = new c1("bdx_monitor_userdomain_localstorage", null, null, null, null, 254);
            String r108 = this.f270155c;
            String r109 = this.f270156d;
            String r110 = this.f270157e;
            String r111 = this.f270158f;
            long r112 = this.f270159g;
            long r113 = this.f270160h;
            JSONObject r114 = new JSONObject();
            r114.put("method_name", r109);
            r114.put("origin_url", r110);
            r114.put("status", r111);
            r107.f247794d = r114;
            JSONObject r115 = new JSONObject();
            r115.put("current_data_size", r112);
            r115.put("stored_data_size", r105);
            r115.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r113);
            r107.f247795e = r115;
            r107.f247793c = r108;
            ExecutorService r116 = BulletLogger.f247763a;
            BulletLogger.k("UserDomainLocalStorageMonitor-report. Info: " + r107.f247795e + ',' + r107.f247794d, null, null, 6);
            s26.d r117 = s26.d.f540305c;
            r r118 = (r) s26.d.f540305c.d("default_bid", r.class);
            if (r118 == null) goto L29;
            r118.S(r107);
            return Unit.INSTANCE;
        L29:
            return null;
        L11:
            if (r104.isDirectory() == false) goto L18;
            Long r119 = f.a(r104);     // Catch: Exception -> L16
            if (r119 == null) goto L18;
            r105 = r119.longValue();     // Catch: Exception -> L16
            goto L19
        L6:
            if (r103.isFile() == false) goto L8;
            r105 = r103.length();     // Catch: Exception -> L16
        L16:
            e = move-exception;
            ExecutorService r120 = BulletLogger.f247763a;
            BulletLogger.k("UserDomainLocalStorageMonitor-calcuteFileSize.Wrong Happen. ErrorMessage: " + e, null, null, 6);
            goto L18
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
    }

    public static Long a(File r100) {
        File[] r101 = r100.listFiles();     // Catch: Exception -> L14
        int r102 = r101.length;     // Catch: Exception -> L14
        int r103 = 0;
        long r104 = 0;
    L3:
        if (r103 >= r102) goto L13;
        File r105 = r101[r103];     // Catch: Exception -> L14
        if (r105.isDirectory() == false) goto L10;
        Long r106 = a(r105);     // Catch: Exception -> L14
        if (r106 == null) goto L9;
        long r107 = r106.longValue();     // Catch: Exception -> L14
    L11:
        r104 = r104 + r107;
        r103 = r103 + 1;
        goto L3
    L9:
        r107 = 0;
        goto L11
    L10:
        r107 = r105.length();     // Catch: Exception -> L14
        goto L11
    L13:
        return Long.valueOf(r104);
    L14:
        e = move-exception;
        ExecutorService r108 = BulletLogger.f247763a;
        BulletLogger.k("UserDomainLocalStorageMonitor-getFolderSize, error happen:" + e, null, null, 6);
        return null;
    }

    public static void b(String r110, Context r111, String r112, long r113, String r114, String r115, String r116, long r210) {
        Intrinsics.checkNotNullParameter(r110, "storageName");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "url");
        Intrinsics.checkNotNullParameter(r114, "methodName");
        Intrinsics.checkNotNullParameter(r115, "platForm");
        Intrinsics.checkNotNullParameter(r116, "status");
        Task.callInBackground(new a(r110, r111, r115, r114, r112, r116, r113, r210));
    }
}
