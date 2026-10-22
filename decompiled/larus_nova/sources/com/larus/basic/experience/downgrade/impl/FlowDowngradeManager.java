package com.larus.basic.experience.downgrade.impl;

import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.basic.experience.downgrade.impl.strategy.DelayDowngradeStrategy;
import com.larus.basic.experience.downgrade.impl.strategy.DowngradeStrategyGroup;
import com.larus.basic.experience.downgrade.impl.strategy.b;
import com.larus.basic.experience.downgrade.impl.strategy.c;
import com.larus.basic.experience.downgrade.impl.strategy.d;
import com.larus.basic.experience.downgrade.impl.strategy.e;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.network.http.v;
import com.larus.network.http.y;
import com.larus.platform.model.downgrade.BlockDowngradeStrategyConfig;
import com.larus.platform.model.downgrade.BlockRequestDowngradeConfig;
import com.larus.platform.model.downgrade.DelayDowngradeStrategyConfig;
import com.larus.platform.model.downgrade.DelayRequestDowngradeConfig;
import com.larus.platform.model.downgrade.MockDowngradeStrategyConfig;
import com.larus.platform.model.downgrade.MockRequestDowngradeConfig;
import com.larus.platform.model.downgrade.ToastDowngradeStrategyConfig;
import com.larus.platform.model.downgrade.ToastRequestDowngradeConfig;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowDowngradeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowDowngradeManager f294834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BlockRequestDowngradeConfig f294835b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MockRequestDowngradeConfig f294836c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DelayRequestDowngradeConfig f294837d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ToastRequestDowngradeConfig f294838e = null;

    public FlowDowngradeManager() {
    }

    static {
        f294834a = new FlowDowngradeManager();
        BlockRequestDowngradeConfig r100 = z2.f365865a.getBlockRequestDowngradeConfig();
        ToastRequestDowngradeConfig r101 = null;
        LinkedHashMap r102 = null;
        if (r100 == null) goto L12;
        Map<String, BlockDowngradeStrategyConfig> r103 = r100.getConfigs();
        if (r103 == null) goto L10;
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r103.size()));
        Iterator<T> r105 = r103.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L11;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.put(StringsKt.replace$default((String) r106.getKey(), "\\/", HTTP.URL_DEFAULT, false, 4, null), r106.getValue());
    L11:
        BlockRequestDowngradeConfig r107 = new BlockRequestDowngradeConfig(r104);
    L13:
        f294835b = r107;
        MockRequestDowngradeConfig r108 = z2.f365865a.getMockRequestDowngradeConfig();
        if (r108 == null) goto L23;
        Map<String, MockDowngradeStrategyConfig> r109 = r108.getConfigs();
        if (r109 == null) goto L21;
        LinkedHashMap r110 = new LinkedHashMap(MapsKt.mapCapacity(r109.size()));
        Iterator<T> r111 = r109.entrySet().iterator();
    L19:
        if (r111.hasNext() == false) goto L22;
        Map.Entry r112 = (Map.Entry) r111.next();
        r110.put(StringsKt.replace$default((String) r112.getKey(), "\\/", HTTP.URL_DEFAULT, false, 4, null), r112.getValue());
    L22:
        MockRequestDowngradeConfig r113 = new MockRequestDowngradeConfig(r110);
    L24:
        f294836c = r113;
        DelayRequestDowngradeConfig r114 = z2.f365865a.getDelayRequestDowngradeConfig();
        if (r114 == null) goto L34;
        Map<String, DelayDowngradeStrategyConfig> r115 = r114.getConfigs();
        if (r115 == null) goto L32;
        LinkedHashMap r116 = new LinkedHashMap(MapsKt.mapCapacity(r115.size()));
        Iterator<T> r117 = r115.entrySet().iterator();
    L30:
        if (r117.hasNext() == false) goto L33;
        Map.Entry r118 = (Map.Entry) r117.next();
        r116.put(StringsKt.replace$default((String) r118.getKey(), "\\/", HTTP.URL_DEFAULT, false, 4, null), r118.getValue());
    L33:
        DelayRequestDowngradeConfig r119 = new DelayRequestDowngradeConfig(r116);
    L35:
        f294837d = r119;
        ToastRequestDowngradeConfig r120 = z2.f365865a.getToastRequestDowngradeConfig();
        if (r120 == null) goto L44;
        Map<String, ToastDowngradeStrategyConfig> r121 = r120.getConfigs();
        if (r121 == null) goto L43;
        r102 = new LinkedHashMap(MapsKt.mapCapacity(r121.size()));
        Iterator<T> r122 = r121.entrySet().iterator();
    L41:
        if (r122.hasNext() == false) goto L43;
        Map.Entry r123 = (Map.Entry) r122.next();
        r102.put(StringsKt.replace$default((String) r123.getKey(), "\\/", HTTP.URL_DEFAULT, false, 4, null), r123.getValue());
    L43:
        r101 = new ToastRequestDowngradeConfig(r102);
    L44:
        f294838e = r101;
        return;
    L32:
        r116 = null;
        goto L33
    L34:
        r119 = null;
        goto L35
    L21:
        r110 = null;
        goto L22
    L23:
        r113 = null;
        goto L24
    L10:
        r104 = null;
        goto L11
    L12:
        r107 = null;
        goto L13
    }

    public static BlockDowngradeStrategyConfig b(String r100) {
        BlockRequestDowngradeConfig r101 = f294835b;
        if (r101 == null) goto L8;
        Map<String, BlockDowngradeStrategyConfig> r102 = r101.getConfigs();
        if (r102 == null) goto L8;
        BlockDowngradeStrategyConfig r103 = r102.get(r100);
        if (r103 == null) goto L8;
        return r103;
    L8:
        BlockRequestDowngradeConfig r104 = a.f294839a;
        if (r104 == null) goto L13;
        Map<String, BlockDowngradeStrategyConfig> r105 = r104.getConfigs();
        if (r105 == null) goto L13;
        return r105.get(r100);
    L13:
        return null;
    }

    public static MockDowngradeStrategyConfig c(String r100) {
        MockRequestDowngradeConfig r101 = f294836c;
        if (r101 == null) goto L8;
        Map<String, MockDowngradeStrategyConfig> r102 = r101.getConfigs();
        if (r102 == null) goto L8;
        MockDowngradeStrategyConfig r103 = r102.get(r100);
        if (r103 == null) goto L8;
        return r103;
    L8:
        MockRequestDowngradeConfig r104 = a.f294840b;
        if (r104 == null) goto L13;
        Map<String, MockDowngradeStrategyConfig> r105 = r104.getConfigs();
        if (r105 == null) goto L13;
        return r105.get(r100);
    L13:
        return null;
    }

    public static com.larus.network.http.a d(b r100) {
        MockDowngradeStrategyConfig r101 = c(r100.f294853a);
        if (r101 == null) goto L5;
        d r102 = new d(r101);
    L7:
        if (r102 == null) goto L13;
        Intrinsics.checkNotNullParameter(r100, "downgradeContext");
        Pair<Boolean, String> r103 = c.a.a(r102, r100, true);
        boolean r104 = r103.component1().booleanValue();
        String r105 = r103.component2();
        FLogger r106 = FLogger.f375446a;
        r106.i("MockDowngradeStrategy", "mockDirectly, path = " + r100.f294853a + ", matched = " + r104 + ", reason = " + r105);
        if (r104 == false) goto L14;
        com.larus.network.http.a r107 = r102.h(r100);
        r106.i("MockDowngradeStrategy", "mockDirectly mock response for " + r100.f294853a + ", mockResp = " + r107);
        return r107;
    L14:
        return new f(new AsyncThrowable(-99999, "mock response is null", new Throwable()), null);
    L13:
        return new f(new AsyncThrowable(-99999, "mock empty process result", new Throwable()), null);
    L5:
        r102 = null;
        goto L7
    }

    public static DowngradeStrategyGroup a(b r100, Function2 r101) {
        ArrayList r102 = new ArrayList();
        BlockDowngradeStrategyConfig r103 = b(r100.f294853a);
        if (r103 == null) goto L5;
        r102.add(new com.larus.basic.experience.downgrade.impl.strategy.a(r103));
    L5:
        MockDowngradeStrategyConfig r104 = c(r100.f294853a);
        if (r104 == null) goto L8;
        r102.add(new d(r104));
    L8:
        String r105 = r100.f294853a;
        DelayRequestDowngradeConfig r106 = f294837d;
        if (r106 == null) goto L14;
        Map<String, DelayDowngradeStrategyConfig> r107 = r106.getConfigs();
        if (r107 == null) goto L14;
        DelayDowngradeStrategyConfig r108 = r107.get(r105);
        if (r108 == null) goto L14;
    L20:
        if (r108 == null) goto L23;
        r102.add(new DelayDowngradeStrategy(r108));
    L23:
        return new DowngradeStrategyGroup(r102, r101, r100);
    L14:
        DelayRequestDowngradeConfig r109 = a.f294841c;
        if (r109 == null) goto L19;
        Map<String, DelayDowngradeStrategyConfig> r110 = r109.getConfigs();
        if (r110 == null) goto L19;
        r108 = r110.get(r105);
    L19:
        r108 = null;
        goto L20
    }

    public final <T> Object e(com.larus.network.http.a<? extends T> r100, b<T> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof FlowDowngradeManager$onResult$1) == false) goto L7;
        FlowDowngradeManager$onResult$1 r103 = (FlowDowngradeManager$onResult$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        b<T> r108 = (b) r103.L$1;
        com.larus.network.http.a<? extends T> r109 = (com.larus.network.http.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
        r101 = r108;
        r100 = r109;
    L30:
        Pair r110 = (Pair) r105;
    L31:
        o r111 = o.f365780a;
        Bundle r112 = new Bundle();
        r112.putString("path", r101.f294853a);
        boolean r113 = r100 instanceof y;
        if (r113 == false) goto L34;
        String r114 = "1";
    L35:
        r112.putString("is_success", r114);
        String r115 = "";
        if (r113 == false) goto L39;
        String r116 = String.valueOf(((y) r100).f360205g);
    L42:
        r112.putString("code", r116);
        if (r113 == false) goto L46;
        r115 = String.valueOf(((y) r100).f360204f);
    L48:
        r112.putString("msg", r115);
        Map<String, String> r117 = r101.f294856d;
        if (r117 == null) goto L54;
        Iterator<Map.Entry<String, String>> r118 = r117.entrySet().iterator();
    L52:
        if (r118.hasNext() == false) goto L54;
        Map.Entry<String, String> r119 = r118.next();
        r112.putString(r119.getKey(), r119.getValue());
    L54:
        Map<String, String> r120 = r101.f294860h;
        if (r120 == null) goto L60;
        Iterator<Map.Entry<String, String>> r121 = r120.entrySet().iterator();
    L58:
        if (r121.hasNext() == false) goto L60;
        Map.Entry<String, String> r122 = r121.next();
        r112.putString(r122.getKey(), r122.getValue());
    L60:
        Unit r123 = Unit.INSTANCE;
        r111.b("flow_downgrade_request_detail", r112);
        return Unit.INSTANCE;
    L46:
        if ((r100 instanceof f) == false) goto L48;
        r115 = String.valueOf(((f) r100).f360157d.getMessage());
        goto L48
    L39:
        if ((r100 instanceof f) == false) goto L41;
        r116 = String.valueOf(((f) r100).f360157d.getCode());
        goto L42
    L41:
        r116 = "";
        goto L42
    L34:
        r114 = "0";
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        String r124 = r101.f294853a;
        ToastRequestDowngradeConfig r125 = f294838e;
        if (r125 == null) goto L20;
        Map<String, ToastDowngradeStrategyConfig> r126 = r125.getConfigs();
        if (r126 == null) goto L20;
        ToastDowngradeStrategyConfig r127 = r126.get(r124);
        if (r127 == null) goto L20;
    L26:
        if (r127 == null) goto L31;
        e r128 = new e(r127);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = r128.c(r101, r100);
        if (r105 != r106) goto L30;
        return r106;
    L20:
        ToastRequestDowngradeConfig r129 = a.f294842d;
        if (r129 == null) goto L25;
        Map<String, ToastDowngradeStrategyConfig> r130 = r129.getConfigs();
        if (r130 == null) goto L25;
        r127 = r130.get(r124);
    L25:
        r127 = null;
    L7:
        r103 = new FlowDowngradeManager$onResult$1(this, r102);
        goto L8
    }

    public final <T> Object f(String r210, Class<T> r211, String r212, Map<String, String> r213, Map<String, String> r214, boolean r215, Map<String, ? extends Object> r216, RequestContext r310, Map<String, String> r311, Continuation<? super com.larus.network.http.a<? extends T>> r312) {
        if ((r312 instanceof FlowDowngradeManager$requestGet$1) == false) goto L7;
        FlowDowngradeManager$requestGet$1 r100 = (FlowDowngradeManager$requestGet$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        com.larus.network.http.a r105 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
    L23:
        Pair r106 = (Pair) r102;
        com.larus.network.http.a<? extends T> r107 = (com.larus.network.http.a) r106.component1();
        b<T> r108 = (b) r106.component2();
        r100.L$0 = r107;
        r100.label = 2;
        if (e(r107, r108, r100) != r103) goto L27;
        return r103;
    L27:
        return r107;
    L16:
        ResultKt.throwOnFailure(r102);
        if (r214 != null) goto L19;
        Map<String, String> r110 = MapsKt.emptyMap();
    L20:
        DowngradeStrategyGroup r109 = a(new b(r212, r211, r110, r311, null, r213, null, new LinkedHashMap()), new FlowDowngradeManager$requestGet$strategyGroup$1(r210, r215, r216, r310, null));
        r100.label = 1;
        r102 = r109.a(r100);
        if (r102 != r103) goto L23;
        return r103;
    L19:
        r110 = r214;
    L7:
        r100 = new FlowDowngradeManager$requestGet$1(this, r312);
        goto L8
    }

    public final <T> Object g(String r210, Class<T> r211, String r212, Map<String, String> r213, Map<String, String> r214, boolean r215, Map<String, ? extends Object> r216, RequestContext r310, Map<String, String> r311, Continuation<? super com.larus.network.http.a<? extends T>> r312) {
        if ((r312 instanceof FlowDowngradeManager$requestGetMock$1) == false) goto L7;
        FlowDowngradeManager$requestGetMock$1 r100 = (FlowDowngradeManager$requestGetMock$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        com.larus.network.http.a r105 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b<T> r106 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L23:
        com.larus.network.http.a<? extends T> r107 = (com.larus.network.http.a) r102;
        r100.L$0 = r107;
        r100.label = 2;
        if (e(r107, r106, r100) != r103) goto L27;
        return r103;
    L27:
        return r107;
    L16:
        ResultKt.throwOnFailure(r102);
        if (r214 != null) goto L19;
        Map<String, String> r110 = MapsKt.emptyMap();
    L20:
        r106 = new b(r212, r211, r110, r311, null, r213, null, new LinkedHashMap());
        new FlowDowngradeManager$requestGetMock$result$1(r210, r215, r216, r310, null);
        r100.L$0 = r106;
        r100.label = 1;
        r102 = d(r106);
        if (r102 != r103) goto L23;
        return r103;
    L19:
        r110 = r214;
    L7:
        r100 = new FlowDowngradeManager$requestGetMock$1(this, r312);
        goto L8
    }

    public final <T> Object i(String r210, Class<T> r211, String r212, JSONObject r213, String r214, Map<String, String> r310, boolean r311, Map<String, ? extends Object> r312, RequestContext r313, v r314, Map<String, String> r315, Continuation<? super com.larus.network.http.a<? extends T>> r316) {
        if ((r316 instanceof FlowDowngradeManager$requestPost$1) == false) goto L7;
        FlowDowngradeManager$requestPost$1 r100 = (FlowDowngradeManager$requestPost$1) r316;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        com.larus.network.http.a r105 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
    L19:
        Pair r106 = (Pair) r102;
        com.larus.network.http.a<? extends T> r107 = (com.larus.network.http.a) r106.component1();
        b<T> r108 = (b) r106.component2();
        r100.L$0 = r107;
        r100.label = 2;
        if (e(r107, r108, r100) != r103) goto L23;
        return r103;
    L23:
        return r107;
    L16:
        ResultKt.throwOnFailure(r102);
        DowngradeStrategyGroup r109 = a(new b(r212, r211, r310, r315, r213, null, null, new LinkedHashMap()), new FlowDowngradeManager$requestPost$strategyGroup$1(r210, r214, r311, r312, r313, r314, null));
        r100.label = 1;
        r102 = r109.a(r100);
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new FlowDowngradeManager$requestPost$1(this, r316);
        goto L8
    }

    public final <T> Object j(String r210, Class<T> r211, String r212, JSONObject r213, String r214, Map<String, String> r310, boolean r311, Map<String, ? extends Object> r312, RequestContext r313, v r314, Map<String, String> r315, Continuation<? super com.larus.network.http.a<? extends T>> r316) {
        if ((r316 instanceof FlowDowngradeManager$requestPostMock$1) == false) goto L7;
        FlowDowngradeManager$requestPostMock$1 r100 = (FlowDowngradeManager$requestPostMock$1) r316;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        com.larus.network.http.a r105 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b<T> r106 = (b) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L19:
        com.larus.network.http.a<? extends T> r107 = (com.larus.network.http.a) r102;
        r100.L$0 = r107;
        r100.label = 2;
        if (e(r107, r106, r100) != r103) goto L23;
        return r103;
    L23:
        return r107;
    L16:
        ResultKt.throwOnFailure(r102);
        r106 = new b(r212, r211, r310, r315, r213, null, null, new LinkedHashMap());
        new FlowDowngradeManager$requestPostMock$result$1(r210, r214, r311, r312, r313, r314, null);
        r100.L$0 = r106;
        r100.label = 1;
        r102 = d(r106);
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new FlowDowngradeManager$requestPostMock$1(this, r316);
        goto L8
    }

    public final <T, Req> Object h(String r210, Class<T> r211, String r310, Req r311, juc.d<Req> r312, juc.d<T> r313, String r314, Map<String, String> r315, boolean r316, Map<String, ? extends Object> r317, RequestContext r318, v r319, Map<String, String> r410, Continuation<? super com.larus.network.http.a<? extends T>> r411) {
        if ((r411 instanceof FlowDowngradeManager$requestPost$2) == false) goto L7;
        FlowDowngradeManager$requestPost$2 r100 = (FlowDowngradeManager$requestPost$2) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        com.larus.network.http.a r105 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
    L19:
        Pair r106 = (Pair) r102;
        com.larus.network.http.a<? extends T> r107 = (com.larus.network.http.a) r106.component1();
        b<T> r108 = (b) r106.component2();
        r100.L$0 = r107;
        r100.label = 2;
        if (e(r107, r108, r100) != r103) goto L23;
        return r103;
    L23:
        return r107;
    L16:
        ResultKt.throwOnFailure(r102);
        DowngradeStrategyGroup r109 = a(new b(r310, r211, r315, r410, HttpExtKt.o(r311, r312), null, null, new LinkedHashMap()), new FlowDowngradeManager$requestPost$strategyGroup$2(r210, r311, r312, r313, r314, r316, r317, r318, r319, null));
        r100.label = 1;
        r102 = r109.a(r100);
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new FlowDowngradeManager$requestPost$2(this, r411);
        goto L8
    }
}
