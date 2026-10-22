package ys4;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f568989a = null;

    static {
        f568989a = new b();
    }

    public b() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intent r101 = new Intent();
        r101.setClassName(r100.getContext(), "com.bytedance.ee.android.debugger.mockfg.widget.MockFGActivity");
        r101.setFlags(268435456);
        r100.getContext().startActivity(r101);
    }
}
