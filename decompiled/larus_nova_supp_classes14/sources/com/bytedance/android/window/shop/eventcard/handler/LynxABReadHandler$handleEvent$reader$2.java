package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.android.ec.core.opt.ab.p;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "shoppingABKey", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LynxABReadHandler$handleEvent$reader$2 extends FunctionReferenceImpl implements Function1<String, Object> {
    public LynxABReadHandler$handleEvent$reader$2(dp3.a r8) {
        super(1, r8, dp3.a.class, "readShopAB", "readShopAB(Ljava/lang/String;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((dp3.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r4, "shoppingABKey");
        int r0 = p.a;
        Object r1 = "";
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r3 = jj4.b.b;     // Catch: Throwable -> L7
        Object r5 = jj4.a.a(r4, String.class, "", false);     // Catch: Throwable -> L7
        if (r5 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
        return r5;
    L16:
        return r5;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L13;
        r1 = r7;
    L13:
        return r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
