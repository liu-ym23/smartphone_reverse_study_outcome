package com.bytedance.ee.bear.document.frontendlog;

import android.os.Process;
import com.bytedance.android.alog.Alog;
import com.bytedance.android.alog.e;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tb5.h;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements h<BatchLoggerMessage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f219931a;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f219931a = "Bear_JsBatchLoggerHandler";
        this.f219931a = "Bear_JsBatchLoggerHandler#".concat(r100);
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r110, m r111) {
        BatchLoggerMessage r112 = (BatchLoggerMessage) r110;
        if (r112 == null) goto L33;
        List<BatchLoggerMessage.LogItem> r113 = r112.getLogMessages();     // Catch: Throwable -> L23
        if (r113 == null) goto L34;
        Iterator<BatchLoggerMessage.LogItem> r114 = r113.iterator();     // Catch: Throwable -> L23
    L7:
        if (r114.hasNext() == false) goto L35;
        BatchLoggerMessage.LogItem r115 = r114.next();     // Catch: Throwable -> L23
        String r100 = null;
        if (r115 == null) goto L12;
        String r101 = r115.getTimeStamp();     // Catch: Throwable -> L23
    L13:
        if (r101 == null) goto L15;
        long r102 = (long) (CastDoubleProtector.parseDouble(r115.getTimeStamp()) * ((double) 1000));     // Catch: Throwable -> L23
    L16:
        long r103 = r102;
        String r104 = this.f219931a;     // Catch: Throwable -> L23
        if (r115 == null) goto L19;
        r100 = r115.getMsg();     // Catch: Throwable -> L23
    L19:
        String r105 = r100;
        long r106 = Process.myTid();     // Catch: Throwable -> L23
        Alog r107 = e.f38378a;     // Catch: Throwable -> L23
        if (r107 == null) goto L7;
        r107.o(2, r104, r105, r106, r103);     // Catch: Throwable -> L23
        goto L7
    L15:
        r102 = System.currentTimeMillis();     // Catch: Throwable -> L23
        goto L16
    L12:
        r101 = null;
        goto L13
    L35:
        return;
    L34:
        return;
    L23:
        th = move-exception;
        tt5.a.f(this.f219931a, th, false);
        return;
    }
}
