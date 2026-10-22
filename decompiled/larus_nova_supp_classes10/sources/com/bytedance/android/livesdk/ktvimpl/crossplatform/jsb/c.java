package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ JsonObject a;

    public c(JsonObject r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<KtvMusic> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        JsonObject r0 = this.a;
        KtvMusic r1 = null;
        if (r0 == null) goto L7;
        JsonElement r2 = r0.get("music");
        if (r2 == null) goto L7;
        JsonObject r3 = r2.getAsJsonObject();
    L8:
        if (r3 == null) goto L10;
        r1 = (KtvMusic) GsonProtectorUtils.fromJson(new Gson(), r3, KtvMusic.class);
    L10:
        if (r1 == null) goto L13;
        r4.onSuccess(r1);
        return;
    L13:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
