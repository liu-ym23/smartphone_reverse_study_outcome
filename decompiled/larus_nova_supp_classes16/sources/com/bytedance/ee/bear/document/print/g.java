package com.bytedance.ee.bear.document.print;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiStyle;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ PrintExportCoordinator a;
    public final /* synthetic */ long b;
    public final /* synthetic */ oj5.c c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Throwable f;

    public g(PrintExportCoordinator r1, long r2, oj5.c r4, String r5, int r6, Throwable r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public final void a() {
        PrintExportCoordinator r0 = this.a;
        long r1 = this.b;
        int r3 = PrintExportCoordinator.l;
        if (r0.k(r1) == true) goto L5;
        return;
    L5:
        boolean r4 = false;
        this.a.f(this.b, false);
        PrintExportCoordinator r2 = this.a;
        oj5.c r5 = this.c;
        String r6 = this.d;
        int r7 = this.e;
        Throwable r8 = this.f;
        r2.getClass();
        boolean r9 = r8 instanceof NetService.ServerErrorException;
        int r10 = 2131889218;
        if (r9 == false) goto L8;
        r7 = ((NetService.ServerErrorException) r8).getCode();
    L10:
        if (r7 != 900099001) goto L12;
    L17:
        boolean r11 = true;
    L18:
        if (r11 == false) goto L43;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L43;
        if (r2.j() == false) goto L43;
        if (r9 == false) goto L27;
        NetService.ServerErrorException r12 = (NetService.ServerErrorException) r8;
    L63:
        ErrorResponse r13 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).e(r6, Integer.valueOf(r5.getType()), "EXPORT", r12);     // Catch: Throwable -> L41
        if (r7 == 900099003) goto L33;
        if (r7 == 900099004) goto L33;
        boolean r14 = false;
    L34:
        if (r14 == false) goto L37;
        r13.setUiStyle(new UiStyle(r2.a.getString(2131889218)));     // Catch: Throwable -> L41
        r13.setHasHandledUiAction(true);     // Catch: Throwable -> L41
    L37:
        if (r13.getHasHandledUiAction() == false) goto L43;
        r13.getCallback().a(r2.a, r13);     // Catch: Throwable -> L41
        r4 = true;
    L33:
        r14 = true;
    L41:
        th = move-exception;
        tt5.a.d("PrintExportCoordinator", "handle print permission failure failed: ".concat(th.getClass().getSimpleName()));
        goto L43
    L27:
        r12 = new NetService.ServerErrorException(r7, "", "", "");
    L43:
        if (r4 == true) goto L65;
        PrintExportCoordinator r16 = this.a;
        int r17 = this.e;
        r16.getClass();
        if (r17 != 110) goto L47;
    L58:
        r10 = 2131889211;
    L60:
        if (r16.j() == false) goto L66;
        Toast.showFailureText(r16.a, r10);
        return;
    L66:
        return;
    L47:
        if (r17 != 111) goto L49;
    L57:
        r10 = 2131889206;
        goto L60
    L49:
        if (r17 == 123) goto L57;
        if (r17 == 1002) goto L58;
        if (r17 == 1006) goto L57;
        if (r17 == 900099011) goto L60;
        r10 = 2131889210;
        goto L60
    L65:
        return;
    L12:
        if (r7 == 900099002) goto L17;
        if (r7 == 900099003) goto L17;
        if (r7 == 900099004) goto L17;
        r11 = false;
        goto L18
    L8:
        if (r7 <= 0) goto L43;
        goto L43
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
