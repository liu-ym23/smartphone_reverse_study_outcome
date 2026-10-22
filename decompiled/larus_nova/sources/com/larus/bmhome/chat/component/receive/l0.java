package com.larus.bmhome.chat.component.receive;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l0 {
    static {
    }

    public static boolean a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "uris");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L20;
        Object r102 = r101.next();
        Uri r103 = (Uri) r102;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        InputStream r105 = ContentResolverWrapper.openInputStream(AppHost.f326268a.getApplication().getContentResolver(), r103);     // Catch: Throwable -> L11
        if (r105 == null) goto L9;
        r105.close();     // Catch: Throwable -> L11
    L9:
        Object r106 = Result.m9449constructorimpl(Boolean.FALSE);     // Catch: Throwable -> L11
    L13:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L18;
        FLogger.f375446a.e("ChatReceiveServiceHelper", "open uri:" + r103 + ", failed:" + r107);
        r106 = Boolean.TRUE;
    L18:
        if (((Boolean) r106).booleanValue() == false) goto L4;
    L21:
        if (r102 != null) goto L23;
        return true;
    L23:
        return false;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L20:
        r102 = null;
        goto L21
    }
}
