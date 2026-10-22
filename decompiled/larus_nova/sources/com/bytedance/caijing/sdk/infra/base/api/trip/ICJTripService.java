package com.bytedance.caijing.sdk.infra.base.api.trip;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.api.trip.performance.ICJTripPerformance;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import id4.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&JM\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2#\b\u0002\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00060\u0010H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u0010H&¨\u0006\u001e"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/trip/ICJTripService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "schema", "", "openDynamicPage", "Lcom/bytedance/caijing/sdk/infra/base/api/trip/a;", "tripPerformanceContext", "Lcom/bytedance/caijing/sdk/infra/base/api/trip/performance/ICJTripPerformance;", "getTripPerformanceHelper", "Lid4/c;", "providerFactory", "Lkotlin/Function0;", "jsbRealLogic", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cjContext", "postInvoke", "blockJSBInvoke", "Lse4/a;", "getTripSidebarComponent", "Lpe4/a;", "getTripByteSync", "Lorg/json/JSONObject;", "params", "callback", "bdpCallTrip", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ICJTripService extends ICJService {

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.api.trip.ICJTripService$blockJSBInvoke$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid4/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lid4/c;)V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    final class AnonymousClass1 extends Lambda implements Function1<c, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(c r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(c r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    void bdpCallTrip(JSONObject r100, Function1<? super JSONObject, Unit> r101);

    void blockJSBInvoke(String r100, c r101, Function0<Unit> r102, Function1<? super c, Unit> r103);

    pe4.a getTripByteSync();

    ICJTripPerformance getTripPerformanceHelper(a r100);

    se4.a getTripSidebarComponent();

    void openDynamicPage(Context r100, String r101);
}
