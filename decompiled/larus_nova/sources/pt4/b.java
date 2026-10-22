package pt4;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f530647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f530648b;

    public b(gv4.a r100, SimpleItemModel r101) {
        this.f530647a = r100;
        this.f530648b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f530647a.a(new Action(this.f530648b.getId(), this.f530648b.getClickAction()));
    }
}
