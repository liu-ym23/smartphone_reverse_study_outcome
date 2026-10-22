package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui;

import android.view.View;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnClickListener {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        KtvChallengeDataContext.a r4 = KtvChallengeDataContext.Companion;
        if (r4 == null) goto L14;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r0 = r4.a();
        if (r0 == null) goto L15;
        me2.a r1 = r0.getChallengeConfig();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.f != KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue()) goto L17;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r5 = r4.a();
        if (r5 == null) goto L18;
        r5.openGiftDialog();
        return;
    L18:
        return;
    L17:
        return;
    L15:
        return;
    }
}
