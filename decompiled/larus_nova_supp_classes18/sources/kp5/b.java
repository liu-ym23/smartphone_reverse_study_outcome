package kp5;

import android.view.View;
import com.bytedance.ee.bear.widgets.popupmenu.PopupMenuView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ PopupMenuView a;

    public b(PopupMenuView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        PopupMenuView.a(this.a);
    }
}
