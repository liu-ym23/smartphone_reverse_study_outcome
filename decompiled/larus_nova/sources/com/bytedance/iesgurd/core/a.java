package com.bytedance.iesgurd.core;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f250646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PolarisFileWrapper f250647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PolarisFileWrapper f250648c;

    /* JADX INFO: renamed from: com.bytedance.iesgurd.core.a$a, reason: collision with other inner class name */
    public static final class RunnableC3567a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RunnableC3567a f250649a = null;

        static {
            f250649a = new RunnableC3567a();
        }

        public RunnableC3567a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PolarisFileWrapper r100 = a.f250648c;     // Catch: Throwable -> L11
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");     // Catch: Throwable -> L11
        L5:
            File[] r101 = r100.listFiles();     // Catch: Throwable -> L11
            if (r101 == null) goto L14;
            int r102 = r101.length;     // Catch: Throwable -> L11
            int r103 = 0;
        L8:
            if (r103 >= r102) goto L20;
            ez5.c.delete(r101[r103]);     // Catch: Throwable -> L11
            r103 = r103 + 1;
            goto L8
        L20:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static void a() {
        Keva r100 = com.bytedance.iesgurd.meta.a.f250764a;
        GeckoLogger.d("ChannelMetaManager removeAll");
        Iterator r101 = CollectionsKt.toList(((ConcurrentHashMap) com.bytedance.iesgurd.meta.a.f250766c).keySet()).iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        String r102 = (String) r101.next();
        GeckoLogger.d("ChannelMetaManager removeAccessKey " + r102);
        ConcurrentHashMap r103 = (ConcurrentHashMap) ((ConcurrentHashMap) com.bytedance.iesgurd.meta.a.f250766c).get(r102);
        if (r103 == null) goto L4;
        Iterator r104 = r103.keySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L14;
        String r105 = (String) r104.next();
        Keva r106 = com.bytedance.iesgurd.meta.a.f250764a;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L13:
        r106.erase(r102 + '@' + r105);
        goto L9
    L14:
        ((ConcurrentHashMap) com.bytedance.iesgurd.meta.a.f250766c).remove(r102);
        goto L4
    L15:
        com.bytedance.geckox.b r107 = com.bytedance.geckox.b.a.f245076a;
        Iterator r108 = ((ConcurrentHashMap) GlobalManager.f250635d).values().iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        c(new PolarisFileWrapper((String) r108.next()));
        goto L17
    L19:
        b();
    }

    public static void b() {
        if (f250646a == true) goto L5;
        return;
    L5:
        PolarisFileWrapper r100 = f250648c;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L9:
        if (r100.exists() == true) goto L11;
        return;
    L11:
        ((Executor) GeckoExecutors.f250873f.getValue()).execute(RunnableC3567a.f250649a);
    }

    static {
    }

    public static boolean c(File r100) {
        if (f250646a == true) goto L5;
        return false;
    L5:
        PolarisFileWrapper r101 = f250648c;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L9:
        if (r101.exists() == true) goto L16;
        PolarisFileWrapper r102 = f250648c;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L14:
        if (r102.mkdirs() == true) goto L16;
        return false;
    L16:
        String r103 = r100.getName() + '_' + System.currentTimeMillis();
        PolarisFileWrapper r104 = f250648c;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L20:
        return r100.renameTo(new PolarisFileWrapper(r104, r103));
    }
}
