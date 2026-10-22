package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.retrofit2.mime.TypedByteArray;
import io.reactivex.functions.Consumer;
import java.nio.charset.Charset;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ String e;

    public a(Ref.LongRef r1, Ref.IntRef r2, Ref.IntRef r3, JSONObject r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r11) {
        Long r12 = (Long) r11;
        long r0 = this.a.element;
        int r13 = this.b.element;
        int r2 = this.c.element;
        JSONObject r3 = this.d;
        String r4 = this.e;
        String r5 = r3.optString("mission_id");
        AdTaskShopApi r6 = (AdTaskShopApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://aweme.snssdk.com", AdTaskShopApi.class);
        JSONObject r7 = new JSONObject();
        r7.put("msg_type", 10007);     // Catch: JSONException -> L5
        r7.put("mission_id", r5.toString());     // Catch: JSONException -> L5
        r7.put("requirement_id", String.valueOf(r0));     // Catch: JSONException -> L5
        r7.put("update_type", r13);     // Catch: JSONException -> L5
        r7.put("sec_shop_id", r4);     // Catch: JSONException -> L5
        r7.put("duration", r2);     // Catch: JSONException -> L5
    L7:
        Unit r14 = Unit.INSTANCE;
        String r15 = r7.toString();
        Charset r1 = Charsets.UTF_8;
        if (r15 == null) goto L12;
        r6.finishProductScan(1, new TypedByteArray("application/json", r15.getBytes(r1), new String[0])).subscribe();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L7
    }
}
