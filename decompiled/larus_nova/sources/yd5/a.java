package yd5;

import android.view.View;
import com.bytedance.ee.bear.list.sidebar.tab.SidebarHomeSubMenuView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarHomeSubMenuView f567305a;

    public a(SidebarHomeSubMenuView r100) {
        this.f567305a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f567305a.f229626c;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
