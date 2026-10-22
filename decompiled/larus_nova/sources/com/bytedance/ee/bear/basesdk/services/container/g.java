package com.bytedance.ee.bear.basesdk.services.container;

import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements s45.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f206641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t45.b f206642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f206643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final KVRepo f206644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.storage.kv.repo.a f206645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f206646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<s45.c.a> f206647g;

    public static final class a {
    }

    public static final class b implements NetService.c<Result<String>> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<String> parse(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Result<String> r101 = new Result();
            JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L5
            int r103 = r102.optInt("code");     // Catch: JSONException -> L5
            String r104 = r102.optString("data", "");     // Catch: JSONException -> L5
            r101.code = r103;     // Catch: JSONException -> L5
            r101.data = r104;     // Catch: JSONException -> L5
        L7:
            return r101;
        L5:
            e = move-exception;
            tt5.a.e("UserDomainCharacteristicServiceImpl", "parse: error", e, false);
            goto L7
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f206648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f206649b;

        public c(boolean r100, g r101) {
            this.f206648a = r100;
            this.f206649b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Result<String> r101 = (Result) r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            if (this.f206648a == false) goto L25;
            g r102 = this.f206649b;
            r102.getClass();
            String r103 = "";
            tt5.a.h("UserDomainCharacteristicServiceImpl", "saveAndNotifyOnlyDomainPool()...");
            if (r102.d(r101) == false) goto L31;
            String r104 = (String) r101.data;
            HashMap r105 = new HashMap();     // Catch: Exception -> L23
            String r106 = new JSONObject(r104).optJSONObject("common").optString("domainPool");     // Catch: Exception -> L23
            String r107 = r102.f206644d.getString("domain_pool", "");     // Catch: Exception -> L23
            if (r107 == null) goto L12;
            r103 = r107;
        L12:
            tt5.a.b("UserDomainCharacteristicServiceImpl", "checkItemSame()... oldValue = " + r103 + ", newValue = " + r106);     // Catch: Exception -> L23
            if (TextUtils.equals(r106, r103) == true) goto L15;
            r105.put("domain_pool", r106);     // Catch: Exception -> L23
        L15:
            CopyOnWriteArrayList<s45.c.a> r108 = r102.f206647g;     // Catch: Exception -> L23
            if (r108 == null) goto L21;
            Iterator r109 = new ArrayList(r108).iterator();     // Catch: Exception -> L23
        L19:
            if (r109.hasNext() == false) goto L21;
            s45.c.a r110 = (s45.c.a) r109.next();     // Catch: Exception -> L23
            Intrinsics.checkNotNullParameter(r110, "listener");     // Catch: Exception -> L23
            r110.a(r105);     // Catch: Exception -> L23
        L21:
            tt5.a.h("UserDomainCharacteristicServiceImpl", "saveAndNotify()...domainPool = " + r106);     // Catch: Exception -> L23
            return;
        L23:
            e = move-exception;
            tt5.a.f("UserDomainCharacteristicServiceImpl", e, false);
            return;
        L31:
            return;
        L25:
            g.a(this.f206649b, r101);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f206650a = null;

        static {
            f206650a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.e("UserDomainCharacteristicServiceImpl", "fetchConfig exception!", r101, false);
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f206651a;

        public e(g r100) {
            this.f206651a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Boolean) r100, "it");
            String r101 = "";
            String r102 = this.f206651a.f206644d.getString("domain_characteristic_config", "");
            if (r102 == null) goto L6;
            r101 = r102;
        L6:
            tt5.a.h("UserDomainCharacteristicServiceImpl", "cache domainCharacteristicConfig = ".concat(r101));
            if (TextUtils.isEmpty(r101) == false) goto L10;
            return this.f206651a.c().map(new h(this.f206651a));
        L10:
            return Flowable.just(SliceInitService.DEFAULT_SWITCH);
        }
    }

    static {
    }

    @Override // s45.c
    public final synchronized String O6() {
        monitor-enter(this);
        String r100 = getString("domain_characteristic_config", SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L16
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
    L13:
        dd(false);     // Catch: Throwable -> L16
        tt5.a.h("UserDomainCharacteristicServiceImpl", "getStringSync()... key = domain_characteristic_config, value is null or empty");     // Catch: Throwable -> L16
        String r102 = (String) BuildersKt.runBlocking$default(null, new UserDomainCharacteristicServiceImpl$getStringSync$1(this, new Ref.ObjectRef(), "domain_characteristic_config", SliceInitService.DEFAULT_SWITCH, null), 1, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L10:
        if (TextUtils.equals(r100, SliceInitService.DEFAULT_SWITCH) == true) goto L13;
        monitor-exit(this);
        return r100;
    L7:
        r101 = false;
    L16:
        th = move-exception;
        throw th;
    }

    public final Flowable<Result<String>> c() {
        tt5.a.h("UserDomainCharacteristicServiceImpl", "fetchConfigFlowable()...");
        NetService.d r100 = this.f206641a.Vc(new b());
        NetService.f r101 = new NetService.f("/api/infra/domains/all");
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.ark_domain") == true) goto L5;
        r101.f216904a = this.f206642b.a().f216936a;
    L5:
        tt5.a.h("UserDomainCharacteristicServiceImpl", "fetchConfigFlowable request.host=" + r101.f216904a);
        return r100.a(r101).observeOn(fo5.d.b());
    }

    @Override // s45.c
    public final Flowable<String> ka() {
        tt5.a.h("UserDomainCharacteristicServiceImpl", "getDomainCharacteristicConfig()...");
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).flatMap(new e(this));
    }

    @Override // s45.c
    public final String Ba(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.f206644d.getString(r100, "");
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // s45.c
    public final void R8(String r100) {
        com.ss.android.lark.storage.kv.repo.a r101 = this.f206645e;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.remove(r100);
    }

    @Override // s45.c
    public final void b1(s45.c.a r100) {
        tt5.a.h("UserDomainCharacteristicServiceImpl", "registerConfigChangeListener()... listener = " + r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f206647g.contains(r100) == true) goto L9;
        this.f206647g.add(r100);
        return;
    }

    public final boolean d(Result<String> r100) {
        tt5.a.h("UserDomainCharacteristicServiceImpl", "needChange()...code = " + r100.code + ", data = " + ((String) r100.data));
        if (r100.code == 0) goto L6;
        tt5.a.h("UserDomainCharacteristicServiceImpl", "needChange()...false for illegal code");
        return false;
    L6:
        String r101 = "";
        String r102 = this.f206644d.getString("domain_characteristic_config", "");
        if (r102 == null) goto L11;
        r101 = r102;
    L11:
        if (TextUtils.isEmpty((CharSequence) r100.data) == false) goto L13;
        return false;
    L13:
        if (TextUtils.equals(r101, (CharSequence) r100.data) == true) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // s45.c
    public final void dd(boolean r100) {
        tt5.a.h("UserDomainCharacteristicServiceImpl", "fetchConfig()... onlyDomainPool " + r100);
        this.f206646f.add(c().subscribe(new c(r100, this), d.f206650a));
    }

    @Override // s45.c
    public final void o4(s45.c.a r100) {
        tt5.a.h("UserDomainCharacteristicServiceImpl", "unregisterConfigChangeListener()... listener = " + r100);
        if (r100 == null) goto L6;
        this.f206647g.remove(r100);
        return;
    }

    @Override // s45.c
    public final String t6(String r100) {
        com.ss.android.lark.storage.kv.repo.a r101 = this.f206645e;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r102 = r101.getString(r100, "");
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    }

    public static final void a(g r110, Result r111) {
        r110.getClass();
        tt5.a.h("UserDomainCharacteristicServiceImpl", "saveAndNotify()...");
        if (r110.d(r111) == false) goto L20;
        String r112 = (String) r111.data;
        HashMap r100 = new HashMap();     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L14
        r110.b("domain_characteristic_config", r112, r100);     // Catch: Exception -> L14
        JSONObject r101 = new JSONObject(r112);     // Catch: Exception -> L14
        JSONObject r113 = r101.optJSONObject("common");     // Catch: Exception -> L14
        String r102 = r113.optString("domainPool");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L14
        r110.b("domain_pool", r102, r100);     // Catch: Exception -> L14
        String r114 = r101.optString("overload_static_domain_new");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r114);     // Catch: Exception -> L14
        r110.b("overload_static_domain_new", r114, r100);     // Catch: Exception -> L14
        String r103 = r101.optString("space_api");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L14
        r110.b("space_api", r103, r100);     // Catch: Exception -> L14
        JSONObject r104 = r113.optJSONObject("domain");     // Catch: Exception -> L14
        String r115 = r104.optString("helpcenter");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r115);     // Catch: Exception -> L14
        r110.b("helpcenter", r115, r100);     // Catch: Exception -> L14
        String r105 = r104.optString("official");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L14
        r110.b("official", r105, r100);     // Catch: Exception -> L14
        String r116 = r113.optJSONObject("helpcenter_article").optString("authorized_help");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r116);     // Catch: Exception -> L14
        r110.b("compatible_extension", r116, r100);     // Catch: Exception -> L14
        String r106 = r101.optJSONObject("paramsConfig").optString("unitID");     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L14
        r110.b("unitID", r106, r100);     // Catch: Exception -> L14
        CopyOnWriteArrayList<s45.c.a> r117 = r110.f206647g;     // Catch: Exception -> L14
        if (r117 == null) goto L12;
        Iterator r118 = new ArrayList(r117).iterator();     // Catch: Exception -> L14
    L10:
        if (r118.hasNext() == false) goto L12;
        s45.c.a r107 = (s45.c.a) r118.next();     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r107, "listener");     // Catch: Exception -> L14
        r107.a(r100);     // Catch: Exception -> L14
    L12:
        tt5.a.h("UserDomainCharacteristicServiceImpl", "saveAndNotify()...domainPool = " + r102 + ", spaceApi = " + r103 + ", helpCenter = " + r115 + ", official = " + r105 + ", compatibleExtension = " + r116 + ", unitID = " + r106);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        tt5.a.f("UserDomainCharacteristicServiceImpl", e, false);
        return;
    }

    @Override // s45.c
    public final String getString(String r100, String r101) {
        KVRepo r102 = this.f206644d;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r103 = r102.getString(r100, r101);
        if (r103 != null) goto L9;
        return "";
    L9:
        return r103;
    }

    @Override // s45.c
    public final void h7(String r100, String r101) {
        String[] r102 = this.f206645e.b();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        String r105 = r102[r104];
        if (TextUtils.equals(r100, this.f206645e.getString(r105, null)) == false) goto L7;
    L8:
        this.f206645e.remove(r105);
    L9:
        r104 = r104 + 1;
        goto L3
    L7:
        if (TextUtils.equals(r101, r105) == false) goto L9;
    L10:
        com.ss.android.lark.storage.kv.repo.a r106 = this.f206645e;
        if (r100 != null) goto L13;
        r100 = "";
    L13:
        if (r101 != null) goto L15;
        r101 = "";
    L15:
        r106.putString(r100, r101);
    }

    public final void b(String r100, String r101, Map<String, String> r102) {
        String r103 = "";
        String r104 = this.f206644d.getString(r100, "");
        if (r104 == null) goto L6;
        r103 = r104;
    L6:
        tt5.a.b("UserDomainCharacteristicServiceImpl", "checkItemSame()...key = " + r100 + ", oldValue = " + r103 + ", newValue = " + r101);
        if (TextUtils.equals(r101, r103) == true) goto L10;
        this.f206644d.putString(r100, r101);
        ((HashMap) r102).put(r100, r101);
        return;
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [T, androidx.lifecycle.LiveData] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.bytedance.ee.bear.basesdk.services.container.UserDomainCharacteristicServiceImpl$observerListener$networkStateObserver$1] */
    @Inject
    public g(by4.d r100, NetService r101, t45.b r102, m r103) {
        Intrinsics.checkNotNullParameter(r100, "kvStore");
        Intrinsics.checkNotNullParameter(r101, "netService");
        Intrinsics.checkNotNullParameter(r102, "docDomainConfig");
        Intrinsics.checkNotNullParameter(r103, "passportUserService");
        this.f206646f = new CompositeDisposable();
        this.f206647g = new CopyOnWriteArrayList();
        this.f206641a = r101;
        this.f206642b = r102;
        this.f206643c = r103;
        this.f206644d = r100.b("domain");
        LarkKVStorage.KVStorageBuilder r104 = new LarkKVStorage.KVStorageBuilder(LarkContext.getApplication());
        LarkKVStorage.KVStorageBuilder.c(r104, r103.getSession().f438138b);
        LarkKVStorage.b r105 = LarkKVStorage.r(r104.b());
        com.ss.android.lark.storage.a r106 = ay4.b.f16748a;
        Intrinsics.checkNotNullParameter(r106, "domain");
        r105.f440933b = r106;
        r105.f440934c = "domain_redirect";
        com.ss.android.lark.storage.kv.repo.a r107 = r105.a();
        this.f206645e = r107;
        r107.putString("bytedance.feishu.cn", "bytedance.larkoffice.com");
        com.bytedance.ee.bear.contract.j r108 = com.bytedance.ee.bear.contract.j.a.f217090a;
        final Ref.ObjectRef r109 = new Ref.ObjectRef();
        r109.element = r108.a();
        ?? r110 = new UserDomainCharacteristicServiceImpl$observerListener$networkStateObserver$1(this, r109);
        if (r108.getNetworkState().a() == true) goto L5;
        com.bytedance.ee.util.ui.m.d(new i(r109, r110));
    L5:
        r103.d(new j(this, r109, r110));
    }
}
