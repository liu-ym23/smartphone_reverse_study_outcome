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
public final class b implements h<BatchLoggerMessage> {
    public final String a;

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, DocRedirectToDocxPlugin.FROM);
        this.a = "Bear_JsBatchLoggerHandler";
        this.a = "Bear_JsBatchLoggerHandler#".concat(r2);
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r12, m r13) {
        BatchLoggerMessage r14 = (BatchLoggerMessage) r12;
        if (r14 == null) goto L33;
        List<BatchLoggerMessage.LogItem> r16 = r14.getLogMessages();     // Catch: Throwable -> L23
        if (r16 == null) goto L34;
        Iterator<BatchLoggerMessage.LogItem> r17 = r16.iterator();     // Catch: Throwable -> L23
    L7:
        if (r17.hasNext() == false) goto L35;
        BatchLoggerMessage.LogItem r18 = r17.next();     // Catch: Throwable -> L23
        String r0 = null;
        if (r18 == null) goto L12;
        String r1 = r18.getTimeStamp();     // Catch: Throwable -> L23
    L13:
        if (r1 == null) goto L15;
        long r2 = (long) (CastDoubleProtector.parseDouble(r18.getTimeStamp()) * ((double) UploadResult.UPLOAD_CACELL));     // Catch: Throwable -> L23
    L16:
        long r9 = r2;
        String r5 = this.a;     // Catch: Throwable -> L23
        if (r18 == null) goto L19;
        r0 = r18.getMsg();     // Catch: Throwable -> L23
    L19:
        String r6 = r0;
        long r7 = Process.myTid();     // Catch: Throwable -> L23
        Alog r3 = e.a;     // Catch: Throwable -> L23
        if (r3 == null) goto L7;
        r3.o(2, r5, r6, r7, r9);     // Catch: Throwable -> L23
        goto L7
    L15:
        r2 = System.currentTimeMillis();     // Catch: Throwable -> L23
        goto L16
    L12:
        r1 = null;
        goto L13
    L35:
        return;
    L34:
        return;
    L23:
        th = move-exception;
        tt5.a.f(this.a, th, false);
        return;
    }
}
