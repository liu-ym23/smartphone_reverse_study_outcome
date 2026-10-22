package com.bytedance.android.shopping.mall.homepage.opt;

import com.ss.android.common.lib.AppLogNewUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Map<String, a> c = null;
    public static final C0105a d = null;
    public final int a;
    public final String b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.opt.a$a, reason: collision with other inner class name */
    public static final class C0105a {
        public C0105a() {
        }

        public static a a(String r2) {
            Intrinsics.checkNotNullParameter("async_inflate_native_view", "type");
            Intrinsics.checkNotNullParameter(r2, "sceneId");
            String r3 = "async_inflate_native_view-" + r2;
            Map<String, a> r0 = a.c;
            a r1 = (a) ((LinkedHashMap) r0).get(r3);
            if (r1 == null) goto L5;
            return r1;
        L5:
            a r4 = new a();
            r0.put(r3, r4);
            return r4;
        }
    }

    static {
        d = new C0105a();
        c = new LinkedHashMap();
    }

    public a() {
        Intrinsics.checkNotNullParameter("async_inflate_native_view", "type");
        this.b = "async_inflate_native_view";
        this.a = 2;
    }

    public final void a(int r4, int r5) {
        JSONObject r0 = new JSONObject();
        r0.putOpt("type", this.b);
        r0.putOpt("state", Integer.valueOf(r4));
        r0.putOpt("result", Integer.valueOf(r5));
        Unit r6 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_async_task_event", r0);
    }
}
