package com.bytedance.ee.bear.review;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.announcement.n;
import qd5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean b(int r2) {
        if (r2 != 10009) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 10013) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean f(Context r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Toast.showFailureText(r3, r3.getText(2131888173), 0);
        return true;
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean g(Throwable r4) {
        if ((r4 instanceof NetService.ServerErrorException) == false) goto L16;
        int r5 = ((NetService.ServerErrorException) r4).getCode();
        if (r5 != 10009) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
    L14:
        return true;
    L10:
        if (r5 != 10013) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L14;
        return false;
    L12:
        r6 = false;
        goto L13
    L7:
        r0 = false;
        goto L8
    L16:
        return false;
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean h(FragmentActivity r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Toast.showFailureText(r3, r3.getText(2131888172), 0);
        return true;
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean a(Context r3, int r4, Runnable r5) {
        if (r3 != null) goto L7;
        r5.run();
        return false;
    L7:
        if (r4 != 10009) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        int r7 = 2131888174;
    L13:
        Toast.showFailureText(r3, r3.getText(r7), 0);
        return true;
    L12:
        r7 = 2131888171;
        goto L13
    L9:
        r6 = false;
        goto L10
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean c(Context r2, Throwable r3, tg5.b.c r4) {
        if (r2 != null) goto L5;
    L9:
        r4.run();
        return false;
    L5:
        if (g(r3) == false) goto L9;
        Toast.showFailureText(r2, r2.getText(2131888427), 0);
        return true;
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean d(Context r2, Throwable r3, j r4) {
        if (r2 != null) goto L5;
    L9:
        r4.run();
        return false;
    L5:
        if (g(r3) == false) goto L9;
        Toast.showFailureText(r2, r2.getText(2131888173), 0);
        return true;
    }

    @Override // com.bytedance.ee.bear.review.a
    public final boolean e(Context r2, Throwable r3, n r4) {
        if (r2 != null) goto L5;
    L9:
        r4.run();
        return false;
    L5:
        if (g(r3) == false) goto L9;
        Toast.showFailureText(r2, r2.getText(2131888172), 0);
        return true;
    }
}
