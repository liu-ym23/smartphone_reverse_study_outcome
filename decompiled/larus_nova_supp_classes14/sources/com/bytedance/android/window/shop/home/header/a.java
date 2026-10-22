package com.bytedance.android.window.shop.home.header;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ JSONObject a;

    public a(JSONObject r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<k> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        ECHybridListDTO r0 = (ECHybridListDTO) u0.b(this.a.toString(), ECHybridListDTO.class);     // Catch: Exception -> L5
        r3.onNext(ECHybridListDTO.a.e(ECHybridListDTO.Companion, r0));     // Catch: Exception -> L5
    L7:
        r3.onComplete();
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r3.onError(e);
        goto L7
    }
}
