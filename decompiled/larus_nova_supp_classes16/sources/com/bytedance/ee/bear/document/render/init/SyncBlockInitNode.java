package com.bytedance.ee.bear.document.render.init;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.PreviewStatus;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SyncBlockInitNode implements bk5.b {
    public static final a b = null;
    public final Function3<h0, NetService, BearUrl, Flowable<String>> a;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ kotlinx.coroutines.i<String> b;

        public b(AtomicBoolean r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == false) goto L9;
            this.b.resumeWith(Result.constructor-impl(r5));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ kotlinx.coroutines.i<String> b;

        public c(AtomicBoolean r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            if (this.a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == false) goto L9;
            kotlinx.coroutines.i<String> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            Intrinsics.checkNotNull(r5);
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r5)));
            return;
        }
    }

    public final String toString() {
        return "SyncBlockInitNode";
    }

    static {
        b = new a();
    }

    public SyncBlockInitNode() {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "sourceTokenResolver");
        this.a = r0;
    }

    public static void f(bk5.a r2, String r3) {
        tt5.a.h("SyncBlockInitNode", r2.getTAG() + ", terminate: " + r3);
        r2.terminate();
        throw new CancellationException(r3);
    }

    public static void d(bk5.a r21, String r22, com.bytedance.ee.bear.route.h r23) {
        String r3 = "";
        r21.hideLoading();
        b.getClass();
        Intrinsics.checkNotNullParameter(r22, "url");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L31
        Uri r1 = UriProtector.parse(r22);     // Catch: Throwable -> L31
        Uri.Builder r7 = r1.buildUpon().encodedQuery(null);     // Catch: Throwable -> L31
        String r8 = r1.getEncodedQuery();     // Catch: Throwable -> L31
        if (r8 != null) goto L6;
    L9:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L29;
        Iterator r4 = StringsKt.split$default(r8, new String[]{"&"}, false, 0, 6, null).iterator();     // Catch: Throwable -> L31
    L14:
        if (r4.hasNext() == false) goto L29;
        String r9 = (String) r4.next();     // Catch: Throwable -> L31
        if (StringsKt.isBlank(r9) == true) goto L14;
        int r10 = StringsKt.indexOf$default(r9, '=', 0, false, 6, null);     // Catch: Throwable -> L31
        if (r10 < 0) goto L21;
        String r11 = r9.substring(0, r10);     // Catch: Throwable -> L31
    L22:
        if (r10 < 0) goto L24;
        String r12 = r9.substring(r10 + 1);     // Catch: Throwable -> L31
    L25:
        String r13 = Uri.decode(r11);     // Catch: Throwable -> L31
        if (Intrinsics.areEqual(r13, "routeFromSync") == true) goto L14;
        r7.appendQueryParameter(r13, Uri.decode(r12));     // Catch: Throwable -> L31
        goto L14
    L24:
        r12 = "";
        goto L25
    L21:
        r11 = r9;
    L29:
        r7.appendQueryParameter("routeFromSync", "true");     // Catch: Throwable -> L31
        Object r5 = Result.constructor-impl(r7.build().toString());     // Catch: Throwable -> L31
    L33:
        Throwable r14 = Result.exceptionOrNull-impl(r5);
        if (r14 == null) goto L37;
        tt5.a.e("SyncBlockInitNode", "appendRouteFromSyncQuery failed", r14, false);
        r5 = r22;
    L37:
        String r6 = (String) r5;
        if (r23 == null) goto L40;
        r23.u5(r6);
    L40:
        com.bytedance.ee.util.ui.j.d(new n(r21), 50);
        String r16 = r21.h9().getString("plugin_host_callback_key");
        if (r16 == null) goto L44;
        r3 = r16;
    L44:
        ConcurrentHashMap r17 = hk5.b.a;
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r3, "key");
        hk5.a r18 = (hk5.a) hk5.b.a.remove(r3);
        if (r18 == null) goto L48;
        r18.onOpenFailedBeforeHost();
    L48:
        f(r21, "sync block fallback to h5");
        throw null;
    L6:
        if (r8.length() == 0) goto L9;
        r2 = false;
    L31:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    public static void e(final bk5.a r8, final Bundle r9, final BearUrl r10) {
        r8.hideLoading();
        Activity r0 = r8.getActivity();
        if (r0 == null) goto L5;
        String r1 = r0.getString(2131887767);
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r3 = r1;
        Activity r2 = r8.getActivity();
        if (r2 == null) goto L11;
        String r6 = r2.getString(2131889052);
    L12:
        r8.g9(r3, 2131232542, -1, r6, new SyncBlockInitNode$showRetryErrorAndTerminate$1(r8, r9, r10));
        f(r8, "sync block retry error");
        throw null;
    L11:
        r6 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static void g(Bundle r1, BearUrl r2, String r3) {
        b.getClass();
        r2.a = sbb.e.o.getType();
        r2.b = r3;
        r2.r = "601";
        r1.putString("url", r2.e);
        r1.putParcelable("bear_url", r2);
    }

    public final boolean b(BearUrl r2, bk5.e r3, bk5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "bearUrl");
        Intrinsics.checkNotNullParameter(r3, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r4, "container");
        return Intrinsics.areEqual(r2.a, sbb.e.y.getType());
    }

    public final Object a(BearUrl r23, bk5.e r24, bk5.a r26, Continuation<? super bk5.e> r27) {
        if ((r27 instanceof SyncBlockInitNode$run$1) == false) goto L7;
        SyncBlockInitNode$run$1 r4 = (SyncBlockInitNode$run$1) r27;
        int r5 = r4.label;
        if ((r5 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L7;
        r4.label = r5 - ShareItemModel.SRC_TINT_UNDEFINED;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        String r8 = "";
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L81:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.bytedance.ee.bear.route.h r2 = (com.bytedance.ee.bear.route.h) r4.L$5;
        String r3 = (String) r4.L$4;
        Bundle r9 = (Bundle) r4.L$3;
        Bundle r10 = (Bundle) r4.L$2;
        bk5.a r11 = (bk5.a) r4.L$1;
        BearUrl r12 = (BearUrl) r4.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L18
    L36:
        String r1 = (String) r0;     // Catch: Throwable -> L18
        JobKt.ensureActive(r4.getContext());
        if (StringsKt.isBlank(r1) == true) goto L41;
        g(r10, r12, r1);
        return bk5.e.b.b;
    L41:
        e(r11, r9, r12);
        throw null;
    L18:
        th = th;
    L46:
        if ((th instanceof CancellationException) == true) goto L86;
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.L$3 = null;
        r4.L$4 = null;
        r4.L$5 = null;
        r4.label = 2;
        JobKt.ensureActive(r4.getContext());
        if ((th instanceof NetService.ServerErrorException) == false) goto L84;
        int r13 = th.getCode();
        if (r13 != 4) goto L52;
        boolean r14 = ((dn4.a) r11.j9().a(dn4.a.class)).a().isCurrentEnable("ccm.docs.synced_block.permission.authorise");
        JobKt.ensureActive(r4.getContext());
        if (r14 == false) goto L82;
        g(r11.h9(), r12, "");
        r0 = bk5.e.b.b;
        if (r0 != r6) goto L81;
        return r6;
    L82:
        d(r11, r3, r2);
        throw null;
    L52:
        if (r13 != 1002) goto L54;
        r11.hideLoading();
        Activity r16 = r11.getActivity();
        if (r16 == null) goto L62;
        String r17 = r16.getString(2131889296);
    L63:
        if (r17 != null) goto L65;
        String r18 = "";
    L66:
        r11.g9(r18, 2131232580, Integer.valueOf(PreviewStatus.OVER_MUCH_NODES_IN_TOTAL), null, null);
        String r19 = r11.h9().getString("plugin_host_callback_key");
        if (r19 == null) goto L70;
        r8 = r19;
    L70:
        ConcurrentHashMap r20 = hk5.b.a;
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r8, "key");
        hk5.a r21 = (hk5.a) hk5.b.a.remove(r8);
        if (r21 == null) goto L74;
        r21.onOpenFailedBeforeHost();
    L74:
        f(r11, "sync block deleted");
        throw null;
    L65:
        r18 = r17;
        goto L66
    L62:
        r17 = null;
        goto L63
    L54:
        if (r13 == 10051) goto L57;
        e(r11, r9, r12);
        throw null;
    L57:
        d(r11, r3, r2);
        throw null;
    L84:
        e(r11, r9, r12);
        throw null;
    L86:
        throw th;
    L20:
        ResultKt.throwOnFailure(r0);
        Bundle r22 = r26.h9();
        r9 = new Bundle(r22);
        String r110 = r23.e;
        if (r110 != null) goto L23;
        r110 = "";
    L23:
        String r111 = r23.b;
        if (r111 != null) goto L26;
    L29:
        boolean r112 = true;
    L30:
        if (r112 == true) goto L87;
        vo5.a r113 = r26.j9();
        h0 r114 = (h0) r113.a(h0.class);
        NetService r115 = (NetService) r113.a(NetService.class);
        com.bytedance.ee.bear.route.h r116 = (com.bytedance.ee.bear.route.h) r113.a(com.bytedance.ee.bear.route.h.class);
        r4.L$0 = r23;     // Catch: Throwable -> L43
        r4.L$1 = r26;     // Catch: Throwable -> L43
        r4.L$2 = r22;     // Catch: Throwable -> L43
        r4.L$3 = r9;     // Catch: Throwable -> L43
        r4.L$4 = r110;     // Catch: Throwable -> L43
        r4.L$5 = r116;     // Catch: Throwable -> L43
        r4.label = 1;     // Catch: Throwable -> L43
        Object r28 = c(r114, r115, r23, r4);     // Catch: Throwable -> L43
        if (r28 != r6) goto L35;
        return r6;
    L35:
        r10 = r22;
        r0 = r28;
        r12 = r23;
        r2 = r116;
        String r29 = r110;
        r11 = r26;
        r3 = r29;
    L43:
        th = th;
        r12 = r23;
        r2 = r116;
        String r210 = r110;
        r11 = r26;
        r3 = r210;
        goto L46
    L87:
        e(r26, r9, r23);
        throw null;
    L26:
        if (StringsKt.isBlank(r111) == true) goto L29;
        r112 = false;
    L7:
        r4 = new SyncBlockInitNode$run$1(this, r27);
        goto L8
    }

    public final Object c(h0 r4, NetService r5, BearUrl r6, Continuation<? super String> r7) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        final AtomicBoolean r1 = new AtomicBoolean(false);
        final Disposable r8 = ((Flowable) this.a.invoke(r4, r5, r6)).first("").subscribe(new b(r1, r0), new c(r1, r0));
        r0.i(new SyncBlockInitNode$awaitSourceToken$2$1(r1, r8));
        Object r9 = r0.B();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r9;
    }
}
