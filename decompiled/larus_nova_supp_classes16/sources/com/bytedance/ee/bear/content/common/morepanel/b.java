package com.bytedance.ee.bear.content.common.morepanel;

import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements hw4.d {
    public final /* synthetic */ CommonMorePanelFragment a;

    public b(CommonMorePanelFragment r1) {
        this.a = r1;
    }

    @Override // hw4.d
    public final void a(int r1, CommonMorePanelItemData r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        CommonMorePanelViewModel r3 = this.a.f;
        if (r3 == null) goto L7;
        MutableLiveData<CommonMorePanelItemData> r4 = r3.getSelectData();
        if (r4 == null) goto L7;
        r4.postValue(r2);
    L7:
        a.InterfaceC0035a r5 = this.a.h;
        if (r5 == null) goto L11;
        ((hw4.a) r5).a();
        return;
    }
}
