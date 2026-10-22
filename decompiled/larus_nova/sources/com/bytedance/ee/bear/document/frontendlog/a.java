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
public final class a implements h<BatchLoggerMessage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f219930a;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f219930a = "Bear_JsBatchLoggerHandler";
        this.f219930a = "Bear_JsBatchLoggerHandler#".concat(r100);
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r110, m r111) {
        BatchLoggerMessage r112 = (BatchLoggerMessage) r110;
        String r100 = this.f219930a;     // Catch: Throwable -> L31
        StringBuilder r101 = new StringBuilder("handle logMessages size: ");     // Catch: Throwable -> L31
        if (r112 == null) goto L8;
        List<BatchLoggerMessage.LogItem> r102 = r112.getLogMessages();     // Catch: Throwable -> L31
        if (r102 == null) goto L8;
        Integer r103 = Integer.valueOf(r102.size());     // Catch: Throwable -> L31
    L9:
        r101.append(r103);     // Catch: Throwable -> L31
        tt5.a.h(r100, r101.toString());     // Catch: Throwable -> L31
        if (r112 == null) goto L41;
        List<BatchLoggerMessage.LogItem> r113 = r112.getLogMessages();     // Catch: Throwable -> L31
        if (r113 == null) goto L42;
        Iterator<BatchLoggerMessage.LogItem> r114 = r113.iterator();     // Catch: Throwable -> L31
    L14:
        if (r114.hasNext() == false) goto L43;
        BatchLoggerMessage.LogItem r104 = r114.next();     // Catch: Throwable -> L31
        if (r104 == null) goto L19;
        String r105 = r104.getTimeStamp();     // Catch: Throwable -> L31
    L20:
        if (r105 == null) goto L22;
        long r106 = (long) (CastDoubleProtector.parseDouble(r104.getTimeStamp()) * ((double) 1000));     // Catch: Throwable -> L31
    L23:
        long r107 = r106;
        String r108 = this.f219930a;     // Catch: Throwable -> L31
        if (r104 == null) goto L26;
        String r109 = r104.getMsg();     // Catch: Throwable -> L31
    L27:
        long r115 = Process.myTid();     // Catch: Throwable -> L31
        Alog r116 = e.f38378a;     // Catch: Throwable -> L31
        if (r116 == null) goto L14;
        r116.o(2, r108, r109, r115, r107);     // Catch: Throwable -> L31
        goto L14
    L26:
        r109 = null;
        goto L27
    L22:
        r106 = System.currentTimeMillis();     // Catch: Throwable -> L31
        goto L23
    L19:
        r105 = null;
        goto L20
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L8:
        r103 = null;
    L31:
        th = move-exception;
        tt5.a.f(this.f219930a, th, false);
    }
}
