package com.bytedance.ee.bear.document.render.init;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public final class SyncBlockInitNode implements bk5.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f221279b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<h0, NetService, BearUrl, Flowable<String>> f221280a;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f221281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<String> f221282b;

        public b(AtomicBoolean r100, kotlinx.coroutines.j r101) {
            this.f221281a = r100;
            this.f221282b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            if (this.f221281a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.f221282b.isActive() == false) goto L9;
            this.f221282b.resumeWith(Result.m9449constructorimpl(r101));
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f221283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<String> f221284b;

        public c(AtomicBoolean r100, kotlinx.coroutines.j r101) {
            this.f221283a = r100;
            this.f221284b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (this.f221283a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            if (this.f221284b.isActive() == false) goto L9;
            kotlinx.coroutines.i<String> r102 = this.f221284b;
            Result.Companion r103 = Result.Companion;
            Intrinsics.checkNotNull(r101);
            r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r101)));
            return;
        }
    }

    public final String toString() {
        return "SyncBlockInitNode";
    }

    static {
        f221279b = new a();
    }

    public SyncBlockInitNode() {
        AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "sourceTokenResolver");
        this.f221280a = r100;
    }

    public static void f(bk5.a r100, String r101) {
        tt5.a.h("SyncBlockInitNode", r100.getTAG() + ", terminate: " + r101);
        r100.terminate();
        throw new CancellationException(r101);
    }

    public static void d(bk5.a r210, String r211, com.bytedance.ee.bear.route.h r212) {
        String r100 = "";
        r210.hideLoading();
        f221279b.getClass();
        Intrinsics.checkNotNullParameter(r211, "url");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L31
        Uri r102 = UriProtector.parse(r211);     // Catch: Throwable -> L31
        Uri.Builder r103 = r102.buildUpon().encodedQuery(null);     // Catch: Throwable -> L31
        String r104 = r102.getEncodedQuery();     // Catch: Throwable -> L31
        if (r104 != null) goto L6;
    L9:
        boolean r105 = true;
    L11:
        if (r105 == true) goto L29;
        Iterator r106 = StringsKt.split$default(r104, new String[]{"&"}, false, 0, 6, null).iterator();     // Catch: Throwable -> L31
    L14:
        if (r106.hasNext() == false) goto L29;
        String r107 = (String) r106.next();     // Catch: Throwable -> L31
        if (StringsKt.isBlank(r107) == true) goto L14;
        int r108 = StringsKt.indexOf$default(r107, com.alipay.sdk.m.n.a.f25612h, 0, false, 6, null);     // Catch: Throwable -> L31
        if (r108 < 0) goto L21;
        String r110 = r107.substring(0, r108);     // Catch: Throwable -> L31
    L22:
        if (r108 < 0) goto L24;
        String r109 = r107.substring(r108 + 1);     // Catch: Throwable -> L31
    L25:
        String r111 = Uri.decode(r110);     // Catch: Throwable -> L31
        if (Intrinsics.areEqual(r111, "routeFromSync") == true) goto L14;
        r103.appendQueryParameter(r111, Uri.decode(r109));     // Catch: Throwable -> L31
        goto L14
    L24:
        r109 = "";
        goto L25
    L21:
        r110 = r107;
    L29:
        r103.appendQueryParameter("routeFromSync", "true");     // Catch: Throwable -> L31
        Object r112 = Result.m9449constructorimpl(r103.build().toString());     // Catch: Throwable -> L31
    L33:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L37;
        tt5.a.e("SyncBlockInitNode", "appendRouteFromSyncQuery failed", r113, false);
        r112 = r211;
    L37:
        String r114 = (String) r112;
        if (r212 == null) goto L40;
        r212.u5(r114);
    L40:
        com.bytedance.ee.util.ui.j.d(new n(r210), 50);
        String r115 = r210.h9().getString("plugin_host_callback_key");
        if (r115 == null) goto L44;
        r100 = r115;
    L44:
        ConcurrentHashMap<String, hk5.a> r116 = hk5.b.f485570a;
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r100, "key");
        hk5.a r117 = hk5.b.f485570a.remove(r100);
        if (r117 == null) goto L48;
        r117.onOpenFailedBeforeHost();
    L48:
        f(r210, "sync block fallback to h5");
        throw null;
    L6:
        if (r104.length() == 0) goto L9;
        r105 = false;
    L31:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    }

    public static void e(final bk5.a r100, final Bundle r101, final BearUrl r110) {
        r100.hideLoading();
        Activity r102 = r100.getActivity();
        if (r102 == null) goto L5;
        String r103 = r102.getString(R.string.Doc_Facade_LoadFailed);
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        String r104 = r103;
        Activity r105 = r100.getActivity();
        if (r105 == null) goto L11;
        String r106 = r105.getString(R.string.LarkCCM_Docs_ErrorRefresh_Button_Mob);
    L12:
        r100.g9(r104, R.drawable.ccm_empty_negative_load_failed, -1, r106, new SyncBlockInitNode$showRetryErrorAndTerminate$1(r100, r101, r110));
        f(r100, "sync block retry error");
        throw null;
    L11:
        r106 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public static void g(Bundle r100, BearUrl r101, String r102) {
        f221279b.getClass();
        r101.f222560a = sbb.e.f541304o.getType();
        r101.f222561b = r102;
        r101.f222577r = "601";
        r100.putString("url", r101.f222564e);
        r100.putParcelable("bear_url", r101);
    }

    @Override // bk5.b
    public final boolean b(BearUrl r100, bk5.e r101, bk5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "loaderTypeBefore");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        return Intrinsics.areEqual(r100.f222560a, sbb.e.f541314y.getType());
    }

    @Override // bk5.b
    public final Object a(BearUrl r210, bk5.e r211, bk5.a r212, Continuation<? super bk5.e> r213) {
        if ((r213 instanceof SyncBlockInitNode$run$1) == false) goto L7;
        SyncBlockInitNode$run$1 r100 = (SyncBlockInitNode$run$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "";
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L81:
        return r102;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.bytedance.ee.bear.route.h r106 = (com.bytedance.ee.bear.route.h) r100.L$5;
        String r107 = (String) r100.L$4;
        Bundle r108 = (Bundle) r100.L$3;
        Bundle r109 = (Bundle) r100.L$2;
        bk5.a r110 = (bk5.a) r100.L$1;
        BearUrl r111 = (BearUrl) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L18
    L36:
        String r112 = (String) r102;     // Catch: Throwable -> L18
        JobKt.ensureActive(r100.getContext());
        if (StringsKt.isBlank(r112) == true) goto L41;
        g(r109, r111, r112);
        return bk5.e.b.f19366b;
    L41:
        e(r110, r108, r111);
        throw null;
    L18:
        th = th;
    L46:
        if ((th instanceof CancellationException) == true) goto L86;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 2;
        JobKt.ensureActive(r100.getContext());
        if ((th instanceof NetService.ServerErrorException) == false) goto L84;
        int r113 = th.getCode();
        if (r113 != 4) goto L52;
        boolean r114 = ((dn4.a) r110.j9().a(dn4.a.class)).a().isCurrentEnable("ccm.docs.synced_block.permission.authorise");
        JobKt.ensureActive(r100.getContext());
        if (r114 == false) goto L82;
        g(r110.h9(), r111, "");
        r102 = bk5.e.b.f19366b;
        if (r102 != r103) goto L81;
        return r103;
    L82:
        d(r110, r107, r106);
        throw null;
    L52:
        if (r113 != 1002) goto L54;
        r110.hideLoading();
        Activity r115 = r110.getActivity();
        if (r115 == null) goto L62;
        String r116 = r115.getString(R.string.LarkCCM_Docs_SyncBlock_Deleted_Toast);
    L63:
        if (r116 != null) goto L65;
        String r117 = "";
    L66:
        r110.g9(r117, R.drawable.ccm_vc_empty_neutral_recycle_bin, 1002, null, null);
        String r118 = r110.h9().getString("plugin_host_callback_key");
        if (r118 == null) goto L70;
        r105 = r118;
    L70:
        ConcurrentHashMap<String, hk5.a> r119 = hk5.b.f485570a;
        Intrinsics.checkNotNullParameter(r105, "key");
        Intrinsics.checkNotNullParameter(r105, "key");
        hk5.a r120 = hk5.b.f485570a.remove(r105);
        if (r120 == null) goto L74;
        r120.onOpenFailedBeforeHost();
    L74:
        f(r110, "sync block deleted");
        throw null;
    L65:
        r117 = r116;
        goto L66
    L62:
        r116 = null;
        goto L63
    L54:
        if (r113 == 10051) goto L57;
        e(r110, r108, r111);
        throw null;
    L57:
        d(r110, r107, r106);
        throw null;
    L84:
        e(r110, r108, r111);
        throw null;
    L86:
        throw th;
    L20:
        ResultKt.throwOnFailure(r102);
        Bundle r121 = r212.h9();
        r108 = new Bundle(r121);
        String r122 = r210.f222564e;
        if (r122 != null) goto L23;
        r122 = "";
    L23:
        String r123 = r210.f222561b;
        if (r123 != null) goto L26;
    L29:
        boolean r124 = true;
    L30:
        if (r124 == true) goto L87;
        vo5.a r125 = r212.j9();
        h0 r126 = (h0) r125.a(h0.class);
        NetService r127 = (NetService) r125.a(NetService.class);
        com.bytedance.ee.bear.route.h r128 = (com.bytedance.ee.bear.route.h) r125.a(com.bytedance.ee.bear.route.h.class);
        r100.L$0 = r210;     // Catch: Throwable -> L43
        r100.L$1 = r212;     // Catch: Throwable -> L43
        r100.L$2 = r121;     // Catch: Throwable -> L43
        r100.L$3 = r108;     // Catch: Throwable -> L43
        r100.L$4 = r122;     // Catch: Throwable -> L43
        r100.L$5 = r128;     // Catch: Throwable -> L43
        r100.label = 1;     // Catch: Throwable -> L43
        Object r129 = c(r126, r127, r210, r100);     // Catch: Throwable -> L43
        if (r129 != r103) goto L35;
        return r103;
    L35:
        r109 = r121;
        r102 = r129;
        r111 = r210;
        r106 = r128;
        String r214 = r122;
        r110 = r212;
        r107 = r214;
    L43:
        th = th;
        r111 = r210;
        r106 = r128;
        String r215 = r122;
        r110 = r212;
        r107 = r215;
        goto L46
    L87:
        e(r212, r108, r210);
        throw null;
    L26:
        if (StringsKt.isBlank(r123) == true) goto L29;
        r124 = false;
    L7:
        r100 = new SyncBlockInitNode$run$1(this, r213);
        goto L8
    }

    public final Object c(h0 r100, NetService r101, BearUrl r102, Continuation<? super String> r103) {
        kotlinx.coroutines.j r104 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r103), 1);
        r104.C();
        final AtomicBoolean r105 = new AtomicBoolean(false);
        final Disposable r106 = this.f221280a.invoke(r100, r101, r102).first("").subscribe(new b(r105, r104), new c(r105, r104));
        r104.i(new SyncBlockInitNode$awaitSourceToken$2$1(r105, r106));
        Object r107 = r104.B();
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L5:
        return r107;
    }
}
