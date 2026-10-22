package com.bytedance.ee.bear.document.frontendlog;

import android.os.Process;
import com.bytedance.android.alog.Alog;
import com.bytedance.android.alog.e;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tb5.h;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements h<BatchLoggerMessage> {
    public final String a;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, DocRedirectToDocxPlugin.FROM);
        this.a = "Bear_JsBatchLoggerHandler";
        this.a = "Bear_JsBatchLoggerHandler#".concat(r2);
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r12, m r13) {
        BatchLoggerMessage r14 = (BatchLoggerMessage) r12;
        String r0 = this.a;     // Catch: Throwable -> L31
        StringBuilder r1 = new StringBuilder("handle logMessages size: ");     // Catch: Throwable -> L31
        if (r14 == null) goto L8;
        List<BatchLoggerMessage.LogItem> r2 = r14.getLogMessages();     // Catch: Throwable -> L31
        if (r2 == null) goto L8;
        Integer r3 = Integer.valueOf(r2.size());     // Catch: Throwable -> L31
    L9:
        r1.append(r3);     // Catch: Throwable -> L31
        tt5.a.h(r0, r1.toString());     // Catch: Throwable -> L31
        if (r14 == null) goto L41;
        List<BatchLoggerMessage.LogItem> r16 = r14.getLogMessages();     // Catch: Throwable -> L31
        if (r16 == null) goto L42;
        Iterator<BatchLoggerMessage.LogItem> r17 = r16.iterator();     // Catch: Throwable -> L31
    L14:
        if (r17.hasNext() == false) goto L43;
        BatchLoggerMessage.LogItem r4 = r17.next();     // Catch: Throwable -> L31
        if (r4 == null) goto L19;
        String r5 = r4.getTimeStamp();     // Catch: Throwable -> L31
    L20:
        if (r5 == null) goto L22;
        long r6 = (long) (CastDoubleProtector.parseDouble(r4.getTimeStamp()) * ((double) UploadResult.UPLOAD_CACELL));     // Catch: Throwable -> L31
    L23:
        long r9 = r6;
        String r7 = this.a;     // Catch: Throwable -> L31
        if (r4 == null) goto L26;
        String r8 = r4.getMsg();     // Catch: Throwable -> L31
    L27:
        long r10 = Process.myTid();     // Catch: Throwable -> L31
        Alog r11 = e.a;     // Catch: Throwable -> L31
        if (r11 == null) goto L14;
        r11.o(2, r7, r8, r10, r9);     // Catch: Throwable -> L31
        goto L14
    L26:
        r8 = null;
        goto L27
    L22:
        r6 = System.currentTimeMillis();     // Catch: Throwable -> L31
        goto L23
    L19:
        r5 = null;
        goto L20
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L8:
        r3 = null;
    L31:
        th = move-exception;
        tt5.a.f(this.a, th, false);
    }
}
