package com.bytedance.ee.bear.list.sidebar.navigation;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ SidebarNavigationAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ b c;

    public a(SidebarNavigationAdapter r1, int r2, b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        SidebarNavigationAdapter r4 = this.a;
        if (r4.c == false) goto L7;
        int r0 = this.b;
        if (r0 == (-1)) goto L7;
        int r1 = r4.d;
        r4.d = r0;
        r4.notifyItemChanged(r0);
        this.a.notifyItemChanged(r1);
    L7:
        Function1<? super b, Unit> r5 = this.a.a;
        if (r5 == null) goto L11;
        r5.invoke(this.c);
        return;
    }
}
