package com.bytedance.android.shopping.api.mall;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallPerformanceService;", "", "SceneContext", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallPerformanceService {

    public static final class SceneContext {
        public static final /* synthetic */ int f = 0;
        public volatile boolean a;
        public final ConcurrentHashMap<String, Object> b;
        public final String c;
        public final Map<String, Object> d;
        public final Function0<Map<String, Object>> e;

        public static final class a {
        }

        static {
        }

        public SceneContext() {
            throw null;
        }

        public final void a(final Function1<? super SceneContext, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            if (this.a == false) goto L5;
            return;
        L5:
            this.a = true;
            kk.d.c(new IECMallPerformanceService$SceneContext$initialize$1(this, r2));
        }

        public final Map<String, Object> b(String r5) {
            Intrinsics.checkNotNullParameter(r5, "timing");
            LinkedHashMap r1 = new LinkedHashMap();
            r1.put("scene", this.c);
            r1.put("timing", r5);
            r1.putAll(this.d);
            r1.putAll(this.b);
            Function0<Map<String, Object>> r6 = this.e;
            if (r6 == null) goto L12;
            Map r7 = (Map) r6.invoke();
            if (r7 == null) goto L12;
            if ((!r7.isEmpty()) == true) goto L10;
            r7 = null;
        L10:
            if (r7 == null) goto L12;
            r1.putAll(r7);
        L12:
            return r1;
        }

        public SceneContext(String r1, Map r2, Function0 r3) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            this.b = new ConcurrentHashMap();
        }
    }

    void a(SceneContext r1, String r2, Boolean r3);
}
