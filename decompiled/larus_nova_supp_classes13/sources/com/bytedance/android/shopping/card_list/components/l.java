package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListFirstScreenPoint;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.perf.cache.CardListCacheManager;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Observer<SsResponse<String>> {
    public final /* synthetic */ CardListQueryFetchComponent a;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public l(CardListQueryFetchComponent r1) {
        this.a = r1;
    }

    public final void onError(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        String r0 = r5.getMessage();
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        EnsureManager.ensureNotReachHere(r5);
        r0 = ExceptionsKt.stackTraceToString(r5);
    L11:
        com.bytedance.android.shopping.card_list.monitor.a.a(-1, r0);
        CardListYataMonitorManager r6 = this.a.j();
        if (r6 == null) goto L16;
        com.bytedance.android.shopping.card_list.monitor.error.a r7 = r6.e;
        if (r7 == null) goto L16;
        CardListErrorMonitorType r3 = CardListErrorMonitorType.FIRST_FETCH_RESP_ERROR;
        String r4 = "CardListQueryFetchComponent-".concat(r0);
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r8 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r7.b(r3, r4, null);
    L16:
        CardListYataMonitorManager r9 = this.a.j();
        if (r9 == null) goto L26;
        CacheMonitor r10 = r9.i;
        if (r10 == null) goto L27;
        String r11 = (String) this.a.l.getValue();
        if (r11 == null) goto L24;
        r1 = r11;
    L24:
        CacheMonitor.b(r10, "error", r1);
        return;
    L27:
        return;
    L26:
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final void onNext(Object r7) {
        SsResponse<String> r8 = (SsResponse) r7;
        Intrinsics.checkNotNullParameter(r8, "o");
        Map<String, Map<String, Long>> r0 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(this.a.v.e.i, "DeserializedStart");
        CardListRepository r1 = CardListRepository.INSTANCE;
        CardListQueryFetchComponent r2 = this.a;
        String r3 = r2.j;
        CardListYataMonitorManager r4 = r2.j();
        if (r4 == null) goto L5;
        com.bytedance.android.shopping.card_list.monitor.error.a r5 = r4.e;
    L6:
        com.bytedance.kmp.ec.yata.common.protocol.data.e r6 = r1.transformToDTO(r3, r5, r8);
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(this.a.v.e.i, "DeserializedEnd");
        CardListYataMonitorManager r9 = this.a.j();
        if (r9 == null) goto L11;
        CardListYataFirstScreenDurationMonitor r10 = r9.d;
        if (r10 == null) goto L11;
        CardListYataFirstScreenDurationMonitor.b(r10, CardListFirstScreenPoint.REQUEST_END);
    L11:
        CardListYataMonitorManager r11 = this.a.j();
        if (r11 == null) goto L16;
        CardListYataFirstScreenDurationMonitor r12 = r11.d;
        if (r12 == null) goto L16;
        CardListYataFirstScreenDurationMonitor.b(r12, CardListFirstScreenPoint.RENDER_START);
    L16:
        if (r6 != null) goto L18;
    L20:
        if (r6 != null) goto L22;
    L23:
        String r13 = com.bytedance.android.shopping.card_list.monitor.a.a;
        if (r6 == null) goto L28;
        Integer r14 = r6.a();
        if (r14 == null) goto L28;
        int r15 = r14.intValue();
    L29:
        if (r6 == null) goto L32;
        String r16 = r6.b();
        if (r16 == null) goto L32;
    L33:
        com.bytedance.android.shopping.card_list.monitor.a.a(r15, r16);
        CardListYataMonitorManager r17 = this.a.j();
        if (r17 == null) goto L38;
        com.bytedance.android.shopping.card_list.monitor.error.a r18 = r17.e;
        if (r18 == null) goto L38;
        CardListErrorMonitorType r19 = CardListErrorMonitorType.FIRST_FETCH_RESP_ERROR;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r20 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r18.b(r19, "CardListQueryFetchComponent-response is null or response is Error", null);
    L38:
        CardListYataMonitorManager r21 = this.a.j();
        if (r21 == null) goto L48;
        CacheMonitor r22 = r21.i;
        if (r22 == null) goto L49;
        String r23 = (String) this.a.l.getValue();
        if (r23 != null) goto L45;
        r23 = "";
    L45:
        CacheMonitor.b(r22, "error", r23);
        return;
    L49:
        return;
    L48:
        return;
    L32:
        r16 = "response is null or response is Error";
    L28:
        r15 = -1;
        goto L29
    L22:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.c(r6) == true) goto L23;
        return;
    L18:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r6) != true) goto L20;
        CardListQueryFetchComponent r24 = this.a;
        r24.h(new com.bytedance.android.shopping.card_list.router.d(r24.v.e.i, r6));
        int r25 = CardListCacheManager.j;
        CardListCacheManager.Companion.b(this.a.j, (String) r8.body(), (String) this.a.l.getValue(), this.a.v.f.getBizType(), this.a.v.f.getNeedCacheManager());
        goto L20
    L5:
        r5 = null;
        goto L6
    }
}
