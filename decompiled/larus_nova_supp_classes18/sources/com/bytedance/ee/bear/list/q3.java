package com.bytedance.ee.bear.list;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.offline.DocWikiInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.subscribe.SubscribeExecutor;
import com.bytedance.ee.bear.tts.impl.model.TtsMetaModel$reload$2;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q3 implements com.bytedance.ee.bear.contract.c0 {
    public final List<com.bytedance.ee.bear.contract.c0.d> a;
    public final Context b;
    public final s c;
    public final com.bytedance.ee.bear.list.create.g0 d;
    public final ae5.s e;
    public final od5.j f;
    public final SubscribeExecutor g;
    public kd5.c2 h;
    public final CompositeDisposable i;

    public class a implements ae5.s.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ com.bytedance.ee.bear.contract.d c;
        public final /* synthetic */ q3 d;

        @Override // ae5.s.a
        public final void onSuccess() {
            Context r0 = this.d.b;
            Toast.showSuccessText(r0, r0.getString(2131887476), 0);
            this.d.q(this.a, this.b, false);
            q3.a(this.d, this.a, false);
            q3.b(this.d, this.c, "star", "succeed");
        }

        @Override // ae5.s.a
        public final void onFail(int r3, Throwable r4) {
            Context r5 = this.d.b;
            Toast.showFailureText(r5, r5.getString(2131887959), 0);
            q3.b(this.d, this.c, "star", "failed");
        }

        public a(q3 r1, String r2, int r3, com.bytedance.ee.bear.contract.d r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class b implements ae5.s.a {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ com.bytedance.ee.bear.contract.d d;
        public final /* synthetic */ q3 e;

        @Override // ae5.s.a
        public final void onSuccess() {
            q3 r0 = this.e;
            final Context r1 = this.a;
            r0.getClass();
            if (r1 != null) goto L5;
        L8:
            this.e.q(this.b, this.c, true);
            q3.a(this.e, this.b, true);
            dd5.s1.a.a.e();
            q3.b(this.e, this.d, "star", "succeed");
            return;
        L5:
            if (AppInfoUtils.f().booleanValue() == false) goto L7;
            Toast.showSuccessText(r1, 2131887475);
            goto L8
        L7:
            UDToast.a r2 = UDToast.build(r1);
            r2.b.e(2131887475);
            r2.d(Toast.getSuccessIcon());
            r2.b(2131887460, new g1(r1));
            r2.h();
            goto L8
        }

        @Override // ae5.s.a
        public final void onFail(int r3, Throwable r4) {
            Context r5 = this.e.b;
            Toast.showFailureText(r5, r5.getString(2131887874), 0);
            q3.b(this.e, this.d, "star", "failed");
        }

        public b(q3 r1, Context r2, String r3, int r4, com.bytedance.ee.bear.contract.d r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class c implements od5.j.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.ee.bear.contract.d c;
        public final /* synthetic */ q3 d;

        @Override // od5.j.a
        public final void onSuccess() {
            tt5.a.h("ListDataServiceImpl", "unpin success");
            Context r0 = this.d.b;
            String r1 = xo5.a.c(r0, 2131889644, "SidebarSection", r0.getString(2131889647));
            Context r2 = this.d.b;
            if (qc5.a.h() == true) goto L5;
        L7:
            r1 = this.d.b.getString(2131887960);
        L8:
            Toast.showSuccessText(r2, r1, 0);
            q3.e(this.d, this.b, false);
            q3.f(this.d, this.b, false);
            q3.b(this.d, this.c, "pin", "succeed");
            return;
        L5:
            if (this.a == 0) goto L7;
            goto L7
        }

        @Override // od5.j.a
        public final void onFail(int r3, Throwable r4) {
            tt5.a.e("ListDataServiceImpl", "unpin fail: code = " + r3, r4, false);
            Context r5 = this.d.b;
            Toast.showFailureText(r5, r5.getString(2131887959), 0);
            q3.b(this.d, this.c, "pin", "failed");
        }

        public c(q3 r1, int r2, String r3, com.bytedance.ee.bear.contract.d r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class d implements od5.j.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.ee.bear.contract.d c;
        public final /* synthetic */ q3 d;

        @Override // od5.j.a
        public final void onSuccess() {
            tt5.a.h("ListDataServiceImpl", "pin success");
            Context r0 = this.d.b;
            String r1 = xo5.a.c(r0, 2131889648, "SidebarSection", r0.getString(2131889647));
            Context r2 = this.d.b;
            if (qc5.a.h() == true) goto L5;
        L7:
            r1 = this.d.b.getString(2131887877);
        L8:
            Toast.showSuccessText(r2, r1, 0);
            q3.e(this.d, this.b, true);
            q3.f(this.d, this.b, true);
            Iterator<WeakReference<dd5.m1>> r3 = dd5.s1.a.a.c.iterator();
        L10:
            if (r3.hasNext() == false) goto L16;
            WeakReference<dd5.m1> r4 = r3.next();
            if (r4 == null) goto L10;
            if (r4.get() == null) goto L10;
            r4.get().Jl();
            goto L10
        L16:
            q3.b(this.d, this.c, "pin", "succeed");
            return;
        L5:
            if (this.a == 0) goto L7;
            goto L7
        }

        @Override // od5.j.a
        public final void onFail(int r3, Throwable r4) {
            tt5.a.e("ListDataServiceImpl", "pin fail: code = " + r3, r4, false);
            if ((r4 instanceof NetService.ServerErrorException) == true) goto L5;
        L8:
            Context r5 = this.d.b;
            Toast.showFailureText(r5, r5.getString(2131887874), 0);
            q3.b(this.d, this.c, "pin", "failed");
            return;
        L5:
            if (((NetService.ServerErrorException) r4).getCode() != 4001) goto L8;
            Context r6 = this.d.b;
            Toast.showFailureText(r6, r6.getString(2131887875), 0);
        }

        public d(q3 r1, int r2, String r3, com.bytedance.ee.bear.contract.d r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class e implements SubscribeExecutor.a {
        public final /* synthetic */ com.bytedance.ee.bear.contract.c0.e a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.bytedance.ee.bear.contract.d d;
        public final /* synthetic */ q3 e;

        @Override // com.bytedance.ee.bear.list.subscribe.SubscribeExecutor.a
        public final void onSuccess() {
            tt5.a.h("ListDataServiceImpl", "subscribe success");
            com.bytedance.ee.bear.contract.c0.e r0 = this.a;
            if (r0 == null) goto L6;
            r0.onSuccess();
        L6:
            if (this.b != 0) goto L8;
            Context r1 = this.e.b;
            Toast.showSuccessText(r1, r1.getString(2131887837));
        L9:
            q3.g(this.e, this.c, true, this.b);
            if (this.b != 0) goto L13;
            q3.b(this.e, this.d, "subscribe", "succeed");
            return;
        L13:
            return;
        L8:
            Context r2 = this.e.b;
            Toast.showSuccessText(r2, r2.getString(2131887333));
            goto L9
        }

        @Override // com.bytedance.ee.bear.list.subscribe.SubscribeExecutor.a
        public final void onFail(int r4, Throwable r5) {
            tt5.a.e("ListDataServiceImpl", "subscribe fail: code = " + r4, r5, false);
            if (this.a == null) goto L10;
            if (r5 != null) goto L6;
        L8:
            this.a.onFail();
            goto L10
        L6:
            if (r5.getMessage() == null) goto L8;
            r5.getMessage();
        L10:
            if (this.b == 0) goto L12;
        L14:
            Context r6 = this.e.b;
            Toast.showFailureText(r6, r6.getString(2131887874), 0);
        L16:
            if (this.b != 0) goto L19;
            q3.b(this.e, this.d, "subscribe", "failed");
            return;
        L19:
            return;
        L12:
            if (r4 != 225565001) goto L14;
            Context r7 = this.e.b;
            Toast.showFailureText(r7, r7.getString(2131888945), 0);
            goto L16
        }

        public e(q3 r1, com.bytedance.ee.bear.contract.c0.e r2, int r3, String r4, com.bytedance.ee.bear.contract.d r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class f implements SubscribeExecutor.a {
        public final /* synthetic */ com.bytedance.ee.bear.contract.c0.e a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.bytedance.ee.bear.contract.d d;
        public final /* synthetic */ q3 e;

        @Override // com.bytedance.ee.bear.list.subscribe.SubscribeExecutor.a
        public final void onSuccess() {
            tt5.a.h("ListDataServiceImpl", "unSubscribe success");
            com.bytedance.ee.bear.contract.c0.e r0 = this.a;
            if (r0 == null) goto L6;
            r0.onSuccess();
        L6:
            if (this.b != 0) goto L8;
            Context r1 = this.e.b;
            Toast.showText(r1, r1.getString(2131887841), 0);
        L9:
            q3.g(this.e, this.c, false, this.b);
            if (this.b != 0) goto L13;
            q3.b(this.e, this.d, "subscribe", "succeed");
            return;
        L13:
            return;
        L8:
            Context r2 = this.e.b;
            Toast.showText(r2, r2.getString(2131887331), 0);
            goto L9
        }

        @Override // com.bytedance.ee.bear.list.subscribe.SubscribeExecutor.a
        public final void onFail(int r3, Throwable r4) {
            tt5.a.e("ListDataServiceImpl", "unSubscribe fail: code = " + r3, r4, false);
            if (this.a == null) goto L7;
            if (r4 == null) goto L6;
            r4.getMessage();
        L6:
            this.a.onFail();
        L7:
            Context r5 = this.e.b;
            Toast.showFailureText(r5, r5.getString(2131887959), 0);
            if (this.b != 0) goto L11;
            q3.b(this.e, this.d, "subscribe", "failed");
            return;
        }

        public f(q3 r1, com.bytedance.ee.bear.contract.c0.e r2, int r3, String r4, com.bytedance.ee.bear.contract.d r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final void H() {
        List<com.bytedance.ee.bear.contract.c0.d> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator r1 = new ArrayList(r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.ee.bear.contract.c0.d) r1.next()).h();
        goto L6
    L10:
        return;
    }

    public final void V() {
        List<com.bytedance.ee.bear.contract.c0.d> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator r1 = new ArrayList(r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.ee.bear.contract.c0.d) r1.next()).g();
        goto L6
    L10:
        return;
    }

    public final void h() {
        if (this.h != null) goto L9;
        final kd5.c2 r0 = new kd5.c2();
        this.h = r0;
        tt5.a.h("OfflineCacheManager", "init()... sManualOfflineStatus: " + kd5.c2.w);
        com.bytedance.ee.bear.contract.j r1 = com.bytedance.ee.bear.contract.j.a.a;
        r0.c = r1;
        r0.m = r1.a();
        AccountService.Account r2 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r2 == null) goto L7;
        r0.g = r2.uid;
    L7:
        ((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).e().observeForever(new kd5.w(r0));
        r0.m.removeObserver(r0.n);
        r0.m.observeForever(r0.n);
        com.bytedance.ee.util.ui.m.a(new kd5.u(r0));
        r0.g();
        return;
    }

    public q3() {
        this.a = new ArrayList();
        this.i = new CompositeDisposable();
        this.b = LarkContext.getApplication();
        this.c = new s();
        this.d = new com.bytedance.ee.bear.list.create.g0();
        this.e = new ae5.s((NetService) org.koin.java.a.a(NetService.class));
        this.f = new od5.j((NetService) org.koin.java.a.a(NetService.class));
        this.g = new SubscribeExecutor((NetService) org.koin.java.a.a(NetService.class));
    }

    public final void Z() {
        h();
        this.h.o();
    }

    public final List<Document> c0() {
        h();
        return this.h.h;
    }

    public final void e0() {
        h();
        this.h.c();
    }

    public final List k0() {
        return mc5.m.a(this).ed();
    }

    public final List<String> m() {
        List<mc5.u1> r0 = mc5.m.a(this).A1();
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L12;
        Iterator<mc5.u1> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        mc5.u1 r3 = r2.next();
        if (r1.contains(r3.a) == true) goto L6;
        r1.add(r3.a);
        if (yu5.c.f(r3.getType(), -1) != 16) goto L6;
        r1.add(r3.N);
    L12:
        return r1;
    }

    public final List<String> o() {
        List<mc5.u1> r0 = mc5.m.a(this).D9();
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L10;
        Iterator<mc5.u1> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        mc5.u1 r3 = r2.next();
        String r4 = r3.a;
        Parcelable.Creator<Document> r5 = Document.CREATOR;
        if (lbb.a.a(r4) == false) goto L6;
        r1.add(r3.a);
    L10:
        return r1;
    }

    public final String F(String r2) {
        return mc5.m.a(this).F(r2);
    }

    public final void G(final String r5) {
        tt5.a.h("ListDataServiceImpl", "notifyListFileDelete()... objToken = " + du5.b.g(r5));
        this.i.add(Flowable.just(r5).filter(new h2()).observeOn(fo5.d.b()).map(new i2(this, r5)).map(new j2()).map(new k2(r5)).subscribe(new l2(), new m2()));
        List<com.bytedance.ee.bear.contract.c0.d> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator r1 = new ArrayList(r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.ee.bear.contract.c0.d) r1.next()).a(r5);
        goto L6
    L10:
        return;
    }

    public final Flowable<OfflineDoc> I(String r4) {
        x3 r0 = x3.c();
        r0.getClass();
        tt5.a.b("OfflineOperationProxy", "ListDataServiceImpl.getOfflineDoc: 45 fakeToken=" + r4);
        bx4.a r1 = r0.a;
        if (r1 == null) goto L5;
        final r4 r2 = (r4) r1;
        tt5.a.h("OfflineOperationWrapper", "OfflineOperationWrapper.getOfflineDoc: 162 fakeToken=" + r4);
        return Flowable.just(r4).observeOn(fo5.d.a()).map(new f4(r2)).flatMap(new g4()).observeOn(fo5.d.d());
    L5:
        tt5.a.b("OfflineOperationProxy", "ListDataServiceImpl.getOfflineDoc: 49 mOfflineOperator is null");
        return Flowable.empty();
    }

    public final Flowable<Boolean> L(final String r3) {
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new t1(this, r3));
    }

    public final Flowable<Boolean> N(final long r3) {
        tt5.a.h("ListDataServiceImpl", "clearDocsCacheDataFlowable(), beforeTimeInMills:" + r3);
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new j3()).map(new l3(this, r3)).doOnError(new m3()).onErrorResumeNext(Flowable.just(Boolean.FALSE));
    }

    public final void O(final String r5) {
        tt5.a.h("ListDataServiceImpl", "notifyListDocDelete()... objToken = " + du5.b.g(r5));
        this.i.add(Flowable.just(r5).filter(new z2()).observeOn(fo5.d.b()).map(new k3(this, r5)).map(new n3()).map(new o3(r5)).map(new p3()).map(new x0(r5)).map(new y0()).map(new z0(r5)).subscribe(new a1(), new b1()));
        List<com.bytedance.ee.bear.contract.c0.d> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator r1 = new ArrayList(r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.ee.bear.contract.c0.d) r1.next()).a(r5);
        goto L6
    L10:
        return;
    }

    public final Flowable<Boolean> S(final String r3) {
        boolean r0 = kd5.c2.w;
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new kd5.j0(r3));
    }

    public final void U(com.bytedance.ee.bear.contract.j0 r9) {
        h();
        kd5.c2 r6 = this.h;
        r6.getClass();
        tt5.a.h("OfflineCacheManager", "manualOffline()...module = " + r9.c + ", type = " + r9.e.getType());
        if (r6.c.getNetworkState().a() == false) goto L5;
    L13:
        r6.p(r9.e);
        r6.f(r9, true, false, 0);
        return;
    L5:
        if (kd5.c2.w == false) goto L7;
    L10:
        r6.h(r9.e, r9.b, false, r9.c, true);
        r6.p(r9.e);
        com.bytedance.ee.bear.contract.c0.b r10 = r9.f;
        if (r10 == null) goto L15;
        r10.a(true);
        return;
    L15:
        return;
    L7:
        if (r6.t == true) goto L10;
        if (r9.e.w == true) goto L13;
        goto L10
    }

    public final void W(final String r3) {
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).flatMap(new n1(this, r3)).subscribe(new o1(), new p1());
        this.i.add(r4);
    }

    public final void X(com.bytedance.ee.bear.contract.f0 r11) {
        com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        boolean r0 = r11.c;
        int r7 = r11.d;
        String r8 = r11.a;
        int r9 = r11.getType();
        com.bytedance.ee.bear.contract.c0.e r3 = r11.e;
        if (r0 == false) goto L7;
        if (r7 != 0) goto L6;
        p(r8, r6, "subscribe", "add_subscribe");
    L6:
        SubscribeExecutor r12 = this.g;
        final e r1 = new e(this, r3, r7, r8, r6);
        r12.getClass();
        NetService.f r2 = SubscribeExecutor.a("/api/subscribe/add/", r8, r9, r7);
        r12.a.Vc(new SubscribeExecutor.b()).a(r2).subscribe(new com.bytedance.ee.bear.list.subscribe.c(r1), new com.bytedance.ee.bear.list.subscribe.d(r1));
        return;
    L7:
        if (r7 != 0) goto L9;
        p(r8, r6, "subscribe", "remove_subscribe");
    L9:
        SubscribeExecutor r13 = this.g;
        final f r4 = new f(this, r3, r7, r8, r6);
        r13.a.Vc(new SubscribeExecutor.b()).a(SubscribeExecutor.a("/api/subscribe/delete/", r8, r9, r7)).subscribe(new com.bytedance.ee.bear.list.subscribe.a(r4), new com.bytedance.ee.bear.list.subscribe.b(r4));
    }

    public final void Y(final OfflineRenameData r4) {
        x3 r0 = x3.c();
        r0.getClass();
        tt5.a.b("OfflineOperationProxy", "ListDataServiceImpl.setOfflineFileName: 33 ");
        bx4.a r1 = r0.a;
        if (r1 == null) goto L5;
        final r4 r2 = (r4) r1;
        tt5.a.b("OfflineOperationWrapper", "OfflineOperationWrapper.setNewName: 26 rawData=" + r4);
        Flowable.just(r4).observeOn(fo5.d.b()).map(new c4(r2, r4)).subscribe(new com.bytedance.ee.bear.bitable.homepage.list.a0(), new d4());
        return;
    L5:
        tt5.a.b("OfflineOperationProxy", "ListDataServiceImpl.setOfflineFileName: 36 mOfflineOperator is null");
    }

    public final int c(List<String> r2) {
        return mc5.m.a(this).c(r2);
    }

    public final int d(List<String> r2) {
        return mc5.m.a(this).r7(r2);
    }

    public final void d0(com.bytedance.ee.bear.contract.c0.d r2) {
        if (r2 == null) goto L5;
        ((ArrayList) this.a).remove(r2);
        return;
    }

    public final long g0(so5.a r3) {
        return mc5.m.a(this).Ve(r3);
    }

    public final void h0(final String r4) {
        this.i.add(Flowable.fromCallable(new i1(this, r4)).subscribeOn(fo5.d.c()).subscribe(new j1(), new k1()));
    }

    public final void handleSyncedDoc(final OfflineDoc r9) {
        x3 r0 = x3.c();
        r0.getClass();
        tt5.a.b("OfflineOperationProxy", "ListDataServiceImpl.handleSyncedDoc: 66 doc=");
        bx4.a r1 = r0.a;
        if (r1 == null) goto L5;
        final r4 r2 = (r4) r1;
        tt5.a.h("OfflineOperationWrapper", "handleSyncedDoc()...doc fakeToken is " + du5.b.i(r9.getFakeToken()) + " token is " + du5.b.i(r9.getToken()) + " doc objToken is " + du5.b.i(r9.getObj_token()));
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new j4(r2, r9)).observeOn(fo5.d.d()).subscribe(new k4(r9), new l4());
    L6:
        h();
        kd5.c2 r3 = this.h;
        r3.getClass();
        DocWikiInfo r4 = r9.getWikiInfo();
        String r5 = r9.getFakeToken();
        String r10 = r9.getObj_token();
        if (r4 != null) goto L14;
        tt5.a.h("OfflineCacheManager", "onOfflineDocSynced, not wiki: fakeToken=" + r5 + ", objToken=" + du5.b.i(r10));
        Iterator r6 = ((CopyOnWriteArrayList) r3.h).iterator();
    L10:
        if (r6.hasNext() == false) goto L20;
        Document r7 = (Document) r6.next();
        if (TextUtils.equals(r7.d, r5) == false) goto L10;
        r7.d = r10;
        goto L10
    L20:
        return;
    L14:
        String r8 = r4.getWiki_token();
        r4.getObj_token();
        int r11 = r4.getObj_type();
        tt5.a.h("OfflineCacheManager", "onOfflineDocSynced, wiki: fakeToken=" + r5 + ", wikiToken=" + du5.b.i(r8) + ", objToken=" + du5.b.i(r10) + ", realType=" + r11);
        Iterator r12 = ((CopyOnWriteArrayList) r3.h).iterator();
    L16:
        if (r12.hasNext() == false) goto L31;
        Document r13 = (Document) r12.next();
        if (TextUtils.equals(r13.d, r5) == false) goto L16;
        r13.d = r8;
        r13.G1 = r10;
        r13.y1 = r11;
        goto L16
    L31:
        return;
    L5:
        tt5.a.b("OfflineOperationProxy", "ListDataServiceImpl.handleSyncedDoc: 70 mOfflineOperator is null");
        goto L6
    }

    public final String i(String r2) {
        return mc5.m.a(this).i(r2);
    }

    public final int i0(String r2) {
        return mc5.m.a(this).Ga(r2);
    }

    public final void j(final String r3) {
        Disposable r4 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new u1(this, r3), new v1());
        this.i.add(r4);
    }

    public final int l(List<String> r2) {
        return mc5.m.a(this).l(r2);
    }

    public final void m0(final int r4) {
        h();
        final kd5.c2 r0 = this.h;
        r0.getClass();
        tt5.a.h("OfflineCacheManager", "resetManualOfflineStatusByType()...documentType = " + r4);
        r0.e.add(Flowable.just("").subscribeOn(fo5.d.b()).map(new kd5.x(r0)).filter(new kd5.y()).map(new kd5.z(r0, r4)).observeOn(fo5.d.d()).subscribe(new kd5.a0(r0), new kd5.b0()));
    }

    public final so5.a p0(String r2) {
        return mc5.m.a(this).Y7(r2);
    }

    public final void q0(com.bytedance.ee.bear.contract.c0.d r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((ArrayList) this.a).contains(r2) == true) goto L8;
        ((ArrayList) this.a).add(r2);
        return;
    }

    public final void K(final String r4, final com.bytedance.ee.bear.contract.c0.a r5) {
        if (r5 == null) goto L4;
        r5.c();
    L4:
        x3 r0 = x3.c();
        r0.getClass();
        tt5.a.b("OfflineOperationProxy", "ListDataServiceImpl.deleteOfflineDoc: 56 fakeToken=" + r4);
        bx4.a r1 = r0.a;
        if (r1 == null) goto L10;
        final r4 r2 = (r4) r1;
        if (TextUtils.isEmpty(r4) == false) goto L9;
        tt5.a.b("OfflineOperationWrapper", "deleteOfflineDoc: fakeToken is null");
        Flowable r3 = Flowable.just(Boolean.FALSE);
    L11:
        this.i.add(r3.filter(new c1(r5)).observeOn(fo5.d.b()).flatMap(new d1(this, r4)).observeOn(fo5.d.d()).subscribe(new e1(this, r5, r4), new f1(r5)));
        return;
    L9:
        r3 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new e4(r2, r4)).observeOn(fo5.d.d());
        goto L11
    L10:
        r3 = Flowable.empty();
        goto L11
    }

    public final void T(final String r5, final String r6) {
        this.i.add(Flowable.just(r5).filter(new n2()).observeOn(fo5.d.b()).subscribe(new p2(this, r5, r6), new q2()));
        List<com.bytedance.ee.bear.contract.c0.d> r0 = this.a;
        if (r0 == null) goto L8;
        Iterator r1 = new ArrayList(r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((com.bytedance.ee.bear.contract.c0.d) r1.next()).b(r5, r6);
        goto L6
    L10:
        return;
    }

    public final void f0(String r1, String r2) {
        O(r2);
        ((com.bytedance.ee.bear.contract.n) org.koin.java.a.a(com.bytedance.ee.bear.contract.n.class)).d(r1);
        ((yr4.a) org.koin.java.a.a(yr4.a.class)).h(r1);
    }

    public final void k(final String r3, final int r4) {
        Disposable r5 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new q1(this, r3, r4), new r1());
        this.i.add(r5);
    }

    public final void o0(final String r4, final boolean r5) {
        this.i.add(Flowable.just("").observeOn(fo5.d.b()).subscribe(new d2(this, r4, r5), new o2()));
    }

    public static void a(final q3 r2, final String r3, final boolean r4) {
        r2.getClass();
        Disposable r5 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new l1(r2, r3, r4), new m1());
        r2.i.add(r5);
    }

    public static void e(final q3 r4, String r5, final boolean r6) {
        r4.i.add(Flowable.just(r5).filter(new b3()).observeOn(fo5.d.b()).subscribe(new c3(r4, r6), new d3()));
        List<com.bytedance.ee.bear.contract.c0.d> r7 = r4.a;
        if (r7 == null) goto L10;
        Iterator r8 = new ArrayList(r7).iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        com.bytedance.ee.bear.contract.c0.d r0 = (com.bytedance.ee.bear.contract.c0.d) r8.next();
        if (r0 == null) goto L6;
        r0.f(r5, r6);
        goto L6
    L16:
        return;
    }

    public static void f(final q3 r2, final String r3, final boolean r4) {
        r2.getClass();
        Disposable r5 = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new r2(r2, r4, r3), new s2());
        r2.i.add(r5);
    }

    public final Flowable J(int r2, String r3, boolean r4) {
        return x3.c().a(r3, r2, r4);
    }

    public final void M(String r6, int r7, boolean r8) {
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (r8 == false) goto L7;
        if (r0 == false) goto L6;
        p(r6, r1, "pin", "remove_quickaccess");
        od5.j r9 = this.f;
        final c r2 = new c(this, r7, r6, r1);
        r9.a.Vc(new od5.j.b()).a(od5.j.a("/api/explorer/pin/remove/", r6, r7)).subscribe(new od5.h(r2), new od5.i(r2));
        return;
    L6:
        Context r10 = this.b;
        Toast.showFailureText(r10, r10.getString(2131887959), 0);
        tt5.a.h("ListDataServiceImpl", "pinDoc()...failed for offline");
        return;
    L7:
        if (r0 == false) goto L9;
        p(r6, r1, "pin", "add_quickaccess");
        od5.j r11 = this.f;
        final d r3 = new d(this, r7, r6, r1);
        r11.getClass();
        NetService.f r12 = od5.j.a("/api/explorer/pin/add/", r6, r7);
        r11.a.Vc(new od5.j.b()).a(r12).subscribe(new od5.f(r3), new od5.g(r3));
        return;
    L9:
        Context r13 = this.b;
        Toast.showFailureText(r13, r13.getString(2131887874), 0);
        tt5.a.h("ListDataServiceImpl", "unPinDoc()...failed for offline");
    }

    public final void Q(final String r4, final String r5, final int r6) {
        this.i.add(Flowable.just("").observeOn(fo5.d.b()).subscribe(new w1(this, r4, r5, r6), new x1()));
    }

    public final void b0(final String r3, final int r4, final TtsMetaModel$reload$2.a r5) {
        Disposable r6 = ((com.bytedance.ee.bear.document.a4) org.koin.java.a.a(com.bytedance.ee.bear.document.a4.class)).b(r3, r4).subscribe(new w0(r5, r3, r4), new h1(r5), new s1(r5));
        this.i.add(r6);
    }

    public final void n0(final Document r5, final boolean r6, final String r7) {
        h();
        final kd5.c2 r0 = this.h;
        r0.getClass();
        tt5.a.h("OfflineCacheManager", "cancelManualOffline()...type = " + r5.getType() + ", module = " + r7);
        r0.e.add(Flowable.just(r5.d).observeOn(fo5.d.b()).flatMap(new kd5.m0(r0, r5)).subscribe(new kd5.n0(r0, r5, r6, r7), new kd5.o0(r6, r7, r5)));
    }

    public final void q(final String r4, int r5, final boolean r6) {
        this.i.add(Flowable.just(r4).filter(new y1()).observeOn(fo5.d.b()).subscribe(new z1(this, r4, r6), new a2()));
        List<com.bytedance.ee.bear.contract.c0.d> r7 = this.a;
        if (r7 == null) goto L10;
        Iterator r8 = new ArrayList(r7).iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        com.bytedance.ee.bear.contract.c0.d r0 = (com.bytedance.ee.bear.contract.c0.d) r8.next();
        if (r0 == null) goto L6;
        r0.e(r4, r6);
        goto L6
    L16:
        return;
    }

    public static void b(q3 r0, com.bytedance.ee.bear.contract.d r1, String r2, String r3) {
        r0.getClass();
        lc5.f.a r4 = lc5.f.a;
        lc5.f.a.c(r1, r2, "status_name", r3);
        Intrinsics.checkNotNullParameter(r1, "analyticService");
        Intrinsics.checkNotNullParameter("client_content_management", "eventId");
        Intrinsics.checkNotNullParameter(r2, "tag");
        r1.v("client_content_management", r1.t(r2));
        r1.c(r2);
    }

    public static void g(final q3 r1, String r2, final boolean r3, int r4) {
        if (r4 != 0) goto L9;
        r1.i.add(Flowable.just(r2).filter(new g3()).observeOn(fo5.d.b()).subscribe(new h3(r1, r3), new i3()));
        List<com.bytedance.ee.bear.contract.c0.d> r5 = r1.a;
        if (r5 == null) goto L15;
        Iterator r6 = new ArrayList(r5).iterator();
    L7:
        if (r6.hasNext() == false) goto L19;
        ((com.bytedance.ee.bear.contract.c0.d) r6.next()).c();
        goto L7
    L19:
        return;
    L15:
        return;
    L9:
        List<com.bytedance.ee.bear.contract.c0.d> r7 = r1.a;
        if (r7 == null) goto L18;
        Iterator r8 = new ArrayList(r7).iterator();
    L13:
        if (r8.hasNext() == false) goto L20;
        ((com.bytedance.ee.bear.contract.c0.d) r8.next()).d();
        goto L13
    L20:
        return;
    }

    public static void p(String r1, com.bytedance.ee.bear.contract.d r2, String r3, String r4) {
        String r5 = du5.b.g(r1);
        lc5.f.a r0 = lc5.f.a;
        lc5.f.a.c(r2, r3, "file_id", r5);
        lc5.f.a.c(r2, r3, "action", r4);
    }

    public final void P(Context r9, String r10, int r11, boolean r12) {
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        com.bytedance.ee.bear.contract.d r7 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (r12 == false) goto L7;
        if (r0 == false) goto L6;
        p(r10, r7, "star", "remove_favorites");
        this.e.b(r10, r11, new a(this, r10, r11, r7));
        return;
    L6:
        Context r13 = this.b;
        Toast.showFailureText(r13, r13.getString(2131887959), 0);
        tt5.a.h("ListDataServiceImpl", "starDoc()...failed for offline");
        return;
    L7:
        if (r0 == false) goto L9;
        p(r10, r7, "star", "add_favorites");
        this.e.a(r10, r11, new b(this, r9, r10, r11, r7));
        return;
    L9:
        Context r14 = this.b;
        Toast.showFailureText(r14, r14.getString(2131887874), 0);
        tt5.a.h("ListDataServiceImpl", "unStarDoc()...failed for offline");
    }

    public final void a0(FragmentManager r2, String r3, String r4, int r5) {
        com.bytedance.ee.bear.list.applydelete.a.a(r2, r3, r4, r5);
    }

    public final Flowable<DocumentCreateInfo> j0(int r10, String r11, String r12, boolean r13) {
        return this.d.a(new com.bytedance.ee.bear.list.create.y0(r10, null, null, r11, r12, r13));
    }

    public final void l0(String r8, int r9, boolean r10, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a r11) {
        com.bytedance.ee.bear.contract.d r6 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (r10 == true) goto L5;
        p(r8, r6, "star", "remove_favorites");
        this.e.b(r8, r9, new r3(this, r11, r8, r9, r6));
        return;
    L5:
        p(r8, r6, "star", "add_favorites");
        this.e.a(r8, r9, new s3(this, r11, r8, r9, r6));
    }

    public final void n(String r2, int r3, int r4, com.bytedance.ee.bear.contract.c0.a r5) {
        this.c.getClass();
        s.a(r2, r3, r4, r5);
    }
}
