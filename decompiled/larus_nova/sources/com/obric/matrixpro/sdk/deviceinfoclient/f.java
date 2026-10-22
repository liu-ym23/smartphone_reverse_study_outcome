package com.obric.matrixpro.sdk.deviceinfoclient;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f extends Handler {
    public f(Looper r100) {
        super(r100);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.what != 1) goto L48;
        Object r101 = r100.obj;
        if (r101 == null) goto L47;
        a.b r102 = (a.b) r101;
        a r103 = a.f397038e;
        Context r104 = r102.getContext();
        a.InterfaceC4654a r105 = r102.f397040b;
        r103.getClass();
        Cursor r106 = a.a(r104.getContentResolver(), UriProtector.parse("content://com.bytedance.securityserver.deviceInfoProvider/get_osdid"));     // Catch: Exception -> L41
        if (r106 == null) goto L36;
        Cursor r107 = r106;     // Catch: Exception -> L41
        Cursor r108 = r107;     // Catch: Throwable -> L31
        if (r108.moveToFirst() == true) goto L18;
        Handler r109 = a.f397036c;     // Catch: Throwable -> L31
        if (r109 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Throwable -> L31
    L15:
        r109.post(new c(r105));     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r107, null);     // Catch: Exception -> L41
        return;
    L18:
        int r110 = r108.getColumnIndex("osdid");     // Catch: Throwable -> L31
        int r111 = r108.getColumnIndex("error");     // Catch: Throwable -> L31
        if (r111 < 0) goto L21;
        String r112 = r108.getString(r111);     // Catch: Throwable -> L31
    L22:
        if (r110 < 0) goto L24;
        String r113 = r108.getString(r110);     // Catch: Throwable -> L31
    L25:
        Handler r114 = a.f397036c;     // Catch: Throwable -> L31
        if (r114 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Throwable -> L31
    L28:
        r114.post(new d(r112, r113, r105));     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r107, null);     // Catch: Exception -> L41
        return;
    L24:
        r113 = null;
        goto L25
    L21:
        r112 = null;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r107, th);     // Catch: Exception -> L41
        throw th;     // Catch: Exception -> L41
    L36:
        Handler r115 = a.f397036c;     // Catch: Exception -> L41
        if (r115 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Exception -> L41
    L39:
        r115.post(new b(r105));     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        int r116 = g.f397048a;
        Intrinsics.checkNotNullParameter("OsDidClient", "tag");
        Intrinsics.checkNotNullParameter("查询OSDID异常", "msg");
        Handler r117 = a.f397036c;
        if (r117 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");
    L45:
        r117.post(new e(r105, e));
        return;
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.matrixpro.sdk.deviceinfoclient.DeviceInfoGetter.OsDidRequest");
    }
}
