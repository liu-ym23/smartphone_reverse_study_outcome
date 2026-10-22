package com.bytedance.ee.bear.document.render.node;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.debug.DebugUtils;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements l {
    public final Channel<Unit> a;
    public e b;
    public final b c;

    public static final class a {
    }

    public static final class b<T> implements tb5.i {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            StringBuilder r3 = new StringBuilder();
            e r4 = this.a.b;
            if (r4 == null) goto L5;
            String r5 = r4.f();
        L6:
            r3.append(r5);
            r3.append("dispatchLoadSuccess");
            tt5.a.h("RenderClientVarNode", r3.toString());
            this.a.a.trySend-JP2dKIU(Unit.INSTANCE);
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public j() {
        this.a = ChannelKt.Channel$default(0, null, null, 7, null);
        this.c = new b(this);
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        tt5.a.h("RenderClientVarNode", "cancelFutureOnCompletion");
        r3.d.getWeb().unbindJSHandler("biz.util.hideLoading");
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r19, Continuation r20) {
        DocumentLoaderV3 r1 = r19;
        if ((r20 instanceof RenderClientVarNode$run$1) == false) goto L7;
        RenderClientVarNode$run$1 r3 = (RenderClientVarNode$run$1) r20;
        int r4 = r3.label;
        if ((r4 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L7;
        r3.label = r4 - ShareItemModel.SRC_TINT_UNDEFINED;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        q r7 = (q) r3.L$1;
        e r8 = (e) r3.L$0;
        ResultKt.throwOnFailure(r2);
        ((kotlinx.coroutines.channels.g) r2).getClass();
        q r9 = r7;
        e r10 = r8;
    L67:
        tt5.a.h("RenderClientVarNode", r10.f() + "after receiveCatching");
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        this.b = r1;
        tt5.a.h("RenderClientVarNode", r1.i + "bindJSHandler");
        r1.d.getWeb().h("biz.util.hideLoading", this.c);
        AccountService$Account r11 = ((h0) r1.a(h0.class)).G2();
        if (r11 != null) goto L17;
        tt5.a.d("RenderClientVarNode", r1.i + "***reportOpenDoc*** onCallJsRender()... account is empty ");
        DocException r12 = new DocException(-51, "account is empty");
        q.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "throwable");
        r9 = new q.b(-51, r12);
    L64:
        Channel<Unit> r13 = this.a;
        r3.L$0 = r1;
        r3.L$1 = r9;
        r3.label = 1;
        r10 = r1;
        if (r13.receiveCatching-JP2dKIU(r3) != r5) goto L67;
        return r5;
    L17:
        com.bytedance.ee.bear.document.d r14 = r19.getDocumentMetadata();
        if (Intrinsics.areEqual(r14.getDocumentType(), sbb.e.i.getType()) == true) goto L20;
    L22:
        String r16 = r14.getOriginUrl();
    L23:
        String r17 = null;
        if (StringsKt.startsWith$default(r16, "https://", false, 2, null) == false) goto L26;
    L28:
        JSONObject r18 = new JSONObject();
        r18.put("userId", r11.uid);
        r18.put("tenantId", r11.tenantId);
        r18.put("departmentId", r11.departmentId);
        r18.put("isPreloadFinished", Boolean.TRUE);
        if (h18.f.a(r1.d.getActivity()) == false) goto L31;
        String r21 = "dark";
    L32:
        r18.put("theme", r21);
        tt5.a.h("RenderClientVarNode", "theme = ".concat(r21));
        JSONObject r22 = new JSONObject();
        r22.put("invokeRender", Long.valueOf(System.currentTimeMillis()));
        r18.put("timestamp", r22);
        r18.put("nativeWebviewId", r1.d.getWeb().getWebViewId());
        r18.put("editorId", Integer.valueOf(r1.d.getWeb().getWebView().hashCode()));
        r18.put("isDebug", Boolean.valueOf(eu5.c.d()));
        ml5.b r23 = DebugUtils.a();
        Boolean r110 = Boolean.FALSE;
        r18.put("isShowDocumentSize", Boolean.valueOf(((Boolean) r23.a("show_doc_size_toast", r110)).booleanValue()));
        r18.put("preFetchClientvarEnable", r110);
        r18.putAll(r1.h.a);
        JSONObject r24 = new JSONObject();
        if (TextUtils.isEmpty(r16) == true) goto L43;
        String r111 = UriProtector.parse(r16).getPath();
        if (TextUtils.isEmpty(r111) == true) goto L44;
        Intrinsics.checkNotNull(r111);
        int r112 = StringsKt.indexOf$default(r16, r111, 0, false, 6, null);
        if (r112 == (-1)) goto L43;
        if (r112 > r16.length()) goto L43;
        r17 = r16.substring(r112);
    L44:
        r24.put("url", r17);
        r24.put("infos", r18);
        t45.c r26 = (t45.c) r1.a(t45.c.class);
        s45.l r113 = r26.m8(r16);
        String r114 = r26.m4(r113);
        String[] r27 = r26.U3(r113);
        if (TextUtils.isEmpty(r114) == true) goto L50;
        if (r27 == null) goto L50;
        tt5.a.h("RenderClientVarNode", r1.i + "render inject mg domain info, apiUrl=" + r114 + " frontierDomain=" + Arrays.toString(r27));
        r24.put("docsApiPrefix", r114);
        r24.put("frontierDomain", r27);
        r24.put("unit", r113.a);
        String r28 = r113.b;
        if (r28 == null) goto L50;
        r24.put("brand", r28);
    L50:
        r24.put("srcHost", r113.c);
        r24.put("srcUrl", r16);
        StringBuilder r29 = new StringBuilder(r24.toString());
        Iterator r30 = ((LinkedHashMap) r1.h.b).entrySet().iterator();
    L52:
        if (r30.hasNext() == false) goto L60;
        Map.Entry r31 = (Map.Entry) r30.next();
        String r115 = (String) r31.getKey();
        String r32 = (String) r31.getValue();
        if (r32.length() != 0) goto L56;
        boolean r116 = true;
    L57:
        if (r116 == false) goto L59;
        r32 = "\"\"";
    L59:
        r29.insert(r29.indexOf("infos\":{") + 8, "\"" + r115 + "\":" + r32 + ',');
        goto L52
    L56:
        r116 = false;
        goto L57
    L60:
        String r33 = r29.toString();
        r1.c.n(System.currentTimeMillis());
        String r34 = "javascript:render(" + r33 + ')';
        tt5.a.h("RenderClientVarNode", r1.i + "***reportOpenDoc*** before call js render, script.length = " + r34.length());
        r1.d.getWeb().getWebView().evaluateJavascript(r34, new k(r1));
        r1.c(RenderClientVarNode$onCallJsRender$3.INSTANCE);
        if (r1.j.a != DocLoadingState.WAITING_PRELOAD) goto L63;
        r1.c.q();
    L63:
        r1.j.k();
        q.a.getClass();
        r9 = new q.c();
    L43:
        r17 = "";
        goto L44
    L31:
        r21 = "light";
        goto L32
    L26:
        if (StringsKt.startsWith$default(r16, "http://", false, 2, null) == true) goto L28;
        r16 = "https://" + r16;
        goto L28
    L20:
        if (fx4.a.g(r14.getOriginBearUrl()) == false) goto L22;
        r16 = r14.getUrl();
    L7:
        r3 = new RenderClientVarNode$run$1(this, r20);
        goto L8
    }
}
