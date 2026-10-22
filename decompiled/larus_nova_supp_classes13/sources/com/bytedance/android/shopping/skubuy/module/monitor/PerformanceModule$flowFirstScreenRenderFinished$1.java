package com.bytedance.android.shopping.skubuy.module.monitor;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.abscontainer.common_biz.platform.util.a;
import com.bytedance.android.shopping.model.abscontainer.PerformancePointType;
import com.bytedance.android.shopping.model.abscontainer.PrePerformancePointType;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import s33.b;
import w33.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lw33/g;", "Lv43/l;", "STATE", "Lu33/a;", "PROPS", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.skubuy.module.monitor.PerformanceModule$flowFirstScreenRenderFinished$1", f = "PerformanceModule.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class PerformanceModule$flowFirstScreenRenderFinished$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PerformanceModule this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.module.monitor.PerformanceModule$flowFirstScreenRenderFinished$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lw33/g;", "Lv43/l;", "STATE", "Lu33/a;", "PROPS", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.skubuy.module.monitor.PerformanceModule$flowFirstScreenRenderFinished$1$1", f = "PerformanceModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PerformanceModule$flowFirstScreenRenderFinished$1 this$0;

        public AnonymousClass1(PerformanceModule$flowFirstScreenRenderFinished$1 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L101;
            ResultKt.throwOnFailure(r10);
            PerformanceModule r11 = this.this$0.this$0;
            r11.getClass();
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator r1 = ((b) r11).a.c.a.getSchemaModel().recordInfo().entrySet().iterator();
        L5:
            long r3 = 0;
            if (r1.hasNext() == false) goto L12;
            Map.Entry r2 = (Map.Entry) r1.next();
            Long r5 = StringsKt.toLongOrNull(r2.getValue().toString());
            if (r5 == null) goto L5;
            if (r5.longValue() <= 0) goto L5;
            r0.put(r2.getKey(), r5);
            goto L5
        L12:
            d r4 = (d) ((b) r11).a.b.b.a;
            if (r4 != null) goto L15;
        L44:
            Map r12 = (Map) ((b) r11).a.b.c.a;
            String r6 = null;
            if (r12 == null) goto L47;
            Object r13 = r12.get("biz_compose_query_cj_passthrough_duration");
        L49:
            if ((r13 instanceof Long) == true) goto L51;
            r13 = null;
        L51:
            Long r14 = (Long) r13;
            if (r14 == null) goto L54;
            r0.put("biz_compose_query_cj_passthrough_duration", r14);
        L54:
            PerformanceModule r15 = this.this$0.this$0;
            r15.getClass();
            PrePerformancePointType r7 = PrePerformancePointType.PAGE_INIT;
            if (r0.get(r7.getValue()) != null) goto L59;
            Long r8 = (Long) r0.get(PerformancePointType.C_PAGE_START.getValue());
            if (r8 == null) goto L59;
            r0.put(r7.getValue(), Long.valueOf(r8.longValue()));
        L59:
            PerformancePointType[] r9 = PerformancePointType.values();
            int r16 = r9.length;
            int r17 = 0;
        L60:
            if (r17 >= r16) goto L65;
            PerformancePointType r18 = r9[r17];
            if (r0.containsKey(r18.getValue()) == false) goto L63;
            r17 = r17 + 1;
            goto L60
        L63:
            r6 = r18.getValue();
        L79:
            if ((!a2.b(r6)) == false) goto L99;
            LinkedHashMap r19 = new LinkedHashMap();
            int r20 = a.a;
            HttpRequestInfo r21 = this.this$0.this$0.e;
            Long r22 = (Long) r0.get(PerformancePointType.FETCH_START.getValue());
            if (r22 == null) goto L83;
            r22.longValue();
        L83:
            Long r23 = (Long) r0.get(PerformancePointType.FETCH_END.getValue());
            if (r23 == null) goto L86;
            r3 = r23.longValue();
        L86:
            Long r24 = (Long) r0.get(PerformancePointType.PARSE_RESPONSE_END.getValue());
            if (r24 == null) goto L89;
            r24.longValue();
        L89:
            Iterator r25 = ((LinkedHashMap) a.a(r21, r3)).entrySet().iterator();
        L91:
            if (r25.hasNext() == false) goto L93;
            Map.Entry r26 = (Map.Entry) r25.next();
            r19.put(r26.getKey(), r26.getValue());
            goto L91
        L93:
            Iterator r27 = r0.entrySet().iterator();
        L95:
            if (r27.hasNext() == false) goto L97;
            Map.Entry r28 = (Map.Entry) r27.next();
            r19.put(r28.getKey(), r28.getValue());
            goto L95
        L97:
            r19.putAll(this.this$0.this$0.c);
            r19.put("api_path", "/order/component/confirmOrder/");
            ((b) this.this$0.this$0).a.d.a().a("ies_ecommerce_fe_custom_log", r19);
        L99:
            return Unit.INSTANCE;
        L65:
            Long r29 = (Long) r0.get(PerformancePointType.INTERACTIVE.getValue());
            if (r29 == null) goto L68;
            long r30 = r29.longValue();
        L69:
            Long r31 = (Long) r0.get(PerformancePointType.C_PAGE_START.getValue());
            if (r31 == null) goto L72;
            long r32 = r31.longValue();
        L73:
            long r33 = r30 - r32;
            if (r33 <= r15.d) goto L76;
        L77:
            r6 = "timeout";
            goto L79
        L76:
            if (r33 != 0) goto L79;
        L72:
            r32 = 0;
            goto L73
        L68:
            r30 = 0;
            goto L69
        L47:
            r13 = null;
            goto L49
        L15:
            if (r4.a == null) goto L18;
            r0.put(PerformancePointType.INNER_START.getValue(), r4.a);
        L18:
            if (r4.e == null) goto L23;
            if (r4.f == null) goto L23;
            r0.put(PerformancePointType.QUERY_PARAM_START.getValue(), r4.e);
            r0.put(PerformancePointType.QUERY_PARAM_END.getValue(), r4.f);
            r0.put(PerformancePointType.FETCH_START.getValue(), r4.f);
        L23:
            if (r4.b == null) goto L28;
            if (r4.c == null) goto L28;
            r0.put(PerformancePointType.REQUEST_START.getValue(), r4.b);
            r0.put(PerformancePointType.REQUEST_END.getValue(), r4.c);
            r0.put(PerformancePointType.FETCH_END.getValue(), r4.c);
            r0.put(PerformancePointType.RENDER_START.getValue(), r4.c);
        L28:
            if (r4.j == null) goto L33;
            if (r4.k == null) goto L33;
            r0.put(PerformancePointType.PARSE_RESPONSE_START.getValue(), r4.j);
            r0.put(PerformancePointType.PARSE_RESPONSE_END.getValue(), r4.k);
        L33:
            if (r4.d == null) goto L36;
            r0.put(PerformancePointType.CONTAINER_INIT_START.getValue(), r4.d);
        L36:
            if (r4.h == null) goto L39;
            r0.put(PerformancePointType.T_PAGE_START.getValue(), r4.h);
        L39:
            if (r4.g == null) goto L42;
            r0.put(PerformancePointType.YATA_RENDER_START.getValue(), r4.g);
        L42:
            if (r4.i == null) goto L44;
            r0.put(PerformancePointType.YATA_RENDER_END.getValue(), r4.i);
            r0.put(PerformancePointType.RENDER_END.getValue(), r4.i);
            r0.put(PerformancePointType.INTERACTIVE.getValue(), r4.i);
            goto L44
        L101:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PerformanceModule$flowFirstScreenRenderFinished$1(PerformanceModule r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new PerformanceModule$flowFirstScreenRenderFinished$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r6 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this, null);
        this.label = 1;
        if (BuildersKt.withContext(r6, r2, this) != r0) goto L12;
        return r0;
    }
}
