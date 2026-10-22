package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.ResponseMeta;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes24.dex */
public final class VerifyDataInterceptor implements com.lark.kmp.rustclient.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f282535a;

    public VerifyDataInterceptor(r r100) {
        Intrinsics.checkNotNullParameter(r100, "definition");
        this.f282535a = r100;
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <Resp> Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> a(final com.lark.kmp.rustclient.api.h<Resp> r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        final Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r101 = r100.b(r100.f282460c);
        return new VerifyDataInterceptor$interceptEnqueue$$inlined$filter$1(r101, r100, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lark.kmp.rustclient.api.g
    public final <T> Object b(com.lark.kmp.rustclient.api.h<T> r110, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, T>> r210) {
        com.lark.kmp.rustclient.api.h r100 = r110;
        if ((r210 instanceof VerifyDataInterceptor$intercept$1) == false) goto L7;
        VerifyDataInterceptor$intercept$1 r101 = (VerifyDataInterceptor$intercept$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (com.lark.kmp.rustclient.api.h) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L17:
        Object r111 = r103;
        com.lark.kmp.rustclient.api.h r106 = r100;
        com.lark.kmp.rustclient.api.model.g r107 = (com.lark.kmp.rustclient.api.model.g) r111;
        com.lark.kmp.rustclient.api.a<Resp> r108 = r106.f282460c;
        r r109 = this.f282535a;
        if ((r108.f282455b instanceof com.lark.kmp.rustclient.api.model.l) == false) goto L52;
        InvokeResponse r112 = (InvokeResponse) r107.f282480a;
        if (r112 == null) goto L23;
        byte[] r113 = r112.f254048b;
    L24:
        if (r113 == null) goto L52;
        if (r108.f282454a.a() == Command.MAKE_USER_ONLINE) goto L52;
        if ((r107 instanceof com.lark.kmp.rustclient.api.model.b) == true) goto L52;
        String r114 = ((com.lark.kmp.rustclient.api.model.l) r108.f282455b).f282483a;
        ResponseMeta r115 = ResponseMeta.ADAPTER.e(((InvokeResponse) r107.f282480a).f254048b);     // Catch: Throwable -> L47 Exception -> L49
        String r116 = String.valueOf(r115.getUser_id());     // Catch: Throwable -> L47 Exception -> L49
        Boolean r117 = r115.getVerify_user_id();     // Catch: Throwable -> L47 Exception -> L49
        if (r117 == null) goto L36;
        boolean r118 = r117.booleanValue();     // Catch: Throwable -> L47 Exception -> L49
    L38:
        if (Intrinsics.areEqual(r114, r116) == false) goto L40;
    L51:
        r109.b();
        goto L52
    L40:
        if (f0.a(r116) == false) goto L42;
        if (r118 == true) goto L42;
    L43:
        if (f0.a(r116) == true) goto L51;
        if (r118 == false) goto L51;
    L46:
        r109.b();
        boolean r119 = false;
    L56:
        if (r119 == false) goto L58;
        return r107;
    L58:
        return new com.lark.kmp.rustclient.api.model.b(com.lark.kmp.rustclient.api.model.i.b(r106.f282460c.f282454a.a(), r106.f282460c.f282454a.f282468d, null, new RuntimeException("User Verify Failed.")), r107.f282480a, r106.f282460c.f282455b);
    L42:
        LarkLogger r120 = LarkLogger.f278603a;     // Catch: Throwable -> L47 Exception -> L49
        LarkLogger.e("logInvokeVerify verifyInvoke Failed: requestUserId = " + r114 + ", command = " + r108.f282454a.a() + ", contextId = " + r108.f282454a.f282466b + ", sdkUserId=" + r116 + ", needVerify=" + r118);     // Catch: Throwable -> L47 Exception -> L49
        goto L43
    L36:
        r118 = false;
    L47:
        th = move-exception;
        r109.b();
        throw th;
    L49:
        e = move-exception;
        LarkLogger r121 = LarkLogger.f278603a;     // Catch: Throwable -> L47
        LarkLogger.e("logInvokeMetaParse verifyInvoke Failed: command = " + r108.f282454a.a() + ", contextId = " + r108.f282454a.f282466b + ", error occurs: " + e.getMessage());     // Catch: Throwable -> L47
        goto L46
    L23:
        r113 = null;
    L52:
        r119 = true;
        goto L56
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Object r122 = r100.f282460c;
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r100.a(r122, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new VerifyDataInterceptor$intercept$1(this, r210);
        goto L8
    }
}
