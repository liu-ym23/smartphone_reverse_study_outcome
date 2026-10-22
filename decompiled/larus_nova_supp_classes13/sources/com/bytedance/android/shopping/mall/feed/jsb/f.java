package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends qf3.e {
    public final String d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public static void a() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
            r1.putOpt("result", "back");     // Catch: Throwable -> L4
            r1.putOpt(PdpOpenThirdParam.KEY_PAGE_NAME, "order_homepage");     // Catch: Throwable -> L4
            r1.putOpt("EVENT_ORIGIN_FEATURE", "TEMAI");     // Catch: Throwable -> L4
            r1.putOpt("type", "left_top_button");     // Catch: Throwable -> L4
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L4
            AppLogNewUtils.onEventV3("ecom_mall_user_back", r1);     // Catch: Throwable -> L4
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public f(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallClosePage";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        com.bytedance.android.ec.hybrid.a.d().submit(b.a);
        r2.b.A1.closePage();
        return qf3.e.f(this);
    }
}
