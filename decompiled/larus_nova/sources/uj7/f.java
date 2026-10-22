package uj7;

import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.manager.a0;
import com.bytedance.ug.sdk.luckycat.impl.manager.z;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements View.OnClickListener {
    public f() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a0 r101 = a0.a.f271304a;
        if (r101.f271303b == false) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - r101.f271302a) < 60000) goto L11;
        r101.f271302a = System.currentTimeMillis();
        r101.f271303b = true;
        rj7.c.a(new qj7.d(new z(r101)));
        return;
    }
}
