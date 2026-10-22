package com.bytedance.ee.bear.doc.follow.impl;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.doc.follow.FollowInvokeResult;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNFollowEvent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class w implements py4.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final py4.e f217961b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vv4.k f217962a;

    public static final class a {
    }

    public static final class b implements ValueCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f217963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NonProguard f217964b;

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(String r100) {
            tt5.a.h("WebViewBridge", "onCallVCFollow-> funcName=" + this.f217963a + ", funcParam=" + this.f217964b);
        }

        public b(String r100, NonProguard r101) {
            this.f217963a = r100;
            this.f217964b = r101;
        }
    }

    public static final class c implements ValueCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f217965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f217966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ry4.a f217967c;

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(String r100) {
            int r101 = py4.e.f531029d;
            String r102 = py4.e.a.a(null, this.f217965a, this.f217966b);
            py4.e r103 = w.f217961b;
            ry4.a r104 = this.f217967c;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r102, "registerKey");
            Intrinsics.checkNotNullParameter(r104, "eventHandler");
            r103.f531030a.put(r102, r104);
        }

        public c(String r100, String r101, ry4.a r102) {
            this.f217965a = r100;
            this.f217966b = r101;
            this.f217967c = r102;
        }
    }

    @Override // py4.j
    public final void g(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "eventType");
        Intrinsics.checkNotNullParameter(r103, "dataJson");
    }

    static {
        f217961b = new py4.e();
    }

    @Override // py4.j
    public final py4.e c() {
        return f217961b;
    }

    public w(vv4.k r100) {
        Intrinsics.checkNotNullParameter(r100, "mWeb");
        this.f217962a = r100;
    }

    @Override // py4.j
    public final void a(String r100) {
        JSONObject r101 = new JSONObject();
        this.f217962a.j("javascript:lark.biz.vcfollow.destroy", r101);
        py4.e r102 = f217961b;
        r102.f531032c.clear();
        r102.f531030a.clear();
        r102.f531031b.clear();
    }

    @Override // py4.j
    public final void b(FollowInvokeResult r100) {
        py4.f r101 = f217961b.b(r100.callbackId);
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // py4.j
    public final ry4.a d(RNFollowEvent r100) {
        int r101 = py4.e.f531029d;
        String r102 = py4.e.a.a(null, r100.module, r100.eventType);
        return f217961b.a(r102);
    }

    @Override // py4.j
    public final py4.k<? extends NonProguard> h(RNFollowEvent r100) {
        int r101 = py4.e.f531029d;
        String r102 = py4.e.a.a(null, r100.module, r100.eventType);
        py4.e r103 = f217961b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "registerKey");
        return r103.f531031b.get(r102);
    }

    @Override // py4.j
    public void onEvent(RNFollowEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = py4.e.f531029d;
        String r102 = py4.e.a.a(null, r100.module, r100.eventType);
        ry4.a r103 = f217961b.a(r102);
        if (r103 == null) goto L6;
        r103.onEvent(r100);
        return;
    }

    @Override // py4.b
    public final void onCallVCFollow(String r100, NonProguard r101) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        this.f217962a.u(r100, r101);
    }

    @Override // py4.j
    public final void i(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "eventType");
        int r103 = py4.e.f531029d;
        String r104 = py4.e.a.a(null, r101, r102);
        py4.e r105 = f217961b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "registerKey");
        r105.f531030a.remove(r104);
    }

    @Override // py4.j
    public final void j(py4.k<? extends NonProguard> r100, ry4.a r110, py4.a r111) {
        Intrinsics.checkNotNullParameter(r100, "parser");
        Intrinsics.checkNotNullParameter(r110, "handler");
        Intrinsics.checkNotNullParameter(r111, "params");
        int r101 = py4.e.f531029d;
        String r102 = py4.e.a.a(null, r111.f531026b, r111.f531027c);
        py4.e r103 = f217961b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "registerKey");
        Intrinsics.checkNotNullParameter(r100, "parserHandler");
        r103.f531031b.put(r102, r100);
        f(r111.f531025a, r111.f531026b, r111.f531027c, r110, r111.f531028d);
    }

    @Override // py4.b
    public final void onCallVCFollow(String r100, NonProguard r101, ry4.a r102) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        Intrinsics.checkNotNullParameter(r101, "funcParam");
        Intrinsics.checkNotNullParameter(r102, "handler");
        this.f217962a.k(r100, r101, new b(r100, r101));
    }

    @Override // py4.j
    public final String e(String r100, String r101, String r102, String r103, py4.f r104) {
        Intrinsics.checkNotNullParameter(r101, "funName");
        tt5.a.b("WebViewBridge", "invoke... funName is " + r101);
        py4.e r105 = f217961b;
        r105.getClass();
        if (r104 == null) goto L5;
        String r106 = Integer.toHexString(r104.hashCode());
        py4.f r107 = r105.f531032c.put(r106, r104);
    L6:
        JSONObject r108 = new JSONObject();
        r108.put2("token", r100);
        r108.put2("funcName", r101);
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r108.put2("paramJson", r102);
        r108.put2("metaJson", r103);
        r108.put2("callbackId", r106);
        this.f217962a.j("javascript:lark.biz.vcfollow.invoke", r108);
        return r106;
    L5:
        r106 = "Empty";
        goto L6
    }

    @Override // py4.j
    public final void f(String r100, String r101, String r102, ry4.a r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "eventType");
        Intrinsics.checkNotNullParameter(r103, "handler");
        JSONObject r105 = new JSONObject();
        r105.put2("token", r100);
        r105.put2(EventConstant.Key.MODULE, r101);
        r105.put2("eventType", r102);
        r105.put2(RNParamRegisterEventHandler.SRC_OUTER, Boolean.valueOf(r104));
        this.f217962a.a("javascript:lark.biz.vcfollow.registerEventHandler", r105, new c(r101, r102, r103));
    }
}
