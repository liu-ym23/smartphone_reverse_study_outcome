package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentAtView a;
    public final /* synthetic */ BitableSuperAgentAtView.d.c b;

    public b(BitableSuperAgentAtView r1, BitableSuperAgentAtView.d.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BitableSuperAgentAtView r5 = this.a;
        BitableSuperAgentAtViewModel.Section r0 = this.b.a;
        int r1 = BitableSuperAgentAtView.h;
        r5.getClass();
        tt5.a.h("BitableSuperAgentAtView", "onMoreClick: section=" + r0);
        BitableSuperAgentAtViewModel r6 = r5.b;
        if (r6 == null) goto L14;
        Intrinsics.checkNotNullParameter(r0, "section");
        MutableLiveData<BitableSuperAgentAtViewModel.ViewMode> r7 = r6.o;
        int r2 = BitableSuperAgentAtViewModel.c.a[r0.ordinal()];
        if (r2 != 1) goto L7;
        BitableSuperAgentAtViewModel.ViewMode r3 = BitableSuperAgentAtViewModel.ViewMode.USERS_ONLY;
    L12:
        r7.setValue(r3);
        return;
    L7:
        if (r2 != 2) goto L10;
        r3 = BitableSuperAgentAtViewModel.ViewMode.TABLES_ONLY;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
