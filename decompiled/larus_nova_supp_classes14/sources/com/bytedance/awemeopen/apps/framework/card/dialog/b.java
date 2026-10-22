package com.bytedance.awemeopen.apps.framework.card.dialog;

import android.view.View;
import com.bytedance.awemeopen.apps.framework.utils.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ AosHostCardBottomPanelDialog b;

    public b(View r1, AosHostCardBottomPanelDialog r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (y.a(this.a) == false) goto L5;
        return;
    L5:
        AosHostCardBottomPanelDialog r3 = this.b;
        int r0 = AosHostCardBottomPanelDialog.j;
        r3.getClass();
        this.b.i.b();
        this.b.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        throw null;
    }
}
