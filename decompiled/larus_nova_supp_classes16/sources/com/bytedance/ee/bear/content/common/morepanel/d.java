package com.bytedance.ee.bear.content.common.morepanel;

import android.view.View;
import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ CommonMorePanelFragment a;

    public d(CommonMorePanelFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        CommonMorePanelViewModel r3 = this.a.f;
        if (r3 == null) goto L7;
        MutableLiveData<Boolean> r4 = r3.getTriggerResetData();
        if (r4 == null) goto L7;
        r4.postValue(Boolean.TRUE);
    L7:
        a.InterfaceC0035a r5 = this.a.h;
        if (r5 == null) goto L11;
        ((hw4.a) r5).a();
        return;
    }
}
