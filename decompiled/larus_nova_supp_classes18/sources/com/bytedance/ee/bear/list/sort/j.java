package com.bytedance.ee.bear.list.sort;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.t;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends t {
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ q e;
    public final /* synthetic */ SortTypeAdapter f;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        if (this.c == false) goto L6;
        Context r5 = this.f.a;
        Toast.showFailureText(r5, r5.getString(2131889467), 0);
        return;
    L6:
        SortTypeAdapter r6 = this.f;
        if (r6.e == true) goto L9;
    L12:
        r6.c = this.d;
        SortTypeAdapter.a r7 = r6.f;
        if (r7 == null) goto L15;
        q r0 = this.e;
        h r8 = ((zd5.m) r7).a;
        r8.s();
        FilterTypeAdapter r9 = r8.p;
        r9.d = r0;
        r9.notifyDataSetChanged();
    L15:
        this.f.notifyDataSetChanged();
        return;
    L9:
        if (r6.c != this.d) goto L11;
        q r1 = this.e;
        r1.c = !r1.c;
        goto L12
    L11:
        this.e.c = false;
        goto L12
    }

    public j(SortTypeAdapter r1, boolean r2, int r3, q r4) {
        this.f = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
