package com.bytedance.android.shopping.card_list.router;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListFirstScreenPoint;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.perf.cache.CardListCacheManager;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "api", "", "netHost", "extraMap", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class CardListKitStarter$queryData$1 extends Lambda implements Function3<String, String, Map<String, ? extends String>, Unit> {
    final /* synthetic */ CardListContainerConfig $cardListContainerConfig;
    final /* synthetic */ CardPassThroughData $passThroughData;
    final /* synthetic */ CardListKitStarter this$0;

    public static final class a implements Observer<SsResponse<String>> {
        public final /* synthetic */ CardListKitStarter$queryData$1 a;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public a(CardListKitStarter$queryData$1 r1) {
            this.a = r1;
        }

        public final void onError(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            CardListKitStarter.a(this.a.this$0, null, r3);
        }

        public final void onNext(Object r12) {
            SsResponse<String> r13 = (SsResponse) r12;
            Intrinsics.checkNotNullParameter(r13, "o");
            Map<String, Map<String, Long>> r0 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
            com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(this.a.this$0.g, "DeserializedStart");
            CardListRepository r1 = CardListRepository.INSTANCE;
            CardListKitStarter r2 = this.a.this$0;
            String r3 = r2.e;
            CardListYataMonitorManager r4 = r2.f;
            LauncherBizType r5 = null;
            if (r4 == null) goto L5;
            com.bytedance.android.shopping.card_list.monitor.error.a r6 = r4.e;
        L6:
            com.bytedance.kmp.ec.yata.common.protocol.data.e r7 = r1.transformToDTO(r3, r6, r13);
            com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(this.a.this$0.g, "DeserializedEnd");
            CardListYataMonitorManager r8 = this.a.this$0.f;
            if (r8 == null) goto L11;
            CardListYataFirstScreenDurationMonitor r9 = r8.d;
            if (r9 == null) goto L11;
            CardListYataFirstScreenDurationMonitor.b(r9, CardListFirstScreenPoint.REQUEST_END);
        L11:
            CardListYataMonitorManager r10 = this.a.this$0.f;
            if (r10 == null) goto L16;
            CardListYataFirstScreenDurationMonitor r11 = r10.d;
            if (r11 == null) goto L16;
            CardListYataFirstScreenDurationMonitor.b(r11, CardListFirstScreenPoint.RENDER_START);
        L16:
            if (r7 != null) goto L18;
        L35:
            if (r7 != null) goto L37;
        L38:
            CardListKitStarter.a(this.a.this$0, r7, new Exception("response is null or response is Error"));
            return;
        L37:
            if (com.bytedance.kmp.ec.yata.common.protocol.data.f.c(r7) == true) goto L38;
            return;
        L18:
            if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r7) != true) goto L35;
            boolean r14 = CardListExtentionsKt.c(this.a.this$0.h, "need_cache_manager", false);
            Integer r15 = CardListExtentionsKt.b(this.a.this$0.h.get("biz_type"));
            if (r15 == null) goto L34;
            int r16 = r15.intValue();
            LauncherBizType[] r17 = LauncherBizType.values();
            int r18 = r17.length;
            int r19 = 0;
        L22:
            if (r19 >= r18) goto L30;
            LauncherBizType r20 = r17[r19];
            if (r20.ordinal() != r16) goto L26;
            boolean r110 = true;
        L27:
            if (r110 == true) goto L28;
            r19 = r19 + 1;
            goto L22
        L28:
            r5 = r20;
            goto L30
        L26:
            r110 = false;
        L30:
            if (r5 == null) goto L33;
            int r21 = CardListCacheManager.j;
            CardListCacheManager.Companion.b(this.a.this$0.e, (String) r13.body(), this.a.this$0.a, r5, r14);
            goto L34
        L33:
            throw new IllegalArgumentException("Invalid enum value: " + r16);
        L34:
            s0.b(new d(this.a.this$0.g, r7));
            goto L35
        L5:
            r6 = null;
            goto L6
        }
    }

    public CardListKitStarter$queryData$1(CardListKitStarter r1, CardPassThroughData r2, CardListContainerConfig r3) {
        this.this$0 = r1;
        this.$passThroughData = r2;
        this.$cardListContainerConfig = r3;
        super(3);
    }

    public final void invoke(String r6, String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r6, "api");
        Intrinsics.checkNotNullParameter(r7, "netHost");
        Intrinsics.checkNotNullParameter(r8, "extraMap");
        CardListRepository r0 = CardListRepository.INSTANCE;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(this.$passThroughData.getSchemaParamsOrCreate());
        r1.putAll(r8);
        Unit r9 = Unit.INSTANCE;
        PackYataSdkConfig r10 = com.bytedance.kmp.ec.yata.common.init.b.a;
        YataPageInfo r11 = this.$cardListContainerConfig.getPageInfo();
        if (r11 == null) goto L5;
        Map r12 = r11.addAndGetYataProtocolInfo();
    L6:
        r0.getQuery(r6, new ab3.b(r1, r12, "1.23.7", 6), r7).subscribeOn(Schedulers.newThread()).subscribe(new a(this));
        return;
    L5:
        r12 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((String) r1, (String) r2, (Map) r3);
        return Unit.INSTANCE;
    }
}
