package pt4;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f530645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f530646b;

    public a(gv4.a r100, SimpleItemModel r101) {
        this.f530645a = r100;
        this.f530646b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f530645a;
        SimpleItemModel r102 = this.f530646b;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getId();
    L6:
        SimpleItemModel r105 = this.f530646b;
        if (r105 == null) goto L9;
        r103 = r105.getClickAction();
    L9:
        r101.a(new Action(r104, r103));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
