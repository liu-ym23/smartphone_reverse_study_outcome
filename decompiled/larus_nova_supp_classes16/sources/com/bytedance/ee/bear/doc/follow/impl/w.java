package com.bytedance.ee.bear.doc.follow.impl;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.doc.follow.FollowInvokeResult;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w implements py4.j {
    public static final py4.e b = null;
    public final vv4.k a;

    public static final class a {
    }

    public static final class b implements ValueCallback<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ NonProguard b;

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(String r2) {
            tt5.a.h("WebViewBridge", "onCallVCFollow-> funcName=" + this.a + ", funcParam=" + this.b);
        }

        public b(String r1, NonProguard r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements ValueCallback<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ry4.a c;

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(String r4) {
            int r5 = py4.e.d;
            String r6 = py4.e.a.a(null, this.a, this.b);
            py4.e r0 = w.b;
            ry4.a r1 = this.c;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "registerKey");
            Intrinsics.checkNotNullParameter(r1, "eventHandler");
            r0.a.put(r6, r1);
        }

        public c(String r1, String r2, ry4.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // py4.j
    public final void g(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "eventType");
        Intrinsics.checkNotNullParameter(r4, "dataJson");
    }

    static {
        b = new py4.e();
    }

    @Override // py4.j
    public final py4.e c() {
        return b;
    }

    public w(vv4.k r2) {
        Intrinsics.checkNotNullParameter(r2, "mWeb");
        this.a = r2;
    }

    @Override // py4.j
    public final void a(String r3) {
        JSONObject r4 = new JSONObject();
        this.a.j("javascript:lark.biz.vcfollow.destroy", r4);
        py4.e r5 = b;
        r5.c.clear();
        r5.a.clear();
        r5.b.clear();
    }

    @Override // py4.j
    public final void b(FollowInvokeResult r3) {
        py4.f r0 = b.b(r3.callbackId);
        if (r0 == null) goto L6;
        r0.b(r3);
        return;
    }

    @Override // py4.j
    public final ry4.a d(RNFollowEvent r3) {
        int r0 = py4.e.d;
        String r4 = py4.e.a.a(null, r3.module, r3.eventType);
        return b.a(r4);
    }

    @Override // py4.j
    public final py4.k<? extends NonProguard> h(RNFollowEvent r3) {
        int r0 = py4.e.d;
        String r4 = py4.e.a.a(null, r3.module, r3.eventType);
        py4.e r1 = b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "registerKey");
        return r1.b.get(r4);
    }

    @Override // py4.j
    public void onEvent(RNFollowEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = py4.e.d;
        String r1 = py4.e.a.a(null, r4.module, r4.eventType);
        ry4.a r2 = b.a(r1);
        if (r2 == null) goto L6;
        r2.onEvent(r4);
        return;
    }

    @Override // py4.b
    public final void onCallVCFollow(String r2, NonProguard r3) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        this.a.u(r2, r3);
    }

    @Override // py4.j
    public final void i(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "eventType");
        int r4 = py4.e.d;
        String r5 = py4.e.a.a(null, r2, r3);
        py4.e r6 = b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "registerKey");
        r6.a.remove(r5);
    }

    @Override // py4.j
    public final void j(py4.k<? extends NonProguard> r9, ry4.a r10, py4.a r11) {
        Intrinsics.checkNotNullParameter(r9, "parser");
        Intrinsics.checkNotNullParameter(r10, "handler");
        Intrinsics.checkNotNullParameter(r11, "params");
        int r0 = py4.e.d;
        String r1 = py4.e.a.a(null, r11.b, r11.c);
        py4.e r2 = b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "registerKey");
        Intrinsics.checkNotNullParameter(r9, "parserHandler");
        r2.b.put(r1, r9);
        f(r11.a, r11.b, r11.c, r10, r11.d);
    }

    @Override // py4.b
    public final void onCallVCFollow(String r2, NonProguard r3, ry4.a r4) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        Intrinsics.checkNotNullParameter(r3, "funcParam");
        Intrinsics.checkNotNullParameter(r4, "handler");
        this.a.k(r2, r3, new b(r2, r3));
    }

    @Override // py4.j
    public final String e(String r3, String r4, String r5, String r6, py4.f r7) {
        Intrinsics.checkNotNullParameter(r4, "funName");
        tt5.a.b("WebViewBridge", "invoke... funName is " + r4);
        py4.e r0 = b;
        r0.getClass();
        if (r7 == null) goto L5;
        String r1 = Integer.toHexString(r7.hashCode());
        py4.f r8 = r0.c.put(r1, r7);
    L6:
        JSONObject r9 = new JSONObject();
        r9.put("token", r3);
        r9.put("funcName", r4);
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r9.put("paramJson", r5);
        r9.put("metaJson", r6);
        r9.put("callbackId", r1);
        this.a.j("javascript:lark.biz.vcfollow.invoke", r9);
        return r1;
    L5:
        r1 = "Empty";
        goto L6
    }

    @Override // py4.j
    public final void f(String r4, String r5, String r6, ry4.a r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "eventType");
        Intrinsics.checkNotNullParameter(r7, "handler");
        JSONObject r1 = new JSONObject();
        r1.put("token", r4);
        r1.put("module", r5);
        r1.put("eventType", r6);
        r1.put(RNParamRegisterEventHandler.SRC_OUTER, Boolean.valueOf(r8));
        this.a.a("javascript:lark.biz.vcfollow.registerEventHandler", r1, new c(r5, r6, r7));
    }
}
