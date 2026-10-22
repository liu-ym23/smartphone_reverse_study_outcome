package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.google.gson.JsonObject;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$3 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$3(b r8) {
        super(1, r8, b.class, "createMusicPlayer", "createMusicPlayer(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        b r0 = (b) ((CallableReference) this).receiver;
        int r1 = b.g;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "createMusicPlayer");
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r3 = r0.c();
        if (r3 == null) goto L5;
        r3.release();
    L5:
        r0.e.j();
        RxUtilKt.c(Single.create(new c(r5)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r0, r5), e.a), r0.b);
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
