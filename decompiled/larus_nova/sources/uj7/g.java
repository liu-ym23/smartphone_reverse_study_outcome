package uj7;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements View.OnClickListener {
    public g() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ug.sdk.luckycat.impl.manager.q r101 = com.bytedance.ug.sdk.luckycat.impl.manager.q.b.f271365a;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r102 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        r102.m();
        if (TextUtils.isEmpty("#AAA345#") == true) goto L10;
        com.bytedance.ug.sdk.luckycat.impl.manager.l.b.f271332a.getClass();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("FissionManager", "check invite with clipdata");
        if (TextUtils.isEmpty("#AAA345#") == true) goto L11;
        r102.n();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("FissionManager", "is enable fission : false");
        return;
    L11:
        return;
    }
}
