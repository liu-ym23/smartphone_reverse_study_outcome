package com.bytedance.ee.bear.document.offline.sync;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockType;
import com.bytedance.ee.bear.document.offline.sync.rust.DocsRustPreloadSender;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class CommonRNPreloadStrategy extends f {
    public static final /* synthetic */ int v = 0;
    public CountDownLatch o;
    public String p;
    public final Map<String, com.bytedance.ee.bear.contract.n.b> q;
    public final Map<String, List<com.bytedance.ee.bear.contract.n.b>> r;
    public final Map<String, Long> s;
    public final Map<String, OfflineDoc> t;
    public final boolean u;

    public static final class a {
        @JvmStatic
        public static String a(Integer r2) {
            int r0 = sbb.e.o.b;
            if (r2 != null) goto L6;
        L8:
            int r1 = sbb.e.h.b;
            if (r2 != null) goto L12;
        L14:
            int r3 = sbb.e.m.b;
            if (r2 != null) goto L18;
        L20:
            return null;
        L18:
            if (r2.intValue() != r3) goto L20;
            return "ccm.mobile.preload_slides_by_rust";
        L12:
            if (r2.intValue() != r1) goto L14;
            return "ccm.mobile.preload_sheet_by_rust";
        L6:
            if (r2.intValue() != r0) goto L8;
            return "ccm.mobile.preload_docx_by_rust";
        }
    }

    public final class b implements tb5.i<String> {
        public final /* synthetic */ CommonRNPreloadStrategy a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(CommonRNPreloadStrategy r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            if (r3 != null) goto L5;
            tt5.a.k(this.a.a, "LoadCompletedHandler()... data is null !");
            return;
        L5:
            this.a.s(r3);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CommonRNPreloadStrategy a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public c(CommonRNPreloadStrategy r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.t(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ CommonRNPreloadStrategy a;
        public final /* synthetic */ String b;
        public final /* synthetic */ OfflineDoc c;

        public d(CommonRNPreloadStrategy r1, String r2, OfflineDoc r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            CommonRNPreloadStrategy r0 = this.a;
            if (r0.u == false) goto L11;
            Map<String, List<com.bytedance.ee.bear.contract.n.b>> r1 = r0.r;
            ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
            List r3 = (List) r2.get(this.b);
            if (r3 == null) goto L16;
            CommonRNPreloadStrategy r4 = this.a;
            String r5 = this.b;
            OfflineDoc r6 = this.c;
            tt5.a.k(r4.a, "preload overtime !");
            Iterator r7 = r3.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            ((com.bytedance.ee.bear.contract.n.b) r7.next()).onPreloadFail(r5);
            goto L8
        L10:
            ((ConcurrentHashMap) r4.r).remove(r5);
            r4.x(99999, "rn exceed time", r5, r6);
            Intrinsics.checkNotNull(r5);
            r4.y(r5);
            return;
        L16:
            return;
        L11:
            Map<String, com.bytedance.ee.bear.contract.n.b> r8 = r0.q;
            ConcurrentHashMap r9 = (ConcurrentHashMap) r8;
            com.bytedance.ee.bear.contract.n.b r10 = (com.bytedance.ee.bear.contract.n.b) r9.get(this.b);
            if (r10 == null) goto L18;
            CommonRNPreloadStrategy r11 = this.a;
            String r12 = this.b;
            OfflineDoc r13 = this.c;
            tt5.a.k(r11.a, "preload overtime !");
            r10.onPreloadFail(r12);
            ((ConcurrentHashMap) r11.q).remove(r12);
            r11.x(99999, "rn exceed time", r12, r13);
            Intrinsics.checkNotNull(r12);
            r11.y(r12);
            return;
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
    }

    public static final class e implements Runnable {
        public final /* synthetic */ CommonRNPreloadStrategy a;
        public final /* synthetic */ String b;
        public final /* synthetic */ OfflineDoc c;

        public e(CommonRNPreloadStrategy r1, String r2, OfflineDoc r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map<String, OfflineDoc> r0 = this.a.t;     // Catch: Throwable -> L6
            ConcurrentHashMap r1 = (ConcurrentHashMap) r0;     // Catch: Throwable -> L6
            if (((OfflineDoc) r1.get(this.b)) == null) goto L9;
            CommonRNPreloadStrategy r2 = this.a;     // Catch: Throwable -> L6
            String r3 = this.b;     // Catch: Throwable -> L6
            r2.x(99999, "rn exceed time", r3, this.c);     // Catch: Throwable -> L6
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L6
            r2.y(r3);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final boolean n(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final void o(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "responseStr");
        Intrinsics.checkNotNullParameter(r3, "objToken");
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final Response p(OfflineDoc r1) {
        return null;
    }

    public abstract void s(String r1);

    public abstract String u();

    public boolean v() {
        return false;
    }

    public CommonRNPreloadStrategy() {
        this.q = new ConcurrentHashMap();
        this.r = new ConcurrentHashMap();
        this.s = new ConcurrentHashMap();
        this.t = new ConcurrentHashMap();
        this.u = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.mobile.offline_list_sync_enabled");
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.q
    public void f(AccountService$Account r3) {
        Intrinsics.checkNotNullParameter(r3, "account");
        Flowable r4 = ((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).d(new CommonRNPreloadStrategy$init$1(this));
        if (r4 == null) goto L6;
        r4.subscribe();
        return;
    }

    public final void y(String r2) {
        ((ConcurrentHashMap) this.s).remove(r2);
        ((ConcurrentHashMap) this.t).remove(r2);
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final void b(OfflineDoc r6, com.bytedance.ee.bear.contract.n.b r7) {
        Intrinsics.checkNotNullParameter(r6, "offlineDoc");
        String r0 = r6.getObj_token();
        tt5.a.h(this.a, "preload()... objToken = " + du5.b.g(r0));
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        Map<String, Long> r1 = this.s;
        Intrinsics.checkNotNull(r0);
        ((ConcurrentHashMap) r1).put(r0, Long.valueOf(System.currentTimeMillis()));
        ((ConcurrentHashMap) this.t).put(r0, r6);
        if (r7 != null) goto L8;
        this.p = r0;
        r(r6, l(r0, f.m(r6), TextUtils.equals("tab_manual_offline", r6.getFrom_source())).toJSONString());
        e r8 = new e(this, r0, r6);     // Catch: InterruptedException -> L24
        Long r9 = h0.j;     // Catch: InterruptedException -> L24
        com.bytedance.ee.util.ui.m.b(r8, r9.longValue() * 1000);     // Catch: InterruptedException -> L24
        CountDownLatch r10 = new CountDownLatch(1);     // Catch: InterruptedException -> L24
        this.o = r10;     // Catch: InterruptedException -> L24
        r10.await(r9.longValue(), TimeUnit.SECONDS);     // Catch: InterruptedException -> L24
        return;
    L24:
        e = move-exception;
        tt5.a.f(this.a, e, false);
        Unit r11 = Unit.INSTANCE;
        return;
    L8:
        if (this.u == true) goto L10;
        ((ConcurrentHashMap) this.q).put(r0, r7);
    L16:
        r(r6, l(r0, f.m(r6), TextUtils.equals("tab_manual_offline", r6.getFrom_source())).toJSONString());
        if (TextUtils.equals("tab_manual_offline", r6.getFrom_source()) == false) goto L19;
        Long r12 = h0.k;
    L20:
        com.bytedance.ee.util.ui.m.b(new d(this, r0, r6), r12.longValue() * 1000);
        return;
    L19:
        r12 = h0.j;
        goto L20
    L10:
        if (((ConcurrentHashMap) this.r).get(r0) != null) goto L12;
        ArrayList r4 = new ArrayList();
        r4.add(r7);
        ((ConcurrentHashMap) this.r).put(r0, r4);
        goto L16
    L12:
        List r5 = (List) ((ConcurrentHashMap) this.r).get(r0);
        if (r5 == null) goto L16;
        r5.add(r7);
        goto L16
    }

    public final void r(final OfflineDoc r6, final String r7) {
        Intrinsics.checkNotNullParameter(r6, "offlineDoc");
        Intrinsics.checkNotNullParameter(r7, "paramJson");
        boolean r1 = v();
        String r2 = a.a(Integer.valueOf(r6.getType()));
        if (r2 == null) goto L9;
        if (r1 == false) goto L9;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g(r2) == false) goto L9;
        boolean r3 = true;
    L10:
        tt5.a.h(this.a, "[rust_preload] dispatch preload request token=" + du5.b.g(r6.getObj_token()) + ", useRust:" + r3);
        if (r3 == false) goto L14;
        com.bytedance.ee.bear.document.offline.sync.rust.c.a();
        int r0 = DocsRustPreloadSender.a;
        DocsRustPreloadSender.a(r6, r7, new CommonRNPreloadStrategy$dispatchPreloadRequest$1(this, r6));
        return;
    L14:
        Intrinsics.checkNotNullParameter(r7, "paramJson");
        Flowable r8 = ((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).d(new CommonRNPreloadStrategy$notifyRNPreloadData$1(r7));
        if (r8 == null) goto L18;
        r8.subscribe();
        return;
    L18:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public final void t(String r3, int r4) {
        if (TextUtils.equals(r3, this.p) == false) goto L8;
        CountDownLatch r0 = this.o;
        if (r0 == null) goto L8;
        r0.countDown();
    L8:
        if (this.u == false) goto L24;
        if ((!((ConcurrentHashMap) this.r).isEmpty()) == false) goto L31;
        List r1 = (List) ((ConcurrentHashMap) this.r).get(r3);
        if (r1 == null) goto L31;
        if (r4 != 0) goto L18;
        Iterator r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L22;
        ((com.bytedance.ee.bear.contract.n.b) r2.next()).d(r3);
    L22:
        List r5 = (List) TypeIntrinsics.asMutableMap(this.r).remove(r3);
        goto L31
    L18:
        Iterator r6 = r1.iterator();
    L20:
        if (r6.hasNext() == false) goto L22;
        ((com.bytedance.ee.bear.contract.n.b) r6.next()).onPreloadFail(r3);
    L31:
        x(r4, "", r3, (OfflineDoc) ((ConcurrentHashMap) this.t).get(r3));
        if (r3 == null) goto L34;
        y(r3);
    L34:
        p r7 = this.n;
        if (r7 == null) goto L40;
        ((r25.e.a) r7).a(r3, System.currentTimeMillis());
        return;
    L40:
        return;
    L24:
        if ((!((ConcurrentHashMap) this.q).isEmpty()) == false) goto L31;
        com.bytedance.ee.bear.contract.n.b r8 = (com.bytedance.ee.bear.contract.n.b) ((ConcurrentHashMap) this.q).get(r3);
        if (r8 == null) goto L31;
        if (r4 != 0) goto L29;
        r8.d(r3);
    L30:
        com.bytedance.ee.bear.contract.n.b r9 = (com.bytedance.ee.bear.contract.n.b) TypeIntrinsics.asMutableMap(this.q).remove(r3);
        goto L31
    L29:
        r8.onPreloadFail(r3);
        goto L30
    }

    public void w(String r5, String r6, int r7) {
        int r0 = com.bytedance.ee.bear.document.offline.sync.rust.b.a;
        boolean r1 = false;
        if (Intrinsics.areEqual(r5, SubBlockType.ALL_DATA_COMPLETE.getSubBlockType()) == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        if (r6 != null) goto L13;
        String r3 = "";
    L15:
        if (r3.length() != 0) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L19;
    L23:
        tt5.a.h(this.a, "[rust_preload] ignore this complete, token not belong here : " + du5.b.g(r6));
        return;
    L19:
        if (((ConcurrentHashMap) this.t).containsKey(r3) == false) goto L23;
        tt5.a.h(this.a, "[rust_preload] handle complete type=" + r5 + ", token=" + du5.b.g(r6) + ", code=" + r7);
        com.bytedance.ee.util.ui.m.a(new c(this, r3, r7));
        return;
    L13:
        r3 = r6;
        goto L15
    L5:
        if (Intrinsics.areEqual(r5, "SHEETS_DATA_COMPLETE") == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void x(int r26, String r27, String r28, OfflineDoc r29) {
        Map r2 = f.m(r29);
        if (((ConcurrentHashMap) this.s).get(r28) != null) goto L5;
        Long r1 = Long.valueOf(System.currentTimeMillis());
    L6:
        if (r29 == null) goto L17;
        int r4 = r29.getType();
        String r6 = r29.getFrom_source();
        String r7 = r29.getSubFrom();
        int r9 = r29.getPreload_priority();
        if (r26 != 0) goto L10;
        int r10 = 0;
    L11:
        Intrinsics.checkNotNull(r1);
        long r13 = r1.longValue();
        long r16 = r29.getTriggerTime();
        long r17 = r29.getTaskManagerEnqueueTime();
        long r19 = r29.getPreloadManagerEnqueueTime();
        if (r2.containsKey("sheet") == false) goto L14;
        String r3 = du5.b.g((String) r2.get("sheet"));
    L15:
        e25.b.b(new e25.c(r4, "clientvar", r6, r7, "rn", r9, r10, r26, r27, r13, r16, r17, r19, -1, 0, r3));
        return;
    L14:
        r3 = null;
        goto L15
    L10:
        r10 = 1;
        goto L11
    L17:
        return;
    L5:
        r1 = (Long) ((ConcurrentHashMap) this.s).get(r28);
        goto L6
    }
}
