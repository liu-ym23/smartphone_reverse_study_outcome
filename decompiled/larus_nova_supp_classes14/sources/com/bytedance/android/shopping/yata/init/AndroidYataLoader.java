package com.bytedance.android.shopping.yata.init;

import cl.d;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AndroidYataLoader {
    public static final Lazy a = null;

    public static final class a implements com.bytedance.kmp.ec.yata.common.log.a {
        public a() {
        }

        public final void a(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
        }

        public final void c(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
        }

        public final boolean b() {
            return ECAppInfoService.e.i();
        }

        public final void d(String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            if (ECAppInfoService.e.i() == false) goto L8;
            d r5 = k.a();
            if (r5 == null) goto L9;
            r5.o("YATA异常", r3, ErrorType.WARING);
            return;
        L9:
            return;
        }

        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "message");
            dm.a.a(r2).b(r3, null);
        }

        public final void ensureNotReachHere(Throwable r1, String r2) {
            nl3.a.a(r1, r2);
        }

        public final void i(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "message");
            dm.a.a(r2).i(r3);
        }

        public final void w(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "message");
            dm.a.a(r2).w(r3, null);
        }

        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "message");
            dm.a.a(r2).a(r3);
        }

        public final void e(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "message");
            dm.a.a(r2).b(r3, r4);
        }
    }

    public static final class b implements com.bytedance.kmp.ec.yata.common.init.a {
        public b() {
        }

        public final boolean b() {
            return ECAppInfoService.e.i();
        }

        public final String getAppVersion() {
            String r0 = ECAppInfoService.e.getAppVersion();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public final List<String> c() {
            Object r0 = ECSettingKeys.e0().get("skip_report_error_infos");
            if ((r0 instanceof List) == true) goto L5;
            r0 = null;
        L5:
            List<String> r1 = (List) r0;
            if (r1 == null) goto L8;
            return r1;
        L8:
            return CollectionsKt.emptyList();
        }

        public final Map<String, Integer> d() {
            Object r0 = ECSettingKeys.e0().get("biz_monitor_percent_config");
            LinkedHashMap r2 = null;
            if ((r0 instanceof Map) == true) goto L5;
            r0 = null;
        L5:
            Map r1 = (Map) r0;
            if (r1 == null) goto L11;
            r2 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
            Iterator r3 = r1.entrySet().iterator();
        L9:
            if (r3.hasNext() == false) goto L11;
            Map.Entry r4 = (Map.Entry) r3.next();
            r2.put(r4.getKey(), Integer.valueOf(((Number) r4.getValue()).intValue()));
        L11:
            if (r2 == null) goto L13;
            return r2;
        L13:
            return MapsKt.emptyMap();
        }

        public final void a(String r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "params");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Object r4 = Result.constructor-impl(new JSONObject(r3));     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r4) == false) goto L11;
            int r5 = nl3.a.a;
            nl3.a.a(Result.exceptionOrNull-impl(r4), "YataLoader MapToJSONObject Crash");
            return;
        L11:
            if (Result.isFailure-impl(r4) == false) goto L13;
            r4 = null;
        L13:
            JSONObject r6 = (JSONObject) r4;
            if (r6 == null) goto L20;
            g.a.logV3(r2, r6);
            return;
        L20:
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }
    }

    static {
        a = LazyKt.lazy(AndroidYataLoader$isInit$2.INSTANCE);
    }

    public static void a() {
        if (((AtomicBoolean) a.getValue()).getAndSet(true) == false) goto L5;
        return;
    L5:
        YaTaLog.f = new a();
        PackYataSdkConfig r0 = com.bytedance.kmp.ec.yata.common.init.b.a;
        b r1 = new b();
        Intrinsics.checkNotNullParameter(r1, "config");
        com.bytedance.kmp.ec.yata.common.init.b.a = new PackYataSdkConfig(r1);
        d r2 = k.a();
        if (r2 == null) goto L9;
        r2.b();
        return;
    }
}
