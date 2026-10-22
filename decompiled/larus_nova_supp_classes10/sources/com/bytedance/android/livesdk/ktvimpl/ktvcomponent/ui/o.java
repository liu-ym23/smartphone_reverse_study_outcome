package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentMidiViewModel;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public o(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        boolean r1 = false;
        if (KtvSettingHelper.f() == false) goto L13;
        KtvComponentUIWidget r0 = this.a;
        TokenCert r2 = KtvComponentUIWidget.y1;
        r0.getClass();
        if (KtvComponentUIWidget.Iq() == true) goto L21;
        if (r5 == null) goto L8;
        r1 = r5.booleanValue();
    L8:
        if (r1 == false) goto L12;
        LifecycleOwner r6 = this.a;
        KtvComponentMidiViewModel r3 = r6.N;
        if (r3 == null) goto L12;
        r3.attach(r6);
    L12:
        KtvComponentUIWidget.zq(this.a, r1);
        return;
    L21:
        return;
    L13:
        if (r5 == null) goto L15;
        r1 = r5.booleanValue();
    L15:
        if (r1 == false) goto L19;
        LifecycleOwner r7 = this.a;
        KtvComponentMidiViewModel r8 = r7.N;
        if (r8 == null) goto L19;
        r8.attach(r7);
    L19:
        KtvComponentUIWidget.zq(this.a, r1);
    }
}
