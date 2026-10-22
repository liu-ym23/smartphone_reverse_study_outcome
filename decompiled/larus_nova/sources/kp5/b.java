package kp5;

import android.view.View;
import com.bytedance.ee.bear.widgets.popupmenu.PopupMenuView;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupMenuView f505511a;

    public b(PopupMenuView r100) {
        this.f505511a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PopupMenuView.a(this.f505511a);
    }
}
