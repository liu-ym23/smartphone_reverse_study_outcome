package yd5;

import android.view.View;
import com.bytedance.ee.bear.list.sidebar.tab.SidebarHomeSubMenuView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ SidebarHomeSubMenuView a;

    public a(SidebarHomeSubMenuView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.c;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }
}
