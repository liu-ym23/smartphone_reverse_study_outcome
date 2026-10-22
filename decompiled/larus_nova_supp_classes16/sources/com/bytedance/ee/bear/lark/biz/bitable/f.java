package com.bytedance.ee.bear.lark.biz.bitable;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.m;
import com.bytedance.ee.bear.list.create.q0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ BitableTabFragment a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ boolean c;

    public f(BitableTabFragment r1, Context r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r9) {
        Throwable r10 = (Throwable) r9;
        Intrinsics.checkNotNullParameter(r10, "throwable");
        tt5.a.d("BitableTabFragment", "createBlankDocument createOnlineDocument()...failed, throwable = " + r10);
        BitableTabFragment r0 = this.a;
        Context r1 = this.b;
        boolean r2 = this.c;
        int r3 = BitableTabFragment.P;
        r0.getClass();
        int r4 = sbb.e.i.b;
        Toast.cancelLoading();
        m r5 = new m("", "lark_workspace_bitable_landing", "docs_manage", false);
        String r6 = r1.getString(2131887996);
        String r7 = sbb.e.c(r4);
        if (r2 == false) goto L5;
        q0.f(r1, r10);
        return;
    L5:
        q0.d(new com.bytedance.ee.bear.list.create.b(r1, r5, r7), r10, r6);
    }
}
