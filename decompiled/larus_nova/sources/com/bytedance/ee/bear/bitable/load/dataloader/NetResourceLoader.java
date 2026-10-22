package com.bytedance.ee.bear.bitable.load.dataloader;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.preload.net.MobileViewCacheParser;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.ui.j;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
public final class NetResourceLoader extends zt4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f214503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<ResourceType, c> f214504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<ResourceType, b> f214505g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/load/dataloader/NetResourceLoader$ResourceType;", "", "<init>", "(Ljava/lang/String;I)V", "ClientVars", "MainPage", "DashboardData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ResourceType extends Enum<ResourceType> {
        public static final ResourceType ClientVars = null;
        public static final ResourceType DashboardData = null;
        public static final ResourceType MainPage = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResourceType[] f214506a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f214507b = null;

        public static EnumEntries<ResourceType> getEntries() {
            return f214507b;
        }

        static {
            ResourceType r100 = new ResourceType("ClientVars", 0);
            ClientVars = r100;
            ResourceType r101 = new ResourceType("MainPage", 1);
            MainPage = r101;
            ResourceType r102 = new ResourceType("DashboardData", 2);
            DashboardData = r102;
            ResourceType[] r103 = {r100, r101, r102};
            f214506a = r103;
            f214507b = EnumEntriesKt.enumEntries(r103);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) f214506a.clone();
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) r27.a.a(ResourceType.class, r100);
        }

        public ResourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BitableResourceData f214508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f214509b;

        public b(BitableResourceData r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f214508a = r100;
            this.f214509b = r101;
        }
    }

    public interface c {
        void a(BitableResourceData r100);

        void onError(Throwable r100);
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetResourceLoader f214510a;

        public d(NetResourceLoader r100) {
            this.f214510a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Result r101 = (Result) r100;
            if (r101.code != 0) goto L5;
            this.f214510a.m(ResourceType.ClientVars, (BitableResourceData) r101.data, null);
            return;
        L5:
            this.f214510a.m(ResourceType.ClientVars, new BitableResourceData(), new Exception(r101.code + ',' + r101.msg));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetResourceLoader f214511a;

        public e(NetResourceLoader r100) {
            this.f214511a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            NetResourceLoader r101 = this.f214511a;
            ResourceType r102 = ResourceType.ClientVars;
            BitableResourceData r103 = new BitableResourceData();
            r101.m(r102, r103, (Throwable) r100);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetResourceLoader f214512a;

        public f(NetResourceLoader r100) {
            this.f214512a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Result r101 = (Result) r100;
            if (r101.code != 0) goto L5;
            this.f214512a.m(ResourceType.DashboardData, (BitableResourceData) r101.data, null);
            return;
        L5:
            this.f214512a.m(ResourceType.DashboardData, new BitableResourceData(), new Exception(r101.code + ',' + r101.msg));
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetResourceLoader f214513a;

        public g(NetResourceLoader r100) {
            this.f214513a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            NetResourceLoader r101 = this.f214513a;
            ResourceType r102 = ResourceType.DashboardData;
            BitableResourceData r103 = new BitableResourceData();
            r101.m(r102, r103, (Throwable) r100);
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetResourceLoader f214514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ResourceType f214515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f214516c;

        public h(NetResourceLoader r100, ResourceType r101, c r102) {
            this.f214514a = r100;
            this.f214515b = r101;
            this.f214516c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetResourceLoader r100 = this.f214514a;     // Catch: Throwable -> L4
            ResourceType r101 = this.f214515b;     // Catch: Throwable -> L4
            c r102 = this.f214516c;     // Catch: Throwable -> L4
            r100.f214504f.put(r101, r102);     // Catch: Throwable -> L4
            r100.n(r101);     // Catch: Throwable -> L4
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
    public final boolean f() {
        zt4.h r100 = (zt4.h) this.f573581a.e(zt4.h.class);
        BitableResourceData r101 = null;
        if (r100 == null) goto L5;
        zr4.a r102 = r100.f573597g;
    L6:
        zt4.f r103 = (zt4.f) this.f573581a.e(zt4.f.class);
        if (r103 == null) goto L9;
        r101 = r103.f573591f;
    L9:
        boolean r104 = this.f573581a.i().N(sbb.e.f541298i.getType());
        if (r102 != null) goto L14;
        m(ResourceType.ClientVars, new BitableResourceData(), new Exception("firstBlock null"));
        return false;
    L14:
        if (r104 == true) goto L21;
        if (r101 != null) goto L21;
        int r105 = r102.f573415c;
        if (r105 != 83) goto L19;
    L20:
        tt5.a.h("NetResourceLoader", "fetchMobileViewCache start: " + r102);
        this.f573581a.A("BITABLE_NATIVE_PREFETCH_CLIENTVARS_START", System.currentTimeMillis());
        this.f573581a.h("request_type", "req_mobileview");
        int r106 = com.bytedance.ee.bear.bitable.preload.net.a.f215015a;
        Intrinsics.checkNotNullParameter(r102, "firstBlockData");
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        NetService.f r108 = new NetService.f(String.format("/api/bitable/%s/mobile_view", Arrays.copyOf(new Object[]{r102.f573413a}, 1)));
        Intrinsics.checkNotNullParameter(r102, "firstBlockData");
        Intrinsics.checkNotNullParameter(r108, "request");
        String r109 = r102.f573414b;
        r102.a();
        iu4.f.a(r109, r102.f573419g, "0", r102.f573422j, r108);
        r108.b(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, "zh");
        this.f214503e = ((NetService) k.a(LarkContext.getApplication(), NetService.class)).Vc(new MobileViewCacheParser()).a(r108).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.bitable.load.dataloader.g(this), new com.bytedance.ee.bear.bitable.load.dataloader.h(this));
    L26:
        return true;
    L19:
        if (r105 == (-1)) goto L20;
    L21:
        j(r102);
        if (r102.f573415c != 36) goto L26;
        if (com.bytedance.ee.bear.bitable.c.k() == false) goto L26;
        k(r102);
        goto L26
    L5:
        r102 = null;
        goto L6
    }

    @Override // zt4.a
    public final boolean g() {
        zt4.h r100 = (zt4.h) this.f573581a.e(zt4.h.class);
        BitableResourceData r101 = null;
        if (r100 == null) goto L5;
        zr4.a r102 = r100.f573597g;
    L6:
        zt4.f r103 = (zt4.f) this.f573581a.e(zt4.f.class);
        if (r103 == null) goto L9;
        r101 = r103.f573591f;
    L9:
        boolean r104 = this.f573581a.i().N(sbb.e.f541298i.getType());
        if (r102 == null) goto L20;
        if (r104 == true) goto L13;
        if (r101 != null) goto L13;
        return false;
    L13:
        j(r102);
        if (r102.f573415c == 36) goto L16;
        return true;
    L16:
        if (com.bytedance.ee.bear.bitable.c.k() == false) goto L23;
        k(r102);
        return true;
    L23:
        return true;
    L20:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    @Override // zt4.a
    public final void i() {
        Disposable r100 = this.f214503e;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final void j(zr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "firstBlock");
        tt5.a.h("NetResourceLoader", "fetchBitableClientVars start: " + r100);
        this.f573581a.A("BITABLE_NATIVE_PREFETCH_CLIENTVARS_START", System.currentTimeMillis());
        this.f573581a.h("request_type", "req_clientvar");
        m(ResourceType.MainPage, new BitableResourceData(), new Exception("not fetch mobile view"));
        int r101 = com.bytedance.ee.bear.bitable.preload.net.a.f215015a;
        Intrinsics.checkNotNullParameter(r100, "firstBlockData");
        String r102 = r100.f573413a;
        String r103 = r100.f573414b;
        r100.a();
        this.f214503e = com.bytedance.ee.bear.bitable.preload.net.a.c(r102, r103, r100.f573419g, r100.f573422j).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
    }

    public final void k(zr4.a r100) {
        tt5.a.h("NetResourceLoader", "fetchDashboardData start: " + r100);
        this.f573581a.A("BITABLE_NATIVE_PREFETCH_DASHBOARD_DATA_START", System.currentTimeMillis());
        this.f573581a.h("request_type", "req_dashboard_data");
        int r101 = com.bytedance.ee.bear.bitable.preload.net.a.f215015a;
        Intrinsics.checkNotNullParameter(r100, "firstBlock");
        String r102 = r100.f573413a;
        String r103 = r100.f573414b;
        r100.a();
        this.f214503e = com.bytedance.ee.bear.bitable.preload.net.a.d(r102, r103, r100.f573419g).observeOn(fo5.d.d()).subscribe(new f(this), new g(this));
    }

    public final void n(ResourceType r100) {
        c r101 = (c) ((LinkedHashMap) this.f214504f).get(r100);
        b r102 = (b) ((LinkedHashMap) this.f214505g).get(r100);
        if (r101 == null) goto L11;
        if (r102 == null) goto L12;
        tt5.a.h("NetResourceLoader", "tryCallback resourceType: " + r100 + ", error: " + r102.f214509b);
        Throwable r103 = r102.f214509b;
        if (r103 == null) goto L8;
        r101.onError(r103);
    L9:
        this.f214505g.remove(r100);
        this.f214504f.remove(r100);
        return;
    L8:
        r101.a(r102.f214508a);
        goto L9
    L12:
        return;
    }

    public NetResourceLoader(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
        this.f214504f = new LinkedHashMap();
        this.f214505g = new LinkedHashMap();
    }

    public final void l(ResourceType r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "resourceType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        tt5.a.h("NetResourceLoader", "setResourcesCallback resourceType: " + r100);
        if (j.b() == false) goto L5;
        this.f214504f.put(r100, r101);
        n(r100);
        return;
    L5:
        j.c(new h(this, r100, r101));
    }

    public final void m(ResourceType r100, BitableResourceData r101, Throwable r102) {
        tt5.a.h("NetResourceLoader", "setResourcesData resourceType: " + r100);
        if (r100 != ResourceType.ClientVars) goto L5;
        this.f573581a.A("BITABLE_NATIVE_PREFETCH_CLIENTVARS_END", System.currentTimeMillis());
    L5:
        this.f214505g.put(r100, new b(r101, r102));
        n(r100);
    }
}
