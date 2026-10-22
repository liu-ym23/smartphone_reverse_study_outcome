package com.bytedance.ee.bear.middleground.unbundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.util.ui.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f234387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f234388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f234389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveData<ConnectionService.NetworkState> f234390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<i<BenefitStore>>> f234391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f234392f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f234393a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.unbundle.b$a$a, reason: collision with other inner class name */
        public static final class C3360a<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f234394a;

            public C3360a(b r100) {
                this.f234394a = r100;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
                b r102 = this.f234394a;
                if (r101 == null) goto L5;
                boolean r103 = r101.a();
            L6:
                r102.f234388b = r103;
                return;
            L5:
                r103 = true;
                goto L6
            }
        }

        public a(b r100) {
            this.f234393a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f234393a;     // Catch: Throwable -> L4
            r100.f234390d.observeForever(new C3360a(r100));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.unbundle.b$b, reason: collision with other inner class name */
    public static final class C3361b {
    }

    public static final class c<T extends Result> implements NetService.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f234395a;

        public c(boolean r100) {
            this.f234395a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<BenefitStore> parse(String r100) {
            JSONObject r101 = new JSONObject(r100);
            int r102 = JSONObjectProtectorUtils.getInt(r101, "code");
            String r103 = JSONObjectProtectorUtils.getString(r101, "msg");
            if (r102 != 0) goto L13;
            JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r101, "data"), "withOwner");
            String r105 = JSONObjectProtectorUtils.getString(r104, "ownerUserId");
            String r106 = JSONObjectProtectorUtils.getString(r104, "benefits");
            JSONObject r107 = r104.optJSONObject("ownerTenantInfo");
            boolean r108 = true;
            if (r107 == null) goto L7;
            r108 = r107.optBoolean("isFreeSuite", true);
        L7:
            tt5.a.h("Benefit_FetchResBenefitExecutor", "sourceBenefit: " + r106);
            if (this.f234395a == false) goto L11;
            if (r107 != null) goto L11;
            tt5.a.h("Benefit_FetchResBenefitExecutor", "fetch includeOwnerTenantInfo but return null. fallback to FreeSuite");
        L11:
            BenefitStore.Companion.getClass();
            BenefitStore r109 = BenefitStore.b.a(r105, r106, BenefitStore.FROM_SERVER, r108);
            Result<BenefitStore> r110 = new Result();
            r110.data = r109;
            return r110;
        L13:
            tt5.a.d("Benefit_FetchResBenefitExecutor", r103);
            throw new NetService.HttpErrorException(r102, r103);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<BenefitStore, Unit> f234396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f234397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f234398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f234399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Disposable> f234400e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super BenefitStore, Unit> r100, b r101, String r102, boolean r103, Ref.ObjectRef<Disposable> r104) {
            this.f234396a = r100;
            this.f234397b = r101;
            this.f234398c = r102;
            this.f234399d = r103;
            this.f234400e = r104;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Result r101 = (Result) r100;
            tt5.a.h("Benefit_FetchResBenefitExecutor", "fetchResBenefit...  result.size is " + ((BenefitStore) r101.data).getBenefitMap().size());
            Function1<BenefitStore, Unit> r102 = this.f234396a;
            if (r102 == 0) goto L5;
            r102.invoke(r101.data);
        L5:
            b r103 = this.f234397b;
            String r104 = this.f234398c;
            boolean r105 = this.f234399d;
            BenefitStore r106 = (BenefitStore) r101.data;
            monitor-enter(r103);
            String r107 = b.b(r104, r105);     // Catch: Throwable -> L22
            List r108 = (List) ((LinkedHashMap) r103.f234391e).get(r107);     // Catch: Throwable -> L22
            if (r108 == null) goto L16;
            Iterator<T> r109 = r108.iterator();     // Catch: Throwable -> L22
        L11:
            if (r109.hasNext() == false) goto L16;
            i r110 = (i) r109.next();     // Catch: Throwable -> L22
            if (r110.isActive() == true) goto L14;
            tt5.a.h("Benefit_FetchResBenefitExecutor", "continuation is not active");     // Catch: Throwable -> L22
            goto L11
        L14:
            r110.resumeWith(kotlin.Result.m9449constructorimpl(r106));     // Catch: Throwable -> L22
        L16:
            r103.f234391e.remove(r107);     // Catch: Throwable -> L22
            monitor-exit(r103);
            Disposable r111 = this.f234400e.element;
            if (r111 == null) goto L33;
            this.f234397b.f234392f.remove(r111);
            return;
        L33:
            return;
        L22:
            th = move-exception;
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f234401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f234402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f234403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Disposable> f234404d;

        public e(b r100, String r101, boolean r102, Ref.ObjectRef<Disposable> r103) {
            this.f234401a = r100;
            this.f234402b = r101;
            this.f234403c = r102;
            this.f234404d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            b.a(this.f234401a, this.f234402b, this.f234403c);
            Disposable r102 = this.f234404d.element;
            if (r102 == null) goto L5;
            this.f234401a.f234392f.remove(r102);
        L5:
            tt5.a.e("Benefit_FetchResBenefitExecutor", "fetchResBenefit... error: ", r101, false);
        }
    }

    static {
    }

    public b(NetService r100) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        this.f234387a = r100;
        this.f234388b = true;
        j r101 = j.a.f217090a;
        this.f234389c = r101;
        this.f234390d = r101.a();
        this.f234391e = new LinkedHashMap();
        this.f234392f = new CompositeDisposable();
        m.a(new a(this));
    }

    public static String b(String r100, boolean r101) {
        return r100 + '#' + r101;
    }

    public static final void a(b r100, String r101, boolean r102) {
        monitor-enter(r100);
        String r103 = b(r101, r102);     // Catch: Throwable -> L15
        List r104 = (List) ((LinkedHashMap) r100.f234391e).get(r103);     // Catch: Throwable -> L15
        if (r104 == null) goto L12;
        Iterator r105 = r104.iterator();     // Catch: Throwable -> L15
    L7:
        if (r105.hasNext() == false) goto L12;
        i r106 = (i) r105.next();     // Catch: Throwable -> L15
        if (r106.isActive() == true) goto L10;
        tt5.a.h("Benefit_FetchResBenefitExecutor", "continuation is not active");     // Catch: Throwable -> L15
        goto L7
    L10:
        r106.resumeWith(kotlin.Result.m9449constructorimpl(null));     // Catch: Throwable -> L15
    L12:
        r100.f234391e.remove(r103);     // Catch: Throwable -> L15
        monitor-exit(r100);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [T, io.reactivex.disposables.Disposable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final synchronized void c(String r100, int r110, Function1<? super BenefitStore, Unit> r111, boolean r112) {
        monitor-enter(this);
        NetService.f r101 = new NetService.f("/space/api/benefit/by_res");     // Catch: Throwable -> L12
        Map<String, String> r102 = r101.f216908e;     // Catch: Throwable -> L12
        String r103 = String.valueOf(((b0) org.koin.java.a.c(b0.class, null, null, 6)).getAppId());     // Catch: Throwable -> L12
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        ((HashMap) r102).put("app_id", r103);     // Catch: Throwable -> L12
        ((HashMap) r101.f216908e).put("pull_item_names", "unbundle_doc_benefit,unbundle_doc_benefit,unbundle_wiki_benefit,unbundle_base_benefit");     // Catch: Throwable -> L12
        Map<String, String> r104 = r101.f216908e;     // Catch: Throwable -> L12
        HashMap r105 = (HashMap) r104;     // Catch: Throwable -> L12
        r105.put("obj_type", String.valueOf(r110));     // Catch: Throwable -> L12
        ((HashMap) r101.f216908e).put("obj_token", r100);     // Catch: Throwable -> L12
        ((HashMap) r101.f216908e).put("platform", "android");     // Catch: Throwable -> L12
        Map<String, String> r113 = r101.f216908e;     // Catch: Throwable -> L12
        HashMap r114 = (HashMap) r113;     // Catch: Throwable -> L12
        r114.put("version", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getVersionName());     // Catch: Throwable -> L12
        if (r112 == false) goto L9;
        ((HashMap) r101.f216908e).put("include_owner_tenant_info", "true");     // Catch: Throwable -> L12
    L9:
        Ref.ObjectRef r115 = new Ref.ObjectRef();     // Catch: Throwable -> L12
        ?? r106 = this.f234387a.Vc(new c(r112)).a(r101).subscribe(new d(r111, this, r100, r112, r115), new e(this, r100, r112, r115));     // Catch: Throwable -> L12
        r115.element = r106;     // Catch: Throwable -> L12
        this.f234392f.add(r106);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
