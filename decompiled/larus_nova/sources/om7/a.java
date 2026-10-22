package om7;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f524296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f524297b;

    public final void a() {
        d r100 = this.f524297b;
        String r101 = this.f524296a;
        monitor-enter(r100);
        um7.e.b("doGetUnionValue() key = " + r101);     // Catch: Throwable -> L70
        Context r102 = pm7.b.a.f529854a.getContext();     // Catch: Throwable -> L70
        String r103 = null;
        if (r102 != null) goto L7;
    L67:
        r100.a(r101, null);     // Catch: Throwable -> L70
        monitor-exit(r100);
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L67;
        String r104 = com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.e.a(r102).b(r101);     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r104) == true) goto L14;
        um7.e.b("doGetUnionValue() DataUnionSettings sp 获取成功： value = " + r104);     // Catch: Throwable -> L70
        r100.a(r101, r104);     // Catch: Throwable -> L70
        monitor-exit(r100);
        return;
    L14:
        pm7.a r105 = pm7.a.C7212a.f529851a;     // Catch: Throwable -> L70
        Set<DataUnionStrategy> r106 = r105.f529848b;     // Catch: Throwable -> L70
        if (r106 == null) goto L17;
        Set<DataUnionStrategy> r107 = r106;
    L19:
        if (r107.contains(DataUnionStrategy.UNION_ACCOUNT) == false) goto L21;
        String r110 = com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.a.a(r102, r101);     // Catch: Throwable -> L70
    L23:
        if (TextUtils.isEmpty(r110) == true) goto L27;
        um7.e.b("doGetUnionValue() DataUnionAccountUtils 获取成功： value = " + r110);     // Catch: Throwable -> L70
        r100.a(r101, r110);     // Catch: Throwable -> L70
        r100.d(r101, r110);     // Catch: Throwable -> L70
        monitor-exit(r100);
        return;
    L27:
        DataUnionStrategy r108 = DataUnionStrategy.UNION_FILE;     // Catch: Throwable -> L70
        if (r107.contains(r108) == false) goto L31;
        r103 = com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.c.b(r102, r101);     // Catch: Throwable -> L70
    L31:
        if (TextUtils.isEmpty(r103) == true) goto L35;
        um7.e.b("doGetUnionValue() DataUnionFileUtils 获取成功： value = " + r103);     // Catch: Throwable -> L70
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.b.a(r101, r103, "file", r108);     // Catch: Throwable -> L70
        r100.a(r101, r103);     // Catch: Throwable -> L70
        r100.d(r101, r103);     // Catch: Throwable -> L70
        monitor-exit(r100);
        return;
    L35:
        DataUnionStrategy r109 = DataUnionStrategy.UNION_CLIPBOARD;     // Catch: Throwable -> L70
        if (r107.contains(r109) == false) goto L38;
        int r111 = 1;
    L39:
        DataUnionStrategy r112 = DataUnionStrategy.UNION_PROVIDER;     // Catch: Throwable -> L70
        int r113 = r111 + (r107.contains(r112) ? 1 : 0);     // Catch: Throwable -> L70
        if (r113 > 0) goto L44;
        r100.a(r101, r103);     // Catch: Throwable -> L70
        monitor-exit(r100);
        return;
    L44:
        CountDownLatch r114 = new CountDownLatch(r113);     // Catch: Throwable -> L70
        if (r107.contains(r109) == false) goto L59;
        rm7.c r115 = rm7.c.a.f538587a;     // Catch: Throwable -> L70
        if (r115.f538576a == null) goto L50;
        Application r116 = m.f538347a;     // Catch: Throwable -> L70
        m.k();     // Catch: Throwable -> L70
    L50:
        if (r115.f538576a == null) goto L52;
        Application r117 = m.f538347a;     // Catch: Throwable -> L70
        m.p();     // Catch: Throwable -> L70
    L52:
        b r118 = new b(r100, r101, r114);     // Catch: Throwable -> L70
        if (Build.VERSION.SDK_INT >= 29) goto L55;
    L57:
        r118.a(r115.d());     // Catch: Throwable -> L70
        goto L59
    L55:
        if (r105.f529849c == true) goto L57;
        um7.e.b("getClipboardText() version > 10, mHasFocus is false, waiting focus");     // Catch: Throwable -> L70
        r105.f529850d = r118;     // Catch: Throwable -> L70
    L59:
        if (r107.contains(r112) == false) goto L74;
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.d.b(r102, r107.contains(DataUnionStrategy.UNION_ACTIVITY), r101, new c(r100, r114));     // Catch: Throwable -> L70
    L74:
        um7.e.b("latch.await() 开始");     // Catch: Throwable -> L63
        long r119 = System.currentTimeMillis();     // Catch: Throwable -> L63
        r114.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L63
        um7.e.b("doGetUnionValue() latch.await finish; 开始回调 耗时：" + (System.currentTimeMillis() - r119));     // Catch: Throwable -> L63
        r100.a(r101, com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.e.a(r102).b(r101));     // Catch: Throwable -> L63
    L65:
        monitor-exit(r100);
        return;
    L63:
        th = move-exception;
        um7.e.a("doGetUnionValue() error: " + th.getLocalizedMessage());     // Catch: Throwable -> L70
        goto L65
    L38:
        r111 = 0;
        goto L39
    L21:
        r110 = null;
        goto L23
    L17:
        r107 = new HashSet();     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(d r100, String r101) {
        this.f524297b = r100;
        this.f524296a = r101;
    }
}
