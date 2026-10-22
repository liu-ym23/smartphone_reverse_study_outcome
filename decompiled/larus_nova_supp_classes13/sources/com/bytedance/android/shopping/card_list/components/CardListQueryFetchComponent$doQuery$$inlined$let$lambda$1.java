package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListQueryFetchComponent$doQuery$$inlined$let$lambda$1 implements Observer<SsResponse<String>> {
    public final /* synthetic */ long a;
    public final /* synthetic */ CardListQueryFetchComponent b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function0 d;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onError(final Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new AnonymousClass2(this, r2));
    }

    public final void onNext(Object r4) {
        SsResponse<String> r5 = (SsResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "o");
        CardListRepository r0 = CardListRepository.INSTANCE;
        CardListQueryFetchComponent r1 = this.b;
        String r2 = r1.j;
        CardListYataMonitorManager r3 = r1.j();
        if (r3 == null) goto L5;
        com.bytedance.android.shopping.card_list.monitor.error.a r6 = r3.e;
    L6:
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r7 = r0.transformToDTO(r2, r6, r5);
        if (r7 == null) goto L10;
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r8 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new AnonymousClass1(r7, this));
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public CardListQueryFetchComponent$doQuery$$inlined$let$lambda$1(long r1, CardListQueryFetchComponent r3, String r4, Function0 r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
