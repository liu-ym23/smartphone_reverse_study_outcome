package com.bytedance.applet.impl.moa;

import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MoaGrantingNetworkGateway {
    public static final MoaGrantingNetworkGateway a = null;

    static {
        a = new MoaGrantingNetworkGateway();
    }

    public MoaGrantingNetworkGateway() {
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0158 -> B:44:0x015c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x016a -> B:46:0x0170). Please report as a decompilation issue!!! */
    public final Object a(Map<String, ? extends Object> r21, Continuation<? super Boolean> r22) {
        if ((r22 instanceof MoaGrantingNetworkGateway$completeGranting$1) == false) goto L7;
        MoaGrantingNetworkGateway$completeGranting$1 r1 = (MoaGrantingNetworkGateway$completeGranting$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r7 = true;
        ?? r8 = 1;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r5 = r1.I$1;
        int r9 = r1.I$0;
        Ref.LongRef r10 = (Ref.LongRef) r1.L$1;
        Map<String, ? extends Object> r11 = (Map) r1.L$0;
        ResultKt.throwOnFailure(r0);
        int r6 = 2;
    L44:
        r10.element *= (long) r6;
        int r14 = r9;
        int r12 = r5;
        Object r13 = r3;
        MoaGrantingNetworkGateway$completeGranting$1 r15 = r1;
        Ref.LongRef r16 = r10;
    L46:
        int r17 = r12 + 1;
        Map<String, ? extends Object> r18 = r11;
        r7 = true;
    L17:
        if (r17 >= r14) goto L50;
        MoaAskHumanResultApi.a r19 = MoaAskHumanResultApi.a;
        r15.L$0 = r18;
        r15.L$1 = r16;
        r15.I$0 = r14;
        r15.I$1 = r17;
        r15.I$2 = r17;
        r15.label = r7 ? 1 : 0;
        r19.getClass();
        FlowHttpConnection r20 = FlowHttpConnection.a;
        int r110 = r14;
        int r111 = r17;
        Object r23 = FlowHttpConnection.g("MainBot", MoaAskHumanResultApi.class, new MoaAskHumanResultApi$Companion$uploadResult$2(r18, null), true, "/alice/office/tool_local/upload_ask_human_warn_result", null, null, r15, 224);
        if (r23 != r13) goto L21;
        return r13;
    L21:
        Map<String, ? extends Object> r112 = r18;
        Ref.LongRef r113 = r16;
        r1 = r15;
        r3 = r13;
        r0 = r23;
        int r24 = r110;
        int r25 = r111;
        r12 = r25;
        r8 = r7;
    L22:
        dm9.a.b r26 = (dm9.a) r0;
        boolean r114 = r26 instanceof dm9.a.b;
        if (r114 == true) goto L25;
    L27:
        boolean r115 = false;
    L29:
        if (r115 == false) goto L32;
        FLogger.a.i("MoaGrantingNetwork", "upload result succeeded, attempt=" + (r25 + r8));
        return Boxing.boxBoolean(r8);
    L32:
        FLogger r116 = FLogger.a;
        StringBuilder r117 = new StringBuilder("upload result failed, attempt=");
        r117.append(r25 + 1);
        r117.append(", error=");
        if (r114 == false) goto L36;
        StringBuilder r118 = new StringBuilder("biz_error:");
        dm9.a.b r27 = r26;
        r118.append(r27.a.getCode());
        r118.append(':');
        r118.append(r27.a.getMsg());
        String r28 = r118.toString();
    L38:
        r117.append(r28);
        r116.e("MoaGrantingNetwork", r117.toString());
        r6 = 2;
        if (r25 >= 2) goto L45;
        long r29 = r113.element;
        r1.L$0 = r112;
        r1.L$1 = r113;
        r1.I$0 = r24;
        r1.I$1 = r12;
        r1.label = 2;
        if (DelayKt.delay(r29, r1) != r3) goto L43;
        return r3;
    L43:
        r5 = r12;
        r9 = r24;
        r10 = r113;
        r11 = r112;
        goto L44
    L45:
        r13 = r3;
        r14 = r24;
        r15 = r1;
        r16 = r113;
        r11 = r112;
        goto L46
    L36:
        if ((r26 instanceof dm9.a.a) == false) goto L48;
        StringBuilder r30 = new StringBuilder("http_error:");
        dm9.a.a r31 = (dm9.a.a) r26;
        r30.append(r31.a);
        r30.append(':');
        r30.append(r31.b);
        r28 = r30.toString();
        goto L38
    L48:
        throw new NoWhenBranchMatchedException();
    L25:
        if (r26.a.isSuccess() == false) goto L27;
        r115 = true;
        goto L29
    L50:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r25 = r1.I$2;
        r12 = r1.I$1;
        r24 = r1.I$0;
        r113 = (Ref.LongRef) r1.L$1;
        r112 = (Map) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L22
    L16:
        ResultKt.throwOnFailure(r0);
        Ref.LongRef r32 = new Ref.LongRef();
        r32.element = 1000;
        r13 = r3;
        r14 = 3;
        r17 = 0;
        r15 = r1;
        r16 = r32;
        r18 = r21;
    L7:
        r1 = new MoaGrantingNetworkGateway$completeGranting$1(this, r22);
        goto L8
    }
}
