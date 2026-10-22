package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvGroupViewModel;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvGroupJoinDialogFragment$accessOnClicklistener$1 implements View.OnClickListener {
    public final /* synthetic */ KtvGroupJoinDialogFragment a;

    public KtvGroupJoinDialogFragment$accessOnClicklistener$1(KtvGroupJoinDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r5 = KtvRoomContext.a.a();
        if (r5 == null) goto L7;
        j<KtvGroupViewModel> r6 = r5.getKtvGroupViewModel();
        if (r6 == null) goto L7;
        KtvGroupViewModel r7 = (KtvGroupViewModel) r6.getValue();
    L8:
        if (r7 == null) goto L11;
        r7.joinGroup(KtvGroupJoinDialogFragment.l, KtvGroupJoinDialogFragment.m, new AnonymousClass1(this));
        return;
    L11:
        return;
    L7:
        r7 = null;
        goto L8
    }
}
