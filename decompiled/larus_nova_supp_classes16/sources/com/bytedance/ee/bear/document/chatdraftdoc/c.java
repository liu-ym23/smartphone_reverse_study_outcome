package com.bytedance.ee.bear.document.chatdraftdoc;

import android.app.Activity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements k05.b {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // k05.b
    public final void a(int r3) {
        l r0 = h.c;
        if (r0 == null) goto L5;
        r0.a.clear();
    L5:
        tt5.a.h("ChatDraftDocManager", "delete draft doc done. code: " + r3);
        if (r3 != 0) goto L8;
        h.a(this.a, this.b, this.c);
        return;
    L8:
        Toast.cancelLoading();
        Toast.showFailureText(this.a, 2131888930);
    }

    public c(Activity r1, String r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
