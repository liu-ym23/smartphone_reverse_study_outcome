package com.bytedance.ee.bear.content.common.morepanel;

import android.view.View;
import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonMorePanelFragment f216798a;

    public d(CommonMorePanelFragment r100) {
        this.f216798a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommonMorePanelViewModel r101 = this.f216798a.f216777f;
        if (r101 == null) goto L7;
        MutableLiveData<Boolean> r102 = r101.getTriggerResetData();
        if (r102 == null) goto L7;
        r102.postValue(Boolean.TRUE);
    L7:
        a.InterfaceC3091a r103 = this.f216798a.f216779h;
        if (r103 == null) goto L11;
        ((hw4.a) r103).a();
        return;
    }
}
