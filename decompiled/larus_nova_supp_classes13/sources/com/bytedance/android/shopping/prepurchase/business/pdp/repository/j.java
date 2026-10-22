package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ PdpDataFetchService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function1 c;

    public j(PdpDataFetchService r1, long r2, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r6) {
        PackResponseDTO r7 = (PackResponseDTO) r6;
        if (this.b == this.a.w.get()) goto L6;
        return;
    L6:
        if (r7.getStatusCode() == 17) goto L11;
        this.a.onGetPack(r7, true);
        Function1 r8 = this.c;
        if (r8 == null) goto L12;
        Unit r9 = (Unit) r8.invoke(PDPRefreshStatus.SUCCESS);
        return;
    L12:
        return;
    }
}
