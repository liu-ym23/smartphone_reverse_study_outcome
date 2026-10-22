package com.larus.init.task.imsdk;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.android.ManifestData;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.statfs.StatFsHelper;
import com.larus.home.api.main.HomeService;
import com.larus.network.http.d;
import com.larus.nova.NovaApplication;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.settings.value.e10;
import com.larus.settings.value.ec;
import com.larus.settings.value.i3;
import com.larus.utils.l0;
import com.obric.assistant.common.spi.IObricFeatureService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import fuc.a;
import g2a.e;
import gd9.b;
import gd9.d0;
import gd9.k;
import gd9.l;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import jm9.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class g implements l {
    public static final g a = null;
    public static final ConcurrentHashMap<l.b, b> b = null;
    public static final NovaApplication c = null;
    public static final Lazy d = null;

    public g() {
    }

    @Override // gd9.l
    public final int appId() {
        return 482431;
    }

    @Override // gd9.l
    public final String appName() {
        return "nova_ai";
    }

    @Override // gd9.l
    public final int f() {
        return 15020070;
    }

    @Override // gd9.l
    public final boolean isDebug() {
        return false;
    }

    @Override // gd9.l
    public final boolean isDebugChannel() {
        return false;
    }

    @Override // gd9.l
    public final void isOversea() {
    }

    @Override // gd9.l
    public final void isPlugin() {
    }

    static {
        a = new g();
        b = new ConcurrentHashMap();
        NovaApplication r0 = NovaApplication.e;
        c = NovaApplication.a.a();
        d = LazyKt.lazy(new f());
    }

    @Override // gd9.l
    public final boolean a() {
        IObricFeatureService r0 = (IObricFeatureService) ServiceManager.get().getService(IObricFeatureService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // gd9.l
    public final boolean b() {
        return !i.b.e;
    }

    @Override // gd9.l
    public final String channel() {
        return (String) d.getValue();
    }

    @Override // gd9.l
    public final long currentTimeMillis() {
        ReentrantLock r0 = d0.a;
        k r1 = new k(this);
        Intrinsics.checkNotNullParameter(r1, "elapsedRealtimeProvider");
        ReentrantLock r2 = d0.a;
        r2.lock();
        Pair r3 = d0.b;     // Catch: Throwable -> L15
        r2.unlock();
        if (r3 == null) goto L7;
        long r4 = ((Number) r3.getFirst()).longValue();
    L9:
        if (r4 < 10000) goto L20;
        if (r3 == null) goto L14;
        return (((Number) r1.invoke()).longValue() - ((Number) r3.getFirst()).longValue()) + ((Number) r3.getSecond()).longValue();
    L14:
        return a.a().a();
    L20:
        return a.a().a();
    L7:
        r4 = 0;
    L15:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    @Override // gd9.l
    public final String e() {
        return o.a.getDeviceId();
    }

    @Override // gd9.l
    public final boolean h() {
        String r0 = d.a;
        return d.e;
    }

    @Override // gd9.l
    public final String i() {
        String r0 = c.getApplicationInfo().dataDir;
        if (r0 == null) goto L5;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r0);
    L6:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r2, "databases");
        if (Intrinsics.areEqual(r1.getPath(), "databases") == false) goto L10;
        r1 = new PolarisFileWrapper("/data/system");
    L10:
        return r1.getAbsolutePath();
    L5:
        r2 = null;
        goto L6
    }

    @Override // gd9.l
    public final boolean isTestChannel() {
        return SetsKt.setOf(new String[]{"debug", "local_test"}).contains("obric_pacific");
    }

    @Override // gd9.l
    public final boolean j() {
        c r0 = c.a;
        return c.b();
    }

    @Override // gd9.l
    public final String m() {
        String r0 = ManifestData.getString(c, "SS_VERSION_NAME");     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return "15.2.0.1";
    L9:
        return String.valueOf(r0);
    L4:
        r0 = XmlPullParser.NO_NAMESPACE;
        goto L6
    }

    @Override // gd9.l
    public final boolean n() {
        if (HomeService.a.o() == true) goto L5;
        return false;
    L5:
        if (AccountService.a.isEnterpriseAccount() == false) goto L11;
        e10 r0 = e10.a;
        if (((qt9.q) l0.a(new qt9.q(0), new ec())).c() == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    @Override // gd9.l
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // gd9.l
    public final boolean k() {
        boolean r0 = a();
        e10 r1 = e10.a;
        boolean r2 = ((com.larus.platform.model.chat.f) l0.a(new com.larus.platform.model.chat.f(0), new i3())).b();
        yp9.d.b.a("FLowAppHost", "isObric:" + r0 + ",isUse:" + r2);
        if (r0 == false) goto L7;
        if (r2 == false) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    @Override // gd9.l
    public final long l() {
        return StatFsHelper.getInstance().getAvailableStorageSpace(StatFsHelper.StorageType.INTERNAL);
    }

    @Override // gd9.l
    public final boolean o() {
        return Intrinsics.areEqual(channel(), "auto_test");
    }

    @Override // gd9.l
    public final long p() {
        return StatFsHelper.getInstance().getAvailableStorageSpace(StatFsHelper.StorageType.EXTERNAL);
    }

    @Override // gd9.l
    public final Application getApplication() {
        return c;
    }

    @Override // gd9.l
    public final void d(long r1) {
        l.a.a(this, r1);
    }

    @Override // gd9.l
    public final long g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "dbName");
        File r4 = c.getDatabasePath(r3);
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.length();
    }

    @Override // gd9.l
    public final void q(l.b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        ConcurrentHashMap<l.b, b> r0 = b;
        b r1 = r0.get(r4);
        if (r1 == null) goto L6;
        i.b.f(r1);
        b r5 = r0.remove(r4);
        return;
    }

    @Override // gd9.l
    public final void r(l.b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        gd9.d r0 = i.b;
        b r1 = new a(r4);
        b.put(r4, r1);
        r0.b(r1);
    }

    @Override // gd9.l
    public final String c(CharSequence r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "content");
        e r0 = e.a;
        return g2a.f.a(r2, r3, r4);
    }
}
