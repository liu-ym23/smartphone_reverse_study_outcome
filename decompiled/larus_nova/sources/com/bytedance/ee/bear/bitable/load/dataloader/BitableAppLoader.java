package com.bytedance.ee.bear.bitable.load.dataloader;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.ui.j;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableAppLoader extends zt4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f214482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f214483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f214484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f214485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<AppResourceType, c> f214486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<AppResourceType, b> f214487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<AppResourceType, a> f214488k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/load/dataloader/BitableAppLoader$AppResourceType;", "", "<init>", "(Ljava/lang/String;I)V", "ClientVarsData", "FirstScreenData", "TableSsrData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AppResourceType extends Enum<AppResourceType> {
        public static final AppResourceType ClientVarsData = null;
        public static final AppResourceType FirstScreenData = null;
        public static final AppResourceType TableSsrData = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AppResourceType[] f214489a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f214490b = null;

        public static EnumEntries<AppResourceType> getEntries() {
            return f214490b;
        }

        static {
            AppResourceType r100 = new AppResourceType("ClientVarsData", 0);
            ClientVarsData = r100;
            AppResourceType r101 = new AppResourceType("FirstScreenData", 1);
            FirstScreenData = r101;
            AppResourceType r102 = new AppResourceType("TableSsrData", 2);
            TableSsrData = r102;
            AppResourceType[] r103 = {r100, r101, r102};
            f214489a = r103;
            f214490b = EnumEntriesKt.enumEntries(r103);
        }

        public static AppResourceType[] values() {
            return (AppResourceType[]) f214489a.clone();
        }

        public static AppResourceType valueOf(String r100) {
            return (AppResourceType) r27.a.a(AppResourceType.class, r100);
        }

        public AppResourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f214491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f214492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f214493c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f214494d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f214495e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f214496f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f214497g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f214491a == r101.f214491a) goto L12;
            return false;
        L12:
            if (this.f214492b == r101.f214492b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f214493c, r101.f214493c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f214494d, r101.f214494d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f214495e, r101.f214495e) == true) goto L24;
            return false;
        L24:
            if (this.f214496f == r101.f214496f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f214497g, r101.f214497g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f214491a;
            int r101 = ((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f214492b) * 31) + this.f214493c.hashCode()) * 31) + this.f214494d.hashCode()) * 31) + this.f214495e.hashCode()) * 31;
            long r102 = this.f214496f;
            return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f214497g.hashCode();
        }

        public final String toString() {
            return "AppResourceMessage(requestStart=" + this.f214491a + ", apiCode=" + this.f214492b + ", errorMsg=" + this.f214493c + ", xttLogId=" + this.f214494d + ", source=" + this.f214495e + ", cacheElapsedTime=" + this.f214496f + ", preloadQueryResult=" + this.f214497g + ')';
        }

        public a(long r100, int r101, String r102, String r103, String r104, long r105, String r110) {
            Intrinsics.checkNotNullParameter(r102, "errorMsg");
            Intrinsics.checkNotNullParameter(r103, "xttLogId");
            Intrinsics.checkNotNullParameter(r104, "source");
            Intrinsics.checkNotNullParameter(r110, "preloadQueryResult");
            this.f214491a = r100;
            this.f214492b = r101;
            this.f214493c = r102;
            this.f214494d = r103;
            this.f214495e = r104;
            this.f214496f = r105;
            this.f214497g = r110;
        }

        public /* synthetic */ a(long r110, int r111, String r112, String r113, String r114, String r115, int r116) {
            if ((r116 & 16) == 0) goto L5;
            String r100 = ErrorType.PREFETCH;
        L7:
            if ((r116 & 64) == 0) goto L9;
            String r117 = "not_triggered";
        L10:
            this(r110, r111, r112, r113, r100, 0, r117);
            return;
        L9:
            r117 = r115;
            goto L10
        L5:
            r100 = r114;
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BitableAppData f214498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f214499b;

        public b(BitableAppData r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f214498a = r100;
            this.f214499b = r101;
        }
    }

    public interface c {
        void a(BitableAppData r100);

        void onError(Throwable r100);
    }

    public static final class d {
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableAppLoader f214500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppResourceType f214501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f214502c;

        public e(BitableAppLoader r100, AppResourceType r101, c r102) {
            this.f214500a = r100;
            this.f214501b = r101;
            this.f214502c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BitableAppLoader r100 = this.f214500a;     // Catch: Throwable -> L4
            AppResourceType r101 = this.f214501b;     // Catch: Throwable -> L4
            c r102 = this.f214502c;     // Catch: Throwable -> L4
            r100.f214486i.put(r101, r102);     // Catch: Throwable -> L4
            r100.q(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // zt4.a
    public final boolean g() {
        return false;
    }

    @Override // zt4.a
    public final boolean f() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        boolean r101 = com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile_native.prefetch");
        boolean r102 = com.bytedance.ee.bear.bitable.c.e();
        if (r101 == true) goto L6;
        if (r102 == true) goto L6;
        return false;
    L6:
        String r103 = l();
        if (r103 != null) goto L9;
        return false;
    L9:
        Map<String, String> r104 = this.f573581a.getPluginHost().a().getOriginBearUrl().f222563d;
        if (r104 == null) goto L12;
        String r105 = r104.get("pageId");
    L13:
        String r106 = r105;
        this.f214485h = r103;
        if (r102 == false) goto L16;
        long r107 = System.currentTimeMillis();
        this.f214482e = Single.fromCallable(new zt4.c(r103)).subscribeOn(fo5.d.c()).timeout(150, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.bitable.load.dataloader.e(this, r103, r107), new f(this, r103, r107));
    L18:
        if (r101 == false) goto L20;
        tt5.a.h("BitableAppLoader", "fetchAppFirstScreenData start: pageID: " + r106);
        long r110 = System.currentTimeMillis();
        this.f214483f = com.bytedance.ee.bear.bitable.preload.net.a.a(r103, r106).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.bitable.load.dataloader.a(this, r110, r103, r106), new com.bytedance.ee.bear.bitable.load.dataloader.b(this, r110, r103, r106));
    L20:
        if (r101 == true) goto L22;
        return true;
    L22:
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.app_mode.mobile.table_prefetch.enable") == false) goto L27;
        tt5.a.h("BitableAppLoader", "fetchAppTableSsrData start: pageID: " + r106);
        long r111 = System.currentTimeMillis();
        this.f214484g = com.bytedance.ee.bear.bitable.preload.net.a.b(r103, r106).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.bitable.load.dataloader.c(this, r111, r103, r106), new com.bytedance.ee.bear.bitable.load.dataloader.d(this, r111, r103, r106));
        return true;
    L27:
        return true;
    L16:
        m(r103, new a(0, -1, "Base app clientVars preload disabled", "", null, "not_triggered", 48), new Exception("Base app clientVars preload disabled"));
        goto L18
    L12:
        r105 = null;
        goto L13
    }

    @Override // zt4.a
    public final void i() {
        Disposable r100 = this.f214482e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f214483f;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        Disposable r102 = this.f214484g;
        if (r102 == null) goto L12;
        r102.dispose();
    L12:
        if (com.bytedance.ee.bear.bitable.c.e() == false) goto L20;
        String r103 = this.f214485h;
        if (r103 != null) goto L19;
        r103 = l();
        if (r103 == null) goto L20;
    L19:
        this.f214482e = fo5.d.c().scheduleDirect(new zt4.d(this, r103));
    L20:
        ((LinkedHashMap) this.f214487j).clear();
        ((LinkedHashMap) this.f214486i).clear();
        ((LinkedHashMap) this.f214488k).clear();
    }

    public final String l() {
        BearUrl r100 = this.f573581a.getPluginHost().a().getOriginBearUrl();
        if (fx4.a.g(r100) == false) goto L9;
        WikiInfo r101 = this.f573581a.getPluginHost().a().getWikiInfo();
        if (r101 != null) goto L8;
        tt5.a.k("BitableAppLoader", "resolveAppResourceToken: wiki url, but wikiInfo is null, skip app preload");
        return null;
    L8:
        String r102 = r101.getObjToken();
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L19;
        tt5.a.k("BitableAppLoader", "resolveAppResourceToken: token is empty, skip app preload");
        return null;
    L19:
        return r102;
    L12:
        if (r102.length() == 0) goto L15;
        r103 = false;
        goto L16
    L9:
        r102 = r100.f222561b;
        goto L10
    }

    public final a k(AppResourceType r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceType");
        return (a) ((LinkedHashMap) this.f214488k).get(r100);
    }

    public final void q(AppResourceType r100) {
        c r101 = (c) ((LinkedHashMap) this.f214486i).get(r100);
        b r102 = (b) ((LinkedHashMap) this.f214487j).get(r100);
        if (r101 == null) goto L11;
        if (r102 == null) goto L12;
        tt5.a.h("BitableAppLoader", "tryCallback resourceType: " + r100 + ", error: " + r102.f214499b);
        Throwable r103 = r102.f214499b;
        if (r103 == null) goto L8;
        r101.onError(r103);
    L9:
        this.f214487j.remove(r100);
        this.f214486i.remove(r100);
        return;
    L8:
        r101.a(r102.f214498a);
        goto L9
    L12:
        return;
    }

    public BitableAppLoader(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
        this.f214486i = new LinkedHashMap();
        this.f214487j = new LinkedHashMap();
        this.f214488k = new LinkedHashMap();
    }

    public static final String j(BitableAppLoader r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof NetService.ServerErrorException) == false) goto L6;
        String r102 = ((NetService.ServerErrorException) r101).getLogId();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public final void n(AppResourceType r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "resourceType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        tt5.a.h("BitableAppLoader", "setAppResourceCallback resourceType: " + r100);
        if (j.b() == false) goto L5;
        this.f214486i.put(r100, r101);
        q(r100);
        return;
    L5:
        j.c(new e(this, r100, r101));
    }

    public final void p(AppResourceType r100, a r101) {
        tt5.a.h("BitableAppLoader", "setAppResourceMessage resourceType: " + r100 + ", message: " + r101);
        this.f214488k.put(r100, r101);
    }

    public final void m(String r100, a r101, Throwable r102) {
        AppResourceType r103 = AppResourceType.ClientVarsData;
        p(r103, r101);
        o(r103, new BitableAppData("", r100, null), r102);
    }

    public final void o(AppResourceType r100, BitableAppData r101, Throwable r102) {
        tt5.a.h("BitableAppLoader", "setAppResourceData resourceType: " + r100);
        this.f214487j.put(r100, new b(r101, r102));
        q(r100);
    }
}
