package com.ss.android.lark.passport.flow.core.network.handler;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@CodeHandlerAnno(code = 4402)
public final class AlertCodeHandler implements e {
    public AlertCodeHandler() {
    }

    @Override // com.ss.android.lark.passport.flow.core.network.handler.e
    public final boolean a(final Context r100, NetworkErrorResult r101) {
        if (r100 != null) goto L5;
    L19:
        return false;
    L5:
        if ((r100 instanceof Activity) == false) goto L19;
        if (r101 == null) goto L10;
        final String r102 = r101.getErrorMessage();
        if (r102 == null) goto L10;
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L19;
        Handler r103 = uyb.a.f552158a;
        Function0<Unit> r104 = new AlertCodeHandler$handlerErrorWithContext$1(r100, r102);
        Intrinsics.checkNotNullParameter(r104, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L16;
        r104.invoke();
        return true;
    L16:
        uyb.a.f552158a.post(new uyb.a.RunnableC7946a(r104));
        return true;
    L10:
        r102 = "";
        goto L12
    }
}
