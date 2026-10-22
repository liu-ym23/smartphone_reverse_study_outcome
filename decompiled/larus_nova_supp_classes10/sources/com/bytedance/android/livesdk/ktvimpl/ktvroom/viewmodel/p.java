package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.GsonHelper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p<T> implements ObservableOnSubscribe {
    public final /* synthetic */ k.d a;
    public final /* synthetic */ com.bytedance.android.live.ktv.common.model.api.e b;

    public p(k.d r1, com.bytedance.android.live.ktv.common.model.api.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<JSONObject> r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        r6.onNext(tv5.a.a(GsonHelper.get(), this.b).put("start_time", this.a.a.i / ((long) 1000)));
    }
}
