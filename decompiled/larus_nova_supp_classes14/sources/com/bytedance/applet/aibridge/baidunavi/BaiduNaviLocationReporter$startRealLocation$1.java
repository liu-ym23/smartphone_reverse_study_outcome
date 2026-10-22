package com.bytedance.applet.aibridge.baidunavi;

import com.larus.navigation.api.baidu.BaiduNaviServiceDelegate;
import com.larus.platform.api.h1;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.service.g0;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.baidunavi.BaiduNaviLocationReporter$startRealLocation$1", f = "BaiduNaviLocationReporter.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {299, 308, 313}, m = "invokeSuspend", n = {"fakeLocMgr", "lastReportTime", "fakeLocMgr", "locationFile", "lastReportTime", "fakeLocMgr", "locationFile", "location", "lastReportTime"}, s = {"L$0", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "J$0"})
final class BaiduNaviLocationReporter$startRealLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AbsStartBaiduNavigationIDL.b $params;
    final /* synthetic */ ul9.f $plan;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public BaiduNaviLocationReporter$startRealLocation$1(ul9.f r1, AbsStartBaiduNavigationIDL.b r2, Continuation<? super BaiduNaviLocationReporter$startRealLocation$1> r3) {
        this.$plan = r1;
        this.$params = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BaiduNaviLocationReporter$startRealLocation$1(this.$plan, this.$params, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x0269 -> B:102:0x026b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x023f -> B:85:0x0213). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r28) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        GeoLocationInfo r3 = (GeoLocationInfo) this.L$2;
        File r7 = (File) this.L$1;
        h1 r10 = (h1) this.L$0;
        ResultKt.throwOnFailure(r28);
        BaiduNaviLocationReporter$startRealLocation$1 r4 = this;
        File r5 = r7;
    L102:
        GeoLocationInfo r12 = r3;
        h1 r6 = r10;
    L104:
        Float r11 = e.e;
        BaiduNaviServiceDelegate r13 = BaiduNaviServiceDelegate.b;
        if (tl9.b.a() == false) goto L107;
        FLogger.a.d("bd_loc_reporter", "updateLocation,curSessionId[" + e.b + "];curRouteId[" + e.c + "];[lat,lon,gpsDir][" + r12.getLatitude() + ',' + r12.getLongitude() + ',' + r12.getGpsDir() + "],[" + r11 + "],locationType[" + r12.getLocationType() + ']');
    L108:
        Float r8 = r12.getGpsDir();
        if (r8 != null) goto L111;
        Float r19 = r11;
    L112:
        r13.e(new ul9.c(r19, new ul9.a(r12.getLatitude(), r12.getLongitude(), r12.getAltitude()), (int) r12.getRadius(), r12.getSpeed(), r12.getGpsTime(), r12.getSatelliteCount(), r12.getLocationType()));
        long r14 = System.currentTimeMillis();
    L86:
        if (e.b == null) goto L114;
        if (e.c == null) goto L114;
        long r15 = e.a() - (System.currentTimeMillis() - r14);
        if (r15 <= 0) goto L94;
        r4.L$0 = r6;
        r4.L$1 = r5;
        r4.L$2 = null;
        r4.J$0 = r14;
        r4.label = 2;
        if (DelayKt.delay(r15, r4) != r1) goto L94;
        return r1;
    L94:
        r12 = e.d;
        if (r12 == null) goto L86;
        if (r5 == null) goto L103;
        if (r6 == null) goto L104;
        r12.getLatitude();
        r12.getLongitude();
        r12.getGpsDir();
        r12.getSpeed();
        r12.getRadius();
        r12.getSatelliteCount();
        r4.L$0 = r6;
        r4.L$1 = r5;
        r4.L$2 = r12;
        r4.J$0 = r14;
        r4.label = 3;
        if (r6.d() != r1) goto L101;
        return r1;
    L101:
        r10 = r6;
        r3 = r12;
    L114:
        return Unit.INSTANCE;
    L111:
        r19 = r8;
        goto L112
    L107:
        FLogger.a.i("bd_loc_reporter", "updateLocation,curSessionId[" + e.b + "];curRouteId[" + e.c + "];gpsDir[" + r12.getGpsDir() + "];sensorDir[" + r11 + "];locationType[" + r12.getLocationType() + ']');
        goto L108
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r14 = this.J$0;
        File r9 = (File) this.L$1;
        h1 r16 = (h1) this.L$0;
        ResultKt.throwOnFailure(r28);
        r4 = this;
        r5 = r9;
        r6 = r16;
        goto L94
    L12:
        r14 = this.J$0;
        r6 = (h1) this.L$0;
        ResultKt.throwOnFailure(r28);
        Object r17 = r28;
    L82:
        r5 = (File) r17;
    L84:
        r4 = this;
        goto L86
    L13:
        ResultKt.throwOnFailure(r28);
        r6 = g0.a.d();
        if (r6 != null) goto L16;
    L18:
        boolean r18 = false;
    L19:
        if (r18 == false) goto L83;
        ul9.f r110 = this.$plan;
        if (r110 == null) goto L30;
        List r111 = r110.a();
        if (r111 == null) goto L30;
        ul9.e r112 = (ul9.e) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L30;
        ul9.a r113 = r112.f();
        if (r113 == null) goto L30;
        String r20 = "[][lat:" + r113.b() + "][lng:" + r113.c() + ']';
        if (r20 == null) goto L30;
    L42:
        ul9.f r21 = this.$plan;
        if (r21 == null) goto L52;
        List r22 = r21.a();
        if (r22 == null) goto L52;
        ul9.e r23 = (ul9.e) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L52;
        ul9.a r24 = r23.c();
        if (r24 == null) goto L52;
        String r25 = "[][lat:" + r24.b() + "][lng:" + r24.c() + ']';
        if (r25 == null) goto L52;
    L64:
        StringBuilder r26 = new StringBuilder("\n                    ");
        r26.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        r26.append("\n                    sid:");
        ul9.f r27 = this.$plan;
        if (r27 == null) goto L68;
        String r29 = r27.b();
        if (r29 == null) goto L68;
    L69:
        r26.append(r29);
        r26.append("\n                    rid:");
        ul9.f r30 = this.$plan;
        if (r30 == null) goto L77;
        List r31 = r30.a();
        if (r31 == null) goto L77;
        ul9.e r32 = (ul9.e) CollectionsKt.firstOrNull(r31);
        if (r32 == null) goto L77;
        String r33 = r32.e();
        if (r33 == null) goto L77;
    L78:
        r26.append(r33);
        r26.append("\n                    type:");
        r26.append(this.$params.getRoutePlanType());
        r26.append("\n                    start:");
        r26.append(r20);
        r26.append("\n                    end:");
        r26.append(r25);
        r26.append("\n                ");
        CollectionsKt.listOf(StringsKt.trimIndent(r26.toString()));
        this.L$0 = r6;
        this.J$0 = 0;
        this.label = 1;
        r17 = r6.f();
        if (r17 != r1) goto L81;
        return r1;
    L81:
        r14 = 0;
    L77:
        r33 = this.$params.getRouteId();
    L68:
        r29 = this.$params.getSessionId();
    L52:
        dv3.e r34 = this.$params.getEnd();
        if (r34 == null) goto L63;
        StringBuilder r35 = new StringBuilder("[");
        r35.append(r34.a());
        r35.append("][lat:");
        dv3.b r36 = r34.b();
        if (r36 == null) goto L57;
        Double r37 = Boxing.boxDouble(r36.a());
    L58:
        r35.append(r37);
        r35.append("][lng:");
        dv3.b r38 = r34.b();
        if (r38 == null) goto L61;
        Double r39 = Boxing.boxDouble(r38.b());
    L62:
        r35.append(r39);
        r35.append(']');
        r25 = r35.toString();
        goto L64
    L61:
        r39 = null;
        goto L62
    L57:
        r37 = null;
        goto L58
    L63:
        r25 = null;
    L30:
        dv3.e r40 = this.$params.getStart();
        if (r40 == null) goto L41;
        StringBuilder r41 = new StringBuilder("[");
        r41.append(r40.a());
        r41.append("][lat:");
        dv3.b r114 = r40.b();
        if (r114 == null) goto L35;
        Double r115 = Boxing.boxDouble(r114.a());
    L36:
        r41.append(r115);
        r41.append("][lng:");
        dv3.b r42 = r40.b();
        if (r42 == null) goto L39;
        Double r43 = Boxing.boxDouble(r42.b());
    L40:
        r41.append(r43);
        r41.append(']');
        r20 = r41.toString();
        goto L42
    L39:
        r43 = null;
        goto L40
    L35:
        r115 = null;
        goto L36
    L41:
        r20 = null;
        goto L42
    L83:
        r5 = null;
        r14 = 0;
        goto L84
    L16:
        if (r6.a() != true) goto L18;
        r18 = true;
        goto L19
    }
}
