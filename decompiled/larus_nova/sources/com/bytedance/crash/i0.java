package com.bytedance.crash;

import android.app.Application;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.sva.sdk.controller.Global;
import java.io.File;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f203227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile PolarisFileWrapper f203228b;

    /* JADX INFO: loaded from: classes15.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f203229a;

        @Override // java.lang.Runnable
        public final void run() {
            i0.a(this.f203229a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Map r100) {
            this.f203229a = r100;
        }
    }

    static {
        f203227a = new ConcurrentHashMap();
    }

    public static void a(Map r100) {
    L25:
        ObjectOutputStream r101 = null;
    L26:
        com.bytedance.crash.util.i.a(r101);
        return;
    L4:
        if (f203228b != null) goto L20;
        Application r102 = i.a().f203223c;     // Catch: Throwable -> L25
        if (r102 == null) goto L33;
        PolarisFileWrapper r103 = new PolarisFileWrapper(i.d(), PromotionProductPrivilegesStruct.TAGS);     // Catch: Throwable -> L25
        if (r103.exists() == true) goto L12;
        r103.mkdirs();     // Catch: Throwable -> L25
    L12:
        if (com.bytedance.crash.util.b.e(r102, com.bytedance.crash.util.b.c()) == false) goto L14;
        String r104 = PullConfiguration.PROCESS_NAME_MAIN;
    L15:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103, r104);     // Catch: Throwable -> L25
        if (r105.exists() == true) goto L18;
        r105.mkdirs();     // Catch: Throwable -> L25
    L18:
        StringBuilder r106 = new StringBuilder("import_tag_");     // Catch: Throwable -> L25
        ConfigManager r107 = a0.f203096a;     // Catch: Throwable -> L25
        r106.append(i.b());     // Catch: Throwable -> L25
        r106.append(Global.SUFFIX_TXT_FILE);     // Catch: Throwable -> L25
        f203228b = new PolarisFileWrapper(r105, r106.toString());     // Catch: Throwable -> L25
        goto L20
    L14:
        r104 = com.bytedance.crash.util.b.b().replaceAll(":", "@");     // Catch: Throwable -> L25
        goto L15
    L33:
        return;
    L20:
        if (f203228b == null) goto L34;
        r101 = new ObjectOutputStream(new PolarisFileOutputStreamWrapper(f203228b));     // Catch: Throwable -> L25
        r101.writeObject(r100);     // Catch: Throwable -> L28
        goto L26
    }

    public static void b(PolarisFileWrapper r100) {
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L21;
        File r104 = r101[r103];
        if (r104.isFile() == true) goto L19;
        File[] r105 = r104.listFiles();
        if (r105 == null) goto L20;
        if (r105.length <= 5) goto L27;
        Arrays.sort(r105);
        int r106 = 0;
    L17:
        if (r106 >= (r105.length - 5)) goto L20;
        com.bytedance.crash.util.h.b(r105[r106]);
        r106 = r106 + 1;
        goto L17
    L27:
        return;
    L20:
        r103 = r103 + 1;
        goto L6
    L19:
        com.bytedance.crash.util.h.b(r104);
        goto L20
    }

    public static void c(String r100) {
        Map<String, String> r101 = f203227a;
        if (((ConcurrentHashMap) r101).containsKey(r100) == true) goto L5;
        return;
    L5:
        ((ConcurrentHashMap) r101).remove(r100);
        if (d0.d() == true) goto L8;
        return;
    L8:
        wh4.b.post(new a(new HashMap(r101)));
    }
}
