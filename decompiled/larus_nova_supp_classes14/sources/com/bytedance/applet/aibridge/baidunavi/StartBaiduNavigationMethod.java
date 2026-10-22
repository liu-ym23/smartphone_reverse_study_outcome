package com.bytedance.applet.aibridge.baidunavi;

import android.os.SystemClock;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.baidunavi.bean.NavigationVerbalMode;
import com.bytedance.applet.task.p;
import com.larus.common.apphost.AppHost;
import com.larus.navigation.api.baidu.BaiduNaviServiceDelegate;
import com.larus.platform.api.h1;
import com.larus.platform.api.p1;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.service.g0;
import com.larus.platform.service.m;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.trace.RealTimeNavErrorMsg;
import com.larus.trace.RealTimeNavErrorType;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import com.larus.utils.logger.FLogger;
import hq9.z2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0007*\u0001 \u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0082@¢\u0006\u0002\u0010\u000eJV\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J+\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0005R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006&"}, d2 = {"Lcom/bytedance/applet/aibridge/baidunavi/StartBaiduNavigationMethod;", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL$StartNavigationParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL$StartNavigationResult;", "doHandle", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Lcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL$StartNavigationParam;Lcom/bytedance/ai/bridge/core/CompletionBlock;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doStartNavigation", "routePlanType", "", "sessionId", "", "routeId", "plan", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviRoutePlan;", "guidanceRange", "Lkotlin/Pair;", "", "toJSBResult", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationResult;", "timeBeforeRoute", "", "Ljava/lang/Long;", "toBaiduNaviCallback", "com/bytedance/applet/aibridge/baidunavi/StartBaiduNavigationMethod$toBaiduNaviCallback$1", "complete", "(FLcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL$StartNavigationParam;Lcom/bytedance/ai/bridge/core/CompletionBlock;)Lcom/bytedance/applet/aibridge/baidunavi/StartBaiduNavigationMethod$toBaiduNaviCallback$1;", "sendOpenBaiduNaviPageDemand", "Companion", "BaiduNaviNotificationCallbackImpl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartBaiduNavigationMethod extends AbsStartBaiduNavigationIDL {
    public static final AtomicBoolean c = null;
    public static Pair<Integer, Integer> d;
    public static boolean e;
    public Long b;

    public final class BaiduNaviNotificationCallbackImpl implements tl9.c {
        public final /* synthetic */ StartBaiduNavigationMethod a;

        public final void a() {
            String r0 = p.a;
            p.c();
        }

        public final void onClick() {
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new StartBaiduNavigationMethod$BaiduNaviNotificationCallbackImpl$onClick$1(this.a, null), 3, null);
        }

        public BaiduNaviNotificationCallbackImpl(StartBaiduNavigationMethod r1) {
            this.a = r1;
        }

        public final void c(int r4, JSONObject r5) {
            if (r4 != 0) goto L4;
            RealTimeNavErrorMsg r6 = RealTimeNavErrorMsg.PUSH_IC_DOWNLOAD_ERROR;
        L8:
            String r0 = ev3.a.a;
            ev3.a.c(RealTimeNavErrorType.PUSH, r6, null, r5, 4);
            return;
        L4:
            if (r4 == 1) goto L6;
            return;
        L6:
            r6 = RealTimeNavErrorMsg.PUSH_BUILD_ERROR;
            goto L8
        }

        public final void b(String r2, String r3, Integer r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "title");
            String r0 = p.a;
            p.b(r2, r3, r4, r5);
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.baidunavi.StartBaiduNavigationMethod$handle$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.aibridge.baidunavi.StartBaiduNavigationMethod$handle$3", f = "StartBaiduNavigationMethod.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e3.d $bridgeContext;
        final /* synthetic */ f3.h<AbsStartBaiduNavigationIDL.c> $callback;
        final /* synthetic */ AbsStartBaiduNavigationIDL.b $params;
        int label;
        final /* synthetic */ StartBaiduNavigationMethod this$0;

        public AnonymousClass3(StartBaiduNavigationMethod r1, e3.d r2, AbsStartBaiduNavigationIDL.b r3, f3.h<AbsStartBaiduNavigationIDL.c> r4, Continuation<? super AnonymousClass3> r5) {
            this.this$0 = r1;
            this.$bridgeContext = r2;
            this.$params = r3;
            this.$callback = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass3(this.this$0, this.$bridgeContext, this.$params, this.$callback, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
            StartBaiduNavigationMethod r6 = this.this$0;
            AbsStartBaiduNavigationIDL.b r2 = this.$params;
            f3.h<AbsStartBaiduNavigationIDL.c> r3 = this.$callback;
            this.label = 1;
            if (StartBaiduNavigationMethod.b(r6, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        c = new AtomicBoolean(false);
    }

    public StartBaiduNavigationMethod() {
    }

    public final void handle(final e3.d r11, ParamModel r12, final f3.h r13) {
        final AbsStartBaiduNavigationIDL.b r14 = (AbsStartBaiduNavigationIDL.b) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        NavigationCallback r1 = NavigationCallback.l;
        if (r1 != null) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r4 == false) goto L19;
        if (r1 == null) goto L12;
        r1.c = false;
    L12:
        e.b("new_nav");
        BaiduNaviServiceDelegate.b.a("new_nav");
        String r2 = ev3.a.a;
        String r3 = r14.getNavigateUniqueId();
        Intrinsics.checkNotNullParameter("new_nav_unique_id", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (ev3.a.i != null) goto L15;
        ev3.a.i = new JSONObject();
    L15:
        JSONObject r5 = ev3.a.i;
        if (r5 == null) goto L18;
        r5.put("new_nav_unique_id", r3);
    L18:
        ev3.a.b(RealTimeNavEndReason.NEW_NAV, null, 2);
    L19:
        String r6 = ev3.a.a;
        ev3.a.a = null;
        ev3.a.c = null;
        ev3.a.d = null;
        ev3.a.e = null;
        ev3.a.f = null;
        ev3.a.g = null;
        ev3.a.h = null;
        ev3.a.i = null;
        ev3.a.b = Long.valueOf(SystemClock.elapsedRealtime());
        ev3.a.a = r14.getNavigateUniqueId();
        BaiduNaviServiceDelegate r7 = BaiduNaviServiceDelegate.b;
        if (c.compareAndSet(false, true) == false) goto L23;
        long r8 = SystemClock.elapsedRealtime();
        r7.d(AppHost.a.getApplication(), tl9.b.a());
        ev3.a.c = Long.valueOf(SystemClock.elapsedRealtime() - r8);
        NavigationCallback r9 = new NavigationCallback();
        Intrinsics.checkNotNullParameter(r9, "callback");
        NavigationCallback.l = r9;
        r7.f(r9);
    L23:
        if (e == true) goto L25;
        final long r10 = SystemClock.elapsedRealtime();
        r7.i(new i(r10, r13, this, r11, r14));
        return;
    L25:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass3(this, r11, r14, r13, null), 3, null);
        return;
    L5:
        if (r1.b != true) goto L7;
        r4 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object b(StartBaiduNavigationMethod r31, AbsStartBaiduNavigationIDL.b r32, f3.h r33, Continuation r34) {
        r31.getClass();
        if ((r34 instanceof StartBaiduNavigationMethod$doHandle$1) == false) goto L7;
        StartBaiduNavigationMethod$doHandle$1 r2 = (StartBaiduNavigationMethod$doHandle$1) r34;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        f3.h r0 = (f3.h) r2.L$1;
        AbsStartBaiduNavigationIDL.b r6 = (AbsStartBaiduNavigationIDL.b) r2.L$0;
        ResultKt.throwOnFailure(r1);
        f3.h r7 = r0;
        AbsStartBaiduNavigationIDL.b r8 = r6;
    L27:
        String r9 = r8.getSessionId();
        String r10 = r8.getRouteId();
        Float r12 = r8.getRoutePlanType();
        String r11 = null;
        if (r12 != null) goto L30;
        FLogger.a.e("js_bd_navi_start", "start no planType", new RuntimeException());
        String r13 = ev3.a.a;
        ev3.a.a("error", "no_planType");
        ev3.a.d(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.PARAMS_ERROR, null, 4);
        f3.h.a.a(r7, "no_planType", null, null, 14);
        return Unit.INSTANCE;
    L30:
        Float r14 = r8.getRoutePlanType();
        if (Intrinsics.areEqual(r14, 1.0f) == false) goto L34;
        Pair<Integer, Integer> r15 = TuplesKt.to(Boxing.boxInt(-10), Boxing.boxInt(20));
    L37:
        d = r15;
        NavigationCallback.Companion r16 = NavigationCallback.k;
        Intrinsics.checkNotNullParameter(r15, "range");
        NavigationCallback.o = r15;
        if (r9 != null) goto L40;
    L43:
        boolean r17 = true;
    L44:
        if (r17 == true) goto L53;
        if (r10 != null) goto L47;
    L50:
        boolean r18 = true;
    L51:
        if (r18 == true) goto L53;
        r31.c(r12.floatValue(), r9, r10, r8, null, r15, r7);
        return Unit.INSTANCE;
    L47:
        if (r10.length() == 0) goto L50;
        r18 = false;
    L53:
        dv3.e r19 = r8.getStart();
        dv3.e r110 = r8.getEnd();
        if (r19 == null) goto L56;
        dv3.b r20 = r19.b();
    L57:
        if (r20 != null) goto L73;
        if (r110 == null) goto L60;
        dv3.b r21 = r110.b();
    L61:
        if (r21 == null) goto L73;
        Ref.BooleanRef r22 = new Ref.BooleanRef();
        r22.element = true;
        FLogger r111 = FLogger.a;
        r111.i("js_bd_navi_start", "try to get the start from continuous locating for route plan");
        JSONObject r23 = new JSONObject();
        r23.put("navigate_unique_id", r8.getNavigateUniqueId());
        long r24 = SystemClock.elapsedRealtime();
        Lazy r25 = e.a;
        j r112 = new j(r22, r24, r7, r110, r12, r8, r15, r31);
        Intrinsics.checkNotNullParameter(r23, "locateExtra");
        e.m = r112;
        if (e.i == false) goto L66;
        r111.i("bd_loc_reporter", "startLocationOnly, but fully locating started. stopLocation first");
        e.b("startLocationOnly");
    L66:
        if (e.g == false) goto L68;
        r111.i("bd_loc_reporter", "startLocationOnly, but location already started. stopLocationOnly first");
        e.c();
    L68:
        m r26 = m.a;
        p1 r113 = m.i();
        if (r113 != null) goto L71;
        r111.i("bd_loc_reporter", "startLocationOnly, locationService is null");
    L108:
        return Unit.INSTANCE;
    L71:
        e.g = true;
        e.j = 0;
        com.larus.platform.service.g.a.c();
        r113.g(e.a(), CoordinateType.GCJ_O2, r23, (z2) e.k.getValue());
        e.h = Long.valueOf(System.currentTimeMillis());
        r111.i("bd_loc_reporter", "startLocationOnly done");
        goto L108
    L60:
        r21 = null;
    L73:
        if (r19 == null) goto L104;
        if (r110 == null) goto L104;
        dv3.b r27 = r19.b();
        dv3.b r114 = r110.b();
        if (r27 == null) goto L103;
        if (r114 == null) goto L103;
        ul9.a r28 = new ul9.a(r27.a(), r27.b(), 0.0d);
        ul9.a r115 = new ul9.a(r114.a(), r114.b(), 0.0d);
        int r29 = (int) r12.floatValue();
        Integer r30 = r8.getRidingRoutePrefer();
        if (r30 != null) goto L85;
        r30 = r8.getDrivingRoutePrefer();
        if (r30 != null) goto L85;
        int r116 = 0;
    L87:
        Integer r35 = r8.getVerbalMode();
        if (r35 == null) goto L101;
        NavigationVerbalMode.a r117 = NavigationVerbalMode.Companion;
        int r36 = r35.intValue();
        r117.getClass();
        if (r36 == 0) goto L97;
        if (r36 != 1) goto L93;
        r11 = "simple_v2";
    L98:
        if (r11 == null) goto L101;
        String r210 = r11;
    L102:
        ul9.g r37 = new ul9.g(r28, r115, r29, r116, r210, r15, r19.c(), r19.a(), r110.c(), r110.a());
        r31.b = Boxing.boxLong(SystemClock.elapsedRealtime());
        BaiduNaviServiceDelegate.b.j(r37, new k(r31, r12.floatValue(), r8, r7));
        return Unit.INSTANCE;
    L93:
        if (r36 != 2) goto L98;
        r11 = "standard";
        goto L98
    L97:
        r11 = "simple";
    L101:
        r210 = "standard";
    L85:
        r116 = r30.intValue();
    L103:
        FLogger.a.e("js_bd_navi_start", "start no points2");
        String r38 = ev3.a.a;
        ev3.a.a("error", "invalid_params_1");
        ev3.a.d(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.PARAMS_ERROR, null, 4);
        f3.h.a.a(r7, "invalid_params_1;[" + r19 + "][" + r110 + ']', null, null, 14);
        return Unit.INSTANCE;
    L104:
        FLogger.a.e("js_bd_navi_start", "start no points");
        String r39 = ev3.a.a;
        ev3.a.a("error", "invalid_params_0");
        ev3.a.d(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.PARAMS_ERROR, null, 4);
        f3.h.a.a(r7, "invalid_params_0", null, null, 14);
        return Unit.INSTANCE;
    L56:
        r20 = null;
        goto L57
    L40:
        if (r9.length() == 0) goto L43;
        r17 = false;
        goto L44
    L34:
        if (Intrinsics.areEqual(r14, 2.0f) == false) goto L36;
        r15 = TuplesKt.to(Boxing.boxInt(-20), Boxing.boxInt(50));
        goto L37
    L36:
        r15 = TuplesKt.to(Boxing.boxInt(-5), Boxing.boxInt(5));
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (tl9.b.a() == false) goto L17;
        FLogger r40 = FLogger.a;
        r40.d("js_bd_navi_start", "[startWithParam]:start[" + r32.getStart() + ']');
        r40.d("js_bd_navi_start", "[startWithParam]:end[" + r32.getEnd() + ']');
    L17:
        FLogger r41 = FLogger.a;
        r41.i("js_bd_navi_start", "[startWithParam]:sessionId[" + r32.getSessionId() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:routeId[" + r32.getRouteId() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:routePlanType[" + r32.getRoutePlanType() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:botId[" + r32.getBotId() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:conversationId[" + r32.getConversationId() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:styleId[" + r32.getStyleId() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:drivingRoutePrefer[" + r32.getDrivingRoutePrefer() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:ridingRoutePrefer[" + r32.getRidingRoutePrefer() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:ridingType[" + r32.getRidingType() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:verbalMode[" + r32.getVerbalMode() + ']');
        r41.i("js_bd_navi_start", "[startWithParam]:navigateUniqueId[" + r32.getNavigateUniqueId() + ']');
        if (Intrinsics.areEqual(r32.isQuickRestart(), Boxing.boxBoolean(true)) == false) goto L20;
        r41.i("navi_callback", "flow.startNavigation isQuickRestart");
    L23:
        BaiduNaviServiceDelegate r42 = BaiduNaviServiceDelegate.b;
        NavigationCallback.Companion r43 = NavigationCallback.k;
        r2.L$0 = r32;
        r2.L$1 = r33;
        r2.label = 1;
        if (r43.a(r32, r2) == r4) goto L111;
        r8 = r32;
        r7 = r33;
        goto L27
    L111:
        return r4;
    L20:
        NavigationCallback r44 = NavigationCallback.l;
        if (r44 == null) goto L23;
        r44.c = false;
    L7:
        r2 = new StartBaiduNavigationMethod$doHandle$1(r31, r34);
        goto L8
    }

    public final void c(float r36, String r37, String r38, AbsStartBaiduNavigationIDL.b r39, ul9.f r40, Pair<Integer, Integer> r41, f3.h<AbsStartBaiduNavigationIDL.c> r42) {
        String r12 = "js_bd_navi_start";
        FLogger.a.i("js_bd_navi_start", "start with ids: [" + r38 + ']');
        BaiduNaviServiceDelegate r0 = BaiduNaviServiceDelegate.b;
        r0.g(new BaiduNaviNotificationCallbackImpl(this));
        r0.k(r37, (int) r36, r38, r41, true, null);
        String r1 = ev3.a.a;
        ev3.a.d(RealTimeNavStartResult.SUCCESS, null, null, 6);
        Intrinsics.checkNotNullParameter(AbsStartBaiduNavigationIDL.c.class, "<this>");
        AbsStartBaiduNavigationIDL.c r2 = k3.c.a(AbsStartBaiduNavigationIDL.c.class);
        AbsStartBaiduNavigationIDL.c r3 = r2;
        r3.setMessage(null);
        r3.setStatus(0);
        String r4 = "";
        if (r40 == null) goto L95;
        Integer r15 = r40.c();
        String r16 = r40.b();
        List r6 = r40.a();
        if (r6 == null) goto L93;
        List r7 = r6;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r5 = r7.iterator();
    L8:
        if (r5.hasNext() == false) goto L92;
        ul9.e r8 = (ul9.e) r5.next();
        if (r8 == null) goto L12;
        ul9.a r17 = r8.f();
    L13:
        if (r8 == null) goto L15;
        ul9.a r18 = r8.c();
    L16:
        if (r8 == null) goto L18;
        String r21 = r8.e();
    L19:
        if (r17 != null) goto L21;
        dv3.b r22 = null;
    L22:
        if (r18 != null) goto L24;
        dv3.b r23 = null;
    L25:
        if (r8 == 0) goto L27;
        int r24 = r8.a();
    L28:
        if (r8 == 0) goto L30;
        int r25 = r8.b();
    L31:
        if (r8 == 0) goto L43;
        List r9 = r8.g();
        if (r9 == null) goto L43;
        List r10 = r9;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r13 = r10.iterator();
    L36:
        if (r13.hasNext() == false) goto L42;
        ul9.h r19 = (ul9.h) r13.next();
        if (r19 == null) goto L40;
        String r20 = r19.b();
    L41:
        r11.add(new dv3.f(r20));
        goto L36
    L40:
        r20 = null;
        goto L41
    L42:
        ArrayList r26 = r11;
    L44:
        if (r8 == 0) goto L46;
        String r27 = r8.h();
    L47:
        if (r8 == 0) goto L90;
        List r28 = r8.g();
        if (r28 == null) goto L90;
        ul9.h r29 = (ul9.h) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L90;
        ul9.d r30 = r29.a();
        if (r30 == null) goto L90;
        List r31 = r30.b();
        if (r31 == null) goto L90;
        List r32 = r31;
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        Iterator r34 = r32.iterator();
    L58:
        if (r34.hasNext() == false) goto L89;
        vl9.d r35 = (vl9.d) r34.next();
        if (r35 == null) goto L62;
        ul9.a r110 = r35.c();
    L64:
        if (r35 == null) goto L66;
        Integer r43 = Integer.valueOf(r35.b());
    L67:
        if (r35 == null) goto L69;
        Integer r44 = Integer.valueOf(r35.a());
    L70:
        double r210 = 0.0d;
        if (r110 == null) goto L73;
        double r111 = r110.c();
    L74:
        if (r110 == null) goto L76;
        r210 = r110.b();
    L76:
        dv3.b r45 = new dv3.b(r111, r210);
        if (r35 == null) goto L81;
        vl9.a r112 = r35.d();
        if (r112 == null) goto L81;
        int r113 = r112.a();
    L82:
        if (r35 == null) goto L87;
        vl9.a r46 = r35.d();
        if (r46 == null) goto L87;
        String r47 = r46.b();
        if (r47 == null) goto L87;
    L88:
        r33.add(new dv3.h(r43, r44, r45, new dv3.g(r113, r47)));
        r5 = r5;
        r34 = r34;
        r12 = r12;
    L87:
        r47 = r4;
    L81:
        r113 = 1;
        goto L82
    L73:
        r111 = 0.0d;
        goto L74
    L69:
        r44 = null;
        goto L70
    L66:
        r43 = null;
        goto L67
    L62:
        r110 = null;
        goto L64
    L89:
        Iterator r114 = r5;
        String r310 = r12;
        ArrayList r211 = r33;
    L91:
        r14.add(new dv3.d(r21, r22, r23, r24, r25, r26, r27, r211, 96));
        r5 = r114;
        r4 = r4;
        r12 = r310;
    L90:
        r114 = r5;
        r310 = r12;
        r211 = null;
        goto L91
    L46:
        r27 = null;
    L43:
        r26 = null;
        goto L44
    L30:
        r25 = 0;
        goto L31
    L27:
        r24 = 0;
        goto L28
    L24:
        r23 = new dv3.b(r18.c(), r18.b());
        goto L25
    L21:
        r22 = new dv3.b(r17.c(), r17.b());
        goto L22
    L18:
        r21 = null;
        goto L19
    L15:
        r18 = null;
        goto L16
    L12:
        r17 = null;
        goto L13
    L92:
        String r311 = r4;
        String r312 = r12;
        ArrayList r115 = r14;
    L94:
        dv3.c r48 = new dv3.c(r15, r16, null, null, r115);
    L96:
        r3.setResult(r48);
        r42.b(r2, r311);
        FLogger r49 = FLogger.a;
        r49.i(r312, "[" + r38 + "]startLocation");
        JSONObject r50 = new JSONObject();
        r50.put("navigate_unique_id", r39.getNavigateUniqueId());
        Lazy r51 = e.a;
        Intrinsics.checkNotNullParameter(r37, "sessionId");
        Intrinsics.checkNotNullParameter(r38, "routeId");
        Intrinsics.checkNotNullParameter(r39, "params");
        Intrinsics.checkNotNullParameter(r50, "locateExtra");
        e.i = true;
        r49.e("bd_loc_reporter", "startLocation:routeId[" + r38 + "]<-[" + e.c + "];sessionId[" + r37 + "]<-[" + e.b + ']');
        if (e.c == null) goto L99;
        e.b("interrupt");
    L99:
        e.b = r37;
        e.c = r38;
        e.d = null;
        e.e = null;
        h1 r52 = g0.a.d();
        if (r52 != null) goto L102;
    L104:
        boolean r53 = false;
    L105:
        if (r53 == false) goto L107;
        e.a();
        r52.e(new g());
        return;
    L107:
        m r54 = m.a;
        p1 r55 = m.i();
        if (r55 != null) goto L111;
        return;
    L111:
        if (e.g == true) goto L113;
        e.g = true;
        e.j = 0;
        com.larus.platform.service.g.a.c();
        r55.g(e.a(), CoordinateType.GCJ_O2, r50, (z2) e.k.getValue());
    L113:
        int r56 = h.a;
        h.a(AppHost.a.getApplication(), (h.a) e.l.getValue());
        Job r57 = e.f;
        if (r57 == null) goto L116;
        Continuation r58 = null;
        Job.DefaultImpls.cancel$default(r57, null, 1, null);
    L117:
        e.f = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BaiduNaviLocationReporter$startRealLocation$1(r40, r39, r58), 3, null);
        return;
    L116:
        r58 = null;
        goto L117
    L102:
        if (r52.c() != true) goto L104;
        r53 = true;
        goto L105
    L93:
        r311 = "";
        r312 = "js_bd_navi_start";
        r115 = null;
        goto L94
    L95:
        r311 = "";
        r312 = "js_bd_navi_start";
        r48 = null;
        goto L96
    }
}
