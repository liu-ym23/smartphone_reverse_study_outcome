package com.bytedance.ee.bear.middleground.unbundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final NetService a;
    public boolean b;
    public final j c;
    public final LiveData<ConnectionService.NetworkState> d;
    public final Map<String, List<i<BenefitStore>>> e;
    public final CompositeDisposable f;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.unbundle.b$a$a, reason: collision with other inner class name */
        public static final class C0113a<T> implements Observer {
            public final /* synthetic */ b a;

            public C0113a(b r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
                b r0 = this.a;
                if (r3 == null) goto L5;
                boolean r4 = r3.a();
            L6:
                r0.b = r4;
                return;
            L5:
                r4 = true;
                goto L6
            }
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L4
            r0.d.observeForever(new C0113a(r0));     // Catch: Throwable -> L4
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
    public static final class C0114b {
    }

    public static final class c<T extends Result> implements NetService.c {
        public final /* synthetic */ boolean a;

        public c(boolean r1) {
            this.a = r1;
        }

        public final Result<BenefitStore> parse(String r7) {
            JSONObject r0 = new JSONObject(r7);
            int r8 = JSONObjectProtectorUtils.getInt(r0, "code");
            String r1 = JSONObjectProtectorUtils.getString(r0, "msg");
            if (r8 != 0) goto L13;
            JSONObject r9 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r0, WikiFolderPushPlugin.DATA), "withOwner");
            String r2 = JSONObjectProtectorUtils.getString(r9, "ownerUserId");
            String r3 = JSONObjectProtectorUtils.getString(r9, "benefits");
            JSONObject r10 = r9.optJSONObject("ownerTenantInfo");
            boolean r4 = true;
            if (r10 == null) goto L7;
            r4 = r10.optBoolean("isFreeSuite", true);
        L7:
            tt5.a.h("Benefit_FetchResBenefitExecutor", "sourceBenefit: " + r3);
            if (this.a == false) goto L11;
            if (r10 != null) goto L11;
            tt5.a.h("Benefit_FetchResBenefitExecutor", "fetch includeOwnerTenantInfo but return null. fallback to FreeSuite");
        L11:
            BenefitStore.Companion.getClass();
            NonProguard r11 = BenefitStore.b.a(r2, r3, BenefitStore.FROM_SERVER, r4);
            Result<BenefitStore> r5 = new Result();
            r5.data = r11;
            return r5;
        L13:
            tt5.a.d("Benefit_FetchResBenefitExecutor", r1);
            throw new NetService.HttpErrorException(r8, r1);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function1<BenefitStore, Unit> a;
        public final /* synthetic */ b b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Ref.ObjectRef<Disposable> e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super BenefitStore, Unit> r1, b r2, String r3, boolean r4, Ref.ObjectRef<Disposable> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r6) {
            Result r7 = (Result) r6;
            tt5.a.h("Benefit_FetchResBenefitExecutor", "fetchResBenefit...  result.size is " + ((BenefitStore) r7.data).getBenefitMap().size());
            Function1<BenefitStore, Unit> r0 = this.a;
            if (r0 == null) goto L5;
            r0.invoke(r7.data);
        L5:
            b r1 = this.b;
            String r2 = this.c;
            boolean r3 = this.d;
            BenefitStore r8 = (BenefitStore) r7.data;
            monitor-enter(r1);
            String r4 = b.b(r2, r3);     // Catch: Throwable -> L22
            List r5 = (List) ((LinkedHashMap) r1.e).get(r4);     // Catch: Throwable -> L22
            if (r5 == null) goto L16;
            Iterator<T> r9 = r5.iterator();     // Catch: Throwable -> L22
        L11:
            if (r9.hasNext() == false) goto L16;
            i r10 = (i) r9.next();     // Catch: Throwable -> L22
            if (r10.isActive() == true) goto L14;
            tt5.a.h("Benefit_FetchResBenefitExecutor", "continuation is not active");     // Catch: Throwable -> L22
            goto L11
        L14:
            r10.resumeWith(kotlin.Result.constructor-impl(r8));     // Catch: Throwable -> L22
        L16:
            r1.e.remove(r4);     // Catch: Throwable -> L22
            monitor-exit(r1);
            Disposable r11 = (Disposable) this.e.element;
            if (r11 == null) goto L33;
            this.b.f.remove(r11);
            return;
        L33:
            return;
        L22:
            th = move-exception;
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Ref.ObjectRef<Disposable> d;

        public e(b r1, String r2, boolean r3, Ref.ObjectRef<Disposable> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            b.a(this.a, this.b, this.c);
            Disposable r0 = (Disposable) this.d.element;
            if (r0 == null) goto L5;
            this.a.f.remove(r0);
        L5:
            tt5.a.e("Benefit_FetchResBenefitExecutor", "fetchResBenefit... error: ", r5, false);
        }
    }

    static {
    }

    public b(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.a = r2;
        this.b = true;
        j r3 = j.a.a;
        this.c = r3;
        this.d = r3.a();
        this.e = new LinkedHashMap();
        this.f = new CompositeDisposable();
        m.a(new a(this));
    }

    public static String b(String r1, boolean r2) {
        return r1 + '#' + r2;
    }

    public static final void a(b r2, String r3, boolean r4) {
        monitor-enter(r2);
        String r5 = b(r3, r4);     // Catch: Throwable -> L15
        List r6 = (List) ((LinkedHashMap) r2.e).get(r5);     // Catch: Throwable -> L15
        if (r6 == null) goto L12;
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L15
    L7:
        if (r7.hasNext() == false) goto L12;
        i r0 = (i) r7.next();     // Catch: Throwable -> L15
        if (r0.isActive() == true) goto L10;
        tt5.a.h("Benefit_FetchResBenefitExecutor", "continuation is not active");     // Catch: Throwable -> L15
        goto L7
    L10:
        r0.resumeWith(kotlin.Result.constructor-impl(null));     // Catch: Throwable -> L15
    L12:
        r2.e.remove(r5);     // Catch: Throwable -> L15
        monitor-exit(r2);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(String r9, int r10, Function1<? super BenefitStore, Unit> r11, boolean r12) {
        monitor-enter(this);
        NetService.f r0 = new NetService.f("/space/api/benefit/by_res");     // Catch: Throwable -> L12
        Map r1 = ((NetService.e) r0).e;     // Catch: Throwable -> L12
        String r3 = String.valueOf(((b0) org.koin.java.a.c(b0.class, null, null, 6)).getAppId());     // Catch: Throwable -> L12
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        ((HashMap) r1).put("app_id", r3);     // Catch: Throwable -> L12
        ((HashMap) ((NetService.e) r0).e).put("pull_item_names", "unbundle_doc_benefit,unbundle_doc_benefit,unbundle_wiki_benefit,unbundle_base_benefit");     // Catch: Throwable -> L12
        Map r2 = ((NetService.e) r0).e;     // Catch: Throwable -> L12
        HashMap r4 = (HashMap) r2;     // Catch: Throwable -> L12
        r4.put("obj_type", String.valueOf(r10));     // Catch: Throwable -> L12
        ((HashMap) ((NetService.e) r0).e).put(ResourceData.KEY_OBJ_TOKEN, r9);     // Catch: Throwable -> L12
        ((HashMap) ((NetService.e) r0).e).put("platform", "android");     // Catch: Throwable -> L12
        Map r13 = ((NetService.e) r0).e;     // Catch: Throwable -> L12
        HashMap r14 = (HashMap) r13;     // Catch: Throwable -> L12
        r14.put("version", ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getVersionName());     // Catch: Throwable -> L12
        if (r12 == false) goto L9;
        ((HashMap) ((NetService.e) r0).e).put("include_owner_tenant_info", "true");     // Catch: Throwable -> L12
    L9:
        Ref.ObjectRef r15 = new Ref.ObjectRef();     // Catch: Throwable -> L12
        Disposable r16 = this.a.Vc(new c(r12)).a(r0).subscribe(new d(r11, this, r9, r12, r15), new e(this, r9, r12, r15));     // Catch: Throwable -> L12
        r15.element = r16;     // Catch: Throwable -> L12
        this.f.add(r16);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
