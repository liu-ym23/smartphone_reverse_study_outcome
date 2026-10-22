package com.bytedance.ee.bear.document.render.node;

import android.os.SystemClock;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.preload.WebViewLoadStateWebService;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements l {
    public s() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r11, Continuation r12) {
        if ((r12 instanceof WaitTemplatePreloadNode$run$1) == false) goto L7;
        WaitTemplatePreloadNode$run$1 r0 = (WaitTemplatePreloadNode$run$1) r12;
        int r1 = r0.label;
        if ((r1 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L7;
        r0.label = r1 - ShareItemModel.SRC_TINT_UNDEFINED;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r14 = r0.I$0;
        e r4 = (e) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L27:
        if (r14 != 0) goto L29;
        r4.c(WaitTemplatePreloadNode$run$3.INSTANCE);
    L29:
        tt5.a.h("GetClientVarNode", r4.f() + ", wait template success");
        q.a.getClass();
        return new q.c();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        com.bytedance.ee.bear.document.render.preload.e r16 = (com.bytedance.ee.bear.document.render.preload.e) r11.d.getWebService(WebViewLoadStateWebService.class);
        String r5 = r11.getDocumentMetadata().getDocumentType();
        tt5.a.h("GetClientVarNode", r11.i + " wait template start, type = " + r5 + ", documentType = " + r11.getDocumentMetadata().getDocumentType() + ", webViewStatusAbility = " + r16);
        if (r16 != null) goto L17;
    L19:
        int r6 = 0;
    L20:
        if (r6 != 0) goto L22;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).j("wait_preload", "start_time", String.valueOf(SystemClock.uptimeMillis()));
        r11.j.m();
        r11.c(WaitTemplatePreloadNode$run$2.INSTANCE);
    L22:
        if (r16 == null) goto L26;
        r0.L$0 = r11;
        r0.I$0 = r6;
        r0.label = 1;
        if (r16.d(r5, r0) != r2) goto L26;
        return r2;
    L26:
        r4 = r11;
        r14 = r6;
        goto L27
    L17:
        if (r16.c(r5) != true) goto L19;
        r6 = 1;
    L7:
        r0 = new WaitTemplatePreloadNode$run$1(this, r12);
        goto L8
    }
}
