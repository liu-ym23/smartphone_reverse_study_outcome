package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f277156i = "c";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ExecutorService f277157j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f277158k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private GrsBaseInfo f277159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f277160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f277161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f277162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f277163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f277164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f277165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FutureTask<Boolean> f277166h;

    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GrsBaseInfo f277168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f277169c;

        /* JADX INFO: renamed from: com.huawei.hms.framework.network.grs.c$a$a, reason: collision with other inner class name */
        public class RunnableC3874a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.huawei.hms.framework.network.grs.f.b f277170a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f277171b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f277172c;

            public RunnableC3874a(a r100, com.huawei.hms.framework.network.grs.f.b r101, com.huawei.hms.framework.network.grs.e.c r102) {
                this.f277172c = r100;
                this.f277170a = r101;
                this.f277171b = r102;
            }

            public void com_huawei_hms_framework_network_grs_c$a$a__run$___twin___() {
                this.f277170a.a(this.f277172c.f277167a.getPackageName(), this.f277171b);
            }

            @Override // java.lang.Runnable
            public void run() {
                com_huawei_hms_framework_network_grs_c$a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_huawei_hms_framework_network_grs_c$a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC3874a r100) {
                r100.com_huawei_hms_framework_network_grs_c$a$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(c r100, Context r101, GrsBaseInfo r102) {
            this.f277169c = r100;
            this.f277167a = r101;
            this.f277168b = r102;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.a(this.f277169c, new g());
            c.a(this.f277169c, new com.huawei.hms.framework.network.grs.e.c(this.f277167a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_"));
            c.b(this.f277169c, new com.huawei.hms.framework.network.grs.e.c(this.f277167a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_"));
            c r100 = this.f277169c;
            c.a(r100, new com.huawei.hms.framework.network.grs.e.a(c.b(r100), c.c(this.f277169c), c.a(this.f277169c)));
            c r101 = this.f277169c;
            c.a(r101, new com.huawei.hms.framework.network.grs.a(c.e(r101), c.d(this.f277169c), c.a(this.f277169c), c.c(this.f277169c)));
            if (com.huawei.hms.framework.network.grs.f.b.a(this.f277167a.getPackageName()) != null) goto L9;
            com.huawei.hms.framework.network.grs.e.c r102 = new com.huawei.hms.framework.network.grs.e.c(this.f277167a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_local_conf_");
            String r103 = r102.a(this.f277167a.getPackageName() + "#localConfig", "");
            if (TextUtils.isEmpty(r103) == false) goto L7;
        L8:
            c.c().execute(new RunnableC3874a(this, new com.huawei.hms.framework.network.grs.f.b(this.f277167a, true), r102));
            goto L9
        L7:
            if (new com.huawei.hms.framework.network.grs.f.b().a(this.f277167a, r103) == false) goto L8;
        L9:
            String r104 = new com.huawei.hms.framework.network.grs.g.j.c(this.f277168b, this.f277167a).c();
            Logger.v(c.d(), "scan serviceSet is: " + r104);
            String r105 = c.c(this.f277169c).a(PromotionProductPrivilegesStruct.SERVICES, "");
            String r106 = h.a(r105, r104);
            if (TextUtils.isEmpty(r106) == true) goto L14;
            c.c(this.f277169c).b(PromotionProductPrivilegesStruct.SERVICES, r106);
            Logger.i(c.d(), "postList is:" + StringUtils.anonymizeMessage(r106));
            Logger.d(c.d(), "currentServices:" + StringUtils.anonymizeMessage(r105));
            if (r106.equals(r105) == true) goto L14;
            c.a(this.f277169c).a(c.e(this.f277169c).getGrsParasKey(true, true, this.f277167a));
            c.a(this.f277169c).a(new com.huawei.hms.framework.network.grs.g.j.c(this.f277168b, this.f277167a), null, null, c.c(this.f277169c), c.e(this.f277169c).getQueryTimeout());
        L14:
            long r107 = SystemClock.elapsedRealtime() - c.e();
            if (c.e() != 0) goto L17;
        L18:
            Logger.i(c.d(), "Try to clear unUsed sp data.");
            c.a(SystemClock.elapsedRealtime());
            c r108 = this.f277169c;
            c.a(r108, c.b(r108).a());
        L19:
            c.d(this.f277169c).b(this.f277168b, this.f277167a);
            return Boolean.TRUE;
        L17:
            if (TimeUnit.MILLISECONDS.toHours(r107) <= 24) goto L19;
            goto L18
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() {
            return call();
        }
    }

    static {
        f277157j = ExecutorsUtils.newSingleThreadExecutor("GrsInit");
        f277158k = 0;
    }

    public c(Context r100, GrsBaseInfo r101) {
        this.f277166h = null;
        if (r100.getApplicationContext() == null) goto L6;
        r100 = r100.getApplicationContext();
    L6:
        this.f277160b = r100;
        a(r101);
        GrsBaseInfo r102 = this.f277159a;
        FutureTask<Boolean> r103 = new FutureTask(new a(this, this.f277160b, r102));
        this.f277166h = r103;
        f277157j.execute(r103);
        Logger.i(f277156i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", new Object[]{com.huawei.hms.framework.network.grs.h.a.a(), r102.getAppName(), r101.getRegCountry(), r101.getSerCountry(), r101.getIssueCountry(), Integer.valueOf(r101.getQueryTimeout())});
    }

    public c(GrsBaseInfo r100) {
        this.f277166h = null;
        a(r100);
    }

    public static /* synthetic */ long a(long r100) {
        f277158k = r100;
        return r100;
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.a a(c r100, com.huawei.hms.framework.network.grs.a r101) {
        r100.f277165g = r101;
        return r101;
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.e.a a(c r100, com.huawei.hms.framework.network.grs.e.a r101) {
        r100.f277162d = r101;
        return r101;
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.e.c a(c r100, com.huawei.hms.framework.network.grs.e.c r101) {
        r100.f277163e = r101;
        return r101;
    }

    public static /* synthetic */ g a(c r100) {
        return r100.f277161c;
    }

    public static /* synthetic */ g a(c r100, g r101) {
        r100.f277161c = r101;
        return r101;
    }

    private void a(GrsBaseInfo r100) {
        this.f277159a = r100.clone();     // Catch: CloneNotSupportedException -> L4
        return;
    L4:
        e = move-exception;
        Logger.w(f277156i, "GrsClient catch CloneNotSupportedException", e);
        this.f277159a = r100.copy();
    }

    public static /* synthetic */ void a(c r100, Map r101) {
        r100.a(r101);
    }

    private void a(Map<String, ?> r100) {
        if (r100 != null) goto L4;
    L27:
        Logger.v(f277156i, "sp's content is empty.");
        return;
    L4:
        if (r100.isEmpty() == true) goto L27;
        Set<String> r101 = r100.keySet();
        Iterator<String> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L26;
        String r103 = r102.next();
        if (r103.endsWith(this.f277160b.getPackageName() + "time") == false) goto L8;
        String r104 = this.f277163e.a(r103, "");
        long r105 = 0;
        if (TextUtils.isEmpty(r104) == false) goto L14;
    L19:
        String r106 = r103.substring(0, r103.length() - 4);
        String r107 = r106 + "ETag";
        if (b(r105) == false) goto L25;
        if (r101.contains(r106) == false) goto L25;
        if (r101.contains(r107) == true) goto L8;
    L25:
        Logger.i(f277156i, "init interface auto clear some invalid sp's data: ".concat(r103));
        this.f277163e.a(r106);
        this.f277163e.a(r103);
        this.f277163e.a(r107);
        goto L8
    L14:
        if (r104.matches("\\d+") == false) goto L19;
        r105 = CastLongProtector.parseLong(r104);     // Catch: NumberFormatException -> L17
    L17:
        e = move-exception;
        Logger.w(f277156i, "convert expire time from String to Long catch NumberFormatException.", e);
        goto L19
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.e.c b(c r100) {
        return r100.f277163e;
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.e.c b(c r100, com.huawei.hms.framework.network.grs.e.c r101) {
        r100.f277164f = r101;
        return r101;
    }

    private boolean b(long r100) {
        if ((System.currentTimeMillis() - r100) > 604800000) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.e.c c(c r100) {
        return r100.f277164f;
    }

    public static /* synthetic */ ExecutorService c() {
        return f277157j;
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.e.a d(c r100) {
        return r100.f277162d;
    }

    public static /* synthetic */ String d() {
        return f277156i;
    }

    public static /* synthetic */ long e() {
        return f277158k;
    }

    public static /* synthetic */ GrsBaseInfo e(c r100) {
        return r100.f277159a;
    }

    private boolean f() {
        FutureTask<Boolean> r100 = this.f277166h;
        if (r100 != null) goto L17;
        return false;
    L17:
    L21:
        return r100.get(8, TimeUnit.SECONDS).booleanValue();
    L10:
        e = e;
        String r101 = f277156i;
        String r102 = "init compute task interrupted.";
    L14:
        Logger.w(r101, r102, e);
        return false;
    L15:
        Logger.i(f277156i, "init compute task canceled.");
        return false;
    L12:
        e = e;
        r101 = f277156i;
        r102 = "init compute task failed.";
    L9:
        Logger.w(f277156i, "init compute task timed out");
        return false;
    L7:
        e = e;
        r101 = f277156i;
        r102 = "init compute task occur unknown Exception";
        goto L14
    }

    public String a(String r100, String r101, int r102) {
        if (this.f277159a == null) goto L12;
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (f() == true) goto L10;
        return null;
    L10:
        return this.f277165g.a(r100, r101, this.f277160b, r102);
    L12:
        Logger.w(f277156i, "invalid para!");
        return null;
    }

    public Map<String, String> a(String r100, int r101) {
        if (this.f277159a == null) goto L12;
        if (r100 == null) goto L12;
        if (f() == false) goto L11;
        return this.f277165g.a(r100, this.f277160b, r101);
    L11:
        return new HashMap();
    L12:
        Logger.w(f277156i, "invalid para!");
        return new HashMap();
    }

    public void a() {
        if (f() == true) goto L5;
        return;
    L5:
        String r100 = this.f277159a.getGrsParasKey(true, true, this.f277160b);
        this.f277163e.a(r100);
        this.f277163e.a(r100 + "time");
        this.f277163e.a(r100 + "ETag");
        this.f277161c.a(r100);
    }

    public void a(String r100, IQueryUrlsCallBack r101, int r102) {
        if (r101 != null) goto L6;
        Logger.w(f277156i, "IQueryUrlsCallBack is must not null for process continue.");
        return;
    L6:
        if (this.f277159a == null) goto L14;
        if (r100 == null) goto L14;
        if (f() == false) goto L12;
        this.f277165g.a(r100, r101, this.f277160b, r102);
        return;
    L12:
        Logger.i(f277156i, "grs init task has not completed.");
        r101.onCallBackFail(-7);
        return;
    L14:
        r101.onCallBackFail(-6);
    }

    public void a(String r100, String r101, IQueryUrlCallBack r110, int r111) {
        if (r110 != null) goto L6;
        Logger.w(f277156i, "IQueryUrlCallBack is must not null for process continue.");
        return;
    L6:
        if (this.f277159a == null) goto L15;
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        if (f() == false) goto L13;
        this.f277165g.a(r100, r101, r110, this.f277160b, r111);
        return;
    L13:
        Logger.i(f277156i, "grs init task has not completed.");
        r110.onCallBackFail(-7);
        return;
    L15:
        r110.onCallBackFail(-6);
    }

    public boolean a(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L14:
        return false;
    L8:
        if (c.class != r100.getClass()) goto L14;
        if ((r100 instanceof c) == false) goto L14;
        return this.f277159a.compare(((c) r100).f277159a);
    }

    public boolean b() {
        if (f() == true) goto L5;
        return false;
    L5:
        GrsBaseInfo r100 = this.f277159a;
        if (r100 == null) goto L12;
        Context r101 = this.f277160b;
        if (r101 == null) goto L12;
        this.f277162d.a(r100, r101);
        return true;
    L12:
        return false;
    }
}
