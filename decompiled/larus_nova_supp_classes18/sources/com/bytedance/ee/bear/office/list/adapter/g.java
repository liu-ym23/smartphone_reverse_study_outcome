package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Runnable {
    public final /* synthetic */ OfficeDocumentAdapter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;

    public g(OfficeDocumentAdapter r1, String r2, int r3, int r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        OfficeDocumentAdapter r0 = this.a;
        int r1 = OfficeDocumentAdapter.C;
        r0.getClass();
        List<Document> r2 = this.a.i;
        String r3 = this.b;
        int r4 = this.c;
        int r5 = this.d;
        String r6 = this.e;
        Iterator r7 = ((ArrayList) r2).iterator();
        int r8 = 0;
    L4:
        if (r7.hasNext() == false) goto L21;
        Document r9 = (Document) r7.next();
        if (Intrinsics.areEqual(r9.d, r3) == true) goto L8;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == true) goto L22;
        r8 = r8 + 1;
    L22:
        if (r8 < 0) goto L27;
        this.a.notifyItemChanged(r8, "payload_thumbnail");
        return;
    L27:
        return;
    L8:
        if (r9.getType() != r4) goto L17;
        if (r9.M1 != r5) goto L17;
        String r11 = r9.p;
        if (r11 != null) goto L15;
        r11 = "";
    L15:
        if (Intrinsics.areEqual(r11, r6) == false) goto L17;
        r10 = true;
        goto L18
    L21:
        r8 = -1;
        goto L22
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
