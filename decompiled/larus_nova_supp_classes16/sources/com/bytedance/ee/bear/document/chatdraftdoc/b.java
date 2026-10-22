package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.DocumentMeta;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements k05.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ Activity c;

    @Override // k05.a
    public final void a(CreateResponse r5) {
        i r0 = h.a;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        if (r5 == null) goto L9;
        DocumentMeta r1 = r5.getMeta();
        if (r1 == null) goto L9;
        String r2 = r1.getUrl();
    L10:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        StringBuilder r3 = new StringBuilder("create draft doc done. chatId: ");
        r3.append(this.a);
        r3.append(", url: ");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Any");
        r3.append(du5.b.f(r2));
        tt5.a.h("ChatDraftDocManager", r3.toString());
        Toast.cancelLoading();
        boolean r4 = false;
        if (r2.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L18;
        String r7 = this.a;
        com.bytedance.ee.util.ui.j.f(new d(this.b));
        com.bytedance.ee.util.ui.j.d(new e(r7, r2), 250);
        return;
    L18:
        if (r5 != null) goto L20;
    L22:
        if (r4 == true) goto L26;
        Toast.showFailureText(this.c, 2131888930);
        return;
    L26:
        return;
    L20:
        if (r5.getFullQuote() != true) goto L22;
        r4 = true;
        goto L22
    L15:
        r6 = false;
    L9:
        r2 = null;
        goto L10
    }

    public b(String r1, Function0<Unit> r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
