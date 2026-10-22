package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.os.Build;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ BitableDefaultMemberAdapter a;

    public b(BitableDefaultMemberAdapter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        BitableDefaultMemberAdapter r0 = this.a;
        Intrinsics.checkNotNull(r5);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        int r6 = BitableDefaultMemberAdapter.b;
        r0.getClass();
    L8:
        return true;
    L5:
        if (r0.a != null) goto L8;
        r0.a = r5.startActionMode(new a(r0), 1);
        goto L8
    }
}
