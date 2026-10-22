package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import java.util.HashMap;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o4 extends com.bytedance.ee.bear.contract.c {
    public final /* synthetic */ p4 b;

    public o4(p4 r1) {
        this.b = r1;
    }

    @Override // com.bytedance.ee.bear.contract.c
    public final void b(AccountService$Account r5) {
        if (r5 != null) goto L5;
    L28:
        tt5.a.h("EditorInit", "  account == null, return " + r5);
        return;
    L5:
        if (r5.hasLogin() == false) goto L28;
        String r6 = r5.uid;
        tt5.a.h("EditorInit", "currentUid = " + r6 + ", mLatestUid = " + this.b.a);
        if (TextUtils.equals(this.b.a, r6) == false) goto L11;
        tt5.a.h("EditorInit", "same uid , return");
        return;
    L11:
        l35.k r1 = l35.k.a.a;
        if (this.b.a == null) goto L15;
        w35.h.a();
    L15:
        if (com.bytedance.ee.bear.document.forecast.a.e() == false) goto L25;
        s1.E = false;
        if (TextUtils.isEmpty(this.b.a) == false) goto L19;
    L21:
        MonitorModule.e().getClass();
        if (DevicePerfManager.b.a.e.h == false) goto L24;
        CpuCallbackManager.a().b(new h4());
    L26:
        this.b.a = r6;
        iu5.f.a(new k4());
        String r7 = (String) com.bytedance.ee.bear.appsetting.c.a.a.d("token_pattern", "((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
        SecretKey r0 = du5.b.a;
        tt5.a.h("EncriptUtils", "inject token pattern");
        du5.b.c = PatternProtector.compile(r7);
        return;
    L24:
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).b().subscribe(new i4(), new j4());
        goto L26
    L19:
        if (l35.k.b != 0) goto L21;
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).c(false).subscribe(new f4(), new g4());
        goto L26
    L25:
        tt5.a.h("EditorInit", "document forecast, interrupt webview preload");
        s1.E = true;
        com.bytedance.ee.bear.contract.d r2 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap r3 = new HashMap();
        r3.put("interrupt_type", "webview");
        r2.n("docs_dev_performance_doc_forecast", r3);
        goto L26
    }
}
