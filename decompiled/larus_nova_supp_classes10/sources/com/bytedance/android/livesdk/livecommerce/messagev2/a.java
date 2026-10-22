package com.bytedance.android.livesdk.livecommerce.messagev2;

import ak2.l;
import am3.g;
import android.content.Context;
import bh2.w;
import bh2.x;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.live.r;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.controller.y;
import com.bytedance.android.livesdk.livecommerce.room.j;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sg2.e0;
import sg2.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends c0 implements td.a, IExternalMessageListener, nl2.c {
    public static final /* synthetic */ int k = 0;
    public com.bytedance.android.livesdk.livecommerce.room.api.d c;
    public l d;
    public final List<e0> e;
    public final Map<String, List<y>> f;
    public final List<r> g;
    public final com.bytedance.android.livesdk.livecommerce.messagev2.b h;
    public final j i;
    public final /* synthetic */ nl2.a j;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.messagev2.a$a, reason: collision with other inner class name */
    public static final class C0079a {
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ a a;
        public final /* synthetic */ ee.a b;
        public final /* synthetic */ boolean c;

        public b(a r1, ee.a r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.util.concurrent.Callable
        public final sg2.a call() {
            a r0 = this.a;
            fe.a r2 = this.b;
            boolean r10 = this.c;
            int r3 = a.k;
            r0.getClass();
            long r13 = System.currentTimeMillis();
            x r4 = x.e;
            String r1 = r2.u();
            String r5 = r2.getContentType();
            byte[] r6 = r2.getContent();
            if (x.b == true) goto L18;
            monitor-enter(r4);
        L14:
            th = move-exception;
            throw th;
        L6:
            if (x.b == true) goto L12;
            Iterator r7 = ((ArrayList) x.a).iterator();     // Catch: Throwable -> L14
        L9:
            if (r7.hasNext() == false) goto L11;
            w r8 = (w) r7.next();     // Catch: Throwable -> L14
            x.c.putAll(r8.b());     // Catch: Throwable -> L14
            x.d.putAll(r8.a());     // Catch: Throwable -> L14
            goto L9
        L11:
            ((ArrayList) x.a).clear();     // Catch: Throwable -> L14
            x.b = true;     // Catch: Throwable -> L14
        L12:
            monitor-exit(r4);
        L18:
            if (r1 != null) goto L20;
        L23:
            boolean r9 = true;
        L25:
            if (r9 == true) goto L63;
            if (r5 != null) goto L28;
        L31:
            boolean r11 = true;
        L32:
            if (r11 == true) goto L63;
            if (r6 != null) goto L36;
        L62:
            bh2.a.a("decode_err_content_empty", r5);
        L64:
            final sg2.a r12 = null;
        L65:
            if (r12 == null) goto L67;
            String r14 = r2.m();
            String r15 = r2.getContentType();
            long r16 = r2.x();
            TraceTimeMetricV2 r17 = r2.d();
            r2.f();
            int r18 = 2;
            r12.setCommon(new sg2.b(r14, r15, r16, r17, null, r10, System.currentTimeMillis()));
        L68:
            Pair[] r19 = new Pair[r18];
            r19[0] = TuplesKt.to("contentType", r2.getContentType());
            r19[1] = TuplesKt.to("cost", String.valueOf(System.currentTimeMillis() - r13));
            final Map r20 = MapsKt.mutableMapOf(r19);
            com.bytedance.android.ec.sdk.helper.l.a(new MessageV2Controller$decodeMessage$$inlined$apply$lambda$1(r20, r12));
            Unit r21 = Unit.INSTANCE;
            xh.b r22 = new xh.b();
            r22.c(null);
            r22.b("MsgDecode");
            r22.a(r20);
            xh.c.a("Live").f(r18, r22);
            return r12;
        L67:
            r18 = 2;
            goto L68
        L36:
            if (r6.length != 0) goto L38;
            boolean r23 = true;
        L39:
            if (r23 == true) goto L62;
            if (Intrinsics.areEqual(r1, "application/vnd.google.protobuf") == false) goto L61;
            Class<?> r24 = (Class) ((LinkedHashMap) x.c).get(r5);
            if (r24 != null) goto L46;
            Map r25 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "msg clazz not registered"), TuplesKt.to("contentType", r5)});
            xh.b r26 = new xh.b();
            r26.c(null);
            r26.b("MsgDecode");
            r26.a(r25);
            xh.c.a("Live").f(5, r26);
            goto L64
        L46:
            am3.c<?> r27 = r4.a(r24);
            g r28 = new g();
            r28.k(new am3.b(r6));     // Catch: Exception -> L60
            if (r27 == null) goto L50;
            Object r29 = r27.decode(r28);     // Catch: Exception -> L60
        L51:
            if (r29 != null) goto L56;
            if (r27 != null) goto L54;
            bh2.a.a("decode_err_decoder_notfound", r5);     // Catch: Exception -> L60
            goto L56
        L54:
            bh2.a.a("decode_err_decode_bytes", r5);     // Catch: Exception -> L60
        L56:
            if ((r29 instanceof sg2.a) == true) goto L58;
            r29 = null;
        L58:
            r12 = (sg2.a) r29;     // Catch: Exception -> L60
            goto L65
        L50:
            r29 = null;
        L60:
            bh2.a.a("decode_err_exception", r5);
            goto L64
        L61:
            bh2.a.a("decode_err_invalid_format", r5);
            goto L64
        L38:
            r23 = false;
            goto L39
        L28:
            if (r5.length() == 0) goto L31;
            r11 = false;
        L63:
            bh2.a.a("decode_err_info_empty", r5);
            goto L64
        L20:
            if (r1.length() == 0) goto L23;
            r9 = false;
            goto L25
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            sg2.a r12 = (sg2.a) r11;
            a r0 = this.a;
            r0.getClass();
            if (r12 == null) goto L7;
            sg2.b r2 = r12.getCommon();
            if (r2 == null) goto L7;
            String r3 = r2.b;
        L8:
            if (r3 == null) goto L53;
            boolean r4 = false;
            monitor-enter(r0);     // Catch: Exception -> L33
        L30:
            th = move-exception;
            throw th;     // Catch: Exception -> L33
        L13:
            if (((ArrayList) r0.e).isEmpty() == false) goto L15;
            List<e0> r5 = r0.e;     // Catch: Throwable -> L30
            int r6 = com.bytedance.android.livesdk.livecommerce.message.c.a;     // Catch: Throwable -> L30
            ((ArrayList) r5).addAll(com.bytedance.android.livesdk.livecommerce.message.c.a(true, r0.A()));     // Catch: Throwable -> L30
        L15:
            ArrayList r7 = (ArrayList) r0.e;     // Catch: Throwable -> L30
            Iterator r8 = r7.iterator();     // Catch: Throwable -> L30
        L17:
            if (r8.hasNext() == false) goto L25;
            e0 r9 = (e0) r8.next();     // Catch: Throwable -> L30
            if ((r9 instanceof com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a) == true) goto L21;
            r9 = null;
        L21:
            com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a r10 = (com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a) r9;     // Catch: Throwable -> L30
            if (r10 == null) goto L17;
            j r13 = r0.i;     // Catch: Throwable -> L30
            Intrinsics.checkNotNullParameter(r13, "provider");     // Catch: Throwable -> L30
            r10.a = r13;     // Catch: Throwable -> L30
            r10.b = r13.roomId();     // Catch: Throwable -> L30
            r10.c = r13.a();     // Catch: Throwable -> L30
            r10.e(r10.b, r13.isAnchor());     // Catch: Throwable -> L30
            goto L17
        L25:
            if (r7.size() > 0) goto L27;
            boolean r1 = false;
        L28:
            monitor-exit(r0);     // Catch: Exception -> L33
            r4 = r1;
        L35:
            if (r4 == true) goto L42;
            List r14 = (List) ((HashMap) r0.f).get(r3);
            if (r14 == null) goto L42;
            Iterator<T> r15 = r14.iterator();
        L40:
            if (r15.hasNext() == false) goto L42;
            ((y) r15.next()).onReceive(r12);
        L42:
            r0.A().r.K();
            return;
        L27:
            r1 = ((e0) ListProtector.get(r7, 0)).a(new g0(r7, 1, r12));     // Catch: Throwable -> L30
        L33:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L35
        L53:
            return;
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            String r0 = r7.getMessage();
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            if (StringsKt.contains$default(r0, "The callable returned a null value", false, 2, null) == false) goto L8;
            this.a.getClass();
            Map r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "msg decode return null, pls check cause message before")});
            xh.b r1 = new xh.b();
            r1.c(null);
            r1.b("MsgDecode");
            r1.a(r8);
            xh.c.a("Live").f(5, r1);
            return;
        L8:
            ECExceptionMonitor.e(r7);
        }
    }

    static {
    }

    @Override // nl2.c
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.j.add(r2);
        return r2;
    }

    public final synchronized void I() {
        monitor-enter(this);
        l r1 = this.d;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.b();     // Catch: Throwable -> L10
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "releaseVirtualMessageManager: virturalMsgManager: " + this.d)});     // Catch: Throwable -> L10
        xh.b r3 = new xh.b();     // Catch: Throwable -> L10
        r3.c(null);     // Catch: Throwable -> L10
        r3.b("VirtualMsgChannel");     // Catch: Throwable -> L10
        r3.a(r0);     // Catch: Throwable -> L10
        xh.c.a("Live").f(4, r3);     // Catch: Throwable -> L10
    L7:
        this.d = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r0 = this.j.a;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        com.bytedance.android.livesdk.livecommerce.room.api.d r1 = this.c;
        if (r1 == null) goto L11;
        r1.b(this);
        com.bytedance.android.livesdk.livecommerce.room.api.d r2 = this.c;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("messageHandler");
    L10:
        r2.c(this);
    L11:
        I();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        monitor-enter(this);
        ((ArrayList) this.e).clear();     // Catch: Throwable -> L8
        ((HashMap) this.f).clear();     // Catch: Throwable -> L8
        ((ArrayList) this.g).clear();     // Catch: Throwable -> L8
        monitor-exit(this);
        I();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void H(long r14) {
        if (r14 <= 0) goto L44;
        monitor-enter(this);
        l r3 = this.d;     // Catch: Throwable -> L40
        if (r3 != null) goto L9;
    L19:
        if (r3 == null) goto L22;
        I();     // Catch: Throwable -> L40
        Map r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "Warning: an unreleased VirtualMessageManager before create new: " + this.d)});     // Catch: Throwable -> L40
        xh.b r4 = new xh.b();     // Catch: Throwable -> L40
        r4.c(null);     // Catch: Throwable -> L40
        r4.b("VirtualMsgChannel");     // Catch: Throwable -> L40
        r4.a(r2);     // Catch: Throwable -> L40
        xh.c.a("Live").f(5, r4);     // Catch: Throwable -> L40
    L22:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L28;
        ILiveService r7 = TTLiveService.getLiveService();     // Catch: Throwable -> L40
        if (r7 == null) goto L26;
        vlc.d r1 = r7.createCustomSceneMessageManager("ecom_live_virtual", r14, m(), new LinkedHashMap());     // Catch: Throwable -> L40
    L27:
        this.d = new l(r14, r1);     // Catch: Throwable -> L40
    L31:
        l r5 = this.d;     // Catch: Throwable -> L40
        if (r5 == null) goto L34;
        r5.c();     // Catch: Throwable -> L40
    L34:
        l r6 = this.d;     // Catch: Throwable -> L40
        if (r6 == null) goto L37;
        r6.a(this);     // Catch: Throwable -> L40
    L37:
        Map r15 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "createMessageManagerByVirtualID: " + r14 + ", virturalMsgManager: " + this.d)});     // Catch: Throwable -> L40
        xh.b r16 = new xh.b();     // Catch: Throwable -> L40
        r16.c(null);     // Catch: Throwable -> L40
        r16.b("VirtualMsgChannel");     // Catch: Throwable -> L40
        r16.a(r15);     // Catch: Throwable -> L40
        xh.c.a("Live").f(4, r16);     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L26:
        r1 = null;
        goto L27
    L28:
        int r8 = ECSdk.a;     // Catch: Throwable -> L40
        IAdapterService r9 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Throwable -> L40
        if (r9 == null) goto L31;
        r9.getMessageManagerService();     // Catch: Throwable -> L40
        goto L31
    L9:
        if (r3.a != r14) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L14;
        l r11 = r3;
    L15:
        if (r11 == null) goto L19;
        Map r17 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "virtualMessageManager already created, VirtualID: " + r14)});     // Catch: Throwable -> L40
        xh.b r18 = new xh.b();     // Catch: Throwable -> L40
        r18.c(null);     // Catch: Throwable -> L40
        r18.b("VirtualMsgChannel");     // Catch: Throwable -> L40
        r18.a(r17);     // Catch: Throwable -> L40
        xh.c.a("Live").f(3, r18);     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L14:
        r11 = null;
        goto L15
    L11:
        r10 = false;
    L40:
        th = move-exception;
        throw th;
    L44:
        if (r14 != (-1)) goto L48;
        I();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void g(com.bytedance.android.livesdk.livecommerce.room.api.d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageHandler");
        Intrinsics.checkNotNullParameter(r2, "messageHandler");
        this.c = r2;
        r2.a(1003, this);
        r2.d(this);
    }

    public final void onMessage(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if ((r2 instanceof fe.a) == false) goto L6;
        f((ee.a) r2, false);
        return;
    }

    public a(RealRoomController$roomResources$1 r2, RealRoomController.d r3) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        Intrinsics.checkNotNullParameter(r3, "roomStateProvider");
        super(r2);
        this.j = new nl2.a();
        this.i = r3;
        this.e = new ArrayList();
        this.f = new HashMap();
        this.g = new ArrayList();
        this.h = new com.bytedance.android.livesdk.livecommerce.messagev2.b(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
        super.c(r1, r2);
        monitor-enter(this);
        ((ArrayList) this.e).clear();     // Catch: Throwable -> L8
        ((HashMap) this.f).clear();     // Catch: Throwable -> L8
        ((ArrayList) this.g).clear();     // Catch: Throwable -> L8
        monitor-exit(this);
        I();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void f(ee.a r2, boolean r3) {
        if ((r2 instanceof fe.a) == false) goto L6;
        nl2.b.a(Single.fromCallable(new b(this, r2, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this)), this);
        return;
    }
}
