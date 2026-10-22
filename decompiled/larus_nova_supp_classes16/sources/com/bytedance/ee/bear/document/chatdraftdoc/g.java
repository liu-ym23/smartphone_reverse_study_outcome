package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0<Unit> c;

    public g(Activity r1, String r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        i r7 = h.a;
        Activity r8 = this.a;
        String r9 = this.b;
        Function0<Unit> r0 = this.c;
        Toast.showLoading(r8, r8.getText(2131888929));
        NetService r1 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        l r2 = h.c;
        if (r2 != null) goto L5;
        r2 = new l();
        h.c = r2;
    L5:
        r2.a(r1, r9, new c(r8, r9, r0));
    }
}
