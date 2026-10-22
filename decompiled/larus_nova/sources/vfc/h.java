package vfc;

import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LKUIDialog f554647a;

    public h(LKUIDialog r100) {
        this.f554647a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f554647a.cancel();
    }
}
