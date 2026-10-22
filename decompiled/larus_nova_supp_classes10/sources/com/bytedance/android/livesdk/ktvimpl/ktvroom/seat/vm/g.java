package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.DragLinearLayout;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvInteractElementWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ KtvRoomViewManager a;

    public g(KtvRoomViewManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvRoomViewManager r0 = this.a;     // Catch: Throwable -> L15
        KtvInteractElementWidget r1 = r0.N;     // Catch: Throwable -> L15
        if (r1 == null) goto L18;
        int r2 = r0.W;     // Catch: Throwable -> L15
        RecyclerView r3 = r0.s;     // Catch: Throwable -> L15
        if (r3 == null) goto L7;
        int r4 = r3.getHeight();     // Catch: Throwable -> L15
    L8:
        int r5 = r2 - r4;     // Catch: Throwable -> L15
        View r6 = ((Widget) r1).contentView;     // Catch: Throwable -> L15
        if (r6 == null) goto L11;
        DragLinearLayout r7 = (DragLinearLayout) r6.findViewById(2131375508);     // Catch: Throwable -> L15
    L12:
        if (r7 == null) goto L22;
        r7.setBottomEdget(r5);     // Catch: Throwable -> L15
        return;
    L22:
        return;
    L11:
        r7 = null;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L18:
        return;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    }
}
