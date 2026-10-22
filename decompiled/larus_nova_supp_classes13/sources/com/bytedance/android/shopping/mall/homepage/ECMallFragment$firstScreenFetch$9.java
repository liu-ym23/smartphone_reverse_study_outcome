package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.bytedance.android.shopping.api.mall.opt.ECMallPopupRenderOptConfig;
import com.bytedance.android.shopping.mall.homepage.component.ECFMiddleware;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$firstScreenFetch$9 implements ECHybridNetworkTask.a {
    public String a;
    public volatile boolean b;
    public boolean c;
    public final /* synthetic */ ECMallFragment d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ com.bytedance.android.shopping.mall.homepage.tools.l f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Function1 h;
    public final /* synthetic */ int i;
    public final /* synthetic */ boolean j;

    /* JADX WARN: Type inference failed for: r0v21, types: [com.bytedance.android.shopping.mall.homepage.ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$1] */
    public final void c(final String r85, final String r86, final ECHybridNetworkVO r87, boolean r88) {
        Intrinsics.checkNotNullParameter(r85, "apiKey");
        Intrinsics.checkNotNullParameter(r86, "result");
        Intrinsics.checkNotNullParameter(r87, "requestVO");
        Object r5 = null;
        if (Intrinsics.areEqual(r85, "homepage") == false) goto L60;
        if (r87.a == true) goto L7;
        this.d.V1 = true;
        DataEngineWrapper r0 = this.d.L0;
        if (r0 == null) goto L36;
        long r7 = System.currentTimeMillis();
        if (r0.b.o() != null) goto L36;
        r0.b = y93.a.a(r0.b, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r7), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4194305, -1, -1, -1, 127);
        ThreadPoolHelper.d().submit(new com.bytedance.android.shopping.mall.homepage.tools.d(r0));
    L36:
        Lazy r1 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.e.b r2 = com.bytedance.android.ec.hybrid.log.mall.e.b.b;
        ECMallLogUtil.c(r2, "receive homepage response, duration = " + (System.currentTimeMillis() - this.d.r3));
        if (this.d.H2 == false) goto L45;
        if (this.d.ja0() == null) goto L45;
        if (com.bytedance.android.shopping.mall.homepage.opt.e.a() != true) goto L45;
        ECMallLogUtil.c(r2, "receive homepage response, data handled use intercept");
        return;
    L45:
        if (this.g == false) goto L55;
        ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2 r4 = new ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2(this, new ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$1(this, r85, r86, r87));
        if (this.i != 2) goto L52;
        if (Intrinsics.areEqual(this.d.K, Boolean.FALSE) == false) goto L52;
        this.d.M = r4;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "post first screen data holding, waiting for render with cached data");
    L52:
        if (this.i != 2) goto L54;
        this.d.O = true;
    L54:
        r4.run();
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "post first screen data at front of queue");
    L55:
        ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$3 r3 = new ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$3(this, r86);
        if (((Boolean) this.d.G.getValue()).booleanValue() == false) goto L58;
        Schedulers.io().createWorker().schedule(r3);
        goto L60
    L58:
        r3.run();
        goto L60
    L7:
        if (this.e == false) goto L29;
        com.bytedance.android.shopping.mall.homepage.tools.l r6 = this.f;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r85, "apiKey");
        Intrinsics.checkNotNullParameter(r87, "networkVO");
        Intrinsics.checkNotNullParameter(r86, "result");
        r6.getClass();
        Lazy r8 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECHybridChunkedDataProcessor#onChunkedResult()@" + r6.hashCode() + ", start");
        ((com.bytedance.android.ec.hybrid.data.utils.a) r6).e = r85;
        ((com.bytedance.android.ec.hybrid.data.utils.a) r6).f = r87;
        long r9 = System.currentTimeMillis();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L11
        Object r11 = Result.constructor-impl(new Gson().fromJson(r86, ((com.bytedance.android.ec.hybrid.data.utils.a) r6).h));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r11) == true) goto L17;
        r5 = r11;
    L17:
        HomePageDTO r12 = r6.b(r87, r86, r5);
        Lazy r13 = ECMallLogUtil.a;
        ECMallLogUtil.a(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "ECHybridChunkedDataProcessor#onChunkedResult()@" + r6.hashCode() + ", parse " + r85 + " chunked data finished, duration = " + (System.currentTimeMillis() - r9));
        CopyOnWriteArrayList r14 = ((com.bytedance.android.ec.hybrid.data.utils.a) r6).a;
        monitor-enter(r14);
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECHybridChunkedDataProcessor#onChunkedResult()@" + r6.hashCode() + ", currentDataListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r6).a.size() + ", currentCallbackListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r6).b.size());     // Catch: Throwable -> L26
        ((com.bytedance.android.ec.hybrid.data.utils.a) r6).a.add(TuplesKt.to(r86, r12));     // Catch: Throwable -> L26
        Iterator r15 = ((com.bytedance.android.ec.hybrid.data.utils.a) r6).b.iterator();     // Catch: Throwable -> L26
    L21:
        if (r15.hasNext() == false) goto L23;
        ((com.bytedance.android.ec.hybrid.data.utils.a.a) r15.next()).c(r85, r87, r86, r12);     // Catch: Throwable -> L26
        goto L21
    L23:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r14);
        Lazy r17 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECHybridChunkedDataProcessor#onChunkedResult()@" + r6.hashCode() + ", end");
        return;
    L26:
        th = move-exception;
        throw th;
    L11:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L29:
        return;
    L60:
        if (Intrinsics.areEqual(r85, "marketing_resource_get") == false) goto L82;
        ECFMiddleware r19 = this.d.d;
        System.currentTimeMillis();
        r19.getClass();
        this.a = r86;
        Lazy r20 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.e r21 = com.bytedance.android.ec.hybrid.log.mall.k.e.b;
        ECMallLogUtil.c(r21, "PopupRenderOpt, receive marketing_resource_get result, timestamp = " + System.currentTimeMillis());
        ECMallPopupRenderOptConfig.a r22 = ECMallPopupRenderOptConfig.Companion;
        String r23 = this.d.d.e();
        r22.getClass();
        int r24 = ECMallPopupRenderOptConfig.a.b(r23);
        if (r24 > 0) goto L64;
    L74:
        ECMallLogUtil.c(r21, "PopupRenderOpt, won't invoke in onResult, timestamp = " + System.currentTimeMillis() + ", pageName = " + this.d.d.e() + ", strategy = " + r24 + ", needHandleMarketingResource = " + this.j);
        return;
    L64:
        if (this.j == false) goto L74;
        this.d.N = new ECMallFragment$firstScreenFetch$9$onResult$1(this, r86);
        this.d.getClass();
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L73;
        if (r24 != 1) goto L69;
    L70:
        ECMallLogUtil.c(r21, "PopupRenderOpt, invoke in onResult, timestamp = " + System.currentTimeMillis());
        Runnable r25 = this.d.N;
        if (r25 == null) goto L83;
        r25.run();
        return;
    L83:
        return;
    L69:
        if ((!Intrinsics.areEqual(this.d.K, Boolean.FALSE)) == true) goto L70;
    L73:
        ECMallLogUtil.c(r21, "PopupRenderOpt, can't invoke in onResult immediately, timestamp = " + System.currentTimeMillis() + ", pageName = " + this.d.d.e() + ", strategy = " + r24 + ", isMallVisible = null, renderWithCachedDataFinished = " + this.d.K);
        return;
    }

    public final void d(String r8, String r9, ECHybridNetworkVO r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "apiKey");
        Intrinsics.checkNotNullParameter(r9, "result");
        Intrinsics.checkNotNullParameter(r10, "requestVO");
        if (this.d.isAdded() == true) goto L5;
        return;
    L5:
        boolean r12 = Intrinsics.areEqual(r8, "homepage");
        if (r12 == true) goto L8;
    L28:
        if (r12 == false) goto L37;
        if (this.d.H2 == false) goto L37;
        if (this.d.ja0() == null) goto L37;
        if (com.bytedance.android.shopping.mall.homepage.opt.e.a() != true) goto L37;
        return;
    L37:
        if (this.g == false) goto L42;
        if (r12 == false) goto L42;
        if (this.c == false) goto L42;
        return;
    L42:
        if (r12 == false) goto L44;
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "handle homepage response, duration = " + (System.currentTimeMillis() - this.d.r3));
    L44:
        ECMallFragment r2 = this.d;
        Function1 r3 = this.h;
        int r4 = ECMallFragment.h4;
        r2.da0(r8, r9, r10, r3);
        if (r12 == false) goto L53;
        this.c = true;
        return;
    L53:
        return;
    L8:
        if (r10.a == false) goto L28;
        if (this.e == false) goto L27;
        com.bytedance.android.shopping.mall.homepage.tools.l r13 = this.f;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r8, "apiKey");
        Intrinsics.checkNotNullParameter(r10, "networkVO");
        r13.getClass();
        Lazy r5 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.e.b r6 = com.bytedance.android.ec.hybrid.log.mall.e.b.b;
        ECMallLogUtil.c(r6, "ECHybridChunkedDataProcessor#onSuccess()@" + r13.hashCode() + ", start");
        ((com.bytedance.android.ec.hybrid.data.utils.a) r13).e = r8;
        ((com.bytedance.android.ec.hybrid.data.utils.a) r13).f = r10;
        CopyOnWriteArrayList r14 = ((com.bytedance.android.ec.hybrid.data.utils.a) r13).a;
        monitor-enter(r14);
        ECMallLogUtil.c(r6, "ECHybridChunkedDataProcessor#onSuccess()@" + r13.hashCode() + ", currentDataListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r13).a.size() + ", currentCallbackListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r13).b.size());     // Catch: Throwable -> L24
        CopyOnWriteArrayList r15 = ((com.bytedance.android.ec.hybrid.data.utils.a) r13).a;     // Catch: Throwable -> L24
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));     // Catch: Throwable -> L24
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L24
    L15:
        if (r16.hasNext() == false) goto L17;
        r7.add(((Pair) r16.next()).getSecond());     // Catch: Throwable -> L24
        goto L15
    L17:
        HomePageDTO r17 = r13.c(r7);     // Catch: Throwable -> L24
        Iterator r18 = ((com.bytedance.android.ec.hybrid.data.utils.a) r13).b.iterator();     // Catch: Throwable -> L24
    L19:
        if (r18.hasNext() == false) goto L21;
        ((com.bytedance.android.ec.hybrid.data.utils.a.a) r18.next()).a(r8, r17);     // Catch: Throwable -> L24
        goto L19
    L21:
        ((com.bytedance.android.ec.hybrid.data.utils.a) r13).c = true;     // Catch: Throwable -> L24
        ((com.bytedance.android.ec.hybrid.data.utils.a) r13).d = Boolean.TRUE;     // Catch: Throwable -> L24
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r14);
        Lazy r20 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECHybridChunkedDataProcessor#onSuccess()@" + r13.hashCode() + ", end");
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void e(String r7, Throwable r8, ECHybridNetworkVO r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "apiKey");
        Intrinsics.checkNotNullParameter(r8, "t");
        if (this.d.isAdded() == true) goto L5;
        return;
    L5:
        Lazy r11 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.e.b r12 = com.bytedance.android.ec.hybrid.log.mall.e.b.b;
        StringBuilder r0 = new StringBuilder("fetch api on first screen failed, apiKey = ");
        r0.append(r7);
        r0.append(", isChunked = ");
        if (r9 == null) goto L8;
        Boolean r1 = Boolean.valueOf(r9.a);
    L9:
        r0.append(r1);
        r0.append(", error = ");
        r0.append(r8.getMessage());
        ECMallLogUtil.b(r12, r0.toString());
        if (Intrinsics.areEqual(r7, "homepage") == false) goto L29;
        if (r9 == null) goto L29;
        if (r9.a != true) goto L29;
        if (this.e == false) goto L28;
        com.bytedance.android.shopping.mall.homepage.tools.l r2 = this.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "apiKey");
        Intrinsics.checkNotNullParameter(r9, "networkVO");
        Intrinsics.checkNotNullParameter(r8, "error");
        r2.getClass();
        ECMallLogUtil.c(r12, "ECHybridChunkedDataProcessor#onError()@" + r2.hashCode() + ", start");
        ((com.bytedance.android.ec.hybrid.data.utils.a) r2).e = r7;
        ((com.bytedance.android.ec.hybrid.data.utils.a) r2).f = r9;
        ((com.bytedance.android.ec.hybrid.data.utils.a) r2).g = r8;
        CopyOnWriteArrayList r4 = ((com.bytedance.android.ec.hybrid.data.utils.a) r2).a;
        monitor-enter(r4);
        ECMallLogUtil.c(r12, "ECHybridChunkedDataProcessor#onError()@" + r2.hashCode() + ", currentDataListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r2).a.size() + ", currentCallbackListSize = " + ((com.bytedance.android.ec.hybrid.data.utils.a) r2).b.size());     // Catch: Throwable -> L25
        Iterator r13 = ((com.bytedance.android.ec.hybrid.data.utils.a) r2).b.iterator();     // Catch: Throwable -> L25
    L20:
        if (r13.hasNext() == false) goto L22;
        ((com.bytedance.android.ec.hybrid.data.utils.a.a) r13.next()).b(r7, r9, r8);     // Catch: Throwable -> L25
        goto L20
    L22:
        ((com.bytedance.android.ec.hybrid.data.utils.a) r2).c = true;     // Catch: Throwable -> L25
        ((com.bytedance.android.ec.hybrid.data.utils.a) r2).d = Boolean.FALSE;     // Catch: Throwable -> L25
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r4);
        Lazy r15 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "ECHybridChunkedDataProcessor#onError()@" + r2.hashCode() + ", end");
        return;
    L25:
        th = move-exception;
        throw th;
    L28:
        return;
    L29:
        ECMallFragment.U90(this.d, r7, r8, this.h);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void f(String r84, String r85, ECHybridNetworkVO r86, boolean r87) {
        Intrinsics.checkNotNullParameter(r84, "apiKey");
        Intrinsics.checkNotNullParameter(r85, "result");
        Intrinsics.checkNotNullParameter(r86, "requestVO");
        ECHybridNetworkTask.a.a.b(r84, r85, r86);
        if (this.d.isAdded() == true) goto L5;
        return;
    L5:
        int r3 = r84.hashCode();
        boolean r5 = false;
        if (r3 == (-1329096418)) goto L46;
        if (r3 == (-615843517)) goto L11;
        return;
    L11:
        if (r84.equals("popup_get") == false) goto L55;
        ECMallFragment r1 = this.d;
        int r4 = ECMallFragment.h4;
        r1.getClass();
        HomePageDTO r2 = (HomePageDTO) new Gson().fromJson(r85, HomePageDTO.class);     // Catch: Exception -> L40
        Gson r6 = new Gson();     // Catch: Exception -> L40
        HomePageBffDTO r7 = r2.getBff();     // Catch: Exception -> L40
        if (r7 == null) goto L18;
        SingleCardData r8 = r7.getPopup();     // Catch: Exception -> L40
        if (r8 == null) goto L18;
        String r9 = r8.getExtra();     // Catch: Exception -> L40
    L19:
        Map r10 = (Map) r6.fromJson(r9, Map.class);     // Catch: Exception -> L40
        if (r10 != null) goto L23;
        return;
    L23:
        if (r10.containsKey("dialog_data_is_valid") == true) goto L25;
        return;
    L25:
        if ((!Intrinsics.areEqual(r10.get("dialog_data_is_valid"), Boolean.TRUE)) == false) goto L27;
        return;
    L27:
        if (r10.containsKey("popup_dialog_optimize_ab") == false) goto L59;
        if ((!Intrinsics.areEqual(r10.get("popup_dialog_optimize_ab"), "1")) == true) goto L67;
        DataEngineWrapper r11 = r1.L0;     // Catch: Exception -> L39
        if (r11 == null) goto L35;
        r11.b = y93.a.a(r11.b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, Long.valueOf(System.currentTimeMillis()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -67108865, -1, -1, 127);     // Catch: Exception -> L39
    L35:
        r1.e.j(r2);     // Catch: Exception -> L39
        DataEngineWrapper r12 = r1.L0;     // Catch: Exception -> L39
        if (r12 == null) goto L60;
        r12.j(System.currentTimeMillis());     // Catch: Exception -> L39
        return;
    L60:
        return;
    L39:
        r5 = true;
        goto L41
    L67:
        return;
    L59:
        return;
    L18:
        r9 = null;
    L41:
        if (r5 == false) goto L61;
        DataEngineWrapper r13 = r1.L0;
        if (r13 == null) goto L62;
        r13.j(System.currentTimeMillis());
        return;
    L62:
        return;
    L61:
        return;
    L55:
        return;
    L46:
        if (r84.equals("marketing_resource_get") == true) goto L48;
        return;
    L48:
        if (this.b == false) goto L65;
        Lazy r14 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.b, "PopupRenderOpt, handle in onPreMainApiSuccess, timestamp = " + System.currentTimeMillis());
        this.b = false;
        this.d.e.l(r85);
        return;
    }

    public ECMallFragment$firstScreenFetch$9(ECMallFragment r1, boolean r2, com.bytedance.android.shopping.mall.homepage.tools.l r3, boolean r4, Function1 r5, int r6, boolean r7) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.b = r7;
    }
}
