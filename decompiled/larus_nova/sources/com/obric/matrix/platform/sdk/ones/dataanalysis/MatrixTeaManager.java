package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class MatrixTeaManager {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static MatrixTeaManager f396960o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicBoolean f396961p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f396962q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f396963r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f396964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.matrix.platform.sdk.ones.dataanalysis.b f396965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IDataService f396966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f396967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f396968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.obric.matrix.platform.sdk.ones.dataanalysis.a> f396969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f396970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f396971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.obric.matrix.platform.sdk.ones.dataanalysis.d f396972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f396973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f396974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f396975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MatrixTeaManager$deviceInfoCallback$1 f396976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f396977n;

    public static final class a {
        public static MatrixTeaManager a() {
            MatrixTeaManager r100 = MatrixTeaManager.f396960o;
            if (r100 == null) goto L7;
            Intrinsics.checkNotNull(r100);
            return r100;
        L7:
            throw new IllegalStateException("MatrixTeaManager还没初始化，请先调用init方法进行初始化~~~".toString());
        }

        public static void b(Context r100, com.obric.matrix.platform.sdk.ones.dataanalysis.b r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "config");
            if (MatrixTeaManager.f396960o == null) goto L5;
        L15:
            MatrixTeaManager r102 = MatrixTeaManager.f396960o;
            Intrinsics.checkNotNull(r102);
            r102.bindService();
            return;
        L5:
            monitor-enter(MatrixTeaManager.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (MatrixTeaManager.f396960o != null) goto L9;
            MatrixTeaManager.f396960o = new MatrixTeaManager(r100, r101);     // Catch: Throwable -> L12
        L9:
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(MatrixTeaManager.class);
            goto L15
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f396978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f396979b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f396978a, r101.f396978a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f396979b, r101.f396979b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f396978a.hashCode() * 31) + this.f396979b.hashCode();
        }

        public final String toString() {
            return "PendingEvent(eventName=" + this.f396978a + ", jsonObject=" + this.f396979b + ')';
        }

        public b(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
            this.f396978a = r100;
            this.f396979b = r101;
        }
    }

    public static final class c implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixTeaManager f396980a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            gka.b.b("MatrixTeaManager", "dataanalysis service binder died");
            this.f396980a.d(false);
            this.f396980a.h();
        }

        public c(MatrixTeaManager r100) {
            this.f396980a = r100;
        }
    }

    public static final class d implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixTeaManager f396981a;

        public d(MatrixTeaManager r100) {
            this.f396981a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            this.f396981a.h();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            gka.b.c("MatrixTeaManager", "onServiceConnected: ");     // Catch: Exception -> L12
            this.f396981a.f396970g.removeCallbacksAndMessages(null);     // Catch: Exception -> L12
            if (r101 != null) goto L7;
            gka.b.b("MatrixTeaManager", "onServiceConnected error, binder is null");     // Catch: Exception -> L12
            this.f396981a.h();     // Catch: Exception -> L12
            return;
        L7:
            this.f396981a.d(true);     // Catch: Exception -> L12
            r101.linkToDeath(this.f396981a.f396973j, 0);     // Catch: Exception -> L12
            MatrixTeaManager r102 = this.f396981a;     // Catch: Exception -> L12
            r102.f396967d = r101;     // Catch: Exception -> L12
            r102.f396966c = IDataService.Stub.asInterface(r101);     // Catch: Exception -> L12
            MatrixTeaManager r103 = this.f396981a;     // Catch: Exception -> L12
            r103.f396968e = true;     // Catch: Exception -> L12
            IDataService r104 = r103.f396966c;     // Catch: Exception -> L12
            if (r104 == null) goto L10;
            r104.registerDeviceInfoListener(r103.f396976m);     // Catch: Exception -> L12
        L10:
            MatrixTeaManager.a(this.f396981a);     // Catch: Exception -> L12
            return;
        L12:
            gka.b.b("MatrixTeaManager", "onServiceConnected error");
            this.f396981a.h();
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatrixTeaManager f396982a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f396982a.f396968e == true) goto L9;
            gka.b.c("MatrixTeaManager", "尝试重新绑定下载服务");     // Catch: Throwable -> L6
            this.f396982a.c();     // Catch: Throwable -> L6
            this.f396982a.f396970g.postDelayed(this, 5000);     // Catch: Throwable -> L6
            return;
        }

        public e(MatrixTeaManager r100) {
            this.f396982a = r100;
        }
    }

    public final void h() {
        d(true);     // Catch: Exception -> L5
        this.f396970g.removeCallbacks(this.f396972i);     // Catch: Exception -> L5
        this.f396970g.postDelayed(this.f396972i, 3000);     // Catch: Exception -> L5
        return;
    L5:
        gka.b.b("MatrixTeaManager", "rebindService error");
    }

    static {
        f396961p = new AtomicBoolean(false);
    }

    public final void bindService() {
        if (f396961p.compareAndSet(false, true) == true) goto L6;
        int r100 = gka.b.f481577a;
        Intrinsics.checkNotNullParameter("tea has inited", "msg");
        gka.b.c("matrix_ones", "tea has inited");
        return;
    L6:
        c();
        this.f396970g.postDelayed(this.f396974k, 5000);
    }

    public final void c() {
        if (this.f396968e == false) goto L6;
        gka.b.c("MatrixTeaManager", "bindServiceInternal: service is already bound");
        return;
    L6:
        Intent r100 = new Intent();
        r100.setAction("com.obric.matrix.dataanalysis.service");
        r100.setPackage("com.obric.matrix");
        this.f396964a.bindService(r100, this.f396977n, 1);
    }

    public final String e() {
        String r100 = f396962q;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L14;
        gka.b.c("MatrixTeaManager", "getDeviceId 有值，立即回调 " + f396962q);
        return f396962q;
    L14:
        if (this.f396968e == true) goto L25;
        gka.b.b("MatrixTeaManager", "getDeviceId error,Service not bounded");
        return null;
    L25:
        IDataService r102 = this.f396966c;     // Catch: Exception -> L21
        if (r102 == null) goto L18;
        String r103 = r102.getDeviceId();     // Catch: Exception -> L21
    L19:
        f396962q = r103;     // Catch: Exception -> L21
        return r103;
    L18:
        r103 = null;
    L21:
        gka.b.b("MatrixTeaManager", "getDeviceId error");
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static final void a(MatrixTeaManager r110) {
        if (r110.f396971h.isEmpty() == false) goto L5;
        gka.b.c("MatrixTeaManager", "没有暂存的事件需要处理");
        return;
    L5:
        gka.b.c("MatrixTeaManager", "开始处理 " + r110.f396971h.size() + " 个暂存事件");
        CopyOnWriteArrayList<b> r100 = r110.f396971h;
        ArrayList r101 = new ArrayList();
        Iterator<b> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        b r103 = r102.next();
        b r104 = r103;
        boolean r105 = true;
        JSONObject r106 = new JSONObject(r104.f396979b.toString());     // Catch: Exception -> L15
        r106.put("app_package_name", r110.f396965b.f396983a);     // Catch: Exception -> L15
        r106.put(Constants.EXTRA_KEY_APP_VERSION_CODE, r110.f396965b.f396984b);     // Catch: Exception -> L15
        r106.put("app_version_name", r110.f396965b.f396985c);     // Catch: Exception -> L15
        if (r110.f396965b.f396986d == false) goto L12;
        int r107 = 1;
    L13:
        r106.put("app_is_boe", r107);     // Catch: Exception -> L15
        r110.g(r104.f396978a, r106);     // Catch: Exception -> L15
        gka.b.c("MatrixTeaManager", "成功发送暂存事件: " + r104.f396978a);     // Catch: Exception -> L15
        r105 = false;
    L16:
        if (r105 == false) goto L7;
        r101.add(r103);
        goto L7
    L12:
        r107 = 0;
    L15:
        gka.b.b("MatrixTeaManager", "发送暂存事件 " + r104.f396978a + " 失败");
        goto L16
    L18:
        r110.f396971h.clear();
        r110.f396971h.addAll(r101);
    }

    public final void b(com.obric.matrix.platform.sdk.ones.dataanalysis.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        gka.b.c("MatrixTeaManager", "addDeviceInfoListener " + r100);
        if (this.f396969f.contains(r100) == true) goto L5;
        this.f396969f.add(r100);
        gka.b.c("MatrixTeaManager", "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.f396969f.size());
    L5:
        String r101 = f396962q;
        boolean r102 = true;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        gka.b.c("MatrixTeaManager", "注册deviceInfoListener时did有值，立即回调 " + f396962q);
        String r104 = f396962q;
        Intrinsics.checkNotNull(r104);
        r100.a(r104);
    L14:
        String r105 = f396963r;
        if (r105 != null) goto L17;
    L20:
        if (r102 == true) goto L23;
        gka.b.c("MatrixTeaManager", "注册deviceInfoListener时installId有值，立即回调 " + f396963r);
        String r106 = f396963r;
        Intrinsics.checkNotNull(r106);
        r100.b(r106);
        return;
    L23:
        return;
    L17:
        if (r105.length() == 0) goto L20;
        r102 = false;
        goto L20
    L8:
        if (r101.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    public final void d(boolean r100) {
        if (r100 == false) goto L13;
        IBinder r101 = this.f396967d;
        if (r101 == null) goto L13;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r101.unlinkToDeath(this.f396973j, 0)));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        gka.b.c("MatrixTeaManager", "unlinkToDeath skipped: " + r104.getMessage());
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L13:
        this.f396967d = null;
        this.f396966c = null;
        this.f396968e = false;
    }

    public final void i(com.obric.matrix.platform.sdk.ones.dataanalysis.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f396969f.remove(r100);     // Catch: Exception -> L5
        gka.b.c("MatrixTeaManager", "removeDeviceInfoListener " + r100 + ", size = " + this.f396969f.size());     // Catch: Exception -> L5
        return;
    L5:
        gka.b.b("MatrixTeaManager", "removeDeviceInfoListener error");
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.d] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager$deviceInfoCallback$1] */
    public MatrixTeaManager(Context r100, com.obric.matrix.platform.sdk.ones.dataanalysis.b r101) {
        this.f396964a = r100;
        this.f396965b = r101;
        this.f396969f = new CopyOnWriteArrayList();
        this.f396970g = new Handler(Looper.getMainLooper());
        this.f396971h = new CopyOnWriteArrayList();
        this.f396972i = new com.obric.matrix.platform.sdk.ones.dataanalysis.d(this);
        this.f396973j = new c(this);
        this.f396974k = new e(this);
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("MatrixTeaBackgroundThread");
        ThreadMethodProxy.start(r102);
        this.f396975l = new Handler(r102.getLooper());
        this.f396976m = new MatrixTeaManager$deviceInfoCallback$1(this);
        this.f396977n = new d(this);
    }

    public final void f(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "jsonObject");
        int r102 = r101.toString().getBytes(Charsets.UTF_8).length;     // Catch: Throwable -> L21
        if (r102 <= 204800) goto L9;
        gka.b.b("MatrixTeaManager", "事件 " + r100 + " 数据大小 " + r102 + " 字节超过200KB限制，已丢弃");
        return;
    L9:
        if (this.f396968e == false) goto L25;
        r101.put("app_package_name", this.f396965b.f396983a);     // Catch: Exception -> L16
        r101.put(Constants.EXTRA_KEY_APP_VERSION_CODE, this.f396965b.f396984b);     // Catch: Exception -> L16
        r101.put("app_version_name", this.f396965b.f396985c);     // Catch: Exception -> L16
        if (this.f396965b.f396986d == false) goto L13;
        int r103 = 1;
    L14:
        r101.put("app_is_boe", r103);     // Catch: Exception -> L16
        g(r100, r101);     // Catch: Exception -> L16
        return;
    L13:
        r103 = 0;
    L16:
        gka.b.b("MatrixTeaManager", "onEvent error");
        return;
    L25:
        this.f396971h.add(new b(r100, new JSONObject(r101.toString())));     // Catch: Exception -> L19
        gka.b.c("MatrixTeaManager", "服务未绑定，暂存事件: " + r100 + " 成功，当前暂存数量: " + this.f396971h.size());     // Catch: Exception -> L19
        return;
    L19:
        gka.b.b("MatrixTeaManager", "服务未绑定，暂存事件 " + r100 + " 失败");
        return;
    L21:
        gka.b.b("MatrixTeaManager", "计算事件大小失败，已丢弃事件 ".concat(r100));
    }

    public final void g(final String r100, final JSONObject r101) {
        LinkedList r102 = new LinkedList();
        Iterator<String> r103 = r101.keys();
    L4:
        if (r103.hasNext() == false) goto L21;
        r102.add(r103.next());
        goto L4
    L21:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        Object[] r105 = r102.toArray(new String[0]);     // Catch: Throwable -> L11
        if (r105 == null) goto L10;
        Object r106 = Result.m9449constructorimpl(new JSONObject(r101, (String[]) r105));     // Catch: Throwable -> L11
    L14:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L17;
        gka.b.b("MatrixTeaManager", "copyJson error");
    L17:
        if (Result.m9455isFailureimpl(r106) == false) goto L19;
        r106 = r101;
    L19:
        final JSONObject r107 = (JSONObject) r106;
        this.f396975l.post(new com.obric.matrix.platform.sdk.ones.dataanalysis.c(this, r100, r107, r101));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
