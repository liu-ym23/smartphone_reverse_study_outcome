package p20;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f527359a;

    public b(ViewGroup r100) {
        this.f527359a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.f527359a.removeView(r100);
        return true;
    }
}
