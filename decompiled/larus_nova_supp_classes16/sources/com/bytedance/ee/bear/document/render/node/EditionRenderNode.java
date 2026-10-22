package com.bytedance.ee.bear.document.render.node;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.z5;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class EditionRenderNode implements l {
    public static final /* synthetic */ int b = 0;
    public final z05.d a;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ kotlinx.coroutines.i<z05.g> a;

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            z05.g r3 = (z05.g) r2;
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ kotlinx.coroutines.i<z05.g> a;

        public c(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            if (this.a.isActive() == false) goto L6;
            kotlinx.coroutines.i<z05.g> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            Intrinsics.checkNotNull(r4);
            r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(r4)));
            return;
        }
    }

    static {
    }

    public EditionRenderNode() {
        this.a = new z05.d();
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public static void a(e r3, z05.g r4) {
        String r0 = r4.f;
        String r5 = r4.a;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        tt5.a.d("EditionRenderNode", r3.f() + "edition render param invalid, editionId=" + r0);
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L7;
        o r6 = r3.e();
        JSONObject r1 = new JSONObject();
        r1.put("version", r0);
        r1.put("versionToken", r5);
        Unit r7 = Unit.INSTANCE;
        r6.a("versionInfo", r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.bytedance.ee.bear.document.render.node.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [com.bytedance.ee.bear.document.DocViewModel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ee.bear.document.render.loader.BaseDocumentLoader, com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.ee.bear.document.render.node.e] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.bytedance.ee.bear.document.DocViewModel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.ee.bear.document.DocViewModel] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v16, types: [com.bytedance.ee.bear.document.render.node.e] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.ee.bear.document.DocViewModel] */
    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r17, Continuation r18) {
        ?? r1 = r17;
        if ((r18 instanceof EditionRenderNode$run$1) == false) goto L7;
        EditionRenderNode$run$1 r2 = (EditionRenderNode$run$1) r18;
        int r3 = r2.label;
        if ((r3 & ShareItemModel.SRC_TINT_UNDEFINED) == 0) goto L7;
        r2.label = r3 - ShareItemModel.SRC_TINT_UNDEFINED;
    L8:
        EditionRenderNode$run$1 r0 = r2;
        Object r4 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r5 = r0.label;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L16;
        DocViewModel r6 = (DocViewModel) r0.L$1;
        e r7 = (e) r0.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L20
        r1 = r6;
        r5 = r7;
    L63:
        q.a.getClass();     // Catch: Throwable -> L20
        return new q.c();
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        DocViewModel r9 = (DocViewModel) r0.L$1;
        e r10 = (e) r0.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L20
        ?? r13 = r9;
        ?? r12 = r10;
    L92:
        z05.g r11 = (z05.g) r4;     // Catch: Throwable -> L66
        String r14 = r11.b;     // Catch: Throwable -> L66
        String r16 = r11.f;     // Catch: Throwable -> L66
        String r19 = r11.a;     // Catch: Throwable -> L66
        r13.setEditionName(r14);     // Catch: Throwable -> L66
        r13.setEditionId(r16);     // Catch: Throwable -> L66
        r13.setEditionToken(r19);     // Catch: Throwable -> L66
        a(r12, r11);     // Catch: Throwable -> L66
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L66
        EditionRenderNode$run$2 r111 = new EditionRenderNode$run$2(this, r12, r13, r11, null);     // Catch: Throwable -> L66
        r0.L$0 = r12;     // Catch: Throwable -> L66
        r0.L$1 = r13;     // Catch: Throwable -> L66
        r0.label = 2;     // Catch: Throwable -> L66
        if (BuildersKt.withContext(r110, r111, r0) != r8) goto L62;
        return r8;
    L62:
        r5 = r12;
        r1 = r13;
    L66:
        th = th;
        r1 = r12;
        ?? r20 = r13;
    L70:
        if ((th instanceof NetService.ServerErrorException) == false) goto L83;
        NetService.ServerErrorException r21 = th;
        switch(r21.getCode()) {
            case 528010000: goto L78;
            case 528021002: goto L78;
            case 528032011: goto L78;
            case 528032012: goto L74;
            default: goto L73;
        };
    L73:
        q.a r22 = q.a;
        int r23 = r21.getCode();
        r22.getClass();
        Intrinsics.checkNotNullParameter(th, "throwable");
        q.b r24 = new q.b(r23, th);
    L85:
        return r24;
    L74:
        q.a r26 = q.a;
        String r27 = th.getMessage();
        if (r27 != null) goto L77;
        r27 = "";
    L77:
        DocException r28 = new DocException(-57, r27);
        r26.getClass();
        Intrinsics.checkNotNullParameter(r28, "throwable");
        return new q.b(-57, r28);
    L78:
        String r29 = z05.i.c(r20.getUrl());
        r20.setUrl(r29);
        r20.setEditionName(null);
        r20.setEditionId(null);
        r20.setEditionToken(null);
        ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).e(null);
        tt5.a.h("EditionRenderNode", r1.f() + "edition load forbidden or invalid, fallback to source doc");
        z5 r30 = (z5) r1.getPluginHost().getHostAbilityOrNull(z5.class);
        if (r30 == null) goto L81;
        r30.reloadDocumentFragment(r29, null);
    L81:
        q.a.getClass();
        return new q.c();
    L83:
        q.a.getClass();
        Intrinsics.checkNotNullParameter(th, "throwable");
        r24 = new q.b(-52, th);
        goto L85
    L22:
        ResultKt.throwOnFailure(r4);
        com.bytedance.ee.bear.document.d r31 = r17.getDocumentMetadata();
        if ((r31 instanceof DocViewModel) == false) goto L25;
        r20 = (DocViewModel) r31;
    L26:
        if (r20 != 0) goto L29;
        tt5.a.k("EditionRenderNode", r1.i + "document metadata is not DocViewModel");
        q.a.getClass();
        return new q.c();
    L29:
        sbb.e r32 = sbb.e.e(r20.getBearUrl().a);
        Intrinsics.checkNotNull(r32);
        if (z05.i.b(r32.b) == false) goto L32;
        r1.S3(new com.bytedance.ee.bear.document.render.node.c(this, r20, r1));
    L32:
        boolean r33 = false;
        if (Intrinsics.areEqual(r32, sbb.e.o) == false) goto L35;
    L40:
        boolean r34 = true;
    L41:
        if (r34 == true) goto L43;
    L47:
        if (r33 == true) goto L50;
        r20.setEditionName(null);
        r20.setEditionId(null);
        r20.setEditionToken(null);
        q.a.getClass();
        return new q.c();
    L50:
        String r36 = r20.getBearUrl().n;
        String r37 = r20.getToken();
        if (TextUtils.isEmpty(r36) == false) goto L53;
    L86:
        tt5.a.d("EditionRenderNode", r1.i + "editionId or token is empty");
        r20.setEditionName(null);
        r20.setEditionId(null);
        r20.setEditionToken(null);
        q.a.getClass();
        return new q.c();
    L53:
        if (TextUtils.isEmpty(r37) == true) goto L86;
        int r38 = r32.b;     // Catch: Throwable -> L68
        Intrinsics.checkNotNull(r36);     // Catch: Throwable -> L68
        r0.L$0 = r1;     // Catch: Throwable -> L68
        r0.L$1 = r20;     // Catch: Throwable -> L68
        r0.label = 1;     // Catch: Throwable -> L68
        Object r39 = d(r37, r38, r36, r0);     // Catch: Throwable -> L68
        if (r39 != r8) goto L58;
        return r8;
    L58:
        r12 = r1;
        r13 = r20;
        r4 = r39;
    L68:
        th = th;
        goto L70
    L43:
        if (r20.getOpenSource() == DocsOpenSource.vc) goto L47;
        if (z05.i.d(r20.getUrl()) == false) goto L47;
        r33 = true;
        goto L47
    L35:
        if (Intrinsics.areEqual(r32, sbb.e.h) == true) goto L37;
    L39:
        r34 = false;
        goto L41
    L37:
        if (r20.isSyncBlock() == true) goto L39;
    L25:
        r20 = 0;
    L20:
        th = th;
        r20 = r1;
        r1 = r5;
    L7:
        r2 = new EditionRenderNode$run$1(this, r18);
        goto L8
    }

    public final Object d(String r4, int r5, String r6, Continuation<? super z05.g> r7) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), 1);
        r0.C();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = this.a.a(r4, r5, r6).subscribe(new b(r0), new c(r0));
        r0.i(new EditionRenderNode$loadEditionMetadata$2$3(r1));
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L5:
        return r8;
    }
}
