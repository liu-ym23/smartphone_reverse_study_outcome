package uj7;

import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.manager.b0;
import com.bytedance.ug.sdk.luckycat.impl.manager.c0;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements View.OnClickListener {
    public e() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c0 r101 = c0.a.f271312a;
        if (r101.f271311b == false) goto L6;
        return;
    L6:
        if (System.currentTimeMillis() < (r101.f271310a * 1000)) goto L11;
        r101.f271311b = true;
        rj7.c.a(new qj7.e(new b0(r101)));
        return;
    }
}
