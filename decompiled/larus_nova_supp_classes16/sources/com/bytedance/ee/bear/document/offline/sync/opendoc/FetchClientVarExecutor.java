package com.bytedance.ee.bear.document.offline.sync.opendoc;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.doc.clientvar.FetchClientVarPlugin;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.eenet.util.ComplexConnect;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class FetchClientVarExecutor {
    public final NetService a;
    public boolean b;
    public final com.bytedance.ee.bear.contract.j c;
    public final LiveData<ConnectionService.NetworkState> d;
    public final HashMap<String, d> e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/opendoc/FetchClientVarExecutor$ClientVarReslut;", "Lcom/bytedance/ee/bear/contract/Result;", "", "<init>", "()V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ClientVarReslut extends Result<String> {
        public String toString() {
            JSONObject r0 = new JSONObject();
            r0.put("msg", this.msg);
            r0.put("code", this.code);
            r0.put("data", this.data);
            return r0.toString();
        }

        public ClientVarReslut() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/opendoc/FetchClientVarExecutor$Status;", "", "<init>", "(Ljava/lang/String;I)V", "Fetching", "FAILED", "SUCCESS", "INTERRUPT", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status FAILED = null;
        public static final Status Fetching = null;
        public static final Status INTERRUPT = null;
        public static final Status SUCCESS = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("Fetching", 0);
            Fetching = r0;
            Status r1 = new Status("FAILED", 1);
            FAILED = r1;
            Status r3 = new Status("SUCCESS", 2);
            SUCCESS = r3;
            Status r5 = new Status("INTERRUPT", 3);
            INTERRUPT = r5;
            Status[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ FetchClientVarExecutor a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.offline.sync.opendoc.FetchClientVarExecutor$a$a, reason: collision with other inner class name */
        public static final class C0086a<T> implements Observer {
            public final /* synthetic */ FetchClientVarExecutor a;

            public C0086a(FetchClientVarExecutor r1) {
                this.a = r1;
            }

            public final void onChanged(Object r2) {
                ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
                FetchClientVarExecutor r0 = this.a;
                if (r3 == null) goto L5;
                boolean r4 = r3.a();
            L6:
                r0.b = r4;
                tt5.a.h("FetchClientVarExecutor", "newConnectionDetector  mIsConnected: " + this.a.b);
                return;
            L5:
                r4 = true;
                goto L6
            }
        }

        public a(FetchClientVarExecutor r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FetchClientVarExecutor r0 = this.a;     // Catch: Throwable -> L4
            r0.d.observeForever(new C0086a(r0));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface b {
        void a(String r1);
    }

    public static final class c {
    }

    public static final class d {
        public Status a;
        public String b;
        public Disposable c;
        public final ArrayList<b> d;

        public d() {
            throw null;
        }

        public d(Status r3, int r4) {
            if ((r4 & 8) == 0) goto L5;
            ArrayList<b> r5 = new ArrayList();
        L6:
            Intrinsics.checkNotNullParameter(r3, "status");
            Intrinsics.checkNotNullParameter(r5, "listeners");
            this.a = r3;
            this.b = null;
            this.c = null;
            this.d = r5;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Status.values().length];
            r0[Status.Fetching.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ BearUrl a;
        public final /* synthetic */ FetchClientVarExecutor b;
        public final /* synthetic */ Ref.LongRef c;

        public f(BearUrl r1, FetchClientVarExecutor r2, Ref.LongRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            ClientVarReslut r6 = (ClientVarReslut) r5;
            tt5.a.h("FetchClientVarExecutor", "fetch clientvar success url: " + du5.b.k(this.a.b));
            FetchClientVarExecutor r0 = this.b;
            BearUrl r1 = this.a;
            long r2 = this.c.element;
            Intrinsics.checkNotNull(r6);
            FetchClientVarExecutor.a(r0, r1, r2, r6);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ BearUrl a;
        public final /* synthetic */ FetchClientVarExecutor b;
        public final /* synthetic */ Ref.LongRef c;

        public g(BearUrl r1, FetchClientVarExecutor r2, Ref.LongRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            tt5.a.k("FetchClientVarExecutor", "fetch clientvar failed url: " + du5.b.k(this.a.b));
            ClientVarReslut r0 = new ClientVarReslut();
            r0.data = "{}";
            r0.code = -1;
            r0.msg = ((Throwable) r5).getMessage();
            FetchClientVarExecutor.a(this.b, this.a, this.c.element, r0);
        }
    }

    static {
    }

    public FetchClientVarExecutor(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.a = r2;
        this.b = true;
        com.bytedance.ee.bear.contract.j r3 = com.bytedance.ee.bear.contract.j.a.a;
        this.c = r3;
        this.d = r3.a();
        this.e = new HashMap();
        m.a(new a(this));
    }

    public static String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        ClientVarReslut r0 = new ClientVarReslut();
        r0.code = -1;
        r0.msg = r2;
        r0.data = "{}";
        return r0.toString();
    }

    public final synchronized void b(BearUrl r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "bearUrl");     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r7.r) == true) goto L6;
        String r0 = r7.r;     // Catch: Throwable -> L41
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L10;
    L38:
        tt5.a.k("FetchClientVarExecutor", "sceneId or hash is not empty ");     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L10:
        if (TextUtils.isEmpty(r7.p) == false) goto L38;
        if (this.b == true) goto L20;
        if (this.c.getNetworkState().a() == true) goto L20;
        tt5.a.k("FetchClientVarExecutor", "fetchClientVar not connected ");     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L20:
        if (this.e.get(r7.b) == null) goto L24;
        tt5.a.k("FetchClientVarExecutor", "fetchClientVar, the request is exist already");     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L24:
        Ref.LongRef r1 = new Ref.LongRef();     // Catch: Throwable -> L41
        r1.element = System.currentTimeMillis();     // Catch: Throwable -> L41
        tt5.a.h("FetchClientVarExecutor", "fetch clientvar before open");     // Catch: Throwable -> L41
        NetService.f r2 = new NetService.f("api/docx/pages/client_vars");     // Catch: Throwable -> L41
        if (TextUtils.isEmpty(r7.p) == true) goto L27;
        boolean r3 = true;
    L28:
        r2.c = 2;     // Catch: Throwable -> L41
        r2.b("id", r7.b);     // Catch: Throwable -> L41
        if (r3 == false) goto L31;
        String r5 = "3";
    L32:
        r2.b("mode", r5);     // Catch: Throwable -> L41
        r2.b("limit", "239");     // Catch: Throwable -> L41
        if (r3 == false) goto L35;
        r2.b("blockId", r7.p);     // Catch: Throwable -> L41
    L35:
        r2.c(MapsKt.mapOf(TuplesKt.to("EENet-Request-Enable-Complex-Connect", ComplexConnect.TRUE.toString())));     // Catch: Throwable -> L41
        d r4 = new d(Status.Fetching, 8);     // Catch: Throwable -> L41
        Flowable r6 = this.a.Rb(ClientVarReslut.class).a(r2);     // Catch: Throwable -> L41
        LarkContext.getApplication();     // Catch: Throwable -> L41
        new f25.i(com.bytedance.ee.bear.contract.j.a.a).b();     // Catch: Throwable -> L41
        r4.c = r6.observeOn(new ExecutorScheduler(f25.i.e, false)).subscribe(new f(r7, this, r1), new g(r7, this, r1));     // Catch: Throwable -> L41
        this.e.put(r7.b, r4);     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L31:
        r5 = DiagramData$RESULT.SUCCESS;
        goto L32
    L27:
        r3 = false;
        goto L28
    L6:
        r0 = r7.q;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(BearUrl r4, FetchClientVarPlugin.b.a r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "bearUrl");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r5, "callBack");     // Catch: Throwable -> L18
        tt5.a.h("FetchClientVarExecutor", "getClientVarResult url: " + du5.b.k(r4.b));     // Catch: Throwable -> L18
        d r0 = this.e.get(r4.b);     // Catch: Throwable -> L18
        if (r0 != null) goto L10;
        r5.a(d("request not found"));     // Catch: Throwable -> L18
        this.e.put(r4.b, new d(Status.INTERRUPT, 12));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L10:
        if (e.a[r0.a.ordinal()] != 1) goto L12;
        r0.d.add(r5);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L12:
        String r6 = r0.b;     // Catch: Throwable -> L18
        if (r6 != null) goto L15;
        r6 = d("request failed");     // Catch: Throwable -> L18
    L15:
        r5.a(r6);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static final void a(FetchClientVarExecutor r28, BearUrl r29, long r30, ClientVarReslut r32) {
        monitor-enter(r28);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty((CharSequence) r32.data) == true) goto L10;
        if (((String) r32.data).length() <= 2621440) goto L10;
        iu5.d.a("NET_RESPONSE", new Throwable(" fetch clientvar, and response length: " + ((String) r32.data).length()));     // Catch: Throwable -> L32
    L10:
        if (r28.e.get(r29.b) != null) goto L12;
        r28.e.put(r29.b, new d(Status.Fetching, 12));     // Catch: Throwable -> L32
    L12:
        d r3 = r28.e.get(r29.b);     // Catch: Throwable -> L32
        if (r3 != null) goto L15;
    L25:
        int r8 = sbb.e.g(r29.a);     // Catch: Throwable -> L32
        int r16 = r32.code;     // Catch: Throwable -> L32
        if (r16 != 0) goto L28;
        int r14 = 0;
    L29:
        e25.b.b(new e25.c(r8, "clientvar_before_open", "pre_fetch", "", "native", -1, r14, r16, "", r30, 0, 0, 0, yu5.c.c((String) r32.data), 0, null));     // Catch: Throwable -> L32
        monitor-exit(r28);
        return;
    L28:
        r14 = 1;
        goto L29
    L15:
        if (r32.code != 0) goto L17;
        Status r4 = Status.SUCCESS;     // Catch: Throwable -> L32
    L18:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L32
        r3.a = r4;     // Catch: Throwable -> L32
        r3.b = r32.toString();     // Catch: Throwable -> L32
        r3.c = null;     // Catch: Throwable -> L32
        Iterator<T> r5 = r3.d.iterator();     // Catch: Throwable -> L32
    L20:
        if (r5.hasNext() == false) goto L25;
        b r6 = (b) r5.next();     // Catch: Throwable -> L32
        String r7 = r3.b;     // Catch: Throwable -> L32
        if (r7 != null) goto L24;
        r7 = d("result not found");     // Catch: Throwable -> L32
    L24:
        r6.a(r7);     // Catch: Throwable -> L32
        goto L20
    L17:
        r4 = Status.FAILED;     // Catch: Throwable -> L32
        goto L18
    }
}
