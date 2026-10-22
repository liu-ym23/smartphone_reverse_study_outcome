package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.setting;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ KtvChallengeSettingViewBinder.KtvChallengeSettingHolder a;
    public final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a b;

    public b(KtvChallengeSettingViewBinder.KtvChallengeSettingHolder r1, com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Object r0 = ((RecyclerView.ViewHolder) this.a).itemView.getParent();
        if ((r0 instanceof View) == true) goto L5;
        r0 = null;
    L5:
        View r1 = (View) r0;
        if (r1 == null) goto L13;
        int r2 = r1.getWidth();
        if (this.b.c != 1) goto L10;
        int r3 = 3;
    L11:
        int r4 = ((r2 - (UtilityKotlinExtentionsKt.i(8) * (r3 - 1))) - (UtilityKotlinExtentionsKt.i(4) * 2)) / r3;
        ViewGroup.LayoutParams r5 = ((RecyclerView.ViewHolder) this.a).itemView.getLayoutParams();
        r5.width = r4;
        ((RecyclerView.ViewHolder) this.a).itemView.setLayoutParams(r5);
        return;
    L10:
        r3 = 4;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
