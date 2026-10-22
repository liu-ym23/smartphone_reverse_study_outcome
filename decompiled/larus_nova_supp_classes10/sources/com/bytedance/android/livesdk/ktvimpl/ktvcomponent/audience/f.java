package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ KtvComponentAudienceLogicWidget a;

    public f(KtvComponentAudienceLogicWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L6;
    L16:
        ((Widget) this.a).dataCenter.put("cmd_current_user_multi_chorus_role_change", Boolean.TRUE);
        return;
    L6:
        if (r4.intValue() != 2) goto L16;
        KtvComponentContext r5 = this.a.f;
        if (r5 == null) goto L16;
        n<KtvComponentUIContext> r6 = r5.getKtvComponentUIContext();
        if (r6 == null) goto L16;
        KtvComponentUIContext r7 = (KtvComponentUIContext) r6.getValue();
        if (r7 == null) goto L16;
        MutableLiveData<Boolean> r8 = r7.getSingerScoreOpen();
        if (r8 == null) goto L16;
        r8.setValue(Boolean.FALSE);
        goto L16
    }
}
