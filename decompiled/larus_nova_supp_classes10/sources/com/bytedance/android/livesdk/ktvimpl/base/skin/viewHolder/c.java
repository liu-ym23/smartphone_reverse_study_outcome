package com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder;

import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ KtvHonorTagViewBinder.KtvHonorTagViewHolder a;
    public final /* synthetic */ MicPosTagInfo b;

    public c(KtvHonorTagViewBinder.KtvHonorTagViewHolder r1, MicPosTagInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvHonorTagViewBinder.KtvHonorTagViewHolder r0 = this.a;     // Catch: Throwable -> L7
        int r1 = KtvHonorTagViewBinder.KtvHonorTagViewHolder.f;     // Catch: Throwable -> L7
        TextView r2 = (TextView) r0.b.getValue();     // Catch: Throwable -> L7
        k r3 = this.b.getBgColorImg();     // Catch: Throwable -> L7
        if ((r3 instanceof k) == true) goto L5;
        r3 = null;
    L5:
        KtvUtilsKt.i(r2, r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
