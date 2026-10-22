package q20;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r20.a f531332a;

    public b(r20.a r100) {
        this.f531332a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        new AlertDialog.Builder(r100.getContext()).setTitle("详情").setMessage(this.f531332a.f535711c.toString()).show();
    }
}
