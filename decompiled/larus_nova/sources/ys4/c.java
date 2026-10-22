package ys4;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f568990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f568991b;

    public c(gv4.a r100, SimpleItemModel r101) {
        this.f568990a = r100;
        this.f568991b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f568990a;
        if (r101 == null) goto L6;
        r101.a(new Action(this.f568991b.getId(), this.f568991b.getClickAction()));
        return;
    }
}
