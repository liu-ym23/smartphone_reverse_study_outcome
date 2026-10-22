package com.bytedance.android.shopping.yata.frontier;

import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.c;
import com.bytedance.kmp.ec.yata.common.utils.YataThreadExtKt;
import com.google.gson.Gson;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class YataFrontierManager$createConnectAction$1$run$1 implements OnMessageReceiveListener {
    public final /* synthetic */ YataFrontierManager$createConnectAction$1 a;

    public YataFrontierManager$createConnectAction$1$run$1(YataFrontierManager$createConnectAction$1 r1) {
        this.a = r1;
    }

    public final void onReceiveMsg(final WsChannelMsg r5) {
        if (r5 != null) goto L4;
    L38:
        String r6 = YaTaLog.a;
        YaTaLog.c("YataFrontierManager", YataFrontierManager$createConnectAction$1$run$1$onReceiveMsg$1.INSTANCE);
        return;
    L4:
        if (r5.getChannelId() != this.a.a.c.e) goto L38;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(new String(r5.getPayload(), Charsets.UTF_8));     // Catch: Throwable -> L8
    L10:
        Object r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L13;
        r1 = null;
    L13:
        String r3 = (String) r1;
        if (r3 != null) goto L16;
        return;
    L16:
        d r4 = k.a();
        if (r4 == null) goto L40;
        r4.b();
    L40:
        Gson r7 = com.bytedance.kmp.ec.yata.common.platform.k.a;     // Catch: Throwable -> L25
        if (StringsKt.isBlank(r3) == false) goto L22;
        Object r8 = null;
    L23:
        Object r9 = Result.constructor-impl((YataFrontierManager.b) r8);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r9) == true) goto L31;
        r2 = r9;
    L31:
        YataFrontierManager.b r10 = (YataFrontierManager.b) r2;
        if (r10 == null) goto L44;
        final c r11 = r10.a();
        if (r11 == null) goto L45;
        YataThreadExtKt.b(new YataFrontierManager$createConnectAction$1$run$1$onReceiveMsg$2(this, r11, r5));
        return;
    L45:
        return;
    L44:
        return;
    L22:
        r8 = com.bytedance.kmp.ec.yata.common.platform.k.a().fromJson(r3, YataFrontierManager.b.class);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final void onReceiveConnectEvent(final ConnectEvent r3, JSONObject r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.mChannelId == this.a.a.c.e) goto L8;
        String r5 = YaTaLog.a;
        YaTaLog.c("YataFrontierManager", YataFrontierManager$createConnectAction$1$run$1$onReceiveConnectEvent$1.INSTANCE);
        return;
    L8:
        String r6 = YaTaLog.a;
        YaTaLog.c("YataFrontierManager", new YataFrontierManager$createConnectAction$1$run$1$onReceiveConnectEvent$2(r3));
        ConnectionState r7 = this.a.a.b;
        ConnectionState r8 = ConnectionState.CONNECTION_UNKNOWN;
        YataFrontierManager.a(this.a.a, r3.connectionState);
    }
}
