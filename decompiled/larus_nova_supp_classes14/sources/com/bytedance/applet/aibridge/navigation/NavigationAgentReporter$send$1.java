package com.bytedance.applet.aibridge.navigation;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.CommonApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.navigation.NavigationAgentReporter$send$1", f = "NavigationAgentReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NavigationAgentReporter$send$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $body;
    final /* synthetic */ String $event;
    int label;

    public NavigationAgentReporter$send$1(String r1, String r2, Continuation<? super NavigationAgentReporter$send$1> r3) {
        this.$event = r1;
        this.$body = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NavigationAgentReporter$send$1(this.$event, this.$body, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L64;
        ResultKt.throwOnFailure(r26);
        String r2 = this.$body;
        String r11 = this.$event;
        int r13 = 0;
        String r0 = null;
        int r14 = 0;
    L6:
        if (r14 >= 2) goto L61;
        long r3 = System.currentTimeMillis();
        SsResponse r7 = ((CommonApi) FlowHttpConnection.c(FlowHttpConnection.a, "Basic", CommonApi.class, null, null, null, 28)).doPost("https://mp.oceancloudapi.com/api/doubao/do_action_v2", null, new TypedByteArray("application/json", r2.getBytes(Charsets.UTF_8), new String[r13]), MapsKt.emptyMap(), null).execute();     // Catch: Exception -> L48
        if (r7 == null) goto L11;
        String r8 = (String) r7.body();     // Catch: Exception -> L48
    L12:
        if (r8 != null) goto L14;
        long r15 = -1;
    L17:
        if (r8 != null) goto L19;
    L30:
        boolean r9 = false;
    L31:
        if (r9 == false) goto L33;
        boolean r16 = r9;
        long r10 = 0;
        String r12 = null;
    L52:
        CoroutineScope r5 = NavigationAgentReporter.a;
        long r6 = System.currentTimeMillis() - r3;
        if (r14 <= 0) goto L55;
        boolean r17 = true;
    L56:
        NavigationAgentReporter.a(r11, r16, r6, r10, r12, r17);
        if (r16 == true) goto L58;
        r14 = r14 + 1;
        r13 = 0;
        goto L6
    L58:
        int r1 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_agent_report", "send ok: event=" + r11 + " attempt=" + (r14 + 1));
        return Unit.INSTANCE;
    L55:
        r17 = false;
        goto L56
    L33:
        if (r15 == (-1)) goto L35;
        long r18 = r15;
    L65:
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L37
        r4.append("biz_fail: http=");     // Catch: Exception -> L37
        if (r7 == null) goto L44;
        Integer r19 = Boxing.boxInt(r7.code());     // Catch: Exception -> L37
    L45:
        r4.append(r19);     // Catch: Exception -> L37
        r4.append(" code=");     // Catch: Exception -> L37
        r4.append(r15);     // Catch: Exception -> L37
        r0 = r4.toString();     // Catch: Exception -> L37
        r12 = r0;
        r16 = r9;
        r10 = r18;
        goto L52
    L44:
        r19 = null;
    L37:
        e = e;
    L51:
        r0 = "request_failed: type=".concat(e.getClass().getSimpleName());
        r12 = r0;
        r16 = r9;
        r10 = -1;
        goto L52
    L35:
        if (r7 == null) goto L39;
        int r20 = r7.code();     // Catch: Exception -> L37
    L40:
        r18 = r20;
        goto L65
    L39:
        r20 = -1;
        goto L40
    L19:
        if (r15 != 0) goto L30;
        JSONObject r21 = new JSONObject(r8).optJSONObject("data");     // Catch: Exception -> L28
        if (r21 == null) goto L25;
        if (r21.optBoolean("success") != true) goto L25;
        boolean r22 = true;
    L26:
        if (r22 == false) goto L30;
        r9 = true;
    L25:
        r22 = false;
    L28:
        e = e;
    L50:
        r9 = false;
        goto L51
    L14:
        r15 = new JSONObject(r8).optLong("code", -1);     // Catch: Exception -> L48
        goto L17
    L11:
        r8 = null;
    L48:
        e = e;
        r14 = r14;
        goto L50
    L61:
        int r23 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.b("nav_agent_report", "send failed after 2 attempts: event=" + this.$event + " err=" + r0);
        return Unit.INSTANCE;
    L64:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
