package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ApplyAuditEscapePanel a;

    public e(ApplyAuditEscapePanel r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        NetService.HttpErrorException r4 = (Throwable) r3;
        tt5.a.d("ApplyAuditEscapePanel", "sendRequest error");
        Toast.cancelLoading();
        Context r0 = this.a.requireContext();
        Intrinsics.checkNotNull(r4);
        String r1 = this.a.j;
        int r2 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r4, "e");
        if ((r4 instanceof NetService.HttpErrorException) == true) goto L5;
    L7:
        String r5 = r0.getString(2131887828);
    L8:
        Toast.showFailureText(r0, r5);
        return;
    L5:
        if (r4.getCode() != 429) goto L7;
        r5 = r0.getString(2131888430);
        goto L8
    }
}
