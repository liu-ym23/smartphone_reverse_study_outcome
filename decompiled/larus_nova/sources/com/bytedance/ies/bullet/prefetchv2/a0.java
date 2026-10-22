package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f247513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f247514b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ExecutorService f247515c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f f247516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f247517e;

    public a0() {
    }

    static {
        f247513a = new a0();
        f247514b = PThreadExecutorsUtils.newCachedThreadPool(new e("PrefetchV2"));
        f247515c = PThreadExecutorsUtils.newFixedThreadPool(4, new e("PrefetchV2Worker"));
    }

    public static v a(p r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        f r101 = f247516d;
        if (r101 == null) goto L5;
        v r102 = r101.a(r100);
    L6:
        if (r102 != null) goto L8;
        int r103 = j.f247548a;
        j.c("内存缓存查找失败: " + r100.f247575l);
    L8:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public static List b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        ConcurrentHashMap<Uri, d0> r101 = w.f247611a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        d0 r102 = w.f247611a.get(r100);
        if (r102 != null) goto L6;
        return CollectionsKt.emptyList();
    L6:
        if (r102.f247524a == false) goto L37;
        h r103 = a.f247510a.a(r100);
        if (r103 != null) goto L11;
    L26:
        j.b("未获取到prefetch配置，无法进行globalProps注入");
        return null;
    L11:
        if (((ArrayList) r103.f247546c).isEmpty() == true) goto L26;
        ArrayList r104 = new ArrayList();
        Iterator r105 = ((ArrayList) r103.f247546c).iterator();
    L15:
        if (r105.hasNext() == false) goto L38;
        t r106 = (t) r105.next();
        int r107 = p.f247563o;
        p r108 = p.a.a(r106, r102, r103);
        if (r108 != null) goto L18;
        int r109 = j.f247548a;
        j.b("PrefetchRequest创建失败: " + r106.f247584a);
        goto L15
    L18:
        f r110 = f247516d;
        if (r110 == null) goto L21;
        v r111 = r110.a(r108);
    L22:
        if (r111 == null) goto L15;
        r111.f247607g = r106.f247592i;
        r104.add(r111);
        goto L15
    L21:
        r111 = null;
        goto L22
    L38:
        return r104;
    L37:
        return CollectionsKt.emptyList();
    }

    public static z c(p r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        ConcurrentHashMap<String, z> r101 = e0.f247529a;
        Intrinsics.checkNotNullParameter(r100, "request");
        Object r102 = e0.f247530b;
        monitor-enter(r102);
        ConcurrentHashMap<String, z> r103 = e0.f247529a;     // Catch: Throwable -> L10
        if (r103.containsKey(r100.f247575l) == true) goto L7;
        int r104 = j.f247548a;     // Catch: Throwable -> L10
        j.a("Prefetch任务查找失败，" + r100.f247575l + ", runningTask: " + r103);     // Catch: Throwable -> L10
    L7:
        z r105 = r103.get(r100.f247575l);     // Catch: Throwable -> L10
        monitor-exit(r102);
        return r105;
    L10:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void e(Uri r100, String r101, int r102) {
        a0 r103 = f247513a;
        if ((r102 & 4) == 0) goto L5;
        r101 = "default_bid";
    L5:
        r103.d(r100, null, r101);
    }

    public final void d(Uri r110, h r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        Intrinsics.checkNotNullParameter(r112, "bid");
        f(this, r110, r111, r112, null, null, null, 48);
    }

    public static void f(a0 r110, final Uri r111, h r112, String r113, t36.d r114, a36.a r115, String r116, int r117) {
        if ((r117 & 2) == 0) goto L5;
        final h r100 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        final String r101 = "default_bid";
    L11:
        if ((r117 & 8) == 0) goto L13;
        final t36.d r102 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        final a36.a r103 = null;
    L19:
        if ((r117 & 32) == 0) goto L21;
        final String r104 = null;
    L22:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r101, "bid");
        f247514b.execute(new PrefetchV2$prefetchBySchemaUriInternal$1(r111, r102, r101, r100, r103, r104));
        return;
    L21:
        r104 = r116;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
